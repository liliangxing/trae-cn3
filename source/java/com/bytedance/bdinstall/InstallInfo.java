package com.bytedance.bdinstall;

import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class InstallInfo implements Cloneable {
    private String clientUdid;
    private String eDid;
    private String eIid;
    private String egdi;
    private String openUdid;
    private String ssid;
    private String did = "";
    private String iid = "";

    public String getEDid() {
        return this.eDid;
    }

    public void setEDid(String str) {
        this.eDid = str;
    }

    public String getEIid() {
        return this.eIid;
    }

    public void setEIid(String str) {
        this.eIid = str;
    }

    public String getIid() {
        return this.iid;
    }

    public String getOpenUdid() {
        return this.openUdid;
    }

    public String getClientUdid() {
        return this.clientUdid;
    }

    public String getDid() {
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public void setIid(String str) {
        this.iid = str;
    }

    public void setOpenUdid(String str) {
        this.openUdid = str;
    }

    public void setClientUdid(String str) {
        this.clientUdid = str;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public void setEgdi(String str) {
        this.egdi = str;
    }

    public String getEgdi() {
        return this.egdi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonConstants.KEY_DEVICE_ID, this.did);
            jSONObject.put("iid", this.iid);
            jSONObject.put("openudid", this.openUdid);
            jSONObject.put("cliend_udid", this.clientUdid);
            jSONObject.put("ssid", this.ssid);
            jSONObject.put("eDid", this.eDid);
            jSONObject.put("eIid", this.eIid);
            jSONObject.put("egdi", this.egdi);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InstallInfo parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            InstallInfo installInfo = new InstallInfo();
            installInfo.setDid(jSONObject.optString(CommonConstants.KEY_DEVICE_ID, ""));
            installInfo.setIid(jSONObject.optString("iid", ""));
            installInfo.setOpenUdid(jSONObject.optString("openudid", ""));
            installInfo.setClientUdid(jSONObject.optString("cliend_udid", ""));
            installInfo.setSsid(jSONObject.optString("ssid", ""));
            installInfo.setSsid(jSONObject.optString("eDid", ""));
            installInfo.setSsid(jSONObject.optString("eIid", ""));
            installInfo.setEgdi(jSONObject.optString("egdi", ""));
            DrLog.d("aaa# parse install info " + installInfo);
            return installInfo;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "{d='" + this.did + "', i='" + this.iid + "', o='" + this.openUdid + "', c='" + this.clientUdid + "', s='" + this.ssid + "', eDid='" + this.eDid + "', eIid='" + this.eIid + "', e='" + this.egdi + "'}";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public InstallInfo m7683clone() {
        try {
            return (InstallInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            DrLog.e("clone error", e);
            return null;
        }
    }
}
