package com.bytedance.bdinstall.storage;

import android.content.Context;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CommonDeviceParamProviderCreator {
    public static final String FILE_NAME = "device_parameters";
    private static final String I18N_FILE_NAME = "dp";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StorageSettings createSettings(Context context, Env env, InstallOptions installOptions) {
        String wrapEnvSuffix;
        if (env.isI18n()) {
            wrapEnvSuffix = LocalConstants.wrapEnvSuffix(I18N_FILE_NAME, env);
        } else {
            wrapEnvSuffix = LocalConstants.wrapEnvSuffix(installOptions.isMainInstance() ? FILE_NAME : "device_parameters_" + installOptions.getAid(), env);
        }
        if (installOptions.isLocalTest()) {
            wrapEnvSuffix = wrapEnvSuffix + "_local";
        }
        StorageSettings storageSettings = new StorageSettings();
        storageSettings.setFileName(wrapEnvSuffix + ".dat");
        storageSettings.setSp(env.getEnvIsolateSp(installOptions));
        storageSettings.setAnonymous(installOptions.isAnonymous());
        storageSettings.setLocalTest(installOptions.isLocalTest());
        storageSettings.setAccount(installOptions.getAccount(), LocalConstants.wrapEnvSuffix("", env));
        storageSettings.setNeedSharedStorage(installOptions.isNeedSharedStorage());
        storageSettings.setOptions(installOptions);
        return storageSettings;
    }
}
