package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.header.HeaderInfo;
import com.bytedance.apm6.consumer.slardar.header.HeaderManager;
import com.bytedance.apm6.consumer.slardar.header.HeaderUtils;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.tob.IReportDataService;
import com.bytedance.apm6.util.BatchLogWrapUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.Tools;
import com.bytedance.apm6.util.log.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
interface UploadLogInfo {
    String getName();

    List<String> getUrls();

    byte[] serialize(HashMap<Long, JSONArray> hashMap);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class ExceptionLogInfo implements UploadLogInfo {
        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public String getName() {
            return "exception";
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public List<String> getUrls() {
            return LogReportController.getInstance().getExceptionUrlList();
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public byte[] serialize(HashMap<Long, JSONArray> hashMap) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                Iterator<Long> it = hashMap.keySet().iterator();
                while (it.hasNext()) {
                    JSONArray jSONArray2 = hashMap.get(it.next());
                    if (jSONArray2 != null) {
                        for (int i = 0; i < jSONArray2.length(); i++) {
                            jSONArray.put(jSONArray2.get(i));
                        }
                    }
                }
                jSONObject.put("header", HeaderUtils.serialize(HeaderManager.getInstance().getHeaderInfo(String.valueOf(HeaderUtils.getUniqueHeaderId()))));
                jSONObject.put("data", jSONArray);
                return Tools.safeGetBytes(jSONObject.toString());
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class TraceLogInfo implements UploadLogInfo {
        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public String getName() {
            return TraceStatsConsts.STATS_KEY_TRACE;
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public List<String> getUrls() {
            return LogReportController.getInstance().getTraceUrlList();
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public byte[] serialize(HashMap<Long, JSONArray> hashMap) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                Iterator<Long> it = hashMap.keySet().iterator();
                while (it.hasNext()) {
                    JSONArray jSONArray2 = hashMap.get(it.next());
                    if (jSONArray2 != null) {
                        for (int i = 0; i < jSONArray2.length(); i++) {
                            try {
                                List<Object> stripData = BatchLogWrapUtils.stripData(jSONArray2.getJSONObject(i));
                                if (!ListUtils.isEmpty(stripData)) {
                                    for (Object obj : stripData) {
                                        jSONArray.put(obj);
                                        if (ApmContext.isDebugMode()) {
                                            Logger.m119d(Constants.TAG, ":" + obj);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                Logger.m121e(Constants.TAG, "serialize", e);
                            }
                        }
                    }
                }
                if (ApmContext.isDebugMode()) {
                    Logger.m119d(Constants.TAG, "jsonArray:" + jSONArray);
                }
                jSONObject.put("header", HeaderUtils.serialize(HeaderManager.getInstance().getHeaderInfo(String.valueOf(HeaderUtils.getUniqueHeaderId()))));
                jSONObject.put("data", jSONArray);
                return Tools.safeGetBytes(jSONObject.toString());
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class MonitorLogInfo implements UploadLogInfo {
        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public String getName() {
            return "log";
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public List<String> getUrls() {
            return LogReportController.getInstance().getReportList();
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public byte[] serialize(HashMap<Long, JSONArray> hashMap) {
            HeaderInfo headerInfo;
            try {
                JSONArray jSONArray = new JSONArray();
                for (Long l : hashMap.keySet()) {
                    HeaderInfo headerInfo2 = HeaderManager.getInstance().getHeaderInfo(String.valueOf(l));
                    if (headerInfo2 == null) {
                        if (ApmContext.isDebugMode()) {
                            Logger.m124w(Constants.TAG, "HeaderInfo null for key " + l);
                        }
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("data", hashMap.get(l));
                        jSONObject.put("header", HeaderUtils.serialize(headerInfo2));
                        jSONArray.put(jSONObject);
                    }
                }
                JSONArray items = DropDataMonitor.getInstance().getItems();
                if (items != null && items.length() > 0 && (headerInfo = HeaderManager.getInstance().getHeaderInfo(String.valueOf(HeaderUtils.getUniqueHeaderId()))) != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("data", items);
                    jSONObject2.put("header", HeaderUtils.serialize(headerInfo));
                    jSONArray.put(jSONObject2);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("list", jSONArray);
                if (ApmContext.isDebugMode()) {
                    Logger.m119d(Constants.TAG, "request:" + jSONObject3);
                }
                IReportDataService iReportDataService = (IReportDataService) ServiceManager.getService(IReportDataService.class);
                if (iReportDataService != null) {
                    jSONObject3 = iReportDataService.changeReportData(jSONObject3);
                }
                return Tools.safeGetBytes(jSONObject3.toString());
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
