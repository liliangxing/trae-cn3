package com.bytedance.trae.login.activity;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.sdk.account.AccountSdkCallback;
import com.bytedance.sdk.account.AccountSdkResponse;
import com.bytedance.sdk.account.response.SendCodeResponseData;
import com.bytedance.trae.login.C0820R;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhoneBindActivity.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$2", "Lcom/bytedance/sdk/account/AccountSdkCallback;", "Lcom/bytedance/sdk/account/response/SendCodeResponseData;", "onSuccess", "", "response", "Lcom/bytedance/sdk/account/AccountSdkResponse;", "onError", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PhoneBindActivity$sendCodeToNewPhone$2 implements AccountSdkCallback<SendCodeResponseData> {
    final /* synthetic */ PhoneBindActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PhoneBindActivity$sendCodeToNewPhone$2(PhoneBindActivity phoneBindActivity) {
        this.this$0 = phoneBindActivity;
    }

    public void onSuccess(AccountSdkResponse<SendCodeResponseData> response) {
        AtomicBoolean atomicBoolean;
        Intrinsics.checkNotNullParameter(response, "response");
        atomicBoolean = this.this$0.isSendingCode;
        atomicBoolean.set(false);
        final PhoneBindActivity phoneBindActivity = this.this$0;
        phoneBindActivity.runOnUiThreadSafe(new Function0() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$sendCodeToNewPhone$2$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit onSuccess$lambda$0;
                onSuccess$lambda$0 = PhoneBindActivity$sendCodeToNewPhone$2.onSuccess$lambda$0(PhoneBindActivity.this);
                return onSuccess$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSuccess$lambda$0(PhoneBindActivity phoneBindActivity) {
        phoneBindActivity.goToVerifyNewStep();
        return Unit.INSTANCE;
    }

    public void onError(final AccountSdkResponse<SendCodeResponseData> response) {
        AtomicBoolean atomicBoolean;
        Intrinsics.checkNotNullParameter(response, "response");
        atomicBoolean = this.this$0.isSendingCode;
        atomicBoolean.set(false);
        PhoneBindActivity.trackSettingsPhoneBindingResult$default(this.this$0, SccResult.MESSAGE_FAIL, "send_new_code", null, response.errorMessage, 4, null);
        final PhoneBindActivity phoneBindActivity = this.this$0;
        phoneBindActivity.runOnUiThreadSafe(new Function0() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$sendCodeToNewPhone$2$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onError$lambda$1;
                onError$lambda$1 = PhoneBindActivity$sendCodeToNewPhone$2.onError$lambda$1(PhoneBindActivity.this, response);
                return onError$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onError$lambda$1(PhoneBindActivity phoneBindActivity, AccountSdkResponse accountSdkResponse) {
        boolean isPhoneAlreadyBoundError;
        isPhoneAlreadyBoundError = phoneBindActivity.isPhoneAlreadyBoundError(accountSdkResponse.errorCode, accountSdkResponse.errorMessage);
        if (isPhoneAlreadyBoundError) {
            phoneBindActivity.showPhoneConflictDialog();
        } else {
            String str = accountSdkResponse.errorMessage;
            Context context = (Context) phoneBindActivity;
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                str = phoneBindActivity.getString(C0820R.string.trae_phone_send_code_fail);
                Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
            }
            Toast.makeText(context, str, 0).show();
        }
        return Unit.INSTANCE;
    }
}
