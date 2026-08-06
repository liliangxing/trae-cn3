package com.bytedance.android.anniex.worker;

import androidx.core.app.NotificationCompat;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.sdk.xbridge.cn.protocol.BaseBridgeHandler;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkerReadableMapBridgeHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/worker/WorkerReadableMapBridgeHandler;", "Lcom/bytedance/sdk/xbridge/cn/protocol/BaseBridgeHandler;", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "()V", "namespace", "", "processor", "Lcom/bytedance/android/anniex/worker/WorkerPlatformDataProcessor;", "getProcessor", "()Lcom/bytedance/android/anniex/worker/WorkerPlatformDataProcessor;", "createErrorDataRaw", "code", "", "message", "setNamespace", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WorkerReadableMapBridgeHandler extends BaseBridgeHandler<ReadableMap, ReadableMap> {
    private final WorkerPlatformDataProcessor processor = new WorkerPlatformDataProcessor();
    private String namespace = "";

    /* renamed from: getProcessor, reason: from getter and merged with bridge method [inline-methods] */
    public WorkerPlatformDataProcessor m3470getProcessor() {
        return this.processor;
    }

    public final void setNamespace(String namespace) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        this.namespace = namespace;
    }

    /* renamed from: createErrorDataRaw, reason: merged with bridge method [inline-methods] */
    public ReadableMap m3469createErrorDataRaw(int code, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        String str = this.namespace;
        if (Intrinsics.areEqual(str, "webcast") ? true : Intrinsics.areEqual(str, "host")) {
            HashMap hashMap = new HashMap();
            hashMap.put("__msg_type", "callback");
            hashMap.put("eventId", 0);
            hashMap.put("__callback_id", "0");
            hashMap.put("code", Integer.valueOf(code));
            Map javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.put(NotificationCompat.CATEGORY_MESSAGE, message);
            Unit unit = Unit.INSTANCE;
            hashMap.put(Constants.KEY_DATA, javaOnlyMap);
            ReadableMap from = JavaOnlyMap.from(hashMap);
            Intrinsics.checkNotNullExpressionValue(from, "from(hashMapOf<String, A…    })\n                })");
            return from;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("code", Integer.valueOf(code));
        hashMap2.put(NotificationCompat.CATEGORY_MESSAGE, message);
        ReadableMap from2 = JavaOnlyMap.from(hashMap2);
        Intrinsics.checkNotNullExpressionValue(from2, "from(hashMapOf<String, A…ssage)\n                })");
        return from2;
    }
}
