package com.bytedance.crash.resource.utils;

import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class GuardFile {
    public static final long DEFAULT_EXPIRE_TIME = 604800;
    private static final String TAG = "GuardFile: ";
    private final long mExpireTime;
    private final File mGuardFile;
    private final String mGuardFileName;

    public GuardFile(String str, String str2, long j) {
        this.mGuardFile = new File(str, str2);
        this.mGuardFileName = str2;
        this.mExpireTime = j <= 0 ? 604800L : j;
    }

    public void createGuardFile() {
        try {
            FileUtils.writeFile(this.mGuardFile, String.valueOf(System.currentTimeMillis() / 1000), false);
            NpthLog.i(TAG, this.mGuardFileName + ": createGuardFile success");
        } catch (Throwable unused) {
            NpthLog.i(TAG, this.mGuardFileName + ": createGuardFile fail");
        }
    }

    public boolean checkGuardFile() {
        if (!this.mGuardFile.exists()) {
            return true;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long parseLong = Long.parseLong(FileUtils.readFile(this.mGuardFile.getAbsolutePath()));
            if (currentTimeMillis < parseLong) {
                NpthLog.i(TAG, this.mGuardFileName + ": time error currentTime is earlier than lastTime");
                return false;
            }
            if (currentTimeMillis - parseLong < this.mExpireTime) {
                NpthLog.i(TAG, this.mGuardFileName + ": CheckTime Less than " + this.mExpireTime + " seconds, lastTime:" + parseLong + " currentTime:" + currentTimeMillis);
                return false;
            }
            FileUtils.deleteFile(this.mGuardFile.getAbsolutePath());
            NpthLog.i(TAG, this.mGuardFileName + ": deleteFile guard file");
            return true;
        } catch (IOException unused) {
            NpthLog.i(TAG, this.mGuardFileName + ": read guard file faild!");
            return false;
        }
    }

    public void deleteGurardFile() {
        if (this.mGuardFile.exists()) {
            if (!this.mGuardFile.delete()) {
                NpthLog.i(TAG, "delete guard file faild!");
            } else {
                NpthLog.i(TAG, "delete guard file success");
            }
        }
    }
}
