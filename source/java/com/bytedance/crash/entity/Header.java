package com.bytedance.crash.entity;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.AppVersion;
import com.bytedance.crash.dumper.CommonParamInfo;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.general.HardwareInfoHelper;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.AppVersionModel;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.SettingManager;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class Header {
    public static final String KEY_AID = "aid";
    public static final String KEY_APP_LAST_UPDATE_TIME = "last_update_time";
    public static final String KEY_APP_START_TIME = "app_start_time";
    public static final String KEY_APP_VERSION = "app_version";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_CRASH_TYPE = "crash_type";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_GET_PARAMS_ERROR = "get_params_error";
    public static final String KEY_OS_TYPE = "os";
    public static final String KEY_RELEASE_BUILD = "release_build";
    public static final String KEY_TOKEN = "x-auth-token";
    public static final String KEY_UNIQUE_KEY = "unique_key";
    public static final String KEY_UPDATE_VERSION_CODE = "update_version_code";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_VERSION_CODE = "version_code";
    public static final String KEY_VERSION_NAME = "version_name";
    private static int sIs64Bit = -1;
    private long mJiffy = -1;
    private final JSONObject mJson = new JSONObject();

    @Deprecated
    public static void addOtherHeader(Header header) {
    }

    @Deprecated
    public static void addRuntimeHeader(Header header) {
    }

    public static Header createHeaderWithoutCommon(AppMonitor appMonitor, long j, CrashType crashType, int i) {
        int i2;
        Header header = new Header();
        header.setAppInfo(j);
        JSONObject jSONObject = header.mJson;
        if (!jSONObject.has("device_id")) {
            JSONUtils.put(jSONObject, "device_id", appMonitor.getDeviceId("0"));
        }
        if (!jSONObject.has("channel")) {
            JSONUtils.put(jSONObject, "channel", appMonitor.getChannel(j));
        }
        try {
            i2 = Integer.parseInt(appMonitor.getAppId());
        } catch (Throwable unused) {
            i2 = SettingManager.AID_DEFAULT;
        }
        JSONUtils.put(jSONObject, "aid", Integer.valueOf(i2));
        AppVersionModel version = appMonitor.getVersion(j);
        if (version.getVersionName() != null) {
            JSONUtils.put(jSONObject, "app_version", version.getVersionName());
        }
        if (version.getVersionCode() != 0) {
            JSONUtils.put(jSONObject, "version_code", Long.valueOf(version.getVersionCode()));
        }
        if (version.getUpdateVersionCode() != 0) {
            JSONUtils.put(jSONObject, "update_version_code", Long.valueOf(version.getUpdateVersionCode()));
        }
        if (version.getManifestVersionCode() != 0) {
            JSONUtils.put(jSONObject, "manifest_version_code", Long.valueOf(version.getManifestVersionCode()));
        }
        header.setCommonHeader(j, crashType, i, null);
        return header;
    }

    public static Header createEventHeader(EventMonitor eventMonitor, long j, CrashType crashType, int i) {
        Header header = new Header();
        header.setAppInfo(j);
        header.setInitParams(eventMonitor, crashType);
        header.setCommonHeader(j, crashType, i, null);
        return header;
    }

    public static Header createCrashHeader(AppMonitor appMonitor, long j, long j2, CrashType crashType, int i, File file) {
        Header header = new Header();
        header.setAppInfo(j);
        header.setInitParams(appMonitor, j, j2, file);
        header.setCommonParams(file);
        header.setCommonHeader(j2, crashType, i, file);
        return header;
    }

    private void setCommonHeader(long j, CrashType crashType, int i, File file) {
        setRomInfo();
        setHardwareInfo();
        setCrashType(crashType);
        setUniqueKey(crashType, i, j);
        setLocale(file);
    }

    private void setCrashType(CrashType crashType) {
        JSONUtils.put(getJson(), KEY_CRASH_TYPE, crashType.getName());
    }

    private void setUniqueKey(CrashType crashType, int i, long j) {
        JSONUtils.put(getJson(), KEY_UNIQUE_KEY, "android_" + getDeviceId() + "_" + j + "_" + i + "_" + crashType.getName());
    }

    private void setRomInfo() {
        GeneralInfoManager.putRomInfo(this.mJson);
    }

    private void setHardwareInfo() {
        GeneralInfoManager.putHardwareInfo(this.mJson);
        this.mJiffy = GeneralInfoManager.getJiffy();
    }

    private void setAppInfo(long j) {
        GeneralInfoManager.putAppInfo(this.mJson, j);
    }

    private void setLocale(File file) {
        LocaleInfo.putTo(this.mJson, file);
    }

    private void setInitParams(EventMonitor eventMonitor, CrashType crashType) {
        int i;
        JSONUtils.put(this.mJson, "device_id", eventMonitor.getDeviceId("0"));
        JSONUtils.put(this.mJson, "user_id", Long.valueOf(eventMonitor.getUserId()));
        JSONUtils.put(this.mJson, "channel", eventMonitor.getChannel());
        JSONUtils.put(this.mJson, "mp_params", eventMonitor.getMPParams());
        try {
            i = Integer.parseInt(eventMonitor.getAppId());
        } catch (Throwable unused) {
            i = SettingManager.AID_DEFAULT;
        }
        JSONUtils.put(this.mJson, "aid", Integer.valueOf(i));
        AppVersionModel version = eventMonitor.getVersion();
        if (version.getVersionName() != null) {
            JSONUtils.put(this.mJson, "app_version", version.getVersionName());
        }
        if (version.getVersionCode() != 0) {
            JSONUtils.put(this.mJson, "version_code", Long.valueOf(version.getVersionCode()));
        }
        if (version.getUpdateVersionCode() != 0) {
            JSONUtils.put(this.mJson, "update_version_code", Long.valueOf(version.getUpdateVersionCode()));
        }
        if (version.getManifestVersionCode() != 0) {
            JSONUtils.put(this.mJson, "manifest_version_code", Long.valueOf(version.getManifestVersionCode()));
        }
        Map<String, Object> commParams = eventMonitor.getCommParams();
        if (commParams != null) {
            for (String str : commParams.keySet()) {
                if (commParams.get(str) != null) {
                    JSONUtils.put(this.mJson, str, commParams.get(str));
                }
            }
        }
    }

    private void setCommonParams(File file) {
        if (file != null) {
            CommonParamInfo.load(this.mJson, file);
        }
    }

    private void setInitParams(AppMonitor appMonitor, long j, long j2, File file) {
        int i;
        AppVersionModel versionByAppUpdateTime;
        JSONUtils.put(this.mJson, "device_id", appMonitor.getDeviceId(j2));
        JSONUtils.put(this.mJson, "user_id", Long.valueOf(appMonitor.getUserId(j2)));
        JSONUtils.put(this.mJson, "channel", appMonitor.getChannel(j2));
        JSONUtils.put(this.mJson, "mp_params", appMonitor.getMPParams());
        try {
            i = Integer.parseInt(appMonitor.getAppId(j2));
        } catch (Throwable unused) {
            i = SettingManager.AID_DEFAULT;
        }
        JSONUtils.put(this.mJson, "aid", Integer.valueOf(i));
        if (AppVersion.load(this.mJson, file)) {
            try {
                JSONObject jSONObject = this.mJson;
                JSONUtils.put(jSONObject, "init_version_name", jSONObject.opt("version_name"));
                JSONObject jSONObject2 = this.mJson;
                JSONUtils.put(jSONObject2, "init_update_version_code", jSONObject2.opt("update_version_code"));
            } catch (Throwable unused2) {
            }
            JSONUtils.put(this.mJson, "version_type", "crash_dump");
            return;
        }
        long lastUpdateTime = getLastUpdateTime();
        if (lastUpdateTime > 0 && j > lastUpdateTime && (versionByAppUpdateTime = appMonitor.getVersionByAppUpdateTime(lastUpdateTime)) != null && versionByAppUpdateTime.getVersionCode() != 0 && versionByAppUpdateTime.getVersionName() != null) {
            JSONUtils.put(this.mJson, "app_version", versionByAppUpdateTime.getVersionName());
            JSONUtils.put(this.mJson, "update_version_code", Long.valueOf(versionByAppUpdateTime.getUpdateVersionCode()));
            JSONUtils.put(this.mJson, "version_code", Long.valueOf(versionByAppUpdateTime.getVersionCode()));
            JSONUtils.put(this.mJson, "manifest_version_code", Long.valueOf(versionByAppUpdateTime.getManifestVersionCode()));
            JSONUtils.put(this.mJson, "version_type", KEY_APP_LAST_UPDATE_TIME);
            return;
        }
        AppVersionModel version = appMonitor.getVersion(j2);
        if (version != null && version.getVersionCode() != 0 && version.getVersionName() != null) {
            JSONUtils.put(this.mJson, "app_version", version.getVersionName());
            JSONUtils.put(this.mJson, "update_version_code", Long.valueOf(version.getUpdateVersionCode()));
            JSONUtils.put(this.mJson, "version_code", Long.valueOf(version.getVersionCode()));
            JSONUtils.put(this.mJson, "manifest_version_code", Long.valueOf(version.getManifestVersionCode()));
            JSONUtils.put(this.mJson, "version_type", "crash_time");
            return;
        }
        JSONUtils.put(this.mJson, "version_type", "app_info");
    }

    public long getLastUpdateTime() {
        return this.mJson.optLong(KEY_APP_LAST_UPDATE_TIME);
    }

    public JSONObject getJson() {
        return this.mJson;
    }

    public String getDeviceId() {
        return this.mJson.optString("device_id");
    }

    public CrashType getCrashType() {
        return CrashType.getType(this.mJson.optString(KEY_CRASH_TYPE));
    }

    public int getAid() {
        return this.mJson.optInt("aid");
    }

    @Deprecated
    private static void packRom(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        GeneralInfoManager.putRomInfo(jSONObject2);
        try {
            jSONObject.put(Api.KEY_ROM, jSONObject2.optString(Api.KEY_ROM));
            jSONObject.put("rom_version", jSONObject2.optString("rom_version"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static Header createHeader(Context context) {
        return new Header();
    }

    @Deprecated
    public JSONObject expandHeader(Map<String, Object> map) {
        return this.mJson;
    }

    @Deprecated
    public void setDeviceId(String str) {
        try {
            AppMonitor appMonitor = MonitorManager.getAppMonitor();
            if (appMonitor != null) {
                this.mJson.put("device_id", appMonitor.getDeviceId("0"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public void setUserId(long j) {
        try {
            AppMonitor appMonitor = MonitorManager.getAppMonitor();
            if (appMonitor != null) {
                this.mJson.put("user_id", appMonitor.getUserId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public JSONObject getHeaderJson() {
        return this.mJson;
    }

    public static boolean is64BitDevice() {
        if (sIs64Bit == -1) {
            sIs64Bit = HardwareInfoHelper.getCpuAbi().contains("64") ? 1 : 0;
        }
        return sIs64Bit == 1;
    }

    public long getJiffy() {
        return this.mJiffy;
    }
}
