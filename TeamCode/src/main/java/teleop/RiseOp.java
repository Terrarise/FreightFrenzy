package teleop;

import static global.General.bot;

public class RiseOp extends Tele{
    @Override
    public void loop() {
        bot.mecanumDrive.move(0,0,0);
        super.loop();
    }
}
