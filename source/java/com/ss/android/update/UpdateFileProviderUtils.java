package com.ss.android.update;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import androidx.core.content.FileProvider;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateFileProviderUtils {
    public static void installApk(Context context, File file) {
        if (context == null || file == null) {
            return;
        }
        try {
            context.startActivity(getIntent(context, file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Intent getIntent(Context context, File file) {
        IUpdateConfig config = UpdateSDK.getConfig();
        Uri uriForFile = FileProvider.getUriForFile(context, config != null ? config.getUpdateConfig().getFormalAuthority() : "com.ss.android.uri.key", file);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        intent.addFlags(268435457);
        return intent;
    }

    public static File getCacheDirectory(Context context, boolean z) {
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (ArrayIndexOutOfBoundsException | NullPointerException unused) {
        }
        File externalCacheDir = (z && "mounted".equals(str)) ? getExternalCacheDir(context) : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir == null) {
            externalCacheDir = new File("/data/data/" + context.getPackageName() + "/cache/");
        }
        if (!externalCacheDir.exists()) {
            externalCacheDir.mkdirs();
        }
        return externalCacheDir;
    }

    public static File getExternalCacheDir(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }
}
