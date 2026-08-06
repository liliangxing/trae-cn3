package com.bytedance.android.monitorV2.hybridSetting.entity;

import com.bytedance.android.monitorV2.logger.MonitorLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class BidInfo {
    public static String DEFAULT = "__hybrid_default";
    private static final String TAG = "BidInfo";
    public Map<String, BidConfig> bidInfoMap = new HashMap();
    public List<BidRegex> regexList = new ArrayList();

    public BidConfig get(String str) {
        if (this.bidInfoMap.containsKey(str)) {
            return this.bidInfoMap.get(str);
        }
        if (this.bidInfoMap.containsKey(DEFAULT)) {
            MonitorLog.i(TAG, "Not found bidConfig for " + str + ", use " + DEFAULT);
            return this.bidInfoMap.get(DEFAULT);
        }
        MonitorLog.i(TAG, "Not found bidConfig for " + str + ", use " + DEFAULT);
        return new BidConfig(DEFAULT);
    }

    public Map<String, Integer> getEventNameSample(String str) {
        return get(str).eventNameSample;
    }

    public List<BidRegex> getRegexList() {
        return this.regexList;
    }

    public String toString() {
        return "BidInfo{bidInfoMap=" + this.bidInfoMap + ", regexList=" + this.regexList + AbstractJsonLexerKt.END_OBJ;
    }

    /* loaded from: classes3.dex */
    public static class BidConfig {
        public static final int NUM = 46;
        public boolean ajax_web;
        public String bid;
        public boolean blank_lynx;
        public boolean blank_reactnative;
        public boolean blank_web;
        public boolean container_error;
        public boolean custom_p0;
        public boolean custom_p1;
        public boolean custom_p2;
        public boolean custom_p3;
        public boolean custom_p4;
        public boolean custom_p5;
        public boolean custom_p6;
        public boolean custom_p7;
        public boolean custom_p8;
        public Map<String, Integer> eventNameSample;
        public boolean falcon_perf_web;
        public boolean fetch_error_lynx;
        public boolean fetch_error_reactnative;
        public boolean fetch_error_web;
        public long hitSample;
        public boolean js_exception_lynx;
        public boolean js_exception_web;
        public boolean jsb_error_lynx;
        public boolean jsb_error_reactnative;
        public boolean jsb_error_web;
        public boolean jsb_perf_lynx;
        public boolean jsb_perf_web;
        public boolean native_error_lynx;
        public boolean native_error_reactnative;
        public boolean native_error_web;
        public boolean navigation_start_lynx;
        public boolean navigation_start_web;
        public boolean perf_web;
        public boolean performance_lynx;
        public boolean performance_reactnative;
        public boolean res_loader_error_lynx;
        public boolean res_loader_error_template_lynx;
        public boolean res_loader_error_template_web;
        public boolean res_loader_error_web;
        public boolean res_loader_perf_lynx;
        public boolean res_loader_perf_template_lynx;
        public boolean res_loader_perf_template_web;
        public boolean res_loader_perf_web;
        public long settingId;
        public boolean static_error_lynx;
        public boolean static_error_web;
        public boolean static_perf_web;
        public boolean static_sri_web;
        public boolean tea_switch;

        public BidConfig() {
            this.bid = BidInfo.DEFAULT;
            this.hitSample = 0L;
            this.settingId = 0L;
            this.eventNameSample = new HashMap();
            this.custom_p0 = false;
            this.custom_p1 = false;
            this.custom_p2 = false;
            this.custom_p3 = false;
            this.custom_p4 = false;
            this.custom_p5 = false;
            this.custom_p6 = false;
            this.custom_p7 = false;
            this.custom_p8 = false;
            this.perf_web = false;
            this.ajax_web = false;
            this.static_perf_web = false;
            this.static_error_web = false;
            this.js_exception_web = false;
            this.blank_web = false;
            this.fetch_error_web = false;
            this.jsb_error_web = false;
            this.jsb_perf_web = false;
            this.falcon_perf_web = false;
            this.native_error_web = false;
            this.navigation_start_web = false;
            this.static_sri_web = false;
            this.performance_lynx = false;
            this.blank_lynx = false;
            this.fetch_error_lynx = false;
            this.jsb_error_lynx = false;
            this.jsb_perf_lynx = false;
            this.native_error_lynx = false;
            this.navigation_start_lynx = false;
            this.performance_reactnative = false;
            this.blank_reactnative = false;
            this.fetch_error_reactnative = false;
            this.jsb_error_reactnative = false;
            this.native_error_reactnative = false;
            this.container_error = false;
            this.js_exception_lynx = false;
            this.static_error_lynx = false;
            this.tea_switch = false;
            this.res_loader_perf_web = false;
            this.res_loader_error_web = false;
            this.res_loader_perf_template_web = false;
            this.res_loader_error_template_web = false;
            this.res_loader_perf_lynx = false;
            this.res_loader_error_lynx = false;
            this.res_loader_perf_template_lynx = false;
            this.res_loader_error_template_lynx = false;
        }

        public BidConfig(String str) {
            this.bid = BidInfo.DEFAULT;
            this.hitSample = 0L;
            this.settingId = 0L;
            this.eventNameSample = new HashMap();
            this.custom_p0 = false;
            this.custom_p1 = false;
            this.custom_p2 = false;
            this.custom_p3 = false;
            this.custom_p4 = false;
            this.custom_p5 = false;
            this.custom_p6 = false;
            this.custom_p7 = false;
            this.custom_p8 = false;
            this.perf_web = false;
            this.ajax_web = false;
            this.static_perf_web = false;
            this.static_error_web = false;
            this.js_exception_web = false;
            this.blank_web = false;
            this.fetch_error_web = false;
            this.jsb_error_web = false;
            this.jsb_perf_web = false;
            this.falcon_perf_web = false;
            this.native_error_web = false;
            this.navigation_start_web = false;
            this.static_sri_web = false;
            this.performance_lynx = false;
            this.blank_lynx = false;
            this.fetch_error_lynx = false;
            this.jsb_error_lynx = false;
            this.jsb_perf_lynx = false;
            this.native_error_lynx = false;
            this.navigation_start_lynx = false;
            this.performance_reactnative = false;
            this.blank_reactnative = false;
            this.fetch_error_reactnative = false;
            this.jsb_error_reactnative = false;
            this.native_error_reactnative = false;
            this.container_error = false;
            this.js_exception_lynx = false;
            this.static_error_lynx = false;
            this.tea_switch = false;
            this.res_loader_perf_web = false;
            this.res_loader_error_web = false;
            this.res_loader_perf_template_web = false;
            this.res_loader_error_template_web = false;
            this.res_loader_perf_lynx = false;
            this.res_loader_error_lynx = false;
            this.res_loader_perf_template_lynx = false;
            this.res_loader_error_template_lynx = false;
            if (str.isEmpty()) {
                return;
            }
            this.bid = str;
        }

        public String toString() {
            return "BidConfig{, hitSample=" + this.hitSample + ", settingId=" + this.settingId + ", custom_p0=" + this.custom_p0 + ", custom_p1=" + this.custom_p1 + ", custom_p2=" + this.custom_p2 + ", custom_p3=" + this.custom_p3 + ", custom_p4=" + this.custom_p4 + ", custom_p5=" + this.custom_p5 + ", custom_p6=" + this.custom_p6 + ", custom_p7=" + this.custom_p7 + ", custom_p8=" + this.custom_p8 + ", perf_web=" + this.perf_web + ", ajax_web=" + this.ajax_web + ", static_perf_web=" + this.static_perf_web + ", static_error_web=" + this.static_error_web + ", js_exception_web=" + this.js_exception_web + ", blank_web=" + this.blank_web + ", fetch_error_web=" + this.fetch_error_web + ", jsb_error_web=" + this.jsb_error_web + ", jsb_perf_web=" + this.jsb_perf_web + ", falcon_perf_web=" + this.falcon_perf_web + ", native_error_web=" + this.native_error_web + ", navigation_start_web=" + this.navigation_start_web + ", performance_lynx=" + this.performance_lynx + ", blank_lynx=" + this.blank_lynx + ", fetch_error_lynx=" + this.fetch_error_lynx + ", jsb_error_lynx=" + this.jsb_error_lynx + ", jsb_perf_lynx=" + this.jsb_perf_lynx + ", native_error_lynx=" + this.native_error_lynx + ", navigation_start_lynx=" + this.navigation_start_lynx + ", performance_reactnative=" + this.performance_reactnative + ", blank_reactnative=" + this.blank_reactnative + ", fetch_error_reactnative=" + this.fetch_error_reactnative + ", jsb_error_reactnative=" + this.jsb_error_reactnative + ", native_error_reactnative=" + this.native_error_reactnative + ", container_error=" + this.container_error + ", js_exception_lynx=" + this.js_exception_lynx + ", static_error_lynx=" + this.static_error_lynx + ", tea_switch=" + this.tea_switch + ", res_loader_perf_web=" + this.res_loader_perf_web + ", res_loader_error_web=" + this.res_loader_error_web + ", res_loader_perf_template_web=" + this.res_loader_perf_template_web + ", res_loader_error_template_web=" + this.res_loader_error_template_web + ", res_loader_perf_lynx=" + this.res_loader_perf_lynx + ", res_loader_error_lynx=" + this.res_loader_error_lynx + ", res_loader_perf_template_lynx=" + this.res_loader_perf_template_lynx + ", res_loader_error_template_lynx=" + this.res_loader_error_template_lynx + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
