package unittests.tele.sensor;


import static global.General.bot;
import static global.General.log;

import java.util.Arrays;

import unittests.tele.TeleUnitTest;

public class ColorTest extends TeleUnitTest {
    /**
     * Tests color sensors
     */

    @Override
    protected void loop() {
        /**
         * In HSV, should seem reasonable,
         * h is the hue or color
         * s is the saturation
         * v is the value or brightness
         */
        log.show("Color sensor reading", Arrays.toString(bot.colorSensors.getOuttakeColorHSV()));
        /**
         * These should turn true depending on the type of freight
         */
        log.show("Put a ball in the intake", bot.colorSensors.isBall());
        log.show("Put a cube in the intake", bot.colorSensors.isCube());
    }
}
