package com.bytedance.upc.common.storage;

import com.bytedance.upc.BuildConfig;
import kotlin.Metadata;

/* compiled from: SpDeviceInfoStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/upc/common/storage/SpDeviceInfoStorage;", "", "()V", "KEY_UPC_DEVICE_INFO", "", "getDeviceInfo", "updateDeviceInfo", "", "value", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes6.dex */
public final class SpDeviceInfoStorage {
    public static final SpDeviceInfoStorage INSTANCE = new SpDeviceInfoStorage();
    private static final String KEY_UPC_DEVICE_INFO = "upc_device_info";

    private SpDeviceInfoStorage() {
    }

    public final void updateDeviceInfo(String value) {
        SpStorage spStorage = SpStorage.INSTANCE;
        if (value == null) {
            value = "";
        }
        spStorage.setString(SpStorage.STORAGE_SETTINGS, KEY_UPC_DEVICE_INFO, value);
    }

    public final String getDeviceInfo() {
        return SpStorage.INSTANCE.getString(SpStorage.STORAGE_SETTINGS, KEY_UPC_DEVICE_INFO, null);
    }
}
