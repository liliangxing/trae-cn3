package com.bytedance.crash.plugin;

import android.os.Process;
import com.bytedance.crash.Global;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.mira.NpthMira;
import com.bytedance.crash.mira.NpthMiraApi;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.JSONWriter;
import com.example.npth_morpheus.NpthMorpheus;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PluginInfoManager {
    private static final long DELAY_MILLIS = 1000;
    private static final String DIRECTORY = "plugin";
    public static final String MIRA_INIT = "mira_init";
    private static final String SUFFIX = ".json";
    private static File sCurrentFile;
    private static File sDirectory;
    private static final Pattern sFileNamePattern = Pattern.compile("^(\\d+)-(\\d+)\\.json");
    private static long sLastUpdatedTime;

    private static File getDirectory() {
        File rootDirectory;
        if (sDirectory == null && (rootDirectory = Global.getRootDirectory()) != null) {
            sDirectory = FileSystemUtils.createDirectory(rootDirectory, DIRECTORY);
        }
        return sDirectory;
    }

    private static File getFile() {
        if (sCurrentFile == null) {
            long appStartTime = Global.getAppStartTime();
            int myPid = Process.myPid();
            File directory = getDirectory();
            if (directory != null) {
                sCurrentFile = new File(directory, appStartTime + "-" + myPid + SUFFIX);
            }
        }
        return sCurrentFile;
    }

    private static File getSavedFile(String str) {
        File directory = getDirectory();
        if (directory != null) {
            return new File(directory, str + SUFFIX);
        }
        return null;
    }

    public static void init() {
        try {
            NpthMorpheus.init();
        } catch (Throwable unused) {
        }
        try {
            NpthMira.init();
        } catch (Throwable unused2) {
        }
        NpthMiraApi.registerMiraCallback(new NpthMiraApi.MiraPluginEventListener() { // from class: com.bytedance.crash.plugin.PluginInfoManager.1
            @Override // com.bytedance.crash.mira.NpthMiraApi.MiraPluginEventListener
            public void onPluginInstallResult(String str, boolean z) {
                PluginInfoManager.postUpdate();
            }

            @Override // com.bytedance.crash.mira.NpthMiraApi.MiraPluginEventListener
            public void onPluginLoaded(String str) {
                PluginInfoManager.postUpdate();
            }
        });
        DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.plugin.PluginInfoManager.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PluginInfoManager.clean();
                } catch (Throwable unused3) {
                }
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void postUpdate() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = sLastUpdatedTime;
        if (j == 0 || currentTimeMillis - j > 1000) {
            sLastUpdatedTime = currentTimeMillis;
            DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.plugin.PluginInfoManager.3
                @Override // java.lang.Runnable
                public void run() {
                    PluginInfoManager.update();
                }
            }, 1000L);
        }
    }

    private static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clean() {
        File[] listFiles;
        File[] listFiles2;
        File directory = getDirectory();
        if (directory == null || (listFiles = directory.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        File[] listFiles3 = new File("/proc").listFiles();
        if (listFiles3 != null && listFiles3.length != 0) {
            for (File file : listFiles3) {
                if (isNumeric(file.getName())) {
                    arrayList.add(file.getName());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        File rootDirectory = CrashManager.getRootDirectory();
        if (rootDirectory != null && (listFiles2 = rootDirectory.listFiles()) != null && listFiles2.length != 0) {
            for (File file2 : listFiles2) {
                arrayList2.add(file2.getName() + SUFFIX);
            }
        }
        File[] listFiles4 = new File(Global.getRootDirectory(), AnrManager.ANR_ROOT_DIR).listFiles();
        if (listFiles4 != null && listFiles4.length != 0) {
            for (File file3 : listFiles4) {
                arrayList2.add(file3.getName() + SUFFIX);
            }
        }
        for (File file4 : listFiles) {
            String name = file4.getName();
            if (!arrayList2.contains(name)) {
                Matcher matcher = sFileNamePattern.matcher(name);
                if (matcher.find() && matcher.groupCount() == 2) {
                    String group = matcher.group(1);
                    long parseLong = group != null ? Long.parseLong(group) : 0L;
                    String group2 = matcher.group(2);
                    if (parseLong != Global.getAppStartTime()) {
                        if (parseLong <= currentTimeMillis) {
                            if (arrayList.contains(group2)) {
                            }
                        }
                    }
                }
                FileSystemUtils.deleteAll(file4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void update() {
        JSONArray pluginInfo;
        if (!NpthMiraApi.miraInited() || (pluginInfo = NpthMiraApi.getPluginInfo()) == null || pluginInfo.length() == 0) {
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getFile(), false));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("plugin_info", pluginInfo);
                jSONObject.put(MIRA_INIT, true);
                JSONWriter.writeTo(jSONObject, bufferedWriter);
            } catch (Throwable unused) {
            }
            FileSystemUtils.close(bufferedWriter);
        } catch (Throwable unused2) {
        }
    }

    public static JSONArray getPluginInfo() {
        return NpthMiraApi.getPluginInfo();
    }

    public static void pushTo(JSONObject jSONObject, File file) {
        String readUtf8File;
        File savedFile = getSavedFile(file.getName());
        if (savedFile != null && savedFile.exists() && (readUtf8File = FileSystemUtils.readUtf8File(savedFile)) != null) {
            try {
                JSONUtils.combineJson(jSONObject, new JSONObject(readUtf8File));
                return;
            } catch (Throwable th) {
                NpthMonitor.reportInnerException("pushTo", th);
            }
        }
        JSONUtils.put(jSONObject, MIRA_INIT, false);
    }

    public static void pushTo(JSONObject jSONObject) {
        if (!NpthMiraApi.miraInited()) {
            JSONUtils.put(jSONObject, MIRA_INIT, false);
            return;
        }
        JSONArray pluginInfo = NpthMiraApi.getPluginInfo();
        if (pluginInfo != null && pluginInfo.length() != 0) {
            try {
                JSONUtils.put(jSONObject, "plugin_info", pluginInfo);
                JSONUtils.put(jSONObject, MIRA_INIT, true);
                return;
            } catch (Throwable unused) {
            }
        }
        JSONUtils.put(jSONObject, MIRA_INIT, false);
    }
}
