package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.ViewGroup;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface TTAVPlayerView {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface LifeCycleCallback {
        void onLoad(TTAVWindowClient client);

        default void onNewSurfaceAvailable() {
        }
    }

    void attachToParent(ViewGroup viewGroup);

    void attachToParent(ViewGroup viewGroup, ViewGroup.LayoutParams params);

    void detachFromParent();

    Rect getSurfacePosition();

    Size getSurfaceSize();

    int getViewHeight();

    int getViewWidth();

    int getVisibility();

    boolean isSurfaceAvailable();

    boolean isSurfaceView();

    void setLayoutParams(ViewGroup.LayoutParams params);

    void setLifeCycleCallback(LifeCycleCallback callback);

    void setScaleType(int scaleType, float cropWidthLimit, float cropHeightLimit);

    void setVisibility(int visibility);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Factory {
        public static TTAVPlayerView create(Context context, LifeCycleCallback callback, int viewType, float videoAspect, int scaleType) {
            return new TTPlayerView(context, callback, viewType, videoAspect, scaleType);
        }
    }
}
