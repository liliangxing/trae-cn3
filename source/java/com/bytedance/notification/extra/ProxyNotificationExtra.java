package com.bytedance.notification.extra;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.HmsMessageService;
import com.ss.android.pushmanager.PushCommonConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ProxyNotificationExtra implements Parcelable {
    public static final Parcelable.Creator<ProxyNotificationExtra> CREATOR = new Parcelable.Creator<ProxyNotificationExtra>() { // from class: com.bytedance.notification.extra.ProxyNotificationExtra.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProxyNotificationExtra createFromParcel(Parcel parcel) {
            return new ProxyNotificationExtra(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProxyNotificationExtra[] newArray(int i) {
            return new ProxyNotificationExtra[i];
        }
    };
    public static final int PROXY_TYPE_NO_PROXY = 0;
    public static final int PROXY_TYPE_NO_WAKE_UP_PROXY = 2;
    public static final int PROXY_TYPE_WAKE_UP_PROXY = 1;
    public JSONObject mExtras;
    public boolean mForceUpdateIcon;
    public String mOpPkg;
    public int mOriginApp;
    public String mPkg;
    public String mProxyIconUrl;
    private JSONObject mProxyNotificationExtraJsonObject;
    private String mProxyNotificationExtraStr;
    public int mProxyType;
    public int mSender;
    public int mTargetApp;
    public String mTargetAppName;
    public String mTargetPkg;
    public JSONObject partnerInfo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ProxyNotificationExtra(String str) {
        this.mProxyNotificationExtraStr = str;
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mProxyNotificationExtraJsonObject = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        initConfig();
    }

    public ProxyNotificationExtra(JSONObject jSONObject) {
        this.mProxyNotificationExtraJsonObject = jSONObject;
        if (jSONObject != null) {
            this.mProxyNotificationExtraStr = jSONObject.toString();
        }
        initConfig();
    }

    protected ProxyNotificationExtra(Parcel parcel) {
        this.mProxyNotificationExtraStr = parcel.readString();
        this.mForceUpdateIcon = parcel.readInt() == 1;
        this.mProxyIconUrl = parcel.readString();
        try {
            this.mExtras = new JSONObject(parcel.readString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.mTargetPkg = parcel.readString();
        this.mTargetAppName = parcel.readString();
        this.mPkg = parcel.readString();
        this.mOpPkg = parcel.readString();
        this.mOriginApp = parcel.readInt();
        this.mTargetApp = parcel.readInt();
        this.mSender = parcel.readInt();
    }

    private void initConfig() {
        JSONObject jSONObject = this.mProxyNotificationExtraJsonObject;
        if (jSONObject == null) {
            return;
        }
        this.mForceUpdateIcon = jSONObject.optBoolean("force_update_icon");
        this.mOriginApp = this.mProxyNotificationExtraJsonObject.optInt(PushCommonConstants.KEY_ORIGIN_APP, -1);
        this.mTargetApp = this.mProxyNotificationExtraJsonObject.optInt(PushCommonConstants.KEY_TARGET_APP, -1);
        this.mSender = this.mProxyNotificationExtraJsonObject.optInt("sender", -1);
        this.mProxyIconUrl = this.mProxyNotificationExtraJsonObject.optString("icon_url");
        JSONObject optJSONObject = this.mProxyNotificationExtraJsonObject.optJSONObject("extras");
        this.mExtras = optJSONObject;
        if (optJSONObject == null) {
            this.mExtras = new JSONObject();
        }
        this.mTargetPkg = this.mProxyNotificationExtraJsonObject.optString("target_pkg");
        this.mTargetAppName = this.mProxyNotificationExtraJsonObject.optString("target_app_name");
        this.mPkg = this.mProxyNotificationExtraJsonObject.optString("pkg");
        this.mOpPkg = this.mProxyNotificationExtraJsonObject.optString("op_pkg");
        this.mProxyType = this.mProxyNotificationExtraJsonObject.optInt(HmsMessageService.PROXY_TYPE, 0);
        this.partnerInfo = this.mProxyNotificationExtraJsonObject.optJSONObject("partner");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mProxyNotificationExtraStr);
        parcel.writeInt(this.mForceUpdateIcon ? 1 : 0);
        parcel.writeString(this.mProxyIconUrl);
        parcel.writeString(this.mExtras.toString());
        parcel.writeString(this.mTargetPkg);
        parcel.writeString(this.mTargetAppName);
        parcel.writeString(this.mPkg);
        parcel.writeString(this.mOpPkg);
        parcel.writeInt(this.mOriginApp);
        parcel.writeInt(this.mTargetApp);
        parcel.writeInt(this.mSender);
    }

    public boolean isValidWakeUpProxyMessage() {
        return this.mProxyType == 1 && this.partnerInfo != null;
    }
}
