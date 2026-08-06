package com.ss.android.push;

import java.lang.reflect.Field;

/* loaded from: classes7.dex */
public class Smith<T> {
    private Field field;
    private String fieldName;
    private boolean inited;
    private Object obj;

    public Smith(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("obj cannot be null");
        }
        this.obj = obj;
        this.fieldName = str;
    }

    private void prepare() {
        if (this.inited) {
            return;
        }
        this.inited = true;
        Class<?> cls = this.obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(this.fieldName);
                declaredField.setAccessible(true);
                this.field = declaredField;
                return;
            } catch (Exception unused) {
            } finally {
                cls.getSuperclass();
            }
        }
    }

    public T get() throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        prepare();
        Field field = this.field;
        if (field == null) {
            throw new NoSuchFieldException();
        }
        try {
            return (T) field.get(this.obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException("unable to cast object");
        }
    }

    public void set(T t) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        prepare();
        Field field = this.field;
        if (field == null) {
            throw new NoSuchFieldException();
        }
        field.set(this.obj, t);
    }
}
