package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.callback.IPluginConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.ConsumerResult;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PluginMessageHandler extends BaseMessageHandler {
    private static final String KEY_MD5 = "md5";
    private static final String KEY_PACKAGENAME = "packageName";
    private static final String KEY_URL = "url";
    private static final String KEY_VERSIONCODE = "versionCode";
    private static final String KEY_WIFIONLY = "wifiOnly";
    private IPluginConsumer mPluginConsumer;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.PLUGIN;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage cloudMessage) throws Exception {
        JSONObject jSONObject = new JSONObject(cloudMessage.getParams());
        if (this.mPluginConsumer == null) {
            return false;
        }
        this.mPluginConsumer.handlePluginMessage(jSONObject.optString("packageName"), jSONObject.optInt(KEY_VERSIONCODE), jSONObject.optString("url"), jSONObject.optString("md5"), jSONObject.optBoolean(KEY_WIFIONLY, false));
        ConsumerResult consumerResult = this.mPluginConsumer.getConsumerResult();
        if (consumerResult.isSuccess()) {
            uploadSuccessStatus(cloudMessage);
            return true;
        }
        uploadFailStatus(consumerResult.getErrMsg(), consumerResult.getSpecificParams(), cloudMessage);
        return true;
    }

    public void setPluginConsumer(IPluginConsumer iPluginConsumer) {
        this.mPluginConsumer = iPluginConsumer;
    }
}
