package com.bytedance.tobshadow.bdtracker;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.c5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0402c5 {

    /* renamed from: a */
    public int f483a;

    /* renamed from: b */
    public int f484b;

    /* renamed from: c */
    public final boolean f485c = true;

    /* renamed from: a */
    public static int m296a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        Iterator<String> keys = jSONObject.keys();
        boolean z = true;
        int i = 2;
        while (keys.hasNext()) {
            if (!z) {
                i++;
            }
            String next = keys.next();
            i = m295a(jSONObject.opt(next)) + m298b(next) + 3 + i;
            z = false;
        }
        return i;
    }

    /* renamed from: b */
    public static int m298b(String str) {
        int i = 0;
        if (str == null) {
            return 0;
        }
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                i2++;
            } else if (charAt <= 2047) {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public boolean m299a(JSONObject jSONObject, boolean z) {
        int m296a = m296a(jSONObject) + (z ? 15 : 1);
        int i = this.f483a;
        if (!(((long) (i + m296a)) < 1048576)) {
            return false;
        }
        this.f483a = i + m296a;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
    
        if (r0 > 51200) goto L10;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m297a(String str) {
        int i;
        if (str != null && str.length() * 4 > 51200) {
            i = m298b(str);
        }
        i = -1;
        return i > 0 ? "{\"description\":\"event param too large\"}" : str;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:39:0x0059. Please report as an issue. */
    /* renamed from: a */
    public static int m295a(Object obj) {
        if (obj instanceof JSONObject) {
            return m296a((JSONObject) obj);
        }
        int i = 2;
        int i2 = 0;
        boolean z = true;
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            if (jSONArray == null) {
                return 0;
            }
            int i3 = 0;
            while (i3 < jSONArray.length()) {
                if (!z) {
                    i++;
                }
                i += m295a(jSONArray.opt(i3));
                i3++;
                z = false;
            }
            return i;
        }
        if (!(obj instanceof String)) {
            return String.valueOf(obj).length();
        }
        String str = (String) obj;
        if (str != null) {
            int i4 = 0;
            while (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (charAt != '\f' && charAt != '\r' && charAt != '\"' && charAt != '/' && charAt != '\\') {
                    switch (charAt) {
                        default:
                            if (charAt > 127) {
                                if (charAt > 2047) {
                                    if (!Character.isHighSurrogate(charAt)) {
                                        i4 += 3;
                                        break;
                                    } else {
                                        i4 += 4;
                                        i2++;
                                        break;
                                    }
                                }
                            } else {
                                i4++;
                                break;
                            }
                        case '\b':
                        case '\t':
                        case '\n':
                            i4 += 2;
                            break;
                    }
                    i2++;
                }
                i4 += 2;
                i2++;
            }
            i2 = i4;
        }
        return i2 + 2;
    }
}
