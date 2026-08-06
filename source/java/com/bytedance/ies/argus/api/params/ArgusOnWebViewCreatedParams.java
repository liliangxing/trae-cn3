package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ArgusOnWebViewCreatedParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/argus/api/params/ArgusOnWebViewCreatedParams;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParamsWithRewrite;", "Lcom/bytedance/ies/argus/api/params/ArgusOnWebViewCreatedRewritePayload;", "originUserAgent", "", "enterFrom", "(Ljava/lang/String;Ljava/lang/String;)V", "getEnterFrom", "()Ljava/lang/String;", "getOriginUserAgent", "initRewritePayload", "toALogObject", "Lorg/json/JSONObject;", "action", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "toMonitorObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusOnWebViewCreatedParams extends BaseAspectParamsWithRewrite<ArgusOnWebViewCreatedRewritePayload> {
    private final String enterFrom;
    private final String originUserAgent;

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toALogObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return null;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toMonitorObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return null;
    }

    public final String getOriginUserAgent() {
        return this.originUserAgent;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public ArgusOnWebViewCreatedParams(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "originUserAgent");
        Intrinsics.checkNotNullParameter(str2, "enterFrom");
        this.originUserAgent = str;
        this.enterFrom = str2;
    }

    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public ArgusOnWebViewCreatedRewritePayload initRewritePayload() {
        return new ArgusOnWebViewCreatedRewritePayload(null, 1, null);
    }
}
