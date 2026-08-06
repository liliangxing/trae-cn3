package com.bytedance.salamander.anniex;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.rts.foundation.RTSMapKt;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: AnniexMonitorUtilsUriParamsFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¨\u0006\u0005"}, d2 = {"findSchemaQueryParams", "", "", "Lcom/bytedance/rts/foundation/RTSMap;", "schema", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class AnniexMonitorUtilsUriParamsFinderKt {
    public static final Map<String, String> findSchemaQueryParams(String str) {
        AnnieXUri createUri;
        Map<String, String> RTSMap = RTSMapKt.RTSMap();
        if (str == null || (createUri = AnnieXUri.INSTANCE.createUri(str)) == null) {
            return RTSMap;
        }
        String queryParameter = createUri.getQueryParameter(SchemaConstants.HYBRID_MONITOR_BIZ_ID);
        if (queryParameter != null && queryParameter.length() > 0) {
            RTSMapKt.set(RTSMap, "bid", queryParameter);
        }
        String queryParameter2 = createUri.getQueryParameter("bdhm_pid");
        if (queryParameter2 != null && queryParameter2.length() > 0) {
            RTSMapKt.set(RTSMap, "pid", queryParameter2);
        }
        return RTSMap;
    }
}
