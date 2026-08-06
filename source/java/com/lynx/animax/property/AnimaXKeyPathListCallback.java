package com.lynx.animax.property;

import com.lynx.animax.base.bridge.JavaOnlyArray;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public interface AnimaXKeyPathListCallback {
    void onCallback(List<AnimaXKeyPath> list);

    default void onKeyPathListCallback(JavaOnlyArray javaOnlyArray) {
        if (javaOnlyArray != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList<Object> asArrayList = javaOnlyArray.asArrayList();
            for (int i = 0; i < asArrayList.size(); i++) {
                if (asArrayList.get(i) instanceof JavaOnlyArray) {
                    arrayList.add(new AnimaXKeyPath((JavaOnlyArray) asArrayList.get(i)));
                }
            }
            onCallback(arrayList);
            return;
        }
        onCallback(new ArrayList());
    }
}
