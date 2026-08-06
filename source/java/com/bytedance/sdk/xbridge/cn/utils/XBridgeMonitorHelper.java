package com.bytedance.sdk.xbridge.cn.utils;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: XBridgeMonitorHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/XBridgeMonitorHelper;", "", "()V", "EVENTNAME_JSB2_FINISH_WITH_FAILURE", "", "reportJSBFailed", "", "eventName", "methodName", IWeixinService.ResponseConstants.URL, "errorMsg", "hybridView", "Landroid/view/View;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XBridgeMonitorHelper {
    public static final String EVENTNAME_JSB2_FINISH_WITH_FAILURE = "jsb2_finish_with_failure";
    public static final XBridgeMonitorHelper INSTANCE = new XBridgeMonitorHelper();

    private XBridgeMonitorHelper() {
    }

    public final void reportJSBFailed(String eventName, String methodName, String url, String errorMsg, View hybridView) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(hybridView, "hybridView");
        try {
            Result.Companion companion = Result.Companion;
            CustomInfo.Builder sample = new CustomInfo.Builder(eventName).setSample(0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IWeixinService.ResponseConstants.URL, url);
            jSONObject.put("methodName", methodName);
            jSONObject.put("errorMsg", errorMsg);
            CustomInfo build = sample.setCategory(jSONObject).setUrl(url).build();
            if (hybridView instanceof LynxView) {
                LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
                Intrinsics.checkNotNullExpressionValue(build, "customInfo");
                instance.customReport(hybridView, build);
            } else if (hybridView instanceof WebView) {
                WebViewMonitorHelper.getInstance().customReport((WebView) hybridView, build);
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }
}
