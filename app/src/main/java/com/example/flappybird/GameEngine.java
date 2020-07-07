package com.example.flappybird;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.Random;

public class GameEngine {

    private BackgroundImage backgroundImage;
    private Bird bird;
    static int gameState;
    private int score, scoringTube;
    private int level = 1;
    private ArrayList<Tube> tubes;
    private Random random;
    private Paint scorePaint;
    private Paint levelPaint;
    private boolean tubeVelocityFlag = false;
    public final static int STATE_NOT_STARTED = 0;
    public final static int STATE_PLAYING = 1;
    public final static int STATE_GAME_OVER = 2;
    private final int ADD_LEVEL_TUBE_VELOCITY = 2;

    public GameEngine() {
        backgroundImage = new BackgroundImage();
        bird = new Bird();

        gameState = STATE_NOT_STARTED;
        tubes = new ArrayList<>();
        random = new Random();
        for(int i = 0; i < AppConstants.numOfTubes; i++){
            int tubeX = AppConstants.SCREEN_WIDTH + i * AppConstants.distanceBetweenTubes;
            int tubeY = AppConstants.minTubeOffsetY + random.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY + 1);
            Tube tube = new Tube(tubeX, tubeY);
            tubes.add(tube);
        }
        score = 0;
        scoringTube = 0;

        scorePaint = new Paint();
        scorePaint.setColor(Color.RED);
        scorePaint.setTextSize(100);
        scorePaint.setTextAlign(Paint.Align.LEFT);

