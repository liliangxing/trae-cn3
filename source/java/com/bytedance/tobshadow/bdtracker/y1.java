package com.bytedance.tobshadow.bdtracker;

import java.util.Objects;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class y1 {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;

    public y1(boolean z, boolean z2) {
        this.b = z;
        this.c = z2;
        this.d = false;
    }

    public y1(boolean z, boolean z2, boolean z3) {
        this.b = z;
        this.c = z2;
        this.d = z3;
    }

    public abstract String a();

    public abstract boolean a(JSONObject jSONObject);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y1) {
            return Objects.equals(a(), ((y1) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return a().hashCode();
    }
}
