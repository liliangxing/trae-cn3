package com.bytedance.frameworks.baselib.network.http.parser;

import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class CacheControlParser {
    private static final String REGEX = "\\s*([\\w\\-]+)\\s*(=)?\\s*(\\d+|\\\"([^\"\\\\]*(\\\\.[^\"\\\\]*)*)+\\\")?\\s*";
    private static final Pattern pattern = Pattern.compile(REGEX);
    private HashMap<Directive, String> values = new HashMap<>();

    /* loaded from: classes2.dex */
    public enum Directive {
        MAXAGE,
        MAXSTALE,
        MINFRESH,
        NOCACHE,
        NOSTORE,
        NOTRANSFORM,
        ONLYIFCACHED,
        MUSTREVALIDATE,
        PRIVATE,
        PROXYREVALIDATE,
        PUBLIC,
        SMAXAGE,
        UNKNOWN;

        public static Directive select(String str) {
            try {
                return valueOf(str.toUpperCase().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
            } catch (Exception unused) {
                return UNKNOWN;
            }
        }
    }

    public CacheControlParser(String str) {
        try {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                Directive select = Directive.select(matcher.group(1));
                if (select != Directive.UNKNOWN) {
                    this.values.put(select, matcher.group(3));
                }
            }
        } catch (IllegalArgumentException unused) {
        }
    }

    public Map<Directive, String> getValues() {
        return this.values;
    }

    public String getValue(Directive directive) {
        return this.values.get(directive);
    }

    public Iterator<Directive> iterator() {
        return this.values.keySet().iterator();
    }
}
