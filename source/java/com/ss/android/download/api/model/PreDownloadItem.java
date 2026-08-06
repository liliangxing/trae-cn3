package com.ss.android.download.api.model;

import com.ss.android.download.api.utils.ToolUtils;
import com.ss.android.update.UpdateHelper;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class PreDownloadItem implements Serializable {
    private static final long serialVersionUID = -1872248691128991983L;
    public long adId;
    public String appPackageName;
    public String appVersion;
    public String downloadUrl;
    public boolean isAd;
    public String logExtra;
    public String md5;
    public long packageSize;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.appPackageName;
        String str2 = ((PreDownloadItem) obj).appPackageName;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.appPackageName;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    PreDownloadItem() {
    }

    public JSONObject toJSon() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("package_name", this.appPackageName);
            jSONObject.put("size", this.packageSize);
            jSONObject.put("app_version", this.appVersion);
            jSONObject.put(UpdateHelper.KEY_URL, this.downloadUrl);
            jSONObject.put("md5", this.md5);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static PreDownloadItem fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PreDownloadItem preDownloadItem = new PreDownloadItem();
        try {
            preDownloadItem.appPackageName = jSONObject.optString("package_name");
            preDownloadItem.packageSize = ToolUtils.optLong(jSONObject, "size");
            preDownloadItem.appVersion = jSONObject.optString("app_version");
            preDownloadItem.downloadUrl = jSONObject.optString(UpdateHelper.KEY_URL);
            preDownloadItem.md5 = jSONObject.optString("md5");
            return preDownloadItem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
