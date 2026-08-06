package com.bytedance.applog.holder;

import com.bytedance.applog.ISessionObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SessionObserverHolder implements ISessionObserver {
    private final CopyOnWriteArraySet<ISessionObserver> mSessionObserver = new CopyOnWriteArraySet<>();

    @Override // com.bytedance.applog.ISessionObserver
    public void onSessionStart(long j, String str) {
        Iterator<ISessionObserver> it = this.mSessionObserver.iterator();
        while (it.hasNext()) {
            it.next().onSessionStart(j, str);
        }
    }

    @Override // com.bytedance.applog.ISessionObserver
    public void onSessionTerminate(long j, String str, JSONObject jSONObject) {
        Iterator<ISessionObserver> it = this.mSessionObserver.iterator();
        while (it.hasNext()) {
            it.next().onSessionTerminate(j, str, jSONObject);
        }
    }

    @Override // com.bytedance.applog.ISessionObserver
    public void onSessionBatchEvent(long j, String str, JSONObject jSONObject) {
        Iterator<ISessionObserver> it = this.mSessionObserver.iterator();
        while (it.hasNext()) {
            it.next().onSessionBatchEvent(j, str, jSONObject);
        }
    }

    public void addSessionHook(ISessionObserver iSessionObserver) {
        if (iSessionObserver != null) {
            this.mSessionObserver.add(iSessionObserver);
        }
    }

    public void removeSessionHook(ISessionObserver iSessionObserver) {
        if (iSessionObserver != null) {
            this.mSessionObserver.remove(iSessionObserver);
        }
    }

    public int getObserverSize() {
        return this.mSessionObserver.size();
    }

    public void removeAllSessionHook() {
        this.mSessionObserver.clear();
    }
}
