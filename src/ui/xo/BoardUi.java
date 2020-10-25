package ui.xo;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Created by nima on 1/23/2019 AD.
 */
public class BoardUi extends GridPane {

    private final static int CELL_SIZE = 60;
    int row, column;
    int turn;
    Label title;

    BoardUi(int row, int column, UiConnection uiConnection, Label lbl) {
        super();
        turn = 1;
        title = lbl;
        //this.list = this.getChildren();
        this.setAlignment(Pos.CENTER);
        this.row = row;
        this.column = column;
        this.setPadding(new Insets(10));
        this.setHgap(0);
        this.setVgap(0);

        //partion board
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Rectangle rectangle = new Rectangle(CELL_SIZE, CELL_SIZE);
                rectangle.setFill(Color.web(Utils.MAIN_THEME.equals(Utils.LIGHT_THEME) ? Utils.RECTANGLE_COLOR_L : Utils.RECTANGLE_COLOR_D));
                rectangle.setStroke(Color.TRANSPARENT);
                final int ii = i;
                final int jj = j;
                rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        //Todo:move
                        if (uiConnection.move(ii, (jj + 5) % 5) == 1) {

                            addPlayer(ii, jj);
                            if (turn == 1) {
                                turn = 2;
                                title.setText(Utils.PLAYER_NAME_1 + "'s Trun");
                                Log.d("Engine", Utils.PLAYER_NAME_2 + " Moved to " + ii + ":" + (jj + 5) % 5);
                            } else {
                                turn = 1;
                                title.setText(Utils.PLAYER_NAME_2 + "'s Trun");
                                Log.d("Engine", Utils.PLAYER_NAME_1 + " Moved to " + ii + ":" + (jj + 5) % 5);
                            }
                            if (uiConnection.isOver() == 1) {
                                Log.d("Engine", uiConnection.end() + "");
                                title.setText(uiConnection.end() + " Won!");
                                //Platform.exit();
                            }
                        } else {
                            Log.d("Engine", "Wrong Move");
                            title.setText("Wrong Move!");
                        }
                    }
                });
                this.add(rectangle, i, j);
            }
        }

    }

    public void addPlayer(int i, int j) {
        Circle circle = new Circle();
        circle.setStrokeWidth(50);
        circle.setTranslateX(5);
        if (turn == 1)
            circle.setStroke(Color.web(Utils.MAIN_THEME.equals(Utils.LIGHT_THEME) ? Utils.CIRCLE_BLUE_L : Utils.CIRCLE_BLUE_D));
        else
            circle.setStroke(Color.web(Utils.MAIN_THEME.equals(Utils.LIGHT_THEME) ? Utils.CIRCLE_RED_L : Utils.CIRCLE_RED_D));
        this.add(circle, i, j);
    }


}
