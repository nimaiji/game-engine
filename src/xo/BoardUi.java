package xo;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by nima on 1/23/2019 AD.
 */
public class BoardUi extends GridPane {

    private final static int CELL_SIZE = 100;
    int row, column;
    ObservableList list;
    MenuUi menuUi = new MenuUi();

    BoardUi(int row, int column) {
        super();
        this.list = this.getChildren();
        this.row = row;
        this.column = column;
        this.setPadding(new Insets(10));
        this.setHgap(0);
        this.setVgap(0);

        //partion board
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Rectangle rectangle = new Rectangle(CELL_SIZE, CELL_SIZE);
                rectangle.setFill(Color.GRAY);
                rectangle.setStroke(Color.WHITE);
                this.add(rectangle, i, j);
            }
        }

    }

    public MenuUi addMenu(){
        list.add(this.menuUi);
        Log.d("Menu Added to BoardUi","");
        return this.menuUi;
    }


}
