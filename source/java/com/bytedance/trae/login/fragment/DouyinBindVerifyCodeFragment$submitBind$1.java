package com.bytedance.trae.login.fragment;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.mobile.query.BindLoginObj;
import com.bytedance.sdk.account.mobile.thread.call.BindLoginCallback;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.DeletionPendingDialogHelper;
import com.bytedance.trae.login.activity.DouyinBindPhoneActivity;
import com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding;
import com.bytedance.trae.login.tracker.LoginTracker;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DouyinBindVerifyCodeFragment.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J \u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$submitBind$1", "Lcom/bytedance/sdk/account/mobile/thread/call/BindLoginCallback;", "onSuccess", "", "response", "Lcom/bytedance/sdk/account/api/call/MobileApiResponse;", "Lcom/bytedance/sdk/account/mobile/query/BindLoginObj;", "onError", "error", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DouyinBindVerifyCodeFragment$submitBind$1 extends BindLoginCallback {
    final /* synthetic */ DouyinBindVerifyCodeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DouyinBindVerifyCodeFragment$submitBind$1(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment) {
        this.this$0 = douyinBindVerifyCodeFragment;
    }

    public void onSuccess(MobileApiResponse<BindLoginObj> response) {
        TraeAuthManager.INSTANCE.onPassportLoginSuccess("douyin", new DouyinBindVerifyCodeFragment$submitBind$1$onSuccess$1(response, this.this$0));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onError(final MobileApiResponse<BindLoginObj> response, final int error) {
        String str;
        boolean z;
        String str2;
        BindLoginObj bindLoginObj;
        boolean isVerifyCodeError;
        boolean isVerifyCodeError2;
        if (response == null || (str = response.errorMsg) == null) {
            str = "bind_login_error_" + error;
        }
        boolean z2 = true;
        if (error != 1201 && error != 1202 && error != 1203 && error != 1204) {
            isVerifyCodeError2 = this.this$0.isVerifyCodeError(str);
            if (!isVerifyCodeError2) {
                z = false;
                if (error != 1007 || error == 1041) {
                    str2 = "phone_already_bound";
                } else if (error != 1075) {
                    str2 = "verify_code_error";
                    switch (error) {
                        case LynxErrorCode.LYNX_ERROR_MAIN_FLOW /* 1201 */:
                        case 1202:
                        case 1203:
                        case 1204:
                            break;
                        default:
                            isVerifyCodeError = this.this$0.isVerifyCodeError(str);
                            if (!isVerifyCodeError) {
                                str2 = "bind_login";
                                break;
                            }
                            break;
                    }
                } else {
                    str2 = "account_deletion_pending";
                }
                String str3 = str2;
                LoginTracker.INSTANCE.trackDouyinBindPhoneResult(false, "submit_bind_phone", String.valueOf(error), str);
                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_FAIL, "douyin", null, str3, String.valueOf(error), str, null, null, null, SccResult.MESSAGE_FAIL, "submit_bind_phone", 452, null);
                if (z) {
                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_VERIFY_CODE_ERROR, "douyin", null, str3, String.valueOf(error), str, null, null, null, SccResult.MESSAGE_FAIL, "submit_bind_phone", 452, null);
                }
                final String str4 = (response != null || (bindLoginObj = response.mobileObj) == null) ? null : bindLoginObj.mCancelToken;
                if (error == 1075) {
                    String str5 = str4;
                    if (str5 != null && str5.length() != 0) {
                        z2 = false;
                    }
                    if (!z2) {
                        final DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment = this.this$0;
                        douyinBindVerifyCodeFragment.runOnHost(new Function2() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj, Object obj2) {
                                Unit onError$lambda$2;
                                onError$lambda$2 = DouyinBindVerifyCodeFragment$submitBind$1.onError$lambda$2(DouyinBindVerifyCodeFragment.this, str4, (DouyinBindPhoneActivity) obj, (TraeFragmentDouyinBindVerifyCodeBinding) obj2);
                                return onError$lambda$2;
                            }
                        });
                        return;
                    }
                }
                if (error != 1007 || error == 1041) {
                    final DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment2 = this.this$0;
                    douyinBindVerifyCodeFragment2.runOnHost(new Function2() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            Unit onError$lambda$3;
                            onError$lambda$3 = DouyinBindVerifyCodeFragment$submitBind$1.onError$lambda$3(DouyinBindVerifyCodeFragment.this, (DouyinBindPhoneActivity) obj, (TraeFragmentDouyinBindVerifyCodeBinding) obj2);
                            return onError$lambda$3;
                        }
                    });
                } else {
                    final DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment3 = this.this$0;
                    douyinBindVerifyCodeFragment3.runOnHost(new Function2() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit onError$lambda$4;
                            onError$lambda$4 = DouyinBindVerifyCodeFragment$submitBind$1.onError$lambda$4(DouyinBindVerifyCodeFragment.this, response, error, (DouyinBindPhoneActivity) obj, (TraeFragmentDouyinBindVerifyCodeBinding) obj2);
                            return onError$lambda$4;
                        }
                    });
                    return;
                }
            }
        }
        z = true;
        if (error != 1007) {
        }
        str2 = "phone_already_bound";
        String str32 = str2;
        LoginTracker.INSTANCE.trackDouyinBindPhoneResult(false, "submit_bind_phone", String.valueOf(error), str);
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_FAIL, "douyin", null, str32, String.valueOf(error), str, null, null, null, SccResult.MESSAGE_FAIL, "submit_bind_phone", 452, null);
        if (z) {
        }
        if (response != null) {
        }
        if (error == 1075) {
        }
        if (error != 1007) {
        }
        final DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment22 = this.this$0;
        douyinBindVerifyCodeFragment22.runOnHost(new Function2() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit onError$lambda$3;
                onError$lambda$3 = DouyinBindVerifyCodeFragment$submitBind$1.onError$lambda$3(DouyinBindVerifyCodeFragment.this, (DouyinBindPhoneActivity) obj, (TraeFragmentDouyinBindVerifyCodeBinding) obj2);
                return onError$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onError$lambda$2(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment, String str, final DouyinBindPhoneActivity douyinBindPhoneActivity, final TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding) {
        Intrinsics.checkNotNullParameter(douyinBindPhoneActivity, "activity");
        Intrinsics.checkNotNullParameter(traeFragmentDouyinBindVerifyCodeBinding, "binding");
        douyinBindVerifyCodeFragment.isSubmitting = false;
        douyinBindPhoneActivity.setBindLoading(false);
        DeletionPendingDialogHelper.INSTANCE.show((Activity) douyinBindPhoneActivity, str, new Function0() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit onError$lambda$2$lambda$0;
                onError$lambda$2$lambda$0 = DouyinBindVerifyCodeFragment$submitBind$1.onError$lambda$2$lambda$0(DouyinBindPhoneActivity.this);
                return onError$lambda$2$lambda$0;
            }
        }, new Function0() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$submitBind$1$$ExternalSyntheticLambda4
            public final Object invoke() {
                Unit onError$lambda$2$lambda$1;
                onError$lambda$2$lambda$1 = DouyinBindVerifyCodeFragment$submitBind$1.onError$lambda$2$lambda$1(TraeFragmentDouyinBindVerifyCodeBinding.this);
                return onError$lambda$2$lambda$1;
            }
        }, "douyin");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onError$lambda$2$lambda$0(DouyinBindPhoneActivity douyinBindPhoneActivity) {
        douyinBindPhoneActivity.navigateToMainActivity();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onError$lambda$2$lambda$1(TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding) {
        traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput.setEnabled(true);
        traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput.setText("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onError$lambda$3(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment, DouyinBindPhoneActivity douyinBindPhoneActivity, TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding) {
        Intrinsics.checkNotNullParameter(douyinBindPhoneActivity, "activity");
        Intrinsics.checkNotNullParameter(traeFragmentDouyinBindVerifyCodeBinding, "binding");
        douyinBindVerifyCodeFragment.isSubmitting = false;
        douyinBindPhoneActivity.setBindLoading(false);
        traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput.setEnabled(true);
        traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput.setText("");
        douyinBindVerifyCodeFragment.showPhoneConflictDialog(douyinBindPhoneActivity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onError$lambda$4(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment, MobileApiResponse mobileApiResponse, int i, DouyinBindPhoneActivity douyinBindPhoneActivity, TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding) {
        String string;
        Intrinsics.checkNotNullParameter(douyinBindPhoneActivity, "activity");
        Intrinsics.checkNotNullParameter(traeFragmentDouyinBindVerifyCodeBinding, "binding");
        douyinBindVerifyCodeFragment.isSubmitting = false;
        douyinBindPhoneActivity.setBindLoading(false);
        traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput.setEnabled(true);
        traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput.setText("");
        Context context = (Context) douyinBindPhoneActivity;
        if (mobileApiResponse == null || (string = mobileApiResponse.errorMsg) == null) {
            string = douyinBindVerifyCodeFragment.getString(C0820R.string.trae_douyin_bind_fail, new Object[]{Integer.valueOf(i)});
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        Toast.makeText(context, string, 0).show();
        return Unit.INSTANCE;
    }
}
