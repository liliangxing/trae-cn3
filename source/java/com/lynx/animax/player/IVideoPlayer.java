package com.lynx.animax.player;

/* loaded from: classes6.dex */
public interface IVideoPlayer {
    void attachAsset(VideoAsset videoAsset);

    void destroy();

    float[] getTransformMatrix();

    void setSurface(int i);

    boolean updateSurface(int i);
}
