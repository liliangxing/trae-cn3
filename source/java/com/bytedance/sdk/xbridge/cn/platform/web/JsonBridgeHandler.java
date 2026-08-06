package com.bytedance.sdk.xbridge.cn.platform.web;

import com.bytedance.sdk.xbridge.cn.protocol.BaseBridgeHandler;
import com.bytedance.sdk.xbridge.cn.protocol.IPlatformDataProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: JsonBridgeHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/web/JsonBridgeHandler;", "Lcom/bytedance/sdk/xbridge/cn/protocol/BaseBridgeHandler;", "Lorg/json/JSONObject;", "()V", "processor", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebPlatformDataProcessor;", "getProcessor", "()Lcom/bytedance/sdk/xbridge/cn/platform/web/WebPlatformDataProcessor;", "createErrorDataRaw", "code", "", "message", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class JsonBridgeHandler extends BaseBridgeHandler<JSONObject, JSONObject> {
    private final WebPlatformDataProcessor processor = new WebPlatformDataProcessor();

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BaseBridgeHandler
    /* renamed from: getProcessor, reason: merged with bridge method [inline-methods] */
    public IPlatformDataProcessor<JSONObject, JSONObject> getProcessor2() {
        return this.processor;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BaseBridgeHandler
    public JSONObject createErrorDataRaw(int code, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        jSONObject.put("msg", message);
        return jSONObject;
    }
}
