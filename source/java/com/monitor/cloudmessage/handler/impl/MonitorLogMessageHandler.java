package com.monitor.cloudmessage.handler.impl;

import android.text.TextUtils;
import com.bytedance.services.apm.api.IMonitorLogQueryCallback;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.callback.IMonitorLogConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.consts.ErrorMsg;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import com.monitor.cloudmessage.internal.file.generator.MonitorLogFileGenerator;
import com.monitor.cloudmessage.upload.CloudMessageUploadManager;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MonitorLogMessageHandler extends BaseMessageHandler implements IFileUploadCallback {
    private static final long DEFAULT_START_TIME_INTERVAL = 18000;
    private static final String KEY_END_TIME = "fetch_end_time";
    private static final String KEY_START_TIME = "fetch_start_time";
    private static final int MAX_QUERY_TIMES = 100;
    private IMonitorLogConsumer mMonitorLogConsumer;
    private File mCloudFile = null;
    private ConcurrentLinkedQueue<MonitorLogConsumeResult> queue = new ConcurrentLinkedQueue<>();
    private MonitorLogConsumeResult ErrorResult = new MonitorLogConsumeResult("error_data", "error_ids");

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.MONITOR_LOG;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String str) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String str, boolean z) {
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage cloudMessage) throws Exception {
        int i;
        int i2;
        String[] strArr;
        JSONObject jSONObject = new JSONObject(cloudMessage.getParams());
        if (this.mMonitorLogConsumer == null) {
            return false;
        }
        if (checkWifiOnly(jSONObject, cloudMessage)) {
            return true;
        }
        long optLong = jSONObject.optLong(KEY_START_TIME, (System.currentTimeMillis() / 1000) - DEFAULT_START_TIME_INTERVAL);
        long optLong2 = jSONObject.optLong(KEY_END_TIME, System.currentTimeMillis() / 1000);
        String[] parseLogType = this.mMonitorLogConsumer.parseLogType(jSONObject);
        if (parseLogType != null && parseLogType.length > 0) {
            int length = parseLogType.length;
            boolean z = false;
            boolean z2 = false;
            int i3 = 0;
            while (i3 < length) {
                String str = parseLogType[i3];
                int i4 = 0;
                while (true) {
                    i4++;
                    if (i4 <= 100) {
                        if (!this.queue.isEmpty()) {
                            MonitorLogConsumeResult poll = this.queue.poll();
                            if (poll == this.ErrorResult) {
                                this.queue.clear();
                                i = i3;
                                i2 = length;
                                strArr = parseLogType;
                                z2 = false;
                                break;
                            }
                            File generateFile = MonitorLogFileGenerator.generateFile(CloudMessageManager.getInstance().getContext(), poll.packLog, parseToFileNamePrex(str));
                            this.mCloudFile = generateFile;
                            if (generateFile != null) {
                                String str2 = str;
                                FileUploadInfo fileUploadInfo = new FileUploadInfo(parseToUploadFileType(str), 0L, false, cloudMessage.getCommandId(), this, null);
                                fileUploadInfo.setCloudMsgResponseCode(1);
                                fileUploadInfo.setForceUseState(true);
                                CloudMessageUploadManager.upload(fileUploadInfo);
                                this.mMonitorLogConsumer.notifyLogDataConsumed(str2, poll.logIds);
                                Thread.sleep(100L);
                                z2 = false;
                                z = true;
                                str = str2;
                                i3 = i3;
                                length = length;
                                parseLogType = parseLogType;
                                i4 = i4;
                            } else {
                                i = i3;
                                i2 = length;
                                strArr = parseLogType;
                                this.queue.clear();
                                z = false;
                                z2 = false;
                                break;
                            }
                        } else if (!z2) {
                            this.mMonitorLogConsumer.handleLogData(optLong, optLong2, str, new IMonitorLogQueryCallback() { // from class: com.monitor.cloudmessage.handler.impl.MonitorLogMessageHandler.1
                                public void onResult(String str3, String str4) {
                                    if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                                        MonitorLogMessageHandler.this.queue.offer(MonitorLogMessageHandler.this.ErrorResult);
                                    } else {
                                        MonitorLogMessageHandler.this.queue.offer(new MonitorLogConsumeResult(str3, str4));
                                    }
                                }
                            });
                            z2 = true;
                        }
                    } else {
                        i = i3;
                        i2 = length;
                        strArr = parseLogType;
                        break;
                    }
                }
                i3 = i + 1;
                length = i2;
                parseLogType = strArr;
            }
            if (z) {
                uploadSuccessStatus(cloudMessage);
            } else {
                uploadFailStatus(ErrorMsg.COMMAND_MONITOR_LOG_NONE, cloudMessage);
            }
        }
        return true;
    }

    public void setMonitorLogConsumer(IMonitorLogConsumer iMonitorLogConsumer) {
        this.mMonitorLogConsumer = iMonitorLogConsumer;
    }

    public String parseToUploadFileType(String str) {
        return "block_monitor".equals(str) ? "log_exception" : "log_performance";
    }

    public String parseToFileNamePrex(String str) {
        return "cloudMessage_" + str;
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

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class MonitorLogConsumeResult {
        public String logIds;
        public String packLog;

        public MonitorLogConsumeResult(String str, String str2) {
            this.packLog = str;
            this.logIds = str2;
        }
    }
}
