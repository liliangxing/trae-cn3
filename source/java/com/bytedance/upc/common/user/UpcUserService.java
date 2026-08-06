package com.bytedance.upc.common.user;

import com.ss.android.ug.bus.UgBusFramework;
import com.ss.android.ug.bus.UgCallbackCenter;
import com.ss.android.ug.bus.account.IAccountService;
import com.ss.android.ug.bus.account.event.OnLoginEvent;
import com.ss.android.ug.bus.account.event.OnLogoutEvent;
import com.ss.android.ug.bus.account.event.OnSwitchEvent;

/* loaded from: classes6.dex */
public class UpcUserService implements IUpcUserService {
    private static UpcUserService mUpcUserService = new UpcUserService();

    @Override // com.bytedance.upc.common.user.IUpcUserService
    public void registerOnLoginListener(UgCallbackCenter.Callback<OnLoginEvent> callback) {
        UgCallbackCenter.register(callback);
    }

    @Override // com.bytedance.upc.common.user.IUpcUserService
    public void registerOnLogoutListener(UgCallbackCenter.Callback<OnLogoutEvent> callback) {
        UgCallbackCenter.register(callback);
    }

    @Override // com.bytedance.upc.common.user.IUpcUserService
    public void registerOnAccountSwitchListener(UgCallbackCenter.Callback<OnSwitchEvent> callback) {
        UgCallbackCenter.register(callback);
    }

    @Override // com.bytedance.upc.common.user.IUpcUserService
    public String getSecUid() {
        IAccountService iAccountService = (IAccountService) UgBusFramework.getService(IAccountService.class);
        if (iAccountService == null) {
            return null;
        }
        return iAccountService.getSecUid();
    }

    public static UpcUserService inst() {
        return mUpcUserService;
    }
}
