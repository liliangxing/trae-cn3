package com.lynx.canvas;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class KryptonUniformLayoutSTD140Fix {
    static String polyfill(String str) {
        if (Pattern.compile("^\\\\s*#version\\\\s+300\\\\s+es").matcher(str).matches()) {
            return str;
        }
        Matcher matcher = Pattern.compile("(es|;)\\s*uniform\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s+\\{").matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            String str2 = ";\n layout(std140) uniform " + matcher.group(2) + " {";
            if (Objects.equals(matcher.group(1), "es")) {
                str2 = "es\n layout(std140) uniform " + matcher.group(2) + " {";
            }
            arrayList.add(new Pair(matcher.group(), str2));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            str = str.replace((CharSequence) pair.first, (CharSequence) pair.second);
        }
        return str;
    }
}
