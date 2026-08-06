package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalSourceWantedData;

/* loaded from: classes7.dex */
public class SourceWantedData {
    public int frameRate;
    public int height;
    public int width;

    public SourceWantedData() {
    }

    public SourceWantedData(InternalSourceWantedData data) {
        this.width = data.width;
        this.height = data.height;
        this.frameRate = data.frameRate;
    }

    public String toString() {
        return "SourceWantedData{width='" + this.width + "', height='" + this.height + "', frameRate='" + this.frameRate + "'}";
    }
}
