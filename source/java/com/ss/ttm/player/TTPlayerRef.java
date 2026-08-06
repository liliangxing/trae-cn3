package com.ss.ttm.player;

import android.content.Context;
import android.media.ImageReader;
import android.os.Handler;
import android.os.RemoteException;
import android.view.Surface;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.OnceConfig;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TTPlayerRef extends ITTPlayerRef implements IPlayerNotifyer {
    private static final String TAG = "TTPlayerRef";
    private static String mAppPath;
    private static String mLoadErr;
    private static boolean mLoadSoSuccess;
    private TTPlayerClient mClient;
    private final Context mContext;
    private long mId = System.currentTimeMillis();
    OnceConfig mOnceBySelf = null;
    private TTPlayer mPlayer;

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int getType() {
        return 1;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setCacheFile(String path, int mode) {
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public Context getContext() {
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public boolean isValid() {
        return this.mPlayer != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public int getLifeId() {
        return this.mPlayer.getIntOption(35, -1);
    }

    public static final synchronized TTPlayerRef create(TTPlayerClient client, Context context, OnceConfig config) {
        TTPlayerRef tTPlayerRef;
        RuntimeException runtimeException;
        synchronized (TTPlayerRef.class) {
            if (mAppPath == null) {
                mAppPath = TTPlayerConfiger.getAppFileCachePath(context);
                try {
                    if (TTPlayer.getAppPath() == null) {
                        TTPlayer.setTempFileDir(mAppPath);
                    }
                } catch (UnsatisfiedLinkError e) {
                    mLoadErr = e.getMessage();
                }
            }
            if (mLoadErr != null) {
                throw new UnsatisfiedLinkError(mLoadErr);
            }
            initGlobalOptions();
            tTPlayerRef = new TTPlayerRef(context);
            tTPlayerRef.mClient = client;
            try {
                TTPlayer tTPlayer = new TTPlayer(context, tTPlayerRef.mId, config);
                tTPlayerRef.mPlayer = tTPlayer;
                tTPlayer.setNotifyer(tTPlayerRef);
            } finally {
            }
        }
        return tTPlayerRef;
    }

    public static synchronized void initGlobalOptions() {
        synchronized (TTPlayerRef.class) {
            if (!mLoadSoSuccess) {
                TTPlayer.setGlobalIntOptionForKey(1015, TTPlayerConfiger.getValue(31, 0));
                TTPlayer.setGlobalIntOptionForKey(1016, TTPlayerConfiger.getValue(32, 0));
                TTPlayer.setGlobalIntOptionForKey(1356, TTPlayerConfiger.getValue(44, 0));
                TTPlayer.setGlobalIntOptionForKey(1357, TTPlayerConfiger.getValue(45, 0));
                TTPlayer.setGlobalIntOptionForKey(1358, TTPlayerConfiger.getValue(46, 0));
                TTPlayer.setGlobalIntOptionForKey(40002, TTPlayerConfiger.getValue(49, 0));
                TTPlayer.setGlobalIntOptionForKey(MediaPlayer.MEDIA_PLAYER_OPTION_GS_AUDIO_ADAPTER_MAX_QUEUE_SIZE, TTPlayerConfiger.getValue(52, 0));
                TTPlayer.setGlobalIntOptionForKey(MediaPlayer.MEDIA_PLAYER_OPTION_GS_AUDIO_ADAPTER_MAX_USE_COUNT, TTPlayerConfiger.getValue(53, 0));
                TTPlayer.setGlobalIntOptionForKey(40007, TTPlayerConfiger.getValue(54, 0));
                TTPlayer.setGlobalIntOptionForKey(40013, TTPlayerConfiger.getValue(55, 0));
                TTPlayer.setGlobalIntOptionForKey(40014, TTPlayerConfiger.getValue(56, 0));
                TTPlayer.setGlobalIntOptionForKey(40015, TTPlayerConfiger.getValue(57, 0));
                TTPlayer.setGlobalIntOptionForKey(40016, TTPlayerConfiger.getValue(58, 0));
                TTPlayer.setGlobalIntOptionForKey(40042, TTPlayerConfiger.getValue(89, 0));
                TTPlayer.setGlobalIntOptionForKey(40037, TTPlayerConfiger.getValue(81, 0));
                TTPlayer.setGlobalIntOptionForKey(40038, TTPlayerConfiger.getValue(82, 0));
                TTPlayer.setGlobalIntOptionForKey(40039, TTPlayerConfiger.getValue(84, 0));
                TTPlayer.setGlobalIntOptionForKey(40040, TTPlayerConfiger.getValue(85, 0));
                TTPlayer.setGlobalIntOptionForKey(40041, TTPlayerConfiger.getValue(86, 0));
                TTPlayer.setGlobalIntOptionForKey(40055, TTPlayerConfiger.getValue(90, 0));
                TTPlayer.setGlobalIntOptionForKey(40056, TTPlayerConfiger.getValue(91, 0));
                TTPlayer.setGlobalIntOptionForKey(40017, TTPlayerConfiger.getValue(59, 0));
                TTPlayer.setGlobalIntOptionForKey(40018, TTPlayerConfiger.getValue(60, 0));
                TTPlayer.setGlobalIntOptionForKey(40019, TTPlayerConfiger.getValue(61, 0));
                TTPlayer.setGlobalIntOptionForKey(40020, TTPlayerConfiger.getValue(62, 0));
                TTPlayer.setGlobalIntOptionForKey(40021, TTPlayerConfiger.getValue(63, 0));
                TTPlayer.setGlobalIntOptionForKey(40022, TTPlayerConfiger.getValue(64, 0));
                TTPlayer.setGlobalIntOptionForKey(40023, TTPlayerConfiger.getValue(65, 0));
                TTPlayer.setGlobalIntOptionForKey(40024, TTPlayerConfiger.getValue(66, 0));
                TTPlayer.setGlobalIntOptionForKey(40025, TTPlayerConfiger.getValue(67, 0));
                TTPlayer.setGlobalIntOptionForKey(40026, TTPlayerConfiger.getValue(68, 0));
                TTPlayer.setGlobalIntOptionForKey(40027, TTPlayerConfiger.getValue(69, 0));
                TTPlayer.setGlobalIntOptionForKey(40028, TTPlayerConfiger.getValue(70, 0));
                TTPlayer.setGlobalIntOptionForKey(40029, TTPlayerConfiger.getValue(71, 0));
                TTPlayer.setGlobalIntOptionForKey(40030, TTPlayerConfiger.getValue(72, 0));
                TTPlayer.setGlobalIntOptionForKey(40031, TTPlayerConfiger.getValue(73, 0));
                TTPlayer.setGlobalIntOptionForKey(40035, TTPlayerConfiger.getValue(79, 0));
                TTPlayer.setGlobalIntOptionForKey(40036, TTPlayerConfiger.getValue(80, 0));
                TTPlayer.setGlobalIntOptionForKey(40034, TTPlayerConfiger.getValue(75, 0));
                TTPlayer.setGlobalStringOptionForKey(40050, TTPlayerConfiger.getValue(77, ""));
                TTPlayer.setGlobalIntOptionForKey(40053, TTPlayerConfiger.getValue(87, 0));
                TTPlayer.setGlobalIntOptionForKey(40054, TTPlayerConfiger.getValue(88, 0));
                TTPlayer.setGlobalIntOptionForKey(40060, TTPlayerConfiger.getValue(93, 0));
            }
            mLoadSoSuccess = true;
        }
    }

    public static void setGlobalStringOptionForKey(int key, String value) {
        if (key == 40050) {
            TTPlayerConfiger.setValue(77, value);
        }
        if (mLoadSoSuccess) {
            TTPlayer.setGlobalStringOptionForKey(key, value);
        }
    }

    public static void setGlobalIntOptionForKey(int key, int value) {
        if (key == 1015) {
            TTPlayerConfiger.setValue(31, value);
        } else if (key == 1016) {
            TTPlayerConfiger.setValue(32, value);
        } else if (key == 1306) {
            TTPlayerConfiger.setValue(52, value);
        } else if (key == 1307) {
            TTPlayerConfiger.setValue(53, value);
        } else if (key == 40002) {
            TTPlayerConfiger.setValue(49, value);
        } else if (key == 40007) {
            TTPlayerConfiger.setValue(54, value);
        } else if (key != 40060) {
            switch (key) {
                case 1356:
                    TTPlayerConfiger.setValue(44, value);
                    break;
                case 1357:
                    TTPlayerConfiger.setValue(45, value);
                    break;
                case 1358:
                    TTPlayerConfiger.setValue(46, value);
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_GS_AUDIOTRACK_POOL_SIZE /* 1359 */:
                    TTPlayerConfiger.setValue(47, value);
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_GS_AUDIOTRACK_POOL_MAX_USED_COUNT /* 1360 */:
                    TTPlayerConfiger.setValue(50, value);
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_GS_AUDIOTRACK_POOL_SAMPLES_CHECK /* 1361 */:
                    TTPlayerConfiger.setValue(51, value);
                    break;
                default:
                    switch (key) {
                        case 40013:
                            TTPlayerConfiger.setValue(55, value);
                            break;
                        case 40014:
                            TTPlayerConfiger.setValue(56, value);
                            break;
                        case 40015:
                            TTPlayerConfiger.setValue(57, value);
                            break;
                        case 40016:
                            TTPlayerConfiger.setValue(58, value);
                            break;
                        case 40017:
                            TTPlayerConfiger.setValue(59, value);
                            break;
                        case 40018:
                            TTPlayerConfiger.setValue(60, value);
                            break;
                        case 40019:
                            TTPlayerConfiger.setValue(61, value);
                            break;
                        case 40020:
                            TTPlayerConfiger.setValue(62, value);
                            break;
                        case 40021:
                            TTPlayerConfiger.setValue(63, value);
                            break;
                        case 40022:
                            TTPlayerConfiger.setValue(64, value);
                            break;
                        case 40023:
                            TTPlayerConfiger.setValue(65, value);
                            break;
                        case 40024:
                            TTPlayerConfiger.setValue(66, value);
                            break;
                        case 40025:
                            TTPlayerConfiger.setValue(67, value);
                            break;
                        case 40026:
                            TTPlayerConfiger.setValue(68, value);
                            break;
                        case 40027:
                            TTPlayerConfiger.setValue(69, value);
                            break;
                        case 40028:
                            TTPlayerConfiger.setValue(70, value);
                            break;
                        case 40029:
                            TTPlayerConfiger.setValue(71, value);
                            break;
                        case 40030:
                            TTPlayerConfiger.setValue(72, value);
                            break;
                        case 40031:
                            TTPlayerConfiger.setValue(73, value);
                            break;
                        default:
                            switch (key) {
                                case 40034:
                                    TTPlayerConfiger.setValue(75, value);
                                    break;
                                case 40035:
                                    TTPlayerConfiger.setValue(79, value);
                                    break;
                                case 40036:
                                    TTPlayerConfiger.setValue(80, value);
                                    break;
                                case 40037:
                                    TTPlayerConfiger.setValue(81, value);
                                    break;
                                case 40038:
                                    TTPlayerConfiger.setValue(82, value);
                                    break;
                                case 40039:
                                    TTPlayerConfiger.setValue(84, value);
                                    break;
                                case 40040:
                                    TTPlayerConfiger.setValue(85, value);
                                    break;
                                case 40041:
                                    TTPlayerConfiger.setValue(86, value);
                                    break;
                                case 40042:
                                    TTPlayerConfiger.setValue(89, value);
                                    break;
                                default:
                                    switch (key) {
                                        case 40051:
                                            TTPlayerConfiger.setValue(78, value);
                                            break;
                                        case 40052:
                                            TTPlayerConfiger.setValue(83, value);
                                            break;
                                        case 40053:
                                            TTPlayerConfiger.setValue(87, value);
                                            break;
                                        case 40054:
                                            TTPlayerConfiger.setValue(88, value);
                                            break;
                                        case 40055:
                                            TTPlayerConfiger.setValue(90, value);
                                            break;
                                        case 40056:
                                            TTPlayerConfiger.setValue(91, value);
                                            break;
                                        case 40057:
                                            TTPlayerConfiger.setValue(92, value);
                                            break;
                                    }
                            }
                    }
            }
        } else {
            TTPlayerConfiger.setValue(93, value);
        }
        if (mLoadSoSuccess) {
            TTPlayer.setGlobalIntOptionForKey(key, value);
        }
    }

    public TTPlayerRef(Context context) {
        this.mContext = context;
    }

    public TTPlayer getPlayer() {
        return this.mPlayer;
    }

    public long getNativeObject() {
        return this.mPlayer.getNativePlayer();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void prevClose() {
        this.mPlayer.prevClose();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void close() {
        this.mPlayer.close();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void release() {
        OnceConfig onceConfig = this.mOnceBySelf;
        if (onceConfig != null) {
            onceConfig.release();
            this.mOnceBySelf = null;
        }
        TTPlayer tTPlayer = this.mPlayer;
        this.mPlayer = null;
        String str = TAG;
        AVLogger.m239d(str, "release native player start");
        tTPlayer.release();
        AVLogger.m239d(str, "release native player end");
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void start() {
        this.mPlayer.start();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void pause() {
        this.mPlayer.pause();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int preDemux() {
        return this.mPlayer.preDemux();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public PipelineLoader prepareMix(PipelineLoadParams params) {
        return this.mPlayer.prepareMix(params);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void reset() {
        this.mPlayer.reset();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void stop() {
        this.mPlayer.stop();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void prepare() {
        this.mPlayer.prepare();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setDataSource(String path) {
        this.mPlayer.setDataSource(path);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setDataSourceFd(int fd) {
        this.mPlayer.setDataSourceFd(fd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setDataSource(IMediaDataSource mediaDataSource) {
        this.mPlayer.setDataSource(mediaDataSource);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setLooping(int b) {
        this.mPlayer.setLooping(b);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setVolume(float left, float right) {
        this.mPlayer.setVolume(left, right);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void mouseEvent(int newAction, int deltaX, int deltaY) {
        this.mPlayer.mouseEvent(newAction, deltaX, deltaY);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void rotateCamera(float angleX, float angleY) {
        this.mPlayer.rotateCamera(angleX, angleY);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void seekTo(int msec) {
        this.mPlayer.seekTo(msec);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void seekTo(int msec, int flag) {
        this.mPlayer.seekTo(msec, flag);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int getIntOption(int key, int dValue) {
        return this.mPlayer.getIntOption(key, dValue);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setSurface(Surface surface) {
        this.mPlayer.setVideoSurface(surface);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setSurfaceTimeOut(Surface surface, int timeoutMs) {
        this.mPlayer.setVideoSurfaceTimeOut(surface, timeoutMs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setWindowClient(TTAVWindowClient client) {
        if (client instanceof TTWindowClient) {
            ((TTWindowClient) client).bindPlayer(this.mPlayer);
        }
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setNotifyState(long state) {
        this.mPlayer.setNotifyerState(state);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setIntOption(int key, int value) {
        try {
            return this.mPlayer.setIntOption(key, value);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setStringOption(int key, String value) {
        return this.mPlayer.setStringOption(key, value);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public String getStringOption(int key) {
        return this.mPlayer.getStringOption(key);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public String getSubtitleContent(int queryTime) {
        return this.mPlayer.getSubtitleContent(queryTime);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setLongOption(int key, long value) {
        return this.mPlayer.setLongOption(key, value);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public long getLongOption(int key, long dValue) {
        return this.mPlayer.getLongOption(key, dValue);
    }

    @Override // com.ss.ttm.player.IPlayerNotifyer
    public void handlePlayerNotify(long id, int lifeId, int what, int parameter, String info) {
        this.mClient.onPlayerNotify(lifeId, what, parameter, info);
    }

    @Override // com.ss.ttm.player.IPlayerNotifyer
    public void handleErrorNotify(long id, int type, int errorCode, String logInfo) {
        this.mClient.onPlayLogInfo(type, errorCode, logInfo);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void takeScreenshot() {
        this.mPlayer.takeScreenshot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setOnScreenshotListener(MediaPlayer.OnScreenshotListener listener) {
        this.mPlayer.setOnScreenshotListener(listener);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void switchStream(int bitrate, int streamType) {
        this.mPlayer.switchStream(bitrate, streamType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setLoadControl(LoadControl control) {
        this.mPlayer.setLoadControl(control);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setMaskInfo(MaskInfo info) {
        this.mPlayer.setMaskInfo(info);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setAIBarrageInfo(MaskInfo barrageInfo) {
        this.mPlayer.setAIBarrageInfo(barrageInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setSubInfo(SubInfo info) {
        this.mPlayer.setSubInfo(info);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setABRStrategy(ABRStrategy abrStrategy) {
        this.mPlayer.setABRStrategy(abrStrategy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setTraitObject(int type, TraitObject traitObject) {
        this.mPlayer.setTraitObject(type, traitObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setFrameMetadataListener(FrameMetadataListener listener) {
        this.mPlayer.setFrameMetadataListener(listener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setStrategyParamsTransport(StrategyParamsTransport transport) {
        this.mPlayer.setStrategyParamsTransport(transport);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setMediaTransport(MediaTransport transport) {
        this.mPlayer.setMediaTransport(transport);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setAudioProcessor(AudioProcessor processor) {
        this.mPlayer.setAudioProcessor(processor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setFloatOption(int key, float value) {
        return this.mPlayer.setFloatOption(key, value);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected int setDoubleOption(int key, double value) {
        return this.mPlayer.setDoubleOption(key, value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public float getFloatOption(int key, float dValue) {
        return this.mPlayer.getFloatOption(key, dValue);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected double getDoubleOption(int key, double dValue) {
        return this.mPlayer.getDoubleOption(key, dValue);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setupMediaCodec() {
        this.mPlayer.setupMediaCodec();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public Object getObjectOption(int key) {
        return this.mPlayer.getObjectValue(key);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ss.ttm.player.ITTPlayerRef
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        return this.mPlayer.getTrackInfo();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setIntOptionArray(int[] keys, int[] values) {
        return this.mPlayer.setIntOptionArray(keys, values);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setLongOptionArray(int[] keys, long[] values) {
        return this.mPlayer.setLongOptionArray(keys, values);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setFloatOptionArray(int[] keys, float[] values) {
        return this.mPlayer.setFloatOptionArray(keys, values);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setStringOptionArray(int[] keys, String[] values) {
        return this.mPlayer.setStringOptionArray(keys, values);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener listener, Handler handler) {
        this.mPlayer.setOnImageAvailableListener(listener, handler);
    }
}
