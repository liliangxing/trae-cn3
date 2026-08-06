package com.bytedance.trae.login.enterprise;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.impl.BDAccountPlatformImpl;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import com.bytedance.trae.login.enterprise.EnterprisePassportLogin;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* compiled from: EnterprisePassportLogin.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterprisePassportLogin;", "", "<init>", "()V", "TAG", "", "PLATFORM_APP_ID", "PLATFORM_NAME", "login", "", "accessToken", "callback", "Lcom/bytedance/trae/login/enterprise/EnterprisePassportLogin$Callback;", "reportBind", "Callback", "EnterprisePassportBindApi", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EnterprisePassportLogin {
    public static final EnterprisePassportLogin INSTANCE = new EnterprisePassportLogin();
    private static final String PLATFORM_APP_ID = "23109";
    private static final String PLATFORM_NAME = "customize_trae_saas";
    private static final String TAG = "EnterprisePassportLogin";

    /* compiled from: EnterprisePassportLogin.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterprisePassportLogin$Callback;", "", "onSuccess", "", "userId", "", "onError", "errorCode", "", "errorMessage", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface Callback {
        void onError(int errorCode, String errorMessage);

        void onSuccess(long userId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EnterprisePassportLogin.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H§@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterprisePassportLogin$EnterprisePassportBindApi;", "", "bindPassportUserId", "Lcom/bytedance/retrofit2/SsResponse;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface EnterprisePassportBindApi {
        @POST("/trae/gtm/tob/api/v1/account/bind_passport_user_id")
        Object bindPassportUserId(Continuation<? super SsResponse<String>> continuation);
    }

    private EnterprisePassportLogin() {
    }

    public final void login(String accessToken, final Callback callback) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (accessToken.length() == 0) {
            FLogger.INSTANCE.mo426e(TAG, "accessToken is empty, skip passport login");
            callback.onError(-1, "accessToken is empty");
        } else {
            FLogger.INSTANCE.mo428i(TAG, "ssoWithAccessTokenLogin start");
            BDAccountPlatformImpl.instance().ssoWithAccessTokenLogin(PLATFORM_APP_ID, PLATFORM_NAME, accessToken, 0L, MapsKt.emptyMap(), new CommonCallBack<UserApiResponse>() { // from class: com.bytedance.trae.login.enterprise.EnterprisePassportLogin$login$1
                public void onSuccess(UserApiResponse response) {
                    IBDAccountUserEntity iBDAccountUserEntity;
                    long j = (response == null || (iBDAccountUserEntity = response.userInfo) == null) ? 0L : iBDAccountUserEntity.userId;
                    FLogger.INSTANCE.mo428i("EnterprisePassportLogin", "ssoWithAccessTokenLogin success, userId=" + j);
                    EnterprisePassportLogin.INSTANCE.reportBind();
                    EnterprisePassportLogin.Callback.this.onSuccess(j);
                }

                public void onError(UserApiResponse response, int error) {
                    String str;
                    if (response == null || (str = response.errorMsg) == null) {
                        str = "unknown";
                    }
                    FLogger.INSTANCE.mo426e("EnterprisePassportLogin", "ssoWithAccessTokenLogin failed: code=" + error + ", msg=" + str);
                    EnterprisePassportLogin.Callback.this.onError(error, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportBind() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ProcessLifecycleOwner.Companion.get()), Dispatchers.getIO(), (CoroutineStart) null, new EnterprisePassportLogin$reportBind$1(null), 2, (Object) null);
    }
}
