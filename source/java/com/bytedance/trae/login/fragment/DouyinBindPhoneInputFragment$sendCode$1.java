package com.bytedance.trae.login.fragment;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.mobile.query.SendCodeQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.SendCodeCallback;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.activity.DouyinBindPhoneActivity;
import com.bytedance.trae.login.databinding.TraeFragmentDouyinBindPhoneInputBinding;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DouyinBindPhoneInputFragment.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J \u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1", "Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;", "onSuccess", "", "response", "Lcom/bytedance/sdk/account/api/call/MobileApiResponse;", "Lcom/bytedance/sdk/account/mobile/query/SendCodeQueryObj;", "onError", "error", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DouyinBindPhoneInputFragment$sendCode$1 extends SendCodeCallback {
    final /* synthetic */ String $phone;
    final /* synthetic */ DouyinBindPhoneInputFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DouyinBindPhoneInputFragment$sendCode$1(DouyinBindPhoneInputFragment douyinBindPhoneInputFragment, String str) {
        this.this$0 = douyinBindPhoneInputFragment;
        this.$phone = str;
    }

    public void onSuccess(MobileApiResponse<SendCodeQueryObj> response) {
        final DouyinBindPhoneInputFragment douyinBindPhoneInputFragment = this.this$0;
        final String str = this.$phone;
        douyinBindPhoneInputFragment.runOnUiThread(new Function0() { // from class: com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment$sendCode$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit onSuccess$lambda$0;
                onSuccess$lambda$0 = DouyinBindPhoneInputFragment$sendCode$1.onSuccess$lambda$0(DouyinBindPhoneInputFragment.this, str);
                return onSuccess$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSuccess$lambda$0(DouyinBindPhoneInputFragment douyinBindPhoneInputFragment, String str) {
        douyinBindPhoneInputFragment.isSendingCode = false;
        douyinBindPhoneInputFragment.updateSendButton();
        DouyinBindPhoneActivity activity = douyinBindPhoneInputFragment.getActivity();
        DouyinBindPhoneActivity douyinBindPhoneActivity = activity instanceof DouyinBindPhoneActivity ? activity : null;
        if (douyinBindPhoneActivity != null) {
            douyinBindPhoneActivity.showVerifyCodeInput(str);
        }
        return Unit.INSTANCE;
    }

    public void onError(final MobileApiResponse<SendCodeQueryObj> response, int error) {
        this.this$0.isSendingCode = false;
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_SEND_CODE_FAIL, "douyin", null, null, String.valueOf(error), response != null ? response.errorMsg : null, null, null, null, null, null, 1984, null);
        final DouyinBindPhoneInputFragment douyinBindPhoneInputFragment = this.this$0;
        douyinBindPhoneInputFragment.runOnUiThread(new Function0() { // from class: com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment$sendCode$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onError$lambda$1;
                onError$lambda$1 = DouyinBindPhoneInputFragment$sendCode$1.onError$lambda$1(DouyinBindPhoneInputFragment.this, response);
                return onError$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onError$lambda$1(DouyinBindPhoneInputFragment douyinBindPhoneInputFragment, MobileApiResponse mobileApiResponse) {
        TraeFragmentDouyinBindPhoneInputBinding traeFragmentDouyinBindPhoneInputBinding;
        String string;
        if (douyinBindPhoneInputFragment.isAdded()) {
            traeFragmentDouyinBindPhoneInputBinding = douyinBindPhoneInputFragment.get_binding();
            if (traeFragmentDouyinBindPhoneInputBinding != null) {
                douyinBindPhoneInputFragment.isSendingCode = false;
                douyinBindPhoneInputFragment.updateSendButton();
                Context requireContext = douyinBindPhoneInputFragment.requireContext();
                if (mobileApiResponse == null || (string = mobileApiResponse.errorMsg) == null) {
                    string = douyinBindPhoneInputFragment.getString(C0820R.string.trae_phone_send_code_fail);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                }
                Toast.makeText(requireContext, string, 0).show();
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
}
