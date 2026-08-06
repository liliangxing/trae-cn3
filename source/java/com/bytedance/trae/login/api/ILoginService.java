package com.bytedance.trae.login.api;

import android.app.Activity;
import android.content.Intent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ILoginService.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J!\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\tH&J\b\u0010\u0012\u001a\u00020\tH&J\b\u0010\u0013\u001a\u00020\u0005H&J\b\u0010\u0014\u001a\u00020\u0005H&JX\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00030\u00182#\u0010\u001c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00030\u0018H&JM\u0010\u001f\u001a\u00020\u00032\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0!2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\"2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00030\u0018H&J.\u0010$\u001a\u00020\u00032\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u00182\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"H&JA\u0010%\u001a\u00020\u00032\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00030\u00182#\u0010\u001c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00030\u0018H&J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0016J\"\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010!2\b\u0010-\u001a\u0004\u0018\u00010)H\u0016J\"\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010)H\u0016J\b\u00101\u001a\u00020\u0003H\u0016¨\u00062"}, d2 = {"Lcom/bytedance/trae/login/api/ILoginService;", "", "logout", "", "forceLogout", "", "callback", "Lcom/bytedance/trae/login/api/IAccountCallback;", "businessScene", "", "registerAccountStatusChangeListener", "Lcom/bytedance/trae/login/api/IAccountStatusListener;", "isSticky", "(Lcom/bytedance/trae/login/api/IAccountStatusListener;Ljava/lang/Boolean;)V", "unregisterAccountStatusChangeListener", "getAccountInfo", "Lcom/bytedance/trae/login/api/AccountInfo;", "getXTToken", "getCloudideSession", "isNewUser", "isTraeLoggedIn", "uploadAvatar", "path", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "onFail", "", "errorCode", "updateUserProfile", "params", "", "Lkotlin/Function0;", "", "refreshUserInfo", "listLoginDevices", "Lcom/bytedance/trae/login/api/LoginDeviceListResult;", "errorMessage", "getGoogleSignInIntent", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "parseGoogleSignInResult", "data", "handleGoogleAuthResult", "requestCode", "resultCode", "cleanupGoogleAuth", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ILoginService {
    void cleanupGoogleAuth();

    AccountInfo getAccountInfo();

    String getCloudideSession();

    Intent getGoogleSignInIntent(Activity activity);

    String getXTToken();

    void handleGoogleAuthResult(int requestCode, int resultCode, Intent data);

    boolean isNewUser();

    boolean isTraeLoggedIn();

    void listLoginDevices(Function1<? super LoginDeviceListResult, Unit> onSuccess, Function1<? super String, Unit> onFail);

    void logout(boolean forceLogout, IAccountCallback callback, String businessScene);

    Map<String, String> parseGoogleSignInResult(Intent data);

    void refreshUserInfo(Function1<? super AccountInfo, Unit> onSuccess, Function0<Unit> onFail);

    void registerAccountStatusChangeListener(IAccountStatusListener callback, Boolean isSticky);

    void unregisterAccountStatusChangeListener(IAccountStatusListener callback);

    void updateUserProfile(Map<String, String> params, Function0<Unit> onSuccess, Function1<? super Integer, Unit> onFail);

    void uploadAvatar(String path, Function1<? super String, Unit> onSuccess, Function1<? super Long, Unit> onFail);

    /* compiled from: ILoginService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static void cleanupGoogleAuth(ILoginService iLoginService) {
        }

        public static Intent getGoogleSignInIntent(ILoginService iLoginService, Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return null;
        }

        public static void handleGoogleAuthResult(ILoginService iLoginService, int i, int i2, Intent intent) {
        }

        public static Map<String, String> parseGoogleSignInResult(ILoginService iLoginService, Intent intent) {
            return null;
        }

        public static /* synthetic */ void registerAccountStatusChangeListener$default(ILoginService iLoginService, IAccountStatusListener iAccountStatusListener, Boolean bool, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerAccountStatusChangeListener");
            }
            if ((i & 2) != 0) {
                bool = false;
            }
            iLoginService.registerAccountStatusChangeListener(iAccountStatusListener, bool);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void refreshUserInfo$default(ILoginService iLoginService, Function1 function1, Function0 function0, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshUserInfo");
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            iLoginService.refreshUserInfo(function1, function0);
        }
    }
}
