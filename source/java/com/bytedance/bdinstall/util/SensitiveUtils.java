package com.bytedance.bdinstall.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ISstInfoProvider;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.SstInfoCompat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SensitiveUtils {
    private static final String ID_TYPE_IMEI = "imei";
    private static final String ID_TYPE_MEID = "meid";
    private static final String ID_TYPE_UNKNOWN = "unknown";
    private static final Singleton<String> sDeviceId = new Singleton<String>() { // from class: com.bytedance.bdinstall.util.SensitiveUtils.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.bdinstall.util.Singleton
        public String create(Object... objArr) {
            return SensitiveUtils.getDefaultImeiOrMeid((Context) objArr[0], (InstallOptions) objArr[1]);
        }
    };
    private static final Singleton<String[]> SimSerialNumbers = new Singleton<String[]>() { // from class: com.bytedance.bdinstall.util.SensitiveUtils.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.bdinstall.util.Singleton
        public String[] create(Object... objArr) {
            return SensitiveUtils.getSimSerialNumbersWithCache((Context) objArr[0], (InstallOptions) objArr[1]);
        }
    };
    private static final Singleton<JSONArray> sMultiImei = new Singleton<JSONArray>() { // from class: com.bytedance.bdinstall.util.SensitiveUtils.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.bdinstall.util.Singleton
        public JSONArray create(Object... objArr) {
            return SensitiveUtils.getMultiImeiWithCache((Context) objArr[0], (InstallOptions) objArr[1]);
        }
    };
    private static final Singleton<String> mSerialNumber = new Singleton<String>() { // from class: com.bytedance.bdinstall.util.SensitiveUtils.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.bdinstall.util.Singleton
        public String create(Object... objArr) {
            return SensitiveUtils.getSerialNumberWithCache((Context) objArr[0], (InstallOptions) objArr[1]);
        }
    };
    private static final Singleton<String> sWifiMacAddress = new Singleton<String>() { // from class: com.bytedance.bdinstall.util.SensitiveUtils.5
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.bdinstall.util.Singleton
        public String create(Object... objArr) {
            if (RomUtils.isAndroidQOrHigher() && RomUtils.isTargetQOrHigher((Context) objArr[0])) {
                return "";
            }
            ISstInfoProvider provider = SstInfoCompat.getProvider((String) objArr[1]);
            if (provider != null) {
                return provider.getMac((Context) objArr[0], (InstallOptions) objArr[2]);
            }
            return null;
        }
    };
    private static final Singleton<JSONArray> sIPV6Address = new Singleton<JSONArray>() { // from class: com.bytedance.bdinstall.util.SensitiveUtils.6
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.bdinstall.util.Singleton
        public JSONArray create(Object... objArr) {
            ISstInfoProvider provider = SstInfoCompat.getProvider((String) objArr[1]);
            if (provider != null) {
                return provider.getIPV6Address((Context) objArr[0]);
            }
            return new JSONArray();
        }
    };
    private static final Singleton<String> sMediaID = new Singleton<String>() { // from class: com.bytedance.bdinstall.util.SensitiveUtils.7
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.bdinstall.util.Singleton
        public String create(Object... objArr) {
            InstallOptions installOptions = (InstallOptions) objArr[0];
            return installOptions != null ? installOptions.getSensitiveInterceptor().getMediaId() : "";
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static String getDefaultImeiOrMeid(Context context, InstallOptions installOptions) {
        if (context == null) {
            return null;
        }
        if ((installOptions == null || installOptions.isCheckPermissionBeforeCallSensitiveApi()) && !InstallPmsUtils.checkReadPhoneStatePermission(context)) {
            return null;
        }
        return SstInfoCompat.getProvider(String.valueOf(installOptions.getAid())).getDefaultImeiOrMeid(context, installOptions);
    }

    public static String getDeviceIdWithCache(Context context, InstallOptions installOptions) {
        return sDeviceId.get(context, installOptions);
    }

    public static String[] getSimSerialNumbersWithCache(Context context, InstallOptions installOptions) {
        String[] simSerialNumbers;
        if (context == null || RomUtils.isAndroidROrHigher() || ((installOptions == null || installOptions.isCheckPermissionBeforeCallSensitiveApi()) && !InstallPmsUtils.checkReadPhoneStatePermission(context))) {
            return new String[0];
        }
        ISstInfoProvider provider = SstInfoCompat.getProvider(String.valueOf(installOptions.getAid()));
        return (provider == null || (simSerialNumbers = provider.getSimSerialNumbers(context, installOptions)) == null) ? new String[0] : simSerialNumbers;
    }

    public static String[] getSimSerialNumbers(Context context, InstallOptions installOptions) {
        return SimSerialNumbers.get(context, installOptions);
    }

    public static JSONArray getMultiImei(Context context, InstallOptions installOptions) {
        return sMultiImei.get(context, installOptions);
    }

    public static JSONArray getMultiImeiWithCache(Context context, InstallOptions installOptions) {
        JSONArray jSONArray = new JSONArray();
        if ((installOptions == null || installOptions.isCheckPermissionBeforeCallSensitiveApi()) && !InstallPmsUtils.checkReadPhoneStatePermission(context)) {
            return new JSONArray();
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    ISstInfoProvider provider = SstInfoCompat.getProvider(String.valueOf(installOptions.getAid()));
                    jSONArray.put(createJsonObjForId(provider != null ? provider.getMeid(context, 0, installOptions) : null, 0, ID_TYPE_MEID));
                } catch (Exception e) {
                    if (e instanceof SecurityException) {
                        DrLog.m140e("读取imei没有权限");
                    } else {
                        e.printStackTrace();
                    }
                }
                try {
                    ISstInfoProvider provider2 = SstInfoCompat.getProvider(String.valueOf(installOptions.getAid()));
                    jSONArray.put(createJsonObjForId(provider2 != null ? provider2.getMeid(context, 1, installOptions) : null, 1, ID_TYPE_MEID));
                } catch (Exception e2) {
                    if (e2 instanceof SecurityException) {
                        DrLog.m140e("读取imei没有权限");
                    } else {
                        e2.printStackTrace();
                    }
                }
                try {
                    ISstInfoProvider provider3 = SstInfoCompat.getProvider(String.valueOf(installOptions.getAid()));
                    jSONArray.put(createJsonObjForId(provider3 != null ? provider3.getImei(context, 0, installOptions) : null, 0, ID_TYPE_IMEI));
                } catch (Exception e3) {
                    if (e3 instanceof SecurityException) {
                        DrLog.m140e("读取imei没有权限");
                    } else {
                        e3.printStackTrace();
                    }
                }
                try {
                    ISstInfoProvider provider4 = SstInfoCompat.getProvider(String.valueOf(installOptions.getAid()));
                    jSONArray.put(createJsonObjForId(provider4 != null ? provider4.getImei(context, 1, installOptions) : null, 1, ID_TYPE_IMEI));
                } catch (Exception e4) {
                    if (e4 instanceof SecurityException) {
                        DrLog.m140e("读取imei没有权限");
                    } else {
                        e4.printStackTrace();
                    }
                }
            } else {
                ISstInfoProvider provider5 = SstInfoCompat.getProvider(String.valueOf(installOptions.getAid()));
                jSONArray.put(createJsonObjForId(provider5 == null ? null : provider5.reflectGetDeviceIdWithSlotIndex(context, 0), 0, "unknown"));
                if (provider5 != null) {
                    r9 = provider5.reflectGetDeviceIdWithSlotIndex(context, 1);
                }
                jSONArray.put(createJsonObjForId(r9, 1, "unknown"));
            }
        } catch (Throwable th) {
            if (th instanceof SecurityException) {
                DrLog.m140e("读取imei没有权限");
            } else {
                th.printStackTrace();
            }
        }
        return jSONArray;
    }

    private static JSONObject createJsonObjForId(String str, int i, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("id", str);
            jSONObject.put("slot_index", i);
            jSONObject.put("type", str2);
        }
        return jSONObject;
    }

    public static String getSerialNumberWithCache(Context context, InstallOptions installOptions) {
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 26 || context.getApplicationInfo().targetSdkVersion < 26 || (!(installOptions == null || installOptions.isCheckPermissionBeforeCallSensitiveApi()) || InstallPmsUtils.checkReadPhoneStatePermission(context))) {
            return SstInfoCompat.getProvider(String.valueOf(installOptions.getAid())).getSerial(context, installOptions);
        }
        return null;
    }

    public static String getSerialNumber(Context context, InstallOptions installOptions) {
        if (installOptions.isEnableLoadSN()) {
            return mSerialNumber.get(context, installOptions);
        }
        return null;
    }

    public static String getMacAddress(Context context, InstallOptions installOptions) {
        return sWifiMacAddress.get(context, String.valueOf(installOptions.getAid()), installOptions);
    }

    public static JSONArray getIPV6Address(Context context, InstallOptions installOptions) {
        return sIPV6Address.get(context, String.valueOf(installOptions.getAid()), installOptions);
    }

    public static String getNetworkOperatorName(InstallOptions installOptions) {
        return installOptions.getSensitiveInterceptor().getNetworkOperatorName();
    }

    public static String getNetworkOperator(InstallOptions installOptions) {
        return installOptions.getSensitiveInterceptor().getNetworkOperator();
    }

    public static String getSimCountryIso(InstallOptions installOptions) {
        return installOptions.getSensitiveInterceptor().getSimCountryIso();
    }

    public static String getCountry(InstallOptions installOptions) {
        return installOptions.getSensitiveInterceptor().getCountry();
    }

    public static Pair<String, Boolean> getGoogleAdid(InstallOptions installOptions) {
        return new Pair<>("", false);
    }

    public static String getMediaId(InstallOptions installOptions) {
        return sMediaID.get(installOptions);
    }
}
