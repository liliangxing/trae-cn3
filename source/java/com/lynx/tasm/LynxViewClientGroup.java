package com.lynx.tasm;

import android.content.Context;
import android.view.KeyEvent;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.trace.TraceEventDef;
import com.lynx.tasm.behavior.ImageInterceptor;
import com.lynx.tasm.event.LynxEventDetail;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.xml.transform.Transformer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxViewClientGroup extends LynxViewClient {
    private CopyOnWriteArrayList<LynxViewClient> mClients = new CopyOnWriteArrayList<>();
    private int mInstanceId = -1;

    @Override // com.lynx.tasm.LynxViewClient
    public void onFirstLoadPerfReady(LynxPerfMetric lynxPerfMetric) {
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onUpdatePerfReady(LynxPerfMetric lynxPerfMetric) {
    }

    public void addClient(LynxViewClient lynxViewClient) {
        if (this.mClients.contains(lynxViewClient)) {
            return;
        }
        this.mClients.add(lynxViewClient);
    }

    public void removeClient(LynxViewClient lynxViewClient) {
        this.mClients.remove(lynxViewClient);
    }

    public void setInstanceId(int i) {
        this.mInstanceId = i;
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onPageStart(String str) {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onPageStart(str);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onLoadSuccess() {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onLoadSuccess();
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onLoadFailed(String str) {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onLoadFailed(str);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onFirstScreen() {
        TraceEvent.beginSection(TraceEventDef.CLIENT_ON_FIRST_SCREEN);
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onFirstScreen();
        }
        TraceEvent.endSection(TraceEventDef.CLIENT_ON_FIRST_SCREEN);
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onPageUpdate() {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onPageUpdate();
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onDataUpdated() {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onDataUpdated();
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onTASMFinishedByNative() {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onTASMFinishedByNative();
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onReceivedError(String str) {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onReceivedError(str);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onReceivedJSError(LynxError lynxError) {
        if (lynxError == null || lynxError.getMsg() == null) {
            return;
        }
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onReceivedJSError(lynxError);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onReceivedNativeError(LynxError lynxError) {
        if (lynxError == null || lynxError.getMsg() == null) {
            return;
        }
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onReceivedNativeError(lynxError);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient, com.lynx.tasm.LynxBackgroundRuntimeClient
    public void onReceivedError(LynxError lynxError) {
        if (lynxError == null || lynxError.getMsg() == null) {
            return;
        }
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onReceivedError(lynxError);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onReceivedJavaError(LynxError lynxError) {
        if (lynxError == null || lynxError.getMsg() == null) {
            return;
        }
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onReceivedJavaError(lynxError);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onRuntimeReady() {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onRuntimeReady();
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onDynamicComponentPerfReady(HashMap<String, Object> hashMap) {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onDynamicComponentPerfReady(hashMap);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onReportComponentInfo(Set<String> set) {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onReportComponentInfo(set);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onDestroy() {
        TraceEvent.beginSection(TraceEventDef.CLIENT_DESTORY);
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        TraceEvent.endSection(TraceEventDef.CLIENT_DESTORY);
    }

    @Override // com.lynx.tasm.LynxViewClient
    public String shouldRedirectImageUrl(String str) {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            String shouldRedirectImageUrl = it.next().shouldRedirectImageUrl(str);
            if (shouldRedirectImageUrl != null) {
                return shouldRedirectImageUrl;
            }
        }
        return null;
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void loadImage(Context context, String str, String str2, float f, float f2, Transformer transformer, ImageInterceptor.CompletionHandler completionHandler) {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().loadImage(context, str, str2, f, f2, transformer, completionHandler);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onUpdateDataWithoutChange() {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onUpdateDataWithoutChange();
        }
    }

    @Override // com.lynx.tasm.LynxViewClient, com.lynx.tasm.LynxBackgroundRuntimeClient
    public void onModuleMethodInvoked(String str, String str2, int i) {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onModuleMethodInvoked(str, str2, i);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onPiperInvoked(Map<String, Object> map) {
        TraceEvent.beginSection(TraceEventDef.CLIENT_PIPER_INVOKED);
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onPiperInvoked(map);
        }
        TraceEvent.endSection(TraceEventDef.CLIENT_PIPER_INVOKED);
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onLynxViewAndJSRuntimeDestroy() {
        TraceEvent.beginSection(TraceEventDef.CLIENT_LYNXVIEW_AND_JSRUNTIME_DESTORY);
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onLynxViewAndJSRuntimeDestroy();
        }
        TraceEvent.endSection(TraceEventDef.CLIENT_LYNXVIEW_AND_JSRUNTIME_DESTORY);
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onScrollStart(LynxViewClient.ScrollInfo scrollInfo) {
        TraceEvent.beginSection(TraceEventDef.CLIENT_SCROLL_START);
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onScrollStart(scrollInfo);
        }
        TraceEvent.endSection(TraceEventDef.CLIENT_SCROLL_START);
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onScrollStop(LynxViewClient.ScrollInfo scrollInfo) {
        TraceEvent.beginSection(TraceEventDef.CLIENT_SCROLL_STOP);
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onScrollStop(scrollInfo);
        }
        TraceEvent.endSection(TraceEventDef.CLIENT_SCROLL_STOP);
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onFling(LynxViewClient.ScrollInfo scrollInfo) {
        TraceEvent.beginSection(TraceEventDef.CLIENT_FLING);
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onFling(scrollInfo);
        }
        TraceEvent.endSection(TraceEventDef.CLIENT_FLING);
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onFlushFinish(LynxViewClient.FlushInfo flushInfo) {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onFlushFinish(flushInfo);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onKeyEvent(KeyEvent keyEvent, boolean z) {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onKeyEvent(keyEvent, z);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onTimingUpdate(Map<String, Object> map, Map<String, Long> map2, String str) {
        TraceEvent.beginSection(TraceEventDef.CLIENT_TIMING_UPDATE);
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onTimingUpdate(map, map2, str);
        }
        TraceEvent.endSection(TraceEventDef.CLIENT_TIMING_UPDATE);
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onTimingSetup(Map<String, Object> map) {
        TraceEvent.beginSection(TraceEventDef.CLIENT_TIMING_SETUP);
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onTimingSetup(map);
        }
        TraceEvent.endSection(TraceEventDef.CLIENT_TIMING_SETUP);
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onJSBInvoked(Map<String, Object> map) {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onJSBInvoked(map);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onCallJSBFinished(Map<String, Object> map) {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onCallJSBFinished(map);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onLynxEvent(LynxEventDetail lynxEventDetail) {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onLynxEvent(lynxEventDetail);
        }
    }

    @Override // com.lynx.tasm.LynxViewClient
    public void onTemplateBundleReady(TemplateBundle templateBundle) {
        Iterator<LynxViewClient> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onTemplateBundleReady(templateBundle);
        }
    }
}
