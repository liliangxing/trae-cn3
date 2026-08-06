package com.lynx.animax.util;

import android.net.Uri;

/* loaded from: classes6.dex */
public class UriUtil {
    public static final String HTTPS_SCHEME = "https";
    public static final String HTTP_SCHEME = "http";
    public static final String LOCAL_ASSET_SCHEME = "asset";
    public static final String LOCAL_FILE_SCHEME = "file";

    public static Uri safeParse(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    public static String fromLocalAsset(String str) {
        return new Uri.Builder().scheme("asset").authority("").path(str).build().toString();
    }

    public static String fromLocalFile(String str) {
        return new Uri.Builder().scheme("file").authority("").path(str).build().toString();
    }

    public static String getAssetName(Uri uri) {
        return uri.getPath().substring(1);
    }

    public static String getLocalFileName(Uri uri) {
        return uri.getPath();
    }

    public static boolean isNetworkUri(Uri uri) {
        String schemeOrNull = getSchemeOrNull(uri);
        return "https".equals(schemeOrNull) || "http".equals(schemeOrNull);
    }

    public static boolean isLocalAssetUri(Uri uri) {
        return "asset".equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalFileUri(Uri uri) {
        return "file".equals(getSchemeOrNull(uri));
    }

    private static String getSchemeOrNull(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }
}
