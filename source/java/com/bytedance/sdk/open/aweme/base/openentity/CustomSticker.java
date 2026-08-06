package com.bytedance.sdk.open.aweme.base.openentity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class CustomSticker extends Sticker {

    @SerializedName("path")
    public String path;

    @SerializedName("start_time")
    public int startTime = 0;

    @SerializedName("end_time")
    public int endTime = 0;

    @Override // com.bytedance.sdk.open.aweme.base.openentity.BaseSticker
    public boolean checkArg() {
        return !TextUtils.isEmpty(this.path);
    }

    @Override // com.bytedance.sdk.open.aweme.base.openentity.BaseSticker
    public final int getType() {
        return 3;
    }
}
