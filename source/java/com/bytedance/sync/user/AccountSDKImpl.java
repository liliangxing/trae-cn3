package com.bytedance.sync.user;

import com.bytedance.sync.interfaze.IAccountService;
import com.ss.android.ug.bus.UgBusFramework;
import com.ss.android.ug.bus.UgCallbackCenter;
import com.ss.android.ug.bus.account.event.OnLoginEvent;
import com.ss.android.ug.bus.account.event.OnLogoutEvent;
import com.ss.android.ug.bus.account.event.OnSwitchEvent;

/* loaded from: classes5.dex */
public class AccountSDKImpl implements IAccountService {
    @Override // com.bytedance.sync.interfaze.IAccountService
    public void registerOnLoginListener(UgCallbackCenter.Callback<OnLoginEvent> callback) {
        UgCallbackCenter.register(callback);
    }

    @Override // com.bytedance.sync.interfaze.IAccountService
    public void registerOnLogoutListener(UgCallbackCenter.Callback<OnLogoutEvent> callback) {
        UgCallbackCenter.register(callback);
    }

    @Override // com.bytedance.sync.interfaze.IAccountService
    public void registerOnAccountSwitchListener(UgCallbackCenter.Callback<OnSwitchEvent> callback) {
        UgCallbackCenter.register(callback);
    }

    @Override // com.bytedance.sync.interfaze.IAccountService
    public String getSecUid() {
        com.ss.android.ug.bus.account.IAccountService iAccountService = (com.ss.android.ug.bus.account.IAccountService) UgBusFramework.getService(com.ss.android.ug.bus.account.IAccountService.class);
        if (iAccountService == null) {
            return null;
        }
        return iAccountService.getSecUid();
    }
}
