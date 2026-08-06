package com.monitor.cloudmessage.refactor;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.utils.FileUtils;
import com.monitor.cloudmessage.utils.NetworkUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CommandResultUploader {
    private static final long IGNORE_WIFI_ONLY_PARAMS_THRESHOLD = 2097152;
    private static final String PENDING_UPLOAD_DIR = "cloud_uploading";
    private volatile File pendingDir;
    private final Map<String, Boolean> wifiOnlyResultMap = new HashMap();

    public static CommandResultUploader getInstance() {
        return InnerHolder.instance;
    }

    public File getPendingDir() {
        if (this.pendingDir == null) {
            if (ApmContext.getContext() == null) {
                return null;
            }
            this.pendingDir = new File(ApmContext.getContext().getFilesDir(), PENDING_UPLOAD_DIR);
        }
        ensureDirExist();
        return this.pendingDir;
    }

    public boolean isWifiOnly(String str) {
        return this.wifiOnlyResultMap.get(str) == Boolean.TRUE;
    }

    public synchronized void upload(CloudMessage cloudMessage, File file, String str) throws Exception {
        CommandReportUtils.uploadRunningMessage("命令产物已生成，等待上传", cloudMessage);
        ensureDirExist();
        String commandId = cloudMessage.getCommandId();
        File pendingDir = getPendingDir();
        if (pendingDir == null) {
            throw new CloudMessageException("pending目录因拿不到context而未设置");
        }
        File file2 = new File(pendingDir, commandId);
        if (file2.exists()) {
            FileUtils.deleteFile(file2);
        }
        file.renameTo(file2);
        long fileDirSize = CommonMonitorUtil.getFileDirSize(file2);
        boolean z = true;
        boolean z2 = cloudMessage.isWifiOnly() && fileDirSize > IGNORE_WIFI_ONLY_PARAMS_THRESHOLD;
        this.wifiOnlyResultMap.put(commandId, Boolean.valueOf(z2));
        if (z2 && !NetworkUtils.isWifi(CloudMessageManager.getInstance().getContext())) {
            CommandReportUtils.uploadRunningMessage("产物超过阈值，等待WiFi环境执行. fileTotalSize=" + fileDirSize, cloudMessage);
            return;
        }
        for (File file3 : file2.listFiles(new FileFilter() { // from class: com.monitor.cloudmessage.refactor.CommandResultUploader.1
            @Override // java.io.FileFilter
            public boolean accept(File file4) {
                return file4.isFile();
            }
        })) {
            boolean uploadFile = CommandReportUtils.uploadFile(commandId, file3, str, "正在上传:" + file3.getName());
            CommandReportUtils.uploadRunningMessage("文件上传" + (uploadFile ? "成功" : "失败") + Constants.COLON_SEPARATOR + file3.getName(), cloudMessage);
            if (!uploadFile) {
                z = false;
            }
        }
        if (z) {
            CommandReportUtils.uploadSuccessMessage(commandId);
        }
        FileUtils.deleteFile(file2);
    }

    private void ensureDirExist() {
        if (this.pendingDir == null || this.pendingDir.exists()) {
            return;
        }
        this.pendingDir.mkdirs();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class InnerHolder {
        private static final CommandResultUploader instance = new CommandResultUploader();

        private InnerHolder() {
        }
    }
}
