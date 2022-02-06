package unittests.unused;

import static global.General.bot;
import static global.General.gamepad1;
import static global.General.log;

import unittests.tele.TeleUnitTest;

/**
 * NOTE: Uncommented
 */

public class MecanumDriveTest extends TeleUnitTest {

    @Override
    protected void loop() {
//        showConfig(bot.mecanumDrive);
        log.show("Use right stick y (forward), right stick x (strafe), and left stick x (turn)");
        bot.mecanumDrive.move(-gamepad1.right_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);
    }
}
