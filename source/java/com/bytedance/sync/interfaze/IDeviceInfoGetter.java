package com.bytedance.sync.interfaze;

import com.bytedance.sync.user.AccountEventSynchronizer;
import com.ss.android.ug.bus.IUgBusService;
import com.ss.android.ug.bus.UgCallbackCenter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IDeviceInfoGetter extends IUgBusService {
    void addAccountLoginOrSwitchEventListener(UgCallbackCenter.Callback<Void> callback);

    void addDeviceInfoChangedListener(UgCallbackCenter.Callback<Void> callback);

    AccountEventSynchronizer.DeviceInfo getDeviceInfo();

    void removeAccountLoginOrSwitchEventListener(UgCallbackCenter.Callback<Void> callback);

    void startListenAccountChangeEvent();

    void updateDid(String str);
}
