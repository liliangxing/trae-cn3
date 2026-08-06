package com.bytedance.webx.seclink.util;

import android.text.TextUtils;
import com.bytedance.webx.seclink.BuildConfig;
import com.bytedance.webx.seclink.SecLinkFacade;
import com.bytedance.webx.seclink.config.AppSecConfig;
import com.bytedance.webx.seclink.setting.SettingManager;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class UrlBuilder {
    private UrlBuilder() {
    }

    public static String addCommonParam(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (!str.endsWith("?")) {
            sb.append("?");
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            String str2 = map.get(next);
            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str2)) {
                sb.append(next).append(ContainerUtils.KEY_VALUE_DELIMITER).append(str2);
                if (it.hasNext()) {
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                }
            }
        }
        return sb.toString();
    }

    public static Map<String, String> getCommonQueryParam() {
        AppSecConfig linkConfig = SecLinkFacade.getLinkConfig();
        HashMap hashMap = new HashMap();
        hashMap.put("device_platform", "android");
        hashMap.put("os_name", "android");
        hashMap.put("seclink_version", BuildConfig.VERSION_NAME);
        hashMap.put("seclink_settings_version", SettingManager.getInstance().getSettingVersion());
        if (linkConfig == null) {
            return hashMap;
        }
        hashMap.put("app_id", linkConfig.getAid());
        hashMap.put(ReportUtil.Params.APP_VERSION, linkConfig.getAppVersion());
        hashMap.put("did", linkConfig.getDid());
        hashMap.put("channel", linkConfig.getChannel());
        hashMap.put("lang", linkConfig.getLang());
        return hashMap;
    }
}
