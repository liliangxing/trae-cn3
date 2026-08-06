package com.bytedance.sdk.open.aweme.base.openentity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class HashtagSticker extends Sticker {

    @SerializedName("name")
    public String name;

    @Override // com.bytedance.sdk.open.aweme.base.openentity.BaseSticker
    public boolean checkArg() {
        return !TextUtils.isEmpty(this.name);
    }

    @Override // com.bytedance.sdk.open.aweme.base.openentity.BaseSticker
    public final int getType() {
        return 1;
    }
}
