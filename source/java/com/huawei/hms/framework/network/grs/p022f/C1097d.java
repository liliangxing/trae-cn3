package com.huawei.hms.framework.network.grs.p022f;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C0879b;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.local.model.C1119a;
import com.huawei.hms.framework.network.grs.local.model.C1120b;
import com.lynx.tasm.DefaultLogicExecutor;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.f.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1097d extends AbstractC1094a {
    public C1097d(Context context, String str, boolean z) {
        this.f1301d = z;
        if (m1253a(TextUtils.isEmpty(str) ? "grs_app_global_route_config.json" : str, context) == 0) {
            this.f1300c = true;
        }
    }

    public C1097d(boolean z, boolean z2) {
        this.f1301d = z2;
        this.f1300c = z;
    }

    @Override // com.huawei.hms.framework.network.grs.p022f.AbstractC1094a
    /* renamed from: b */
    public int mo1260b(String str) {
        this.f1298a = new C1119a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONArray("applications").getJSONObject(0);
            this.f1298a.m1386b(jSONObject.getString(DefaultLogicExecutor.GLOBAL_EVENT_NAME));
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            if (jSONArray != null && jSONArray.length() != 0) {
                if (jSONObject.has("customservices")) {
                    m1262b(jSONObject.getJSONArray("customservices"));
                }
                return 0;
            }
            return -1;
        } catch (JSONException e) {
            Logger.m1191w("LocalManagerV2", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.p022f.AbstractC1094a
    /* renamed from: c */
    public int mo1263c(String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        this.f1299b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.m1182e("LocalManagerV2", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONArray = null;
            }
            if (jSONArray == null) {
                return -1;
            }
            if (jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    C1120b c1120b = new C1120b();
                    c1120b.m1391b(jSONObject2.getString("id"));
                    c1120b.m1393c(jSONObject2.getString(DefaultLogicExecutor.GLOBAL_EVENT_NAME));
                    c1120b.m1388a(jSONObject2.getString(C0879b.f565i));
                    if (jSONObject2.has("countriesOrAreas")) {
                        jSONArray2 = jSONObject2.getJSONArray("countriesOrAreas");
                    } else if (jSONObject2.has("countries")) {
                        jSONArray2 = jSONObject2.getJSONArray("countries");
                    } else {
                        Logger.m1189w("LocalManagerV2", "current country or area group has not config countries or areas.");
                        jSONArray2 = null;
                    }
                    HashSet hashSet = new HashSet(16);
                    if (jSONArray2 != null && jSONArray2.length() != 0) {
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            hashSet.add((String) jSONArray2.get(i2));
                        }
                        c1120b.m1389a(hashSet);
                        this.f1299b.add(c1120b);
                    }
                    return -1;
                }
            }
            return 0;
        } catch (JSONException e) {
            Logger.m1191w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.p022f.AbstractC1094a
    /* renamed from: g */
    public int mo1269g(String str) {
        return m1268f(str);
    }
}
