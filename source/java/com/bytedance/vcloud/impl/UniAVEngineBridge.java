package com.bytedance.vcloud.impl;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.vcloud.strategy.IAppService;
import com.bytedance.vcloud.uniplayer.EngineNotifyListener;
import com.bytedance.vcloud.uniplayer.SeekMode;
import com.bytedance.vcloud.uniplayer.UniKitService_androidKt;
import com.bytedance.webx.seclink.util.ReportUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniAVEngine.android.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\rH\u0016J \u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\rH\u0016J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020(H\u0016J\u0018\u0010+\u001a\u00020\r2\u0006\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\rH\u0016J\u0018\u0010,\u001a\u00020$2\u0006\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020$H\u0016J\b\u0010-\u001a\u00020\rH\u0016J\b\u0010.\u001a\u00020\u001eH\u0016J2\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020$2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020 H\u0016J\b\u00105\u001a\u00020 H\u0016J\b\u00106\u001a\u00020 H\u0016J\u0018\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020\u001eH\u0016J\b\u0010=\u001a\u00020\rH\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/bytedance/vcloud/impl/UniAVEngineBridge;", "Lcom/bytedance/vcloud/impl/UniAvEngineNative;", "Lcom/bytedance/vcloud/uniplayer/EngineNotifyListener;", "videoModel", "Lcom/bytedance/vcloud/impl/UniVideoModelImpl;", "abConfig", "Lcom/bytedance/vcloud/impl/UniAbConfigImpl;", "instConfig", "Lcom/bytedance/vcloud/impl/UniInstConfigImpl;", IAppService.SOURCE_ENGINE, "Lcom/bytedance/vcloud/impl/UniAVEngineImpl;", "(Lcom/bytedance/vcloud/impl/UniVideoModelImpl;Lcom/bytedance/vcloud/impl/UniAbConfigImpl;Lcom/bytedance/vcloud/impl/UniInstConfigImpl;Lcom/bytedance/vcloud/impl/UniAVEngineImpl;)V", "enginePtr", "", "(JLcom/bytedance/vcloud/impl/UniAVEngineImpl;)V", "mEngineHandle", "getMEngineHandle", "()Lcom/bytedance/vcloud/impl/UniAVEngineImpl;", "setMEngineHandle", "(Lcom/bytedance/vcloud/impl/UniAVEngineImpl;)V", "mMainHandler", "Landroid/os/Handler;", "mNativeEngine", "mNotify", "Lcom/bytedance/vcloud/impl/JvmNotify;", "getMNotify", "()Lcom/bytedance/vcloud/impl/JvmNotify;", "setMNotify", "(Lcom/bytedance/vcloud/impl/JvmNotify;)V", "ownsEngine", "", "close", "", "currentPosition", "doExecute", "action", "", "arg1", "arg2", "getFloatValue", "", "key", "defaultValue", "getInt64Value", "getIntValue", "getNative", "isPlaying", "notify", "eId", "what", "info", "", "pause", "play", "prepare", "seek", "seekTimeMs", "seekMode", "Lcom/bytedance/vcloud/uniplayer/SeekMode;", "stop", "savePosition", "watchedDuration", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UniAVEngineBridge implements UniAvEngineNative, EngineNotifyListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private UniAVEngineImpl mEngineHandle;
    private final Handler mMainHandler;
    private volatile long mNativeEngine;
    private JvmNotify mNotify;
    private final boolean ownsEngine;

    @JvmStatic
    public static final native long create(JvmNotify jvmNotify, long j, long j2, long j3);

    @JvmStatic
    public static final native void destroy(long j);

    @JvmStatic
    public static final native void exec(long j, int i, long j2, long j3);

    @JvmStatic
    public static final native float getFloat(long j, int i, float f);

    @JvmStatic
    public static final native int getInt(long j, int i, int i2);

    @JvmStatic
    public static final native long getInt64(long j, int i, long j2);

    @JvmStatic
    public static final native String getString(long j, int i);

    @JvmStatic
    public static final native void pause(long j);

    @JvmStatic
    public static final native void play(long j);

    @JvmStatic
    public static final native boolean playing(long j);

    @JvmStatic
    public static final native long pos(long j);

    @JvmStatic
    public static final native void prepare(long j);

    @JvmStatic
    public static final native void proxy(long j, JvmNotify jvmNotify);

    @JvmStatic
    public static final native int seek(long j, long j2, int i);

    @JvmStatic
    public static final native void stop(long j, boolean z);

    @JvmStatic
    public static final native long watched(long j);

    public final UniAVEngineImpl getMEngineHandle() {
        return this.mEngineHandle;
    }

    public final void setMEngineHandle(UniAVEngineImpl uniAVEngineImpl) {
        this.mEngineHandle = uniAVEngineImpl;
    }

    public final JvmNotify getMNotify() {
        return this.mNotify;
    }

    public final void setMNotify(JvmNotify jvmNotify) {
        Intrinsics.checkNotNullParameter(jvmNotify, "<set-?>");
        this.mNotify = jvmNotify;
    }

    public UniAVEngineBridge(UniVideoModelImpl uniVideoModelImpl, UniAbConfigImpl uniAbConfigImpl, UniInstConfigImpl uniInstConfigImpl, UniAVEngineImpl uniAVEngineImpl) {
        Intrinsics.checkNotNullParameter(uniVideoModelImpl, "videoModel");
        Intrinsics.checkNotNullParameter(uniAVEngineImpl, IAppService.SOURCE_ENGINE);
        this.mNotify = new JvmNotify(this);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.ownsEngine = true;
        this.mEngineHandle = uniAVEngineImpl;
        long mNative = uniInstConfigImpl != null ? uniInstConfigImpl.getMNative() : 0L;
        long nativePtr = uniVideoModelImpl.getNativePtr();
        this.mNativeEngine = INSTANCE.create(this.mNotify, uniAbConfigImpl != null ? uniAbConfigImpl.getMNative() : 0L, mNative, nativePtr);
    }

    public UniAVEngineBridge(long j, UniAVEngineImpl uniAVEngineImpl) {
        Intrinsics.checkNotNullParameter(uniAVEngineImpl, IAppService.SOURCE_ENGINE);
        this.mNotify = new JvmNotify(this);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.ownsEngine = false;
        this.mEngineHandle = uniAVEngineImpl;
        this.mNativeEngine = j;
        INSTANCE.proxy(this.mNativeEngine, this.mNotify);
    }

    @Override // com.bytedance.vcloud.impl.UniAvEngineNative
    /* renamed from: getNative, reason: from getter */
    public long getMNativeEngine() {
        return this.mNativeEngine;
    }

    @Override // com.bytedance.vcloud.impl.UniAvEngineNative
    public void prepare() {
        INSTANCE.prepare(this.mNativeEngine);
    }

    @Override // com.bytedance.vcloud.impl.UniAvEngineNative
    public void play() {
        INSTANCE.play(this.mNativeEngine);
    }

    @Override // com.bytedance.vcloud.impl.UniAvEngineNative
    public void pause() {
        INSTANCE.pause(this.mNativeEngine);
    }

    @Override // com.bytedance.vcloud.impl.UniAvEngineNative
    public void stop(boolean savePosition) {
        INSTANCE.stop(this.mNativeEngine, savePosition);
    }

    @Override // com.bytedance.vcloud.impl.UniAvEngineNative
    public long currentPosition() {
        return INSTANCE.pos(this.mNativeEngine);
    }

    @Override // com.bytedance.vcloud.impl.UniAvEngineNative
    public long watchedDuration() {
        return INSTANCE.watched(this.mNativeEngine);
    }

    @Override // com.bytedance.vcloud.impl.UniAvEngineNative
    public boolean isPlaying() {
        return INSTANCE.playing(this.mNativeEngine);
    }

    @Override // com.bytedance.vcloud.impl.UniAvEngineNative
    public void close() {
        if (this.mNativeEngine != 0) {
            if (this.ownsEngine) {
                INSTANCE.destroy(this.mNativeEngine);
            } else {
                AVManagerJvmBridge.INSTANCE.decEngine(this.mNativeEngine);
            }
            this.mNativeEngine = 0L;
        }
        this.mMainHandler.removeCallbacksAndMessages(null);
        this.mEngineHandle = null;
    }

    @Override // com.bytedance.vcloud.impl.UniAvEngineNative
    public void doExecute(int action, long arg1, long arg2) {
        INSTANCE.exec(this.mNativeEngine, action, arg1, arg2);
    }

    @Override // com.bytedance.vcloud.impl.UniAvEngineNative
    public int seek(long seekTimeMs, SeekMode seekMode) {
        Intrinsics.checkNotNullParameter(seekMode, "seekMode");
        return INSTANCE.seek(this.mNativeEngine, seekTimeMs, seekMode.getValue());
    }

    @Override // com.bytedance.vcloud.uniplayer.EngineNotifyListener
    public void notify(int eId, int what, long arg1, long arg2, String info) {
        UniAVEngineImpl uniAVEngineImpl = this.mEngineHandle;
        if (uniAVEngineImpl != null) {
            uniAVEngineImpl.notify(what, arg1, arg2, info);
        }
    }

    @Override // com.bytedance.vcloud.impl.UniAvEngineNative
    public int getIntValue(int key, int defaultValue) {
        return INSTANCE.getInt(this.mNativeEngine, key, defaultValue);
    }

    @Override // com.bytedance.vcloud.impl.UniAvEngineNative
    public long getInt64Value(int key, long defaultValue) {
        return INSTANCE.getInt64(this.mNativeEngine, key, defaultValue);
    }

    @Override // com.bytedance.vcloud.impl.UniAvEngineNative
    public float getFloatValue(int key, float defaultValue) {
        return INSTANCE.getFloat(this.mNativeEngine, key, defaultValue);
    }

    /* compiled from: UniAVEngine.android.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0087 J)\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0087 J!\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\rH\u0087 J!\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087 J!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004H\u0087 J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\tH\u0087 J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0004H\u0087 J\u0011\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0087 J\u0011\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0087 J\u0011\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0087 J!\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\tH\u0087 J\u0019\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0087 J\u0019\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0015H\u0087 J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0087 J)\u0010\"\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0087 J\u0011\u0010&\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0087 ¨\u0006'"}, d2 = {"Lcom/bytedance/vcloud/impl/UniAVEngineBridge$Companion;", "", "()V", "unip_avengine_current_pos", "", IAppService.SOURCE_ENGINE, "unip_avengine_execute", "", "action", "", "arg1", "arg2", "unip_avengine_get_float", "", "key", "defaultValue", "unip_avengine_get_int", "unip_avengine_get_int64", "unip_avengine_get_string", "", "unip_avengine_isplaying", "", "unip_avengine_pause", "unip_avengine_play", "unip_avengine_prepare", "unip_avengine_seek", "pos", ReportUtil.Params.MODE, "unip_avengine_set_proxy_cb", "notify", "Lcom/bytedance/vcloud/impl/JvmNotify;", "unip_avengine_stop", "savePosition", "unip_avengine_watched_duration", "unip_create_avengine", "abConfig", "instCfg", "videoModelPtr", "unip_destroy_avengine", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final long create(JvmNotify jvmNotify, long j, long j2, long j3) {
            return UniAVEngineBridge.create(jvmNotify, j, j2, j3);
        }

        @JvmStatic
        public final void destroy(long j) {
            UniAVEngineBridge.destroy(j);
        }

        @JvmStatic
        public final void exec(long j, int i, long j2, long j3) {
            UniAVEngineBridge.exec(j, i, j2, j3);
        }

        @JvmStatic
        public final float getFloat(long j, int i, float f) {
            return UniAVEngineBridge.getFloat(j, i, f);
        }

        @JvmStatic
        public final int getInt(long j, int i, int i2) {
            return UniAVEngineBridge.getInt(j, i, i2);
        }

        @JvmStatic
        public final long getInt64(long j, int i, long j2) {
            return UniAVEngineBridge.getInt64(j, i, j2);
        }

        @JvmStatic
        public final String getString(long j, int i) {
            return UniAVEngineBridge.getString(j, i);
        }

        @JvmStatic
        public final void pause(long j) {
            UniAVEngineBridge.pause(j);
        }

        @JvmStatic
        public final void play(long j) {
            UniAVEngineBridge.play(j);
        }

        @JvmStatic
        public final boolean playing(long j) {
            return UniAVEngineBridge.playing(j);
        }

        @JvmStatic
        public final long pos(long j) {
            return UniAVEngineBridge.pos(j);
        }

        @JvmStatic
        public final void prepare(long j) {
            UniAVEngineBridge.prepare(j);
        }

        @JvmStatic
        public final void proxy(long j, JvmNotify jvmNotify) {
            UniAVEngineBridge.proxy(j, jvmNotify);
        }

        @JvmStatic
        public final int seek(long j, long j2, int i) {
            return UniAVEngineBridge.seek(j, j2, i);
        }

        @JvmStatic
        public final void stop(long j, boolean z) {
            UniAVEngineBridge.stop(j, z);
        }

        @JvmStatic
        public final long watched(long j) {
            return UniAVEngineBridge.watched(j);
        }

        private Companion() {
        }
    }

    static {
        UniKitService_androidKt.loadLibrary();
    }
}
