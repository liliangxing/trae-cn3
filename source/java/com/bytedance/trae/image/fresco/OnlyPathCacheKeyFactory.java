package com.bytedance.trae.image.fresco;

import android.net.Uri;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FrescoExt.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/image/fresco/OnlyPathCacheKeyFactory;", "Lcom/facebook/imagepipeline/cache/DefaultCacheKeyFactory;", "<init>", "()V", "getCacheKeySourceUriStr", "", "sourceUri", "Landroid/net/Uri;", "getUriCacheKey", "toStringWithoutHost", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class OnlyPathCacheKeyFactory extends DefaultCacheKeyFactory {
    public static final OnlyPathCacheKeyFactory INSTANCE = new OnlyPathCacheKeyFactory();

    private OnlyPathCacheKeyFactory() {
    }

    protected String getCacheKeySourceUriStr(Uri sourceUri) {
        return getUriCacheKey(sourceUri);
    }

    private final String getUriCacheKey(Uri sourceUri) {
        if (sourceUri == null) {
            return "";
        }
        if (!Intrinsics.areEqual("http", sourceUri.getScheme()) && !Intrinsics.areEqual("https", sourceUri.getScheme())) {
            String uri = sourceUri.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
            return uri;
        }
        return toStringWithoutHost(sourceUri);
    }

    private final String toStringWithoutHost(Uri sourceUri) {
        StringBuilder sb = new StringBuilder();
        sb.append(sourceUri.getScheme()).append(":");
        if (sourceUri.getEncodedAuthority() != null) {
            sb.append("//");
        }
        String encodedPath = sourceUri.getEncodedPath();
        if (encodedPath != null) {
            sb.append(encodedPath);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
