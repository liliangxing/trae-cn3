package com.bytedance.pia.nsr;

import android.net.Uri;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: RecordEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/pia/nsr/RecordEntry;", "", "fullPath", "", "queries", "", "(Ljava/lang/String;Ljava/util/Set;)V", "getFullPath", "()Ljava/lang/String;", "mHashCode", "", "Ljava/lang/Integer;", "mString", "getQueries", "()Ljava/util/Set;", "equals", "", "other", "hashCode", "match", "entry", "toString", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RecordEntry {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String fullPath;
    private Integer mHashCode;
    private String mString;
    private final Set<String> queries;

    public RecordEntry(String str, Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "fullPath");
        Intrinsics.checkNotNullParameter(set, "queries");
        this.fullPath = str;
        this.queries = set;
    }

    public final String getFullPath() {
        return this.fullPath;
    }

    public final Set<String> getQueries() {
        return this.queries;
    }

    /* compiled from: RecordEntry.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/pia/nsr/RecordEntry$Companion;", "", "()V", RLMonitorReporter.PARSE, "Lcom/bytedance/pia/nsr/RecordEntry;", "url", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RecordEntry parse(String url) {
            Object obj;
            TreeSet treeSet;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(Uri.parse(url));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                return null;
            }
            Uri uri = (Uri) obj;
            String stringBuffer = new StringBuffer().append(uri.getScheme()).append("://").append(uri.getAuthority()).append(uri.getPath()).toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer, "StringBuffer()\n         …              .toString()");
            String query = uri.getQuery();
            List split$default = query != null ? StringsKt.split$default(query, new char[]{'&'}, false, 0, 6, (Object) null) : null;
            if (split$default == null) {
                treeSet = new TreeSet();
            } else {
                treeSet = new TreeSet(split$default);
            }
            return new RecordEntry(stringBuffer, treeSet);
        }
    }

    public final boolean match(RecordEntry entry) {
        return Intrinsics.areEqual(this.fullPath, entry != null ? entry.fullPath : null) && entry.queries.containsAll(this.queries);
    }

    public boolean equals(Object other) {
        if (other instanceof String) {
            return equals(INSTANCE.parse((String) other));
        }
        return (other instanceof RecordEntry) && hashCode() == other.hashCode();
    }

    public int hashCode() {
        if (this.mHashCode == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.fullPath);
            CollectionsKt.toSortedSet(this.queries);
            Iterator<T> it = this.queries.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
            }
            this.mHashCode = Integer.valueOf(sb.toString().hashCode());
        }
        Integer num = this.mHashCode;
        Intrinsics.checkNotNull(num, "null cannot be cast to non-null type kotlin.Int");
        return num.intValue();
    }

    public String toString() {
        if (this.mString == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.fullPath);
            if (!this.queries.isEmpty()) {
                sb.append('?');
            }
            CollectionsKt.toSortedSet(this.queries);
            int i = 0;
            for (Object obj : this.queries) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                sb.append((String) obj);
                if (i < this.queries.size() - 1) {
                    sb.append('&');
                }
                i = i2;
            }
            this.mString = sb.toString();
        }
        String str = this.mString;
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type kotlin.String");
        return str;
    }
}
