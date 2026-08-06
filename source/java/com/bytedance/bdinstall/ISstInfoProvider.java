package com.bytedance.bdinstall;

import android.content.Context;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface ISstInfoProvider {
    String getDefaultImeiOrMeid(Context context, InstallOptions installOptions);

    JSONArray getIPV6Address(Context context);

    String getImei(Context context, int i, InstallOptions installOptions);

    String getMac(Context context, InstallOptions installOptions);

    String getMeid(Context context, int i, InstallOptions installOptions);

    String getSerial(Context context, InstallOptions installOptions);

    String[] getSimSerialNumbers(Context context, InstallOptions installOptions);

    String reflectGetDeviceIdWithSlotIndex(Context context, int i);
}
