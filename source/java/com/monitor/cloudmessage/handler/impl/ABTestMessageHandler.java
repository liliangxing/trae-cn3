package com.monitor.cloudmessage.handler.impl;

import android.text.TextUtils;
import com.monitor.cloudmessage.callback.IABTestConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.ConsumerResult;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ABTestMessageHandler extends BaseMessageHandler {
    private static final String KEY_FIELD = "field";
    private static final String KEY_SPKEY = "spKey";
    private static final String KEY_VALUE = "value";
    private IABTestConsumer mAbTestConsumer;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.ABTEST;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage cloudMessage) throws Exception {
        JSONObject jSONObject = new JSONObject(cloudMessage.getParams());
        if (this.mAbTestConsumer == null) {
            return false;
        }
        if (checkWifiOnly(jSONObject, cloudMessage)) {
            return true;
        }
        String optString = jSONObject.optString(KEY_FIELD);
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        Object obj = jSONObject.get("value");
        this.mAbTestConsumer.notifyABTestModelUpdate(optString, obj);
        if (this.mAbTestConsumer.isUpdateABTestInfoInSP()) {
            this.mAbTestConsumer.notifyABTestSPUpdate(jSONObject.optString(KEY_SPKEY), obj);
        }
        ConsumerResult consumerResult = this.mAbTestConsumer.getConsumerResult();
        if (consumerResult.isSuccess()) {
            uploadSuccessStatus(cloudMessage);
        } else {
            uploadFailStatus(consumerResult.getErrMsg(), consumerResult.getSpecificParams(), cloudMessage);
        }
        return true;
    }

    public void setmAbTestConsumer(IABTestConsumer iABTestConsumer) {
        this.mAbTestConsumer = iABTestConsumer;
    }
}
