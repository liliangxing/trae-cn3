package com.bytedance.android.monitorV2.webview.base;

import android.webkit.RenderProcessGoneDetail;
import com.bytedance.android.monitorV2.entity.EngineInfo;
import com.bytedance.android.monitorV2.entity.FallBackInfo;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.applog.server.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: IWebViewLifeCycle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H&J3\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\n2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00030\u0013H&J\b\u0010\u0018\u001a\u00020\u0019H&J\u001a\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0005H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0005H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\nH&J\b\u0010*\u001a\u00020\u0003H&J\b\u0010+\u001a\u00020\u0003H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.H&J(\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H&J\"\u00104\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u00010\u0005H&¨\u00067"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/base/IWebViewLifeCycle;", "", "addContext", "", Api.KEY_ENCRYPT_RESP_KEY, "", "value", "addExtraEventInfo", "type", "state", "", "customReport", "customEvent", "Lcom/bytedance/android/monitorV2/event/CustomEvent;", "forceReport", "reportType", "getPerformance", "waitCompleteData", "performanceCallback", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "performanceResult", "getUnifyInfo", "Lcom/bytedance/android/monitorV2/entity/EngineInfo;", "handleNativeInfo", "event", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "jsonObject", "handleRenderProcessGone", "webdetail", "Landroid/webkit/RenderProcessGoneDetail;", "onAttachedToWindow", "onDestroy", "onGoBack", "onLoadUrl", "url", "onPageFinished", "onPageStarted", "onProgressChanged", "newProgress", "onReload", "onViewCreate", "reportFallbackPage", "fallBackInfo", "Lcom/bytedance/android/monitorV2/entity/FallBackInfo;", "reportGeckoInfo", "resStatus", "resType", "resUrl", "resVersion", "updateUnifyError", AlogMonitor.ALOG_RESULT_CODE, "message", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IWebViewLifeCycle {
    void addContext(String key, String value);

    void addExtraEventInfo(String type, int state);

    void customReport(CustomEvent customEvent);

    void forceReport(String reportType);

    void getPerformance(int waitCompleteData, Function1<? super JSONObject, Unit> performanceCallback);

    EngineInfo getUnifyInfo();

    void handleNativeInfo(CommonEvent event, JSONObject jsonObject);

    void handleRenderProcessGone(RenderProcessGoneDetail webdetail);

    void onAttachedToWindow();

    void onDestroy();

    void onGoBack();

    void onLoadUrl(String url);

    void onPageFinished(String url);

    void onPageStarted(CommonEvent event);

    void onProgressChanged(int newProgress);

    void onReload();

    void onViewCreate();

    void reportFallbackPage(FallBackInfo fallBackInfo);

    void reportGeckoInfo(String resStatus, String resType, String resUrl, String resVersion);

    void updateUnifyError(CommonEvent event, int code, String message);
}
