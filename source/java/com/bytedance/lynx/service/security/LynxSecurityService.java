package com.bytedance.lynx.service.security;

import android.content.Context;
import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.LynxLazyInitializer;
import com.lynx.tasm.service.security.ILynxSecurityService;
import com.lynx.tasm.service.security.ILynxSecurityTarget;
import com.lynx.tasm.service.security.SecurityResult;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxSecurityService.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0014J\u0011\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0082 JB\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0082 ¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u000bJ\u0016\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u000bJ\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u0005J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0014J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J8\u0010+\u001a\u00020,2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020/H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/lynx/service/security/LynxSecurityService;", "Lcom/lynx/tasm/service/LynxLazyInitializer;", "Lcom/lynx/tasm/service/security/ILynxSecurityService;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "delegateRegistry", "Lcom/bytedance/lynx/service/security/LynxSecurityDelegateRegistry;", "Lcom/lynx/tasm/service/security/ILynxSecurityTarget;", "Lcom/bytedance/lynx/service/security/ILynxSecurityServiceDelegate;", "doInitialize", "", "nativeUpdateRsaPublicKeys", "publicKeys", "nativeVerifySignBlock", "template", "", "buffer", "Ljava/nio/ByteBuffer;", "signIdBuffer", "", "extras", "", "errorCodeBuffer", "", "([BLjava/nio/ByteBuffer;[J[Ljava/lang/String;[I)Z", "onInitialize", "", "context", "Landroid/content/Context;", "setSecurityDelegate", "delegate", "setSecurityDelegateForTarget", "target", "updateRSAPublicKeys", "verifyPayload", "Lcom/bytedance/lynx/service/security/ILynxSecurityVerificationEntity;", "payloadData", "signBlockData", "verifyPayloadInternal", "Lcom/bytedance/lynx/service/security/LynxSecurityPayloadVerificationEntity;", "verifyTASM", "Lcom/lynx/tasm/service/security/SecurityResult;", "url", "type", "Lcom/lynx/tasm/service/security/ILynxSecurityService$LynxTasmType;", "Companion", "LynxSecurityService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxSecurityService extends LynxLazyInitializer implements ILynxSecurityService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<LynxSecurityService> INSTANCE$delegate = LazyKt.lazy(new Function0<LynxSecurityService>() { // from class: com.bytedance.lynx.service.security.LynxSecurityService$Companion$INSTANCE$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LynxSecurityService m725invoke() {
            return new LynxSecurityService();
        }
    });
    private final String TAG = "LynxSecurityService";
    private final LynxSecurityDelegateRegistry<ILynxSecurityTarget, ILynxSecurityServiceDelegate> delegateRegistry = new LynxSecurityDelegateRegistry<>();

    private final native boolean nativeUpdateRsaPublicKeys(String publicKeys);

    private final native boolean nativeVerifySignBlock(byte[] template, ByteBuffer buffer, long[] signIdBuffer, String[] extras, int[] errorCodeBuffer);

    public final String getTAG() {
        return this.TAG;
    }

    /* compiled from: LynxSecurityService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\u0004H\u0086\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/lynx/service/security/LynxSecurityService$Companion;", "", "()V", "INSTANCE", "Lcom/bytedance/lynx/service/security/LynxSecurityService;", "getINSTANCE", "()Lcom/bytedance/lynx/service/security/LynxSecurityService;", "INSTANCE$delegate", "Lkotlin/Lazy;", "invoke", "LynxSecurityService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LynxSecurityService getINSTANCE() {
            return (LynxSecurityService) LynxSecurityService.INSTANCE$delegate.getValue();
        }

        public final LynxSecurityService invoke() {
            return getINSTANCE();
        }
    }

    public void onInitialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        initialize();
    }

    protected boolean doInitialize() {
        Unit unit;
        try {
            INativeLibraryLoader libraryLoader = LynxEnv.inst().getLibraryLoader();
            if (libraryLoader != null) {
                libraryLoader.loadLibrary("lynxsecurity");
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return true;
            }
            LynxSecurityService lynxSecurityService = this;
            System.loadLibrary("lynxsecurity");
            return true;
        } catch (Exception e) {
            LLog.e(this.TAG, "fail to load lynxsecurity.so, error message is: " + e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            LLog.e(this.TAG, "fail to load lynxsecurity.so, error message is: " + e2);
            return false;
        }
    }

    public final void setSecurityDelegate(ILynxSecurityServiceDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        if (this.delegateRegistry.setGlobalDelegate(delegate)) {
            return;
        }
        LLog.e(this.TAG, "SecurityDelegate can not be override.");
    }

    public final void setSecurityDelegateForTarget(ILynxSecurityTarget target, ILynxSecurityServiceDelegate delegate) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        if (this.delegateRegistry.setDelegateForKey(target, delegate)) {
            return;
        }
        LLog.e(this.TAG, "SecurityDelegate for target can not be override.");
    }

    public final ILynxSecurityVerificationEntity verifyPayload(ByteBuffer payloadData, ByteBuffer signBlockData) {
        Intrinsics.checkNotNullParameter(payloadData, "payloadData");
        Intrinsics.checkNotNullParameter(signBlockData, "signBlockData");
        return verifyPayloadInternal(LynxSecurityPayloadBufferHelper.INSTANCE.createLengthPrefixedBuffer(payloadData, signBlockData));
    }

    public final void updateRSAPublicKeys(String publicKeys) {
        Intrinsics.checkNotNullParameter(publicKeys, "publicKeys");
        if (!ensureInitialized()) {
            LLog.e("LynxSecurityService", "lynxsecurity.so load failed.");
        } else {
            nativeUpdateRsaPublicKeys(publicKeys);
        }
    }

    public SecurityResult verifyTASM(ILynxSecurityTarget target, byte[] template, ByteBuffer buffer, String url, ILynxSecurityService.LynxTasmType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!ensureInitialized()) {
            LLog.e(this.TAG, "lynxsecurity.so load failed");
            SecurityResult onSuccess = SecurityResult.onSuccess();
            Intrinsics.checkNotNullExpressionValue(onSuccess, "onSuccess()");
            return onSuccess;
        }
        if (template == null && buffer == null) {
            SecurityResult onReject = SecurityResult.onReject("empty tasm file.");
            Intrinsics.checkNotNullExpressionValue(onReject, "onReject(\"empty tasm file.\")");
            return onReject;
        }
        ILynxSecurityServiceDelegate resolveDelegate = this.delegateRegistry.resolveDelegate(target);
        if (resolveDelegate == null || !resolveDelegate.enableVerification()) {
            SecurityResult onSuccess2 = SecurityResult.onSuccess();
            Intrinsics.checkNotNullExpressionValue(onSuccess2, "onSuccess()");
            return onSuccess2;
        }
        long[] jArr = {-1};
        int[] iArr = {0};
        String[] strArr = new String[2];
        boolean nativeVerifySignBlock = nativeVerifySignBlock(template, buffer, jArr, strArr, iArr);
        long j = jArr[0];
        LynxSecurityErrorCode fromCode = LynxSecurityErrorCode.INSTANCE.fromCode(iArr[0]);
        String str = strArr[0];
        return resolveDelegate.didTasmVerified(new LynxSecurityVerificationEntity(new WeakReference(target), new WeakReference(target instanceof LynxView ? (LynxView) target : null), url, template, buffer, nativeVerifySignBlock, strArr[1], fromCode, j, str, type));
    }

    private final LynxSecurityPayloadVerificationEntity verifyPayloadInternal(ByteBuffer buffer) {
        if (!ensureInitialized()) {
            LLog.e(this.TAG, "lynxsecurity.so load failed.");
            return new LynxSecurityPayloadVerificationEntity(false, "lynxsecurity.so load failed.", null, -1L, null);
        }
        long[] jArr = {-1};
        int[] iArr = {0};
        String[] strArr = new String[2];
        return new LynxSecurityPayloadVerificationEntity(nativeVerifySignBlock(null, buffer, jArr, strArr, iArr), strArr[1], LynxSecurityErrorCode.INSTANCE.fromCode(iArr[0]), jArr[0], strArr[0]);
    }
}
