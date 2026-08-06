package com.lynx.canvas.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonVideoPlayer;

/* loaded from: classes6.dex */
public class KryptonDefaultVideoPlayer implements KryptonVideoPlayer, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnSeekCompleteListener {
    private static final String TAG = "Player default";
    private Context mContext;
    private double mCurrentTimeForPause;
    private int mDuration;
    private int mHeight;
    private final MediaPlayer mPlayer;
    private KryptonVideoPlayer.Listener mPlayerListener;
    private int mRotation;
    private int mWidth;

    public KryptonDefaultVideoPlayer(Context context) {
        this.mContext = context;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mPlayer = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnSeekCompleteListener(this);
        mediaPlayer.setOnInfoListener(this);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setListener(KryptonVideoPlayer.Listener listener) {
        this.mPlayerListener = listener;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setDataSource(String str) {
        try {
            this.mPlayer.reset();
            this.mCurrentTimeForPause = 0.0d;
            try {
                this.mPlayer.setDataSource(this.mContext, Uri.parse(str));
            } catch (Exception e) {
                KryptonLLog.e(TAG, "setDataSource exception: " + e.getMessage());
                callbackWithErrorMessage("setDataSource exception:" + e.getMessage());
            }
        } catch (Exception e2) {
            KryptonLLog.e(TAG, "reset exception: " + e2.getMessage());
            callbackWithErrorMessage("reset exception:" + e2.getMessage());
        }
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void prepare() {
        try {
            this.mPlayer.prepareAsync();
        } catch (IllegalStateException e) {
            KryptonLLog.e(TAG, "prepareAsync exception: " + e.getMessage());
            callbackWithErrorMessage("prepareAsync exception:" + e.getMessage());
        }
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public int getVideoWidth() {
        return this.mWidth;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public int getVideoHeight() {
        return this.mHeight;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public int getDuration() {
        return this.mDuration;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public int getRotation() {
        return this.mRotation;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setSurface(Surface surface) {
        try {
            this.mPlayer.setSurface(surface);
        } catch (IllegalStateException e) {
            KryptonLLog.e(TAG, "setSurface exception:" + e.getMessage());
        }
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void play() {
        try {
            this.mPlayer.start();
            KryptonVideoPlayer.Listener listener = this.mPlayerListener;
            if (listener != null) {
                listener.onStartPlay(this);
            }
        } catch (IllegalStateException e) {
            KryptonLLog.e(TAG, "play exception:" + e.getMessage());
        }
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void pause() {
        try {
            this.mCurrentTimeForPause = this.mPlayer.getCurrentPosition() / 1000.0d;
            this.mPlayer.pause();
            KryptonVideoPlayer.Listener listener = this.mPlayerListener;
            if (listener != null) {
                listener.onPaused(this);
            }
        } catch (IllegalStateException e) {
            KryptonLLog.e(TAG, "pause exception:" + e.getMessage());
        }
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void release() {
        try {
            this.mPlayer.release();
        } catch (Exception e) {
            KryptonLLog.e(TAG, "release exception:" + e.getMessage());
        }
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public boolean isPlaying() {
        return this.mPlayer.isPlaying();
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setLooping(boolean z) {
        this.mPlayer.setLooping(z);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public boolean getLooping() {
        return this.mPlayer.isLooping();
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setCurrentTime(double d) {
        int i = (int) (d * 1000.0d);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mPlayer.seekTo(i, 3);
            } else {
                this.mPlayer.seekTo(i);
            }
        } catch (Exception e) {
            KryptonLLog.e(TAG, "seekTo exception:" + e.getMessage());
        }
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public double getCurrentTime() {
        if (!this.mPlayer.isPlaying()) {
            return this.mCurrentTimeForPause;
        }
        return this.mPlayer.getCurrentPosition() / 1000.0d;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setVolume(double d) {
        float f = (float) d;
        this.mPlayer.setVolume(f, f);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        KryptonVideoPlayer.Listener listener = this.mPlayerListener;
        if (listener != null) {
            listener.onCompletion(this);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        KryptonLLog.i(TAG, "onError what " + i + " extra " + i2);
        callbackWithErrorMessage("what: " + i + ", extra: " + i2);
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        KryptonLLog.i(TAG, "onPrepared");
        if (this.mPlayerListener != null) {
            this.mWidth = this.mPlayer.getVideoWidth();
            this.mHeight = this.mPlayer.getVideoHeight();
            this.mDuration = this.mPlayer.getDuration();
            this.mPlayerListener.onPrepared(this);
        }
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        KryptonLLog.i(TAG, "onInfo what " + i + " extra " + i2);
        if (i != 3) {
            return false;
        }
        KryptonVideoPlayer.Listener listener = this.mPlayerListener;
        if (listener == null) {
            return true;
        }
        listener.onRenderStart(this);
        return true;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        KryptonVideoPlayer.Listener listener = this.mPlayerListener;
        if (listener != null) {
            listener.onSeekComplete(this);
        }
    }

    private void callbackWithErrorMessage(String str) {
        KryptonVideoPlayer.Listener listener = this.mPlayerListener;
        if (listener != null) {
            listener.onError(this, new Error(str));
        }
    }
}
