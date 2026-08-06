package com.bytedance.trae.conversation.devices.flow;

import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFlowStore.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;", "", "<init>", "()V", "requests", "", "", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;", "put", OauthTokenTriggerScene.REQUEST, "get", "key", "remove", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceFlowStore {
    public static final DeviceFlowStore INSTANCE = new DeviceFlowStore();
    private static final Map<String, DeviceFlowRequest> requests = new LinkedHashMap();

    private DeviceFlowStore() {
    }

    public final String put(DeviceFlowRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        requests.put(uuid, request);
        return uuid;
    }

    public final DeviceFlowRequest get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return requests.get(key);
    }

    public final void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        requests.remove(key);
    }
}
