package com.bytedance.ies.bullet.redirect.data;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.redirect.AnnieXRedirectImplProcessor;
import com.bytedance.ies.bullet.redirect.data.RedirectReportInfo;
import com.bytedance.iesgurd.exception.BytePatchException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RedirectSettingsData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0001.B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J7\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\t\u0010*\u001a\u00020+HÖ\u0001J\u0006\u0010,\u001a\u00020#J\t\u0010-\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR,\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/RedirectSettingsData;", "Ljava/io/Serializable;", "redirectRules", "Lorg/json/JSONObject;", "commonConfig", "geckoCDNVersion", "", "settingsDataInitTime", "", "(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;J)V", "getCommonConfig", "()Lorg/json/JSONObject;", "getGeckoCDNVersion", "()Ljava/lang/String;", "setGeckoCDNVersion", "(Ljava/lang/String;)V", "mRedirectRuleMap", "", "", "Lcom/bytedance/ies/bullet/redirect/data/RedirectRule;", "getMRedirectRuleMap", "()Ljava/util/Map;", "setMRedirectRuleMap", "(Ljava/util/Map;)V", "getRedirectRules", "getSettingsDataInitTime", "()J", "setSettingsDataInitTime", "(J)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getTargetInfoWithEntryKey", "Lcom/bytedance/ies/bullet/redirect/data/RedirectOutputInfo;", "info", "Lcom/bytedance/ies/bullet/redirect/data/RedirectInputInfo;", "hashCode", "", "isExpired", "toString", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class RedirectSettingsData implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final JSONObject commonConfig;
    private String geckoCDNVersion;
    private Map<String, List<RedirectRule>> mRedirectRuleMap;
    private final JSONObject redirectRules;
    private long settingsDataInitTime;

    public RedirectSettingsData() {
        this(null, null, null, 0L, 15, null);
    }

    public static /* synthetic */ RedirectSettingsData copy$default(RedirectSettingsData redirectSettingsData, JSONObject jSONObject, JSONObject jSONObject2, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = redirectSettingsData.redirectRules;
        }
        if ((i & 2) != 0) {
            jSONObject2 = redirectSettingsData.commonConfig;
        }
        JSONObject jSONObject3 = jSONObject2;
        if ((i & 4) != 0) {
            str = redirectSettingsData.geckoCDNVersion;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            j = redirectSettingsData.settingsDataInitTime;
        }
        return redirectSettingsData.copy(jSONObject, jSONObject3, str2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final JSONObject getRedirectRules() {
        return this.redirectRules;
    }

    /* renamed from: component2, reason: from getter */
    public final JSONObject getCommonConfig() {
        return this.commonConfig;
    }

    /* renamed from: component3, reason: from getter */
    public final String getGeckoCDNVersion() {
        return this.geckoCDNVersion;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSettingsDataInitTime() {
        return this.settingsDataInitTime;
    }

    public final RedirectSettingsData copy(JSONObject redirectRules, JSONObject commonConfig, String geckoCDNVersion, long settingsDataInitTime) {
        return new RedirectSettingsData(redirectRules, commonConfig, geckoCDNVersion, settingsDataInitTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RedirectSettingsData)) {
            return false;
        }
        RedirectSettingsData redirectSettingsData = (RedirectSettingsData) other;
        return Intrinsics.areEqual(this.redirectRules, redirectSettingsData.redirectRules) && Intrinsics.areEqual(this.commonConfig, redirectSettingsData.commonConfig) && Intrinsics.areEqual(this.geckoCDNVersion, redirectSettingsData.geckoCDNVersion) && this.settingsDataInitTime == redirectSettingsData.settingsDataInitTime;
    }

    public int hashCode() {
        JSONObject jSONObject = this.redirectRules;
        int hashCode = (jSONObject == null ? 0 : jSONObject.hashCode()) * 31;
        JSONObject jSONObject2 = this.commonConfig;
        int hashCode2 = (hashCode + (jSONObject2 == null ? 0 : jSONObject2.hashCode())) * 31;
        String str = this.geckoCDNVersion;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Long.hashCode(this.settingsDataInitTime);
    }

    public String toString() {
        return "RedirectSettingsData(redirectRules=" + this.redirectRules + ", commonConfig=" + this.commonConfig + ", geckoCDNVersion=" + this.geckoCDNVersion + ", settingsDataInitTime=" + this.settingsDataInitTime + ')';
    }

    public RedirectSettingsData(JSONObject jSONObject, JSONObject jSONObject2, String str, long j) {
        this.redirectRules = jSONObject;
        this.commonConfig = jSONObject2;
        this.geckoCDNVersion = str;
        this.settingsDataInitTime = j;
        this.mRedirectRuleMap = new LinkedHashMap();
    }

    public final JSONObject getRedirectRules() {
        return this.redirectRules;
    }

    public final JSONObject getCommonConfig() {
        return this.commonConfig;
    }

    public final String getGeckoCDNVersion() {
        return this.geckoCDNVersion;
    }

    public final void setGeckoCDNVersion(String str) {
        this.geckoCDNVersion = str;
    }

    public /* synthetic */ RedirectSettingsData(JSONObject jSONObject, JSONObject jSONObject2, String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jSONObject, (i & 2) != 0 ? null : jSONObject2, (i & 4) == 0 ? str : null, (i & 8) != 0 ? System.currentTimeMillis() : j);
    }

    public final long getSettingsDataInitTime() {
        return this.settingsDataInitTime;
    }

    public final void setSettingsDataInitTime(long j) {
        this.settingsDataInitTime = j;
    }

    /* compiled from: RedirectSettingsData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/RedirectSettingsData$Companion;", "", "()V", "create", "Lcom/bytedance/ies/bullet/redirect/data/RedirectSettingsData;", "redirectRules", "Lorg/json/JSONObject;", "commonConfig", "geckoCDNVersion", "", "settingsDataInitTime", "", "fromJson", "jsonString", "toJson", "settingsData", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RedirectSettingsData create(JSONObject redirectRules, JSONObject commonConfig, String geckoCDNVersion, long settingsDataInitTime) {
            return new RedirectSettingsData(redirectRules, commonConfig, geckoCDNVersion, settingsDataInitTime);
        }

        public final RedirectSettingsData fromJson(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            try {
                JSONObject jSONObject = new JSONObject(jsonString);
                return new RedirectSettingsData(jSONObject.optJSONObject("redirectRules"), jSONObject.optJSONObject("commonConfig"), jSONObject.optString("geckoCDNVersion"), jSONObject.optLong("settingsDataInitTime"));
            } catch (Exception unused) {
                return null;
            }
        }

        public final String toJson(RedirectSettingsData settingsData) {
            Intrinsics.checkNotNullParameter(settingsData, "settingsData");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("redirectRules", settingsData.getRedirectRules());
            jSONObject.put("commonConfig", settingsData.getCommonConfig());
            jSONObject.put("geckoCDNVersion", settingsData.getGeckoCDNVersion());
            jSONObject.put("settingsDataInitTime", settingsData.getSettingsDataInitTime());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "store.toString()");
            return jSONObject2;
        }
    }

    public final Map<String, List<RedirectRule>> getMRedirectRuleMap() {
        return this.mRedirectRuleMap;
    }

    public final void setMRedirectRuleMap(Map<String, List<RedirectRule>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.mRedirectRuleMap = map;
    }

    public final boolean isExpired() {
        long currentTimeMillis = System.currentTimeMillis() - this.settingsDataInitTime;
        JSONObject jSONObject = this.commonConfig;
        return currentTimeMillis > (jSONObject != null ? jSONObject.optLong("limit_second") : 0L) * ((long) BytePatchException.ErrorCode.paramsError);
    }

    public final RedirectOutputInfo getTargetInfoWithEntryKey(RedirectInputInfo info) {
        RedirectOutputInfo redirectOutputInfo;
        RedirectRule createRule;
        Intrinsics.checkNotNullParameter(info, "info");
        String key = info.getKey();
        JSONObject jSONObject = this.redirectRules;
        Object opt = jSONObject != null ? jSONObject.opt(key) : null;
        if (opt == null) {
            return new RedirectOutputInfo(null, 3, "no entry config");
        }
        RedirectReportInfo reportInfo = info.getReportInfo();
        RedirectReportInfo.Extra extras = reportInfo != null ? reportInfo.getExtras() : null;
        if (extras != null) {
            extras.setEntryConfig(opt.toString());
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, AnnieXRedirectImplProcessor.TAG, "getTargetInfoWithEntryKey: \n key: " + key + ";\n rawRules: " + opt, null, null, 12, null);
        ArrayList arrayList = this.mRedirectRuleMap.get(key);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.mRedirectRuleMap.put(key, arrayList);
        }
        if (arrayList.isEmpty()) {
            if (opt instanceof String) {
                return new RedirectOutputInfo((String) opt, null, null, 6, null);
            }
            if (opt instanceof JSONObject) {
                RedirectRule createRule2 = RedirectRule.INSTANCE.createRule((JSONObject) opt);
                if (createRule2 != null) {
                    arrayList.add(createRule2);
                }
            } else if (opt instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) opt;
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "this.getJSONObject(i)");
                    if ((jSONObject2 instanceof JSONObject) && (createRule = RedirectRule.INSTANCE.createRule(jSONObject2)) != null) {
                        arrayList.add(createRule);
                    }
                }
            }
        }
        Iterator<RedirectRule> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                redirectOutputInfo = null;
                break;
            }
            redirectOutputInfo = it.next().findTargetInfo(info);
            if (redirectOutputInfo != null) {
                HybridLogger.i$default(HybridLogger.INSTANCE, AnnieXRedirectImplProcessor.TAG, "rule match success", null, null, 12, null);
                break;
            }
            HybridLogger.i$default(HybridLogger.INSTANCE, AnnieXRedirectImplProcessor.TAG, "rule match failed", null, null, 12, null);
        }
        return redirectOutputInfo != null ? redirectOutputInfo : new RedirectOutputInfo(null, 4, "no match rule");
    }
}
