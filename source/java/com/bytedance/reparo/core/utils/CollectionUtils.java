package com.bytedance.reparo.core.utils;

import com.ss.android.update.UpdateDialogNewBase;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class CollectionUtils {
    public static <E> String toString(Collection<E> collection) {
        if (collection == null || collection.size() == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[\n");
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            E next = it.next();
            if (it.hasNext()) {
                sb.append(next.toString()).append(", \n");
            } else {
                sb.append(next.toString()).append(UpdateDialogNewBase.TYPE);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
