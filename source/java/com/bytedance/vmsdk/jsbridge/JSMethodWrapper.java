package com.bytedance.vmsdk.jsbridge;

import androidx.collection.ArrayMap;
import com.bytedance.vmsdk.jsbridge.utils.Assertions;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.Dynamic;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class JSMethodWrapper {
    private static ArrayMap<Class, Character> class2Type;
    private boolean mArgumentsProcessed = false;
    private final Method mMethod;
    private final Class[] mParameterTypes;
    private String mSignature;

    private static char paramTypeToChar(Class cls) {
        char commonTypeToChar = commonTypeToChar(cls);
        if (commonTypeToChar != 0) {
            return commonTypeToChar;
        }
        if (cls == Callback.class) {
            return 'X';
        }
        if (cls == Promise.class) {
            return 'P';
        }
        if (cls == ReadableMap.class) {
            return 'M';
        }
        if (cls == ReadableArray.class) {
            return 'A';
        }
        if (cls == Dynamic.class) {
            return 'Y';
        }
        if (cls == byte[].class) {
            return 'a';
        }
        throw new RuntimeException("Got unknown param class: " + cls.getSimpleName());
    }

    private static char returnTypeToChar(Class cls) {
        char commonTypeToChar = commonTypeToChar(cls);
        if (commonTypeToChar != 0) {
            return commonTypeToChar;
        }
        if (cls == Void.TYPE) {
            return 'v';
        }
        if (cls == WritableMap.class) {
            return 'M';
        }
        if (cls == WritableArray.class) {
            return 'A';
        }
        if (cls == byte[].class) {
            return 'a';
        }
        throw new RuntimeException("Got unknown return class: " + cls.getSimpleName());
    }

    private static char commonTypeToChar(Class cls) {
        if (class2Type == null) {
            ArrayMap<Class, Character> arrayMap = new ArrayMap<>();
            class2Type = arrayMap;
            arrayMap.put(Byte.TYPE, 'b');
            class2Type.put(Byte.class, 'B');
            class2Type.put(Short.TYPE, 's');
            class2Type.put(Short.class, 'S');
            class2Type.put(Long.TYPE, 'l');
            class2Type.put(Long.class, 'L');
            class2Type.put(Character.TYPE, 'c');
            class2Type.put(Character.class, 'C');
            class2Type.put(Boolean.TYPE, 'z');
            class2Type.put(Boolean.class, 'Z');
            class2Type.put(Integer.TYPE, 'i');
            class2Type.put(Integer.class, 'I');
            class2Type.put(Double.TYPE, 'd');
            class2Type.put(Double.class, 'D');
            class2Type.put(Float.TYPE, 'f');
            class2Type.put(Float.class, 'F');
            class2Type.put(String.class, 'T');
        }
        if (class2Type.containsKey(cls)) {
            return ((Character) class2Type.get(cls)).charValue();
        }
        return (char) 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSMethodWrapper(Method method) {
        this.mMethod = method;
        method.setAccessible(true);
        this.mParameterTypes = method.getParameterTypes();
    }

    private void processArguments() {
        if (this.mArgumentsProcessed) {
            return;
        }
        this.mArgumentsProcessed = true;
        this.mSignature = buildSignature(this.mMethod, this.mParameterTypes);
    }

    public Method getMethod() {
        return this.mMethod;
    }

    public String getSignature() {
        if (!this.mArgumentsProcessed) {
            processArguments();
        }
        return (String) Assertions.assertNotNull(this.mSignature);
    }

    private String buildSignature(Method method, Class[] clsArr) {
        StringBuilder sb = new StringBuilder(clsArr.length + 2);
        sb.append(returnTypeToChar(method.getReturnType()));
        sb.append('.');
        int i = 0;
        while (i < clsArr.length) {
            Class cls = clsArr[i];
            if (cls == Promise.class) {
                Assertions.assertCondition(i == clsArr.length - 1, "Promise must be used as last parameter only");
            }
            sb.append(paramTypeToChar(cls));
            i++;
        }
        return sb.toString();
    }
}
