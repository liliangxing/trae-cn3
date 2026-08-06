package com.bytedance.ies.web.jsbridge2;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.web.jsbridge2.BaseStatefulMethod;
import com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator;
import com.bytedance.ies.web.jsbridge2.PermissionConfig;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class JsBridge2 {
    public static final String DEFAULT_NAMESPACE = "host";
    private final AbstractBridge bridge;
    private final Environment environment;
    private final List<IReleaseListener> releaseListeners;
    private volatile boolean released;
    private ISupportBridge supportBridge;
    private final WebView webView;
    static final Lazy<IGlobalCallListener> globalCallListenerLazy = new Lazy<IGlobalCallListener>() { // from class: com.bytedance.ies.web.jsbridge2.JsBridge2.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.ies.web.jsbridge2.Lazy
        public IGlobalCallListener initialValue() {
            return DefaultConfigProvider.getGlobalCallListener();
        }
    };
    static final Lazy<PermissionConfigRepository> permissionConfigRepositoryLazy = new Lazy<PermissionConfigRepository>() { // from class: com.bytedance.ies.web.jsbridge2.JsBridge2.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.ies.web.jsbridge2.Lazy
        public PermissionConfigRepository initialValue() {
            IBridgePermissionConfigurator configurator = DefaultConfigProvider.getConfigurator();
            if (configurator != null) {
                return new PermissionConfigRepository(configurator);
            }
            return null;
        }
    };
    static Lazy<IGlobalBridgeInterceptor> globalBridgeInterceptor = new Lazy<IGlobalBridgeInterceptor>() { // from class: com.bytedance.ies.web.jsbridge2.JsBridge2.3
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.ies.web.jsbridge2.Lazy
        public IGlobalBridgeInterceptor initialValue() {
            return DefaultConfigProvider.getGlobalBridgeInterceptor();
        }
    };
    private static final Object lock = new Object();
    public static List<TimeLineEvent> sdkInitTimeLineEvents = new CopyOnWriteArrayList();
    static final Lazy<ISwitchConfig> switchConfigLazy = new Lazy<ISwitchConfig>() { // from class: com.bytedance.ies.web.jsbridge2.JsBridge2.4
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.ies.web.jsbridge2.Lazy
        public ISwitchConfig initialValue() {
            return DefaultConfigProvider.getSwitchConfig();
        }
    };

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ISwitchConfig {
        boolean optSwitch(SwitchConfigEnum switchConfigEnum);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface InitCallback {
        void onInitialized();
    }

    public static void setGlobalCallListener(IGlobalCallListener iGlobalCallListener) {
        globalCallListenerLazy.set(iGlobalCallListener);
    }

    public static void enablePermissionCheck(IBridgePermissionConfigurator iBridgePermissionConfigurator, InitCallback initCallback) {
        enablePermissionCheck(true, iBridgePermissionConfigurator, initCallback, null);
    }

    public static void enablePermissionCheck(boolean z, IBridgePermissionConfigurator iBridgePermissionConfigurator, InitCallback initCallback) {
        enablePermissionCheck(z, iBridgePermissionConfigurator, initCallback, null);
    }

    public static void enablePermissionCheck(IBridgePermissionConfigurator iBridgePermissionConfigurator, InitCallback initCallback, ISwitchConfig iSwitchConfig) {
        enablePermissionCheck(true, iBridgePermissionConfigurator, initCallback, iSwitchConfig);
    }

    public static void enablePermissionCheck(boolean z, IBridgePermissionConfigurator iBridgePermissionConfigurator, InitCallback initCallback, ISwitchConfig iSwitchConfig) {
        switchConfigLazy.set(iSwitchConfig);
        Lazy<PermissionConfigRepository> lazy = permissionConfigRepositoryLazy;
        if (!lazy.hasInitialized()) {
            synchronized (lock) {
                if (!lazy.hasInitialized()) {
                    lazy.set(new PermissionConfigRepository(iBridgePermissionConfigurator));
                }
            }
        }
        handlePermissionConfig(z, initCallback);
    }

    public static void handlePermissionConfig(boolean z, InitCallback initCallback) {
        Lazy<PermissionConfigRepository> lazy = permissionConfigRepositoryLazy;
        if (lazy.get() != null) {
            if (z) {
                lazy.get().fetch(initCallback);
            } else {
                lazy.get().handleLocalPermissionConfig(initCallback);
            }
        }
    }

    public static PermissionConfig getPermissionConfig() {
        return getPermissionConfig("host");
    }

    public static PermissionConfig getPermissionConfig(String str) {
        if (!TextUtils.isEmpty(str)) {
            Lazy<PermissionConfigRepository> lazy = permissionConfigRepositoryLazy;
            if (lazy.get() != null) {
                return lazy.get().get(str, null);
            }
        }
        return null;
    }

    private static void handlePermissionConfig(PermissionConfig permissionConfig, Set<String> set) {
        if (permissionConfig == null || set == null) {
            return;
        }
        Map<String, List<PermissionConfig.RemoteConfig>> configListMap = permissionConfig.getConfigListMap();
        if (configListMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, List<PermissionConfig.RemoteConfig>> entry : configListMap.entrySet()) {
            Iterator<PermissionConfig.RemoteConfig> it = entry.getValue().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().permissionGroup != PermissionGroup.PUBLIC) {
                        set.add(entry.getKey());
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static Set<String> getSafeHostSet(List<String> list, IBridgePermissionConfigurator.LocalStorage localStorage, String str) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Lazy<PermissionConfigRepository> lazy = permissionConfigRepositoryLazy;
        if (lazy.get() != null) {
            lazy.get().getConfigMap();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                handlePermissionConfig(permissionConfigRepositoryLazy.get().get(it.next(), null), hashSet);
            }
        }
        if (hashSet.isEmpty() && localStorage != null && !TextUtils.isEmpty(str)) {
            try {
                String read = localStorage.read("com.bytedance.ies.web.jsbridge2.PermissionConfigRepository.permission_config_response", "");
                if (read != null && !read.isEmpty()) {
                    JSONArray jSONArray = new JSONObject(read).getJSONObject("data").getJSONObject(SchemaConstants.QUERY_KEY_PACKAGES).getJSONArray(str);
                    for (String str2 : list) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            if (jSONObject.getString("channel").equals("host".equals(str2) ? "_jsb_auth" : "_jsb_auth." + str2)) {
                                Iterator<String> keys = jSONObject.getJSONObject("content").keys();
                                while (keys.hasNext()) {
                                    hashSet.add(keys.next());
                                }
                            }
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return hashSet;
    }

    public static boolean isPermissionCheckEnabled() {
        return permissionConfigRepositoryLazy.get() != null;
    }

    public static Environment createWith(WebView webView) {
        return new Environment(webView);
    }

    public static Environment createWith(JsBridge2 jsBridge2) {
        Environment environment = new Environment(jsBridge2.environment);
        environment.dummy = true;
        environment.enablePermissionCheck = false;
        return environment;
    }

    public static Environment create(AbsHybridViewLazy absHybridViewLazy) {
        return new Environment(absHybridViewLazy);
    }

    @Deprecated
    public static Environment create() {
        return new Environment();
    }

    public <T> void sendJsEvent(String str, T t) {
        checkReleased();
        this.bridge.sendJsEvent(str, t);
    }

    public JsBridge2 registerStatelessMethod(String str, BaseStatelessMethod<?, ?> baseStatelessMethod) {
        return registerStatelessMethod(str, null, baseStatelessMethod);
    }

    public JsBridge2 registerStatelessMethod(String str, String str2, BaseStatelessMethod<?, ?> baseStatelessMethod) {
        checkReleased();
        this.bridge.callHandler.registerStatelessMethod(str, baseStatelessMethod);
        ISupportBridge iSupportBridge = this.supportBridge;
        if (iSupportBridge != null) {
            iSupportBridge.onRegisterMethod(str);
        }
        return this;
    }

    public JsBridge2 registerStatefulMethod(String str, BaseStatefulMethod.Provider provider) {
        return registerStatefulMethod(str, null, provider);
    }

    public JsBridge2 registerStatefulMethod(String str, String str2, BaseStatefulMethod.Provider provider) {
        checkReleased();
        this.bridge.callHandler.registerStatefulMethod(str, provider);
        ISupportBridge iSupportBridge = this.supportBridge;
        if (iSupportBridge != null) {
            iSupportBridge.onRegisterMethod(str);
        }
        return this;
    }

    public JsBridge2 importFrom(String str, final JsBridge2 jsBridge2) {
        ISupportBridge iSupportBridge;
        this.bridge.addExternalHandler(str, jsBridge2.bridge.callHandler);
        ISupportBridge iSupportBridge2 = this.supportBridge;
        if (iSupportBridge2 != null && (iSupportBridge = jsBridge2.supportBridge) != null) {
            iSupportBridge2.importFrom(iSupportBridge);
        }
        this.releaseListeners.add(new IReleaseListener() { // from class: com.bytedance.ies.web.jsbridge2.JsBridge2.5
            @Override // com.bytedance.ies.web.jsbridge2.IReleaseListener
            public void onReleased() {
                jsBridge2.release();
            }
        });
        return this;
    }

    public JsBridge2 unregisterMethod(String str) {
        return unregisterMethod(str, null);
    }

    public JsBridge2 unregisterMethod(String str, String str2) {
        checkReleased();
        this.bridge.callHandler.unregisterMethod(str);
        ISupportBridge iSupportBridge = this.supportBridge;
        if (iSupportBridge != null) {
            iSupportBridge.onUnregisterMethod(str);
        }
        return this;
    }

    public JsBridge2 enableSupportBridge(ISupportBridge iSupportBridge) {
        this.supportBridge = iSupportBridge;
        return this;
    }

    public WebView getWebView() {
        return this.webView;
    }

    public View getHybridView() {
        return this.bridge.getHybridView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Environment getEnvironment() {
        return this.environment;
    }

    public String getBizKey() {
        return getEnvironment().getBizKey();
    }

    public void release() {
        if (this.released) {
            return;
        }
        this.bridge.release();
        this.released = true;
        for (IReleaseListener iReleaseListener : this.releaseListeners) {
            if (iReleaseListener != null) {
                iReleaseListener.onReleased();
            }
        }
    }

    public boolean isReleased() {
        return this.released;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsBridge2(Environment environment) {
        ArrayList arrayList = new ArrayList();
        this.releaseListeners = arrayList;
        this.released = false;
        this.environment = environment;
        TimeLineEvent.Builder extraItem = TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.ENABLE_PERMISSION_CHECK, Boolean.valueOf(environment.enablePermissionCheck));
        String str = TimeLineEvent.Constants.PERMISSION_CONFIG_REPOSITORY;
        Lazy<PermissionConfigRepository> lazy = permissionConfigRepositoryLazy;
        extraItem.setExtraItem(str, Boolean.valueOf(lazy.get() != null)).bind(TimeLineEvent.Constants.LABEL_CREATE_JSB_INSTANCE, environment.jsbInstanceTimeLineEvents);
        PermissionConfig permissionConfig = (!environment.enablePermissionCheck || lazy.get() == null) ? null : lazy.get().get(environment.namespace, environment.jsbInstanceTimeLineEvents);
        if (environment.webView != null) {
            this.bridge = new WebViewBridge();
        } else {
            this.bridge = environment.customBridge;
        }
        this.bridge.initActual(environment, permissionConfig);
        this.webView = environment.webView;
        arrayList.add(environment.releaseListener);
        DebugUtil.init(environment.debug);
        SerializeHelper.setShouldFlattenData(environment.shouldFlattenData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsBridge2(Environment environment, Boolean bool) {
        this.releaseListeners = new ArrayList();
        this.released = false;
        this.environment = environment;
        environment.dummy = bool.booleanValue();
        this.webView = null;
        this.bridge = environment.customBridge;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractBridge getBridge() {
        return this.bridge;
    }

    private void checkReleased() {
        if (this.released) {
            DebugUtil.throwRuntimeException(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }

    public PermissionGroup getPermissionGroup(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Lazy<PermissionConfigRepository> lazy = permissionConfigRepositoryLazy;
            if (lazy.get() != null) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "host";
                }
                PermissionConfig permissionConfig = lazy.get().get(str2, null);
                r1 = permissionConfig != null ? permissionConfig.getPermissionGroup(str) : null;
                String authority = Uri.parse(str).getAuthority();
                if (r1 == null && !TextUtils.isEmpty(authority)) {
                    for (String str3 : this.bridge.callHandler.getPermissionChecker().getSafeHostSet()) {
                        if (authority.equals(str3) || authority.endsWith(LibrarianImpl.Constants.DOT + str3)) {
                            return PermissionGroup.PRIVATE;
                        }
                    }
                }
            }
        }
        return r1;
    }

    public boolean isSafeHost(String str, String str2) {
        PermissionGroup permissionGroup = getPermissionGroup(str, str2);
        return (permissionGroup == null || PermissionGroup.PUBLIC == permissionGroup) ? false : true;
    }

    public void setMethodWithNamespaceInvocationListener(IMethodWithNamespaceInvocationListener iMethodWithNamespaceInvocationListener) {
        this.bridge.invocationListener = iMethodWithNamespaceInvocationListener;
    }
}
