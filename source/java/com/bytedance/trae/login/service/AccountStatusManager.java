package com.bytedance.trae.login.service;

import com.bytedance.trae.login.api.AccountStatus;
import com.bytedance.trae.login.api.IAccountStatusListener;
import com.bytedance.trae.login.traeauth.TraeAuthStorage;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountStatusManager.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/login/service/AccountStatusManager;", "", "<init>", "()V", "mAccountStatusList", "", "Lcom/bytedance/trae/login/api/IAccountStatusListener;", "ACCOUNT_STATUS_STICKY", "", "addAccountStatusCallback", "", "callback", "isSticky", "", "removeAccountStatusCallback", "loginStatusChanged", "status", "Lcom/bytedance/trae/login/api/AccountStatus;", "businessScene", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AccountStatusManager {
    private static final String ACCOUNT_STATUS_STICKY = "get_account_status_siticky";
    public static final AccountStatusManager INSTANCE = new AccountStatusManager();
    private static List<IAccountStatusListener> mAccountStatusList = new CopyOnWriteArrayList();

    private AccountStatusManager() {
    }

    public final void addAccountStatusCallback(IAccountStatusListener callback, boolean isSticky) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        List<IAccountStatusListener> list = mAccountStatusList;
        if (list != null) {
            list.add(callback);
        }
        if (isSticky) {
            callback.onAccountStatusChanged(TraeAuthStorage.INSTANCE.getJwtToken().length() > 0 ? AccountStatus.LOGGED_IN : AccountStatus.LOGGED_OUT, ACCOUNT_STATUS_STICKY);
        }
    }

    public final void removeAccountStatusCallback(IAccountStatusListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        List<IAccountStatusListener> list = mAccountStatusList;
        if (list != null) {
            list.remove(callback);
        }
    }

    public final void loginStatusChanged(AccountStatus status, String businessScene) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(businessScene, "businessScene");
        List<IAccountStatusListener> list = mAccountStatusList;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((IAccountStatusListener) it.next()).onAccountStatusChanged(status, businessScene);
            }
        }
    }
}
