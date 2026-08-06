package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* loaded from: classes5.dex */
public class MusicObject implements IMediaObject {
    private static final String TAG = "ImageObject";
    public String mMusicId;

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString(ParamKeyConstants.AWEME_EXTRA_LUNA_MUSIC_ID, this.mMusicId);
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public int type() {
        return 7;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void unserialize(Bundle bundle) {
        this.mMusicId = bundle.getString(ParamKeyConstants.AWEME_EXTRA_LUNA_MUSIC_ID);
    }
}
