package com.bytedance.webx.core.webview.inner;

import android.content.Context;
import com.bytedance.webx.AbsExtension;
import com.bytedance.webx.ContainerConfig;
import com.bytedance.webx.IContainer;
import com.bytedance.webx.IExtension;
import com.bytedance.webx.WebXEnv;
import com.bytedance.webx.context.ExtendableContext;
import com.bytedance.webx.context.IContextItem;
import com.bytedance.webx.core.ExtendableControlDelegate;
import com.bytedance.webx.core.IExtendableControl;
import com.bytedance.webx.core.webview.IWebviewManager;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.bytedance.webx.core.webview.client.WebChromeContainerClient;
import com.bytedance.webx.core.webview.client.WebViewContainerClient;
import com.bytedance.webx.core.webview.extension.PageCtrlExtension;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class WebviewManagerInner implements IExtendableControl, IWebviewManager, IContextItem {
    private ExtendableControlDelegate mContainerControlDelegate = new ExtendableControlDelegate();
    private WebXEnv mEnv;

    @Override // com.bytedance.webx.core.IExtendableControl
    public void init(WebXEnv webXEnv) {
        this.mEnv = webXEnv;
        this.mContainerControlDelegate.setExtendableContext(new ExtendableContext(this.mEnv, this));
    }

    @Override // com.bytedance.webx.core.IExtendableControl
    public ExtendableContext getExtendableContext() {
        ExtendableControlDelegate extendableControlDelegate = this.mContainerControlDelegate;
        if (extendableControlDelegate == null) {
            return null;
        }
        return extendableControlDelegate.getExtendableContext();
    }

    @Override // com.bytedance.webx.IManager
    public <T extends IExtension.IManagerExtension> T castManager(Class<T> cls) {
        return (T) this.mContainerControlDelegate.castExtendable(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Class] */
    @Override // com.bytedance.webx.core.webview.IWebviewManager, com.bytedance.webx.IManager
    public WebViewContainer createContainer(Context context, ContainerConfig containerConfig) {
        WebViewContainer webViewContainer;
        Set<Class<? extends AbsExtension>> set;
        Set<WebXEnv.IExtensionCreateListener> set2;
        HashMap<Class<? extends AbsExtension>, WebXEnv.IExtensionCreateListener> hashMap;
        WebViewContainer assignContainer;
        if (containerConfig != null) {
            IContainer assignContainer2 = containerConfig.getAssignContainer();
            WebViewContainer webViewContainer2 = assignContainer2 instanceof WebViewContainer ? (WebViewContainer) assignContainer2 : null;
            ?? newContainerClass = containerConfig.getNewContainerClass();
            r0 = newContainerClass != 0 ? newContainerClass : null;
            set2 = containerConfig.getExtensionCreateListeners();
            hashMap = containerConfig.getExtensionCreateListenerMap();
            WebViewContainer webViewContainer3 = webViewContainer2;
            set = containerConfig.getExtensions();
            webViewContainer = r0;
            r0 = webViewContainer3;
        } else {
            webViewContainer = null;
            set = null;
            set2 = null;
            hashMap = null;
        }
        if (r0 == null) {
            assignContainer = (WebViewContainer) newContainer(context, webViewContainer);
        } else {
            assignContainer = assignContainer(r0);
        }
        initContainerCustom(set2, hashMap, set, assignContainer);
        return assignContainer;
    }

    public <T extends IContainer> T createContainer(Context context, Class<T> cls) {
        return (T) newContainer(context, cls);
    }

    @Override // com.bytedance.webx.core.webview.IWebviewManager, com.bytedance.webx.IManager
    public WebViewContainer createContainer(Context context) {
        return (WebViewContainer) newContainer(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends IContainer> T newContainer(Context context, Class<T> cls) {
        WebViewContainer webViewContainer;
        if (cls == null) {
            webViewContainer = new WebViewContainer(context);
        } else {
            try {
                webViewContainer = (WebViewContainer) cls.getConstructor(Context.class).newInstance(context);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
        return initContainerBase(webViewContainer);
    }

    private WebViewContainer assignContainer(WebViewContainer webViewContainer) {
        return initContainerBase(webViewContainer);
    }

    private WebViewContainer initContainerBase(WebViewContainer webViewContainer) {
        if (webViewContainer.getExtendableContext() != null) {
            return webViewContainer;
        }
        webViewContainer.init(this.mEnv);
        WebViewContainerClient webViewContainerClient = new WebViewContainerClient();
        WebChromeContainerClient webChromeContainerClient = new WebChromeContainerClient();
        webViewContainerClient.init(this.mEnv);
        webViewContainer.setExtendableWebViewClient(webViewContainerClient);
        webChromeContainerClient.init(this.mEnv);
        webViewContainer.setExtendableWebViewClient(webChromeContainerClient);
        LinkedHashSet<Class<? extends AbsExtension>> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(PageCtrlExtension.class);
        linkedHashSet.addAll(this.mEnv.mContainerExtensionClazzs);
        webViewContainer.getExtendableContext().firstAddExtension(linkedHashSet);
        webViewContainer.getExtendableContext().setBaseInited(true);
        return webViewContainer;
    }

    private void initContainerCustom(Set<WebXEnv.IExtensionCreateListener> set, HashMap<Class<? extends AbsExtension>, WebXEnv.IExtensionCreateListener> hashMap, Set<Class<? extends AbsExtension>> set2, WebViewContainer webViewContainer) {
        webViewContainer.getExtendableContext().addExtensionCreateListener(set, hashMap);
        webViewContainer.getExtendableContext().addExtension(set2);
    }
}
