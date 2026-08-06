package com.lynx.canvas.player;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonReflectLoader;
import com.lynx.canvas.KryptonSettingsService;
import com.lynx.canvas.KryptonVideoPlayer;
import com.lynx.canvas.KryptonVideoPlayerService;
import com.lynx.canvas.SurfaceTextureWrapper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PlayerContext implements KryptonVideoPlayer.Listener {
    private static final int CAN_DRAW = 3;
    private static final int CAN_PLAY = 0;
    private static final int END = 1;
    private static final int ERROR = 2;
    private static final int PAUSED = 6;
    private static final int SEEK_END = 4;
    private static final int START_PLAY = 5;
    private static final String TAG = "PlayerContext";
    private static final String USE_CUSTOM_PLAYER = "useCustomPlayer";
    private Context mContext;
    private final KryptonApp mKryptonApp;
    private Looper mLooperTriggerLoad;
    long mNativePtr;
    private Map<String, String> mOptions;
    KryptonVideoPlayer mVideoPlayer;
    private double mCurrentTime = 0.0d;
    private volatile boolean mPrepared = false;
    private double mCurrentTimeCache = 0.0d;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeNotifyPlayerState(long j, int i, int[] iArr, String str);

    private PlayerContext(long j, KryptonApp kryptonApp, Map<String, String> map) {
        this.mNativePtr = j;
        this.mKryptonApp = kryptonApp;
        this.mContext = kryptonApp.getContext();
        this.mOptions = map;
    }

    private boolean checkTTEngineHardwareDecodeDisabled() {
        Collection collection;
        String str = Build.MODEL;
        boolean z = false;
        try {
            KryptonSettingsService kryptonSettingsService = (KryptonSettingsService) this.mKryptonApp.getService(KryptonSettingsService.class);
            if (kryptonSettingsService != null && (collection = (Collection) kryptonSettingsService.objectValueForKey("TT_VIDEO_HARDWARE_DECODE_BLACK_LIST", null)) != null) {
                if (collection.contains(str.toLowerCase())) {
                    z = true;
                }
            }
        } catch (Throwable th) {
            KryptonLLog.m2563w(TAG, "checkTTEngineHardwareDecodeDisabled error " + th.toString());
        }
        KryptonLLog.m2561i(TAG, "checkTTEngineHardwareDecodeDisabled = " + z + " for " + str);
        return z;
    }

    private KryptonVideoPlayer createPlayer() {
        KryptonVideoPlayerService kryptonVideoPlayerService;
        Map<String, String> map = this.mOptions;
        if (map != null) {
            String str = map.get(USE_CUSTOM_PLAYER);
            r2 = str != null ? Boolean.parseBoolean(str) : false;
            KryptonLLog.m2561i(TAG, "create player options: " + this.mOptions);
        }
        if (r2) {
            kryptonVideoPlayerService = (KryptonVideoPlayerService) this.mKryptonApp.getService(KryptonVideoPlayerService.class);
            if (kryptonVideoPlayerService == null) {
                kryptonVideoPlayerService = (KryptonVideoPlayerService) KryptonReflectLoader.inst().getHybridServiceInstance(KryptonVideoPlayerService.class);
            }
            if (kryptonVideoPlayerService != null) {
                KryptonLLog.m2561i(TAG, "create player using custom player service");
            } else {
                KryptonLLog.m2561i(TAG, "create player using system player service, as custom player service is not set");
            }
        } else {
            KryptonLLog.m2561i(TAG, "create player using default player service");
            kryptonVideoPlayerService = null;
        }
        if (kryptonVideoPlayerService == null) {
            kryptonVideoPlayerService = new KryptonVideoPlayerService() { // from class: com.lynx.canvas.player.PlayerContext.1
                @Override // com.lynx.canvas.KryptonVideoPlayerService
                public KryptonVideoPlayer createVideoPlayer(Map<String, String> map2) {
                    return new KryptonDefaultVideoPlayer(PlayerContext.this.mContext);
                }
            };
        }
        Boolean valueOf = Boolean.valueOf(checkTTEngineHardwareDecodeDisabled());
        Map<String, String> map2 = this.mOptions;
        if (map2 != null) {
            map2.put("disable_tt_engine_hardware_decode", valueOf.toString());
        } else if (valueOf.booleanValue()) {
            HashMap hashMap = new HashMap();
            this.mOptions = hashMap;
            hashMap.put("disable_tt_engine_hardware_decode", "true");
        }
        return kryptonVideoPlayerService.createVideoPlayer(this.mOptions);
    }

    private void loadInternal(String str) {
        if (this.mVideoPlayer == null) {
            this.mVideoPlayer = createPlayer();
            this.mLooperTriggerLoad = Looper.myLooper();
            this.mVideoPlayer.setListener(this);
        }
        if (this.mVideoPlayer == null) {
            KryptonLLog.m2560e(TAG, "service create video player return null");
            return;
        }
        KryptonLLog.m2561i(TAG, "load url " + str);
        this.mVideoPlayer.setDataSource(str);
        this.mVideoPlayer.prepare();
    }

    public static PlayerContext create(long j, KryptonApp kryptonApp, Object obj) {
        return new PlayerContext(j, kryptonApp, (Map) obj);
    }

    void setupSurface(SurfaceTextureWrapper surfaceTextureWrapper) {
        this.mVideoPlayer.setSurface(surfaceTextureWrapper.getSurface());
    }

    void play() {
        KryptonVideoPlayer kryptonVideoPlayer = this.mVideoPlayer;
        if (kryptonVideoPlayer == null) {
            return;
        }
        kryptonVideoPlayer.play();
    }

    void pause() {
        KryptonVideoPlayer kryptonVideoPlayer = this.mVideoPlayer;
        if (kryptonVideoPlayer == null || !kryptonVideoPlayer.isPlaying()) {
            return;
        }
        this.mVideoPlayer.pause();
    }

    void load(String str) {
        loadInternal(str);
    }

    double getCurrentTime() {
        KryptonVideoPlayer kryptonVideoPlayer = this.mVideoPlayer;
        if (kryptonVideoPlayer == null) {
            return 0.0d;
        }
        return kryptonVideoPlayer.getCurrentTime();
    }

    void setCurrentTime(double d) {
        if (this.mVideoPlayer == null || !this.mPrepared) {
            this.mCurrentTimeCache = d;
        } else {
            this.mVideoPlayer.setCurrentTime(d);
        }
    }

    void setVolume(double d) {
        KryptonVideoPlayer kryptonVideoPlayer = this.mVideoPlayer;
        if (kryptonVideoPlayer == null) {
            return;
        }
        kryptonVideoPlayer.setVolume(d);
    }

    public void setLoop(boolean z) {
        KryptonVideoPlayer kryptonVideoPlayer = this.mVideoPlayer;
        if (kryptonVideoPlayer == null) {
            return;
        }
        kryptonVideoPlayer.setLooping(z);
    }

    public boolean getLoop() {
        KryptonVideoPlayer kryptonVideoPlayer = this.mVideoPlayer;
        if (kryptonVideoPlayer == null) {
            return false;
        }
        return kryptonVideoPlayer.getLooping();
    }

    void release() {
        KryptonVideoPlayer kryptonVideoPlayer = this.mVideoPlayer;
        if (kryptonVideoPlayer != null) {
            kryptonVideoPlayer.setListener(null);
            this.mVideoPlayer.release();
            this.mVideoPlayer = null;
        }
        this.mNativePtr = 0L;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onPrepared(KryptonVideoPlayer kryptonVideoPlayer) {
        this.mPrepared = true;
        callbackOnThreadTriggerLoad(0, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onCompletion(KryptonVideoPlayer kryptonVideoPlayer) {
        callbackOnThreadTriggerLoad(1, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onSeekComplete(KryptonVideoPlayer kryptonVideoPlayer) {
        callbackOnThreadTriggerLoad(4, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onRenderStart(KryptonVideoPlayer kryptonVideoPlayer) {
        callbackOnThreadTriggerLoad(3, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onStartPlay(KryptonVideoPlayer kryptonVideoPlayer) {
        callbackOnThreadTriggerLoad(5, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onPaused(KryptonVideoPlayer kryptonVideoPlayer) {
        callbackOnThreadTriggerLoad(6, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public boolean onError(KryptonVideoPlayer kryptonVideoPlayer, Object obj) {
        if (obj != null) {
            callbackOnThreadTriggerLoad(2, obj.toString());
            return false;
        }
        callbackOnThreadTriggerLoad(2, "Internal error");
        return false;
    }

    private void callbackOnThreadTriggerLoad(final int i, final String str) {
        new Handler(this.mLooperTriggerLoad).post(new Runnable() { // from class: com.lynx.canvas.player.PlayerContext.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[0];
                if (i == 0 && PlayerContext.this.mVideoPlayer != null) {
                    if (PlayerContext.this.mCurrentTimeCache != 0.0d) {
                        PlayerContext playerContext = PlayerContext.this;
                        playerContext.setCurrentTime(playerContext.mCurrentTimeCache);
                    }
                    iArr = new int[]{PlayerContext.this.mVideoPlayer.getVideoWidth(), PlayerContext.this.mVideoPlayer.getVideoHeight(), PlayerContext.this.mVideoPlayer.getDuration(), PlayerContext.this.mVideoPlayer.getRotation()};
                }
                if (PlayerContext.this.mNativePtr != 0) {
                    PlayerContext.nativeNotifyPlayerState(PlayerContext.this.mNativePtr, i, iArr, str);
                }
            }
        });
    }
}
