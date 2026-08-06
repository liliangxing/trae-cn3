package com.bytedance.timonbase;

import android.app.Application;
import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMEnv.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\t\n\u0002\b\u001f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001a\u00106\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001a\u00109\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001a\u0010<\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001a\u0010?\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001a\u0010B\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\u001a\u0010E\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001a\u0010H\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR\u001a\u0010K\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR\u001a\u0010N\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR\u001a\u0010Q\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u001b\"\u0004\bS\u0010\u001dR\u0011\u0010T\u001a\u00020U¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR\u001a\u0010[\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0006\"\u0004\b\\\u0010\bR\u001a\u0010]\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010\bR\u000e\u0010`\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010a\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u001b\"\u0004\bc\u0010\u001dR\u001a\u0010d\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u001b\"\u0004\bf\u0010\u001dR\u001a\u0010g\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u001b\"\u0004\bi\u0010\u001dR\u001a\u0010j\u001a\u00020UX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010W\"\u0004\bl\u0010mR\u001a\u0010n\u001a\u00020UX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010W\"\u0004\bp\u0010mR\u001a\u0010q\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u001b\"\u0004\bs\u0010\u001d¨\u0006t"}, d2 = {"Lcom/bytedance/timonbase/TMEnv;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "appId", "", "getAppId", "()I", "setAppId", "(I)V", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "basicModeEnable", "getBasicModeEnable", "setBasicModeEnable", "channel", "", "getChannel", "()Ljava/lang/String;", "setChannel", "(Ljava/lang/String;)V", "didGetter", "Lkotlin/Function0;", "getDidGetter", "()Lkotlin/jvm/functions/Function0;", "setDidGetter", "(Lkotlin/jvm/functions/Function0;)V", "enableAntiSurvivalService", "getEnableAntiSurvivalService", "setEnableAntiSurvivalService", "enableBpeaService", "getEnableBpeaService", "setEnableBpeaService", "enableClipboardCompliance", "getEnableClipboardCompliance", "setEnableClipboardCompliance", "enableClipboardPermissionDetect", "getEnableClipboardPermissionDetect", "setEnableClipboardPermissionDetect", "enableClipboardSuiteUseRule", "getEnableClipboardSuiteUseRule", "setEnableClipboardSuiteUseRule", "enableClipboardWindowFocusChecker", "getEnableClipboardWindowFocusChecker", "setEnableClipboardWindowFocusChecker", "enableDelayInit", "getEnableDelayInit", "setEnableDelayInit", "enableHeliosService", "getEnableHeliosService", "setEnableHeliosService", "enablePipeline", "getEnablePipeline", "setEnablePipeline", "enableProcessLifecycle", "getEnableProcessLifecycle", "setEnableProcessLifecycle", "enableReadPhoneStateDowngrade", "getEnableReadPhoneStateDowngrade", "setEnableReadPhoneStateDowngrade", "enableRulerParamGetEarlier", "getEnableRulerParamGetEarlier", "setEnableRulerParamGetEarlier", "enableRulerService", "getEnableRulerService", "setEnableRulerService", "enableRunningProcessDowngrade", "getEnableRunningProcessDowngrade", "setEnableRunningProcessDowngrade", "enableTimonToken", "getEnableTimonToken", "setEnableTimonToken", "initThread", "getInitThread", "setInitThread", "initialTime", "", "getInitialTime", "()J", "initialed", "getInitialed", "setInitialed", "isInitOpt", "setInitOpt", "rulerHardCodeReady", "getRulerHardCodeReady", "setRulerHardCodeReady", "sdkVersion", "settingFetcherSource", "getSettingFetcherSource", "setSettingFetcherSource", "timonDyeMark", "getTimonDyeMark", "setTimonDyeMark", "uid", "getUid", "setUid", "updateVersionCode", "getUpdateVersionCode", "setUpdateVersionCode", "(J)V", "versionCode", "getVersionCode", "setVersionCode", "versionName", "getVersionName", "setVersionName", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class TMEnv {
    private static boolean DEBUG = false;
    private static Application application = null;
    private static boolean basicModeEnable = false;
    private static boolean enableClipboardCompliance = false;
    private static boolean enableClipboardPermissionDetect = false;
    private static boolean enableClipboardWindowFocusChecker = false;
    private static boolean enableDelayInit = false;
    private static boolean enableProcessLifecycle = false;
    private static boolean enableRulerParamGetEarlier = false;
    private static boolean enableTimonToken = false;
    private static boolean initialed = false;
    private static boolean isInitOpt = false;
    private static boolean rulerHardCodeReady = false;
    public static final String sdkVersion = "4.0.0";
    private static long updateVersionCode;
    private static long versionCode;
    public static final TMEnv INSTANCE = new TMEnv();
    private static int appId = -1;
    private static String channel = "";
    private static String versionName = "";
    private static Function0<String> didGetter = new Function0<String>() { // from class: com.bytedance.timonbase.TMEnv$didGetter$1
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "";
        }
    };
    private static String uid = "";
    private static String settingFetcherSource = "";
    private static String initThread = "";
    private static final long initialTime = SystemClock.elapsedRealtime();
    private static boolean enablePipeline = true;
    private static boolean enableHeliosService = true;
    private static boolean enableRulerService = true;
    private static boolean enableBpeaService = true;
    private static boolean enableAntiSurvivalService = true;
    private static boolean enableRunningProcessDowngrade = true;
    private static boolean enableReadPhoneStateDowngrade = true;
    private static boolean enableClipboardSuiteUseRule = true;
    private static String timonDyeMark = "";

    private TMEnv() {
    }

    public final boolean getDEBUG() {
        return DEBUG;
    }

    public final void setDEBUG(boolean z) {
        DEBUG = z;
    }

    public final boolean getInitialed() {
        return initialed;
    }

    public final void setInitialed(boolean z) {
        initialed = z;
    }

    public final boolean getBasicModeEnable() {
        return basicModeEnable;
    }

    public final void setBasicModeEnable(boolean z) {
        basicModeEnable = z;
    }

    public final boolean isInitOpt() {
        return isInitOpt;
    }

    public final void setInitOpt(boolean z) {
        isInitOpt = z;
    }

    public final Application getApplication() {
        return application;
    }

    public final void setApplication(Application application2) {
        application = application2;
    }

    public final int getAppId() {
        return appId;
    }

    public final void setAppId(int i) {
        appId = i;
    }

    public final String getChannel() {
        return channel;
    }

    public final void setChannel(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        channel = str;
    }

    public final String getVersionName() {
        return versionName;
    }

    public final void setVersionName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        versionName = str;
    }

    public final long getVersionCode() {
        return versionCode;
    }

    public final void setVersionCode(long j) {
        versionCode = j;
    }

    public final long getUpdateVersionCode() {
        return updateVersionCode;
    }

    public final void setUpdateVersionCode(long j) {
        updateVersionCode = j;
    }

    public final Function0<String> getDidGetter() {
        return didGetter;
    }

    public final void setDidGetter(Function0<String> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
        didGetter = function0;
    }

    public final String getUid() {
        return uid;
    }

    public final void setUid(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        uid = str;
    }

    public final String getSettingFetcherSource() {
        return settingFetcherSource;
    }

    public final void setSettingFetcherSource(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        settingFetcherSource = str;
    }

    public final String getInitThread() {
        return initThread;
    }

    public final void setInitThread(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        initThread = str;
    }

    public final long getInitialTime() {
        return initialTime;
    }

    public final boolean getEnablePipeline() {
        return enablePipeline;
    }

    public final void setEnablePipeline(boolean z) {
        enablePipeline = z;
    }

    public final boolean getRulerHardCodeReady() {
        return rulerHardCodeReady;
    }

    public final void setRulerHardCodeReady(boolean z) {
        rulerHardCodeReady = z;
    }

    public final boolean getEnableHeliosService() {
        return enableHeliosService;
    }

    public final void setEnableHeliosService(boolean z) {
        enableHeliosService = z;
    }

    public final boolean getEnableRulerService() {
        return enableRulerService;
    }

    public final void setEnableRulerService(boolean z) {
        enableRulerService = z;
    }

    public final boolean getEnableBpeaService() {
        return enableBpeaService;
    }

    public final void setEnableBpeaService(boolean z) {
        enableBpeaService = z;
    }

    public final boolean getEnableAntiSurvivalService() {
        return enableAntiSurvivalService;
    }

    public final void setEnableAntiSurvivalService(boolean z) {
        enableAntiSurvivalService = z;
    }

    public final boolean getEnableDelayInit() {
        return enableDelayInit;
    }

    public final void setEnableDelayInit(boolean z) {
        enableDelayInit = z;
    }

    public final boolean getEnableTimonToken() {
        return enableTimonToken;
    }

    public final void setEnableTimonToken(boolean z) {
        enableTimonToken = z;
    }

    public final boolean getEnableProcessLifecycle() {
        return enableProcessLifecycle;
    }

    public final void setEnableProcessLifecycle(boolean z) {
        enableProcessLifecycle = z;
    }

    public final boolean getEnableClipboardCompliance() {
        return enableClipboardCompliance;
    }

    public final void setEnableClipboardCompliance(boolean z) {
        enableClipboardCompliance = z;
    }

    public final boolean getEnableClipboardWindowFocusChecker() {
        return enableClipboardWindowFocusChecker;
    }

    public final void setEnableClipboardWindowFocusChecker(boolean z) {
        enableClipboardWindowFocusChecker = z;
    }

    public final boolean getEnableRunningProcessDowngrade() {
        return enableRunningProcessDowngrade;
    }

    public final void setEnableRunningProcessDowngrade(boolean z) {
        enableRunningProcessDowngrade = z;
    }

    public final boolean getEnableReadPhoneStateDowngrade() {
        return enableReadPhoneStateDowngrade;
    }

    public final void setEnableReadPhoneStateDowngrade(boolean z) {
        enableReadPhoneStateDowngrade = z;
    }

    public final boolean getEnableRulerParamGetEarlier() {
        return enableRulerParamGetEarlier;
    }

    public final void setEnableRulerParamGetEarlier(boolean z) {
        enableRulerParamGetEarlier = z;
    }

    public final boolean getEnableClipboardSuiteUseRule() {
        return enableClipboardSuiteUseRule;
    }

    public final void setEnableClipboardSuiteUseRule(boolean z) {
        enableClipboardSuiteUseRule = z;
    }

    public final boolean getEnableClipboardPermissionDetect() {
        return enableClipboardPermissionDetect;
    }

    public final void setEnableClipboardPermissionDetect(boolean z) {
        enableClipboardPermissionDetect = z;
    }

    public final String getTimonDyeMark() {
        return timonDyeMark;
    }

    public final void setTimonDyeMark(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        timonDyeMark = str;
    }
}
