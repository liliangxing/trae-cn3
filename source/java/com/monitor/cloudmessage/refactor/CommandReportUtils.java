package com.monitor.cloudmessage.refactor;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.Logger;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import com.monitor.cloudmessage.upload.net.CloudMessageUploadService;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CommandReportUtils {
    public static void uploadRunningMessage(String str, CloudMessage cloudMessage) {
        report(cloudMessage.getCommandId(), str, 0, null);
    }

    public static void uploadRunningMessage(String str, CloudMessage cloudMessage, Map<String, String> map) {
        report(cloudMessage.getCommandId(), str, 0, map);
    }

    public static void uploadSuccessMessage(String str) {
        report(str, "上传成功", 2, null);
    }

    public static void uploadFailureMessage(String str, String str2) {
        report(str2, str, 3, null);
    }

    public static void report(String str, String str2, int i, Map<String, String> map) {
        if (ApmContext.isDebugMode()) {
            Logger.d("cloudmessage", new String[]{"report: commandId=" + str, ", message=" + str2, ", code=" + i, ", specificParams=" + map});
        }
        UploadInfo uploadInfo = new UploadInfo(0L, false, str, map != null ? new HashMap(map) : null);
        uploadInfo.setCloudMsgResponseCode(i);
        uploadInfo.setErrorMsg(str2);
        CloudMessageUploadManager.upload(uploadInfo);
    }

    public static boolean uploadFile(String str, File file, String str2, String str3) {
        if (ApmContext.isDebugMode()) {
            Logger.d("cloudmessage", new String[]{"postFile: commandId=" + str, "postFile=" + file.getAbsolutePath(), ", uploadMessage=" + str3, ", fileType=" + str2});
        }
        return CloudMessageUploadService.uploadFile(file, 1, str2, str, str3, System.currentTimeMillis(), null);
    }
}
