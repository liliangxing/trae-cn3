package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.callback.IPatchConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.ConsumerResult;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PatchMessageHandler extends BaseMessageHandler {
    private static final String KEY_MD5 = "md5";
    private static final String KEY_URL = "url";
    private IPatchConsumer mPatchConsumer;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.PATCH;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage cloudMessage) throws Exception {
        JSONObject jSONObject = new JSONObject(cloudMessage.getParams());
        if (this.mPatchConsumer == null) {
            return false;
        }
        if (checkWifiOnly(jSONObject, cloudMessage)) {
            return true;
        }
        this.mPatchConsumer.handlePatchMessage(jSONObject.optString("url"), jSONObject.optString("md5"));
        ConsumerResult consumerResult = this.mPatchConsumer.getConsumerResult();
        if (consumerResult.isSuccess()) {
            uploadSuccessStatus(cloudMessage);
        } else {
            uploadFailStatus(consumerResult.getErrMsg(), consumerResult.getSpecificParams(), cloudMessage);
        }
        return true;
    }

    public void setPatchConsumer(IPatchConsumer iPatchConsumer) {
        this.mPatchConsumer = iPatchConsumer;
    }
}
