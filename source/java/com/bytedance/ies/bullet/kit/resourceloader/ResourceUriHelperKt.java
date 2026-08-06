package com.bytedance.ies.bullet.kit.resourceloader;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceUriHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u001a\u001c\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u001a\u001c\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u001a\u001c\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u001a\u0016\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"AUTHORITY_ABSOLUTE", "", "AUTHORITY_RELATIVE", "SCHEME_ASSETS", "SCHEME_FILE", "SCHEME_HTTP", "SCHEME_HTTPS", "SCHEME_LYNX_VIEW", "makeAbsoluteUri", "Landroid/net/Uri;", "path", "sourceUri", "makeAssetAbsoluteUri", "makeAssetRelativeUri", "makeRelativeUri", "appendExtraPart", "Landroid/net/Uri$Builder;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class ResourceUriHelperKt {
    public static final String AUTHORITY_ABSOLUTE = "absolute";
    public static final String AUTHORITY_RELATIVE = "relative";
    public static final String SCHEME_ASSETS = "assets";
    public static final String SCHEME_FILE = "local_file";
    public static final String SCHEME_HTTP = "http";
    public static final String SCHEME_HTTPS = "https";
    public static final String SCHEME_LYNX_VIEW = "lynxview";

    public static final Uri makeRelativeUri(String path, Uri uri) {
        Intrinsics.checkNotNullParameter(path, "path");
        Uri.Builder path2 = new Uri.Builder().scheme("local_file").authority("relative").path(path);
        Intrinsics.checkNotNullExpressionValue(path2, "Builder()\n    .scheme(SC…RITY_RELATIVE).path(path)");
        Uri build = appendExtraPart(path2, uri).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n    .scheme(SC…raPart(sourceUri).build()");
        return build;
    }

    public static /* synthetic */ Uri makeRelativeUri$default(String str, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            uri = null;
        }
        return makeRelativeUri(str, uri);
    }

    public static final Uri makeAbsoluteUri(String path, Uri uri) {
        Intrinsics.checkNotNullParameter(path, "path");
        Uri.Builder path2 = new Uri.Builder().scheme("local_file").authority("absolute").path(path);
        Intrinsics.checkNotNullExpressionValue(path2, "Builder()\n    .scheme(SC…RITY_ABSOLUTE).path(path)");
        Uri build = appendExtraPart(path2, uri).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n    .scheme(SC…raPart(sourceUri).build()");
        return build;
    }

    public static /* synthetic */ Uri makeAbsoluteUri$default(String str, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            uri = null;
        }
        return makeAbsoluteUri(str, uri);
    }

    public static final Uri makeAssetRelativeUri(String path, Uri uri) {
        Intrinsics.checkNotNullParameter(path, "path");
        Uri.Builder path2 = new Uri.Builder().scheme(SCHEME_ASSETS).authority("relative").path(path);
        Intrinsics.checkNotNullExpressionValue(path2, "Builder()\n    .scheme(SC…RITY_RELATIVE).path(path)");
        Uri build = appendExtraPart(path2, uri).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n    .scheme(SC…raPart(sourceUri).build()");
        return build;
    }

    public static /* synthetic */ Uri makeAssetRelativeUri$default(String str, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            uri = null;
        }
        return makeAssetRelativeUri(str, uri);
    }

    public static final Uri makeAssetAbsoluteUri(String path, Uri uri) {
        Intrinsics.checkNotNullParameter(path, "path");
        Uri.Builder path2 = new Uri.Builder().scheme(SCHEME_ASSETS).authority("absolute").path(path);
        Intrinsics.checkNotNullExpressionValue(path2, "Builder()\n    .scheme(SC…RITY_ABSOLUTE).path(path)");
        Uri build = appendExtraPart(path2, uri).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n    .scheme(SC…raPart(sourceUri).build()");
        return build;
    }

    public static /* synthetic */ Uri makeAssetAbsoluteUri$default(String str, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            uri = null;
        }
        return makeAssetAbsoluteUri(str, uri);
    }

    public static /* synthetic */ Uri.Builder appendExtraPart$default(Uri.Builder builder, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = null;
        }
        return appendExtraPart(builder, uri);
    }

    public static final Uri.Builder appendExtraPart(Uri.Builder builder, Uri uri) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        if (uri != null) {
            builder.encodedQuery(uri.getEncodedQuery());
        }
        return builder;
    }
}
