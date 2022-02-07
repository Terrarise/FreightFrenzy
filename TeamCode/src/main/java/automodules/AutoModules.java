package automodules;

import static global.General.bot;

import robotparts.RobotPart;

public class AutoModules{
    /**
     * Define automodules here as a stage list
     */
    // TODO FIX
            // DOenst work properly
    public StageList IntakeAuto = new StageList(bot.lift, bot.intake, bot.outtake).define(
        bot.lift.liftEncoder(0.4, 0),
        bot.intake.intakeUntilFreight(1),
        bot.outtake.outtakeLock(1)
    );

    public StageList IntakeTele = new StageList(bot.lift, bot.intake, bot.outtake).define(
        bot.outtake.outtakeReset(0.05),
        bot.lift.liftEncoder(0.4, 0),
        bot.intake.intakeUntilFreightLiftDown(1),
        bot.lift.liftEncoderAndIntake(0.2, 90),
        bot.outtake.outtakeLock(1),
        bot.lift.liftEncoder(0.1, 170)
    );

    public StageList MoveForwardTime(double time) {
        return MoveTime(0.5, 0, time);
    }

    public StageList MoveBackwardTime(double time) {
        return MoveTime(-0.5, 0, time);
    }

    public StageList MoveCWTime(double time) {
        return MoveTime(0, 0.4, time);
    }

    public StageList MoveCCWTime(double time) {
        return MoveTime(0, -0.5, time);
    }

    public StageList MoveTime(double forward, double turn, double time) {
        return new StageList(bot.tankDrive).define(
            bot.tankDrive.moveTime(forward, turn, time)
        );
    }

    public StageList pause(double time) {
        return new StageList().define(
            RobotPart.pause(time)
        );
    }

    public StageList ReleaseAndResetTele = new StageList(bot.lift, bot.outtake).define(
        bot.outtake.outtakeDrop(1),
        bot.lift.liftEncoder(0.4, 0)
    );
}
