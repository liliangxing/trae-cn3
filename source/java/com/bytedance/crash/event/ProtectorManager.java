package com.bytedance.crash.event;

import android.os.Process;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.coredump.CoredumpAdapter;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ProtectorManager {
    private static final String TAG = "ProtectorManager";

    public static void upload() {
        File[] listFiles;
        File file = new File(Global.getRootDirectory(), "protector");
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                uploadOne(file2);
            }
        }
    }

    private static boolean uploadOne(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            NpthLog.m234i(TAG, "upload " + file.getAbsolutePath());
            AppMonitor appMonitor = MonitorManager.getAppMonitor();
            if (appMonitor == null) {
                return false;
            }
            JSONObject json = Header.createEventHeader(appMonitor, currentTimeMillis, CrashType.NATIVE_CUSTOMIZE, Process.myPid()).getJson();
            CrashSummary loadFromDirectory = CrashSummary.loadFromDirectory(file);
            if (loadFromDirectory == null) {
                NpthLog.m236w(TAG, "upload delete dir" + file.getAbsolutePath());
                FileSystemUtils.deleteAll(file);
                return false;
            }
            JSONObject json2 = loadFromDirectory.assemblyCrashBody(appMonitor).getJson();
            json2.put("event_type", "native_exception");
            json2.put("message", "protector");
            json2.put("log_type", "1");
            json2.put("timestamp", System.currentTimeMillis());
            json2.put(ApmTrafficStats.KEY_EXCEPTION_TYPE, 1);
            String stackTrace = loadFromDirectory.getStackTrace();
            if (stackTrace != null) {
                json2.put(EnsureReportData.CLASS_REF, "Native");
                json2.put("method", "Native");
                json2.put("is_core", 1);
                json2.put(EnsureReportData.LINE_NUM, -1);
                json2.put(EnsureReportData.ENSURE_TYPE, EnsureDeliverer.ENSURE_NOT_REACH_HERE);
                json2.put(CrashBody.CRASH_LIB_UUID, NativeTools.get().getSoUUID(stackTrace));
                json2.put("stack", stackTrace);
                json2.put(Constants.HAS_DUMP, "true");
            }
            JSONObject optJSONObject = json2.optJSONObject("filters");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                json2.put("filters", optJSONObject);
            }
            CoredumpAdapter.upload(appMonitor, loadFromDirectory, file, optJSONObject);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(json2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", jSONArray);
            jSONObject.put("header", json);
            boolean isSuccess = CrashUploader.uploadCrashLogWithAttachment("ensure_zip", UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionZipUploadUrl(), json), jSONObject.toString(), getAttachmentFileList(file)).isSuccess();
            if (isSuccess) {
                NpthLog.m228d(TAG, "upload success");
                FileUtils.deleteFile(file);
            }
            return isSuccess;
        } catch (Exception unused) {
            return false;
        }
    }

    private static List<File> getAttachmentFileList(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (!name.endsWith(".summary") && !name.endsWith(".json") && !name.endsWith(".inf")) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }
}
