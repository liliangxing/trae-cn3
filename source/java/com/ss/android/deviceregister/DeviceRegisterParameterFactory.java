package com.ss.android.deviceregister;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter;
import com.ss.android.deviceregister.service.ServiceManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DeviceRegisterParameterFactory {
    public static final String CLASS_NAME_NEW_USER_MODE = "com.ss.android.deviceregister.newuser.DeviceParamsProvider";
    private static final String KEY_NEW_USER_MODER = "new_user";
    private static final String TAG = "DRParameterFactory";
    private static AccountManager mAccountManager;
    private static Account sAccount;
    private static String sChannel;
    private static Account sDeviceAccount;
    private static IDeviceRegisterParameter sDeviceRegisterParameterProvider;

    public static IDeviceRegisterParameter getProvider(Context context) throws IllegalArgumentException {
        if (!DeviceRegisterManager.hasInit()) {
            throw new IllegalStateException("please init TeaAgent first");
        }
        if (sDeviceRegisterParameterProvider == null) {
            synchronized (DeviceRegisterParameterFactory.class) {
                if (sDeviceRegisterParameterProvider == null) {
                    if (context == null) {
                        throw new IllegalArgumentException("context == null");
                    }
                    if (isNewUserMode(context)) {
                        try {
                            INewUserModeManager iNewUserModeManager = (INewUserModeManager) ServiceManager.getService(INewUserModeManager.class);
                            if (iNewUserModeManager.isAutoMode()) {
                                iNewUserModeManager.clearCache();
                            }
                            sDeviceRegisterParameterProvider = iNewUserModeManager.getDeviceParamsProvider();
                            TLog.m73d("DRParameterFactory create new user device param provider & NewUserModeManager success");
                        } catch (Exception unused) {
                            TLog.m81w("DRParameterFactoryclass com.ss.android.deviceregister.newuser.NewUserModeManager not fount");
                        }
                    }
                    if (sDeviceRegisterParameterProvider == null) {
                        DeviceParamsProvider deviceParamsProvider = new DeviceParamsProvider(context, DeviceRegisterManager.isLocalTest());
                        sDeviceRegisterParameterProvider = deviceParamsProvider;
                        Account account = sDeviceAccount;
                        if (account != null) {
                            DeviceParamsProvider deviceParamsProvider2 = deviceParamsProvider;
                            deviceParamsProvider.setAccount(account);
                        }
                    }
                }
            }
        }
        return sDeviceRegisterParameterProvider;
    }

    public static void setNewUserMode(Context context, boolean z) {
        INewUserModeManager iNewUserModeManager;
        if (context != null) {
            if ((isDebugChannel() || DeviceRegisterManager.isForceOpenNewUserMode()) && (iNewUserModeManager = (INewUserModeManager) ServiceManager.getService(INewUserModeManager.class)) != null) {
                iNewUserModeManager.setNewUserMode(z);
            }
        }
    }

    public static boolean isNewUserMode(Context context) {
        if (context == null || (!isDebugChannel() && !DeviceRegisterManager.isForceOpenNewUserMode())) {
            TLog.m73d("DRParameterFactory #isNewUserMode false. context=" + context + " isDebugChannel()=" + isDebugChannel());
            return false;
        }
        INewUserModeManager iNewUserModeManager = (INewUserModeManager) ServiceManager.getService(INewUserModeManager.class);
        if (iNewUserModeManager != null) {
            return iNewUserModeManager.isNewUserMode();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isDebugChannel() {
        if (TextUtils.isEmpty(sChannel)) {
            sChannel = RegistrationHeaderHelper.getChannel();
        }
        return "local_test".equals(sChannel);
    }

    public static void setAccount(Context context, Account account) {
        IDeviceRegisterParameter iDeviceRegisterParameter = sDeviceRegisterParameterProvider;
        if (iDeviceRegisterParameter instanceof DeviceParamsProvider) {
            ((DeviceParamsProvider) iDeviceRegisterParameter).setAccount(account);
        } else {
            sDeviceAccount = account;
        }
        INewUserModeManager iNewUserModeManager = (INewUserModeManager) ServiceManager.getService(INewUserModeManager.class);
        if (iNewUserModeManager != null) {
            iNewUserModeManager.setAccount(account);
        }
    }
}
