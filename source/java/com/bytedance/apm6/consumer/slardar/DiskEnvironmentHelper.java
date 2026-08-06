package com.bytedance.apm6.consumer.slardar;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.UUID;

/* loaded from: classes3.dex */
public class DiskEnvironmentHelper {
    private static final String CHILD_PROCESS_PERSISTENT_DIR_NAME = "child_process_persistent";
    private static final String FLUSH_DIR_NAME = "flush";
    private static final String PERSISTENT_DIR_NAME = "persistent";
    private static final String WORKING_DIR_NAME = "apm6";
    private static File sFlushDirectory;
    private static File sPersistentDirectory;
    private static File sPersistentFile;
    private static File sWorkingDirectory;

    public static synchronized File getWorkingDirectory() {
        File file;
        synchronized (DiskEnvironmentHelper.class) {
            if (sWorkingDirectory == null) {
                File file2 = new File(ApmContext.getContext().getFilesDir(), WORKING_DIR_NAME);
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
        File file2;
        synchronized (DiskEnvironmentHelper.class) {
            if (sPersistentDirectory == null) {
                if (ApmContext.isMainProcess()) {
                    file2 = new File(getWorkingDirectory(), PERSISTENT_DIR_NAME);
                } else {
                    file2 = new File(getWorkingDirectory(), CHILD_PROCESS_PERSISTENT_DIR_NAME);
                }
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                sPersistentDirectory = file2;
                if (ApmContext.isDebugMode()) {
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
                    String str = ApmContext.getCurrentProcessName().replace(LibrarianImpl.Constants.DOT, "_").replace(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER) + ".bin";
                    if (!ApmContext.isMainProcess()) {
                        str = ApmContext.getInitTimeStamp() + "_" + str;
                    }
                    File file2 = new File(getPersistentDirectory(), str);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    sPersistentFile = file2;
                    if (ApmContext.isDebugMode()) {
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
                if (ApmContext.isDebugMode()) {
                    Logger.d(Constants.TAG, "prepare FlushDirectory success. name=" + sFlushDirectory);
                }
            }
            file = sFlushDirectory;
        }
        return file;
    }

    public static File getSubProcessPersistentDirectory() {
        return new File(getWorkingDirectory(), CHILD_PROCESS_PERSISTENT_DIR_NAME);
    }

    public static String generateFlushFileName() {
        return System.currentTimeMillis() + "_" + UUID.randomUUID().toString() + ".log";
    }
}
