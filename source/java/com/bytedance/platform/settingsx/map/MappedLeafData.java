package com.bytedance.platform.settingsx.map;

import com.bytedance.platform.settingsx.api.map.MappedData;

/* loaded from: classes4.dex */
public class MappedLeafData extends MappedData {
    private Type type;
    private Object value;

    /* loaded from: classes4.dex */
    public enum Type {
        STRING,
        ARRAY,
        MAP,
        INT,
        LONG,
        FLOAT,
        DOUBLE,
        BOOLEAN;

        public static Type getType(int i) {
            Type type = STRING;
            if (i == type.ordinal()) {
                return type;
            }
            Type type2 = INT;
            if (i == type2.ordinal()) {
                return type2;
            }
            Type type3 = LONG;
            if (i == type3.ordinal()) {
                return type3;
            }
            Type type4 = FLOAT;
            if (i == type4.ordinal()) {
                return type4;
            }
            Type type5 = DOUBLE;
            if (i == type5.ordinal()) {
                return type5;
            }
            Type type6 = BOOLEAN;
            if (i == type6.ordinal()) {
                return type6;
            }
            Type type7 = ARRAY;
            return i == type7.ordinal() ? type7 : MAP;
        }
    }

    public Object getValue() {
        return this.value;
    }

    public Type getType() {
        return this.type;
    }

    public MappedLeafData(int i, String str, Object obj, Type type) {
        super(i, str);
        this.value = obj;
        this.type = type;
    }
}
