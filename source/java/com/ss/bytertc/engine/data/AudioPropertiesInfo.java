package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class AudioPropertiesInfo {
    private static final int SPECTRUM_SIZE = 257;
    public int linearVolume;
    public int nonlinearVolume;
    public float[] spectrum;
    public int vad;
    public double voicePitch = 0.0d;

    public AudioPropertiesInfo(int linearVolume, int nonlinearVolume, float[] spectrum, int vad) {
        float[] fArr = new float[257];
        this.spectrum = fArr;
        this.linearVolume = linearVolume;
        this.nonlinearVolume = nonlinearVolume;
        System.arraycopy(spectrum, 0, fArr, 0, 257);
        this.vad = vad;
    }

    public String toString() {
        return "AudioPropertiesInfo{linearVolume='" + this.linearVolume + "'nonlinearVolume='" + this.nonlinearVolume + "'voicePitch='" + this.voicePitch + "'}";
    }
}
