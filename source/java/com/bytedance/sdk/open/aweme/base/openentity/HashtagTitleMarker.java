package com.bytedance.sdk.open.aweme.base.openentity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class HashtagTitleMarker extends PublishTitleMarker {

    @SerializedName("name")
    public String name;

    @Override // com.bytedance.sdk.open.aweme.base.openentity.PublishTitleMarker
    public boolean checkArgs() {
        return !TextUtils.isEmpty(this.name);
    }
}
