package com.bytedance.timon.clipboard.suite;

import android.app.AppOpsManager;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Parcel;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.sdk.account.platform.api.IAppAuthService;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sync.SyncConstants;
import com.bytedance.timon.clipboard.suite.cert.EmptyCert;
import com.bytedance.timon.clipboard.suite.checker.CertChecker;
import com.bytedance.timon.clipboard.suite.checker.CheckResult;
import com.bytedance.timon.clipboard.suite.checker.CheckResultKt;
import com.bytedance.timon.clipboard.suite.checker.ReadFastPassChecker;
import com.bytedance.timon.clipboard.suite.checker.RuleChecker;
import com.bytedance.timon.clipboard.suite.checker.WriteFastPassChecker;
import com.bytedance.timon.clipboard.suite.config.CertConfigManager;
import com.bytedance.timon.clipboard.suite.config.TokenConfig;
import com.bytedance.timon.clipboard.suite.constans.ClipboardSuiteConstants;
import com.bytedance.timon.clipboard.suite.report.ReportHelper;
import com.bytedance.timon.clipboard.suite.storage.ClipboardSuiteStorageHelper;
import com.bytedance.timon.foundation.interfaces.TimonBackgroundReferee;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.scene.ScenesDetector;
import com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache;
import com.bytedance.timonbase.sensitive.detect.cacher.SensitiveCachedContent;
import com.bytedance.timonbase.sensitive.detect.cacher.TMSensitiveContentCacheManager;
import com.bytedance.tracing.log.Fields;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: TimonClipboardSuite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010)\u001a\u0004\u0018\u00010\u00102\u0006\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.H\u0002J\u001a\u0010/\u001a\u0002002\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010*\u001a\u00020\u001aH\u0002J\b\u00101\u001a\u000200H\u0002J\u0018\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0007H\u0002J\u0012\u00106\u001a\u0002002\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J7\u00107\u001a\u0002002\b\u00108\u001a\u0004\u0018\u00010,2%\b\u0002\u00109\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(;\u0012\u0004\u0012\u000200\u0018\u00010:J\u0014\u0010<\u001a\u0002002\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010>\u001a\u00020\u001aH\u0002J\u0012\u0010?\u001a\u0004\u0018\u00010\u00152\u0006\u0010@\u001a\u00020\u0007H\u0002J\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J8\u0010B\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b((\u0012\u0006\u0012\u0004\u0018\u00010\u00070$J9\u0010C\u001a\u0004\u0018\u00010\u00102\b\u0010+\u001a\u0004\u0018\u00010,2%\b\u0002\u0010D\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(;\u0012\u0004\u0012\u000200\u0018\u00010:JK\u0010C\u001a\u0004\u0018\u00010\u00102\b\u00108\u001a\u0004\u0018\u00010,2%\b\u0002\u0010D\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(;\u0012\u0004\u0012\u000200\u0018\u00010:2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0007H\u0002J9\u0010G\u001a\u0004\u0018\u00010\u00152\b\u00108\u001a\u0004\u0018\u00010,2%\b\u0002\u0010D\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(;\u0012\u0004\u0012\u000200\u0018\u00010:J\n\u0010H\u001a\u0004\u0018\u00010\u0015H\u0002J9\u0010I\u001a\u0004\u0018\u00010J2\b\u0010+\u001a\u0004\u0018\u00010,2%\b\u0002\u00109\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(;\u0012\u0004\u0012\u000200\u0018\u00010:J\u0017\u0010K\u001a\u0004\u0018\u00010L2\b\b\u0002\u0010@\u001a\u00020\u0007¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020\u001aH\u0002J\u0016\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00150PH\u0002J\u000e\u0010\u001d\u001a\u0002002\u0006\u0010Q\u001a\u00020\u000eJ\b\u0010R\u001a\u000200H\u0002J@\u0010S\u001a\u00020028\u0010#\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b((\u0012\u0006\u0012\u0004\u0018\u00010\u00070$J?\u0010T\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2#\u0010D\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(;\u0012\u0004\u0012\u000200\u0018\u00010:H\u0002J?\u0010U\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2#\u0010D\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(;\u0012\u0004\u0012\u000200\u0018\u00010:H\u0002J5\u0010V\u001a\u0002002#\u0010W\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(;\u0012\u0004\u0012\u000200\u0018\u00010:2\u0006\u0010X\u001a\u00020\u0007H\u0002J\b\u0010Y\u001a\u00020\u001aH\u0002JO\u0010Z\u001a\u0002002\u0006\u0010-\u001a\u00020.2#\u0010D\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(;\u0012\u0004\u0012\u000200\u0018\u00010:2\u0006\u0010[\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010;\u001a\u00020\u0004H\u0002J\b\u0010\\\u001a\u00020\u001aH\u0002J\u0018\u0010]\u001a\u0002002\u0010\u0010\u0018\u001a\f\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001bJ\u001a\u0010^\u001a\u0002002\u0012\u0010_\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010`0\u0019j\u0002`aJ\u001a\u0010b\u001a\u0002002\u0012\u0010_\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010`0\u0019j\u0002`aJ\u0018\u0010c\u001a\u0002002\u0006\u0010d\u001a\u00020\u00072\b\b\u0002\u0010e\u001a\u00020\u001aJ\u000e\u0010f\u001a\u0002002\u0006\u0010d\u001a\u00020\u0007J?\u0010g\u001a\u0002002\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010h\u001a\u00020\u00102%\b\u0002\u00109\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(;\u0012\u0004\u0012\u000200\u0018\u00010:JQ\u0010g\u001a\u0002002\b\u00108\u001a\u0004\u0018\u00010,2\u0006\u0010h\u001a\u00020\u00102%\b\u0002\u00109\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(;\u0012\u0004\u0012\u000200\u0018\u00010:2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0007H\u0002J?\u0010i\u001a\u0002002\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010j\u001a\u00020J2%\b\u0002\u00109\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(;\u0012\u0004\u0012\u000200\u0018\u00010:J\u0010\u0010k\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0002J\u0016\u0010l\u001a\u00020\u001a*\u00020m2\b\u0010n\u001a\u0004\u0018\u00010mH\u0002J\f\u0010o\u001a\u000200*\u00020\u0017H\u0007J\f\u0010p\u001a\u0004\u0018\u00010\u0010*\u00020\u0017J\n\u0010q\u001a\u00020\u001a*\u00020\u0017J\u0012\u0010r\u001a\u000200*\u00020\u00172\u0006\u0010h\u001a\u00020\u0010J\u0016\u0010s\u001a\u00020\u001a*\u00020\u00102\b\u0010n\u001a\u0004\u0018\u00010\u0010H\u0002J\u0016\u0010s\u001a\u00020\u001a*\u00020m2\b\u0010n\u001a\u0004\u0018\u00010mH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\u0004\u0018\u0001`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010#\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b((\u0012\u0006\u0012\u0004\u0018\u00010\u00070$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/TimonClipboardSuite;", "", "()V", "BACKGROUND", "", "EXCEPT_PATTERNS", "", "", "FOREGROUND", "IDLE", "OPSTR_READ_CLIPBOARD", "OPSTR_WRITE_CLIPBOARD", "TAG", "application", "Landroid/app/Application;", "value", "Landroid/content/ClipData;", "cachedClipData", "setCachedClipData", "(Landroid/content/ClipData;)V", "cachedClipDescription", "Landroid/content/ClipDescription;", "clipboardManager", "Landroid/content/ClipboardManager;", "clipboardToggleReferee", "Lkotlin/Function0;", "", "Lcom/bytedance/timonbase/scene/AutoReadClipboardToggleReferee;", "currentAppState", "init", "getInit", "()Z", "isFromBackToFront", "lastMatchedPattern", "lastSetClipData", "multiThreadStack", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "className", "methodName", "cacheAndCallGetClipPrimary", "userActiveRead", "cert", "Lcom/bytedance/bpea/basics/Cert;", "reportContext", "Lcom/bytedance/timon/clipboard/suite/report/ReportHelper$ReportContext;", "cacheClipboardDataToSensitiveCache", "", "checkCacheIsInvalid", "checkPermissionByAppOps", "context", "Landroid/content/Context;", "opPermission", "checkSetCacheIsInvalid", "clearPrimaryClip", "cert_", "errorCallback", "Lkotlin/Function1;", "reason", "clearReadCache", "newestDescription", "enableAutoReadClipboard", "getDescription", "certToken", "getMatchedPatterns", "getMultiStack", "getPrimaryClip", "readCallback", "apiId", "entryToken", "getPrimaryClipDescription", "getSystemDescription", "getText", "", "getWriteTimestamp", "", "(Ljava/lang/String;)Ljava/lang/Long;", "hasPrimaryClip", "hasPrimaryClipChangedWithNewestDescription", "Lkotlin/Pair;", "app", "initClipboardManager", "injectMultiStack", "interceptByMimeType", "interceptByPattern", "invokeCallback", "callback", "message", "isFromViewAutoPaste", "mimeTypeIntercept", "mimeType", "readCacheIsEmpty", "registerClipboardToggleReferee", "registerConfigProvider", "configProvider", "Lcom/google/gson/JsonObject;", "Lcom/bytedance/timon/clipboard/suite/config/CertConfigProvider;", "registerDefaultConfigProvider", "reportEffectiveRead", "token", "isEffect", "savePrimaryClipReadTimestamp", "setPrimaryClip", "clipData", "setText", "text", "verifyLastWrittenTimestamp", "checkItemIntentIsSame", "Landroid/content/ClipData$Item;", "other", "safeClearPrimaryClip", "safeGetPrimaryClip", "safeHasPrimaryClip", "safeSetPrimaryClip", "same", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TimonClipboardSuite {
    private static final int BACKGROUND = 2;
    private static final int FOREGROUND = 1;
    private static final int IDLE = 0;
    public static final String OPSTR_READ_CLIPBOARD = "android:read_clipboard";
    public static final String OPSTR_WRITE_CLIPBOARD = "android:write_clipboard";
    public static final String TAG = "ClipboardSuite";
    private static Application application;
    private static ClipData cachedClipData;
    private static ClipDescription cachedClipDescription;
    private static volatile ClipboardManager clipboardManager;
    private static Function0<Boolean> clipboardToggleReferee;
    private static int currentAppState;
    private static boolean isFromBackToFront;
    private static ClipData lastSetClipData;
    public static final TimonClipboardSuite INSTANCE = new TimonClipboardSuite();
    private static final List<String> EXCEPT_PATTERNS = CollectionsKt.listOf(new String[]{"email", "phone", IAppAuthService.Scope.ADDRESS, IWeixinService.ResponseConstants.URL, "date", "datetime", "flight"});
    private static List<String> lastMatchedPattern = CollectionsKt.emptyList();
    private static Function2<? super String, ? super String, String> multiThreadStack = new Function2() { // from class: com.bytedance.timon.clipboard.suite.TimonClipboardSuite$multiThreadStack$1
        public final Void invoke(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, "<anonymous parameter 0>");
            Intrinsics.checkParameterIsNotNull(str2, "<anonymous parameter 1>");
            return null;
        }
    };

    private TimonClipboardSuite() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCachedClipData(ClipData clipData) {
        cachedClipDescription = clipData != null ? clipData.getDescription() : null;
        cachedClipData = clipData;
    }

    public final boolean getInit() {
        return application != null;
    }

    public final void init(Application app) {
        Intrinsics.checkParameterIsNotNull(app, "app");
        if (getInit()) {
            return;
        }
        application = app;
        CertConfigManager.INSTANCE.init();
        ScenesDetector.INSTANCE.pureInit(app);
        TimonBackgroundReferee appBackgroundReferee = ScenesDetector.INSTANCE.getAppBackgroundReferee();
        if (appBackgroundReferee != null) {
            appBackgroundReferee.addStatusChangeListener(new Function1<Boolean, Unit>() { // from class: com.bytedance.timon.clipboard.suite.TimonClipboardSuite$init$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
                
                    if (r0 == 1) goto L12;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(boolean z) {
                    int i;
                    int i2;
                    TimonClipboardSuite timonClipboardSuite = TimonClipboardSuite.INSTANCE;
                    i = TimonClipboardSuite.currentAppState;
                    TimonClipboardSuite timonClipboardSuite2 = TimonClipboardSuite.INSTANCE;
                    boolean z2 = true;
                    TimonClipboardSuite.currentAppState = z ? 2 : 1;
                    TimonClipboardSuite timonClipboardSuite3 = TimonClipboardSuite.INSTANCE;
                    if (i == 2) {
                        TimonClipboardSuite timonClipboardSuite4 = TimonClipboardSuite.INSTANCE;
                        i2 = TimonClipboardSuite.currentAppState;
                    }
                    z2 = false;
                    TimonClipboardSuite.isFromBackToFront = z2;
                }
            });
        }
    }

    public final void injectMultiStack(Function2<? super String, ? super String, String> multiThreadStack2) {
        Intrinsics.checkParameterIsNotNull(multiThreadStack2, "multiThreadStack");
        multiThreadStack = multiThreadStack2;
    }

    public final Function2<String, String, String> getMultiStack() {
        return multiThreadStack;
    }

    private final void initClipboardManager() {
        if (clipboardManager != null) {
            return;
        }
        synchronized (this) {
            if (clipboardManager != null) {
                return;
            }
            if (((ITMClipboardSuiteInitService) ServiceManager.get().getService(ITMClipboardSuiteInitService.class)).makeSureSuiteInit()) {
                Object obj = null;
                try {
                    Application application2 = application;
                    Object systemService = application2 != null ? application2.getSystemService("clipboard") : null;
                    if (!(systemService instanceof ClipboardManager)) {
                        systemService = null;
                    }
                    clipboardManager = (ClipboardManager) systemService;
                } catch (Exception unused) {
                    if (Looper.myLooper() == null) {
                        Looper.prepare();
                        Application application3 = application;
                        Object systemService2 = application3 != null ? application3.getSystemService("clipboard") : null;
                        if (systemService2 instanceof ClipboardManager) {
                            obj = systemService2;
                        }
                        clipboardManager = (ClipboardManager) obj;
                    }
                }
                try {
                    ClipboardManager clipboardManager2 = clipboardManager;
                    if (clipboardManager2 != null) {
                        clipboardManager2.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() { // from class: com.bytedance.timon.clipboard.suite.TimonClipboardSuite$initClipboardManager$1$1
                            @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
                            public final void onPrimaryClipChanged() {
                                boolean readCacheIsEmpty;
                                boolean readCacheIsEmpty2;
                                ClipDescription systemDescription;
                                ClipData clipData;
                                readCacheIsEmpty = TimonClipboardSuite.INSTANCE.readCacheIsEmpty();
                                if (!readCacheIsEmpty) {
                                    if (Build.VERSION.SDK_INT >= 26) {
                                        systemDescription = TimonClipboardSuite.INSTANCE.getSystemDescription();
                                        TimonClipboardSuite timonClipboardSuite = TimonClipboardSuite.INSTANCE;
                                        clipData = TimonClipboardSuite.cachedClipData;
                                        if (!Intrinsics.areEqual(systemDescription != null ? Long.valueOf(systemDescription.getTimestamp()) : null, (clipData != null ? clipData.getDescription() : null) != null ? Long.valueOf(r1.getTimestamp()) : null)) {
                                            TimonClipboardSuite.clearReadCache$default(TimonClipboardSuite.INSTANCE, null, 1, null);
                                        }
                                    } else {
                                        TimonClipboardSuite.clearReadCache$default(TimonClipboardSuite.INSTANCE, null, 1, null);
                                    }
                                }
                                TMLogger tMLogger = TMLogger.INSTANCE;
                                StringBuilder sb = new StringBuilder("cache isCleared=");
                                readCacheIsEmpty2 = TimonClipboardSuite.INSTANCE.readCacheIsEmpty();
                                tMLogger.m223i(TimonClipboardSuite.TAG, sb.append(readCacheIsEmpty2).toString());
                            }
                        });
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (NullPointerException e) {
                    TMLogger.INSTANCE.m221e(TAG, "addPrimaryClipChangedListener NPE " + e.getMessage());
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void clearReadCache$default(TimonClipboardSuite timonClipboardSuite, ClipDescription clipDescription, int i, Object obj) {
        if ((i & 1) != 0) {
            clipDescription = null;
        }
        timonClipboardSuite.clearReadCache(clipDescription);
    }

    private final void clearReadCache(ClipDescription newestDescription) {
        setCachedClipData(null);
        if (newestDescription != null) {
            cachedClipDescription = newestDescription;
        }
        CertConfigManager.INSTANCE.clearTokenHasReadClipData();
    }

    public final void registerClipboardToggleReferee(Function0<Boolean> clipboardToggleReferee2) {
        Intrinsics.checkParameterIsNotNull(clipboardToggleReferee2, "clipboardToggleReferee");
        clipboardToggleReferee = clipboardToggleReferee2;
    }

    public final void registerConfigProvider(Function0<JsonObject> configProvider) {
        Intrinsics.checkParameterIsNotNull(configProvider, "configProvider");
        if (getInit()) {
            return;
        }
        CertConfigManager.INSTANCE.registerConfigProvider(configProvider);
    }

    public final void registerDefaultConfigProvider(Function0<JsonObject> configProvider) {
        Intrinsics.checkParameterIsNotNull(configProvider, "configProvider");
        if (getInit()) {
            return;
        }
        CertConfigManager.INSTANCE.registerDefaultConfigProvider(configProvider);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClipDescription getPrimaryClipDescription$default(TimonClipboardSuite timonClipboardSuite, Cert cert, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return timonClipboardSuite.getPrimaryClipDescription(cert, function1);
    }

    public final ClipDescription getPrimaryClipDescription(Cert cert_, Function1<? super String, Unit> readCallback) {
        Cert genEmptyCert = cert_ != null ? cert_ : EmptyCert.INSTANCE.genEmptyCert();
        long j = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j2 = 0;
        String str5 = ClipboardSuiteConstants.INSTANCE.getID_TO_METHOD_NAME().get(Integer.valueOf(ClipboardSuiteConstants.ID_GET_PRIMARY_DESCRIPTION));
        ReportHelper.ReportContext reportContext = new ReportHelper.ReportContext(j, str, str2, str3, str4, j2, str5 != null ? str5 : "", genEmptyCert, ClipboardSuiteConstants.ID_GET_PRIMARY_DESCRIPTION, null, false, 0L, 0L, null, 15935, null);
        reportContext.getEvent().setRead(1);
        initClipboardManager();
        if (clipboardManager == null) {
            reportContext.getEvent().setError_code(CheckResultKt.kTMPasteboardErrorCodeSuiteNotInit);
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(readCallback, "Error: TimonClipboardSuite not init yet");
            return null;
        }
        if (isFromViewAutoPaste()) {
            reportContext.getEvent().set_initiative_read(1);
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(readCallback, "Success: Read from View pass.");
            return getSystemDescription();
        }
        CheckResult check = ReadFastPassChecker.INSTANCE.check(genEmptyCert, new Function0<Boolean>() { // from class: com.bytedance.timon.clipboard.suite.TimonClipboardSuite$getPrimaryClipDescription$fastPassResult$1
            public /* bridge */ /* synthetic */ Object invoke() {
                return Boolean.valueOf(m1038invoke());
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final boolean m1038invoke() {
                boolean hasPrimaryClip;
                hasPrimaryClip = TimonClipboardSuite.INSTANCE.hasPrimaryClip();
                return hasPrimaryClip;
            }
        });
        if (check.getIntercept()) {
            reportContext.getEvent().setError_code(check.getCode());
            reportContext.getEvent().setFastPass(1);
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(readCallback, "Success: method=getPrimaryClipDescription, " + check);
            return null;
        }
        CertConfigManager certConfigManager = CertConfigManager.INSTANCE;
        String certToken = genEmptyCert.certToken();
        if (certToken == null) {
            certToken = "";
        }
        if (!certConfigManager.disableBaseModelIntercept(certToken) && ScenesDetector.INSTANCE.isBasicMode()) {
            String certToken2 = genEmptyCert.certToken();
            if (certToken2 == null) {
                certToken2 = "";
            }
            CheckResult checkResult = new CheckResult(true, "Can't read clipboard in basic model", certToken2, CheckResultKt.kTMPasteboardErrorCodeInBasicMode);
            reportContext.getEvent().setError_code(checkResult.getCode());
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(readCallback, "Error: " + checkResult);
            return null;
        }
        CheckResult check2 = CertChecker.INSTANCE.check(genEmptyCert, ClipboardSuiteConstants.GET_CLIPBOARD_DESCRIPTION, ClipboardSuiteConstants.ID_GET_PRIMARY_DESCRIPTION);
        if (check2.getIntercept()) {
            reportContext.getEvent().setError_code(check2.getCode());
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(readCallback, "Error: " + check2.getMessage());
            return null;
        }
        CheckResult validate = RuleChecker.INSTANCE.validate(ClipboardSuiteConstants.ID_GET_PRIMARY_DESCRIPTION, genEmptyCert);
        if (validate.getIntercept()) {
            reportContext.setCheckResult(validate);
            reportContext.getEvent().setError_code(validate.getCode());
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(readCallback, "Error: " + validate);
            return null;
        }
        checkCacheIsInvalid();
        String certToken3 = genEmptyCert.certToken();
        if (certToken3 == null) {
            certToken3 = "";
        }
        ClipDescription description = getDescription(certToken3);
        ReportHelper.INSTANCE.report(reportContext);
        invokeCallback(readCallback, "Success:\nFastPass=" + check + ", \n Cert=" + check2 + ", \n FromCache=" + (description != null));
        return description;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CharSequence getText$default(TimonClipboardSuite timonClipboardSuite, Cert cert, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return timonClipboardSuite.getText(cert, function1);
    }

    public final CharSequence getText(Cert cert, Function1<? super String, Unit> errorCallback) {
        ClipData.Item itemAt;
        ClipData primaryClip = getPrimaryClip(cert, errorCallback, ClipboardSuiteConstants.ID_GET_TEXT, ClipboardSuiteConstants.GET_TEXT);
        if ((primaryClip != null ? primaryClip.getItemCount() : 0) <= 0 || primaryClip == null || (itemAt = primaryClip.getItemAt(0)) == null) {
            return null;
        }
        return itemAt.getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClipData getPrimaryClip$default(TimonClipboardSuite timonClipboardSuite, Cert cert, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return timonClipboardSuite.getPrimaryClip(cert, function1);
    }

    public final ClipData getPrimaryClip(Cert cert, Function1<? super String, Unit> readCallback) {
        return getPrimaryClip(cert, readCallback, ClipboardSuiteConstants.ID_GET_PRIMARY_CLIP, ClipboardSuiteConstants.GET_PRIMARY_CLIP);
    }

    public final void savePrimaryClipReadTimestamp(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        Long writeTimestamp = getWriteTimestamp(token);
        if (writeTimestamp != null) {
            long longValue = writeTimestamp.longValue();
            if (CertConfigManager.INSTANCE.isEnableCustomSaveTimestamp(token)) {
                ClipboardSuiteStorageHelper.INSTANCE.writeLastWriteTimestamp(token, longValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClipDescription getSystemDescription() {
        TMLogger.INSTANCE.m223i(TAG, "invoke getSystemDescription");
        ClipboardManager clipboardManager2 = clipboardManager;
        if (clipboardManager2 != null) {
            return clipboardManager2.getPrimaryClipDescription();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ ClipData getPrimaryClip$default(TimonClipboardSuite timonClipboardSuite, Cert cert, Function1 function1, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        return timonClipboardSuite.getPrimaryClip(cert, function1, i, str);
    }

    private final ClipData getPrimaryClip(Cert cert_, Function1<? super String, Unit> readCallback, int apiId, String entryToken) {
        ClipData cacheAndCallGetClipPrimary;
        Application application2;
        Cert genEmptyCert = cert_ != null ? cert_ : EmptyCert.INSTANCE.genEmptyCert();
        long j = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j2 = 0;
        String str5 = ClipboardSuiteConstants.INSTANCE.getID_TO_METHOD_NAME().get(Integer.valueOf(apiId));
        if (str5 == null) {
            str5 = "";
        }
        Cert cert = genEmptyCert;
        ReportHelper.ReportContext reportContext = new ReportHelper.ReportContext(j, str, str2, str3, str4, j2, str5, cert, apiId, null, false, 0L, 0L, null, 15935, null);
        if (TMEnv.INSTANCE.getEnableClipboardPermissionDetect() && (application2 = application) != null) {
            ReportHelper.Event event = reportContext.getEvent();
            TimonClipboardSuite timonClipboardSuite = INSTANCE;
            Application application3 = application2;
            event.setRead_permission(timonClipboardSuite.checkPermissionByAppOps(application3, OPSTR_READ_CLIPBOARD));
            reportContext.getEvent().setWrite_permission(timonClipboardSuite.checkPermissionByAppOps(application3, OPSTR_WRITE_CLIPBOARD));
        }
        reportContext.getEvent().setRead(1);
        initClipboardManager();
        if (clipboardManager == null) {
            reportContext.getEvent().setError_code(CheckResultKt.kTMPasteboardErrorCodeSuiteNotInit);
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(readCallback, "Error: TimonClipboardSuite not init yet");
            return null;
        }
        CertConfigManager certConfigManager = CertConfigManager.INSTANCE;
        String certToken = cert.certToken();
        if (certToken == null) {
            certToken = "";
        }
        if (!certConfigManager.disableAutoReadPass(certToken) && isFromViewAutoPaste()) {
            ClipData cacheAndCallGetClipPrimary2 = cacheAndCallGetClipPrimary(true, cert, reportContext);
            reportContext.getEvent().setHasReadContent(ReportHelper.INSTANCE.toStr$clipboard_suite_release(cacheAndCallGetClipPrimary2 != null));
            reportContext.getEvent().set_initiative_read(1);
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(readCallback, "Success: Read from View pass.");
            return cacheAndCallGetClipPrimary2;
        }
        CheckResult check = ReadFastPassChecker.INSTANCE.check(cert, new Function0<Boolean>() { // from class: com.bytedance.timon.clipboard.suite.TimonClipboardSuite$getPrimaryClip$fastPassResult$1
            public /* bridge */ /* synthetic */ Object invoke() {
                return Boolean.valueOf(m1037invoke());
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final boolean m1037invoke() {
                boolean hasPrimaryClip;
                hasPrimaryClip = TimonClipboardSuite.INSTANCE.hasPrimaryClip();
                return hasPrimaryClip;
            }
        });
        if (check.getIntercept()) {
            reportContext.getEvent().setError_code(check.getCode());
            reportContext.getEvent().setFastPass(1);
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(readCallback, "Error: " + check);
            return null;
        }
        CertConfigManager certConfigManager2 = CertConfigManager.INSTANCE;
        String certToken2 = cert.certToken();
        if (certToken2 == null) {
            certToken2 = "";
        }
        if (!certConfigManager2.disableBaseModelIntercept(certToken2) && ScenesDetector.INSTANCE.isBasicMode()) {
            String certToken3 = cert.certToken();
            if (certToken3 == null) {
                certToken3 = "";
            }
            CheckResult checkResult = new CheckResult(true, "Can't read clipboard in basic model", certToken3, CheckResultKt.kTMPasteboardErrorCodeInBasicMode);
            reportContext.getEvent().setError_code(checkResult.getCode());
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(readCallback, "Error: " + checkResult);
            return null;
        }
        CheckResult check2 = CertChecker.INSTANCE.check(cert, entryToken, apiId);
        if (check2.getIntercept()) {
            reportContext.getEvent().setError_code(check2.getCode());
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(readCallback, "Error: " + check2);
            return null;
        }
        if (!enableAutoReadClipboard()) {
            CertConfigManager certConfigManager3 = CertConfigManager.INSTANCE;
            String certToken4 = cert.certToken();
            if (certToken4 == null) {
                certToken4 = "";
            }
            if (!certConfigManager3.disableAutoReadSwitch(certToken4)) {
                reportContext.getEvent().setError_code(CheckResultKt.kTMPasteboardErrorCodeDisableAutoRead);
                ReportHelper.INSTANCE.report(reportContext);
                invokeCallback(readCallback, "Error: auto read clipboard toggle closed");
                return null;
            }
        }
        CheckResult validate = RuleChecker.INSTANCE.validate(apiId, cert);
        if (validate.getIntercept()) {
            reportContext.setCheckResult(validate);
            reportContext.getEvent().setError_code(validate.getCode());
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(readCallback, "Error: " + validate);
            return null;
        }
        checkCacheIsInvalid();
        if (!verifyLastWrittenTimestamp(cert)) {
            CertConfigManager certConfigManager4 = CertConfigManager.INSTANCE;
            String certToken5 = cert.certToken();
            if (certToken5 == null) {
                certToken5 = "";
            }
            if (certConfigManager4.isEnableTimestampVerifyIntercept(certToken5)) {
                reportContext.getEvent().setError_code(CheckResultKt.kTMPasteboardErrorCodeDisableRepeatReadByTimestamp);
                ReportHelper.INSTANCE.report(reportContext);
                return null;
            }
            reportContext.getEvent().setRead_timestamp_verify_intercept(true);
        } else {
            reportContext.getEvent().setRead_timestamp_verify_intercept(false);
        }
        String certToken6 = cert.certToken();
        if (certToken6 == null) {
            certToken6 = "";
        }
        Long writeTimestamp = getWriteTimestamp(certToken6);
        if (writeTimestamp != null) {
            long longValue = writeTimestamp.longValue();
            CertConfigManager certConfigManager5 = CertConfigManager.INSTANCE;
            String certToken7 = cert.certToken();
            if (certToken7 == null) {
                certToken7 = "";
            }
            if (!certConfigManager5.isEnableCustomSaveTimestamp(certToken7)) {
                ClipboardSuiteStorageHelper clipboardSuiteStorageHelper = ClipboardSuiteStorageHelper.INSTANCE;
                String certToken8 = cert.certToken();
                if (certToken8 == null) {
                    certToken8 = "";
                }
                clipboardSuiteStorageHelper.writeLastWriteTimestamp(certToken8, longValue);
            }
        }
        if (interceptByPattern(cert, reportContext, readCallback)) {
            return null;
        }
        if (!readCacheIsEmpty()) {
            CertConfigManager certConfigManager6 = CertConfigManager.INSTANCE;
            String certToken9 = cert.certToken();
            if (certToken9 == null) {
                certToken9 = "";
            }
            if (certConfigManager6.disableRepeatReadUseCache(certToken9)) {
                reportContext.getEvent().setError_code(CheckResultKt.kTMPasteboardErrorCodeDisableRepeatReadUseCache);
                ReportHelper.INSTANCE.report(reportContext);
                invokeCallback(readCallback, "Error:duplicate read interception");
                return null;
            }
        }
        CertConfigManager certConfigManager7 = CertConfigManager.INSTANCE;
        String certToken10 = cert.certToken();
        if (certToken10 == null) {
            certToken10 = "";
        }
        boolean disableCache = certConfigManager7.disableCache(certToken10);
        TMLogger.INSTANCE.m223i(TAG, "cache was disabled=" + disableCache);
        if (interceptByMimeType(cert, reportContext, readCallback)) {
            return null;
        }
        if (cachedClipData != null && !disableCache) {
            TMLogger.INSTANCE.m223i(TAG, "read from cache");
            reportContext.getEvent().setCache("1");
            reportContext.getEvent().setHasReadContent("1");
            reportContext.getEvent().setRepeatRead(1);
            cacheAndCallGetClipPrimary = cachedClipData;
        } else {
            synchronized (this) {
                if (cachedClipData != null && !disableCache) {
                    TMLogger.INSTANCE.m223i(TAG, "read from cache_");
                    reportContext.getEvent().setCache("1");
                    reportContext.getEvent().setHasReadContent("1");
                    reportContext.getEvent().setRepeatRead(1);
                    cacheAndCallGetClipPrimary = cachedClipData;
                } else {
                    cacheAndCallGetClipPrimary = INSTANCE.cacheAndCallGetClipPrimary(disableCache, cert, reportContext);
                    reportContext.getEvent().setHasReadContent(ReportHelper.INSTANCE.toStr$clipboard_suite_release(cacheAndCallGetClipPrimary != null));
                }
            }
        }
        ReportHelper.Event event2 = reportContext.getEvent();
        String certToken11 = cert.certToken();
        if (certToken11 == null) {
            certToken11 = "";
        }
        event2.setWriteTimestamp(getWriteTimestamp(certToken11));
        ReportHelper.INSTANCE.report(reportContext);
        StringBuilder append = new StringBuilder("Success: FastPass=").append(check).append(", Cert=").append(check2).append(", \n FromCache=");
        Integer repeatRead = reportContext.getEvent().getRepeatRead();
        invokeCallback(readCallback, append.append(repeatRead != null && repeatRead.intValue() == 1).toString());
        CertConfigManager certConfigManager8 = CertConfigManager.INSTANCE;
        String certToken12 = cert.certToken();
        if (certToken12 == null) {
            certToken12 = "";
        }
        certConfigManager8.recordTokenHasReadClipData(certToken12);
        return cacheAndCallGetClipPrimary;
    }

    private final void checkCacheIsInvalid() {
        if (!readCacheIsEmpty() && Build.VERSION.SDK_INT >= 29 && isFromBackToFront) {
            isFromBackToFront = false;
            TMLogger.INSTANCE.m223i(TAG, "前台进后台");
            Pair<Boolean, ClipDescription> hasPrimaryClipChangedWithNewestDescription = hasPrimaryClipChangedWithNewestDescription();
            if (((Boolean) hasPrimaryClipChangedWithNewestDescription.getFirst()).booleanValue()) {
                clearReadCache((ClipDescription) hasPrimaryClipChangedWithNewestDescription.getSecond());
                TMLogger.INSTANCE.m223i(TAG, "clear cache because other app copied something");
            }
        }
    }

    private final void checkSetCacheIsInvalid(Cert cert) {
        String str;
        ClipDescription systemDescription;
        PersistableBundle extras;
        if (lastSetClipData == null) {
            return;
        }
        CertConfigManager certConfigManager = CertConfigManager.INSTANCE;
        if (cert == null || (str = cert.certToken()) == null) {
            str = "";
        }
        if (!certConfigManager.disableWriteCache(str) && (systemDescription = getSystemDescription()) != null && (extras = systemDescription.getExtras()) != null) {
            Application application2 = application;
            if (extras.getBoolean(Intrinsics.stringPlus(application2 != null ? application2.getPackageName() : null, "timon_written_flag"))) {
                return;
            }
        }
        lastSetClipData = null;
        TMLogger.INSTANCE.m223i(TAG, "clear cache");
    }

    private final void invokeCallback(Function1<? super String, Unit> callback, String message) {
        if (callback != null) {
        }
    }

    private final boolean isFromViewAutoPaste() {
        Class<?> cls;
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        Intrinsics.checkExpressionValueIsNotNull(stackTrace, Fields.STACK);
        for (StackTraceElement stackTraceElement : stackTrace) {
            try {
                Intrinsics.checkExpressionValueIsNotNull(stackTraceElement, "it");
                cls = Class.forName(stackTraceElement.getClassName());
            } catch (ClassNotFoundException unused) {
                cls = null;
            }
            if (cls != null && TextView.class.isAssignableFrom(cls)) {
                TMLogger.INSTANCE.m223i(TAG, "paste from TextView");
                return true;
            }
        }
        return false;
    }

    private final boolean enableAutoReadClipboard() {
        Boolean bool;
        Function0<Boolean> function0 = clipboardToggleReferee;
        if (function0 == null || (bool = (Boolean) function0.invoke()) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasPrimaryClip() {
        ClipboardManager clipboardManager2 = clipboardManager;
        if (clipboardManager2 != null) {
            return safeHasPrimaryClip(clipboardManager2);
        }
        return false;
    }

    private final boolean interceptByPattern(Cert cert, ReportHelper.ReportContext reportContext, Function1<? super String, Unit> readCallback) {
        String str;
        String str2;
        String str3;
        String certToken;
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        String str4 = "";
        if (cert == null || (str = cert.certToken()) == null) {
            str = "";
        }
        ClipDescription description = getDescription(str);
        if (description == null || description.getClassificationStatus() != 3) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        CertConfigManager certConfigManager = CertConfigManager.INSTANCE;
        if (cert == null || (str2 = cert.certToken()) == null) {
            str2 = "";
        }
        TokenConfig config = certConfigManager.getConfig(str2);
        float patternConfidence = config.getPatternConfidence() == 0.0f ? 1.0f : config.getPatternConfidence();
        JSONObject jSONObject = new JSONObject();
        for (String str5 : EXCEPT_PATTERNS) {
            float confidenceScore = description.getConfidenceScore(str5);
            jSONObject.putOpt(str5, Float.valueOf(confidenceScore));
            if (confidenceScore >= patternConfidence) {
                arrayList.add(str5);
            }
        }
        lastMatchedPattern = arrayList;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = arrayList;
        Iterator it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            sb.append(sb.length() > 0 ? IWeiboService.Scope.EMPTY_SCOPE : "").append((String) it.next());
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "run {\n            val sb…  sb.toString()\n        }");
        reportContext.getEvent().setPatterns(sb2);
        reportContext.getEvent().setPatternsScore(jSONObject.toString());
        TMLogger.INSTANCE.m223i(TAG, "except " + config.getPatterns() + ", matched " + sb2);
        CertConfigManager certConfigManager2 = CertConfigManager.INSTANCE;
        if (cert == null || (str3 = cert.certToken()) == null) {
            str3 = "";
        }
        if (!certConfigManager2.disablePatternMatch(str3)) {
            Iterator<T> it2 = config.getPatterns().iterator();
            boolean z = true;
            while (it2.hasNext()) {
                if (!arrayList.contains((String) it2.next())) {
                    z = false;
                }
            }
            if (!z) {
                reportContext.getEvent().setError_code(CheckResultKt.kTMPasteboardErrorCodeDetectPatternFailed);
                ReportHelper.INSTANCE.report(reportContext);
                StringBuilder sb3 = new StringBuilder("Error: ");
                String str6 = "content not matched patterns, except " + CollectionsKt.sorted(config.getPatterns()) + ", matched " + CollectionsKt.sorted(arrayList2);
                if (cert != null && (certToken = cert.certToken()) != null) {
                    str4 = certToken;
                }
                invokeCallback(readCallback, sb3.append(new CheckResult(true, str6, str4, CheckResultKt.kTMPasteboardErrorCodeDetectPatternFailed)).toString());
                return true;
            }
        }
        return false;
    }

    private final boolean interceptByMimeType(Cert cert, ReportHelper.ReportContext reportContext, Function1<? super String, Unit> readCallback) {
        String str;
        String str2;
        String str3;
        String certToken;
        String str4 = "";
        if (cert == null || (str = cert.certToken()) == null) {
            str = "";
        }
        ClipDescription description = getDescription(str);
        if (description != null) {
            if (description.getMimeTypeCount() > 0) {
                StringBuilder sb = new StringBuilder();
                int mimeTypeCount = description.getMimeTypeCount();
                for (int i = 0; i < mimeTypeCount; i++) {
                    if (i != 0) {
                        sb.append(SyncConstants.SEPARATOR);
                    }
                    sb.append(description.getMimeType(i));
                }
                str2 = sb.toString();
            } else {
                str2 = "";
            }
            Intrinsics.checkExpressionValueIsNotNull(str2, "if (description.mimeType…\n            \"\"\n        }");
            TMLogger.INSTANCE.m223i(TAG, "mimeType " + str2);
            reportContext.getEvent().setMimeType(str2);
            if (description.getMimeTypeCount() <= 0) {
                return false;
            }
            CertConfigManager certConfigManager = CertConfigManager.INSTANCE;
            if (cert == null || (str3 = cert.certToken()) == null) {
                str3 = "";
            }
            if (certConfigManager.isEnableNoneTextInFirstIntercept(str3) && !ClipDescription.compareMimeTypes(description.getMimeType(0), "text/*")) {
                mimeTypeIntercept(reportContext, readCallback, str2, cert, 4096);
                return true;
            }
            CertConfigManager certConfigManager2 = CertConfigManager.INSTANCE;
            if (cert != null && (certToken = cert.certToken()) != null) {
                str4 = certToken;
            }
            if (certConfigManager2.isEnableNotContainsTextIntercept(str4)) {
                Iterator it = CollectionsKt.listOf("text/*").iterator();
                while (it.hasNext()) {
                    if (description.hasMimeType((String) it.next())) {
                        return false;
                    }
                }
                mimeTypeIntercept(reportContext, readCallback, str2, cert, 2048);
                return true;
            }
        }
        return false;
    }

    private final void mimeTypeIntercept(ReportHelper.ReportContext reportContext, Function1<? super String, Unit> readCallback, String mimeType, Cert cert, int reason) {
        String str;
        StringBuilder sb = new StringBuilder("Error: ");
        String str2 = "content contains intercept mime type, type: " + mimeType + ", reason: " + reason;
        if (cert == null || (str = cert.certToken()) == null) {
            str = "";
        }
        invokeCallback(readCallback, sb.append(new CheckResult(true, str2, str, CheckResultKt.kTMPasteboardErrorCodeImageIntercept)).toString());
        reportContext.getEvent().setError_code(CheckResultKt.kTMPasteboardErrorCodeImageIntercept);
        ReportHelper.INSTANCE.report(reportContext);
    }

    private final synchronized ClipDescription getDescription(String certToken) {
        if (CertConfigManager.INSTANCE.disableCache(certToken)) {
            return getSystemDescription();
        }
        if (cachedClipDescription == null) {
            ClipboardManager clipboardManager2 = clipboardManager;
            ClipDescription primaryClipDescription = clipboardManager2 != null ? clipboardManager2.getPrimaryClipDescription() : null;
            if (primaryClipDescription != null) {
                cachedClipDescription = primaryClipDescription;
            } else {
                Log.i(TAG, "system description is null because of lose input focus cert" + certToken);
            }
        }
        return cachedClipDescription;
    }

    private final ClipData cacheAndCallGetClipPrimary(boolean userActiveRead, Cert cert, ReportHelper.ReportContext reportContext) {
        int i;
        if (userActiveRead) {
            ClipboardManager clipboardManager2 = clipboardManager;
            r0 = clipboardManager2 != null ? safeGetPrimaryClip(clipboardManager2) : null;
            ClipData clipData = cachedClipData;
            if (clipData != null) {
                boolean same = INSTANCE.same(clipData, r0);
                ReportHelper.Event event = reportContext.getEvent();
                if (same) {
                    i = 1;
                } else {
                    i = 0;
                }
                event.setCache_is_valid(i);
                TMLogger.INSTANCE.m223i(TAG, "content is same:" + same);
                Unit unit = Unit.INSTANCE;
            }
        } else {
            ClipboardManager clipboardManager3 = clipboardManager;
            if (clipboardManager3 != null) {
                r0 = safeGetPrimaryClip(clipboardManager3);
            }
        }
        setCachedClipData(r0);
        cacheClipboardDataToSensitiveCache(cert, userActiveRead);
        return cachedClipData;
    }

    private final Pair<Boolean, ClipDescription> hasPrimaryClipChangedWithNewestDescription() {
        if (readCacheIsEmpty()) {
            return new Pair<>(false, (Object) null);
        }
        if (Build.VERSION.SDK_INT < 26) {
            return new Pair<>(true, (Object) null);
        }
        ClipDescription clipDescription = cachedClipDescription;
        if (clipDescription == null) {
            ClipData clipData = cachedClipData;
            clipDescription = clipData != null ? clipData.getDescription() : null;
        }
        if (clipDescription == null) {
            Pair<Boolean, ClipDescription> pair = new Pair<>(true, (Object) null);
            TMLogger.INSTANCE.m223i(TAG, "content changed: cachedClipData?.description == null");
            return pair;
        }
        ClipDescription systemDescription = getSystemDescription();
        if (systemDescription == null) {
            Pair<Boolean, ClipDescription> pair2 = new Pair<>(true, (Object) null);
            TMLogger.INSTANCE.m223i(TAG, "content changed: getSystemDescription() == null");
            return pair2;
        }
        if (systemDescription.getTimestamp() != clipDescription.getTimestamp()) {
            TMLogger.INSTANCE.m223i(TAG, "content changed: description.timestamp != preDescription.timestamp");
            return new Pair<>(true, systemDescription);
        }
        TMLogger.INSTANCE.m223i(TAG, "content is same.");
        return new Pair<>(false, (Object) null);
    }

    private final boolean same(ClipData clipData, ClipData clipData2) {
        if (clipData2 == null || clipData.getItemCount() != clipData2.getItemCount()) {
            return false;
        }
        int itemCount = clipData.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            ClipData.Item itemAt = clipData.getItemAt(i);
            ClipData.Item itemAt2 = clipData2.getItemAt(i);
            if (itemAt != null && !same(itemAt, itemAt2)) {
                return false;
            }
        }
        return true;
    }

    private final boolean same(ClipData.Item item, ClipData.Item item2) {
        CharSequence text;
        CharSequence text2 = item.getText();
        if (Intrinsics.areEqual(text2 != null ? text2.toString() : null, (item2 == null || (text = item2.getText()) == null) ? null : text.toString())) {
            if (Intrinsics.areEqual(item.getHtmlText(), item2 != null ? item2.getHtmlText() : null)) {
                if (Intrinsics.areEqual(item.getUri(), item2 != null ? item2.getUri() : null) && checkItemIntentIsSame(item, item2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean checkItemIntentIsSame(ClipData.Item item, ClipData.Item item2) {
        if (item.getIntent() == null) {
            if ((item2 != null ? item2.getIntent() : null) != null) {
                return false;
            }
        }
        if (item.getIntent() != null) {
            if ((item2 != null ? item2.getIntent() : null) == null) {
                return false;
            }
        }
        if (item.getIntent() != null) {
            if ((item2 != null ? item2.getIntent() : null) != null) {
                Intent intent = item.getIntent();
                Intrinsics.checkExpressionValueIsNotNull(intent, "this.intent");
                if (intent.getExtras() != null) {
                    return false;
                }
                Intent intent2 = item2.getIntent();
                Intrinsics.checkExpressionValueIsNotNull(intent2, "other.intent");
                if (intent2.getExtras() == null) {
                    return item.getIntent().filterEquals(item2.getIntent());
                }
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setPrimaryClip$default(TimonClipboardSuite timonClipboardSuite, Cert cert, ClipData clipData, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        timonClipboardSuite.setPrimaryClip(cert, clipData, function1);
    }

    public final void setPrimaryClip(Cert cert, ClipData clipData, Function1<? super String, Unit> errorCallback) {
        Intrinsics.checkParameterIsNotNull(clipData, "clipData");
        setPrimaryClip(cert, clipData, errorCallback, ClipboardSuiteConstants.ID_SET_PRIMARY_CLIP, ClipboardSuiteConstants.SET_PRIMARY_CLIP);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void clearPrimaryClip$default(TimonClipboardSuite timonClipboardSuite, Cert cert, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        timonClipboardSuite.clearPrimaryClip(cert, function1);
    }

    public final void clearPrimaryClip(Cert cert_, Function1<? super String, Unit> errorCallback) {
        Cert genEmptyCert = cert_ != null ? cert_ : EmptyCert.INSTANCE.genEmptyCert();
        long j = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j2 = 0;
        String str5 = ClipboardSuiteConstants.INSTANCE.getID_TO_METHOD_NAME().get(Integer.valueOf(ClipboardSuiteConstants.ID_CLEAR_PRIMARY));
        ReportHelper.ReportContext reportContext = new ReportHelper.ReportContext(j, str, str2, str3, str4, j2, str5 != null ? str5 : "", genEmptyCert, ClipboardSuiteConstants.ID_CLEAR_PRIMARY, null, false, 0L, 0L, null, 14911, null);
        clearReadCache$default(this, null, 1, null);
        initClipboardManager();
        CheckResult check = WriteFastPassChecker.INSTANCE.check(genEmptyCert);
        if (check.getIntercept()) {
            reportContext.getEvent().setError_code(check.getCode());
            reportContext.getEvent().setFastPass(1);
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(errorCallback, "Error: " + check);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            CheckResult check2 = CertChecker.INSTANCE.check(genEmptyCert, ClipboardSuiteConstants.CLEAR_CLIPBOARD, ClipboardSuiteConstants.ID_CLEAR_PRIMARY);
            if (!check2.getIntercept()) {
                CheckResult validate = RuleChecker.INSTANCE.validate(ClipboardSuiteConstants.ID_CLEAR_PRIMARY, genEmptyCert);
                if (validate.getIntercept()) {
                    reportContext.setCheckResult(validate);
                    reportContext.getEvent().setError_code(validate.getCode());
                    ReportHelper.INSTANCE.report(reportContext);
                    invokeCallback(errorCallback, "Error: " + validate);
                    return;
                }
                ClipboardManager clipboardManager2 = clipboardManager;
                if (clipboardManager2 != null) {
                    safeClearPrimaryClip(clipboardManager2);
                }
                lastSetClipData = null;
                ReportHelper.INSTANCE.report(reportContext);
                invokeCallback(errorCallback, "cert=" + genEmptyCert.certToken() + " clear success");
                return;
            }
            reportContext.getEvent().setError_code(check2.getCode());
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(errorCallback, "cert=" + genEmptyCert.certToken() + " is not valid, because of " + check2.getMessage());
            TMLogger.INSTANCE.m221e(TAG, "cert=" + genEmptyCert + " is not valid, because of " + check2.getMessage());
            return;
        }
        ReportHelper.ReportContext reportContext2 = new ReportHelper.ReportContext(0L, null, null, null, null, 0L, "setPrimaryClip", genEmptyCert, ClipboardSuiteConstants.ID_SET_PRIMARY_CLIP, null, false, 0L, 0L, null, 14911, null);
        CheckResult check3 = CertChecker.INSTANCE.check(genEmptyCert, ClipboardSuiteConstants.SET_PRIMARY_CLIP, ClipboardSuiteConstants.ID_SET_PRIMARY_CLIP);
        if (!check3.getIntercept()) {
            CheckResult validate2 = RuleChecker.INSTANCE.validate(ClipboardSuiteConstants.ID_SET_PRIMARY_CLIP, genEmptyCert);
            if (validate2.getIntercept()) {
                reportContext.setCheckResult(validate2);
                reportContext.getEvent().setError_code(validate2.getCode());
                ReportHelper.INSTANCE.report(reportContext);
                invokeCallback(errorCallback, "Error: " + validate2);
                return;
            }
            ClipboardManager clipboardManager3 = clipboardManager;
            if (clipboardManager3 != null) {
                ClipData newPlainText = ClipData.newPlainText("", "");
                Intrinsics.checkExpressionValueIsNotNull(newPlainText, "ClipData.newPlainText(\"\", \"\")");
                safeSetPrimaryClip(clipboardManager3, newPlainText);
            }
            lastSetClipData = null;
            ReportHelper.INSTANCE.report(reportContext2);
            invokeCallback(errorCallback, "cert=" + (genEmptyCert != null ? genEmptyCert.certToken() : null) + " clear success, by setPrimaryCLip");
            return;
        }
        reportContext2.getEvent().setError_code(check3.getCode());
        ReportHelper.INSTANCE.report(reportContext2);
        invokeCallback(errorCallback, "cert=" + (genEmptyCert != null ? genEmptyCert.certToken() : null) + " is not valid, because of " + check3.getMessage());
        TMLogger.INSTANCE.m221e(TAG, "cert=" + genEmptyCert + " is not valid, because of " + check3.getMessage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setText$default(TimonClipboardSuite timonClipboardSuite, Cert cert, CharSequence charSequence, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        timonClipboardSuite.setText(cert, charSequence, function1);
    }

    public final void setText(Cert cert, CharSequence text, Function1<? super String, Unit> errorCallback) {
        Intrinsics.checkParameterIsNotNull(text, "text");
        ClipData newPlainText = ClipData.newPlainText(null, text);
        Intrinsics.checkExpressionValueIsNotNull(newPlainText, "ClipData.newPlainText(null, text)");
        setPrimaryClip(cert, newPlainText, errorCallback, ClipboardSuiteConstants.ID_SET_TEXT, ClipboardSuiteConstants.SET_TEXT);
    }

    static /* synthetic */ void setPrimaryClip$default(TimonClipboardSuite timonClipboardSuite, Cert cert, ClipData clipData, Function1 function1, int i, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        timonClipboardSuite.setPrimaryClip(cert, clipData, function1, i, str);
    }

    private final void setPrimaryClip(Cert cert_, ClipData clipData, Function1<? super String, Unit> errorCallback, int apiId, String entryToken) {
        PersistableBundle extras;
        Application application2;
        Cert genEmptyCert = cert_ != null ? cert_ : EmptyCert.INSTANCE.genEmptyCert();
        long j = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j2 = 0;
        String str5 = ClipboardSuiteConstants.INSTANCE.getID_TO_METHOD_NAME().get(Integer.valueOf(apiId));
        if (str5 == null) {
            str5 = "";
        }
        Cert cert = genEmptyCert;
        ReportHelper.ReportContext reportContext = new ReportHelper.ReportContext(j, str, str2, str3, str4, j2, str5, cert, apiId, null, false, 0L, 0L, null, 14911, null);
        if (TMEnv.INSTANCE.getEnableClipboardPermissionDetect() && (application2 = application) != null) {
            ReportHelper.Event event = reportContext.getEvent();
            TimonClipboardSuite timonClipboardSuite = INSTANCE;
            Application application3 = application2;
            event.setRead_permission(timonClipboardSuite.checkPermissionByAppOps(application3, OPSTR_READ_CLIPBOARD));
            reportContext.getEvent().setWrite_permission(timonClipboardSuite.checkPermissionByAppOps(application3, OPSTR_WRITE_CLIPBOARD));
        }
        clearReadCache$default(this, null, 1, null);
        initClipboardManager();
        CheckResult check = WriteFastPassChecker.INSTANCE.check(cert);
        if (check.getIntercept()) {
            reportContext.getEvent().setError_code(check.getCode());
            reportContext.getEvent().setFastPass(1);
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(errorCallback, "Error: " + check);
            return;
        }
        CheckResult check2 = CertChecker.INSTANCE.check(cert, entryToken, apiId);
        if (!check2.getIntercept()) {
            CheckResult validate = RuleChecker.INSTANCE.validate(apiId, cert);
            if (validate.getIntercept()) {
                reportContext.setCheckResult(validate);
                reportContext.getEvent().setError_code(validate.getCode());
                ReportHelper.INSTANCE.report(reportContext);
                invokeCallback(errorCallback, "Error: " + validate);
                return;
            }
            checkSetCacheIsInvalid(cert);
            if (same(clipData, lastSetClipData)) {
                TMLogger.INSTANCE.m221e(TAG, "cert=" + cert + " set same clip");
                reportContext.getEvent().setCache("1");
                reportContext.getEvent().setError_code(CheckResultKt.kTMPasteboardErrorCodeRepeatWrite);
                ReportHelper.INSTANCE.report(reportContext);
                invokeCallback(errorCallback, "cert=" + cert.certToken() + " error, because of set same clip");
                return;
            }
            ClipDescription description = clipData.getDescription();
            if ((description != null ? description.getExtras() : null) != null) {
                ClipDescription description2 = clipData.getDescription();
                if (description2 != null && (extras = description2.getExtras()) != null) {
                    Application application4 = application;
                    extras.putBoolean(Intrinsics.stringPlus(application4 != null ? application4.getPackageName() : null, "timon_written_flag"), true);
                }
            } else {
                PersistableBundle persistableBundle = new PersistableBundle();
                Application application5 = application;
                persistableBundle.putBoolean(Intrinsics.stringPlus(application5 != null ? application5.getPackageName() : null, "timon_written_flag"), true);
                ClipDescription description3 = clipData.getDescription();
                if (description3 != null) {
                    description3.setExtras(persistableBundle);
                }
            }
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkExpressionValueIsNotNull(obtain, "Parcel.obtain()");
            clipData.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            lastSetClipData = (ClipData) ClipData.CREATOR.createFromParcel(obtain);
            obtain.recycle();
            ClipboardManager clipboardManager2 = clipboardManager;
            if (clipboardManager2 != null) {
                safeSetPrimaryClip(clipboardManager2, clipData);
            }
            ReportHelper.INSTANCE.report(reportContext);
            invokeCallback(errorCallback, "cert=" + cert.certToken() + "  set clip success");
            return;
        }
        reportContext.getEvent().setError_code(check2.getCode());
        ReportHelper.INSTANCE.report(reportContext);
        invokeCallback(errorCallback, "cert=" + cert.certToken() + " is not valid, because of " + check2.getMessage());
        TMLogger.INSTANCE.m221e(TAG, "cert=" + cert + " is not valid, because of " + check2.getMessage());
    }

    public static /* synthetic */ void reportEffectiveRead$default(TimonClipboardSuite timonClipboardSuite, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        timonClipboardSuite.reportEffectiveRead(str, z);
    }

    public final void reportEffectiveRead(String token, boolean isEffect) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        ReportHelper.INSTANCE.reportEffectiveRead(token, isEffect);
    }

    private final void cacheClipboardDataToSensitiveCache(Cert cert, boolean userActiveRead) {
        ClipData clipData;
        CharSequence text;
        ISensitiveContentCache sensitiveContentCacheByType = TMSensitiveContentCacheManager.INSTANCE.getSensitiveContentCacheByType(ISensitiveContentCache.Type.CLIPBOARD);
        if (sensitiveContentCacheByType == null || (clipData = cachedClipData) == null) {
            return;
        }
        int itemCount = clipData.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            ClipData.Item itemAt = clipData.getItemAt(i);
            if (itemAt != null && (text = itemAt.getText()) != null) {
                String obj = text.toString();
                Pair[] pairArr = new Pair[2];
                pairArr[0] = TuplesKt.to("bpea_cert_token", cert != null ? cert.certToken() : null);
                pairArr[1] = TuplesKt.to("disable_cache", Boolean.valueOf(userActiveRead));
                sensitiveContentCacheByType.cacheContent(new SensitiveCachedContent(obj, MapsKt.mapOf(pairArr)));
            }
        }
    }

    public final List<String> getMatchedPatterns() {
        return lastMatchedPattern;
    }

    public static /* synthetic */ Long getWriteTimestamp$default(TimonClipboardSuite timonClipboardSuite, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return timonClipboardSuite.getWriteTimestamp(str);
    }

    public final Long getWriteTimestamp(String certToken) {
        ClipDescription description;
        Intrinsics.checkParameterIsNotNull(certToken, "certToken");
        if (Build.VERSION.SDK_INT < 26 || (description = getDescription(certToken)) == null) {
            return null;
        }
        return Long.valueOf(description.getTimestamp());
    }

    private final int checkPermissionByAppOps(Context context, String opPermission) {
        try {
            Object systemService = context.getSystemService((Class<Object>) AppOpsManager.class);
            Intrinsics.checkExpressionValueIsNotNull(systemService, "context.getSystemService…ppOpsManager::class.java)");
            return ((AppOpsManager) systemService).checkOpNoThrow(opPermission, context.getApplicationInfo().uid, context.getPackageName());
        } catch (Exception unused) {
            TMLogger.INSTANCE.m221e(TAG, "find failed");
            return -1;
        }
    }

    public final void safeClearPrimaryClip(ClipboardManager clipboardManager2) {
        Intrinsics.checkParameterIsNotNull(clipboardManager2, "$this$safeClearPrimaryClip");
        try {
            clipboardManager2.clearPrimaryClip();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final ClipData safeGetPrimaryClip(ClipboardManager clipboardManager2) {
        Intrinsics.checkParameterIsNotNull(clipboardManager2, "$this$safeGetPrimaryClip");
        try {
            return clipboardManager2.getPrimaryClip();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean safeHasPrimaryClip(ClipboardManager clipboardManager2) {
        Intrinsics.checkParameterIsNotNull(clipboardManager2, "$this$safeHasPrimaryClip");
        try {
            return clipboardManager2.hasPrimaryClip();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void safeSetPrimaryClip(ClipboardManager clipboardManager2, ClipData clipData) {
        Intrinsics.checkParameterIsNotNull(clipboardManager2, "$this$safeSetPrimaryClip");
        Intrinsics.checkParameterIsNotNull(clipData, "clipData");
        try {
            clipboardManager2.setPrimaryClip(clipData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final boolean verifyLastWrittenTimestamp(Cert cert) {
        Long lastWriteTimestamp;
        if (Build.VERSION.SDK_INT < 26 || (lastWriteTimestamp = ClipboardSuiteStorageHelper.INSTANCE.getLastWriteTimestamp(cert.certToken())) == null) {
            return true;
        }
        long longValue = lastWriteTimestamp.longValue();
        String certToken = cert.certToken();
        if (certToken == null) {
            certToken = "";
        }
        Long writeTimestamp = getWriteTimestamp(certToken);
        return writeTimestamp == null || longValue != writeTimestamp.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean readCacheIsEmpty() {
        return cachedClipData == null && cachedClipDescription == null;
    }
}
