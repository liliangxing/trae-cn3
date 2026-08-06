package com.bytedance.timon.clipboard.suite.report;

import com.bytedance.bpea.basics.Cert;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.timon.clipboard.suite.TimonClipboardSuite;
import com.bytedance.timon.clipboard.suite.checker.CheckResult;
import com.bytedance.timon.clipboard.suite.checker.CheckResultKt;
import com.bytedance.timon.clipboard.suite.config.CertConfigManager;
import com.bytedance.timon.clipboard.suite.report.ReportHelper;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TimonConstantKt;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.timonbase.report.TMDataCollector;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.timonbase.scene.ScenesDetector;
import com.bytedance.timonbase.utils.ProcessUtil;
import com.bytedance.timonbase.utils.TMThreadUtils;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedance.tracing.log.Fields;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ReportHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002()B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002JT\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000e28\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014H\u0002JT\u0010\u0019\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u001228\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014H\u0002J&\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001c0\u001b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u001d\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020%J\u0011\u0010&\u001a\u00020\u0004*\u00020%H\u0000¢\u0006\u0002\b'R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/report/ReportHelper;", "", "()V", "EFFECTIVE_READ_EVENT_NAME", "", "EFFECTIVE_READ_FIELD_RESULT", "EFFECTIVE_READ_FIELD_TOKEN", "TIMON_PRIVACY_ACTION_DATA_LOG", "TIMON_READ_PASTEBOARD_EVENT", "TM_CLIPBOARD_SUIT_REPORT_HELPER", "buildBpeaInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "cert", "Lcom/bytedance/bpea/basics/Cert;", "buildPrivacyAPIReportInfo", "Lorg/json/JSONObject;", "context", "Lcom/bytedance/timon/clipboard/suite/report/ReportHelper$ReportContext;", "multiThreadStack", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "className", "methodName", "buildPrivacyInfo", "buildStrategies", "Lkotlin/Pair;", "Lorg/json/JSONArray;", "buildStrategiesInput", "buildStrategiesOutput", "buildStrategiesUsedStateParams", "report", "", "reportEffectiveRead", "token", "isEffect", "", "toStr", "toStr$clipboard_suite_release", "Event", "ReportContext", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ReportHelper {
    private static final String EFFECTIVE_READ_EVENT_NAME = "timon_effective_read_pasteboard_feedback";
    private static final String EFFECTIVE_READ_FIELD_RESULT = "is_effective_read";
    private static final String EFFECTIVE_READ_FIELD_TOKEN = "bpea_cert_token";
    public static final ReportHelper INSTANCE = new ReportHelper();
    private static final String TIMON_PRIVACY_ACTION_DATA_LOG = "timon_privacy_action_data_log";
    private static final String TIMON_READ_PASTEBOARD_EVENT = "timon_read_pasteboard_event";
    private static final String TM_CLIPBOARD_SUIT_REPORT_HELPER = "tm_clipboard_suit_report_helper";

    public final String toStr$clipboard_suite_release(boolean z) {
        return z ? "1" : "0";
    }

    private ReportHelper() {
    }

    /* compiled from: ReportHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\ba\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010 J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0006HÆ\u0003J\t\u0010b\u001a\u00020\u000fHÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010h\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010ZJ\t\u0010i\u001a\u00020\u0003HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\t\u0010n\u001a\u00020\u0003HÆ\u0003J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\u0010\u0010p\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0002\u0010IJ\u000b\u0010q\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010r\u001a\u00020\u0006HÆ\u0003J\t\u0010s\u001a\u00020\u0006HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010u\u001a\u00020\u0006HÆ\u0003J\t\u0010v\u001a\u00020\u0006HÆ\u0003J\t\u0010w\u001a\u00020\u0006HÆ\u0003J\t\u0010x\u001a\u00020\u0006HÆ\u0003J\u009e\u0002\u0010y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010zJ\u0013\u0010{\u001a\u00020\u001e2\b\u0010|\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010}\u001a\u00020\u0003HÖ\u0001J\t\u0010~\u001a\u00020\u0006HÖ\u0001R \u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\"\"\u0004\b/\u0010$R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R\u001e\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\"\"\u0004\b4\u0010$R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b\u0018\u0010&\"\u0004\b5\u0010(R \u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\"\"\u0004\b7\u0010$R\u001e\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\"\"\u0004\b9\u0010$R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\"\"\u0004\b;\u0010$R\u001e\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\"\"\u0004\b=\u0010$R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\"\"\u0004\b?\u0010$R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b@\u0010&\"\u0004\bA\u0010(R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010\u001b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010+\"\u0004\bG\u0010-R\"\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\bM\u0010&\"\u0004\bN\u0010(R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\bO\u0010&\"\u0004\bP\u0010(R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\"\"\u0004\bR\u0010$R\u001e\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010+\"\u0004\bT\u0010-R\u001e\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010+\"\u0004\bV\u0010-R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\bW\u0010&\"\u0004\bX\u0010(R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001e\u0010\u001c\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010+\"\u0004\b_\u0010-¨\u0006\u007f"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/report/ReportHelper$Event;", "", "error_code", "", "fastPass", "pasteboardName", "", "ruleAction", "patternsScore", "eventUuid", "pasteboardApi", "hasReadContent", "isCache", "patterns", "readDuration", "", "repeatRead", "repeatWrite", "bpeaCertToken", "read", "write", "writeTimestamp", "", "suite", "is_initiative_read", "cache_is_valid", "unit_disable", "read_permission", "write_permission", "read_timestamp_verify_intercept", "", "mimeType", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;ILjava/lang/Integer;Ljava/lang/Integer;IIILjava/lang/Boolean;Ljava/lang/String;)V", "getBpeaCertToken", "()Ljava/lang/String;", "setBpeaCertToken", "(Ljava/lang/String;)V", "getCache_is_valid", "()Ljava/lang/Integer;", "setCache_is_valid", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getError_code", "()I", "setError_code", "(I)V", "getEventUuid", "setEventUuid", "getFastPass", "setFastPass", "getHasReadContent", "setHasReadContent", "setCache", "set_initiative_read", "getMimeType", "setMimeType", "getPasteboardApi", "setPasteboardApi", "getPasteboardName", "setPasteboardName", "getPatterns", "setPatterns", "getPatternsScore", "setPatternsScore", "getRead", "setRead", "getReadDuration", "()F", "setReadDuration", "(F)V", "getRead_permission", "setRead_permission", "getRead_timestamp_verify_intercept", "()Ljava/lang/Boolean;", "setRead_timestamp_verify_intercept", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRepeatRead", "setRepeatRead", "getRepeatWrite", "setRepeatWrite", "getRuleAction", "setRuleAction", "getSuite", "setSuite", "getUnit_disable", "setUnit_disable", "getWrite", "setWrite", "getWriteTimestamp", "()Ljava/lang/Long;", "setWriteTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getWrite_permission", "setWrite_permission", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;ILjava/lang/Integer;Ljava/lang/Integer;IIILjava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/timon/clipboard/suite/report/ReportHelper$Event;", "equals", "other", "hashCode", "toString", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Event {

        @SerializedName(ReportHelper.EFFECTIVE_READ_FIELD_TOKEN)
        private String bpeaCertToken;

        @SerializedName("timon_pasteboard_same_as_cache")
        private Integer cache_is_valid;

        @SerializedName("timon_pasteboard_error_code")
        private int error_code;

        @SerializedName("timon_event_uuid")
        private String eventUuid;

        @SerializedName("timon_pasteboard_fast_pass")
        private int fastPass;

        @SerializedName("timon_pasteboard_has_read_content")
        private String hasReadContent;

        @SerializedName("timon_pasteboard_is_cache")
        private String isCache;

        @SerializedName("is_initiative_read")
        private Integer is_initiative_read;

        @SerializedName("timon_pasteboard_mimetype")
        private String mimeType;

        @SerializedName("timon_pasteboard_api")
        private String pasteboardApi;

        @SerializedName("timon_pasteboard_name")
        private String pasteboardName;

        @SerializedName("timon_pasteboard_patterns")
        private String patterns;

        @SerializedName("timon_pasteboard_patterns_score")
        private String patternsScore;

        @SerializedName("pasteboard_read")
        private Integer read;

        @SerializedName("timon_pasteboard_read_duration")
        private float readDuration;

        @SerializedName("timon_pasteboard_read_permission")
        private int read_permission;

        @SerializedName("read_timestamp_verify_intercept")
        private Boolean read_timestamp_verify_intercept;

        @SerializedName("pasteboard_repeat_read")
        private Integer repeatRead;

        @SerializedName("pasteboard_repeat_write")
        private Integer repeatWrite;

        @SerializedName("timon_rule_action")
        private String ruleAction;

        @SerializedName("call_from_pasteboard_suite")
        private int suite;

        @SerializedName("timon_pasteboard_unit_disable")
        private int unit_disable;

        @SerializedName("pasteboard_write")
        private Integer write;

        @SerializedName("pasteboard_write_timestamp")
        private Long writeTimestamp;

        @SerializedName("timon_pasteboard_write_permission")
        private int write_permission;

        public Event() {
            this(0, 0, null, null, null, null, null, null, null, null, 0.0f, null, null, null, null, null, null, 0, null, null, 0, 0, 0, null, null, 33554431, null);
        }

        /* renamed from: component1, reason: from getter */
        public final int getError_code() {
            return this.error_code;
        }

        /* renamed from: component10, reason: from getter */
        public final String getPatterns() {
            return this.patterns;
        }

        /* renamed from: component11, reason: from getter */
        public final float getReadDuration() {
            return this.readDuration;
        }

        /* renamed from: component12, reason: from getter */
        public final Integer getRepeatRead() {
            return this.repeatRead;
        }

        /* renamed from: component13, reason: from getter */
        public final Integer getRepeatWrite() {
            return this.repeatWrite;
        }

        /* renamed from: component14, reason: from getter */
        public final String getBpeaCertToken() {
            return this.bpeaCertToken;
        }

        /* renamed from: component15, reason: from getter */
        public final Integer getRead() {
            return this.read;
        }

        /* renamed from: component16, reason: from getter */
        public final Integer getWrite() {
            return this.write;
        }

        /* renamed from: component17, reason: from getter */
        public final Long getWriteTimestamp() {
            return this.writeTimestamp;
        }

        /* renamed from: component18, reason: from getter */
        public final int getSuite() {
            return this.suite;
        }

        /* renamed from: component19, reason: from getter */
        public final Integer getIs_initiative_read() {
            return this.is_initiative_read;
        }

        /* renamed from: component2, reason: from getter */
        public final int getFastPass() {
            return this.fastPass;
        }

        /* renamed from: component20, reason: from getter */
        public final Integer getCache_is_valid() {
            return this.cache_is_valid;
        }

        /* renamed from: component21, reason: from getter */
        public final int getUnit_disable() {
            return this.unit_disable;
        }

        /* renamed from: component22, reason: from getter */
        public final int getRead_permission() {
            return this.read_permission;
        }

        /* renamed from: component23, reason: from getter */
        public final int getWrite_permission() {
            return this.write_permission;
        }

        /* renamed from: component24, reason: from getter */
        public final Boolean getRead_timestamp_verify_intercept() {
            return this.read_timestamp_verify_intercept;
        }

        /* renamed from: component25, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPasteboardName() {
            return this.pasteboardName;
        }

        /* renamed from: component4, reason: from getter */
        public final String getRuleAction() {
            return this.ruleAction;
        }

        /* renamed from: component5, reason: from getter */
        public final String getPatternsScore() {
            return this.patternsScore;
        }

        /* renamed from: component6, reason: from getter */
        public final String getEventUuid() {
            return this.eventUuid;
        }

        /* renamed from: component7, reason: from getter */
        public final String getPasteboardApi() {
            return this.pasteboardApi;
        }

        /* renamed from: component8, reason: from getter */
        public final String getHasReadContent() {
            return this.hasReadContent;
        }

        /* renamed from: component9, reason: from getter */
        public final String getIsCache() {
            return this.isCache;
        }

        public final Event copy(int error_code, int fastPass, String pasteboardName, String ruleAction, String patternsScore, String eventUuid, String pasteboardApi, String hasReadContent, String isCache, String patterns, float readDuration, Integer repeatRead, Integer repeatWrite, String bpeaCertToken, Integer read, Integer write, Long writeTimestamp, int suite, Integer is_initiative_read, Integer cache_is_valid, int unit_disable, int read_permission, int write_permission, Boolean read_timestamp_verify_intercept, String mimeType) {
            Intrinsics.checkParameterIsNotNull(pasteboardName, "pasteboardName");
            Intrinsics.checkParameterIsNotNull(ruleAction, "ruleAction");
            Intrinsics.checkParameterIsNotNull(eventUuid, "eventUuid");
            Intrinsics.checkParameterIsNotNull(pasteboardApi, "pasteboardApi");
            Intrinsics.checkParameterIsNotNull(hasReadContent, "hasReadContent");
            Intrinsics.checkParameterIsNotNull(isCache, "isCache");
            Intrinsics.checkParameterIsNotNull(patterns, "patterns");
            return new Event(error_code, fastPass, pasteboardName, ruleAction, patternsScore, eventUuid, pasteboardApi, hasReadContent, isCache, patterns, readDuration, repeatRead, repeatWrite, bpeaCertToken, read, write, writeTimestamp, suite, is_initiative_read, cache_is_valid, unit_disable, read_permission, write_permission, read_timestamp_verify_intercept, mimeType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Event)) {
                return false;
            }
            Event event = (Event) other;
            return this.error_code == event.error_code && this.fastPass == event.fastPass && Intrinsics.areEqual(this.pasteboardName, event.pasteboardName) && Intrinsics.areEqual(this.ruleAction, event.ruleAction) && Intrinsics.areEqual(this.patternsScore, event.patternsScore) && Intrinsics.areEqual(this.eventUuid, event.eventUuid) && Intrinsics.areEqual(this.pasteboardApi, event.pasteboardApi) && Intrinsics.areEqual(this.hasReadContent, event.hasReadContent) && Intrinsics.areEqual(this.isCache, event.isCache) && Intrinsics.areEqual(this.patterns, event.patterns) && Float.compare(this.readDuration, event.readDuration) == 0 && Intrinsics.areEqual(this.repeatRead, event.repeatRead) && Intrinsics.areEqual(this.repeatWrite, event.repeatWrite) && Intrinsics.areEqual(this.bpeaCertToken, event.bpeaCertToken) && Intrinsics.areEqual(this.read, event.read) && Intrinsics.areEqual(this.write, event.write) && Intrinsics.areEqual(this.writeTimestamp, event.writeTimestamp) && this.suite == event.suite && Intrinsics.areEqual(this.is_initiative_read, event.is_initiative_read) && Intrinsics.areEqual(this.cache_is_valid, event.cache_is_valid) && this.unit_disable == event.unit_disable && this.read_permission == event.read_permission && this.write_permission == event.write_permission && Intrinsics.areEqual(this.read_timestamp_verify_intercept, event.read_timestamp_verify_intercept) && Intrinsics.areEqual(this.mimeType, event.mimeType);
        }

        public int hashCode() {
            int hashCode = ((Integer.hashCode(this.error_code) * 31) + Integer.hashCode(this.fastPass)) * 31;
            String str = this.pasteboardName;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.ruleAction;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.patternsScore;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.eventUuid;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.pasteboardApi;
            int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.hasReadContent;
            int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.isCache;
            int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.patterns;
            int hashCode9 = (((hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31) + Float.hashCode(this.readDuration)) * 31;
            Integer num = this.repeatRead;
            int hashCode10 = (hashCode9 + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.repeatWrite;
            int hashCode11 = (hashCode10 + (num2 != null ? num2.hashCode() : 0)) * 31;
            String str9 = this.bpeaCertToken;
            int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
            Integer num3 = this.read;
            int hashCode13 = (hashCode12 + (num3 != null ? num3.hashCode() : 0)) * 31;
            Integer num4 = this.write;
            int hashCode14 = (hashCode13 + (num4 != null ? num4.hashCode() : 0)) * 31;
            Long l = this.writeTimestamp;
            int hashCode15 = (((hashCode14 + (l != null ? l.hashCode() : 0)) * 31) + Integer.hashCode(this.suite)) * 31;
            Integer num5 = this.is_initiative_read;
            int hashCode16 = (hashCode15 + (num5 != null ? num5.hashCode() : 0)) * 31;
            Integer num6 = this.cache_is_valid;
            int hashCode17 = (((((((hashCode16 + (num6 != null ? num6.hashCode() : 0)) * 31) + Integer.hashCode(this.unit_disable)) * 31) + Integer.hashCode(this.read_permission)) * 31) + Integer.hashCode(this.write_permission)) * 31;
            Boolean bool = this.read_timestamp_verify_intercept;
            int hashCode18 = (hashCode17 + (bool != null ? bool.hashCode() : 0)) * 31;
            String str10 = this.mimeType;
            return hashCode18 + (str10 != null ? str10.hashCode() : 0);
        }

        public String toString() {
            return "Event(error_code=" + this.error_code + ", fastPass=" + this.fastPass + ", pasteboardName=" + this.pasteboardName + ", ruleAction=" + this.ruleAction + ", patternsScore=" + this.patternsScore + ", eventUuid=" + this.eventUuid + ", pasteboardApi=" + this.pasteboardApi + ", hasReadContent=" + this.hasReadContent + ", isCache=" + this.isCache + ", patterns=" + this.patterns + ", readDuration=" + this.readDuration + ", repeatRead=" + this.repeatRead + ", repeatWrite=" + this.repeatWrite + ", bpeaCertToken=" + this.bpeaCertToken + ", read=" + this.read + ", write=" + this.write + ", writeTimestamp=" + this.writeTimestamp + ", suite=" + this.suite + ", is_initiative_read=" + this.is_initiative_read + ", cache_is_valid=" + this.cache_is_valid + ", unit_disable=" + this.unit_disable + ", read_permission=" + this.read_permission + ", write_permission=" + this.write_permission + ", read_timestamp_verify_intercept=" + this.read_timestamp_verify_intercept + ", mimeType=" + this.mimeType + ")";
        }

        public Event(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, float f, Integer num, Integer num2, String str9, Integer num3, Integer num4, Long l, int i3, Integer num5, Integer num6, int i4, int i5, int i6, Boolean bool, String str10) {
            Intrinsics.checkParameterIsNotNull(str, "pasteboardName");
            Intrinsics.checkParameterIsNotNull(str2, "ruleAction");
            Intrinsics.checkParameterIsNotNull(str4, "eventUuid");
            Intrinsics.checkParameterIsNotNull(str5, "pasteboardApi");
            Intrinsics.checkParameterIsNotNull(str6, "hasReadContent");
            Intrinsics.checkParameterIsNotNull(str7, "isCache");
            Intrinsics.checkParameterIsNotNull(str8, "patterns");
            this.error_code = i;
            this.fastPass = i2;
            this.pasteboardName = str;
            this.ruleAction = str2;
            this.patternsScore = str3;
            this.eventUuid = str4;
            this.pasteboardApi = str5;
            this.hasReadContent = str6;
            this.isCache = str7;
            this.patterns = str8;
            this.readDuration = f;
            this.repeatRead = num;
            this.repeatWrite = num2;
            this.bpeaCertToken = str9;
            this.read = num3;
            this.write = num4;
            this.writeTimestamp = l;
            this.suite = i3;
            this.is_initiative_read = num5;
            this.cache_is_valid = num6;
            this.unit_disable = i4;
            this.read_permission = i5;
            this.write_permission = i6;
            this.read_timestamp_verify_intercept = bool;
            this.mimeType = str10;
        }

        public final int getError_code() {
            return this.error_code;
        }

        public final void setError_code(int i) {
            this.error_code = i;
        }

        public final int getFastPass() {
            return this.fastPass;
        }

        public final void setFastPass(int i) {
            this.fastPass = i;
        }

        public final String getPasteboardName() {
            return this.pasteboardName;
        }

        public final void setPasteboardName(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.pasteboardName = str;
        }

        public final String getRuleAction() {
            return this.ruleAction;
        }

        public final void setRuleAction(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.ruleAction = str;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Event(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, float f, Integer num, Integer num2, String str9, Integer num3, Integer num4, Long l, int i3, Integer num5, Integer num6, int i4, int i5, int i6, Boolean bool, String str10, int i7, DefaultConstructorMarker defaultConstructorMarker) {
            this(r1, r3, r4, r6, r7, r9, r10, r11, r12, r5, r13, r14, r15, r16, r2, r17, r18, r19, r20, r21, r22, r23, r24, r25, r8);
            String str11;
            Integer num7;
            Integer num8;
            String str12;
            Integer num9;
            Integer num10;
            Long l2;
            Integer num11;
            Integer num12;
            Boolean bool2;
            int i8 = (i7 & 1) != 0 ? 0 : i;
            int i9 = (i7 & 2) != 0 ? 0 : i2;
            String str13 = (i7 & 4) != 0 ? "" : str;
            String str14 = (i7 & 8) != 0 ? "" : str2;
            String str15 = null;
            if ((i7 & 16) != 0) {
                str11 = null;
            } else {
                str11 = str3;
            }
            String str16 = (i7 & 32) != 0 ? "" : str4;
            String str17 = (i7 & 64) != 0 ? "" : str5;
            String str18 = (i7 & 128) != 0 ? "0" : str6;
            String str19 = (i7 & StatusBarUtils.FLAG_NOTCH_SUPPORT) == 0 ? str7 : "0";
            String str20 = (i7 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) == 0 ? str8 : "";
            float f2 = (i7 & 1024) != 0 ? 0.0f : f;
            if ((i7 & 2048) != 0) {
                num7 = null;
            } else {
                num7 = num;
            }
            if ((i7 & 4096) != 0) {
                num8 = null;
            } else {
                num8 = num2;
            }
            if ((i7 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0) {
                str12 = null;
            } else {
                str12 = str9;
            }
            String str21 = str12;
            if ((i7 & 16384) != 0) {
                num9 = null;
            } else {
                num9 = num3;
            }
            if ((i7 & 32768) != 0) {
                num10 = null;
            } else {
                num10 = num4;
            }
            if ((i7 & 65536) != 0) {
                l2 = null;
            } else {
                l2 = l;
            }
            int i10 = (i7 & 131072) != 0 ? 1 : i3;
            if ((i7 & 262144) != 0) {
                num11 = null;
            } else {
                num11 = num5;
            }
            if ((i7 & FConstants.SLICE_SIZE) != 0) {
                num12 = null;
            } else {
                num12 = num6;
            }
            int i11 = (i7 & 1048576) != 0 ? 0 : i4;
            int i12 = (i7 & 2097152) != 0 ? -1 : i5;
            int i13 = (i7 & 4194304) == 0 ? i6 : -1;
            if ((i7 & 8388608) != 0) {
                bool2 = null;
            } else {
                bool2 = bool;
            }
            if ((i7 & 16777216) != 0) {
            } else {
                str15 = str10;
            }
        }

        public final String getPatternsScore() {
            return this.patternsScore;
        }

        public final void setPatternsScore(String str) {
            this.patternsScore = str;
        }

        public final String getEventUuid() {
            return this.eventUuid;
        }

        public final void setEventUuid(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.eventUuid = str;
        }

        public final String getPasteboardApi() {
            return this.pasteboardApi;
        }

        public final void setPasteboardApi(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.pasteboardApi = str;
        }

        public final String getHasReadContent() {
            return this.hasReadContent;
        }

        public final void setHasReadContent(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.hasReadContent = str;
        }

        public final String isCache() {
            return this.isCache;
        }

        public final void setCache(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.isCache = str;
        }

        public final String getPatterns() {
            return this.patterns;
        }

        public final void setPatterns(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.patterns = str;
        }

        public final float getReadDuration() {
            return this.readDuration;
        }

        public final void setReadDuration(float f) {
            this.readDuration = f;
        }

        public final Integer getRepeatRead() {
            return this.repeatRead;
        }

        public final void setRepeatRead(Integer num) {
            this.repeatRead = num;
        }

        public final Integer getRepeatWrite() {
            return this.repeatWrite;
        }

        public final void setRepeatWrite(Integer num) {
            this.repeatWrite = num;
        }

        public final String getBpeaCertToken() {
            return this.bpeaCertToken;
        }

        public final void setBpeaCertToken(String str) {
            this.bpeaCertToken = str;
        }

        public final Integer getRead() {
            return this.read;
        }

        public final void setRead(Integer num) {
            this.read = num;
        }

        public final Integer getWrite() {
            return this.write;
        }

        public final void setWrite(Integer num) {
            this.write = num;
        }

        public final Long getWriteTimestamp() {
            return this.writeTimestamp;
        }

        public final void setWriteTimestamp(Long l) {
            this.writeTimestamp = l;
        }

        public final int getSuite() {
            return this.suite;
        }

        public final void setSuite(int i) {
            this.suite = i;
        }

        public final Integer is_initiative_read() {
            return this.is_initiative_read;
        }

        public final void set_initiative_read(Integer num) {
            this.is_initiative_read = num;
        }

        public final Integer getCache_is_valid() {
            return this.cache_is_valid;
        }

        public final void setCache_is_valid(Integer num) {
            this.cache_is_valid = num;
        }

        public final int getUnit_disable() {
            return this.unit_disable;
        }

        public final void setUnit_disable(int i) {
            this.unit_disable = i;
        }

        public final int getRead_permission() {
            return this.read_permission;
        }

        public final void setRead_permission(int i) {
            this.read_permission = i;
        }

        public final int getWrite_permission() {
            return this.write_permission;
        }

        public final void setWrite_permission(int i) {
            this.write_permission = i;
        }

        public final Boolean getRead_timestamp_verify_intercept() {
            return this.read_timestamp_verify_intercept;
        }

        public final void setRead_timestamp_verify_intercept(Boolean bool) {
            this.read_timestamp_verify_intercept = bool;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public final void setMimeType(String str) {
            this.mimeType = str;
        }
    }

    /* compiled from: ReportHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u001d\u00107\u001a\u00020\u00052\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;H\u0002¢\u0006\u0002\u0010=R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010$\"\u0004\b/\u00100R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010$¨\u0006>"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/report/ReportHelper$ReportContext;", "", "startTime", "", "threadName", "", "process", "className", "id", "invokeTime", "methodName", "cert", "Lcom/bytedance/bpea/basics/Cert;", "apiId", "", "pageInfo", "", "Lcom/bytedance/timonbase/scene/PageDataManager$PageRecord;", "read", "", "enter_background_duration", "cold_launch_duration", "checkResult", "Lcom/bytedance/timon/clipboard/suite/checker/CheckResult;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/bytedance/bpea/basics/Cert;ILjava/util/List;ZJJLcom/bytedance/timon/clipboard/suite/checker/CheckResult;)V", "getApiId", "()I", "getCert", "()Lcom/bytedance/bpea/basics/Cert;", "setCert", "(Lcom/bytedance/bpea/basics/Cert;)V", "getCheckResult", "()Lcom/bytedance/timon/clipboard/suite/checker/CheckResult;", "setCheckResult", "(Lcom/bytedance/timon/clipboard/suite/checker/CheckResult;)V", "getClassName", "()Ljava/lang/String;", "getCold_launch_duration", "()J", "getEnter_background_duration", Fields.EVENT, "Lcom/bytedance/timon/clipboard/suite/report/ReportHelper$Event;", "getEvent", "()Lcom/bytedance/timon/clipboard/suite/report/ReportHelper$Event;", "getId", "getInvokeTime", "getMethodName", "setMethodName", "(Ljava/lang/String;)V", "getPageInfo", "()Ljava/util/List;", "getProcess", "getRead", "()Z", Fields.STACK, "getStack", "getStartTime", "getThreadName", "stackTrace", "", "Ljava/lang/StackTraceElement;", "([Ljava/lang/StackTraceElement;)Ljava/lang/String;", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ReportContext {
        private final int apiId;
        private Cert cert;
        private CheckResult checkResult;
        private final String className;
        private final long cold_launch_duration;
        private final long enter_background_duration;
        private final Event event;
        private final String id;
        private final long invokeTime;
        private String methodName;
        private final List<PageDataManager.PageRecord> pageInfo;
        private final String process;
        private final boolean read;
        private final String stack;
        private final long startTime;
        private final String threadName;

        public ReportContext(long j, String str, String str2, String str3, String str4, long j2, String str5, Cert cert, int i, List<PageDataManager.PageRecord> list, boolean z, long j3, long j4, CheckResult checkResult) {
            Intrinsics.checkParameterIsNotNull(str, "threadName");
            Intrinsics.checkParameterIsNotNull(str3, "className");
            Intrinsics.checkParameterIsNotNull(str4, "id");
            Intrinsics.checkParameterIsNotNull(str5, "methodName");
            Intrinsics.checkParameterIsNotNull(list, "pageInfo");
            this.startTime = j;
            this.threadName = str;
            this.process = str2;
            this.className = str3;
            this.id = str4;
            this.invokeTime = j2;
            this.methodName = str5;
            this.cert = cert;
            this.apiId = i;
            this.pageInfo = list;
            this.read = z;
            this.enter_background_duration = j3;
            this.cold_launch_duration = j4;
            this.checkResult = checkResult;
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            this.stack = getStack(currentThread.getStackTrace());
            Integer valueOf = Integer.valueOf(!z ? 1 : 0);
            this.event = new Event(0, 0, this.methodName, null, null, str4, String.valueOf(i), null, null, null, 0.0f, null, null, null, Integer.valueOf(z ? 1 : 0), valueOf, null, 1, null, null, 0, 0, 0, null, null, 33374107, null);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ ReportContext(long j, String str, String str2, String str3, String str4, long j2, String str5, Cert cert, int i, List list, boolean z, long j3, long j4, CheckResult checkResult, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(r4, r6, r7, r8, r9, r10, r12, cert, r14, r15, r16, r17, r19, r21);
            String str6;
            String str7;
            CheckResult checkResult2;
            long currentTimeMillis = (i2 & 1) != 0 ? System.currentTimeMillis() : j;
            if ((i2 & 2) != 0) {
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                String name = currentThread.getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "Thread.currentThread().name");
                str6 = name;
            } else {
                str6 = str;
            }
            String currentProcessName = (i2 & 4) != 0 ? ProcessUtil.INSTANCE.getCurrentProcessName(TMEnv.INSTANCE.getApplication()) : str2;
            String str8 = (i2 & 8) != 0 ? "android/content/ClipboardManager" : str3;
            if ((i2 & 16) != 0) {
                String uuid = UUID.randomUUID().toString();
                Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
                str7 = uuid;
            } else {
                str7 = str4;
            }
            long currentTimeMillis2 = (i2 & 32) != 0 ? System.currentTimeMillis() : j2;
            String str9 = (i2 & 64) != 0 ? "" : str5;
            int i3 = (i2 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? 0 : i;
            List historyPage = (i2 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? PageDataManager.INSTANCE.get().getHistoryPage() : list;
            boolean z2 = (i2 & 1024) != 0 ? true : z;
            long enterBackgroundDuration = (i2 & 2048) != 0 ? ScenesDetector.INSTANCE.enterBackgroundDuration() : j3;
            long coldLaunchDuration = (i2 & 4096) != 0 ? ScenesDetector.INSTANCE.coldLaunchDuration() : j4;
            if ((i2 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0) {
                checkResult2 = null;
            } else {
                checkResult2 = checkResult;
            }
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final String getThreadName() {
            return this.threadName;
        }

        public final String getProcess() {
            return this.process;
        }

        public final String getClassName() {
            return this.className;
        }

        public final String getId() {
            return this.id;
        }

        public final long getInvokeTime() {
            return this.invokeTime;
        }

        public final String getMethodName() {
            return this.methodName;
        }

        public final void setMethodName(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.methodName = str;
        }

        public final Cert getCert() {
            return this.cert;
        }

        public final void setCert(Cert cert) {
            this.cert = cert;
        }

        public final int getApiId() {
            return this.apiId;
        }

        public final List<PageDataManager.PageRecord> getPageInfo() {
            return this.pageInfo;
        }

        public final boolean getRead() {
            return this.read;
        }

        public final long getEnter_background_duration() {
            return this.enter_background_duration;
        }

        public final long getCold_launch_duration() {
            return this.cold_launch_duration;
        }

        public final CheckResult getCheckResult() {
            return this.checkResult;
        }

        public final void setCheckResult(CheckResult checkResult) {
            this.checkResult = checkResult;
        }

        public final String getStack() {
            return this.stack;
        }

        public final Event getEvent() {
            return this.event;
        }

        private final String getStack(StackTraceElement[] stackTrace) {
            StringBuilder sb = new StringBuilder();
            if (stackTrace != null) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement.toString()).append('\n');
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
            return sb2;
        }
    }

    public final void report(final ReportContext context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context.getEvent().setReadDuration((float) (System.currentTimeMillis() - context.getStartTime()));
        TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timon.clipboard.suite.report.ReportHelper$report$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1039invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1039invoke() {
                String str;
                JSONObject buildPrivacyAPIReportInfo;
                try {
                    Cert cert = ReportHelper.ReportContext.this.getCert();
                    ReportHelper.ReportContext.this.getEvent().setBpeaCertToken(cert != null ? cert.certToken() : null);
                    ReportHelper.Event event = ReportHelper.ReportContext.this.getEvent();
                    CertConfigManager certConfigManager = CertConfigManager.INSTANCE;
                    if (cert == null || (str = cert.certToken()) == null) {
                        str = "";
                    }
                    event.setUnit_disable(certConfigManager.getUnitDisable(str));
                    TMDataCollector.reportAppLog$default(TMDataCollector.INSTANCE, "timon_read_pasteboard_event", new JSONObject(new Gson().toJson(ReportHelper.ReportContext.this.getEvent())), true, null, 8, null);
                    buildPrivacyAPIReportInfo = ReportHelper.INSTANCE.buildPrivacyAPIReportInfo(ReportHelper.ReportContext.this, cert, TimonClipboardSuite.INSTANCE.getMultiStack());
                    TMDataCollector.reportAppLog$default(TMDataCollector.INSTANCE, "timon_privacy_action_data_log", buildPrivacyAPIReportInfo, true, null, 8, null);
                } catch (Exception e) {
                    TMDataCollector.reportException$default(TMDataCollector.INSTANCE, "tm_clipboard_suit_report_helper", e, "建勤上报异常", MapsKt.emptyMap(), false, 16, null);
                }
            }
        });
    }

    public static /* synthetic */ void reportEffectiveRead$default(ReportHelper reportHelper, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        reportHelper.reportEffectiveRead(str, z);
    }

    public final void reportEffectiveRead(String token, boolean isEffect) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(EFFECTIVE_READ_FIELD_RESULT, isEffect);
        jSONObject.put(EFFECTIVE_READ_FIELD_TOKEN, token);
        TMDataCollector.reportAppLog$default(TMDataCollector.INSTANCE, EFFECTIVE_READ_EVENT_NAME, jSONObject, false, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject buildPrivacyAPIReportInfo(ReportContext context, Cert cert, Function2<? super String, ? super String, String> multiThreadStack) {
        JSONObject buildPrivacyInfo = buildPrivacyInfo(cert, context, multiThreadStack);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event_type", "privacy_api_call");
        jSONObject.put("id", context.getId());
        jSONObject.put("client_invoke_time", context.getInvokeTime());
        jSONObject.put("privacy_api_call_data", buildPrivacyInfo.toString());
        jSONObject.put("privacy_api_call_id", context.getApiId());
        return jSONObject;
    }

    private final JSONObject buildPrivacyInfo(Cert cert, ReportContext context, Function2<? super String, ? super String, String> multiThreadStack) {
        Pair<JSONObject, JSONArray> buildStrategies = buildStrategies(cert, context);
        JSONObject jSONObject = (JSONObject) buildStrategies.component1();
        JSONArray jSONArray = (JSONArray) buildStrategies.component2();
        HashMap<String, Object> buildBpeaInfo = buildBpeaInfo(cert);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("class_name", context.getClassName());
        jSONObject2.put("method_name", context.getMethodName());
        jSONObject2.put("api_id", context.getApiId());
        boolean z = true;
        jSONObject2.put("is_valid", jSONArray.length() > 0);
        jSONObject2.put("is_downgrade", context.getEvent().getError_code() != 0 || Intrinsics.areEqual(context.getEvent().isCache(), "1"));
        jSONObject2.put("page_info", new JSONArray(new Gson().toJson(context.getPageInfo())));
        jSONObject2.put("event_thread", context.getThreadName());
        jSONObject2.put("event_process", context.getProcess());
        String str = (String) multiThreadStack.invoke(context.getClassName(), context.getMethodName());
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (z) {
            jSONObject2.put(Fields.STACK, context.getStack());
        } else {
            jSONObject2.put("full_stack", str);
        }
        jSONObject2.put("permission_status", -1);
        jSONObject2.put("permission_type", "[]");
        jSONObject2.put("strategies", new JSONArray().put(jSONObject));
        jSONObject2.put("bpea_info", new JSONObject(new Gson().toJson(buildBpeaInfo)));
        jSONObject2.put("strategy_md5", "clipboard_suit_strategy");
        return jSONObject2;
    }

    private final HashMap<String, Object> buildBpeaInfo(Cert cert) {
        HashMap<String, Object> hashMap = new HashMap<>();
        HashMap<String, Object> hashMap2 = hashMap;
        hashMap2.put("cert_token", cert != null ? cert.certToken() : null);
        hashMap2.put("entry_token", TimonConstantKt.TIMON_CLIPBOARD_SUITE);
        hashMap2.put("customInfo", cert != null ? cert.customInfo() : null);
        hashMap2.put("enable_pipeline", TMEnv.INSTANCE.getEnablePipeline() ? "1" : "0");
        return hashMap;
    }

    private final Pair<JSONObject, JSONArray> buildStrategies(Cert cert, ReportContext context) {
        JSONObject jSONObject = new JSONObject();
        JSONObject buildStrategiesInput = buildStrategiesInput(cert, context);
        JSONObject buildStrategiesUsedStateParams = buildStrategiesUsedStateParams(context);
        Pair<JSONObject, JSONArray> buildStrategiesOutput = buildStrategiesOutput(context);
        JSONObject jSONObject2 = (JSONObject) buildStrategiesOutput.component1();
        JSONArray jSONArray = (JSONArray) buildStrategiesOutput.component2();
        jSONObject.put("output", jSONObject2);
        jSONObject.put("input", buildStrategiesInput);
        jSONObject.put("used_state_params", buildStrategiesUsedStateParams);
        return new Pair<>(jSONObject, jSONArray);
    }

    private final JSONObject buildStrategiesUsedStateParams(ReportContext context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enter_background_duration", context.getEnter_background_duration());
        jSONObject.put("cold_launch_duration", context.getCold_launch_duration());
        return jSONObject;
    }

    private final Pair<JSONObject, JSONArray> buildStrategiesOutput(ReportContext context) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("PRIMARY_CLIP_READ_Collection");
        JSONArray jSONArray2 = new JSONArray();
        if (context.getEvent().getError_code() != 0) {
            JSONObject jSONObject = new JSONObject();
            if (context.getEvent().getError_code() == -6011) {
                CheckResult checkResult = context.getCheckResult();
                jSONObject.put("key", checkResult != null ? checkResult.getMessage() : null);
            } else {
                jSONObject.put("key", CheckResultKt.getERROR_CODE_TO_RULE_KEY().get(Integer.valueOf(context.getEvent().getError_code())));
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", "fuse");
            jSONObject.put("config", jSONObject2);
            jSONArray2.put(jSONObject);
        } else if (Intrinsics.areEqual(context.getEvent().isCache(), "1")) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("key", context.getRead() ? "pasteboard_repeat_read" : "pasteboard_repeat_write");
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("action", "cache");
            jSONObject3.put("config", jSONObject4);
            jSONArray2.put(jSONObject3);
        }
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("scene", "fuse");
        jSONObject5.put("code", 0);
        jSONObject5.put("strategies", jSONArray);
        jSONObject5.put(TracingConstants.KEY_HIT_RULES, jSONArray2);
        return new Pair<>(jSONObject5, jSONArray2);
    }

    private final JSONObject buildStrategiesInput(Cert cert, ReportContext context) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clipboard");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cert_token", cert != null ? cert.certToken() : null);
        jSONObject.put(TimonPipeline.KEY_SOURCE, "api_control_fuse");
        jSONObject.put("api_id", context.getApiId());
        jSONObject.put("permission_type", "Clipboard");
        jSONObject.put("data_types", jSONArray);
        jSONObject.put("is_pair_not_close", false);
        jSONObject.put("is_pair_delay_close", false);
        return jSONObject;
    }
}
