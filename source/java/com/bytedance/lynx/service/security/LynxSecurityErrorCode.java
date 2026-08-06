package com.bytedance.lynx.service.security;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LynxSecurityVerificationEntity.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/lynx/service/security/LynxSecurityErrorCode;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "LynxSecurityErrorCodeOk", "LynxSecurityErrorCodeUnSigned", "LynxSecurityErrorCodeErrorSign", "LynxSecurityErrorCodeReadBlockFailed", "LynxSecurityErrorCodePKNotFound", "LynxSecurityErrorCodeDebugCertExpired", "LynxSecurityErrorCodeDebugCertVerifyFailed", "LynxSecurityErrorCodeDebugCertInvalid", "Companion", "LynxSecurityService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public enum LynxSecurityErrorCode {
    LynxSecurityErrorCodeOk(0),
    LynxSecurityErrorCodeUnSigned(1),
    LynxSecurityErrorCodeErrorSign(2),
    LynxSecurityErrorCodeReadBlockFailed(3),
    LynxSecurityErrorCodePKNotFound(4),
    LynxSecurityErrorCodeDebugCertExpired(5),
    LynxSecurityErrorCodeDebugCertVerifyFailed(6),
    LynxSecurityErrorCodeDebugCertInvalid(7);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int code;

    LynxSecurityErrorCode(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    /* compiled from: LynxSecurityVerificationEntity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lynx/service/security/LynxSecurityErrorCode$Companion;", "", "()V", "fromCode", "Lcom/bytedance/lynx/service/security/LynxSecurityErrorCode;", "code", "", "LynxSecurityService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LynxSecurityErrorCode fromCode(int code) {
            LynxSecurityErrorCode lynxSecurityErrorCode;
            LynxSecurityErrorCode[] values = LynxSecurityErrorCode.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    lynxSecurityErrorCode = null;
                    break;
                }
                lynxSecurityErrorCode = values[i];
                if (lynxSecurityErrorCode.getCode() == code) {
                    break;
                }
                i++;
            }
            if (lynxSecurityErrorCode != null) {
                return lynxSecurityErrorCode;
            }
            throw new IllegalArgumentException("unknown error code: " + code);
        }
    }
}
