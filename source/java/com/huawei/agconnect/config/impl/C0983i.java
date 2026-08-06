package com.huawei.agconnect.config.impl;

import android.util.Log;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.huawei.agconnect.config.ConfigReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.agconnect.config.impl.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0983i implements ConfigReader {

    /* renamed from: a */
    private final JSONObject f850a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0983i(InputStream inputStream, String str) {
        this.f850a = m812a(inputStream);
        m813a(str);
    }

    /* renamed from: a */
    private JSONObject m812a(InputStream inputStream) {
        String str;
        if (inputStream != null) {
            try {
                return new JSONObject(Utils.toString(inputStream, Utf8Charset.NAME));
            } catch (IOException unused) {
                str = "IOException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            } catch (JSONException unused2) {
                str = "JSONException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    /* renamed from: a */
    private void m813a(String str) {
        try {
            JSONObject m815b = m815b(str);
            if (m815b == null) {
                return;
            }
            String string = getString("/configuration_version", "");
            BigDecimal bigDecimal = new BigDecimal("0.0");
            try {
                bigDecimal = BigDecimal.valueOf(Double.parseDouble(string));
            } catch (NumberFormatException unused) {
                Log.d("InputStreamReader", "configuration_version to double error");
            }
            if (bigDecimal.compareTo(new BigDecimal("2.0")) == 0) {
                this.f850a.getJSONObject("client").put("app_id", m815b.getString("app_id"));
                return;
            }
            if (bigDecimal.compareTo(new BigDecimal("3.0")) >= 0) {
                Iterator<String> keys = m815b.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!"package_name".equals(next)) {
                        m814a(next, m815b.get(next), this.f850a);
                    }
                }
            }
        } catch (JSONException unused2) {
            Log.d("InputStreamReader", "JSONException when reading the 'appInfos' from InputStream.");
        }
    }

    /* renamed from: a */
    private void m814a(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if (str == null || obj == null || jSONObject == null) {
            return;
        }
        if (!(obj instanceof JSONObject)) {
            jSONObject.put(str, obj);
            return;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            m814a(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
        }
    }

    /* renamed from: b */
    private JSONObject m815b(String str) throws JSONException {
        JSONArray jSONArray = this.f850a.getJSONArray("appInfos");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.getString("package_name").equals(str)) {
                return jSONObject;
            }
        }
        return null;
    }

    @Override // com.huawei.agconnect.config.ConfigReader
    public String getString(String str, String str2) {
        if (str.endsWith("/")) {
            return str2;
        }
        String[] split = str.split("/");
        try {
            JSONObject jSONObject = this.f850a;
            for (int i = 1; i < split.length; i++) {
                if (i == split.length - 1) {
                    str = jSONObject.get(split[i]).toString();
                    return str;
                }
                jSONObject = jSONObject.getJSONObject(split[i]);
            }
        } catch (JSONException unused) {
            Log.w("InputStreamReader", "JSONException when reading 'path': " + str);
        }
        return str2;
    }

    public String toString() {
        return "InputStreamReader{config=" + this.f850a.toString().hashCode() + '}';
    }
}
