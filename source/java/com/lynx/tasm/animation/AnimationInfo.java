package com.lynx.tasm.animation;

import android.util.SparseArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;

/* loaded from: classes6.dex */
public class AnimationInfo implements Cloneable {
    private long delay;
    private int direction;
    private long duration;
    private int fillMode;
    private int iterationCount;
    private int layoutAnimationType;
    private String name;
    private int orderIndex;
    private int playState;
    private int property;
    private int stepsType;
    private int timingType;
    private float x1;
    private float x2;
    private float y1;
    private float y2;

    public AnimationInfo(String str, long j, long j2, int i, float f, float f2, float f3, float f4, int i2, int i3, int i4, int i5, int i6) {
        this.orderIndex = -1;
        this.name = str;
        this.duration = j;
        this.delay = j2;
        this.timingType = i;
        this.x1 = f;
        this.y1 = f2;
        this.x2 = f3;
        this.y2 = f4;
        this.stepsType = i2;
        this.iterationCount = i3;
        this.fillMode = i4;
        this.direction = i5;
        this.playState = i6;
    }

    public AnimationInfo(int i, long j, long j2, int i2, int i3, float f, float f2, float f3, float f4, int i4) {
        this.fillMode = -1;
        this.playState = -1;
        this.orderIndex = -1;
        this.layoutAnimationType = i;
        this.duration = j;
        this.delay = j2;
        this.property = i2;
        this.timingType = i3;
        this.x1 = f;
        this.y1 = f2;
        this.x2 = f3;
        this.y2 = f4;
        this.stepsType = i4;
    }

    public AnimationInfo() {
        this.fillMode = -1;
        this.playState = -1;
        this.orderIndex = -1;
    }

    public AnimationInfo(AnimationInfo animationInfo) {
        this.fillMode = -1;
        this.playState = -1;
        this.orderIndex = -1;
        this.name = animationInfo.name;
        this.duration = animationInfo.duration;
        this.delay = animationInfo.delay;
        this.property = animationInfo.property;
        this.timingType = animationInfo.timingType;
        this.x1 = animationInfo.x1;
        this.y1 = animationInfo.y1;
        this.x2 = animationInfo.x2;
        this.y2 = animationInfo.y2;
        this.stepsType = animationInfo.stepsType;
        this.iterationCount = animationInfo.iterationCount;
        this.fillMode = animationInfo.fillMode;
        this.direction = animationInfo.direction;
        this.playState = animationInfo.playState;
        this.layoutAnimationType = animationInfo.layoutAnimationType;
        this.orderIndex = animationInfo.orderIndex;
    }

    public void setProperty(int i) {
        this.property = i;
    }

    public void setOrderIndex(int i) {
        this.orderIndex = i;
    }

    public int getOrderIndex() {
        return this.orderIndex;
    }

