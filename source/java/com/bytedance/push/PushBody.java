package com.bytedance.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.push.utils.Logger;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.pushmanager.MessageConstants;
import com.ss.android.pushmanager.PushCommonConstants;
import com.ss.android.socialbase.downloader.segment.Segment;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class PushBody implements Parcelable {
    public static final Parcelable.Creator<PushBody> CREATOR = new Parcelable.Creator<PushBody>() { // from class: com.bytedance.push.PushBody.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PushBody createFromParcel(Parcel parcel) {
            return new PushBody(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PushBody[] newArray(int i) {
            return new PushBody[i];
        }
    };
    public static final String KEY_PASS_THROUGH = "pass_through";
    public static final int TYPE_IMAGE_BIG = 1;
    public static final int TYPE_IMAGE_NONE = 0;
    public static final int TYPE_IMAGE_SMALL = 2;
    public boolean allowInterceptInBlackTimeWindow;
    public String androidGroup;
    private int avatarDisplayMode;
    public int badge;
    public String businessType;
    public boolean callbackArrive;
    public boolean callbackClick;
    public int clientIntelligencePushShowMode;
    public int clientIntelligencePushShowSubMode;
    public long delayShowIntervalInSecond;
    public JSONObject eventExtra;
    public String extra;
    private boolean forceSameWithIos;
    public int groupFoldNum;
    public final String groupId;
    public long id;
    public int imageType;
    public String imageUrl;
    public String mBdPushStr;
    public int mChannelImportance;
    public boolean mIsPassThough;
    public String mNotificationCategory;
    public String mNotificationChannelId;
    public long messageExpiredTime;
    public int messageType;
    public int minDisplayIntervalFromForeground;
    public int minDisplayIntervalFromLastMsg;
    public JSONObject msgData;
    public final boolean needFilterMsgByUid;
    public String open_url;
    public int pushShowType;
    public long revokeId;
    public long rid64;
    public final boolean showWhen;
    public String sign;
    public final String targetSecUid;
    public String text;
    public String title;
    public boolean useClientIntelligenceShow;
    public boolean useLED;
    public boolean useSound;
    public boolean useVibrator;
    public String voipParams;

    /* loaded from: classes4.dex */
    public @interface ImageType {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PushBody(JSONObject jSONObject) {
        this.msgData = jSONObject;
        this.open_url = jSONObject.optString(MessageConstants.BUNDLE_OPEN_URL);
        this.text = jSONObject.optString("text");
        this.title = jSONObject.optString("title");
        this.imageUrl = jSONObject.optString(LynxMonitorService.KEY_IMAGE_URL);
        this.id = jSONObject.optLong("id", 0L);
        this.rid64 = jSONObject.optLong(PushCommonConstants.KEY_RID64, 0L);
        this.useLED = optBoolean(jSONObject, "use_led", false);
        this.useSound = optBoolean(jSONObject, RemoteMessageConst.Notification.SOUND, false);
        this.useVibrator = optBoolean(jSONObject, "use_vibrator", false);
        this.imageType = jSONObject.optInt(FrescoMonitorConst.IMAGE_TYPE, 0);
        this.avatarDisplayMode = jSONObject.optInt("avatar_display_mode", 0);
        this.forceSameWithIos = jSONObject.optBoolean("force_same_with_ios");
        this.mIsPassThough = jSONObject.optInt(KEY_PASS_THROUGH, 1) > 0;
        this.mNotificationChannelId = jSONObject.optString("notify_channel");
        this.messageType = jSONObject.optInt(MessageConstants.MSG_FROM);
        this.groupId = jSONObject.optString("group_id_str");
        this.showWhen = jSONObject.optInt(Segment.JsonKey.START, 1) > 0;
        this.targetSecUid = jSONObject.optString(PushCommonConstants.KEY_TARGET_SEC_UID);
        this.needFilterMsgByUid = jSONObject.optInt("ttpush_need_filter_uid", 0) > 0;
        this.revokeId = jSONObject.optLong("revoke_id");
        this.extra = jSONObject.optString("extra_str");
        this.mBdPushStr = jSONObject.optString("bdpush_str");
        this.sign = jSONObject.optString(TicketGuardProviderKt.PATH_SIGN);
        this.eventExtra = jSONObject.optJSONObject(PushCommonConstants.KEY_TTPUSH_EVENT_EXTRA);
        this.pushShowType = jSONObject.optInt(PushCommonConstants.KEY_PUSH_SHOW_TYPE, 0);
        this.businessType = jSONObject.optString("business_type", "");
        this.badge = jSONObject.optInt(IAllianceService.CONTENT_TYPE_BADGE);
        this.pushShowType = jSONObject.optInt(PushCommonConstants.KEY_PUSH_SHOW_TYPE, 0);
        this.businessType = jSONObject.optString("business_type", "");
        this.voipParams = jSONObject.optString("voip_params", "");
        this.androidGroup = jSONObject.optString("android_group", "");
        this.groupFoldNum = jSONObject.optInt("group_fold_num", 3);
        this.useClientIntelligenceShow = jSONObject.optBoolean("client_intelligent");
        long optLong = jSONObject.optLong("message_expire_time", -1L);
        this.messageExpiredTime = optLong;
        if (optLong == -1) {
            this.messageExpiredTime = jSONObject.optLong("expire_time", -1L);
        }
        this.clientIntelligencePushShowMode = jSONObject.optInt("client_intelligence_push_show_mode", 1);
        this.clientIntelligencePushShowSubMode = jSONObject.optInt("client_intelligence_push_show_sub_mode", 0);
        this.allowInterceptInBlackTimeWindow = jSONObject.optBoolean("allow_intercept_in_black_time_window", true);
        this.mNotificationCategory = jSONObject.optString("category", "");
        this.mChannelImportance = jSONObject.optInt("importance", -1);
        long j = this.messageExpiredTime;
        if (j == -1) {
            Logger.w("PushBody", "expiredTime is None so force set useClientIntelligenceShow and allowInterceptInBlackTimeWindow to false");
            this.useClientIntelligenceShow = false;
            this.allowInterceptInBlackTimeWindow = false;
        } else {
            this.messageExpiredTime = j * 1000;
        }
        if (PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIsDebugMode && !TextUtils.isEmpty(this.extra)) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.extra);
                if (TextUtils.isEmpty(this.androidGroup)) {
                    this.androidGroup = jSONObject2.optString("android_group");
                }
                int optInt = jSONObject2.optInt(FrescoMonitorConst.IMAGE_TYPE, -1);
                if (optInt > 0) {
                    this.imageType = optInt;
                }
                if (jSONObject2.optBoolean("force_same_with_ios", false)) {
                    this.forceSameWithIos = true;
                }
                int optInt2 = jSONObject2.optInt("avatar_display_mode", -1);
                if (optInt2 > 0) {
                    this.avatarDisplayMode = optInt2;
                }
                if (jSONObject2.optBoolean("client_intelligent", false)) {
                    this.useClientIntelligenceShow = true;
                    this.messageExpiredTime = System.currentTimeMillis() + 28800000;
                }
                int optInt3 = jSONObject2.optInt("client_intelligence_push_show_mode", -1);
                if (optInt3 > -1) {
                    this.clientIntelligencePushShowMode = optInt3;
                }
                int optInt4 = jSONObject2.optInt("client_intelligence_push_show_sub_mode", -1);
                if (optInt4 > -1) {
                    this.clientIntelligencePushShowSubMode = optInt4;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.minDisplayIntervalFromLastMsg = jSONObject.optInt("min_display_interval_from_last_msg", -1);
        this.minDisplayIntervalFromForeground = jSONObject.optInt("min_display_interval_from_foreground", -1);
        this.callbackArrive = jSONObject.optBoolean("additional_arrive_callback", false);
        this.callbackClick = jSONObject.optBoolean("additional_click_callback", false);
        this.delayShowIntervalInSecond = jSONObject.optLong("delay_show_interval_in_second", 0L);
    }

    private static boolean optBoolean(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || jSONObject.isNull(str)) {
            return z;
        }
        int optInt = jSONObject.optInt(str, -1);
        if (optInt >= 1) {
            return true;
        }
        if (optInt == 0) {
            return false;
        }
        return jSONObject.optBoolean(str, z);
    }

    public String getNotificationChannel() {
        return this.mNotificationChannelId;
    }

    public String getOriginData() {
        JSONObject jSONObject = this.msgData;
        if (jSONObject != null) {
            return jSONObject.toString();
        }
        return null;
    }

    public String getExtra() {
        return this.extra;
    }

    public boolean checkValid() {
        return (this.id <= 0 || TextUtils.isEmpty(this.open_url) || TextUtils.isEmpty(this.groupId)) ? false : true;
    }

    public String toString() {
        return "PushBody{groupId='" + this.groupId + "', extra='" + this.extra + "', mNotificationChannelId='" + this.mNotificationChannelId + "', mIsPassThough=" + this.mIsPassThough + ", msgData=" + this.msgData + ", text='" + this.text + "', title='" + this.title + "', imageUrl='" + this.imageUrl + "', imageType=" + this.imageType + ", id=" + this.id + ", open_url='" + this.open_url + "', useLED=" + this.useLED + ", useSound=" + this.useSound + ", useVibrator=" + this.useVibrator + ", messageType=" + this.messageType + ", androidGroup=" + this.androidGroup + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeLong(this.rid64);
        parcel.writeString(this.groupId);
        parcel.writeByte(this.showWhen ? (byte) 1 : (byte) 0);
        parcel.writeString(this.targetSecUid);
        parcel.writeByte(this.needFilterMsgByUid ? (byte) 1 : (byte) 0);
        parcel.writeString(this.extra);
        parcel.writeString(this.mBdPushStr);
        parcel.writeString(this.mNotificationChannelId);
        parcel.writeByte(this.mIsPassThough ? (byte) 1 : (byte) 0);
        parcel.writeString(this.msgData.toString());
        parcel.writeString(this.text);
        parcel.writeString(this.title);
        parcel.writeString(this.imageUrl);
        parcel.writeInt(this.imageType);
        parcel.writeString(this.open_url);
        parcel.writeByte(this.useLED ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.useSound ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.useVibrator ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.messageType);
        parcel.writeLong(this.revokeId);
        parcel.writeString(this.sign);
        parcel.writeByte(this.forceSameWithIos ? (byte) 1 : (byte) 0);
        JSONObject jSONObject = this.eventExtra;
        parcel.writeString(jSONObject == null ? "" : jSONObject.toString());
    }

    protected PushBody(Parcel parcel) {
        this.id = parcel.readLong();
        this.rid64 = parcel.readLong();
        this.groupId = parcel.readString();
        this.showWhen = parcel.readByte() != 0;
        this.targetSecUid = parcel.readString();
        this.needFilterMsgByUid = parcel.readByte() != 0;
        this.extra = parcel.readString();
        this.mBdPushStr = parcel.readString();
        this.mNotificationChannelId = parcel.readString();
        this.mIsPassThough = parcel.readByte() != 0;
        try {
            this.msgData = new JSONObject(parcel.readString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.text = parcel.readString();
        this.title = parcel.readString();
        this.imageUrl = parcel.readString();
        this.imageType = parcel.readInt();
        this.open_url = parcel.readString();
        this.useLED = parcel.readByte() != 0;
        this.useSound = parcel.readByte() != 0;
        this.useVibrator = parcel.readByte() != 0;
        this.messageType = parcel.readInt();
        this.revokeId = parcel.readLong();
        this.sign = parcel.readString();
        this.forceSameWithIos = parcel.readByte() != 0;
        try {
            this.eventExtra = new JSONObject(parcel.readString());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public int getProxyOriginAPP() {
        JSONObject optJSONObject;
        JSONObject jSONObject = this.msgData;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("proxy_notification_info")) == null) {
            return -1;
        }
        return optJSONObject.optInt(PushCommonConstants.KEY_ORIGIN_APP, -1);
    }

    public int getProxyTargetAPP() {
        JSONObject optJSONObject;
        JSONObject jSONObject = this.msgData;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("proxy_notification_info")) == null) {
            return -1;
        }
        return optJSONObject.optInt(PushCommonConstants.KEY_TARGET_APP, -1);
    }

    public int getProxySender() {
        JSONObject optJSONObject;
        JSONObject jSONObject = this.msgData;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("proxy_notification_info")) == null) {
            return -1;
        }
        return optJSONObject.optInt("sender", -1);
    }

    public NotificationBody convertToNotificationBody() {
        return new NotificationBody.Builder().msgData(this.msgData).id(this.id).showWhen(this.showWhen).title(this.title).content(this.text).groupId(this.groupId).channelId(this.mNotificationChannelId).redBadgeNum(this.badge).imageUrl(this.imageUrl).imageType(this.imageType).useLED(this.useLED).useSound(this.useSound).useVibrator(this.useVibrator).androidGroup(this.androidGroup).groupFoldNum(this.groupFoldNum).setBdPushStr(this.mBdPushStr).setOpenUrl(this.open_url).setEventExtra(this.eventExtra).setChannelImportance(this.mChannelImportance).setNotificationCategory(this.mNotificationCategory).setAvatarDisplayMode(this.avatarDisplayMode).setForceSameWithIos(this.forceSameWithIos).build();
    }
}
