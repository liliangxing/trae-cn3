package com.bytedance.mt.protector.impl;

import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.mt.protector.LogUtils;
import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.SelfDataManager;
import com.bytedance.mt.protector.ThrowableDisposerResult;
import com.bytedance.mt.protector.utils.StackTraceUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.Reader;
import java.lang.reflect.Type;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GsonProtectorUtils {
    private static void addSelfData(String str, Throwable th, String str2) {
        try {
            String stackTrace = StackTraceUtils.getStackTrace(th);
            JsonElement jsonObject = new JsonObject();
            jsonObject.addProperty("stackTrace", stackTrace);
            jsonObject.addProperty("inputData", str2);
            SelfDataManager.getInstance().addData(str, jsonObject, th);
        } catch (Throwable th2) {
            LogUtils.m113e("addSelfData", th2);
        }
    }

    private static void addSelfData(String str, Throwable th, JsonElement jsonElement) {
        addSelfData(str, th, jsonElement != null ? jsonElement.toString() : "null-param");
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static Gson createGson() {
        if (Protector.enable()) {
            try {
                return new Gson();
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    addSelfData("createGson", th, "Gson<init>");
                    throw th;
                }
                if (disposeThrowable.getResult() instanceof JsonElement) {
                    return new Gson();
                }
                return null;
            }
        }
        return new Gson();
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T fromJson(Gson gson, JsonElement jsonElement, Class<T> cls) {
        if (Protector.enable()) {
            try {
                return (T) gson.fromJson(jsonElement, cls);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    addSelfData("fromJson", th, jsonElement);
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof JsonElement) {
                    return (T) gson.fromJson((JsonElement) result, cls);
                }
                return null;
            }
        }
        return (T) gson.fromJson(jsonElement, cls);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T fromJson(Gson gson, JsonElement jsonElement, Type type) {
        if (Protector.enable()) {
            try {
                return (T) gson.fromJson(jsonElement, type);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    addSelfData("fromJson", th, jsonElement);
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof JsonElement) {
                    return (T) gson.fromJson((JsonElement) result, type);
                }
                return null;
            }
        }
        return (T) gson.fromJson(jsonElement, type);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T fromJson(Gson gson, String str, Class<T> cls) {
        if (Protector.enable()) {
            try {
                return (T) gson.fromJson(str, cls);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    addSelfData("fromJson", th, str);
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof JsonElement) {
                    return (T) gson.fromJson((JsonElement) result, cls);
                }
                return null;
            }
        }
        return (T) gson.fromJson(str, cls);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T fromJson(Gson gson, String str, Type type) {
        if (Protector.enable()) {
            try {
                return (T) gson.fromJson(str, type);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    addSelfData("fromJson", th, str);
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof JsonElement) {
                    return (T) gson.fromJson((JsonElement) result, type);
                }
                return null;
            }
        }
        return (T) gson.fromJson(str, type);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T fromJson(Gson gson, Reader reader, Class<T> cls) {
        if (Protector.enable()) {
            try {
                return (T) gson.fromJson(reader, cls);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    addSelfData("fromJson", th, "unsupport Reader");
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof JsonElement) {
                    return (T) gson.fromJson((JsonElement) result, cls);
                }
                return null;
            }
        }
        return (T) gson.fromJson(reader, cls);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T fromJson(Gson gson, Reader reader, Type type) {
        if (Protector.enable()) {
            try {
                return (T) gson.fromJson(reader, type);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    addSelfData("fromJson", th, "unsupport Reader");
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof JsonElement) {
                    return (T) gson.fromJson((JsonElement) result, type);
                }
                return null;
            }
        }
        return (T) gson.fromJson(reader, type);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T fromJson(Gson gson, JsonReader jsonReader, Type type) {
        if (Protector.enable()) {
            try {
                return (T) gson.fromJson(jsonReader, type);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    addSelfData("fromJson", th, "unsupport JsonReader");
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof JsonElement) {
                    return (T) gson.fromJson((JsonElement) result, type);
                }
                return null;
            }
        }
        return (T) gson.fromJson(jsonReader, type);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static String toJson(Gson gson, Object obj) {
        if (Protector.enable()) {
            try {
                return gson.toJson(obj);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                return (String) disposeThrowable.getResult();
            }
        }
        return gson.toJson(obj);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static String toJson(Gson gson, Object obj, Type type) {
        if (Protector.enable()) {
            try {
                return gson.toJson(obj, type);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                return (String) disposeThrowable.getResult();
            }
        }
        return gson.toJson(obj, type);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static void toJson(Gson gson, Object obj, Appendable appendable) {
        if (Protector.enable()) {
            try {
                gson.toJson(obj, appendable);
                return;
            } catch (Throwable th) {
                if (Protector.disposeThrowable(ProtectorType.JSON, th) == null) {
                    throw th;
                }
                return;
            }
        }
        gson.toJson(obj, appendable);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static void toJson(Gson gson, Object obj, Type type, Appendable appendable) {
        if (Protector.enable()) {
            try {
                gson.toJson(obj, type, appendable);
                return;
            } catch (Throwable th) {
                if (Protector.disposeThrowable(ProtectorType.JSON, th) == null) {
                    throw th;
                }
                return;
            }
        }
        gson.toJson(obj, type, appendable);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static void toJson(Gson gson, Object obj, Type type, JsonWriter jsonWriter) {
        if (Protector.enable()) {
            try {
                gson.toJson(obj, type, jsonWriter);
                return;
            } catch (Throwable th) {
                if (Protector.disposeThrowable(ProtectorType.JSON, th) == null) {
                    throw th;
                }
                return;
            }
        }
        gson.toJson(obj, type, jsonWriter);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static String toJson(Gson gson, JsonElement jsonElement) {
        if (Protector.enable()) {
            try {
                return gson.toJson(jsonElement);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    throw th;
                }
                return (String) disposeThrowable.getResult();
            }
        }
        return gson.toJson(jsonElement);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static void toJson(Gson gson, JsonElement jsonElement, Appendable appendable) {
        if (Protector.enable()) {
            try {
                gson.toJson(jsonElement, appendable);
                return;
            } catch (Throwable th) {
                if (Protector.disposeThrowable(ProtectorType.JSON, th) == null) {
                    throw th;
                }
                return;
            }
        }
        gson.toJson(jsonElement, appendable);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JsonElement toJsonTree(Gson gson, Object obj) {
        if (Protector.enable()) {
            try {
                return gson.toJsonTree(obj);
            } catch (Throwable th) {
                if (Protector.disposeThrowable(ProtectorType.JSON, th) != null) {
                    return null;
                }
                throw th;
            }
        }
        return gson.toJsonTree(obj);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JsonElement toJsonTree(Gson gson, Object obj, Type type) {
        if (Protector.enable()) {
            try {
                return gson.toJsonTree(obj, type);
            } catch (Throwable th) {
                if (Protector.disposeThrowable(ProtectorType.JSON, th) != null) {
                    return null;
                }
                throw th;
            }
        }
        return gson.toJsonTree(obj, type);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static JsonElement parse(JsonParser jsonParser, String str) {
        if (Protector.enable()) {
            try {
                return jsonParser.parse(str);
            } catch (Throwable th) {
                ThrowableDisposerResult disposeThrowable = Protector.disposeThrowable(ProtectorType.JSON, th);
                if (disposeThrowable == null) {
                    addSelfData(RLMonitorReporter.PARSE, th, str);
                    throw th;
                }
                Object result = disposeThrowable.getResult();
                if (result instanceof String) {
                    return jsonParser.parse((String) result);
                }
                return null;
            }
        }
        return jsonParser.parse(str);
    }
}
