package com.bytedance.ies.argus.aspect;

import com.bytedance.ies.argus.api.ArgusAPI;
import com.bytedance.ies.argus.api.ArgusLynxDelegate;
import com.bytedance.ies.argus.api.params.LynxSignVerifyCallerParams;
import com.bytedance.ies.argus.aspect.eventCenter.GlobalEventCenter;
import com.bytedance.ies.argus.bean.ArgusLynxViewAspect;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.lynx.service.security.ILynxSecurityServiceDelegate;
import com.bytedance.lynx.service.security.LynxSecurityVerificationEntity;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.service.security.SecurityResult;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusLynxSecurityHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/aspect/ArgusLynxSecurityHandler;", "Lcom/bytedance/lynx/service/security/ILynxSecurityServiceDelegate;", "()V", "didTasmVerified", "Lcom/lynx/tasm/service/security/SecurityResult;", "verification", "Lcom/bytedance/lynx/service/security/LynxSecurityVerificationEntity;", "enableVerification", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusLynxSecurityHandler implements ILynxSecurityServiceDelegate {
    public static final String TAG = "LynxSecurityHandler";

    public boolean enableVerification() {
        return !ArgusConfigManager.INSTANCE.getInstance().disableByRecovery(ArgusLynxViewAspect.LOAD_TEMPLATE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0027, code lost:
    
        if (r0 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SecurityResult didTasmVerified(LynxSecurityVerificationEntity verification) {
        ArgusLynxDelegate initLynxDelegate;
        Intrinsics.checkNotNullParameter(verification, "verification");
        LynxView lynxView = (LynxView) verification.getLynxView().get();
        if (lynxView != null) {
            WeakReference<ArgusLynxDelegate> context = GlobalEventCenter.INSTANCE.getInstance().getContext(lynxView);
            initLynxDelegate = context != null ? context.get() : null;
        }
        initLynxDelegate = ArgusAPI.INSTANCE.initLynxDelegate(null, null);
        if (initLynxDelegate != null) {
            LynxSignVerifyCallerParams lynxSignVerifyCallerParams = new LynxSignVerifyCallerParams(verification);
            AspectVerifyResult verifyLoadTemplate = initLynxDelegate.verifyLoadTemplate(lynxSignVerifyCallerParams);
            if (verifyLoadTemplate.isPass()) {
                SecurityResult onSuccess = SecurityResult.onSuccess();
                Intrinsics.checkNotNullExpressionValue(onSuccess, "onSuccess()");
                return onSuccess;
            }
            SecurityResult onReject = SecurityResult.onReject("Lynx sign verify failed. reason: " + verifyLoadTemplate.getReason() + ", verify url: " + lynxSignVerifyCallerParams.getVerifyUrl());
            Intrinsics.checkNotNullExpressionValue(onReject, "onReject(\"Lynx sign veri…rl: ${params.verifyUrl}\")");
            return onReject;
        }
        SecurityResult onSuccess2 = SecurityResult.onSuccess();
        Intrinsics.checkNotNullExpressionValue(onSuccess2, "onSuccess()");
        return onSuccess2;
    }
}
