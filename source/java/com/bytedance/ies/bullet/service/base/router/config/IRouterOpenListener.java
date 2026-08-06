package com.bytedance.ies.bullet.service.base.router.config;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouterConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\nJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/router/config/IRouterOpenListener;", "", "onPostOpen", "", "uri", "Landroid/net/Uri;", "convertedUri", "success", "", "onPreOpen", "Base", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IRouterOpenListener {

    /* compiled from: RouterConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/router/config/IRouterOpenListener$Base;", "Lcom/bytedance/ies/bullet/service/base/router/config/IRouterOpenListener;", "()V", "onPostOpen", "", "uri", "Landroid/net/Uri;", "convertedUri", "success", "", "onPreOpen", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static class Base implements IRouterOpenListener {
        @Override // com.bytedance.ies.bullet.service.base.router.config.IRouterOpenListener
        public void onPostOpen(Uri uri, Uri convertedUri, boolean success) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(convertedUri, "convertedUri");
        }

        @Override // com.bytedance.ies.bullet.service.base.router.config.IRouterOpenListener
        public void onPreOpen(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
        }
    }

    void onPostOpen(Uri uri, Uri convertedUri, boolean success);

    void onPreOpen(Uri uri);
}
