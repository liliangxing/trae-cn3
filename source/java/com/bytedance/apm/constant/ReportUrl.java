package com.bytedance.apm.constant;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ReportUrl {
    public static final String DEFAULT_EXCEPTION_UPLOAD_URL = "https://mon.zijieapi.com/monitor/collect/c/exception";
    public static final String DEFAULT_FILE_UPLOAD_URL = "https://mon.zijieapi.com/monitor/collect/c/logcollect";
    public static final List<String> EXCEPTION_UPLOAD_URL_LIST;
    public static final List<String> FETCH_SETTING_LIST;
    public static final String MAINLAND_EXCEPTION_DOMAIN_HTTPS = "https://mon.zijieapi.com";
    public static final String MAINLAND_NORMAL_DOMAIN_HTTPS = "https://mon.zijieapi.com";
    public static final String MAINLAND_REPORT_DOMAIN1_HTTPS = "https://mon.toutiao.com";
    public static final String MAINLAND_SETTING_DOMAIN1_HTTPS = "https://monsetting.toutiao.com";
    public static final List<String> REPORT_TRACING_URL_LIST;
    public static final List<String> REPORT_URL_LIST;

    static {
        ArrayList arrayList = new ArrayList();
        FETCH_SETTING_LIST = arrayList;
        arrayList.add("https://mon.zijieapi.com/monitor/appmonitor/v5/batch_settings");
        arrayList.add("https://monsetting.toutiao.com/monitor/appmonitor/v5/batch_settings");
        ArrayList arrayList2 = new ArrayList();
        REPORT_URL_LIST = arrayList2;
        arrayList2.add("https://mon.zijieapi.com/monitor/collect/batch/");
        arrayList2.add("https://mon.toutiao.com/monitor/collect/batch/");
        ArrayList arrayList3 = new ArrayList();
        REPORT_TRACING_URL_LIST = arrayList3;
        arrayList3.add("https://mon.zijieapi.com/monitor/collect/c/trace_collect");
        ArrayList arrayList4 = new ArrayList();
        EXCEPTION_UPLOAD_URL_LIST = arrayList4;
        arrayList4.add(DEFAULT_EXCEPTION_UPLOAD_URL);
        arrayList4.add(DEFAULT_EXCEPTION_UPLOAD_URL);
    }
}
