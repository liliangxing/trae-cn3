package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class MixObject implements IMediaObject {
    public boolean isImageAlbum;
    public ArrayList<String> mMediaPaths = new ArrayList<>();

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putStringArrayList(ParamKeyConstants.AWEME_EXTRA_MEDIA_MESSAGE_MIX_PATH, this.mMediaPaths);
        bundle.putString(ParamKeyConstants.ShareParams.SHARE_IMAGE_ALBUM, String.valueOf(this.isImageAlbum));
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public int type() {
        return 6;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void unserialize(Bundle bundle) {
        this.mMediaPaths.clear();
        ArrayList<String> stringArrayList = bundle.getStringArrayList(ParamKeyConstants.AWEME_EXTRA_MEDIA_MESSAGE_MIX_PATH);
        if (stringArrayList != null) {
            this.mMediaPaths = stringArrayList;
        }
        this.isImageAlbum = Boolean.parseBoolean(bundle.getString(ParamKeyConstants.ShareParams.SHARE_IMAGE_ALBUM));
    }
}
