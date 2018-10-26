
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();

        VBox vb = new VBox();
        vb.setSpacing(10);
        vb.setPadding(new Insets(10, 50, 50, 50));

        final Rectangle rect = new Rectangle(20, 20, 350, 200);
        rect.setId("rect");
        final ContextMenu context = new ContextMenu();
        MenuItem item1 = new MenuItem("Red");
        item1.setId("item1");
        MenuItem item2 = new MenuItem("Green");
        item2.setId("item2");
        MenuItem item3 = new MenuItem("Yellow");
        item3.setId("item3");
        MenuItem item4 = new MenuItem("Blue");
        item4.setId("item4");

        item1.setOnAction(event -> {
            rect.setFill(Color.RED);

        });

        item2.setOnAction(event -> rect.setFill(Color.GREEN));


        item3.setOnAction(event -> rect.setFill(Color.YELLOW));
        item4.setOnAction(event -> rect.setFill(Color.BLUE));

        context.getItems().addAll(item1,new SeparatorMenuItem(),item2, new SeparatorMenuItem(),item3);


        rect.setFill(Color.GRAY);
        rect.setStroke(Color.BLACK);
        rect.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            if(event.getButton()== MouseButton.SECONDARY){
                context.show(rect,event.getScreenX(),event.getScreenY());
            }
        });
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.setPadding(new Insets(10, 50, 50, 50));

        final TextField tf = new TextField();
        tf.setId("tf");
        tf.setPadding(new Insets(10, 10, 10, 10));
        tf.setOnAction(event -> {


            if (tf.getText().equals("Red") && rect.getFill() != Color.RED) {
                rect.setFill(Color.RED);
            }
            if (tf.getText().equals("Green") && rect.getFill() != Color.GREEN) {
                rect.setFill(Color.GREEN);
            }
            if (tf.getText().equals("Yellow") && rect.getFill() != Color.YELLOW) {
                rect.setFill(Color.YELLOW);
            }


        });

        Button btn1 = new Button();
        btn1.setId("Yellow");
        btn1.setText("Change To Yellow");
        btn1.setOnAction(event -> {
            rect.setFill(Color.YELLOW);
            tf.setText("Yellow");
        });



        Button btn2 = new Button();
        btn2.setId("Red");
        btn2.setText("Change To Red");
        btn2.setOnAction(event -> {
            rect.setFill(Color.RED);
            tf.setText("Red");
        });


        Button btn3 = new Button();
        btn3.setId("Green");
        btn3.setText("Change To Green");
        btn3.setOnAction(event -> {
            rect.setFill(Color.GREEN);
            tf.setText("Green");
        });

        Label label = new Label();
        label.setStyle("-fx-border-color:white; -fx-background-color:#c4d8de;");
        label.setId("labelId");
        label.setText("Can you find this label text");

        hb.getChildren().add(btn1);
        hb.getChildren().add(btn2);
        hb.getChildren().add(btn3);



        ListView listView = new ListView();
        listView.setId("listViewId");
        listView.getItems().addAll("Item1","Item2","Item3","Item4","Item5","Item6","Item7");

        vb.getChildren().addAll(hb, rect,label, tf,listView);

        Scene scene = new Scene(vb, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Test Title");
        primaryStage.show();

    }

    public static boolean resultForJUnit(){
        return true;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
