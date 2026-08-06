package com.bytedance.sdk.xbridge.cn.platform.lynx;

import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import com.bytedance.sdk.xbridge.cn.protocol.BaseBridgeHandler;
import com.bytedance.sdk.xbridge.cn.protocol.IPlatformDataProcessor;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReadableMapBridgeHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/lynx/ReadableMapBridgeHandler;", "Lcom/bytedance/sdk/xbridge/cn/protocol/BaseBridgeHandler;", "Lcom/lynx/react/bridge/ReadableMap;", "", "()V", LynxBridgeCall.NAME_SPACE, "", "processor", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxPlatformDataProcessor;", "getProcessor", "()Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxPlatformDataProcessor;", "createErrorDataRaw", "code", "", "message", "setNamespace", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ReadableMapBridgeHandler extends BaseBridgeHandler<ReadableMap, Object> {
    private final LynxPlatformDataProcessor processor = new LynxPlatformDataProcessor();
    private String namespace = "";

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BaseBridgeHandler
    /* renamed from: getProcessor */
    public IPlatformDataProcessor<ReadableMap, Object> getProcessor2() {
        return this.processor;
    }

    public final void setNamespace(String namespace) {
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        this.namespace = namespace;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BaseBridgeHandler
    public Object createErrorDataRaw(int code, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        String str = this.namespace;
        if (Intrinsics.areEqual(str, "webcast") ? true : Intrinsics.areEqual(str, PermissionConfigParser.WEBCAST_HOST_NAMESPACE)) {
            HashMap hashMap = new HashMap();
            hashMap.put("__msg_type", "callback");
            hashMap.put("eventId", 0);
            hashMap.put("__callback_id", "0");
            hashMap.put("code", Integer.valueOf(code));
            Map javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.put("msg", message);
            Unit unit = Unit.INSTANCE;
            hashMap.put("data", javaOnlyMap);
            ReadableMap from = JavaOnlyMap.from(hashMap);
            Intrinsics.checkNotNullExpressionValue(from, "from(hashMapOf<String, A…    })\n                })");
            return from;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("code", Integer.valueOf(code));
        hashMap2.put("msg", message);
        ReadableMap from2 = JavaOnlyMap.from(hashMap2);
        Intrinsics.checkNotNullExpressionValue(from2, "from(hashMapOf<String, A…ssage)\n                })");
        return from2;
    }
}
