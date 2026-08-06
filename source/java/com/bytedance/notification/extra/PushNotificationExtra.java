package com.bytedance.notification.extra;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.android.service.manager.push.notification.PushNotificationButtonInfo;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.notification.interfaze.IBannerNotificationListener;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.bytedance.push.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class PushNotificationExtra implements Parcelable {
    public static final int BANNER_TYPE_FULL_SCREEN = 1;
    public static final int BANNER_TYPE_TOAST = 0;
    public static final Parcelable.Creator<PushNotificationExtra> CREATOR = new Parcelable.Creator<PushNotificationExtra>() { // from class: com.bytedance.notification.extra.PushNotificationExtra.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PushNotificationExtra createFromParcel(Parcel parcel) {
            return new PushNotificationExtra(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PushNotificationExtra[] newArray(int i) {
            return new PushNotificationExtra[i];
        }
    };
    public int flags;
    public Bitmap mBannerBackgroundBitmap;
    public String mBannerBackgroundImage;
    public int mBannerColor;
    public int mBannerContentColor;
    public int mBannerHeaderColor;
    public double mBannerShowDuration;
    public int mBannerTitleColor;
    public int mBannerType;
    public JSONObject mBdPushObject;
    public String mBdPushStr;
    public boolean mBrightScreen;
    public boolean mEnableBannerHighLight;
    public boolean mEnableBannerShow;
    public boolean mEnableNotificationHighLight;
    public boolean mEnableOnTop;
    public boolean mEnableSticky;
    public JSONObject mExtras;
    public boolean mHandleBySdk;
    public IBannerNotificationListener mIBannerNotificationListener;
    public boolean mIsEmptyExtra;
    public JSONArray mNotifiactionButtonInfoObject;
    public Bitmap mNotificationBackgroundBitmap;
    public String mNotificationBackgroundImage;
    public int mNotificationColor;
    public int mNotificationContentColor;
    public int mNotificationHeaderColor;
    public int mNotificationRedbadgeNumber;
    public int mNotificationTitleColor;
    public String mNotificationVideoUrl;
    public int mOnTopTime;
    public Bitmap mProxyIconBitmap;
    public ProxyNotificationExtra mProxyNotificationExtra;
    public List<PushNotificationButtonInfo> mPushNotificationButtonInfoList;
    public boolean mResetAllTextToBlack;
    public boolean mUseSound;
    public boolean mUseVibration;

    /* loaded from: classes4.dex */
    public @interface BannerType {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PushNotificationExtra(String str) {
        this.mEnableNotificationHighLight = false;
        this.mNotificationColor = -1;
        this.mNotificationHeaderColor = 0;
        this.mNotificationTitleColor = 0;
        this.mNotificationContentColor = 0;
        this.mEnableSticky = false;
        this.mEnableOnTop = false;
        this.mOnTopTime = 2;
        this.mEnableBannerShow = false;
        this.mBannerType = 0;
        this.mEnableBannerHighLight = false;
        this.mBannerColor = -1;
        this.mBannerHeaderColor = 0;
        this.mBannerTitleColor = 0;
        this.mBannerContentColor = 0;
        this.mBannerShowDuration = 1.0d;
        this.mIsEmptyExtra = false;
        this.flags = -1;
        if (TextUtils.isEmpty(str)) {
            this.mIsEmptyExtra = true;
            return;
        }
        this.mBdPushStr = str;
        try {
            this.mBdPushObject = new JSONObject(this.mBdPushStr);
            initConfig();
        } catch (Throwable unused) {
            this.mIsEmptyExtra = true;
        }
    }

    private void initConfig() {
        JSONObject jSONObject = this.mBdPushObject;
        if (jSONObject == null) {
            this.mIsEmptyExtra = true;
            return;
        }
        try {
            this.mEnableNotificationHighLight = jSONObject.optBoolean("enable_notification_highlight", false);
            this.mNotificationColor = parseColor(this.mBdPushObject, "notification_color", -1);
            this.mNotificationBackgroundImage = this.mBdPushObject.optString("notification_background_image");
            this.mBannerBackgroundImage = this.mBdPushObject.optString("banner_background_image");
            this.mNotificationHeaderColor = parseColor(this.mBdPushObject, "notification_header_color", 0);
            this.mNotificationTitleColor = parseColor(this.mBdPushObject, "notification_title_color", 0);
            this.mNotificationContentColor = parseColor(this.mBdPushObject, "notification_content_color", 0);
            this.mResetAllTextToBlack = this.mBdPushObject.optBoolean("reset_all_text_to_black", false);
            this.mEnableBannerShow = this.mBdPushObject.optBoolean("enable_banner_show", false);
            this.mEnableBannerHighLight = this.mBdPushObject.optBoolean("enable_banner_highlight", false);
            this.mBannerType = this.mBdPushObject.optInt("banner_type", 0);
            this.mBannerColor = parseColor(this.mBdPushObject, "banner_color", -1);
            this.mBannerHeaderColor = parseColor(this.mBdPushObject, "banner_header_color", 0);
            this.mBannerTitleColor = parseColor(this.mBdPushObject, "banner_title_color", 0);
            this.mBannerContentColor = parseColor(this.mBdPushObject, "banner_content_color", 0);
            this.mBannerShowDuration = this.mBdPushObject.optDouble("banner_show_duration", 1.0d);
            this.mEnableSticky = this.mBdPushObject.optBoolean("enable_sticky", false);
            this.mEnableOnTop = this.mBdPushObject.optBoolean("enable_on_top", false);
            this.mOnTopTime = this.mBdPushObject.optInt("on_top_time", 2);
            this.mHandleBySdk = this.mBdPushObject.optBoolean(MultiProcessPushMessageDatabaseHelper.COL_HANDLE_BY_SDK, true);
            if (this.mBdPushObject.optBoolean("handle_by_business", false)) {
                this.mHandleBySdk = false;
            }
            JSONObject optJSONObject = this.mBdPushObject.optJSONObject("proxy_notification_info");
            if (optJSONObject != null) {
                this.mProxyNotificationExtra = new ProxyNotificationExtra(optJSONObject);
            }
            this.mNotifiactionButtonInfoObject = this.mBdPushObject.optJSONArray("notification_button_info");
            this.mPushNotificationButtonInfoList = new ArrayList();
            if (this.mNotifiactionButtonInfoObject != null) {
                for (int i = 0; i < this.mNotifiactionButtonInfoObject.length(); i++) {
                    try {
                        this.mPushNotificationButtonInfoList.add(new PushNotificationButtonInfo(this.mNotifiactionButtonInfoObject.getJSONObject(i)));
                    } catch (Exception e) {
                        Logger.e(getClass().getSimpleName(), e.getMessage());
                    }
                }
            }
            this.mNotificationRedbadgeNumber = this.mBdPushObject.optInt("notification_red_badge_number", 0);
            this.mNotificationVideoUrl = this.mBdPushObject.optString("notification_video_url");
            this.flags = this.mBdPushObject.optInt(RouterConstants.QUERY_KEY_FLAGS, -1);
            JSONObject optJSONObject2 = this.mBdPushObject.optJSONObject("extras");
            this.mExtras = optJSONObject2;
            if (optJSONObject2 == null) {
                this.mExtras = new JSONObject();
            }
            this.mUseSound = this.mBdPushObject.optBoolean("use_sound", false);
            this.mUseVibration = this.mBdPushObject.optBoolean("use_vibration", false);
            this.mBrightScreen = this.mBdPushObject.optBoolean("bright_screen", false);
        } catch (Throwable unused) {
            this.mIsEmptyExtra = true;
        }
    }

    private int parseColor(JSONObject jSONObject, String str, int i) {
        try {
            String optString = jSONObject.optString(str);
            return !TextUtils.isEmpty(optString) ? Color.parseColor(optString) : i;
        } catch (Throwable unused) {
            return i;
        }
    }

    protected PushNotificationExtra(Parcel parcel) {
        this.mEnableNotificationHighLight = false;
        this.mNotificationColor = -1;
        this.mNotificationHeaderColor = 0;
        this.mNotificationTitleColor = 0;
        this.mNotificationContentColor = 0;
        this.mEnableSticky = false;
        this.mEnableOnTop = false;
        this.mOnTopTime = 2;
        this.mEnableBannerShow = false;
        this.mBannerType = 0;
        this.mEnableBannerHighLight = false;
        this.mBannerColor = -1;
        this.mBannerHeaderColor = 0;
        this.mBannerTitleColor = 0;
        this.mBannerContentColor = 0;
        this.mBannerShowDuration = 1.0d;
        this.mIsEmptyExtra = false;
        this.flags = -1;
        this.mBdPushStr = parcel.readString();
        try {
            this.mBdPushObject = new JSONObject(parcel.readString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.mEnableNotificationHighLight = parcel.readByte() != 0;
        this.mNotificationColor = parcel.readInt();
        this.mEnableSticky = parcel.readByte() != 0;
        this.mEnableOnTop = parcel.readByte() != 0;
        this.mOnTopTime = parcel.readInt();
        this.mEnableBannerShow = parcel.readByte() != 0;
        this.mEnableBannerHighLight = parcel.readByte() != 0;
        this.mBannerColor = parcel.readInt();
        this.mBannerShowDuration = parcel.readDouble();
        try {
            this.mExtras = new JSONObject(parcel.readString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.mUseSound = parcel.readByte() != 0;
        this.mUseVibration = parcel.readByte() != 0;
        this.mBrightScreen = parcel.readByte() != 0;
    }

    public boolean useSelfReminder() {
        return this.mUseSound || this.mUseVibration || this.mBrightScreen;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mBdPushStr);
        JSONObject jSONObject = this.mBdPushObject;
        parcel.writeString(jSONObject != null ? jSONObject.toString() : "");
        parcel.writeByte(this.mEnableNotificationHighLight ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mNotificationColor);
        parcel.writeByte(this.mEnableSticky ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mEnableOnTop ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mOnTopTime);
        parcel.writeByte(this.mEnableBannerShow ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mEnableBannerHighLight ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mBannerColor);
        parcel.writeDouble(this.mBannerShowDuration);
        JSONObject jSONObject2 = this.mExtras;
        parcel.writeString(jSONObject2 != null ? jSONObject2.toString() : "");
        parcel.writeByte(this.mUseSound ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mUseVibration ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mBrightScreen ? (byte) 1 : (byte) 0);
    }
}
