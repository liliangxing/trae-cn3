package com.monitor.cloudmessage.handler.impl;

import com.bytedance.apm.util.CommonMonitorUtil;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.refactor.CommandReportUtils;
import com.monitor.cloudmessage.refactor.CommandResultUploader;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.File;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FileUploadMessageHandler extends BaseMessageHandler {
    private static final long DIR_SIZE_THRESHOLD = 134217728;
    private static final String KEY_RELATIVE_FILENAME = "relativeFilename";
    private static final String KEY_ROOT_NODE = "rootNode";
    private static final String KEY_SYSTEM_SO = "systemlib_so";
    private static final String SUFFIX_ART = ".art";
    private static final String SUFFIX_JAR = ".jar";
    private static final String SUFFIX_ODEX = ".odex";
    private static final String SUFFIX_SO = ".so";
    private static final String SUFFIX_VDEX = ".vdex";
    private long mLastHandleTime = 0;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.UPLOAD;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage cloudMessage) throws Exception {
        File joinFile;
        JSONObject paramsJson = cloudMessage.getParamsJson();
        if (System.currentTimeMillis() - this.mLastHandleTime < 120000) {
            CommandReportUtils.uploadRunningMessage("2分钟不重复处理文件回捞", cloudMessage);
            return false;
        }
        this.mLastHandleTime = System.currentTimeMillis();
        String optString = paramsJson.optString(KEY_ROOT_NODE);
        String optString2 = paramsJson.optString(KEY_RELATIVE_FILENAME);
        if (optString2.contains("../")) {
            throw new CloudMessageException("it's not allowed to use the form `../` to route in path");
        }
        if (KEY_SYSTEM_SO.equals(optString)) {
            if (optString2.endsWith(SUFFIX_SO) || optString2.endsWith(SUFFIX_ODEX) || optString2.endsWith(SUFFIX_JAR) || optString2.endsWith(SUFFIX_VDEX) || optString2.endsWith(SUFFIX_ART)) {
                joinFile = new File(optString2);
            } else {
                throw new CloudMessageException("非so, jar, odex, vdex, art 文件无权回捞");
            }
        } else {
            joinFile = FileUtils.joinFile(optString, optString2);
        }
        if (joinFile == null) {
            throw new CloudMessageException("目录参数解析失败");
        }
        CommandReportUtils.uploadRunningMessage("handling file upload:" + joinFile.getAbsolutePath(), cloudMessage);
        if (!joinFile.exists()) {
            throw new CloudMessageException("文件或目录不存在");
        }
        if (!joinFile.canRead()) {
            throw new CloudMessageException("文件或目录无可读权限");
        }
        if (joinFile.isDirectory() && CommonMonitorUtil.getFileDirSize(joinFile) > DIR_SIZE_THRESHOLD) {
            throw new CloudMessageException("回捞目录过大，禁止回捞");
        }
        File pendingDir = CommandResultUploader.getInstance().getPendingDir();
        if (pendingDir == null) {
            throw new CloudMessageException("pending目录因拿不到context而未设置");
        }
        File file = new File(pendingDir, cloudMessage.getCommandId() + "_temp");
        FileUtils.ensureDirectoryClean(file);
        FileUtils.compress(new File(file, "result.zip").getAbsolutePath(), joinFile.getAbsolutePath());
        CommandResultUploader.getInstance().upload(cloudMessage, file, paramsJson.optString("fileContentType", "unknown"));
        return true;
    }
}
