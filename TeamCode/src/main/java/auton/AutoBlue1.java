package auton;

import static global.General.bot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import elements.FieldSide;
import util.Timer;

@Disabled
@Autonomous(name="AutoBlue")
public class AutoBlue1 extends Auto {

    public double currentVoltage = 13.35;
    public final double voltageCoeffTurn = 1.2;

    @Override
    public void runOpMode() throws InterruptedException {

        reference(this);

        activate(FieldSide.BLUE);

        waitForStart();

        ready();
        Timer timer2 = new Timer();
        timer2.reset();
        while (timer2.seconds() < 0.2) {
            bot.mecDrive.move(1,0,0);
        }
        timer2.reset();
        while (timer2.seconds() < 0.5) {
            bot.mecDrive.move(0,0,1);
        }
        timer2.reset();
        while (timer2.seconds() < 2) {
            bot.mecDrive.move(1,0,0);
        }
        timer2.reset();
        while (timer2.seconds() < 20) {
            bot.carousel.move(1);
        }
        timer2.reset();
        while (timer2.seconds() < 4) {
            bot.mecDrive.move(-1,0,0);

        }
        end();
    }
}
