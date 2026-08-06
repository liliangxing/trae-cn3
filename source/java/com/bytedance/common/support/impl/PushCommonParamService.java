package com.bytedance.common.support.impl;

import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdturing.utils.Consts;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.support.service.IPushCommonParamService;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushCommonSetting;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PushCommonParamService implements IPushCommonParamService {
    private volatile String mProcessStartComponentName;
    private volatile String mProcessStartMethod;

    @Override // com.bytedance.common.support.service.IPushCommonParamService
    public Map<String, String> getHttpCommonParams() {
        return getHttpCommonParams(null);
    }

    @Override // com.bytedance.common.support.service.IPushCommonParamService
    public Map<String, String> getHttpCommonParams(Map<String, String> map) {
        Map extraCommonParams;
        HashMap hashMap = new HashMap();
        PushCommonSetting.getInstance().getSSIDs(hashMap);
        HashMap hashMap2 = new HashMap();
        if (map != null) {
            hashMap2.putAll(map);
        }
        hashMap2.put("push_sdk_version", String.valueOf(30919));
        hashMap2.put("push_sdk_version_name", "3.9.19-rc.0.7-bugfix");
        String str = (String) hashMap.get("install_id");
        if (!StringUtils.isEmpty(str)) {
            hashMap2.put("iid", str);
        }
        String str2 = (String) hashMap.get("device_id");
        if (!StringUtils.isEmpty(str2)) {
            hashMap2.put("device_id", str2);
        }
        String str3 = (String) hashMap.get("alias");
        if (!TextUtils.isEmpty(str3)) {
            hashMap2.put("alias", str3);
        }
        PushCommonConfiguration pushCommonConfiguration = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        String networkAccessType = NetworkUtils.getNetworkAccessType(pushCommonConfiguration.mApplication);
        if (!StringUtils.isEmpty(networkAccessType)) {
            hashMap2.put("ac", networkAccessType);
        }
        String str4 = pushCommonConfiguration.mChannel;
        if (str4 != null) {
            hashMap2.put("channel", str4);
        }
        hashMap2.put("aid", String.valueOf(pushCommonConfiguration.mAid));
        String str5 = pushCommonConfiguration.mAppName;
        if (str5 != null) {
            hashMap2.put(Api.KEY_APP_NAME, str5);
        }
        hashMap2.put("version_code", String.valueOf(pushCommonConfiguration.mVersionCode));
        hashMap2.put("version_name", pushCommonConfiguration.mVersionName);
        hashMap2.put("update_version_code", String.valueOf(pushCommonConfiguration.mUpdateVersionCode));
        hashMap2.put(Api.KEY_DEVICE_TYPE, Build.MODEL);
        hashMap2.put("device_brand", Build.BRAND);
        hashMap2.put("device_manufacturer", Build.MANUFACTURER);
        hashMap2.put(Api.KEY_LANGUAGE, Locale.getDefault().getLanguage());
        hashMap2.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        try {
            String str6 = Build.VERSION.RELEASE;
            if (str6 != null && str6.length() > 10) {
                str6 = str6.substring(0, 10);
            }
            hashMap2.put("os_version", str6);
        } catch (Exception unused) {
        }
        int dpi = UIUtils.getDpi(pushCommonConfiguration.mApplication);
        if (dpi > 0) {
            hashMap2.put(Api.KEY_DPI, String.valueOf(dpi));
        }
        hashMap2.put(Api.KEY_ROM, ToolUtils.getRomInfo());
        String str7 = Consts.OS_NAME;
        hashMap2.put("os", Consts.OS_NAME);
        hashMap2.put("package", pushCommonConfiguration.mApplication.getPackageName());
        hashMap2.put("push_device_id", ToolUtils.getPushFakeDeviceId(pushCommonConfiguration.mApplication));
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        if (timeZone != null) {
            hashMap2.put(Api.KEY_TZ_OFFSET, String.valueOf(timeZone.getOffset(ToolUtils.currentTimeMillis()) / 1000));
            hashMap2.put(Api.KEY_TZ_NAME, timeZone.getID());
        }
        String language = Locale.getDefault().getLanguage();
        if (!StringUtils.isEmpty(language)) {
            hashMap2.put(Api.KEY_LANGUAGE, language);
        }
        String country = Locale.getDefault().getCountry();
        if (!StringUtils.isEmpty(country)) {
            hashMap2.put("region", country.toLowerCase());
        }
        try {
            hashMap2.put("country", getCountry());
            if (pushCommonConfiguration.mExtraParams != null && (extraCommonParams = pushCommonConfiguration.mExtraParams.getExtraCommonParams()) != null) {
                hashMap2.putAll(extraCommonParams);
            }
            if (pushCommonConfiguration.mI18nCommonParams != null) {
                hashMap2.put(Api.KEY_APP_REGION, pushCommonConfiguration.mI18nCommonParams.getAppRegion());
                hashMap2.put(Api.KEY_APP_LANGUAGE, pushCommonConfiguration.mI18nCommonParams.getAppLanguage());
            }
            hashMap2.put("rom_version", RomVersionParamHelper.getParameter());
        } catch (Exception unused2) {
        }
        if (RomVersionParamHelper.isHarmonyOs()) {
            str7 = "harmony";
        }
        hashMap2.put("os_detail_type", str7);
        String harmonyOsVersion = RomVersionParamHelper.getHarmonyOsVersion();
        if (!TextUtils.isEmpty(harmonyOsVersion)) {
            hashMap2.put("extra_rom_version", harmonyOsVersion);
        }
        if (pushCommonConfiguration.mIsThroughMsgEncrypt) {
            hashMap2.put("through_msg_encrypt", "1");
        }
        hashMap2.put("process", ToolUtils.getCurProcessNameSuffix(pushCommonConfiguration.mApplication));
        Logger.d("PushCommonParamService", "[getHttpCommonParams]mProcessStartMethod:" + this.mProcessStartMethod + " mProcessStartComponentName:" + this.mProcessStartComponentName);
        if (!TextUtils.isEmpty(this.mProcessStartMethod)) {
            hashMap2.put("process_start_method", this.mProcessStartMethod);
        }
        if (!TextUtils.isEmpty(this.mProcessStartComponentName)) {
            hashMap2.put("process_start_component", this.mProcessStartComponentName);
        }
        return hashMap2;
    }

    @Override // com.bytedance.common.support.service.IPushCommonParamService
    public void setProcessStartReason(String str, String str2) {
        Logger.d("PushCommonParamService", "[setProcessStartMethod]mProcessStartMethod:" + this.mProcessStartMethod + " method:" + str + " mProcessStartComponentName:" + this.mProcessStartComponentName + " componentName:" + str2);
        if (TextUtils.isEmpty(this.mProcessStartMethod)) {
            this.mProcessStartMethod = str;
        }
        if (TextUtils.isEmpty(this.mProcessStartComponentName)) {
            this.mProcessStartComponentName = str2;
        }
    }

    private String getCountry() {
        String country = Resources.getSystem().getConfiguration().locale.getCountry();
        return !TextUtils.isEmpty(country) ? country.toUpperCase() : "";
    }
}
