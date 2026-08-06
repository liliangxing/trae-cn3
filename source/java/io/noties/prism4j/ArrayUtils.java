package io.noties.prism4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
abstract class ArrayUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeVarargs
    public static <T> List<T> toList(T... tArr) {
        int length = tArr != null ? tArr.length : 0;
        ArrayList arrayList = new ArrayList(length);
        if (length > 0) {
            Collections.addAll(arrayList, tArr);
        }
        return arrayList;
    }

    private ArrayUtils() {
    }
}
