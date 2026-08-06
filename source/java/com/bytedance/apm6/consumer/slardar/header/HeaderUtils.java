package com.bytedance.apm6.consumer.slardar.header;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.JsonUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class HeaderUtils {
    private static long sHeaderKey = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getTimeByHeaderId(long j) {
        if (j < 0) {
            return 0L;
        }
        return j >> 16;
    }

    public static JSONObject serialize(HeaderInfo headerInfo) {
        if (headerInfo == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (headerInfo.getStableExtra() != null) {
                jSONObject = JsonUtils.copyJson2(jSONObject, headerInfo.getStableExtra());
            }
            if (headerInfo.getDynamicExtra() != null) {
                jSONObject = JsonUtils.copyJson2(jSONObject, headerInfo.getDynamicExtra());
            }
            jSONObject.put("version_code", headerInfo.getVersionCode());
            jSONObject.put("version_name", headerInfo.getVersionName());
            jSONObject.put("manifest_version_code", headerInfo.getManifestVersionCode());
            jSONObject.put("update_version_code", headerInfo.getUpdateVersionCode());
            jSONObject.put("app_version", headerInfo.getAppVersion());
            jSONObject.put("os", headerInfo.getOs());
            jSONObject.put("device_platform", headerInfo.getDevicePlatform());
            jSONObject.put("os_version", headerInfo.getOsVersion());
            jSONObject.put("os_api", headerInfo.getApiVersion());
            jSONObject.put("device_model", headerInfo.getDeviceModel());
            jSONObject.put("device_brand", headerInfo.getDeviceBrand());
            jSONObject.put("device_manufacturer", headerInfo.getDeviceManufacturer());
            jSONObject.put("process_name", headerInfo.getProcessName());
            jSONObject.put("sid", headerInfo.getSid());
            jSONObject.put("rom_version", headerInfo.getRomVersion());
            jSONObject.put("package", headerInfo.getPackageName());
            jSONObject.put("monitor_version", headerInfo.getMonitorVersion());
            jSONObject.put("channel", headerInfo.getChannel());
            jSONObject.put("aid", headerInfo.getAid());
            if (!TextUtils.isEmpty(headerInfo.getDeviceId())) {
                jSONObject.put("device_id", headerInfo.getDeviceId());
            }
            jSONObject.put("uid", headerInfo.getUid());
            jSONObject.put("phone_startup_time", headerInfo.getPhoneStartTime());
            jSONObject.put("release_build", headerInfo.getReleaseBuild());
            if (headerInfo.getConfigTime() != -1) {
                jSONObject.put(Constants.KEY_CONFIG_TIME, String.valueOf(headerInfo.getConfigTime()));
            }
            if (!TextUtils.isEmpty(headerInfo.getVerifyInfo())) {
                jSONObject.put("verify_info", headerInfo.getVerifyInfo());
            }
            jSONObject.put("current_update_version_code", headerInfo.getCurrentUpdateVersionCode());
            if (headerInfo.getNtpTime() != -1) {
                jSONObject.put(Constants.KEY_NTP_TIME, headerInfo.getNtpTime());
            }
            if (headerInfo.getNtpOffset() != -1) {
                jSONObject.put(Constants.KEY_NTP_OFFSET, headerInfo.getNtpOffset());
            }
            if (headerInfo.getFilters() != null) {
                jSONObject.put("filters", headerInfo.getFilters());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static HeaderInfo deserialize(byte[] bArr) {
        try {
            HeaderInfo headerInfo = new HeaderInfo();
            JSONObject jSONObject = new JSONObject(new String(bArr));
            headerInfo.setVersionCode(JsonUtils.removeString(jSONObject, "version_code"));
            headerInfo.setVersionName(JsonUtils.removeString(jSONObject, "version_name"));
            headerInfo.setManifestVersionCode(JsonUtils.removeString(jSONObject, "manifest_version_code"));
            headerInfo.setUpdateVersionCode(JsonUtils.removeString(jSONObject, "update_version_code"));
            headerInfo.setAppVersion(JsonUtils.removeString(jSONObject, "app_version"));
            headerInfo.setOs(JsonUtils.removeString(jSONObject, "os"));
            headerInfo.setDevicePlatform(JsonUtils.removeString(jSONObject, "device_platform"));
            headerInfo.setOsVersion(JsonUtils.removeString(jSONObject, "os_version"));
            headerInfo.setApiVersion(JsonUtils.removeInt(jSONObject, "os_api"));
            headerInfo.setDeviceModel(JsonUtils.removeString(jSONObject, "device_model"));
            headerInfo.setDeviceBrand(JsonUtils.removeString(jSONObject, "device_brand"));
            headerInfo.setDeviceManufacturer(JsonUtils.removeString(jSONObject, "device_manufacturer"));
            headerInfo.setProcessName(JsonUtils.removeString(jSONObject, "process_name"));
            headerInfo.setSid(JsonUtils.removeLong(jSONObject, "sid"));
            headerInfo.setRomVersion(JsonUtils.removeString(jSONObject, "rom_version"));
            headerInfo.setPackageName(JsonUtils.removeString(jSONObject, "package"));
            headerInfo.setMonitorVersion(JsonUtils.removeString(jSONObject, "monitor_version"));
            headerInfo.setChannel(JsonUtils.removeString(jSONObject, "channel"));
            headerInfo.setAid(JsonUtils.removeInt(jSONObject, "aid"));
            headerInfo.setDeviceId(JsonUtils.removeString(jSONObject, "device_id"));
            headerInfo.setPhoneStartTime(JsonUtils.removeLong(jSONObject, "phone_startup_time"));
            headerInfo.setReleaseBuild(JsonUtils.removeString(jSONObject, "release_build"));
            headerInfo.setUid(JsonUtils.removeLong(jSONObject, "uid"));
            headerInfo.setVerifyInfo(JsonUtils.removeString(jSONObject, "verify_info"));
            headerInfo.setCurrentUpdateVersionCode(JsonUtils.removeString(jSONObject, "current_update_version_code"));
            if (jSONObject.has(Constants.KEY_CONFIG_TIME)) {
                headerInfo.setConfigTime(JsonUtils.removeInt(jSONObject, Constants.KEY_CONFIG_TIME));
            }
            try {
                headerInfo.setFilters(new JSONObject((String) jSONObject.remove("filters")));
            } catch (Exception unused) {
            }
            headerInfo.setStableExtra(jSONObject);
            return headerInfo;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static long getUniqueHeaderId() {
        if (sHeaderKey == -1) {
            sHeaderKey = (ApmContext.getStartId() << 16) | Process.myPid();
        }
        return sHeaderKey;
    }
}
