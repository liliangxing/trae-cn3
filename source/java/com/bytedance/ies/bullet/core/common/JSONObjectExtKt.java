package com.bytedance.ies.bullet.core.common;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.push.interfaze.IPushService;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: JSONObjectExt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0003"}, d2 = {"wrap", "Lorg/json/JSONObject;", "json", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class JSONObjectExtKt {
    public static final JSONObject wrap(JSONObject jSONObject, JSONObject jSONObject2) {
        Object obj;
        Unit unit;
        Iterator<String> keys;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            if (jSONObject2 == null || (keys = jSONObject2.keys()) == null) {
                unit = null;
            } else {
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.opt(next));
                }
                unit = Unit.INSTANCE;
            }
            obj = Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            BulletLogger.INSTANCE.printLog("JsonUtils.wrap " + th2.getMessage(), LogLevel.E, IPushService.TAG_PUSH_MONITOR);
        }
        return jSONObject;
    }
}
