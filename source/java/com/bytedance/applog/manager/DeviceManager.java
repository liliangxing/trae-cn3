package com.bytedance.applog.manager;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.bdinstall.IBdInstallService;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.server.Api;
import com.bytedance.applog.util.JsonUtils;
import com.bytedance.applog.util.RomUtils;
import com.bytedance.applog.util.TLog;
import com.bytedance.applog.util.Utils;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DeviceManager {
    private static final List<String> logTags = Collections.singletonList("DeviceManager");
    private final AppLogInstance appLogInstance;
    private volatile boolean mAllReady;
    private final IBdInstallService mBDInstallService;
    private final ConfigManager mConfig;
    private final SharedPreferences mSp;
    private volatile boolean isDidAndIidValid = false;
    private volatile JSONObject mHeader = new JSONObject();

    public DeviceManager(AppLogInstance appLogInstance, ConfigManager configManager, IBdInstallService iBdInstallService) {
        this.appLogInstance = appLogInstance;
        this.mConfig = configManager;
        this.mBDInstallService = iBdInstallService;
        this.mSp = configManager.getStatSp();
    }

    public <T> T getHeaderValue(String str, T t, Class<T> cls) {
        return (T) this.appLogInstance.getApiParamsUtil().getValue(this.mHeader, str, t, cls);
    }

    public JSONObject getCopiedHeader() {
        return Utils.copyJson(this.mHeader);
    }

    public long getVersionCode() {
        InstallOptions installOptions = this.mBDInstallService.getInstallOptions();
        if (installOptions != null) {
            return installOptions.getVersionCode();
        }
        return 0L;
    }

    public String getVersionName() {
        InstallOptions installOptions = this.mBDInstallService.getInstallOptions();
        return installOptions != null ? installOptions.getVersion() : "";
    }

    public synchronized void setExternalAbVersion(String str) {
        Set<String> setFromString = getSetFromString(this.mConfig.getExternalAbVersion());
        Set<String> setFromString2 = getSetFromString(this.mHeader.optString(Api.KEY_AB_SDK_VERSION));
        setFromString2.removeAll(setFromString);
        setFromString2.addAll(getSetFromString(str));
        this.mConfig.setExternalAbVersion(str);
        setAbSdkVersion(getStringsFromSet(setFromString2));
    }

    private String getStringsFromSet(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private Set<String> getSetFromString(String str) {
        String[] split;
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(str) && (split = str.split(",")) != null && split.length > 0) {
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2)) {
                    hashSet.add(str2);
                }
            }
        }
        return hashSet;
    }

    public void setUserUniqueId(String str) {
        this.mConfig.setUserUniqueId(str);
    }

    public String getUserUniqueId() {
        if (this.mAllReady) {
            return this.mHeader.optString("user_unique_id", "");
        }
        ConfigManager configManager = this.mConfig;
        return configManager != null ? configManager.getUserUniqueId() : "";
    }

    private void setAbSdkVersion(String str) {
        if (updateHeader(Api.KEY_AB_SDK_VERSION, str)) {
            this.mConfig.setAbSdkVersion(str);
        }
    }

    private boolean updateHeader(String str, Object obj) {
        boolean z;
        if (this.appLogInstance.getBlockHeaderKeys().contains(str)) {
            this.appLogInstance.getLogger().warn(logTags, "update header failed for header: {} is blocked!", str);
            return false;
        }
        Object opt = this.mHeader.opt(str);
        if ((obj == null || obj.equals(opt)) && (obj != null || opt == null)) {
            z = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.mHeader;
                    JSONObject jSONObject2 = new JSONObject();
                    Utils.copy(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.mHeader = jSONObject2;
                    if ("device_id".equals(str) || "install_id".equals(str)) {
                        loadIsValidDidAndIid();
                    }
                } catch (JSONException e) {
                    this.appLogInstance.getLogger().error(logTags, "update header failed", e, new Object[0]);
                }
            }
            z = true;
        }
        this.appLogInstance.getLogger().debug(logTags, "updateHeader -> key:{}, old:{}, new:{}", str, opt, obj);
        return z;
    }

    public boolean isValidDidAndIid() {
        return this.isDidAndIidValid;
    }

    public boolean isValidDidAndIid(JSONObject jSONObject) {
        if (jSONObject != null) {
            return Utils.checkId(jSONObject.optString("device_id", "")) && Utils.checkId(jSONObject.optString("install_id", ""));
        }
        return false;
    }

    public String getAbSdkVersion() {
        return this.mConfig.getAbSdkVersion();
    }

    public long getLastVersionCode() {
        try {
            return this.mSp.getLong("version_code", 0L);
        } catch (ClassCastException unused) {
            long j = this.mSp.getInt("version_code", 0);
            this.mSp.edit().putLong("version_code", j).apply();
            return j;
        }
    }

    public void updateHeader(JSONObject jSONObject) {
        this.appLogInstance.getLogger().debug(logTags, "updateHeader: {}", jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        String abSdkVersion = this.appLogInstance.getAbSdkVersion();
        synchronized (this) {
            Utils.copy(jSONObject2, this.mHeader);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    try {
                        jSONObject2.put(next, getHeaderValueWithFilter(jSONObject, next));
                    } catch (JSONException e) {
                        this.appLogInstance.getLogger().error("updateHeader put header key:{} value failed", next, e);
                    }
                }
            }
            try {
                jSONObject2.put("sdk_version", 5071151);
                jSONObject2.put("sdk_version_code", TLog.SDK_VERSION_CODE);
                jSONObject2.put("sdk_version_name", "5.7.11-rc.1");
                if (!TextUtils.isEmpty(abSdkVersion)) {
                    jSONObject2.put(Api.KEY_AB_SDK_VERSION, abSdkVersion);
                }
                loadHarmonyInfo(jSONObject2);
            } catch (Throwable th) {
                this.appLogInstance.getLogger().error("updateHeader put header sdk version or load harmony info failed", th, new Object[0]);
                this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
            }
            Iterator<String> it = this.appLogInstance.getBlockHeaderKeys().iterator();
            while (it.hasNext()) {
                jSONObject2.remove(it.next());
            }
            this.mHeader = jSONObject2;
            this.mAllReady = true;
            loadIsValidDidAndIid();
        }
        SharedPreferences.Editor edit = this.mSp.edit();
        edit.putLong("version_code", this.mHeader.optLong("version_code", 0L));
        edit.putString("channel", this.mHeader.optString("channel", ""));
        edit.apply();
        if (LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("set_header", new EventBus.DataFetcher() { // from class: com.bytedance.applog.manager.DeviceManager.1
            @Override // com.bytedance.applog.log.EventBus.DataFetcher
            public Object fetch() {
                JSONObject jSONObject3 = new JSONObject();
                JsonUtils.mergeJsonObject(DeviceManager.this.mHeader, jSONObject3);
                try {
                    jSONObject3.put("appId", DeviceManager.this.appLogInstance.getAppId());
                } catch (Throwable unused) {
                    DeviceManager.this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                }
                return jSONObject3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void filterHeaderInMemory() {
        updateHeader(this.mHeader);
    }

    private Object getHeaderValueWithFilter(JSONObject jSONObject, String str) {
        if ("custom".equals(str) && this.appLogInstance.isCustomHeaderControlEnabled()) {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject == null) {
                return jSONObject.opt(str);
            }
            ArrayList<String> arrayList = new ArrayList();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!this.mConfig.isCustomHeaderKeyAllowed(next)) {
                    arrayList.add(next);
                }
            }
            for (String str2 : arrayList) {
                optJSONObject.remove(str2);
                this.appLogInstance.getLogger().info(logTags, "custom header:{} removed by header control ", str2);
                this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.REMOVE_CUSTOM_HEADER_COUNT);
            }
            return optJSONObject;
        }
        return jSONObject.opt(str);
    }

    private void loadHarmonyInfo(JSONObject jSONObject) {
        boolean isHarmonyUI = RomUtils.isHarmonyUI();
        try {
            jSONObject.put("platform", isHarmonyUI ? "Harmony" : "Android");
        } catch (JSONException e) {
            this.appLogInstance.getLogger().error(logTags, "loadHarmonyInfo failed", e, new Object[0]);
        }
        if (isHarmonyUI) {
            try {
                jSONObject.put("harmony_os_api", SystemPropertiesWithCache.get("hw_sc.build.os.apiversion"));
                jSONObject.put("harmony_os_version", SystemPropertiesWithCache.get("hw_sc.build.platform.version"));
                jSONObject.put("harmony_release_type", SystemPropertiesWithCache.get("hw_sc.build.os.releasetype"));
            } catch (Throwable th) {
                this.appLogInstance.getLogger().debug(logTags, "loadHarmonyInfo failed", th);
            }
        }
    }

    public boolean isHeaderReady() {
        return this.mAllReady && isValidDidAndIid();
    }

    private void loadIsValidDidAndIid() {
        this.isDidAndIidValid = isValidDidAndIid(this.mHeader);
    }
}
