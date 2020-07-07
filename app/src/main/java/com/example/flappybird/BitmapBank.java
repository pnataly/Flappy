package com.example.flappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    private Bitmap background, level2, level3, level4, level5, level6, level7, level8, level9, level10,
            level11, level12, level13, level14, level15, level16, level17, level18, level19, level20;
    private Bitmap[] bird;
    private Bitmap tubeTop, tubeBottom;
    private Bitmap redTubeTop, redTubeBottom;

    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background);
        background = scaleImage(background);
        level2 = BitmapFactory.decodeResource(res, R.drawable.background2);
        level2 = scaleImage(level2);
        level3 = BitmapFactory.decodeResource(res, R.drawable.level3);
        level3 = scaleImage(level3);
        level4 = BitmapFactory.decodeResource(res, R.drawable.level4);
        level4 = scaleImage(level4);
        level5 = BitmapFactory.decodeResource(res, R.drawable.level5);
        level5 = scaleImage(level5);
        level6 = BitmapFactory.decodeResource(res, R.drawable.level6);
        level6 = scaleImage(level6);
        level7 = BitmapFactory.decodeResource(res, R.drawable.level7);
        level7 = scaleImage(level7);
        level8 = BitmapFactory.decodeResource(res, R.drawable.level8);
        level8 = scaleImage(level8);
        level9 = BitmapFactory.decodeResource(res, R.drawable.level9);
        level9 = scaleImage(level9);
        level10 = BitmapFactory.decodeResource(res, R.drawable.level10);
        level10 = scaleImage(level10);
        level11 = BitmapFactory.decodeResource(res, R.drawable.level11);
        level11 = scaleImage(level11);
        level12 = BitmapFactory.decodeResource(res, R.drawable.level12);
        level12 = scaleImage(level12);
        level13 = BitmapFactory.decodeResource(res, R.drawable.level13);
        level13 = scaleImage(level13);
        level14 = BitmapFactory.decodeResource(res, R.drawable.level14);
        level14 = scaleImage(level14);
        level15 = BitmapFactory.decodeResource(res, R.drawable.level15);
        level15 = scaleImage(level15);
        level16 = BitmapFactory.decodeResource(res, R.drawable.level16);
        level16 = scaleImage(level16);
        level17 = BitmapFactory.decodeResource(res, R.drawable.level17);
        level17 = scaleImage(level17);
        level18 = BitmapFactory.decodeResource(res, R.drawable.level18);
        level18 = scaleImage(level18);
        level19 = BitmapFactory.decodeResource(res, R.drawable.level19);
        level19 = scaleImage(level19);
        level20 = BitmapFactory.decodeResource(res, R.drawable.level20);
        level20 = scaleImage(level20);

        bird = new Bitmap[4];
        bird[0] = BitmapFactory.decodeResource(res, R.drawable.bird_frame1);
        bird[1] = BitmapFactory.decodeResource(res, R.drawable.bird_frame2);
        bird[2] = BitmapFactory.decodeResource(res, R.drawable.bird_frame3);
        bird[3] = BitmapFactory.decodeResource(res, R.drawable.bird_frame4);
        tubeTop = BitmapFactory.decodeResource(res, R.drawable.tube_top);
        tubeBottom = BitmapFactory.decodeResource(res, R.drawable.tube_bottom);
        redTubeTop = BitmapFactory.decodeResource(res, R.drawable.red_tube_top);
        redTubeBottom = BitmapFactory.decodeResource(res, R.drawable.red_tube_bottom);
    }

    public Bitmap getBackground() {
        return background;
    }

    public void setBackground(Bitmap background) {
        this.background = background;
    }

    public int getBackgroundWidth() {
        return background.getWidth();
    }

    public int getBackgroundHeight() {
        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        int backgroundScaleWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaleWidth, AppConstants.SCREEN_HEIGHT, false);
    }

    public Bitmap getBird(int frame) {
        return bird[frame];
    }

    public int getBirdWidth() {
        return bird[0].getWidth();
    }

    public int getBirdHeight() {
        return bird[0].getHeight();
    }

    public Bitmap getTubeTop() {
        return tubeTop;
    }

    public Bitmap getTubeBottom() {
        return tubeBottom;
    }

    public Bitmap getRedTubeTop() {
        return redTubeTop;
    }

    public Bitmap getRedTubeBottom() {
        return redTubeBottom;
    }

    public int getTubeWidth(){
        return tubeTop.getWidth();
    }

    public int getTubeHeight(){
        return tubeTop.getHeight();
    }

    public Bitmap getLevel2() {
        return level2;
    }

    public int getLevel2Width() {
        return level2.getWidth();
    }

    public int getLevel2Height() {
        return level2.getHeight();
    }

    public Bitmap getLevel3() {
        return level3;
    }

    public int getLevel3Width() {
        return level3.getWidth();
    }

    public int getLevel3Height() {
        return level3.getHeight();
    }

    public Bitmap getLevel4() {
        return level4;
    }

    public int getLevel4Width() {
        return level4.getWidth();
    }

    public int getLevel4Height() {
        return level4.getHeight();
    }

    public Bitmap getLevel5() {
        return level5;
    }

    public int getLevel5Width() {
        return level5.getWidth();
    }

    public int getLevel5Height() {
        return level5.getHeight();
    }

    public Bitmap getLevel6() {
        return level6;
    }

    public int getLevel6Width() {
        return level6.getWidth();
    }

    public int getLevel6Height() {
        return level6.getHeight();
    }

    public Bitmap getLevel7() {
        return level7;
    }

    public int getLevel7Width() {
        return level7.getWidth();
    }

    public int getLevel7Height() {
        return level7.getHeight();
    }

    public Bitmap getLevel8() {
        return level8;
    }

    public int getLevel8Width() {
        return level8.getWidth();
    }

    public int getLevel8Height() {
        return level8.getHeight();
    }

    public Bitmap getLevel9() {
        return level9;
    }

    public int getLevel9Width() {
        return level9.getWidth();
    }

    public int getLevel9Height() {
        return level9.getHeight();
    }

    public Bitmap getLevel10() {
        return level10;
    }

    public int getLevel10Width() {
        return level10.getWidth();
    }

    public int getLevel10Height() {
        return level10.getHeight();
    }

    public Bitmap getLevel11() {
        return level11;
    }

    public int getLevel11Width() {
        return level11.getWidth();
    }

    public int getLevel11Height() {
        return level11.getHeight();
    }

    public Bitmap getLevel12() {
        return level12;
    }

    public int getLevel12Width() {
        return level12.getWidth();
    }

    public int getLevel12Height() {
        return level12.getHeight();
    }

    public Bitmap getLevel13() {
        return level13;
    }

    public int getLevel13Width() {
        return level13.getWidth();
    }

    public int getLevel13Height() {
        return level13.getHeight();
    }

    public Bitmap getLevel14() {
        return level14;
    }

    public int getLevel14Width() {
        return level14.getWidth();
    }

    public int getLevel14Height() {
        return level14.getHeight();
    }

    public Bitmap getLevel15() {
        return level15;
    }

    public int getLevel15Width() {
        return level15.getWidth();
    }

    public int getLevel15Height() {
        return level15.getHeight();
    }

    public Bitmap getLevel16() {
        return level16;
    }

    public int getLevel16Width() {
        return level16.getWidth();
    }

    public int getLevel16Height() {
        return level16.getHeight();
    }

    public Bitmap getLevel17() {
        return level17;
    }

    public int getLevel17Width() {
        return level17.getWidth();
    }

    public int getLevel17Height() {
        return level17.getHeight();
    }

    public Bitmap getLevel18() {
        return level18;
    }

    public int getLevel18Width() {
        return level18.getWidth();
    }

    public int getLevel18Height() {
        return level18.getHeight();
    }

    public Bitmap getLevel19() {
        return level19;
    }

    public int getLevel19Width() {
        return level19.getWidth();
    }

    public int getLevel19Height() {
        return level19.getHeight();
    }

    public Bitmap getLevel20() {
        return level20;
    }

    public int getLevel20Width() {
        return level20.getWidth();
    }

    public int getLevel20Height() {
        return level20.getHeight();
    }

}
