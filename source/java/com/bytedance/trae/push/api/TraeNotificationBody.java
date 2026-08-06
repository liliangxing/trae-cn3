package com.bytedance.trae.push.api;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.forest.model.PreloadConfig;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: TraeNotificationBody.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\be\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010j\u001a\u00020\fHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010n\u001a\u00020\fHÆ\u0003J\t\u0010o\u001a\u00020\u0005HÆ\u0003J\t\u0010p\u001a\u00020\u0005HÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010s\u001a\u00020\fHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\t\u0010y\u001a\u00020\fHÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010{\u001a\u00020\fHÆ\u0003J\t\u0010|\u001a\u00020\u0005HÆ\u0003J\u009f\u0002\u0010}\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0016\u001a\u00020\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\u0005HÆ\u0001J\u0013\u0010~\u001a\u00020\u00052\b\u0010\u007f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0080\u0001\u001a\u00020\fHÖ\u0001J\n\u0010\u0081\u0001\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010=\"\u0004\bA\u0010?R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00107\"\u0004\bC\u00109R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010)\"\u0004\bE\u0010+R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010)\"\u0004\bG\u0010+R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010)\"\u0004\bI\u0010+R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010-\"\u0004\bK\u0010/R\u001a\u0010\u0016\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00107\"\u0004\bM\u00109R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010-\"\u0004\bS\u0010/R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010-\"\u0004\bU\u0010/R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010-\"\u0004\bW\u0010/R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001a\u0010\u001e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00107\"\u0004\b]\u00109R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010-\"\u0004\b_\u0010/R\u001a\u0010 \u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u00107\"\u0004\ba\u00109R\u001a\u0010!\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010)\"\u0004\bc\u0010+¨\u0006\u0082\u0001"}, d2 = {"Lcom/bytedance/trae/push/api/TraeNotificationBody;", "", "id", "", "showWhen", "", "title", "", "content", "groupId", RemoteMessageConst.Notification.CHANNEL_ID, "redBadgeNum", "", "imageUrl", "imageBitmap", "Landroid/graphics/Bitmap;", "iconBitmap", "imageType", "useLED", "useSound", "useVibrator", "androidGroup", "groupFoldNum", RemoteMessageConst.Notification.SOUND, "Landroid/net/Uri;", "bdPushStr", "appName", "openUrl", "eventExtra", "Lorg/json/JSONObject;", "channelImportance", "notificationCategory", "avatarDisplayMode", "forceSameWithIos", "<init>", "(JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;IZZZLjava/lang/String;ILandroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ILjava/lang/String;IZ)V", "getId", "()J", "setId", "(J)V", "getShowWhen", "()Z", "setShowWhen", "(Z)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getContent", "setContent", "getGroupId", "setGroupId", "getChannelId", "setChannelId", "getRedBadgeNum", "()I", "setRedBadgeNum", "(I)V", "getImageUrl", "setImageUrl", "getImageBitmap", "()Landroid/graphics/Bitmap;", "setImageBitmap", "(Landroid/graphics/Bitmap;)V", "getIconBitmap", "setIconBitmap", "getImageType", "setImageType", "getUseLED", "setUseLED", "getUseSound", "setUseSound", "getUseVibrator", "setUseVibrator", "getAndroidGroup", "setAndroidGroup", "getGroupFoldNum", "setGroupFoldNum", "getSound", "()Landroid/net/Uri;", "setSound", "(Landroid/net/Uri;)V", "getBdPushStr", "setBdPushStr", "getAppName", "setAppName", "getOpenUrl", "setOpenUrl", "getEventExtra", "()Lorg/json/JSONObject;", "setEventExtra", "(Lorg/json/JSONObject;)V", "getChannelImportance", "setChannelImportance", "getNotificationCategory", "setNotificationCategory", "getAvatarDisplayMode", "setAvatarDisplayMode", "getForceSameWithIos", "setForceSameWithIos", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TraeNotificationBody {
    private String androidGroup;
    private String appName;
    private int avatarDisplayMode;
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
    private String notificationCategory;
    private String openUrl;
    private int redBadgeNum;
    private boolean showWhen;
    private Uri sound;
    private String title;
    private boolean useLED;
    private boolean useSound;
    private boolean useVibrator;

    public TraeNotificationBody() {
        this(0L, false, null, null, null, null, 0, null, null, null, 0, false, false, false, null, 0, null, null, null, null, null, 0, null, 0, false, 33554431, null);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final Bitmap getIconBitmap() {
        return this.iconBitmap;
    }

    /* renamed from: component11, reason: from getter */
    public final int getImageType() {
        return this.imageType;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getUseLED() {
        return this.useLED;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getUseSound() {
        return this.useSound;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getUseVibrator() {
        return this.useVibrator;
    }

    /* renamed from: component15, reason: from getter */
    public final String getAndroidGroup() {
        return this.androidGroup;
    }

    /* renamed from: component16, reason: from getter */
    public final int getGroupFoldNum() {
        return this.groupFoldNum;
    }

    /* renamed from: component17, reason: from getter */
    public final Uri getSound() {
        return this.sound;
    }

    /* renamed from: component18, reason: from getter */
    public final String getBdPushStr() {
        return this.bdPushStr;
    }

    /* renamed from: component19, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getShowWhen() {
        return this.showWhen;
    }

    /* renamed from: component20, reason: from getter */
    public final String getOpenUrl() {
        return this.openUrl;
    }

    /* renamed from: component21, reason: from getter */
    public final JSONObject getEventExtra() {
        return this.eventExtra;
    }

    /* renamed from: component22, reason: from getter */
    public final int getChannelImportance() {
        return this.channelImportance;
    }

    /* renamed from: component23, reason: from getter */
    public final String getNotificationCategory() {
        return this.notificationCategory;
    }

    /* renamed from: component24, reason: from getter */
    public final int getAvatarDisplayMode() {
        return this.avatarDisplayMode;
    }

    /* renamed from: component25, reason: from getter */
    public final boolean getForceSameWithIos() {
        return this.forceSameWithIos;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component4, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component5, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: component7, reason: from getter */
    public final int getRedBadgeNum() {
        return this.redBadgeNum;
    }

    /* renamed from: component8, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component9, reason: from getter */
    public final Bitmap getImageBitmap() {
        return this.imageBitmap;
    }

    public final TraeNotificationBody copy(long id, boolean showWhen, String title, String content, String groupId, String channelId, int redBadgeNum, String imageUrl, Bitmap imageBitmap, Bitmap iconBitmap, int imageType, boolean useLED, boolean useSound, boolean useVibrator, String androidGroup, int groupFoldNum, Uri sound, String bdPushStr, String appName, String openUrl, JSONObject eventExtra, int channelImportance, String notificationCategory, int avatarDisplayMode, boolean forceSameWithIos) {
        return new TraeNotificationBody(id, showWhen, title, content, groupId, channelId, redBadgeNum, imageUrl, imageBitmap, iconBitmap, imageType, useLED, useSound, useVibrator, androidGroup, groupFoldNum, sound, bdPushStr, appName, openUrl, eventExtra, channelImportance, notificationCategory, avatarDisplayMode, forceSameWithIos);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraeNotificationBody)) {
            return false;
        }
        TraeNotificationBody traeNotificationBody = (TraeNotificationBody) other;
        return this.id == traeNotificationBody.id && this.showWhen == traeNotificationBody.showWhen && Intrinsics.areEqual(this.title, traeNotificationBody.title) && Intrinsics.areEqual(this.content, traeNotificationBody.content) && Intrinsics.areEqual(this.groupId, traeNotificationBody.groupId) && Intrinsics.areEqual(this.channelId, traeNotificationBody.channelId) && this.redBadgeNum == traeNotificationBody.redBadgeNum && Intrinsics.areEqual(this.imageUrl, traeNotificationBody.imageUrl) && Intrinsics.areEqual(this.imageBitmap, traeNotificationBody.imageBitmap) && Intrinsics.areEqual(this.iconBitmap, traeNotificationBody.iconBitmap) && this.imageType == traeNotificationBody.imageType && this.useLED == traeNotificationBody.useLED && this.useSound == traeNotificationBody.useSound && this.useVibrator == traeNotificationBody.useVibrator && Intrinsics.areEqual(this.androidGroup, traeNotificationBody.androidGroup) && this.groupFoldNum == traeNotificationBody.groupFoldNum && Intrinsics.areEqual(this.sound, traeNotificationBody.sound) && Intrinsics.areEqual(this.bdPushStr, traeNotificationBody.bdPushStr) && Intrinsics.areEqual(this.appName, traeNotificationBody.appName) && Intrinsics.areEqual(this.openUrl, traeNotificationBody.openUrl) && Intrinsics.areEqual(this.eventExtra, traeNotificationBody.eventExtra) && this.channelImportance == traeNotificationBody.channelImportance && Intrinsics.areEqual(this.notificationCategory, traeNotificationBody.notificationCategory) && this.avatarDisplayMode == traeNotificationBody.avatarDisplayMode && this.forceSameWithIos == traeNotificationBody.forceSameWithIos;
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.id) * 31) + Boolean.hashCode(this.showWhen)) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.content;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.groupId;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.channelId;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Integer.hashCode(this.redBadgeNum)) * 31;
        String str5 = this.imageUrl;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Bitmap bitmap = this.imageBitmap;
        int hashCode7 = (hashCode6 + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
        Bitmap bitmap2 = this.iconBitmap;
        int hashCode8 = (((((((((hashCode7 + (bitmap2 == null ? 0 : bitmap2.hashCode())) * 31) + Integer.hashCode(this.imageType)) * 31) + Boolean.hashCode(this.useLED)) * 31) + Boolean.hashCode(this.useSound)) * 31) + Boolean.hashCode(this.useVibrator)) * 31;
        String str6 = this.androidGroup;
        int hashCode9 = (((hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31) + Integer.hashCode(this.groupFoldNum)) * 31;
        Uri uri = this.sound;
        int hashCode10 = (hashCode9 + (uri == null ? 0 : uri.hashCode())) * 31;
        String str7 = this.bdPushStr;
        int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.appName;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.openUrl;
        int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        JSONObject jSONObject = this.eventExtra;
        int hashCode14 = (((hashCode13 + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31) + Integer.hashCode(this.channelImportance)) * 31;
        String str10 = this.notificationCategory;
        return ((((hashCode14 + (str10 != null ? str10.hashCode() : 0)) * 31) + Integer.hashCode(this.avatarDisplayMode)) * 31) + Boolean.hashCode(this.forceSameWithIos);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TraeNotificationBody(id=");
        sb.append(this.id).append(", showWhen=").append(this.showWhen).append(", title=").append(this.title).append(", content=").append(this.content).append(", groupId=").append(this.groupId).append(", channelId=").append(this.channelId).append(", redBadgeNum=").append(this.redBadgeNum).append(", imageUrl=").append(this.imageUrl).append(", imageBitmap=").append(this.imageBitmap).append(", iconBitmap=").append(this.iconBitmap).append(", imageType=").append(this.imageType).append(", useLED=");
        sb.append(this.useLED).append(", useSound=").append(this.useSound).append(", useVibrator=").append(this.useVibrator).append(", androidGroup=").append(this.androidGroup).append(", groupFoldNum=").append(this.groupFoldNum).append(", sound=").append(this.sound).append(", bdPushStr=").append(this.bdPushStr).append(", appName=").append(this.appName).append(", openUrl=").append(this.openUrl).append(", eventExtra=").append(this.eventExtra).append(", channelImportance=").append(this.channelImportance).append(", notificationCategory=").append(this.notificationCategory);
        sb.append(", avatarDisplayMode=").append(this.avatarDisplayMode).append(", forceSameWithIos=").append(this.forceSameWithIos).append(')');
        return sb.toString();
    }

    public TraeNotificationBody(long j, boolean z, String str, String str2, String str3, String str4, int i, String str5, Bitmap bitmap, Bitmap bitmap2, int i2, boolean z2, boolean z3, boolean z4, String str6, int i3, Uri uri, String str7, String str8, String str9, JSONObject jSONObject, int i4, String str10, int i5, boolean z5) {
        this.id = j;
        this.showWhen = z;
        this.title = str;
        this.content = str2;
        this.groupId = str3;
        this.channelId = str4;
        this.redBadgeNum = i;
        this.imageUrl = str5;
        this.imageBitmap = bitmap;
        this.iconBitmap = bitmap2;
        this.imageType = i2;
        this.useLED = z2;
        this.useSound = z3;
        this.useVibrator = z4;
        this.androidGroup = str6;
        this.groupFoldNum = i3;
        this.sound = uri;
        this.bdPushStr = str7;
        this.appName = str8;
        this.openUrl = str9;
        this.eventExtra = jSONObject;
        this.channelImportance = i4;
        this.notificationCategory = str10;
        this.avatarDisplayMode = i5;
        this.forceSameWithIos = z5;
    }

    public /* synthetic */ TraeNotificationBody(long j, boolean z, String str, String str2, String str3, String str4, int i, String str5, Bitmap bitmap, Bitmap bitmap2, int i2, boolean z2, boolean z3, boolean z4, String str6, int i3, Uri uri, String str7, String str8, String str9, JSONObject jSONObject, int i4, String str10, int i5, boolean z5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0L : j, (i6 & 2) != 0 ? false : z, (i6 & 4) != 0 ? null : str, (i6 & 8) != 0 ? null : str2, (i6 & 16) != 0 ? null : str3, (i6 & 32) != 0 ? null : str4, (i6 & 64) != 0 ? 0 : i, (i6 & 128) != 0 ? null : str5, (i6 & 256) != 0 ? null : bitmap, (i6 & 512) != 0 ? null : bitmap2, (i6 & 1024) != 0 ? 0 : i2, (i6 & 2048) != 0 ? false : z2, (i6 & 4096) != 0 ? false : z3, (i6 & 8192) != 0 ? false : z4, (i6 & 16384) != 0 ? null : str6, (i6 & 32768) != 0 ? 0 : i3, (i6 & 65536) != 0 ? null : uri, (i6 & 131072) != 0 ? null : str7, (i6 & 262144) != 0 ? null : str8, (i6 & 524288) != 0 ? null : str9, (i6 & 1048576) != 0 ? null : jSONObject, (i6 & 2097152) != 0 ? 0 : i4, (i6 & 4194304) != 0 ? null : str10, (i6 & 8388608) != 0 ? 0 : i5, (i6 & 16777216) != 0 ? false : z5);
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final boolean getShowWhen() {
        return this.showWhen;
    }

    public final void setShowWhen(boolean z) {
        this.showWhen = z;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(String str) {
        this.channelId = str;
    }

    public final int getRedBadgeNum() {
        return this.redBadgeNum;
    }

    public final void setRedBadgeNum(int i) {
        this.redBadgeNum = i;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final Bitmap getImageBitmap() {
        return this.imageBitmap;
    }

    public final void setImageBitmap(Bitmap bitmap) {
        this.imageBitmap = bitmap;
    }

    public final Bitmap getIconBitmap() {
        return this.iconBitmap;
    }

    public final void setIconBitmap(Bitmap bitmap) {
        this.iconBitmap = bitmap;
    }

    public final int getImageType() {
        return this.imageType;
    }

    public final void setImageType(int i) {
        this.imageType = i;
    }

    public final boolean getUseLED() {
        return this.useLED;
    }

    public final void setUseLED(boolean z) {
        this.useLED = z;
    }

    public final boolean getUseSound() {
        return this.useSound;
    }

    public final void setUseSound(boolean z) {
        this.useSound = z;
    }

    public final boolean getUseVibrator() {
        return this.useVibrator;
    }

    public final void setUseVibrator(boolean z) {
        this.useVibrator = z;
    }

    public final String getAndroidGroup() {
        return this.androidGroup;
    }

    public final void setAndroidGroup(String str) {
        this.androidGroup = str;
    }

    public final int getGroupFoldNum() {
        return this.groupFoldNum;
    }

    public final void setGroupFoldNum(int i) {
        this.groupFoldNum = i;
    }

    public final Uri getSound() {
        return this.sound;
    }

    public final void setSound(Uri uri) {
        this.sound = uri;
    }

    public final String getBdPushStr() {
        return this.bdPushStr;
    }

    public final void setBdPushStr(String str) {
        this.bdPushStr = str;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final void setAppName(String str) {
        this.appName = str;
    }

    public final String getOpenUrl() {
        return this.openUrl;
    }

    public final void setOpenUrl(String str) {
        this.openUrl = str;
    }

    public final JSONObject getEventExtra() {
        return this.eventExtra;
    }

    public final void setEventExtra(JSONObject jSONObject) {
        this.eventExtra = jSONObject;
    }

    public final int getChannelImportance() {
        return this.channelImportance;
    }

    public final void setChannelImportance(int i) {
        this.channelImportance = i;
    }

    public final String getNotificationCategory() {
        return this.notificationCategory;
    }

    public final void setNotificationCategory(String str) {
        this.notificationCategory = str;
    }

    public final int getAvatarDisplayMode() {
        return this.avatarDisplayMode;
    }

    public final void setAvatarDisplayMode(int i) {
        this.avatarDisplayMode = i;
    }

    public final boolean getForceSameWithIos() {
        return this.forceSameWithIos;
    }

    public final void setForceSameWithIos(boolean z) {
        this.forceSameWithIos = z;
    }
}
