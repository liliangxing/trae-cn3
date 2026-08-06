package com.lynx.canvas;

import android.view.Surface;

/* loaded from: classes6.dex */
public interface KryptonVideoPlayer {

    /* loaded from: classes6.dex */
    public interface Listener {
        void onCompletion(KryptonVideoPlayer kryptonVideoPlayer);

        boolean onError(KryptonVideoPlayer kryptonVideoPlayer, Object obj);

        void onPaused(KryptonVideoPlayer kryptonVideoPlayer);

        void onPrepared(KryptonVideoPlayer kryptonVideoPlayer);

        void onRenderStart(KryptonVideoPlayer kryptonVideoPlayer);

        void onSeekComplete(KryptonVideoPlayer kryptonVideoPlayer);

        void onStartPlay(KryptonVideoPlayer kryptonVideoPlayer);
    }

    double getCurrentTime();

    int getDuration();

    boolean getLooping();

    int getRotation();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void pause();

    void play();

    void prepare();

    void release();

    void setCurrentTime(double d);

    void setDataSource(String str);

    void setListener(Listener listener);

    void setLooping(boolean z);

    void setSurface(Surface surface);

    void setVolume(double d);
}
