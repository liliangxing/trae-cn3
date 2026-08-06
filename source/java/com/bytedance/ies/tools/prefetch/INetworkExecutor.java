package com.bytedance.ies.tools.prefetch;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.lynx.tasm.LynxError;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: Interfaces.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\u0017JJ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0017J<\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0017JZ\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0017¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/INetworkExecutor;", "", "get", "", "url", "", "headers", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ies/tools/prefetch/INetworkExecutor$Callback;", "needCommonParams", "", "extras", "post", DBDefinition.MIME_TYPE, ReportConst.ValidationReport.BODY, "Lorg/json/JSONObject;", "Callback", "HttpResponse", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public interface INetworkExecutor {

    /* compiled from: Interfaces.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/INetworkExecutor$Callback;", "", "onRequestFailed", "", LynxError.LYNX_THROWABLE, "", "onRequestSucceed", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/ies/tools/prefetch/INetworkExecutor$HttpResponse;", "prefetch_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes4.dex */
    public interface Callback {
        void onRequestFailed(Throwable throwable);

        void onRequestSucceed(HttpResponse response);
    }

    @Deprecated(message = "Please implement the other 'get' method.")
    void get(String url, Map<String, String> headers, Callback callback);

    void get(String url, Map<String, String> headers, boolean needCommonParams, Map<String, String> extras, Callback callback);

    @Deprecated(message = "Please implement the other 'post' method.")
    void post(String url, Map<String, String> headers, String mimeType, JSONObject body, Callback callback);

    void post(String url, Map<String, String> headers, String mimeType, JSONObject body, boolean needCommonParams, Map<String, String> extras, Callback callback);

    /* compiled from: Interfaces.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&J\u0010\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)H\u0007J\r\u0010*\u001a\u00020%H\u0000¢\u0006\u0002\b+R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016¨\u0006,"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/INetworkExecutor$HttpResponse;", "", "()V", ReportConst.ValidationReport.BODY, "", "getBody", "()[B", "setBody", "([B)V", "bodyAsString", "", "getBodyAsString", "()Ljava/lang/String;", "bodyString", "getBodyString", "setBodyString", "(Ljava/lang/String;)V", "cached", "", "getCached", "()I", "setCached", "(I)V", "extra", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "headerMap", "getHeaderMap", "setHeaderMap", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "getStatusCode", "setStatusCode", "fromJSONObject", "jsonObject", "Lorg/json/JSONObject;", "fromJSONObject$prefetch_release", "getFormattedJSONObject", "bodyIsString", "", "toJSONObject", "toJSONObject$prefetch_release", "prefetch_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes4.dex */
    public static class HttpResponse {
        private byte[] body;
        private String bodyString;
        private Map<String, String> extra;
        private Map<String, String> headerMap;
        private int statusCode = -1;
        private int cached = PrefetchProcess.HitState.FALLBACK.ordinal();

        public final byte[] getBody() {
            return this.body;
        }

        public final void setBody(byte[] bArr) {
            this.body = bArr;
        }

        public final String getBodyString() {
            return this.bodyString;
        }

        public final void setBodyString(String str) {
            this.bodyString = str;
        }

        public final Map<String, String> getHeaderMap() {
            return this.headerMap;
        }

        public final void setHeaderMap(Map<String, String> map) {
            this.headerMap = map;
        }

        public final int getStatusCode() {
            return this.statusCode;
        }

        public final void setStatusCode(int i) {
            this.statusCode = i;
        }

        public final Map<String, String> getExtra() {
            return this.extra;
        }

        public final void setExtra(Map<String, String> map) {
            this.extra = map;
        }

        public final int getCached() {
            return this.cached;
        }

        public final void setCached(int i) {
            this.cached = i;
        }

        public final String getBodyAsString() {
            String str = this.bodyString;
            if (str != null) {
                return str;
            }
            byte[] bArr = this.body;
            if (bArr == null) {
                return null;
            }
            String str2 = new String(bArr, Charsets.UTF_8);
            this.bodyString = str2;
            return str2;
        }

        @Deprecated(message = "Please build your json as you want.")
        public final JSONObject getFormattedJSONObject(boolean bodyIsString) {
            Object m10253constructorimpl;
            Object jSONObject;
            JSONObject jSONObject2 = new JSONObject();
            try {
                Result.Companion companion = Result.INSTANCE;
                if (bodyIsString) {
                    jSONObject = getBodyAsString();
                } else {
                    String bodyAsString = getBodyAsString();
                    jSONObject = bodyAsString != null ? new JSONObject(bodyAsString) : new JSONObject();
                }
                jSONObject2.put(AccountMonitorConstants.CommonParameter.RAW, jSONObject);
                jSONObject2.put("headers", UtilKt.toJSONObject(this.headerMap));
                jSONObject2.put("cached", this.cached);
                m10253constructorimpl = Result.m10253constructorimpl(jSONObject2.put("status_code", this.statusCode));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m10253constructorimpl = Result.m10253constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m10256exceptionOrNullimpl = Result.m10256exceptionOrNullimpl(m10253constructorimpl);
            if (m10256exceptionOrNullimpl != null) {
                LogUtil.INSTANCE.e("Format json error.", m10256exceptionOrNullimpl);
            }
            return jSONObject2;
        }

        public final JSONObject toJSONObject$prefetch_release() {
            JSONObject jSONObject = new JSONObject();
            Map<String, String> map = this.headerMap;
            jSONObject.put("headers", map != null ? UtilKt.toJSONObject(map) : null);
            jSONObject.put(ReportConst.ValidationReport.BODY, getBodyAsString());
            jSONObject.put("status_code", this.statusCode);
            Map<String, String> map2 = this.extra;
            jSONObject.put("extra", map2 != null ? UtilKt.toJSONObject(map2) : null);
            return jSONObject;
        }

        public final HttpResponse fromJSONObject$prefetch_release(JSONObject jsonObject) {
            Intrinsics.checkParameterIsNotNull(jsonObject, "jsonObject");
            HttpResponse httpResponse = new HttpResponse();
            JSONObject optJSONObject = jsonObject.optJSONObject("headers");
            httpResponse.headerMap = optJSONObject != null ? UtilKt.toStringMap(optJSONObject) : null;
            httpResponse.bodyString = jsonObject.optString(ReportConst.ValidationReport.BODY);
            httpResponse.statusCode = jsonObject.optInt("status_code");
            JSONObject optJSONObject2 = jsonObject.optJSONObject("extra");
            httpResponse.extra = optJSONObject2 != null ? UtilKt.toStringMap(optJSONObject2) : null;
            return httpResponse;
        }
    }

    /* compiled from: Interfaces.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        @Deprecated(message = "Please implement the other 'get' method.")
        public static void get(INetworkExecutor iNetworkExecutor, String url, Map<String, String> headers, Callback callback) {
            Intrinsics.checkParameterIsNotNull(url, "url");
            Intrinsics.checkParameterIsNotNull(headers, "headers");
            Intrinsics.checkParameterIsNotNull(callback, "callback");
        }

        @Deprecated(message = "Please implement the other 'post' method.")
        public static void post(INetworkExecutor iNetworkExecutor, String url, Map<String, String> headers, String mimeType, JSONObject body, Callback callback) {
            Intrinsics.checkParameterIsNotNull(url, "url");
            Intrinsics.checkParameterIsNotNull(headers, "headers");
            Intrinsics.checkParameterIsNotNull(mimeType, "mimeType");
            Intrinsics.checkParameterIsNotNull(body, "body");
            Intrinsics.checkParameterIsNotNull(callback, "callback");
        }

        public static void get(INetworkExecutor iNetworkExecutor, String url, Map<String, String> headers, boolean z, Map<String, String> map, Callback callback) {
            Intrinsics.checkParameterIsNotNull(url, "url");
            Intrinsics.checkParameterIsNotNull(headers, "headers");
            Intrinsics.checkParameterIsNotNull(callback, "callback");
            iNetworkExecutor.get(url, headers, callback);
        }

        public static void post(INetworkExecutor iNetworkExecutor, String url, Map<String, String> headers, String mimeType, JSONObject body, boolean z, Map<String, String> map, Callback callback) {
            Intrinsics.checkParameterIsNotNull(url, "url");
            Intrinsics.checkParameterIsNotNull(headers, "headers");
            Intrinsics.checkParameterIsNotNull(mimeType, "mimeType");
            Intrinsics.checkParameterIsNotNull(body, "body");
            Intrinsics.checkParameterIsNotNull(callback, "callback");
            iNetworkExecutor.post(url, headers, mimeType, body, callback);
        }
    }
}
