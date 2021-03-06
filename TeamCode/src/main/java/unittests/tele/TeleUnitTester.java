package unittests.tele;

import static global.General.log;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import elements.FieldSide;
import teleop.Tele;
import unittests.UnitTester;
import unittests.unused.MecanumDriveTest;

@SuppressWarnings("ALL")
@TeleOp(name = "TeleUnitTester", group = "UnitTests")
public class TeleUnitTester extends Tele implements UnitTester{

    /**
     * Type of testing mode
     * @link TestType
     */
    private TestingMode testingMode = TestingMode.CONTROL;

    @Override
    public void createUnitTests(){
        /**
         * Framework
         */
        addAll(
//            new OdometryServoTest(),
//            new AccessTest(),
//            new CommonTest(),
//            new CoordinatePlaneTest(),
//            new LoggerTest(),
//            new FaultTest(),
//            new GamepadTest(),
//            new RobotFunctionsTest(),
//            new ThreadTest(),
//            new StorageTest(),
//            new AutoModuleTest(),
//            new LagTest(),
//            new SelectorTest(),
//            new SynchroniserTest(),
//            new RobotPartTest(),
//            new RobotFrameworkTest(),
//            new ElectronicsTest()
        );
        /**
         * Hardware
         */
        addAll(
            new MecanumDriveTest()
//            new TankDriveTest(),
//            new IntakeTest(),
//            new LiftTest(),
//            new TurretTest(),
//            new OuttakeTest(),
//            new CarouselTest()
        );
        /**
         * Sensors
         */
        addAll(
//            new ColorTest(),
//            new DistanceTest(),
//            new GyroTest(),
//            new OdometryTest(),
//            new TouchTest()
        );
    }

    /**
     * Init method
     */
    @Override
    public void initTele() {
        readyTestsAndSelector(testingMode);
        activate(FieldSide.UNKNOWN);
    }

    /**
     * Start method, reset the selectors update timer
     */
    @Override
    public void startTele() {
        selector.resetUpdateTimer();
    }

    /**
     * Loop method, update the selector, and run the current test
     */
    @Override
    public void loopTele() {
        if(!isDoneWithAllTests(testingMode)) {
            selector.update();
            runCurrentTest(testingMode);
        }else{
            log.show("Done With All Tests");
        }
    }

    /**
     * Reset the selector
     */
    @Override
    public void stopTele() {
        selector.reset();
    }
}
