package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.ISessionObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class s1 implements ISessionObserver {
    public final CopyOnWriteArraySet<ISessionObserver> a = new CopyOnWriteArraySet<>();

    public void a(ISessionObserver iSessionObserver) {
        if (iSessionObserver != null) {
            this.a.add(iSessionObserver);
        }
    }

    public void b(ISessionObserver iSessionObserver) {
        if (iSessionObserver != null) {
            this.a.remove(iSessionObserver);
        }
    }

    @Override // com.bytedance.tobshadow.applog.ISessionObserver
    public void onSessionBatchEvent(long j, String str, JSONObject jSONObject) {
        Iterator<ISessionObserver> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onSessionBatchEvent(j, str, jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.ISessionObserver
    public void onSessionStart(long j, String str) {
        Iterator<ISessionObserver> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onSessionStart(j, str);
        }
    }

    @Override // com.bytedance.tobshadow.applog.ISessionObserver
    public void onSessionTerminate(long j, String str, JSONObject jSONObject) {
        Iterator<ISessionObserver> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onSessionTerminate(j, str, jSONObject);
        }
    }
}
