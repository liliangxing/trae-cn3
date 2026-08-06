package com.bytedance.ies.bullet.lynx.model;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LynxCommonData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"wrapLynxCommonData", "", "", "", "", "data", "Lcom/bytedance/ies/bullet/lynx/model/LynxCommonData;", "Lorg/json/JSONObject;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxCommonDataKt {
    public static final void wrapLynxCommonData(Map<String, Object> map, LynxCommonData data) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        map.put("containerID", data.getContainerID());
        map.put(SchemaConstants.INNER_PARAM_PROTOCOL_VERSION, data.getProtocolVersion());
    }

    public static final void wrapLynxCommonData(JSONObject jSONObject, LynxCommonData data) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        jSONObject.put("containerID", data.getContainerID());
        jSONObject.put(SchemaConstants.INNER_PARAM_PROTOCOL_VERSION, data.getProtocolVersion());
    }
}
