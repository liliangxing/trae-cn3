package com.bytedance.frameworks.baselib.network.http.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class SafeObjectInputStream extends ObjectInputStream {
    private final Set<String> mSafeTypes;

    public SafeObjectInputStream(InputStream inputStream, Collection<String> collection) throws IOException {
        super(inputStream);
        HashSet hashSet = new HashSet();
        this.mSafeTypes = hashSet;
        if (collection != null) {
            hashSet.addAll(collection);
        }
    }

    public SafeObjectInputStream(InputStream inputStream, String... strArr) throws IOException {
        super(inputStream);
        HashSet hashSet = new HashSet();
        this.mSafeTypes = hashSet;
        if (strArr != null) {
            hashSet.addAll(Arrays.asList(strArr));
        }
    }

    public SafeObjectInputStream(InputStream inputStream, Class<?>... clsArr) throws IOException {
        super(inputStream);
        this.mSafeTypes = new HashSet();
        if (clsArr != null) {
            for (Class<?> cls : clsArr) {
                this.mSafeTypes.add(cls.getName());
            }
        }
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
        if (objectStreamClass == null || objectStreamClass.getName() == null) {
            return super.resolveClass(objectStreamClass);
        }
        String name = objectStreamClass.getName();
        if (this.mSafeTypes.contains(name)) {
            return super.resolveClass(objectStreamClass);
        }
        return Class.forName(name, true, ClassLoader.getSystemClassLoader().getParent());
    }
}
