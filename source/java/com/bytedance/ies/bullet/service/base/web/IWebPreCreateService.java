package com.bytedance.ies.bullet.service.base.web;

import android.content.Context;
import android.webkit.WebView;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import kotlin.Metadata;

/* compiled from: IWebPreCreateService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H'J\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/IWebPreCreateService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "init", "", "application", "Landroid/content/Context;", "config", "Lcom/bytedance/ies/bullet/service/base/web/WebPreCreateServiceConfig;", "preCreateWebView", "context", "provideWebView", "Landroid/webkit/WebView;", "type", "", "submitPreCreateWebView", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IWebPreCreateService extends IBulletService {
    void init(Context application, WebPreCreateServiceConfig config);

    void preCreateWebView(Context context);

    WebView provideWebView(Context context, String type);

    void submitPreCreateWebView(Context context);

    /* compiled from: IWebPreCreateService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ WebView provideWebView$default(IWebPreCreateService iWebPreCreateService, Context context, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: provideWebView");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return iWebPreCreateService.provideWebView(context, str);
        }
    }
}
