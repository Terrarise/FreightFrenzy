package autoutil.executors;

import static java.lang.Math.PI;
import static global.General.*;
import static global.General.autoModules;
import static global.General.bot;

import java.util.LinkedList;
import java.util.TreeMap;

import automodules.StageList;
import geometry.circles.AngleType;
import util.codeseg.CodeSeg;

public abstract class Executor extends MovementExecutor {

    private final boolean[] syncedSegsExist = new boolean[1000];
    private final boolean[] unSyncedSegsExist = new boolean[1000];
    private final TreeMap<Integer, LinkedList<CodeSeg>> syncedSegs = new TreeMap<>();
    private final TreeMap<Integer, LinkedList<CodeSeg>> unSyncedSegs = new TreeMap<>();

    private boolean runningCodeSeg = false;

    //region CONSTRUCTORS
    public Executor() {
        super(0, 0, PI/2, AngleType.RADIANS);
        fillBoolArrs();
    }

//    public Executor(double stH, AngleType angleType) {
//        super(0, 0, stH, angleType);
//        fillBoolArrs();
//    }
//
//    public Executor(double stX, double stY, double stH, AngleType angleType) {
//        super(stX, stY, stH, angleType);
//        fillBoolArrs();
//    }

    private void fillBoolArrs() {
        for (int i = 0; i < 1000; i++) {
            syncedSegsExist[i] = false;
            unSyncedSegsExist[i] = false;
        }
    }
    //endregion

    public void addSynchronizedRF(StageList rf) {
        if (!syncedSegsExist[curPath]) {
            syncedSegsExist[curPath] = true;
            syncedSegs.put(curPath, new LinkedList<>());
        }
        syncedSegs.get(curPath).add(() -> bot.addAutoModule(rf));
    }

    public void addUnsynchronizedRF(StageList rf) {
        if (!unSyncedSegsExist[curPath]) {
            unSyncedSegsExist[curPath] = true;
            unSyncedSegs.put(curPath, new LinkedList<>());
        }
        unSyncedSegs.get(curPath).add(() -> bot.addAutoModule(rf));
    }

    public void addPause(double time) {
        addUnsynchronizedRF(autoModules.pause(time));
    }

    public boolean finished() {
        return finishedMove() && !unSyncedSegsExist[curPath] && !syncedSegsExist[curPath]
                && bot.rfsHandler.rfsQueue.isEmpty();
    }

    public void update() {
        if (!runningCodeSeg) {
            if (!moveRunning) {
                if (unSyncedSegsExist[curPath]) {
                    runningCodeSeg = true;
                    unSyncedSegs.get(curPath).poll().run();
                    unSyncedSegsExist[curPath] = !unSyncedSegs.get(curPath).isEmpty();
                } else if (!finishedMove()) {
                    resumeMove();
                }
            } else {
                if (syncedSegsExist[curPath]) {
                    syncedSegs.get(curPath).poll().run();
                    syncedSegsExist[curPath] = !syncedSegs.get(curPath).isEmpty();
                }
                updateMovement();
            }
        } else {
            runningCodeSeg = !bot.rfsHandler.rfsQueue.isEmpty();
        }
    }

}
