package com.bytedance.android.monitorV2.lynx.data.entity;

import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.android.monitorV2.entity.EngineInfo;
import com.bytedance.android.monitorV2.util.JsonUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LynxBlankData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`H\u0016R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0018\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010$\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001a\u0010*\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u001a\u0010-\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001e\"\u0004\bA\u0010 R\u001a\u0010B\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\r\"\u0004\bD\u0010\u000fR\u001a\u0010E\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\r\"\u0004\bG\u0010\u000fR\u001a\u0010H\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR\u001a\u0010K\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00103\"\u0004\bM\u00105R\u001a\u0010N\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR\u001a\u0010Q\u001a\u00020RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR(\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\b\"\u0004\bY\u0010\nR\u001a\u0010Z\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\r\"\u0004\b\\\u0010\u000f¨\u0006a"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxBlankData;", "Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;", "()V", "allElements", "", "", "", "getAllElements", "()Ljava/util/Map;", "setAllElements", "(Ljava/util/Map;)V", "alpha", "getAlpha", "()I", "setAlpha", "(I)V", MonitorConstant.BLANK_BITMAP, "getBitmap", "()Ljava/lang/String;", "setBitmap", "(Ljava/lang/String;)V", "bitmapHeight", "getBitmapHeight", "setBitmapHeight", "bitmapWidth", "getBitmapWidth", "setBitmapWidth", "calculateTime", "", "getCalculateTime", "()J", "setCalculateTime", "(J)V", "collectTime", "getCollectTime", "setCollectTime", "costTime", "getCostTime", "setCostTime", "detectFrom", "getDetectFrom", "setDetectFrom", "detectStartTime", "getDetectStartTime", "setDetectStartTime", "detectType", "getDetectType", "setDetectType", "effectivePercentage", "", "getEffectivePercentage", "()F", "setEffectivePercentage", "(F)V", "elementCount", "getElementCount", "setElementCount", "engineInfo", "Lcom/bytedance/android/monitorV2/entity/EngineInfo;", "getEngineInfo", "()Lcom/bytedance/android/monitorV2/entity/EngineInfo;", "setEngineInfo", "(Lcom/bytedance/android/monitorV2/entity/EngineInfo;)V", "enterPageTime", "getEnterPageTime", "setEnterPageTime", "height", "getHeight", "setHeight", "httpRttMs", "getHttpRttMs", "setHttpRttMs", "loadState", "getLoadState", "setLoadState", "maxBlankRectRadio", "getMaxBlankRectRadio", "setMaxBlankRectRadio", "transportRttMs", "getTransportRttMs", "setTransportRttMs", "validChildNode", "", "getValidChildNode", "()Z", "setValidChildNode", "(Z)V", "validElements", "getValidElements", "setValidElements", "width", "getWidth", "setWidth", "fillInJsonObject", "", "jsonObject", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxBlankData extends BaseNativeInfo {
    private Map<String, Integer> allElements;
    private int alpha;
    private String bitmap;
    private int bitmapHeight;
    private int bitmapWidth;
    private long calculateTime;
    private long collectTime;
    private long costTime;
    private String detectFrom;
    private long detectStartTime;
    private int detectType;
    private float effectivePercentage;
    private int elementCount;
    private EngineInfo engineInfo;
    private long enterPageTime;
    private int height;
    private int httpRttMs;
    private int loadState;
    private float maxBlankRectRadio;
    private int transportRttMs;
    private boolean validChildNode;
    private Map<String, Integer> validElements;
    private int width;

    public LynxBlankData() {
        super("blank");
        this.loadState = LynxLifecycleData.INSTANCE.getSTATE_UNKNOWN();
        this.maxBlankRectRadio = -1.0f;
        this.bitmap = "";
        this.detectFrom = "";
    }

    public final float getEffectivePercentage() {
        return this.effectivePercentage;
    }

    public final void setEffectivePercentage(float f) {
        this.effectivePercentage = f;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final long getCostTime() {
        return this.costTime;
    }

    public final void setCostTime(long j) {
        this.costTime = j;
    }

    public final long getCollectTime() {
        return this.collectTime;
    }

    public final void setCollectTime(long j) {
        this.collectTime = j;
    }

    public final long getCalculateTime() {
        return this.calculateTime;
    }

    public final void setCalculateTime(long j) {
        this.calculateTime = j;
    }

    public final int getDetectType() {
        return this.detectType;
    }

    public final void setDetectType(int i) {
        this.detectType = i;
    }

    public final long getEnterPageTime() {
        return this.enterPageTime;
    }

    public final void setEnterPageTime(long j) {
        this.enterPageTime = j;
    }

    public final long getDetectStartTime() {
        return this.detectStartTime;
    }

    public final void setDetectStartTime(long j) {
        this.detectStartTime = j;
    }

    public final int getHttpRttMs() {
        return this.httpRttMs;
    }

    public final void setHttpRttMs(int i) {
        this.httpRttMs = i;
    }

    public final int getTransportRttMs() {
        return this.transportRttMs;
    }

    public final void setTransportRttMs(int i) {
        this.transportRttMs = i;
    }

    public final int getLoadState() {
        return this.loadState;
    }

    public final void setLoadState(int i) {
        this.loadState = i;
    }

    public final float getMaxBlankRectRadio() {
        return this.maxBlankRectRadio;
    }

    public final void setMaxBlankRectRadio(float f) {
        this.maxBlankRectRadio = f;
    }

    public final int getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(int i) {
        this.alpha = i;
    }

    public final int getElementCount() {
        return this.elementCount;
    }

    public final void setElementCount(int i) {
        this.elementCount = i;
    }

    public final String getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bitmap = str;
    }

    public final int getBitmapWidth() {
        return this.bitmapWidth;
    }

    public final void setBitmapWidth(int i) {
        this.bitmapWidth = i;
    }

    public final int getBitmapHeight() {
        return this.bitmapHeight;
    }

    public final void setBitmapHeight(int i) {
        this.bitmapHeight = i;
    }

    public final EngineInfo getEngineInfo() {
        return this.engineInfo;
    }

    public final void setEngineInfo(EngineInfo engineInfo) {
        this.engineInfo = engineInfo;
    }

    public final Map<String, Integer> getAllElements() {
        return this.allElements;
    }

    public final void setAllElements(Map<String, Integer> map) {
        this.allElements = map;
    }

    public final Map<String, Integer> getValidElements() {
        return this.validElements;
    }

    public final void setValidElements(Map<String, Integer> map) {
        this.validElements = map;
    }

    public final boolean getValidChildNode() {
        return this.validChildNode;
    }

    public final void setValidChildNode(boolean z) {
        this.validChildNode = z;
    }

    public final String getDetectFrom() {
        return this.detectFrom;
    }

    public final void setDetectFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.detectFrom = str;
    }

    @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JsonUtils.safePut(jsonObject, "effective_percentage", Float.valueOf(this.effectivePercentage));
        JsonUtils.safePut(jsonObject, "view_height", this.height);
        JsonUtils.safePut(jsonObject, "view_width", this.width);
        JsonUtils.safePut(jsonObject, "view_alpha", this.alpha);
        JsonUtils.safePut(jsonObject, "element_count", this.elementCount);
        JsonUtils.safePut(jsonObject, "collect_time", this.collectTime);
        JsonUtils.safePut(jsonObject, "calculate_time", this.calculateTime);
        JsonUtils.safePut(jsonObject, "cost_time", this.costTime);
        JsonUtils.safePut(jsonObject, "detect_type", this.detectType);
        JsonUtils.safePut(jsonObject, "enter_page_time", this.enterPageTime);
        JsonUtils.safePut(jsonObject, "detect_start_time", this.detectStartTime);
        float f = this.maxBlankRectRadio;
        if (f > 0) {
            JsonUtils.safePut(jsonObject, MonitorConstant.MAX_BLANK_RECT_RADIO, Float.valueOf(f));
        }
        JSONObject jSONObject = new JSONObject();
        int i = this.httpRttMs;
        if (i != 0) {
            JsonUtils.safePut(jSONObject, "http_rtt_ms", i);
        }
        int i2 = this.transportRttMs;
        if (i2 != 0) {
            JsonUtils.safePut(jSONObject, "transport_rtt_ms", i2);
        }
        int i3 = this.loadState;
        if (i3 >= 0) {
            JsonUtils.safePut(jSONObject, "load_state", i3);
        }
        Unit unit = Unit.INSTANCE;
        JsonUtils.safePut(jsonObject, MonitorConstant.ASSIST_INFO, jSONObject);
        JsonUtils.safePut(jsonObject, MonitorConstant.BLANK_BITMAP, this.bitmap);
        JsonUtils.safePut(jsonObject, MonitorConstant.BLANK_BITMAP_WIDTH, this.bitmapWidth);
        JsonUtils.safePut(jsonObject, MonitorConstant.BLANK_BITMAP_HEIGHT, this.bitmapHeight);
        EngineInfo engineInfo = this.engineInfo;
        if (engineInfo != null) {
            engineInfo.fillInJsonObject(jsonObject);
        }
        Map<String, Integer> map = this.allElements;
        if (map != null) {
            JsonUtils.safePut(jsonObject, MonitorConstant.BLANK_ALL_ELEMENTS, new JSONObject(map));
        }
        Map<String, Integer> map2 = this.validElements;
        if (map2 != null) {
            JsonUtils.safePut(jsonObject, MonitorConstant.BLANK_VALID_ELEMENTS, new JSONObject(map2));
        }
        JsonUtils.safePut(jsonObject, MonitorConstant.BLANK_VALID_CHILD_NODE, Boolean.valueOf(this.validChildNode));
    }
}
