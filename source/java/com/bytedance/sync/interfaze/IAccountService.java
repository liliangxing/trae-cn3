package com.bytedance.sync.interfaze;

import com.ss.android.ug.bus.UgCallbackCenter;
import com.ss.android.ug.bus.account.event.OnLoginEvent;
import com.ss.android.ug.bus.account.event.OnLogoutEvent;
import com.ss.android.ug.bus.account.event.OnSwitchEvent;

/* loaded from: classes5.dex */
public interface IAccountService {
    String getSecUid();

    void registerOnAccountSwitchListener(UgCallbackCenter.Callback<OnSwitchEvent> callback);

    void registerOnLoginListener(UgCallbackCenter.Callback<OnLoginEvent> callback);

    void registerOnLogoutListener(UgCallbackCenter.Callback<OnLogoutEvent> callback);
}
