package com.bytedance.trae.login.activity;

import com.bytedance.sdk.account.api.callback.SafeVerifyCallback;
import com.bytedance.sdk.account.api.response.SafeVerifyResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhoneBindActivity.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/bytedance/trae/login/activity/PhoneBindActivity$checkSafeEnv$1", "Lcom/bytedance/sdk/account/api/callback/SafeVerifyCallback;", "onSuccess", "", "response", "Lcom/bytedance/sdk/account/api/response/SafeVerifyResponse;", "onError", "error", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PhoneBindActivity$checkSafeEnv$1 extends SafeVerifyCallback {
    final /* synthetic */ PhoneBindActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PhoneBindActivity$checkSafeEnv$1(PhoneBindActivity phoneBindActivity) {
        this.this$0 = phoneBindActivity;
    }

    public void onSuccess(SafeVerifyResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        final PhoneBindActivity phoneBindActivity = this.this$0;
        phoneBindActivity.runOnUiThreadSafe(new Function0() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$checkSafeEnv$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit onSuccess$lambda$0;
                onSuccess$lambda$0 = PhoneBindActivity$checkSafeEnv$1.onSuccess$lambda$0(PhoneBindActivity.this);
                return onSuccess$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSuccess$lambda$0(PhoneBindActivity phoneBindActivity) {
        phoneBindActivity.showLoading(false);
        phoneBindActivity.sendCodeToOldPhone();
        return Unit.INSTANCE;
    }

    public void onError(SafeVerifyResponse response, int error) {
        Intrinsics.checkNotNullParameter(response, "response");
        final PhoneBindActivity phoneBindActivity = this.this$0;
        phoneBindActivity.runOnUiThreadSafe(new Function0() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$checkSafeEnv$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onError$lambda$1;
                onError$lambda$1 = PhoneBindActivity$checkSafeEnv$1.onError$lambda$1(PhoneBindActivity.this);
                return onError$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onError$lambda$1(PhoneBindActivity phoneBindActivity) {
        phoneBindActivity.showLoading(false);
        phoneBindActivity.sendCodeToOldPhone();
        return Unit.INSTANCE;
    }
}
