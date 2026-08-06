package com.bytedance.bdinstall.storage;

import android.content.Context;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DeviceParamProviderCreator extends CommonDeviceParamProviderCreator {
    public static void registerInstallParameterProvider(Context context, Env env, InstallOptions installOptions) {
        IInstallParameters deviceParamsProvider;
        StorageSettings createSettings = createSettings(context, env, installOptions);
        if (env.isI18n()) {
            deviceParamsProvider = new DeviceParamsProvider(context, createSettings);
        } else {
            deviceParamsProvider = new CNDeviceParamsProvider(context, createSettings);
        }
        INewUserModeService iNewUserModeService = (INewUserModeService) ServiceManager.getService(INewUserModeService.class, installOptions.getAidString());
        if (iNewUserModeService != null) {
            deviceParamsProvider = (IInstallParameters) iNewUserModeService.tryReplaceService(IInstallParameters.class, deviceParamsProvider);
        }
        ServiceManager.registerService(IInstallParameters.class, deviceParamsProvider, installOptions.getAidString());
    }
}
