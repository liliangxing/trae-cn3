package com.bytedance.ies.bullet.redirect.helper;

import android.net.Uri;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UriQueryView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0086\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0003J\u0019\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0000H\u0086\u0002J\u001b\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0086\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/helper/UriQueryView;", "", "baseUriString", "", "(Ljava/lang/String;)V", "baseUri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "queryMap", "", "get", "key", "remove", "", "set", "value", "toString", "toUri", "view", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class UriQueryView {
    private final Uri baseUri;
    private final Map<String, Object> queryMap;

    public UriQueryView(Uri baseUri) {
        Intrinsics.checkNotNullParameter(baseUri, "baseUri");
        this.baseUri = baseUri;
        this.queryMap = new LinkedHashMap();
        if (baseUri.isHierarchical()) {
            Set<String> queryParameterNames = baseUri.getQueryParameterNames();
            Intrinsics.checkNotNullExpressionValue(queryParameterNames, "baseUri.queryParameterNames");
            for (String it : queryParameterNames) {
                String queryParameter = this.baseUri.getQueryParameter(it);
                Intrinsics.checkNotNull(queryParameter);
                Map<String, Object> map = this.queryMap;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                map.put(it, queryParameter);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UriQueryView(String baseUriString) {
        this(r2);
        Intrinsics.checkNotNullParameter(baseUriString, "baseUriString");
        Uri parse = Uri.parse(baseUriString);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(baseUriString)");
    }

    public final String get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.queryMap.get(key);
        if (obj instanceof UriQueryView) {
            return ((UriQueryView) obj).toUri().toString();
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final void set(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (value != null) {
            this.queryMap.put(key, value);
        } else {
            this.queryMap.remove(key);
        }
    }

    public final void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.queryMap.remove(key);
    }

    public final void set(String key, UriQueryView value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.queryMap.put(key, value);
    }

    public final UriQueryView view(String key) {
        UriQueryView uriQueryView;
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.queryMap.get(key);
        if (obj instanceof UriQueryView) {
            return (UriQueryView) obj;
        }
        if (obj instanceof String) {
            Uri uri = Uri.parse((String) obj);
            if (uri.isHierarchical()) {
                Intrinsics.checkNotNullExpressionValue(uri, "uri");
                uriQueryView = new UriQueryView(uri);
            } else {
                Uri EMPTY = Uri.EMPTY;
                Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
                uriQueryView = new UriQueryView(EMPTY);
            }
        } else {
            Uri EMPTY2 = Uri.EMPTY;
            Intrinsics.checkNotNullExpressionValue(EMPTY2, "EMPTY");
            uriQueryView = new UriQueryView(EMPTY2);
        }
        this.queryMap.put(key, uriQueryView);
        return uriQueryView;
    }

    public final Uri toUri() {
        String obj;
        Uri.Builder clearQuery = this.baseUri.buildUpon().clearQuery();
        Iterator<T> it = this.queryMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof UriQueryView) {
                obj = ((UriQueryView) value).toUri().toString();
            } else {
                obj = value.toString();
            }
            Intrinsics.checkNotNullExpressionValue(obj, "if (v is UriQueryView) {….toString()\n            }");
            clearQuery.appendQueryParameter(str, obj);
        }
        Uri build = clearQuery.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public String toString() {
        String uri = toUri().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toUri().toString()");
        return uri;
    }
}
