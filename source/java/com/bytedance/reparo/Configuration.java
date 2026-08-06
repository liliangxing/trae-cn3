package com.bytedance.reparo;

import android.app.Application;
import java.io.File;

/* loaded from: classes4.dex */
public class Configuration {
    private static final String CACHE_ROOT_DIR_NAME = "reparo-root";
    private static final String DOWNLOAD_DIR_NAME = "download";
    private Application mApplication;

    public Configuration(Application application) {
        this.mApplication = application;
    }

    public File getCacheRootDir() {
        return new File(this.mApplication.getFilesDir(), "reparo-root");
    }

    public File getPatchCacheDir(String str) {
        return new File(getCacheRootDir(), str);
    }

    public File getDownloadCacheFile(String str, String str2) {
        return new File(getPatchCacheDir(str), DOWNLOAD_DIR_NAME + File.separator + str2);
    }
}
