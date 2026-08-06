package com.bytedance.vmsdk.registry;

import android.text.TextUtils;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaScriptObject;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import com.bytedance.vmsdk.worker.JsWorker;
import com.bytedance.vmsdk.worker.VmSdkException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class JavaScriptRegistry {
    HashMap<Class<? extends JavaScriptModule>, JavaScriptModule> mModuleMap = new HashMap<>();
    HashMap<Class<? extends JavaScriptFunction>, JavaScriptFunction> mFunctionMap = new HashMap<>();

    public <T extends JavaScriptModule> T getJavaScriptModule(JsWorker jsWorker, Class<? extends JavaScriptModule> cls) {
        T t = (T) this.mModuleMap.get(cls);
        if (t != null) {
            return t;
        }
        T t2 = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new JavaScriptModuleProxy(jsWorker, cls));
        this.mModuleMap.put(cls, t2);
        return t2;
    }

    public <T extends JavaScriptFunction> T getJavaScriptFunction(JsWorker jsWorker, Class<? extends JavaScriptFunction> cls) {
        T t = (T) this.mFunctionMap.get(cls);
        if (t != null) {
            return t;
        }
        T t2 = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new JavaScriptFunctionProxy(jsWorker, cls));
        this.mFunctionMap.put(cls, t2);
        return t2;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class JavaScriptFunctionProxy implements InvocationHandler {
        private Class<? extends JavaScriptFunction> mInterfaceCls;
        private JsWorker mJsWorker;

        public JavaScriptFunctionProxy(JsWorker jsWorker, Class<? extends JavaScriptFunction> cls) {
            this.mJsWorker = jsWorker;
            this.mInterfaceCls = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            JavaOnlyArray m13of = JavaOnlyArray.m13of(objArr);
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            int length = exceptionTypes.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (VmSdkException.class == exceptionTypes[i]) {
                    z = true;
                    break;
                }
                i++;
            }
            return this.mJsWorker.invokeJavaScriptFunction(method.getName(), m13of, JavaScriptRegistry.returnTypeToChar(method.getReturnType()), z);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class JavaScriptModuleProxy implements InvocationHandler {
        private Class<? extends JavaScriptModule> mInterfaceCls;
        private JsWorker mJsWorker;
        private String mModuleName;

        public JavaScriptModuleProxy(JsWorker jsWorker, Class<? extends JavaScriptModule> cls) {
            this.mJsWorker = jsWorker;
            this.mInterfaceCls = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            JavaOnlyArray m13of = JavaOnlyArray.m13of(objArr);
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            int length = exceptionTypes.length;
            for (int i = 0; i < length && VmSdkException.class != exceptionTypes[i]; i++) {
            }
            return this.mJsWorker.invokeJavaScriptModule(getName(), method.getName(), m13of, JavaScriptRegistry.returnTypeToChar(method.getReturnType()));
        }

        private String getName() {
            if (TextUtils.isEmpty(this.mModuleName)) {
                String name = ((JavaScriptObject) this.mInterfaceCls.getAnnotation(JavaScriptObject.class)).name();
                if ("".equals(name)) {
                    name = this.mInterfaceCls.getSimpleName();
                }
                this.mModuleName = name;
            }
            return this.mModuleName;
        }
    }

    public static char returnTypeToChar(Class cls) {
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
        throw new RuntimeException("Got unknown return class: " + cls.getSimpleName());
    }

    private static char commonTypeToChar(Class cls) {
        if (cls == Boolean.TYPE) {
            return 'z';
        }
        if (cls == Boolean.class) {
            return 'Z';
        }
        if (cls == Integer.TYPE) {
            return 'i';
        }
        if (cls == Integer.class) {
            return 'I';
        }
        if (cls == Short.TYPE) {
            return 's';
        }
        if (cls == Short.class) {
            return 'S';
        }
        if (cls == Double.TYPE) {
            return 'd';
        }
        if (cls == Double.class) {
            return 'D';
        }
        if (cls == Float.TYPE) {
            return 'f';
        }
        if (cls == Float.class) {
            return 'F';
        }
        if (cls == String.class) {
            return 'T';
        }
        if (cls == Byte.TYPE) {
            return 'b';
        }
        if (cls == Byte.class) {
            return 'B';
        }
        if (cls == Long.TYPE) {
            return 'l';
        }
        if (cls == Long.class) {
            return 'L';
        }
        return cls == byte[].class ? 'a' : (char) 0;
    }
}
