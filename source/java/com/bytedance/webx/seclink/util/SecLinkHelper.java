package com.bytedance.webx.seclink.util;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.webx.seclink.SecLinkFacade;
import com.bytedance.webx.seclink.config.AppSecConfig;
import com.bytedance.webx.seclink.request.CheckUrlCallback;
import com.bytedance.webx.seclink.request.CheckUrlResponse;
import com.bytedance.webx.seclink.request.CheckUrlSecManager;
import com.bytedance.webx.seclink.request.CheckUrlTask;
import com.bytedance.webx.seclink.setting.SettingConfig;
import com.bytedance.webx.seclink.setting.SettingManager;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SecLinkHelper {
    private static final String TAG = "SecLinkHelper";

    @Deprecated
    public static String buildSecLink(String str, String str2) {
        return buildSecLink(str, str2, "");
    }

    public static String buildSecLink(String str, String str2, String str3) {
        return buildSecLinkMiddlePage(str, "", str2, null, -1, str3);
    }

    public static String buildSecLink(String str, String str2, String str3, String str4) {
        return buildSecLinkMiddlePage(str, str2, str3, null, -1, str4);
    }

    @Deprecated
    public static String buildSecLink(String str, String str2, Map<String, Object> map) {
        return buildSecLinkMiddlePage(str, str2, map, -1, "");
    }

    public static String buildSecLink(String str, String str2, Map<String, Object> map, String str3) {
        return buildSecLinkMiddlePage(str, str2, map, -1, str3);
    }

    public static String buildSecLink(String str, String str2, String str3, Map<String, Object> map, String str4) {
        return buildSecLinkMiddlePage(str, str2, str3, map, -1, str4);
    }

    public static String buildSecLinkMiddlePage(String str, String str2, Map<String, Object> map, int i, String str3) {
        return buildSecLinkMiddlePage(str, "", str2, map, i, str3);
    }

    public static String buildSecLinkMiddlePage(String str, String str2, String str3, Map<String, Object> map, int i, String str4) {
        AppSecConfig linkConfig = SecLinkFacade.getLinkConfig();
        if (TextUtils.isEmpty(str2)) {
            str2 = linkConfig != null ? linkConfig.getAid() : "";
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || startWithSecHost(str)) {
            return str;
        }
        String localHost = getLocalHost();
        if (isValid(str, str3)) {
            StringBuilder sb = new StringBuilder();
            sb.append(localHost);
            if (i > 0) {
                sb.append("/middle-page");
            }
            Map<String, String> commonQueryParam = UrlBuilder.getCommonQueryParam();
            commonQueryParam.put("aid", str2);
            commonQueryParam.put("lang", linkConfig != null ? linkConfig.getLang() : "zh");
            commonQueryParam.put(ReportUtil.Params.SCENE, str3);
            commonQueryParam.put("jumper_version", "1");
            commonQueryParam.put("target", URLEncoder.encode(str));
            commonQueryParam.put("sec_link_biz_tag", !TextUtils.isEmpty(str4) ? str4 : SystemUtils.UNKNOWN);
            if (i > 0) {
                commonQueryParam.put("type", i + "");
            }
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && entry.getValue() != null && !commonQueryParam.containsKey(entry.getKey())) {
                        commonQueryParam.put(URLEncoder.encode(entry.getKey()), URLEncoder.encode(entry.getValue().toString()));
                    }
                }
            }
            sb.append("?");
            Iterator<String> it = commonQueryParam.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                sb.append(next).append(ContainerUtils.KEY_VALUE_DELIMITER).append(commonQueryParam.get(next));
                if (it.hasNext()) {
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                }
            }
            String sb2 = sb.toString();
            ReportUtil.buildMiddlePage(true, localHost, str, str3, str4, sb2);
            return sb2;
        }
        ReportUtil.buildMiddlePage(false, localHost, str, str3, str4, str);
        return str;
    }

    public static String getLocalHost() {
        return SettingManager.getInstance().getVerifyHost();
    }

    public static boolean startWithSecHost(String str) {
        if (!isStringStartsWithIgnoreCase(str, "https://")) {
            Log.m48d(TAG, "startWithSecHost : target url should start with https");
            return false;
        }
        String host = Uri.parse(getLocalHost()).getHost();
        String host2 = Uri.parse(str).getHost();
        if (host2 == null) {
            Log.m48d(TAG, "startWithSecHost : target url is invalid");
            return false;
        }
        return host2.equalsIgnoreCase(host);
    }

    public static boolean isValid(String str, String str2) {
        if (!TextUtils.isEmpty(str) && SettingManager.isSafeCheckEnable(str2)) {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (TextUtils.isEmpty(scheme)) {
                return true;
            }
            Set<String> schemeSet = SettingManager.getInstance().getSchemeSet(str2);
            if (schemeSet != null) {
                if (schemeSet.contains(SettingConfig.SPECIAL_SCHEME)) {
                    if (!TextUtils.isEmpty(parse.getHost())) {
                        return !startWithSecHost(str);
                    }
                } else if (schemeSet.contains(scheme.toLowerCase())) {
                    return !startWithSecHost(str);
                }
            }
            List<String> verifySchemeList = SecLinkFacade.getLinkConfig() != null ? SecLinkFacade.getLinkConfig().getVerifySchemeList() : null;
            if (verifySchemeList != null && verifySchemeList.contains(scheme.toLowerCase())) {
                return !startWithSecHost(str);
            }
        }
        return false;
    }

    public static boolean isStringStartsWithIgnoreCase(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str.toLowerCase().startsWith(str2.toLowerCase());
    }

    public static boolean isEqual(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (!str2.equals(str) && !str2.equals(new StringBuilder().append(str).append("/").toString()))) ? false : true;
    }

    @Deprecated
    public static void checkUrlSafely(String str, String str2, int i, CheckUrlCallback checkUrlCallback) {
        checkUrlSafely(str, "", str2, i, null, "", checkUrlCallback, false);
    }

    public static void checkUrlSafely(String str, String str2, int i, String str3, CheckUrlCallback checkUrlCallback) {
        checkUrlSafely(str, "", str2, i, null, str3, checkUrlCallback, false);
    }

    @Deprecated
    public static void checkUrlSafely(String str, String str2, int i, Map<String, Object> map, CheckUrlCallback checkUrlCallback) {
        checkUrlSafely(str, "", str2, i, map, "", checkUrlCallback, false);
    }

    public static void checkUrlSafely(String str, String str2, int i, Map<String, Object> map, String str3, CheckUrlCallback checkUrlCallback) {
        checkUrlSafely(str, "", str2, i, map, str3, checkUrlCallback, false);
    }

    public static void checkUrlSafely(String str, String str2, String str3, int i, Map<String, Object> map, String str4, CheckUrlCallback checkUrlCallback, boolean z) {
        AppSecConfig linkConfig = SecLinkFacade.getLinkConfig();
        if (TextUtils.isEmpty(str2)) {
            str2 = linkConfig != null ? linkConfig.getAid() : "";
        }
        CheckUrlSecManager.getInstance().check(new CheckUrlTask.Builder().setAid(str2).setLanguage(linkConfig != null ? linkConfig.getLang() : "").setTarget(str).setScene(str3).setCallback(checkUrlCallback).useBizConfig(z).setGrade(i).extraInfo(map).bizTag(str4).build());
    }

    @Deprecated
    public static Future<CheckUrlResponse> checkUrlSafely(String str, String str2, int i, boolean z) {
        return checkUrlSafely(str, str2, i, (Map<String, Object>) null, z);
    }

    public static Future<CheckUrlResponse> checkUrlSafely(String str, String str2, int i, boolean z, String str3) {
        return checkUrlSafely(str, "", str2, i, null, z, str3);
    }

    @Deprecated
    public static Future<CheckUrlResponse> checkUrlSafely(String str, String str2, int i, Map<String, Object> map, boolean z) {
        return checkUrlSafely(str, str2, i, map, z, (String) null);
    }

    public static Future<CheckUrlResponse> checkUrlSafely(String str, String str2, int i, Map<String, Object> map, boolean z, String str3) {
        return checkUrlSafely(str, "", str2, i, map, z, str3);
    }

    public static Future<CheckUrlResponse> checkUrlSafely(String str, String str2, String str3, int i, Map<String, Object> map, boolean z, String str4) {
        AppSecConfig linkConfig = SecLinkFacade.getLinkConfig();
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
            String aid = linkConfig != null ? linkConfig.getAid() : "";
            if (!TextUtils.isEmpty(aid)) {
                str2 = aid;
            }
        }
        return CheckUrlSecManager.getInstance().syncCheck(new CheckUrlTask.Builder().setAid(str2).setLanguage(linkConfig != null ? linkConfig.getLang() : "zh").setTarget(str).setScene(str3).setGrade(i).extraInfo(map).useBizConfig(z).bizTag(str4).build());
    }
}
