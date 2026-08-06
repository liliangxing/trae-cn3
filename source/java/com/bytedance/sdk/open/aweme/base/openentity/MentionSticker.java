package com.bytedance.sdk.open.aweme.base.openentity;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class MentionSticker extends Sticker {

    @SerializedName("open_id")
    public String openId;

    @Override // com.bytedance.sdk.open.aweme.base.openentity.BaseSticker
    public final int getType() {
        return 2;
    }
}
