package com.bytedance.sdk.open.aweme.base.openentity;

import com.google.gson.annotations.SerializedName;
import com.lynx.tasm.behavior.PropsConstants;

/* loaded from: classes5.dex */
public abstract class BaseSticker {
    public static final int CUSTOM_STICKER_TYPE = 3;
    public static final int HASHTAG_STICKER_TYPE = 1;
    public static final int MENTION_STICKER_TYPE = 2;
    public static final int POI_STICKER_TYPE = 4;
    public static final int QUICK_FLASH_STICKER_TYPE = 5;

    @SerializedName("layer_weight")
    public int layerWeight = 0;

    @SerializedName("normalized_size_x")
    public float normalizedSizeX = -1.0f;

    @SerializedName("normalized_size_y")
    public float normalizedSizeY = -1.0f;

    @SerializedName("scale")
    public float scale = 1.0f;

    @SerializedName(PropsConstants.ROTATE)
    public float rotate = 0.0f;

    @SerializedName("offset_x")
    public float offsetX = 0.5f;

    @SerializedName("offset_y")
    public float offsetY = 0.5f;

    public boolean checkArg() {
        return true;
    }

    public abstract int getType();
}
