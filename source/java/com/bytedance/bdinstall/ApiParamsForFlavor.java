package com.bytedance.bdinstall;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.loader.AliYunUUIDHandler;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.util.SensitiveUtils;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ApiParamsForFlavor {
    /* renamed from: com_bytedance_bdinstall_ApiParamsForFlavor_com_bytedance_bdinstall_oaid_Oaid_getOaidId */
    private static String m138x6abbdb86(Oaid oaid) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(10000008, "com/bytedance/bdinstall/oaid/Oaid", "getOaidId", oaid, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(10000008, "com/bytedance/bdinstall/oaid/Oaid", "getOaidId", oaid, objArr, null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String oaidId = oaid.getOaidId();
        heliosApiHook.postInvoke(10000008, "com/bytedance/bdinstall/oaid/Oaid", "getOaidId", oaid, objArr, oaidId, extraInfo, true);
        return oaidId;
    }

    ApiParamsForFlavor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addSstParams(Context context, Map<String, String> map, boolean z, InstallOptions installOptions) {
        if (installOptions != null && !installOptions.isTouristMode()) {
            String macAddress = SensitiveUtils.getMacAddress(context, installOptions);
            if (!TextUtils.isEmpty(macAddress)) {
                map.put(Api.KEY_MAC_ADDRESS, macAddress);
            }
            String deviceIdWithCache = SensitiveUtils.getDeviceIdWithCache(context, installOptions);
            if (!Utils.isBadId(deviceIdWithCache)) {
                map.put("uuid", deviceIdWithCache);
            }
        }
        String cloudUUID = AliYunUUIDHandler.inst().getCloudUUID();
        if (!TextUtils.isEmpty(cloudUUID)) {
            map.put(Api.KEY_ALIYUN_UUID, cloudUUID);
        }
        if (z) {
            try {
                String m138x6abbdb86 = m138x6abbdb86(Oaid.instance(context));
                if (TextUtils.isEmpty(m138x6abbdb86)) {
                    return;
                }
                map.put(Oaid.KEY_OAID_ID, m138x6abbdb86);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addActiveParams(Context context, InstallOptions installOptions, StringBuilder sb) {
        String[] simSerialNumbers;
        if (!installOptions.isTouristMode()) {
            Api.addParams(sb, "build_serial", SensitiveUtils.getSerialNumber(context, installOptions));
            if (installOptions.reportPhoneDetailInfo() && (simSerialNumbers = SensitiveUtils.getSimSerialNumbers(context, installOptions)) != null && simSerialNumbers.length > 0) {
                String str = simSerialNumbers[0];
                for (int i = 1; i < simSerialNumbers.length; i++) {
                    str = str + "," + simSerialNumbers[i];
                }
                Api.addParams(sb, "sim_serial_number", str);
            }
        }
        m138x6abbdb86(Oaid.instance(context));
    }

    public static void addCommonParams(boolean z, Context context, InstallOptions installOptions) {
        IBDInstallApi bDInstall;
        if (installOptions == null || (bDInstall = BDInstall.getInstance(installOptions.getAidString())) == null) {
            return;
        }
        boolean enablePrefetchAdId = bDInstall.getAdIdConfig().enablePrefetchAdId();
        if (z && enablePrefetchAdId) {
            Oaid.instance(context).init();
        }
    }
}
