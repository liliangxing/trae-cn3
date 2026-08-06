package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class SingScoringRealtimeInfo {
    public int averageScore;
    public int currentPosition;
    public int sentenceIndex;
    public int sentenceScore;
    public int standardPitch;
    public int totalScore;
    public int userPitch;

    public SingScoringRealtimeInfo(int currentPosition, int userPitch, int standardPitch, int sentenceIndex, int sentenceScore, int totalScore, int averageScore) {
        this.currentPosition = currentPosition;
        this.userPitch = userPitch;
        this.standardPitch = standardPitch;
        this.sentenceIndex = sentenceIndex;
        this.sentenceScore = sentenceScore;
        this.totalScore = totalScore;
        this.averageScore = averageScore;
    }

    private static SingScoringRealtimeInfo create(int currentPosition, int userPitch, int standardPitch, int sentenceIndex, int sentenceScore, int totalScore, int averageScore) {
        return new SingScoringRealtimeInfo(currentPosition, userPitch, standardPitch, sentenceIndex, sentenceScore, totalScore, averageScore);
    }

    public String toString() {
        return "SingScoringRealtimeInfo{currentPosition='" + this.currentPosition + "'userPitch='" + this.userPitch + "'standardPitch='" + this.standardPitch + "'sentenceIndex='" + this.sentenceIndex + "'sentenceScore='" + this.sentenceScore + "'totalScore='" + this.totalScore + "'averageScore='" + this.averageScore + "'}";
    }
}
