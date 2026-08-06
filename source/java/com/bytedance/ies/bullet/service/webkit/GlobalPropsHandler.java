package com.bytedance.ies.bullet.service.webkit;

import android.webkit.WebView;
import com.bytedance.android.anniex.R;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.web.IGlobalPropsHandler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: GlobalPropsHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/service/webkit/GlobalPropsHandler;", "Lcom/bytedance/ies/bullet/service/base/web/IGlobalPropsHandler;", "webKitService", "Lcom/bytedance/ies/bullet/service/webkit/WebKitService;", "(Lcom/bytedance/ies/bullet/service/webkit/WebKitService;)V", "globalPropsJsonString", "", "mContextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getWebKitService", "()Lcom/bytedance/ies/bullet/service/webkit/WebKitService;", "injectContextProvider", "", "contextProviderFactory", "injectGlobalProps", "webView", "Landroid/webkit/WebView;", "updateGlobalProps", "globalProps", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GlobalPropsHandler implements IGlobalPropsHandler {
    private String globalPropsJsonString;
    private ContextProviderFactory mContextProviderFactory;
    private final WebKitService webKitService;

    public GlobalPropsHandler(WebKitService webKitService) {
        Intrinsics.checkNotNullParameter(webKitService, "webKitService");
        this.webKitService = webKitService;
    }

    public final WebKitService getWebKitService() {
        return this.webKitService;
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IGlobalPropsHandler
    public void injectContextProvider(ContextProviderFactory contextProviderFactory) {
        Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
        this.mContextProviderFactory = contextProviderFactory;
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IGlobalPropsHandler
    public void updateGlobalProps(Map<String, ? extends Object> globalProps) {
        Intrinsics.checkNotNullParameter(globalProps, "globalProps");
        if (globalProps.isEmpty()) {
            this.globalPropsJsonString = null;
        } else {
            this.globalPropsJsonString = new JSONObject(globalProps).toString();
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IGlobalPropsHandler
    public void injectGlobalProps(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        if (this.globalPropsJsonString == null) {
            return;
        }
        Object tag = webView.getTag(R.id.key_js_object_global_props);
        if (tag == null) {
            ContextProviderFactory contextProviderFactory = this.mContextProviderFactory;
            InjectData injectData = contextProviderFactory != null ? (InjectData) contextProviderFactory.provideInstance(InjectData.class) : null;
            if (injectData != null) {
                String str = this.globalPropsJsonString;
                if (str == null) {
                    str = "{}";
                }
                injectData.setGlobalProps(str);
            } else {
                injectData = new InjectData(this.globalPropsJsonString, null, null, 6, null);
            }
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(injectData, "__globalprops");
            webView.setTag(R.id.key_js_object_global_props, injectData);
            BulletLogger.INSTANCE.printLog("injectGlobalProps:successfully set", LogLevel.D, "XWebKit");
            return;
        }
        if (!(tag instanceof InjectData)) {
            BulletLogger.INSTANCE.printLog("injectGlobalProps:type mismatch, current type is " + tag.getClass(), LogLevel.E, "XWebKit");
            return;
        }
        BulletLogger.INSTANCE.printLog("injectGlobalProps:already set", LogLevel.D, "XWebKit");
        String str2 = this.globalPropsJsonString;
        Intrinsics.checkNotNull(str2);
        ((InjectData) tag).setGlobalProps(str2);
    }
}
