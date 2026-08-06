package com.bytedance.lynx.service.security;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxSecurityVerificationEntity.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/bytedance/lynx/service/security/LynxSecurityPayloadVerificationEntity;", "Lcom/bytedance/lynx/service/security/ILynxSecurityVerificationEntity;", "verified", "", "errorMsg", "", "errorCode", "Lcom/bytedance/lynx/service/security/LynxSecurityErrorCode;", "signId", "", "extraConfig", "(ZLjava/lang/String;Lcom/bytedance/lynx/service/security/LynxSecurityErrorCode;JLjava/lang/String;)V", "getErrorCode", "()Lcom/bytedance/lynx/service/security/LynxSecurityErrorCode;", "getErrorMsg", "()Ljava/lang/String;", "getExtraConfig", "getSignId", "()J", "getVerified", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "Companion", "LynxSecurityService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LynxSecurityPayloadVerificationEntity implements ILynxSecurityVerificationEntity {
    public static final long INVALID_SIGN_ID = -1;
    private final LynxSecurityErrorCode errorCode;
    private final String errorMsg;
    private final String extraConfig;
    private final long signId;
    private final boolean verified;

    public static /* synthetic */ LynxSecurityPayloadVerificationEntity copy$default(LynxSecurityPayloadVerificationEntity lynxSecurityPayloadVerificationEntity, boolean z, String str, LynxSecurityErrorCode lynxSecurityErrorCode, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = lynxSecurityPayloadVerificationEntity.getVerified();
        }
        if ((i & 2) != 0) {
            str = lynxSecurityPayloadVerificationEntity.getErrorMsg();
        }
        String str3 = str;
        if ((i & 4) != 0) {
            lynxSecurityErrorCode = lynxSecurityPayloadVerificationEntity.getErrorCode();
        }
        LynxSecurityErrorCode lynxSecurityErrorCode2 = lynxSecurityErrorCode;
        if ((i & 8) != 0) {
            j = lynxSecurityPayloadVerificationEntity.getSignId();
        }
        long j2 = j;
        if ((i & 16) != 0) {
            str2 = lynxSecurityPayloadVerificationEntity.getExtraConfig();
        }
        return lynxSecurityPayloadVerificationEntity.copy(z, str3, lynxSecurityErrorCode2, j2, str2);
    }

    public final boolean component1() {
        return getVerified();
    }

    public final String component2() {
        return getErrorMsg();
    }

    public final LynxSecurityErrorCode component3() {
        return getErrorCode();
    }

    public final long component4() {
        return getSignId();
    }

    public final String component5() {
        return getExtraConfig();
    }

    public final LynxSecurityPayloadVerificationEntity copy(boolean verified, String errorMsg, LynxSecurityErrorCode errorCode, long signId, String extraConfig) {
        return new LynxSecurityPayloadVerificationEntity(verified, errorMsg, errorCode, signId, extraConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LynxSecurityPayloadVerificationEntity)) {
            return false;
        }
        LynxSecurityPayloadVerificationEntity lynxSecurityPayloadVerificationEntity = (LynxSecurityPayloadVerificationEntity) other;
        return getVerified() == lynxSecurityPayloadVerificationEntity.getVerified() && Intrinsics.areEqual(getErrorMsg(), lynxSecurityPayloadVerificationEntity.getErrorMsg()) && getErrorCode() == lynxSecurityPayloadVerificationEntity.getErrorCode() && getSignId() == lynxSecurityPayloadVerificationEntity.getSignId() && Intrinsics.areEqual(getExtraConfig(), lynxSecurityPayloadVerificationEntity.getExtraConfig());
    }

    public int hashCode() {
        boolean verified = getVerified();
        int i = verified;
        if (verified) {
            i = 1;
        }
        return (((((((i * 31) + (getErrorMsg() == null ? 0 : getErrorMsg().hashCode())) * 31) + (getErrorCode() == null ? 0 : getErrorCode().hashCode())) * 31) + Long.hashCode(getSignId())) * 31) + (getExtraConfig() != null ? getExtraConfig().hashCode() : 0);
    }

    public String toString() {
        return "LynxSecurityPayloadVerificationEntity(verified=" + getVerified() + ", errorMsg=" + getErrorMsg() + ", errorCode=" + getErrorCode() + ", signId=" + getSignId() + ", extraConfig=" + getExtraConfig() + ')';
    }

    public LynxSecurityPayloadVerificationEntity(boolean z, String str, LynxSecurityErrorCode lynxSecurityErrorCode, long j, String str2) {
        this.verified = z;
        this.errorMsg = str;
        this.errorCode = lynxSecurityErrorCode;
        this.signId = j;
        this.extraConfig = str2;
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
}
