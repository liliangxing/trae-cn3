package com.bytedance.mt.protector.impl.collections;

import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.impl.ProtectorMethod;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ListProtector extends BaseCollectionProtector {
    @ProtectorMethod(exceptions = {IndexOutOfBoundsException.class})
    public static <T> T get(List<T> list, int i) {
        Integer num;
        try {
            return list.get(i);
        } catch (Throwable th) {
            if (Protector.enable() && list.size() > 0 && (num = (Integer) tryProtect(th, Integer.class)) != null) {
                return list.get(num.intValue());
            }
            throw th;
        }
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T set(List<T> list, int i, T t) {
        Integer num;
        try {
            return list.set(i, t);
        } catch (Throwable th) {
            if (Protector.enable() && list.size() > 0 && (num = (Integer) tryProtect(th, Integer.class)) != null) {
                return list.set(num.intValue(), t);
            }
            throw th;
        }
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> void add(List<T> list, int i, T t) {
        Integer num;
        try {
            list.add(i, t);
        } catch (Throwable th) {
            if (Protector.enable() && (num = (Integer) tryProtect(th, Integer.class)) != null) {
                list.add(num.intValue(), t);
                return;
            }
            throw th;
        }
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static <T> T remove(List<T> list, int i) {
        Integer num;
        try {
            return list.remove(i);
        } catch (Throwable th) {
            if (Protector.enable() && list.size() > 0 && (num = (Integer) tryProtect(th, Integer.class)) != null) {
                return list.remove(num.intValue());
            }
            throw th;
        }
    }
}
