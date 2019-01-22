package xo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {
    static String MAIN_THEME = Utils.DARK_THEME;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //xo logo
        Image logo_light = new Image(new FileInputStream(Utils.LOGO_LIGHT_PATH));
        Image logo_dark = new Image(new FileInputStream(Utils.LOGO_DARK_PATH));

        ImageView logoView = new ImageView(logo_dark);
        logoView.setFitWidth(200);
        logoView.setFitHeight(120);


        //making "about us" scene
        AboutUi aboutUi = new AboutUi();
        Text text = new Text(Utils.LOREM);
        text.setWrappingWidth(Utils.M_W_SIZE - 20);
        Button back = new Button("Back");
        aboutUi.addText(text);
        aboutUi.addButton(back);
        aboutUi.setPadding(new Insets(Utils.M_P_SIZE));
        aboutUi.getStylesheets().add(MAIN_THEME);

        //making "menu" scene
        MenuUi menuUi = new MenuUi();
        menuUi.setAlignment(Pos.CENTER);
        menuUi.getStylesheets().add(MAIN_THEME);
        Button oneByOne = new Button("1 vs. 1");
        Button oneByBot = new Button("1 vs. Bot");
        Button about = new Button("About Us");
        Button exit = new Button("Exit");

        menuUi.addImage(logoView);
        menuUi.addAllButtons(oneByOne, oneByBot, about, exit);


        //scenes
        Scene about_scene = new Scene(aboutUi, Utils.M_W_SIZE, Utils.M_H_SIZE);
        Scene menu_scene = new Scene(menuUi, Utils.M_W_SIZE, Utils.M_H_SIZE);

        //onActions
        about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //going to about us scene
                primaryStage.setScene(about_scene);
                primaryStage.setTitle(Utils.ABOUT_TITLE);
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(menu_scene);

            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });

        //making first stage
        primaryStage.setScene(menu_scene);
        primaryStage.setTitle(Utils.MENU_TITLE);

        //show stage
        primaryStage.show();
    }

    public static void makingStage(Stage primaryStage, Parent root, String title, int width, int height) {
        primaryStage.setTitle(title);
        Scene scene = new Scene(root, width, height);
        scene.setFill(Color.BLUE);
        primaryStage.setScene(scene);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
