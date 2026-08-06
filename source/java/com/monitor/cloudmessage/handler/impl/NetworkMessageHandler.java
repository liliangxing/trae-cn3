package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.NetworkFileGenerator;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NetworkMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final String NETWORK_FILE_TYPE = "json";
    private File mCloudNetFile = null;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.NETWORK;
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
        File generateFile = NetworkFileGenerator.generateFile(CloudMessageManager.getInstance().getContext(), new JSONObject(cloudMessage.getParams()));
        if (generateFile == null) {
            uploadFailStatus("网络信息文件生成失败", cloudMessage);
            return true;
        }
        this.mCloudNetFile = generateFile;
        CloudMessageUploadManager.upload(new FileUploadInfo(NETWORK_FILE_TYPE, 0L, false, cloudMessage.getCommandId(), this, null));
        return true;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List<String> getUploadFileList() {
        ArrayList arrayList = new ArrayList(1);
        File file = this.mCloudNetFile;
        if (file != null) {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }
}
