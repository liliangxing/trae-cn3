package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class ImageAlbumObject extends ImageObject {
    private boolean isImageAlbum;

    public ImageAlbumObject() {
    }

    public ImageAlbumObject(ArrayList<String> arrayList) {
        super(arrayList);
    }

    public ImageAlbumObject(ArrayList<String> arrayList, boolean z) {
        this(arrayList);
        this.isImageAlbum = z;
    }

    public final boolean isImageAlbum() {
        return this.isImageAlbum;
    }

    @Override // com.bytedance.sdk.open.aweme.base.ImageObject, com.bytedance.sdk.open.aweme.base.IMediaObject
    public void serialize(Bundle bundle) {
        super.serialize(bundle);
        bundle.putString(ParamKeyConstants.ShareParams.SHARE_IMAGE_ALBUM, String.valueOf(this.isImageAlbum));
    }

    public final void setImageAlbum(boolean z) {
        this.isImageAlbum = z;
    }

    @Override // com.bytedance.sdk.open.aweme.base.ImageObject, com.bytedance.sdk.open.aweme.base.IMediaObject
    public void unserialize(Bundle bundle) {
        super.unserialize(bundle);
        this.isImageAlbum = Boolean.parseBoolean(bundle.getString(ParamKeyConstants.ShareParams.SHARE_IMAGE_ALBUM));
    }
}
