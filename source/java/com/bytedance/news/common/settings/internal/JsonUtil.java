package com.bytedance.news.common.settings.internal;

import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.news.common.settings.api.Migration;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JsonUtil {
    public static boolean optBoolean(JSONObject jSONObject, String str) {
        return optBoolean(jSONObject, str, false);
    }

    public static boolean optBoolean(JSONObject jSONObject, String str, boolean z) {
        Boolean bool = toBoolean(jSONObject.opt(str));
        return bool != null ? bool.booleanValue() : z;
    }

    public static boolean optBoolean(Migration migration, String str) {
        return optBoolean(migration, str, false);
    }

    public static boolean optBoolean(Migration migration, String str, boolean z) {
        Object string;
        try {
            try {
                string = Boolean.valueOf(migration.getBoolean(str));
            } catch (Exception unused) {
                string = Integer.valueOf(migration.getInt(str));
            }
        } catch (Exception unused2) {
            string = migration.getString(str);
        }
        Boolean bool = toBoolean(string);
        return bool != null ? bool.booleanValue() : z;
    }

    private static Boolean toBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            if (num.intValue() == 1) {
                return true;
            }
            return num.intValue() == 0 ? false : null;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (RouterConstants.TRUE.equalsIgnoreCase(str) || "1".equals(str)) {
            return true;
        }
        return ("false".equalsIgnoreCase(str) || "0".equals(str)) ? false : null;
    }
}
