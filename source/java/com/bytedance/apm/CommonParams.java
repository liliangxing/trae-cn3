package com.bytedance.apm;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CommonParams {
    private int aid;
    private String appVersion;
    private String channel;
    private String deviceId;
    private JSONObject dynamicHeaderExtras;
    private int manifestVersionCode;
    private Map<String, String> paramExtras;
    private String processName;
    private String releaseBuild;
    private JSONObject staticHeaderExtras;
    private int updateVersionCode;
    private int versionCode;
    private String versionName;

    public int getAid() {
        return this.aid;
    }

    public void setAid(int i) {
        this.aid = i;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public long getUid() {
        if (ApmContext.getDynamicParams() != null) {
            return ApmContext.getDynamicParams().getUid();
        }
        return 0L;
    }

    public String getSession() {
        if (ApmContext.getDynamicParams() != null) {
            return ApmContext.getDynamicParams().getSessionId();
        }
        return null;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String str) {
        this.processName = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public int getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public void setUpdateVersionCode(int i) {
        this.updateVersionCode = i;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public int getManifestVersionCode() {
        return this.manifestVersionCode;
    }

    public void setManifestVersionCode(int i) {
        this.manifestVersionCode = i;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getReleaseBuild() {
        return this.releaseBuild;
    }

    public void setReleaseBuild(String str) {
        this.releaseBuild = str;
    }

    public JSONObject getDynamicHeaderExtras() {
        return this.dynamicHeaderExtras;
    }

    public void setDynamicHeaderExtras(JSONObject jSONObject) {
        this.dynamicHeaderExtras = jSONObject;
    }

    public JSONObject getStaticHeaderExtras() {
        return this.staticHeaderExtras;
    }

    public void setStaticHeaderExtras(JSONObject jSONObject) {
        this.staticHeaderExtras = jSONObject;
    }

    public Map<String, String> getParamExtras() {
        return this.paramExtras;
    }

    public void setParamExtras(Map<String, String> map) {
        this.paramExtras = map;
    }
}
