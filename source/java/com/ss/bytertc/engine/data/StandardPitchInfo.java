package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class StandardPitchInfo {
    public int duration;
    public int pitch;
    public int startTime;

    public StandardPitchInfo(int startTime, int duration, int pitch) {
        this.startTime = startTime;
        this.duration = duration;
        this.pitch = pitch;
    }

    private static StandardPitchInfo create(int startTime, int duration, int pitch) {
        return new StandardPitchInfo(startTime, duration, pitch);
    }
}
