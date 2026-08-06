package com.bytedance.applog.holder;

import com.bytedance.applog.IEventObserver;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public class EventObserverHolder {
    private final Map<Integer, CopyOnWriteArraySet<IEventObserver>> mEventObserverMap = new ConcurrentHashMap();

    public void onEvent(int i, String str, String str2, String str3, long j, long j2, String str4) {
        CopyOnWriteArraySet<IEventObserver> copyOnWriteArraySet;
        if (noStage(i) || (copyOnWriteArraySet = this.mEventObserverMap.get(Integer.valueOf(i))) == null) {
            return;
        }
        Iterator<IEventObserver> it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            it.next().onEvent(str, str2, str3, j, j2, str4);
        }
    }

    public void onEventV3(int i, String str, String str2) {
        CopyOnWriteArraySet<IEventObserver> copyOnWriteArraySet;
        if (noStage(i) || (copyOnWriteArraySet = this.mEventObserverMap.get(Integer.valueOf(i))) == null) {
            return;
        }
        Iterator<IEventObserver> it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            it.next().onEventV3(str, str2);
        }
    }

    public void onMiscEvent(int i, String str, String str2) {
        CopyOnWriteArraySet<IEventObserver> copyOnWriteArraySet;
        if (noStage(i) || (copyOnWriteArraySet = this.mEventObserverMap.get(Integer.valueOf(i))) == null) {
            return;
        }
        Iterator<IEventObserver> it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            it.next().onMiscEvent(str, str2);
        }
    }

    public void addEventObserver(int i, IEventObserver iEventObserver) {
        CopyOnWriteArraySet<IEventObserver> copyOnWriteArraySet;
        if (noStage(i)) {
            this.mEventObserverMap.put(Integer.valueOf(i), new CopyOnWriteArraySet<>());
        }
        if (iEventObserver == null || (copyOnWriteArraySet = this.mEventObserverMap.get(Integer.valueOf(i))) == null) {
            return;
        }
        copyOnWriteArraySet.add(iEventObserver);
    }

    public void removeEventObserver(IEventObserver iEventObserver) {
        if (iEventObserver != null) {
            Iterator<Map.Entry<Integer, CopyOnWriteArraySet<IEventObserver>>> it = this.mEventObserverMap.entrySet().iterator();
            while (it.hasNext()) {
                CopyOnWriteArraySet<IEventObserver> value = it.next().getValue();
                if (value != null && value.contains(iEventObserver)) {
                    value.remove(iEventObserver);
                }
            }
        }
    }

    public int getObserverSize() {
        return this.mEventObserverMap.values().size();
    }

    public boolean noStage(int i) {
        return !this.mEventObserverMap.containsKey(Integer.valueOf(i));
    }
}
