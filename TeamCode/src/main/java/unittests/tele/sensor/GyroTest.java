package unittests.tele.sensor;

import static global.General.bot;
import static global.General.log;

import unittests.tele.TeleUnitTest;

public class GyroTest extends TeleUnitTest {
    /**
     * Tests gyro sensors
     */
    @Override
    protected void loop() {
        /**
         * These should range from -180 to 180 and are in degrees
         */
        log.show("Right gyro reading", bot.gyroSensors.getRightHeadingDeg());
        log.show("Left gyro reading", bot.gyroSensors.getLeftHeadingDeg());
    }
}
