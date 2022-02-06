package unittests.tele.hardware;

import static global.General.bot;
import static global.General.gamepad1;
import static global.General.log;

import unittests.tele.TeleUnitTest;

public class CarouselTest extends TeleUnitTest {
    /**
     * Tests carousel
     */
    @Override
    public void loop() {
        showConfig(bot.carousel);
        /**
         * Carousel should move
         */
        log.show("Use right trigger");
        bot.carousel.move(gamepad1.right_trigger);
    }
}
