package unittests.tele.hardware;

import static global.General.bot;
import static global.General.gph1;
import static global.General.log;

import teleutil.button.Button;
import teleutil.button.OnPressEventHandler;
import unittests.tele.TeleUnitTest;

public class OuttakeTest extends TeleUnitTest {
    /**
     * Tests the outtake
     */
    @Override
    protected void start() {
        /**
         * Link the gamepad handlers
         */
        gph1.link(Button.B, OnPressEventHandler.class, () -> bot.outtake.lockCube());
        gph1.link(Button.DPAD_UP, OnPressEventHandler.class, () -> bot.outtake.lockBall());
        gph1.link(Button.DPAD_RIGHT, OnPressEventHandler.class, () -> bot.outtake.align());
        gph1.link(Button.DPAD_DOWN, OnPressEventHandler.class, () -> bot.outtake.start());
        gph1.link(Button.DPAD_LEFT, OnPressEventHandler.class, () -> bot.outtake.open());
    }

    @Override
    protected void loop() {
        showConfig(bot.outtake);
        /**
         * Should move the outtake servo
         */
        log.show("B for lock cube");
        log.show("Dpad up for lock ball");
        log.show("Dpad right for align");
        log.show("Dpad down for start");
        log.show("Dpad left for open");
    }
}
