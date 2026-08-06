package com.bytedance.memory.event;

import android.text.TextUtils;
import com.bytedance.memory.api.MemoryApi;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.EventConfig;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class EventUtils {
    public static final String ALLOW_SERVICE_NAME = "allow_service_name";
    public static final String CLIENT_ANALYZE_BEGIN = "client_analyze_begin";
    public static final String CLIENT_ANALYZE_END = "client_analyze_end";
    public static final String CLIENT_ANALYZE_TIME = "client_analyze_time";
    public static final String CLOSE_NATIVE_DUMP_AND_SHRINK = "close_native_dump_and_shrink";
    public static final String CLOSE_NATIVE_SHRINK = "close_native_shrink";
    public static final String CLOSE_NPTH_HPROF = "npth_hprof_close";
    public static final String CLOSE_NPTH_HPROF_EXPIRED = "npth_hprof_close_expired";
    public static final String CUSTOM_EVENT_SETTINGS = "custom_event_settings";
    public static final String DUMPCOLLECT_URL_NULL = "error_dumpcollect_url_null";
    public static final String DUMP_BEGIN = "dump_begin";
    public static final String DUMP_END = "dump_end";
    public static final String DUMP_TIME = "dump_time";
    public static final String ERROR_CORRUPTED_HPROF = "error_corruppted_hprof";
    public static final String ERROR_DISALLOW_UPLOAD_WHEN_NOT_WIFI_IN_DUMP = "error_not_wifi_in_dump";
    public static final String ERROR_DISALLOW_UPLOAD_WHEN_NOT_WIFI_IN_UPLOAD = "error_not_wifi_in_upload";
    public static final String ERROR_DISALLOW_UPLOAD_WHEN_NOT_WIFI_IN_UPLOADCHECK = "error_not_wifi_in_uploadcheck";
    public static final String ERROR_EXPIRED_HEAP_HPROF = "error_expired_heap_hprof";
    public static final String ERROR_EXPIRED_ZIP_HPROF = "error_expired_zip_hprof";
    public static final String ERROR_UPLOADFILE_EXCEPTION = "error_uploadfile_exception";
    public static final String ERROR_UPLOADFILE_FAILED = "error_uploadfile_failed";
    public static final String ERROR_VERSION_MISMATCH = "error_version_mismatch";
    public static final String FORBID_UPLOAD = "error_forbid_upload";
    public static final String MEMORY = "memory";
    public static final String MEMORY_DUMP_EVENT = "memory_dump_event";
    public static final String MEMORY_UPLOAD_ORIGIN = "memory_upload_origin";
    public static final String NPTH_DUMP_BEGIN = "npth_dump_begin";
    public static final String NPTH_DUMP_END = "npth_dump_end";
    public static final String ORIGIN_COMPRESS_BEGIN = "origin_compress_begin";
    public static final String ORIGIN_COMPRESS_END = "origin_compress_end";
    public static final String ORIGIN_COMPRESS_SIZE = "origin_compress_size";
    public static final String ORIGIN_COMPRESS_TIME = "origin_compress_time";
    public static final String ORIGIN_SIZE = "origin_size";
    public static final String PERFORMANCE_MODULES = "performance_modules";
    public static final String SHRINK_BEGIN = "shrink_begin";
    public static final String SHRINK_COMPRESS_BEGIN = "shrink_compress_begin";
    public static final String SHRINK_COMPRESS_END = "shrink_compress_end";
    public static final String SHRINK_COMPRESS_SIZE = "shrink_compress_size";
    public static final String SHRINK_COMPRESS_TIME = "shrink_compress_time";
    public static final String SHRINK_DEEP_BEGIN = "shrink_deep_begin";
    public static final String SHRINK_DEEP_END = "shrink_deep_end";
    public static final String SHRINK_END = "shrink_end";
    public static final String SHRINK_SIZE = "shrink_size";
    public static final String SHRINK_TIME = "shrink_time";
    public static final String UPLOAD_DUMP = "upload_dump";
    public static final String UPLOAD_DUMP_SUCCESS = "upload_dump_success";
    public static final String UPLOAD_RELEASE_BUILD_STATUS = "upload_release_build_status";

    public static void uploadCategoryEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            IApmAgent iApmAgent = (IApmAgent) ServiceManager.getService(IApmAgent.class);
            if (iApmAgent != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, 1);
                iApmAgent.monitorEvent(MEMORY_DUMP_EVENT, jSONObject, (JSONObject) null, (JSONObject) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void uploadCategoryEvent(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            IApmAgent iApmAgent = (IApmAgent) ServiceManager.getService(IApmAgent.class);
            if (iApmAgent != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, str2);
                iApmAgent.monitorEvent(MEMORY_DUMP_EVENT, jSONObject, (JSONObject) null, (JSONObject) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void uploadCategoryEventImmediate(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            IApmAgent iApmAgent = (IApmAgent) ServiceManager.getService(IApmAgent.class);
            if (iApmAgent != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, 1);
                iApmAgent.monitorEvent(EventConfig.builder().setServiceName(MEMORY_DUMP_EVENT).setCategory(jSONObject).isUploadImmediate(true).build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void uploadMetricEvent(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            IApmAgent iApmAgent = (IApmAgent) ServiceManager.getService(IApmAgent.class);
            if (iApmAgent != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, j);
                iApmAgent.monitorEvent(MEMORY_DUMP_EVENT, (JSONObject) null, jSONObject, (JSONObject) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean getMemoryEvent(String str) {
        return getEvent(PERFORMANCE_MODULES, "memory", str) || MemoryApi.getInstance().debugMode();
    }

    public static boolean getMemoryEventNoDebug(String str) {
        return getEvent(PERFORMANCE_MODULES, "memory", str);
    }

    public static boolean getDumpEventNoDebug(String str) {
        return getEvent(CUSTOM_EVENT_SETTINGS, ALLOW_SERVICE_NAME, str);
    }

    public static boolean getEvent(String str, String str2, String str3) {
        JSONObject configJSON;
        JSONObject optJSONObject;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                IConfigManager iConfigManager = (IConfigManager) ServiceManager.getService(IConfigManager.class);
                if (iConfigManager == null || (configJSON = iConfigManager.getConfigJSON(str)) == null || (optJSONObject = configJSON.optJSONObject(str2)) == null) {
                    return false;
                }
                return optJSONObject.optInt(str3, 0) == 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
