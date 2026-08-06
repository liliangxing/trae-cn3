package com.bytedance.pia.core.utils;

import android.net.Uri;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.pia.core.setting.Settings;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UrlUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0007J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\f\u0010\f\u001a\u00020\u0006*\u00020\u0006H\u0007J\u000e\u0010\r\u001a\u00020\u0004*\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\b*\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\b*\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\u0010\u001a\u00020\u0011*\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\u0010\u001a\u00020\u0011*\u0004\u0018\u00010\u0004H\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/pia/core/utils/UrlUtils;", "", "()V", "normalizeUrl", "", "uri", "Landroid/net/Uri;", "extraVary", "", "resolveRelativeUrl", "origin", "url", "compatV2", "getFullPath", "getHostSegments", "getPathFullSegments", "isHttp", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UrlUtils {
    public static final UrlUtils INSTANCE = new UrlUtils();

    @JvmStatic
    public static final String normalizeUrl(Uri uri) {
        return normalizeUrl$default(uri, null, 2, null);
    }

    private UrlUtils() {
    }

    @JvmStatic
    public static final boolean isHttp(String str) {
        return isHttp(str != null ? Uri.parse(str) : null);
    }

    @JvmStatic
    public static final boolean isHttp(Uri uri) {
        return CollectionsKt.contains(CollectionsKt.listOf(new String[]{"http", "https"}), uri != null ? uri.getScheme() : null);
    }

    @JvmStatic
    public static final String getFullPath(Uri uri) {
        String str = null;
        if (uri != null) {
            if (!isHttp(uri)) {
                uri = null;
            }
            if (uri != null) {
                str = (String) StringsKt.split$default(uri.getScheme() + ':' + uri.getEncodedSchemeSpecificPart(), new char[]{'?'}, false, 0, 6, (Object) null).get(0);
            }
        }
        return str == null ? "" : str;
    }

    @JvmStatic
    public static final Uri resolveRelativeUrl(Uri origin, String url) {
        Uri parse = url != null ? Uri.parse(url) : null;
        if (parse == null) {
            return null;
        }
        List<String> pathSegments = parse.getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "it");
        if (!(!pathSegments.isEmpty())) {
            pathSegments = null;
        }
        if (pathSegments == null) {
            return null;
        }
        String scheme = parse.getScheme();
        if (scheme == null) {
            scheme = origin != null ? origin.getScheme() : null;
            if (scheme == null) {
                return null;
            }
        }
        String encodedAuthority = parse.getEncodedAuthority();
        if (encodedAuthority == null) {
            encodedAuthority = origin != null ? origin.getEncodedAuthority() : null;
            if (encodedAuthority == null) {
                return null;
            }
        }
        if (Intrinsics.areEqual(CollectionsKt.first(pathSegments), LibrarianImpl.Constants.DOT)) {
            List<String> pathSegments2 = origin != null ? origin.getPathSegments() : null;
            if (pathSegments2 == null) {
                pathSegments2 = CollectionsKt.emptyList();
            }
            String path = origin != null ? origin.getPath() : null;
            if (path == null) {
                path = "";
            }
            if (!StringsKt.endsWith$default(path, '/', false, 2, (Object) null)) {
                pathSegments2 = CollectionsKt.dropLast(pathSegments2, 1);
            }
            pathSegments = CollectionsKt.plus(pathSegments2, CollectionsKt.drop(pathSegments, 1));
        }
        String joinToString$default = CollectionsKt.joinToString$default(pathSegments, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(scheme);
        builder.encodedAuthority(encodedAuthority);
        builder.encodedQuery(parse.getEncodedQuery());
        builder.path(joinToString$default);
        return builder.build();
    }

    public static /* synthetic */ String normalizeUrl$default(Uri uri, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        return normalizeUrl(uri, list);
    }

    @JvmStatic
    public static final String normalizeUrl(Uri uri, List<String> extraVary) {
        if (uri == null || !isHttp(uri)) {
            return null;
        }
        StringBuffer append = new StringBuffer().append(uri.getAuthority()).append(uri.getPath());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String queryParameter = uri.getQueryParameter("_pia_vary_");
        if (queryParameter != null) {
            Intrinsics.checkNotNullExpressionValue(queryParameter, "getQueryParameter(\"_pia_vary_\")");
            List split$default = StringsKt.split$default(queryParameter, new char[]{StringListParam.SPLIT_DELIMITER}, false, 0, 6, (Object) null);
            if (split$default != null) {
                List<String> list = split$default;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (String str : list) {
                    if (str == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    arrayList.add(StringsKt.trim(str).toString());
                }
                linkedHashSet.addAll(arrayList);
            }
        }
        if (extraVary != null) {
            linkedHashSet.addAll(extraVary);
        }
        List<String> sorted = CollectionsKt.sorted(linkedHashSet);
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : sorted) {
            String queryParameter2 = uri.getQueryParameter(str2);
            String str3 = queryParameter2;
            Pair pair = str3 == null || StringsKt.isBlank(str3) ? null : TuplesKt.to(str2, queryParameter2);
            if (pair != null) {
                arrayList2.add(pair);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = arrayList3.isEmpty() ^ true ? arrayList3 : null;
        if (arrayList4 != null) {
            Pair pair2 = (Pair) CollectionsKt.first(arrayList4);
            append.append("?").append(((String) pair2.getFirst()) + '=' + ((String) pair2.getSecond()));
            List<Pair> drop = CollectionsKt.drop(arrayList4, 1);
            if (drop != null) {
                for (Pair pair3 : drop) {
                    append.append("&").append(((String) pair3.component1()) + '=' + ((String) pair3.component2()));
                }
            }
        }
        return append.toString();
    }

    @JvmStatic
    public static final List<String> getHostSegments(Uri uri) {
        String host;
        List split$default = (uri == null || (host = uri.getHost()) == null) ? null : StringsKt.split$default(host, new char[]{'.'}, false, 0, 6, (Object) null);
        if (split$default == null) {
            split$default = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final List<String> getPathFullSegments(Uri uri) {
        List<String> pathSegments = uri != null ? uri.getPathSegments() : null;
        if (pathSegments == null) {
            pathSegments = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : pathSegments) {
            Intrinsics.checkNotNullExpressionValue(str, "it");
            List split$default = StringsKt.split$default(str, new char[]{'.'}, false, 0, 6, (Object) null);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : split$default) {
                if (((String) obj).length() > 0) {
                    arrayList2.add(obj);
                }
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final Uri compatV2(Uri uri) {
        Uri uri2;
        Intrinsics.checkNotNullParameter(uri, "<this>");
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsUrlCompatV2Enabled()) {
            return uri;
        }
        try {
            Result.Companion companion = Result.Companion;
            uri2 = Result.constructor-impl(uri.buildUpon().appendQueryParameter("_pia_", "1").build());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            uri2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (!Result.isFailure-impl(uri2)) {
            uri = uri2;
        }
        Intrinsics.checkNotNullExpressionValue(uri, "{\n        runCatching {\n….getOrDefault(this)\n    }");
        return uri;
    }
}
