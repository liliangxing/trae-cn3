package com.bytedance.ies.bullet.service.schema.utils;

import android.net.Uri;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SchemaUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\u001a\u0014\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003\u001a\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002\u001a\u0012\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u0018\u0010\b\u001a\u00020\u0003*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n¨\u0006\u000b"}, d2 = {"getQueryParameterNamesSafely", "", "", "Landroid/net/Uri;", "getQueryParameterSafely", "key", "removeQueryParameterSafely", "queryParameterName", "removeQueryParametersSafely", "queryParameterNames", "", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class SchemaUtilsKt {
    public static final String getQueryParameterSafely(Uri uri, String key) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!uri.isHierarchical()) {
            uri = null;
        }
        if (uri != null) {
            return uri.getQueryParameter(key);
        }
        return null;
    }

    public static final Set<String> getQueryParameterNamesSafely(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        if (!uri.isHierarchical()) {
            uri = null;
        }
        if (uri != null) {
            return uri.getQueryParameterNames();
        }
        return null;
    }

    public static final Uri removeQueryParameterSafely(Uri uri, String queryParameterName) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(queryParameterName, "queryParameterName");
        if (!uri.isHierarchical()) {
            return uri;
        }
        Uri.Builder clearQuery = uri.buildUpon().clearQuery();
        Intrinsics.checkNotNullExpressionValue(clearQuery, "this.buildUpon().clearQuery()");
        for (String str : uri.getQueryParameterNames()) {
            if (!Intrinsics.areEqual(str, queryParameterName)) {
                Iterator<String> it = uri.getQueryParameters(str).iterator();
                while (it.hasNext()) {
                    clearQuery.appendQueryParameter(str, it.next());
                }
            }
        }
        Uri build = clearQuery.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static final Uri removeQueryParametersSafely(Uri uri, List<String> queryParameterNames) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(queryParameterNames, "queryParameterNames");
        if (!uri.isHierarchical()) {
            return uri;
        }
        Uri.Builder clearQuery = uri.buildUpon().clearQuery();
        Intrinsics.checkNotNullExpressionValue(clearQuery, "this.buildUpon().clearQuery()");
        for (String str : uri.getQueryParameterNames()) {
            if (!queryParameterNames.contains(str)) {
                Iterator<String> it = uri.getQueryParameters(str).iterator();
                while (it.hasNext()) {
                    clearQuery.appendQueryParameter(str, it.next());
                }
            }
        }
        Uri build = clearQuery.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
