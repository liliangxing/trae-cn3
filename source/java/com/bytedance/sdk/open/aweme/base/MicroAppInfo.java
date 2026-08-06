package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class MicroAppInfo {

    @SerializedName("appId")
    private String appId;

    @SerializedName("appTitle")
    private String appTitle;

    @SerializedName("appUrl")
    private String appUrl;

    @SerializedName("description")
    private String description;

    @SerializedName("open_platform_third_app_schema")
    private String thirdAppSchema;

    public static MicroAppInfo unserialize(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString(ParamKeyConstants.ShareParams.SHARE_MICROAPP_INFO);
        try {
            if (!TextUtils.isEmpty(string)) {
                return (MicroAppInfo) new Gson().fromJson(string, MicroAppInfo.class);
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppTitle() {
        return this.appTitle;
    }

    public String getAppUrl() {
        return this.appUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public String getThirdAppSchema() {
        return this.thirdAppSchema;
    }

    public void serialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putString(ParamKeyConstants.ShareParams.SHARE_MICROAPP_INFO, new Gson().toJson(this));
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppTitle(String str) {
        this.appTitle = str;
    }

    public void setAppUrl(String str) {
        this.appUrl = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setThirdAppSchema(String str) {
        this.thirdAppSchema = str;
    }
}
