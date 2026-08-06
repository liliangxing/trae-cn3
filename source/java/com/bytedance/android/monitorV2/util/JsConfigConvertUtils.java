package com.bytedance.android.monitorV2.util;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: JsConfigConvertUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/monitorV2/util/JsConfigConvertUtils;", "", "()V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class JsConfigConvertUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: JsConfigConvertUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/monitorV2/util/JsConfigConvertUtils$Companion;", "", "()V", "convert", "Lorg/json/JSONObject;", "originObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JSONObject convert(JSONObject originObject) {
            JSONObject jSONObject = new JSONObject();
            if (originObject != null) {
                String pid = JsonUtils.safeOptStr(originObject, "pid");
                Intrinsics.checkNotNullExpressionValue(pid, "pid");
                if (pid.length() > 0) {
                    JsonUtils.safePut(jSONObject, "pid", pid);
                }
                String bid = JsonUtils.safeOptStr(originObject, "bid");
                Intrinsics.checkNotNullExpressionValue(bid, "bid");
                if (bid.length() > 0) {
                    JsonUtils.safePut(jSONObject, "bid", bid);
                }
                JSONObject safeOptJsonObj = JsonUtils.safeOptJsonObj(originObject, "context");
                if (safeOptJsonObj != null) {
                    Iterator<String> keys = safeOptJsonObj.keys();
                    Intrinsics.checkNotNullExpressionValue(keys, "context.keys()");
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object obj = safeOptJsonObj.get(next);
                        if (obj != null && !(obj instanceof String)) {
                            JsonUtils.safePut(safeOptJsonObj, next, obj.toString());
                        }
                    }
                    JsonUtils.safePut(jSONObject, "context", safeOptJsonObj);
                }
                String env = JsonUtils.safeOptStr(originObject, "env");
                Intrinsics.checkNotNullExpressionValue(env, "env");
                if (env.length() > 0) {
                    JsonUtils.safePut(jSONObject, "env", env);
                }
                String release = JsonUtils.safeOptStr(originObject, "release");
                Intrinsics.checkNotNullExpressionValue(release, "release");
                if (release.length() > 0) {
                    JsonUtils.safePut(jSONObject, "release", release);
                }
            }
            return jSONObject;
        }
    }
}
