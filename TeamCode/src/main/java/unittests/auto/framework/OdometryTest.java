package unittests.auto.framework;

import static global.General.bot;
import static global.General.log;

import java.util.Arrays;

import unittests.auto.AutoUnitTest;
import util.Timer;

public class OdometryTest extends AutoUnitTest {
    Timer timer = new Timer();
    @Override
    public void init() {
        log.showAndRecord("init", "");
    }

    @Override
    protected void run() {
        whileActive(() -> log.show("odometry pos", Arrays.toString(bot.odometry.curPos)));

    }
}