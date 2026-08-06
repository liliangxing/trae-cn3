package com.lynx.tasm;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.lynx.tasm.behavior.ImageInterceptor;
import com.lynx.tasm.event.LynxEventDetail;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.transform.Transformer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class LynxViewClient extends LynxBackgroundRuntimeClient implements ImageInterceptor {
    public void loadImage(Context context, String str, String str2, float f, float f2, Transformer transformer, ImageInterceptor.CompletionHandler completionHandler) {
    }

    public void onCallJSBFinished(Map<String, Object> map) {
    }

    public void onDataUpdated() {
    }

    public void onDestroy() {
    }

    @Deprecated
    public void onDynamicComponentPerfReady(HashMap<String, Object> hashMap) {
    }

    public void onFirstLoadPerfReady(LynxPerfMetric lynxPerfMetric) {
    }

    public void onFirstScreen() {
    }

    public void onFling(ScrollInfo scrollInfo) {
    }

    public void onFlushFinish(FlushInfo flushInfo) {
    }

    public void onJSBInvoked(Map<String, Object> map) {
    }

    public void onKeyEvent(KeyEvent keyEvent, boolean z) {
    }

    @Deprecated
    public void onLoadFailed(String str) {
    }

    public void onLoadSuccess() {
    }

    public void onLynxEvent(LynxEventDetail lynxEventDetail) {
    }

    public void onLynxViewAndJSRuntimeDestroy() {
    }

    @Override // com.lynx.tasm.LynxBackgroundRuntimeClient
    public void onModuleMethodInvoked(String str, String str2, int i) {
    }

    public void onPageStart(String str) {
    }

    public void onPageUpdate() {
    }

    public void onPiperInvoked(Map<String, Object> map) {
    }

    @Override // com.lynx.tasm.LynxBackgroundRuntimeClient
    public void onReceivedError(LynxError lynxError) {
    }

    @Deprecated
    public void onReceivedError(String str) {
    }

    public void onReceivedJSError(LynxError lynxError) {
    }

    public void onReceivedJavaError(LynxError lynxError) {
    }

    public void onReceivedNativeError(LynxError lynxError) {
    }

    public void onReportComponentInfo(Set<String> set) {
    }

    @Deprecated
    public void onReportLynxConfigInfo(LynxConfigInfo lynxConfigInfo) {
    }

    public void onRuntimeReady() {
    }

    public void onScrollStart(ScrollInfo scrollInfo) {
    }

    public void onScrollStop(ScrollInfo scrollInfo) {
    }

    public void onTASMFinishedByNative() {
    }

    public void onTemplateBundleReady(TemplateBundle templateBundle) {
    }

    public void onTimingSetup(Map<String, Object> map) {
    }

    public void onTimingUpdate(Map<String, Object> map, Map<String, Long> map2, String str) {
    }

    public void onUpdateDataWithoutChange() {
    }

    public void onUpdatePerfReady(LynxPerfMetric lynxPerfMetric) {
    }

    @Deprecated
    public String shouldRedirectImageUrl(String str) {
        return null;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class ScrollInfo {
        public String mScrollMonitorTag;
        public String mTagName;
        public View mView;

        public ScrollInfo(View view, String str, String str2) {
            this.mView = view;
            this.mTagName = str;
            this.mScrollMonitorTag = str2;
        }

        public String toString() {
            return String.format("ViewInfo @%d view %s, name %s, monitor-name %s", Integer.valueOf(hashCode()), this.mView.getClass().getSimpleName(), this.mTagName, this.mScrollMonitorTag);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class FlushInfo {
        public final long beginTiming;
        public final long endTiming;
        public final boolean syncFlush;

        public FlushInfo(boolean z, long j, long j2) {
            this.syncFlush = z;
            this.beginTiming = j;
            this.endTiming = j2;
        }

        public String toString() {
            return String.format("FlushInfo is sync:" + this.syncFlush + ", begin timing:" + this.beginTiming + ", end timing:" + this.endTiming, new Object[0]);
        }
    }
}
