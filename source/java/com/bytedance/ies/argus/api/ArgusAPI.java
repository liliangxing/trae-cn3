package com.bytedance.ies.argus.api;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.anniex.R;
import com.bytedance.ies.argus.api.interfaces.service.IArgusWebSecureService;
import com.bytedance.ies.argus.base.ArgusServiceManager;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0011J*\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00012\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0015H\u0082\b¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000eH\u0007¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/argus/api/ArgusAPI;", "", "()V", "forceClose", "", "initContainerDelegate", "Lcom/bytedance/ies/argus/api/ArgusContainerDelegate;", "initLynxDelegate", "Lcom/bytedance/ies/argus/api/ArgusLynxDelegate;", "delegate", "view", "Lcom/lynx/tasm/LynxView;", "initWebDelegate", "Lcom/bytedance/ies/argus/api/ArgusWebDelegate;", "Landroid/webkit/WebView;", "injectWebSecureService", "", "Lcom/bytedance/ies/argus/api/interfaces/service/IArgusWebSecureService;", "innerInit", "T", "initBlock", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isArgusVerifyWebView", "webView", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusAPI {
    public static final ArgusAPI INSTANCE = new ArgusAPI();

    private ArgusAPI() {
    }

    private final <T> T innerInit(Function0<? extends T> initBlock) {
        if (forceClose()) {
            return null;
        }
        ArgusSecureManager.INSTANCE.ensureSetupFinished();
        return (T) initBlock.invoke();
    }

    public final void injectWebSecureService(IArgusWebSecureService delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        ArgusServiceManager.INSTANCE.getInstance().add(delegate);
    }

    @JvmStatic
    public static final boolean isArgusVerifyWebView(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return Intrinsics.areEqual(webView.getTag(R.id.argus_secure_webview), true);
    }

    private final boolean forceClose() {
        return ArgusConfigManager.INSTANCE.getInstance().getForceCloseAll();
    }

    public final ArgusContainerDelegate initContainerDelegate() {
        if (forceClose()) {
            return null;
        }
        ArgusSecureManager.INSTANCE.ensureSetupFinished();
        return new ArgusContainerDelegate();
    }

    public final ArgusWebDelegate initWebDelegate(ArgusContainerDelegate delegate, WebView view) {
        if (forceClose()) {
            return null;
        }
        ArgusSecureManager.INSTANCE.ensureSetupFinished();
        ArgusWebDelegate attachContainerDelegate = new ArgusWebDelegate().attachContainerDelegate(delegate);
        attachContainerDelegate.attachView(view);
        return attachContainerDelegate;
    }

    public final ArgusLynxDelegate initLynxDelegate(ArgusContainerDelegate delegate, LynxView view) {
        if (forceClose()) {
            return null;
        }
        ArgusSecureManager.INSTANCE.ensureSetupFinished();
        ArgusLynxDelegate attachContainerDelegate = new ArgusLynxDelegate().attachContainerDelegate(delegate);
        attachContainerDelegate.attachView((View) view);
        return attachContainerDelegate;
    }
}
