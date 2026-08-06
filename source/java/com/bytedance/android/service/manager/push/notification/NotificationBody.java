package com.bytedance.android.service.manager.push.notification;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.service.manager.R;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.utils.Logger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NotificationBody {
    public static final int AVATAR_DISPLAY_MODE_NOT_SHOW_HEADER = 0;
    public static final int AVATAR_DISPLAY_MODE_SHOW_HEADER = 1;
    public static final int TYPE_GIF = 8;
    public static final int TYPE_IMAGE_BIG = 1;
    public static final int TYPE_IMAGE_NONE = 0;
    public static final int TYPE_IMAGE_SMALL = 2;
    public static final int TYPE_PERSON = 7;
    public String androidGroup;
    public String appName;
    public int avatarDisplayMode;
    public String bdPushStr;
    public String channelId;
    public int channelImportance;
    public String content;
    public JSONObject eventExtra;
    public boolean forceSameWithIos;
    public int groupFoldNum;
    public String groupId;
    public Bitmap iconBitmap;
    public long id;
    public Bitmap imageBitmap;
    public int imageType;
    public String imageUrl;
    public JSONObject msgData;
    public String notificationCategory;
    public String openUrl;
    public int redBadgeNum;
    public boolean showWhen;
    public Uri sound;
    public String title;
    public boolean useLED;
    public boolean useSound;
    public boolean useVibrator;

    /* loaded from: classes3.dex */
    public @interface ImageType {
    }

    public NotificationBody(Builder builder) {
        this.avatarDisplayMode = 0;
        this.forceSameWithIos = false;
        this.msgData = builder.msgData;
        this.id = builder.id;
        this.showWhen = builder.showWhen;
        this.title = builder.title;
        this.content = builder.content;
        this.groupId = builder.groupId;
        this.channelId = builder.channelId;
        this.redBadgeNum = builder.redBadgeNum;
        this.imageUrl = builder.imageUrl;
        this.imageBitmap = builder.imageBitmap;
        this.imageType = builder.imageType;
        this.useLED = builder.useLED;
        this.useSound = builder.useSound;
        this.useVibrator = builder.useVibrator;
        this.androidGroup = builder.androidGroup;
        this.groupFoldNum = builder.groupFoldNum;
        this.sound = builder.sound;
        this.bdPushStr = builder.bdPushStr;
        this.iconBitmap = builder.iconBitmap;
        this.appName = builder.appName;
        this.openUrl = builder.openUrl;
        this.eventExtra = builder.eventExtra;
        this.channelImportance = builder.channelImportance;
        this.notificationCategory = builder.notificationCategory;
        this.avatarDisplayMode = builder.avatarDisplayMode;
        this.forceSameWithIos = builder.forceSameWithIos;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private String androidGroup;
        private String appName;
        private int avatarDisplayMode = 0;
        private String bdPushStr;
        private String channelId;
        private int channelImportance;
        private String content;
        private JSONObject eventExtra;
        private boolean forceSameWithIos;
        private int groupFoldNum;
        private String groupId;
        private Bitmap iconBitmap;
        private long id;
        private Bitmap imageBitmap;
        private int imageType;
        private String imageUrl;
        private JSONObject msgData;
        private String notificationCategory;
        private String openUrl;
        private int redBadgeNum;
        private boolean showWhen;
        private Uri sound;
        private String title;
        private boolean useLED;
        private boolean useSound;
        private boolean useVibrator;

        public Builder msgData(JSONObject jSONObject) {
            this.msgData = jSONObject;
            return this;
        }

        public Builder id(long j) {
            this.id = j;
            return this;
        }

        public Builder showWhen(boolean z) {
            this.showWhen = z;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder content(String str) {
            this.content = str;
            return this;
        }

        public Builder groupId(String str) {
            this.groupId = str;
            return this;
        }

        public Builder channelId(String str) {
            this.channelId = str;
            return this;
        }

        public Builder redBadgeNum(int i) {
            this.redBadgeNum = i;
            return this;
        }

        public Builder imageType(int i) {
            this.imageType = i;
            return this;
        }

        public Builder imageUrl(String str) {
            this.imageUrl = str;
            return this;
        }

        public Builder useLED(boolean z) {
            this.useLED = z;
            return this;
        }

        public Builder useSound(boolean z) {
            this.useSound = z;
            return this;
        }

        public Builder useVibrator(boolean z) {
            this.useVibrator = z;
            return this;
        }

        public Builder androidGroup(String str) {
            this.androidGroup = str;
            return this;
        }

        public Builder groupFoldNum(int i) {
            this.groupFoldNum = i;
            return this;
        }

        public Builder setImageBitmap(Bitmap bitmap) {
            this.imageBitmap = bitmap;
            return this;
        }

        public Builder setSound(Uri uri) {
            this.sound = uri;
            return this;
        }

        public Builder setBdPushStr(String str) {
            this.bdPushStr = str;
            return this;
        }

        public Builder setIconBitmap(Bitmap bitmap) {
            this.iconBitmap = bitmap;
            return this;
        }

        public Builder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public Builder setOpenUrl(String str) {
            this.openUrl = str;
            return this;
        }

        public Builder setEventExtra(JSONObject jSONObject) {
            this.eventExtra = jSONObject;
            return this;
        }

        public Builder setChannelImportance(int i) {
            this.channelImportance = i;
            return this;
        }

        public Builder setNotificationCategory(String str) {
            this.notificationCategory = str;
            return this;
        }

        public Builder setAvatarDisplayMode(int i) {
            this.avatarDisplayMode = i;
            return this;
        }

        public Builder setForceSameWithIos(boolean z) {
            this.forceSameWithIos = z;
            return this;
        }

        public NotificationBody build() {
            if (this.imageType != 0 && TextUtils.isEmpty(this.imageUrl) && this.imageBitmap == null) {
                this.imageType = 0;
            }
            if (this.iconBitmap == null) {
                PushCommonConfiguration pushCommonConfiguration = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
                try {
                    Logger.d("NotificationBody", "try use host icon_bitmap iconBitmap");
                    this.iconBitmap = BitmapFactory.decodeResource(pushCommonConfiguration.mApplication.getResources(), pushCommonConfiguration.mIPushCommonConfiguration.getAppIconResId());
                } catch (Throwable th) {
                    Logger.e("NotificationBody", "error when parse status_icon ", th);
                }
                try {
                    if (this.iconBitmap == null) {
                        Logger.d("NotificationBody", "try use R.drawable.status_icon as  iconBitmap");
                        this.iconBitmap = BitmapFactory.decodeResource(pushCommonConfiguration.mApplication.getResources(), R.drawable.status_icon);
                    }
                } catch (Throwable th2) {
                    Logger.e("NotificationBody", "error when parse status_icon ", th2);
                }
            }
            return new NotificationBody(this);
        }
    }
}
