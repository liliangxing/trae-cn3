package com.bytedance.crash.tracker;

import android.text.TextUtils;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.crash.Global;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.DateUtils;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ProcessTracker {
    private static final String DIR = "processTrack";
    private static final int MAX_DAY = 5;
    private static File currentDayDir;
    private static File currentFile;
    private static File currentProcessDir;
    private static ProcessTracker instance = new ProcessTracker();
    private static volatile boolean isInited;
    private static File rootDir;
    private boolean isEnable;

    private ProcessTracker() {
    }

    public static ProcessTracker getInstance() {
        return instance;
    }

    public void start() {
        if (App.isMainProcess()) {
            DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.tracker.ProcessTracker.1
                @Override // java.lang.Runnable
                public void run() {
                    ProcessTracker.this.clear();
                }
            }, GWorker.INTERVAL);
        }
    }

    private void init() {
        if (isInited) {
            return;
        }
        File file = new File(Global.getRootDirectory(), DIR);
        rootDir = file;
        FileSystemUtils.createDirectory(file);
        File file2 = new File(rootDir, String.valueOf(Global.getAppStartTime() / 86400000));
        currentDayDir = file2;
        FileSystemUtils.createDirectory(file2);
        File file3 = new File(currentDayDir, App.getProcessName());
        currentProcessDir = file3;
        FileSystemUtils.createDirectory(file3);
        isInited = true;
    }

    public void setEnable(boolean z) {
        if (z) {
            this.isEnable = true;
        }
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clear() {
        File[] listFiles;
        if (App.isMainProcess()) {
            init();
            File file = rootDir;
            if (file == null || (listFiles = file.listFiles()) == null) {
                return;
            }
            try {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.bytedance.crash.tracker.ProcessTracker.2
                    @Override // java.util.Comparator
                    public int compare(File file2, File file3) {
                        return file2.getName().compareTo(file3.getName());
                    }
                });
            } catch (Exception unused) {
            }
            int appStartTime = (int) (Global.getAppStartTime() / 86400000);
            for (File file2 : listFiles) {
                try {
                    if (Math.abs(appStartTime - Integer.valueOf(file2.getName()).intValue()) >= 5) {
                        FileUtils.deleteFile(file2);
                    }
                } catch (Exception unused2) {
                }
            }
            DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.tracker.ProcessTracker.3
                @Override // java.lang.Runnable
                public void run() {
                    ProcessTracker.this.clear();
                }
            }, 120000L);
        }
    }

    public void addEvent(String str, String str2, long j) {
        try {
            File currentFile2 = getCurrentFile();
            if (currentFile2 != null) {
                FileUtils.writeFile(currentFile2, str + ' ' + str2 + ' ' + DateUtils.getFileDateInstance().format(new Date(j)) + '\n', true);
            }
        } catch (Throwable unused) {
        }
    }

    public File getCurrentFile() {
        File file = currentFile;
        if (file != null) {
            return file;
        }
        init();
        if (currentProcessDir != null) {
            File file2 = new File(currentProcessDir, String.valueOf(Global.getAppStartTime()));
            currentFile = file2;
            return file2;
        }
        return currentFile;
    }

    public File getProcessTrackFile(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(Global.getRootDirectory(), DIR + File.separator + String.valueOf(j / 86400000) + File.separator + str + File.separator + String.valueOf(j));
    }
}
