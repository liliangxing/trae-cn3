package com.bytedance.trae.login.fragment;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.mobile.query.SendCodeQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.SendCodeCallback;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.activity.DouyinBindPhoneActivity;
import com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DouyinBindVerifyCodeFragment.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J \u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$resendCode$1", "Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;", "onSuccess", "", "response", "Lcom/bytedance/sdk/account/api/call/MobileApiResponse;", "Lcom/bytedance/sdk/account/mobile/query/SendCodeQueryObj;", "onError", "error", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DouyinBindVerifyCodeFragment$resendCode$1 extends SendCodeCallback {
    final /* synthetic */ DouyinBindVerifyCodeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DouyinBindVerifyCodeFragment$resendCode$1(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment) {
        this.this$0 = douyinBindVerifyCodeFragment;
    }

    public void onSuccess(MobileApiResponse<SendCodeQueryObj> response) {
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_RESEND_CODE_SUCCESS, "douyin", null, null, null, null, null, null, null, "success", null, 1532, null);
        final DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment = this.this$0;
        douyinBindVerifyCodeFragment.runOnHost(new Function2() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$resendCode$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit onSuccess$lambda$0;
                onSuccess$lambda$0 = DouyinBindVerifyCodeFragment$resendCode$1.onSuccess$lambda$0(DouyinBindVerifyCodeFragment.this, (DouyinBindPhoneActivity) obj, (TraeFragmentDouyinBindVerifyCodeBinding) obj2);
                return onSuccess$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSuccess$lambda$0(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment, DouyinBindPhoneActivity douyinBindPhoneActivity, TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding) {
        Intrinsics.checkNotNullParameter(douyinBindPhoneActivity, "<unused var>");
        Intrinsics.checkNotNullParameter(traeFragmentDouyinBindVerifyCodeBinding, "binding");
        douyinBindVerifyCodeFragment.isResending = false;
        traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput.setText("");
        douyinBindVerifyCodeFragment.startCountdown();
        return Unit.INSTANCE;
    }

    public void onError(final MobileApiResponse<SendCodeQueryObj> response, int error) {
        this.this$0.isResending = false;
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_RESEND_CODE_FAIL, "douyin", null, null, String.valueOf(error), response != null ? response.errorMsg : null, null, null, null, SccResult.MESSAGE_FAIL, null, 1484, null);
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_SMS_RESEND_ERROR, "douyin", null, null, String.valueOf(error), response != null ? response.errorMsg : null, null, null, null, null, null, 1984, null);
        final DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment = this.this$0;
        douyinBindVerifyCodeFragment.runOnHost(new Function2() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$resendCode$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit onError$lambda$1;
                onError$lambda$1 = DouyinBindVerifyCodeFragment$resendCode$1.onError$lambda$1(DouyinBindVerifyCodeFragment.this, response, (DouyinBindPhoneActivity) obj, (TraeFragmentDouyinBindVerifyCodeBinding) obj2);
                return onError$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onError$lambda$1(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment, MobileApiResponse mobileApiResponse, DouyinBindPhoneActivity douyinBindPhoneActivity, TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding) {
        String string;
        Intrinsics.checkNotNullParameter(douyinBindPhoneActivity, "activity");
        Intrinsics.checkNotNullParameter(traeFragmentDouyinBindVerifyCodeBinding, "<unused var>");
        douyinBindVerifyCodeFragment.setResendReady();
        Context context = (Context) douyinBindPhoneActivity;
        if (mobileApiResponse == null || (string = mobileApiResponse.errorMsg) == null) {
            string = douyinBindVerifyCodeFragment.getString(C0820R.string.trae_phone_send_code_fail);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        Toast.makeText(context, string, 0).show();
        return Unit.INSTANCE;
    }
}
