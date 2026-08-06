package com.bytedance.bdturing.sensor;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.tobshadow.applog.encryptor.IEncryptorType;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SensorStatus {
    boolean a;
    List<Long> b = new ArrayList();
    List<Long> c = new ArrayList();
    boolean cb;
    boolean ef;
    boolean ka;
    boolean ve;

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ka", this.ka);
            jSONObject.put(CommonConstants.CLIPBOARD_CONTENT, this.cb);
            jSONObject.put("ef", this.ef);
            jSONObject.put("ve", this.ve);
            jSONObject.put(IEncryptorType.DEFAULT_ENCRYPTOR, this.a);
            JSONArray jSONArray = new JSONArray();
            Iterator<Long> it = this.b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("b", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<Long> it2 = this.c.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            jSONObject.put(AirActionConstant.ActionId.ACTION_ID_CALL, jSONArray2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
