package teleop;

import static global.General.autoModules;
import static global.General.bot;
import static global.General.gph1;
import static global.General.log;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.Arrays;

import teleutil.button.Button;
import teleutil.button.OnPressEventHandler;

@TeleOp(name = "RiseTest", group = "TeleOp")
public class RiseTest extends Tele{
    @Override
    public void startTele() {
//        gph1.link(Button.X, OnPressEventHandler.class, () -> bot.addAutoModule(autoModules.RiseLift));
        gph1.link(Button.Y, OnPressEventHandler.class, () -> bot.addAutoModule(autoModules.IntakeTele));
        gph1.link(Button.X, OnPressEventHandler.class, () -> bot.addAutoModule(autoModules.ReleaseAndResetTele));
    }

    @Override
    public void loopTele() {
        bot.mecanumDrive.moveSmooth(-gamepad1.right_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);
        bot.intake.move(-gamepad2.right_stick_y);
        bot.lift.setToRestPow();
//        bot.lift.move(-gamepad2.right_stick_y);
    }

}


