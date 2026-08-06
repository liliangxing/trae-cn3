package com.bytedance.trae.login.service;

import android.content.Context;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.platform.PlatformLoginAdapter;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.api.IAccountCallback;
import com.bytedance.trae.login.api.LoginPlatform;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DouyinLoginServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1", "Lcom/bytedance/sdk/account/platform/PlatformLoginAdapter;", "onLoginSuccess", "", "response", "Lcom/bytedance/sdk/account/api/call/UserApiResponse;", "onLoginError", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DouyinLoginServiceImpl$authorize$platformCallback$1 extends PlatformLoginAdapter {
    final /* synthetic */ String $businessScene;
    final /* synthetic */ IAccountCallback $callback;
    final /* synthetic */ DouyinLoginServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DouyinLoginServiceImpl$authorize$platformCallback$1(DouyinLoginServiceImpl douyinLoginServiceImpl, String str, IAccountCallback iAccountCallback, Context context) {
        super(context, "23081", "aweme_v2", true, false);
        this.this$0 = douyinLoginServiceImpl;
        this.$businessScene = str;
        this.$callback = iAccountCallback;
    }

    public void onLoginSuccess(UserApiResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_AUTH_SUCCESS_NO_BIND, "douyin", null, null, null, null, null, null, null, null, null, 2044, null);
        TraeAuthManager.INSTANCE.onPassportLoginSuccess("douyin", new C0869xc2b79d06(this.this$0, response, this.$businessScene, this.$callback));
    }

    public void onLoginError(final UserApiResponse response) {
        String str;
        Intrinsics.checkNotNullParameter(response, "response");
        final String profileKey = response.getProfileKey();
        if (response.error == 1060) {
            String str2 = profileKey;
            if (!(str2 == null || str2.length() == 0)) {
                DouyinLoginServiceImpl douyinLoginServiceImpl = this.this$0;
                final IAccountCallback iAccountCallback = this.$callback;
                final String str3 = this.$businessScene;
                douyinLoginServiceImpl.postToMain(new Function0() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit onLoginError$lambda$0;
                        onLoginError$lambda$0 = DouyinLoginServiceImpl$authorize$platformCallback$1.onLoginError$lambda$0(IAccountCallback.this, response, str3, profileKey);
                        return onLoginError$lambda$0;
                    }
                });
                return;
            }
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str4 = response.mCancelToken;
        if (str4 != null) {
            if (str4.length() > 0) {
                linkedHashMap.put("cancel_token", str4);
            }
        }
        if (response.error == -1001) {
            str = "user_cancelled";
        } else if (response.error == -1004) {
            str = "authorize_error";
        } else if (response.error == -1005) {
            str = "request_api_error";
        } else {
            str = response.error > 0 ? "passport_error" : "login_error";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("(" + response.error + ')');
        String str5 = response.errorMsg;
        String str6 = str5;
        if (!(str6 == null || str6.length() == 0)) {
            sb.append("|error_msg=" + str5);
        }
        if (response.mDetailErrorCode != 0) {
            sb.append("|detail_code=" + response.mDetailErrorCode);
        }
        String str7 = response.mDetailErrorMsg;
        String str8 = str7;
        if (!(str8 == null || str8.length() == 0)) {
            sb.append("|detail_msg=" + str7);
        }
        final String sb2 = sb.toString();
        DouyinLoginServiceImpl douyinLoginServiceImpl2 = this.this$0;
        final IAccountCallback iAccountCallback2 = this.$callback;
        final String str9 = this.$businessScene;
        douyinLoginServiceImpl2.postToMain(new Function0() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit onLoginError$lambda$4;
                onLoginError$lambda$4 = DouyinLoginServiceImpl$authorize$platformCallback$1.onLoginError$lambda$4(IAccountCallback.this, response, sb2, str9, linkedHashMap);
                return onLoginError$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoginError$lambda$0(IAccountCallback iAccountCallback, UserApiResponse userApiResponse, String str, String str2) {
        LoginPlatform loginPlatform = LoginPlatform.DOUYIN;
        int i = userApiResponse.error;
        String str3 = userApiResponse.errorMsg;
        if (str3 == null) {
            str3 = AppHost.Companion.getApplication().getString(C0820R.string.trae_douyin_need_bind_phone);
            Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
        }
        IAccountCallback.DefaultImpls.onFailed$default(iAccountCallback, loginPlatform, i, str3, str, null, str2, null, null, null, 448, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoginError$lambda$4(IAccountCallback iAccountCallback, UserApiResponse userApiResponse, String str, String str2, Map map) {
        IAccountCallback.DefaultImpls.onFailed$default(iAccountCallback, LoginPlatform.DOUYIN, userApiResponse.error, str, str2, null, null, null, null, map.isEmpty() ? null : map, 224, null);
        return Unit.INSTANCE;
    }
}
