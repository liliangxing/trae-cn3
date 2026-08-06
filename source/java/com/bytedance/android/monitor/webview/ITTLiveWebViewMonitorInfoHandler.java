package com.bytedance.android.monitor.webview;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.bytedance.android.monitor.entity.ContainerCommon;
import com.bytedance.android.monitor.entity.ContainerInfo;
import com.bytedance.android.monitor.entity.FetchError;
import com.bytedance.android.monitor.entity.JSBError;
import com.bytedance.android.monitor.entity.JSBInfo;
import com.bytedance.android.monitor.standard.ContainerError;
import com.bytedance.android.monitor.webview.base.IBusinessCustom;
import com.bytedance.android.monitor.webview.base.IContainerContext;
import com.bytedance.android.monitor.webview.base.IWebBlankCallback;
import com.bytedance.webx.blankdetect.BlankUtils;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface ITTLiveWebViewMonitorInfoHandler {
    void addContext(WebView webView, String str, Object obj);

    boolean checkInCache(WebView webView);

    void cover(WebView webView, String str, String str2, String str3);

    IContainerContext getContainerContext(WebView webView);

    String getLastUrl(WebView webView);

    void handleBlankDetect(WebView webView, BlankUtils.DetectorResult detectorResult, IWebBlankCallback iWebBlankCallback);

    @Deprecated
    void handleClientOfflineInfo(WebView webView, String str, boolean z);

    void handleContainerError(WebView webView, ContainerCommon containerCommon, ContainerError containerError);

    void handleCustomCoverReport(WebView webView, String str, String str2, String str3, String str4);

    void handleCustomDirectlyReport(WebView webView, String str, String str2, String str3, String str4);

    void handleCustomParams(WebView webView, String str);

    void handleCustomParseKeys(WebView webView, Set<String> set);

    void handleFetchError(WebView webView, FetchError fetchError);

    void handleInitTimeInfo(WebView webView, String str);

    void handleInjectJS(WebView webView, long j);

    void handleJSBError(WebView webView, JSBError jSBError);

    void handleJSBInfo(WebView webView, JSBInfo jSBInfo);

    void handleLoadUrl(WebView webView, String str);

    @Deprecated
    void handleOffLineInfo(WebView webView, String str, boolean z);

    @Deprecated
    void handleOfflineInfoExtra(WebView webView, String str, String str2, String str3, String str4, String str5);

    void handlePageExit(WebView webView);

    void handlePageFinish(WebView webView, String str);

    void handlePageProgress(WebView webView, int i);

    void handlePageStart(WebView webView, String str);

    void handleRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail);

    void handleReportEvent(WebView webView, String str, int i);

    void handleRequestError(WebView webView, String str, boolean z, int i, String str2, int i2);

    void handleViewAttach(WebView webView);

    void handleViewCreate(WebView webView);

    void handleViewDetach(WebView webView);

    void handleWebviewDestory(WebView webView);

    boolean hasReport(WebView webView);

    boolean isWebviewDestoryed(WebView webView);

    void registerDataCallback(WebView webView, IBusinessCustom.IDataCallback iDataCallback);

    void reportClientDirectly(WebView webView, String str, JSONObject jSONObject);

    void reportClientDirectly(WebView webView, String str, JSONObject jSONObject, ContainerInfo containerInfo);

    void reportDirectly(WebView webView, String str, String str2);

    void reportPerformance(WebView webView, String str);

    void save(WebView webView, String str, String str2, JSONObject jSONObject);

    void save(WebView webView, String str, JSONObject jSONObject);
}
