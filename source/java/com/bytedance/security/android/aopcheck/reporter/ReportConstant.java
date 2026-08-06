package com.bytedance.security.android.aopcheck.reporter;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import kotlin.Metadata;

/* compiled from: ReportConstant.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/security/android/aopcheck/reporter/ReportConstant;", "", "()V", PrefetchRequestConfig.ENV_TYPE_AID, "", "AOP_REPORT_INIT_DURATION", "AOP_REPORT_PATH_TRAVERSAL", "COMMON_ACTION_CONTENT", "COMMON_ACTION_TYPE", "COMMON_BACKTRACE", "COMMON_CONTENT", "COMMON_INIT_DURATION", "COMMON_SCENE", "COMMON_TIMESTAMP", "DEFAULT_URL_REPORT", "DEFAULT_URL_RULES", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class ReportConstant {
    public static final String AID = "333807";
    public static final String AOP_REPORT_INIT_DURATION = "aop_report_init_duration";
    public static final String AOP_REPORT_PATH_TRAVERSAL = "path_traversal_call";
    public static final String COMMON_ACTION_CONTENT = "actionContent";
    public static final String COMMON_ACTION_TYPE = "actionType";
    public static final String COMMON_BACKTRACE = "backtrace";
    public static final String COMMON_CONTENT = "content";
    public static final String COMMON_INIT_DURATION = "duration";
    public static final String COMMON_SCENE = "scene";
    public static final String COMMON_TIMESTAMP = "timestamp";
    public static final String DEFAULT_URL_REPORT = "https://mon.snssdk.com/monitor/collect/";
    public static final String DEFAULT_URL_RULES = "https://mon.snssdk.com/monitor/appmonitor/v3/settings";
    public static final ReportConstant INSTANCE = new ReportConstant();

    private ReportConstant() {
    }
}
