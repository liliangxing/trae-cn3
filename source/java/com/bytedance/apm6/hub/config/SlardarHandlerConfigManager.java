package com.bytedance.apm6.hub.config;

import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.SlardarHandler;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfig;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.foundation.safety.CustomExceptionHelper;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SlardarHandlerConfigManager implements SlardarHandlerConfigService {
    public static final int DEFAULT_LOG_MAX_SAVE_DAYS = 5;
    public static final int DEFAULT_MAX_DB_SIZE_MB = 80;
    private volatile SlardarHandlerConfig config;
    private JSONObject outsideConfig;
    String SETTING_GENERAL_API_REPORT = SlardarSettingsConsts.SETTING_GENERAL_API_REPORT;
    String SETTING_GENERAL_API_REPORT_ENCRYPT = SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_ENCRYPT;
    String SETTING_GENERAL_API_REPORT_HOSTS = SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_HOSTS;
    String BASE_KEY_ONCE_MAX_SIZE_KB = "apm6_once_max_size_kb";
    String BASE_KEY_REPORT_INTERVAL = "apm6_uploading_interval";
    String SETTING_GENERAL_ENABLE_REPORT_INTERNAL_EXCEPTION = "enable_report_internal_exception";
    String LOG_RESERVE_DAYS = SlardarSettingsConsts.LOG_RESERVE_DAYS;
    String LOG_MAX_SIZE_MB = SlardarSettingsConsts.LOG_MAX_SIZE_MB;
    String COMPRESS_TYPE = "compress_type";

    public SlardarHandlerConfigManager() {
        initConfig();
    }

    public SlardarHandlerConfigManager(JSONObject jSONObject) {
        this.outsideConfig = jSONObject;
        initConfig();
    }

    private void initConfig() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new IConfigChangeListener() { // from class: com.bytedance.apm6.hub.config.SlardarHandlerConfigManager.1
            @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
            public void onConfigChanged(JSONObject jSONObject, boolean z) {
                SlardarHandlerConfigManager.this.parseConfig(jSONObject, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseConfig(JSONObject jSONObject, boolean z) {
        JSONObject optJSONObject;
        String str;
        JSONObject optJSONObject2;
        if (jSONObject == null || (optJSONObject = JsonUtils.optJSONObject(jSONObject, "general", "slardar_api_settings", this.SETTING_GENERAL_API_REPORT)) == null) {
            return;
        }
        List<String> parseReportHost = parseReportHost(optJSONObject.optJSONArray(this.SETTING_GENERAL_API_REPORT_HOSTS));
        ArrayList arrayList = new ArrayList();
        String str2 = null;
        if (ListUtils.isEmpty(parseReportHost)) {
            str = null;
        } else {
            str = null;
            for (String str3 : parseReportHost) {
                arrayList.add("https://" + str3 + "/monitor/collect/batch/");
                if (str2 == null) {
                    str2 = "https://" + str3 + "/monitor/collect/c/exception";
                }
                if (str == null) {
                    str = "https://" + str3 + "/monitor/collect/c/trace_collect";
                }
            }
        }
        boolean optBoolean = optJSONObject.optBoolean(this.SETTING_GENERAL_API_REPORT_ENCRYPT, true);
        long optLong = optJSONObject.optLong(this.BASE_KEY_ONCE_MAX_SIZE_KB, -1L) * 1024;
        long optLong2 = optJSONObject.optLong(this.BASE_KEY_REPORT_INTERVAL, -1L) * 1000;
        boolean z2 = JsonUtils.optInt(jSONObject, "general", this.SETTING_GENERAL_ENABLE_REPORT_INTERNAL_EXCEPTION) == 1;
        SlardarHandlerConfig slardarHandlerConfig = new SlardarHandlerConfig();
        slardarHandlerConfig.setReportUrlList(arrayList);
        slardarHandlerConfig.setExceptionUrl(str2);
        slardarHandlerConfig.setTraceReportUrl(str);
        slardarHandlerConfig.setOnceReportMaxSizeBytes(optLong);
        slardarHandlerConfig.setEncrypt(optBoolean);
        slardarHandlerConfig.setReportInterval(optLong2);
        slardarHandlerConfig.setUploadInternalException(z2);
        JSONObject jSONObject2 = this.outsideConfig;
        if (jSONObject2 != null) {
            slardarHandlerConfig.setMaxSizeMBToday(jSONObject2.optInt(CommonKey.OUTSIDE_MAX_SIZE_MB_TODAY, -1));
        }
        slardarHandlerConfig.setCompressType(optJSONObject.optInt(this.COMPRESS_TYPE, 2));
        JSONObject optJSONObject3 = jSONObject.optJSONObject("general");
        if (optJSONObject3 != null && (optJSONObject2 = optJSONObject3.optJSONObject("cleanup")) != null) {
            slardarHandlerConfig.setMaxSizeMB(optJSONObject2.optInt(this.LOG_MAX_SIZE_MB, 80));
            slardarHandlerConfig.setKeepDays(optJSONObject2.optInt(this.LOG_RESERVE_DAYS, 5));
        }
        this.config = slardarHandlerConfig;
        if (ApmContext.isDebugMode()) {
            Logger.m119d(ConfigConstants.LOG_TAG, "received reportSetting=" + optJSONObject);
            Logger.m119d(ConfigConstants.LOG_TAG, "parsed SlardarHandlerConfig=" + this.config);
        }
        CustomExceptionHelper.setEnableReport(z2);
        CustomExceptionHelper.setExceptionUrl(str2);
        SlardarHandler.getInstance().setSlardarHandlerConfig(getConfig());
    }

    private static List<String> parseReportHost(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList(2);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        String host = new URL(jSONArray.getString(i)).getHost();
                        if (!TextUtils.isEmpty(host) && host.indexOf(46) > 0) {
                            arrayList.add(host);
                        }
                    }
                    return arrayList;
                }
            } catch (MalformedURLException e) {
                Logger.m121e(Constants.TAG_SETTING, "parse setting host malformedurl exception", e);
            } catch (JSONException e2) {
                Logger.m121e(Constants.TAG_SETTING, "parse setting host json exception", e2);
            }
        }
        return Collections.emptyList();
    }

    @Override // com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService
    public SlardarHandlerConfig getConfig() {
        return this.config;
    }

    @Override // com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService
    public void setOutsideConfig(JSONObject jSONObject) {
        this.outsideConfig = jSONObject;
    }
}
