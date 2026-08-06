package com.lynx.animax.loader;

import android.net.Uri;
import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.loader.IAnimaXLoaderRequest;
import com.lynx.animax.util.UriUtil;
import java.util.Map;

/* loaded from: classes6.dex */
public class AnimaXLoaderRequest implements IAnimaXLoaderRequest {
    private static final String PARAMS_IMAGE_HEIGHT_KEY = "image_height";
    private static final String PARAMS_IMAGE_WIDTH_KEY = "image_width";
    private static final String PARAMS_SCHEME_KEY = "scheme";
    private final Map<String, Object> mParams;
    private final AnimaXLoaderScheme mScheme;
    private final String mUri;

    @Override // com.lynx.animax.loader.IAnimaXLoaderRequest
    public String getUri() {
        if (!isUriWithValidScheme(this.mUri)) {
            return createUriWithScheme(this.mUri, this.mScheme);
        }
        return this.mUri;
    }

    @Override // com.lynx.animax.loader.IAnimaXLoaderRequest
    public Map<String, Object> getParams() {
        return this.mParams;
    }

    public AnimaXLoaderRequest(String str, Map<String, Object> map) {
        this.mUri = str;
        this.mParams = map;
        if (map != null && map.get("scheme") != null) {
            this.mScheme = AnimaXLoaderScheme.values()[((Integer) map.get("scheme")).intValue()];
        } else {
            this.mScheme = null;
        }
    }

    static AnimaXLoaderRequest createRequestWithParams(String str, JavaOnlyMap javaOnlyMap) {
        return new AnimaXLoaderRequest(str, javaOnlyMap);
    }

    static AnimaXLoaderRequest createRequest(String str) {
        return new AnimaXLoaderRequest(str, null);
    }

    @Override // com.lynx.animax.loader.IAnimaXLoaderRequest
    public IAnimaXLoaderRequest.IImageInfo getImageInfo() {
        Map<String, Object> map = this.mParams;
        if (map == null) {
            return null;
        }
        final Object obj = map.get(PARAMS_IMAGE_WIDTH_KEY);
        final Object obj2 = this.mParams.get(PARAMS_IMAGE_HEIGHT_KEY);
        if ((obj instanceof Integer) && (obj2 instanceof Integer)) {
            return new IAnimaXLoaderRequest.IImageInfo() { // from class: com.lynx.animax.loader.AnimaXLoaderRequest.1
                @Override // com.lynx.animax.loader.IAnimaXLoaderRequest.IImageInfo
                public int getWidth() {
                    return ((Integer) obj).intValue();
                }

                @Override // com.lynx.animax.loader.IAnimaXLoaderRequest.IImageInfo
                public int getHeight() {
                    return ((Integer) obj2).intValue();
                }
            };
        }
        return null;
    }

    private static String createUriWithScheme(String str, AnimaXLoaderScheme animaXLoaderScheme) {
        if (animaXLoaderScheme == null) {
            return str;
        }
        if (animaXLoaderScheme == AnimaXLoaderScheme.ASSET) {
            return UriUtil.fromLocalAsset(str);
        }
        return animaXLoaderScheme == AnimaXLoaderScheme.FILE ? UriUtil.fromLocalFile(str) : str;
    }

    private static boolean isUriWithValidScheme(String str) {
        Uri safeParse = UriUtil.safeParse(str);
        return UriUtil.isLocalAssetUri(safeParse) || UriUtil.isLocalFileUri(safeParse) || UriUtil.isNetworkUri(safeParse);
    }
}
