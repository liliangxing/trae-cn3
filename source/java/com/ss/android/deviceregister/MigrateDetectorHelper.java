package com.ss.android.deviceregister;

import android.content.Context;
import com.ss.android.deviceregister.base.AppLogConstants;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class MigrateDetectorHelper {
    MigrateDetectorHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clearMigrationInfo(Context context) {
        MigrateDetector migrateDetector = new MigrateDetector(context);
        if (migrateDetector.isMigrate()) {
            GaidGetter.clearSp(context);
            IDeviceRegisterParameter provider = DeviceRegisterParameterFactory.getProvider(context);
            RegistrationHeaderHelper.setOldDeviceId(provider.getDeviceId());
            provider.clear("openudid");
            provider.clear("clientudid");
            provider.clear("serial_number");
            provider.clear("sim_serial_number");
            provider.clear("udid");
            provider.clear(AppLogConstants.KEY_UDID_LIST);
            provider.clear("device_id");
            DeviceRegisterManager.clearDidAndIid(context, "clearMigrationInfo");
        }
        migrateDetector.disableComponent();
    }
}
