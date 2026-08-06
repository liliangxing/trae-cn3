package com.bytedance.ies.bullet.lynx.element;

import android.content.Context;
import android.view.Surface;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.push.settings.pull.PullSettingsModel;
import com.lynx.canvas.KryptonVideoPlayer;
import com.lynx.canvas.KryptonVideoPlayerService;
import com.lynx.canvas.LynxKryptonUtils;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.ss.ttvideoengine.SeekCompletionListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineListener;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxCanvasTTPlayer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 B2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001BB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J&\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u0011H\u0016J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J\u0012\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010$\u001a\u00020\u0011H\u0016J\u001a\u0010%\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010&\u001a\u00020\u0011H\u0016J\u0012\u0010'\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010(\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010)\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010*\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010+\u001a\u00020\u0011H\u0016J\"\u0010,\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0011H\u0016J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u0011H\u0016J\b\u00101\u001a\u00020\u001bH\u0016J\b\u00102\u001a\u00020\u001bH\u0016J\b\u00103\u001a\u00020\u001bH\u0016J\b\u00104\u001a\u00020\u001bH\u0016J\u0010\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u000fH\u0016J\u0012\u00107\u001a\u00020\u001b2\b\u00108\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u00109\u001a\u00020\u001b2\b\u0010:\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u0013H\u0016J\u0012\u0010=\u001a\u00020\u001b2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u000fH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/element/LynxCanvasTTPlayer;", "Lcom/lynx/canvas/KryptonVideoPlayer;", "Lcom/ss/ttvideoengine/VideoEngineListener;", "Lcom/ss/ttvideoengine/SeekCompletionListener;", "playerContext", "Landroid/content/Context;", "options", "", "", "(Landroid/content/Context;Ljava/util/Map;)V", "playerListener", "Lcom/lynx/canvas/KryptonVideoPlayer$Listener;", "videoEngine", "Lcom/ss/ttvideoengine/TTVideoEngine;", "getCurrentTime", "", "getDuration", "", "getLooping", "", "getRotation", "getVideoHeight", "getVideoWidth", "initVideoEngine", "appContext", "isPlaying", "onBufferingUpdate", "", "engine", "percent", "onCompletion", "success", "onError", "error", "Lcom/ss/ttvideoengine/utils/Error;", "onLoadStateChanged", "loadState", "onPlaybackStateChanged", "playbackState", "onPrepare", "onPrepared", "onRenderStart", "onStreamChanged", "type", "onVideoSizeChanged", "width", "height", "onVideoStatusException", "status", "pause", "play", "prepare", "release", "setCurrentTime", "time", "setDataSource", "url", "setListener", "listener", "setLooping", PullSettingsModel.SCENE_LOOP, "setSurface", "surface", "Landroid/view/Surface;", "setVolume", "volume", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxCanvasTTPlayer implements KryptonVideoPlayer, VideoEngineListener, SeekCompletionListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private KryptonVideoPlayer.Listener playerListener;
    private final TTVideoEngine videoEngine;

    public int getRotation() {
        return 0;
    }

    public void onBufferingUpdate(TTVideoEngine engine, int percent) {
    }

    public void onLoadStateChanged(TTVideoEngine engine, int loadState) {
    }

    public void onPlaybackStateChanged(TTVideoEngine engine, int playbackState) {
    }

    public void onPrepare(TTVideoEngine engine) {
    }

    public void onStreamChanged(TTVideoEngine engine, int type) {
    }

    public void onVideoSizeChanged(TTVideoEngine engine, int width, int height) {
    }

    public void onVideoStatusException(int status) {
    }

    public LynxCanvasTTPlayer(Context context, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(context, "playerContext");
        this.videoEngine = initVideoEngine(context, map);
    }

    /* compiled from: LynxCanvasTTPlayer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/element/LynxCanvasTTPlayer$Companion;", "", "()V", "attachToLynxView", "", "lynxView", "Lcom/lynx/tasm/LynxView;", "context", "Landroid/content/Context;", "LynxCanvasPlayerService", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: LynxCanvasTTPlayer.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/element/LynxCanvasTTPlayer$Companion$LynxCanvasPlayerService;", "Lcom/lynx/canvas/KryptonVideoPlayerService;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_context", "createVideoPlayer", "Lcom/lynx/canvas/KryptonVideoPlayer;", "options", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final class LynxCanvasPlayerService extends KryptonVideoPlayerService {
            private Context _context;

            public LynxCanvasPlayerService(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                this._context = applicationContext;
            }

            public KryptonVideoPlayer createVideoPlayer(Map<String, String> options) {
                return new LynxCanvasTTPlayer(this._context, options);
            }
        }

        private Companion() {
        }

        public final void attachToLynxView(LynxView lynxView, Context context) {
            Intrinsics.checkNotNullParameter(lynxView, "lynxView");
            Intrinsics.checkNotNullParameter(context, "context");
            LynxKryptonHelper lynxKryptonHelper = LynxKryptonUtils.getLynxKryptonHelper(lynxView);
            if (lynxKryptonHelper != null) {
                lynxKryptonHelper.registerService(KryptonVideoPlayerService.class, new LynxCanvasPlayerService(context));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TTVideoEngine initVideoEngine(Context appContext, Map<String, String> options) {
        String str;
        int i = 0;
        i = 0;
        TTVideoEngine tTVideoEngine = new TTVideoEngine(appContext, 0);
        tTVideoEngine.setIntOption(110, 1);
        tTVideoEngine.setTag("lynx_krypton");
        tTVideoEngine.setSubTag("lynx_krypton_for_tiktok");
        tTVideoEngine.setIntOption(415, 1);
        if (options != null && (str = (String) MapsKt.getValue(options, "disable_tt_engine_hardware_decode")) != null) {
            i = Boolean.parseBoolean(str);
        }
        tTVideoEngine.setIntOption(7, i ^ 1);
        return tTVideoEngine;
    }

    public void setListener(KryptonVideoPlayer.Listener listener) {
        this.playerListener = listener;
        if (listener == null) {
            this.videoEngine.setListener((VideoEngineListener) null);
        } else {
            this.videoEngine.setListener(this);
        }
    }

    public int getVideoWidth() {
        return this.videoEngine.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.videoEngine.getVideoHeight();
    }

    public int getDuration() {
        return this.videoEngine.getDuration();
    }

    public void setSurface(Surface surface) {
        this.videoEngine.setSurface(surface);
    }

    public void play() {
        this.videoEngine.play();
        KryptonVideoPlayer.Listener listener = this.playerListener;
        if (listener != null) {
            listener.onStartPlay(this);
        }
    }

    public void pause() {
        this.videoEngine.pause();
        KryptonVideoPlayer.Listener listener = this.playerListener;
        if (listener != null) {
            listener.onPaused(this);
        }
    }

    public void setDataSource(String url) {
        this.videoEngine.setDirectURL(url);
    }

    public void prepare() {
        this.videoEngine.prepare();
    }

    public void setLooping(boolean loop) {
        this.videoEngine.setLooping(loop);
    }

    public boolean getLooping() {
        return this.videoEngine.isLooping();
    }

    public void setCurrentTime(double time) {
        this.videoEngine.seekTo((int) (time * BytePatchException.ErrorCode.paramsError), this);
    }

    public double getCurrentTime() {
        return this.videoEngine.getCurrentPlaybackTime() * 0.001d;
    }

    public void setVolume(double volume) {
        float maxVolume = (volume > ((double) 1) ? 1.0f : volume < ((double) 0) ? 0.0f : (float) volume) * this.videoEngine.getMaxVolume();
        this.videoEngine.setVolume(maxVolume, maxVolume);
    }

    public void release() {
        this.videoEngine.release();
    }

    public boolean isPlaying() {
        if (this.videoEngine.isShouldPlay()) {
            return true;
        }
        return this.videoEngine.isStarted() && this.videoEngine.getPlaybackState() == 1;
    }

    public void onPrepared(TTVideoEngine engine) {
        KryptonVideoPlayer.Listener listener = this.playerListener;
        if (listener != null) {
            listener.onPrepared(this);
        }
    }

    public void onRenderStart(TTVideoEngine engine) {
        KryptonVideoPlayer.Listener listener = this.playerListener;
        if (listener != null) {
            listener.onRenderStart(this);
        }
    }

    public void onCompletion(TTVideoEngine engine) {
        KryptonVideoPlayer.Listener listener = this.playerListener;
        if (listener != null) {
            listener.onCompletion(this);
        }
    }

    public void onError(Error error) {
        KryptonVideoPlayer.Listener listener = this.playerListener;
        if (listener != null) {
            listener.onError(this, error);
        }
    }

    public void onCompletion(boolean success) {
        KryptonVideoPlayer.Listener listener = this.playerListener;
        if (listener != null) {
            listener.onSeekComplete(this);
        }
    }
}
