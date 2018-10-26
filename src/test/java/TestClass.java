import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import org.junit.Test;
import org.testfx.util.WaitForAsyncUtils;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;


public class TestClass extends TestFXBase  {

    @Test
    public void cucumber(){
        MyRunner myRunner = new MyRunner();

    }
    @Test
    public void ChangeColorContextMenuRed(){
        rightClickOn("#rect");
        clickOn("#item1");
        Rectangle rect = find("#rect");
        Paint color = rect.getFill();

        assertThat(color, is(Color.RED));

    }

    @Test
    public void ChangeColorContextMenuGreen(){
        rightClickOn("#rect");
        clickOn("#item2");
        Rectangle rect = find("#rect");
        Paint color = rect.getFill();

        assertThat(color, is(Color.GREEN));

    }

    @Test
    public void ChangeColorContextMenuYellow(){
        rightClickOn("#rect");
        clickOn("#item3");
        Rectangle rect = find("#rect");
        Paint color = rect.getFill();

        assertThat(color, is(Color.YELLOW));

    }
//
//    @Test
//    public void ChangeColorsWithButtonsYellow() {
//        clickOn("#Yellow");
//        assertNodeExists(hasText("Yellow"));
//    }
//    @Test
//    public void ChangeColorsWithButtonsRed(){
//        clickOn("#Red");
//        assertNodeExists(hasText("Red"));
//    }
//
//
//
//    @Test
//    public void ChangeColorsWithButtonsGreen() {
//        clickOn("#Green");
//        assertex(hasText("Green"));
//    }

    @Test
    public void ChangeWithTextFieldGreen() {

        clickOn("#tf");
        write("Green");
        press(KeyCode.ENTER);
        WaitForAsyncUtils.waitForFxEvents();
        Rectangle rect = find("#rect");

        if (rect.getFill() == Color.GREEN) {
            System.out.println("Match Green");
        }

        else{
            fail();
        }
    }
    @Test
    public void ChangeWithTextFieldYellow() {


        clickOn("#tf");
        write("Yellow");
        press(KeyCode.ENTER);
        WaitForAsyncUtils.waitForFxEvents();
        Rectangle rect = find("#rect");

        if (rect.getFill() == Color.YELLOW) {
            System.out.println("Match Yellow");
        }

        else{
            fail();
        }
    }
    @Test
    public void ChangeWithTextFieldRed() {

        clickOn("#tf");
        write("Red");
        press(KeyCode.ENTER);
        WaitForAsyncUtils.waitForFxEvents();
        Rectangle rect = find("#rect");

        if (rect.getFill() == Color.RED) {
            System.out.println("Match Red");
        }
        else{
            fail();
        }
    }

    @Test
    public void ensureLabelContains(){
        String labelText = "Can you find this label text";
        clickOn(labelText);
        sleep(1000);
        verifyThat("#labelId",(Label label)-> {
            String text = label.getText();
            return text.contains(labelText);
        });
    }

    @Test
    public void ensureListViewIsPopulated(){

        //MoveTo üzerinde durmasını sağlar. belirli bir sleep konulduktan sonra bir pencere açılıyorsa oradan da metin kontrolü yapılabilir.

        //moveTo("#listViewId");

        ListView listView = find("#listViewId");
        WaitForAsyncUtils.waitForFxEvents();

        assertEquals(7,listView.getItems().size());
    }



    @Test
    public void notUsefulHereButMaybeForLoginTests(){
        clearOutInputFields();
        clickOn("#tf").write("USERNAME and Password");
        //clickOn(LOGIN_BUTTON_ID);
        //assertEquals("Test Title",getPrimaryStage().getTitle());
        //assertTrue("Test Title",getPrimaryStage().isShowing());
    }

    private void clearOutInputFields() {
        final int NUM_CHARS_TO_ERASE = 10;
        clickOn("#tf").eraseText(NUM_CHARS_TO_ERASE);
    }

}
