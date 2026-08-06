package com.bytedance.tobshadow.bdtracker;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.p4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0493p4 extends C0528u4 {

    /* renamed from: A */
    public ArrayList<String> f916A;

    /* renamed from: B */
    public ArrayList<String> f917B;

    /* renamed from: C */
    public int f918C;

    /* renamed from: D */
    public int f919D;

    /* renamed from: E */
    public int f920E;

    /* renamed from: F */
    public int f921F;

    /* renamed from: v */
    public String f922v;

    /* renamed from: w */
    public String f923w;

    /* renamed from: x */
    public String f924x;

    /* renamed from: y */
    public String f925y;

    /* renamed from: z */
    public String f926z;

    public C0493p4(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        super(null, "bav2b_click", true, null);
        this.f922v = str;
        this.f923w = str2;
        this.f924x = str3;
        this.f925y = str4;
        this.f926z = str5;
        this.f916A = arrayList;
        this.f917B = arrayList2;
        this.f918C = i;
        this.f919D = i2;
        this.f920E = i3;
        this.f921F = i4;
    }

    @Override // com.bytedance.tobshadow.bdtracker.C0528u4
    /* renamed from: k */
    public void mo607k() {
        if (this.f1102s == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("element_path", this.f924x);
            jSONObject.put("page_key", this.f922v);
            ArrayList<String> arrayList = this.f917B;
            if (arrayList != null && arrayList.size() > 0) {
                jSONObject.put("positions", new JSONArray((Collection) this.f917B));
            }
            ArrayList<String> arrayList2 = this.f916A;
            if (arrayList2 != null && arrayList2.size() > 0) {
                jSONObject.put("texts", new JSONArray((Collection) this.f916A));
            }
            jSONObject.put("element_width", this.f918C);
            jSONObject.put("element_height", this.f919D);
            jSONObject.put("touch_x", this.f920E);
            jSONObject.put("touch_y", this.f921F);
            jSONObject.put("page_title", this.f923w);
            jSONObject.put("element_id", this.f925y);
            jSONObject.put("element_type", this.f926z);
            this.f1102s = jSONObject.toString();
        }
    }
}
