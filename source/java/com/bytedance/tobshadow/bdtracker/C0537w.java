package com.bytedance.tobshadow.bdtracker;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b8\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001wB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010s\u001a\u00020t2\b\u0010u\u001a\u0004\u0018\u00010+H\u0016J\b\u0010v\u001a\u00020+H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00102\"\u0004\b6\u00104R\u001c\u00107\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\u001c\u0010C\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001c\u0010F\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\u001c\u0010I\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\u001c\u0010L\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\u001c\u0010O\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\u001c\u0010R\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\u001c\u0010U\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR\u001c\u0010X\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR\u001c\u0010[\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\bR\u001c\u0010^\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0006\"\u0004\b`\u0010\bR\u001c\u0010a\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0006\"\u0004\bc\u0010\bR\u001c\u0010d\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0006\"\u0004\bf\u0010\bR\u001c\u0010g\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0006\"\u0004\bi\u0010\bR\u001c\u0010j\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0006\"\u0004\bl\u0010\bR\u001c\u0010m\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0006\"\u0004\bo\u0010\bR\u001c\u0010p\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0006\"\u0004\br\u0010\b¨\u0006x"}, d2 = {"Lcom/bytedance/tobshadow/applog/alink/model/AttributionData;", "Lcom/bytedance/tobshadow/applog/alink/model/BaseData;", "()V", "accountId", "", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "accountName", "getAccountName", "setAccountName", "activationTimestamp", "getActivationTimestamp", "setActivationTimestamp", "activationType", "Lcom/bytedance/tobshadow/applog/alink/model/AttributionData$ActivationType;", "getActivationType", "()Lcom/bytedance/tobshadow/applog/alink/model/AttributionData$ActivationType;", "setActivationType", "(Lcom/bytedance/tobshadow/applog/alink/model/AttributionData$ActivationType;)V", "adId", "getAdId", "setAdId", "adName", "getAdName", "setAdName", "campaignId", "getCampaignId", "setCampaignId", "campaignName", "getCampaignName", "setCampaignName", "creativeId", "getCreativeId", "setCreativeId", "creativeName", "getCreativeName", "setCreativeName", "deeplinkValue", "getDeeplinkValue", "setDeeplinkValue", "extra", "Lorg/json/JSONObject;", "getExtra", "()Lorg/json/JSONObject;", "setExtra", "(Lorg/json/JSONObject;)V", "isFirstLaunch", "", "()Z", "setFirstLaunch", "(Z)V", "isRetargeting", "setRetargeting", "name", "getName", "setName", "reengagementWindow", "", "getReengagementWindow", "()I", "setReengagementWindow", "(I)V", "touchTimestamp", "getTouchTimestamp", "setTouchTimestamp", "touchType", "getTouchType", "setTouchType", "trAdmaster", "getTrAdmaster", "setTrAdmaster", "trDp", "getTrDp", "setTrDp", "trInstallType", "getTrInstallType", "setTrInstallType", "trParam1", "getTrParam1", "setTrParam1", "trParam2", "getTrParam2", "setTrParam2", "trParam3", "getTrParam3", "setTrParam3", "trParam4", "getTrParam4", "setTrParam4", "trShareuser", "getTrShareuser", "setTrShareuser", "trSiteId", "getTrSiteId", "setTrSiteId", "trSiteName", "getTrSiteName", "setTrSiteName", "utmCampaign", "getUtmCampaign", "setUtmCampaign", "utmContent", "getUtmContent", "setUtmContent", "utmMedium", "getUtmMedium", "setUtmMedium", "utmSource", "getUtmSource", "setUtmSource", "utmTerm", "getUtmTerm", "setUtmTerm", "initWithJson", "", "json", "toJson", "ActivationType", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* renamed from: com.bytedance.tobshadow.bdtracker.w */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0537w extends AbstractC0551y {

    /* renamed from: A */
    public String f1144A;

    /* renamed from: B */
    public String f1145B;

    /* renamed from: C */
    public String f1146C;

    /* renamed from: D */
    public String f1147D;

    /* renamed from: E */
    public a f1148E = a.PROMOTION;

    /* renamed from: F */
    public String f1149F;

    /* renamed from: G */
    public boolean f1150G;

    /* renamed from: H */
    public JSONObject f1151H;

    /* renamed from: b */
    public String f1152b;

    /* renamed from: c */
    public String f1153c;

    /* renamed from: d */
    public String f1154d;

    /* renamed from: e */
    public String f1155e;

    /* renamed from: f */
    public String f1156f;

    /* renamed from: g */
    public String f1157g;

    /* renamed from: h */
    public String f1158h;

    /* renamed from: i */
    public String f1159i;

    /* renamed from: j */
    public String f1160j;

    /* renamed from: k */
    public String f1161k;

    /* renamed from: l */
    public String f1162l;

    /* renamed from: m */
    public String f1163m;

    /* renamed from: n */
    public boolean f1164n;

    /* renamed from: o */
    public int f1165o;

    /* renamed from: p */
    public String f1166p;

    /* renamed from: q */
    public String f1167q;

    /* renamed from: r */
    public String f1168r;

    /* renamed from: s */
    public String f1169s;

    /* renamed from: t */
    public String f1170t;

    /* renamed from: u */
    public String f1171u;

    /* renamed from: v */
    public String f1172v;

    /* renamed from: w */
    public String f1173w;

    /* renamed from: x */
    public String f1174x;

    /* renamed from: y */
    public String f1175y;

    /* renamed from: z */
    public String f1176z;

    /* renamed from: com.bytedance.tobshadow.bdtracker.w$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public enum a {
        PROMOTION,
        ORGANIC
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0551y
    /* renamed from: a */
    public JSONObject mo665a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.f1152b);
        jSONObject.put("utm_campaign", this.f1153c);
        jSONObject.put("utm_source", this.f1154d);
        jSONObject.put("utm_medium", this.f1155e);
        jSONObject.put("utm_content", this.f1156f);
        jSONObject.put("utm_term", this.f1157g);
        jSONObject.put("tr_shareuser", this.f1158h);
        jSONObject.put("tr_admaster", this.f1159i);
        jSONObject.put("tr_param1", this.f1160j);
        jSONObject.put("tr_param2", this.f1161k);
        jSONObject.put("tr_param3", this.f1162l);
        jSONObject.put("tr_param4", this.f1163m);
        jSONObject.put("is_retargeting", this.f1164n);
        jSONObject.put("reengagement_window", this.f1165o);
        jSONObject.put("tr_dp", this.f1166p);
        jSONObject.put("deeplink_value", this.f1167q);
        jSONObject.put("tr_site_id", this.f1168r);
        jSONObject.put("tr_site_name", this.f1169s);
        jSONObject.put("account_id", this.f1170t);
        jSONObject.put("account_name", this.f1171u);
        jSONObject.put("campaign_id", this.f1172v);
        jSONObject.put("campaign_name", this.f1173w);
        jSONObject.put("ad_id", this.f1174x);
        jSONObject.put("ad_name", this.f1175y);
        jSONObject.put("creative_id", this.f1176z);
        jSONObject.put("creative_name", this.f1144A);
        jSONObject.put("tr_install_type", this.f1145B);
        jSONObject.put("touch_type", this.f1146C);
        jSONObject.put("touch_timestamp", this.f1147D);
        String name = this.f1148E.name();
        Locale locale = Locale.ROOT;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
        if (name == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = name.toLowerCase(locale);
        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        jSONObject.put("activation_type", lowerCase);
        jSONObject.put("activation_timestamp", this.f1149F);
        jSONObject.put("is_first_launch", this.f1150G);
        jSONObject.put("extra", this.f1151H);
        return jSONObject;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0551y
    /* renamed from: a */
    public void mo666a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f1152b = jSONObject.optString("name", null);
            this.f1153c = jSONObject.optString("utm_campaign", null);
            this.f1154d = jSONObject.optString("utm_source", null);
            this.f1155e = jSONObject.optString("utm_medium", null);
            this.f1156f = jSONObject.optString("utm_content", null);
            this.f1157g = jSONObject.optString("utm_term", null);
            this.f1158h = jSONObject.optString("tr_shareuser", null);
            this.f1159i = jSONObject.optString("tr_admaster", null);
            this.f1160j = jSONObject.optString("tr_param1", null);
            this.f1161k = jSONObject.optString("tr_param2", null);
            this.f1162l = jSONObject.optString("tr_param3", null);
            this.f1163m = jSONObject.optString("tr_param4", null);
            this.f1164n = jSONObject.optBoolean("is_retargeting");
            this.f1165o = jSONObject.optInt("reengagement_window");
            this.f1166p = jSONObject.optString("tr_dp", null);
            this.f1167q = jSONObject.optString("deeplink_value", null);
            this.f1168r = jSONObject.optString("tr_site_id", null);
            this.f1169s = jSONObject.optString("tr_site_name", null);
            this.f1170t = jSONObject.optString("account_id", null);
            this.f1171u = jSONObject.optString("account_name", null);
            this.f1172v = jSONObject.optString("campaign_id", null);
            this.f1173w = jSONObject.optString("campaign_name", null);
            this.f1174x = jSONObject.optString("ad_id", null);
            this.f1175y = jSONObject.optString("ad_name", null);
            this.f1176z = jSONObject.optString("creative_id", null);
            this.f1144A = jSONObject.optString("creative_name", null);
            this.f1145B = jSONObject.optString("tr_install_type", null);
            this.f1146C = jSONObject.optString("touch_type", null);
            this.f1147D = jSONObject.optString("touch_timestamp", null);
            this.f1148E = Intrinsics.areEqual(jSONObject.optString("activation_type"), "promotion") ? a.PROMOTION : a.ORGANIC;
            this.f1149F = jSONObject.optString("activation_timestamp", null);
            this.f1150G = jSONObject.optBoolean("is_first_launch");
            this.f1151H = jSONObject.optJSONObject("extra");
        }
    }
}
