package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class MediaContent {
    private static final String TAG = "AWEME.SDK.MediaContent";
    public IMediaObject mMediaObject;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class Builder {
        public static final String KEY_IDENTIFIER = "_dyobject_identifier_";

        public static MediaContent fromBundle(Bundle bundle) {
            MediaContent mediaContent = new MediaContent();
            int i = bundle.getInt(ParamKeyConstants.BaseParams.MEDIA_CONTENT_TYPE);
            IMediaObject imageObject = i == 2 ? new ImageObject() : i == 3 ? new VideoObject() : i == 6 ? new MixObject() : i == 7 ? new MusicObject() : i == 8 ? new AwemeObject() : i == 9 ? new MicroAppObject() : null;
            if (imageObject != null) {
                imageObject.unserialize(bundle);
            }
            mediaContent.mMediaObject = imageObject;
            return mediaContent;
        }

        public static Bundle toBundle(MediaContent mediaContent) {
            Bundle bundle = new Bundle();
            if (mediaContent.mMediaObject != null) {
                bundle.putInt(ParamKeyConstants.BaseParams.MEDIA_CONTENT_TYPE, mediaContent.getType());
                bundle.putInt(ParamKeyConstants.BaseParams.MEDIA_CONTENT_VERSION, 2);
                mediaContent.mMediaObject.serialize(bundle);
            }
            return bundle;
        }
    }

    public MediaContent() {
    }

    public MediaContent(IMediaObject iMediaObject) {
        this.mMediaObject = iMediaObject;
    }

    public final boolean checkArgs() {
        return this.mMediaObject.checkArgs();
    }

    public final int getType() {
        IMediaObject iMediaObject = this.mMediaObject;
        if (iMediaObject == null) {
            return 0;
        }
        return iMediaObject.type();
    }
}
