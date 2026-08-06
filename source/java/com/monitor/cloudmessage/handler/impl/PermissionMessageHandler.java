package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.PermissionFileGenerator;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PermissionMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final String PERMISSION_FILE_TYPE = "txt";
    private File mCloudPermissionFile = null;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.PERMISSION;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String str) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String str, boolean z) {
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage cloudMessage) throws Exception {
        if (checkWifiOnly(new JSONObject(cloudMessage.getParams()), cloudMessage)) {
            return true;
        }
        File writePermissionInfo = PermissionFileGenerator.writePermissionInfo(CloudMessageManager.getInstance().getContext());
        if (writePermissionInfo == null) {
            UploadInfo uploadInfo = new UploadInfo(0L, false, cloudMessage.getCommandId(), null);
            uploadInfo.setCloudMsgResponseCode(3);
            uploadInfo.setErrorMsg("网络信息文件生成失败");
            CloudMessageUploadManager.upload(uploadInfo);
            return true;
        }
        this.mCloudPermissionFile = writePermissionInfo;
        CloudMessageUploadManager.upload(new FileUploadInfo(PERMISSION_FILE_TYPE, 0L, false, cloudMessage.getCommandId(), this, null));
        return true;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List<String> getUploadFileList() {
        ArrayList arrayList = new ArrayList(1);
        File file = this.mCloudPermissionFile;
        if (file != null) {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }
}
