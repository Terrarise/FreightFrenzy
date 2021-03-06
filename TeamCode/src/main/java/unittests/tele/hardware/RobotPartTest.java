package unittests.tele.hardware;

import static global.General.bot;
import static global.General.log;

import robotparts.electronics.continuous.CMotor;
import unittests.tele.TeleUnitTest;

public class RobotPartTest extends TeleUnitTest {
    /**
     * Class that tests robot part by creating a test robot part
     */


    /**
     * Uses the intake robotpart as the test part
     * NOTE: The robot must have an intake robotpart for this to work
     */
    @Override
    protected void loop() {
        /**
         * Should show config of test part properly (i.e. directions correct, run without encoder, etc.)
         */
        showConfig(bot.intake);
        /**
         * Should be 1
         */
        log.show("Test part electronics size", bot.intake.getElectronicsOfType(CMotor.class).size());
        /**
         * Should be TELE
         */
        log.show("Test part current user", bot.intake.getUser());
    }

    /**
     * When the program stops the logs should have the configuration of the intake
     */
}
