package com.bytedance.webx.precreate;

import android.content.Context;
import android.webkit.WebView;
import com.bytedance.webx.precreate.api.IMultiWebViewSupplier;
import com.bytedance.webx.precreate.api.IPreCreateMonitor;
import com.bytedance.webx.precreate.impl.DefaultMultiWebViewSupplier;
import com.bytedance.webx.precreate.model.PreCreateInfo;
import com.bytedance.webx.seclink.util.ReportUtil;
import io.noties.markwon.html.tag.ImageGridHandler;
import kotlin.Metadata;

/* compiled from: PreCreateWebViewManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001f\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\u0010\u0010\r\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0010\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u001a\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/webx/precreate/PreCreateWebViewManager;", "Lcom/bytedance/webx/precreate/api/IMultiWebViewSupplier;", "()V", "multiWebViewSupplier", "fetchCachedWebView", "Landroid/webkit/WebView;", "type", "", ImageGridHandler.Index, "", "get", "context", "Landroid/content/Context;", ReportUtil.Event.EVENT_INIT, "preCreate", "", "registerMonitorCallback", "callback", "Lcom/bytedance/webx/precreate/api/IPreCreateMonitor;", "registerWebView", "info", "Lcom/bytedance/webx/precreate/model/PreCreateInfo;", "remove", "", "webView", "resize", "cacheSize", "setPreCreatActive", "enable", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class PreCreateWebViewManager implements IMultiWebViewSupplier {
    public static final PreCreateWebViewManager INSTANCE = new PreCreateWebViewManager();
    private static IMultiWebViewSupplier multiWebViewSupplier;

    private PreCreateWebViewManager() {
    }

    public final IMultiWebViewSupplier init(Context context) {
        if (multiWebViewSupplier == null) {
            multiWebViewSupplier = new DefaultMultiWebViewSupplier(context);
        }
        return this;
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public IMultiWebViewSupplier registerWebView(String type, PreCreateInfo info) {
        IMultiWebViewSupplier iMultiWebViewSupplier = multiWebViewSupplier;
        if (iMultiWebViewSupplier != null) {
            iMultiWebViewSupplier.registerWebView(type, info);
        }
        return this;
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public IMultiWebViewSupplier registerMonitorCallback(IPreCreateMonitor callback) {
        IMultiWebViewSupplier iMultiWebViewSupplier = multiWebViewSupplier;
        if (iMultiWebViewSupplier != null) {
            iMultiWebViewSupplier.registerMonitorCallback(callback);
        }
        return this;
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public void resize(String type, int cacheSize) {
        IMultiWebViewSupplier iMultiWebViewSupplier = multiWebViewSupplier;
        if (iMultiWebViewSupplier != null) {
            iMultiWebViewSupplier.resize(type, cacheSize);
        }
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public void preCreate(String type) {
        IMultiWebViewSupplier iMultiWebViewSupplier = multiWebViewSupplier;
        if (iMultiWebViewSupplier != null) {
            iMultiWebViewSupplier.preCreate(type);
        }
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public WebView get(Context context, String type) {
        IMultiWebViewSupplier iMultiWebViewSupplier = multiWebViewSupplier;
        if (iMultiWebViewSupplier != null) {
            return iMultiWebViewSupplier.get(context, type);
        }
        return null;
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public WebView fetchCachedWebView(String type, int index) {
        IMultiWebViewSupplier iMultiWebViewSupplier = multiWebViewSupplier;
        if (iMultiWebViewSupplier != null) {
            return iMultiWebViewSupplier.fetchCachedWebView(type, index);
        }
        return null;
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public boolean remove(String type, WebView webView, boolean resize) {
        IMultiWebViewSupplier iMultiWebViewSupplier = multiWebViewSupplier;
        if (iMultiWebViewSupplier != null) {
            return iMultiWebViewSupplier.remove(type, webView, resize);
        }
        return false;
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public void setPreCreatActive(boolean enable) {
        IMultiWebViewSupplier iMultiWebViewSupplier = multiWebViewSupplier;
        if (iMultiWebViewSupplier != null) {
            iMultiWebViewSupplier.setPreCreatActive(enable);
        }
    }
}
