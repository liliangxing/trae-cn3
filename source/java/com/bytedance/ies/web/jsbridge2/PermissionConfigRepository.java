package com.bytedance.ies.web.jsbridge2;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator;
import com.bytedance.ies.web.jsbridge2.JsBridge2;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PermissionConfigRepository {
    private static final String KEY_PERMISSION_CONFIG_REPO_PREFIX = "com.bytedance.ies.web.jsbridge2.PermissionConfigRepository.";
    static final String KEY_PERMISSION_CONFIG_RESPONSE = "com.bytedance.ies.web.jsbridge2.PermissionConfigRepository.permission_config_response";
    private final IBridgePermissionConfigurator configurator;
    private final Executor executor;
    private final String fetchUrl;
    private final Collection<String> namespaces;
    private final Map<String, PermissionConfig> configMap = new ConcurrentHashMap();
    private final Map<Integer, SoftReference<FetchCallback>> fetchCallbackMap = new ConcurrentHashMap();
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private volatile boolean isFetched = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface FetchCallback {
        void onPermissionConfigFetched();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PermissionConfigRepository(IBridgePermissionConfigurator iBridgePermissionConfigurator) {
        this.configurator = iBridgePermissionConfigurator;
        String provideHostPermissionFetchUrl = iBridgePermissionConfigurator.provideHostPermissionFetchUrl();
        if (TextUtils.isEmpty(provideHostPermissionFetchUrl)) {
            this.fetchUrl = iBridgePermissionConfigurator.provideRegionConfig().url;
        } else {
            this.fetchUrl = provideHostPermissionFetchUrl;
        }
        this.executor = iBridgePermissionConfigurator.provideWorkerExecutor();
        this.namespaces = new LinkedList(iBridgePermissionConfigurator.provideNamespaces());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PermissionConfig get(String str, List<TimeLineEvent> list) {
        if (!this.namespaces.contains(str) && !TextUtils.equals(str, "host")) {
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.NAMESPACE, str).setExtraItem(TimeLineEvent.Constants.LIST, str).bind(TimeLineEvent.Constants.LABEL_ILLEGAL_NAMESPACE, list);
            throw new IllegalArgumentException("Namespace: " + str + " not registered.");
        }
        return createOrUpdateOrGetConfig(str, null, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFetchCallback(FetchCallback fetchCallback) {
        this.fetchCallbackMap.put(Integer.valueOf(fetchCallback.hashCode()), new SoftReference<>(fetchCallback));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeFetchCallback(FetchCallback fetchCallback) {
        this.fetchCallbackMap.remove(Integer.valueOf(fetchCallback.hashCode()));
    }

    public boolean isFetched() {
        if (JsBridge2.switchConfigLazy.get() == null || !JsBridge2.switchConfigLazy.get().optSwitch(SwitchConfigEnum.PERMISSION_CONFIG_DEFAULT_FETCHED)) {
            return this.isFetched;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fetch(final JsBridge2.InitCallback initCallback) {
        TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.FETCH_PERMISSION_CONFIG, true).bind(TimeLineEvent.Constants.LABEL_ENABLE_PERMISSION_CHECK, JsBridge2.sdkInitTimeLineEvents);
        final String jSONObject = createFetchParamsBody().toString();
        this.configurator.doPost(this.fetchUrl, null, "application/json", jSONObject.getBytes(), new IBridgePermissionConfigurator.NetworkCallback() { // from class: com.bytedance.ies.web.jsbridge2.PermissionConfigRepository.1
            @Override // com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator.NetworkCallback
            public void onSucceed(final String str) {
                DebugUtil.m65i("Fetch configurations succeed, url: " + PermissionConfigRepository.this.fetchUrl);
                PermissionConfigRepository.this.executor.execute(new Runnable() { // from class: com.bytedance.ies.web.jsbridge2.PermissionConfigRepository.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PermissionConfigRepository.this.parsePackageVersion(str, TimeLineEvent.Constants.FROM_NETWORK, PermissionConfigRepository.this.fetchUrl);
                        PermissionConfigRepository.this.handleResponse(false, str, initCallback);
                    }
                });
            }

            @Override // com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator.NetworkCallback
            public void onFailed(Throwable th) {
                DebugUtil.m64e("Fetch configurations failed, url: " + PermissionConfigRepository.this.fetchUrl, th);
                TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.URL, PermissionConfigRepository.this.fetchUrl).setExtraItem(TimeLineEvent.Constants.PARAM, jSONObject).setExtraItem(TimeLineEvent.Constants.EXCEPTION_NAME, th.getClass().getSimpleName()).setExtraItem(TimeLineEvent.Constants.EXCEPTION_MESSAGE, th.getMessage()).bind(TimeLineEvent.Constants.LABEL_FETCH_ON_FAILED, JsBridge2.sdkInitTimeLineEvents);
                PermissionConfigRepository.this.handleLocalPermissionConfig(initCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBridgePermissionConfigurator.PermissionCheckUrlFilter providePermissionCheckUrlFilter() {
        IBridgePermissionConfigurator iBridgePermissionConfigurator = this.configurator;
        if (iBridgePermissionConfigurator != null) {
            return iBridgePermissionConfigurator.providePermissionCheckUrlFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleLocalPermissionConfig(final JsBridge2.InitCallback initCallback) {
        this.executor.execute(new Runnable() { // from class: com.bytedance.ies.web.jsbridge2.PermissionConfigRepository$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PermissionConfigRepository.this.m68x36b58a85(initCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$handleLocalPermissionConfig$1$com-bytedance-ies-web-jsbridge2-PermissionConfigRepository */
    public /* synthetic */ void m68x36b58a85(final JsBridge2.InitCallback initCallback) {
        TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.FETCH_PERMISSION_CONFIG, false).bind(TimeLineEvent.Constants.LABEL_ENABLE_PERMISSION_CHECK, JsBridge2.sdkInitTimeLineEvents);
        this.configurator.provideLocalStorage().read(KEY_PERMISSION_CONFIG_RESPONSE, new IBridgePermissionConfigurator.LocalStorage.ValueCallback() { // from class: com.bytedance.ies.web.jsbridge2.PermissionConfigRepository$$ExternalSyntheticLambda2
            @Override // com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator.LocalStorage.ValueCallback
            public final void onValue(String str) {
                PermissionConfigRepository.this.m70xd9ba74d9(initCallback, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$null$0$com-bytedance-ies-web-jsbridge2-PermissionConfigRepository */
    public /* synthetic */ void m70xd9ba74d9(JsBridge2.InitCallback initCallback, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.configurator.providePermissionConfigResponse();
            parsePackageVersion(str, TimeLineEvent.Constants.FROM_INJECTION, null);
        } else {
            parsePackageVersion(str, TimeLineEvent.Constants.FROM_STORAGE, null);
        }
        handleResponse(true, str, initCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResponse(boolean z, final String str, final JsBridge2.InitCallback initCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            this.configurator.provideLocalStorage().read(KEY_PERMISSION_CONFIG_RESPONSE, new IBridgePermissionConfigurator.LocalStorage.ValueCallback() { // from class: com.bytedance.ies.web.jsbridge2.PermissionConfigRepository$$ExternalSyntheticLambda1
                @Override // com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator.LocalStorage.ValueCallback
                public final void onValue(String str2) {
                    PermissionConfigRepository.this.m69xac72b215(str, str2);
                }
            });
        }
        parseConfigurations(str);
        this.isFetched = true;
        TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.REPO_FETCHED, TimeLineEvent.Constants.TRUE).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_FETCH, JsBridge2.sdkInitTimeLineEvents);
        this.mainThreadHandler.post(new Runnable() { // from class: com.bytedance.ies.web.jsbridge2.PermissionConfigRepository.2
            @Override // java.lang.Runnable
            public void run() {
                JsBridge2.InitCallback initCallback2 = initCallback;
                if (initCallback2 != null) {
                    initCallback2.onInitialized();
                }
                try {
                    Iterator it = PermissionConfigRepository.this.fetchCallbackMap.entrySet().iterator();
                    while (it.hasNext()) {
                        SoftReference softReference = (SoftReference) ((Map.Entry) it.next()).getValue();
                        if (softReference != null && softReference.get() != null) {
                            ((FetchCallback) softReference.get()).onPermissionConfigFetched();
                        }
                    }
                } catch (Throwable th) {
                    DebugUtil.m64e("Failed to  onPermissionConfigFetched", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$handleResponse$2$com-bytedance-ies-web-jsbridge2-PermissionConfigRepository */
    public /* synthetic */ void m69xac72b215(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("status") == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                JSONObject optJSONObject2 = optJSONObject == null ? null : optJSONObject.optJSONObject(SchemaConstants.QUERY_KEY_PACKAGES);
                if (optJSONObject2 != null && !TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    JSONObject optJSONObject3 = jSONObject2.optJSONObject("data");
                    JSONObject optJSONObject4 = optJSONObject3 == null ? null : optJSONObject3.optJSONObject(SchemaConstants.QUERY_KEY_PACKAGES);
                    if (optJSONObject4 == null) {
                        this.configurator.provideLocalStorage().write(KEY_PERMISSION_CONFIG_RESPONSE, str);
                        return;
                    }
                    Iterator<String> keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        optJSONObject4.put(next, optJSONObject2.getJSONArray(next));
                    }
                    String jSONObject3 = jSONObject2.toString();
                    this.configurator.provideLocalStorage().write(KEY_PERMISSION_CONFIG_RESPONSE, jSONObject3);
                    parsePackageVersion(jSONObject3, TimeLineEvent.Constants.FROM_MERGE, null);
                    return;
                }
                this.configurator.provideLocalStorage().write(KEY_PERMISSION_CONFIG_RESPONSE, str);
            }
        } catch (JSONException e) {
            DebugUtil.m64e("Failed to merge response.", e);
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.EXCEPTION_NAME, e.getClass().getSimpleName()).setExtraItem(TimeLineEvent.Constants.EXCEPTION_MESSAGE, e.getMessage()).setExtraItem(TimeLineEvent.Constants.RESPONSE, str).setExtraItem(TimeLineEvent.Constants.VALUE, str2).bind(TimeLineEvent.Constants.LABEL_REPOSITORY_MERGE_CONFIG_EXCEPTION, JsBridge2.sdkInitTimeLineEvents);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parsePackageVersion(String str, String str2, String str3) {
        TimeLineEvent.Builder label = TimeLineEvent.Builder.instance().setTime().setExtraItem(TimeLineEvent.Constants.FROM, str2).setLabel(TimeLineEvent.Constants.LABEL_PARSE_PACKAGE_VERSION);
        if (!TextUtils.isEmpty(str3)) {
            label.setExtraItem(TimeLineEvent.Constants.URL, str3);
        }
        if (TextUtils.isEmpty(str)) {
            label.setExtraItem(TimeLineEvent.Constants.RESPONSE, TimeLineEvent.Constants.NULL);
            JsBridge2.sdkInitTimeLineEvents.add(label.build());
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            if (optJSONObject == null) {
                label.setExtraItem(TimeLineEvent.Constants.RESPONSE, str);
                JsBridge2.sdkInitTimeLineEvents.add(label.build());
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(SchemaConstants.QUERY_KEY_PACKAGES);
            if (optJSONObject2 == null) {
                label.setExtraItem(TimeLineEvent.Constants.RESPONSE, str);
                JsBridge2.sdkInitTimeLineEvents.add(label.build());
                return;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray jSONArray = optJSONObject2.getJSONArray(next);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    label.setExtraItem(next + RomVersionParamHelper.SEPARATOR + jSONObject.getString("channel"), Long.valueOf(jSONObject.getLong("package_version")));
                }
            }
            JsBridge2.sdkInitTimeLineEvents.add(label.build());
        } catch (JSONException e) {
            label.setExtraItem(TimeLineEvent.Constants.RESPONSE, str).setExtraItem(TimeLineEvent.Constants.EXCEPTION_NAME, e.getClass().getSimpleName()).setExtraItem(TimeLineEvent.Constants.EXCEPTION_MESSAGE, e.getMessage());
            JsBridge2.sdkInitTimeLineEvents.add(label.build());
        }
    }

    private JSONObject createFetchParamsBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CommonConstants.KEY_AID, this.configurator.provideAppId());
            jSONObject2.put("app_version", this.configurator.provideAppVersion());
            jSONObject2.put("os", 0);
            jSONObject2.put(CommonConstants.KEY_DID, this.configurator.provideDeviceId());
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("channel", "_jsb_auth");
            jSONObject3.put("local_version", 0);
            jSONArray.put(jSONObject3);
            for (String str : this.namespaces) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("channel", "_jsb_auth." + str);
                jSONObject4.put("local_version", 0);
                jSONArray.put(jSONObject4);
            }
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(this.configurator.provideGeckoAccessKey(), jSONArray);
            jSONObject.put("common", jSONObject2);
            jSONObject.put("deployment", jSONObject5);
        } catch (JSONException e) {
            DebugUtil.m64e("Failed to put params.", e);
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.EXCEPTION_NAME, e.getClass().getSimpleName()).setExtraItem(TimeLineEvent.Constants.EXCEPTION_MESSAGE, e.getMessage()).setExtraItem(TimeLineEvent.Constants.PARAM, jSONObject.toString()).bind(TimeLineEvent.Constants.LABEL_CREATE_FETCH_PARAM_EXCEPTION, JsBridge2.sdkInitTimeLineEvents);
        }
        return jSONObject;
    }

    private void parseConfigurations(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONObject("data").getJSONObject(SchemaConstants.QUERY_KEY_PACKAGES).getJSONArray(this.configurator.provideGeckoAccessKey());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString("channel");
                if (TextUtils.equals(optString, "_jsb_auth")) {
                    createOrUpdateOrGetConfig("host", jSONObject, JsBridge2.sdkInitTimeLineEvents);
                } else if (optString.startsWith("_jsb_auth.")) {
                    createOrUpdateOrGetConfig(optString.replace("_jsb_auth.", ""), jSONObject, JsBridge2.sdkInitTimeLineEvents);
                } else {
                    DebugUtil.m63e("Malformed config: " + jSONObject.toString());
                }
            }
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.KEY, this.configurator.provideGeckoAccessKey()).bind(TimeLineEvent.Constants.LABEL_REPOSITORY_PARSE_CONFIG, JsBridge2.sdkInitTimeLineEvents);
        } catch (JSONException e) {
            DebugUtil.m64e("Parse configurations failed, url: " + this.fetchUrl + ", response: " + str, e);
            TimeLineEvent.Builder extraItem = TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.EXCEPTION_NAME, e.getClass().getSimpleName()).setExtraItem(TimeLineEvent.Constants.EXCEPTION_MESSAGE, e.getMessage());
            String str2 = TimeLineEvent.Constants.RESPONSE;
            if (TextUtils.isEmpty(str)) {
                str = TimeLineEvent.Constants.NULL;
            }
            extraItem.setExtraItem(str2, str).bind(TimeLineEvent.Constants.LABEL_REPOSITORY_PARSE_CONFIG_EXCEPTION, JsBridge2.sdkInitTimeLineEvents);
        }
    }

    private PermissionConfig createOrUpdateOrGetConfig(String str, JSONObject jSONObject, List<TimeLineEvent> list) {
        PermissionConfig permissionConfig = this.configMap.get(str);
        TimeLineEvent.Builder extraItem = TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.NAMESPACE, str);
        if (permissionConfig == null) {
            PermissionConfig permissionConfig2 = new PermissionConfig(str, this.configurator.providePermissionCacheCapacity(), this.configurator.provideLocalStorage(), this.configurator.provideWorkerExecutor(), jSONObject, list);
            this.configMap.put(str, permissionConfig2);
            extraItem.bind(TimeLineEvent.Constants.LABEL_REPOSITORY_CREATE_CONFIG, list);
            return permissionConfig2;
        }
        if (jSONObject == null) {
            return permissionConfig;
        }
        permissionConfig.update(jSONObject, list);
        extraItem.bind(TimeLineEvent.Constants.LABEL_REPOSITORY_UPDATE_CONFIG, list);
        return permissionConfig;
    }

    public Map<String, PermissionConfig> getConfigMap() {
        return this.configMap;
    }
}
