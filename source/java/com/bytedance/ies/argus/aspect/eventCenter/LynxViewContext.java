package com.bytedance.ies.argus.aspect.eventCenter;

import com.bytedance.ies.argus.api.params.ArgusResourceLoaderInfo;
import com.bytedance.ies.argus.api.params.IFePageInfo;
import com.bytedance.ies.argus.api.params.LoadTemplateParams;
import com.bytedance.ies.argus.bean.ArgusLynxViewAspect;
import com.bytedance.sdk.xbridge.cn.auth.bean.BridgeCallRecord;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.service.security.ILynxSecurityService;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxViewContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001f\u001a\u00020 J%\u0010!\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0000¢\u0006\u0002\b#J\u0016\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/bytedance/ies/argus/aspect/eventCenter/LynxViewContext;", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseViewContext;", "Lcom/lynx/tasm/LynxView;", "()V", "bridgeLimitRule", "Ljava/util/HashMap;", "", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/BridgeCallRecord;", "Lkotlin/collections/HashMap;", "getBridgeLimitRule", "()Ljava/util/HashMap;", "feId", "", "getFeId", "()Ljava/lang/Long;", "setFeId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mainTemplateInfo", "Lcom/bytedance/ies/argus/api/params/LoadTemplateParams;", "tasmFeId", "getTasmFeId", "setTasmFeId", "verifyUrl", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "getMainPageInfo", "Lcom/bytedance/ies/argus/api/params/IFePageInfo;", "getTemplateInfo", "tasmType", "Lcom/lynx/tasm/service/security/ILynxSecurityService$LynxTasmType;", "recordJsbAuthInfo", "", "recordJsbAuthInfo$anniex_release", "recordTemplateInfo", "info", "aspect", "Lcom/bytedance/ies/argus/bean/ArgusLynxViewAspect;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxViewContext extends BaseViewContext<LynxView> {
    private final HashMap<String, BridgeCallRecord> bridgeLimitRule = new HashMap<>();
    private Long feId;
    private LoadTemplateParams mainTemplateInfo;
    private Long tasmFeId;
    private String verifyUrl;

    /* compiled from: LynxViewContext.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ArgusLynxViewAspect.values().length];
            try {
                iArr[ArgusLynxViewAspect.ABOUT_TO_LOAD_TEMPLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ILynxSecurityService.LynxTasmType.values().length];
            try {
                iArr2[ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[ILynxSecurityService.LynxTasmType.TYPE_DYNAMIC_COMPONENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Override // com.bytedance.ies.argus.aspect.eventCenter.BaseViewContext
    public IFePageInfo getMainPageInfo() {
        return null;
    }

    public final String getVerifyUrl() {
        return this.verifyUrl;
    }

    public final void setVerifyUrl(String str) {
        this.verifyUrl = str;
    }

    public final Long getFeId() {
        return this.feId;
    }

    public final void setFeId(Long l) {
        this.feId = l;
    }

    public final Long getTasmFeId() {
        return this.tasmFeId;
    }

    public final void setTasmFeId(Long l) {
        this.tasmFeId = l;
    }

    public final HashMap<String, BridgeCallRecord> getBridgeLimitRule() {
        return this.bridgeLimitRule;
    }

    public final void recordTemplateInfo(LoadTemplateParams info, ArgusLynxViewAspect aspect) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(aspect, "aspect");
        if (WhenMappings.$EnumSwitchMapping$0[aspect.ordinal()] == 1) {
            this.mainTemplateInfo = info;
            ArgusResourceLoaderInfo loaderInfo = info.getLoaderInfo();
            this.verifyUrl = loaderInfo != null ? loaderInfo.getVerifyUrl() : null;
        }
    }

    public final LoadTemplateParams getTemplateInfo(ILynxSecurityService.LynxTasmType tasmType) {
        Intrinsics.checkNotNullParameter(tasmType, "tasmType");
        int i = WhenMappings.$EnumSwitchMapping$1[tasmType.ordinal()];
        if (i == 1) {
            return this.mainTemplateInfo;
        }
        if (i == 2) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void recordJsbAuthInfo$anniex_release(long feId, long tasmFeId, String verifyUrl) {
        Intrinsics.checkNotNullParameter(verifyUrl, "verifyUrl");
        this.feId = Long.valueOf(feId);
        this.tasmFeId = Long.valueOf(tasmFeId);
        this.verifyUrl = verifyUrl;
    }
}
