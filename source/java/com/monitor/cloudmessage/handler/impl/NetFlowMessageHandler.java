package com.monitor.cloudmessage.handler.impl;

import com.bytedance.apm.util.TrafficUtils;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.NetFlowFileGenerator;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NetFlowMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final String KEY_END_TIME = "fetch_end_time";
    private static final String KEY_START_TIME = "fetch_start_time";
    private static final String NET_FLOW_FILE_TYPE = "json";
    private static final String NET_STATS_MOBILE = "netStatsMobile";
    private static final String NET_STATS_TOTAL = "netStatsTotal";
    private static final String NET_STATS_WIFI = "netStatsWifi";
    private File mCloudFile = null;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.NET_FLOW;
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
        long optLong = jSONObject.optLong(KEY_START_TIME, (System.currentTimeMillis() / 1000) - 18000);
        long j = optLong * 1000;
        long optLong2 = 1000 * jSONObject.optLong(KEY_END_TIME, System.currentTimeMillis() / 1000);
        long netStats = TrafficUtils.getNetStats(CloudMessageManager.getInstance().getContext(), j, optLong2, 1);
        long netStats2 = TrafficUtils.getNetStats(CloudMessageManager.getInstance().getContext(), j, optLong2, 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(NET_STATS_WIFI, netStats);
            jSONObject2.put(NET_STATS_MOBILE, netStats2);
            jSONObject2.put(NET_STATS_TOTAL, netStats2 + netStats);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        File generateFile = NetFlowFileGenerator.generateFile(CloudMessageManager.getInstance().getContext(), jSONObject2);
        if (generateFile == null) {
            uploadFailStatus(ErrorMsg.COMMAND_NET_FLOW_FILE_GENERATE_FAIL, cloudMessage);
            return true;
        }
        this.mCloudFile = generateFile;
        CloudMessageUploadManager.upload(new FileUploadInfo(NET_FLOW_FILE_TYPE, 0L, false, cloudMessage.getCommandId(), this, null));
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
