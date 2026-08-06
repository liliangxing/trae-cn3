package com.ss.ttm.player;

import android.content.Context;
import android.media.ImageReader;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.utils.OnceConfig;
import com.ss.ttm.utils.ReuseConfig;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class ITTPlayerRef {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void close();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Context getContext();

    protected abstract double getDoubleOption(int key, double dValue);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract float getFloatOption(int key, float dValue);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getIntOption(int key, int dValue);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getLifeId();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long getLongOption(int key, long dValue);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object getObjectOption(int key);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getStringOption(int key);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getSubtitleContent(int queryTime);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract MediaPlayer.TrackInfo[] getTrackInfo();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getType();

    /* JADX INFO: Access modifiers changed from: protected */
    public void invalid() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isValid();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void mouseEvent(int action, int deltaX, int deltaY);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void pause();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int preDemux();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void prepare();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract PipelineLoader prepareMix(PipelineLoadParams params);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void prevClose();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void release();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void reset();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void rotateCamera(float angleX, float angleY);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void seekTo(int msec);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void seekTo(int msec, int flag);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setABRStrategy(ABRStrategy abrStrategy);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setAIBarrageInfo(MaskInfo barrageInfo);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setAudioProcessor(AudioProcessor processor);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setCacheFile(String path, int mode);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setDataSource(IMediaDataSource mediaDataSource);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setDataSource(String path);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setDataSourceFd(int fd);

    protected abstract int setDoubleOption(int key, double value);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int setFloatOption(int key, float value);

    public int setFloatOptionArray(int[] keys, float[] values) {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setFrameMetadataListener(FrameMetadataListener listener);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int setIntOption(int key, int value);

    public int setIntOptionArray(int[] keys, int[] values) {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setLoadControl(LoadControl control);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int setLongOption(int key, long value);

    public int setLongOptionArray(int[] keys, long[] values) {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setLooping(int b);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setMaskInfo(MaskInfo maskInfo);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setMediaTransport(MediaTransport transport);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setNotifyState(long state);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setOnImageAvailableListener(ImageReader.OnImageAvailableListener listener, Handler handler);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setOnScreenshotListener(MediaPlayer.OnScreenshotListener listener);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setStrategyParamsTransport(StrategyParamsTransport transport);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int setStringOption(int key, String value);

    public int setStringOptionArray(int[] keys, String[] values) {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setSubInfo(SubInfo subInfo);

    @Deprecated
    protected abstract void setSurface(Surface surface);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setSurfaceTimeOut(Surface surface, int timeoutMs);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setTraitObject(int type, TraitObject traitObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setVolume(float left, float right);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setWindowClient(TTAVWindowClient client);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setupMediaCodec();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void start();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void stop();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void switchStream(int bitrate, int streamType);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void takeScreenshot();

    public static synchronized ITTPlayerRef create(Context context, TTPlayerClient client, HashMap<Integer, Integer> configParams, OnceConfig config) {
        TTPlayerRef create;
        synchronized (ITTPlayerRef.class) {
            Integer num = 0;
            Integer.valueOf(0);
            OnceConfig onceConfig = config == null ? new OnceConfig((ReuseConfig) null) : config;
            onceConfig.setIntValue(42097, (configParams == null || configParams.get(33) == null) ? 1 : configParams.get(33).intValue());
            onceConfig.setIntValue(42098, (configParams == null || configParams.get(43) == null) ? 0 : configParams.get(43).intValue());
            create = TTPlayerRef.create(client, context, onceConfig);
            if (create != null) {
                if (config == null) {
                    create.mOnceBySelf = onceConfig;
                }
                if (TTPlayerConfiger.isPrintInfo()) {
                    Log.i(TTPlayerConfiger.TAG, "---------->ttplayer on<------------");
                }
            }
            if (create == null) {
                Log.i(TTPlayerConfiger.TAG, TTPlayerConfiger.getValue(16, "not find start service info."));
                if (configParams != null) {
                    num = configParams.get(100);
                }
                if (configParams != null && num != null && num.intValue() == 1) {
                    if (configParams.get(7).intValue() == 0 && configParams.get(10).intValue() < 3) {
                        configParams.put(7, 1);
                    }
                } else if (!TTPlayerConfiger.getValue(7, false) && TTPlayerConfiger.getValue(10, 0) < 3) {
                    TTPlayerConfiger.setValue(7, true);
                }
            }
        }
        return create;
    }

    public static void setGlobalIntOptionForKey(int key, int value) {
        TTPlayerRef.setGlobalIntOptionForKey(key, value);
    }

    public static void setGlobalStringOptionForKey(int key, String value) {
        TTPlayerRef.setGlobalStringOptionForKey(key, value);
    }
}
