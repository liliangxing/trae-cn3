package com.monitor.cloudmessage.handler.impl;

import android.text.TextUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.File;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DataClearMessageHandler extends BaseMessageHandler {
    private static final String KEY_DELETE_STRATEGY = "deleteStrategy";
    private static final String KEY_EXPIRATION_TIME = "expiration_time";
    private static final String KEY_RELATIVEDIRNAME = "relativeDirName";
    private static final String KEY_ROOTNODE = "rootNode";
    private static final int STRATEGY_DELETE_ALL = 0;
    private static final int STRATEGY_DELETE_BY_TIME = 1;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.DATA_CLEAR;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage cloudMessage) throws Exception {
        File file;
        boolean delete;
        JSONObject jSONObject = new JSONObject(cloudMessage.getParams());
        if (checkWifiOnly(jSONObject, cloudMessage)) {
            return true;
        }
        String fullPath = FileUtils.getFullPath(jSONObject.optString(KEY_ROOTNODE), jSONObject.optString(KEY_RELATIVEDIRNAME));
        String str = null;
        if (TextUtils.isEmpty(fullPath)) {
            file = null;
            str = ErrorMsg.COMMAND_DIRNAME_EMPTY;
        } else {
            file = new File(fullPath);
            if (!file.exists()) {
                str = ErrorMsg.COMMAND_DIR_FILE_NOT_EXIST;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            uploadFailStatus(str, cloudMessage);
            return true;
        }
        int optInt = jSONObject.optInt(KEY_DELETE_STRATEGY, 0);
        if (optInt != 0) {
            if (optInt == 1) {
                long optLong = jSONObject.optLong(KEY_EXPIRATION_TIME, -1L);
                if (optLong < 0) {
                    uploadFailStatus(ErrorMsg.COMMAND_EXPIRATION_TIME_NULL, cloudMessage);
                } else if (file.isDirectory()) {
                    delete = true;
                    for (File file2 : file.listFiles()) {
                        if (file2.lastModified() < optLong * 1000) {
                            delete = delete && file.delete();
                        }
                    }
                } else if (file.lastModified() < optLong * 1000) {
                    delete = file.delete();
                }
                delete = true;
            } else {
                uploadFailStatus(ErrorMsg.COMMAND_DATA_DELETE_STRATEGY_NOT_FOUND, cloudMessage);
                return true;
            }
        } else if (file.isDirectory()) {
            delete = FileUtils.removeDir(file.getAbsolutePath());
        } else {
            delete = file.delete();
        }
        if (!delete) {
            uploadFailStatus(ErrorMsg.COMMAND_DATA_DELETE_FAIL, cloudMessage);
        } else {
            uploadSuccessStatus(cloudMessage);
        }
        return true;
    }
}
