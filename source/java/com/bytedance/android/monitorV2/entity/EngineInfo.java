package com.bytedance.android.monitorV2.entity;

import com.bytedance.android.monitorV2.base.BaseMonitorData;
import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.util.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: EngineInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u000e\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020?J\u001e\u0010@\u001a\u00020:2\u0006\u0010>\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R$\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR$\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R$\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R$\u0010 \u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\rR$\u0010#\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\rR$\u0010&\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R$\u0010)\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R$\u0010-\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0011\"\u0004\b/\u0010\u0013R$\u00100\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010\u0013R$\u00104\u001a\u0002032\u0006\u0010\u0007\u001a\u000203@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006D"}, d2 = {"Lcom/bytedance/android/monitorV2/entity/EngineInfo;", "Lcom/bytedance/android/monitorV2/base/BaseMonitorData;", "commonData", "Lcom/bytedance/android/monitorV2/entity/NativeCommon;", "(Lcom/bytedance/android/monitorV2/entity/NativeCommon;)V", "getCommonData", "()Lcom/bytedance/android/monitorV2/entity/NativeCommon;", "<set-?>", "", "domState", "getDomState", "()Ljava/lang/String;", "setDomState$anniex_release", "(Ljava/lang/String;)V", "", "fetchErrorCount", "getFetchErrorCount", "()I", "setFetchErrorCount$anniex_release", "(I)V", "jsExceptionCount", "getJsExceptionCount", "setJsExceptionCount$anniex_release", "jsHang", "getJsHang", "setJsHang$anniex_release", "jsbErrorCount", "getJsbErrorCount", "setJsbErrorCount$anniex_release", "nativeErrorCount", "getNativeErrorCount", "setNativeErrorCount$anniex_release", "renderStatus", "getRenderStatus", "setRenderStatus$anniex_release", "renderingPhase", "getRenderingPhase", "setRenderingPhase$anniex_release", "resLoaderErrorCount", "getResLoaderErrorCount", "setResLoaderErrorCount$anniex_release", "resLoaderErrorTemplateCount", "getResLoaderErrorTemplateCount", "setResLoaderErrorTemplateCount$anniex_release", "value", MonitorConstant.STAGE, "getStage", "setStage", "staticCount", "getStaticCount", "setStaticCount$anniex_release", "Lcom/bytedance/android/monitorV2/entity/UnifyError;", "unifyError", "getUnifyError", "()Lcom/bytedance/android/monitorV2/entity/UnifyError;", "setUnifyError$anniex_release", "(Lcom/bytedance/android/monitorV2/entity/UnifyError;)V", "fillInJsonObject", "", "jsonObject", "Lorg/json/JSONObject;", "update", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "updateRawError", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "originCode", "message", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class EngineInfo extends BaseMonitorData {
    private final NativeCommon commonData;
    private String domState;
    private int fetchErrorCount;
    private int jsExceptionCount;
    private String jsHang;
    private int jsbErrorCount;
    private int nativeErrorCount;
    private String renderStatus;
    private String renderingPhase;
    private int resLoaderErrorCount;
    private int resLoaderErrorTemplateCount;
    private int stage;
    private int staticCount;
    private UnifyError unifyError;

    public EngineInfo(NativeCommon nativeCommon) {
        Intrinsics.checkNotNullParameter(nativeCommon, "commonData");
        this.commonData = nativeCommon;
        this.unifyError = new UnifyError(UnifyErrorDomain.AnnieXUnifyErrorDomainReserved.getErrorDomain(), null, 0, 6, null);
        this.renderStatus = "";
        this.domState = "";
        this.renderingPhase = "";
        this.jsHang = "";
        nativeCommon.addContext(MonitorConstant.STAGE, 0);
    }

    public final NativeCommon getCommonData() {
        return this.commonData;
    }

    public final int getStage() {
        return this.stage;
    }

    public final void setStage(int i) {
        this.stage = i;
        this.commonData.addContext(MonitorConstant.STAGE, Integer.valueOf(i));
    }

    public final UnifyError getUnifyError() {
        return this.unifyError;
    }

    public final void setUnifyError$anniex_release(UnifyError unifyError) {
        Intrinsics.checkNotNullParameter(unifyError, "<set-?>");
        this.unifyError = unifyError;
    }

    public final int getJsExceptionCount() {
        return this.jsExceptionCount;
    }

    public final void setJsExceptionCount$anniex_release(int i) {
        this.jsExceptionCount = i;
    }

    public final int getNativeErrorCount() {
        return this.nativeErrorCount;
    }

    public final void setNativeErrorCount$anniex_release(int i) {
        this.nativeErrorCount = i;
    }

    public final int getStaticCount() {
        return this.staticCount;
    }

    public final void setStaticCount$anniex_release(int i) {
        this.staticCount = i;
    }

    public final int getFetchErrorCount() {
        return this.fetchErrorCount;
    }

    public final void setFetchErrorCount$anniex_release(int i) {
        this.fetchErrorCount = i;
    }

    public final int getJsbErrorCount() {
        return this.jsbErrorCount;
    }

    public final void setJsbErrorCount$anniex_release(int i) {
        this.jsbErrorCount = i;
    }

    public final int getResLoaderErrorCount() {
        return this.resLoaderErrorCount;
    }

    public final void setResLoaderErrorCount$anniex_release(int i) {
        this.resLoaderErrorCount = i;
    }

    public final int getResLoaderErrorTemplateCount() {
        return this.resLoaderErrorTemplateCount;
    }

    public final void setResLoaderErrorTemplateCount$anniex_release(int i) {
        this.resLoaderErrorTemplateCount = i;
    }

    public final String getRenderStatus() {
        return this.renderStatus;
    }

    public final void setRenderStatus$anniex_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.renderStatus = str;
    }

    public final String getDomState() {
        return this.domState;
    }

    public final void setDomState$anniex_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.domState = str;
    }

    public final String getRenderingPhase() {
        return this.renderingPhase;
    }

    public final void setRenderingPhase$anniex_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.renderingPhase = str;
    }

    public final String getJsHang() {
        return this.jsHang;
    }

    public final void setJsHang$anniex_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jsHang = str;
    }

    public final void update(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof CommonEvent) {
            String eventType = event.getEventType();
            switch (eventType.hashCode()) {
                case -892481938:
                    if (eventType.equals(ReportConst.Event.STATIC)) {
                        this.staticCount++;
                        return;
                    }
                    return;
                case 281935726:
                    if (eventType.equals("fetchError")) {
                        this.fetchErrorCount++;
                        return;
                    }
                    return;
                case 299602137:
                    if (eventType.equals(ReportConst.Event.JS_EXCEPTION)) {
                        this.jsExceptionCount++;
                        return;
                    }
                    return;
                case 1521451035:
                    if (eventType.equals(ReportConst.Event.RES_LOADER_ERROR)) {
                        this.resLoaderErrorCount++;
                        return;
                    }
                    return;
                case 1727072305:
                    if (eventType.equals("nativeError")) {
                        this.nativeErrorCount++;
                        return;
                    }
                    return;
                case 1830775838:
                    if (eventType.equals(ReportConst.Event.RES_LOADER_ERROR_TEMPLATE)) {
                        this.resLoaderErrorTemplateCount++;
                        return;
                    }
                    return;
                case 1910899023:
                    if (eventType.equals("jsbError")) {
                        this.jsbErrorCount++;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void updateRawError(CommonEvent event, int originCode, String message) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(message, "message");
        String eventType = event.getEventType();
        switch (eventType.hashCode()) {
            case -892481938:
                if (eventType.equals(ReportConst.Event.STATIC)) {
                    this.unifyError = new UnifyError(UnifyErrorDomain.AnnieXUnifyErrorDomainStaticResource.getErrorDomain(), message, originCode);
                    return;
                }
                return;
            case 281935726:
                if (eventType.equals("fetchError")) {
                    this.unifyError = new UnifyError(UnifyErrorDomain.AnnieXUnifyErrorDomainFetch.getErrorDomain(), message, originCode);
                    return;
                }
                return;
            case 299602137:
                if (eventType.equals(ReportConst.Event.JS_EXCEPTION)) {
                    this.unifyError = new UnifyError(UnifyErrorDomain.AnnieXUnifyErrorDomainJS.getErrorDomain(), message, originCode);
                    return;
                }
                return;
            case 1521451035:
                if (eventType.equals(ReportConst.Event.RES_LOADER_ERROR)) {
                    this.unifyError = new UnifyError(UnifyErrorDomain.AnnieXUnifyErrorDomainResourceLoader.getErrorDomain(), message, originCode);
                    return;
                }
                return;
            case 1727072305:
                if (eventType.equals("nativeError")) {
                    this.unifyError = Intrinsics.areEqual(event.getNativeBase().containerType, "web") ? new UnifyError(UnifyErrorDomain.AnnieXUnifyErrorDomainEngineWeb.getErrorDomain(), message, originCode) : new UnifyError(UnifyErrorDomain.AnnieXUnifyErrorDomainEngineLynx.getErrorDomain(), message, originCode);
                    return;
                }
                return;
            case 1830775838:
                if (eventType.equals(ReportConst.Event.RES_LOADER_ERROR_TEMPLATE)) {
                    this.unifyError = new UnifyError(UnifyErrorDomain.AnnieXUnifyErrorDomainResourceLoader.getErrorDomain(), message, originCode);
                    return;
                }
                return;
            case 1910899023:
                if (eventType.equals("jsbError")) {
                    this.unifyError = new UnifyError(UnifyErrorDomain.AnnieXUnifyErrorDomainContainerJSB.getErrorDomain(), message, originCode);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObject) {
        JsonUtils.safePut(jsonObject, MonitorConstant.STAGE, this.stage);
        JsonUtils.safePut(jsonObject, MonitorConstant.COUNT_JS_EXCEPTION, this.jsExceptionCount);
        JsonUtils.safePut(jsonObject, MonitorConstant.COUNT_NATIVE_ERROR, this.nativeErrorCount);
        JsonUtils.safePut(jsonObject, MonitorConstant.COUNT_STATIC, this.staticCount);
        JsonUtils.safePut(jsonObject, MonitorConstant.COUNT_FETCH_ERROR, this.fetchErrorCount);
        JsonUtils.safePut(jsonObject, MonitorConstant.COUNT_JSB_ERROR, this.jsbErrorCount);
        JsonUtils.safePut(jsonObject, MonitorConstant.COUNT_RES_LOADER_ERROR, this.resLoaderErrorCount);
        JsonUtils.safePut(jsonObject, MonitorConstant.COUNT_RES_LOADER_ERROR_TEMPLATE, this.resLoaderErrorTemplateCount);
        JsonUtils.safePut(jsonObject, MonitorConstant.RENDER_STATUS, this.renderStatus);
        JsonUtils.safePut(jsonObject, MonitorConstant.DOM_STATE, this.domState);
        JsonUtils.safePut(jsonObject, MonitorConstant.RENDERING_PHASE, this.renderingPhase);
        JsonUtils.safePut(jsonObject, MonitorConstant.JS_HANG, this.jsHang);
    }
}
