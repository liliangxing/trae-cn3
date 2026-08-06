package com.lynx.animax.property;

import com.lynx.animax.base.bridge.JavaOnlyArray;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public interface AnimaXPropertyCallback {
    void onError(List<String> list);

    void onSuccess();

    default void onPropertyCallback(JavaOnlyArray javaOnlyArray) {
        if (javaOnlyArray == null || javaOnlyArray.isEmpty()) {
            onSuccess();
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<Object> asArrayList = javaOnlyArray.asArrayList();
        for (int i = 0; i < asArrayList.size(); i++) {
            Object obj = asArrayList.get(i);
            if (obj instanceof String) {
                arrayList.add((String) obj);
            }
        }
        onError(arrayList);
    }
}
