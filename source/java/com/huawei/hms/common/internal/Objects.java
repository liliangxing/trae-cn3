package com.huawei.hms.common.internal;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public final class Objects {

    /* loaded from: classes6.dex */
    public static final class ToStringHelper {
        private final List<String> a;
        private final Object b;

        public final ToStringHelper add(String str, Object obj) {
            String str2 = (String) Preconditions.checkNotNull(str);
            String valueOf = String.valueOf(obj);
            this.a.add(new StringBuilder(str2.length() + valueOf.length() + 1).append(str2).append(ContainerUtils.KEY_VALUE_DELIMITER).append(valueOf).toString());
            return this;
        }

        public final String toString() {
            StringBuilder append = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append(AbstractJsonLexerKt.BEGIN_OBJ);
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                append.append(this.a.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append(AbstractJsonLexerKt.END_OBJ).toString();
        }

        private ToStringHelper(Object obj) {
            this.b = Preconditions.checkNotNull(obj);
            this.a = new ArrayList();
        }
    }

    private Objects() {
        throw new AssertionError("Uninstantiable");
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        return obj != null && obj.equals(obj2);
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static boolean isNull(Object... objArr) {
        if (objArr == null) {
            return true;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj);
    }
}
