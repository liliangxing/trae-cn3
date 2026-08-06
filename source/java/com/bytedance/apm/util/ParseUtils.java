package com.bytedance.apm.util;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ParseUtils {
    public static boolean isHostEquals(String str, List<String> list) {
        if (!com.bytedance.apm6.util.ListUtils.isEmpty(list) && !TextUtils.isEmpty(str)) {
            try {
                String host = Uri.parse(str).getHost();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (host.equalsIgnoreCase(it.next())) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean isMatch(String str, List<String> list, List<Pattern> list2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!com.bytedance.apm6.util.ListUtils.isEmpty(list)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return true;
                }
            }
        }
        try {
            String path = new URI(str).getPath();
            if (!com.bytedance.apm6.util.ListUtils.isEmpty(list2)) {
                Iterator<Pattern> it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (it2.next().matcher(path).matches()) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static JSONObject getJsonObject(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return jSONObject.optJSONObject(str);
    }

    public static List<String> parseList(JSONObject jSONObject, String str) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (com.bytedance.apm6.util.JsonUtils.isEmpty(optJSONArray)) {
                return null;
            }
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                String string = optJSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(string);
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<String> parseMapList(JSONObject jSONObject, String str) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (com.bytedance.apm6.util.JsonUtils.isEmpty(optJSONObject)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (optJSONObject.optInt(next) == 1) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<String> parseListFromStr(JSONObject jSONObject, String str) {
        String optString = jSONObject.optString(str, "");
        if (TextUtils.isEmpty(optString)) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.asList(optString.split(","));
    }

    public static List<Pattern> parsePatterns(JSONObject jSONObject, String str) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return null;
            }
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                String string = optJSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(Pattern.compile(string));
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<Pattern> parseMapPatterns(JSONObject jSONObject, String str) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (com.bytedance.apm6.util.JsonUtils.isEmpty(optJSONObject)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (optJSONObject.optInt(next) == 1) {
                    arrayList.add(Pattern.compile(next));
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }
}
