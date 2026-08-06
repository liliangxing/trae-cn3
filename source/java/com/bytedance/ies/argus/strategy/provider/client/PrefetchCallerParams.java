package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.api.params.BaseAspectParamsWithoutRewrite;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PrefetchStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/PrefetchCallerParams;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParamsWithoutRewrite;", "url", "", "channel", "bundle", "type", "Lcom/bytedance/ies/argus/strategy/provider/client/PrefetchType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ies/argus/strategy/provider/client/PrefetchType;)V", "getBundle", "()Ljava/lang/String;", "getChannel", "host", "getHost", "setHost", "(Ljava/lang/String;)V", "realUrl", "getRealUrl", "setRealUrl", "getType", "()Lcom/bytedance/ies/argus/strategy/provider/client/PrefetchType;", "getUrl", "toALogObject", "Lorg/json/JSONObject;", "action", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "toMonitorObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class PrefetchCallerParams extends BaseAspectParamsWithoutRewrite {
    private final String bundle;
    private final String channel;
    private String host;
    private String realUrl;
    private final PrefetchType type;
    private final String url;

    public /* synthetic */ PrefetchCallerParams(String str, String str2, String str3, PrefetchType prefetchType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, prefetchType);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getBundle() {
        return this.bundle;
    }

    public final PrefetchType getType() {
        return this.type;
    }

    public PrefetchCallerParams(String str, String str2, String str3, PrefetchType prefetchType) {
        Intrinsics.checkNotNullParameter(prefetchType, "type");
        this.url = str;
        this.channel = str2;
        this.bundle = str3;
        this.type = prefetchType;
    }

    public final String getHost() {
        return this.host;
    }

    public final void setHost(String str) {
        this.host = str;
    }

    public final String getRealUrl() {
        return this.realUrl;
    }

    public final void setRealUrl(String str) {
        this.realUrl = str;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toMonitorObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject jSONObject = new JSONObject();
        String str = this.realUrl;
        if (str == null) {
            str = "";
        }
        JSONUtilsKt.safelyPut(jSONObject, "real_url", str);
        JSONUtilsKt.safelyPut(jSONObject, "url", this.url);
        JSONUtilsKt.safelyPut(jSONObject, "channel", this.channel);
        JSONUtilsKt.safelyPut(jSONObject, "bundle", this.bundle);
        String str2 = this.host;
        JSONUtilsKt.safelyPut(jSONObject, "host", str2 != null ? str2 : "");
        JSONUtilsKt.safelyPut(jSONObject, "type", this.type.name());
        return jSONObject;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toALogObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return toMonitorObject(action);
    }
}
