package global;

import static global.General.autoModules;
import static global.General.bot;
import static global.General.fault;
import static global.General.fieldSide;
import static global.General.gameTime;
import static global.General.gamepad1;
import static global.General.gamepad2;
import static global.General.gph1;
import static global.General.gph2;
import static global.General.hardwareMap;
import static global.General.log;
import static global.General.mainUser;
import static global.General.storage;
import static global.General.sync;
import static global.General.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import automodules.AutoModules;
import debugging.Fault;
import debugging.Logger;
import debugging.Synchroniser;
import elements.FieldSide;
import robot.TerraBot;
import teleutil.GamepadHandler;
import util.User;
import util.store.Storage;

public interface Common{
    /**
     * Reference initializes all of the robotParts using the opmode
     * @param thisOpMode
     */
    default void reference(OpMode thisOpMode){
        /**
         * Initialize all of the objects from the opmode
         */
        hardwareMap = thisOpMode.hardwareMap;
        telemetry = thisOpMode.telemetry;
        gamepad1 = thisOpMode.gamepad1;
        gamepad2 = thisOpMode.gamepad2;
        /**
         * Create the gamepadhanlders from the gamepads
         */
        gph1 = new GamepadHandler(gamepad1);
        gph2 = new GamepadHandler(gamepad2);
        /**
         * Create the debugging tools
         */
        fault = new Fault();
        sync = new Synchroniser();
        log = new Logger();
        /**
         * Create the gameTime
         */
        gameTime = new ElapsedTime();
        /**
         * Get the main user
         * NOTE: the user is automatically set from the type of opMode
         */
        mainUser = User.getUserFromTypeOfOpMode(thisOpMode);
        /**
         * Create the storage
         */
        storage = new Storage();
        /**
         * Create the robot, and then the modules, stages, and automodules
         */
        bot = new TerraBot();
        /**
         * Create the automodules
         */
        autoModules = new AutoModules();
        /**
         * Initialize the robot
         */
        bot.init();
    }

    /**
     * Activate sets the field side and thus should only be used in teleop or auton
     * Also shows telemetry to display that the robot is ready
     * @param side
     */
    default void activate(FieldSide side){
        fieldSide = side;
        sync.logReady();
    }

    /**
     * Starts the robot and clears the telemetry
     */
    default void ready(){
        bot.start();
        sync.resetDelay();
        log.clearTelemetry();
    }

    /**
     * Updates the telemetry, checks the access for bot for the main user (either teleop or auton)
     * Runs the gamepad handlers
     * @param showTelemetry
     */
    default void update(boolean showTelemetry){
        bot.update();
        gph1.run();
        gph2.run();
        sync.update();
        if(showTelemetry){log.showTelemetry();}
    }

    /**
     * Stops the robot, halts all of the motors (in stop), checks if common is used properly, shows the logs, and saves the storage times
     */
    default void end(){
        bot.stop();
        sync.logDelay();
        log.showLogs();
        storage.saveItems();
    }
}
