package Nacho.Tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EventTaskTest {
    @Test
    public void testStringConversion() {
        EventTask testTask = new EventTask("Team Meeting", "17/09/2025-14:30", "17/09/2025-15:30");

        // Standard String Conversion Format
        assertEquals("[E][ ] Team Meeting (from: 17 September 2025 - 02:30 PM to: 17 September 2025 - 03:30 PM)",
            testTask.toString());

        // Storage String Conversion Format
        assertEquals("E | 0 | Team Meeting | 17/09/2025-14:30 | 17/09/2025-15:30",
            testTask.getStorageRepresentation());
    }

    @Test
    public void testMarkAndUnmark() {
        EventTask testTask = new EventTask("Team Meeting", "17/09/2025-14:30", "17/09/2025-15:30");

        testTask.markCompleted();
        assertEquals("[E][X] Team Meeting (from: 17 September 2025 - 02:30 PM to: 17 September 2025 - 03:30 PM)",
            testTask.toString());
        assertEquals(1, testTask.isCompleted());

        testTask.unmarkCompleted();
        assertEquals("[E][ ] Team Meeting (from: 17 September 2025 - 02:30 PM to: 17 September 2025 - 03:30 PM)",
            testTask.toString());
        assertEquals(0, testTask.isCompleted());
    }
}
