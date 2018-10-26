import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.concurrent.TimeoutException;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" })
public class MyRunner extends ApplicationTest{

    private static boolean isHeadless = false;



    @BeforeClass
    public static void setupHeadlessMode() {
        if(isHeadless){
            System.setProperty("testfx.robot", "glass");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("prism.text", "t2k");
            System.setProperty("java.awt.headless", "true");
        }


    }

    @Before
    public void setUpClass() throws Exception {
        sleep(10000);
        ApplicationTest.launch(Main.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        sleep(10000);
        stage.show();
    }

    @After
    public void afterEachTest() throws TimeoutException {
        sleep(10000);
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    /* Helper method to retrieve Java FX GUI Components */
    public <T extends Node> T find (final  String query){
        return (T) lookup(query).queryAll().iterator().next();
    }




}