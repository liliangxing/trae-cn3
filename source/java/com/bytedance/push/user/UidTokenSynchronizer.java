package com.bytedance.push.user;

import android.text.TextUtils;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.IAccountService;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.interfaze.IAccountEventApi;
import com.bytedance.push.interfaze.ISupport;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.task.SyncUidAndTokenTask;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.pushmanager.setting.PushSetting;
import com.ss.android.ug.bus.UgCallbackCenter;
import com.ss.android.ug.bus.account.event.OnLoginEvent;
import com.ss.android.ug.bus.account.event.OnLogoutEvent;
import com.ss.android.ug.bus.account.event.OnSwitchEvent;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UidTokenSynchronizer implements IAccountEventApi {
    public static final String TAG = "UidSync";
    private static volatile UidTokenSynchronizer uidTokenSynchronizer;
    private IAccountService mAccountSynchronizer;
    private volatile String mLastSyncAccountSwitchUid;
    private ISupport mSupport;
    private String mPushSdkUid = null;
    private final AtomicBoolean mInitEd = new AtomicBoolean(false);

    public static UidTokenSynchronizer getUidTokenSynchronizer() {
        if (uidTokenSynchronizer == null) {
            synchronized (UidTokenSynchronizer.class) {
                if (uidTokenSynchronizer == null) {
                    uidTokenSynchronizer = new UidTokenSynchronizer();
                }
            }
        }
        return uidTokenSynchronizer;
    }

    public void observerUidChangeEvent(ISupport iSupport, IAccountService iAccountService) {
        Logger.m274i(TAG, "[observerUidChangeEvent]");
        if (!this.mInitEd.compareAndSet(false, true)) {
            Logger.m274i(TAG, "[observerUidChangeEvent]do nothing because repeat invoke");
            return;
        }
        this.mSupport = iSupport;
        this.mAccountSynchronizer = iAccountService;
        this.mPushSdkUid = iAccountService.getSecUid();
        this.mAccountSynchronizer.registerOnAccountSwitchListener(new UgCallbackCenter.Callback<OnSwitchEvent>() { // from class: com.bytedance.push.user.UidTokenSynchronizer.1
            public void onCall(OnSwitchEvent onSwitchEvent) {
                UidTokenSynchronizer.this.onAccountSwitch(onSwitchEvent.secUid);
            }
        });
        this.mAccountSynchronizer.registerOnLoginListener(new UgCallbackCenter.Callback<OnLoginEvent>() { // from class: com.bytedance.push.user.UidTokenSynchronizer.2
            public void onCall(OnLoginEvent onLoginEvent) {
                UidTokenSynchronizer.this.onLogin(onLoginEvent.secUid);
            }
        });
        this.mAccountSynchronizer.registerOnLogoutListener(new UgCallbackCenter.Callback<OnLogoutEvent>() { // from class: com.bytedance.push.user.UidTokenSynchronizer.3
            public void onCall(OnLogoutEvent onLogoutEvent) {
                UidTokenSynchronizer.this.onLogout();
            }
        });
    }

    @Override // com.bytedance.push.interfaze.IAccountEventApi
    public void onLogin(String str) {
        this.mSupport.getLogger().mo250i(TAG, "onLogin " + str);
        this.mPushSdkUid = str;
        syncToken(SyncUidAndTokenTask.ACTION_PASSPORT_LOGIN);
    }

    @Override // com.bytedance.push.interfaze.IAccountEventApi
    public void onLogout() {
        this.mSupport.getLogger().mo250i(TAG, "onLogout");
        this.mPushSdkUid = "";
        syncToken(SyncUidAndTokenTask.ACTION_PASSPORT_LOGOUT);
    }

    @Override // com.bytedance.push.interfaze.IAccountEventApi
    public void onAccountSwitch(final String str) {
        if (this.mSupport == null) {
            this.mSupport = PushSupporter.get();
        }
        if (TextUtils.equals(str, this.mPushSdkUid)) {
            this.mSupport.getLogger().mo250i(TAG, "[onAccountSwitch]secUid is equals last login uid,do noting,secUid:" + str);
            return;
        }
        boolean optUidChangeByHostInvoke = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.optUidChangeByHostInvoke();
        this.mSupport.getLogger().mo250i(TAG, "[onAccountSwitch]optUidChangeByHostInvoke:" + optUidChangeByHostInvoke + " secUid:" + str);
        this.mPushSdkUid = str;
        if (optUidChangeByHostInvoke) {
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.user.UidTokenSynchronizer.4
                @Override // java.lang.Runnable
                public void run() {
                    UidTokenSynchronizer.this.onAccountSwitchV2(str);
                }
            });
        } else {
            syncToken(SyncUidAndTokenTask.ACTION_PASSPORT_SWITCH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onAccountSwitchV2(String str) {
        this.mSupport.getLogger().mo250i(TAG, "[onAccountSwitchV2]");
        if (!TextUtils.equals(this.mLastSyncAccountSwitchUid, str)) {
            this.mSupport.getLogger().mo250i(TAG, "[onAccountSwitchV2]find uid changed,upload token now");
            this.mLastSyncAccountSwitchUid = str;
            syncToken(SyncUidAndTokenTask.ACTION_PASSPORT_SWITCH);
        } else {
            this.mSupport.getLogger().mo250i(TAG, "[onAccountSwitchV2]uid not changed,do nothing");
        }
    }

    private void syncToken(String str) {
        ThreadPlus.submitRunnable(new SyncUidAndTokenTask(this.mSupport, str));
    }

    public void checkUidUpdate(final ISupport iSupport, final IAccountService iAccountService) {
        boolean enableBackUpTokenRefresh = PushSetting.getInstance().getPushOnLineSettings().enableBackUpTokenRefresh();
        Logger.m274i(TAG, "[checkUidUpdate]enableBackUpTokenRefresh:" + enableBackUpTokenRefresh);
        if (enableBackUpTokenRefresh) {
            Logger.m274i(TAG, "[checkUidUpdate]check uid change after 3000ms");
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.user.UidTokenSynchronizer.5
                @Override // java.lang.Runnable
                public void run() {
                    IAccountService iAccountService2 = iAccountService;
                    if (iAccountService2 == null || iSupport == null) {
                        return;
                    }
                    String secUid = iAccountService2.getSecUid();
                    if (UidTokenSynchronizer.this.mPushSdkUid == null || !TextUtils.equals(secUid, UidTokenSynchronizer.this.mPushSdkUid)) {
                        UidTokenSynchronizer.this.mPushSdkUid = secUid;
                        String lastSecUid = ((LocalSettings) SettingsManager.obtain(AppProvider.getApp(), LocalSettings.class)).getLastSecUid();
                        Logger.m274i(UidTokenSynchronizer.TAG, "repeat start,last_sec_uid=" + lastSecUid);
                        Logger.m274i(UidTokenSynchronizer.TAG, "repeat start,cur secUid=" + secUid);
                        if (!TextUtils.equals(LocalSettings.INIT_SEC_UID, lastSecUid)) {
                            if (TextUtils.equals(secUid, lastSecUid)) {
                                return;
                            }
                            Logger.m274i(UidTokenSynchronizer.TAG, "find curUid update,force update token " + secUid);
                            ThreadPlus.submitRunnable(new SyncUidAndTokenTask(iSupport, SyncUidAndTokenTask.ACTION_PASSPORT_REFRESH));
                            return;
                        }
                        Logger.m274i(UidTokenSynchronizer.TAG, "last sec_uid is INIT_SEC_UID,do nothing");
                        return;
                    }
                    Logger.m274i(UidTokenSynchronizer.TAG, "sdk has sync curUid,do nothing");
                }
            }, OnlineTracing.DATA_TIMEOUT);
        } else {
            Logger.m274i(TAG, "[checkUidUpdate]do nothing because enableBackUpTokenRefresh is false");
        }
    }
}
