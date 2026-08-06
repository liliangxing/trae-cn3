package com.bytedance.ies.web.jsbridge2;

import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class DataConverterActual {
    private final IDataConverter converter;
    private boolean optJsonObject;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DataConverterActual from(IDataConverter iDataConverter) {
        return new DataConverterActual(iDataConverter);
    }

    private DataConverterActual(IDataConverter iDataConverter) {
        this.converter = iDataConverter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> T fromRawData(String str, Type type) throws JSONException {
        checkRawDataLegal(str);
        if (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) {
            return (T) new JSONObject(str);
        }
        return (T) this.converter.fromRawData(str, type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> String toRawData(T t) {
        String obj;
        if (t == null) {
            return "{}";
        }
        if ((t instanceof JSONObject) || (t instanceof JSONArray)) {
            obj = t.toString();
        } else {
            obj = this.converter.toRawData(t);
        }
        checkRawDataLegal(obj);
        return obj;
    }

    IDataConverter getConverter() {
        return this.converter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOptJsonObject() {
        return this.optJsonObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOptJsonObject(boolean z) {
        this.optJsonObject = z;
    }

    private static void checkRawDataLegal(String str) {
        if (str.startsWith("{") && str.endsWith("}")) {
            return;
        }
        DebugUtil.throwRuntimeException(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n " + str));
    }
}
