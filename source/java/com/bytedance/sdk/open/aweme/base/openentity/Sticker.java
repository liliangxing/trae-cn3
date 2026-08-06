package com.bytedance.sdk.open.aweme.base.openentity;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public abstract class Sticker extends BaseSticker {

    @SerializedName("deletable")
    public boolean deletable = true;

    @SerializedName("interactive")
    public boolean interactive = true;
}
