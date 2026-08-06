package com.bytedance.reparo.core.utils;

import com.bytedance.reparo.core.common.utils.FileUtils;
import java.io.File;
import java.io.IOException;

/* loaded from: classes4.dex */
public class TimesRecorder {
    public static boolean enableCrashProtect = true;
    private int mCurrentTimes;
    private File mFile;
    private int mMaxTimes;
    private Runnable mOnMaxRunnable;

    public static void checkParseCost(long j) {
        if (!enableCrashProtect || j < 300) {
            return;
        }
        enableCrashProtect = false;
    }

    public TimesRecorder(File file, String str, int i, String str2) {
        this(file, str, i, str2, null);
        this.mFile = new File(file, str + "@" + str2.hashCode());
        this.mMaxTimes = i;
    }

    public TimesRecorder(File file, String str, int i, String str2, Runnable runnable) {
        this.mCurrentTimes = -1;
        this.mOnMaxRunnable = null;
        this.mFile = new File(file, str + "@" + str2.hashCode());
        this.mMaxTimes = i;
        this.mOnMaxRunnable = runnable;
    }

    private int getTimes() {
        int i = this.mCurrentTimes;
        if (i >= 0) {
            return i;
        }
        if (!this.mFile.exists()) {
            return 0;
        }
        try {
            this.mCurrentTimes = Integer.parseInt(FileUtils.readStr(this.mFile));
        } catch (Throwable unused) {
        }
        if (this.mCurrentTimes < 0) {
            this.mCurrentTimes = 0;
        }
        return this.mCurrentTimes;
    }

    private void setTimes(int i) {
        Runnable runnable;
        this.mCurrentTimes = i;
        try {
            FileUtils.writeFile(this.mFile, String.valueOf(i), false);
        } catch (IOException unused) {
        }
        if (!check() || (runnable = this.mOnMaxRunnable) == null) {
            return;
        }
        runnable.run();
    }

    public boolean check() {
        return getTimes() >= this.mMaxTimes;
    }

    public boolean checkOrIncrement() {
        if (check()) {
            return true;
        }
        setTimes(getTimes() + 1);
        return false;
    }

    public void clear() {
        this.mFile.delete();
    }
}
