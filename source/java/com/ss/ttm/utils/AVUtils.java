package com.ss.ttm.utils;

/* loaded from: classes7.dex */
public class AVUtils {

    /* loaded from: classes7.dex */
    public static class ScaleInfo {
        public int h;
        public int w;
        public int x;
        public int y;
    }

    public static final ScaleInfo getScaleInfoFromSize(float video_width, float video_height, float screen_width, float screen_height) {
        ScaleInfo scaleInfo = new ScaleInfo();
        float f = video_width / video_height;
        scaleInfo.w = (int) screen_width;
        scaleInfo.h = (int) (screen_width / f);
        if (scaleInfo.h < screen_height) {
            scaleInfo.h = (int) screen_height;
            scaleInfo.w = (int) (f * screen_height);
        }
        scaleInfo.y = ((int) (scaleInfo.h - screen_height)) >> 1;
        scaleInfo.x = ((int) (scaleInfo.w - screen_width)) >> 1;
        if (scaleInfo.h > screen_height) {
            scaleInfo.y = 0 - scaleInfo.y;
        }
        if (scaleInfo.w > screen_width) {
            scaleInfo.x = 0 - scaleInfo.x;
        }
        return scaleInfo;
    }
}
