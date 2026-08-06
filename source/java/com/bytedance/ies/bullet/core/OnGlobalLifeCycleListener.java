package com.bytedance.ies.bullet.core;

import android.net.Uri;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletLifeCycleManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/core/OnGlobalLifeCycleListener;", "", "onLoadUriFail", "", "uri", "Landroid/net/Uri;", "view", "Landroid/view/View;", "onLoadUriSuccess", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface OnGlobalLifeCycleListener {

    /* compiled from: BulletLifeCycleManager.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void onLoadUriFail(OnGlobalLifeCycleListener onGlobalLifeCycleListener, Uri uri, View view) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public static void onLoadUriSuccess(OnGlobalLifeCycleListener onGlobalLifeCycleListener, Uri uri, View view) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    void onLoadUriFail(Uri uri, View view);

    void onLoadUriSuccess(Uri uri, View view);
}
