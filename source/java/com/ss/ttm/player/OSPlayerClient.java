package com.ss.ttm.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.ss.ttm.player.MediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class OSPlayerClient extends MediaPlayerClient {
    protected MediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    protected MediaPlayer.OnCompletionListener mOnCompletionListener;
    protected MediaPlayer.OnErrorListener mOnErrorListener;
    protected MediaPlayer.OnInfoListener mOnInfoListener;
    protected MediaPlayer.OnPreparedListener mOnPreparedListener;
    protected MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    protected MediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private android.media.MediaPlayer mPlayer;
    private MediaPlayer mWrapper;
    private boolean mIsUsedNewWindowClient = false;
    private TTAVWindowClient mWindowClient = null;

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getType() {
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void preDemux() {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public PipelineLoader prepareMix(PipelineLoadParams params) {
        return null;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prevClose() {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void selectTrack(int index) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setABRStrategy(ABRStrategy abrStrategy) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setAIBarrageInfo(MaskInfo barrageInfo) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(IMediaDataSource dataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setFrameMetadataListener(FrameMetadataListener listener) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setLoadControl(LoadControl control) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setMaskInfo(MaskInfo maskInfo) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setMediaTransport(MediaTransport transport) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnExternInfoListener(MediaPlayer.OnExternInfoListener listener) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnSARChangedListener(MediaPlayer.onSARChangedListener listener) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSubInfo(SubInfo subInfo) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void switchStream(int bitrate, int streamType) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void takeScreenshot(MediaPlayer.OnScreenshotListener listener) {
    }

    public static final synchronized OSPlayerClient create(MediaPlayer wrapper, Context context) {
        OSPlayerClient oSPlayerClient;
        synchronized (OSPlayerClient.class) {
            oSPlayerClient = new OSPlayerClient();
            oSPlayerClient.mPlayer = new android.media.MediaPlayer();
            oSPlayerClient.mWrapper = wrapper;
        }
        return oSPlayerClient;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void release() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.mPlayer = null;
                throw th;
            }
            this.mPlayer = null;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void start() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.start();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void pause() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.pause();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void reset() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.reset();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void stop() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prepare() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prepareAsync() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.prepareAsync();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getCurrentPosition() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.getCurrentPosition();
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoHeight() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.getVideoHeight();
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoWidth() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.getVideoWidth();
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getDuration() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.getDuration();
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDisplay(SurfaceHolder surfaceHolder) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        try {
            mediaPlayer.setDisplay(surfaceHolder);
        } catch (Exception unused) {
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isPlaying() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.isPlaying();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isLooping() {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                return mediaPlayer.isLooping();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setLooping(boolean b) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setLooping(b);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setVolume(float left, float right) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(left, right);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void seekTo(int msec, int flag) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.seekTo(msec);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void seekTo(int msec) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.seekTo(msec);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setScreenOnWhilePlaying(boolean screenOn) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setScreenOnWhilePlaying(screenOn);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener listener) {
        this.mOnBufferingUpdateListener = listener;
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setOnBufferingUpdateListener(new WrapOnBufferingUpdateListener(listener, this.mWrapper));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class WrapOnBufferingUpdateListener implements MediaPlayer.OnBufferingUpdateListener {
        private MediaPlayer.OnBufferingUpdateListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener listener, MediaPlayer wrapper) {
            this.mWrapper = wrapper;
            this.mListener = listener;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(android.media.MediaPlayer mp, int percent) {
            this.mListener.onBufferingUpdate(this.mWrapper, percent);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener listener) {
        this.mOnCompletionListener = listener;
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(new WrapOnCompletionListener(listener, this.mWrapper));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class WrapOnCompletionListener implements MediaPlayer.OnCompletionListener {
        private MediaPlayer.OnCompletionListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnCompletionListener(MediaPlayer.OnCompletionListener listener, MediaPlayer wrapper) {
            this.mWrapper = wrapper;
            this.mListener = listener;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(android.media.MediaPlayer mp) {
            this.mListener.onCompletion(this.mWrapper);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnErrorListener(MediaPlayer.OnErrorListener listener) {
        this.mOnErrorListener = listener;
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setOnErrorListener(new WrapOnErrorListener(listener, this.mWrapper));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class WrapOnErrorListener implements MediaPlayer.OnErrorListener {
        private MediaPlayer.OnErrorListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnErrorListener(MediaPlayer.OnErrorListener listener, MediaPlayer wrapper) {
            this.mWrapper = wrapper;
            this.mListener = listener;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(android.media.MediaPlayer mp, int what, int extra) {
            return this.mListener.onError(this.mWrapper, what, extra);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnInfoListener(MediaPlayer.OnInfoListener listener) {
        this.mOnInfoListener = listener;
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setOnInfoListener(new WrapOnInfoListener(listener, this.mWrapper));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class WrapOnInfoListener implements MediaPlayer.OnInfoListener {
        private MediaPlayer.OnInfoListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnInfoListener(MediaPlayer.OnInfoListener listener, MediaPlayer wrapper) {
            this.mWrapper = wrapper;
            this.mListener = listener;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(android.media.MediaPlayer mp, int what, int extra) {
            return this.mListener.onInfo(this.mWrapper, what, extra);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener listener) {
        this.mOnPreparedListener = listener;
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(new WrapOnPreparedListener(listener, this.mWrapper));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class WrapOnPreparedListener implements MediaPlayer.OnPreparedListener {
        private MediaPlayer.OnPreparedListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnPreparedListener(MediaPlayer.OnPreparedListener listener, MediaPlayer wrapper) {
            this.mListener = listener;
            this.mWrapper = wrapper;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(android.media.MediaPlayer mp) {
            this.mListener.onPrepared(this.mWrapper);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener listener) {
        this.mOnSeekCompleteListener = listener;
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setOnSeekCompleteListener(new WrapOnSeekCompleteListener(listener, this.mWrapper));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class WrapOnSeekCompleteListener implements MediaPlayer.OnSeekCompleteListener {
        private MediaPlayer.OnSeekCompleteListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener listener, MediaPlayer player) {
            this.mListener = listener;
            this.mWrapper = player;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(android.media.MediaPlayer mp) {
            this.mListener.onSeekComplete(this.mWrapper);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener listener) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setOnVideoSizeChangedListener(new WrapOnVideoSizeChangedListener(listener, this.mWrapper));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class WrapOnVideoSizeChangedListener implements MediaPlayer.OnVideoSizeChangedListener {
        private MediaPlayer.OnVideoSizeChangedListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener listener, MediaPlayer player) {
            this.mListener = listener;
            this.mWrapper = player;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(android.media.MediaPlayer mp, int width, int height) {
            this.mListener.onVideoSizeChanged(this.mWrapper, width, height);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        this.mPlayer.setDataSource(context, uri, headers);
        _doSetVideoScalingMode();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(String path) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        this.mPlayer.setDataSource(path);
        _doSetVideoScalingMode();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(FileDescriptor fd, long offset, long length) throws IllegalStateException, IllegalArgumentException, IOException {
        this.mPlayer.setDataSource(fd, offset, length);
        _doSetVideoScalingMode();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        this.mPlayer.setDataSource(context, uri);
        _doSetVideoScalingMode();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSurface(Surface surface) {
        this.mPlayer.setSurface(surface);
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setWindowClient(TTAVWindowClient client) {
        this.mIsUsedNewWindowClient = true;
        _doSetVideoScalingMode();
        TTAVWindowClient tTAVWindowClient = this.mWindowClient;
        if (tTAVWindowClient != null && tTAVWindowClient != client) {
            tTAVWindowClient.unbindMediaClient(this);
        }
        if (client != null) {
            client.bindMediaClient(this);
        }
        this.mWindowClient = client;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSurfaceTimeOut(Surface surface, int timeoutMs) {
        setSurface(surface);
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setWakeMode(Context context, int mode) {
        this.mPlayer.setWakeMode(context, mode);
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void releaseAsync() {
        new Thread(new Runnable() { // from class: com.ss.ttm.player.OSPlayerClient.1
            @Override // java.lang.Runnable
            public void run() {
                OSPlayerClient.this.release();
            }
        }).start();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setPlaybackParams(PlaybackParams params) {
        android.media.PlaybackParams playbackParams = new android.media.PlaybackParams();
        float speed = params.getSpeed();
        if (speed > 0.0f) {
            playbackParams.setSpeed(speed);
        }
        int audioFallbackMode = params.getAudioFallbackMode();
        if (audioFallbackMode >= 0) {
            playbackParams.setAudioFallbackMode(audioFallbackMode);
        }
        float pitch = params.getPitch();
        if (pitch > 0.0f) {
            playbackParams.setPitch(pitch);
        }
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setPlaybackParams(playbackParams);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void deselectTrack(int index) {
        if (this.mPlayer != null) {
            try {
                this.mPlayer.deselectTrack(index);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getSelectedTrack(int trackType) {
        android.media.MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return -1;
        }
        try {
            return mediaPlayer.getSelectedTrack(trackType);
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        MediaPlayer.TrackInfo[] trackInfoArr;
        if (this.mPlayer != null) {
            try {
                trackInfoArr = this.mPlayer.getTrackInfo();
            } catch (Exception unused) {
                trackInfoArr = null;
            }
            if (trackInfoArr != null) {
                MediaPlayer.TrackInfo[] trackInfoArr2 = new MediaPlayer.TrackInfo[trackInfoArr.length];
                int length = trackInfoArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    trackInfoArr2[i2] = new MediaPlayer.TrackInfo(trackInfoArr[i]);
                    i++;
                    i2++;
                }
            }
        }
        return null;
    }

    private void _doSetVideoScalingMode() {
        if (this.mIsUsedNewWindowClient) {
            this.mPlayer.setVideoScalingMode(2);
        }
    }
}
