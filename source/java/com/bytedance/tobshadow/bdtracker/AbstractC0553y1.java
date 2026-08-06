package com.bytedance.tobshadow.bdtracker;

import java.util.Objects;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.y1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbstractC0553y1 {

    /* renamed from: a */
    public boolean f1253a;

    /* renamed from: b */
    public boolean f1254b;

    /* renamed from: c */
    public boolean f1255c;

    /* renamed from: d */
    public boolean f1256d;

    public AbstractC0553y1(boolean z, boolean z2) {
        this.f1254b = z;
        this.f1255c = z2;
        this.f1256d = false;
    }

    public AbstractC0553y1(boolean z, boolean z2, boolean z3) {
        this.f1254b = z;
        this.f1255c = z2;
        this.f1256d = z3;
    }

    /* renamed from: a */
    public abstract String mo253a();

    /* renamed from: a */
    public abstract boolean mo255a(JSONObject jSONObject);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AbstractC0553y1) {
            return Objects.equals(mo253a(), ((AbstractC0553y1) obj).mo253a());
        }
        return false;
    }

    public int hashCode() {
        return mo253a().hashCode();
    }
}
