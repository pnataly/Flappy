package com.example.flappybird;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private GameThread gameThread;

    public GameView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        gameThread = new GameThread(holder);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if(!gameThread.isRunning()){
            gameThread = new GameThread(holder);
            gameThread.start();
        }
        else{
            gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if(gameThread.isRunning()){
            gameThread.setRunning(false);
            boolean retry = true;
            while (retry){
                try {
                    gameThread.join();
                    retry = false;
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){

            if(AppConstants.getGameEngine().getGameState() == AppConstants.getGameEngine().STATE_NOT_STARTED){
                AppConstants.getGameEngine().gameState = AppConstants.getGameEngine().STATE_PLAYING;
                AppConstants.getSoundBank().playSwoosh();
            }
            else{
                AppConstants.getSoundBank().playWing();
            }
            AppConstants.getGameEngine().getBird().setVelocity(AppConstants.VELOCITY_WHEN_JUMP);
        }
        return true;
    }
}
