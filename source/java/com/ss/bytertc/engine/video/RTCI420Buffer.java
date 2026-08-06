package com.ss.bytertc.engine.video;

import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class RTCI420Buffer {
    private int width = 0;
    private int height = 0;
    private ByteBuffer dataY = null;
    private ByteBuffer dataU = null;
    private ByteBuffer dataV = null;

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public void setDataY(ByteBuffer dataY) {
        this.dataY = dataY;
    }

    public ByteBuffer getDataY() {
        return this.dataY;
    }

    public void setDataU(ByteBuffer dataU) {
        this.dataU = dataU;
    }

    public ByteBuffer getDataU() {
        return this.dataU;
    }

    public void setDataV(ByteBuffer dataV) {
        this.dataV = dataV;
    }

    public ByteBuffer getDataV() {
        return this.dataV;
    }
}
