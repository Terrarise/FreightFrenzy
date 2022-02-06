package unittests.tele.hardware;

import static global.General.bot;
import static global.General.gph1;
import static global.General.log;

import teleutil.button.Button;
import teleutil.button.OnPressEventHandler;
import unittests.UnitTest;

public class OdometryServoTest extends UnitTest {
    /**
     * Tests odometry servo (used to retract for tank)
     */

    protected void start() {
        /**
         * Link gamepad handlers
         */
        gph1.link(Button.B, OnPressEventHandler.class, () -> bot.tankDrive.lower());
        gph1.link(Button.Y, OnPressEventHandler.class, () -> bot.tankDrive.raise());
    }

    protected void loop() {
        /**
         * The servo should move to the right locations
         */
        log.show("Press B to lower odometry");
        log.show("Press Y to raise odometry");
    }
}
