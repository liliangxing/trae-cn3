package com.bytedance.lynx.service.security;

import kotlin.Metadata;

/* compiled from: LynxSecurityVerificationEntity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/lynx/service/security/ILynxSecurityVerificationEntity;", "", "errorCode", "Lcom/bytedance/lynx/service/security/LynxSecurityErrorCode;", "getErrorCode", "()Lcom/bytedance/lynx/service/security/LynxSecurityErrorCode;", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "extraConfig", "getExtraConfig", "signId", "", "getSignId", "()J", "verified", "", "getVerified", "()Z", "LynxSecurityService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ILynxSecurityVerificationEntity {
    LynxSecurityErrorCode getErrorCode();

    String getErrorMsg();

    String getExtraConfig();

    long getSignId();

    boolean getVerified();
}
