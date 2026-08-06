package com.xiaomi.push;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class bf extends JSONObject implements bd {
    private static final int a = 2;
    private static final int b = 3;

    /* renamed from: a, reason: collision with other field name */
    private final LinkedHashMap<String, Integer> f197a = new LinkedHashMap<>();

    @Override // com.xiaomi.push.bd
    public int a() {
        int i = a;
        Iterator<Integer> it = this.f197a.values().iterator();
        while (it.hasNext()) {
            i += it.next().intValue();
        }
        return i + (length() - 1);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.f197a.put(str, Integer.valueOf(str.length() + String.valueOf(i).length() + b));
        }
        return super.put(str, i);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.f197a.put(str, Integer.valueOf(str.length() + String.valueOf(j).length() + b));
        }
        return super.put(str, j);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, double d) {
        if (!TextUtils.isEmpty(str)) {
            this.f197a.put(str, Integer.valueOf(str.length() + String.valueOf(d).length() + b));
        }
        return super.put(str, d);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, Object obj) {
        JSONObject put = super.put(str, obj);
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (obj instanceof bd) {
                this.f197a.put(str, Integer.valueOf(str.length() + ((bd) obj).a() + b));
            } else {
                this.f197a.put(str, Integer.valueOf(str.length() + String.valueOf(obj).getBytes(StandardCharsets.UTF_8).length + b + a));
            }
        }
        return put;
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f197a.put(str, Integer.valueOf(str.length() + String.valueOf(z).length() + b));
        }
        return super.put(str, z);
    }

    @Override // org.json.JSONObject
    public Object remove(String str) {
        this.f197a.remove(str);
        return super.remove(str);
    }
}