        levelPaint = new Paint();
        levelPaint.setColor(Color.RED);
        levelPaint.setTextSize(100);
    }

    public void updateAndDrawBackground(Canvas canvas){

        if(score > 5 && score < 10){
            level = 2;
        } else if(score > 10 && score < 15){
            level = 3;
        }else if(score > 15 && score < 20){
            level = 4;
        }else if(score > 20 && score < 25){
            level = 5;
        }else if(score > 25 && score < 30){
            level = 6;
        }else if(score > 30 && score < 35){
            level = 7;
        }else if(score > 35 && score < 40){
            level = 8;
        }else if(score > 40 && score < 45){
            level = 9;
        }else if(score > 45 && score < 50){
            level = 11;
        } else if(score > 50 && score < 55){
            level = 12;
        } else if(score > 55 && score < 60){
            level = 13;
        } else if(score > 60 && score < 65){
            level = 14;
        } else if(score > 65 && score < 70){
            level = 15;
        } else if(score > 70 && score < 75){
            level = 16;
        } else if(score > 75 && score < 80){
            level = 17;
        } else if(score > 80 && score < 85){
            level = 18;
        } else if(score > 85 && score < 90){
            level = 19;
        } else if(score > 90 && score < 100){
            level = 20;
        }else if(score >= 100){
            level = 21;
        }

        backgroundImage.setBackgroundImageX(backgroundImage.getBackgroundImageX() - backgroundImage.getBackgroundImageVelocity());
        if(backgroundImage.getBackgroundImageX() < -AppConstants.getBitmapBank().getBackgroundWidth()){
            backgroundImage.setBackgroundImageX(0);
        }

        if(level == 1) {
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if (backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getBackgroundWidth() -
                    AppConstants.SCREEN_WIDTH)) {
                canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getBackgroundWidth(), backgroundImage.getBackgroundImageY(), null);
            }
        }else if(level == 2){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel2(), backgroundImage.getBackgroundImageX(),
                        backgroundImage.getBackgroundImageY(), null);
                if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel2Width() -
                        AppConstants.SCREEN_WIDTH)){
                    canvas.drawBitmap(AppConstants.getBitmapBank().getLevel2(), backgroundImage.getBackgroundImageX() +
                            AppConstants.getBitmapBank().getLevel2Width(), backgroundImage.getBackgroundImageY(), null);
                }
        }else if(level ==3){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel3(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel3Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel3(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel2Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 4){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel4(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel4Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel4(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel2Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 5){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel5(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel5Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel5(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel5Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 6){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel6(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel6Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel6(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel6Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 7){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel7(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel7Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel7(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel7Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 8){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel8(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel8Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel8(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel8Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 9){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel9(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel9Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel9(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel9Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 10){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel10(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel10Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel10(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel10Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 11){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel11(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel11Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel11(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel11Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 12){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel12(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel12Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel12(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel12Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 13){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel13(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel13Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel13(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel13Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 14){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel14(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel14Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel14(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel14Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 15){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel15(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel15Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel15(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel15Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 16){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel16(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel16Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel16(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel16Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 17){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel17(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel17Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel17(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel17Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 18){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel18(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel18Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel18(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel18Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 19){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel19(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel19Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel19(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel19Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 20){
            canvas.drawBitmap(AppConstants.getBitmapBank().getLevel20(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if(backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getLevel20Width() -
                    AppConstants.SCREEN_WIDTH)){
                canvas.drawBitmap(AppConstants.getBitmapBank().getLevel20(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getLevel20Width(), backgroundImage.getBackgroundImageY(), null);
            }
        } else if(level == 21) {
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getBackgroundImageX(),
                    backgroundImage.getBackgroundImageY(), null);
            if (backgroundImage.getBackgroundImageX() < -(AppConstants.getBitmapBank().getBackgroundWidth() -
                    AppConstants.SCREEN_WIDTH)) {
                canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getBackgroundImageX() +
                        AppConstants.getBitmapBank().getBackgroundWidth(), backgroundImage.getBackgroundImageY(), null);
            }
        }
    }

    public void updateAndDrawBird(Canvas canvas){

        if(gameState == STATE_PLAYING){
            if(bird.getBirdY() < AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getBirdHeight()
                || bird.getVelocity() < 0){
                bird.setVelocity(bird.getVelocity() + AppConstants.gravity);
                bird.setBirdY(bird.getBirdY() + bird.getVelocity());
            }
        }

        int currentFrame = bird.getCurrentFrame();
        canvas.drawBitmap(AppConstants.getBitmapBank().getBird(currentFrame), bird.getBirdX(), bird.getBirdY(), null);
        currentFrame++;

        if(currentFrame > bird.maxFrame){
            currentFrame = 0;
        }
        bird.setCurrentFrame(currentFrame);
    }

    public void updateAndDrawTubes(Canvas canvas){

        if(gameState == STATE_PLAYING){

            if (level == 2 && tubeVelocityFlag == false) {
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = true;
            } else if (level == 3 && tubeVelocityFlag == true) {
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = false;
            }else if(level == 4 && tubeVelocityFlag == false){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = true;
            }else if(level == 5 && tubeVelocityFlag == true){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = false;
            }else if(level == 6 && tubeVelocityFlag == false){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = true;
            }else if(level == 7 && tubeVelocityFlag == true){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = false;
            }else if(level == 8 && tubeVelocityFlag == false){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = true;
            }else if(level == 9 && tubeVelocityFlag == true){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = false;
            }else if(level == 10 && tubeVelocityFlag == false){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = true;
            }else if(level == 11 && tubeVelocityFlag == true){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = false;
            }else if(level == 12 && tubeVelocityFlag == false){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = true;
            }else if(level == 13 && tubeVelocityFlag == true){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = false;
            }else if(level == 14 && tubeVelocityFlag == false){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = true;
            }else if(level == 15 && tubeVelocityFlag == true){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = false;
            }else if(level == 16 && tubeVelocityFlag == false){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = true;
            }else if(level == 17 && tubeVelocityFlag == true){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = false;
            }else if(level == 18 && tubeVelocityFlag == false){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = true;
            }else if(level == 19 && tubeVelocityFlag == true){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = false;
            }else if(level == 20 && tubeVelocityFlag == false){
                AppConstants.tubeVelocity += ADD_LEVEL_TUBE_VELOCITY;
                tubeVelocityFlag = true;
            }

            if((tubes.get(scoringTube).getTubeX() < bird.getBirdX() + AppConstants.getBitmapBank().getBirdWidth())
                    && (tubes.get(scoringTube).getTubeY() > bird.getBirdY()
                    || tubes.get(scoringTube).getBottomTubeY() < (bird.getBirdY() + AppConstants.getBitmapBank().getBirdHeight()))){
                gameState = STATE_GAME_OVER;
                AppConstants.getSoundBank().playHit();

                Context context = AppConstants.gameActivityContext;
                Intent intent = new Intent(context, GameOverActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("level", level);
                context.startActivity(intent);
                ((Activity)context).finish();
            }
            else if (tubes.get(scoringTube).getTubeX() < bird.getBirdX() - AppConstants.getBitmapBank().getTubeWidth()){

                if(score == 100){
                    Context context = AppConstants.gameActivityContext;
                    Intent intent = new Intent(context, FinishActivity.class);
                    context.startActivity(intent);
                    ((Activity)context).finish();
                }

                score++;
                AppConstants.getSoundBank().playPoint();
                scoringTube++;
                if(scoringTube > AppConstants.numOfTubes -1){
                    scoringTube = 0;
                }
            }

            for(int i = 0; i < AppConstants.numOfTubes; i++){

                if(tubes.get(i).getTubeX() < -AppConstants.getBitmapBank().getTubeWidth()){
                    tubes.get(i).setTubeX(tubes.get(i).getTubeX() + AppConstants.numOfTubes * AppConstants.distanceBetweenTubes);
                    int topTubeY = AppConstants.minTubeOffsetY + random.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY + 1);
                    tubes.get(i).setTubeY(topTubeY);
                    tubes.get(i).setTubeColor();
                }
                tubes.get(i).setTubeX(tubes.get(i).getTubeX() - AppConstants.tubeVelocity);

                if(tubes.get(i).getTubeColor() == 0){
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeTop(), tubes.get(i).getTubeX(),
                            tubes.get(i).getTopTubeY(), null);
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeBottom(), tubes.get(i).getTubeX(),
                            tubes.get(i).getBottomTubeY(), null);
                } else{
                    canvas.drawBitmap(AppConstants.getBitmapBank().getRedTubeTop(), tubes.get(i).getTubeX(),
                            tubes.get(i).getTopTubeY(), null);
                    canvas.drawBitmap(AppConstants.getBitmapBank().getRedTubeBottom(), tubes.get(i).getTubeX(),
                            tubes.get(i).getBottomTubeY(), null);
                }
            }
            canvas.drawText("Points: " + score, 0, 110, scorePaint);
            canvas.drawText("Level: " + level, 1050, 110, levelPaint);
        }
    }

    public Bird getBird() {
        return bird;
    }

    public static int getGameState() {
        return gameState;
    }

    public static void setGameState(int gameState) {
        GameEngine.gameState = gameState;
    }
}
