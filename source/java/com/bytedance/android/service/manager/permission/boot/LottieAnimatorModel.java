package com.bytedance.android.service.manager.permission.boot;

import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public class LottieAnimatorModel {

    @SerializedName("animator_height")
    public int height;

    @SerializedName("image_height")
    public int imageHeight;

    @SerializedName("image_offset_x")
    public int imageOffsetX;

    @SerializedName("image_offset_y")
    public int imageOffsetY;

    @SerializedName(LynxMonitorService.KEY_IMAGE_URL)
    public String imageUrl;

    @SerializedName("image_width")
    public int imageWidth;

    @SerializedName("is_need_mask")
    public boolean isNeedMask;

    @SerializedName("mask_color")
    public String maskColor;

    @SerializedName("animator_offset_x")
    public int offsetX;

    @SerializedName("animator_offset_y")
    public int offsetY;

    @SerializedName("animator_repeat_count")
    public int repeatCount = -1;

    @SerializedName("animator_url")
    public String url;

    @SerializedName("virtual_width")
    public int virtualWidth;

    @SerializedName("animator_width")
    public int width;
}
