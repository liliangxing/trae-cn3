package com.bytedance.trae.login.activity;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.sdk.account.api.call.ValidateCodeResponse;
import com.bytedance.sdk.account.mobile.thread.call.ValidateCodeCallBack;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.widget.VerifyCodeInputView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhoneBindActivity.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/bytedance/trae/login/activity/PhoneBindActivity$validateOldPhone$1", "Lcom/bytedance/sdk/account/mobile/thread/call/ValidateCodeCallBack;", "onSuccess", "", "response", "Lcom/bytedance/sdk/account/api/call/ValidateCodeResponse;", "onError", "error", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PhoneBindActivity$validateOldPhone$1 extends ValidateCodeCallBack {
    final /* synthetic */ PhoneBindActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PhoneBindActivity$validateOldPhone$1(PhoneBindActivity phoneBindActivity) {
        this.this$0 = phoneBindActivity;
    }

    public void onSuccess(final ValidateCodeResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        final PhoneBindActivity phoneBindActivity = this.this$0;
        phoneBindActivity.runOnUiThreadSafe(new Function0() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$validateOldPhone$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onSuccess$lambda$0;
                onSuccess$lambda$0 = PhoneBindActivity$validateOldPhone$1.onSuccess$lambda$0(PhoneBindActivity.this, response);
                return onSuccess$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSuccess$lambda$0(PhoneBindActivity phoneBindActivity, ValidateCodeResponse validateCodeResponse) {
        phoneBindActivity.showLoading(false);
        String ticket = validateCodeResponse.getTicket();
        if (ticket == null) {
            ticket = "";
        }
        phoneBindActivity.ticket = ticket;
        phoneBindActivity.showStep(2);
        return Unit.INSTANCE;
    }

    public void onError(ValidateCodeResponse response, int error) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.this$0.trackSettingsPhoneBindingResult(SccResult.MESSAGE_FAIL, "validate_old_code", Integer.valueOf(error), response.errorMsg);
        final PhoneBindActivity phoneBindActivity = this.this$0;
        phoneBindActivity.runOnUiThreadSafe(new Function0() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$validateOldPhone$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit onError$lambda$1;
                onError$lambda$1 = PhoneBindActivity$validateOldPhone$1.onError$lambda$1(PhoneBindActivity.this);
                return onError$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onError$lambda$1(PhoneBindActivity phoneBindActivity) {
        VerifyCodeInputView verifyCodeInputView;
        VerifyCodeInputView verifyCodeInputView2;
        VerifyCodeInputView verifyCodeInputView3;
        phoneBindActivity.showLoading(false);
        verifyCodeInputView = phoneBindActivity.verifyOldInput;
        VerifyCodeInputView verifyCodeInputView4 = null;
        if (verifyCodeInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOldInput");
            verifyCodeInputView = null;
        }
        verifyCodeInputView.setEnabled(true);
        verifyCodeInputView2 = phoneBindActivity.verifyOldInput;
        if (verifyCodeInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOldInput");
            verifyCodeInputView2 = null;
        }
        verifyCodeInputView2.setText("");
        verifyCodeInputView3 = phoneBindActivity.verifyOldInput;
        if (verifyCodeInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOldInput");
        } else {
            verifyCodeInputView4 = verifyCodeInputView3;
        }
        verifyCodeInputView4.setError(true);
        Toast.makeText((Context) phoneBindActivity, C0820R.string.trae_phone_verify_fail, 0).show();
        return Unit.INSTANCE;
    }
}
