package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.header.HeaderManager;
import com.bytedance.apm6.consumer.slardar.persistent.LogFile;
import com.bytedance.apm6.consumer.slardar.persistent.LogItem;
import com.bytedance.apm6.consumer.slardar.send.UploadLogInfo;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeController;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeDataStorage;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class UploadLogManager {
    private static final String KEY_DEBUG_LEFT_COUNT = "debug_left_file_count";
    private static final String KEY_DEBUG_MERGE_COUNT = "debug_merge_file_count";
    private static final String KEY_DEBUG_SECOND_LEFT_COUNT = "debug_second_file_count";
    private static final String KEY_DEBUG_SEQ_NUM = "debug_sender_number";
    private static final String KEY_DEBUG_SID = "debug_sender_sid";
    private static final String KEY_DEBUG_TOTAL_BYTES = "debug_total_bytes";
    private static final String KEY_DEBUG_TOTAL_COUNT = "debug_total_count";
    private static final String KEY_SELF_DEBUG_MESSAGE = "_debug_self";
    private static final UploadLogInfo.ExceptionLogInfo exceptionLogInfo;
    private static final UploadLogInfo.MonitorLogInfo monitorLogInfo;
    private static final UploadLogInfo.TraceLogInfo traceLogInfo;
    private static final List<UploadLogInfo> uploadTypes;
    private static AtomicInteger seqNum = new AtomicInteger(0);
    private static final List<String> uploadTypeListInTraceType = Arrays.asList("tracing");

    UploadLogManager() {
    }

    static {
        UploadLogInfo.ExceptionLogInfo exceptionLogInfo2 = new UploadLogInfo.ExceptionLogInfo();
        exceptionLogInfo = exceptionLogInfo2;
        UploadLogInfo.TraceLogInfo traceLogInfo2 = new UploadLogInfo.TraceLogInfo();
        traceLogInfo = traceLogInfo2;
        UploadLogInfo.MonitorLogInfo monitorLogInfo2 = new UploadLogInfo.MonitorLogInfo();
        monitorLogInfo = monitorLogInfo2;
        ArrayList arrayList = new ArrayList();
        uploadTypes = arrayList;
        arrayList.add(exceptionLogInfo2);
        arrayList.add(traceLogInfo2);
        arrayList.add(monitorLogInfo2);
    }

    public static List<UploadLogInfo> getUploadType() {
        return uploadTypes;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0152 A[Catch: all -> 0x01dd, TryCatch #5 {all -> 0x01dd, blocks: (B:3:0x0005, B:4:0x0016, B:6:0x001c, B:8:0x0032, B:10:0x003e, B:13:0x0052, B:15:0x005f, B:17:0x0065, B:18:0x0068, B:19:0x007a, B:21:0x0080, B:25:0x0092, B:27:0x0098, B:30:0x00a0, B:33:0x00a4, B:34:0x00b0, B:36:0x00be, B:38:0x00c4, B:43:0x00d6, B:55:0x00de, B:57:0x00e4, B:60:0x00ee, B:63:0x00f4, B:66:0x00ff, B:69:0x011e, B:70:0x012f, B:72:0x0135, B:46:0x014a, B:48:0x0152, B:49:0x015a, B:51:0x0160, B:52:0x0168, B:42:0x017b, B:98:0x018d, B:99:0x019b, B:101:0x01a1, B:103:0x01b5, B:105:0x01bb), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0160 A[Catch: all -> 0x01dd, TryCatch #5 {all -> 0x01dd, blocks: (B:3:0x0005, B:4:0x0016, B:6:0x001c, B:8:0x0032, B:10:0x003e, B:13:0x0052, B:15:0x005f, B:17:0x0065, B:18:0x0068, B:19:0x007a, B:21:0x0080, B:25:0x0092, B:27:0x0098, B:30:0x00a0, B:33:0x00a4, B:34:0x00b0, B:36:0x00be, B:38:0x00c4, B:43:0x00d6, B:55:0x00de, B:57:0x00e4, B:60:0x00ee, B:63:0x00f4, B:66:0x00ff, B:69:0x011e, B:70:0x012f, B:72:0x0135, B:46:0x014a, B:48:0x0152, B:49:0x015a, B:51:0x0160, B:52:0x0168, B:42:0x017b, B:98:0x018d, B:99:0x019b, B:101:0x01a1, B:103:0x01b5, B:105:0x01bb), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0135 A[Catch: all -> 0x01dd, TryCatch #5 {all -> 0x01dd, blocks: (B:3:0x0005, B:4:0x0016, B:6:0x001c, B:8:0x0032, B:10:0x003e, B:13:0x0052, B:15:0x005f, B:17:0x0065, B:18:0x0068, B:19:0x007a, B:21:0x0080, B:25:0x0092, B:27:0x0098, B:30:0x00a0, B:33:0x00a4, B:34:0x00b0, B:36:0x00be, B:38:0x00c4, B:43:0x00d6, B:55:0x00de, B:57:0x00e4, B:60:0x00ee, B:63:0x00f4, B:66:0x00ff, B:69:0x011e, B:70:0x012f, B:72:0x0135, B:46:0x014a, B:48:0x0152, B:49:0x015a, B:51:0x0160, B:52:0x0168, B:42:0x017b, B:98:0x018d, B:99:0x019b, B:101:0x01a1, B:103:0x01b5, B:105:0x01bb), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<UploadLogInfo, byte[]> serialize(List<LogFile> list, int i) {
        String str;
        int i2;
        HashMap hashMap;
        List list2;
        JSONObject jSONObject;
        HashMap hashMap2;
        Map map;
        String[] list3;
        String str2 = KEY_SELF_DEBUG_MESSAGE;
        try {
            HashMap hashMap3 = new HashMap();
            long size = list.size();
            long j = 0;
            long j2 = 0;
            for (LogFile logFile : list) {
                long startID = logFile.getStartID();
                List list4 = (List) hashMap3.get(Long.valueOf(startID));
                if (list4 == null) {
                    list4 = new ArrayList();
                    hashMap3.put(Long.valueOf(startID), list4);
                }
                j += logFile.getTotalBytes();
                j2 += logFile.getTotalCount();
                list4.addAll(logFile.getLogList());
            }
            debugPrint(hashMap3);
            File directory = DiskFileHelper.getInstance().getDirectory();
            int length = (directory == null || (list3 = directory.list()) == null) ? 0 : list3.length;
            HashMap hashMap4 = new HashMap();
            ArrayList arrayList = new ArrayList();
            Iterator it = hashMap3.keySet().iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                List list5 = (List) hashMap3.get(l);
                if (list5 != null) {
                    HashMap hashMap5 = hashMap3;
                    int i3 = 0;
                    while (i3 < list5.size()) {
                        Iterator it2 = it;
                        try {
                            list2 = list5;
                            try {
                                jSONObject = new JSONObject(new String(((LogItem) list5.get(i3)).getData()));
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                            str = str2;
                            i2 = i3;
                            hashMap = hashMap4;
                            list2 = list5;
                        }
                        if (!DowngradeController.getInstance().uploadEnabled(jSONObject, ApmContext.getAid())) {
                            if (ApmContext.isDebugMode()) {
                                Logger.m119d(DowngradeDataStorage.TAG, jSONObject.toString());
                            }
                            str = str2;
                            i2 = i3;
                            hashMap = hashMap4;
                            hashMap4 = hashMap;
                            i3 = i2 + 1;
                            it = it2;
                            list5 = list2;
                            str2 = str;
                        } else {
                            UploadLogInfo uploadLogInfo = getUploadLogInfo(jSONObject);
                            if (uploadLogInfo instanceof UploadLogInfo.MonitorLogInfo) {
                                try {
                                    JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                                    if (optJSONObject == null) {
                                        optJSONObject = new JSONObject();
                                        jSONObject.put(str2, optJSONObject);
                                    }
                                    str = str2;
                                    try {
                                        i2 = i3;
                                        try {
                                            optJSONObject.put(KEY_DEBUG_SEQ_NUM, seqNum.getAndIncrement());
                                            hashMap2 = hashMap4;
                                            try {
                                                optJSONObject.put(KEY_DEBUG_SID, ApmContext.getStartId());
                                                optJSONObject.put(KEY_DEBUG_TOTAL_BYTES, j);
                                                optJSONObject.put(KEY_DEBUG_TOTAL_COUNT, j2);
                                                optJSONObject.put(KEY_DEBUG_MERGE_COUNT, size);
                                                optJSONObject.put(KEY_DEBUG_SECOND_LEFT_COUNT, length);
                                                try {
                                                    optJSONObject.put(KEY_DEBUG_LEFT_COUNT, i);
                                                } catch (Exception unused3) {
                                                }
                                            } catch (Exception unused4) {
                                                if (jSONObject.has("seq_no")) {
                                                }
                                                hashMap = hashMap2;
                                                map = (Map) hashMap.get(uploadLogInfo);
                                                if (map == null) {
                                                }
                                                if (!map.containsKey(l)) {
                                                }
                                                ((JSONArray) map.get(l)).put(jSONObject);
                                                hashMap4 = hashMap;
                                                i3 = i2 + 1;
                                                it = it2;
                                                list5 = list2;
                                                str2 = str;
                                            }
                                        } catch (Exception unused5) {
                                            hashMap2 = hashMap4;
                                        }
                                    } catch (Exception unused6) {
                                        i2 = i3;
                                        hashMap2 = hashMap4;
                                        if (jSONObject.has("seq_no")) {
                                        }
                                        hashMap = hashMap2;
                                        map = (Map) hashMap.get(uploadLogInfo);
                                        if (map == null) {
                                        }
                                        if (!map.containsKey(l)) {
                                        }
                                        ((JSONArray) map.get(l)).put(jSONObject);
                                        hashMap4 = hashMap;
                                        i3 = i2 + 1;
                                        it = it2;
                                        list5 = list2;
                                        str2 = str;
                                    }
                                } catch (Exception unused7) {
                                    str = str2;
                                }
                                if (jSONObject.has("seq_no")) {
                                    arrayList.add(String.valueOf(jSONObject.get("seq_no")));
                                }
                                hashMap = hashMap2;
                            } else {
                                str = str2;
                                i2 = i3;
                                hashMap = hashMap4;
                            }
                            map = (Map) hashMap.get(uploadLogInfo);
                            if (map == null) {
                                map = new HashMap();
                                hashMap.put(uploadLogInfo, map);
                            }
                            if (!map.containsKey(l)) {
                                map.put(l, new JSONArray());
                            }
                            ((JSONArray) map.get(l)).put(jSONObject);
                            hashMap4 = hashMap;
                            i3 = i2 + 1;
                            it = it2;
                            list5 = list2;
                            str2 = str;
                        }
                    }
                    hashMap3 = hashMap5;
                }
            }
            HashMap hashMap6 = hashMap4;
            HashMap hashMap7 = new HashMap();
            for (UploadLogInfo uploadLogInfo2 : hashMap6.keySet()) {
                hashMap7.put(uploadLogInfo2, uploadLogInfo2.serialize((HashMap) hashMap6.get(uploadLogInfo2)));
            }
            if (ApmAlogHelper.getInnerLogger() != null) {
                ApmAlogHelper.getInnerLogger().m78d(Constants.TAG, "seqNoList:" + arrayList.toString());
            }
            return hashMap7;
        } catch (Throwable th) {
            Logger.m121e(Constants.TAG, "LogSender serialize failed.", th);
            return null;
        }
    }

    private static void debugPrint(Map<Long, List<LogItem>> map) {
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "sendLog: input sendList merged into " + map.size() + " group(s)");
            int i = 0;
            for (Long l : map.keySet()) {
                List<LogItem> list = map.get(l);
                Logger.m119d(Constants.TAG, "----------------");
                int i2 = i + 1;
                Logger.m119d(Constants.TAG, "group " + i + " header:" + HeaderManager.getInstance().getHeaderInfo(String.valueOf(l)));
                for (int i3 = 0; i3 < list.size(); i3++) {
                    Logger.m119d(Constants.TAG, "  log[" + i3 + "]=" + list.get(i3).toString());
                }
                Logger.m119d(Constants.TAG, "----------------");
                i = i2;
            }
        }
    }

    private static UploadLogInfo getUploadLogInfo(JSONObject jSONObject) {
        String optString = jSONObject.optString("log_type");
        if (Constants.EXCEPTION_TYPE.contains(optString)) {
            return exceptionLogInfo;
        }
        if (uploadTypeListInTraceType.contains(optString)) {
            return traceLogInfo;
        }
        return monitorLogInfo;
    }
}
