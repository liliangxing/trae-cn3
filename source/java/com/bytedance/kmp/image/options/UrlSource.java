package com.bytedance.kmp.image.options;

import com.bytedance.kmp.image.options.KImageSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KImageSource.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0002\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u000b\u001a\u00020\tHÂ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006J\t\u0010\u0014\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/kmp/image/options/UrlSource;", "Lcom/bytedance/kmp/image/options/KImageSource;", "url", "", "(Ljava/lang/String;)V", "urls", "", "(Ljava/util/List;)V", "urlSourceUrls", "Lcom/bytedance/kmp/image/options/UrlSourceUrls;", "(Lcom/bytedance/kmp/image/options/UrlSourceUrls;)V", "component1", "copy", "equals", "", "other", "", "getType", "", "getUrls", "hashCode", "toString", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class UrlSource implements KImageSource {
    public static final int $stable = 0;
    private final UrlSourceUrls urlSourceUrls;

    /* renamed from: component1, reason: from getter */
    private final UrlSourceUrls getUrlSourceUrls() {
        return this.urlSourceUrls;
    }

    public static /* synthetic */ UrlSource copy$default(UrlSource urlSource, UrlSourceUrls urlSourceUrls, int i, Object obj) {
        if ((i & 1) != 0) {
            urlSourceUrls = urlSource.urlSourceUrls;
        }
        return urlSource.copy(urlSourceUrls);
    }

    public final UrlSource copy(UrlSourceUrls urlSourceUrls) {
        Intrinsics.checkNotNullParameter(urlSourceUrls, "urlSourceUrls");
        return new UrlSource(urlSourceUrls);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UrlSource) && Intrinsics.areEqual(this.urlSourceUrls, ((UrlSource) other).urlSourceUrls);
    }

    @Override // com.bytedance.kmp.image.options.KImageSource
    public int getType() {
        return 1;
    }

    public int hashCode() {
        return this.urlSourceUrls.hashCode();
    }

    public String toString() {
        return "UrlSource(urlSourceUrls=" + this.urlSourceUrls + ')';
    }

    private UrlSource(UrlSourceUrls urlSourceUrls) {
        this.urlSourceUrls = urlSourceUrls;
    }

    @Override // com.bytedance.kmp.image.options.KImageSource
    public boolean isLocalSource() {
        return KImageSource.DefaultImpls.isLocalSource(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UrlSource(String str) {
        this(new UrlSourceUrls(CollectionsKt.listOf(str)));
        Intrinsics.checkNotNullParameter(str, "url");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UrlSource(List<String> list) {
        this(new UrlSourceUrls(CollectionsKt.toList(list)));
        Intrinsics.checkNotNullParameter(list, "urls");
    }

    public final List<String> getUrls() {
        return this.urlSourceUrls.getUrls();
    }
}
