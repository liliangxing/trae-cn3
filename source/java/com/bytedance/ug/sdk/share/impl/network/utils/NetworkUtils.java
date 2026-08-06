package com.bytedance.ug.sdk.share.impl.network.utils;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.share.BuildConfig;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.network.constant.ApiConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NetworkUtils {
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";

    public static String addHost(String str) {
        String host = ShareConfigManager.getInstance().getHost();
        if (TextUtils.isEmpty(host)) {
            host = ApiConstants.COMMON_HOST;
        }
        String str2 = host + str;
        return ShareConfigManager.getInstance().isBoe() ? replaceBoeHost(str2) : str2;
    }

    public static String replaceBoeHost(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri parse = Uri.parse(str.trim());
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("http");
            builder.encodedAuthority(parse.getEncodedAuthority() + ".boe-gateway.byted.org");
            builder.encodedPath(parse.getPath());
            builder.encodedQuery(parse.getEncodedQuery());
            return builder.build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String addTestHost(String str) {
        return "http://10.18.60.199:9400" + str;
    }

    public static String addCommonParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        appendCommonParams(sb);
        return sb.toString();
    }

    public static void appendCommonParams(StringBuilder sb) {
        if (sb != null) {
            if (sb.toString().indexOf(63) < 0) {
                sb.append("?");
            } else {
                sb.append(PARAMETER_SEPARATOR);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            putCommonParams(linkedHashMap);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                arrayList.add(new Pair(entry.getKey(), entry.getValue()));
            }
            sb.append(format(arrayList, "UTF-8"));
        }
    }

    public static void putCommonParams(Map<String, String> map) {
        if (map != null) {
            String deviceId = ShareConfigManager.getInstance().getDeviceId();
            if (!TextUtils.isEmpty(deviceId)) {
                map.put("ug_share_did", deviceId);
            }
            String appId = ShareConfigManager.getInstance().getAppId();
            if (!TextUtils.isEmpty(appId)) {
                map.put("ug_share_aid", appId);
                map.put(CommonConstants.KEY_AID, appId);
            }
            String packageName = ShareConfigManager.getInstance().getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                map.put("ug_share_package_name", packageName);
            }
            map.put("ug_share_v_code", String.valueOf(BuildConfig.SHARE_VERSION_CODE));
            map.put("ug_share_v_name", BuildConfig.SHARE_VERSION_NAME);
            map.put("ug_share_os_api", String.valueOf(Build.VERSION.SDK_INT));
            map.put(CommonConstants.KEY_DEVICE_PLATFORM, "android");
            map.put("ug_share_platform", "android");
        }
    }

    public static String format(List<Pair<String, String>> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, String> pair : list) {
            String encode = encode((String) pair.first, str);
            String str2 = (String) pair.second;
            String encode2 = str2 != null ? encode(str2, str) : "";
            if (sb.length() > 0) {
                sb.append(PARAMETER_SEPARATOR);
            }
            sb.append(encode);
            sb.append(NAME_VALUE_SEPARATOR);
            sb.append(encode2);
        }
        return sb.toString();
    }

    private static String encode(String str, String str2) {
        if (str2 == null) {
            str2 = DEFAULT_CONTENT_CHARSET;
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
