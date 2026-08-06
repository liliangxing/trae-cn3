package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.log.IAppLogLogger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.a6 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0387a6 {

    /* renamed from: a */
    public static final List<String> f448a = Collections.singletonList("Validator");

    /* renamed from: b */
    public static final Pattern f449b = Pattern.compile("^[a-z0-9A-Z_ .-]{1,255}$");

    /* renamed from: c */
    public static final List<String> f450c = Arrays.asList("$inactive", "$inline", "$target_uuid_list", "$source_uuid", "$is_spider", "$source_id", "$is_first_time");

    /* renamed from: a */
    public static void m273a(IAppLogLogger iAppLogLogger, String str, JSONObject jSONObject) {
        if (C0411e.m376c(str)) {
            iAppLogLogger.warn(f448a, "Event name must not be empty!", new Object[0]);
        } else {
            if (!f449b.matcher(str).matches()) {
                iAppLogLogger.warn(f448a, "Event [" + str + "] name is invalid!", new Object[0]);
            }
            if (str.startsWith("__")) {
                iAppLogLogger.warn(f448a, "Event [" + str + "] name should not start with __!", new Object[0]);
            }
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        String m347a = C0411e.m347a((Object) str);
        while (keys.hasNext()) {
            String next = keys.next();
            if (C0411e.m376c(next)) {
                iAppLogLogger.warn(f448a, "Event [" + m347a + "] param key must not be empty!", new Object[0]);
            }
            if (!f450c.contains(next)) {
                if (!f449b.matcher(next).matches()) {
                    iAppLogLogger.warn(f448a, "Event [" + m347a + "] param key [" + next + "] is invalid!", new Object[0]);
                }
                if (next.startsWith("__")) {
                    iAppLogLogger.warn(f448a, "Event [" + m347a + "] param key [" + next + "] should not start with __!", new Object[0]);
                }
            }
            Object opt = jSONObject.opt(next);
            if ((opt instanceof String) && ((String) opt).length() > 1024) {
                iAppLogLogger.warn(f448a, "Event [" + m347a + "] param key [" + next + "] value is limited to a maximum of 1024 characters!", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static void m274a(IAppLogLogger iAppLogLogger, Map<String, Object> map) {
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            if (C0411e.m376c(str)) {
                iAppLogLogger.warn(f448a, "Header name must not be empty!", new Object[0]);
            }
            if (!f450c.contains(str)) {
                if (!f449b.matcher(str).matches()) {
                    iAppLogLogger.warn(f448a, "Header [" + str + "] name is invalid!", new Object[0]);
                }
                if (str.startsWith("__")) {
                    iAppLogLogger.warn(f448a, "Header [" + str + "] name should not start with __!", new Object[0]);
                }
            }
            Object obj = map.get(str);
            if ((obj instanceof String) && ((String) obj).length() > 1024) {
                iAppLogLogger.warn(f448a, "Header [" + str + "] value is limited to a maximum of 1024 characters!", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static void m275a(IAppLogLogger iAppLogLogger, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (C0411e.m376c(next)) {
                iAppLogLogger.warn(f448a, "Profile key must not be empty!", new Object[0]);
            }
            if (!f449b.matcher(next).matches()) {
                iAppLogLogger.warn(f448a, "Profile param [" + next + "] name is invalid!", new Object[0]);
            }
            Object opt = jSONObject.opt(next);
            if ((opt instanceof String) && ((String) opt).length() > 1024) {
                iAppLogLogger.warn(f448a, "Profile param [" + next + "] value is limited to a maximum of 1024 characters!", new Object[0]);
            }
        }
    }
}
