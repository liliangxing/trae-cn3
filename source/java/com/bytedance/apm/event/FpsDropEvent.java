package com.bytedance.apm.event;

import com.bytedance.apm.util.FpsUtil;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FpsDropEvent extends PerfBaseEvent {
    private static final String FPS_DROP_SERVICE = "fps_drop";
    private static final String KEY_DROP_RATE = "drop_time_rate";
    private static final String KEY_REFRESH_RATE = "refresh_rate";
    private static final String KEY_SCENE = "scene";
    public static final int MIN_DROP_FRAME = 0;
    private static final String SCROLL_TIME = "total_scroll_time";
    private int[] dropLevel;
    private int maxDropCount;
    private int sumFrame;
    private long sumFrameCost;
    private String visibleScene;

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getFilters() {
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        return "fps_drop";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return false;
    }

    public FpsDropEvent(int i, int[] iArr, int i2, String str, long j) {
        this.maxDropCount = i;
        this.dropLevel = iArr;
        this.sumFrame = i2;
        this.visibleScene = str;
        this.sumFrameCost = j;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraValues() {
        try {
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i <= this.maxDropCount; i++) {
                if (this.dropLevel[i] > 0) {
                    jSONObject.put(String.valueOf(i), this.dropLevel[i]);
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraStatus() {
        try {
            new JSONObject().put("scene", this.visibleScene);
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject createRootJSONObject() {
        try {
            float frameIntervalMillis = FpsUtil.getFrameIntervalMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("total_scroll_time", this.sumFrameCost);
            jSONObject.put("drop_time_rate", 1.0f - ((this.sumFrame * 1.0f) / ((int) (((float) this.sumFrameCost) / frameIntervalMillis))));
            jSONObject.put("refresh_rate", this.maxDropCount + 1);
        } catch (Throwable unused) {
        }
        return super.createRootJSONObject();
    }
}
