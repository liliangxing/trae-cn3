package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.data.stat.SystemInfoDataProvider;
import com.monitor.cloudmessage.internal.file.generator.StatFileGenerator;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class StatMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final String KEY_TYPE = "type";
    private static final String STAT_FILE_TYPE = "json";
    private static final String TYPE_ALL = "all";
    private static final String TYPE_STACK_IFNO = "stack_info";
    private static final String TYPE_SYSTEM_INFO = "system_info";
    private File mCloudFile = null;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.STAT;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String str) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String str, boolean z) {
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage cloudMessage) throws Exception {
        JSONObject jSONObject = new JSONObject(cloudMessage.getParams());
        String optString = jSONObject.optString("type", TYPE_SYSTEM_INFO);
        if (checkWifiOnly(jSONObject, cloudMessage)) {
            return true;
        }
        JSONObject jSONObject2 = new JSONObject();
        if ("all".equals(optString)) {
            jSONObject2.put("all", new SystemInfoDataProvider().provideData());
        } else if (!TYPE_STACK_IFNO.equals(optString) && TYPE_SYSTEM_INFO.equals(optString)) {
            jSONObject2.put(TYPE_SYSTEM_INFO, new SystemInfoDataProvider().provideData());
        }
        File generateFile = StatFileGenerator.generateFile(CloudMessageManager.getInstance().getContext(), jSONObject2);
        if (generateFile == null) {
            uploadFailStatus(ErrorMsg.COMMAND_STAT_FILE_GENERATE_FAIL, cloudMessage);
            return true;
        }
        this.mCloudFile = generateFile;
        CloudMessageUploadManager.upload(new FileUploadInfo(STAT_FILE_TYPE, 0L, false, cloudMessage.getCommandId(), this, null));
        return true;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List<String> getUploadFileList() {
        ArrayList arrayList = new ArrayList();
        File file = this.mCloudFile;
        if (file != null) {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }
}
