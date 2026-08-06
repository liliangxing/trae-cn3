package com.bytedance.reparo.core.parse;

import com.bytedance.reparo.core.PatchLogger;
import com.bytedance.reparo.core.common.utils.FileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* loaded from: classes4.dex */
public class FileLockHelper implements Closeable {
    public static final int LOCK_WAIT_EACH_TIME = 10;
    public static final int MAX_LOCK_ATTEMPTS = 3;
    private static final String TAG = "FileLockHelper";
    private final FileLock fileLock;
    private final FileOutputStream outputStream;

    private FileLockHelper(File file) throws IOException {
        FileUtils.ensureFileExist(file);
        this.outputStream = new FileOutputStream(file);
        FileLock fileLock = null;
        int i = 0;
        Exception e = null;
        while (i < 3) {
            i++;
            try {
                fileLock = this.outputStream.getChannel().lock();
                if (fileLock != null) {
                    break;
                }
            } catch (Exception e2) {
                e = e2;
                PatchLogger.e(TAG, "getInfoLock Thread failed time:10");
            }
            try {
                Thread.sleep(10L);
            } catch (Exception e3) {
                PatchLogger.e(TAG, "getInfoLock Thread sleep exception", e3);
            }
        }
        if (fileLock == null) {
            throw new IOException("FileLockHelper lock file failed: " + file.getAbsolutePath(), e);
        }
        this.fileLock = fileLock;
    }

    public static FileLockHelper getFileLock(File file) throws IOException {
        return new FileLockHelper(file);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            FileLock fileLock = this.fileLock;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            FileOutputStream fileOutputStream = this.outputStream;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}
