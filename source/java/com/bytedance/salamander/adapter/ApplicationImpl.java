package com.bytedance.salamander.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bytedance.salamander.adapter.Salamander;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FoundationUIKitApplicationImpl.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016R\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/adapter/ApplicationImpl;", "Lcom/bytedance/salamander/adapter/ApplicationProvider;", "()V", "application", "Landroid/content/Context;", "Lcom/bytedance/salamander/adapter/Context;", "appVersion", "", "buildNumber", "displayName", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public class ApplicationImpl implements ApplicationProvider {
    private Context application;

    public ApplicationImpl() {
        Salamander.Companion companion = Salamander.INSTANCE;
        Intrinsics.checkNotNull(companion);
        Context application = companion.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type android.content.Context{ com.bytedance.salamander.adapter.IndexKt.Context }");
        this.application = application;
    }

    @Override // com.bytedance.salamander.adapter.ApplicationProvider
    public String displayName() {
        Intrinsics.checkNotNull(this);
        Context context = this.application;
        Intrinsics.checkNotNull(context);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        Intrinsics.checkNotNull(applicationInfo);
        CharSequence loadLabel = applicationInfo.loadLabel(this.application.getPackageManager());
        Intrinsics.checkNotNullExpressionValue(loadLabel, "this)!!.application)!!.a…plication.packageManager)");
        return (String) loadLabel;
    }

    @Override // com.bytedance.salamander.adapter.ApplicationProvider
    public String buildNumber() {
        PackageInfo packageInfo;
        Intrinsics.checkNotNull(this);
        Context context = this.application;
        Intrinsics.checkNotNull(context);
        PackageManager packageManager = context.getPackageManager();
        Integer valueOf = (packageManager == null || (packageInfo = packageManager.getPackageInfo(this.application.getPackageName(), 0)) == null) ? null : Integer.valueOf(packageInfo.versionCode);
        return valueOf != null ? valueOf.toString() : "Unknown Build Number";
    }

    @Override // com.bytedance.salamander.adapter.ApplicationProvider
    public String appVersion() {
        Intrinsics.checkNotNull(this);
        Context context = this.application;
        Intrinsics.checkNotNull(context);
        PackageManager packageManager = context.getPackageManager();
        Intrinsics.checkNotNull(packageManager);
        PackageInfo packageInfo = packageManager.getPackageInfo(this.application.getPackageName(), 0);
        String str = packageInfo != null ? packageInfo.versionName : null;
        return str != null ? str : "Unknown Version";
    }
}
