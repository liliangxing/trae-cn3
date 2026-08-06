package com.ss.mediakit.image.api;

import android.net.Uri;
import java.util.Map;

/* loaded from: classes7.dex */
public interface ImageLoaderApi {
    boolean canFetchForUri(Uri uri, Map<String, String> map);

    IRequest fetchImage(String str, Map<String, String> map, Map<String, String> map2, String str2);
}
