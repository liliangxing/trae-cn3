package com.bytedance.ies.argus.api.params;

import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ArgusOnWebViewCreatedParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/argus/api/params/ArgusOnWebViewCreatedRewritePayload;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "newUserAgent", "", "(Ljava/lang/String;)V", "getNewUserAgent", "()Ljava/lang/String;", "setNewUserAgent", "toString", "ttmSetValue", "", Api.KEY_ENCRYPT_RESP_KEY, "value", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusOnWebViewCreatedRewritePayload extends BaseRewritePayload {
    private String newUserAgent;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArgusOnWebViewCreatedRewritePayload() {
        this(r0, 1, r0);
        String str = null;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseRewritePayload, com.bytedance.ies.argus.strategy.BaseStrategyParams
    public boolean ttmSetValue(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        return false;
    }

    public /* synthetic */ ArgusOnWebViewCreatedRewritePayload(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getNewUserAgent() {
        return this.newUserAgent;
    }

    public final void setNewUserAgent(String str) {
        this.newUserAgent = str;
    }

    public ArgusOnWebViewCreatedRewritePayload(String str) {
        this.newUserAgent = str;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseRewritePayload
    public String toString() {
        JSONObject jSONObject = new JSONObject();
        JSONUtilsKt.safelyPut(jSONObject, "new_user_agent", this.newUserAgent);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   …ent)\n        }.toString()");
        return jSONObject2;
    }
}
