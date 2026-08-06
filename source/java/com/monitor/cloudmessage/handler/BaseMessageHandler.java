package com.monitor.cloudmessage.handler;

import com.bytedance.apm.logging.Logger;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.refactor.CommandReportUtils;
import com.monitor.cloudmessage.refactor.CommandResultUploader;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import com.monitor.cloudmessage.utils.ExceptionUtils;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class BaseMessageHandler implements IMessageHandler {
    private static final long COMMAND_INTERNAL = 10000;
    private static ConcurrentHashMap<String, Long> cmdIdMap = new ConcurrentHashMap<>();

    public abstract String getCloudControlType();

    public abstract boolean handleMessage(CloudMessage cloudMessage) throws Exception;

    @Override // com.monitor.cloudmessage.handler.IMessageHandler
    public synchronized boolean handleCloudMessage(CloudMessage cloudMessage) {
        if (!getCloudControlType().equals(cloudMessage.getType())) {
            return false;
        }
        try {
            try {
                if (isTypeInBlockList()) {
                    handleMsgInBlackList(cloudMessage);
                    return true;
                }
                if (checkCmdInterval(cloudMessage) && checkResultCanUpload(cloudMessage)) {
                    Logger.d("cloudmessage", new String[]{"start handle message:" + cloudMessage});
                    return handleMessage(cloudMessage);
                }
                Logger.d("cloudmessage", new String[]{"checkCmdInterval false: ignored for now."});
                return false;
            } catch (CloudMessageException e) {
                uploadFailStatus(e.getMessage(), cloudMessage);
                return false;
            }
        } catch (Exception e2) {
            uploadFailStatus(String.format("系统错误：%s", ExceptionUtils.getFullStacktrace(e2)), cloudMessage);
            return false;
        }
    }

    protected boolean checkResultCanUpload(CloudMessage cloudMessage) {
        if (!CommandResultUploader.getInstance().isWifiOnly(cloudMessage.getCommandId()) || NetworkUtils.isWifi(CloudMessageManager.getInstance().getContext())) {
            return true;
        }
        CommandReportUtils.uploadRunningMessage("产物超过阈值，等待WiFi环境执行", cloudMessage);
        return false;
    }

    protected boolean isTypeInBlockList() {
        if (CloudMessageManager.getBlackListForCloudContrlInf() != null) {
            for (String str : CloudMessageManager.getBlackListForCloudContrlInf()) {
                if (getCloudControlType().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void handleMsgInBlackList(CloudMessage cloudMessage) {
        UploadInfo uploadInfo = new UploadInfo(0L, false, cloudMessage.getCommandId(), null);
        uploadInfo.setCloudMsgResponseCode(3);
        uploadInfo.setErrorMsg(ErrorMsg.COMMAND_IN_SDK_BLACK_LIST);
        CloudMessageUploadManager.upload(uploadInfo);
    }

    private boolean checkCmdInterval(CloudMessage cloudMessage) {
        String commandId = cloudMessage.getCommandId();
        if (cmdIdMap.containsKey(commandId)) {
            if (System.currentTimeMillis() - cmdIdMap.get(commandId).longValue() < COMMAND_INTERNAL) {
                return false;
            }
            cmdIdMap.put(commandId, Long.valueOf(System.currentTimeMillis()));
            return true;
        }
        cmdIdMap.put(commandId, Long.valueOf(System.currentTimeMillis()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkWifiOnly(JSONObject jSONObject, CloudMessage cloudMessage) {
        if (!jSONObject.optBoolean("wifiOnly", false) || NetworkUtils.isWifi(CloudMessageManager.getInstance().getContext())) {
            return false;
        }
        UploadInfo uploadInfo = new UploadInfo(0L, false, cloudMessage.getCommandId(), null);
        uploadInfo.setCloudMsgResponseCode(0);
        uploadInfo.setErrorMsg(ErrorMsg.COMMAND_NOT_EXECUTE_IN_4G);
        CloudMessageUploadManager.upload(uploadInfo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uploadFailStatus(String str, CloudMessage cloudMessage) {
        UploadInfo uploadInfo = new UploadInfo(0L, false, cloudMessage.getCommandId(), null);
        uploadInfo.setCloudMsgResponseCode(3);
        uploadInfo.setErrorMsg(str);
        CloudMessageUploadManager.upload(uploadInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uploadSuccessStatus(CloudMessage cloudMessage) {
        UploadInfo uploadInfo = new UploadInfo(0L, false, cloudMessage.getCommandId(), null);
        uploadInfo.setCloudMsgResponseCode(2);
        CloudMessageUploadManager.upload(uploadInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uploadFailStatus(String str, HashMap<String, String> hashMap, CloudMessage cloudMessage) {
        UploadInfo uploadInfo = new UploadInfo(0L, false, cloudMessage.getCommandId(), hashMap);
        uploadInfo.setCloudMsgResponseCode(3);
        uploadInfo.setErrorMsg(str);
        CloudMessageUploadManager.upload(uploadInfo);
    }
}
