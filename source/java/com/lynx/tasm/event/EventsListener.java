package com.lynx.tasm.event;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class EventsListener {
    private static final String FUNCTION = "function";
    private static final String LEPUS_FUNCTION = "lepusFunction";
    private static final String LEPUS_TYPE = "lepusType";
    private static final String NAME = "name";
    private static final String TYPE = "type";
    public String functionName;
    public String lepusFunctionName;
    public String lepusType;
    public String name;
    public String type;

    public EventsListener(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.type = str2;
        this.functionName = str3;
        this.lepusType = str4;
        this.lepusFunctionName = str5;
    }

    public static Map<String, EventsListener> convertEventListeners(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            String string = map.getString("name");
            EventsListener eventsListener = (EventsListener) hashMap.get(string);
            if (eventsListener == null) {
                eventsListener = new EventsListener(string, map.getString("type"), map.getString(FUNCTION), map.getString(LEPUS_TYPE), map.getString(LEPUS_FUNCTION));
            } else {
                if (eventsListener.type == null && eventsListener.functionName == null) {
                    eventsListener.type = map.getString("type");
                    eventsListener.functionName = map.getString(FUNCTION);
                }
                if (eventsListener.lepusType == null && eventsListener.lepusFunctionName == null) {
                    eventsListener.lepusType = map.getString(LEPUS_TYPE);
                    eventsListener.lepusFunctionName = map.getString(LEPUS_FUNCTION);
                }
            }
            hashMap.put(eventsListener.name, eventsListener);
        }
        return hashMap;
    }
}
