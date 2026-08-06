package com.bytedance.apm6.disk;

import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.apm6.util.JsonUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DiskReportEvent extends PerfBaseEvent {
    private static final int MAX_DATA_SIZE = 262144;
    private static final String PERF_DISK_APP_USAGE = "app_usage";
    private static final String PERF_DISK_CACHE = "cache";
    private static final String PERF_DISK_DATA = "data";
    private static final String PERF_DISK_DISK_INFO = "disk_info";
    private static final String PERF_DISK_EXCEPTION_FOLDERS = "exception_folders";
    private static final String PERF_DISK_FREE_CAPACITY = "free_capacity";
    private static final String PERF_DISK_OCCUPIED_RATE = "app_occupied_rate";
    private static final String PERF_DISK_OUTDATED_FILES = "outdated_files";
    private static final String PERF_DISK_ROM_FREE = "rom_free";
    private static final String PERF_DISK_TOP_USAGE = "top_usage";
    private static final String PERF_DISK_TOTAL = "total";
    private static final String PERF_DISK_TOTAL_CAPACITY = "total_capacity";
    private static final String SERVICE_NAME = "disk";
    private double appOccupiedRate;
    private long appUsage;
    private long cacheUsed;
    private long dataUsed;
    private JSONArray diskInfo;
    private JSONArray exceptionFolder;
    private long freeCapacity;
    private int maxRoomOfJsonObject = MAX_DATA_SIZE;
    private JSONArray outDateList;
    private long romFreeSpace;
    private JSONArray topUsage;
    private long totalCapacity;
    private long totalSize;

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        return "disk";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public DiskReportEvent(long j, long j2, long j3, long j4, long j5, long j6, long j7, double d, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4) {
        this.dataUsed = j;
        this.cacheUsed = j2;
        this.totalSize = j3;
        this.romFreeSpace = j4;
        this.appUsage = j5;
        this.totalCapacity = j6;
        this.freeCapacity = j7;
        this.appOccupiedRate = d;
        this.topUsage = jSONArray;
        this.exceptionFolder = jSONArray2;
        this.outDateList = jSONArray3;
        this.diskInfo = jSONArray4;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraValues() {
        JSONObject jSONObject = new JSONObject();
        try {
            long j = this.dataUsed;
            if (j > 0) {
                jSONObject.put("data", j);
            }
            long j2 = this.cacheUsed;
            if (j2 > 0) {
                jSONObject.put("cache", j2);
            }
            long j3 = this.totalSize;
            if (j3 > 0) {
                jSONObject.put("total", j3);
            }
            long j4 = this.romFreeSpace;
            if (j4 > 0) {
                jSONObject.put("rom_free", j4);
            }
            long j5 = this.appUsage;
            if (j5 > 0) {
                jSONObject.put(PERF_DISK_APP_USAGE, j5);
            }
            long j6 = this.totalCapacity;
            if (j6 > 0) {
                jSONObject.put(PERF_DISK_TOTAL_CAPACITY, j6);
            }
            long j7 = this.freeCapacity;
            if (j7 > 0) {
                jSONObject.put(PERF_DISK_FREE_CAPACITY, j7);
            }
            double d = this.appOccupiedRate;
            if (d > 0.0d) {
                jSONObject.put(PERF_DISK_OCCUPIED_RATE, d);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static long getJsonSize(JSONArray jSONArray) {
        try {
            return jSONArray.toString().getBytes(UrlUtils.UTF_8).length;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private JSONArray tailorJsonObject(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new JSONArray();
        }
        int i = 102400;
        for (int i2 = 0; getJsonSize(jSONArray) > this.maxRoomOfJsonObject && i2 <= 10; i2++) {
            try {
                jSONArray = tailorDiskInfo(jSONArray, i);
            } catch (JSONException unused) {
            }
            i *= 2;
        }
        return jSONArray;
    }

    private JSONArray tailorDiskInfo(JSONArray jSONArray, int i) throws JSONException {
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            if (jSONObject.getLong("size") >= i) {
                JSONArray optJSONArray = jSONObject.optJSONArray("next_disk");
                if (optJSONArray != null) {
                    JSONArray tailorDiskInfo = tailorDiskInfo(optJSONArray, i);
                    if (tailorDiskInfo.length() > 0) {
                        jSONObject.put("next_disk", tailorDiskInfo);
                    } else {
                        jSONObject.remove("next_disk");
                    }
                }
                jSONArray2.put(jSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject createRootJSONObject() {
        int i;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = this.topUsage;
            if (jSONArray != null) {
                jSONObject.put("top_usage", jSONArray);
            }
            JSONArray jSONArray2 = this.exceptionFolder;
            if (jSONArray2 != null) {
                jSONObject.put("exception_folders", jSONArray2);
            }
            JSONArray jSONArray3 = this.outDateList;
            if (jSONArray3 != null) {
                jSONObject.put("outdated_files", jSONArray3);
            }
            if (this.diskInfo != null) {
                try {
                    i = jSONObject.toString().getBytes(UrlUtils.UTF_8).length;
                } catch (Exception unused) {
                    i = 0;
                }
                this.maxRoomOfJsonObject = (MAX_DATA_SIZE - i) - 12288;
                JSONArray tailorJsonObject = tailorJsonObject(this.diskInfo);
                this.diskInfo = tailorJsonObject;
                jSONObject.put("disk_info", tailorJsonObject);
            }
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraStatus() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", PerfFilterManager.getInstance().getSceneString());
            jSONObject.put("process_name", ApmContext.getCurrentProcessName());
            jSONObject.put(CommonKey.KEY_IS_FRONT, false);
            jSONObject.put("is_main_process", ApmContext.isMainProcess());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getFilters() {
        JSONObject perfFiltersJson = PerfFilterManager.getInstance().getPerfFiltersJson();
        try {
            JsonUtils.copyJson2(perfFiltersJson, PerfFilterManager.getInstance().getRealTimeMemInfo());
        } catch (Exception unused) {
        }
        return perfFiltersJson;
    }
}
