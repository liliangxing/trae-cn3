package com.bytedance.trae.account;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Pair;
import com.bytedance.sdk.account.api.BDAccountEvent;
import com.bytedance.sdk.account.api.BDAccountEventListener;
import com.bytedance.sdk.account.api.IBDAccount;
import com.bytedance.sdk.account.impl.BDAccountDelegateInner;
import com.bytedance.sdk.account.utils.ILogger;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.api.IAccountCallback;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.IRequestTagHeaderProvider;
import com.ss.android.TTHeader;
import com.ss.android.account.TTAccountInit;
import com.ss.android.token.TTTokenConfig;
import com.ss.android.token.TTTokenManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TTAccount.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/account/TTAccount;", "", "<init>", "()V", "TAG", "", "accountEventsListener", "Lcom/bytedance/sdk/account/api/BDAccountEventListener;", "isNetworkAvailable", "", "init", "", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TTAccount {
    private static final String TAG = "TTAccount";
    public static final TTAccount INSTANCE = new TTAccount();
    private static final BDAccountEventListener accountEventsListener = new BDAccountEventListener() { // from class: com.bytedance.trae.account.TTAccount$$ExternalSyntheticLambda0
        @Override // com.bytedance.sdk.account.api.BDAccountEventListener
        public final void onReceiveAccountEvent(BDAccountEvent bDAccountEvent) {
            TTAccount.accountEventsListener$lambda$0(bDAccountEvent);
        }
    };
    public static final int $stable = 8;

    private TTAccount() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accountEventsListener$lambda$0(BDAccountEvent bDAccountEvent) {
        boolean z = false;
        if (bDAccountEvent != null && bDAccountEvent.type == 2) {
            z = true;
        }
        if (z) {
            if (!INSTANCE.isNetworkAvailable()) {
                FLogger.INSTANCE.w(TAG, "SESSION_EXPIRED event received but network unavailable, ignoring logout");
                return;
            }
            FLogger.INSTANCE.i(TAG, "SESSION_EXPIRED event received with network available, performing logout");
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            if (iLoginService != null) {
                iLoginService.logout(true, (IAccountCallback) null, "logout_by_session_expired");
            }
        }
    }

    private final boolean isNetworkAvailable() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        Object systemService = AppHost.INSTANCE.getApplication().getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(12);
    }

    public final void init() {
        TTAccountInit.setRequestTagHeaderProvider(new IRequestTagHeaderProvider() { // from class: com.bytedance.trae.account.TTAccount$init$1
            public TTHeader getRequestTagHeader(final boolean isAuto) {
                Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.trae.account.TTAccount$init$1$getRequestTagHeader$requestTag$1
                    public int triggerType() {
                        return !isAuto ? 1 : 0;
                    }
                });
                return new TTHeader((String) buildBDNetworkTag.first, (String) buildBDNetworkTag.second);
            }

            public TTHeader getRequestTagHeader(final boolean isAuto, boolean isNewUser) {
                Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.trae.account.TTAccount$init$1$getRequestTagHeader$requestTag$2
                    public int triggerType() {
                        return !isAuto ? 1 : 0;
                    }
                });
                return new TTHeader((String) buildBDNetworkTag.first, (String) buildBDNetworkTag.second);
            }
        });
        TTAccountInit.setLogger(new ILogger() { // from class: com.bytedance.trae.account.TTAccount$$ExternalSyntheticLambda1
            @Override // com.bytedance.sdk.account.utils.ILogger
            public final void log(int i, String str, String str2) {
                TTAccount.init$lambda$1(i, str, str2);
            }
        });
        TTAccountInit.init(new TTAccountConfig());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(HostResolver.INSTANCE.getAllHosts(HostType.ONLINE));
        arrayList.addAll(HostResolver.INSTANCE.getAllHosts(HostType.LOGIN));
        TTTokenManager.initialize(AppHost.INSTANCE.getApplication(), new TTTokenConfig().setUpdateInterval(600000L).addHostList(arrayList).setTokenSign(true));
        BDAccountDelegateInner.instance(AppHost.INSTANCE.getApplication()).addListener(accountEventsListener);
        IApplog.INSTANCE.setBDAccountCallbackProvider(new Function0() { // from class: com.bytedance.trae.account.TTAccount$$ExternalSyntheticLambda2
            public final Object invoke() {
                Pair init$lambda$2;
                init$lambda$2 = TTAccount.init$lambda$2();
                return init$lambda$2;
            }
        });
        AccountInitExt.INSTANCE.setupAuthExpirationConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1(int i, String str, String str2) {
        switch (i) {
            case 2:
                FLogger fLogger = FLogger.INSTANCE;
                Intrinsics.checkNotNull(str);
                fLogger.v(str, str2);
                return;
            case 3:
            case 4:
                FLogger fLogger2 = FLogger.INSTANCE;
                Intrinsics.checkNotNull(str);
                fLogger2.i(str, str2);
                return;
            case 5:
                FLogger fLogger3 = FLogger.INSTANCE;
                Intrinsics.checkNotNull(str);
                fLogger3.w(str, str2);
                return;
            case 6:
            case 7:
                FLogger fLogger4 = FLogger.INSTANCE;
                Intrinsics.checkNotNull(str);
                fLogger4.e(str, str2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair init$lambda$2() {
        IBDAccount instance = BDAccountDelegateInner.instance();
        return new Pair(Integer.valueOf(instance.getOdinUserType()), Long.valueOf(instance.isLogin() ? instance.getUserId() : 0L));
    }
}
