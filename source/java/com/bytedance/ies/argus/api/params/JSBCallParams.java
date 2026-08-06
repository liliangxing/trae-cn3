package com.bytedance.ies.argus.api.params;

import com.bytedance.common.process.cross.CrossProcessDatabaseHelper;
import com.bytedance.ies.argus.bean.ArgusContainerType;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: JSBCallParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\b\u0010\u001a\u001a\u00020\u0002H\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/argus/api/params/JSBCallParams;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParamsWithRewrite;", "Lcom/bytedance/ies/argus/api/params/JSBCallRewritePayload;", "methodName", "", "methodAuthType", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "namespace", "containerType", "Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "originUrl", "(Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;Ljava/lang/String;Lcom/bytedance/ies/argus/bean/ArgusContainerType;Ljava/lang/String;)V", "getContainerType", "()Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "getMethodAuthType", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "getMethodName", "()Ljava/lang/String;", "getNamespace", "getOriginUrl", "printObj", "Lorg/json/JSONObject;", "getPrintObj", "()Lorg/json/JSONObject;", "printObj$delegate", "Lkotlin/Lazy;", "initRewritePayload", "toALogObject", "action", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "toMonitorObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class JSBCallParams extends BaseAspectParamsWithRewrite<JSBCallRewritePayload> {
    private final ArgusContainerType containerType;
    private final AuthBridgeAccess methodAuthType;
    private final String methodName;
    private final String namespace;
    private final String originUrl;

    /* renamed from: printObj$delegate, reason: from kotlin metadata */
    private final Lazy printObj;

    public final String getMethodName() {
        return this.methodName;
    }

    public /* synthetic */ JSBCallParams(String str, AuthBridgeAccess authBridgeAccess, String str2, ArgusContainerType argusContainerType, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? AuthBridgeAccess.PRIVATE : authBridgeAccess, str2, argusContainerType, (i & 16) != 0 ? null : str3);
    }

    public final AuthBridgeAccess getMethodAuthType() {
        return this.methodAuthType;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final ArgusContainerType getContainerType() {
        return this.containerType;
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public JSBCallParams(String str, AuthBridgeAccess authBridgeAccess, String str2, ArgusContainerType argusContainerType, String str3) {
        Intrinsics.checkNotNullParameter(str, "methodName");
        Intrinsics.checkNotNullParameter(authBridgeAccess, "methodAuthType");
        Intrinsics.checkNotNullParameter(argusContainerType, "containerType");
        this.methodName = str;
        this.methodAuthType = authBridgeAccess;
        this.namespace = str2;
        this.containerType = argusContainerType;
        this.originUrl = str3;
        this.printObj = LazyKt.lazy(new Function0<JSONObject>() { // from class: com.bytedance.ies.argus.api.params.JSBCallParams$printObj$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final JSONObject invoke() {
                JSONObject jSONObject = new JSONObject();
                JSBCallParams jSBCallParams = JSBCallParams.this;
                JSONUtilsKt.safelyPut(jSONObject, CrossProcessDatabaseHelper.COL_METHOD_NAME, jSBCallParams.getMethodName());
                JSONUtilsKt.safelyPut(jSONObject, "method_auth_type", jSBCallParams.getMethodAuthType().getValue());
                return jSONObject;
            }
        });
    }

    private final JSONObject getPrintObj() {
        return (JSONObject) this.printObj.getValue();
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

    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public JSBCallRewritePayload initRewritePayload() {
        return new JSBCallRewritePayload(AuthBridgeAccess.UNKNOWN, null, null, 6, null);
    }
}
