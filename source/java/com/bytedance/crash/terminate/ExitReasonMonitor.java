package com.bytedance.crash.terminate;

import android.app.ApplicationExitInfo;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IApmAgent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ExitReasonMonitor {
    static final int REASON_LIMIT_FILE_SIZE = 50;
    private static List<ApplicationExitInfo> infos = new ArrayList();
    private static boolean mExitReasonParsed;

    private static long getLastExitReasonTime() {
        File file = new File(TerminateMonitor.mTerminateHistoryDirectory, "lastReasonTime");
        if (file.exists()) {
            try {
                return TerminateMonitor.decodeWithCatch(FileUtils.readFile(file), -1L);
            } catch (IOException unused) {
            }
        }
        return -1L;
    }

    private static void setExitReasonTime() {
        try {
            FileUtils.writeFile(new File(TerminateMonitor.mTerminateHistoryDirectory, "lastReasonTime"), String.valueOf(System.currentTimeMillis()), false);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<ApplicationExitInfo> parseExitReason() {
        List<ApplicationExitInfo> processExitReasons;
        if (mExitReasonParsed) {
            return infos;
        }
        mExitReasonParsed = true;
        if (!AppExitInfoUtils.enableProcessExitReason()) {
            return null;
        }
        try {
            processExitReasons = AppExitInfoUtils.getProcessExitReasons();
        } finally {
            try {
                clearExitInfo();
                return infos;
            } finally {
            }
        }
        if (processExitReasons == null) {
            return null;
        }
        long lastExitReasonTime = getLastExitReasonTime();
        for (ApplicationExitInfo applicationExitInfo : processExitReasons) {
            if (applicationExitInfo.getTimestamp() < lastExitReasonTime) {
                break;
            }
            infos.add(applicationExitInfo);
            TerminateMonitor.callExitReasonCallbacks(applicationExitInfo);
        }
        if (infos.size() == 0) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                IApmAgent iApmAgent = (IApmAgent) ServiceManager.getService(IApmAgent.class);
                if (iApmAgent != null) {
                    jSONObject.put("reason", "1");
                    jSONObject2.put(OaidModel.KEY_TIME, lastExitReasonTime);
                    iApmAgent.monitorEvent(AppExitInfoUtils.APP_EXIT, jSONObject, (JSONObject) null, (JSONObject) null);
                }
            } catch (Throwable unused) {
            }
        }
        TerminateMonitor.callExitReasonCallback(infos);
        setExitReasonTime();
        clearExitInfo();
        return infos;
    }

    static void clearExitInfo() {
        String[] list;
        File file = new File(TerminateMonitor.mTerminateHistoryDirectory, TerminateMonitor.EXIT_INFO_PATH);
        if (file.exists() && (list = file.list()) != null) {
            if (list.length > 50) {
                Arrays.sort(list);
                for (int i = 50; i < list.length; i++) {
                    FileUtils.deleteFile(new File(file, list[i]));
                }
            }
        }
    }
}
