package com.bytedance.vcloud.uniplayer;

import com.bytedance.vcloud.impl.UniAvSceneBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniAvScene.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniAvScene;", "Ljava/lang/AutoCloseable;", "sceneId", "", "bridge", "Lcom/bytedance/vcloud/impl/UniAvSceneBridge;", "(Ljava/lang/String;Lcom/bytedance/vcloud/impl/UniAvSceneBridge;)V", "getBridge$uniplayer_release", "()Lcom/bytedance/vcloud/impl/UniAvSceneBridge;", "getSceneId", "()Ljava/lang/String;", "close", "", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UniAvScene implements AutoCloseable {
    private final UniAvSceneBridge bridge;
    private final String sceneId;

    public UniAvScene(String sceneId, UniAvSceneBridge bridge) {
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        this.sceneId = sceneId;
        this.bridge = bridge;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    /* renamed from: getBridge$uniplayer_release, reason: from getter */
    public final UniAvSceneBridge getBridge() {
        return this.bridge;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.bridge.close();
    }
}
