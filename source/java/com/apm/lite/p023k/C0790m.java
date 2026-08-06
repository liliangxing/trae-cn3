package com.apm.lite.p023k;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.apm.lite.k.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0790m {

    /* renamed from: a */
    final Writer f583a;

    /* renamed from: b */
    private final List<a> f584b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.apm.lite.k.m$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public enum a {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL
    }

    public C0790m(Writer writer) {
        this.f583a = writer;
    }

    /* renamed from: a */
    private void m826a(a aVar) {
        this.f584b.set(r0.size() - 1, aVar);
    }

    /* renamed from: a */
    private void m827a(JSONArray jSONArray) {
        m835a();
        for (int i = 0; i < jSONArray.length(); i++) {
            m838a(jSONArray.get(i));
        }
        m840b();
    }

    /* renamed from: a */
    public static void m828a(JSONArray jSONArray, Writer writer) {
        new C0790m(writer).m827a(jSONArray);
        writer.flush();
    }

    /* renamed from: a */
    private void m829a(JSONObject jSONObject) {
        m841c();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            m839a(next).m838a(jSONObject.get(next));
        }
        m842d();
    }

    /* renamed from: a */
    public static void m830a(JSONObject jSONObject, Writer writer) {
        new C0790m(writer).m829a(jSONObject);
        writer.flush();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0027. Please report as an issue. */
    /* renamed from: b */
    private void m831b(String str) {
        Writer writer;
        String str2;
        this.f583a.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\f') {
                writer = this.f583a;
                str2 = "\\f";
            } else if (charAt != '\r') {
                if (charAt == '\"' || charAt == '/' || charAt == '\\') {
                    this.f583a.write(92);
                } else {
                    switch (charAt) {
                        case '\b':
                            writer = this.f583a;
                            str2 = "\\b";
                            break;
                        case '\t':
                            writer = this.f583a;
                            str2 = "\\t";
                            break;
                        case '\n':
                            writer = this.f583a;
                            str2 = "\\n";
                            break;
                        default:
                            if (charAt <= 31) {
                                this.f583a.write(String.format("\\u%04x", Integer.valueOf(charAt)));
                                break;
                            }
                            break;
                    }
                }
                this.f583a.write(charAt);
            } else {
                writer = this.f583a;
                str2 = "\\r";
            }
            writer.write(str2);
        }
        this.f583a.write("\"");
    }

    /* renamed from: e */
    private a m832e() {
        return this.f584b.get(r0.size() - 1);
    }

    /* renamed from: f */
    private void m833f() {
        a m832e = m832e();
        if (m832e == a.NONEMPTY_OBJECT) {
            this.f583a.write(44);
        } else if (m832e != a.EMPTY_OBJECT) {
            throw new JSONException("Nesting problem");
        }
        m826a(a.DANGLING_KEY);
    }

    /* renamed from: g */
    private void m834g() {
        a aVar;
        if (this.f584b.isEmpty()) {
            return;
        }
        a m832e = m832e();
        if (m832e == a.EMPTY_ARRAY) {
            aVar = a.NONEMPTY_ARRAY;
        } else if (m832e == a.NONEMPTY_ARRAY) {
            this.f583a.write(44);
            return;
        } else if (m832e != a.DANGLING_KEY) {
            if (m832e != a.NULL) {
                throw new JSONException("Nesting problem");
            }
            return;
        } else {
            this.f583a.write(":");
            aVar = a.NONEMPTY_OBJECT;
        }
        m826a(aVar);
    }

    /* renamed from: a */
    public C0790m m835a() {
        return m837a(a.EMPTY_ARRAY, "[");
    }

    /* renamed from: a */
    C0790m m836a(a aVar, a aVar2, String str) {
        m832e();
        this.f584b.remove(r1.size() - 1);
        this.f583a.write(str);
        return this;
    }

    /* renamed from: a */
    C0790m m837a(a aVar, String str) {
        m834g();
        this.f584b.add(aVar);
        this.f583a.write(str);
        return this;
    }

    /* renamed from: a */
    public C0790m m838a(Object obj) {
        Writer writer;
        String numberToString;
        if (obj instanceof JSONArray) {
            m827a((JSONArray) obj);
            return this;
        }
        if (obj instanceof JSONObject) {
            m829a((JSONObject) obj);
            return this;
        }
        m834g();
        if (obj == null || obj == JSONObject.NULL) {
            this.f583a.write("null");
        } else {
            if (obj instanceof Boolean) {
                writer = this.f583a;
                numberToString = String.valueOf(obj);
            } else if (obj instanceof Number) {
                writer = this.f583a;
                numberToString = JSONObject.numberToString((Number) obj);
            } else {
                m831b(obj.toString());
            }
            writer.write(numberToString);
        }
        return this;
    }

    /* renamed from: a */
    public C0790m m839a(String str) {
        m833f();
        m831b(str);
        return this;
    }

    /* renamed from: b */
    public C0790m m840b() {
        return m836a(a.EMPTY_ARRAY, a.NONEMPTY_ARRAY, "]");
    }

    /* renamed from: c */
    public C0790m m841c() {
        return m837a(a.EMPTY_OBJECT, "{");
    }

    /* renamed from: d */
    public C0790m m842d() {
        return m836a(a.EMPTY_OBJECT, a.NONEMPTY_OBJECT, "}");
    }

    public String toString() {
        return "";
    }
}
