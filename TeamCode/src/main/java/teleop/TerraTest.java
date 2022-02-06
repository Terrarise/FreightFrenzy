package teleop;

import static global.General.bot;
import static global.General.gph1;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import teleutil.button.Button;
import teleutil.button.OnTurnOffEventHandler;
import teleutil.button.OnTurnOnEventHandler;

@TeleOp(name = "TerraTest", group = "TeleOp")
public class TerraTest extends Tele{
    @Override
    public void startTele() {
        gph1.link(Button.A, OnTurnOnEventHandler.class, () -> bot.intake.move(1));
        gph1.link(Button.A, OnTurnOffEventHandler.class, () -> bot.intake.move(0));
    }

    @Override
    public void loopTele() {
        bot.mecanumDrive.moveSmooth(-gamepad1.right_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);
//        bot.intake.move(-gamepad1.right_stick_y);
    }

}


