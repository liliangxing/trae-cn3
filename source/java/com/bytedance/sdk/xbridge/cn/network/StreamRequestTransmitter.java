package com.bytedance.sdk.xbridge.cn.network;

import android.util.Base64;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.prefetchv2.PrefetchResult;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.io.ByteArrayOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StreamRequestTransmitter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/network/StreamRequestTransmitter;", "", "()V", "transmitByCache", "", "sessionId", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "prefetchResult", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchResult;", "transmitByProgress", "", "startIndex", "transmitError", "e", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class StreamRequestTransmitter {
    public static final StreamRequestTransmitter INSTANCE = new StreamRequestTransmitter();

    private StreamRequestTransmitter() {
    }

    public final void transmitByCache(String sessionId, IBDXBridgeContext bridgeContext, PrefetchResult prefetchResult) {
        int i;
        ByteArrayOutputStream byteArrayOutputStream;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        if (prefetchResult == null || (byteArrayOutputStream = prefetchResult.getByteArrayOutputStream()) == null) {
            i = 0;
        } else {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "_byteArrayOutputStream.toByteArray()");
            i = byteArray.length;
            String encodeToString = Base64.encodeToString(byteArray, 2);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("streamLoadType", 1);
            linkedHashMap.put("content-range", "bytes=0-" + i);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "data");
            linkedHashMap.put("data", encodeToString);
            linkedHashMap.put("length", Integer.valueOf(encodeToString.length()));
            linkedHashMap.put("streamSessionId", sessionId);
            linkedHashMap.put("stage", "inProgress");
            linkedHashMap.put("dataType", "base64");
            Unit unit = Unit.INSTANCE;
            bridgeContext.sendEvent("x.requestChunkData", linkedHashMap);
            HybridLogger.i$default(HybridLogger.INSTANCE, "XPrefetch", "发送流式 Prefetch 全部缓存数据 size = " + i, (Map) null, (LoggerContext) null, 12, (Object) null);
        }
        if (prefetchResult != null && prefetchResult.getStreamRequestFinish()) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("streamLoadType", 1);
            linkedHashMap2.put("length", Integer.valueOf(i));
            linkedHashMap2.put("stage", "complete");
            linkedHashMap2.put("streamSessionId", sessionId);
            linkedHashMap2.put("dataType", "base64");
            Unit unit2 = Unit.INSTANCE;
            bridgeContext.sendEvent("x.requestChunkData", linkedHashMap2);
        }
    }

    public final synchronized int transmitByProgress(String sessionId, int startIndex, IBDXBridgeContext bridgeContext, PrefetchResult prefetchResult) {
        int i;
        ByteArrayOutputStream byteArrayOutputStream;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        if (prefetchResult == null || (byteArrayOutputStream = prefetchResult.getByteArrayOutputStream()) == null) {
            i = 0;
        } else {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "_byteArrayOutputStream.toByteArray()");
            i = byteArray.length;
            if (i > startIndex) {
                String encodeToString = Base64.encodeToString(byteArray, startIndex, byteArray.length - startIndex, 2);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(\n        …e64.NO_WRAP\n            )");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("streamLoadType", 1);
                linkedHashMap.put("data", encodeToString);
                linkedHashMap.put("content-range", "bytes=" + startIndex + '-' + i);
                linkedHashMap.put("length", Integer.valueOf(encodeToString.length()));
                linkedHashMap.put("streamSessionId", sessionId);
                linkedHashMap.put("stage", "inProgress");
                linkedHashMap.put("dataType", "base64");
                Integer clientCode = prefetchResult.getClientCode();
                linkedHashMap.put("clientCode", Integer.valueOf(clientCode != null ? clientCode.intValue() : 0));
                Integer httpCode = prefetchResult.getHttpCode();
                linkedHashMap.put("httpCode", Integer.valueOf(httpCode != null ? httpCode.intValue() : 0));
                Unit unit = Unit.INSTANCE;
                bridgeContext.sendEvent("x.requestChunkData", linkedHashMap);
                HybridLogger.i$default(HybridLogger.INSTANCE, "XPrefetch", "发送流式 Prefetch 部分缓存数据 index = " + startIndex + ", length = " + i, (Map) null, (LoggerContext) null, 12, (Object) null);
            }
        }
        if (prefetchResult != null && prefetchResult.getStreamRequestFinish()) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("streamLoadType", 1);
            linkedHashMap2.put("stage", "complete");
            linkedHashMap2.put("streamSessionId", sessionId);
            linkedHashMap2.put("dataType", "base64");
            Integer clientCode2 = prefetchResult.getClientCode();
            linkedHashMap2.put("clientCode", Integer.valueOf(clientCode2 != null ? clientCode2.intValue() : 0));
            Integer httpCode2 = prefetchResult.getHttpCode();
            linkedHashMap2.put("httpCode", Integer.valueOf(httpCode2 != null ? httpCode2.intValue() : 0));
            Unit unit2 = Unit.INSTANCE;
            bridgeContext.sendEvent("x.requestChunkData", linkedHashMap2);
        }
        return i;
    }

    public final void transmitError(String sessionId, IBDXBridgeContext bridgeContext, PrefetchResult prefetchResult, Throwable e) {
        Integer httpCode;
        Integer clientCode;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(e, "e");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("streamLoadType", 1);
        linkedHashMap.put("stage", "complete");
        linkedHashMap.put("streamSessionId", sessionId);
        linkedHashMap.put("dataType", "base64");
        int i = 0;
        linkedHashMap.put("clientCode", Integer.valueOf((prefetchResult == null || (clientCode = prefetchResult.getClientCode()) == null) ? 0 : clientCode.intValue()));
        if (prefetchResult != null && (httpCode = prefetchResult.getHttpCode()) != null) {
            i = httpCode.intValue();
        }
        linkedHashMap.put("httpCode", Integer.valueOf(i));
        String message = e.getMessage();
        if (message == null) {
            message = "un known error";
        }
        linkedHashMap.put("msg", message);
        Unit unit = Unit.INSTANCE;
        bridgeContext.sendEvent("x.requestChunkData", linkedHashMap);
    }
}
