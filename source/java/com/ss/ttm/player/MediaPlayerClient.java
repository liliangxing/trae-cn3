package com.ss.ttm.player;

import android.content.Context;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.ss.ttm.player.MediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class MediaPlayerClient {
    public static final int IsAudioVoiceWaitTimeout = 1;
    public static final int IsBuffering = 0;
    public static final int MAX_LOG_LINES = 40;

    public abstract void deselectTrack(int index);

    public abstract int getCurrentPosition();

    public String getDataSource() {
        return null;
    }

    public double getDoubleOption(int key, double dValue) {
        return dValue;
    }

    public abstract int getDuration();

    public float getFloatOption(int key, float dValue) {
        return dValue;
    }

    public int getIntOption(int key, int dValue) {
        return dValue;
    }

    public long getLongOption(int key, long dValue) {
        return dValue;
    }

    public Object getObjectOption(int key) {
        return null;
    }

    public abstract int getSelectedTrack(int trackType);

    public String getStringOption(int key) {
        return null;
    }

    public String getSubtitleContent(int queryTime) {
        return null;
    }

    public abstract MediaPlayer.TrackInfo[] getTrackInfo();

    public abstract int getType();

    public abstract int getVideoHeight();

    public int getVideoType() {
        return 0;
    }

    public abstract int getVideoWidth();

    public abstract boolean isLooping();

    public boolean isMute() {
        return false;
    }

    public abstract boolean isPlaying();

    public void mouseEvent(int action, int deltaX, int deltaY) {
    }

    public abstract void pause();

    public abstract void preDemux();

    public abstract void prepare();

    public abstract void prepareAsync();

    public abstract PipelineLoader prepareMix(PipelineLoadParams params);

    @Deprecated
    public abstract void prevClose();

    public abstract void release();

    public abstract void releaseAsync();

    public abstract void reset();

    public abstract void seekTo(int msec);

    public void seekTo(int msec, int flag) {
    }

    public abstract void selectTrack(int index);

    public void setABRStrategy(ABRStrategy abrStrategy) {
    }

    public void setAIBarrageInfo(MaskInfo barrageInfo) {
    }

    public void setAudioProcessor(AudioProcessor processor) {
    }

    public void setCacheFile(String path, int mode) {
    }

    public abstract void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(IMediaDataSource dataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(FileDescriptor fd, long offset, long length) throws IllegalStateException, IllegalArgumentException, IOException;

    public abstract void setDataSource(String path) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDisplay(SurfaceHolder surfaceHolder);

    public int setDoubleOption(int key, double dValue) {
        return -1;
    }

    public int setFloatOption(int key, float dValue) {
        return -1;
    }

    public int setFloatOptionArray(int[] keys, float[] values) {
        return -1;
    }

    public abstract void setFrameMetadataListener(FrameMetadataListener listener);

    public int setIntOptionArray(int[] keys, int[] values) {
        return -1;
    }

    public void setIsMute(boolean isMute) {
    }

    public void setLoadControl(LoadControl control) {
    }

    public int setLongOption(int key, long value) {
        return -1;
    }

    public int setLongOptionArray(int[] keys, long[] values) {
        return -1;
    }

    public abstract void setLooping(boolean b);

    public void setMaskInfo(MaskInfo maskInfo) {
    }

    public abstract void setMediaTransport(MediaTransport transport);

    public abstract void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener listener);

    public abstract void setOnCompletionListener(MediaPlayer.OnCompletionListener listener);

    public abstract void setOnErrorListener(MediaPlayer.OnErrorListener listener);

    public abstract void setOnExternInfoListener(MediaPlayer.OnExternInfoListener listener);

    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener listener, Handler handler) {
    }

    public abstract void setOnInfoListener(MediaPlayer.OnInfoListener listener);

    public void setOnLogListener(MediaPlayer.OnLogListener listener) {
    }

    public abstract void setOnPreparedListener(MediaPlayer.OnPreparedListener listener);

    public abstract void setOnSARChangedListener(MediaPlayer.onSARChangedListener listener);

    public abstract void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener listener);

    public abstract void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener listener);

    public void setPanoVideoControlModel(int model) {
    }

    public abstract void setPlaybackParams(PlaybackParams params);

    public abstract void setScreenOnWhilePlaying(boolean screenOn);

    public void setStrategyParamsTransport(StrategyParamsTransport transport) {
    }

    public int setStringOption(int key, String value) {
        return -1;
    }

    public int setStringOptionArray(int[] keys, String[] values) {
        return -1;
    }

    public void setSubInfo(SubInfo subInfo) {
    }

    public abstract void setSurface(Surface surfave);

    public abstract void setSurfaceTimeOut(Surface surface, int timeoutMs);

    public void setTraitObject(int type, TraitObject traitObject) {
    }

    public abstract void setVolume(float left, float right);

    public abstract void setWakeMode(Context context, int mode);

    public void setupMediaCodec() {
    }

    public abstract void start();

    public abstract void stop();

    public abstract void switchStream(int bitrate, int streamType);

    public abstract void takeScreenshot(MediaPlayer.OnScreenshotListener listener);

    public void setWindowClient(TTAVWindowClient client) {
        throw new RuntimeException("Not implements");
    }

    public void rotateCamera(float angleX, float angleY) {
        Log.i(TTPlayerConfiger.TAG, "<MediaPlayerClient.java,rotateCamera,55>rotateCamera is not implemented");
    }

    public int setIntOption(int key, int value) {
        Log.i(TTPlayerConfiger.TAG, "<MediaPlayerClient.java,setIntOption,65>set os player is not inval");
        return -1;
    }
}
