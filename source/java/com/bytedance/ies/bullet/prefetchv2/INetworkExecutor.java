package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.lynx.tasm.LynxError;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: INetworkExecutor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013JJ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH'JZ\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH'¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/INetworkExecutor;", "", "get", "", "url", "", "headers", "", "needCommonParams", "", "extras", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ies/bullet/prefetchv2/INetworkExecutor$Callback;", "post", DBDefinition.MIME_TYPE, ReportConst.ValidationReport.BODY, "Lorg/json/JSONObject;", "Callback", "HttpResponse", "StreamCallback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface INetworkExecutor {

    /* compiled from: INetworkExecutor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/INetworkExecutor$Callback;", "", "onRequestFailed", "", LynxError.LYNX_THROWABLE, "", "onRequestSucceed", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/ies/bullet/prefetchv2/INetworkExecutor$HttpResponse;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Callback {
        void onRequestFailed(Throwable throwable);

        void onRequestSucceed(HttpResponse response);
    }

    /* compiled from: INetworkExecutor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/INetworkExecutor$StreamCallback;", "", "onReceiveResponse", "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/ies/bullet/prefetchv2/INetworkExecutor$HttpResponse;", "onRequestFailed", LynxError.LYNX_THROWABLE, "", "onRequestSucceed", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface StreamCallback {
        void onReceiveResponse(HttpResponse response);

        void onRequestFailed(Throwable throwable);

        void onRequestSucceed(HttpResponse response);
    }

    void get(String url, Map<String, String> headers, boolean needCommonParams, Map<String, String> extras, Callback callback);

    void post(String url, Map<String, String> headers, String mimeType, JSONObject body, boolean needCommonParams, Map<String, String> extras, Callback callback);

    /* compiled from: INetworkExecutor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%J\n\u0010\u0006\u001a\u0004\u0018\u00010\u000bH\u0002J\r\u0010&\u001a\u00020$H\u0000¢\u0006\u0002\b'R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015¨\u0006("}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/INetworkExecutor$HttpResponse;", "", "()V", ReportConst.ValidationReport.BODY, "", "getBody$annotations", "getBody", "()[B", "setBody", "([B)V", "bodyString", "", "getBodyString", "()Ljava/lang/String;", "setBodyString", "(Ljava/lang/String;)V", "cached", "", "getCached", "()I", "setCached", "(I)V", "extra", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "headerMap", "getHeaderMap", "setHeaderMap", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "getStatusCode", "setStatusCode", "fromJSONObject", "jsonObject", "Lorg/json/JSONObject;", "fromJSONObject$anniex_release", "toJSONObject", "toJSONObject$anniex_release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static class HttpResponse {
        private byte[] body;
        private String bodyString;
        private int cached;
        private Map<String, String> extra;
        private Map<String, String> headerMap;
        private int statusCode = -1;

        @Deprecated(message = "Please use 'bodyString'.")
        public static /* synthetic */ void getBody$annotations() {
        }

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

        private final String getBody() {
            String str = this.bodyString;
            if (str != null) {
                return str;
            }
            byte[] bArr = this.body;
            if (bArr != null) {
                this.bodyString = new String(bArr, Charsets.UTF_8);
            }
            return this.bodyString;
        }

        public final JSONObject toJSONObject$anniex_release() {
            JSONObject jSONObject = new JSONObject();
            Map<String, String> map = this.headerMap;
            jSONObject.put("headers", map != null ? ExtKt.toJSONObject(map) : null);
            jSONObject.put(ReportConst.ValidationReport.BODY, getBody());
            jSONObject.put("status_code", this.statusCode);
            Map<String, String> map2 = this.extra;
            jSONObject.put("extra", map2 != null ? ExtKt.toJSONObject(map2) : null);
            return jSONObject;
        }

        public final HttpResponse fromJSONObject$anniex_release(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            HttpResponse httpResponse = new HttpResponse();
            JSONObject optJSONObject = jsonObject.optJSONObject("headers");
            httpResponse.headerMap = optJSONObject != null ? PrefetchConfigKt.toStringMap(optJSONObject) : null;
            httpResponse.bodyString = jsonObject.optString(ReportConst.ValidationReport.BODY);
            httpResponse.statusCode = jsonObject.optInt("status_code");
            JSONObject optJSONObject2 = jsonObject.optJSONObject("extra");
            httpResponse.extra = optJSONObject2 != null ? PrefetchConfigKt.toStringMap(optJSONObject2) : null;
            return httpResponse;
        }
    }
}
