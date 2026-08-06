package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.PrefFileGenerator;
import com.monitor.cloudmessage.refactor.CommandResultUploader;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SPMessageHandler extends BaseMessageHandler {
    private static final String SP_FILE_TYPE = "default_sp_file_type";

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.f26SP;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public synchronized boolean handleMessage(CloudMessage cloudMessage) throws Exception {
        File copySPFiles = PrefFileGenerator.copySPFiles(CloudMessageManager.getInstance().getContext());
        if (copySPFiles == null) {
            uploadFailStatus(ErrorMsg.COMMAND_SP_COPY_FAIL, cloudMessage);
            return true;
        }
        CommandResultUploader.getInstance().upload(cloudMessage, copySPFiles.getParentFile(), SP_FILE_TYPE);
        return true;
    }
}
