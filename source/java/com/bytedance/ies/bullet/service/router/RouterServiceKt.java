package com.bytedance.ies.bullet.service.router;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouterService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001¨\u0006\u0004"}, d2 = {"getQueryParameterSafely", "", "Landroid/net/Uri;", "key", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class RouterServiceKt {
    public static final String getQueryParameterSafely(Uri uri, String key) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!uri.isHierarchical()) {
            uri = null;
        }
        if (uri != null) {
            return uri.getQueryParameter(key);
        }
        return null;
    }
}
