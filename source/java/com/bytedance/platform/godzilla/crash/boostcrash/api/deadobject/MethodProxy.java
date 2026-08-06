package com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject;

import com.bytedance.platform.godzilla.common.Logger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class MethodProxy extends MethodDelegate implements InvocationHandler {
    private static final Map<String, MethodDelegate> METHOD_DELEGATE_MAP = new HashMap();
    protected static final Map<Class<?>, Class<?>> WRAPPER_PRIMITIVE_MAP;
    private boolean mCalled;
    protected HashMap<String, MethodDelegate> mDelegateMethods = new HashMap<>();
    protected boolean mEnable = true;
    protected Object mProxy;
    protected Object mTarget;

    protected boolean isCatchInvokeThrowable(Method method) {
        return true;
    }

    public abstract void onInstall();

    static {
        HashMap hashMap = new HashMap();
        WRAPPER_PRIMITIVE_MAP = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        hashMap.put(Byte.class, Byte.TYPE);
        hashMap.put(Character.class, Character.TYPE);
        hashMap.put(Short.class, Short.TYPE);
        hashMap.put(Integer.class, Integer.TYPE);
        hashMap.put(Long.class, Long.TYPE);
        hashMap.put(Double.class, Double.TYPE);
        hashMap.put(Float.class, Float.TYPE);
    }

    public void setTarget(Object obj) {
        this.mCalled = true;
        this.mTarget = obj;
    }

    protected void setProxy(Object obj) {
        this.mProxy = obj;
    }

    public Object getTarget() {
        return this.mTarget;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void addMethodDelegate(String str, MethodDelegate methodDelegate) {
        METHOD_DELEGATE_MAP.put(str, methodDelegate);
    }

    protected MethodDelegate findMethodDelegate(String str) {
        MethodDelegate methodDelegate = METHOD_DELEGATE_MAP.get(str);
        return methodDelegate == null ? this.mDelegateMethods.get(str) : methodDelegate;
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
    public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
        MethodDelegate findMethodDelegate = findMethodDelegate(method.getName());
        return findMethodDelegate != null ? findMethodDelegate.beforeInvoke(obj, method, objArr) : super.beforeInvoke(obj, method, objArr);
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
    public Object afterInvoke(Object obj, Method method, Object[] objArr, Object obj2) {
        MethodDelegate findMethodDelegate = findMethodDelegate(method.getName());
        return findMethodDelegate != null ? findMethodDelegate.afterInvoke(obj, method, objArr, obj2) : super.afterInvoke(obj, method, objArr, obj2);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        Object obj2;
        if (!this.mCalled) {
            throw new IllegalStateException("setTarget must be invoked before this invoke");
        }
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        if (!this.mEnable) {
            return method.invoke(this.mTarget, objArr);
        }
        try {
            obj2 = beforeInvoke(this.mTarget, method, objArr);
        } catch (Throwable th) {
            Logger.e("beforeInvoke", th.toString());
            obj2 = null;
        }
        if (obj2 == null) {
            try {
                obj2 = method.invoke(this.mTarget, objArr);
            } catch (Throwable th2) {
                if (!isCatchInvokeThrowable(method)) {
                    throw new RuntimeException(th2);
                }
                Logger.e("MethodProxyError.", th2.toString());
            }
        }
        try {
            obj2 = afterInvoke(this.mTarget, method, objArr, obj2);
        } catch (Throwable th3) {
            Logger.e("afterInvokeError.", th3.toString());
        }
        return invokeResult(method, obj2);
    }

    private Object invokeResult(Method method, Object obj) {
        if (obj != null) {
            return obj;
        }
        Class<?> returnType = method.getReturnType();
        if (returnType == null) {
            return null;
        }
        if (!returnType.isPrimitive() && (returnType = WRAPPER_PRIMITIVE_MAP.get(returnType)) == null) {
            return null;
        }
        if (returnType == Boolean.TYPE) {
            return false;
        }
        if (returnType == Void.TYPE) {
            return new Object();
        }
        return 0;
    }
}
