package com.bytedance.push.settings.permission.boot;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class MiuiGifConfig {

    @SerializedName("checkbox_height_dp")
    public float checkBoxHeightDp;

    @SerializedName("checkbox_margin_end_dp")
    public float checkBoxMarginEndDp;

    @SerializedName("checkbox_margin_top_dp")
    public float checkBoxMarginTopDp;

    @SerializedName("checkbox_parent_color")
    public String checkBoxParentColor;

    @SerializedName("checkbox_parent_height")
    public float checkBoxParentHeight;

    @SerializedName("checkbox_vertical_padding_dp")
    public float checkBoxVerticalPaddingDp;

    @SerializedName("checkbox_width_dp")
    public float checkBoxWidthDp;

    public boolean isValid() {
        return this.checkBoxWidthDp >= 0.0f && this.checkBoxHeightDp >= 0.0f && this.checkBoxMarginEndDp >= 0.0f && this.checkBoxMarginTopDp >= 0.0f && this.checkBoxVerticalPaddingDp >= 0.0f;
    }
}
