package org.openjfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private MenuBarController menuBarController;


    @Override
    public void start(Stage primaryStage) throws IOException {
        //scene = new Scene(loadFXML("primary"), 640, 480);
        primaryStage.setTitle("NoteCrash");

        menuBarController = new MenuBarController();

        Menu menuFile = new Menu("File");
        List<String> menuNames = Arrays.asList("New", "Open", "Save", "SaveAs", "Exit");
        List<MenuItem> menuItems = new ArrayList<>();
        EventHandler<ActionEvent> action = act();
        for(var name : menuNames){
            var menuItem = new MenuItem(name);
            menuItem.setOnAction(action);
            menuItems.add(menuItem);
            menuFile.getItems().add(menuItem);
        }

        Menu menuSearch = new Menu("Search");
        MenuItem menuItemSearch = new MenuItem("search");
        menuSearch.getItems().add(menuItemSearch);
        MenuBar menuBar = new MenuBar();

        menuBar.getMenus().add(menuFile);
        menuBar.getMenus().add(menuSearch);
        VBox vBox = new VBox(menuBar);
        Scene scene = new Scene(vBox, 960, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private EventHandler<ActionEvent> act() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MenuItem mItem = (MenuItem) actionEvent.getSource();
                String name = mItem.getText();
                switch(name){
                    case "New":
                        System.out.println(name + "pressed");
                        menuBarController.actionNew();
                        break;
                    case "Load":
                        System.out.println(name + "pressed");
                        menuBarController.actionLoad();
                        break;
                    case "Save":
                        System.out.println(name + "pressed");
                        menuBarController.actionSave();
                        break;
                    case "SaveAs":
                        System.out.println(name + "pressed");
                        menuBarController.actionSaveAs();
                        break;
                    case "Exit":
                        System.out.println(name + "pressed");
                        menuBarController.actionExit();
                        break;
                }
            }
        };
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}