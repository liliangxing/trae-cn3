package com.lynx.tasm.p001ui.image.fresco;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.react.bridge.ReadableMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxNetworkImageRequest extends ImageRequest {
    private final ReadableMap mHeaders;

    public static LynxNetworkImageRequest fromBuilderWithHeaders(ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap) {
        return new LynxNetworkImageRequest(imageRequestBuilder, readableMap);
    }

    protected LynxNetworkImageRequest(ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap) {
        super(imageRequestBuilder);
        this.mHeaders = readableMap;
    }

    public ReadableMap getHeaders() {
        return this.mHeaders;
    }
}
