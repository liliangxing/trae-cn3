package com.bytedance.sdk.open.aweme.base.openentity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class QuickFlashSticker extends Sticker {

    @SerializedName("sticker_id")
    public String stickerId;

    @SerializedName("text_info")
    public String textInfo;

    @Override // com.bytedance.sdk.open.aweme.base.openentity.BaseSticker
    public boolean checkArg() {
        return super.checkArg() && !TextUtils.isEmpty(this.textInfo);
    }

    @Override // com.bytedance.sdk.open.aweme.base.openentity.BaseSticker
    public int getType() {
        return 5;
    }
}
