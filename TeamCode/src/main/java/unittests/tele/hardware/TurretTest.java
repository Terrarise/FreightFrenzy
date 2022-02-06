package unittests.tele.hardware;

import static global.General.bot;
import static global.General.gamepad1;
import static global.General.log;

import unittests.tele.TeleUnitTest;

public class TurretTest extends TeleUnitTest {
    /**
     * Tests the turret
     */

    @Override
    public void loop() {
        showConfig(bot.turret);
        /**
         * Should move the turret
         */
        log.show("Use left stick x");
        bot.turret.move(gamepad1.left_stick_x);
        /**
         * Should change when the turret moves
         */
        log.show("Turret pos", bot.turret.getTurretPos());
        /**
         * Should not change when the turret moves
         */
        log.show("Turret target pos", bot.turret.getTargetPos());
    }
}
