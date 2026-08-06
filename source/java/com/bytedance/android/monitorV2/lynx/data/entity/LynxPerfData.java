package com.bytedance.android.monitorV2.lynx.data.entity;

import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitorConstant;
import com.bytedance.android.monitorV2.util.JsonUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LynxPerfData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020,H\u0002J\u0010\u0010H\u001a\u00020F2\u0006\u0010G\u001a\u00020,H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u001a\u00104\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\u001a\u00107\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR(\u0010:\u001a\u0010\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\b¨\u0006I"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxPerfData;", "Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;", "()V", "diffRootCreate", "", "getDiffRootCreate", "()D", "setDiffRootCreate", "(D)V", "diffSameRoot", "getDiffSameRoot", "setDiffSameRoot", "fmp", "getFmp", "setFmp", "fp", "getFp", "setFp", "layout", "getLayout", "setLayout", "lifecycle", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxLifecycleData;", "getLifecycle", "()Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxLifecycleData;", "setLifecycle", "(Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxLifecycleData;)V", "value", "", "lynxState", "getLynxState", "()I", "setLynxState", "(I)V", "perfReportTime", "", "getPerfReportTime", "()J", "setPerfReportTime", "(J)V", "renderPage", "getRenderPage", "setRenderPage", "sourceJsonObj", "Lorg/json/JSONObject;", "getSourceJsonObj", "()Lorg/json/JSONObject;", "setSourceJsonObj", "(Lorg/json/JSONObject;)V", "tasmBinaryDecode", "getTasmBinaryDecode", "setTasmBinaryDecode", "tasmFinishLoadTemplate", "getTasmFinishLoadTemplate", "setTasmFinishLoadTemplate", "tasmRndDecodeFinishLoadTemplate", "getTasmRndDecodeFinishLoadTemplate", "setTasmRndDecodeFinishLoadTemplate", "timingInfo", "", "", "", "getTimingInfo", "()Ljava/util/Map;", "setTimingInfo", "(Ljava/util/Map;)V", "tti", "getTti", "setTti", "appendNativeInfoParams", "", "jsonObj", "fillInJsonObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxPerfData extends BaseNativeInfo {
    private double diffRootCreate;
    private double diffSameRoot;
    private double fmp;
    private double fp;
    private double layout;
    private LynxLifecycleData lifecycle;
    private int lynxState;
    private long perfReportTime;
    private double renderPage;
    private JSONObject sourceJsonObj;
    private double tasmBinaryDecode;
    private double tasmFinishLoadTemplate;
    private double tasmRndDecodeFinishLoadTemplate;
    private Map<String, Object> timingInfo;
    private double tti;

    public LynxPerfData() {
        super("performance");
        this.perfReportTime = System.currentTimeMillis();
    }

    public final double getFp() {
        return this.fp;
    }

    public final void setFp(double d) {
        this.fp = d;
    }

    public final double getFmp() {
        return this.fmp;
    }

    public final void setFmp(double d) {
        this.fmp = d;
    }

    public final double getTti() {
        return this.tti;
    }

    public final void setTti(double d) {
        this.tti = d;
    }

    public final double getLayout() {
        return this.layout;
    }

    public final void setLayout(double d) {
        this.layout = d;
    }

    public final double getDiffRootCreate() {
        return this.diffRootCreate;
    }

    public final void setDiffRootCreate(double d) {
        this.diffRootCreate = d;
    }

    public final double getDiffSameRoot() {
        return this.diffSameRoot;
    }

    public final void setDiffSameRoot(double d) {
        this.diffSameRoot = d;
    }

    public final double getTasmRndDecodeFinishLoadTemplate() {
        return this.tasmRndDecodeFinishLoadTemplate;
    }

    public final void setTasmRndDecodeFinishLoadTemplate(double d) {
        this.tasmRndDecodeFinishLoadTemplate = d;
    }

    public final double getTasmBinaryDecode() {
        return this.tasmBinaryDecode;
    }

    public final void setTasmBinaryDecode(double d) {
        this.tasmBinaryDecode = d;
    }

    public final double getTasmFinishLoadTemplate() {
        return this.tasmFinishLoadTemplate;
    }

    public final void setTasmFinishLoadTemplate(double d) {
        this.tasmFinishLoadTemplate = d;
    }

    public final double getRenderPage() {
        return this.renderPage;
    }

    public final void setRenderPage(double d) {
        this.renderPage = d;
    }

    public final LynxLifecycleData getLifecycle() {
        return this.lifecycle;
    }

    public final void setLifecycle(LynxLifecycleData lynxLifecycleData) {
        this.lifecycle = lynxLifecycleData;
    }

    public final JSONObject getSourceJsonObj() {
        return this.sourceJsonObj;
    }

    public final void setSourceJsonObj(JSONObject jSONObject) {
        this.sourceJsonObj = jSONObject;
    }

    public final int getLynxState() {
        return this.lynxState;
    }

    public final void setLynxState(int i) {
        MonitorLog.m29i("LynxState", "set lynx_state = " + i);
        this.lynxState = i;
    }

    public final long getPerfReportTime() {
        return this.perfReportTime;
    }

    public final void setPerfReportTime(long j) {
        this.perfReportTime = j;
    }

    public final Map<String, Object> getTimingInfo() {
        return this.timingInfo;
    }

    public final void setTimingInfo(Map<String, Object> map) {
        this.timingInfo = map;
    }

    @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        appendNativeInfoParams(jsonObj);
        LynxLifecycleData lynxLifecycleData = this.lifecycle;
        if (lynxLifecycleData != null) {
            lynxLifecycleData.fillInJsonObject(jsonObj);
        }
    }

    private final void appendNativeInfoParams(JSONObject jsonObj) {
        JsonUtils.deepCopy(jsonObj, this.sourceJsonObj);
        JsonUtils.safePut(jsonObj, "fp", Double.valueOf(this.fp));
        JsonUtils.safePut(jsonObj, "fmp", Double.valueOf(this.fmp));
        JsonUtils.safePut(jsonObj, "tti", Double.valueOf(this.tti));
        JsonUtils.safePut(jsonObj, LynxViewMonitorConstant.LAYOUT, Double.valueOf(this.layout));
        JsonUtils.safePut(jsonObj, LynxViewMonitorConstant.RENDER_PAGE, Double.valueOf(this.renderPage));
        JsonUtils.safePut(jsonObj, LynxViewMonitorConstant.DIFF_ROOT_CREATE, Double.valueOf(this.diffRootCreate));
        JsonUtils.safePut(jsonObj, LynxViewMonitorConstant.DIFF_SAME_ROOT, Double.valueOf(this.diffSameRoot));
        JsonUtils.safePut(jsonObj, LynxViewMonitorConstant.TASM_BINARY_DECODE, Double.valueOf(this.tasmBinaryDecode));
        JsonUtils.safePut(jsonObj, LynxViewMonitorConstant.TASM_END_DECODE_FINISH_LOAD_TEMPLATE, Double.valueOf(this.tasmRndDecodeFinishLoadTemplate));
        JsonUtils.safePut(jsonObj, LynxViewMonitorConstant.TASM_FINISH_LOAD_TEMPLATE, Double.valueOf(this.tasmFinishLoadTemplate));
        JsonUtils.safePut(jsonObj, "state", this.lynxState);
        JsonUtils.safePut(jsonObj, LynxViewMonitorConstant.REPORT_TS, this.perfReportTime);
        JSONObject jSONObject = new JSONObject();
        Map<String, Object> map = this.timingInfo;
        if ((map != null ? map.get("metrics") : null) != null) {
            Map<String, Object> map2 = this.timingInfo;
            JsonUtils.safePut(jSONObject, "metrics", JsonUtils.safeToJsonOb(String.valueOf(map2 != null ? map2.get("metrics") : null)));
        }
        Map<String, Object> map3 = this.timingInfo;
        if ((map3 != null ? map3.get(LynxViewMonitorConstant.SETUP_TIMING) : null) != null) {
            Map<String, Object> map4 = this.timingInfo;
            JsonUtils.safePut(jSONObject, LynxViewMonitorConstant.SETUP_TIMING, JsonUtils.safeToJsonOb(String.valueOf(map4 != null ? map4.get(LynxViewMonitorConstant.SETUP_TIMING) : null)));
        }
        Map<String, Object> map5 = this.timingInfo;
        if ((map5 != null ? map5.get(LynxViewMonitorConstant.UPDATE_TIMINGS) : null) != null) {
            Map<String, Object> map6 = this.timingInfo;
            JsonUtils.safePut(jSONObject, LynxViewMonitorConstant.UPDATE_TIMINGS, JsonUtils.safeToJsonOb(String.valueOf(map6 != null ? map6.get(LynxViewMonitorConstant.UPDATE_TIMINGS) : null)));
        }
        Map<String, Object> map7 = this.timingInfo;
        if ((map7 != null ? map7.get(LynxViewMonitorConstant.EXTRA_TIMING) : null) != null) {
            Map<String, Object> map8 = this.timingInfo;
            JsonUtils.safePut(jSONObject, LynxViewMonitorConstant.EXTRA_TIMING, JsonUtils.safeToJsonOb(String.valueOf(map8 != null ? map8.get(LynxViewMonitorConstant.EXTRA_TIMING) : null)));
        }
        Map<String, Object> map9 = this.timingInfo;
        if ((map9 != null ? map9.get(LynxViewMonitorConstant.THREAD_STRATEGY) : null) != null) {
            Map<String, Object> map10 = this.timingInfo;
            JsonUtils.safePut(jSONObject, LynxViewMonitorConstant.THREAD_STRATEGY, map10 != null ? map10.get(LynxViewMonitorConstant.THREAD_STRATEGY) : null);
        }
        Map<String, Object> map11 = this.timingInfo;
        if (String.valueOf(map11 != null ? map11.get("url") : null).length() > 0) {
            Map<String, Object> map12 = this.timingInfo;
            JsonUtils.safePut(jSONObject, "url", map12 != null ? map12.get("url") : null);
        }
        JsonUtils.deepCopy(jsonObj, jSONObject);
    }
}
