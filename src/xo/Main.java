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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

        //one by one scene
        MenuUi oneByOne_menu = new MenuUi();
        Label oneByOne_title = new Label("Wellcome to 1 Vs. 1 part...\nPlease insert your informations:");
        Label playerOne = new Label("First Player:");
        Label playerTwo = new Label("Second Player:");
        TextField playerOne_field = new TextField();
        TextField playerTwo_field = new TextField();
        Button oneByOne_enter = new Button("Start Game :D");
        oneByOne_menu.addAll(oneByOne_title, playerOne, playerOne_field, playerTwo, playerTwo_field, oneByOne_enter);
        oneByOne_menu.getStylesheets().add(MAIN_THEME);

        //one by bot scene
        MenuUi oneByBot_menu = new MenuUi();
        Label oneByBot_title = new Label("Wellcome to 1 vs. Bot part...\nPlease insert your information:");
        Label bplayer = new Label("Name:");
        TextField bplayer_field = new TextField();
        Button oneByBot_enter = new Button("Start Game :D");
        oneByBot_menu.addAll(oneByBot_title, bplayer, bplayer_field, oneByBot_enter);
        oneByBot_menu.getStylesheets().add(MAIN_THEME);

        //making "about us" scene
        AboutUi aboutUi = new AboutUi();
        Text text = new Text(Utils.LOREM);
        text.setWrappingWidth(Utils.M_W_SIZE - 20);
        aboutUi.addText(text);
        aboutUi.getStylesheets().add(MAIN_THEME);

        //making "menu" scene
        MenuUi menuUi = new MenuUi();
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
        Scene oneByOne_scene = new Scene(oneByOne_menu, Utils.M_W_SIZE, Utils.M_H_SIZE);
        Scene oneByBot_scene = new Scene(oneByBot_menu, Utils.M_W_SIZE, Utils.M_H_SIZE);

        //onActions
        oneByBot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //going to about us scene
                primaryStage.setScene(oneByBot_scene);
                primaryStage.setTitle(Utils.ONE_BY_BOT_TITLE);
            }
        });

        oneByBot_menu.addMainMenuButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //going to main menu scene
                primaryStage.setScene(menu_scene);
                primaryStage.setTitle(Utils.MENU_TITLE);
            }
        });

        oneByOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //going to about us scene
                primaryStage.setScene(oneByOne_scene);
                primaryStage.setTitle(Utils.ONE_BY_ONE_TITLE);
            }
        });

        oneByOne_menu.addMainMenuButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //going to main menu scene
                primaryStage.setScene(menu_scene);
                primaryStage.setTitle(Utils.MENU_TITLE);
            }
        });

        oneByOne_enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Utils.PLAYER_NAME_1 = playerOne_field.getText().toString();
                Utils.PLAYER_NAME_2 = playerTwo_field.getText().toString();
                Log.d("Player 1", Utils.PLAYER_NAME_1);
                Log.d("Player 2", Utils.PLAYER_NAME_2);
            }
        });

        about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //going to about us scene
                primaryStage.setScene(about_scene);
                primaryStage.setTitle(Utils.ABOUT_TITLE);
            }
        });

        aboutUi.addMainMenuButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //going to main menu scene
                primaryStage.setScene(menu_scene);
                primaryStage.setTitle(Utils.MENU_TITLE);
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
