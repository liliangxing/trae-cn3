package com.bytedance.crash.util;

import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JSONWriter {
    private final Writer out;
    private final List<Scope> stack = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum Scope {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL
    }

    public String toString() {
        return "";
    }

    private JSONWriter(Writer writer) {
        this.out = writer;
    }

    private JSONWriter array() throws JSONException, IOException {
        return open(Scope.EMPTY_ARRAY, "[");
    }

    private JSONWriter endArray() throws JSONException, IOException {
        return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }

    private JSONWriter object() throws JSONException, IOException {
        return open(Scope.EMPTY_OBJECT, "{");
    }

    private JSONWriter endObject() throws JSONException, IOException {
        return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
    }

    private JSONWriter open(Scope scope, String str) throws JSONException, IOException {
        beforeValue();
        this.stack.add(scope);
        this.out.write(str);
        return this;
    }

    private JSONWriter close(Scope scope, Scope scope2, String str) throws JSONException, IOException {
        peek();
        this.stack.remove(r1.size() - 1);
        this.out.write(str);
        return this;
    }

    private Scope peek() {
        return this.stack.get(r0.size() - 1);
    }

    private void replaceTop(Scope scope) {
        this.stack.set(r0.size() - 1, scope);
    }

    private JSONWriter value(Object obj) throws JSONException, IOException {
        if (obj instanceof JSONArray) {
            arrayWriteTo((JSONArray) obj);
            return this;
        }
        if (obj instanceof JSONObject) {
            jsonWriteTo((JSONObject) obj);
            return this;
        }
        beforeValue();
        if (obj == null || obj == JSONObject.NULL) {
            this.out.write("null");
        } else if (obj instanceof Boolean) {
            this.out.write(String.valueOf(obj));
        } else if (obj instanceof Number) {
            this.out.write(JSONObject.numberToString((Number) obj));
        } else {
            string(obj.toString());
        }
        return this;
    }

    public JSONWriter value(boolean z) throws JSONException, IOException {
        beforeValue();
        this.out.write(String.valueOf(z));
        return this;
    }

    public JSONWriter value(double d) throws JSONException, IOException {
        beforeValue();
        this.out.write(JSONObject.numberToString(Double.valueOf(d)));
        return this;
    }

    public JSONWriter value(long j) throws JSONException, IOException {
        beforeValue();
        this.out.write(String.valueOf(j));
        return this;
    }

    private void string(String str) throws IOException {
        this.out.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '\f') {
                if (charAt != '\r') {
                    if (charAt == '\"' || charAt == '/' || charAt == '\\') {
                        this.out.write(92);
                        this.out.write(charAt);
                    } else {
                        switch (charAt) {
                            case '\b':
                                this.out.write("\\b");
                                break;
                            case '\t':
                                this.out.write("\\t");
                                break;
                            case '\n':
                                this.out.write("\\n");
                                break;
                            default:
                                if (charAt <= 31) {
                                    this.out.write(String.format("\\u%04x", Integer.valueOf(charAt)));
                                    break;
                                } else {
                                    this.out.write(charAt);
                                    break;
                                }
                        }
                    }
                } else {
                    this.out.write("\\r");
                }
            } else {
                this.out.write("\\f");
            }
        }
        this.out.write("\"");
    }

    private JSONWriter key(String str) throws JSONException, IOException {
        beforeKey();
        string(str);
        return this;
    }

    private void beforeKey() throws JSONException, IOException {
        Scope peek = peek();
        if (peek == Scope.NONEMPTY_OBJECT) {
            this.out.write(44);
        } else if (peek != Scope.EMPTY_OBJECT) {
            throw new JSONException("Nesting problem");
        }
        replaceTop(Scope.DANGLING_KEY);
    }

    private void beforeValue() throws JSONException, IOException {
        if (this.stack.isEmpty()) {
            return;
        }
        Scope peek = peek();
        if (peek == Scope.EMPTY_ARRAY) {
            replaceTop(Scope.NONEMPTY_ARRAY);
            return;
        }
        if (peek == Scope.NONEMPTY_ARRAY) {
            this.out.write(44);
        } else if (peek == Scope.DANGLING_KEY) {
            this.out.write(Constants.COLON_SEPARATOR);
            replaceTop(Scope.NONEMPTY_OBJECT);
        } else if (peek != Scope.NULL) {
            throw new JSONException("Nesting problem");
        }
    }

    public static void writeTo(JSONObject jSONObject, Writer writer) throws Throwable {
        new JSONWriter(writer).jsonWriteTo(jSONObject);
        writer.flush();
    }

    public static void writeTo(JSONArray jSONArray, Writer writer) throws Throwable {
        new JSONWriter(writer).arrayWriteTo(jSONArray);
        writer.flush();
    }

    private void jsonWriteTo(JSONObject jSONObject) throws JSONException, IOException {
        object();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            key(next).value(jSONObject.get(next));
        }
        endObject();
    }

    private void arrayWriteTo(JSONArray jSONArray) throws JSONException, IOException {
        array();
        for (int i = 0; i < jSONArray.length(); i++) {
            value(jSONArray.get(i));
        }
        endArray();
    }
}
