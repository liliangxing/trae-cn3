package com.ttnet.org.chromium.base;

import java.util.Objects;

/* loaded from: classes7.dex */
public final class ParamChecker {
    public static void check(Class<?>[] clsArr, Object... objArr) {
        Objects.requireNonNull(clsArr, "parameterType should not be null");
        if (objArr == null) {
            objArr = new Object[0];
        }
        if (clsArr.length != objArr.length) {
            throw new IllegalArgumentException(String.format("param count mismatch: expected %d, actual %d", Integer.valueOf(clsArr.length), Integer.valueOf(objArr.length)));
        }
        for (int i = 0; i < clsArr.length; i++) {
            Class<?> cls = clsArr[i];
            Object obj = objArr[i];
            if (!isTypeCompatible(cls, obj)) {
                throw new IllegalArgumentException(String.format("The param %d type mismatch: expected %s, actual %s", Integer.valueOf(i + 1), getTypeName(cls), obj == null ? "null" : getTypeName(obj.getClass())));
            }
        }
    }

    private static boolean isTypeCompatible(Class<?> cls, Object obj) {
        if (obj == null) {
            return !cls.isPrimitive();
        }
        return toWrapperClass(cls).isAssignableFrom(toWrapperClass(obj.getClass()));
    }

    private static Class<?> toWrapperClass(Class<?> cls) {
        if (cls == null || !cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        name.hashCode();
        char c = 65535;
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    c = 0;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    c = 1;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    c = 2;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    c = 3;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    c = 4;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    c = 5;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    c = 6;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    c = 7;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Double.class;
            case 1:
                return Integer.class;
            case 2:
                return Byte.class;
            case 3:
                return Character.class;
            case 4:
                return Long.class;
            case 5:
                return Void.class;
            case 6:
                return Boolean.class;
            case 7:
                return Float.class;
            case '\b':
                return Short.class;
            default:
                return cls;
        }
    }

    private static String getTypeName(Class<?> cls) {
        if (cls == null) {
            return "null";
        }
        if (cls.isArray()) {
            return cls.getCanonicalName();
        }
        if (cls.isPrimitive()) {
            return cls.getName();
        }
        return cls.getCanonicalName();
    }
}
