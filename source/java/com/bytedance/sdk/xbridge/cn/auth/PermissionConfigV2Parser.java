package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigBean;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigType;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigV1Bean;
import com.bytedance.sdk.xbridge.cn.auth.bean.ConfigWithSwitch;
import com.bytedance.sdk.xbridge.cn.auth.bean.ConfigWithSwitchLazy;
import com.bytedance.sdk.xbridge.cn.auth.bean.LynxAuthSwitch;
import com.bytedance.sdk.xbridge.cn.auth.bean.MethodCallLimitsBean;
import com.bytedance.sdk.xbridge.cn.auth.bean.PublicKey;
import com.bytedance.sdk.xbridge.cn.auth.depend.ILogDepend;
import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PermissionConfigV2Parser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0004J\u001c\u0010\u001b\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0007J$\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0018\u00010\u001e2\b\b\u0002\u0010\u0015\u001a\u00020\u0004J\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0004J\u001a\u0010#\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020%2\b\b\u0002\u0010\u0015\u001a\u00020\u0004J\u0014\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010(\u001a\u00020\u0004J\u0010\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0015\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020\u0004J\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u001eJ\u0006\u0010-\u001a\u00020\tJ0\u0010.\u001a\u00020\u00142\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u00102\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004J$\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u001e\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002050\u001e2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0010\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u000200H\u0002J\u0018\u00108\u001a\b\u0012\u0004\u0012\u00020 092\b\u0010:\u001a\u0004\u0018\u000105H\u0002J\u001e\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u001e2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u001e\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002000\u001e2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0012\u0010=\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0012\u0010>\u001a\u00020%2\b\u0010?\u001a\u0004\u0018\u000100H\u0002J\u0014\u0010@\u001a\u0004\u0018\u0001002\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u001c\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020B0\u001e2\u0006\u00107\u001a\u000200H\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010\u00042\u0006\u0010/\u001a\u000200H\u0002J\u000e\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\u0004J\u000e\u0010F\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eJ;\u0010G\u001a\b\u0012\u0004\u0012\u0002HH0\u001f\"\u0004\b\u0000\u0010H*\u0002052!\u0010I\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(M\u0012\u0004\u0012\u0002HH0JH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/PermissionConfigV2Parser;", "", "()V", "CUSTOM_CHANNEL_PREFIX", "", "HOST_CHANNEL", "HOST_NAMESPACE", "isContentParsed", "Ljava/util/concurrent/ConcurrentHashMap;", "", "isContentV2Parsed", "isSettingsParsed", "loaderName", "logDepend", "Lcom/bytedance/sdk/xbridge/cn/auth/depend/ILogDepend;", "permissionConfigMapV2", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/ConfigWithSwitch;", "permissionConfigMapV2Lazy", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/ConfigWithSwitchLazy;", "coverJsonToContent", "", LynxBridgeCall.NAME_SPACE, "coverJsonToContentV2", "coverJsonToSettings", "getAuthConfig", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigBean;", "appId", "getAuthConfigFromLazy", "getConfigWithSwitch", "getContentAuthConfig", "", "", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigV1Bean;", "getContentAuthConfigBasedHost", PermissionConfigParser.WEBCAST_HOST_NAMESPACE, "getContentAuthConfigBasedHostFromLazy", "getLynxAuthSwitch", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/LynxAuthSwitch;", "getNamespaceByChannel", Constant.KEY_CHANNEL, "getPackageLoaderName", "getPackageVersion", "", "getPublicKeys", "getWholeContentV2AuthConfig", "isPermissionConfigEmpty", "parse", "config", "Lorg/json/JSONObject;", "accessKey", "isLazyParse", "parseContent", "parseContentLazyParse", "Lorg/json/JSONArray;", "parseContentPerAppID", "configDetail", "parseContentPerHost", "", "configList", "parseContentV2", "parseContentV2LazyParse", "parseLynxGlobalSettings", "parseLynxGlobalSettingsInner", "settings", "parseLynxGlobalSettingsLazy", "parseMethodCallLimits", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/MethodCallLimitsBean;", "parseNamespace", "printLog", "msg", "setLogDepend", "map", "T", "cb", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "item", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PermissionConfigV2Parser {
    private static final String CUSTOM_CHANNEL_PREFIX = "_jsb_auth.";
    private static final String HOST_CHANNEL = "_jsb_auth";
    public static final String HOST_NAMESPACE = "";
    private static String loaderName;
    private static ILogDepend logDepend;
    public static final PermissionConfigV2Parser INSTANCE = new PermissionConfigV2Parser();
    private static final ConcurrentHashMap<String, ConfigWithSwitch> permissionConfigMapV2 = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, ConfigWithSwitchLazy> permissionConfigMapV2Lazy = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> isContentParsed = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> isContentV2Parsed = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> isSettingsParsed = new ConcurrentHashMap<>();

    private PermissionConfigV2Parser() {
    }

    public final void setLogDepend(ILogDepend logDepend2) {
        Intrinsics.checkNotNullParameter(logDepend2, "logDepend");
        logDepend = logDepend2;
    }

    public final void printLog(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        ILogDepend iLogDepend = logDepend;
        if (iLogDepend != null) {
            iLogDepend.log("PermissionConfigV2Parser", msg);
        }
    }

    public static /* synthetic */ void parse$default(PermissionConfigV2Parser permissionConfigV2Parser, JSONObject jSONObject, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        permissionConfigV2Parser.parse(jSONObject, str, z, str2);
    }

    public final void parse(JSONObject config, String accessKey, boolean isLazyParse, String loaderName2) {
        JSONObject optJSONObject;
        if (config == null || accessKey == null) {
            return;
        }
        JSONObject optJSONObject2 = config.optJSONObject("data");
        JSONArray optJSONArray = (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("packages")) == null) ? null : optJSONObject.optJSONArray(accessKey);
        if (optJSONArray == null) {
            return;
        }
        loaderName = loaderName2;
        printLog("parse config from loader " + loaderName2 + ", accessKey: " + accessKey + ", config size: " + optJSONArray.length());
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(optJSONObject3, "itemConfig");
            String parseNamespace = parseNamespace(optJSONObject3);
            if (parseNamespace != null) {
                int optInt = optJSONObject3.optInt("package_version", -1);
                printLog("parse namespace: " + parseNamespace + ", package version: " + optInt);
                if (!isLazyParse) {
                    LynxAuthSwitch parseLynxGlobalSettings = parseLynxGlobalSettings(optJSONObject3);
                    ConcurrentHashMap<String, ConfigWithSwitch> concurrentHashMap = permissionConfigMapV2;
                    ConfigWithSwitch configWithSwitch = new ConfigWithSwitch(parseContent(optJSONObject3), parseContentV2(optJSONObject3), parseLynxGlobalSettings);
                    configWithSwitch.setPackageVersion(optInt);
                    concurrentHashMap.put(parseNamespace, configWithSwitch);
                    isContentParsed.put(parseNamespace, true);
                    isContentV2Parsed.put(parseNamespace, true);
                    isSettingsParsed.put(parseNamespace, true);
                } else {
                    ConcurrentHashMap<String, ConfigWithSwitch> concurrentHashMap2 = permissionConfigMapV2;
                    ConfigWithSwitch configWithSwitch2 = new ConfigWithSwitch(new LinkedHashMap(), new LinkedHashMap(), new LynxAuthSwitch(0, false, false, 7, null));
                    configWithSwitch2.setPackageVersion(optInt);
                    concurrentHashMap2.put(parseNamespace, configWithSwitch2);
                    permissionConfigMapV2Lazy.put(parseNamespace, new ConfigWithSwitchLazy(parseContentLazyParse(optJSONObject3), parseContentV2LazyParse(optJSONObject3), parseLynxGlobalSettingsLazy(optJSONObject3)));
                    isContentParsed.put(parseNamespace, false);
                    isContentV2Parsed.put(parseNamespace, false);
                    isSettingsParsed.put(parseNamespace, false);
                }
            }
        }
    }

    public final boolean isPermissionConfigEmpty() {
        return permissionConfigMapV2.isEmpty();
    }

    public static /* synthetic */ AuthConfigBean getAuthConfig$default(PermissionConfigV2Parser permissionConfigV2Parser, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return permissionConfigV2Parser.getAuthConfig(str, str2);
    }

    public final AuthConfigBean getAuthConfig(String appId, String namespace) {
        Map<String, AuthConfigBean> contentV2;
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        getAuthConfigFromLazy(appId, namespace);
        ConfigWithSwitch configWithSwitch = permissionConfigMapV2.get(namespace);
        if (configWithSwitch == null || (contentV2 = configWithSwitch.getContentV2()) == null) {
            return null;
        }
        return contentV2.get(appId);
    }

    public static /* synthetic */ ConfigWithSwitch getConfigWithSwitch$default(PermissionConfigV2Parser permissionConfigV2Parser, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return permissionConfigV2Parser.getConfigWithSwitch(str);
    }

    @Deprecated(message = "no used")
    public final ConfigWithSwitch getConfigWithSwitch(String namespace) {
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        coverJsonToSettings(namespace);
        coverJsonToContentV2(namespace);
        coverJsonToContent(namespace);
        return permissionConfigMapV2.get(namespace);
    }

    public static /* synthetic */ LynxAuthSwitch getLynxAuthSwitch$default(PermissionConfigV2Parser permissionConfigV2Parser, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return permissionConfigV2Parser.getLynxAuthSwitch(str);
    }

    public final LynxAuthSwitch getLynxAuthSwitch(String namespace) {
        LynxAuthSwitch settings;
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        coverJsonToSettings(namespace);
        ConfigWithSwitch configWithSwitch = permissionConfigMapV2.get(namespace);
        return (configWithSwitch == null || (settings = configWithSwitch.getSettings()) == null) ? new LynxAuthSwitch(0, false, false, 7, null) : settings;
    }

    public final Map<String, AuthConfigBean> getWholeContentV2AuthConfig() {
        Map<String, AuthConfigBean> contentV2;
        coverJsonToContentV2("");
        ConfigWithSwitch configWithSwitch = permissionConfigMapV2.get("");
        return (configWithSwitch == null || (contentV2 = configWithSwitch.getContentV2()) == null) ? MapsKt.emptyMap() : contentV2;
    }

    public static /* synthetic */ List getContentAuthConfigBasedHost$default(PermissionConfigV2Parser permissionConfigV2Parser, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return permissionConfigV2Parser.getContentAuthConfigBasedHost(str, str2);
    }

    public final List<AuthConfigV1Bean> getContentAuthConfigBasedHost(String host, String namespace) {
        Map<String, List<AuthConfigV1Bean>> content;
        List<AuthConfigV1Bean> list;
        Intrinsics.checkNotNullParameter(host, PermissionConfigParser.WEBCAST_HOST_NAMESPACE);
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        getContentAuthConfigBasedHostFromLazy(host, namespace);
        ConfigWithSwitch configWithSwitch = permissionConfigMapV2.get(namespace);
        return (configWithSwitch == null || (content = configWithSwitch.getContent()) == null || (list = content.get(host)) == null) ? CollectionsKt.emptyList() : list;
    }

    public static /* synthetic */ Map getContentAuthConfig$default(PermissionConfigV2Parser permissionConfigV2Parser, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return permissionConfigV2Parser.getContentAuthConfig(str);
    }

    public final Map<String, List<AuthConfigV1Bean>> getContentAuthConfig(String namespace) {
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        coverJsonToContent(namespace);
        ConfigWithSwitch configWithSwitch = permissionConfigMapV2.get(namespace);
        if (configWithSwitch != null) {
            return configWithSwitch.getContent();
        }
        return null;
    }

    public static /* synthetic */ int getPackageVersion$default(PermissionConfigV2Parser permissionConfigV2Parser, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return permissionConfigV2Parser.getPackageVersion(str);
    }

    public final int getPackageVersion(String namespace) {
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        ConcurrentHashMap<String, ConfigWithSwitch> concurrentHashMap = permissionConfigMapV2;
        ConfigWithSwitch configWithSwitch = concurrentHashMap.get(namespace);
        if (configWithSwitch == null && (configWithSwitch = concurrentHashMap.get("")) == null) {
            return -1;
        }
        return configWithSwitch.getPackageVersion();
    }

    public final String getPackageLoaderName() {
        String str = loaderName;
        return str == null ? "unknown" : str;
    }

    public final String getPublicKeys() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = getWholeContentV2AuthConfig().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            AuthConfigBean authConfigBean = (AuthConfigBean) entry.getValue();
            if (authConfigBean.getType() == AuthConfigType.LYNX) {
                linkedHashMap.put(str, authConfigBean.getPublic_key().getRsa());
            }
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            jSONObject.put((String) entry2.getKey(), (String) entry2.getValue());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    private final String parseNamespace(JSONObject config) {
        return getNamespaceByChannel(config.optString(Constant.KEY_CHANNEL));
    }

    private final String getNamespaceByChannel(String channel) {
        if (channel == null) {
            return null;
        }
        if (Intrinsics.areEqual(channel, HOST_CHANNEL)) {
            return "";
        }
        if (StringsKt.startsWith$default(channel, CUSTOM_CHANNEL_PREFIX, false, 2, (Object) null)) {
            return StringsKt.replace$default(channel, CUSTOM_CHANNEL_PREFIX, "", false, 4, (Object) null);
        }
        return null;
    }

    private final Map<String, List<AuthConfigV1Bean>> parseContent(JSONObject config) {
        Iterator<String> keys;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject optJSONObject = config != null ? config.optJSONObject(ReportConstant.COMMON_CONTENT) : null;
        if (optJSONObject != null && (keys = optJSONObject.keys()) != null) {
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = optJSONObject.optJSONArray(next);
                if (optJSONArray != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONArray, "configList");
                    List<AuthConfigV1Bean> parseContentPerHost = INSTANCE.parseContentPerHost(optJSONArray);
                    Intrinsics.checkNotNullExpressionValue(next, PermissionConfigParser.WEBCAST_HOST_NAMESPACE);
                    linkedHashMap.put(next, parseContentPerHost);
                }
            }
        }
        return linkedHashMap;
    }

    private final Map<String, JSONArray> parseContentLazyParse(JSONObject config) {
        Iterator<String> keys;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject optJSONObject = config != null ? config.optJSONObject(ReportConstant.COMMON_CONTENT) : null;
        if (optJSONObject != null && (keys = optJSONObject.keys()) != null) {
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = optJSONObject.optJSONArray(next);
                if (optJSONArray != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONArray, "configList");
                    Intrinsics.checkNotNullExpressionValue(next, PermissionConfigParser.WEBCAST_HOST_NAMESPACE);
                    linkedHashMap.put(next, optJSONArray);
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
    
        if (r4 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004a, code lost:
    
        if (r4 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<AuthConfigV1Bean> parseContentPerHost(JSONArray configList) {
        List emptyList;
        List emptyList2;
        ArrayList arrayList = new ArrayList();
        if (configList != null) {
            int length = configList.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = configList.optJSONObject(i);
                String optString = optJSONObject.optString("pattern");
                Intrinsics.checkNotNullExpressionValue(optString, "configObj.optString(\"pattern\")");
                AuthBridgeAccess.Companion companion = AuthBridgeAccess.INSTANCE;
                String optString2 = optJSONObject.optString("group");
                Intrinsics.checkNotNullExpressionValue(optString2, "configObj.optString(\"group\")");
                AuthBridgeAccess access = companion.getAccess(optString2);
                JSONArray optJSONArray = optJSONObject.optJSONArray("included_methods");
                if (optJSONArray != null) {
                    PermissionConfigV2Parser permissionConfigV2Parser = INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(\"included_methods\")");
                    emptyList = permissionConfigV2Parser.map(optJSONArray, new Function1<Object, String>() { // from class: com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser$parseContentPerHost$1$authConfig$1
                        public final String invoke(Object obj) {
                            Intrinsics.checkNotNullParameter(obj, "it");
                            return obj.toString();
                        }
                    });
                }
                emptyList = CollectionsKt.emptyList();
                List list = emptyList;
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("excluded_methods");
                if (optJSONArray2 != null) {
                    PermissionConfigV2Parser permissionConfigV2Parser2 = INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(optJSONArray2, "optJSONArray(\"excluded_methods\")");
                    emptyList2 = permissionConfigV2Parser2.map(optJSONArray2, new Function1<Object, String>() { // from class: com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser$parseContentPerHost$1$authConfig$2
                        public final String invoke(Object obj) {
                            Intrinsics.checkNotNullParameter(obj, "it");
                            return obj.toString();
                        }
                    });
                }
                emptyList2 = CollectionsKt.emptyList();
                arrayList.add(new AuthConfigV1Bean(optString, access, list, emptyList2, optJSONObject.has("appid") ? Long.valueOf(optJSONObject.optLong("appid")) : null));
            }
        }
        return arrayList;
    }

    private final Map<String, AuthConfigBean> parseContentV2(JSONObject config) {
        Iterator<String> keys;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject optJSONObject = config != null ? config.optJSONObject("content_v2") : null;
        if (optJSONObject != null && (keys = optJSONObject.keys()) != null) {
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                if (optJSONObject2 != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject2, "configDetail");
                    Intrinsics.checkNotNullExpressionValue(next, "appId");
                    linkedHashMap.put(next, INSTANCE.parseContentPerAppID(optJSONObject2));
                }
            }
        }
        return linkedHashMap;
    }

    private final Map<String, JSONObject> parseContentV2LazyParse(JSONObject config) {
        Iterator<String> keys;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject optJSONObject = config != null ? config.optJSONObject("content_v2") : null;
        if (optJSONObject != null && (keys = optJSONObject.keys()) != null) {
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                if (optJSONObject2 != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject2, "configDetail");
                    Intrinsics.checkNotNullExpressionValue(next, "appId");
                    linkedHashMap.put(next, optJSONObject2);
                }
            }
        }
        return linkedHashMap;
    }

    private final AuthConfigBean parseContentPerAppID(JSONObject configDetail) {
        List emptyList;
        List emptyList2;
        List emptyList3;
        Map<String, MethodCallLimitsBean> parseMethodCallLimits = parseMethodCallLimits(configDetail);
        AuthConfigType.Companion companion = AuthConfigType.INSTANCE;
        String optString = configDetail.optString(DBData.FIELD_TYPE);
        Intrinsics.checkNotNullExpressionValue(optString, "configDetail.optString(\"type\")");
        AuthConfigType type = companion.getType(optString);
        JSONArray optJSONArray = configDetail.optJSONArray("safe_urls");
        if (optJSONArray == null || (emptyList = map(optJSONArray, new Function1<Object, String>() { // from class: com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser$parseContentPerAppID$lynxAuthConfigBean$1
            public final String invoke(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "it");
                return obj.toString();
            }
        })) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        List list = emptyList;
        JSONObject optJSONObject = configDetail.optJSONObject("public_key");
        String optString2 = optJSONObject != null ? optJSONObject.optString("RSA") : null;
        if (optString2 == null) {
            optString2 = "";
        }
        PublicKey publicKey = new PublicKey(optString2);
        AuthBridgeAccess.Companion companion2 = AuthBridgeAccess.INSTANCE;
        String optString3 = configDetail.optString("group");
        Intrinsics.checkNotNullExpressionValue(optString3, "configDetail.optString(\"group\")");
        AuthBridgeAccess access = companion2.getAccess(optString3);
        JSONArray optJSONArray2 = configDetail.optJSONArray("included_methods");
        if (optJSONArray2 == null || (emptyList2 = map(optJSONArray2, new Function1<Object, String>() { // from class: com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser$parseContentPerAppID$lynxAuthConfigBean$2
            public final String invoke(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "it");
                return obj.toString();
            }
        })) == null) {
            emptyList2 = CollectionsKt.emptyList();
        }
        List list2 = emptyList2;
        JSONArray optJSONArray3 = configDetail.optJSONArray("excluded_methods");
        if (optJSONArray3 == null || (emptyList3 = map(optJSONArray3, new Function1<Object, String>() { // from class: com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser$parseContentPerAppID$lynxAuthConfigBean$3
            public final String invoke(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "it");
                return obj.toString();
            }
        })) == null) {
            emptyList3 = CollectionsKt.emptyList();
        }
        return new AuthConfigBean(type, list, publicKey, access, list2, emptyList3, parseMethodCallLimits, configDetail.optInt("v", 1));
    }

    private final Map<String, MethodCallLimitsBean> parseMethodCallLimits(JSONObject configDetail) {
        List list;
        JSONArray optJSONArray;
        JSONObject optJSONObject = configDetail.optJSONObject("method_call_limits");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = optJSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "methodCallLimitRaw.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNullExpressionValue(next, "method");
            Integer valueOf = Integer.valueOf(optJSONObject.optJSONObject(next).optInt("runtime_call_count"));
            String optString = optJSONObject.optJSONObject(next).optString("runtime_call_frequency");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
            if (optJSONObject2 == null || (optJSONArray = optJSONObject2.optJSONArray(IWeixinService.ResponseConstants.URL)) == null) {
                list = null;
            } else {
                PermissionConfigV2Parser permissionConfigV2Parser = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(\"url\")");
                list = permissionConfigV2Parser.map(optJSONArray, new Function1<Object, String>() { // from class: com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser$parseMethodCallLimits$1$1
                    public final String invoke(Object obj) {
                        Intrinsics.checkNotNullParameter(obj, "it");
                        return obj.toString();
                    }
                });
            }
            linkedHashMap.put(next, new MethodCallLimitsBean(valueOf, optString, list));
        }
        return linkedHashMap;
    }

    private final LynxAuthSwitch parseLynxGlobalSettings(JSONObject config) {
        return parseLynxGlobalSettingsInner(config != null ? config.optJSONObject("lynx_global_settings") : null);
    }

    private final JSONObject parseLynxGlobalSettingsLazy(JSONObject config) {
        if (config != null) {
            return config.optJSONObject("lynx_global_settings");
        }
        return null;
    }

    private final LynxAuthSwitch parseLynxGlobalSettingsInner(JSONObject settings) {
        boolean z = false;
        int optInt = settings != null ? settings.optInt("sign_verify_mode") : 0;
        boolean z2 = settings != null && settings.optInt("enable_jsb_auth") == 1;
        if (settings != null && settings.optInt("enable_jsb_call_limit") == 1) {
            z = true;
        }
        return new LynxAuthSwitch(optInt, z2, z);
    }

    private final <T> List<T> map(JSONArray jSONArray, Function1<Object, ? extends T> function1) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object opt = jSONArray.opt(i);
            Intrinsics.checkNotNullExpressionValue(opt, "opt(i)");
            arrayList.add(function1.invoke(opt));
        }
        return arrayList;
    }

    static /* synthetic */ void getContentAuthConfigBasedHostFromLazy$default(PermissionConfigV2Parser permissionConfigV2Parser, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        permissionConfigV2Parser.getContentAuthConfigBasedHostFromLazy(str, str2);
    }

    private final void getContentAuthConfigBasedHostFromLazy(String host, String namespace) {
        ConfigWithSwitchLazy configWithSwitchLazy;
        Map<String, JSONArray> contentJson;
        JSONArray jSONArray;
        ConfigWithSwitch configWithSwitch;
        Map<String, List<AuthConfigV1Bean>> content;
        Map<String, List<AuthConfigV1Bean>> content2;
        Map<String, List<AuthConfigV1Bean>> content3;
        ConcurrentHashMap<String, ConfigWithSwitch> concurrentHashMap = permissionConfigMapV2;
        ConfigWithSwitch configWithSwitch2 = concurrentHashMap.get(namespace);
        if (((configWithSwitch2 == null || (content3 = configWithSwitch2.getContent()) == null) ? null : content3.get(host)) != null || (configWithSwitchLazy = permissionConfigMapV2Lazy.get(namespace)) == null || (contentJson = configWithSwitchLazy.getContentJson()) == null || (jSONArray = contentJson.get(host)) == null) {
            return;
        }
        synchronized (concurrentHashMap) {
            ConfigWithSwitch configWithSwitch3 = concurrentHashMap.get(namespace);
            if (((configWithSwitch3 == null || (content2 = configWithSwitch3.getContent()) == null) ? null : content2.get(host)) == null && (configWithSwitch = concurrentHashMap.get(namespace)) != null && (content = configWithSwitch.getContent()) != null) {
                Map<String, List<AuthConfigV1Bean>> map = TypeIntrinsics.isMutableMap(content) ? content : null;
                if (map != null) {
                    map.put(host, INSTANCE.parseContentPerHost(jSONArray));
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    static /* synthetic */ void getAuthConfigFromLazy$default(PermissionConfigV2Parser permissionConfigV2Parser, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        permissionConfigV2Parser.getAuthConfigFromLazy(str, str2);
    }

    private final void getAuthConfigFromLazy(String appId, String namespace) {
        ConfigWithSwitchLazy configWithSwitchLazy;
        Map<String, JSONObject> contentV2Json;
        JSONObject jSONObject;
        ConfigWithSwitch configWithSwitch;
        Map<String, AuthConfigBean> contentV2;
        Map<String, AuthConfigBean> contentV22;
        Map<String, AuthConfigBean> contentV23;
        if (appId == null) {
            return;
        }
        ConcurrentHashMap<String, ConfigWithSwitch> concurrentHashMap = permissionConfigMapV2;
        ConfigWithSwitch configWithSwitch2 = concurrentHashMap.get(namespace);
        if (((configWithSwitch2 == null || (contentV23 = configWithSwitch2.getContentV2()) == null) ? null : contentV23.get(appId)) != null || (configWithSwitchLazy = permissionConfigMapV2Lazy.get(namespace)) == null || (contentV2Json = configWithSwitchLazy.getContentV2Json()) == null || (jSONObject = contentV2Json.get(appId)) == null) {
            return;
        }
        synchronized (concurrentHashMap) {
            ConfigWithSwitch configWithSwitch3 = concurrentHashMap.get(namespace);
            if (((configWithSwitch3 == null || (contentV22 = configWithSwitch3.getContentV2()) == null) ? null : contentV22.get(appId)) == null && (configWithSwitch = concurrentHashMap.get(namespace)) != null && (contentV2 = configWithSwitch.getContentV2()) != null) {
                Map<String, AuthConfigBean> map = TypeIntrinsics.isMutableMap(contentV2) ? contentV2 : null;
                if (map != null) {
                    map.put(appId, INSTANCE.parseContentPerAppID(jSONObject));
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void coverJsonToContent(String namespace) {
        Map<String, JSONArray> contentJson;
        Map<String, List<AuthConfigV1Bean>> content;
        if (isContentParsed.get(namespace) != null) {
            Boolean bool = isContentParsed.get(namespace);
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                return;
            }
            ConcurrentHashMap<String, ConfigWithSwitchLazy> concurrentHashMap = permissionConfigMapV2Lazy;
            ConfigWithSwitchLazy configWithSwitchLazy = concurrentHashMap.get(namespace);
            if ((configWithSwitchLazy != null ? configWithSwitchLazy.getContentJson() : null) == null) {
                return;
            }
            synchronized (isContentParsed) {
                ConfigWithSwitchLazy configWithSwitchLazy2 = concurrentHashMap.get(namespace);
                if (configWithSwitchLazy2 != null && (contentJson = configWithSwitchLazy2.getContentJson()) != null) {
                    for (Map.Entry<String, JSONArray> entry : contentJson.entrySet()) {
                        ConfigWithSwitch configWithSwitch = permissionConfigMapV2.get(namespace);
                        if (configWithSwitch != null && (content = configWithSwitch.getContent()) != null && content.get(entry.getKey()) == null) {
                            if (!TypeIntrinsics.isMutableMap(content)) {
                                content = null;
                            }
                            if (content != null) {
                                content.put(entry.getKey(), INSTANCE.parseContentPerHost(entry.getValue()));
                            }
                        }
                    }
                }
                isContentParsed.put(namespace, true);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void coverJsonToContentV2(String namespace) {
        Map<String, JSONObject> contentV2Json;
        Map<String, AuthConfigBean> contentV2;
        if (isContentV2Parsed.get(namespace) != null) {
            Boolean bool = isContentV2Parsed.get(namespace);
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                return;
            }
            ConcurrentHashMap<String, ConfigWithSwitchLazy> concurrentHashMap = permissionConfigMapV2Lazy;
            ConfigWithSwitchLazy configWithSwitchLazy = concurrentHashMap.get(namespace);
            if ((configWithSwitchLazy != null ? configWithSwitchLazy.getContentV2Json() : null) == null) {
                return;
            }
            synchronized (isContentV2Parsed) {
                ConfigWithSwitchLazy configWithSwitchLazy2 = concurrentHashMap.get(namespace);
                if (configWithSwitchLazy2 != null && (contentV2Json = configWithSwitchLazy2.getContentV2Json()) != null) {
                    for (Map.Entry<String, JSONObject> entry : contentV2Json.entrySet()) {
                        ConfigWithSwitch configWithSwitch = permissionConfigMapV2.get(namespace);
                        if (configWithSwitch != null && (contentV2 = configWithSwitch.getContentV2()) != null && contentV2.get(entry.getKey()) == null) {
                            if (!TypeIntrinsics.isMutableMap(contentV2)) {
                                contentV2 = null;
                            }
                            if (contentV2 != null) {
                                contentV2.put(entry.getKey(), INSTANCE.parseContentPerAppID(entry.getValue()));
                            }
                        }
                    }
                }
                isContentV2Parsed.put(namespace, true);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void coverJsonToSettings(String namespace) {
        if (isSettingsParsed.get(namespace) != null) {
            Boolean bool = isSettingsParsed.get(namespace);
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                return;
            }
            ConcurrentHashMap<String, ConfigWithSwitchLazy> concurrentHashMap = permissionConfigMapV2Lazy;
            ConfigWithSwitchLazy configWithSwitchLazy = concurrentHashMap.get(namespace);
            if ((configWithSwitchLazy != null ? configWithSwitchLazy.getSettingsJson() : null) == null) {
                return;
            }
            synchronized (isSettingsParsed) {
                ConfigWithSwitch configWithSwitch = permissionConfigMapV2.get(namespace);
                if (configWithSwitch != null) {
                    PermissionConfigV2Parser permissionConfigV2Parser = INSTANCE;
                    ConfigWithSwitchLazy configWithSwitchLazy2 = concurrentHashMap.get(namespace);
                    configWithSwitch.setSettings(permissionConfigV2Parser.parseLynxGlobalSettingsInner(configWithSwitchLazy2 != null ? configWithSwitchLazy2.getSettingsJson() : null));
                }
                isSettingsParsed.put(namespace, true);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
