package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.android.monitorV2.constant.ReportConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PrefetchResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toPrefetchResult", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchResult;", "", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PrefetchResultKt {
    public static final PrefetchResult toPrefetchResult(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        JSONObject jSONObject = new JSONObject(str);
        PrefetchResult prefetchResult = new PrefetchResult();
        prefetchResult.setHttpCode(Integer.valueOf(jSONObject.optInt("httpCode", -1)));
        prefetchResult.setClientCode(Integer.valueOf(jSONObject.optInt("clientCode", -1)));
        prefetchResult.setHeader(PrefetchConfigKt.toStringMap(jSONObject.optJSONObject("header")));
        prefetchResult.setBody(jSONObject.optJSONObject(ReportConst.ValidationReport.BODY));
        if (jSONObject.has("requestStartTimestamp")) {
            prefetchResult.setRequestStartTimestamp(Long.valueOf(jSONObject.optLong("requestStartTimestamp")));
        }
        if (jSONObject.has("requestFinishTimestamp")) {
            prefetchResult.setRequestFinishTimestamp(Long.valueOf(jSONObject.optLong("requestFinishTimestamp")));
        }
        if (jSONObject.has("expireMs")) {
            prefetchResult.setExpireMs(Long.valueOf(jSONObject.optLong("expireMs")));
        }
        if (jSONObject.has("expireTimestamp")) {
            prefetchResult.setExpireTimestamp(Long.valueOf(jSONObject.optLong("expireTimestamp")));
        }
        prefetchResult.setGlobalPropsName(jSONObject.optString("globalPropsName", null));
        return prefetchResult;
    }
}
