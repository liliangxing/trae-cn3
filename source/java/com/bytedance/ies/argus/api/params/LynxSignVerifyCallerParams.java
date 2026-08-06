package com.bytedance.ies.argus.api.params;

import android.net.Uri;
import com.bytedance.android.monitorV2.webview.constant.WebViewMonitorConstant;
import com.bytedance.ies.argus.aspect.eventCenter.FeAuthConfig;
import com.bytedance.ies.argus.bean.ArgusContainerType;
import com.bytedance.ies.argus.bean.ArgusFeId;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.bytedance.lynx.service.security.LynxSecurityVerificationEntity;
import com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser;
import com.lynx.tasm.service.security.ILynxSecurityService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: LynxSignVerifyParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010X\u001a\u00020\u000bJ\u0012\u0010Y\u001a\u0004\u0018\u00010.2\u0006\u0010Z\u001a\u00020[H\u0016J\u0012\u0010\\\u001a\u0004\u0018\u00010.2\u0006\u0010Z\u001a\u00020[H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010#\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001e\u0010%\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\rR\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b/\u00100R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00102\u001a\u0004\b4\u00100R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\r\"\u0004\b>\u0010\u000fR\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0019\"\u0004\bG\u0010\u001bR\u0011\u0010H\u001a\u00020I¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010L\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\rR\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0011\u0010V\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bW\u0010\r¨\u0006]"}, d2 = {"Lcom/bytedance/ies/argus/api/params/LynxSignVerifyCallerParams;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParamsWithoutRewrite;", "Lcom/bytedance/ies/argus/api/params/IFePageInfo;", "verification", "Lcom/bytedance/lynx/service/security/LynxSecurityVerificationEntity;", "(Lcom/bytedance/lynx/service/security/LynxSecurityVerificationEntity;)V", "containerType", "Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "getContainerType", "()Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "enterFrom", "", "getEnterFrom", "()Ljava/lang/String;", "setEnterFrom", "(Ljava/lang/String;)V", "feAuthConfig", "Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfig;", "getFeAuthConfig", "()Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfig;", "setFeAuthConfig", "(Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfig;)V", "feId", "", "getFeId", "()J", "setFeId", "(J)V", "isDegraded", "", "()Z", "setDegraded", "(Z)V", "isHighRisk", "setHighRisk", "isSigned", "setSigned", "lastModified", "getLastModified", "()Ljava/lang/Long;", "setLastModified", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "loadUrl", "getLoadUrl", "printBaseInfoObj", "Lorg/json/JSONObject;", "getPrintBaseInfoObj", "()Lorg/json/JSONObject;", "printBaseInfoObj$delegate", "Lkotlin/Lazy;", "printFullObj", "getPrintFullObj", "printFullObj$delegate", "resourceInfo", "Lcom/bytedance/ies/argus/api/params/ArgusResourceLoaderInfo;", "getResourceInfo", "()Lcom/bytedance/ies/argus/api/params/ArgusResourceLoaderInfo;", "setResourceInfo", "(Lcom/bytedance/ies/argus/api/params/ArgusResourceLoaderInfo;)V", "scene", "getScene", "setScene", "signBlockVersion", "Lcom/bytedance/ies/argus/api/params/SignBlockVersion;", "getSignBlockVersion", "()Lcom/bytedance/ies/argus/api/params/SignBlockVersion;", "setSignBlockVersion", "(Lcom/bytedance/ies/argus/api/params/SignBlockVersion;)V", "tasmFeId", "getTasmFeId", "setTasmFeId", "tasmType", "Lcom/lynx/tasm/service/security/ILynxSecurityService$LynxTasmType;", "getTasmType", "()Lcom/lynx/tasm/service/security/ILynxSecurityService$LynxTasmType;", "templateUrl", "getTemplateUrl", "tsStatus", "Lcom/bytedance/ies/argus/api/params/TimestampStatus;", "getTsStatus", "()Lcom/bytedance/ies/argus/api/params/TimestampStatus;", "setTsStatus", "(Lcom/bytedance/ies/argus/api/params/TimestampStatus;)V", "getVerification", "()Lcom/bytedance/lynx/service/security/LynxSecurityVerificationEntity;", "verifyUrl", "getVerifyUrl", "getTasmTypeValue", "toALogObject", "action", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "toMonitorObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxSignVerifyCallerParams extends BaseAspectParamsWithoutRewrite implements IFePageInfo {
    private final ArgusContainerType containerType;
    private String enterFrom;
    private FeAuthConfig feAuthConfig;
    private long feId;
    private boolean isDegraded;
    private boolean isHighRisk;
    private boolean isSigned;
    private Long lastModified;

    /* renamed from: printBaseInfoObj$delegate, reason: from kotlin metadata */
    private final Lazy printBaseInfoObj;

    /* renamed from: printFullObj$delegate, reason: from kotlin metadata */
    private final Lazy printFullObj;
    private ArgusResourceLoaderInfo resourceInfo;
    private String scene;
    private SignBlockVersion signBlockVersion;
    private long tasmFeId;
    private final ILynxSecurityService.LynxTasmType tasmType;
    private final String templateUrl;
    private TimestampStatus tsStatus;
    private final LynxSecurityVerificationEntity verification;

    /* compiled from: LynxSignVerifyParams.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ILynxSecurityService.LynxTasmType.values().length];
            try {
                iArr[ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ILynxSecurityService.LynxTasmType.TYPE_DYNAMIC_COMPONENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final LynxSecurityVerificationEntity getVerification() {
        return this.verification;
    }

    public LynxSignVerifyCallerParams(LynxSecurityVerificationEntity lynxSecurityVerificationEntity) {
        Intrinsics.checkNotNullParameter(lynxSecurityVerificationEntity, "verification");
        this.verification = lynxSecurityVerificationEntity;
        this.printBaseInfoObj = LazyKt.lazy(new Function0<JSONObject>() { // from class: com.bytedance.ies.argus.api.params.LynxSignVerifyCallerParams$printBaseInfoObj$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final JSONObject invoke() {
                JSONObject jSONObject = new JSONObject();
                LynxSignVerifyCallerParams lynxSignVerifyCallerParams = LynxSignVerifyCallerParams.this;
                JSONUtilsKt.safelyPut(jSONObject, "verify_url", CommonUtils.INSTANCE.removeQuery(lynxSignVerifyCallerParams.getVerifyUrl()));
                JSONUtilsKt.safelyPut(jSONObject, "fe_id", Long.valueOf(lynxSignVerifyCallerParams.getFeId()));
                JSONUtilsKt.safelyPut(jSONObject, "is_degraded", Integer.valueOf(lynxSignVerifyCallerParams.getIsDegraded() ? 1 : 0));
                JSONUtilsKt.safelyPut(jSONObject, "tasm_fe_id", Long.valueOf(lynxSignVerifyCallerParams.getTasmFeId()));
                JSONUtilsKt.safelyPut(jSONObject, "is_high_risk", Integer.valueOf(lynxSignVerifyCallerParams.getIsHighRisk() ? 1 : 0));
                String scene = lynxSignVerifyCallerParams.getScene();
                if (scene == null) {
                    scene = "";
                }
                JSONUtilsKt.safelyPut(jSONObject, "scene", scene);
                return jSONObject;
            }
        });
        this.printFullObj = LazyKt.lazy(new Function0<JSONObject>() { // from class: com.bytedance.ies.argus.api.params.LynxSignVerifyCallerParams$printFullObj$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final JSONObject invoke() {
                JSONObject printBaseInfoObj;
                String templateUrl;
                String loaderName;
                Long resourceVersion;
                printBaseInfoObj = LynxSignVerifyCallerParams.this.getPrintBaseInfoObj();
                LynxSignVerifyCallerParams lynxSignVerifyCallerParams = LynxSignVerifyCallerParams.this;
                String templateUrl2 = lynxSignVerifyCallerParams.getVerification().getTemplateUrl();
                if (templateUrl2 != null) {
                    JSONUtilsKt.safelyPut(printBaseInfoObj, "lynxview_url", templateUrl2);
                }
                SignBlockVersion signBlockVersion = lynxSignVerifyCallerParams.getSignBlockVersion();
                if (signBlockVersion != null) {
                    JSONUtilsKt.safelyPut(printBaseInfoObj, "sign_block_version", signBlockVersion.getStrValue());
                }
                JSONUtilsKt.safelyPut(printBaseInfoObj, "fe_config_version", Integer.valueOf(PermissionConfigV2Parser.getPackageVersion$default(PermissionConfigV2Parser.INSTANCE, (String) null, 1, (Object) null)));
                ArgusResourceLoaderInfo resourceInfo = lynxSignVerifyCallerParams.getResourceInfo();
                JSONUtilsKt.safelyPut(printBaseInfoObj, "page_gecko_version", Long.valueOf((resourceInfo == null || (resourceVersion = resourceInfo.getResourceVersion()) == null) ? 0L : resourceVersion.longValue()));
                TimestampStatus tsStatus = lynxSignVerifyCallerParams.getTsStatus();
                if (tsStatus != null) {
                    JSONUtilsKt.safelyPut(printBaseInfoObj, "ts_status", tsStatus.getStrValue());
                }
                JSONUtilsKt.safelyPut(printBaseInfoObj, "fe_config_from", PermissionConfigV2Parser.INSTANCE.getPackageLoaderName());
                String enterFrom = lynxSignVerifyCallerParams.getEnterFrom();
                String str = "unknown";
                if (enterFrom == null) {
                    enterFrom = "unknown";
                }
                JSONUtilsKt.safelyPut(printBaseInfoObj, "verify_enter_from", enterFrom);
                ArgusResourceLoaderInfo resourceInfo2 = lynxSignVerifyCallerParams.getResourceInfo();
                if (resourceInfo2 != null && (loaderName = resourceInfo2.getLoaderName()) != null) {
                    str = loaderName;
                }
                JSONUtilsKt.safelyPut(printBaseInfoObj, "loader_name", str);
                JSONUtilsKt.safelyPut(printBaseInfoObj, "tasm_type", lynxSignVerifyCallerParams.getTasmTypeValue());
                ArgusResourceLoaderInfo resourceInfo3 = lynxSignVerifyCallerParams.getResourceInfo();
                if ((resourceInfo3 == null || (templateUrl = resourceInfo3.getSourceUrl()) == null) && (templateUrl = lynxSignVerifyCallerParams.getTemplateUrl()) == null) {
                    templateUrl = "";
                }
                JSONUtilsKt.safelyPut(printBaseInfoObj, WebViewMonitorConstant.Web.FULL_URL, templateUrl);
                return printBaseInfoObj;
            }
        });
        this.containerType = ArgusContainerType.LYNX;
        this.feId = ArgusFeId.UNSET.getLongValue();
        this.tasmFeId = ArgusFeId.UNSET.getLongValue();
        this.templateUrl = lynxSecurityVerificationEntity.getTemplateUrl();
        this.tasmType = lynxSecurityVerificationEntity.getTasmType();
        this.isSigned = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject getPrintBaseInfoObj() {
        return (JSONObject) this.printBaseInfoObj.getValue();
    }

    private final JSONObject getPrintFullObj() {
        return (JSONObject) this.printFullObj.getValue();
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toALogObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action == ArgusVerifyAction.BLOCK) {
            return getPrintFullObj();
        }
        return getPrintBaseInfoObj();
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toMonitorObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject printFullObj = getPrintFullObj();
        JSONUtilsKt.safelyPut(printFullObj, "origin_verify_url", getVerifyUrl());
        return printFullObj;
    }

    @Override // com.bytedance.ies.argus.api.params.IFePageInfo
    public ArgusContainerType getContainerType() {
        return this.containerType;
    }

    @Override // com.bytedance.ies.argus.api.params.IFePageInfo
    public String getLoadUrl() {
        return getVerifyUrl();
    }

    @Override // com.bytedance.ies.argus.api.params.IFePageInfo
    public long getFeId() {
        return this.feId;
    }

    @Override // com.bytedance.ies.argus.api.params.IFePageInfo
    public void setFeId(long j) {
        this.feId = j;
    }

    @Override // com.bytedance.ies.argus.api.params.IFePageInfo
    public FeAuthConfig getFeAuthConfig() {
        return this.feAuthConfig;
    }

    @Override // com.bytedance.ies.argus.api.params.IFePageInfo
    public void setFeAuthConfig(FeAuthConfig feAuthConfig) {
        this.feAuthConfig = feAuthConfig;
    }

    public final long getTasmFeId() {
        return this.tasmFeId;
    }

    public final void setTasmFeId(long j) {
        this.tasmFeId = j;
    }

    public final ArgusResourceLoaderInfo getResourceInfo() {
        return this.resourceInfo;
    }

    public final void setResourceInfo(ArgusResourceLoaderInfo argusResourceLoaderInfo) {
        this.resourceInfo = argusResourceLoaderInfo;
    }

    public final String getTemplateUrl() {
        return this.templateUrl;
    }

    public final ILynxSecurityService.LynxTasmType getTasmType() {
        return this.tasmType;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final void setEnterFrom(String str) {
        this.enterFrom = str;
    }

    /* renamed from: isDegraded, reason: from getter */
    public final boolean getIsDegraded() {
        return this.isDegraded;
    }

    public final void setDegraded(boolean z) {
        this.isDegraded = z;
    }

    public final String getVerifyUrl() {
        String verifyUrl;
        ArgusResourceLoaderInfo argusResourceLoaderInfo = this.resourceInfo;
        if (argusResourceLoaderInfo != null && (verifyUrl = argusResourceLoaderInfo.getVerifyUrl()) != null) {
            return verifyUrl;
        }
        String str = this.templateUrl;
        if (str == null) {
            return "unknown://empty";
        }
        if (this.tasmType == ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE && (StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(str, "https://", false, 2, (Object) null))) {
            return str;
        }
        StringBuilder sb = new StringBuilder("unknown://raw/");
        Uri parse = Uri.parse(str);
        if (parse != null) {
            CommonUtils commonUtils = CommonUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(parse, "parse(it)");
            String cdn = commonUtils.getCDN(parse);
            if (cdn != null) {
                str = cdn;
            }
        }
        return sb.append(str).toString();
    }

    public final SignBlockVersion getSignBlockVersion() {
        return this.signBlockVersion;
    }

    public final void setSignBlockVersion(SignBlockVersion signBlockVersion) {
        this.signBlockVersion = signBlockVersion;
    }

    /* renamed from: isSigned, reason: from getter */
    public final boolean getIsSigned() {
        return this.isSigned;
    }

    public final void setSigned(boolean z) {
        this.isSigned = z;
    }

    public final String getTasmTypeValue() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.tasmType.ordinal()];
        return i != 1 ? i != 2 ? "unknown" : "dynamic_component" : "main_template";
    }

    public final TimestampStatus getTsStatus() {
        return this.tsStatus;
    }

    public final void setTsStatus(TimestampStatus timestampStatus) {
        this.tsStatus = timestampStatus;
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setScene(String str) {
        this.scene = str;
    }

    public final Long getLastModified() {
        return this.lastModified;
    }

    public final void setLastModified(Long l) {
        this.lastModified = l;
    }

    /* renamed from: isHighRisk, reason: from getter */
    public final boolean getIsHighRisk() {
        return this.isHighRisk;
    }

    public final void setHighRisk(boolean z) {
        this.isHighRisk = z;
    }
}
