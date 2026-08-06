package org.commonmark.internal.util;

import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.update.UpdateDialogNewBase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
public class Html5Entities {
    private static final String ENTITY_PATH = "/org/commonmark/internal/util/entities.properties";
    private static final Map<String, String> NAMED_CHARACTER_REFERENCES = readEntities();
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^&#[Xx]?");

    public static String entityToString(String str) {
        Matcher matcher = NUMERIC_PATTERN.matcher(str);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(str.substring(matcher.end(), str.length() - 1), matcher.end() == 2 ? 10 : 16);
                return parseInt == 0 ? "�" : new String(Character.toChars(parseInt));
            } catch (IllegalArgumentException unused) {
                return "�";
            }
        }
        String str2 = NAMED_CHARACTER_REFERENCES.get(str.substring(1, str.length() - 1));
        return str2 != null ? str2 : str;
    }

    private static Map<String, String> readEntities() {
        HashMap hashMap = new HashMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Html5Entities.class.getResourceAsStream(ENTITY_PATH), Charset.forName("UTF-8")));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (readLine.length() != 0) {
                            int indexOf = readLine.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                            hashMap.put(readLine.substring(0, indexOf), readLine.substring(indexOf + 1));
                        }
                    } else {
                        bufferedReader.close();
                        hashMap.put("NewLine", UpdateDialogNewBase.TYPE);
                        return hashMap;
                    }
                } finally {
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed reading data for HTML named character references", e);
        }
    }
}
