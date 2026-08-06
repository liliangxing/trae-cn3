package com.bytedance.upc.common.account;

import com.bytedance.upc.common.device.IDeviceInfoService;
import com.bytedance.upc.common.log.LogUtils;
import com.bytedance.upc.common.user.UpcUserService;
import com.ss.android.ug.bus.UgCallbackCenter;
import com.ss.android.ug.bus.account.event.OnLoginEvent;
import com.ss.android.ug.bus.account.event.OnLogoutEvent;
import com.ss.android.ug.bus.account.event.OnSwitchEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class UpcAccountManager {
    private static UpcAccountManager mUpcAccountManager = new UpcAccountManager();
    private List<IUpcAccountListener> mUpcAccountListenerList = new ArrayList();
    private UgCallbackCenter.Callback<OnLoginEvent> loginCallback = new UgCallbackCenter.Callback<OnLoginEvent>() { // from class: com.bytedance.upc.common.account.UpcAccountManager.1
        public void onCall(OnLoginEvent onLoginEvent) {
            UpcAccountManager.this.onLoginEvent(onLoginEvent);
        }
    };
    private UgCallbackCenter.Callback<OnLogoutEvent> logoutCallback = new UgCallbackCenter.Callback<OnLogoutEvent>() { // from class: com.bytedance.upc.common.account.UpcAccountManager.2
        public void onCall(OnLogoutEvent onLogoutEvent) {
            UpcAccountManager.this.onLogoutEvent(onLogoutEvent);
        }
    };
    private UgCallbackCenter.Callback<OnSwitchEvent> switchCallback = new UgCallbackCenter.Callback<OnSwitchEvent>() { // from class: com.bytedance.upc.common.account.UpcAccountManager.3
        public void onCall(OnSwitchEvent onSwitchEvent) {
            UpcAccountManager.this.OnAccountSwitch(onSwitchEvent);
        }
    };

    public void init() {
    }

    private UpcAccountManager() {
        UpcUserService.inst().registerOnLoginListener(this.loginCallback);
        UpcUserService.inst().registerOnLogoutListener(this.logoutCallback);
        UpcUserService.inst().registerOnAccountSwitchListener(this.switchCallback);
    }

    public void registerAccountListener(IUpcAccountListener iUpcAccountListener) {
        this.mUpcAccountListenerList.add(iUpcAccountListener);
    }

    public static UpcAccountManager inst() {
        return mUpcAccountManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoginEvent(OnLoginEvent onLoginEvent) {
        onAccountStatusChange();
        for (int i = 0; i < this.mUpcAccountListenerList.size(); i++) {
            this.mUpcAccountListenerList.get(i).onLoginEvent(onLoginEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLogoutEvent(OnLogoutEvent onLogoutEvent) {
        onAccountStatusChange();
        for (int i = 0; i < this.mUpcAccountListenerList.size(); i++) {
            this.mUpcAccountListenerList.get(i).onLogoutEvent(onLogoutEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnAccountSwitch(OnSwitchEvent onSwitchEvent) {
        onAccountStatusChange();
        for (int i = 0; i < this.mUpcAccountListenerList.size(); i++) {
            this.mUpcAccountListenerList.get(i).onChangeEvent(onSwitchEvent);
        }
    }

    private void onAccountStatusChange() {
        String secUid = UpcUserService.inst().getSecUid();
        LogUtils.m9i("account status change , uid = " + secUid);
        ((IDeviceInfoService) ServiceManager.get().getService(IDeviceInfoService.class)).updateDeviceInfo(null, secUid, null);
    }
}
