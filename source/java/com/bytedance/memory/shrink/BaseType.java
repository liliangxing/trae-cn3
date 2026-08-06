package com.bytedance.memory.shrink;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public enum BaseType {
    OBJECT(2, 0),
    BOOLEAN(4, 1),
    CHAR(5, 2),
    FLOAT(6, 4),
    DOUBLE(7, 8),
    BYTE(8, 1),
    SHORT(9, 2),
    INT(10, 4),
    LONG(11, 8);

    private static Map<Integer, BaseType> sTypeMap = new HashMap();
    private int mId;
    private int mSize;

    static {
        for (BaseType baseType : values()) {
            sTypeMap.put(Integer.valueOf(baseType.mId), baseType);
        }
    }

    BaseType(int i, int i2) {
        this.mId = i;
        this.mSize = i2;
    }

    public static BaseType getType(int i) {
        return sTypeMap.get(Integer.valueOf(i));
    }

    public int getSize(int i) {
        int i2 = this.mSize;
        return i2 != 0 ? i2 : i;
    }

    public int getTypeId() {
        return this.mId;
    }

    /* renamed from: com.bytedance.memory.shrink.BaseType$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$memory$shrink$BaseType;

        static {
            int[] iArr = new int[BaseType.values().length];
            $SwitchMap$com$bytedance$memory$shrink$BaseType = iArr;
            try {
                iArr[BaseType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.BYTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.SHORT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.INT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.LONG.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static String getClassNameOfPrimitiveArray(BaseType baseType) {
        switch (AnonymousClass1.$SwitchMap$com$bytedance$memory$shrink$BaseType[baseType.ordinal()]) {
            case 1:
                return "boolean[]";
            case 2:
                return "char[]";
            case 3:
                return "float[]";
            case 4:
                return "double[]";
            case 5:
                return "byte[]";
            case 6:
                return "short[]";
            case 7:
                return "int[]";
            case 8:
                return "long[]";
            default:
                throw new IllegalArgumentException("OBJECT type is not a primitive type");
        }
    }
}
