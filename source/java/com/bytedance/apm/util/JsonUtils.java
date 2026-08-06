package com.bytedance.apm.util;

import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JsonUtils {
    public static JSONObject copyJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<String> keys = jSONObject.keys();
        if (keys == null) {
            return null;
        }
        while (keys.hasNext()) {
            linkedList.add(keys.next());
        }
        try {
            return new JSONObject(jSONObject, (String[]) linkedList.toArray(new String[0]));
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public static JSONObject copyJson2(JSONObject jSONObject) throws JSONException {
        Iterator<String> keys;
        if (jSONObject == null || (keys = jSONObject.keys()) == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONObject2.put(next, jSONObject.opt(next));
        }
        return jSONObject2;
    }

    public static JSONObject copyJson2(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> keys;
        if (jSONObject == null || jSONObject2 == null || (keys = jSONObject2.keys()) == null) {
            return null;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject2.isNull(next)) {
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
        return jSONObject;
    }

    public static void combineJson(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null || jSONObject2.length() <= 0) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.get(next));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static boolean isEmpty(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    public static boolean isEmpty(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    public static boolean hasData(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    public static boolean hasData(JSONArray jSONArray) {
        return jSONArray != null && jSONArray.length() > 0;
    }

    public static int calc(JSONObject jSONObject) {
        try {
            StatsWriter statsWriter = new StatsWriter();
            JsonWriter.writeTo(jSONObject, statsWriter);
            return statsWriter.length;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int calc(JSONArray jSONArray) {
        if (jSONArray == null) {
            return 0;
        }
        try {
            StatsWriter statsWriter = new StatsWriter();
            JsonWriter.writeTo(jSONArray, statsWriter);
            return statsWriter.length;
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* loaded from: classes3.dex */
    private static class StatsWriter extends Writer {
        public int length;

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
        }

        private StatsWriter() {
            this.length = 0;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.length += i2;
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.length++;
        }

        @Override // java.io.Writer
        public void write(String str) throws IOException {
            this.length += str.length();
        }

        @Override // java.io.Writer
        public void write(char[] cArr) throws IOException {
            this.length += cArr.length;
        }

        @Override // java.io.Writer
        public void write(String str, int i, int i2) throws IOException {
            this.length += i2;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char c) throws IOException {
            this.length++;
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.length += charSequence.length();
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i, int i2) throws IOException {
            this.length += i2 - i;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    private static class JsonWriter {
        final Writer out;
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

        public JsonWriter(Writer writer) {
            this.out = writer;
        }

        public JsonWriter array() throws JSONException, IOException {
            return open(Scope.EMPTY_ARRAY, "[");
        }

        public JsonWriter endArray() throws JSONException, IOException {
            return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
        }

        public JsonWriter object() throws JSONException, IOException {
            return open(Scope.EMPTY_OBJECT, "{");
        }

        public JsonWriter endObject() throws JSONException, IOException {
            return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
        }

        JsonWriter open(Scope scope, String str) throws JSONException, IOException {
            beforeValue();
            this.stack.add(scope);
            this.out.write(str);
            return this;
        }

        JsonWriter close(Scope scope, Scope scope2, String str) throws JSONException, IOException {
            peek();
            this.stack.remove(r1.size() - 1);
            this.out.write(str);
            return this;
        }

        private Scope peek() throws JSONException {
            return this.stack.get(r0.size() - 1);
        }

        private void replaceTop(Scope scope) {
            this.stack.set(r0.size() - 1, scope);
        }

        public JsonWriter value(Object obj) throws JSONException, IOException {
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

        public JsonWriter value(boolean z) throws JSONException, IOException {
            beforeValue();
            this.out.write(String.valueOf(z));
            return this;
        }

        public JsonWriter value(double d) throws JSONException, IOException {
            beforeValue();
            this.out.write(JSONObject.numberToString(Double.valueOf(d)));
            return this;
        }

        public JsonWriter value(long j) throws JSONException, IOException {
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

        public JsonWriter key(String str) throws JSONException, IOException {
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
            new JsonWriter(writer).jsonWriteTo(jSONObject);
            writer.flush();
        }

        public static void writeTo(JSONArray jSONArray, Writer writer) throws Throwable {
            new JsonWriter(writer).arrayWriteTo(jSONArray);
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

    public static JSONObject optJSONObject(JSONObject jSONObject, String str, String str2) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        return optJSONObject.optJSONObject(str2);
    }

    public static JSONObject optJSONObject(JSONObject jSONObject, String str, String str2, String str3) {
        JSONObject optJSONObject = optJSONObject(jSONObject, str, str2);
        if (optJSONObject == null) {
            return null;
        }
        return optJSONObject.optJSONObject(str3);
    }

    public static int optInt(JSONObject jSONObject, String str, String str2, String str3) {
        JSONObject optJSONObject = optJSONObject(jSONObject, str, str2);
        if (optJSONObject == null) {
            return 0;
        }
        return optJSONObject.optInt(str3, 0);
    }

    public static boolean optBoolean(JSONObject jSONObject, String str, String str2, boolean z) {
        JSONObject optJSONObject;
        return (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(str)) == null) ? z : optJSONObject.optBoolean(str2, z);
    }

    public static JSONObject deepCopy(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new JSONObject(jSONObject.toString());
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public static JSONObject safeCopyJson2(JSONObject jSONObject) {
        Iterator<String> keys;
        if (jSONObject == null || (keys = jSONObject.keys()) == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject2.put(next, jSONObject.opt(next));
            }
            return jSONObject2;
        } catch (Exception unused) {
            return jSONObject;
        }
    }

    public static JSONObject safeJsonObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        if (keys == null) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt instanceof JSONObject) {
                    jSONObject2.put(next, safeJsonObject((JSONObject) opt));
                } else if (opt instanceof JSONArray) {
                    jSONObject2.put(next, safeJsonArray((JSONArray) opt));
                } else {
                    jSONObject2.put(next, opt);
                }
            }
            return jSONObject2;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public static JSONArray safeJsonArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        if (length == 0) {
            return jSONArray;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < length; i++) {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONObject) {
                    jSONArray2.put(safeJsonObject((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    jSONArray2.put(safeJsonArray((JSONArray) obj));
                } else {
                    jSONArray2.put(obj);
                }
            }
        } catch (Throwable unused) {
        }
        return jSONArray;
    }
}
