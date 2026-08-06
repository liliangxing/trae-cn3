package com.lynx.animax.player;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class VideoRawData {
    private ByteBuffer mFrameBuffer;
    private ArrayList<Integer> mKeyFrames = new ArrayList<>();
    private ArrayList<FrameInfo> mFrameInfos = new ArrayList<>();

    public ByteBuffer getFrameBuffer() {
        return this.mFrameBuffer;
    }

    public void setFrameBuffer(ByteBuffer byteBuffer) {
        this.mFrameBuffer = byteBuffer;
    }

    public ArrayList<Integer> getKeyFrames() {
        return this.mKeyFrames;
    }

    public ArrayList<FrameInfo> getFrameInfos() {
        return this.mFrameInfos;
    }
}
