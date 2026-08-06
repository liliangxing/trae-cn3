package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* loaded from: classes5.dex */
public class AwemeObject implements IMediaObject {
    public String videoId;

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString(ParamKeyConstants.ShareParams.SHARE_AWEME_VIDEO_ID, this.videoId);
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public int type() {
        return 8;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void unserialize(Bundle bundle) {
        this.videoId = bundle.getString(ParamKeyConstants.ShareParams.SHARE_AWEME_VIDEO_ID);
    }
}
