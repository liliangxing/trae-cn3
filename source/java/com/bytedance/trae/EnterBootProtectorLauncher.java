package com.bytedance.trae;

import android.app.Application;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterBootProtectorLauncher.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/EnterBootProtectorLauncher;", "Lcom/bytedance/trae/ILauncher;", "<init>", "()V", "beforeAttachBaseContext", "", "context", "Landroid/content/Context;", "afterAttachBaseContext", "beforeOnCreate", "application", "Landroid/app/Application;", "afterOnCreate", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EnterBootProtectorLauncher implements ILauncher {
    public static final int $stable = 0;

    @Override // com.bytedance.trae.ILauncher
    public void afterAttachBaseContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.bytedance.trae.ILauncher
    public void afterOnCreate(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
    }

    @Override // com.bytedance.trae.ILauncher
    public void beforeAttachBaseContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.bytedance.trae.ILauncher
    public void beforeOnCreate(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
    }
}
