package com.example.flappybird;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.SurfaceHolder;

public class GameThread extends Thread{

    private SurfaceHolder holder;
    private boolean isRunning;
    private long startTime, loopTime;
    private long DELAY = 33;    //milliseconds between screen refreshed

    public GameThread(SurfaceHolder holder) {
        this.holder = holder;
        isRunning = true;
    }

    @Override
    public void run() {

        while (isRunning){

            startTime = SystemClock.uptimeMillis();
            Canvas canvas = holder.lockCanvas(null);
            if(canvas != null){
                synchronized (holder){
                    AppConstants.getGameEngine().updateAndDrawBackground(canvas);
                    AppConstants.getGameEngine().updateAndDrawBird(canvas);
                    AppConstants.getGameEngine().updateAndDrawTubes(canvas);
                    holder.unlockCanvasAndPost(canvas);
                }
            }
            loopTime = SystemClock.uptimeMillis() - startTime;
            if(loopTime < DELAY){
                try{
                    Thread.sleep(DELAY - loopTime);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
