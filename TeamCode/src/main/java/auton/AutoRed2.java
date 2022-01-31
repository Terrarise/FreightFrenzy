package auton;

import static global.General.bot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import java.sql.Time;

import elements.FieldSide;
import util.Timer;
import util.codeseg.CodeSeg;

@Disabled
@Autonomous(name="AutoRed2")
public class AutoRed2 extends Auto {

    public double currentVoltage = 13.35;
    public final double voltageCoeffTurn = 1.2;

    @Override
    public void runOpMode() throws InterruptedException {

        reference(this);
        activate(FieldSide.RED);

        waitForStart();

        ready();

        Timer timer3 = new Timer();
        timer3.reset();


        end();
    }
}