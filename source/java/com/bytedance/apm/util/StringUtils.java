package com.bytedance.apm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;

/* loaded from: classes3.dex */
public class StringUtils {
    public static String slurp(InputStream inputStream) throws IOException {
        char[] cArr = new char[8192];
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read >= 0) {
                sb.append(cArr, 0, read);
            } else {
                return sb.toString();
            }
        }
    }

    public static String join(Set<String> set, char c) {
        return set == null ? "" : join(set.toArray(), c, 0, set.size());
    }

    public static String join(Object[] objArr, char c, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i3 * 16);
        for (int i4 = i; i4 < i2; i4++) {
            if (i4 > i) {
                sb.append(c);
            }
            Object obj = objArr[i4];
            if (obj != null) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }
}