    public String getName() {
        return this.name;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getDelay() {
        return this.delay;
    }

    public int getProperty() {
        return this.property;
    }

    public int getTimingType() {
        return this.timingType;
    }

    public float getX1() {
        return this.x1;
    }

    public float getY1() {
        return this.y1;
    }

    public float getX2() {
        return this.x2;
    }

    public float getY2() {
        return this.y2;
    }

    public int getStepsType() {
        return this.stepsType;
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

    public int getFillMode() {
        return this.fillMode;
    }

    public int getDirection() {
        return this.direction;
    }

    public int getPlayState() {
        return this.playState;
    }

    public int getLayoutAnimationType() {
        return this.layoutAnimationType;
    }

    public void setCount(float f) {
        this.x1 = f;
    }

    public int getCount() {
        return (int) this.x1;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setDelay(long j) {
        this.delay = j;
    }

    public void setTimingType(int i) {
        this.timingType = i;
    }

    public void setX1(float f) {
        this.x1 = f;
    }

    public void setY1(float f) {
        this.y1 = f;
    }

    public void setX2(float f) {
        this.x2 = f;
    }

    public void setY2(float f) {
        this.y2 = f;
    }

    public void setStepsType(int i) {
        this.stepsType = i;
    }

    public void setIterationCount(int i) {
        this.iterationCount = i;
    }

    public void setFillMode(int i) {
        this.fillMode = i;
    }

    public void setDirection(int i) {
        this.direction = i;
    }

    public void setPlayState(int i) {
        this.playState = i;
    }

    public void setLayoutAnimationType(int i) {
        this.layoutAnimationType = i;
    }

    public int setTimingFunction(ReadableArray readableArray, int i) {
        if (readableArray == null || readableArray.size() < 6) {
            setTimingType(0);
            setStepsType(0);
            setX1(0.0f);
            setY1(0.0f);
            setX2(0.0f);
            setY2(0.0f);
            return i;
        }
        setTimingType(readableArray.getInt(i));
        setStepsType(readableArray.getInt(i + 1));
        setX1((float) readableArray.getDouble(i + 2));
        setY1((float) readableArray.getDouble(i + 3));
        setX2((float) readableArray.getDouble(i + 4));
        setY2((float) readableArray.getDouble(i + 5));
        return i + 6;
    }

    public void setTimingFunction(int i, float f, float f2, float f3, float f4, int i2) {
        setTimingType(i);
        setStepsType(i2);
        setX1(f);
        setY1(f2);
        setX2(f3);
        setY2(f4);
    }

    public static AnimationInfo toAnimationInfo(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        if (readableArray.size() != 13) {
            LLog.DTHROW();
        }
        AnimationInfo animationInfo = new AnimationInfo();
        animationInfo.setName(readableArray.getString(0));
        animationInfo.setDuration((long) readableArray.getDouble(1));
        int timingFunction = animationInfo.setTimingFunction(readableArray, 2);
        int i = timingFunction + 1;
        animationInfo.setDelay((long) readableArray.getDouble(timingFunction));
        int i2 = i + 1;
        animationInfo.setIterationCount(readableArray.getInt(i) - 1);
        int i3 = i2 + 1;
        animationInfo.setDirection(readableArray.getInt(i2));
        animationInfo.setFillMode(readableArray.getInt(i3));
        animationInfo.setPlayState(readableArray.getInt(i3 + 1));
        return animationInfo;
    }

    public boolean isEqualTo(AnimationInfo animationInfo) {
        return animationInfo != null && isEqualExceptPlayState(animationInfo) && this.playState == animationInfo.playState;
    }

    public boolean isOnlyPlayStateChanged(AnimationInfo animationInfo) {
        return isEqualExceptPlayState(animationInfo) && this.playState != animationInfo.playState;
    }

    public static boolean isDirectionReverse(AnimationInfo animationInfo) {
        return animationInfo.getDirection() == 1 || animationInfo.getDirection() == 3;
    }

    public static boolean isDirectionAlternate(AnimationInfo animationInfo) {
        return animationInfo.getDirection() == 2 || animationInfo.getDirection() == 3;
    }

    public static boolean isFillModeForwards(AnimationInfo animationInfo) {
        return animationInfo.getFillMode() == 1 || animationInfo.getFillMode() == 3;
    }

    public static boolean isFillModeBackwards(AnimationInfo animationInfo) {
        return animationInfo.getFillMode() == 2 || animationInfo.getFillMode() == 3;
    }

    public static void removeDuplicateAnimation(SparseArray<AnimationInfo> sparseArray, int i, int i2) {
        if (sparseArray.indexOfKey(i) < 0 || sparseArray.indexOfKey(i2) < 0) {
            return;
        }
        if (sparseArray.get(i).getOrderIndex() < sparseArray.get(i2).getOrderIndex()) {
            sparseArray.remove(i);
        } else {
            sparseArray.remove(i2);
        }
    }

    private boolean isEqualExceptPlayState(AnimationInfo animationInfo) {
        return animationInfo != null && this.name.equals(animationInfo.name) && this.duration == animationInfo.duration && this.delay == animationInfo.delay && this.property == animationInfo.property && this.timingType == animationInfo.timingType && this.x1 == animationInfo.x1 && this.y1 == animationInfo.y1 && this.x2 == animationInfo.x2 && this.y2 == animationInfo.y2 && this.stepsType == animationInfo.stepsType && this.iterationCount == animationInfo.iterationCount && this.fillMode == animationInfo.fillMode && this.direction == animationInfo.direction && this.layoutAnimationType == animationInfo.layoutAnimationType;
    }
}
