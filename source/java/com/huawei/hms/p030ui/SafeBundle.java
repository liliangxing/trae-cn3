package com.huawei.hms.p030ui;

import android.os.Bundle;
import com.huawei.hms.base.p020ui.LogUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SafeBundle {

    /* renamed from: a */
    private final Bundle f1848a;

    public SafeBundle() {
        this(new Bundle());
    }

    public boolean containsKey(String str) {
        try {
            return this.f1848a.containsKey(str);
        } catch (Throwable unused) {
            LogUtil.m1061e("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    public Object get(String str) {
        try {
            return this.f1848a.get(str);
        } catch (Exception e) {
            LogUtil.m1062e("SafeBundle", "get exception: " + e.getMessage(), true);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.f1848a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public String getString(String str) {
        try {
            return this.f1848a.getString(str);
        } catch (Throwable th) {
            LogUtil.m1062e("SafeBundle", "getString exception: " + th.getMessage(), true);
            return "";
        }
    }

    public boolean isEmpty() {
        try {
            return this.f1848a.isEmpty();
        } catch (Exception unused) {
            LogUtil.m1061e("SafeBundle", "isEmpty exception");
            return true;
        }
    }

    public int size() {
        try {
            return this.f1848a.size();
        } catch (Exception unused) {
            LogUtil.m1061e("SafeBundle", "size exception");
            return 0;
        }
    }

    public String toString() {
        return this.f1848a.toString();
    }

    public SafeBundle(Bundle bundle) {
        this.f1848a = bundle == null ? new Bundle() : bundle;
    }

    public int getInt(String str, int i) {
        try {
            return this.f1848a.getInt(str, i);
        } catch (Throwable th) {
            LogUtil.m1062e("SafeBundle", "getInt exception: " + th.getMessage(), true);
            return i;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.f1848a.getString(str, str2);
        } catch (Exception e) {
            LogUtil.m1062e("SafeBundle", "getString exception: " + e.getMessage(), true);
            return str2;
        }
    }
}
