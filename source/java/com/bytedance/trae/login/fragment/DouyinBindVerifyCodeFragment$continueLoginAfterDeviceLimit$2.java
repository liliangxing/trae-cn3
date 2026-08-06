package com.bytedance.trae.login.fragment;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.activity.DouyinBindPhoneActivity;
import com.bytedance.trae.login.api.AccountStatus;
import com.bytedance.trae.login.api.LoginPlatform;
import com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding;
import com.bytedance.trae.login.service.AccountHelper;
import com.bytedance.trae.login.tracker.LoginTracker;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DouyinBindVerifyCodeFragment.kt */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2", "Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;", "onSuccess", "", "onFailure", "errorCode", "", "errorMessage", "deviceOverLimit", "token", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2 implements TraeAuthManager.TraeAuthCallback {
    final /* synthetic */ DouyinBindVerifyCodeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment) {
        this.this$0 = douyinBindVerifyCodeFragment;
    }

    @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
    public void onSuccess() {
        AccountHelper.INSTANCE.loginStatusChanged(AccountStatus.LOGGED_IN, "", LoginPlatform.DOUYIN);
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_SUCCESS, "douyin", null, "device_limit_continue", null, null, null, null, null, "success", "device_limit_continue", 500, null);
        LoginTracker.trackDouyinBindPhoneResult$default(LoginTracker.INSTANCE, true, "device_limit_continue", null, null, 12, null);
        final DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment = this.this$0;
        douyinBindVerifyCodeFragment.runOnHost(new Function2() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit onSuccess$lambda$0;
                onSuccess$lambda$0 = DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2.onSuccess$lambda$0(DouyinBindVerifyCodeFragment.this, (DouyinBindPhoneActivity) obj, (TraeFragmentDouyinBindVerifyCodeBinding) obj2);
                return onSuccess$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSuccess$lambda$0(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment, DouyinBindPhoneActivity douyinBindPhoneActivity, TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding) {
        Intrinsics.checkNotNullParameter(douyinBindPhoneActivity, "activity");
        Intrinsics.checkNotNullParameter(traeFragmentDouyinBindVerifyCodeBinding, "<unused var>");
        douyinBindVerifyCodeFragment.isSubmitting = false;
        douyinBindPhoneActivity.setBindLoading(false);
        douyinBindPhoneActivity.navigateToMainActivity();
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
    public void onFailure(String errorCode, final String errorMessage) {
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_TRAE_AUTH_FAIL, "douyin", null, "device_limit_continue", errorCode, errorMessage, null, null, null, SccResult.MESSAGE_FAIL, "device_limit_continue", 452, null);
        LoginTracker.INSTANCE.trackDouyinBindPhoneResult(false, "device_limit_continue", errorCode, errorMessage);
        final DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment = this.this$0;
        douyinBindVerifyCodeFragment.runOnHost(new Function2() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit onFailure$lambda$1;
                onFailure$lambda$1 = DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2.onFailure$lambda$1(DouyinBindVerifyCodeFragment.this, errorMessage, (DouyinBindPhoneActivity) obj, (TraeFragmentDouyinBindVerifyCodeBinding) obj2);
                return onFailure$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onFailure$lambda$1(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment, String str, DouyinBindPhoneActivity douyinBindPhoneActivity, TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding) {
        Intrinsics.checkNotNullParameter(douyinBindPhoneActivity, "activity");
        Intrinsics.checkNotNullParameter(traeFragmentDouyinBindVerifyCodeBinding, "binding");
        douyinBindVerifyCodeFragment.isSubmitting = false;
        douyinBindPhoneActivity.setBindLoading(false);
        traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput.setEnabled(true);
        Context context = (Context) douyinBindPhoneActivity;
        if (str == null) {
            str = douyinBindVerifyCodeFragment.getString(C0820R.string.trae_douyin_bind_login_fail);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        }
        Toast.makeText(context, str, 0).show();
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
    public void deviceOverLimit(String token) {
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_DEVICE_LIMIT, "douyin", null, "device_limit_continue", null, "device_over_limit_again", null, null, null, SccResult.MESSAGE_FAIL, "device_limit_continue", 468, null);
        LoginTracker.trackDouyinBindPhoneResult$default(LoginTracker.INSTANCE, false, "device_limit_continue", null, "device_over_limit_again", 4, null);
        final DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment = this.this$0;
        douyinBindVerifyCodeFragment.runOnHost(new Function2() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit deviceOverLimit$lambda$2;
                deviceOverLimit$lambda$2 = DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2.deviceOverLimit$lambda$2(DouyinBindVerifyCodeFragment.this, (DouyinBindPhoneActivity) obj, (TraeFragmentDouyinBindVerifyCodeBinding) obj2);
                return deviceOverLimit$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit deviceOverLimit$lambda$2(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment, DouyinBindPhoneActivity douyinBindPhoneActivity, TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding) {
        Intrinsics.checkNotNullParameter(douyinBindPhoneActivity, "activity");
        Intrinsics.checkNotNullParameter(traeFragmentDouyinBindVerifyCodeBinding, "binding");
        douyinBindVerifyCodeFragment.isSubmitting = false;
        douyinBindPhoneActivity.setBindLoading(false);
        traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput.setEnabled(true);
        Toast.makeText((Context) douyinBindPhoneActivity, C0820R.string.trae_douyin_bind_device_limit, 0).show();
        return Unit.INSTANCE;
    }
}
