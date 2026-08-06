package com.bytedance.ttnet.utils;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ttnet.TTNetInit;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MultiProcessFileUtils {
    public static final String KEY_DNS = "dns";
    public static final String KEY_FRONTIER_URLS = "frontier_urls";
    public static final String KEY_HTTPS_DNS = "https_dns";
    public static final String KEY_IS_FULL_CONFIG = "is_full_config";
    public static final String KEY_SSIDS = "ssids";
    public static final String KEY_TNC_ABTEST = "tnc_abtest";
    public static final String KEY_TNC_CONFIG = "tnc_config";
    public static final String KEY_TNC_ETAG = "tnc_etag";
    private static final String TAG = "MultiProcessFileUtils";
    public static final int TYPE_DNS = 2;
    public static final int TYPE_HTTPS_DNS = 3;
    public static final int TYPE_SSIDS = 1;
    public static final int TYPE_TNC_ABTEST = 6;
    public static final int TYPE_TNC_CONFIG = 4;
    public static final int TYPE_TNC_ETAG = 5;
    public static final int TYPE_TNC_FULL_CONFIG_FLAG = 7;

    public static void saveData(Context context, int i, String str) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            switch (i) {
                case 1:
                    linkedHashMap.put(KEY_SSIDS, str);
                    break;
                case 2:
                    linkedHashMap.put(KEY_DNS, str);
                    break;
                case 3:
                    linkedHashMap.put(KEY_HTTPS_DNS, str);
                    break;
                case 4:
                    linkedHashMap.put(KEY_TNC_CONFIG, str);
                    break;
                case 5:
                    linkedHashMap.put(KEY_TNC_ETAG, str);
                    break;
                case 6:
                    linkedHashMap.put(KEY_TNC_ABTEST, str);
                    break;
                case 7:
                    linkedHashMap.put("is_full_config", str);
                    break;
            }
            if (Logger.debug()) {
                Logger.d("PushService", "saveData = " + str);
            }
            TTNetInit.getTTNetDepend().saveMapToProvider(context, linkedHashMap);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057 A[ExcHandler: Exception -> 0x0057] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getData(Context context, int i) {
        String str;
        switch (i) {
            case 1:
                str = TTNetInit.getTTNetDepend().getProviderString(context, KEY_SSIDS, "");
                break;
            case 2:
                str = TTNetInit.getTTNetDepend().getProviderString(context, KEY_DNS, "");
                break;
            case 3:
                str = TTNetInit.getTTNetDepend().getProviderString(context, KEY_HTTPS_DNS, "");
                break;
            case 4:
                str = TTNetInit.getTTNetDepend().getProviderString(context, KEY_TNC_CONFIG, "");
                break;
            case 5:
                str = TTNetInit.getTTNetDepend().getProviderString(context, KEY_TNC_ETAG, "");
                break;
            case 6:
                str = TTNetInit.getTTNetDepend().getProviderString(context, KEY_TNC_ABTEST, "");
                break;
            case 7:
                str = TTNetInit.getTTNetDepend().getProviderString(context, "is_full_config", "");
                break;
            default:
                str = "";
                return !(str instanceof String) ? String.valueOf(str) : "";
        }
        if (!(str instanceof String)) {
        }
    }

    public static void saveSSIDs(Context context, Map<String, String> map) {
        if (context == null || map == null) {
            return;
        }
        if (Logger.debug()) {
            Logger.d("PushService", "saveSSIDs start");
        }
        try {
            saveData(context, 1, StringUtils.mapToString(map));
        } catch (Exception unused) {
        }
    }

    public static void getSSIDs(Context context, Map<String, String> map) {
        if (context == null || map == null) {
            return;
        }
        if (Logger.debug()) {
            Logger.d("PushService", "getSSIDs start");
        }
        try {
            String data = getData(context, 1);
            if (StringUtils.isEmpty(data)) {
                return;
            }
            StringUtils.stringToMap(data, map);
        } catch (Exception unused) {
        }
    }

    public static String bool2Str(boolean z) {
        return Boolean.valueOf(z).toString();
    }

    public static boolean str2Bool(String str) {
        return Boolean.parseBoolean(str);
    }
}
