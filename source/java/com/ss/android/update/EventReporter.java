package com.ss.android.update;

import org.json.JSONObject;

/* loaded from: classes7.dex */
public class EventReporter {
    private static IEventReporter reporter = new IEventReporter() { // from class: com.ss.android.update.EventReporter.1
        @Override // com.ss.android.update.IEventReporter
        public void onEvent(String str, JSONObject jSONObject) {
        }
    };

    public static void setupReporter(IEventReporter iEventReporter) {
        reporter = iEventReporter;
    }

    public static void onEvent(String str, JSONObject jSONObject) {
        reporter.onEvent(str, jSONObject);
    }
}
