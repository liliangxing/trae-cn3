package com.bytedance.android.monitorV2.dedupcheck;

import android.text.TextUtils;
import com.bytedance.android.monitorV2.DataReporter;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.webview.IHybridMonitor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: DataDeduplicationManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0006\u001e\u001f !\"#B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J4\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0018J0\u0010\u001d\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/android/monitorV2/dedupcheck/DataDeduplicationManager;", "", "()V", "deDupHandlerMap", "", "", "Lcom/bytedance/android/monitorV2/dedupcheck/DataDeduplicationManager$ICheckHandler;", "lastData", "Lorg/json/JSONObject;", "lastDeDupKey", "lastMonitor", "Lcom/bytedance/android/monitorV2/webview/IHybridMonitor;", "latestContainerType", "latestEventType", "nativeRepeatCount", "", "generateKey", "jsonObj", "eventType", "containerType", "isNeedCheck", "", "deDupKey", "postData", "", "monitor", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "tryUploadBuffer", "updateLatestData", "CustomCheckHandler", "FetchErrorCheckHandler", "ICheckHandler", "JSBErrorCheckHandler", "JSBPerfCheckHandler", "NativeErrorCheckHandler", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class DataDeduplicationManager {
    private final Map<String, ICheckHandler> deDupHandlerMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("jsbError", new JSBErrorCheckHandler()), TuplesKt.to("fetchError", new FetchErrorCheckHandler()), TuplesKt.to("nativeError", new NativeErrorCheckHandler()), TuplesKt.to("jsbPerf", new JSBPerfCheckHandler()), TuplesKt.to("custom", new CustomCheckHandler())});
    private JSONObject lastData;
    private String lastDeDupKey;
    private IHybridMonitor lastMonitor;
    private String latestContainerType;
    private String latestEventType;
    private int nativeRepeatCount;

    /* compiled from: DataDeduplicationManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/dedupcheck/DataDeduplicationManager$ICheckHandler;", "", "isDeDup", "", "lastJsonObj", "Lorg/json/JSONObject;", "jsonObj", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface ICheckHandler {
        boolean isDeDup(JSONObject lastJsonObj, JSONObject jsonObj);
    }

    public static /* synthetic */ void postData$default(DataDeduplicationManager dataDeduplicationManager, IHybridMonitor iHybridMonitor, JSONObject jSONObject, String str, String str2, HybridEvent hybridEvent, int i, Object obj) {
        if ((i & 16) != 0) {
            hybridEvent = null;
        }
        dataDeduplicationManager.postData(iHybridMonitor, jSONObject, str, str2, hybridEvent);
    }

    public final void postData(IHybridMonitor monitor, JSONObject jsonObj, String eventType, String containerType, HybridEvent event) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(containerType, "containerType");
        String generateKey = generateKey(jsonObj, eventType, containerType);
        if (this.deDupHandlerMap.containsKey(eventType) && isNeedCheck(generateKey)) {
            ICheckHandler iCheckHandler = this.deDupHandlerMap.get(eventType);
            if (iCheckHandler != null) {
                if (iCheckHandler.isDeDup(this.lastData, jsonObj)) {
                    this.nativeRepeatCount++;
                    if (event != null) {
                        event.onEventTerminated(HybridEvent.TerminateType.EVENT_REPEATED);
                    }
                } else {
                    tryUploadBuffer();
                    DataReporter.INSTANCE.realMonitor(monitor, jsonObj, eventType, containerType, event);
                }
            }
        } else {
            tryUploadBuffer();
            DataReporter.INSTANCE.realMonitor(monitor, jsonObj, eventType, containerType, event);
        }
        updateLatestData(monitor, jsonObj, eventType, containerType);
    }

    private final void updateLatestData(IHybridMonitor monitor, JSONObject jsonObj, String eventType, String containerType) {
        this.lastMonitor = monitor;
        this.lastData = jsonObj;
        this.latestEventType = eventType;
        this.latestContainerType = containerType;
    }

    public final void tryUploadBuffer() {
        int i = this.nativeRepeatCount;
        if (i > 0) {
            JsonUtils.safePut(this.lastData, ReportConst.Params.NATIVE_REPEAT_COUNT, i);
            DataReporter.realMonitor$default(DataReporter.INSTANCE, this.lastMonitor, this.lastData, this.latestEventType, this.latestContainerType, null, 16, null);
            this.nativeRepeatCount = 0;
        }
    }

    private final boolean isNeedCheck(String deDupKey) {
        return TextUtils.equals(deDupKey, this.lastDeDupKey);
    }

    private final String generateKey(JSONObject jsonObj, String eventType, String containerType) {
        if (TextUtils.equals("custom", eventType)) {
            return "custom";
        }
        return containerType + '_' + eventType + '_' + JsonUtils.safeOptStr(JsonUtils.safeOptJsonObj(jsonObj, "nativeBase"), "navigation_id");
    }

    /* compiled from: DataDeduplicationManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/monitorV2/dedupcheck/DataDeduplicationManager$JSBErrorCheckHandler;", "Lcom/bytedance/android/monitorV2/dedupcheck/DataDeduplicationManager$ICheckHandler;", "()V", "isDeDup", "", "lastJsonObj", "Lorg/json/JSONObject;", "jsonObj", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class JSBErrorCheckHandler implements ICheckHandler {
        @Override // com.bytedance.android.monitorV2.dedupcheck.DataDeduplicationManager.ICheckHandler
        public boolean isDeDup(JSONObject lastJsonObj, JSONObject jsonObj) {
            return JsonUtils.safeCompareArgs(JsonUtils.safeOptJsonObj(jsonObj, "nativeInfo"), JsonUtils.safeOptJsonObj(lastJsonObj, "nativeInfo"), "bridge_name", "error_code", "error_message");
        }
    }

    /* compiled from: DataDeduplicationManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/monitorV2/dedupcheck/DataDeduplicationManager$FetchErrorCheckHandler;", "Lcom/bytedance/android/monitorV2/dedupcheck/DataDeduplicationManager$ICheckHandler;", "()V", "isDeDup", "", "lastJsonObj", "Lorg/json/JSONObject;", "jsonObj", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class FetchErrorCheckHandler implements ICheckHandler {
        @Override // com.bytedance.android.monitorV2.dedupcheck.DataDeduplicationManager.ICheckHandler
        public boolean isDeDup(JSONObject lastJsonObj, JSONObject jsonObj) {
            return JsonUtils.safeCompareArgs(JsonUtils.safeOptJsonObj(jsonObj, "nativeInfo"), JsonUtils.safeOptJsonObj(lastJsonObj, "nativeInfo"), "url", "method", "status_code", "request_error_code", "request_error_msg", "error_no", "error_msg");
        }
    }

    /* compiled from: DataDeduplicationManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/monitorV2/dedupcheck/DataDeduplicationManager$NativeErrorCheckHandler;", "Lcom/bytedance/android/monitorV2/dedupcheck/DataDeduplicationManager$ICheckHandler;", "()V", "isDeDup", "", "lastJsonObj", "Lorg/json/JSONObject;", "jsonObj", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class NativeErrorCheckHandler implements ICheckHandler {
        @Override // com.bytedance.android.monitorV2.dedupcheck.DataDeduplicationManager.ICheckHandler
        public boolean isDeDup(JSONObject lastJsonObj, JSONObject jsonObj) {
            return JsonUtils.safeCompareArgs(JsonUtils.safeOptJsonObj(jsonObj, "nativeInfo"), JsonUtils.safeOptJsonObj(lastJsonObj, "nativeInfo"), "scene", "error_code", "error_msg", "http_status");
        }
    }

    /* compiled from: DataDeduplicationManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/monitorV2/dedupcheck/DataDeduplicationManager$JSBPerfCheckHandler;", "Lcom/bytedance/android/monitorV2/dedupcheck/DataDeduplicationManager$ICheckHandler;", "()V", "isDeDup", "", "lastJsonObj", "Lorg/json/JSONObject;", "jsonObj", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class JSBPerfCheckHandler implements ICheckHandler {
        @Override // com.bytedance.android.monitorV2.dedupcheck.DataDeduplicationManager.ICheckHandler
        public boolean isDeDup(JSONObject lastJsonObj, JSONObject jsonObj) {
            return JsonUtils.safeCompareArgs(JsonUtils.safeOptJsonObj(jsonObj, "nativeInfo"), JsonUtils.safeOptJsonObj(lastJsonObj, "nativeInfo"), "bridge_name", "status_code", "status_description");
        }
    }

    /* compiled from: DataDeduplicationManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/monitorV2/dedupcheck/DataDeduplicationManager$CustomCheckHandler;", "Lcom/bytedance/android/monitorV2/dedupcheck/DataDeduplicationManager$ICheckHandler;", "()V", "isDeDup", "", "lastJsonObj", "Lorg/json/JSONObject;", "jsonObj", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class CustomCheckHandler implements ICheckHandler {
        @Override // com.bytedance.android.monitorV2.dedupcheck.DataDeduplicationManager.ICheckHandler
        public boolean isDeDup(JSONObject lastJsonObj, JSONObject jsonObj) {
            return JsonUtils.safeCompare(jsonObj, lastJsonObj);
        }
    }
}
