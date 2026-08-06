package com.bytedance.vcloud.uniplayer;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniKitService.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniAndroidEnv;", "", "()V", "appContext", "Landroid/content/Context;", "setContext", "", "ctx", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UniAndroidEnv {
    public static final UniAndroidEnv INSTANCE = new UniAndroidEnv();
    private static Context appContext;

    private UniAndroidEnv() {
    }

    public final void setContext(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        appContext = ctx;
    }
}
