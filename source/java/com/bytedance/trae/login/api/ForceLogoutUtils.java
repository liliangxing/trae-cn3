package com.bytedance.trae.login.api;

import android.app.Activity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForceLogoutUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\b\u0010\u000e\u001a\u00020\bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/login/api/ForceLogoutUtils;", "", "<init>", "()V", "logoutListeners", "", "Lcom/bytedance/trae/login/api/ForceLogoutUtils$OnLogoutListener;", "addOnLogoutListener", "", "listener", "removeOnLogoutListener", "performForceLogout", "activity", "Landroid/app/Activity;", "navigateToLogin", "OnLogoutListener", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForceLogoutUtils {
    public static final ForceLogoutUtils INSTANCE = new ForceLogoutUtils();
    private static final List<OnLogoutListener> logoutListeners = new ArrayList();

    /* compiled from: ForceLogoutUtils.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/trae/login/api/ForceLogoutUtils$OnLogoutListener;", "", "onLogout", "", "navigateToLogin", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface OnLogoutListener {
        void navigateToLogin();

        void onLogout();
    }

    private ForceLogoutUtils() {
    }

    public final void addOnLogoutListener(OnLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<OnLogoutListener> list = logoutListeners;
        if (list.contains(listener)) {
            return;
        }
        list.add(listener);
    }

    public final void removeOnLogoutListener(OnLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        logoutListeners.remove(listener);
    }

    public final void performForceLogout(Activity activity) {
        Iterator<T> it = logoutListeners.iterator();
        while (it.hasNext()) {
            ((OnLogoutListener) it.next()).onLogout();
        }
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null) {
            return;
        }
        iLoginService.logout(true, new IAccountCallback() { // from class: com.bytedance.trae.login.api.ForceLogoutUtils$performForceLogout$2
            @Override // com.bytedance.trae.login.api.IAccountCallback
            public void onDeviceOverLimit(String token, Map<String, ? extends Object> extras) {
            }

            @Override // com.bytedance.trae.login.api.IAccountCallback
            public void onSuccess(LoginPlatform platform, String businessScene, Boolean isNewUserLogin) {
                ForceLogoutUtils.INSTANCE.navigateToLogin();
            }

            @Override // com.bytedance.trae.login.api.IAccountCallback
            public void onFailed(LoginPlatform platform, int errorCode, String errorMessage, String businessScene, Throwable throwable, String profileKey, Integer originErrorCode, String originErrorMessage, Map<String, Object> ext) {
                ForceLogoutUtils.INSTANCE.navigateToLogin();
            }
        }, "risk_control");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToLogin() {
        Iterator<T> it = logoutListeners.iterator();
        while (it.hasNext()) {
            ((OnLogoutListener) it.next()).navigateToLogin();
        }
    }
}
