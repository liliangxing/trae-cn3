package com.bytedance.trae.login.service;

import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.api.AccountStatus;
import com.bytedance.trae.login.api.IAccountCallback;
import com.bytedance.trae.login.api.LoginPlatform;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DouyinLoginServiceImpl.kt */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1", "Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;", "onSuccess", "", "onFailure", "errorCode", "", "errorMessage", "deviceOverLimit", "token", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: com.bytedance.trae.login.service.DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class C0869xc2b79d06 implements TraeAuthManager.TraeAuthCallback {
    final /* synthetic */ String $businessScene;
    final /* synthetic */ IAccountCallback $callback;
    final /* synthetic */ UserApiResponse $response;
    final /* synthetic */ DouyinLoginServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0869xc2b79d06(DouyinLoginServiceImpl douyinLoginServiceImpl, UserApiResponse userApiResponse, String str, IAccountCallback iAccountCallback) {
        this.this$0 = douyinLoginServiceImpl;
        this.$response = userApiResponse;
        this.$businessScene = str;
        this.$callback = iAccountCallback;
    }

    @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
    public void onSuccess() {
        DouyinLoginServiceImpl douyinLoginServiceImpl = this.this$0;
        final UserApiResponse userApiResponse = this.$response;
        final String str = this.$businessScene;
        final IAccountCallback iAccountCallback = this.$callback;
        douyinLoginServiceImpl.postToMain(new Function0() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit onSuccess$lambda$0;
                onSuccess$lambda$0 = C0869xc2b79d06.onSuccess$lambda$0(userApiResponse, str, iAccountCallback);
                return onSuccess$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSuccess$lambda$0(UserApiResponse userApiResponse, String str, IAccountCallback iAccountCallback) {
        IBDAccountUserEntity iBDAccountUserEntity = userApiResponse.userInfo;
        boolean z = false;
        if (iBDAccountUserEntity != null && iBDAccountUserEntity.isNewUser) {
            z = true;
        }
        AccountHelper.INSTANCE.setIsNewUser(z);
        AccountHelper.INSTANCE.loginStatusChanged(AccountStatus.LOGGED_IN, str == null ? "" : str, LoginPlatform.DOUYIN);
        iAccountCallback.onSuccess(LoginPlatform.DOUYIN, str, Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
    public void onFailure(final String errorCode, final String errorMessage) {
        DouyinLoginServiceImpl douyinLoginServiceImpl = this.this$0;
        final IAccountCallback iAccountCallback = this.$callback;
        final String str = this.$businessScene;
        douyinLoginServiceImpl.postToMain(new Function0() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onFailure$lambda$1;
                onFailure$lambda$1 = C0869xc2b79d06.onFailure$lambda$1(IAccountCallback.this, errorCode, errorMessage, str);
                return onFailure$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onFailure$lambda$1(IAccountCallback iAccountCallback, String str, String str2, String str3) {
        Integer intOrNull;
        LoginPlatform loginPlatform = LoginPlatform.DOUYIN;
        int intValue = (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? -1 : intOrNull.intValue();
        if (str2 == null) {
            str2 = AppHost.Companion.getApplication().getString(C0820R.string.trae_douyin_auth_failed);
            Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
        }
        IAccountCallback.DefaultImpls.onFailed$default(iAccountCallback, loginPlatform, intValue, str2, str3, null, null, null, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("failed_step", "trae_auth_after_douyin_auth")}), 224, null);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
    public void deviceOverLimit(final String token) {
        IBDAccountUserEntity iBDAccountUserEntity = this.$response.userInfo;
        boolean z = false;
        if (iBDAccountUserEntity != null && iBDAccountUserEntity.isNewUser) {
            z = true;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("is_new_user", Boolean.valueOf(z));
        DouyinLoginServiceImpl douyinLoginServiceImpl = this.this$0;
        final IAccountCallback iAccountCallback = this.$callback;
        douyinLoginServiceImpl.postToMain(new Function0() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit deviceOverLimit$lambda$2;
                deviceOverLimit$lambda$2 = C0869xc2b79d06.deviceOverLimit$lambda$2(IAccountCallback.this, token, hashMap);
                return deviceOverLimit$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deviceOverLimit$lambda$2(IAccountCallback iAccountCallback, String str, HashMap hashMap) {
        iAccountCallback.onDeviceOverLimit(str, hashMap);
        return Unit.INSTANCE;
    }
}
