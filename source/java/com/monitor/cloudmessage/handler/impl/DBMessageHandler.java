package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.DbFileGenerator;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DBMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final String KEY_DBNAME = "db_name";
    private File mCloudDBFile = null;
    private volatile boolean isProcessingDBFile = false;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return "db";
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String str) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String str, boolean z) {
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage cloudMessage) throws Exception {
        File file;
        JSONObject jSONObject = new JSONObject(cloudMessage.getParams());
        if (checkWifiOnly(jSONObject, cloudMessage)) {
            return true;
        }
        if (this.isProcessingDBFile) {
            dbCmdNotResponse(cloudMessage);
            return true;
        }
        this.isProcessingDBFile = true;
        try {
            file = DbFileGenerator.copyDbFiles(CloudMessageManager.getInstance().getContext(), jSONObject.optString(KEY_DBNAME, ""));
            this.isProcessingDBFile = false;
        } catch (Throwable unused) {
            this.isProcessingDBFile = false;
            file = null;
        }
        if (file == null) {
            uploadFailStatus(ErrorMsg.COMMAND_DB_COPY_FAIL, cloudMessage);
            return true;
        }
        this.mCloudDBFile = file;
        FileUploadInfo fileUploadInfo = new FileUploadInfo(jSONObject.optString("fileContentType", "default_db_file_type"), 0L, false, cloudMessage.getCommandId(), this, null);
        fileUploadInfo.setCompress(false);
        fileUploadInfo.setDelSourceFile(true);
        CloudMessageUploadManager.upload(fileUploadInfo);
        return true;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List<String> getUploadFileList() {
        ArrayList arrayList = new ArrayList(1);
        File file = this.mCloudDBFile;
        if (file != null) {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }

    private void dbCmdNotResponse(CloudMessage cloudMessage) {
        UploadInfo uploadInfo = new UploadInfo(0L, false, cloudMessage.getCommandId(), null);
        uploadInfo.setCloudMsgResponseCode(0);
        uploadInfo.setErrorMsg(ErrorMsg.COMMAND_DB_FILE_PROCESSING);
        CloudMessageUploadManager.upload(uploadInfo);
    }
}
