package com.monitor.cloudmessage.handler.impl;

import com.bytedance.apm.ApmContext;
import com.monitor.cloudmessage.callback.IAdvanceAlogConsumer;
import com.monitor.cloudmessage.callback.IAlogConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.entity.ConsumerResult;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.refactor.CommandReportUtils;
import com.monitor.cloudmessage.refactor.CommandResultUploader;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AlogMessageHandler extends BaseMessageHandler {
    private static final String ALOG_FILE_TYPE = "log_agile";
    private static final String KEY_END_TIME = "fetch_end_time";
    private static final String KEY_START_TIME = "fetch_start_time";
    private static final String MSG_BACKUP_DATA = "兜底策略数据";
    private static final String MSG_MAINPROCESS_NOT_SET_ALOG_CONSUMER = "主进程收到命令，未设置ALog回捞组件。请宿主应用检查是否在合适时机设置ALog回捞组件。";
    private static final String MSG_SUBPROCESS_NOT_SET_ALOG_CONSUMER = "子进程\"$processName\"收到命令，等待主进程活跃后上报。";
    private IAlogConsumer mAlogConsumer;
    private List<String> mAlogFileList = new ArrayList();
    private volatile long mLastHandleTIme = 0;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.ALOG;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public synchronized boolean handleMessage(CloudMessage cloudMessage) throws Exception {
        JSONObject jSONObject = new JSONObject(cloudMessage.getParams());
        if (this.mAlogConsumer == null) {
            boolean isMainProcess = ApmContext.isMainProcess();
            String currentProcessName = ApmContext.getCurrentProcessName();
            if (currentProcessName == null) {
                currentProcessName = "";
            }
            CommandReportUtils.uploadRunningMessage(isMainProcess ? MSG_MAINPROCESS_NOT_SET_ALOG_CONSUMER : MSG_SUBPROCESS_NOT_SET_ALOG_CONSUMER.replace("$processName", currentProcessName), cloudMessage);
            return false;
        }
        if (System.currentTimeMillis() - this.mLastHandleTIme < 180000) {
            UploadInfo uploadInfo = new UploadInfo(0L, false, cloudMessage.getCommandId(), null);
            uploadInfo.setCloudMsgResponseCode(0);
            uploadInfo.setErrorMsg(ErrorMsg.COMMAND_NOT_EXECUTE_IN_3_MINS);
            CloudMessageUploadManager.upload(uploadInfo);
            return false;
        }
        this.mLastHandleTIme = System.currentTimeMillis();
        List<String> handleAlogData = this.mAlogConsumer.handleAlogData(jSONObject.optLong(KEY_START_TIME, (System.currentTimeMillis() / 1000) - 18000), jSONObject.optLong(KEY_END_TIME, System.currentTimeMillis() / 1000), jSONObject);
        ConsumerResult consumerResult = this.mAlogConsumer.getConsumerResult();
        if (handleAlogData == null || handleAlogData.size() == 0) {
            IAlogConsumer iAlogConsumer = this.mAlogConsumer;
            if ((iAlogConsumer instanceof IAdvanceAlogConsumer) && (handleAlogData = ((IAdvanceAlogConsumer) iAlogConsumer).getBackupAlogData()) != null && handleAlogData.size() != 0) {
                consumerResult = ConsumerResult.build(true, MSG_BACKUP_DATA, consumerResult.getSpecificParams());
            }
        }
        if (handleAlogData != null && handleAlogData.size() != 0 && consumerResult.isSuccess()) {
            this.mAlogFileList.clear();
            this.mAlogFileList.addAll(handleAlogData);
            File pendingDir = CommandResultUploader.getInstance().getPendingDir();
            if (pendingDir == null) {
                throw new CloudMessageException("pending目录因拿不到context而未设置");
            }
            File file = new File(pendingDir, cloudMessage.getCommandId() + "temp");
            if (file.exists()) {
                FileUtils.deleteFile(file);
            }
            file.mkdirs();
            File file2 = new File(file, cloudMessage.getCommandId() + "-cloudMsg.zip");
            if (file2.exists()) {
                file2.delete();
            }
            String[] strArr = (String[]) handleAlogData.toArray(new String[handleAlogData.size()]);
            FileUtils.compress(file2.getAbsolutePath(), strArr);
            CommandReportUtils.uploadRunningMessage("Alog回捞:" + Arrays.toString(strArr) + " ErrMsg=" + consumerResult.getErrMsg(), cloudMessage, consumerResult.getSpecificParams());
            CommandResultUploader.getInstance().upload(cloudMessage, file, ALOG_FILE_TYPE);
        } else if (!consumerResult.isSuccess()) {
            uploadFailStatus(consumerResult.getErrMsg(), consumerResult.getSpecificParams(), cloudMessage);
        }
        return true;
    }

    public void setAlogConsumer(IAlogConsumer iAlogConsumer) {
        this.mAlogConsumer = iAlogConsumer;
    }
}
