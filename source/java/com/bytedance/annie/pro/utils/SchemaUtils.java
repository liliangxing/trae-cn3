package com.bytedance.annie.pro.utils;

import android.net.Uri;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SchemaUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\b\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\f"}, d2 = {"Lcom/bytedance/annie/pro/utils/SchemaUtils;", "", "()V", "appendEndSlash", "", "path", "appendStartSlash", "removeEndSlash", "replaceQueryParameterSafely", "Landroid/net/Uri;", "queryParameterName", "queryParameterValue", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class SchemaUtils {
    public static final SchemaUtils INSTANCE = new SchemaUtils();

    private SchemaUtils() {
    }

    public final String appendStartSlash(String path) {
        String str = path;
        return str == null || StringsKt.isBlank(str) ? "" : StringsKt.startsWith$default(path, "/", false, 2, (Object) null) ? path : "/" + path;
    }

    public final String appendEndSlash(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return StringsKt.isBlank(path) ? "" : StringsKt.endsWith$default(path, "/", false, 2, (Object) null) ? path : path + '/';
    }

    public final String removeEndSlash(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (StringsKt.isBlank(path)) {
            return "";
        }
        if (!StringsKt.endsWith$default(path, "/", false, 2, (Object) null)) {
            return path;
        }
        String substring = path.substring(0, path.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final Uri replaceQueryParameterSafely(Uri uri, String str, String str2) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(str, "queryParameterName");
        Intrinsics.checkNotNullParameter(str2, "queryParameterValue");
        if (!uri.isHierarchical()) {
            return uri;
        }
        Uri.Builder clearQuery = uri.buildUpon().clearQuery();
        Intrinsics.checkNotNullExpressionValue(clearQuery, "this.buildUpon().clearQuery()");
        for (String str3 : uri.getQueryParameterNames()) {
            if (!Intrinsics.areEqual(str3, str)) {
                Iterator<String> it = uri.getQueryParameters(str3).iterator();
                while (it.hasNext()) {
                    clearQuery.appendQueryParameter(str3, it.next());
                }
            } else {
                clearQuery.appendQueryParameter(str, str2);
            }
        }
        Uri build = clearQuery.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
