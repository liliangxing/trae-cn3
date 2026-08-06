package com.monitor.cloudmessage.handler.impl;

import android.text.TextUtils;
import com.monitor.cloudmessage.callback.IRouteConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.ConsumerResult;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RouteMessageHandler extends BaseMessageHandler {
    private static final String KEY_SCHEMA = "schema";
    private IRouteConsumer mRouteConsumer = null;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.ROUTE;
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage cloudMessage) throws Exception {
        String optString = new JSONObject(cloudMessage.getParams()).optString(KEY_SCHEMA);
        if (TextUtils.isEmpty(optString)) {
            uploadFailStatus(ErrorMsg.COMMAND_ROUTE_SCHEME_EMPTY_ERROR, cloudMessage);
            return true;
        }
        IRouteConsumer iRouteConsumer = this.mRouteConsumer;
        if (iRouteConsumer == null) {
            return false;
        }
        iRouteConsumer.handleRouteUrl(optString);
        ConsumerResult consumerResult = this.mRouteConsumer.getConsumerResult();
        if (consumerResult.isSuccess()) {
            uploadSuccessStatus(cloudMessage);
        } else {
            uploadFailStatus(consumerResult.getErrMsg(), consumerResult.getSpecificParams(), cloudMessage);
        }
        return true;
    }

    public void setRouteConsumer(IRouteConsumer iRouteConsumer) {
        this.mRouteConsumer = iRouteConsumer;
    }
}
