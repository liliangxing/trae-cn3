package com.bytedance.reparo.core.utils.reflect;

import com.bytedance.reparo.core.log.TLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class ClassMethodFinder<T> {
    private ClassMethodFinder<T>.ClassMethodGetter mMethodGetter = null;
    private boolean mInited = false;

    abstract List<? extends ClassMethodFinder<T>.ClassMethodGetter> allMethodsImpl();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public abstract class ClassMethodGetter {
        Method mMethod;

        abstract Method getDeclaredMethod() throws NoSuchMethodException;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ClassMethodGetter() {
        }

        ClassMethodFinder<T>.ClassMethodGetter getMethod() throws NoSuchMethodException {
            Method declaredMethod = getDeclaredMethod();
            this.mMethod = declaredMethod;
            declaredMethod.setAccessible(true);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public T invoke(Object obj, Object... objArr) throws InvocationTargetException, IllegalAccessException, ClassCastException {
            return (T) this.mMethod.invoke(obj, objArr);
        }
    }

    ClassMethodFinder<T>.ClassMethodGetter getOneMethod() {
        if (this.mInited) {
            return this.mMethodGetter;
        }
        this.mInited = true;
        ClassMethodFinder<T>.ClassMethodGetter realGetOneMethod = realGetOneMethod();
        this.mMethodGetter = realGetOneMethod;
        return realGetOneMethod;
    }

    public T invoke(Object obj, Object... objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ClassMethodFinder<T>.ClassMethodGetter oneMethod = getOneMethod();
        if (oneMethod == null) {
            throw new NoSuchMethodException("NotFound method with " + getClass());
        }
        return oneMethod.invoke(obj, objArr);
    }

    private ClassMethodFinder<T>.ClassMethodGetter realGetOneMethod() {
        List<? extends ClassMethodFinder<T>.ClassMethodGetter> allMethodsImpl = allMethodsImpl();
        if (allMethodsImpl != null && !allMethodsImpl.isEmpty()) {
            Iterator<? extends ClassMethodFinder<T>.ClassMethodGetter> it = allMethodsImpl.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().getMethod();
                } catch (NoSuchMethodException unused) {
                } catch (Throwable th) {
                    TLog.e("Error when getMethod in " + getClass(), th);
                }
            }
        }
        return null;
    }
}
