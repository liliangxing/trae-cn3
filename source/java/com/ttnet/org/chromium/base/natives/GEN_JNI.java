package com.ttnet.org.chromium.base.natives;

import J.N;

/* loaded from: classes7.dex */
public class GEN_JNI {
    public static final boolean REQUIRE_MOCK = false;
    public static final boolean TESTING_ENABLED = false;

    public static void com_ttnet_org_chromium_base_ApplicationStatus_onApplicationStateChange(int i) {
        N.M$lotPPc(i);
    }

    public static boolean com_ttnet_org_chromium_base_BaseFeatureList_isEnabled(String str) {
        return N.Mtllg_IO(str);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_init(String[] strArr) {
        N.MZSU27YP(strArr);
    }

    public static boolean com_ttnet_org_chromium_base_CommandLine_hasSwitch(String str) {
        return N.MhlgTxh2(str);
    }

    public static String com_ttnet_org_chromium_base_CommandLine_getSwitchValue(String str) {
        return N.MaCXZYAa(str);
    }

    public static String[] com_ttnet_org_chromium_base_CommandLine_getSwitchesFlattened() {
        return N.MahsXrQs();
    }

    public static void com_ttnet_org_chromium_base_CommandLine_appendSwitch(String str) {
        N.MawtMrJF(str);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_appendSwitchWithValue(String str, String str2) {
        N.MIZelAXD(str, str2);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_appendSwitchesAndArguments(String[] strArr) {
        N.MjOVh1Zv(strArr);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_removeSwitch(String str) {
        N.MP5WQt3J(str);
    }

    public static int com_ttnet_org_chromium_base_CpuFeatures_getCoreCount() {
        return N.Mcaj_8qf();
    }

    public static long com_ttnet_org_chromium_base_CpuFeatures_getCpuFeatures() {
        return N.M1UV95tj();
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyBeginEvent(String str, long j, int i, long j2) {
        N.MCawLSFP(str, j, i, j2);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyEndEvent(String str, long j, int i, long j2) {
        N.MvvW3g4w(str, j, i, j2);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyToplevelBeginEvent(String str, long j, int i, long j2) {
        N.MjWH5Jmd(str, j, i, j2);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyToplevelEndEvent(String str, long j, int i, long j2) {
        N.MoB6dYvZ(str, j, i, j2);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyAsyncBeginEvent(String str, long j, long j2) {
        N.M88o6Bs3(str, j, j2);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyAsyncEndEvent(String str, long j, long j2) {
        N.MohIB14s(str, j, j2);
    }

    public static boolean com_ttnet_org_chromium_base_FeatureList_isInitialized() {
        return N.Md1lGM43();
    }

    public static boolean com_ttnet_org_chromium_base_Features_isEnabled(long j) {
        return N.MoITUwC2(j);
    }

    public static boolean com_ttnet_org_chromium_base_Features_getFieldTrialParamByFeatureAsBoolean(long j, String str, boolean z) {
        return N.MiTw3O_J(j, str, z);
    }

    public static String com_ttnet_org_chromium_base_FieldTrialList_findFullName(String str) {
        return N.MfcktC_e(str);
    }

    public static boolean com_ttnet_org_chromium_base_FieldTrialList_trialExists(String str) {
        return N.MBEGQVWX(str);
    }

    public static String com_ttnet_org_chromium_base_FieldTrialList_getVariationParameter(String str, String str2) {
        return N.Msd5Ns7Y(str, str2);
    }

    public static void com_ttnet_org_chromium_base_FieldTrialList_logActiveTrials() {
        N.M2n_z3BB();
    }

    public static boolean com_ttnet_org_chromium_base_FieldTrialList_createFieldTrial(String str, String str2) {
        return N.MzhBrODy(str, str2);
    }

    public static String com_ttnet_org_chromium_base_FileUtils_getAbsoluteFilePath(String str) {
        return N.MKMoqNq6(str);
    }

    public static boolean com_ttnet_org_chromium_base_ImportantFileWriterAndroid_writeFileAtomically(String str, byte[] bArr) {
        return N.M1jycjxU(str, bArr);
    }

    public static void com_ttnet_org_chromium_base_JavaExceptionReporter_reportJavaException(boolean z, Throwable th) {
        N.M9gfm$zh(z, th);
    }

    public static void com_ttnet_org_chromium_base_JavaExceptionReporter_reportJavaStackTrace(String str) {
        N.MuvJZ5jK(str);
    }

    public static void com_ttnet_org_chromium_base_JavaHandlerThread_initializeThread(long j, long j2) {
        N.M3RaWo13(j, j2);
    }

    public static void com_ttnet_org_chromium_base_JavaHandlerThread_onLooperStopped(long j) {
        N.MSKUcgE4(j);
    }

    public static void com_ttnet_org_chromium_base_PathService_override(int i, String str) {
        N.MvMFfChw(i, str);
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onBatteryChargingChanged() {
        N.MxETr4iO();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onSuspend() {
        N.MBffe1lF();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onResume() {
        N.MyS7kauI();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onInstantSuspend() {
        N.MolcG1Wq();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onInstantResume() {
        N.MELAwTDU();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onThermalStatusChanged(int i) {
        N.MuSEGQ9M(i);
    }

    public static void com_ttnet_org_chromium_base_SysUtils_logPageFaultCountToTracing() {
        N.Mm3sCch3();
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_registerEnabledObserver() {
        N.M8F7L$JR();
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_startATrace(String str) {
        N.MiUfkLIq(str);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_stopATrace() {
        N.MTnadCLu();
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_setupATraceStartupTrace(String str) {
        N.M8MvK2gp(str);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_instant(String str, String str2) {
        N.Mz5qii_R(str, str2);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_begin(String str, String str2) {
        N.MajVTFsV(str, str2);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_end(String str, String str2) {
        N.M5yUVmrW(str, str2);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_beginToplevel(String str) {
        N.MljCyOuh(str);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_endToplevel(String str) {
        N.M6R6NWXS(str);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_startAsync(String str, long j) {
        N.MKlPFTpb(str, j);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_finishAsync(String str, long j) {
        N.MjXrJVoa(str, j);
    }

    public static boolean com_ttnet_org_chromium_base_TraceEvent_viewHierarchyDumpEnabled() {
        return N.MpI7Xy5x();
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_initViewHierarchyDump() {
        N.MgOuiubc();
    }

    public static long com_ttnet_org_chromium_base_TraceEvent_startActivityDump(String str, long j) {
        return N.MgxFMA1H(str, j);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_addViewDump(int i, int i2, boolean z, boolean z2, String str, String str2, long j) {
        N.MxGy3cn_(i, i2, z, z2, str, str2, j);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_instantAndroidIPC(String str, long j) {
        N.MMXoiNW_(str, j);
    }

    public static void com_ttnet_org_chromium_base_jank_1tracker_JankMetricUMARecorder_recordJankMetrics(String str, long[] jArr, long[] jArr2, long[] jArr3, int i) {
        N.Mw$h3q2i(str, jArr, jArr2, jArr3, i);
    }

    public static boolean com_ttnet_org_chromium_base_library_1loader_LibraryLoader_libraryLoaded(int i) {
        return N.MnwWsRxg(i);
    }

    public static void com_ttnet_org_chromium_base_library_1loader_LibraryLoader_registerNonMainDexJni() {
        N.MU8nwPRG();
    }

    public static void com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_forkAndPrefetchNativeLibrary() {
        N.MVIMN27T();
    }

    public static int com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_percentageOfResidentNativeLibraryCode() {
        return N.MA6QAXj_();
    }

    public static void com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_periodicallyCollectResidency() {
        N.MtuV2SWL();
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordBooleanHistogram(String str, long j, boolean z) {
        return N.MYPj82kt(str, j, z);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordExponentialHistogram(String str, long j, int i, int i2, int i3, int i4) {
        return N.M45N7QIN(str, j, i, i2, i3, i4);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordLinearHistogram(String str, long j, int i, int i2, int i3, int i4) {
        return N.Mx1k0LvC(str, j, i, i2, i3, i4);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordSparseHistogram(String str, long j, int i) {
        return N.MV$7$UuP(str, j, i);
    }

    public static void com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordUserAction(String str, long j) {
        N.MxViw_go(str, j);
    }

    public static int com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramValueCountForTesting(String str, int i, long j) {
        return N.MkFXHbyW_ForTesting(str, i, j);
    }

    public static int com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramTotalCountForTesting(String str, long j) {
        return N.M7NlTYxi_ForTesting(str, j);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_createHistogramSnapshotForTesting() {
        return N.M_034fMZ_ForTesting();
    }

    public static void com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_destroyHistogramSnapshotForTesting(long j) {
        N.Me95ZC6G_ForTesting(j);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_addActionCallbackForTesting(Object obj) {
        return N.MDoBOCZO_ForTesting(obj);
    }

    public static void com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_removeActionCallbackForTesting(long j) {
        N.MYkUp9vo_ForTesting(j);
    }

    public static String com_ttnet_org_chromium_base_metrics_StatisticsRecorderAndroid_toJson(int i) {
        return N.M5gAmtvn(i);
    }

    public static void com_ttnet_org_chromium_base_task_PostTask_postDelayedTask(int i, boolean z, boolean z2, byte b, byte[] bArr, Object obj, long j, String str) {
        N.Mwr17eXX(i, z, z2, b, bArr, obj, j, str);
    }

    public static long com_ttnet_org_chromium_base_task_TaskRunnerImpl_init(int i, int i2, boolean z, boolean z2, byte b, byte[] bArr) {
        return N.MLtH82Um(i, i2, z, z2, b, bArr);
    }

    public static void com_ttnet_org_chromium_base_task_TaskRunnerImpl_destroy(long j) {
        N.Mvd960xb(j);
    }

    public static void com_ttnet_org_chromium_base_task_TaskRunnerImpl_postDelayedTask(long j, Object obj, long j2, String str) {
        N.MJ_h_2p2(j, obj, j2, str);
    }

    public static boolean com_ttnet_org_chromium_base_task_TaskRunnerImpl_belongsToCurrentThread(long j) {
        return N.Mz$BG_4y(j);
    }

    public static void com_ttnet_org_chromium_net_AndroidNetworkLibrary_onCellularAlwaysUp(boolean z, int i) {
        N.MeYG7FqD(z, i);
    }

    public static String com_ttnet_org_chromium_net_GURLUtils_getOrigin(String str) {
        return N.McGsvqvj(str);
    }

    public static void com_ttnet_org_chromium_net_HttpNegotiateAuthenticator_setResult(long j, Object obj, int i, String str) {
        N.MsAf1sYp(j, obj, i, str);
    }

    public static boolean com_ttnet_org_chromium_net_HttpUtil_isAllowedHeader(String str, String str2) {
        return N.MsTaj7yX(str, str2);
    }

    public static void com_ttnet_org_chromium_net_NetworkActiveNotifier_notifyOfDefaultNetworkActive(long j) {
        N.M5aI8A5Z(j);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyConnectionTypeChanged(long j, Object obj, int i, long j2) {
        N.MjJzrRFH(j, obj, i, j2);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyConnectionCostChanged(long j, Object obj, int i) {
        N.MZnuk2LK(j, obj, i);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyMaxBandwidthChanged(long j, Object obj, int i) {
        N.MqNJnYjG(j, obj, i);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkConnect(long j, Object obj, long j2, boolean z, int i) {
        N.MZ5e75rQ(j, obj, j2, z, i);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkSoonToDisconnect(long j, Object obj, long j2) {
        N.MssT8yD3(j, obj, j2);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkDisconnect(long j, Object obj, boolean z, long j2) {
        N.Ms7JLaGI(j, obj, z, j2);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyPurgeActiveNetworkList(long j, Object obj, long[] jArr) {
        N.Mvng38R0(j, obj, jArr);
    }

    public static void com_ttnet_org_chromium_net_ProxyChangeListener_proxySettingsChangedTo(long j, Object obj, String str, int i, String str2, String[] strArr) {
        N.MtXZ30qk(j, obj, str, i, str2, strArr);
    }

    public static void com_ttnet_org_chromium_net_ProxyChangeListener_proxySettingsChanged(long j, Object obj) {
        N.MKwsFZ4t(j, obj);
    }

    public static boolean com_ttnet_org_chromium_net_TTAppSecurityManager_isUserPrivacyRestrictionEnabled() {
        return N.MaSRwBiO();
    }

    public static boolean com_ttnet_org_chromium_net_TTAppSecurityManager_isTTPRestrictionEnabled() {
        return N.Mhd7DRFo();
    }

    public static void com_ttnet_org_chromium_net_TTSocketAccelerate_OnCheckSystemAvailableResult(long j, Object obj, int i) {
        N.MXvQH$ie(j, obj, i);
    }

    public static void com_ttnet_org_chromium_net_TTSocketAccelerate_OnNotifyAccelerateResult(long j, Object obj, int i, int i2) {
        N.MOfWrYJI(j, obj, i, i2);
    }

    public static void com_ttnet_org_chromium_net_X509Util_notifyKeyChainChanged() {
        N.MzV1TXLS();
    }

    public static long com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_createBidirectionalStream(Object obj, long j, boolean z, boolean z2, int i, boolean z3, int i2, long j2) {
        return N.MSnVviPU(obj, j, z, z2, i, z3, i2, j2);
    }

    public static int com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_start(long j, Object obj, String str, int i, String str2, String[] strArr, boolean z) {
        return N.MycrIbGr(j, obj, str, i, str2, strArr, z);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_sendRequestHeaders(long j, Object obj) {
        N.MhETl_ev(j, obj);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_readData(long j, Object obj, Object obj2, int i, int i2) {
        return N.M21CWxxV(j, obj, obj2, i, i2);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_writevData(long j, Object obj, Object[] objArr, int[] iArr, int[] iArr2, boolean z) {
        return N.MYRRygif(j, obj, objArr, iArr, iArr2, z);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_destroy(long j, Object obj, boolean z) {
        N.My0p82p4(j, obj, z);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetFrontierClient_createFrontierClientAdapter(Object obj) {
        return N.MagNlhNv(obj);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_addHeader(long j, Object obj, String str, String str2) {
        N.MwZrRAIG(j, obj, str, str2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_addServiceId(long j, Object obj, int i) {
        N.Msf3H5kQ(j, obj, i);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_configParams(long j, Object obj, int i, int i2, String str, int i3, String str2, String str3, String str4, String str5, int i4, int i5, int i6, boolean z, String str6, String str7) {
        N.Mhk1t9AY(j, obj, i, i2, str, i3, str2, str3, str4, str5, i4, i5, i6, z, str6, str7);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_registerService(long j, Object obj, String[] strArr, Object obj2, int i, int i2, boolean z) {
        N.MKu8Zh_d(j, obj, strArr, obj2, i, i2, z);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_unregisterService(long j, Object obj, int i) {
        N.M4rPfgYd(j, obj, i);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetFrontierClient_isServiceReady(long j, Object obj, int i) {
        return N.My_P9YPg(j, obj, i);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_sendMessage(long j, Object obj, int i, String[] strArr, Object obj2) {
        N.MKYiSehZ(j, obj, i, strArr, obj2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_reportAppStateChange(long j, Object obj, boolean z) {
        N.MlH8$Rpg(j, obj, z);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_destroy(long j, Object obj) {
        N.MKRYs$fc(j, obj);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetLibraryLoader_cronetInitOnInitThread() {
        N.MyweRqSS();
    }

    public static String com_ttnet_org_chromium_net_impl_CronetLibraryLoader_getCronetVersion() {
        return N.MVlvYo_c();
    }

    public static void com_ttnet_org_chromium_net_impl_CronetLibraryLoader_createNetworkChangeNotifierOnInitThread() {
        N.MhrJ$_b0();
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUploadDataStream_attachUploadDataToRequest(Object obj, long j, long j2) {
        return N.M89UGLMC(obj, j, j2);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUploadDataStream_createAdapterForTesting(Object obj) {
        return N.M3b_yKC0_ForTesting(obj);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUploadDataStream_createUploadDataStreamForTesting(Object obj, long j, long j2) {
        return N.MKATyFlf_ForTesting(obj, j, j2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUploadDataStream_onReadSucceeded(long j, Object obj, int i, boolean z) {
        N.MYsxiVBk(j, obj, i, z);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUploadDataStream_onRewindSucceeded(long j, Object obj) {
        N.M3Tck9nA(j, obj);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUploadDataStream_destroy(long j) {
        N.Mx3T_YwB(j);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUrlRequest_createRequestAdapter(Object obj, long j, String str, int i, int i2, boolean z, boolean z2, boolean z3, int i3, boolean z4, int i4, int i5, long j2) {
        return N.MnXVOzVo(obj, j, str, i, i2, z, z2, z3, i3, z4, i4, i5, j2);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequest_setHttpMethod(long j, Object obj, String str) {
        return N.MfdvbiJC(j, obj, str);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequest_addRequestHeader(long j, Object obj, String str, String str2) {
        return N.MtJFji5x(j, obj, str, str2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_start(long j, Object obj) {
        N.Mv2a151P(j, obj);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_followDeferredRedirect(long j, Object obj) {
        N.MhCyx70S(j, obj);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequest_readData(long j, Object obj, Object obj2, int i, int i2) {
        return N.MJbYA4in(j, obj, obj2, i, i2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_destroy(long j, Object obj, boolean z) {
        N.MIb9tt7_(j, obj, z);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_appTimeout(long j, Object obj) {
        N.M3xsE8SK(j, obj);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_abortWhenUploadException(long j, Object obj) {
        N.MzKjGz9N(j, obj);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_addRequestCookieHeader(long j, Object obj, String str, String str2) {
        N.M2jrbUOP(j, obj, str, str2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_removeRequestCookieHeader(long j, Object obj) {
        N.MjbEhTZs(j, obj);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setSocketTimeout(long j, Object obj, int i, int i2, int i3) {
        N.M4C6WZaz(j, obj, i, i2, i3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setRequestTimeout(long j, Object obj, int i) {
        N.MaFGwSbC(j, obj, i);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setThrottleNetSpeed(long j, Object obj, long j2) {
        N.ML2WrLQ6(j, obj, j2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setRequestTypeFlags(long j, Object obj, int i) {
        N.MC7pScOk(j, obj, i);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setAuthCredentials(long j, Object obj, String str, String str2) {
        N.Mor7A21H(j, obj, str, str2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_getStatus(long j, Object obj, Object obj2) {
        N.MmSvKAJE(j, obj, obj2);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_createRequestContextConfig(String str, String str2, boolean z, String str3, boolean z2, boolean z3, boolean z4, int i, long j, String str4, long j2, boolean z5, boolean z6, int i2) {
        return N.Mmo_MQVE(str, str2, z, str3, z2, z3, z4, i, j, str4, j2, z5, z6, i2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addQuicHint(long j, String str, int i, int i2) {
        N.M6WZ7Wt0(j, str, i, i2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addPkp(long j, String str, byte[][] bArr, boolean z, long j2) {
        N.Mkx3KULb(j, str, bArr, z, j2);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_createRequestContextAdapter(long j) {
        return N.MuixiOYs(j);
    }

    public static int com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setMinLogLevel(int i) {
        return N.MyyJ5zsH(i);
    }

    public static byte[] com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_getHistogramDeltas() {
        return N.MdOiNSC0();
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_destroy(long j, Object obj) {
        N.MG$DT18r(j, obj);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startNetLogToFile(long j, Object obj, String str, boolean z) {
        return N.Mt89JXhb(j, obj, str, z);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startNetLogToDisk(long j, Object obj, String str, boolean z, int i) {
        N.MuR7zLrb(j, obj, str, z, i);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_stopNetLog(long j, Object obj) {
        N.ML5dVOOG(j, obj);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_initRequestContextOnInitThread(long j, Object obj) {
        N.Mdu$OLLN(j, obj);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_configureNetworkQualityEstimatorForTesting(long j, Object obj, boolean z, boolean z2, boolean z3) {
        N.MNAF9eXw_ForTesting(j, obj, z, z2, z3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_provideRTTObservations(long j, Object obj, boolean z) {
        N.Mk1UqBGq(j, obj, z);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setTTNetInitConfig(long j, int i, boolean z, boolean z2, String str, String str2, String str3, boolean z3, String str4, String str5, byte[][] bArr, Object[] objArr, boolean z4, boolean z5, boolean z6, String str6, Object obj, long j2, boolean z7, boolean z8, boolean z9, Object obj2, boolean z10, String str7) {
        N.MawZO189(j, i, z, z2, str, str2, str3, z3, str4, str5, bArr, objArr, z4, z5, z6, str6, obj, j2, z7, z8, z9, obj2, z10, str7);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setClientOpaqueData(long j, String[] strArr, byte[] bArr, byte[] bArr2) {
        N.MTZ7mkhc(j, strArr, bArr, bArr2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_initALogFuncAddr(long j) {
        N.MjS9m1YQ(j);
    }

    public static long[] com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_getOpaqueFuncAddress() {
        return N.MlOQJZ8w();
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_parseTNCConfigFromSystemHTTPRequest(long j, Object obj, String str, String str2, String str3, String str4, String str5, String str6) {
        N.MU6k4d25(j, obj, str, str2, str3, str4, str5, str6);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_triggerTNCRequestByUser(long j, Object obj, boolean z) {
        N.MN8yyQkr(j, obj, z);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_ttUrlDispatch(long j, Object obj, Object obj2, String str, boolean z) {
        N.MRTGlzo1(j, obj, obj2, str, z);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_runInBackGround(long j, Object obj, boolean z) {
        N.MWOUQ7KG(j, obj, z);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addClientOpaqueData(long j, Object obj, String[] strArr, byte[] bArr, byte[] bArr2, long j2, long j3) {
        N.MWb1lJ5e(j, obj, strArr, bArr, bArr2, j2, j3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_clearClientOpaqueData(long j, Object obj) {
        N.MK0SE_Ub(j, obj);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_removeClientOpaqueData(long j, Object obj, String str) {
        N.Mcfn2q8$(j, obj, str);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setProxy(long j, Object obj, String str) {
        N.Mj4Pi_Pa(j, obj, str);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_preconnectUrl(long j, Object obj, String str, int i, String str2) {
        N.MBtj30QU(j, obj, str, i, str2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_ttDnsResolve(long j, Object obj, String str, int i, String str2, String str3) {
        N.MH0muaR3(j, obj, str, i, str2, str3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_controlHttpDNSConfig(long j, Object obj, boolean z, boolean z2, boolean z3) {
        N.MHps7uOC(j, obj, z, z2, z3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setHostResolverRules(long j, Object obj, String str) {
        N.MlH1XMiR(j, obj, str);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addSamplingSetting(long j, Object obj, Object obj2) {
        N.MKYzOUkj(j, obj, obj2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_tryStartNetDetect(long j, Object obj, String[] strArr, int i, int i2) {
        N.MA5SsGAv(j, obj, strArr, i, i2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_updateStoreRegionFromServer(long j, Object obj, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        N.MqjX8qD1(j, obj, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setAlogFuncAddr(long j, Object obj, long j2) {
        N.Me3xdZoU(j, obj, j2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setZstdFuncAddr(long j, Object obj, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
        N.MIs1FVFz(j, obj, j2, j3, j4, j5, j6, j7, j8, j9);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setRouteSelectionBestHost(long j, Object obj, String str, String str2) {
        N.MhbNiNFL(j, obj, str, str2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startThrottle(long j, Object obj, String[] strArr, int i, long j2) {
        N.MiGn0DCY(j, obj, strArr, i, j2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_stopThrottle(long j, Object obj, String[] strArr, int i) {
        N.MohL$06P(j, obj, strArr, i);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_enableTTBizHttpDns(long j, Object obj, boolean z, String str, String str2, String str3, boolean z2, String str4) {
        N.M2ni33Tk(j, obj, z, str, str2, str3, z2, str4);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setAppStartUpState(long j, Object obj, int i) {
        N.MksRT8QX(j, obj, i);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setCookieInitCompleted(long j, Object obj) {
        N.MaSOyuXL(j, obj);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_reportNetDiagnosisUserLog(long j, Object obj, String str) {
        N.MPONMQm_(j, obj, str);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_provideThroughputObservations(long j, Object obj, boolean z) {
        N.MHUcn7PP(j, obj, z);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_skipLogging(long j, Object obj) {
        return N.MLLAskZ0(j, obj);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_createWebsocketConnectionAdapter(Object obj, long j) {
        return N.MRAGjNeT(obj, j);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithFrontier(long j, Object obj, int i, String str, long j2, int i2, long j3, String str2, int i3, String str3, boolean z) {
        N.MWq0tMul(j, obj, i, str, j2, i2, j3, str2, i3, str3, z);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithWSChannel(long j, Object obj, boolean z) {
        N.MVrBbeuj(j, obj, z);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_stop(long j, Object obj) {
        N.M14GZgiH(j, obj);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendText(long j, Object obj, String str) {
        N.MRnDfpSi(j, obj, str);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendBinary(long j, Object obj, Object obj2) {
        N.MRfZ_7V_(j, obj, obj2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_destroy(long j, Object obj) {
        N.MCzpxGQD(j, obj);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addUrl(long j, Object obj, String str) {
        N.MgN9hn8A(j, obj, str);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addHeader(long j, Object obj, String str, String str2) {
        N.MKmGe$35(j, obj, str, str2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addGetParam(long j, Object obj, String str, String str2) {
        N.Mzisx1kZ(j, obj, str, str2);
    }

    public static long com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_createRequestAdapter(Object obj, long j, int i, String[] strArr, int i2, int i3, int i4) {
        return N.MPJAsrFC(obj, j, i, strArr, i2, i3, i4);
    }

    public static void com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_start(long j, Object obj) {
        N.MLiR9ZbW(j, obj);
    }

    public static void com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_destroy(long j, Object obj) {
        N.M6$xRvea(j, obj);
    }

    public static void com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_doExtraCommand(long j, Object obj, String str, String str2) {
        N.MDZjmtTn(j, obj, str, str2);
    }
}
