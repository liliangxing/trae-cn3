package com.bytedance.tobshadow.bdtracker;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class c5 {
    public int a;
    public int b;
    public final boolean c = true;

    public static int a(JSONObject jSONObject) {
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
            i = a(jSONObject.opt(next)) + b(next) + 3 + i;
            z = false;
        }
        return i;
    }

    public static int b(String str) {
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

    public boolean a(JSONObject jSONObject, boolean z) {
        int a = a(jSONObject) + (z ? 15 : 1);
        int i = this.a;
        if (!(((long) (i + a)) < 1048576)) {
            return false;
        }
        this.a = i + a;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
    
        if (r0 > 51200) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        int i;
        if (str != null && str.length() * 4 > 51200) {
            i = b(str);
        }
        i = -1;
        return i > 0 ? "{\"description\":\"event param too large\"}" : str;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:39:0x0059. Please report as an issue. */
    public static int a(Object obj) {
        if (obj instanceof JSONObject) {
            return a((JSONObject) obj);
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
                i += a(jSONArray.opt(i3));
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
