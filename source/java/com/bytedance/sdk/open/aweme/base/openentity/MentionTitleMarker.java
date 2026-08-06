package com.bytedance.sdk.open.aweme.base.openentity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class MentionTitleMarker extends PublishTitleMarker {

    @SerializedName("open_id")
    public String openId;

    @Override // com.bytedance.sdk.open.aweme.base.openentity.PublishTitleMarker
    public boolean checkArgs() {
        return !TextUtils.isEmpty(this.openId);
    }
}
