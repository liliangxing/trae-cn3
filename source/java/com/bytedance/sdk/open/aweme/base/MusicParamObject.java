package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* loaded from: classes5.dex */
public class MusicParamObject {
    public String musicId = "";
    public int start = 0;

    public static MusicParamObject unSerialize(Bundle bundle) {
        MusicParamObject musicParamObject = new MusicParamObject();
        musicParamObject.musicId = bundle.getString(ParamKeyConstants.ShareParams.SHARE_MUSIC_ID, "");
        musicParamObject.start = bundle.getInt(ParamKeyConstants.ShareParams.SHARE_MUSIC_START, 0);
        return musicParamObject;
    }

    public void serialize(Bundle bundle) {
        bundle.putString(ParamKeyConstants.ShareParams.SHARE_MUSIC_ID, this.musicId);
        bundle.putInt(ParamKeyConstants.ShareParams.SHARE_MUSIC_START, this.start);
    }
}
