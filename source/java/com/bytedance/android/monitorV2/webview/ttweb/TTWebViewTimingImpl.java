package com.bytedance.android.monitorV2.webview.ttweb;

import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.lynx.webview.glue.IWebViewExtension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TTWebViewTimingImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/ttweb/TTWebViewTimingImpl;", "Lcom/bytedance/lynx/webview/glue/IWebViewExtension$PerformanceTimingListener;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/android/monitorV2/webview/ttweb/TTWebViewCallback;", "(Lcom/bytedance/android/monitorV2/webview/ttweb/TTWebViewCallback;)V", "TAG", "", "onBodyParsing", "", "onCustomTagNotify", "json", "onDOMContentLoaded", "onFirstContentfulPaint", "onFirstImagePaint", "onFirstMeaningfulPaint", "onFirstScreenPaint", "onIframeLoaded", "url", "onJSError", "onNetFinish", "onReceivedResponse", "onReceivedSpecialEvent", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class TTWebViewTimingImpl implements IWebViewExtension.PerformanceTimingListener {
    private final String TAG;
    private final TTWebViewCallback callback;

    public void onBodyParsing() {
    }

    public void onCustomTagNotify(String json) {
    }

    public void onDOMContentLoaded() {
    }

    public void onFirstImagePaint() {
    }

    public void onFirstMeaningfulPaint() {
    }

    public void onFirstScreenPaint() {
    }

    public void onIframeLoaded(String url) {
    }

    public void onJSError(String json) {
    }

    public void onNetFinish() {
    }

    public void onReceivedResponse(String json) {
    }

    public void onReceivedSpecialEvent(String json) {
    }

    public TTWebViewTimingImpl(TTWebViewCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        this.TAG = "TTWebViewTimingImpl";
    }

    public void onFirstContentfulPaint() {
        MonitorLog.d(this.TAG, "onFirstContentfulPaint");
        this.callback.blankDetect(false);
    }
}
