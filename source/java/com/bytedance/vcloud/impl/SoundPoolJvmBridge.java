package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.uniplayer.EngineNotifyListener;
import com.bytedance.vcloud.uniplayer.UniInstConfig;
import com.bytedance.vcloud.uniplayer.VideoModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SoundPool.android.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0000\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0004J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0016J2\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\rH\u0016J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/vcloud/impl/SoundPoolJvmBridge;", "Lcom/bytedance/vcloud/impl/SoundPoolBridge;", "Lcom/bytedance/vcloud/uniplayer/EngineNotifyListener;", "tag", "", "instConfig", "Lcom/bytedance/vcloud/impl/UniInstConfigImpl;", "(Ljava/lang/String;Lcom/bytedance/vcloud/impl/UniInstConfigImpl;)V", "callback", "Lcom/bytedance/vcloud/impl/SoundPoolCallbackBridge;", "mNotify", "Lcom/bytedance/vcloud/impl/JvmNotify;", "nativePtr", "", "attachCallback", "", "clearAll", "close", "disposeNative", "finalize", "getCurrentPos", "soundId", "", "load", "videoModel", "Lcom/bytedance/vcloud/uniplayer/VideoModel;", "Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "notify", "eId", "what", "arg1", "arg2", "info", "pause", "play", "release", "seek", "positionMs", "setVolume", "volume", "", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class SoundPoolJvmBridge implements SoundPoolBridge, EngineNotifyListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SoundPoolCallbackBridge callback;
    private JvmNotify mNotify;
    private long nativePtr;

    @JvmStatic
    public static final native void clear(long j);

    @JvmStatic
    public static final native long create(String str, long j, JvmNotify jvmNotify);

    @JvmStatic
    public static final native void destroy(long j);

    @JvmStatic
    public static final native int load(long j, long j2, long j3);

    @JvmStatic
    public static final native void pause(long j, int i);

    @JvmStatic
    public static final native void play(long j, int i);

    @JvmStatic
    public static final native long pos(long j, int i);

    @JvmStatic
    public static final native void release(long j, int i);

    @JvmStatic
    public static final native int seek(long j, int i, long j2);

    @JvmStatic
    public static final native void setVolume(long j, int i, float f);

    public SoundPoolJvmBridge(String str, UniInstConfigImpl uniInstConfigImpl) {
        Intrinsics.checkNotNullParameter(str, "tag");
        this.mNotify = new JvmNotify(this);
        this.nativePtr = INSTANCE.create(str, uniInstConfigImpl != null ? uniInstConfigImpl.getMNative() : 0L, this.mNotify);
    }

    @Override // com.bytedance.vcloud.impl.SoundPoolBridge
    public int load(VideoModel videoModel, UniInstConfig instConfig) {
        Intrinsics.checkNotNullParameter(videoModel, "videoModel");
        UniVideoModelImpl uniVideoModelImpl = (UniVideoModelImpl) videoModel;
        UniInstConfigImpl uniInstConfigImpl = instConfig instanceof UniInstConfigImpl ? (UniInstConfigImpl) instConfig : null;
        return INSTANCE.load(this.nativePtr, uniVideoModelImpl.getNativePtr(), uniInstConfigImpl != null ? uniInstConfigImpl.getMNative() : 0L);
    }

    @Override // com.bytedance.vcloud.impl.SoundPoolBridge
    public void play(int soundId) {
        INSTANCE.play(this.nativePtr, soundId);
    }

    @Override // com.bytedance.vcloud.impl.SoundPoolBridge
    public void setVolume(int soundId, float volume) {
        INSTANCE.setVolume(this.nativePtr, soundId, volume);
    }

    @Override // com.bytedance.vcloud.impl.SoundPoolBridge
    public void pause(int soundId) {
        INSTANCE.pause(this.nativePtr, soundId);
    }

    @Override // com.bytedance.vcloud.impl.SoundPoolBridge
    public int seek(int soundId, long positionMs) {
        return INSTANCE.seek(this.nativePtr, soundId, positionMs);
    }

    @Override // com.bytedance.vcloud.impl.SoundPoolBridge
    public long getCurrentPos(int soundId) {
        return INSTANCE.pos(this.nativePtr, soundId);
    }

    @Override // com.bytedance.vcloud.impl.SoundPoolBridge
    public void release(int soundId) {
        INSTANCE.release(this.nativePtr, soundId);
    }

    @Override // com.bytedance.vcloud.impl.SoundPoolBridge
    public void clearAll() {
        INSTANCE.clear(this.nativePtr);
    }

    @Override // com.bytedance.vcloud.impl.SoundPoolBridge
    public void close() {
        clearAll();
        disposeNative();
    }

    @Override // com.bytedance.vcloud.impl.SoundPoolBridge
    public void attachCallback(SoundPoolCallbackBridge callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @Override // com.bytedance.vcloud.uniplayer.EngineNotifyListener
    public void notify(int eId, int what, long arg1, long arg2, String info) {
        SoundPoolCallbackBridge soundPoolCallbackBridge = this.callback;
        if (soundPoolCallbackBridge == null) {
            return;
        }
        soundPoolCallbackBridge.onNotify(eId, what, arg1, arg2, info);
    }

    private final void disposeNative() {
        long j = this.nativePtr;
        if (j != 0) {
            Companion companion = INSTANCE;
            companion.clear(j);
            companion.destroy(j);
            this.nativePtr = 0L;
            this.callback = null;
        }
    }

    protected final void finalize() {
        disposeNative();
    }

    /* compiled from: SoundPool.android.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0087 J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0087 J\u0011\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0087 J\u0019\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0087 J!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0087 J\u0019\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0087 J\u0019\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0087 J\u0019\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0087 J!\u0010\u0016\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0004H\u0087 J!\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0087 ¨\u0006\u001b"}, d2 = {"Lcom/bytedance/vcloud/impl/SoundPoolJvmBridge$Companion;", "", "()V", "unip_create_soundpool", "", "tag", "", "instCfg", "notify", "Lcom/bytedance/vcloud/impl/JvmNotify;", "unip_destroy_soundpool", "", "pool", "unip_soundpool_clear_all", "unip_soundpool_current_pos", "soundId", "", "unip_soundpool_load", "videoModelPtr", "unip_soundpool_pause", "unip_soundpool_play", "unip_soundpool_release", "unip_soundpool_seek", "positionMs", "unip_soundpool_set_volume", "volume", "", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void clear(long j) {
            SoundPoolJvmBridge.clear(j);
        }

        @JvmStatic
        public final long create(String str, long j, JvmNotify jvmNotify) {
            return SoundPoolJvmBridge.create(str, j, jvmNotify);
        }

        @JvmStatic
        public final void destroy(long j) {
            SoundPoolJvmBridge.destroy(j);
        }

        @JvmStatic
        public final int load(long j, long j2, long j3) {
            return SoundPoolJvmBridge.load(j, j2, j3);
        }

        @JvmStatic
        public final void pause(long j, int i) {
            SoundPoolJvmBridge.pause(j, i);
        }

        @JvmStatic
        public final void play(long j, int i) {
            SoundPoolJvmBridge.play(j, i);
        }

        @JvmStatic
        public final long pos(long j, int i) {
            return SoundPoolJvmBridge.pos(j, i);
        }

        @JvmStatic
        public final void release(long j, int i) {
            SoundPoolJvmBridge.release(j, i);
        }

        @JvmStatic
        public final int seek(long j, int i, long j2) {
            return SoundPoolJvmBridge.seek(j, i, j2);
        }

        @JvmStatic
        public final void setVolume(long j, int i, float f) {
            SoundPoolJvmBridge.setVolume(j, i, f);
        }

        private Companion() {
        }
    }
}
