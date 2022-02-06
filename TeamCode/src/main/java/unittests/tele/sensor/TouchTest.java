package unittests.tele.sensor;

import static global.General.bot;
import static global.General.log;

import unittests.tele.TeleUnitTest;

public class TouchTest extends TeleUnitTest {
    /**
     * Test the touch sensors
     */
    @Override
    protected void loop() {
        /**
         * This should change when the touch sensor is touched
         */
        log.show("Touch sensor reading, is pressed?", bot.touchSensors.isOuttakePressingTouchSensor());
    }
}
