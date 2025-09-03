package Nacho.Tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TodoTaskTest {
    @Test
    public void testStringConversion() {
        assertEquals("[T][ ] Test Title", new TodoTask("Test Title").toString());
    }

    @Test
    public void testMarkAndUnmark() {
        TodoTask testTask = new TodoTask("Test");

        testTask.markCompleted();
        assertEquals("[T][X] Test", testTask.toString());
        assertEquals(1, testTask.isCompleted());

        testTask.unmarkCompleted();
        assertEquals("[T][ ] Test", testTask.toString());
        assertEquals(0, testTask.isCompleted());
    }

}
