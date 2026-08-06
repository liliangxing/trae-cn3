package com.bytedance.pia.core.storage;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IPageStorage {
    <T> T get(String str, Class<? extends T> cls);

    <T> void put(String str, T t);

    void remove(String str);

    static IPageStorage create(String str) {
        return new PageStorage(str);
    }
}
