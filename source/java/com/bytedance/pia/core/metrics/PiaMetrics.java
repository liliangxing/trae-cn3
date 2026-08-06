package com.bytedance.pia.core.metrics;

import android.webkit.WebView;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.pia.core.api.monitor.IPiaMetricsObserver;
import com.bytedance.pia.core.api.utils.IReleasable;
import com.bytedance.pia.core.utils.ThreadUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PiaMetrics implements IReleasable {
    private static final String NAME_SDK_VERSION = "pia_sdk_version";
    private static final String NAME_URL = "url";
    private final String originUrl;
    private final Set<IPiaMetricsObserver> observers = new HashSet();
    private boolean isPvReported = false;
    private final Map<String, Object> pvEvents = new HashMap();
    private WeakReference<WebView> webViewReference = null;

    public PiaMetrics(String str) {
        this.originUrl = str;
    }

    public void addObserver(final IPiaMetricsObserver iPiaMetricsObserver) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.metrics.PiaMetrics$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                PiaMetrics.this.m742lambda$addObserver$0$combytedancepiacoremetricsPiaMetrics(iPiaMetricsObserver);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$addObserver$0$com-bytedance-pia-core-metrics-PiaMetrics, reason: not valid java name */
    public /* synthetic */ void m742lambda$addObserver$0$combytedancepiacoremetricsPiaMetrics(IPiaMetricsObserver iPiaMetricsObserver) {
        this.observers.add(iPiaMetricsObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setWebView$1$com-bytedance-pia-core-metrics-PiaMetrics, reason: not valid java name */
    public /* synthetic */ void m747lambda$setWebView$1$combytedancepiacoremetricsPiaMetrics(WebView webView) {
        this.webViewReference = new WeakReference<>(webView);
    }

    public void setWebView(final WebView webView) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.metrics.PiaMetrics$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                PiaMetrics.this.m747lambda$setWebView$1$combytedancepiacoremetricsPiaMetrics(webView);
            }
        });
    }

    public void onError(String str, String str2) {
        onError(str, 0, str2);
    }

    public void onError(String str, int i) {
        onError(str, i, "");
    }

    public void onError(final String str, final int i, final String str2) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.metrics.PiaMetrics$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PiaMetrics.this.m743lambda$onError$2$combytedancepiacoremetricsPiaMetrics(str, i, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onError$2$com-bytedance-pia-core-metrics-PiaMetrics, reason: not valid java name */
    public /* synthetic */ void m743lambda$onError$2$combytedancepiacoremetricsPiaMetrics(String str, int i, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_from", "client");
        hashMap.put("error_type", str);
        hashMap.put(CDNLoader.DIAGNOSE_ERROR_CODE, Integer.valueOf(i));
        hashMap.put("error_detail", str2);
        hashMap.put("url", this.originUrl);
        hashMap.put(NAME_SDK_VERSION, "2.0.0");
        report(MetricsType.EXCEPTION, hashMap, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onPvEvent$3$com-bytedance-pia-core-metrics-PiaMetrics, reason: not valid java name */
    public /* synthetic */ void m744lambda$onPvEvent$3$combytedancepiacoremetricsPiaMetrics(PvEventType pvEventType, Object obj) {
        this.pvEvents.put(pvEventType.getValue(), obj);
    }

    public void onPvEvent(final PvEventType pvEventType, final Object obj) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.metrics.PiaMetrics$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                PiaMetrics.this.m744lambda$onPvEvent$3$combytedancepiacoremetricsPiaMetrics(pvEventType, obj);
            }
        });
    }

    public void reportPvEvent() {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.metrics.PiaMetrics$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PiaMetrics.this.m746lambda$reportPvEvent$4$combytedancepiacoremetricsPiaMetrics();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$reportPvEvent$4$com-bytedance-pia-core-metrics-PiaMetrics, reason: not valid java name */
    public /* synthetic */ void m746lambda$reportPvEvent$4$combytedancepiacoremetricsPiaMetrics() {
        if (this.isPvReported) {
            return;
        }
        this.isPvReported = true;
        this.pvEvents.put("url", this.originUrl);
        this.pvEvents.put(NAME_SDK_VERSION, "2.0.0");
        report(MetricsType.PV, this.pvEvents, null);
    }

    public void report(final MetricsType metricsType, final Map<String, Object> map, final Map<String, Object> map2) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.metrics.PiaMetrics$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                PiaMetrics.this.m745lambda$report$6$combytedancepiacoremetricsPiaMetrics(metricsType, map, map2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$report$6$com-bytedance-pia-core-metrics-PiaMetrics, reason: not valid java name */
    public /* synthetic */ void m745lambda$report$6$combytedancepiacoremetricsPiaMetrics(final MetricsType metricsType, final Map map, final Map map2) {
        for (final IPiaMetricsObserver iPiaMetricsObserver : this.observers) {
            if (iPiaMetricsObserver != null) {
                WeakReference<WebView> weakReference = this.webViewReference;
                final WebView webView = weakReference == null ? null : weakReference.get();
                ThreadUtil.runOnMain(new Runnable() { // from class: com.bytedance.pia.core.metrics.PiaMetrics$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        IPiaMetricsObserver.this.onMetrics(metricsType.getValue(), webView, map, map2);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.pia.core.api.utils.IReleasable
    public void release() {
        reportPvEvent();
    }
}
