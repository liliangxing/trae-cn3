package com.bytedance.ies.argus.api.params;

import android.webkit.WebResourceResponse;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ArgusWebResourceRequestParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R,\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/argus/api/params/ArgusWebResourceRequestRewritePayload;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", ApmTrafficStats.TTNET_RESPONSE, "Landroid/webkit/WebResourceResponse;", "(Landroid/webkit/WebResourceResponse;)V", "value", "", "forceUseOriginNetwork", "getForceUseOriginNetwork", "()Ljava/lang/Boolean;", "setForceUseOriginNetwork", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "printObj", "Lorg/json/JSONObject;", "getPrintObj", "()Lorg/json/JSONObject;", "printObj$delegate", "Lkotlin/Lazy;", "getResponse", "()Landroid/webkit/WebResourceResponse;", "setResponse", "getPrintJSONObj", "toALogObject", "action", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "toMonitorObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusWebResourceRequestRewritePayload extends BaseRewritePayload {
    private Boolean forceUseOriginNetwork;

    /* renamed from: printObj$delegate, reason: from kotlin metadata */
    private final Lazy printObj;
    private WebResourceResponse response;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArgusWebResourceRequestRewritePayload() {
        this(r0, 1, r0);
        WebResourceResponse webResourceResponse = null;
    }

    public /* synthetic */ ArgusWebResourceRequestRewritePayload(WebResourceResponse webResourceResponse, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : webResourceResponse);
    }

    public final WebResourceResponse getResponse() {
        return this.response;
    }

    public final void setResponse(WebResourceResponse webResourceResponse) {
        this.response = webResourceResponse;
    }

    public ArgusWebResourceRequestRewritePayload(WebResourceResponse webResourceResponse) {
        this.response = webResourceResponse;
        this.printObj = LazyKt.lazy(new Function0<JSONObject>() { // from class: com.bytedance.ies.argus.api.params.ArgusWebResourceRequestRewritePayload$printObj$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final JSONObject invoke() {
                JSONObject printJSONObj;
                printJSONObj = ArgusWebResourceRequestRewritePayload.this.getPrintJSONObj();
                return printJSONObj;
            }
        });
    }

    public final Boolean getForceUseOriginNetwork() {
        Object obj = getInnerData$anniex_release().get("use_origin_network");
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        return null;
    }

    public final void setForceUseOriginNetwork(Boolean bool) {
        this.forceUseOriginNetwork = bool;
        if (bool != null) {
            getInnerData$anniex_release().put("use_origin_network", Boolean.valueOf(bool.booleanValue()));
        }
    }

    private final JSONObject getPrintObj() {
        return (JSONObject) this.printObj.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject getPrintJSONObj() {
        return JSONUtilsKt.safelyPut(new JSONObject(), "use_origin_network", getForceUseOriginNetwork());
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toMonitorObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return getPrintObj();
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toALogObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return getPrintObj();
    }
}
