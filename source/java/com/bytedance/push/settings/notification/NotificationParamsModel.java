package com.bytedance.push.settings.notification;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class NotificationParamsModel {

    @SerializedName("notification_gif_enable_expansion")
    public boolean notificationGifEnableExpansion;

    @SerializedName("notification_gif_frame_interval")
    public int notificationGifFrameInterval;

    @SerializedName("notification_gif_max_bytes")
    public int notificationGifMaxBytes;

    @SerializedName("notification_gif_max_pixel_size")
    public int notificationGifMaxPixelSize;

    @SerializedName("notification_gif_position")
    public String notificationGifPosition;

    @SerializedName("notification_red_badge_color")
    public String notificationRedBadgeColor;
}
