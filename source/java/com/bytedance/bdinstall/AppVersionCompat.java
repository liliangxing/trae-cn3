package com.bytedance.bdinstall;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.Singleton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class AppVersionCompat {
    private final Context context;
    private final Singleton<PackageInfo> mPackageInfo = new Singleton<PackageInfo>() { // from class: com.bytedance.bdinstall.AppVersionCompat.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        public PackageInfo create(Object... objArr) {
            try {
                return AppVersionCompat.this.context.getPackageManager().getPackageInfo(AppVersionCompat.this.context.getPackageName(), 0);
            } catch (Throwable th) {
                DrLog.m141e("AppVersionCompat#getPackageInfo error", th);
                return null;
            }
        }
    };
    private final long manifestVersionCode;
    private final long updateVersionCode;
    private final String version;
    private final long versionCode;
    private final String versionMinor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppVersionCompat(Builder builder) {
        this.context = builder.context;
        this.version = builder.version;
        this.versionMinor = TextUtils.isEmpty(builder.versionMinor) ? "" : builder.versionMinor;
        this.versionCode = builder.versionCode;
        this.updateVersionCode = builder.updateVersionCode;
        this.manifestVersionCode = builder.manifestVersionCode;
    }

    public String getVersion() {
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(this.version) && (packageInfo = this.mPackageInfo.get(new Object[0])) != null) {
            return packageInfo.versionName;
        }
        return this.version;
    }

    public String getVersionMinor() {
        return this.versionMinor;
    }

    public long getVersionCode() {
        PackageInfo packageInfo;
        if (this.versionCode == 0 && (packageInfo = this.mPackageInfo.get(new Object[0])) != null) {
            return packageInfo.versionCode;
        }
        return this.versionCode;
    }

    public long getUpdateVersionCode() {
        PackageInfo packageInfo;
        if (this.updateVersionCode == 0 && (packageInfo = this.mPackageInfo.get(new Object[0])) != null) {
            return packageInfo.versionCode;
        }
        return this.updateVersionCode;
    }

    public long getManifestVersionCode() {
        PackageInfo packageInfo;
        if (this.manifestVersionCode == 0 && (packageInfo = this.mPackageInfo.get(new Object[0])) != null) {
            return packageInfo.versionCode;
        }
        return this.manifestVersionCode;
    }
}
