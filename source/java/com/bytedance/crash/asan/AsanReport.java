package com.bytedance.crash.asan;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.LogPathConfig;
import com.bytedance.crash.dumper.BuildId;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AsanReport {
    private static final String DIR_NAME = "asan";

    public static void upload() {
        File[] listFiles;
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor == null) {
            return;
        }
        File file = new File(LogPathConfig.getNpthRootPath(), DIR_NAME);
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        Pattern compile = Pattern.compile("^asan_report\\.(\\d{1,5})$");
        int length = listFiles.length;
        for (int i = 0; i < length; i++) {
            File file2 = listFiles[i];
            try {
                Matcher matcher = compile.matcher(file2.getName());
                if (matcher.find() && matcher.groupCount() == 1) {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    long time = new Date(file2.lastModified()).getTime();
                    CrashBody crashBody = new CrashBody();
                    String readUtf8File = FileSystemUtils.readUtf8File(file2);
                    if (readUtf8File == null || readUtf8File.length() == 0) {
                        readUtf8File = "AsanReport is Null";
                    }
                    crashBody.put("data", readUtf8File);
                    crashBody.put("crash_time", Long.valueOf(time));
                    crashBody.put(Header.KEY_CRASH_TYPE, DIR_NAME);
                    crashBody.put(CrashBody.IS_NATIVE_CRASH, 1);
                    crashBody.put("commit_id", "1");
                    crashBody.put("jenkins_job_id", "1");
                    BuildId.putAsanBuildIdToJson(crashBody.getJson(), file2);
                    crashBody.setHeader(Header.createEventHeader(appMonitor, time, CrashType.ASAN, parseInt));
                    NpthLog.m233i(file2.getName() + "upload " + (CrashUploader.uploadCrashLogWithAttachment(DIR_NAME, UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.ASAN, crashBody.getHeader().getJson()), crashBody.getJson().toString(), new ArrayList()).isSuccess() ? "success" : "fail"));
                }
            } finally {
                try {
                    FileUtils.deleteFile(file2);
                } catch (Throwable th) {
                }
            }
            FileUtils.deleteFile(file2);
        }
    }
}
