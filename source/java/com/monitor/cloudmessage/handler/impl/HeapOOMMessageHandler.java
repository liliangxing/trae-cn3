package com.monitor.cloudmessage.handler.impl;

import android.os.Debug;
import android.text.TextUtils;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HeapOOMMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final String HEAPOOM_FILE_TYPE = "log_heap_oom";
    private static final String KEY_ISTRYTOCATCH = "isTryToCatch";
    private File mCloudFile = null;
    private long mLastHandleTime = 0;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.HEAP_OOM;
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
        if (checkWifiOnly(jSONObject, cloudMessage)) {
            return true;
        }
        if (System.currentTimeMillis() - this.mLastHandleTime < Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL) {
            return false;
        }
        this.mLastHandleTime = System.currentTimeMillis();
        boolean optBoolean = jSONObject.optBoolean(KEY_ISTRYTOCATCH, false);
        String dumpFileDir = CloudMessageManager.getDumpFileDir();
        boolean isEmpty = TextUtils.isEmpty(dumpFileDir);
        String str = ErrorMsg.COMMAND_OOM_DUMP_FILE_NAME_NULL;
        if (isEmpty) {
            uploadFailStatus(ErrorMsg.COMMAND_OOM_DUMP_FILE_NAME_NULL, cloudMessage);
            return true;
        }
        if (optBoolean) {
            try {
                Debug.dumpHprofData(dumpFileDir);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File file = new File(dumpFileDir);
        if (!TextUtils.isEmpty(dumpFileDir)) {
            str = null;
        }
        if (!file.exists()) {
            str = ErrorMsg.COMMAND_OOM_DUMP_FILE_NOT_EXIST;
        }
        if (!TextUtils.isEmpty(str)) {
            uploadFailStatus(str, cloudMessage);
            return true;
        }
        this.mCloudFile = file;
        FileUploadInfo fileUploadInfo = new FileUploadInfo(HEAPOOM_FILE_TYPE, 0L, false, cloudMessage.getCommandId(), this, null);
        fileUploadInfo.setCompress(true);
        CloudMessageUploadManager.upload(fileUploadInfo);
        return true;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List<String> getUploadFileList() {
        ArrayList arrayList = new ArrayList(1);
        File file = this.mCloudFile;
        if (file != null) {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }
}
