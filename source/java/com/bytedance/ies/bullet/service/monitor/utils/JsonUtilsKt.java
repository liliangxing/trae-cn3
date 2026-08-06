package com.bytedance.ies.bullet.service.monitor.utils;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.push.interfaze.IPushService;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: JsonUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u0004H\u0000\u001a\u0016\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0000¨\u0006\t"}, d2 = {"forEach", "", "Lorg/json/JSONObject;", "handler", "Lkotlin/Function2;", "", "", "wrap", "json", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class JsonUtilsKt {
    public static final void forEach(JSONObject jSONObject, Function2<? super String, Object, Unit> function2) {
        Object obj;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(function2, "handler");
        try {
            Result.Companion companion = Result.Companion;
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNullExpressionValue(next, "key");
                function2.invoke(next, jSONObject.get(next));
            }
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            BulletLogger.INSTANCE.printLog("JsonUtils.forEach " + th2.getMessage(), LogLevel.E, IPushService.TAG_PUSH_MONITOR);
        }
    }

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
