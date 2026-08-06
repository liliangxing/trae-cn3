package com.ss.android.deviceregister;

import android.accounts.Account;
import android.content.Context;
import com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter;
import java.util.Map;

/* loaded from: classes7.dex */
public interface INewUserModeManager {
    INewUserModeManager addCustomParam(String str, String str2);

    void clearCache();

    void done();

    String getCustomParam(String str, String str2);

    IDeviceRegisterParameter getDeviceParamsProvider();

    boolean isAutoMode();

    boolean isNewUserMode();

    void mapCustomParams(Map<String, String> map);

    INewUserModeManager newUserMode(Context context);

    void setAccount(Account account);

    INewUserModeManager setAutoNewUserMode(boolean z);

    INewUserModeManager setNewUserMode(boolean z);
}
