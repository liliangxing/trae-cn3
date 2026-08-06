package com.bytedance.ies.bullet.redirect.data;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.redirect.AnnieXRedirectImplProcessor;
import com.bytedance.ies.bullet.redirect.data.RedirectReportInfo;
import com.bytedance.ies.bullet.redirect.rule.RuleStrategy;
import com.bytedance.push.client.intelligence.FeatureConnectionConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RedirectRule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/RedirectRule;", "", "ruleType", "", FeatureConnectionConstant.LOCATION, "", "children", "", "curRuleJSONObject", "Lorg/json/JSONObject;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lorg/json/JSONObject;)V", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "getCurRuleJSONObject", "()Lorg/json/JSONObject;", "setCurRuleJSONObject", "(Lorg/json/JSONObject;)V", "getLocation", "()Ljava/lang/String;", "setLocation", "(Ljava/lang/String;)V", "getRuleType", "()Ljava/lang/Integer;", "setRuleType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "findTargetInfo", "Lcom/bytedance/ies/bullet/redirect/data/RedirectOutputInfo;", "info", "Lcom/bytedance/ies/bullet/redirect/data/RedirectInputInfo;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RedirectRule {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private List<RedirectRule> children;
    private JSONObject curRuleJSONObject;
    private String location;
    private Integer ruleType;

    public RedirectRule() {
        this(null, null, null, null, 15, null);
    }

    public RedirectRule(Integer num, String str, List<RedirectRule> list, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "curRuleJSONObject");
        this.ruleType = num;
        this.location = str;
        this.children = list;
        this.curRuleJSONObject = jSONObject;
    }

    public final Integer getRuleType() {
        return this.ruleType;
    }

    public final void setRuleType(Integer num) {
        this.ruleType = num;
    }

    public final String getLocation() {
        return this.location;
    }

    public final void setLocation(String str) {
        this.location = str;
    }

    public final List<RedirectRule> getChildren() {
        return this.children;
    }

    public final void setChildren(List<RedirectRule> list) {
        this.children = list;
    }

    public /* synthetic */ RedirectRule(Integer num, String str, List list, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list, (i & 8) != 0 ? new JSONObject() : jSONObject);
    }

    public final JSONObject getCurRuleJSONObject() {
        return this.curRuleJSONObject;
    }

    public final void setCurRuleJSONObject(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.curRuleJSONObject = jSONObject;
    }

    /* compiled from: RedirectRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/RedirectRule$Companion;", "", "()V", "createRule", "Lcom/bytedance/ies/bullet/redirect/data/RedirectRule;", "redirectRuleJSONObject", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RedirectRule createRule(JSONObject redirectRuleJSONObject) {
            RedirectRule createRule;
            Intrinsics.checkNotNullParameter(redirectRuleJSONObject, "redirectRuleJSONObject");
            int optInt = redirectRuleJSONObject.optInt("ruleType");
            Object opt = redirectRuleJSONObject.opt(FeatureConnectionConstant.LOCATION);
            if (opt instanceof String) {
                return new RedirectRule(Integer.valueOf(optInt), (String) opt, null, redirectRuleJSONObject);
            }
            if (opt instanceof JSONObject) {
                Integer valueOf = Integer.valueOf(optInt);
                ArrayList arrayList = new ArrayList();
                RedirectRule createRule2 = RedirectRule.INSTANCE.createRule((JSONObject) opt);
                if (createRule2 != null) {
                    arrayList.add(createRule2);
                }
                Unit unit = Unit.INSTANCE;
                return new RedirectRule(valueOf, null, arrayList, redirectRuleJSONObject);
            }
            if (!(opt instanceof JSONArray)) {
                return null;
            }
            Integer valueOf2 = Integer.valueOf(optInt);
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArray = (JSONArray) opt;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Object obj = jSONArray.get(i);
                if (obj instanceof String) {
                    arrayList2.add(new RedirectRule(Integer.valueOf(optInt), (String) obj, null, redirectRuleJSONObject));
                } else if ((obj instanceof JSONObject) && (createRule = RedirectRule.INSTANCE.createRule((JSONObject) obj)) != null) {
                    arrayList2.add(createRule);
                }
            }
            Unit unit2 = Unit.INSTANCE;
            return new RedirectRule(valueOf2, null, arrayList2, redirectRuleJSONObject);
        }
    }

    public final RedirectOutputInfo findTargetInfo(RedirectInputInfo info) {
        RedirectReportInfo.Category category;
        JSONArray ruleTypes;
        Intrinsics.checkNotNullParameter(info, "info");
        HybridLogger.i$default(HybridLogger.INSTANCE, AnnieXRedirectImplProcessor.TAG, "try match redirect rule: curRuleDetail: " + this.curRuleJSONObject, null, null, 12, null);
        RuleStrategy.Companion companion = RuleStrategy.INSTANCE;
        Integer num = this.ruleType;
        boolean match = companion.get(num != null ? num.intValue() : -1).match(this);
        RedirectOutputInfo redirectOutputInfo = null;
        if (!match) {
            return null;
        }
        RedirectReportInfo reportInfo = info.getReportInfo();
        if (reportInfo != null && (category = reportInfo.getCategory()) != null && (ruleTypes = category.getRuleTypes()) != null) {
            ruleTypes.put(this.ruleType);
        }
        if (this.location != null) {
            String str = this.location;
            Intrinsics.checkNotNull(str);
            return new RedirectOutputInfo(str, null, null, 6, null);
        }
        List<RedirectRule> list = this.children;
        if (list == null || list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            RedirectOutputInfo findTargetInfo = ((RedirectRule) it.next()).findTargetInfo(info);
            if (findTargetInfo != null) {
                redirectOutputInfo = findTargetInfo;
            }
        }
        return redirectOutputInfo;
    }
}
