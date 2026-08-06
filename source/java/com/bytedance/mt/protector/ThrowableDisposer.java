package com.bytedance.mt.protector;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ThrowableDisposer {
    private static ThrowableDisposer instance = new ThrowableDisposer();
    final List<ConfItem> confItems = new CopyOnWriteArrayList();

    private ThrowableDisposer() {
    }

    public List<ConfItem> getConfItems() {
        return this.confItems;
    }

    public static ThrowableDisposer getInstance() {
        return instance;
    }

    public void setConf(JsonArray jsonArray) {
        if (jsonArray == null || jsonArray.size() == 0) {
            this.confItems.clear();
            return;
        }
        this.confItems.clear();
        Iterator it = jsonArray.iterator();
        while (it.hasNext()) {
            ConfItem create = ConfItem.create((JsonElement) it.next());
            if (create != null) {
                this.confItems.add(create);
            }
        }
    }

    public ThrowableDisposerResult disposeThrowable(ProtectorType protectorType, Throwable th) {
        if (protectorType != null && th != null && this.confItems.size() != 0) {
            for (ConfItem confItem : this.confItems) {
                if (confItem.isTarget(protectorType, th) && confItem.returnValue != null) {
                    if ("string".equals(confItem.returnType)) {
                        return new ThrowableDisposerResult(DataType.getType(confItem.returnType), confItem.returnValue.getAsString());
                    }
                    if ("byte".equals(confItem.returnType)) {
                        return new ThrowableDisposerResult(DataType.getType(confItem.returnType), Byte.valueOf(confItem.returnValue.getAsByte()));
                    }
                    if ("short".equals(confItem.returnType)) {
                        return new ThrowableDisposerResult(DataType.getType(confItem.returnType), Short.valueOf(confItem.returnValue.getAsShort()));
                    }
                    if ("int".equals(confItem.returnType)) {
                        return new ThrowableDisposerResult(DataType.getType(confItem.returnType), Integer.valueOf(confItem.returnValue.getAsInt()));
                    }
                    if ("long".equals(confItem.returnType)) {
                        return new ThrowableDisposerResult(DataType.getType(confItem.returnType), Long.valueOf(confItem.returnValue.getAsLong()));
                    }
                    if ("float".equals(confItem.returnType)) {
                        return new ThrowableDisposerResult(DataType.getType(confItem.returnType), Float.valueOf(confItem.returnValue.getAsFloat()));
                    }
                    if ("double".equals(confItem.returnType)) {
                        return new ThrowableDisposerResult(DataType.getType(confItem.returnType), Double.valueOf(confItem.returnValue.getAsDouble()));
                    }
                    if ("boolean".equals(confItem.returnType)) {
                        return new ThrowableDisposerResult(DataType.getType(confItem.returnType), Boolean.valueOf(confItem.returnValue.getAsBoolean()));
                    }
                    if ("jsonElement".equals(confItem.returnType)) {
                        return new ThrowableDisposerResult(DataType.getType(confItem.returnType), confItem.returnValue);
                    }
                    if ("null".equals(confItem.returnType)) {
                        return new ThrowableDisposerResult(DataType.getType(confItem.returnType), null);
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class ConfItem {
        private static final String PROTECTOR_TYPE = "protectorType";
        public static final String RETURN_TYPE = "returnType";
        public static final String RETURN_VALUE = "returnValue";
        private static final String STACK_FEATURES = "stackFeatures";
        String protectorType;
        String returnType;
        JsonElement returnValue;
        String[] stackFeatures;

        ConfItem() {
        }

        static ConfItem create(JsonElement jsonElement) {
            if (jsonElement != null && jsonElement.getAsJsonObject() != null) {
                ConfItem confItem = new ConfItem();
                try {
                    if (jsonElement.getAsJsonObject().has(STACK_FEATURES)) {
                        String asString = jsonElement.getAsJsonObject().get(STACK_FEATURES).getAsString();
                        confItem.stackFeatures = asString != null ? asString.split("\n") : new String[0];
                        if (jsonElement.getAsJsonObject().has(PROTECTOR_TYPE)) {
                            confItem.protectorType = jsonElement.getAsJsonObject().get(PROTECTOR_TYPE).getAsString();
                            if (jsonElement.getAsJsonObject().has(RETURN_TYPE)) {
                                confItem.returnType = jsonElement.getAsJsonObject().get(RETURN_TYPE).getAsString();
                                if (jsonElement.getAsJsonObject().has(RETURN_VALUE)) {
                                    confItem.returnValue = jsonElement.getAsJsonObject().get(RETURN_VALUE);
                                    LogUtils.m112d("create ConfItem " + confItem.toString());
                                    return confItem;
                                }
                                LogUtils.eWithTag("ConfItem", String.format("ConfItem can't find key %s in %s", RETURN_VALUE, jsonElement.toString()));
                                return null;
                            }
                            LogUtils.eWithTag("ConfItem", String.format("ConfItem can't find key %s in %s", RETURN_TYPE, jsonElement.toString()));
                            return null;
                        }
                        LogUtils.eWithTag("ConfItem", String.format("ConfItem can't find key %s in %s", PROTECTOR_TYPE, jsonElement.toString()));
                        return null;
                    }
                    LogUtils.eWithTag("ConfItem", String.format("ConfItem can't find key %s in %s", STACK_FEATURES, jsonElement.toString()));
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtils.m112d("create ConfItem has exception " + e.toString());
                }
            }
            return null;
        }

        public boolean isSameException(Throwable th) {
            String trim;
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i = -1;
            int i2 = 0;
            while (i < stackTrace.length && i2 < this.stackFeatures.length) {
                if (i == -1) {
                    trim = th.toString().trim();
                } else {
                    trim = stackTrace[i].toString().trim();
                }
                i++;
                if (trim.contains(this.stackFeatures[i2].trim())) {
                    i2++;
                }
            }
            return i2 == this.stackFeatures.length;
        }

        boolean isTarget(ProtectorType protectorType, Throwable th) {
            if (protectorType == null || th == null || !protectorType.getName().equals(this.protectorType)) {
                return false;
            }
            return isSameException(th);
        }

        public String toString() {
            return "ConfItem{stackFeatures=" + Arrays.toString(this.stackFeatures) + ", protectorType='" + this.protectorType + "', returnType='" + this.returnType + "', returnValue='" + this.returnValue + "'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum DataType {
        NULL_RESULT_TYPE("null", 0),
        STRING_RESULT_TYPE("string", 1),
        INT_RESULT_TYPE("int", 2),
        LONG_RESULT_TYPE("long", 3),
        FLOAT_RESULT_TYPE("float", 4),
        JSON_ELEMENT_RESULT_TYPE("jsonElement", 5),
        BOOLEAN_RESULT_TYPE("boolean", 6),
        BYTE_RESULT_TYPE("byte", 7),
        SHORT_RESULT_TYPE("short", 8),
        DOUBLE_RESULT_TYPE("double", 9);

        private String text;
        private int type;

        DataType(String str, int i) {
            this.text = str;
            this.type = i;
        }

        static int getType(String str) {
            for (DataType dataType : values()) {
                if (str.equals(dataType.text)) {
                    return dataType.type;
                }
            }
            return 0;
        }
    }
}
