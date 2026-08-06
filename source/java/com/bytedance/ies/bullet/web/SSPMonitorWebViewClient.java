package com.bytedance.ies.bullet.web;

import android.graphics.Bitmap;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.MonitorSettingsConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: SSPMonitorWebViewClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J&\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/web/SSPMonitorWebViewClient;", "Lcom/bytedance/ies/bullet/service/base/web/WebViewClientDelegate;", "()V", "isWebSSPReport", "", "onPageStarted", "", "view", "Landroid/webkit/WebView;", "url", "", "favicon", "Landroid/graphics/Bitmap;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SSPMonitorWebViewClient extends WebViewClientDelegate {
    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (!isWebSSPReport() || view == null || url == null) {
            return;
        }
        WebViewMonitorHelper.getInstance().handleSSPInfo("anniex_ssp_pv", String.valueOf(view.hashCode()), url, (Map) null);
    }

    private final boolean isWebSSPReport() {
        MonitorSettingsConfig monitorSettingsConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (monitorSettingsConfig = (MonitorSettingsConfig) iBulletSettingsService.obtainSettings(MonitorSettingsConfig.class)) == null) {
            return false;
        }
        return monitorSettingsConfig.getWebSSPReport();
    }
}
