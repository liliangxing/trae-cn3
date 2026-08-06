package com.bytedance.ies.web.jsbridge2;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PermissionConfig {
    private static final int DEFAULT_CACHE_CAPACITY = 16;
    private static final String KEY_PERMISSION_CONFIG_PREFIX = "com.bytedance.ies.web.jsbridge2.PermissionConfig.";
    private Map<String, List<RemoteConfig>> configListMap = new ConcurrentHashMap();
    private volatile boolean dataValid = false;
    private final IBridgePermissionConfigurator.LocalStorage localStorage;
    private final String namespace;
    private final LruCache<String, UrlBasedRule> ruleCache;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class UrlBasedRule {
        public PermissionGroup permissionGroup = PermissionGroup.PUBLIC;
        public Set<String> includedMethods = new HashSet();
        public Set<String> excludedMethods = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PermissionConfig(String str, int i, IBridgePermissionConfigurator.LocalStorage localStorage, final Executor executor, JSONObject jSONObject, final List<TimeLineEvent> list) {
        this.namespace = str;
        if (i <= 0) {
            this.ruleCache = new LruCache<>(16);
        } else {
            this.ruleCache = new LruCache<>(i);
        }
        this.localStorage = localStorage;
        if (jSONObject == null) {
            localStorage.read(getLocalConfigKey(str), new IBridgePermissionConfigurator.LocalStorage.ValueCallback() { // from class: com.bytedance.ies.web.jsbridge2.PermissionConfig.1
                @Override // com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator.LocalStorage.ValueCallback
                public void onValue(final String str2) {
                    boolean z = JsBridge2.switchConfigLazy.get() != null && JsBridge2.switchConfigLazy.get().optSwitch(SwitchConfigEnum.PERMISSION_CONFIG_SYNC_PARSE_SWITCH);
                    Runnable runnable = new Runnable() { // from class: com.bytedance.ies.web.jsbridge2.PermissionConfig.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (list != null) {
                                TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.VALUE, Boolean.valueOf(!TextUtils.isEmpty(str2))).bind(TimeLineEvent.Constants.LABEL_PERMISSION_STORAGE, list);
                            }
                            if (TextUtils.isEmpty(str2)) {
                                return;
                            }
                            try {
                                PermissionConfig.this.parseConfigurations(new JSONObject(str2), list);
                            } catch (JSONException e) {
                                DebugUtil.m64e("Parse configurations failed, local storage content: " + str2, e);
                            }
                        }
                    };
                    if (z) {
                        runnable.run();
                    } else {
                        executor.execute(runnable);
                    }
                }
            });
        } else {
            update(jSONObject, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void update(JSONObject jSONObject, List<TimeLineEvent> list) {
        parseConfigurations(jSONObject, list);
        this.localStorage.write(getLocalConfigKey(this.namespace), jSONObject.toString());
    }

    public UrlBasedRule getRule(Uri uri) {
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String builder = new Uri.Builder().scheme(scheme).authority(authority).path(uri.getPath()).toString();
        UrlBasedRule urlBasedRule = new UrlBasedRule();
        if (authority == null || authority.isEmpty()) {
            urlBasedRule.permissionGroup = PermissionGroup.PUBLIC;
            return urlBasedRule;
        }
        UrlBasedRule urlBasedRule2 = this.ruleCache.get(builder);
        if (urlBasedRule2 != null) {
            return urlBasedRule2;
        }
        try {
            return createRule(builder);
        } catch (Throwable unused) {
            return urlBasedRule2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UrlBasedRule getRule(String str, List<TimeLineEvent> list) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String builder = new Uri.Builder().scheme(scheme).authority(authority).path(parse.getPath()).toString();
        UrlBasedRule urlBasedRule = new UrlBasedRule();
        if (authority == null || authority.isEmpty()) {
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.HOST, TimeLineEvent.Constants.NULL).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_NULL_HOST, list);
            urlBasedRule.permissionGroup = PermissionGroup.PUBLIC;
            return urlBasedRule;
        }
        UrlBasedRule urlBasedRule2 = this.ruleCache.get(builder);
        if (urlBasedRule2 != null) {
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.FROM, TimeLineEvent.Constants.FROM_CACHE).setExtraItem(TimeLineEvent.Constants.RULE_PERMISSION_GROUP, urlBasedRule2.permissionGroup.toString()).setExtraItem(TimeLineEvent.Constants.RULE_INCLUDED_METHOD, urlBasedRule2.includedMethods.toString()).setExtraItem(TimeLineEvent.Constants.RULE_EXCLUDED_METHOD, urlBasedRule2.excludedMethods.toString()).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_CACHE_RULE, list);
            return urlBasedRule2;
        }
        UrlBasedRule createRule = createRule(builder, list);
        TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.FROM, TimeLineEvent.Constants.FROM_CREATE).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER, list);
        return createRule;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseConfigurations(JSONObject jSONObject, List<TimeLineEvent> list) {
        try {
            TimeLineEvent.Builder instance = TimeLineEvent.Builder.instance();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    copyOnWriteArrayList.add(parseJSONConfig(jSONArray.getJSONObject(i)));
                }
                concurrentHashMap.put(next, copyOnWriteArrayList);
                instance.setExtraItem(jSONObject.getString("channel"), Long.valueOf(jSONObject.getLong("package_version")));
            }
            this.configListMap = concurrentHashMap;
            instance.bind(TimeLineEvent.Constants.LABEL_PARSE_CONFIG, list);
        } catch (JSONException e) {
            DebugUtil.m64e("Parse configurations failed, response: " + jSONObject.toString(), e);
            if (list != null) {
                TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.EXCEPTION_NAME, e.getClass().getSimpleName()).setExtraItem(TimeLineEvent.Constants.EXCEPTION_MESSAGE, e.getMessage()).setExtraItem(TimeLineEvent.Constants.VALUE, jSONObject.toString()).bind(TimeLineEvent.Constants.LABEL_PARSE_CONFIG_EXCEPTION, list);
            }
        }
        this.ruleCache.evictAll();
        this.dataValid = true;
    }

    private UrlBasedRule createRule(String str) throws IllegalRemoteConfigException {
        UrlBasedRule urlBasedRule = new UrlBasedRule();
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String shortenedHost = getShortenedHost(authority);
        if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(authority) || shortenedHost == null) {
            this.ruleCache.put(str, urlBasedRule);
            return urlBasedRule;
        }
        List<RemoteConfig> remoteConfigList = getRemoteConfigList(shortenedHost);
        if (remoteConfigList == null) {
            urlBasedRule.permissionGroup = PermissionGroup.PUBLIC;
            this.ruleCache.put(str, urlBasedRule);
            return urlBasedRule;
        }
        for (RemoteConfig remoteConfig : remoteConfigList) {
            if (remoteConfig.pattern.matcher(str).find()) {
                if (remoteConfig.permissionGroup.compareTo(urlBasedRule.permissionGroup) >= 0) {
                    urlBasedRule.permissionGroup = remoteConfig.permissionGroup;
                }
                urlBasedRule.includedMethods.addAll(remoteConfig.includedMethods);
                urlBasedRule.excludedMethods.addAll(remoteConfig.excludedMethods);
            }
        }
        this.ruleCache.put(str, urlBasedRule);
        return urlBasedRule;
    }

    private UrlBasedRule createRule(String str, List<TimeLineEvent> list) throws IllegalRemoteConfigException {
        UrlBasedRule urlBasedRule = new UrlBasedRule();
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String shortenedHost = getShortenedHost(authority);
        if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(authority) || shortenedHost == null) {
            this.ruleCache.put(str, urlBasedRule);
            return urlBasedRule;
        }
        List<RemoteConfig> remoteConfigList = getRemoteConfigList(shortenedHost);
        TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.SHORTENED_HOST, shortenedHost).setExtraItem(TimeLineEvent.Constants.CONFIG_SIZE, remoteConfigList == null ? TimeLineEvent.Constants.NULL : Integer.valueOf(remoteConfigList.size())).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_REMOTE_CONFIG, list);
        if (remoteConfigList == null) {
            urlBasedRule.permissionGroup = PermissionGroup.PUBLIC;
            this.ruleCache.put(str, urlBasedRule);
            return urlBasedRule;
        }
        for (RemoteConfig remoteConfig : remoteConfigList) {
            if (remoteConfig.pattern.matcher(str).find()) {
                if (remoteConfig.permissionGroup.compareTo(urlBasedRule.permissionGroup) >= 0) {
                    urlBasedRule.permissionGroup = remoteConfig.permissionGroup;
                }
                urlBasedRule.includedMethods.addAll(remoteConfig.includedMethods);
                urlBasedRule.excludedMethods.addAll(remoteConfig.excludedMethods);
            }
        }
        this.ruleCache.put(str, urlBasedRule);
        TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.FROM, TimeLineEvent.Constants.FROM_MERGE).setExtraItem(TimeLineEvent.Constants.RULE_PERMISSION_GROUP, urlBasedRule.permissionGroup.toString()).setExtraItem(TimeLineEvent.Constants.RULE_INCLUDED_METHOD, urlBasedRule.includedMethods.toString()).setExtraItem(TimeLineEvent.Constants.RULE_EXCLUDED_METHOD, urlBasedRule.excludedMethods.toString()).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER_MERGE_REMOTE_CONFIG, list);
        return urlBasedRule;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class IllegalRemoteConfigException extends IllegalStateException {
        /* JADX INFO: Access modifiers changed from: package-private */
        public IllegalRemoteConfigException(String str) {
            super(str);
        }
    }

    public static String getShortenedHost(String str) {
        String[] split;
        int length;
        if (str != null && (length = (split = str.split("[.]")).length) >= 2) {
            return length == 2 ? str : split[length - 2] + LibrarianImpl.Constants.DOT + split[length - 1];
        }
        return null;
    }

    public List<RemoteConfig> getRemoteConfigList(String str) throws IllegalRemoteConfigException {
        if (!this.dataValid) {
            throw new IllegalRemoteConfigException("Permission config is outdated!");
        }
        return this.configListMap.get(str);
    }

    private static RemoteConfig parseJSONConfig(JSONObject jSONObject) throws JSONException {
        RemoteConfig remoteConfig = new RemoteConfig();
        remoteConfig.pattern = Pattern.compile(jSONObject.getString("pattern"));
        remoteConfig.permissionGroup = PermissionGroup.from(jSONObject.getString("group"));
        remoteConfig.includedMethods = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("included_methods");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                remoteConfig.includedMethods.add(optJSONArray.getString(i));
            }
        }
        remoteConfig.excludedMethods = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                remoteConfig.excludedMethods.add(optJSONArray2.getString(i2));
            }
        }
        return remoteConfig;
    }

    private static String getLocalConfigKey(String str) {
        return KEY_PERMISSION_CONFIG_PREFIX + str;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class RemoteConfig {
        public List<String> excludedMethods;
        public List<String> includedMethods;
        public Pattern pattern;
        public PermissionGroup permissionGroup;

        public String toString() {
            return "RemoteConfig{pattern=" + this.pattern + ", permissionGroup=" + this.permissionGroup + ", includedMethods=" + this.includedMethods + ", excludedMethods=" + this.excludedMethods + '}';
        }
    }

    public PermissionGroup getPermissionGroup(String str) {
        List<RemoteConfig> list;
        PermissionGroup permissionGroup = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String shortenedHost = getShortenedHost(authority);
        if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(authority) && shortenedHost != null) {
            try {
                list = getRemoteConfigList(shortenedHost);
            } catch (IllegalRemoteConfigException unused) {
                list = null;
            }
            if (list == null) {
                return null;
            }
            for (RemoteConfig remoteConfig : list) {
                if (remoteConfig.pattern.matcher(str).find() && (permissionGroup == null || remoteConfig.permissionGroup.compareTo(permissionGroup) >= 0)) {
                    permissionGroup = remoteConfig.permissionGroup;
                }
            }
        }
        return permissionGroup;
    }

    public Map<String, List<RemoteConfig>> getConfigListMap() {
        return this.configListMap;
    }
}
