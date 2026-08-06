package com.bytedance.framwork.core.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class ListUtils {
    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static String[] toArray(Set<String> set) {
        String[] strArr = new String[set.size()];
        Iterator<String> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = it.next();
            i++;
        }
        return strArr;
    }

    public static String listToString(Collection collection, String str) {
        if (collection == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Object obj : collection) {
            if (z) {
                z = false;
            } else {
                sb.append(str);
            }
            sb.append(obj.toString());
        }
        return sb.toString();
    }
}
