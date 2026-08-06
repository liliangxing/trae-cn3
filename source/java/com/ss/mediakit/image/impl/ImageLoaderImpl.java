package com.ss.mediakit.image.impl;

import android.net.Uri;
import com.ss.mediakit.image.ImageLoader;
import com.ss.mediakit.image.api.IRequest;
import com.ss.mediakit.image.api.ImageLoaderApi;
import com.ss.mediakit.image.impl.ImageRequest;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ImageLoaderImpl implements ImageLoaderApi {
    static final String TAG = "ImageLoaderImpl";

    @Override // com.ss.mediakit.image.api.ImageLoaderApi
    public boolean canFetchForUri(Uri uri, Map<String, String> map) {
        return ImageLoader.get().canFetchUri(uri, map);
    }

    @Override // com.ss.mediakit.image.api.ImageLoaderApi
    public IRequest fetchImage(String str, Map<String, String> map, Map<String, String> map2, String str2) {
        return new ImageRequest.Builder().url(str).headers(map).params(map2).extInfos(str2).build();
    }
}
