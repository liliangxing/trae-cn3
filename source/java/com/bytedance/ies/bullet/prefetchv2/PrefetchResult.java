package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.android.monitorV2.constant.ReportConst;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PrefetchResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010>\u001a\u000209J\u001f\u0010>\u001a\u0002092\b\u0010?\u001a\u0004\u0018\u00010\u001d2\b\u0010@\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010AR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010#\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001c\u0010&\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010\u001bR(\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b0\u0010\u0012\"\u0004\b1\u0010\u0014R\u001e\u00102\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b3\u0010\u001f\"\u0004\b4\u0010!R\u001e\u00105\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u0010!R\u001a\u00108\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006B"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchResult;", "", "()V", ReportConst.ValidationReport.BODY, "Lorg/json/JSONObject;", "getBody", "()Lorg/json/JSONObject;", "setBody", "(Lorg/json/JSONObject;)V", "byteArrayOutputStream", "Ljava/io/ByteArrayOutputStream;", "getByteArrayOutputStream", "()Ljava/io/ByteArrayOutputStream;", "setByteArrayOutputStream", "(Ljava/io/ByteArrayOutputStream;)V", "clientCode", "", "getClientCode", "()Ljava/lang/Integer;", "setClientCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "configFrom", "", "getConfigFrom", "()Ljava/lang/String;", "setConfigFrom", "(Ljava/lang/String;)V", "expireMs", "", "getExpireMs", "()Ljava/lang/Long;", "setExpireMs", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "expireTimestamp", "getExpireTimestamp", "setExpireTimestamp", "globalPropsName", "getGlobalPropsName", "setGlobalPropsName", "header", "", "getHeader", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "httpCode", "getHttpCode", "setHttpCode", "requestFinishTimestamp", "getRequestFinishTimestamp", "setRequestFinishTimestamp", "requestStartTimestamp", "getRequestStartTimestamp", "setRequestStartTimestamp", "streamRequestFinish", "", "getStreamRequestFinish", "()Z", "setStreamRequestFinish", "(Z)V", "isExpire", "expireMillis", "expireTs", "(Ljava/lang/Long;Ljava/lang/Long;)Z", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PrefetchResult {
    private JSONObject body;
    private ByteArrayOutputStream byteArrayOutputStream;
    private Integer clientCode;
    private String configFrom = "unknown";
    private Long expireMs;
    private Long expireTimestamp;
    private String globalPropsName;
    private Map<String, String> header;
    private Integer httpCode;
    private Long requestFinishTimestamp;
    private Long requestStartTimestamp;
    private boolean streamRequestFinish;

    public final Integer getHttpCode() {
        return this.httpCode;
    }

    public final void setHttpCode(Integer num) {
        this.httpCode = num;
    }

    public final Integer getClientCode() {
        return this.clientCode;
    }

    public final void setClientCode(Integer num) {
        this.clientCode = num;
    }

    public final Map<String, String> getHeader() {
        return this.header;
    }

    public final void setHeader(Map<String, String> map) {
        this.header = map;
    }

    public final JSONObject getBody() {
        return this.body;
    }

    public final void setBody(JSONObject jSONObject) {
        this.body = jSONObject;
    }

    public final Long getRequestStartTimestamp() {
        return this.requestStartTimestamp;
    }

    public final void setRequestStartTimestamp(Long l) {
        this.requestStartTimestamp = l;
    }

    public final Long getRequestFinishTimestamp() {
        return this.requestFinishTimestamp;
    }

    public final void setRequestFinishTimestamp(Long l) {
        this.requestFinishTimestamp = l;
    }

    public final Long getExpireMs() {
        return this.expireMs;
    }

    public final void setExpireMs(Long l) {
        this.expireMs = l;
    }

    public final Long getExpireTimestamp() {
        return this.expireTimestamp;
    }

    public final void setExpireTimestamp(Long l) {
        this.expireTimestamp = l;
    }

    public final String getGlobalPropsName() {
        return this.globalPropsName;
    }

    public final void setGlobalPropsName(String str) {
        this.globalPropsName = str;
    }

    public final String getConfigFrom() {
        return this.configFrom;
    }

    public final void setConfigFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.configFrom = str;
    }

    public final ByteArrayOutputStream getByteArrayOutputStream() {
        return this.byteArrayOutputStream;
    }

    public final void setByteArrayOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
        this.byteArrayOutputStream = byteArrayOutputStream;
    }

    public final boolean getStreamRequestFinish() {
        return this.streamRequestFinish;
    }

    public final void setStreamRequestFinish(boolean z) {
        this.streamRequestFinish = z;
    }

    public final boolean isExpire() {
        return isExpire(this.expireMs, this.expireTimestamp);
    }

    public final boolean isExpire(Long expireMillis, Long expireTs) {
        Long l = this.requestStartTimestamp;
        if (l == null) {
            return true;
        }
        long longValue = l.longValue();
        long longValue2 = expireMillis != null ? expireMillis.longValue() : 30000L;
        long currentTimeMillis = System.currentTimeMillis();
        return ((((currentTimeMillis - longValue2) - longValue) > 0L ? 1 : (((currentTimeMillis - longValue2) - longValue) == 0L ? 0 : -1)) > 0) || (expireTs != null && (currentTimeMillis > expireTs.longValue() ? 1 : (currentTimeMillis == expireTs.longValue() ? 0 : -1)) > 0);
    }
}
