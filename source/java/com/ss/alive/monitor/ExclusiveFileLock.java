package com.ss.alive.monitor;

import android.content.Context;
import com.bytedance.push.utils.Logger;
import com.ss.alive.monitor.util.ToolUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: classes7.dex */
public class ExclusiveFileLock {
    private static final String TAG = "ExclusiveFileLock";
    private RandomAccessFile fd;
    private FileLock lock;
    private final String mFileName;
    private boolean sHasCheckIsFirst;
    private boolean sIsFirst;

    public ExclusiveFileLock(String str) {
        this.mFileName = str;
    }

    public boolean tryLockFile(Context context) {
        return isFirstLockFile(context);
    }

    public boolean isFirstLockFile(Context context) {
        try {
            if (this.sHasCheckIsFirst) {
                return this.sIsFirst;
            }
            this.sHasCheckIsFirst = true;
            File file = new File(context.getFilesDir(), this.mFileName);
            if (file.isDirectory()) {
                file.delete();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            this.sIsFirst = isFirstProcess(file);
            if (Logger.debug()) {
                Logger.d(TAG, "isFirstLockFile: sIsFirst = " + this.sIsFirst + "  process = " + ToolUtils.getCurProcessName(context) + file.getPath());
            }
            return this.sIsFirst;
        } catch (Throwable th) {
            th.printStackTrace();
            this.sIsFirst = false;
            return false;
        }
    }

    private boolean isFirstProcess(File file) {
        boolean z = false;
        if (!file.exists()) {
            return false;
        }
        boolean z2 = true;
        FileLock fileLock = null;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            this.fd = randomAccessFile;
            fileLock = randomAccessFile.getChannel().tryLock();
            if (fileLock != null) {
                this.lock = fileLock;
            }
            FileLock fileLock2 = this.lock;
            if (fileLock2 != null) {
                if (fileLock2.isValid()) {
                    z = true;
                }
            }
            return z;
        } catch (Throwable th) {
            try {
                if (!(th instanceof IOException) || !th.getMessage().contains("fcntl failed: EAGAIN")) {
                    z2 = false;
                }
                if (!z2) {
                    th.printStackTrace();
                }
                if (fileLock == null) {
                    doLockBackground(this.fd);
                }
                return false;
            } finally {
                if (fileLock == null) {
                    doLockBackground(this.fd);
                }
            }
        }
    }

    private void doLockBackground(final RandomAccessFile randomAccessFile) {
        new Thread(new Runnable() { // from class: com.ss.alive.monitor.ExclusiveFileLock.1
            @Override // java.lang.Runnable
            public void run() {
                if (randomAccessFile == null) {
                    return;
                }
                try {
                    Logger.d(ExclusiveFileLock.TAG, "pending lock file ...");
                    FileLock lock = randomAccessFile.getChannel().lock();
                    if (lock != null) {
                        ExclusiveFileLock.this.lock = lock;
                    }
                    Logger.d(ExclusiveFileLock.TAG, "lock file success!" + ((ExclusiveFileLock.this.lock == null || !ExclusiveFileLock.this.lock.isValid() || ExclusiveFileLock.this.lock.isShared()) ? false : true));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }).start();
    }
}
