package com.bytedance.trae.login.activity;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.mobile.query.SendCodeQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.SendCodeCallback;
import com.bytedance.trae.login.C0820R;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhoneBindActivity.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J \u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/bytedance/trae/login/activity/PhoneBindActivity$sendCodeToNewPhone$1", "Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;", "onSuccess", "", "response", "Lcom/bytedance/sdk/account/api/call/MobileApiResponse;", "Lcom/bytedance/sdk/account/mobile/query/SendCodeQueryObj;", "onError", "error", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PhoneBindActivity$sendCodeToNewPhone$1 extends SendCodeCallback {
    final /* synthetic */ PhoneBindActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PhoneBindActivity$sendCodeToNewPhone$1(PhoneBindActivity phoneBindActivity) {
        this.this$0 = phoneBindActivity;
    }

    public void onSuccess(MobileApiResponse<SendCodeQueryObj> response) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.this$0.isSendingCode;
        atomicBoolean.set(false);
        final PhoneBindActivity phoneBindActivity = this.this$0;
        phoneBindActivity.runOnUiThreadSafe(new Function0() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$sendCodeToNewPhone$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onSuccess$lambda$0;
                onSuccess$lambda$0 = PhoneBindActivity$sendCodeToNewPhone$1.onSuccess$lambda$0(PhoneBindActivity.this);
                return onSuccess$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSuccess$lambda$0(PhoneBindActivity phoneBindActivity) {
        phoneBindActivity.goToVerifyNewStep();
        return Unit.INSTANCE;
    }

    public void onError(final MobileApiResponse<SendCodeQueryObj> response, final int error) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.this$0.isSendingCode;
        atomicBoolean.set(false);
        this.this$0.trackSettingsPhoneBindingResult(SccResult.MESSAGE_FAIL, "send_new_code", Integer.valueOf(error), response != null ? response.errorMsg : null);
        final PhoneBindActivity phoneBindActivity = this.this$0;
        phoneBindActivity.runOnUiThreadSafe(new Function0() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$sendCodeToNewPhone$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit onError$lambda$1;
                onError$lambda$1 = PhoneBindActivity$sendCodeToNewPhone$1.onError$lambda$1(PhoneBindActivity.this, error, response);
                return onError$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onError$lambda$1(PhoneBindActivity phoneBindActivity, int i, MobileApiResponse mobileApiResponse) {
        boolean isPhoneAlreadyBoundError;
        String string;
        isPhoneAlreadyBoundError = phoneBindActivity.isPhoneAlreadyBoundError(i, mobileApiResponse != null ? mobileApiResponse.errorMsg : null);
        if (isPhoneAlreadyBoundError) {
            phoneBindActivity.showPhoneConflictDialog();
        } else {
            Context context = (Context) phoneBindActivity;
            if (mobileApiResponse == null || (string = mobileApiResponse.errorMsg) == null) {
                string = phoneBindActivity.getString(C0820R.string.trae_phone_send_code_fail);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            }
            Toast.makeText(context, string, 0).show();
        }
        return Unit.INSTANCE;
    }
}
