package com.xiaomi.push;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.bf */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1499bf extends JSONObject implements InterfaceC1497bd {

    /* renamed from: a */
    private static final int f1058a = 2;

    /* renamed from: b */
    private static final int f1059b = 3;

    /* renamed from: a */
    private final LinkedHashMap<String, Integer> f1060a = new LinkedHashMap<>();

    @Override // com.xiaomi.push.InterfaceC1497bd
    /* renamed from: a */
    public int mo1650a() {
        int i = f1058a;
        Iterator<Integer> it = this.f1060a.values().iterator();
        while (it.hasNext()) {
            i += it.next().intValue();
        }
        return i + (length() - 1);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.f1060a.put(str, Integer.valueOf(str.length() + String.valueOf(i).length() + f1059b));
        }
        return super.put(str, i);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.f1060a.put(str, Integer.valueOf(str.length() + String.valueOf(j).length() + f1059b));
        }
        return super.put(str, j);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, double d) {
        if (!TextUtils.isEmpty(str)) {
            this.f1060a.put(str, Integer.valueOf(str.length() + String.valueOf(d).length() + f1059b));
        }
        return super.put(str, d);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, Object obj) {
        JSONObject put = super.put(str, obj);
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (obj instanceof InterfaceC1497bd) {
                this.f1060a.put(str, Integer.valueOf(str.length() + ((InterfaceC1497bd) obj).mo1650a() + f1059b));
            } else {
                this.f1060a.put(str, Integer.valueOf(str.length() + String.valueOf(obj).getBytes(StandardCharsets.UTF_8).length + f1059b + f1058a));
            }
        }
        return put;
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f1060a.put(str, Integer.valueOf(str.length() + String.valueOf(z).length() + f1059b));
        }
        return super.put(str, z);
    }

    @Override // org.json.JSONObject
    public Object remove(String str) {
        this.f1060a.remove(str);
        return super.remove(str);
    }
}
