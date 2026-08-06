package com.lynx.jsbridge;

import com.lynx.jsbridge.jsi.ILynxJSIObject;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.PiperData;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.Assertions;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxMethodWrapper {
    private boolean mArgumentsProcessed = false;
    private final Method mMethod;
    private final Class[] mParameterTypes;
    private String mSignature;
    private static final Set<Class<?>> mJavaOnlyMapClassSets = getSelfFirstLevelSuperAndInterfaces(JavaOnlyMap.class);
    private static final Set<Class<?>> mJavaOnlyArrayClassSets = getSelfFirstLevelSuperAndInterfaces(JavaOnlyArray.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    public LynxMethodWrapper(Method method) {
        this.mMethod = method;
        method.setAccessible(true);
        this.mParameterTypes = method.getParameterTypes();
    }

    private static Set<Class<?>> getSelfFirstLevelSuperAndInterfaces(Class<?> cls) {
        HashSet hashSet = new HashSet();
        hashSet.add(cls);
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            hashSet.add(superclass);
        }
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            hashSet.addAll(Arrays.asList(interfaces));
        }
        return hashSet;
    }

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
        if (mJavaOnlyMapClassSets.contains(cls)) {
            return 'M';
        }
        if (mJavaOnlyArrayClassSets.contains(cls)) {
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
        if (cls == WritableMap.class || cls == ReadableMap.class || cls == JavaOnlyMap.class) {
            return 'M';
        }
        if (cls == WritableArray.class || cls == ReadableArray.class || cls == JavaOnlyArray.class) {
            return 'A';
        }
        if (cls == byte[].class) {
            return 'a';
        }
        if (cls == PiperData.class) {
            return 'J';
        }
        if (cls == ILynxJSIObject.class) {
            return 'O';
        }
        if (cls == TemplateData.class) {
            return 'E';
        }
        throw new RuntimeException("Got unknown return class: " + cls.getSimpleName());
    }

    private static char commonTypeToChar(Class cls) {
        if (cls.equals(Byte.TYPE)) {
            return 'b';
        }
        if (cls.equals(Byte.class)) {
            return 'B';
        }
        if (cls.equals(Short.TYPE)) {
            return 's';
        }
        if (cls.equals(Short.class)) {
            return 'S';
        }
        if (cls.equals(Long.TYPE)) {
            return 'l';
        }
        if (cls.equals(Long.class)) {
            return 'L';
        }
        if (cls.equals(Character.TYPE)) {
            return 'c';
        }
        if (cls.equals(Character.class)) {
            return 'C';
        }
        if (cls.equals(Boolean.TYPE)) {
            return 'z';
        }
        if (cls.equals(Boolean.class)) {
            return 'Z';
        }
        if (cls.equals(Integer.TYPE)) {
            return 'i';
        }
        if (cls.equals(Integer.class)) {
            return 'I';
        }
        if (cls.equals(Double.TYPE)) {
            return 'd';
        }
        if (cls.equals(Double.class)) {
            return 'D';
        }
        if (cls.equals(Float.TYPE)) {
            return 'f';
        }
        if (cls.equals(Float.class)) {
            return 'F';
        }
        return cls.equals(String.class) ? 'T' : (char) 0;
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
