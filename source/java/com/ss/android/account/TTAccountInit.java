package com.ss.android.account;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.sdk.bdticketguard.INetwork;
import com.bytedance.sdk.account.api.BDAccountEvent;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.response.CommonRequestResponse;
import com.bytedance.sdk.account.impl.BDAccountDelegateInner;
import com.bytedance.sdk.account.impl.BDAccountFrameworkManager;
import com.bytedance.sdk.account.impl.CommonRequestImpl;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IAccountSettingsService;
import com.bytedance.sdk.account.platform.api.IAuthorizeMonitorService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.ticketguard.TicketGuardNetwork;
import com.bytedance.sdk.account.utils.ILogger;
import com.bytedance.sdk.account.utils.IProjectMode;
import com.ss.android.IRequestTagHeaderProvider;
import com.ss.android.LogHelper;
import com.ss.android.ShowDialogActivity;
import com.ss.android.TTAccountConfig;
import com.ss.android.TTAccountExtraConfig;
import com.ss.android.account.dbtring.IBdTruing;
import com.ss.android.account.sec.IAccountSec;
import com.ss.android.token.ITokenService;
import com.ss.android.token.TTTokenManager;
import com.ss.android.token.TokenFactory;
import com.ss.android.token.TokenUtils;
import com.ss.android.ug.bus.UgBusFramework;
import com.ss.android.ug.bus.account.IAccountService;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TTAccountInit {
    private static final String TAG = "TTAccountInit";
    private static final Handler sCheckTokenHandler = new CheckTokenHandler(Looper.getMainLooper());
    private static volatile TTAccountConfig sConfig;
    private static volatile TTAccountExtraConfig sExtraConfig;
    private static volatile ILogger sLogger;
    private static volatile IProjectMode sProjectMode;
    private static volatile IRequestTagHeaderProvider sRequestTagHeaderProvider;

    public static void init(TTAccountConfig tTAccountConfig) {
        init(tTAccountConfig, false);
    }

    public static void init(final TTAccountConfig tTAccountConfig, boolean z) {
        if (tTAccountConfig == null) {
            return;
        }
        BDAccountFrameworkManager.instance().init();
        sConfig = tTAccountConfig;
        AuthorizeFramework.registerService(IAccountSettingsService.class, BDAccountDelegateInner.getSettingsInstance(getConfig().getApplicationContext()));
        if (sConfig.getMonitor() != null && AuthorizeFramework.getService(IAuthorizeMonitorService.class) == null) {
            AuthorizeFramework.registerService(IAuthorizeMonitorService.class, new IAuthorizeMonitorService() { // from class: com.ss.android.account.TTAccountInit.1
                public void onEvent(String str, JSONObject jSONObject) {
                    TTAccountInit.sConfig.getMonitor().onEvent(str, jSONObject);
                }
            });
        }
        IBdTruing iBdTruing = sConfig.getIBdTruing();
        if (iBdTruing != null) {
            BdTruingManager.getInst().setBdTruing(iBdTruing);
            if (!iBdTruing.forceDisable()) {
                if (!BdTruingManager.getInst().init()) {
                    throw new RuntimeException("please implement IBdTruing interface correctly");
                }
            } else {
                LogHelper.m37e(TAG, "force disable IBdTruing is not recommend");
            }
            IAccountSec iSec = sConfig.getISec();
            if (iSec != null) {
                SecInitManager.getInst().setAccountSec(iSec);
                if (!SecInitManager.getInst().init()) {
                    throw new RuntimeException("please implement IAccountSec interface correctly");
                }
                if (sConfig.getMonitor() == null) {
                    throw new RuntimeException("IMonitor == null");
                }
                doComponentReflection();
                if (z) {
                    sCheckTokenHandler.postDelayed(new Runnable() { // from class: com.ss.android.account.TTAccountInit.2
                        @Override // java.lang.Runnable
                        public void run() {
                            TTAccountInit.doComponentReflectionDelay();
                            UgBusFramework.registerService(IAccountService.class, AccountBusService.getIns());
                        }
                    }, 5000L);
                } else {
                    doComponentReflectionDelay();
                    UgBusFramework.registerService(IAccountService.class, AccountBusService.getIns());
                }
                if (TokenUtils.isMainProcess(sConfig.getApplicationContext())) {
                    sCheckTokenHandler.sendEmptyMessageDelayed(2001, 60000L);
                }
                TTTokenManager.setTokenService(new ITokenService() { // from class: com.ss.android.account.TTAccountInit.3
                    @Override // com.ss.android.token.ITokenService
                    public Context getApplicationContext() {
                        return TTAccountConfig.this.getApplicationContext();
                    }

                    @Override // com.ss.android.token.ITokenService
                    public void request(String str, Map<String, String> map, Map<String, String> map2, boolean z2, final ITokenService.Callback callback) {
                        CommonRequestImpl.instance().doCommonRequest(str, map, map2, z2, new AbsApiCall<CommonRequestResponse>() { // from class: com.ss.android.account.TTAccountInit.3.1
                            public void onResponse(CommonRequestResponse commonRequestResponse) {
                                ITokenService.Response response = new ITokenService.Response(commonRequestResponse.error, commonRequestResponse.mDetailErrorCode, commonRequestResponse.errorMsg, commonRequestResponse.mDetailErrorMsg, commonRequestResponse.data);
                                if (callback == null) {
                                    return;
                                }
                                if (commonRequestResponse.success) {
                                    callback.onSuccess(response);
                                } else {
                                    callback.onError(response);
                                }
                            }
                        });
                    }

                    @Override // com.ss.android.token.ITokenService
                    public boolean isLogin() {
                        return BDAccountDelegateInner.instance(getApplicationContext()).isLogin();
                    }

                    @Override // com.ss.android.token.ITokenService
                    public String host() {
                        return TTAccountConfig.this.host();
                    }

                    @Override // com.ss.android.token.ITokenService
                    public void onEvent(String str, JSONObject jSONObject) {
                        if (TTAccountInit.sConfig.getMonitor() != null) {
                            TTAccountInit.sConfig.getMonitor().onEvent(str, jSONObject);
                        }
                    }

                    @Override // com.ss.android.token.ITokenService
                    public void onSelfCheckError(String str, String str2) {
                        ShowDialogActivity.showDialog(TTAccountConfig.this.getApplicationContext(), str, str2);
                    }

                    @Override // com.ss.android.token.ITokenService
                    public JSONObject getSettings() {
                        return BDAccountDelegateInner.getSettingsInstance(TTAccountInit.getConfig().getApplicationContext()).getAccountSettingsConfig();
                    }

                    @Override // com.ss.android.token.ITokenService
                    public INetwork getTicketNetwork() {
                        return new TicketGuardNetwork();
                    }
                });
                TTTokenManager.setSessionManager(new TTTokenManager.ISessionManager() { // from class: com.ss.android.account.TTAccountInit.4
                    @Override // com.ss.android.token.TTTokenManager.ISessionManager
                    public void invalidSession(boolean z2) {
                        BDAccountDelegateInner.instance(TTAccountConfig.this.getApplicationContext()).invalidateSession(z2);
                    }

                    @Override // com.ss.android.token.TTTokenManager.ISessionManager
                    public void notifyLogout(String str) {
                        BDAccountEvent bDAccountEvent = new BDAccountEvent(1);
                        bDAccountEvent.logoutScene = BDAccountEvent.getLogoutScene(str);
                        BDAccountDelegateInner.instance(TTAccountConfig.this.getApplicationContext()).notifyBDAccountEvent(bDAccountEvent);
                    }
                });
                TTTokenManager.setLocalTest(sConfig.isLocalTest());
                TTTokenManager.setLogger(new TTTokenManager.ILogger() { // from class: com.ss.android.account.TTAccountInit.5
                    @Override // com.ss.android.token.TTTokenManager.ILogger
                    public void log(int i, String str, String str2) {
                        LogHelper.m36d(str, str2);
                    }
                });
                return;
            }
            throw new RuntimeException("please provide IAccountSec implementation");
        }
        throw new RuntimeException("please provide IBdTruing implementation");
    }

    public static TTAccountConfig getConfig() {
        if (sConfig == null) {
            throw new IllegalStateException("not init TTAccount config");
        }
        return sConfig;
    }

    public static TTAccountConfig getConfigMayNull() {
        return sConfig;
    }

    public static TTAccountExtraConfig getExtraConfig() {
        return sExtraConfig;
    }

    public static void setExtraConfig(TTAccountExtraConfig tTAccountExtraConfig) {
        sExtraConfig = tTAccountExtraConfig;
    }

    @Deprecated
    public static void initProjectMode(IProjectMode iProjectMode) {
        sProjectMode = iProjectMode;
    }

    public static IProjectMode getProjectMode() {
        return sProjectMode;
    }

    private static void doComponentReflection() {
        try {
            Class.forName("com.ss.android.account.token.TTTokenUtils").getMethod("addTokenInterceptor", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doComponentReflectionDelay() {
        try {
            Class.forName("com.ss.android.account.adapter.InternalAccountAdapter").getMethod("init", Context.class).invoke(null, sConfig.getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static IRequestTagHeaderProvider getRequestTagHeaderProvider() {
        return sRequestTagHeaderProvider;
    }

    public static void setRequestTagHeaderProvider(IRequestTagHeaderProvider iRequestTagHeaderProvider) {
        sRequestTagHeaderProvider = iRequestTagHeaderProvider;
        TTTokenManager.setRequestTagHeaderProvider(iRequestTagHeaderProvider);
    }

    public static ILogger getLogger() {
        return sLogger;
    }

    public static void setLogger(ILogger iLogger) {
        sLogger = iLogger;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class CheckTokenHandler extends Handler {
        public static final int MSG_CHECK_TOKEN = 2001;

        public CheckTokenHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2001 || TokenFactory.isHasCallInit()) {
                return;
            }
            if (TTAccountInit.sConfig.isLocalTest()) {
                ShowDialogActivity.showDialog(TTAccountInit.sConfig.getApplicationContext(), "token sdk is not inited!", "please call TTTokenManager.initialize(context, config)!");
            } else {
                AccountMonitorUtil.onNeverCallTokenInit();
            }
        }
    }
}
