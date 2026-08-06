package com.bytedance.ies.tools.prefetch;

import android.text.TextUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PrefetchConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006BG\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\u0010\rJ \u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\b\u0010 \u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003H\u0002J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0003H\u0002J\u001c\u0010(\u001a\u00020$2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030*H\u0002J\u001a\u0010+\u001a\u00020,2\b\u0010 \u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020\"H\u0002R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u001b\u0010\u0017\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000f¨\u0006-"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/Rule;", "", "ruleName", "", "jsonObject", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "hostReg", "hashReg", "query", "", "prefetchApis", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "getHashReg", "()Ljava/lang/String;", "hashRegMatcher", "Lkotlin/text/Regex;", "getHashRegMatcher", "()Lkotlin/text/Regex;", "hashRegMatcher$delegate", "Lkotlin/Lazy;", "getHostReg", "hostRegMatcher", "getHostRegMatcher", "hostRegMatcher$delegate", "getPrefetchApis", "()Ljava/util/List;", "getQuery", "()Ljava/util/Map;", "getRuleName", "getMatchApisName", "logKey", "uriWrapper", "Lcom/bytedance/ies/tools/prefetch/UriWrapper;", "matchHash", "", "hash", "matchHost", "host", "matchQuery", "queryOnUri", "Ljava/util/SortedMap;", "printLog", "", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class Rule {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Rule.class), "hostRegMatcher", "getHostRegMatcher()Lkotlin/text/Regex;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Rule.class), "hashRegMatcher", "getHashRegMatcher()Lkotlin/text/Regex;"))};
    private final String hashReg;

    /* renamed from: hashRegMatcher$delegate, reason: from kotlin metadata */
    private final Lazy hashRegMatcher;
    private final String hostReg;

    /* renamed from: hostRegMatcher$delegate, reason: from kotlin metadata */
    private final Lazy hostRegMatcher;
    private final List<String> prefetchApis;
    private final Map<String, String> query;
    private final String ruleName;

    private final Regex getHashRegMatcher() {
        Lazy lazy = this.hashRegMatcher;
        KProperty kProperty = $$delegatedProperties[1];
        return (Regex) lazy.getValue();
    }

    private final Regex getHostRegMatcher() {
        Lazy lazy = this.hostRegMatcher;
        KProperty kProperty = $$delegatedProperties[0];
        return (Regex) lazy.getValue();
    }

    private Rule(String str, String str2, String str3, Map<String, String> map, List<String> list) {
        this.ruleName = str;
        this.hostReg = str2;
        this.hashReg = str3;
        this.query = map;
        this.prefetchApis = list;
        this.hostRegMatcher = LazyKt.lazy(new Function0<Regex>() { // from class: com.bytedance.ies.tools.prefetch.Rule$hostRegMatcher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final Regex invoke() {
                String hostReg = Rule.this.getHostReg();
                if (hostReg == null) {
                    hostReg = ".*?";
                }
                return new Regex(hostReg);
            }
        });
        this.hashRegMatcher = LazyKt.lazy(new Function0<Regex>() { // from class: com.bytedance.ies.tools.prefetch.Rule$hashRegMatcher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final Regex invoke() {
                String hashReg = Rule.this.getHashReg();
                if (hashReg == null) {
                    hashReg = ".*?";
                }
                return new Regex(hashReg);
            }
        });
    }

    public final String getRuleName() {
        return this.ruleName;
    }

    public final String getHostReg() {
        return this.hostReg;
    }

    public final String getHashReg() {
        return this.hashReg;
    }

    public final Map<String, String> getQuery() {
        return this.query;
    }

    public final List<String> getPrefetchApis() {
        return this.prefetchApis;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Rule(String str, JSONObject jSONObject) {
        this(str, r4, r5, r0 != null ? UtilKt.toKeyValueMap(r0) : null, UtilKt.toStringList(jSONObject.getJSONArray("prefetch_apis")));
        Intrinsics.checkParameterIsNotNull(str, "ruleName");
        Intrinsics.checkParameterIsNotNull(jSONObject, "jsonObject");
        String optString = jSONObject.optString("host", null);
        String optString2 = jSONObject.optString("hash", null);
        JSONArray optJSONArray = jSONObject.optJSONArray("query");
    }

    public final List<String> getMatchApisName(String logKey, UriWrapper uriWrapper) {
        Intrinsics.checkParameterIsNotNull(uriWrapper, "uriWrapper");
        if (TextUtils.isEmpty(this.hostReg) && TextUtils.isEmpty(this.hashReg) && this.query == null) {
            printLog(logKey, uriWrapper);
            return this.prefetchApis;
        }
        if (!matchHost(uriWrapper.getHost()) || !matchHash(uriWrapper.getHash()) || !matchQuery(uriWrapper.getQueryMap())) {
            return null;
        }
        printLog(logKey, uriWrapper);
        return this.prefetchApis;
    }

    private final void printLog(String logKey, UriWrapper uriWrapper) {
        String joinToString$default = CollectionsKt.joinToString$default(this.prefetchApis, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<String, String>() { // from class: com.bytedance.ies.tools.prefetch.Rule$printLog$apis$1
            public final String invoke(String str) {
                Intrinsics.checkParameterIsNotNull(str, "item");
                Locale locale = Locale.ROOT;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                return lowerCase;
            }
        }, 31, (Object) null);
        if (logKey != null) {
            LogUtil.INSTANCE.m55d("[occasion:" + logKey + "] matchRule:" + this.ruleName + " matchApis:" + joinToString$default);
        } else {
            LogUtil.INSTANCE.m55d("[scheme:" + uriWrapper.getUrl() + "] matchRule:" + this.ruleName + " matchApis:" + joinToString$default);
        }
    }

    private final boolean matchHost(String host) {
        if (TextUtils.isEmpty(this.hostReg)) {
            return true;
        }
        return getHostRegMatcher().matches(host);
    }

    private final boolean matchHash(String hash) {
        if (TextUtils.isEmpty(this.hashReg)) {
            return true;
        }
        return getHashRegMatcher().matches(hash);
    }

    private final boolean matchQuery(SortedMap<String, String> queryOnUri) {
        if (this.query == null) {
            return true;
        }
        if (queryOnUri.size() < this.query.size()) {
            return false;
        }
        for (Map.Entry<String, String> entry : this.query.entrySet()) {
            if (queryOnUri.containsKey(entry.getKey())) {
                String value = entry.getValue();
                if (!(value.length() == 0)) {
                    Regex regex = new Regex(value);
                    String str = queryOnUri.get(entry.getKey());
                    if (str == null) {
                        str = "";
                    }
                    if (!regex.matches(str)) {
                    }
                }
            }
            return false;
        }
        return true;
    }
}
