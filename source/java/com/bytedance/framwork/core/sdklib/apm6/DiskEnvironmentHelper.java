package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.framwork.core.sdklib.apm6.safety.Logger;
import com.bytedance.librarian.LibrarianImpl;
import com.ss.android.common.util.ToolUtils;
import java.io.File;

/* loaded from: classes2.dex */
public class DiskEnvironmentHelper {
    private static final String FLUSH_DIR_NAME = "flush";
    private static final String HEADER_DIR_NAME = "header";
    private static final String LOG_DIR_NAME = "log";
    private static final String PERSISTENT_DIR_NAME = "persistent";
    private static final String WORKING_DIR_NAME = "apm6_sdk";
    private static File sFlushDirectory;
    private static File sHeaderDirectory;
    private static File sLogDirectory;
    private static File sPersistentDirectory;
    private static File sPersistentFile;
    private static File sWorkingDirectory;

    public static synchronized File getWorkingDirectory() {
        File file;
        synchronized (DiskEnvironmentHelper.class) {
            if (sWorkingDirectory == null) {
                File file2 = new File(SDKContext.getContext().getFilesDir(), WORKING_DIR_NAME);
                sWorkingDirectory = file2;
                if (!file2.exists()) {
                    sWorkingDirectory.mkdirs();
                }
            }
            file = sWorkingDirectory;
        }
        return file;
    }

    public static synchronized File getPersistentDirectory() {
        File file;
        synchronized (DiskEnvironmentHelper.class) {
            if (sPersistentDirectory == null) {
                File file2 = new File(getWorkingDirectory(), PERSISTENT_DIR_NAME);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                sPersistentDirectory = file2;
                if (SDKContext.isDebugMode()) {
                    Logger.d(Constants.TAG, "prepare PersistentDirectory success. name=" + sPersistentDirectory);
                }
            }
            file = sPersistentDirectory;
        }
        return file;
    }

    public static synchronized File getPersistentFile() {
        File file;
        synchronized (DiskEnvironmentHelper.class) {
            if (sPersistentFile == null) {
                try {
                    File file2 = new File(getPersistentDirectory(), ToolUtils.getCurProcessName(SDKContext.getContext()).replace(LibrarianImpl.Constants.DOT, "_").replace(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER) + ".bin");
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    sPersistentFile = file2;
                    if (SDKContext.isDebugMode()) {
                        Logger.d(Constants.TAG, "prepare PersistentFile success. fileName=" + sPersistentFile);
                    }
                } catch (Exception e) {
                    Logger.e(Constants.TAG, "prepare PersistentFile fail.", e);
                }
            }
            file = sPersistentFile;
        }
        return file;
    }

    public static synchronized File getFlushDirectory() {
        File file;
        synchronized (DiskEnvironmentHelper.class) {
            if (sFlushDirectory == null) {
                File file2 = new File(getWorkingDirectory(), FLUSH_DIR_NAME);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                sFlushDirectory = file2;
                if (SDKContext.isDebugMode()) {
                    Logger.d(Constants.TAG, "prepare FlushDirectory success. name=" + sFlushDirectory);
                }
            }
            file = sFlushDirectory;
        }
        return file;
    }

    public static synchronized File getLogDirectory() {
        File file;
        synchronized (DiskEnvironmentHelper.class) {
            if (sLogDirectory == null) {
                File file2 = new File(getWorkingDirectory(), "log");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                sLogDirectory = file2;
            }
            file = sLogDirectory;
        }
        return file;
    }

    public static synchronized File getHeaderDirectory() {
        File file;
        synchronized (DiskEnvironmentHelper.class) {
            try {
                if (sHeaderDirectory == null) {
                    File file2 = new File(getWorkingDirectory(), "header");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    sHeaderDirectory = file2;
                }
            } catch (Exception e) {
                Logger.e(Constants.TAG, "header", e);
            }
            file = sHeaderDirectory;
        }
        return file;
    }

    public static File getLockFile() {
        return new File(getWorkingDirectory(), "file.lock");
    }
}
