package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ForestPreloadKey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0016\u0010\u0005\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestPreloadKey;", "", "url", "", "(Ljava/lang/String;)V", "key", "getKey$anniex_release", "()Ljava/lang/String;", "getUrl", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestPreloadKey {
    private final String key;
    private final String url;

    public ForestPreloadKey(String str) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(str, "url");
        this.url = str;
        if (GeckoXAdapter.Companion.canParsed(str) && (indexOf$default = StringsKt.indexOf$default(str, "?", 0, false, 6, (Object) null)) != -1) {
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            str = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        this.key = str;
    }

    public final String getUrl() {
        return this.url;
    }

    /* renamed from: getKey$anniex_release, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bytedance.ies.bullet.forest.ForestPreloadKey");
        return Intrinsics.areEqual(this.key, ((ForestPreloadKey) other).key);
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return "ForestPreloadKey(url='" + this.url + "', key='" + this.key + "')";
    }
}
