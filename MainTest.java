import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class MainTest {

    @Test
    public void testPickColor() {
        String[] colorArray = {"red", "green", "blue", "yellow"};
        String pickedColor = Main.pickColor(colorArray);
        assertTrue(Arrays.asList(colorArray).contains(pickedColor));
    }

    @Test
    public void testCheckSequence_match() {
        String[] userColours = {"red", "green", "blue"};
        String[] computerColours = {"red", "green", "blue"};
        int index = 1;
        assertTrue(Main.checkSequence(userColours, computerColours, index));
    }

    @Test
    public void testCheckSequence_mismatch() {
        String[] userColours = {"red", "green", "blue"};
        String[] computerColours = {"red", "yellow", "blue"};
        int index = 1;
        assertFalse(Main.checkSequence(userColours, computerColours, index));
    }
}
