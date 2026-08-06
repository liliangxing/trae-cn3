package com.bytedance.trae.network;

import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: TraeRequestEventReporter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\rJ&\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/network/TraeRequestEventReporter;", "", "<init>", "()V", "report", "", "interceptorPath", "", "costTime", "", "code", "message", "headers", "", "firstHeader", "name", "parseServerTimingDuration", "", "value", "(Ljava/lang/String;)Ljava/lang/Double;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeRequestEventReporter {
    public static final TraeRequestEventReporter INSTANCE = new TraeRequestEventReporter();

    private TraeRequestEventReporter() {
    }

    public final void report(String interceptorPath, long costTime, long code, String message, Map<String, String> headers) {
        Double parseServerTimingDuration;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(headers, "headers");
        JSONObject jSONObject = new JSONObject();
        if (interceptorPath == null) {
            interceptorPath = "";
        }
        jSONObject.put("path", interceptorPath);
        jSONObject.put("cost_time", costTime);
        jSONObject.put("code", code);
        jSONObject.put("msg", message);
        TraeRequestEventReporter traeRequestEventReporter = INSTANCE;
        String firstHeader = traeRequestEventReporter.firstHeader(headers, "x-tt-logid");
        if (firstHeader != null) {
            jSONObject.put(CronetDataStorageAccess.LOGID, firstHeader);
        }
        String firstHeader2 = traeRequestEventReporter.firstHeader(headers, "server-timing");
        if (firstHeader2 != null && (parseServerTimingDuration = traeRequestEventReporter.parseServerTimingDuration(firstHeader2)) != null) {
            jSONObject.put("inner_duration", parseServerTimingDuration.doubleValue());
        }
        IApplog.Companion.reportEvent("solo_request_event", jSONObject);
    }

    private final String firstHeader(Map<String, String> headers, String name) {
        Object obj;
        Iterator<T> it = headers.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt.equals((String) ((Map.Entry) obj).getKey(), name, true)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            return (String) entry.getValue();
        }
        return null;
    }

    private final Double parseServerTimingDuration(String value) {
        List groupValues;
        String str;
        MatchResult find$default = Regex.find$default(new Regex("dur=([\\d.]+)"), value, 0, 2, (Object) null);
        if (find$default == null || (groupValues = find$default.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues, 1)) == null) {
            return null;
        }
        return StringsKt.toDoubleOrNull(str);
    }
}
