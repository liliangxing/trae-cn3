package com.bytedance.vcloud.uniplayer;

import com.bytedance.vcloud.impl.AVManagerBridge;
import com.bytedance.vcloud.impl.AVManager_androidKt;
import com.bytedance.vcloud.impl.UniAVEngineImpl;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniAVManager.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fJ\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003J\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003J\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0012J\u0016\u0010!\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniAVManager;", "Ljava/lang/AutoCloseable;", "sceneID", "", "abConfig", "Lcom/bytedance/vcloud/uniplayer/UniAbConfig;", "(Ljava/lang/String;Lcom/bytedance/vcloud/uniplayer/UniAbConfig;)V", "bridge", "Lcom/bytedance/vcloud/impl/AVManagerBridge;", "engineCache", "", "Lcom/bytedance/vcloud/uniplayer/UniAVEngine;", "mScene", "Lcom/bytedance/vcloud/uniplayer/UniAvScene;", "pendingWindowClients", "Lcom/bytedance/vcloud/uniplayer/UniWindowClient;", "sceneId", "bindWindow", "", "engineID", "windowClient", "close", "create", "videoModel", "Lcom/bytedance/vcloud/uniplayer/VideoModel;", "instConfig", "Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "getEngine", "getScene", "pause", "play", "release", "releaseAll", "transferEngineTo", "", "target", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UniAVManager implements AutoCloseable {
    private final AVManagerBridge bridge;
    private final Map<String, UniAVEngine> engineCache;
    private UniAvScene mScene;
    private final Map<String, UniWindowClient> pendingWindowClients;
    private final String sceneId;

    public UniAVManager(String str, UniAbConfig uniAbConfig) {
        Intrinsics.checkNotNullParameter(str, "sceneID");
        this.bridge = AVManager_androidKt.newAVManagerBridge(str, uniAbConfig);
        this.sceneId = str;
        this.engineCache = new HashMap();
        this.pendingWindowClients = new HashMap();
    }

    public /* synthetic */ UniAVManager(String str, UniAbConfig uniAbConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : uniAbConfig);
    }

    public final String create(VideoModel videoModel, UniInstConfig instConfig) {
        Intrinsics.checkNotNullParameter(videoModel, "videoModel");
        Intrinsics.checkNotNullParameter(instConfig, "instConfig");
        try {
            String create = this.bridge.create(videoModel, instConfig);
            UniWindowClient uniWindowClient = this.pendingWindowClients.get(create);
            if (uniWindowClient != null) {
                bindWindow(create, uniWindowClient);
            }
            return create;
        } finally {
            instConfig.close();
        }
    }

    public final UniAVEngine getEngine(final String engineID) {
        Intrinsics.checkNotNullParameter(engineID, "engineID");
        if (engineID.length() == 0) {
            return null;
        }
        UniAVEngine uniAVEngine = this.engineCache.get(engineID);
        if (uniAVEngine != null) {
            return uniAVEngine;
        }
        UniAVEngine engine = this.bridge.getEngine(engineID, new Function0<Unit>() { // from class: com.bytedance.vcloud.uniplayer.UniAVManager$getEngine$engine$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2630invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2630invoke() {
                UniAVManager.this.release(engineID);
            }
        });
        if (engine == null) {
            return null;
        }
        this.engineCache.put(engineID, engine);
        return engine;
    }

    public final UniAvScene getScene() {
        UniAvScene uniAvScene = this.mScene;
        if (uniAvScene != null) {
            return uniAvScene;
        }
        UniAvScene uniAvScene2 = new UniAvScene(this.sceneId, this.bridge.getScene());
        this.mScene = uniAvScene2;
        return uniAvScene2;
    }

    public final boolean transferEngineTo(final String engineID, final UniAVManager target) {
        Intrinsics.checkNotNullParameter(engineID, "engineID");
        Intrinsics.checkNotNullParameter(target, "target");
        if ((engineID.length() == 0) || target == this || !this.bridge.transferEngineTo(engineID, target.bridge)) {
            return false;
        }
        UniAVEngine remove = this.engineCache.remove(engineID);
        this.pendingWindowClients.remove(engineID);
        if (remove instanceof UniAVEngineImpl) {
            ((UniAVEngineImpl) remove).updateReleaseGate$uniplayer_release(new Function0<Unit>() { // from class: com.bytedance.vcloud.uniplayer.UniAVManager$transferEngineTo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2631invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2631invoke() {
                    UniAVManager.this.release(engineID);
                }
            });
        }
        if (remove != null && !target.engineCache.containsKey(engineID)) {
            target.engineCache.put(engineID, remove);
        }
        return true;
    }

    public final void play(String engineID) {
        Intrinsics.checkNotNullParameter(engineID, "engineID");
        this.bridge.play(engineID);
    }

    public final void pause(String engineID) {
        Intrinsics.checkNotNullParameter(engineID, "engineID");
        this.bridge.pause(engineID);
    }

    public final void release(String engineID) {
        Intrinsics.checkNotNullParameter(engineID, "engineID");
        this.engineCache.remove(engineID);
        this.pendingWindowClients.remove(engineID);
        this.bridge.release(engineID);
    }

    public final void bindWindow(String engineID, UniWindowClient windowClient) {
        Intrinsics.checkNotNullParameter(engineID, "engineID");
        Intrinsics.checkNotNullParameter(windowClient, "windowClient");
        UniWindowBinder binder = this.bridge.getBinder(engineID);
        if (binder.getMNativePtr() != 0) {
            windowClient.bind(binder);
            this.pendingWindowClients.remove(engineID);
        } else {
            this.pendingWindowClients.put(engineID, windowClient);
        }
        binder.close();
    }

    public final void releaseAll() {
        this.engineCache.clear();
        this.pendingWindowClients.clear();
        this.bridge.releaseAll();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        releaseAll();
        UniAvScene uniAvScene = this.mScene;
        if (uniAvScene != null) {
            uniAvScene.close();
        }
        this.mScene = null;
        this.bridge.close();
    }
}
