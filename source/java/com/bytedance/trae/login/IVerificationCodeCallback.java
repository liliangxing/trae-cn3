package com.bytedance.trae.login;

import kotlin.Metadata;

/* compiled from: IVerificationCodeCallback.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J7\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/IVerificationCodeCallback;", "", "onSendSuccess", "", "onSendFailure", "errorCode", "", "errorMessage", "", "originErrorCode", "originErrorMsg", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IVerificationCodeCallback {
    void onSendFailure(int errorCode, String errorMessage, Integer originErrorCode, String originErrorMsg);

    void onSendSuccess();

    /* compiled from: IVerificationCodeCallback.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onSendFailure$default(IVerificationCodeCallback iVerificationCodeCallback, int i, String str, Integer num, String str2, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSendFailure");
            }
            if ((i2 & 4) != 0) {
                num = null;
            }
            if ((i2 & 8) != 0) {
                str2 = null;
            }
            iVerificationCodeCallback.onSendFailure(i, str, num, str2);
        }
    }
}
