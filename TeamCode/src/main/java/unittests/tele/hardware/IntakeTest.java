package unittests.tele.hardware;

import static global.General.bot;
import static global.General.gph1;
import static global.General.log;

import teleutil.button.Button;
import teleutil.button.OnTurnOffEventHandler;
import teleutil.button.OnTurnOnEventHandler;
import unittests.tele.TeleUnitTest;

public class IntakeTest extends TeleUnitTest {
    /**
     * Tests intake
     */
    @Override
    public void start() {
        /**
         * Link the gamepad handlers
         */
        gph1.link(Button.RIGHT_BUMPER, OnTurnOnEventHandler.class, () -> bot.intake.move(1));
        gph1.link(Button.RIGHT_BUMPER, OnTurnOffEventHandler.class, () -> bot.intake.move(0));
    }

    @Override
    protected void loop() {
        showConfig(bot.intake);
        /**
         * Intake should move when right bumper is pressed (toggle control)
         */
        log.show("Use right bumper");
    }
}
