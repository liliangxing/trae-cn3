package com.bytedance.applog.forward;

import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class EventForward {
    private String host;
    private String mForwardReportUri;
    private String path;
    private int mVersion = 0;
    private long mInterval = 60000;
    private final Set<String> events = new HashSet();
    private int open = 0;

    public static EventForward parseFromServerJson(JSONObject jSONObject) {
        EventForward eventForward = new EventForward();
        eventForward.setVersion(jSONObject.optInt("version", 0));
        int optInt = jSONObject.optInt("interval", -1);
        eventForward.setInterval(optInt >= 0 ? optInt * 1000 : 60000L);
        eventForward.setPath(jSONObject.optString(EventForwardLoader.KEY_EVENT_FORWARD_PATH));
        eventForward.setHost(jSONObject.optString(EventForwardLoader.KEY_EVENT_FORWARD_HOST));
        eventForward.setOpen(jSONObject.optInt(EventForwardLoader.KEY_EVENT_FORWARD_OPEN, 0));
        JSONArray optJSONArray = jSONObject.optJSONArray(EventForwardLoader.KEY_EVENT_FORWARD_EVENTS);
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                eventForward.addEvent(optJSONArray.optString(i));
            }
        }
        return eventForward;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    public long getInterval() {
        return this.mInterval;
    }

    public void setInterval(long j) {
        this.mInterval = j;
    }

    public Set<String> getEvents() {
        return this.events;
    }

    public void addEvents(Set<String> set) {
        this.events.addAll(set);
    }

    public void addEvent(String str) {
        this.events.add(str);
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public int getOpen() {
        return this.open;
    }

    public void setOpen(int i) {
        this.open = i;
    }

    public boolean isEnabled() {
        return (this.open != 1 || TextUtils.isEmpty(this.host) || TextUtils.isEmpty(this.path) || this.events.isEmpty() || this.mInterval <= 0 || TextUtils.isEmpty(getUri())) ? false : true;
    }

    public JSONObject getConfigJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", getVersion());
            jSONObject.put("interval", getInterval());
            jSONObject.put(EventForwardLoader.KEY_EVENT_FORWARD_PATH, getPath());
            jSONObject.put(EventForwardLoader.KEY_EVENT_FORWARD_HOST, getHost());
            jSONObject.put(EventForwardLoader.KEY_EVENT_FORWARD_OPEN, getOpen());
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = getEvents().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put(EventForwardLoader.KEY_EVENT_FORWARD_EVENTS, jSONArray);
        } catch (Throwable th) {
            LoggerImpl.global().error("put json object for event forward failed", th, new Object[0]);
        }
        return jSONObject;
    }

    public boolean hasEvent(String str) {
        return this.events.contains(str);
    }

    public String getUri() {
        if (getOpen() == 0 || TextUtils.isEmpty(getHost())) {
            return null;
        }
        if (TextUtils.isEmpty(this.mForwardReportUri)) {
            String host = (!getHost().startsWith("https://") || getHost().endsWith("/")) ? null : getHost();
            if (TextUtils.isEmpty(host)) {
                this.mForwardReportUri = null;
                return null;
            }
            this.mForwardReportUri = host + ((!TextUtils.isEmpty(getPath()) && getPath().startsWith("/") && getPath().endsWith("/")) ? getPath() : "/service/2/app_log/");
        }
        return this.mForwardReportUri;
    }

    public boolean equals(Object obj) {
        if (obj instanceof EventForward) {
            EventForward eventForward = (EventForward) obj;
            return eventForward.getVersion() == getVersion() && eventForward.getInterval() == getInterval() && TextUtils.equals(eventForward.getHost(), getHost()) && TextUtils.equals(eventForward.getPath(), getPath()) && eventForward.getOpen() == getOpen() && eventForward.getEvents().containsAll(getEvents()) && getEvents().containsAll(eventForward.getEvents());
        }
        return super.equals(obj);
    }
}
