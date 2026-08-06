package com.monitor.cloudmessage.handler.impl;

import android.text.TextUtils;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.callback.ITemplateConsumer;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.ConsumerResult;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.TemplateFileGenerator;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TemplateMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final String KEY_TEMPLATE = "template";
    private File mCloudTemplateFile = null;
    private ITemplateConsumer mTemplateConsumer;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return "custom";
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String str) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String str, boolean z) {
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage cloudMessage) throws Exception {
        String params = cloudMessage.getParams();
        if (this.mTemplateConsumer == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject(params);
        if (checkWifiOnly(jSONObject, cloudMessage)) {
            return true;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(KEY_TEMPLATE);
        if (optJSONObject == null) {
            uploadFailStatus(ErrorMsg.COMMAND_TEMPLATE_FIELD_ERROR, cloudMessage);
            return true;
        }
        jSONObject.put("cloud_command_id", cloudMessage.getCommandId());
        String handleTemplateMessage = this.mTemplateConsumer.handleTemplateMessage(optJSONObject);
        ConsumerResult consumerResult = this.mTemplateConsumer.getConsumerResult();
        if (consumerResult.isSuccess()) {
            if (TextUtils.isEmpty(handleTemplateMessage)) {
                handleTemplateMessage = "{\"result\" : \"no one handle it.\"}";
            }
            File generateFile = TemplateFileGenerator.generateFile(CloudMessageManager.getInstance().getContext(), handleTemplateMessage);
            if (generateFile == null) {
                uploadFailStatus(ErrorMsg.COMMAND_TEMPLATE_FILE_GENERATE_ERROR, cloudMessage);
                return true;
            }
            this.mCloudTemplateFile = generateFile;
            CloudMessageUploadManager.upload(new FileUploadInfo(jSONObject.optString("fileContentType", "template_file_type"), 0L, false, cloudMessage.getCommandId(), this, consumerResult.getSpecificParams()));
        } else {
            uploadFailStatus(consumerResult.getErrMsg(), consumerResult.getSpecificParams(), cloudMessage);
        }
        return true;
    }

    public void setTemplateConsumer(ITemplateConsumer iTemplateConsumer) {
        this.mTemplateConsumer = iTemplateConsumer;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List<String> getUploadFileList() {
        ArrayList arrayList = new ArrayList(1);
        File file = this.mCloudTemplateFile;
        if (file != null) {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }
}
