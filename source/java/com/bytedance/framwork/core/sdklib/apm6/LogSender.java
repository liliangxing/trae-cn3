package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.NetUtils;
import com.bytedance.apm6.util.Tools;
import com.bytedance.framwork.core.sdklib.apm6.LogSenderHelper;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeController;
import com.bytedance.framwork.core.sdklib.apm6.header.HeaderManager;
import com.bytedance.framwork.core.sdklib.apm6.safety.Logger;
import com.bytedance.framwork.core.sdklib.thread.AsyncEventManager;
import com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class LogSender implements IMonitorTimeTask {
    private static final int DEFAULT_SEND_LOG_INTERVAL = 90000;
    private static final long DIRECT_SEND_INTERVAL = 5000;
    private static final String KEY_DEBUG_SEQ_NUM = "debug_sender_number";
    private static final String KEY_SELF_DEBUG_MESSAGE = "_debug_self";
    private static final int MAX_COUNT = 10;
    private static AtomicInteger seqNum = new AtomicInteger(0);
    private AtomicLong directSendTime;
    private long lastSendTime;
    private ConcurrentLinkedQueue<LogModel> queue;

    private LogSender() {
        this.directSendTime = new AtomicLong(0L);
        this.queue = new ConcurrentLinkedQueue<>();
    }

    public static LogSender getInstance() {
        return InnerHolder.instance;
    }

    public void init() {
        AsyncEventManager.getInstance().addTimeTask(this);
    }

    @Override // com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask
    public void onTimeEvent(long j) {
        if (j - this.lastSendTime >= 90000) {
            try {
                send();
            } catch (Throwable th) {
                Logger.m1307e(Constants.TAG, "onTimeEvent", th);
            }
            this.lastSendTime = System.currentTimeMillis();
        }
    }

    public void sendLog(List<LogFile> list) {
        try {
            if (LogReportController.getInstance().isStopCollect()) {
                if (SDKContext.isDebugMode()) {
                    Logger.m1306e(Constants.TAG, "stop collect log");
                }
                deleteFiles(list);
                return;
            }
            int i = 1;
            byte[] serialize = serialize(list, true);
            if (serialize == null) {
                deleteFiles(list);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            if (currentTimeMillis - this.directSendTime.get() >= 5000) {
                this.directSendTime.set(currentTimeMillis);
                if (LogReportController.getInstance().isReportLogEnable() && NetUtils.isNetworkTrulyAvailable(SDKContext.getContext())) {
                    z = NetworkHelper.getInstance().sendLog(serialize);
                } else {
                    i = 0;
                }
                if (SDKContext.isDebugMode()) {
                    Logger.m1305d(Constants.TAG, "sendDirect:isReportLogEnable " + LogReportController.getInstance().isReportLogEnable() + " :sendResult " + z);
                }
            } else {
                i = 0;
            }
            if (!z) {
                long retryInterval = LogReportController.getInstance().getRetryInterval(i);
                long currentTimeMillis2 = System.currentTimeMillis() + retryInterval;
                boolean saveFile = LogSenderHelper.getInstance().saveFile(serialize, i, currentTimeMillis2);
                if (SDKContext.isDebugMode()) {
                    Logger.m1305d(Constants.TAG, "saveFile:Result:" + saveFile + " " + i + " " + retryInterval);
                }
                if (!saveFile) {
                    this.queue.add(new LogModel(serialize, i, currentTimeMillis2));
                    if (this.queue.size() > 10) {
                        this.queue.poll();
                    }
                }
            }
            deleteFiles(list);
        } catch (Throwable th) {
            Logger.m1307e(Constants.TAG, "sendLog", th);
        }
    }

    private void send() {
        if (NetUtils.isNetworkTrulyAvailable(SDKContext.getContext()) && LogReportController.getInstance().isReportLogEnable()) {
            if (SDKContext.isDebugMode()) {
                Logger.m1305d(Constants.TAG, "trigger send.");
            }
            sendMemory();
            if (SDKContext.isReportEnableInCurProcess()) {
                sendFile();
            }
        }
    }

    private void sendMemory() {
        LogModel logModel;
        if (this.queue.isEmpty()) {
            return;
        }
        Object[] array = this.queue.toArray();
        int length = array.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                logModel = null;
                break;
            }
            logModel = (LogModel) array[i];
            if (logModel.retryCount > LogReportController.getInstance().getMaxRetryCount()) {
                this.queue.remove(logModel);
            } else if (logModel.retryCount <= 0 || System.currentTimeMillis() - logModel.nextSendTime > 0) {
                break;
            }
            i++;
        }
        if (logModel == null && this.queue.size() > 0) {
            logModel = this.queue.peek();
        }
        if (logModel == null) {
            return;
        }
        if (SDKContext.isDebugMode()) {
            Logger.m1305d(Constants.TAG, "sendMemory");
        }
        if (NetworkHelper.getInstance().sendLog(logModel.bytes)) {
            this.queue.remove(logModel);
        } else {
            logModel.retryCount++;
            logModel.nextSendTime = LogReportController.getInstance().getRetryInterval(logModel.retryCount) + System.currentTimeMillis();
        }
    }

    private void sendFile() {
        File sendFile = LogSenderHelper.getInstance().getSendFile();
        if (sendFile == null || !sendFile.exists()) {
            return;
        }
        if (NetworkHelper.getInstance().sendLog(FileUtils.readFileToByteArray(sendFile))) {
            if (SDKContext.isDebugMode()) {
                Logger.m1305d(Constants.TAG, "sendFile: success");
            }
            LogSenderHelper.getInstance().deleteLog(sendFile);
            return;
        }
        LogSenderHelper.RetryMessage reportMessage = LogSenderHelper.getInstance().getReportMessage(sendFile);
        int retryCount = reportMessage != null ? reportMessage.getRetryCount() + 1 : 0;
        long retryInterval = LogReportController.getInstance().getRetryInterval(retryCount) + System.currentTimeMillis();
        LogSenderHelper.getInstance().updateRetryMessage(sendFile, retryCount, retryInterval);
        if (SDKContext.isDebugMode()) {
            Logger.m1305d(Constants.TAG, "sendfile error retry count:" + sendFile.getName() + "  " + retryCount + " nextRetryTime:" + retryInterval);
        }
    }

    private byte[] serialize(List<LogFile> list, boolean z) {
        try {
            Map<String, List<LogItem>> mergeLogItems = mergeLogItems(list);
            debugPrint(mergeLogItems);
            JSONArray json = toJSON(mergeLogItems, z);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.KEY_LIST, json);
            if (SDKContext.isDebugMode()) {
                Logger.m1310w(Constants.TAG, "request : " + jSONObject.toString());
            }
            return Tools.safeGetBytes(jSONObject.toString());
        } catch (Throwable th) {
            Logger.m1307e(Constants.TAG, "LogSender serialize failed.", th);
            return null;
        }
    }

    private void debugPrint(Map<String, List<LogItem>> map) {
        if (SDKContext.isDebugMode()) {
            Logger.m1305d(Constants.TAG, "sendLog: input sendList merged into " + map.size() + " group(s)");
            Iterator<Map.Entry<String, List<LogItem>>> it = map.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                List<LogItem> value = it.next().getValue();
                if (value != null) {
                    Logger.m1305d(Constants.TAG, "----------------");
                    int i2 = i + 1;
                    Logger.m1305d(Constants.TAG, "group " + i + " aid " + value.get(0).getAid() + " headerId " + value.get(0).getHeaderId() + " header:" + HeaderManager.getInstance().getHeader(value.get(0).getAid(), value.get(0).getHeaderId()));
                    for (int i3 = 0; i3 < value.size(); i3++) {
                        Logger.m1305d(Constants.TAG, "  log[" + i3 + "]=" + value.get(i3).toString());
                    }
                    Logger.m1305d(Constants.TAG, "----------------");
                    i = i2;
                }
            }
        }
    }

    private Map<String, List<LogItem>> mergeLogItems(List<LogFile> list) {
        HashMap hashMap = new HashMap();
        Iterator<LogFile> it = list.iterator();
        while (it.hasNext()) {
            for (LogItem logItem : it.next().getLogList()) {
                String str = logItem.getHeaderId() + "_" + logItem.getAid();
                List list2 = (List) hashMap.get(str);
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(str, list2);
                }
                list2.add(logItem);
            }
        }
        return hashMap;
    }

    private JSONArray toJSON(Map<String, List<LogItem>> map, boolean z) {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, List<LogItem>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<LogItem> value = entry.getValue();
            if (!ListUtils.isEmpty(value)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i = 0; i < value.size(); i++) {
                    LogItem logItem = value.get(i);
                    try {
                        JSONObject jSONObject = new JSONObject(new String(logItem.getData()));
                        if (!DowngradeController.getInstance().uploadEnabled(jSONObject, (int) logItem.getAid())) {
                            if (SDKContext.isDebugMode()) {
                                Logger.m1305d(Constants.TAG, "failed to report: event is downgraded: " + jSONObject.toString());
                            }
                        } else {
                            if (z) {
                                addDebugMessage(jSONObject);
                            }
                            jSONArray2.put(jSONObject);
                        }
                    } catch (Exception e) {
                        Logger.m1307e(Constants.TAG, "toJSON", e);
                    }
                }
                JSONObject header = HeaderManager.getInstance().getHeader(value.get(0).getAid(), value.get(0).getHeaderId());
                if (header == null) {
                    if (SDKContext.isDebugMode()) {
                        Logger.m1310w(Constants.TAG, "HeaderInfo null for key " + key);
                    }
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(Constants.KEY_DATA, jSONArray2);
                        jSONObject2.put(Constants.KEY_HEADER, header);
                        jSONArray.put(jSONObject2);
                    } catch (Exception e2) {
                        Logger.m1307e(Constants.TAG, "toJSON", e2);
                    }
                }
            }
        }
        return jSONArray;
    }

    private void addDebugMessage(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(KEY_SELF_DEBUG_MESSAGE);
        if (optJSONObject == null) {
            try {
                optJSONObject = new JSONObject();
                jSONObject.put(KEY_SELF_DEBUG_MESSAGE, optJSONObject);
            } catch (Exception unused) {
                return;
            }
        }
        optJSONObject.put(KEY_DEBUG_SEQ_NUM, seqNum.getAndIncrement());
    }

    private void deleteFiles(List<LogFile> list) {
        for (LogFile logFile : list) {
            try {
                if (logFile.getSource() != null) {
                    FileUtils.deleteFile(logFile.getSource());
                }
            } catch (Exception unused) {
                Logger.m1310w(Constants.TAG, "delete LogFile's source File failed. logFile=" + logFile.getSource());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class LogModel {
        byte[] bytes;
        long nextSendTime;
        int retryCount;

        LogModel(byte[] bArr, int i, long j) {
            this.bytes = bArr;
            this.retryCount = i;
            this.nextSendTime = j;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private static class InnerHolder {
        private static final LogSender instance = new LogSender();

        private InnerHolder() {
        }
    }
}
