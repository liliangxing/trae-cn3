package com.bytedance.push.settings.helper;

import android.content.Context;
import com.bytedance.push.settings.logger.SettingsLoggerHelper;
import com.bytedance.push.settings.utils.SettingsUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: classes4.dex */
public class SettingsExclusiveFileLock {
    private static final String TAG = "SettingsExclusiveFileLock";
    private RandomAccessFile fd;
    private FileLock lock;
    private final String mFileName;
    private boolean mNeedMonitorLockRelease;
    private boolean sHasCheckIsFirst;
    private boolean sIsFirst;

    public SettingsExclusiveFileLock(String str, boolean z) {
        this.mFileName = str;
        this.mNeedMonitorLockRelease = z;
    }

    public SettingsExclusiveFileLock(String str) {
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
            SettingsLoggerHelper.getInstance().d(TAG, "isFirstLockFile: sIsFirst = " + this.sIsFirst + "  process = " + SettingsUtils.getCurProcessName(context) + file.getPath());
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
                if (this.mNeedMonitorLockRelease && fileLock == null) {
                    doLockBackground(this.fd);
                }
                return false;
            } finally {
                if (this.mNeedMonitorLockRelease && fileLock == null) {
                    doLockBackground(this.fd);
                }
            }
        }
    }

    private void doLockBackground(final RandomAccessFile randomAccessFile) {
        new Thread(new Runnable() { // from class: com.bytedance.push.settings.helper.SettingsExclusiveFileLock.1
            @Override // java.lang.Runnable
            public void run() {
                if (randomAccessFile == null) {
                    return;
                }
                try {
                    SettingsLoggerHelper.getInstance().d(SettingsExclusiveFileLock.TAG, "pending lock file , mNeedMonitorLockRelease is " + SettingsExclusiveFileLock.this.mNeedMonitorLockRelease);
                    FileLock lock = randomAccessFile.getChannel().lock();
                    if (lock != null) {
                        SettingsExclusiveFileLock.this.lock = lock;
                    }
                    SettingsLoggerHelper.getInstance().d(SettingsExclusiveFileLock.TAG, "lock file success!" + ((SettingsExclusiveFileLock.this.lock == null || !SettingsExclusiveFileLock.this.lock.isValid() || SettingsExclusiveFileLock.this.lock.isShared()) ? false : true));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }).start();
    }

    public void releaseLockFile() {
        try {
            this.lock.release();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
