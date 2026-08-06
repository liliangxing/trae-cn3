package com.bytedance.apm.util;

/* loaded from: classes3.dex */
public class ObjectsCompat {
    private static final ImplBase IMPL = new ImplBase();

    private ObjectsCompat() {
    }

    public static boolean equals(Object obj, Object obj2) {
        return IMPL.equals(obj, obj2);
    }

    /* loaded from: classes3.dex */
    private static class ImplBase {
        private ImplBase() {
        }

        public boolean equals(Object obj, Object obj2) {
            return obj == obj2 || (obj != null && obj.equals(obj2));
        }
    }
}
