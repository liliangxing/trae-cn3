package com.bytedance.android.monitorV2.webview;

import android.net.Uri;
import com.bytedance.android.monitorV2.checker.DoubleReportChecker;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.webview.base.ISSPRootInterface;
import com.bytedance.android.monitorV2.webview.cache.impl.SSPNativeCommon;
import com.bytedance.android.monitorV2.webview.constant.WebViewMonitorConstant;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: WebViewRootManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J:\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J0\u0010 \u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006!"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/WebViewRootManager;", "Lcom/bytedance/android/monitorV2/webview/base/ISSPRootInterface;", "biz", "", "(Ljava/lang/String;)V", "PV_EVENT_TYPE", "RES_LOADER_EVENT_TYPE", "RIFLEBIZ", "weiViewStack", "Ljava/util/concurrent/LinkedBlockingDeque;", "getWeiViewStack", "()Ljava/util/concurrent/LinkedBlockingDeque;", "weiViewStack$delegate", "Lkotlin/Lazy;", "addRootInfo", "", "nativeCommon", "Lcom/bytedance/android/monitorV2/webview/cache/impl/SSPNativeCommon;", "url", "currentNavigation", "Lcom/bytedance/android/monitorV2/webview/NavigationDataManager;", "getParentUrl", "getRootUrl", "handleSPPMonitorInfo", "event", "params", "", "", "removeQuery", "uri", "Landroid/net/Uri;", "reportSSPPv", "reportSSPResLoadInfo", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class WebViewRootManager implements ISSPRootInterface {
    private final String PV_EVENT_TYPE;
    private final String RES_LOADER_EVENT_TYPE;
    private final String RIFLEBIZ;
    private final String biz;

    /* renamed from: weiViewStack$delegate, reason: from kotlin metadata */
    private final Lazy weiViewStack;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WebViewRootManager() {
        this(r0, 1, r0);
        String str = null;
    }

    public WebViewRootManager(String str) {
        this.biz = str;
        this.weiViewStack = LazyKt.lazy(new Function0<LinkedBlockingDeque<String>>() { // from class: com.bytedance.android.monitorV2.webview.WebViewRootManager$weiViewStack$2
            public final LinkedBlockingDeque<String> invoke() {
                return new LinkedBlockingDeque<>();
            }
        });
        this.RIFLEBIZ = "rifle";
        this.PV_EVENT_TYPE = "navigationStart";
        this.RES_LOADER_EVENT_TYPE = ReportConst.Event.RES_LOADER_PERF;
    }

    public /* synthetic */ WebViewRootManager(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    private final LinkedBlockingDeque<String> getWeiViewStack() {
        return (LinkedBlockingDeque) this.weiViewStack.getValue();
    }

    @Override // com.bytedance.android.monitorV2.webview.base.ISSPRootInterface
    public void handleSPPMonitorInfo(String event, NavigationDataManager currentNavigation, String url, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(this.biz, this.RIFLEBIZ)) {
            if (Intrinsics.areEqual(event, ReportConst.Event.ANNIEX_SSP_PV)) {
                if (url != null) {
                    getWeiViewStack().add(url);
                    reportSSPPv(url, currentNavigation);
                    return;
                }
                return;
            }
            if (!Intrinsics.areEqual(event, ReportConst.Event.ANNIEX_SSP_RES_LOADER_INFO) || url == null) {
                return;
            }
            reportSSPResLoadInfo(url, currentNavigation, params);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.ISSPRootInterface
    public String getParentUrl() {
        if (getWeiViewStack().size() > 1) {
            return (String) CollectionsKt.elementAt(getWeiViewStack(), getWeiViewStack().size() - 2);
        }
        return null;
    }

    @Override // com.bytedance.android.monitorV2.webview.base.ISSPRootInterface
    public String getRootUrl() {
        if (getWeiViewStack().size() >= 1) {
            return getWeiViewStack().getFirst();
        }
        return null;
    }

    private final void reportSSPPv(String url, NavigationDataManager currentNavigation) {
        try {
            SSPNativeCommon sSPNativeCommon = new SSPNativeCommon();
            addRootInfo(sSPNativeCommon, url, currentNavigation);
            sSPNativeCommon.eventType = this.PV_EVENT_TYPE;
            DoubleReportChecker doubleReportChecker = DoubleReportChecker.INSTANCE;
            JSONObject jsonObject = sSPNativeCommon.toJsonObject();
            Intrinsics.checkNotNullExpressionValue(jsonObject, "nativeCommon.toJsonObject()");
            doubleReportChecker.reportTea(ReportConst.Event.ANNIEX_SSP_PV, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void reportSSPResLoadInfo(String url, NavigationDataManager currentNavigation, Map<String, ? extends Object> params) {
        try {
            SSPNativeCommon sSPNativeCommon = new SSPNativeCommon();
            addRootInfo(sSPNativeCommon, url, currentNavigation);
            if (params != null) {
                Object obj = params.get(WebViewMonitorConstant.Web.RES_FORMAT_SRC);
                if (obj != null) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    sSPNativeCommon.resFormatSrc = (String) obj;
                }
                Object obj2 = params.get(WebViewMonitorConstant.Web.RES_FULL_SRC);
                if (obj2 != null) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                    sSPNativeCommon.resFullSrc = (String) obj2;
                }
                Object obj3 = params.get(WebViewMonitorConstant.Web.RES_FROM);
                if (obj3 != null) {
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                    sSPNativeCommon.resFrom = (String) obj3;
                }
                Object obj4 = params.get(WebViewMonitorConstant.Web.RES_SIZE);
                if (obj4 != null) {
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
                    sSPNativeCommon.resSize = (Integer) obj4;
                }
                Object obj5 = params.get("res_type");
                if (obj5 != null) {
                    Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
                    sSPNativeCommon.resType = (String) obj5;
                }
                Object obj6 = params.get(WebViewMonitorConstant.Web.REQUEST_METHOD);
                if (obj6 != null) {
                    Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.String");
                    sSPNativeCommon.requestMethod = (String) obj6;
                }
            }
            sSPNativeCommon.eventType = this.RES_LOADER_EVENT_TYPE;
            DoubleReportChecker doubleReportChecker = DoubleReportChecker.INSTANCE;
            JSONObject jsonObject = sSPNativeCommon.toJsonObject();
            Intrinsics.checkNotNullExpressionValue(jsonObject, "nativeCommon.toJsonObject()");
            doubleReportChecker.reportTea(ReportConst.Event.ANNIEX_SSP_RES_LOADER_INFO, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void addRootInfo(SSPNativeCommon nativeCommon, String url, NavigationDataManager currentNavigation) {
        nativeCommon.engineType = "web";
        Uri parse = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
        nativeCommon.formatUrl = removeQuery(parse);
        nativeCommon.fullUrl = url;
        nativeCommon.rootUrl = getRootUrl();
        nativeCommon.parentUrl = getParentUrl();
        if (currentNavigation != null) {
            nativeCommon.navigationId = currentNavigation.getWebNativeCommon().navigationId;
        }
        nativeCommon.biz = this.biz;
    }

    private final String removeQuery(Uri uri) {
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.clearQuery();
        String uri2 = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "builder.build().toString()");
        return uri2;
    }
}
