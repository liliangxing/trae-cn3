package com.huawei.hms.framework.network.grs.p023g.p024i;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.p023g.p025j.C1111d;
import com.huawei.hms.framework.network.grs.p026h.C1114c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.g.i.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1107a {

    /* renamed from: a */
    private static final String f1364a = "a";

    /* renamed from: b */
    private static C1111d f1365b;

    /* renamed from: c */
    private static final Object f1366c = new Object();

    /* renamed from: a */
    public static C1111d m1347a(Context context) {
        synchronized (f1366c) {
            C1111d c1111d = f1365b;
            if (c1111d != null) {
                return c1111d;
            }
            String m1371a = C1114c.m1371a(GrsApp.getInstance().getBrand("/") + "grs_sdk_server_config.json", context);
            ArrayList arrayList = null;
            if (TextUtils.isEmpty(m1371a)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(m1371a).getJSONObject("grs_server");
                JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                if (jSONArray != null && jSONArray.length() > 0) {
                    arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.get(i).toString());
                    }
                }
                C1111d c1111d2 = new C1111d();
                f1365b = c1111d2;
                c1111d2.m1360a(arrayList);
                f1365b.m1359a(jSONObject.getString("grs_query_endpoint_2.0"));
                f1365b.m1358a(jSONObject.getInt("grs_query_timeout"));
            } catch (JSONException e) {
                Logger.m1191w(f1364a, "getGrsServerBean catch JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            }
            return f1365b;
        }
    }
}
