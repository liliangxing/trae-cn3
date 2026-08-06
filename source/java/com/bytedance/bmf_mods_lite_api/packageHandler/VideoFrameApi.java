package com.bytedance.bmf_mods_lite_api.packageHandler;

/* loaded from: classes3.dex */
public interface VideoFrameApi {
    default int clearData() {
        return -1;
    }

    default long getNativePtr() {
        return 0L;
    }

    default int getVideoFrameFormat() {
        return -1;
    }

    default int getVideoFrameHeight() {
        return -1;
    }

    default int getVideoFrameTexture() {
        return -1;
    }

    default int getVideoFrameWidth() {
        return -1;
    }

    default void release() {
    }

    default int setVideoFrame(int textureId, int mem_type, int width, int height, int format) {
        return -1;
    }
}
