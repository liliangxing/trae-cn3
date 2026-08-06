package com.bytedance.bdinstall.storage;

import android.content.Context;
import java.util.Arrays;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DeviceParamsProvider extends AbsDeviceParamsProvider {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceParamsProvider(Context context, StorageSettings storageSettings) {
        super(context, storageSettings);
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public void clearAll() {
        this.mCache.clear(Arrays.asList("openudid", "clientudid", "device_id", "install_id"));
    }
}
