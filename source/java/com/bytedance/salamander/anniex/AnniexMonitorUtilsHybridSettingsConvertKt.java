package com.bytedance.salamander.anniex;

import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.rts.foundation.RTSIntKt;
import com.bytedance.rts.foundation.RTSMapKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AnniexMonitorUtilsHybridSettingsConvert.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u001a\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000b\u001a\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000b\u001a.\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000b0\u0018j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000b`\u001a2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u001a\u001a\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u001e\u001a\u00020\t\u001a\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t¨\u0006!"}, d2 = {"convertJSONSettings", "Lcom/bytedance/salamander/anniex/HybridSettingsResponse;", "jsonObject", "Lorg/json/JSONObject;", "Lcom/bytedance/salamander/anniex/AnnieXJSONObject;", "convertSample", "Lcom/bytedance/salamander/anniex/BidConfig;", "bidConfig", "variable0", "", "bit", "", "isSampleForContainer", "", "eventType", "Lcom/bytedance/salamander/anniex/SLEventType;", "isSampleForCustom", "p", "isSampleForLynx", "isSampleForWebSample", "setSample", "", "i", "toAllEventSample", "", "", "Lcom/bytedance/rts/foundation/RTSMap;", "toBidInfo", "Lcom/bytedance/salamander/anniex/BidInfo;", "bidObject", "settingId", "toSwitchConfig", "num", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AnniexMonitorUtilsHybridSettingsConvertKt {

    /* compiled from: AnniexMonitorUtilsHybridSettingsConvert.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SLEventType.values().length];
            try {
                iArr[SLEventType.PERFORMANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SLEventType.BLANK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SLEventType.FETCH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SLEventType.JSB_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SLEventType.JSB_PERF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SLEventType.NATIVE_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SLEventType.PV.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SLEventType.CONTAINER_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SLEventType.JS_EXCEPTION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SLEventType.STATIC.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SLEventType.RES_LOADER_PERF.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[SLEventType.RES_LOADER_PERF_TEMPLATE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[SLEventType.RES_LOADER_ERROR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[SLEventType.RES_LOADER_ERROR_TEMPLATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[SLEventType.AJAX.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[SLEventType.RESOURCE_PERFORMANCE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[SLEventType.STATIC_SRI.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final HybridSettingsResponse convertJSONSettings(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        HybridSettingsResponse hybridSettingsResponse = new HybridSettingsResponse();
        JSONObject optJSONObjectFromJSONObject = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optJSONObjectFromJSONObject(jSONObject, "data", AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().createJSONObject());
        hybridSettingsResponse.setUpdateTime(AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optLongFromJSONObject(optJSONObjectFromJSONObject, "update_time", 0L));
        hybridSettingsResponse.setDuration(AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optIntFromJSONObject(optJSONObjectFromJSONObject, LynxTimingPerformanceReportProcessor.KEY_DURATION, 0));
        hybridSettingsResponse.setSettingId(AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optLongFromJSONObject(optJSONObjectFromJSONObject, "setting_id", 0L));
        hybridSettingsResponse.setSwitchConfig(toSwitchConfig(AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optLongFromJSONObject(optJSONObjectFromJSONObject, "enable_switch", 0L)));
        hybridSettingsResponse.setAllEventSample(toAllEventSample(AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optJSONObjectFromJSONObject(optJSONObjectFromJSONObject, "all_event_sample", AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().createJSONObject())));
        hybridSettingsResponse.setBidInfo(toBidInfo(AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optJSONObjectFromJSONObject(optJSONObjectFromJSONObject, "bid_info", AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().createJSONObject()), hybridSettingsResponse.getSettingId()));
        return hybridSettingsResponse;
    }

    public static final long toSwitchConfig(long j) {
        Switches.INSTANCE.resetAll(j);
        return j;
    }

    public static final Map<String, Integer> toAllEventSample(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Map<String, Integer> RTSMap = RTSMapKt.RTSMap();
        for (String str : AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().getJSONObjectKeys(jSONObject)) {
            RTSMapKt.set(RTSMap, str, Integer.valueOf(AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optIntFromJSONObject(jSONObject, str, 0)));
        }
        return RTSMap;
    }

    public static final BidInfo toBidInfo(JSONObject jSONObject, long j) {
        Intrinsics.checkNotNullParameter(jSONObject, "bidObject");
        BidInfo bidInfo = new BidInfo();
        JSONObject createJSONObject = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().createJSONObject();
        Intrinsics.checkNotNull(createJSONObject, "null cannot be cast to non-null type org.json.JSONObject{ com.bytedance.salamander.anniex.AnniexMonitorFoundationInterfaceBasicTypeKt.AnnieXJSONObject }");
        for (String str : AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().getJSONObjectKeys(jSONObject)) {
            Intrinsics.checkNotNull(str, "null cannot be cast to non-null type kotlin.Any");
            String str2 = str;
            JSONObject optJSONObjectFromJSONObject = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optJSONObjectFromJSONObject(jSONObject, str2, createJSONObject);
            long optLongFromJSONObject = AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optLongFromJSONObject(optJSONObjectFromJSONObject, "hit_sample", 0L);
            BidConfig bidConfig = new BidConfig(str2);
            bidConfig.setHitSample(optLongFromJSONObject);
            bidConfig.setSettingId(j);
            bidConfig.setEventNameSample(toAllEventSample(AnniexMonitorFoundationImplJSONUtilsKt.getJSONUtils().optJSONObjectFromJSONObject(optJSONObjectFromJSONObject, "event_name_sample", createJSONObject)));
            RTSMapKt.set(bidInfo.getBidInfoMap(), str2, convertSample(bidConfig, optLongFromJSONObject, BidConfig.INSTANCE.getNUM()));
        }
        return bidInfo;
    }

    public static final BidConfig convertSample(BidConfig bidConfig, long j, int i) {
        Intrinsics.checkNotNullParameter(bidConfig, "bidConfig");
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 != 0) {
                j >>= 1;
            }
            if (j % 2 == RTSIntKt.toInt64(IntCompanionObject.INSTANCE, 1)) {
                setSample(bidConfig, i2);
            }
        }
        return bidConfig;
    }

    public static final void setSample(BidConfig bidConfig, int i) {
        Intrinsics.checkNotNullParameter(bidConfig, "bidConfig");
        switch (i) {
            case 0:
                bidConfig.setCustom_p0(true);
                return;
            case 1:
                bidConfig.setCustom_p1(true);
                return;
            case 2:
                bidConfig.setCustom_p2(true);
                return;
            case 3:
                bidConfig.setCustom_p3(true);
                return;
            case 4:
                bidConfig.setCustom_p4(true);
                return;
            case 5:
                bidConfig.setCustom_p5(true);
                return;
            case 6:
                bidConfig.setCustom_p6(true);
                return;
            case 7:
                bidConfig.setCustom_p7(true);
                return;
            case 8:
                bidConfig.setCustom_p8(true);
                return;
            case 9:
                bidConfig.setPerf_web(true);
                return;
            case 10:
                bidConfig.setAjax_web(true);
                return;
            case 11:
                bidConfig.setStatic_perf_web(true);
                return;
            case 12:
                bidConfig.setStatic_error_web(true);
                return;
            case 13:
                bidConfig.setJs_exception_web(true);
                return;
            case 14:
                bidConfig.setBlank_web(true);
                return;
            case 15:
                bidConfig.setFetch_error_web(true);
                return;
            case 16:
                bidConfig.setJsb_error_web(true);
                return;
            case 17:
                bidConfig.setJsb_perf_web(true);
                return;
            case 18:
                bidConfig.setFalcon_perf_web(true);
                return;
            case 19:
                bidConfig.setNative_error_web(true);
                return;
            case 20:
                bidConfig.setNavigation_start_web(true);
                return;
            case 21:
                bidConfig.setStatic_sri_web(true);
                return;
            case 22:
                bidConfig.setPerformance_lynx(true);
                return;
            case 23:
                bidConfig.setBlank_lynx(true);
                return;
            case 24:
                bidConfig.setFetch_error_lynx(true);
                return;
            case 25:
                bidConfig.setJsb_error_lynx(true);
                return;
            case 26:
                bidConfig.setJsb_perf_lynx(true);
                return;
            case 27:
                bidConfig.setNative_error_lynx(true);
                return;
            case 28:
                bidConfig.setNavigation_start_lynx(true);
                return;
            case 29:
                bidConfig.setPerformance_reactnative(true);
                return;
            case 30:
                bidConfig.setBlank_reactnative(true);
                return;
            case 31:
                bidConfig.setFetch_error_reactnative(true);
                return;
            case 32:
                bidConfig.setJsb_error_reactnative(true);
                return;
            case 33:
                bidConfig.setNative_error_reactnative(true);
                return;
            case 34:
                bidConfig.setContainer_error(true);
                return;
            case 35:
                bidConfig.setJs_exception_lynx(true);
                return;
            case 36:
                bidConfig.setStatic_error_lynx(true);
                return;
            case 37:
                bidConfig.setTea_switch(true);
                return;
            case 38:
                bidConfig.setRes_loader_perf_web(true);
                return;
            case 39:
                bidConfig.setRes_loader_perf_template_web(true);
                return;
            case 40:
                bidConfig.setRes_loader_error_web(true);
                return;
            case 41:
                bidConfig.setRes_loader_error_template_web(true);
                return;
            case 42:
                bidConfig.setRes_loader_perf_lynx(true);
                return;
            case 43:
                bidConfig.setRes_loader_perf_template_lynx(true);
                return;
            case 44:
                bidConfig.setRes_loader_error_lynx(true);
                return;
            case 45:
                bidConfig.setRes_loader_error_template_lynx(true);
                return;
            default:
                return;
        }
    }

    public static final boolean isSampleForCustom(BidConfig bidConfig, int i) {
        Intrinsics.checkNotNullParameter(bidConfig, "bidConfig");
        switch (i) {
            case 0:
                return bidConfig.getCustom_p0();
            case 1:
                return bidConfig.getCustom_p1();
            case 2:
                return bidConfig.getCustom_p2();
            case 3:
                return bidConfig.getCustom_p3();
            case 4:
                return bidConfig.getCustom_p4();
            case 5:
                return bidConfig.getCustom_p5();
            case 6:
                return bidConfig.getCustom_p6();
            case 7:
                return bidConfig.getCustom_p7();
            default:
                return bidConfig.getCustom_p8();
        }
    }

    public static final boolean isSampleForLynx(SLEventType sLEventType, BidConfig bidConfig) {
        Intrinsics.checkNotNullParameter(sLEventType, "eventType");
        Intrinsics.checkNotNullParameter(bidConfig, "bidConfig");
        switch (WhenMappings.$EnumSwitchMapping$0[sLEventType.ordinal()]) {
            case 1:
                return bidConfig.getPerformance_lynx();
            case 2:
                return bidConfig.getBlank_lynx();
            case 3:
                return bidConfig.getFetch_error_lynx();
            case 4:
                return bidConfig.getJsb_error_lynx();
            case 5:
                return bidConfig.getJsb_perf_lynx();
            case 6:
                return bidConfig.getNative_error_lynx();
            case 7:
                return bidConfig.getNavigation_start_lynx();
            case 8:
                return bidConfig.getContainer_error();
            case 9:
                return bidConfig.getJs_exception_lynx();
            case 10:
                return bidConfig.getStatic_error_lynx();
            case 11:
                return bidConfig.getRes_loader_perf_lynx();
            case 12:
                return bidConfig.getRes_loader_perf_template_lynx();
            case 13:
                return bidConfig.getRes_loader_error_lynx();
            case 14:
                return bidConfig.getRes_loader_error_template_lynx();
            default:
                return false;
        }
    }

    public static final boolean isSampleForWebSample(SLEventType sLEventType, BidConfig bidConfig) {
        Intrinsics.checkNotNullParameter(sLEventType, "eventType");
        Intrinsics.checkNotNullParameter(bidConfig, "bidConfig");
        switch (WhenMappings.$EnumSwitchMapping$0[sLEventType.ordinal()]) {
            case 1:
                return bidConfig.getPerf_web();
            case 2:
                return bidConfig.getBlank_web();
            case 3:
                return bidConfig.getFetch_error_web();
            case 4:
                return bidConfig.getJsb_error_web();
            case 5:
                return bidConfig.getJsb_perf_web();
            case 6:
                return bidConfig.getNative_error_web();
            case 7:
                return bidConfig.getNavigation_start_web();
            case 8:
                return bidConfig.getContainer_error();
            case 9:
                return bidConfig.getJs_exception_web();
            case 10:
                return bidConfig.getStatic_error_web();
            case 11:
                return bidConfig.getRes_loader_perf_web();
            case 12:
                return bidConfig.getRes_loader_perf_template_web();
            case 13:
                return bidConfig.getRes_loader_error_web();
            case 14:
                return bidConfig.getRes_loader_error_template_web();
            case 15:
                return bidConfig.getAjax_web();
            case 16:
                return bidConfig.getStatic_perf_web();
            case 17:
                return bidConfig.getStatic_sri_web();
            default:
                return false;
        }
    }

    public static final boolean isSampleForContainer(SLEventType sLEventType, BidConfig bidConfig) {
        Intrinsics.checkNotNullParameter(sLEventType, "eventType");
        Intrinsics.checkNotNullParameter(bidConfig, "bidConfig");
        if (WhenMappings.$EnumSwitchMapping$0[sLEventType.ordinal()] == 8) {
            return bidConfig.getContainer_error();
        }
        return false;
    }
}
