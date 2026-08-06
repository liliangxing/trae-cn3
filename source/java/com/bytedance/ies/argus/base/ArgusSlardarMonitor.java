package com.bytedance.ies.argus.base;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.ies.argus.api.interfaces.SecureReportInfo;
import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusSlardarMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusSlardarMonitor;", "", "()V", "buildCustomInfo", "Lcom/bytedance/android/monitorV2/entity/CustomInfo;", "info", "Lcom/bytedance/ies/argus/api/interfaces/SecureReportInfo;", "report", "", "webView", "Landroid/webkit/WebView;", "reportInfo", "lynxView", "Lcom/lynx/tasm/LynxView;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusSlardarMonitor {
    public static final ArgusSlardarMonitor INSTANCE = new ArgusSlardarMonitor();

    private ArgusSlardarMonitor() {
    }

    private final CustomInfo buildCustomInfo(SecureReportInfo info) {
        CustomInfo.Builder bid = new CustomInfo.Builder(info.getEventName()).setUrl(info.getUrl()).setCategory(info.getCategory()).setMetric(info.getMetrics()).setSample(info.getSampleLevel()).setBid("bullet_custom_bid");
        String bid2 = info.getBid();
        if (bid2 != null) {
            bid.setBid(bid2);
        }
        CustomInfo build = bid.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public final void report(SecureReportInfo reportInfo) {
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        WebViewMonitorHelper.getInstance().customReport((WebView) null, buildCustomInfo(reportInfo));
    }

    public final void report(WebView webView, SecureReportInfo reportInfo) {
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        WebViewMonitorHelper.getInstance().customReport(webView, buildCustomInfo(reportInfo));
    }

    public final void report(LynxView lynxView, SecureReportInfo reportInfo) {
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        LynxViewMonitor.INSTANCE.getINSTANCE().customReport((View) lynxView, buildCustomInfo(reportInfo));
    }
}
