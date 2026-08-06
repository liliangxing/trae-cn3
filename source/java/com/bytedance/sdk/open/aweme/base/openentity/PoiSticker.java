package com.bytedance.sdk.open.aweme.base.openentity;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class PoiSticker extends Sticker {

    @SerializedName("poi_id")
    public String poiId;

    @Override // com.bytedance.sdk.open.aweme.base.openentity.BaseSticker
    public final int getType() {
        return 4;
    }
}
