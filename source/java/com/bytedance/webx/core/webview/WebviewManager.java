package com.bytedance.webx.core.webview;

import android.content.Context;
import com.bytedance.webx.ContainerConfig;
import com.bytedance.webx.ExtensionParam;
import com.bytedance.webx.IContainer;
import com.bytedance.webx.IExtension;
import com.bytedance.webx.core.ThreadSession;
import com.bytedance.webx.core.webview.inner.WebviewManagerInner;
import com.bytedance.webx.event.AbsListenerStub;
import com.bytedance.webx.event.EventManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class WebviewManager extends WebviewManagerInner {
    public static final String EVENT_createContainer = "createContainer";
    public static final String EVENT_newContainer = "newContainer";

    @Override // com.bytedance.webx.core.webview.inner.WebviewManagerInner, com.bytedance.webx.core.webview.IWebviewManager, com.bytedance.webx.IManager
    public WebViewContainer createContainer(Context context, ContainerConfig containerConfig) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.createContainer(context, containerConfig);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_createContainer);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            WebViewContainer createContainer = ((ListenerStub) topListener).createContainer(context, containerConfig);
            ThreadSession.sExtensionExtendStack.get().pop();
            return createContainer;
        }
        return super.createContainer(context, containerConfig);
    }

    public WebViewContainer createContainer(Context context, ContainerConfig containerConfig, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        WebViewContainer createContainer = createContainer(context, containerConfig);
        ThreadSession.sExtensionParamStack.get().pop();
        return createContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewContainer __super_createContainer(Context context, ContainerConfig containerConfig) {
        return super.createContainer(context, containerConfig);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebviewManagerInner, com.bytedance.webx.core.webview.IWebviewManager, com.bytedance.webx.IManager
    public <T extends IContainer> T createContainer(Context context, Class<T> cls) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return (T) super.createContainer(context, cls);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_createContainer);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            T t = (T) ((ListenerStub) topListener).createContainer(context, cls);
            ThreadSession.sExtensionExtendStack.get().pop();
            return t;
        }
        return (T) super.createContainer(context, cls);
    }

    public <T extends IContainer> T createContainer(Context context, Class<T> cls, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        T t = (T) createContainer(context, cls);
        ThreadSession.sExtensionParamStack.get().pop();
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends IContainer> T __super_createContainer(Context context, Class<T> cls) {
        return (T) super.createContainer(context, cls);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebviewManagerInner, com.bytedance.webx.core.webview.IWebviewManager, com.bytedance.webx.IManager
    public WebViewContainer createContainer(Context context) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return super.createContainer(context);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_createContainer);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            WebViewContainer createContainer = ((ListenerStub) topListener).createContainer(context);
            ThreadSession.sExtensionExtendStack.get().pop();
            return createContainer;
        }
        return super.createContainer(context);
    }

    public WebViewContainer createContainer(Context context, ExtensionParam... extensionParamArr) {
        ThreadSession.sExtensionParamStack.get().push(extensionParamArr);
        WebViewContainer createContainer = createContainer(context);
        ThreadSession.sExtensionParamStack.get().pop();
        return createContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewContainer __super_createContainer(Context context) {
        return super.createContainer(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.webx.core.webview.inner.WebviewManagerInner
    public <T extends IContainer> T newContainer(Context context, Class<T> cls) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return (T) super.newContainer(context, cls);
        }
        AbsListenerStub topListener = EventManager.getTopListener(getExtendableContext(), EVENT_newContainer);
        if (topListener instanceof ListenerStub) {
            ThreadSession.sExtensionExtendStack.get().push();
            T t = (T) ((ListenerStub) topListener).newContainer(context, cls);
            ThreadSession.sExtensionExtendStack.get().pop();
            return t;
        }
        return (T) super.newContainer(context, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends IContainer> T __super_newContainer(Context context, Class<T> cls) {
        return (T) super.newContainer(context, cls);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static abstract class ListenerStub extends AbsListenerStub<WebviewManager> implements IWebviewManager {
        @Override // com.bytedance.webx.IManager
        public <T extends IExtension.IManagerExtension> T castManager(Class<T> cls) {
            return (T) getExtendable().castManager(cls);
        }

        @Override // com.bytedance.webx.core.webview.IWebviewManager, com.bytedance.webx.IManager
        public WebViewContainer createContainer(Context context, ContainerConfig containerConfig) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebviewManager.EVENT_createContainer);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_createContainer(context, containerConfig);
            }
            return ((ListenerStub) findNextListener).createContainer(context, containerConfig);
        }

        @Override // com.bytedance.webx.core.webview.IWebviewManager, com.bytedance.webx.IManager
        public <T extends IContainer> T createContainer(Context context, Class<T> cls) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebviewManager.EVENT_createContainer);
            if (!(findNextListener instanceof ListenerStub)) {
                return (T) getExtendable().__super_createContainer(context, cls);
            }
            return (T) ((ListenerStub) findNextListener).createContainer(context, cls);
        }

        @Override // com.bytedance.webx.core.webview.IWebviewManager, com.bytedance.webx.IManager
        public WebViewContainer createContainer(Context context) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebviewManager.EVENT_createContainer);
            if (!(findNextListener instanceof ListenerStub)) {
                return getExtendable().__super_createContainer(context);
            }
            return ((ListenerStub) findNextListener).createContainer(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public <T extends IContainer> T newContainer(Context context, Class<T> cls) {
            AbsListenerStub findNextListener = EventManager.findNextListener(getExtendableContext(), this, WebviewManager.EVENT_newContainer);
            if (!(findNextListener instanceof ListenerStub)) {
                return (T) getExtendable().__super_newContainer(context, cls);
            }
            return (T) ((ListenerStub) findNextListener).newContainer(context, cls);
        }
    }
}
