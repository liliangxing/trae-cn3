package com.bytedance.common.push.interfaze;

import com.ss.android.ug.bus.IUgBusService;
import com.ss.android.ug.bus.UgCallbackCenter;
import com.ss.android.ug.bus.account.event.OnLoginEvent;
import com.ss.android.ug.bus.account.event.OnLogoutEvent;
import com.ss.android.ug.bus.account.event.OnSwitchEvent;
import java.util.List;

/* loaded from: classes3.dex */
public interface IAccountService extends IUgBusService {
    List<String> getLoginHistoryUids();

    String getSecUid();

    void registerOnAccountSwitchListener(UgCallbackCenter.Callback<OnSwitchEvent> callback);

    void registerOnLoginListener(UgCallbackCenter.Callback<OnLoginEvent> callback);

    void registerOnLogoutListener(UgCallbackCenter.Callback<OnLogoutEvent> callback);
}
