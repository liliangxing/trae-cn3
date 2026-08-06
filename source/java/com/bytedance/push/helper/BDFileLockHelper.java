package com.bytedance.push.helper;

import android.content.Context;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.ToolUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BDFileLockHelper {
    private static final String TAG = "FileLockHelper";
    private static final Map<String, BDFileLockHelper> sLockHelperMap = new HashMap();
    private FileLock lock;
    private final String mFileName;
    private RandomAccessFile mRandomAccessFile;

    public static BDFileLockHelper getInstance(String str) {
        Map<String, BDFileLockHelper> map = sLockHelperMap;
        BDFileLockHelper bDFileLockHelper = map.get(str);
        if (bDFileLockHelper == null) {
            synchronized (map) {
                bDFileLockHelper = map.get(str);
                if (bDFileLockHelper == null) {
                    bDFileLockHelper = new BDFileLockHelper(str);
                    map.put(str, bDFileLockHelper);
                }
            }
        }
        return bDFileLockHelper;
    }

    private BDFileLockHelper(String str) {
        this.mFileName = str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x001a -> B:15:0x004d). Please report as a decompilation issue!!! */
    public boolean unLock() {
        FileLock fileLock = this.lock;
        try {
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileLock == null) {
            return false;
        }
        try {
            try {
                fileLock.release();
                try {
                    this.lock.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                RandomAccessFile randomAccessFile = this.mRandomAccessFile;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                try {
                    this.lock.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                RandomAccessFile randomAccessFile2 = this.mRandomAccessFile;
                if (randomAccessFile2 == null) {
                    return false;
                }
                randomAccessFile2.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                this.lock.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            RandomAccessFile randomAccessFile3 = this.mRandomAccessFile;
            if (randomAccessFile3 != null) {
                try {
                    randomAccessFile3.close();
                    throw th;
                } catch (IOException e6) {
                    e6.printStackTrace();
                    throw th;
                }
            }
            throw th;
        }
    }

    public boolean lock(Context context) {
        try {
            File file = new File(context.getFilesDir(), this.mFileName);
            if (file.isDirectory()) {
                file.delete();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            boolean lockFile = lockFile(file);
            if (Logger.debug()) {
                Logger.m268d(TAG, "isFirstLockFile: sIsFirst = " + lockFile + "  process = " + ToolUtils.getCurProcessName(context) + file.getPath());
            }
            return lockFile;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private boolean lockFile(File file) {
        if (!file.exists()) {
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            this.mRandomAccessFile = randomAccessFile;
            FileLock lock = randomAccessFile.getChannel().lock();
            if (lock != null) {
                this.lock = lock;
            }
            FileLock fileLock = this.lock;
            if (fileLock != null) {
                return fileLock.isValid();
            }
            return false;
        } catch (Throwable th) {
            if (!((th instanceof IOException) && th.getMessage().contains("fcntl failed: EAGAIN"))) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
