package com.unicom.online.account.kernel;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class q {
    public e a = null;

    public final void a(int i, String str) {
        a(i, str, "", "");
    }

    public final void a(int i, String str, String str2, String str3) {
        try {
            if (this.a == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            jSONObject.put(OnekeyLoginConstants.CU_KEY_RESULT_MSG, str);
            jSONObject.put(OnekeyLoginConstants.CU_KEY_RESULT_DATA, str2);
            jSONObject.put(OnekeyLoginConstants.CU_KEY_SEQ, str3);
            this.a.onResult(jSONObject.toString());
            this.a = null;
            if (i < 0) {
                z.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
