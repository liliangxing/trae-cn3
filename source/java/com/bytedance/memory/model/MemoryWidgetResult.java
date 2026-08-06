package com.bytedance.memory.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class MemoryWidgetResult implements Serializable {
    private static final long serialVersionUID = 5865887187300488157L;
    private List<ResultLeakNode> mBigObjLeakNodes = new ArrayList();
    private List<ResultLeakNode> mActivityLeakNodes = new ArrayList();
    private List<ResultLeakNode> mBitmapLeakNodes = new ArrayList();
    private List<ClassNumber> mClassNumbers = new ArrayList();
    private MemoryWidgetMonitor mMemoryWidgetMonitor = new MemoryWidgetMonitor();

    public List<ClassNumber> getClassNumbers() {
        return this.mClassNumbers;
    }

    public void setClassNumbers(List<ClassNumber> list) {
        this.mClassNumbers = list;
    }

    public List<ResultLeakNode> getActivityLeakNodes() {
        return this.mActivityLeakNodes;
    }

    public void setActivityLeakNodes(List<ResultLeakNode> list) {
        this.mActivityLeakNodes = list;
    }

    public List<ResultLeakNode> getBitmapLeakNodes() {
        return this.mBitmapLeakNodes;
    }

    public void setBitmapLeakNodes(List<ResultLeakNode> list) {
        this.mBitmapLeakNodes = list;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        Iterator<ResultLeakNode> it = this.mBigObjLeakNodes.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(new JSONObject(it.next().toString()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Iterator<ResultLeakNode> it2 = this.mActivityLeakNodes.iterator();
        while (it2.hasNext()) {
            try {
                jSONArray2.put(new JSONObject(it2.next().toString()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        Iterator<ResultLeakNode> it3 = this.mBitmapLeakNodes.iterator();
        while (it3.hasNext()) {
            try {
                jSONArray3.put(new JSONObject(it3.next().toString()));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        Iterator<ClassNumber> it4 = this.mClassNumbers.iterator();
        while (it4.hasNext()) {
            try {
                jSONArray4.put(new JSONObject(it4.next().toString()));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        wrapToJson(jSONObject, jSONArray, jSONArray2, jSONArray3, jSONArray4);
        return jSONObject.toString();
    }

    private void wrapToJson(JSONObject jSONObject, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4) {
        try {
            jSONObject.put("object_node", jSONArray);
            jSONObject.put("activity_node", jSONArray2);
            jSONObject.put("bitmap_node", jSONArray3);
            jSONObject.put("instance_count_node", jSONArray4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setBigObjLeakNodes(List<ResultLeakNode> list) {
        this.mBigObjLeakNodes = list;
    }

    public void setMemoryWidgetMonitor(MemoryWidgetMonitor memoryWidgetMonitor) {
        this.mMemoryWidgetMonitor = memoryWidgetMonitor;
    }

    public List<ResultLeakNode> getBigObjLeakNodes() {
        return this.mBigObjLeakNodes;
    }

    public MemoryWidgetMonitor getMemoryWidgetMonitor() {
        return this.mMemoryWidgetMonitor;
    }

    public void transForm(JSONArray jSONArray, JSONObject jSONObject) {
        transformLeakNodes(jSONArray);
        transformMonitor(jSONObject);
    }

    private void transformLeakNodes(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            ResultLeakNode resultLeakNode = new ResultLeakNode();
            try {
                resultLeakNode.setRetainedHeapSize(jSONArray.getJSONObject(0).optDouble("retainedHeapSize"));
                resultLeakNode.setLeakClass(jSONArray.getJSONObject(0).optString("leakClass"));
                resultLeakNode.setLeakTrace(jSONArray.getJSONObject(0).optString("leakTrace"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mBigObjLeakNodes.add(resultLeakNode);
        }
    }

    private void transformMonitor(JSONObject jSONObject) {
        this.mMemoryWidgetMonitor.setAppHeapInstanceSize(jSONObject.optInt("appHeapInstanceSize"));
        this.mMemoryWidgetMonitor.setLeakTraceSize(jSONObject.optInt("LeakTraceSize"));
        this.mMemoryWidgetMonitor.setHeapDumpFilePath(jSONObject.optString("heapDumpFilePath"));
        this.mMemoryWidgetMonitor.setHeapDumpFileSize(jSONObject.optInt("heapDumpFileSize"));
        this.mMemoryWidgetMonitor.setReferenceName(jSONObject.optString("referenceName"));
        this.mMemoryWidgetMonitor.setDebug(jSONObject.optBoolean("isDebug"));
        this.mMemoryWidgetMonitor.setWatchDurationMs(jSONObject.optInt("watchDurationMs"));
        this.mMemoryWidgetMonitor.setGcDurationMs(jSONObject.optInt("gcDurationMs"));
        this.mMemoryWidgetMonitor.setHeapDumpDurationMs(jSONObject.optInt("heapDumpDurationMs"));
    }

    /* loaded from: classes4.dex */
    public static class ResultLeakNode implements Serializable {
        private static final long serialVersionUID = -3143585016293965793L;
        private String leakClass;
        private String leakTrace;
        private double retainedHeapSize;

        public double getRetainedHeapSize() {
            return this.retainedHeapSize;
        }

        public void setRetainedHeapSize(double d) {
            this.retainedHeapSize = d;
        }

        public String getLeakClass() {
            return this.leakClass;
        }

        public void setLeakClass(String str) {
            this.leakClass = str;
        }

        public String getLeakTrace() {
            return this.leakTrace;
        }

        public void setLeakTrace(String str) {
            this.leakTrace = str;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("object_class", getLeakClass());
                jSONObject.put("object_trace", getLeakTrace());
                jSONObject.put("retained_heap_size", getRetainedHeapSize());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static class MemoryWidgetMonitor implements Serializable {
        private static final long serialVersionUID = -5276649811675595534L;
        private int appHeapInstanceSize;
        private long gcDurationMs;
        private long heapDumpDurationMs;
        private String heapDumpFilePath;
        private long heapDumpFileSize;
        private boolean isDebug;
        private int leakTraceSize;
        private String referenceName;
        private String stepTrace;
        private long watchDurationMs;

        public int getAppHeapInstanceSize() {
            return this.appHeapInstanceSize;
        }

        public void setAppHeapInstanceSize(int i) {
            this.appHeapInstanceSize = i;
        }

        public int getLeakTraceSize() {
            return this.leakTraceSize;
        }

        public void setLeakTraceSize(int i) {
            this.leakTraceSize = i;
        }

        public String getHeapDumpFilePath() {
            return this.heapDumpFilePath;
        }

        public void setHeapDumpFilePath(String str) {
            this.heapDumpFilePath = str;
        }

        public long getHeapDumpFileSize() {
            return this.heapDumpFileSize;
        }

        public void setHeapDumpFileSize(long j) {
            this.heapDumpFileSize = j;
        }

        public String getReferenceName() {
            return this.referenceName;
        }

        public void setReferenceName(String str) {
            this.referenceName = str;
        }

        public boolean isDebug() {
            return this.isDebug;
        }

        public void setDebug(boolean z) {
            this.isDebug = z;
        }

        public long getWatchDurationMs() {
            return this.watchDurationMs;
        }

        public void setWatchDurationMs(long j) {
            this.watchDurationMs = j;
        }

        public long getGcDurationMs() {
            return this.gcDurationMs;
        }

        public void setGcDurationMs(long j) {
            this.gcDurationMs = j;
        }

        public long getHeapDumpDurationMs() {
            return this.heapDumpDurationMs;
        }

        public void setHeapDumpDurationMs(long j) {
            this.heapDumpDurationMs = j;
        }

        public String getStepTrace() {
            return this.stepTrace;
        }

        public void setStepTrace(String str) {
            this.stepTrace = str;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appHeapInstanceSize", getAppHeapInstanceSize());
                jSONObject.put("gcDurationMs", getGcDurationMs());
                jSONObject.put("heapDumpDurationMs", getHeapDumpDurationMs());
                jSONObject.put("heapDumpFilePath", getHeapDumpFilePath());
                jSONObject.put("heapDumpFileSize", getHeapDumpFileSize());
                jSONObject.put("leakTraceSize", getLeakTraceSize());
                jSONObject.put("referenceName", getReferenceName());
                jSONObject.put("stepTrace", getStepTrace());
                jSONObject.put("watchDurationMs", getWatchDurationMs());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }
}
