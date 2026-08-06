package com.ss.bytertc.engine.video;

/* loaded from: classes7.dex */
public class ExpressionDetectInfo {
    public float age;
    public float angryScore;
    public float arousal;
    public float attractive;
    public float boyProb;
    public float happyScore;
    public float sadScore;
    public float surpriseScore;
    public float valence;

    public ExpressionDetectInfo(final float age, final float boyProb, final float attractive, final float happyScore, final float sadScore, final float angryScore, final float surpriseScore, final float arousal, final float valence) {
        this.age = age;
        this.boyProb = boyProb;
        this.attractive = attractive;
        this.happyScore = happyScore;
        this.sadScore = sadScore;
        this.angryScore = angryScore;
        this.surpriseScore = surpriseScore;
        this.arousal = arousal;
        this.valence = valence;
    }
}
