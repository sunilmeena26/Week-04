package com.day06.javaunittesting;
import static org.junit.jupiter.api.Assertions.*;

import com.day05.javajunit.LongRunningTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

//Create a class LongRunningTaskTesting to perform junit testing on LongRunning class and perform @Timeout(2) Tests
public class LongRunningTaskTesting {

    //Create a method testLongRunningTask to test the longRunningTask method
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    public void testLongRunningTask() {
        // This test will fail because the longRunningTask method takes 3 seconds
        String result = LongRunningTask.longRunningTask();
        assertEquals("Task Completed", result);
    }
}
