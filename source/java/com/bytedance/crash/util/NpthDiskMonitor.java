package com.bytedance.crash.util;

import com.bytedance.crash.CrashAgent;
import com.bytedance.crash.Global;
import com.bytedance.crash.event.EventConfig;
import com.bytedance.crash.runtime.DefaultWorkThread;
import java.io.File;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NpthDiskMonitor {
    public static String SERVICE_NAME = "npth_disk_event";
    private static NpthDiskMonitor sInstance = new NpthDiskMonitor();

    private NpthDiskMonitor() {
    }

    public static NpthDiskMonitor getInstance() {
        return sInstance;
    }

    public void setConfig(EventConfig eventConfig) {
        if (eventConfig != null && eventConfig.isSampled(SERVICE_NAME)) {
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.util.NpthDiskMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        File[] listFiles = Global.getRootDirectory().listFiles();
                        JSONObject jSONObject = new JSONObject();
                        if (listFiles != null && listFiles.length > 0) {
                            for (File file : listFiles) {
                                jSONObject.put(file.getName(), NpthDiskMonitor.getDirSize(file));
                            }
                        }
                        CrashAgent.monitorEvent(NpthDiskMonitor.SERVICE_NAME, jSONObject, null, null);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void init() {
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.util.NpthDiskMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                NpthDiskMonitor.this.cleanOldDir();
            }
        });
    }

    public void cleanOldDir() {
        try {
            File rootDirectory = Global.getRootDirectory();
            if (new File(rootDirectory, "crash.deleted").exists()) {
                return;
            }
            FileUtils.deleteFile(new File(rootDirectory, "RuntimeContext"));
            FileUtils.deleteFile(new File(rootDirectory, "ProcessTrack"));
            FileUtils.deleteFile(new File(rootDirectory, "TrackInfo"));
            FileUtils.deleteFile(new File(rootDirectory, "CrashCommonLog"));
            FileUtils.deleteFile(new File(rootDirectory, "CrashLogJava"));
            FileUtils.deleteFile(new File(rootDirectory, "CrashLogNative"));
            FileUtils.deleteFile(new File(rootDirectory, "procanr"));
            FileUtils.deleteFile(new File(rootDirectory, "configCrash"));
            new File(rootDirectory, "crash.deleted").createNewFile();
        } catch (Throwable unused) {
        }
    }

    public static long getDirSize(File file) {
        long j = 0;
        if (!file.exists()) {
            return 0L;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                j += getDirSize(file2);
            }
            return j;
        }
        return file.length() / 1024;
    }
}
