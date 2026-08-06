package io.noties.markwon.html.jsoup.nodes;

import com.huawei.hms.framework.common.ContainerUtils;
import io.noties.markwon.html.MarkwonSettings;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.commonmark.internal.util.Html5Entities;

/* loaded from: classes6.dex */
public abstract class CommonMarkEntities {
    private static Map<String, String> COMMONMARK_NAMED_ENTITIES;
    private static Map<String, String> DEFAULT_NAMED_ENTITIES;

    public static boolean isNamedEntity(String str) {
        return getCommonMarkEntity(str) != null;
    }

    public static int codepointsForName(String str, int[] iArr) {
        String commonMarkEntity = getCommonMarkEntity(str);
        if (commonMarkEntity == null) {
            return 0;
        }
        int length = commonMarkEntity.length();
        if (length == 1) {
            iArr[0] = commonMarkEntity.charAt(0);
        } else {
            iArr[0] = commonMarkEntity.charAt(0);
            iArr[1] = commonMarkEntity.charAt(1);
        }
        return length;
    }

    private static String getCommonMarkEntity(String str) {
        Map<String, String> map = DEFAULT_NAMED_ENTITIES;
        String str2 = map != null ? map.get(str) : null;
        if (str2 != null) {
            return str2;
        }
        if (COMMONMARK_NAMED_ENTITIES == null) {
            initCommonMarkNamedEntities();
        }
        return COMMONMARK_NAMED_ENTITIES.get(str);
    }

    private static void initCommonMarkNamedEntities() {
        Map<String, String> map;
        try {
            Field declaredField = Html5Entities.class.getDeclaredField("NAMED_CHARACTER_REFERENCES");
            declaredField.setAccessible(true);
            map = (Map) declaredField.get(null);
        } catch (Throwable th) {
            Map<String, String> emptyMap = Collections.emptyMap();
            th.printStackTrace();
            map = emptyMap;
        }
        COMMONMARK_NAMED_ENTITIES = map;
    }

    private static void initDefaultNamedEntities() {
        DEFAULT_NAMED_ENTITIES = new HashMap<String, String>() { // from class: io.noties.markwon.html.jsoup.nodes.CommonMarkEntities.1
            {
                put("quot", "\"");
                put("apos", "'");
                put("amp", ContainerUtils.FIELD_DELIMITER);
                put("lt", "<");
                put("gt", ">");
            }
        };
    }

    static {
        if (MarkwonSettings.INSTANCE.getEnableHtmlNameEntityOptimize()) {
            initDefaultNamedEntities();
        } else {
            initCommonMarkNamedEntities();
        }
    }

    private CommonMarkEntities() {
    }
}
