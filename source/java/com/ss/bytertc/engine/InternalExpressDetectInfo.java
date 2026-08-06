package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalExpressDetectInfo {
    public float age;
    public float angryScore;
    public float arousal;
    public float attractive;
    public float boyProb;
    public float happyScore;
    public float sadScore;
    public float surpriseScore;
    public float valence;

    public InternalExpressDetectInfo(final float age, final float boyProb, final float attractive, final float happyScore, final float sadScore, final float angryScore, final float surpriseScore, final float arousal, final float valence) {
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

    private static InternalExpressDetectInfo create(final float age, final float boyProb, final float attractive, final float happyScore, final float sadScore, final float angryScore, final float surpriseScore, final float arousal, final float valence) {
        return new InternalExpressDetectInfo(age, boyProb, attractive, happyScore, sadScore, angryScore, surpriseScore, arousal, valence);
    }
}
