package com.bytedance.kmp.image.utils;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Uri.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BI\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/kmp/image/utils/Uri;", "", "data", "", "separator", "scheme", "authority", "path", "query", "fragment", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthority", "()Ljava/lang/String;", "getFragment", "getPath", "getQuery", "getScheme", "getSeparator", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Uri {
    public static final int $stable = 0;
    private final String authority;
    private final String data;
    private final String fragment;
    private final String path;
    private final String query;
    private final String scheme;
    private final String separator;

    public Uri(String data, String separator, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(separator, "separator");
        this.data = data;
        this.separator = separator;
        this.scheme = str;
        this.authority = str2;
        this.path = str3;
        this.query = str4;
        this.fragment = str5;
    }

    public final String getSeparator() {
        return this.separator;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final String getAuthority() {
        return this.authority;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getFragment() {
        return this.fragment;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Uri) && Intrinsics.areEqual(((Uri) other).data, this.data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    /* renamed from: toString, reason: from getter */
    public String getData() {
        return this.data;
    }
}
