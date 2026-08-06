package com.lynx.animax.base.bridge;

import java.util.ArrayList;

/* loaded from: classes6.dex */
public class JavaOnlyArray extends ArrayList<Object> {
    public ArrayList<Object> asArrayList() {
        return this;
    }

    public void pushArray(JavaOnlyArray javaOnlyArray) {
        add(javaOnlyArray);
    }

    public void pushString(String str) {
        add(str);
    }

    public void pushByteArrayAsString(byte[] bArr) {
        add(new String(bArr));
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return super.size();
    }

    public String getString(int i) {
        return (String) get(i);
    }

    public ReadableType getType(int i) {
        Object obj = get(i);
        if (obj == null) {
            return ReadableType.Null;
        }
        if (obj instanceof Boolean) {
            return ReadableType.Boolean;
        }
        if (obj instanceof Integer) {
            return ReadableType.Int;
        }
        if (obj instanceof Long) {
            return ReadableType.Long;
        }
        if ((obj instanceof Number) || (obj instanceof Character)) {
            return ReadableType.Number;
        }
        if (obj instanceof String) {
            return ReadableType.String;
        }
        if (obj instanceof ReadableMap) {
            return ReadableType.Map;
        }
        if (obj instanceof byte[]) {
            return ReadableType.ByteArray;
        }
        throw new IllegalArgumentException("unsupported type " + obj.getClass() + " contained in JavaOnlyArray");
    }

    public int getTypeIndex(int i) {
        return getType(i).ordinal();
    }

    private static JavaOnlyArray create() {
        return new JavaOnlyArray();
    }
}
