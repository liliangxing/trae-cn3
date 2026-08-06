package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.strategy.IAppService;
import com.bytedance.vcloud.uniplayer.UniAVEngine;
import com.bytedance.vcloud.uniplayer.UniAbConfig;
import com.bytedance.vcloud.uniplayer.UniInstConfig;
import com.bytedance.vcloud.uniplayer.UniKitService_androidKt;
import com.bytedance.vcloud.uniplayer.UniWindowBinder;
import com.bytedance.vcloud.uniplayer.VideoModel;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.lynx.animax.monitor.AnimaXMonitorUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AVManager.android.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J \u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0001H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/vcloud/impl/AVManagerJvmBridge;", "Lcom/bytedance/vcloud/impl/AVManagerBridge;", "sceneID", "", "abConfig", "Lcom/bytedance/vcloud/uniplayer/UniAbConfig;", "(Ljava/lang/String;Lcom/bytedance/vcloud/uniplayer/UniAbConfig;)V", "nativePtr", "", "sceneId", "close", "", "create", "videoModel", "Lcom/bytedance/vcloud/uniplayer/VideoModel;", "instConfig", "Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "getBinder", "Lcom/bytedance/vcloud/uniplayer/UniWindowBinder;", "engineId", "getEngine", "Lcom/bytedance/vcloud/uniplayer/UniAVEngine;", "engineID", AnimaXMonitorUtil.TRIGGER_ON_RELEASE, "Lkotlin/Function0;", "getScene", "Lcom/bytedance/vcloud/impl/UniAvSceneBridge;", "pause", "play", "release", "releaseAll", "transferEngineTo", "", "target", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class AVManagerJvmBridge implements AVManagerBridge {
    private static final int AVMANAGER_ACTION_PAUSE = 2;
    private static final int AVMANAGER_ACTION_PLAY = 0;
    private static final int AVMANAGER_ACTION_RELEASE = 4;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private long nativePtr;
    private final String sceneId;

    @JvmStatic
    public static final native void action(long j, String str, int i);

    @JvmStatic
    public static final native long create(String str, long j);

    @JvmStatic
    public static final native void decEngine(long j);

    @JvmStatic
    public static final native void decScene(long j);

    @JvmStatic
    public static final native void destroy(long j);

    @JvmStatic
    public static final native long getEngine(long j, String str);

    @JvmStatic
    public static final native long getScene(long j);

    @JvmStatic
    public static final native String newEngine(long j, long j2, long j3);

    @JvmStatic
    public static final native void releaseAll(long j);

    @JvmStatic
    public static final native boolean transfer(long j, String str, long j2);

    public AVManagerJvmBridge(String str, UniAbConfig uniAbConfig) {
        Intrinsics.checkNotNullParameter(str, "sceneID");
        UniAbConfigImpl uniAbConfigImpl = uniAbConfig instanceof UniAbConfigImpl ? (UniAbConfigImpl) uniAbConfig : null;
        this.nativePtr = INSTANCE.create(str, uniAbConfigImpl != null ? uniAbConfigImpl.getMNative() : 0L);
        this.sceneId = str;
    }

    @Override // com.bytedance.vcloud.impl.AVManagerBridge
    public String create(VideoModel videoModel, UniInstConfig instConfig) {
        Intrinsics.checkNotNullParameter(videoModel, "videoModel");
        Intrinsics.checkNotNullParameter(instConfig, "instConfig");
        long j = this.nativePtr;
        if (j == 0) {
            return "";
        }
        UniVideoModelImpl uniVideoModelImpl = videoModel instanceof UniVideoModelImpl ? (UniVideoModelImpl) videoModel : null;
        long nativePtr = uniVideoModelImpl != null ? uniVideoModelImpl.getNativePtr() : 0L;
        UniInstConfigImpl uniInstConfigImpl = instConfig instanceof UniInstConfigImpl ? (UniInstConfigImpl) instConfig : null;
        long mNative = uniInstConfigImpl != null ? uniInstConfigImpl.getMNative() : 0L;
        return (nativePtr == 0 || mNative == 0) ? "" : INSTANCE.newEngine(j, nativePtr, mNative);
    }

    @Override // com.bytedance.vcloud.impl.AVManagerBridge
    public UniAVEngine getEngine(String engineID, Function0<Unit> onRelease) {
        Intrinsics.checkNotNullParameter(engineID, "engineID");
        Intrinsics.checkNotNullParameter(onRelease, AnimaXMonitorUtil.TRIGGER_ON_RELEASE);
        long j = this.nativePtr;
        if (j == 0) {
            return null;
        }
        long engine = INSTANCE.getEngine(j, engineID);
        if (engine == 0) {
            return null;
        }
        return UniAVEngineImpl.INSTANCE.attach$uniplayer_release(engine, onRelease);
    }

    @Override // com.bytedance.vcloud.impl.AVManagerBridge
    public boolean transferEngineTo(String engineID, AVManagerBridge target) {
        Intrinsics.checkNotNullParameter(engineID, "engineID");
        Intrinsics.checkNotNullParameter(target, "target");
        long j = this.nativePtr;
        AVManagerJvmBridge aVManagerJvmBridge = target instanceof AVManagerJvmBridge ? (AVManagerJvmBridge) target : null;
        if (aVManagerJvmBridge != null) {
            return INSTANCE.transfer(j, engineID, aVManagerJvmBridge.nativePtr);
        }
        return false;
    }

    @Override // com.bytedance.vcloud.impl.AVManagerBridge
    public void play(String engineID) {
        Intrinsics.checkNotNullParameter(engineID, "engineID");
        long j = this.nativePtr;
        if (j != 0) {
            INSTANCE.action(j, engineID, 0);
        }
    }

    @Override // com.bytedance.vcloud.impl.AVManagerBridge
    public void pause(String engineID) {
        Intrinsics.checkNotNullParameter(engineID, "engineID");
        long j = this.nativePtr;
        if (j != 0) {
            INSTANCE.action(j, engineID, 2);
        }
    }

    @Override // com.bytedance.vcloud.impl.AVManagerBridge
    public void release(String engineID) {
        Intrinsics.checkNotNullParameter(engineID, "engineID");
        long j = this.nativePtr;
        if (j != 0) {
            INSTANCE.action(j, engineID, 4);
        }
    }

    @Override // com.bytedance.vcloud.impl.AVManagerBridge
    public UniWindowBinder getBinder(String engineId) {
        Intrinsics.checkNotNullParameter(engineId, "engineId");
        long j = this.nativePtr;
        if (j == 0) {
            return new UniWindowBinder(0L, new Function1<Long, Unit>() { // from class: com.bytedance.vcloud.impl.AVManagerJvmBridge$getBinder$1
                public final void invoke(long j2) {
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return Unit.INSTANCE;
                }
            });
        }
        return new UniWindowBinder(INSTANCE.getEngine(j, engineId), new Function1<Long, Unit>() { // from class: com.bytedance.vcloud.impl.AVManagerJvmBridge$getBinder$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j2) {
                if (j2 != 0) {
                    AVManagerJvmBridge.INSTANCE.decEngine(j2);
                }
            }
        });
    }

    @Override // com.bytedance.vcloud.impl.AVManagerBridge
    public UniAvSceneBridge getScene() {
        long j = this.nativePtr;
        return UniAvSceneBridgeKt.createUniAvSceneBridge(j != 0 ? INSTANCE.getScene(j) : 0L);
    }

    @Override // com.bytedance.vcloud.impl.AVManagerBridge
    public void releaseAll() {
        long j = this.nativePtr;
        if (j != 0) {
            INSTANCE.releaseAll(j);
        }
    }

    @Override // com.bytedance.vcloud.impl.AVManagerBridge
    public void close() {
        long j = this.nativePtr;
        if (j != 0) {
            this.nativePtr = 0L;
            INSTANCE.destroy(j);
        }
    }

    /* compiled from: AVManager.android.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0087 J!\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0087 J\u0011\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\nH\u0087 J\u0011\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\nH\u0087 J\u0019\u0010\u0015\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0087 J\u0011\u0010\u0016\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0087 J\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0087 J!\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\nH\u0087 J\u0019\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\nH\u0087 J\u0011\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0087 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/vcloud/impl/AVManagerJvmBridge$Companion;", "", "()V", "AVMANAGER_ACTION_PAUSE", "", "AVMANAGER_ACTION_PLAY", "AVMANAGER_ACTION_RELEASE", "unip_avmanager_action", "", "avmanager", "", "engineID", "", "action", "unip_avmanager_create", "videoModelPtr", "instCfgPtr", "unip_avmanager_decengine", IAppService.SOURCE_ENGINE, "unip_avmanager_decscene", ReportUtil.Params.SCENE, "unip_avmanager_getengine", "unip_avmanager_getscene", "unip_avmanager_release_all", "unip_avmanager_transfer_engine_to", "", "targetManager", "unip_create_avmanager", "sceneID", "abConfig", "unip_destroy_avmanager", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void action(long j, String str, int i) {
            AVManagerJvmBridge.action(j, str, i);
        }

        @JvmStatic
        public final long create(String str, long j) {
            return AVManagerJvmBridge.create(str, j);
        }

        @JvmStatic
        public final void decEngine(long j) {
            AVManagerJvmBridge.decEngine(j);
        }

        @JvmStatic
        public final void decScene(long j) {
            AVManagerJvmBridge.decScene(j);
        }

        @JvmStatic
        public final void destroy(long j) {
            AVManagerJvmBridge.destroy(j);
        }

        @JvmStatic
        public final long getEngine(long j, String str) {
            return AVManagerJvmBridge.getEngine(j, str);
        }

        @JvmStatic
        public final long getScene(long j) {
            return AVManagerJvmBridge.getScene(j);
        }

        @JvmStatic
        public final String newEngine(long j, long j2, long j3) {
            return AVManagerJvmBridge.newEngine(j, j2, j3);
        }

        @JvmStatic
        public final void releaseAll(long j) {
            AVManagerJvmBridge.releaseAll(j);
        }

        @JvmStatic
        public final boolean transfer(long j, String str, long j2) {
            return AVManagerJvmBridge.transfer(j, str, j2);
        }

        private Companion() {
        }
    }

    static {
        UniKitService_androidKt.loadLibrary();
    }
}
