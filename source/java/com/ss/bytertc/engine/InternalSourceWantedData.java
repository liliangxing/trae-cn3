package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalSourceWantedData {
    public int frameRate;
    public int height;
    public int width;

    public InternalSourceWantedData(int width, int height, int frameRate) {
        this.width = width;
        this.height = height;
        this.frameRate = frameRate;
    }

    private static InternalSourceWantedData create(int width, int height, int frameRate) {
        return new InternalSourceWantedData(width, height, frameRate);
    }

    public String toString() {
        return "InternalSourceWantedData{width='" + this.width + "', height='" + this.height + "', frameRate='" + this.frameRate + "'}";
    }
}
