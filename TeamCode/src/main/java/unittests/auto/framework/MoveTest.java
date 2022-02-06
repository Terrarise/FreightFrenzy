package unittests.auto.framework;

import static global.General.bot;

import unittests.auto.AutoUnitTest;
import util.Timer;

public class MoveTest extends AutoUnitTest {
    Timer timer = new Timer();
    @Override
    public void init() {
        timer.reset();
    }

    @Override
    protected void run() {
        whileTime(() -> bot.tankDrive.move(0.3, 0), 1);
    }

    @Override
    public void stop() {
        bot.tankDrive.move(0,0);
    }
}
