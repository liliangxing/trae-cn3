package com.bytedance.salamander.anniex;

import com.bytedance.rts.foundation.RTSMapKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorSettingsHybridSettingsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b]\b\u0016\u0018\u0000 ¦\u00012\u00020\u0001:\u0002¦\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001a\u0010\u001d\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u001a\u0010 \u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\nR\u001a\u0010#\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\b\"\u0004\b%\u0010\nR\u001a\u0010&\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\nR\u001a\u0010)\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\b\"\u0004\b+\u0010\nR\u001a\u0010,\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\b\"\u0004\b.\u0010\nR\u001a\u0010/\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\b\"\u0004\b1\u0010\nR\u001a\u00102\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\nR6\u00105\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020706j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000207`8X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\b\"\u0004\b?\u0010\nR\u001a\u0010@\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\b\"\u0004\bB\u0010\nR\u001a\u0010C\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\b\"\u0004\bE\u0010\nR\u001a\u0010F\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\b\"\u0004\bH\u0010\nR\u001a\u0010I\u001a\u00020JX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\b\"\u0004\bQ\u0010\nR\u001a\u0010R\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\b\"\u0004\bT\u0010\nR\u001a\u0010U\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\b\"\u0004\bW\u0010\nR\u001a\u0010X\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\b\"\u0004\bZ\u0010\nR\u001a\u0010[\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\b\"\u0004\b]\u0010\nR\u001a\u0010^\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\b\"\u0004\b`\u0010\nR\u001a\u0010a\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\b\"\u0004\bc\u0010\nR\u001a\u0010d\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\b\"\u0004\bf\u0010\nR\u001a\u0010g\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\b\"\u0004\bi\u0010\nR\u001a\u0010j\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\b\"\u0004\bl\u0010\nR\u001a\u0010m\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\b\"\u0004\bo\u0010\nR\u001a\u0010p\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\b\"\u0004\br\u0010\nR\u001a\u0010s\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\b\"\u0004\bu\u0010\nR\u001a\u0010v\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\b\"\u0004\bx\u0010\nR\u001a\u0010y\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\b\"\u0004\b{\u0010\nR\u001a\u0010|\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\b\"\u0004\b~\u0010\nR\u001c\u0010\u007f\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\b\"\u0005\b\u0081\u0001\u0010\nR\u001d\u0010\u0082\u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\b\"\u0005\b\u0084\u0001\u0010\nR\u001d\u0010\u0085\u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\b\"\u0005\b\u0087\u0001\u0010\nR\u001d\u0010\u0088\u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010\b\"\u0005\b\u008a\u0001\u0010\nR\u001d\u0010\u008b\u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010\b\"\u0005\b\u008d\u0001\u0010\nR\u001d\u0010\u008e\u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010\b\"\u0005\b\u0090\u0001\u0010\nR\u001d\u0010\u0091\u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\b\"\u0005\b\u0093\u0001\u0010\nR\u001d\u0010\u0094\u0001\u001a\u00020JX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010L\"\u0005\b\u0096\u0001\u0010NR\u001d\u0010\u0097\u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\b\"\u0005\b\u0099\u0001\u0010\nR\u001d\u0010\u009a\u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010\b\"\u0005\b\u009c\u0001\u0010\nR\u001d\u0010\u009d\u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010\b\"\u0005\b\u009f\u0001\u0010\nR\u001d\u0010 \u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u0010\b\"\u0005\b¢\u0001\u0010\nR\u001d\u0010£\u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010\b\"\u0005\b¥\u0001\u0010\n¨\u0006§\u0001"}, d2 = {"Lcom/bytedance/salamander/anniex/BidConfig;", "", "bid", "", "(Ljava/lang/String;)V", "ajax_web", "", "getAjax_web", "()Z", "setAjax_web", "(Z)V", "getBid", "()Ljava/lang/String;", "setBid", "blank_lynx", "getBlank_lynx", "setBlank_lynx", "blank_reactnative", "getBlank_reactnative", "setBlank_reactnative", "blank_web", "getBlank_web", "setBlank_web", "container_error", "getContainer_error", "setContainer_error", "custom_p0", "getCustom_p0", "setCustom_p0", "custom_p1", "getCustom_p1", "setCustom_p1", "custom_p2", "getCustom_p2", "setCustom_p2", "custom_p3", "getCustom_p3", "setCustom_p3", "custom_p4", "getCustom_p4", "setCustom_p4", "custom_p5", "getCustom_p5", "setCustom_p5", "custom_p6", "getCustom_p6", "setCustom_p6", "custom_p7", "getCustom_p7", "setCustom_p7", "custom_p8", "getCustom_p8", "setCustom_p8", "eventNameSample", "", "", "Lcom/bytedance/rts/foundation/RTSMap;", "getEventNameSample", "()Ljava/util/Map;", "setEventNameSample", "(Ljava/util/Map;)V", "falcon_perf_web", "getFalcon_perf_web", "setFalcon_perf_web", "fetch_error_lynx", "getFetch_error_lynx", "setFetch_error_lynx", "fetch_error_reactnative", "getFetch_error_reactnative", "setFetch_error_reactnative", "fetch_error_web", "getFetch_error_web", "setFetch_error_web", "hitSample", "", "getHitSample", "()J", "setHitSample", "(J)V", "js_exception_lynx", "getJs_exception_lynx", "setJs_exception_lynx", "js_exception_web", "getJs_exception_web", "setJs_exception_web", "jsb_error_lynx", "getJsb_error_lynx", "setJsb_error_lynx", "jsb_error_reactnative", "getJsb_error_reactnative", "setJsb_error_reactnative", "jsb_error_web", "getJsb_error_web", "setJsb_error_web", "jsb_perf_lynx", "getJsb_perf_lynx", "setJsb_perf_lynx", "jsb_perf_web", "getJsb_perf_web", "setJsb_perf_web", "native_error_lynx", "getNative_error_lynx", "setNative_error_lynx", "native_error_reactnative", "getNative_error_reactnative", "setNative_error_reactnative", "native_error_web", "getNative_error_web", "setNative_error_web", "navigation_start_lynx", "getNavigation_start_lynx", "setNavigation_start_lynx", "navigation_start_web", "getNavigation_start_web", "setNavigation_start_web", "perf_web", "getPerf_web", "setPerf_web", "performance_lynx", "getPerformance_lynx", "setPerformance_lynx", "performance_reactnative", "getPerformance_reactnative", "setPerformance_reactnative", "res_loader_error_lynx", "getRes_loader_error_lynx", "setRes_loader_error_lynx", "res_loader_error_template_lynx", "getRes_loader_error_template_lynx", "setRes_loader_error_template_lynx", "res_loader_error_template_web", "getRes_loader_error_template_web", "setRes_loader_error_template_web", "res_loader_error_web", "getRes_loader_error_web", "setRes_loader_error_web", "res_loader_perf_lynx", "getRes_loader_perf_lynx", "setRes_loader_perf_lynx", "res_loader_perf_template_lynx", "getRes_loader_perf_template_lynx", "setRes_loader_perf_template_lynx", "res_loader_perf_template_web", "getRes_loader_perf_template_web", "setRes_loader_perf_template_web", "res_loader_perf_web", "getRes_loader_perf_web", "setRes_loader_perf_web", "settingId", "getSettingId", "setSettingId", "static_error_lynx", "getStatic_error_lynx", "setStatic_error_lynx", "static_error_web", "getStatic_error_web", "setStatic_error_web", "static_perf_web", "getStatic_perf_web", "setStatic_perf_web", "static_sri_web", "getStatic_sri_web", "setStatic_sri_web", "tea_switch", "getTea_switch", "setTea_switch", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BidConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int NUM = 46;
    private boolean ajax_web;
    private String bid;
    private boolean blank_lynx;
    private boolean blank_reactnative;
    private boolean blank_web;
    private boolean container_error;
    private boolean custom_p0;
    private boolean custom_p1;
    private boolean custom_p2;
    private boolean custom_p3;
    private boolean custom_p4;
    private boolean custom_p5;
    private boolean custom_p6;
    private boolean custom_p7;
    private boolean custom_p8;
    private Map<String, Integer> eventNameSample;
    private boolean falcon_perf_web;
    private boolean fetch_error_lynx;
    private boolean fetch_error_reactnative;
    private boolean fetch_error_web;
    private long hitSample;
    private boolean js_exception_lynx;
    private boolean js_exception_web;
    private boolean jsb_error_lynx;
    private boolean jsb_error_reactnative;
    private boolean jsb_error_web;
    private boolean jsb_perf_lynx;
    private boolean jsb_perf_web;
    private boolean native_error_lynx;
    private boolean native_error_reactnative;
    private boolean native_error_web;
    private boolean navigation_start_lynx;
    private boolean navigation_start_web;
    private boolean perf_web;
    private boolean performance_lynx;
    private boolean performance_reactnative;
    private boolean res_loader_error_lynx;
    private boolean res_loader_error_template_lynx;
    private boolean res_loader_error_template_web;
    private boolean res_loader_error_web;
    private boolean res_loader_perf_lynx;
    private boolean res_loader_perf_template_lynx;
    private boolean res_loader_perf_template_web;
    private boolean res_loader_perf_web;
    private long settingId;
    private boolean static_error_lynx;
    private boolean static_error_web;
    private boolean static_perf_web;
    private boolean static_sri_web;
    private boolean tea_switch;

    public String getBid() {
        return this.bid;
    }

    public void setBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bid = str;
    }

    public long getHitSample() {
        return this.hitSample;
    }

    public void setHitSample(long j) {
        this.hitSample = j;
    }

    public long getSettingId() {
        return this.settingId;
    }

    public void setSettingId(long j) {
        this.settingId = j;
    }

    public Map<String, Integer> getEventNameSample() {
        return this.eventNameSample;
    }

    public void setEventNameSample(Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.eventNameSample = map;
    }

    public boolean getCustom_p0() {
        return this.custom_p0;
    }

    public void setCustom_p0(boolean z) {
        this.custom_p0 = z;
    }

    public boolean getCustom_p1() {
        return this.custom_p1;
    }

    public void setCustom_p1(boolean z) {
        this.custom_p1 = z;
    }

    public boolean getCustom_p2() {
        return this.custom_p2;
    }

    public void setCustom_p2(boolean z) {
        this.custom_p2 = z;
    }

    public boolean getCustom_p3() {
        return this.custom_p3;
    }

    public void setCustom_p3(boolean z) {
        this.custom_p3 = z;
    }

    public boolean getCustom_p4() {
        return this.custom_p4;
    }

    public void setCustom_p4(boolean z) {
        this.custom_p4 = z;
    }

    public boolean getCustom_p5() {
        return this.custom_p5;
    }

    public void setCustom_p5(boolean z) {
        this.custom_p5 = z;
    }

    public boolean getCustom_p6() {
        return this.custom_p6;
    }

    public void setCustom_p6(boolean z) {
        this.custom_p6 = z;
    }

    public boolean getCustom_p7() {
        return this.custom_p7;
    }

    public void setCustom_p7(boolean z) {
        this.custom_p7 = z;
    }

    public boolean getCustom_p8() {
        return this.custom_p8;
    }

    public void setCustom_p8(boolean z) {
        this.custom_p8 = z;
    }

    public boolean getPerf_web() {
        return this.perf_web;
    }

    public void setPerf_web(boolean z) {
        this.perf_web = z;
    }

    public boolean getAjax_web() {
        return this.ajax_web;
    }

    public void setAjax_web(boolean z) {
        this.ajax_web = z;
    }

    public boolean getStatic_perf_web() {
        return this.static_perf_web;
    }

    public void setStatic_perf_web(boolean z) {
        this.static_perf_web = z;
    }

    public boolean getStatic_error_web() {
        return this.static_error_web;
    }

    public void setStatic_error_web(boolean z) {
        this.static_error_web = z;
    }

    public boolean getJs_exception_web() {
        return this.js_exception_web;
    }

    public void setJs_exception_web(boolean z) {
        this.js_exception_web = z;
    }

    public boolean getBlank_web() {
        return this.blank_web;
    }

    public void setBlank_web(boolean z) {
        this.blank_web = z;
    }

    public boolean getFetch_error_web() {
        return this.fetch_error_web;
    }

    public void setFetch_error_web(boolean z) {
        this.fetch_error_web = z;
    }

    public boolean getJsb_error_web() {
        return this.jsb_error_web;
    }

    public void setJsb_error_web(boolean z) {
        this.jsb_error_web = z;
    }

    public boolean getJsb_perf_web() {
        return this.jsb_perf_web;
    }

    public void setJsb_perf_web(boolean z) {
        this.jsb_perf_web = z;
    }

    public boolean getFalcon_perf_web() {
        return this.falcon_perf_web;
    }

    public void setFalcon_perf_web(boolean z) {
        this.falcon_perf_web = z;
    }

    public boolean getNative_error_web() {
        return this.native_error_web;
    }

    public void setNative_error_web(boolean z) {
        this.native_error_web = z;
    }

    public boolean getNavigation_start_web() {
        return this.navigation_start_web;
    }

    public void setNavigation_start_web(boolean z) {
        this.navigation_start_web = z;
    }

    public boolean getStatic_sri_web() {
        return this.static_sri_web;
    }

    public void setStatic_sri_web(boolean z) {
        this.static_sri_web = z;
    }

    public boolean getPerformance_lynx() {
        return this.performance_lynx;
    }

    public void setPerformance_lynx(boolean z) {
        this.performance_lynx = z;
    }

    public boolean getBlank_lynx() {
        return this.blank_lynx;
    }

    public void setBlank_lynx(boolean z) {
        this.blank_lynx = z;
    }

    public boolean getFetch_error_lynx() {
        return this.fetch_error_lynx;
    }

    public void setFetch_error_lynx(boolean z) {
        this.fetch_error_lynx = z;
    }

    public boolean getJsb_error_lynx() {
        return this.jsb_error_lynx;
    }

    public void setJsb_error_lynx(boolean z) {
        this.jsb_error_lynx = z;
    }

    public boolean getJsb_perf_lynx() {
        return this.jsb_perf_lynx;
    }

    public void setJsb_perf_lynx(boolean z) {
        this.jsb_perf_lynx = z;
    }

    public boolean getNative_error_lynx() {
        return this.native_error_lynx;
    }

    public void setNative_error_lynx(boolean z) {
        this.native_error_lynx = z;
    }

    public boolean getNavigation_start_lynx() {
        return this.navigation_start_lynx;
    }

    public void setNavigation_start_lynx(boolean z) {
        this.navigation_start_lynx = z;
    }

    public boolean getPerformance_reactnative() {
        return this.performance_reactnative;
    }

    public void setPerformance_reactnative(boolean z) {
        this.performance_reactnative = z;
    }

    public boolean getBlank_reactnative() {
        return this.blank_reactnative;
    }

    public void setBlank_reactnative(boolean z) {
        this.blank_reactnative = z;
    }

    public boolean getFetch_error_reactnative() {
        return this.fetch_error_reactnative;
    }

    public void setFetch_error_reactnative(boolean z) {
        this.fetch_error_reactnative = z;
    }

    public boolean getJsb_error_reactnative() {
        return this.jsb_error_reactnative;
    }

    public void setJsb_error_reactnative(boolean z) {
        this.jsb_error_reactnative = z;
    }

    public boolean getNative_error_reactnative() {
        return this.native_error_reactnative;
    }

    public void setNative_error_reactnative(boolean z) {
        this.native_error_reactnative = z;
    }

    public boolean getContainer_error() {
        return this.container_error;
    }

    public void setContainer_error(boolean z) {
        this.container_error = z;
    }

    public boolean getJs_exception_lynx() {
        return this.js_exception_lynx;
    }

    public void setJs_exception_lynx(boolean z) {
        this.js_exception_lynx = z;
    }

    public boolean getStatic_error_lynx() {
        return this.static_error_lynx;
    }

    public void setStatic_error_lynx(boolean z) {
        this.static_error_lynx = z;
    }

    public boolean getTea_switch() {
        return this.tea_switch;
    }

    public void setTea_switch(boolean z) {
        this.tea_switch = z;
    }

    public boolean getRes_loader_perf_web() {
        return this.res_loader_perf_web;
    }

    public void setRes_loader_perf_web(boolean z) {
        this.res_loader_perf_web = z;
    }

    public boolean getRes_loader_error_web() {
        return this.res_loader_error_web;
    }

    public void setRes_loader_error_web(boolean z) {
        this.res_loader_error_web = z;
    }

    public boolean getRes_loader_perf_template_web() {
        return this.res_loader_perf_template_web;
    }

    public void setRes_loader_perf_template_web(boolean z) {
        this.res_loader_perf_template_web = z;
    }

    public boolean getRes_loader_error_template_web() {
        return this.res_loader_error_template_web;
    }

    public void setRes_loader_error_template_web(boolean z) {
        this.res_loader_error_template_web = z;
    }

    public boolean getRes_loader_perf_lynx() {
        return this.res_loader_perf_lynx;
    }

    public void setRes_loader_perf_lynx(boolean z) {
        this.res_loader_perf_lynx = z;
    }

    public boolean getRes_loader_error_lynx() {
        return this.res_loader_error_lynx;
    }

    public void setRes_loader_error_lynx(boolean z) {
        this.res_loader_error_lynx = z;
    }

    public boolean getRes_loader_perf_template_lynx() {
        return this.res_loader_perf_template_lynx;
    }

    public void setRes_loader_perf_template_lynx(boolean z) {
        this.res_loader_perf_template_lynx = z;
    }

    public boolean getRes_loader_error_template_lynx() {
        return this.res_loader_error_template_lynx;
    }

    public void setRes_loader_error_template_lynx(boolean z) {
        this.res_loader_error_template_lynx = z;
    }

    public BidConfig(String str) {
        Intrinsics.checkNotNullParameter(str, "bid");
        this.bid = BidInfo.INSTANCE.getDEFAULT();
        this.eventNameSample = RTSMapKt.RTSMap();
        if (Intrinsics.areEqual(str, "")) {
            return;
        }
        setBid(str);
    }

    /* compiled from: AnniexMonitorSettingsHybridSettingsResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/salamander/anniex/BidConfig$Companion;", "", "()V", "NUM", "", "getNUM", "()I", "setNUM", "(I)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public int getNUM() {
            return BidConfig.NUM;
        }

        public void setNUM(int i) {
            BidConfig.NUM = i;
        }
    }
}
