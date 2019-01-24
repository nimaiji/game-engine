package xo;


import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class MenuUi extends VBox {

    private double SPACE_SIZE = 10;
    ObservableList list;
    private Button main_menu_btn = new Button("Main Menu");

    MenuUi() {
        list = this.getChildren();
        this.setSpacing(SPACE_SIZE);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(Utils.M_P_SIZE));
        Log.d("Game", "Menu Created");
    }

    public void addButton(Button button) {
        list.add(button);
        Log.d("Button Added to Menu", button.getText().toString());
    }

    public void addAllButtons(Button... buttons) {
        list.addAll(buttons);
        Log.d("Buttons Added to Menu", "All Buttons added to menu");
    }

    public void addImage(ImageView imageView) {
        list.add(imageView);
        Log.d("Image Added to Menu", "Image added");
    }

    public void addAllImage(ImageView... imageViews) {
        list.addAll(imageViews);
        Log.d("Images Added to Menu", "All Images added to menu");
    }

    public void addLabel(Label label) {
        list.add(label);
        Log.d("Label Added to Menu", label.getText().toString());
    }

    public void addAll(Object... objects) {
        list.addAll(objects);
        for (Object obj : objects) {
            Log.d("Object Added to Menu", obj.toString());
        }
    }

    public Button addMainMenuButton() {
        list.add(main_menu_btn);
        //Todo:add Log.d("");
        return main_menu_btn;
    }

    public Button getMainMenuButton() {
        return main_menu_btn;
    }

}
