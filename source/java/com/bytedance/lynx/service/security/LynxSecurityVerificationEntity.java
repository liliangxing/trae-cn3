package com.bytedance.lynx.service.security;

import com.bytedance.forest.model.PreloadConfig;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.service.security.ILynxSecurityService;
import com.lynx.tasm.service.security.ILynxSecurityTarget;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxSecurityVerificationEntity.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 =2\u00020\u0001:\u0001=By\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0011\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010-\u001a\u00020\u0016HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00102\u001a\u00020\u000eHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u00105\u001a\u00020\u0013HÆ\u0003J\u0093\u0001\u00106\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0015\u001a\u00020\u0016HÆ\u0001J\u0013\u00107\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u000109H\u0096\u0002J\b\u0010:\u001a\u00020;H\u0016J\t\u0010<\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006>"}, d2 = {"Lcom/bytedance/lynx/service/security/LynxSecurityVerificationEntity;", "Lcom/bytedance/lynx/service/security/ILynxSecurityVerificationEntity;", "securityTarget", "Ljava/lang/ref/WeakReference;", "Lcom/lynx/tasm/service/security/ILynxSecurityTarget;", "lynxView", "Lcom/lynx/tasm/LynxView;", "templateUrl", "", "originTasm", "", "originTasmBuffer", "Ljava/nio/ByteBuffer;", "verified", "", "errorMsg", "errorCode", "Lcom/bytedance/lynx/service/security/LynxSecurityErrorCode;", "signId", "", "extraConfig", "tasmType", "Lcom/lynx/tasm/service/security/ILynxSecurityService$LynxTasmType;", "(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Ljava/lang/String;[BLjava/nio/ByteBuffer;ZLjava/lang/String;Lcom/bytedance/lynx/service/security/LynxSecurityErrorCode;JLjava/lang/String;Lcom/lynx/tasm/service/security/ILynxSecurityService$LynxTasmType;)V", "getErrorCode", "()Lcom/bytedance/lynx/service/security/LynxSecurityErrorCode;", "getErrorMsg", "()Ljava/lang/String;", "getExtraConfig", "getLynxView", "()Ljava/lang/ref/WeakReference;", "getOriginTasm", "()[B", "getOriginTasmBuffer", "()Ljava/nio/ByteBuffer;", "getSecurityTarget", "getSignId", "()J", "getTasmType", "()Lcom/lynx/tasm/service/security/ILynxSecurityService$LynxTasmType;", "getTemplateUrl", "getVerified", "()Z", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "Companion", "LynxSecurityService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LynxSecurityVerificationEntity implements ILynxSecurityVerificationEntity {
    public static final long INVALID_SIGN_ID = -1;
    private final LynxSecurityErrorCode errorCode;
    private final String errorMsg;
    private final String extraConfig;
    private final WeakReference<LynxView> lynxView;
    private final byte[] originTasm;
    private final ByteBuffer originTasmBuffer;
    private final WeakReference<ILynxSecurityTarget> securityTarget;
    private final long signId;
    private final ILynxSecurityService.LynxTasmType tasmType;
    private final String templateUrl;
    private final boolean verified;

    public final WeakReference<ILynxSecurityTarget> component1() {
        return this.securityTarget;
    }

    public final String component10() {
        return getExtraConfig();
    }

    /* renamed from: component11, reason: from getter */
    public final ILynxSecurityService.LynxTasmType getTasmType() {
        return this.tasmType;
    }

    public final WeakReference<LynxView> component2() {
        return this.lynxView;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTemplateUrl() {
        return this.templateUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final byte[] getOriginTasm() {
        return this.originTasm;
    }

    /* renamed from: component5, reason: from getter */
    public final ByteBuffer getOriginTasmBuffer() {
        return this.originTasmBuffer;
    }

    public final boolean component6() {
        return getVerified();
    }

    public final String component7() {
        return getErrorMsg();
    }

    public final LynxSecurityErrorCode component8() {
        return getErrorCode();
    }

    public final long component9() {
        return getSignId();
    }

    public final LynxSecurityVerificationEntity copy(WeakReference<ILynxSecurityTarget> securityTarget, WeakReference<LynxView> lynxView, String templateUrl, byte[] originTasm, ByteBuffer originTasmBuffer, boolean verified, String errorMsg, LynxSecurityErrorCode errorCode, long signId, String extraConfig, ILynxSecurityService.LynxTasmType tasmType) {
        Intrinsics.checkNotNullParameter(securityTarget, "securityTarget");
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        Intrinsics.checkNotNullParameter(tasmType, "tasmType");
        return new LynxSecurityVerificationEntity(securityTarget, lynxView, templateUrl, originTasm, originTasmBuffer, verified, errorMsg, errorCode, signId, extraConfig, tasmType);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LynxSecurityVerificationEntity(securityTarget=");
        sb.append(this.securityTarget).append(", lynxView=").append(this.lynxView).append(", templateUrl=").append(this.templateUrl).append(", originTasm=").append(Arrays.toString(this.originTasm)).append(", originTasmBuffer=").append(this.originTasmBuffer).append(", verified=").append(getVerified()).append(", errorMsg=").append(getErrorMsg()).append(", errorCode=").append(getErrorCode()).append(", signId=").append(getSignId()).append(", extraConfig=").append(getExtraConfig()).append(", tasmType=").append(this.tasmType).append(')');
        return sb.toString();
    }

    public LynxSecurityVerificationEntity(WeakReference<ILynxSecurityTarget> securityTarget, WeakReference<LynxView> lynxView, String str, byte[] bArr, ByteBuffer byteBuffer, boolean z, String str2, LynxSecurityErrorCode lynxSecurityErrorCode, long j, String str3, ILynxSecurityService.LynxTasmType tasmType) {
        Intrinsics.checkNotNullParameter(securityTarget, "securityTarget");
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        Intrinsics.checkNotNullParameter(tasmType, "tasmType");
        this.securityTarget = securityTarget;
        this.lynxView = lynxView;
        this.templateUrl = str;
        this.originTasm = bArr;
        this.originTasmBuffer = byteBuffer;
        this.verified = z;
        this.errorMsg = str2;
        this.errorCode = lynxSecurityErrorCode;
        this.signId = j;
        this.extraConfig = str3;
        this.tasmType = tasmType;
    }

    public final WeakReference<ILynxSecurityTarget> getSecurityTarget() {
        return this.securityTarget;
    }

    public final WeakReference<LynxView> getLynxView() {
        return this.lynxView;
    }

    public final String getTemplateUrl() {
        return this.templateUrl;
    }

    public final byte[] getOriginTasm() {
        return this.originTasm;
    }

    public final ByteBuffer getOriginTasmBuffer() {
        return this.originTasmBuffer;
    }

    @Override // com.bytedance.lynx.service.security.ILynxSecurityVerificationEntity
    public boolean getVerified() {
        return this.verified;
    }

    @Override // com.bytedance.lynx.service.security.ILynxSecurityVerificationEntity
    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override // com.bytedance.lynx.service.security.ILynxSecurityVerificationEntity
    public LynxSecurityErrorCode getErrorCode() {
        return this.errorCode;
    }

    @Override // com.bytedance.lynx.service.security.ILynxSecurityVerificationEntity
    public long getSignId() {
        return this.signId;
    }

    @Override // com.bytedance.lynx.service.security.ILynxSecurityVerificationEntity
    public String getExtraConfig() {
        return this.extraConfig;
    }

    public final ILynxSecurityService.LynxTasmType getTasmType() {
        return this.tasmType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        if (other != null) {
            LynxSecurityVerificationEntity lynxSecurityVerificationEntity = (LynxSecurityVerificationEntity) other;
            if (Intrinsics.areEqual(this.templateUrl, lynxSecurityVerificationEntity.templateUrl) && Arrays.equals(this.originTasm, lynxSecurityVerificationEntity.originTasm) && getVerified() == lynxSecurityVerificationEntity.getVerified() && Intrinsics.areEqual(getErrorMsg(), lynxSecurityVerificationEntity.getErrorMsg()) && getSignId() == lynxSecurityVerificationEntity.getSignId()) {
                return Intrinsics.areEqual(getExtraConfig(), lynxSecurityVerificationEntity.getExtraConfig());
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.lynx.service.security.LynxSecurityVerificationEntity");
    }

    public int hashCode() {
        String str = this.templateUrl;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + Boolean.hashCode(getVerified())) * 31;
        String errorMsg = getErrorMsg();
        int hashCode2 = (((hashCode + (errorMsg != null ? errorMsg.hashCode() : 0)) * 31) + Long.hashCode(getSignId())) * 31;
        String extraConfig = getExtraConfig();
        return hashCode2 + (extraConfig != null ? extraConfig.hashCode() : 0);
    }
}
