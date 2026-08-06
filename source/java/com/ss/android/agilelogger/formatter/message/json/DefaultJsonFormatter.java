package com.ss.android.agilelogger.formatter.message.json;

import com.ss.android.agilelogger.formatter.FormatException;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class DefaultJsonFormatter implements JsonFormatter {
    private static final int JSON_INDENT = 4;

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public String format(String str) {
        if (str == null || str.trim().length() == 0) {
            throw new FormatException("JSON empty.");
        }
        try {
            if (str.startsWith("{")) {
                return new JSONObject(str).toString(4);
            }
            if (str.startsWith("[")) {
                return new JSONArray(str).toString(4);
            }
            throw new FormatException("JSON should start with { or [, but found " + str);
        } catch (Exception e) {
            throw new FormatException("Parse JSON error. JSON string:" + str, e);
        }
    }
}
