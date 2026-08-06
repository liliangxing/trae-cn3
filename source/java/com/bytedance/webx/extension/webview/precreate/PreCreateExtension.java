package com.bytedance.webx.extension.webview.precreate;

import android.content.Context;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.bytedance.webx.AbsExtension;
import com.bytedance.webx.ExtensionParam;
import com.bytedance.webx.IContainer;
import com.bytedance.webx.WebX;
import com.bytedance.webx.WebXEnv;
import com.bytedance.webx.core.webview.PreCreateAccessHelper;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.bytedance.webx.core.webview.WebviewManager;
import com.bytedance.webx.precreate.PreCreateWebViewManager;
import com.bytedance.webx.precreate.api.IWebViewFactory;
import com.bytedance.webx.precreate.model.PreCreateInfo;
import com.bytedance.webx.precreate.util.PreCreateUtil;
import kotlin.jvm.functions.Function2;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PreCreateExtension extends AbsExtension<WebviewManager> implements IPreCreateExtension {
    private static String PRE_CREATE_TYPE = "webx_container";
    WebviewManager.ListenerStub mListener = new WebviewManager.ListenerStub() { // from class: com.bytedance.webx.extension.webview.precreate.PreCreateExtension.1
        @Override // com.bytedance.webx.event.AbsListenerStub
        public AbsExtension getExtension() {
            return PreCreateExtension.this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.webx.core.webview.WebviewManager.ListenerStub
        public <T extends IContainer> T newContainer(Context context, Class<T> cls) {
            CreateContainer createContainer = (CreateContainer) ExtensionParam.selectParam(CreateContainer.class);
            if (createContainer != null) {
                if (!createContainer.mIsFromPreCreated) {
                    return (T) super.newContainer(context, cls);
                }
                WebView webView = PreCreateWebViewManager.INSTANCE.get(context, PreCreateExtension.getPreCreateType(PreCreateExtension.this.mEnv.getNameSpace(), cls));
                if (webView instanceof WebViewContainer) {
                    return (T) webView;
                }
                PreCreateUtil.destroyWebView(webView, context.getApplicationContext());
                return (T) super.newContainer(context, cls);
            }
            return (T) super.newContainer(context, cls);
        }
    };

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class CreateContainer extends ExtensionParam {
        private boolean mIsFromPreCreated;

        public static CreateContainer param(boolean z) {
            CreateContainer createContainer = new CreateContainer();
            createContainer.mIsFromPreCreated = z;
            return createContainer;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class CastManager {
        public static Class<? extends IPreCreateExtension> param() {
            return PreCreateExtension.class;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.webx.AbsExtension
    public void onCreateExtendable(AbsExtension.CreateHelper createHelper) {
        register(WebviewManager.EVENT_newContainer, this.mListener, 9000);
    }

    @Override // com.bytedance.webx.extension.webview.precreate.IPreCreateExtension
    public void initPreCreate(int i, boolean z) {
        initPreCreate(i, z, null);
    }

    @Override // com.bytedance.webx.extension.webview.precreate.IPreCreateExtension
    public void initPreCreate(int i, boolean z, final Class<? extends WebViewContainer> cls) {
        PreCreateWebViewManager.INSTANCE.init(WebXEnv.getAppContext()).registerWebView(getPreCreateType(this.mEnv.getNameSpace(), cls), new PreCreateInfo.Builder().setWebViewFactory(new IWebViewFactory() { // from class: com.bytedance.webx.extension.webview.precreate.PreCreateExtension.2
            @Override // com.bytedance.webx.precreate.api.IWebViewFactory
            public WebView create(Context context, boolean z2) {
                CreateContainer createContainer = (CreateContainer) ExtensionParam.selectParam(CreateContainer.class);
                boolean z3 = false;
                if (createContainer != null && createContainer.mIsFromPreCreated) {
                    createContainer.mIsFromPreCreated = false;
                    z3 = true;
                }
                WebViewContainer webViewContainer = (WebViewContainer) PreCreateAccessHelper.newContainer((WebviewManager) WebX.getContainerManager(PreCreateExtension.this.mEnv.getNameSpace(), WebviewManager.class), context, cls);
                PreCreateExtension.addRenderProcessGoneExtension(webViewContainer, PreCreateExtension.this.mEnv, cls);
                if (z3) {
                    createContainer.mIsFromPreCreated = true;
                }
                return webViewContainer;
            }
        }).setSize(i).preCreateWebViewWhenRegister(z).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getPreCreateType(String str, Class<? extends WebViewContainer> cls) {
        return PRE_CREATE_TYPE + ":" + str + (cls == null ? "" : ":" + cls.getCanonicalName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addRenderProcessGoneExtension(WebViewContainer webViewContainer, final WebXEnv webXEnv, final Class<? extends WebViewContainer> cls) {
        PreCreateRenderProcessGoneExtension preCreateRenderProcessGoneExtension = new PreCreateRenderProcessGoneExtension();
        preCreateRenderProcessGoneExtension.setRemovePreCreatedHandler(new Function2<WebView, RenderProcessGoneDetail, Boolean>() { // from class: com.bytedance.webx.extension.webview.precreate.PreCreateExtension.3
            public Boolean invoke(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                return Boolean.valueOf(PreCreateWebViewManager.INSTANCE.remove(PreCreateExtension.getPreCreateType(WebXEnv.this.getNameSpace(), cls), webView, false));
            }
        });
        webViewContainer.getExtendableContext().addExtensionInstance(preCreateRenderProcessGoneExtension);
    }
}
