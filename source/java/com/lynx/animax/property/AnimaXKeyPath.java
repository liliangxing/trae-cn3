package com.lynx.animax.property;

import com.lynx.animax.base.bridge.JavaOnlyArray;
import com.lynx.animax.util.AnimaXLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class AnimaXKeyPath {
    private static final String TAG = "AnimaXKeyPath";
    private final JavaOnlyArray mKeys;

    public AnimaXKeyPath(String... strArr) {
        this.mKeys = new JavaOnlyArray();
        for (String str : strArr) {
            if (str == null || str.isEmpty()) {
                AnimaXLog.i(TAG, "AnimaXKeyPath received a null or empty key, which will be ignored.");
            } else {
                this.mKeys.pushString(str);
            }
        }
    }

    public AnimaXKeyPath(JavaOnlyArray javaOnlyArray) {
        this.mKeys = javaOnlyArray;
    }

    public JavaOnlyArray getKeys() {
        return this.mKeys;
    }

    public List<String> getKeysList() {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = this.mKeys.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof String) {
                arrayList.add((String) next);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "KeyPath{keys=" + getKeysList().toString() + "}";
    }
}
