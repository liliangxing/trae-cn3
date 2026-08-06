package com.bytedance.ies.bullet.service.router;

import android.net.Uri;
import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouterService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/router/DefaultRouterInterceptor;", "Lcom/bytedance/ies/bullet/service/router/IRouterInterceptor;", "()V", "checkUriValid", "", "uri", "Landroid/net/Uri;", "onPrepare", "onRouter", "bulletUri", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultRouterInterceptor implements IRouterInterceptor {
    @Override // com.bytedance.ies.bullet.service.router.IRouterInterceptor
    public boolean onRouter(Uri bulletUri) {
        Intrinsics.checkNotNullParameter(bulletUri, "bulletUri");
        return true;
    }

    @Override // com.bytedance.ies.bullet.service.router.IRouterInterceptor
    public boolean onPrepare(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return checkUriValid(uri);
    }

    private final boolean checkUriValid(Uri uri) {
        return (!uri.isHierarchical() || TextUtils.isEmpty(uri.getScheme()) || TextUtils.isEmpty(uri.getHost())) ? false : true;
    }
}
