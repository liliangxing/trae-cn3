package com.bytedance.android.monitorV2.lynx.impl.blank;

import android.view.View;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.executor.HybridMonitorExecutor;
import com.bytedance.android.monitorV2.experiment.HostExperimentManager;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.lynx.blank.LynxBlankDetect;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxBlankData;
import com.bytedance.android.monitorV2.lynx.impl.LynxViewNavigationDataManager;
import com.bytedance.android.monitorV2.lynx.impl.blank.BlankCheckCallbacks;
import com.bytedance.android.monitorV2.lynx.impl.blank.BlankViewRegionChecker;
import com.bytedance.android.monitorV2.util.ConvertUtil;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.Utilities;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ttnet.TTNetInit;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* compiled from: BlankCheckTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0006R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankCheckTask;", "", "navigation", "Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewNavigationDataManager;", "(Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewNavigationDataManager;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkInternal", "", "detectCost", "", "regionChecker", "Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankViewRegionChecker;", "listener", "Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankCheckCallbacks$OnCheckListener;", "start", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/android/monitorV2/lynx/blank/LynxBlankDetect$OnLynxBlankCallback;", "detectFrom", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class BlankCheckTask {
    private final String TAG;
    private final LynxViewNavigationDataManager navigation;

    public BlankCheckTask(LynxViewNavigationDataManager lynxViewNavigationDataManager) {
        Intrinsics.checkNotNullParameter(lynxViewNavigationDataManager, "navigation");
        this.navigation = lynxViewNavigationDataManager;
        this.TAG = "LynxViewBlankChecker";
    }

    public final String getTAG() {
        return this.TAG;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void start(final LynxBlankDetect.OnLynxBlankCallback callback, String detectFrom) {
        String str;
        Field declaredField;
        String str2;
        float f;
        float f2;
        String str3;
        float f3;
        String str4;
        float f4;
        String str5;
        Intrinsics.checkNotNullParameter(detectFrom, "detectFrom");
        final CommonEvent create$default = CommonEvent.Companion.create$default(CommonEvent.INSTANCE, "blank", null, 2, null);
        View hostView = this.navigation.getHostView();
        Intrinsics.checkNotNullExpressionValue(HybridMultiMonitor.getInstance().getHybridSettingManager().getSwitch(), "getInstance().hybridSettingManager.switch");
        if (create$default.terminateIf(!r0.isLynxEnableBlank(), HybridEvent.TerminateType.SWITCH_OFF)) {
            if (hostView != null) {
                if (callback != null) {
                    f4 = 0.0f;
                    str5 = "0";
                    callback.onDetectCost(hostView, "0", 0L, 0L);
                } else {
                    f4 = 0.0f;
                    str5 = "0";
                }
                if (callback != null) {
                    callback.onDetectResult(hostView, str5, f4);
                    return;
                }
                return;
            }
            return;
        }
        if (create$default.terminateIf(!this.navigation.getLynxViewDataManager().getViewConf().getEnableBlankDetect(), HybridEvent.TerminateType.SWITCH_OFF)) {
            if (hostView != null) {
                if (callback != null) {
                    f3 = 0.0f;
                    str4 = "0";
                    callback.onDetectCost(hostView, "0", 0L, 0L);
                } else {
                    f3 = 0.0f;
                    str4 = "0";
                }
                if (callback != null) {
                    callback.onDetectResult(hostView, str4, f3);
                    return;
                }
                return;
            }
            return;
        }
        boolean z = false;
        if (create$default.terminateIf(hostView == null, HybridEvent.TerminateType.HOST_VIEW_DESTROYED)) {
            if (hostView != null) {
                if (callback != null) {
                    f2 = 0.0f;
                    str3 = "0";
                    callback.onDetectCost(hostView, "0", 0L, 0L);
                } else {
                    f2 = 0.0f;
                    str3 = "0";
                }
                if (callback != null) {
                    callback.onDetectResult(hostView, str3, f2);
                    return;
                }
                return;
            }
            return;
        }
        if (hostView == null || hostView.getWidth() == 0 || hostView.getHeight() == 0) {
            create$default.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
            if (hostView != null) {
                if (callback != null) {
                    callback.onDetectCost(hostView, "0", 0L, 0L);
                }
                if (callback != null) {
                    callback.onDetectResult(hostView, "0", 0.0f);
                    return;
                }
                return;
            }
            return;
        }
        if (callback == null && System.currentTimeMillis() - this.navigation.getInitTime() < this.navigation.getBlankConfig().getStayDuration()) {
            create$default.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);
            return;
        }
        String[] urlBlockList = this.navigation.getBlankConfig().getUrlBlockList();
        int length = urlBlockList.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str6 = urlBlockList[i];
            String templateUrl = hostView.getTemplateUrl();
            if (templateUrl == null) {
                templateUrl = "";
            }
            String str7 = templateUrl;
            Intrinsics.checkNotNullExpressionValue(str7, "hostView.templateUrl ?: \"\"");
            if (StringsKt.contains$default(str7, str6, false, 2, (Object) null)) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            create$default.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);
            if (callback != null) {
                str2 = "0";
                f = 0.0f;
                callback.onDetectCost(hostView, "0", 0L, 0L);
            } else {
                str2 = "0";
                f = 0.0f;
            }
            if (callback != null) {
                callback.onDetectResult(hostView, str2, f);
                return;
            }
            return;
        }
        try {
            declaredField = LynxView.class.getDeclaredField("mLynxTemplateRender");
            declaredField.setAccessible(true);
        } catch (Exception e) {
            e = e;
            str = "0";
        }
        if (((LynxTemplateRender) declaredField.get(hostView)) == null) {
            create$default.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
            if (callback != null) {
                str = "0";
                try {
                    callback.onDetectCost(hostView, "0", 0L, 0L);
                } catch (Exception e2) {
                    e = e2;
                    create$default.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
                    ExceptionUtil.handleException(e);
                    if (HostExperimentManager.INSTANCE.getEnablePreSample()) {
                        if (ConvertUtil.isSampleForLynx("blank", this.navigation.getNavigationBidConfig())) {
                        }
                    }
                    BlankViewRegionChecker blankViewRegionChecker = new BlankViewRegionChecker(hostView.getWidth(), hostView.getHeight(), 0, 4, null);
                    long currentTimeMillis = System.currentTimeMillis();
                    BlankViewDetector.INSTANCE.detect(blankViewRegionChecker, hostView);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    final LynxBlankData lynxBlankData = new LynxBlankData();
                    lynxBlankData.setDetectFrom(detectFrom);
                    lynxBlankData.setDetectType(2);
                    lynxBlankData.setHeight(MathKt.roundToInt(hostView.getHeight() / hostView.getResources().getDisplayMetrics().density));
                    lynxBlankData.setWidth(MathKt.roundToInt(hostView.getWidth() / hostView.getResources().getDisplayMetrics().density));
                    lynxBlankData.setAlpha(MathKt.roundToInt(hostView.getAlpha() * 100));
                    final WeakReference weakReference = new WeakReference(hostView);
                    final LynxViewNavigationDataManager lynxViewNavigationDataManager = this.navigation;
                    final long currentTimeMillis3 = System.currentTimeMillis();
                    checkInternal(currentTimeMillis2, blankViewRegionChecker, new BlankCheckCallbacks.OnCheckListener() { // from class: com.bytedance.android.monitorV2.lynx.impl.blank.BlankCheckTask$start$9$1
                        @Override // com.bytedance.android.monitorV2.lynx.impl.blank.BlankCheckCallbacks.OnCheckListener
                        public void onChecked(BlankCheckCallbacks.BlankCheck check) {
                            LynxViewNavigationDataManager lynxViewNavigationDataManager2;
                            LynxViewNavigationDataManager lynxViewNavigationDataManager3;
                            Intrinsics.checkNotNullParameter(check, "check");
                            LynxBlankData.this.setEffectivePercentage(check.getCheckResult().getEffectiveAreaRatio());
                            LynxBlankData.this.setElementCount(check.getCheckResult().getValidViewCount());
                            Utilities utilities = Utilities.INSTANCE;
                            LynxBlankData lynxBlankData2 = LynxBlankData.this;
                            try {
                                lynxBlankData2.setHttpRttMs(TTNetInit.getNetworkQuality().httpRttMs);
                                lynxBlankData2.setTransportRttMs(TTNetInit.getNetworkQuality().transportRttMs);
                            } catch (Throwable th) {
                                ExceptionUtil.handleException(th);
                            }
                            LynxBlankData.this.setMaxBlankRectRadio(check.getCheckResult().getMaxBlankAreaRatio());
                            LynxBlankData.this.setLoadState(lynxViewNavigationDataManager.getLifecycle().getLoadState());
                            LynxBlankData.this.setCostTime(System.currentTimeMillis() - currentTimeMillis3);
                            LynxBlankData.this.setCollectTime(check.getDetectElapse());
                            LynxBlankData.this.setCalculateTime(check.getCheckElapse());
                            LynxBlankData.this.setEnterPageTime(lynxViewNavigationDataManager.getInitTime());
                            LynxBlankData.this.setDetectStartTime(currentTimeMillis3);
                            if (Switches.blankBitmap.isEnabled()) {
                                LynxBlankData.this.setBitmap(check.getCheckResult().getBlankBitmap());
                                LynxBlankData.this.setBitmapWidth(check.getCheckResult().getBlankBitmapWidth());
                                LynxBlankData.this.setBitmapHeight(check.getCheckResult().getBlankBitmapHeight());
                            }
                            LynxBlankData.this.setAllElements(check.getCheckResult().getElements());
                            LynxBlankData.this.setValidElements(check.getCheckResult().getValidElements());
                            LynxBlankData.this.setValidChildNode(check.getCheckResult().getValidChildNode());
                            create$default.setNativeInfo(LynxBlankData.this);
                            String tag = this.getTAG();
                            StringBuilder sb = new StringBuilder("handleBlankDetect: session: ");
                            lynxViewNavigationDataManager2 = this.navigation;
                            MonitorLog.m29i(tag, sb.append(lynxViewNavigationDataManager2.getMonitorId()).append(", effectivePercentage: ").append(LynxBlankData.this.getEffectivePercentage()).append(", height: ").append(LynxBlankData.this.getHeight()).append(", width: ").append(LynxBlankData.this.getWidth()).append(", alpha: ").append(LynxBlankData.this.getAlpha()).append(", elementCount: ").append(LynxBlankData.this.getElementCount()).toString());
                            lynxViewNavigationDataManager3 = this.navigation;
                            lynxViewNavigationDataManager3.reportBlank(create$default);
                            View view = (LynxView) weakReference.get();
                            if (view != null) {
                                LynxViewNavigationDataManager lynxViewNavigationDataManager4 = lynxViewNavigationDataManager;
                                LynxBlankDetect.OnLynxBlankCallback onLynxBlankCallback = callback;
                                LynxBlankData lynxBlankData3 = LynxBlankData.this;
                                LynxBlankDetect.OnLynxBlankCallback blankDetectCallback = lynxViewNavigationDataManager4.getLynxViewDataManager().getViewConf().getBlankDetectCallback();
                                if (blankDetectCallback != null) {
                                    View view2 = view;
                                    blankDetectCallback.onDetectCost(view2, "", check.getDetectElapse(), check.getCheckElapse());
                                    blankDetectCallback.onDetectResult(view2, "", lynxBlankData3.getEffectivePercentage());
                                }
                                if (onLynxBlankCallback != null) {
                                    onLynxBlankCallback.onDetectCost(view, "1", check.getDetectElapse(), check.getCheckElapse());
                                }
                                if (onLynxBlankCallback != null) {
                                    onLynxBlankCallback.onDetectResult(view, "1", lynxBlankData3.getEffectivePercentage());
                                }
                            }
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("effective_percentage", Integer.valueOf((int) (check.getCheckResult().getEffectiveAreaRatio() * 10000)));
                            InternalWatcher.notice$default(InternalWatcher.INSTANCE, lynxViewNavigationDataManager.getNaviId(), InternalWatcher.EVENT_BLANK_RESULT, null, linkedHashMap, 4, null);
                        }
                    });
                }
            } else {
                str = "0";
            }
            if (callback != null) {
                callback.onDetectResult(hostView, str, 0.0f);
                return;
            }
            return;
        }
        str = "0";
        if (HostExperimentManager.INSTANCE.getEnablePreSample() && this.navigation.getBidExactly() && !Intrinsics.areEqual(this.navigation.getNavigationBid(), BidInfo.DEFAULT)) {
            if (ConvertUtil.isSampleForLynx("blank", this.navigation.getNavigationBidConfig())) {
                create$default.onEventSampled();
                if (callback != null) {
                    callback.onDetectCost(hostView, "0", 0L, 0L);
                }
                if (callback != null) {
                    callback.onDetectResult(hostView, str, 0.0f);
                }
                MonitorLog.m29i(this.TAG, "WebView blank detect canceled due to sampling");
                return;
            }
            create$default.setHitSample(true);
        }
        BlankViewRegionChecker blankViewRegionChecker2 = new BlankViewRegionChecker(hostView.getWidth(), hostView.getHeight(), 0, 4, null);
        long currentTimeMillis4 = System.currentTimeMillis();
        BlankViewDetector.INSTANCE.detect(blankViewRegionChecker2, hostView);
        long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis4;
        final LynxBlankData lynxBlankData2 = new LynxBlankData();
        lynxBlankData2.setDetectFrom(detectFrom);
        lynxBlankData2.setDetectType(2);
        lynxBlankData2.setHeight(MathKt.roundToInt(hostView.getHeight() / hostView.getResources().getDisplayMetrics().density));
        lynxBlankData2.setWidth(MathKt.roundToInt(hostView.getWidth() / hostView.getResources().getDisplayMetrics().density));
        lynxBlankData2.setAlpha(MathKt.roundToInt(hostView.getAlpha() * 100));
        final WeakReference<LynxView> weakReference2 = new WeakReference(hostView);
        final LynxViewNavigationDataManager lynxViewNavigationDataManager2 = this.navigation;
        final long currentTimeMillis32 = System.currentTimeMillis();
        checkInternal(currentTimeMillis22, blankViewRegionChecker2, new BlankCheckCallbacks.OnCheckListener() { // from class: com.bytedance.android.monitorV2.lynx.impl.blank.BlankCheckTask$start$9$1
            @Override // com.bytedance.android.monitorV2.lynx.impl.blank.BlankCheckCallbacks.OnCheckListener
            public void onChecked(BlankCheckCallbacks.BlankCheck check) {
                LynxViewNavigationDataManager lynxViewNavigationDataManager22;
                LynxViewNavigationDataManager lynxViewNavigationDataManager3;
                Intrinsics.checkNotNullParameter(check, "check");
                LynxBlankData.this.setEffectivePercentage(check.getCheckResult().getEffectiveAreaRatio());
                LynxBlankData.this.setElementCount(check.getCheckResult().getValidViewCount());
                Utilities utilities = Utilities.INSTANCE;
                LynxBlankData lynxBlankData22 = LynxBlankData.this;
                try {
                    lynxBlankData22.setHttpRttMs(TTNetInit.getNetworkQuality().httpRttMs);
                    lynxBlankData22.setTransportRttMs(TTNetInit.getNetworkQuality().transportRttMs);
                } catch (Throwable th) {
                    ExceptionUtil.handleException(th);
                }
                LynxBlankData.this.setMaxBlankRectRadio(check.getCheckResult().getMaxBlankAreaRatio());
                LynxBlankData.this.setLoadState(lynxViewNavigationDataManager2.getLifecycle().getLoadState());
                LynxBlankData.this.setCostTime(System.currentTimeMillis() - currentTimeMillis32);
                LynxBlankData.this.setCollectTime(check.getDetectElapse());
                LynxBlankData.this.setCalculateTime(check.getCheckElapse());
                LynxBlankData.this.setEnterPageTime(lynxViewNavigationDataManager2.getInitTime());
                LynxBlankData.this.setDetectStartTime(currentTimeMillis32);
                if (Switches.blankBitmap.isEnabled()) {
                    LynxBlankData.this.setBitmap(check.getCheckResult().getBlankBitmap());
                    LynxBlankData.this.setBitmapWidth(check.getCheckResult().getBlankBitmapWidth());
                    LynxBlankData.this.setBitmapHeight(check.getCheckResult().getBlankBitmapHeight());
                }
                LynxBlankData.this.setAllElements(check.getCheckResult().getElements());
                LynxBlankData.this.setValidElements(check.getCheckResult().getValidElements());
                LynxBlankData.this.setValidChildNode(check.getCheckResult().getValidChildNode());
                create$default.setNativeInfo(LynxBlankData.this);
                String tag = this.getTAG();
                StringBuilder sb = new StringBuilder("handleBlankDetect: session: ");
                lynxViewNavigationDataManager22 = this.navigation;
                MonitorLog.m29i(tag, sb.append(lynxViewNavigationDataManager22.getMonitorId()).append(", effectivePercentage: ").append(LynxBlankData.this.getEffectivePercentage()).append(", height: ").append(LynxBlankData.this.getHeight()).append(", width: ").append(LynxBlankData.this.getWidth()).append(", alpha: ").append(LynxBlankData.this.getAlpha()).append(", elementCount: ").append(LynxBlankData.this.getElementCount()).toString());
                lynxViewNavigationDataManager3 = this.navigation;
                lynxViewNavigationDataManager3.reportBlank(create$default);
                View view = (LynxView) weakReference2.get();
                if (view != null) {
                    LynxViewNavigationDataManager lynxViewNavigationDataManager4 = lynxViewNavigationDataManager2;
                    LynxBlankDetect.OnLynxBlankCallback onLynxBlankCallback = callback;
                    LynxBlankData lynxBlankData3 = LynxBlankData.this;
                    LynxBlankDetect.OnLynxBlankCallback blankDetectCallback = lynxViewNavigationDataManager4.getLynxViewDataManager().getViewConf().getBlankDetectCallback();
                    if (blankDetectCallback != null) {
                        View view2 = view;
                        blankDetectCallback.onDetectCost(view2, "", check.getDetectElapse(), check.getCheckElapse());
                        blankDetectCallback.onDetectResult(view2, "", lynxBlankData3.getEffectivePercentage());
                    }
                    if (onLynxBlankCallback != null) {
                        onLynxBlankCallback.onDetectCost(view, "1", check.getDetectElapse(), check.getCheckElapse());
                    }
                    if (onLynxBlankCallback != null) {
                        onLynxBlankCallback.onDetectResult(view, "1", lynxBlankData3.getEffectivePercentage());
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("effective_percentage", Integer.valueOf((int) (check.getCheckResult().getEffectiveAreaRatio() * 10000)));
                InternalWatcher.notice$default(InternalWatcher.INSTANCE, lynxViewNavigationDataManager2.getNaviId(), InternalWatcher.EVENT_BLANK_RESULT, null, linkedHashMap, 4, null);
            }
        });
    }

    private final void checkInternal(final long detectCost, final BlankViewRegionChecker regionChecker, final BlankCheckCallbacks.OnCheckListener listener) {
        HybridMonitorExecutor.INSTANCE.post(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.blank.BlankCheckTask$checkInternal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m371invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m371invoke() {
                long currentTimeMillis = System.currentTimeMillis();
                BlankViewRegionChecker.CheckResult check = BlankViewRegionChecker.this.check();
                listener.onChecked(new BlankCheckCallbacks.BlankCheck(detectCost, System.currentTimeMillis() - currentTimeMillis, check));
            }
        });
    }
}
