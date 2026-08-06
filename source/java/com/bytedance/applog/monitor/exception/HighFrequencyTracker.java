package com.bytedance.applog.monitor.exception;

import com.bytedance.applog.monitor.v3.StageEventType;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: classes3.dex */
public class HighFrequencyTracker {
    private final HighFrequencyCallback callback;
    private final long periodMillis;
    private final long threshold;
    private final LinkedList<Event> events = new LinkedList<>();
    private final Map<String, Integer> eventCount = new HashMap();

    /* loaded from: classes3.dex */
    public interface HighFrequencyCallback {
        void onHighFrequencyDetected(Map<String, Integer> map);
    }

    public HighFrequencyTracker(long j, long j2, HighFrequencyCallback highFrequencyCallback) {
        this.periodMillis = j;
        this.threshold = j2;
        this.callback = highFrequencyCallback;
    }

    public synchronized void addEvent(StageEventType stageEventType, String str, long j) {
        this.events.add(new Event(stageEventType, str, j));
        String str2 = stageEventType + Constants.COLON_SEPARATOR + str;
        Integer num = this.eventCount.get(str2);
        if (num == null) {
            this.eventCount.put(str2, 1);
        } else {
            this.eventCount.put(str2, Integer.valueOf(num.intValue() + 1));
        }
        removeExpiredEvents(j);
        if (this.events.size() > this.threshold) {
            triggerCallback();
        }
    }

    private void removeExpiredEvents(long j) {
        while (!this.events.isEmpty() && this.events.getFirst().timestamp < j - this.periodMillis) {
            Event removeFirst = this.events.removeFirst();
            String str = removeFirst.type + Constants.COLON_SEPARATOR + removeFirst.name;
            Integer num = this.eventCount.get(str);
            if (num != null) {
                if (num.intValue() > 1) {
                    this.eventCount.put(str, Integer.valueOf(num.intValue() - 1));
                } else {
                    this.eventCount.remove(str);
                }
            }
        }
    }

    public int getEventSize() {
        return this.events.size();
    }

    private void triggerCallback() {
        HashMap hashMap = new HashMap(this.eventCount);
        this.eventCount.clear();
        this.events.clear();
        HighFrequencyCallback highFrequencyCallback = this.callback;
        if (highFrequencyCallback != null) {
            highFrequencyCallback.onHighFrequencyDetected(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Event {
        String name;
        long timestamp;
        StageEventType type;

        public Event(StageEventType stageEventType, String str, long j) {
            this.type = stageEventType;
            this.name = str;
            this.timestamp = j;
        }
    }
}
