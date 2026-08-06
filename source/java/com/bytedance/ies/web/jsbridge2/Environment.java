package com.bytedance.ies.web.jsbridge2;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.bytedance.ies.web.jsbridge2.AbsHybridViewLazy;
import com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.memory.api.MemoryApi;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class Environment {
    public IAsyncMethodRegister asyncMethodRegister;
    private String bizKey;
    Context context;
    AbstractBridge customBridge;
    DataConverterActual dataConverter;
    boolean debug;
    boolean disableAllPermissionCheck;
    boolean dummy;
    boolean enablePermissionCheck;
    boolean enforceHttp;
    AbsHybridViewLazy hybridViewLazy;
    boolean isShowDebugToast;
    String jsObjectName;
    public List<TimeLineEvent> jsbInstanceTimeLineEvents;
    IBridgePermissionConfigurator.OpenJsbPermissionValidator jsbPermissionValidator;
    final Set<IMethodInvocationListener> methodInvocationListeners;
    String namespace;
    boolean optJsonObject;
    IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener;
    final Set<String> publicMethodSet;
    IReleaseListener releaseListener;
    final Set<String> safeHostSet;
    ISafeWebView safeWebViewImpl;
    boolean shouldFlattenData;
    WebView webView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Environment(WebView webView) {
        this.jsObjectName = "IESJSBridge";
        this.methodInvocationListeners = new LinkedHashSet();
        this.namespace = "host";
        this.safeHostSet = new LinkedHashSet();
        this.publicMethodSet = new LinkedHashSet();
        this.jsbInstanceTimeLineEvents = new CopyOnWriteArrayList();
        this.isShowDebugToast = true;
        this.enforceHttp = true;
        this.webView = webView;
        this.hybridViewLazy = new AbsHybridViewLazy.WebViewLazy(webView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Environment(Environment environment) {
        this.jsObjectName = "IESJSBridge";
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.methodInvocationListeners = linkedHashSet;
        this.namespace = "host";
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        this.safeHostSet = linkedHashSet2;
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        this.publicMethodSet = linkedHashSet3;
        this.jsbInstanceTimeLineEvents = new CopyOnWriteArrayList();
        this.isShowDebugToast = true;
        this.enforceHttp = true;
        this.webView = environment.webView;
        this.hybridViewLazy = environment.hybridViewLazy;
        this.jsObjectName = environment.jsObjectName;
        this.dataConverter = environment.dataConverter;
        this.context = environment.context;
        this.debug = environment.debug;
        this.shouldFlattenData = environment.shouldFlattenData;
        this.enablePermissionCheck = environment.enablePermissionCheck;
        linkedHashSet.addAll(environment.methodInvocationListeners);
        this.namespace = environment.namespace;
        linkedHashSet2.addAll(environment.safeHostSet);
        linkedHashSet3.addAll(environment.publicMethodSet);
        this.dummy = environment.dummy;
        this.customBridge = environment.customBridge;
        this.releaseListener = environment.releaseListener;
        this.disableAllPermissionCheck = environment.disableAllPermissionCheck;
        this.isShowDebugToast = environment.isShowDebugToast;
        this.optJsonObject = environment.optJsonObject;
        this.bizKey = environment.bizKey;
        this.safeWebViewImpl = environment.safeWebViewImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Environment(AbsHybridViewLazy absHybridViewLazy) {
        this.jsObjectName = "IESJSBridge";
        this.methodInvocationListeners = new LinkedHashSet();
        this.namespace = "host";
        this.safeHostSet = new LinkedHashSet();
        this.publicMethodSet = new LinkedHashSet();
        this.jsbInstanceTimeLineEvents = new CopyOnWriteArrayList();
        this.isShowDebugToast = true;
        this.enforceHttp = true;
        this.hybridViewLazy = absHybridViewLazy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public Environment() {
        this.jsObjectName = "IESJSBridge";
        this.methodInvocationListeners = new LinkedHashSet();
        this.namespace = "host";
        this.safeHostSet = new LinkedHashSet();
        this.publicMethodSet = new LinkedHashSet();
        this.jsbInstanceTimeLineEvents = new CopyOnWriteArrayList();
        this.isShowDebugToast = true;
        this.enforceHttp = true;
    }

    public Environment setCustomBridge(AbstractBridge abstractBridge) {
        this.customBridge = abstractBridge;
        return this;
    }

    public Environment setJsObjectName(String str) {
        this.jsObjectName = str;
        return this;
    }

    public Environment setDataConverter(IDataConverter iDataConverter) {
        DataConverterActual from = DataConverterActual.from(iDataConverter);
        this.dataConverter = from;
        from.setOptJsonObject(this.optJsonObject);
        return this;
    }

    public Environment addSafeHost(String str) {
        this.safeHostSet.add(str);
        return this;
    }

    public Environment addSafeHost(Collection<String> collection) {
        this.safeHostSet.addAll(collection);
        return this;
    }

    public Environment addPublicMethod(String str) {
        this.publicMethodSet.add(str);
        return this;
    }

    public Environment addPublicMethod(Collection<String> collection) {
        this.publicMethodSet.addAll(collection);
        return this;
    }

    public Environment setContext(Context context) {
        this.context = context;
        return this;
    }

    public Environment enablePermissionCheck(boolean z) {
        this.enablePermissionCheck = z;
        return this;
    }

    public Environment setDebug(boolean z) {
        this.debug = z;
        return this;
    }

    public Environment setShouldFlattenData(boolean z) {
        this.shouldFlattenData = z;
        return this;
    }

    @Deprecated
    public Environment setMethodInvocationListener(IMethodInvocationListener iMethodInvocationListener) {
        return addMethodInvocationListener(iMethodInvocationListener);
    }

    public Environment addMethodInvocationListener(IMethodInvocationListener iMethodInvocationListener) {
        this.methodInvocationListeners.add(iMethodInvocationListener);
        return this;
    }

    public Environment addOpenJsbValidator(IBridgePermissionConfigurator.OpenJsbPermissionValidator openJsbPermissionValidator) {
        this.jsbPermissionValidator = openJsbPermissionValidator;
        return this;
    }

    public Environment addPermissionCheckingListener(IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener) {
        this.permissionCheckingListener = permissionCheckingListener;
        return this;
    }

    public Environment setNamespace(String str) {
        this.namespace = str;
        return this;
    }

    public Environment disableAllPermissionCheck() {
        this.disableAllPermissionCheck = true;
        return this;
    }

    public Environment setReleaseListener(IReleaseListener iReleaseListener) {
        this.releaseListener = iReleaseListener;
        return this;
    }

    public boolean isShowDebugToast() {
        return this.isShowDebugToast;
    }

    public Environment setShowDebugToast(boolean z) {
        this.isShowDebugToast = z;
        return this;
    }

    public Environment setOptJsonObject(boolean z) {
        this.optJsonObject = z;
        DataConverterActual dataConverterActual = this.dataConverter;
        if (dataConverterActual != null) {
            dataConverterActual.setOptJsonObject(z);
        }
        return this;
    }

    public Environment setSafeWebViewImpl(ISafeWebView iSafeWebView) {
        this.safeWebViewImpl = iSafeWebView;
        return this;
    }

    public JsBridge2 build() {
        checkInvalid();
        TimeLineEvent.Builder extraItem = TimeLineEvent.Builder.instance().setExtraItem("jsObjectName", this.jsObjectName).setExtraItem(MemoryApi.DEBUG, Boolean.valueOf(this.debug)).setExtraItem("shouldFlattenData", Boolean.valueOf(this.shouldFlattenData)).setExtraItem("enablePermissionCheck", Boolean.valueOf(this.enablePermissionCheck)).setExtraItem("namespace", this.namespace).setExtraItem("safeHostSet", this.safeHostSet).setExtraItem("publicMethodSet", this.publicMethodSet).setExtraItem("dummy", Boolean.valueOf(this.dummy)).setExtraItem("jsbPermissionValidator", Boolean.valueOf(this.jsbPermissionValidator != null)).setExtraItem("disableAllPermissionCheck", Boolean.valueOf(this.disableAllPermissionCheck)).setExtraItem("isShowDebugToast", Boolean.valueOf(this.isShowDebugToast));
        WebView webView = this.webView;
        if (webView != null) {
            extraItem.setExtraItem("webView", webView.getClass().getSimpleName());
        }
        ISafeWebView iSafeWebView = this.safeWebViewImpl;
        if (iSafeWebView != null) {
            extraItem.setExtraItem("safeWebViewHandler", iSafeWebView.getClass().getSimpleName());
        }
        extraItem.bind(TimeLineEvent.Constants.LABEL_CREATE_JSB_ENVIRONMENT, this.jsbInstanceTimeLineEvents);
        return new JsBridge2(this);
    }

    public JsBridge2 buildDummy() {
        return new JsBridge2(this, true);
    }

    public WebView getWebView() {
        return this.webView;
    }

    public AbstractBridge getCustomBridge() {
        return this.customBridge;
    }

    public String getJsObjectName() {
        return this.jsObjectName;
    }

    public DataConverterActual getDataConverter() {
        return this.dataConverter;
    }

    public Context getContext() {
        return this.context;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isShouldFlattenData() {
        return this.shouldFlattenData;
    }

    public boolean isEnablePermissionCheck() {
        return this.enablePermissionCheck;
    }

    @Deprecated
    public IMethodInvocationListener getMethodInvocationListener() {
        if (this.methodInvocationListeners.isEmpty()) {
            return null;
        }
        return this.methodInvocationListeners.iterator().next();
    }

    public Set<IMethodInvocationListener> getMethodInvocationListeners() {
        return new LinkedHashSet(this.methodInvocationListeners);
    }

    public IReleaseListener getReleaseListener() {
        return this.releaseListener;
    }

    public boolean isDisableAllPermissionCheck() {
        return this.disableAllPermissionCheck;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public Set<String> getSafeHostSet() {
        return this.safeHostSet;
    }

    public Set<String> getPublicMethodSet() {
        return this.publicMethodSet;
    }

    public boolean isOptJsonObject() {
        return this.optJsonObject;
    }

    public boolean isDummy() {
        return this.dummy;
    }

    public void setDummy(Boolean bool) {
        this.dummy = bool.booleanValue();
    }

    public void setBizKey(String str) {
        this.bizKey = str;
    }

    public String getBizKey() {
        String str = this.bizKey;
        return (str == null || str.isEmpty()) ? "host" : this.bizKey;
    }

    public boolean isEnforceHttp() {
        return this.enforceHttp;
    }

    public void setEnforceHttp(boolean z) {
        this.enforceHttp = z;
    }

    private void checkInvalid() {
        if ((this.webView == null && !this.dummy && this.customBridge == null) || ((TextUtils.isEmpty(this.jsObjectName) && this.webView != null) || this.dataConverter == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
        checkWebView(this.debug, this.isShowDebugToast, this.webView);
    }

    public static void checkWebView(boolean z, boolean z2, final WebView webView) {
        if (!z || !z2 || webView == null || (webView instanceof ISafeWebView)) {
            return;
        }
        webView.post(new Runnable() { // from class: com.bytedance.ies.web.jsbridge2.Environment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(webView.getContext(), "【Security】\nThe current JSB authentication has security risks!\nPlease implement the ISafeWebView interface of JsBridge2\n", 1).show();
            }
        });
    }

    public Environment setAsyncMethodRegister(IAsyncMethodRegister iAsyncMethodRegister) {
        this.asyncMethodRegister = iAsyncMethodRegister;
        return this;
    }
}
