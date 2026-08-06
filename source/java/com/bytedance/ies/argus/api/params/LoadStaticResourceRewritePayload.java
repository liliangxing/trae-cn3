package com.bytedance.ies.argus.api.params;

import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LoadStaticResourceParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/argus/api/params/LoadStaticResourceRewritePayload;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "rewriteHeaders", "", "", "(Ljava/util/Map;)V", "getRewriteHeaders", "()Ljava/util/Map;", "setRewriteHeaders", "toString", "ttmSetValue", "", Api.KEY_ENCRYPT_RESP_KEY, "value", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LoadStaticResourceRewritePayload extends BaseRewritePayload {
    private Map<String, String> rewriteHeaders;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LoadStaticResourceRewritePayload() {
        this(r0, 1, r0);
        Map map = null;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseRewritePayload, com.bytedance.ies.argus.strategy.BaseStrategyParams
    public boolean ttmSetValue(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        return false;
    }

    public /* synthetic */ LoadStaticResourceRewritePayload(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, String> getRewriteHeaders() {
        return this.rewriteHeaders;
    }

    public final void setRewriteHeaders(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.rewriteHeaders = map;
    }

    public LoadStaticResourceRewritePayload(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "rewriteHeaders");
        this.rewriteHeaders = map;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseRewritePayload
    public String toString() {
        JSONObject jSONObject = new JSONObject();
        JSONUtilsKt.safelyPut(jSONObject, "rewrite_headers", this.rewriteHeaders.toString());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   …g())\n        }.toString()");
        return jSONObject2;
    }
}
