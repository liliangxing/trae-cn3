package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.ISessionObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.s1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0511s1 implements ISessionObserver {

    /* renamed from: a */
    public final CopyOnWriteArraySet<ISessionObserver> f1014a = new CopyOnWriteArraySet<>();

    /* renamed from: a */
    public void m654a(ISessionObserver iSessionObserver) {
        if (iSessionObserver != null) {
            this.f1014a.add(iSessionObserver);
        }
    }

    /* renamed from: b */
    public void m655b(ISessionObserver iSessionObserver) {
        if (iSessionObserver != null) {
            this.f1014a.remove(iSessionObserver);
        }
    }

    @Override // com.bytedance.tobshadow.applog.ISessionObserver
    public void onSessionBatchEvent(long j, String str, JSONObject jSONObject) {
        Iterator<ISessionObserver> it = this.f1014a.iterator();
        while (it.hasNext()) {
            it.next().onSessionBatchEvent(j, str, jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.ISessionObserver
    public void onSessionStart(long j, String str) {
        Iterator<ISessionObserver> it = this.f1014a.iterator();
        while (it.hasNext()) {
            it.next().onSessionStart(j, str);
        }
    }

    @Override // com.bytedance.tobshadow.applog.ISessionObserver
    public void onSessionTerminate(long j, String str, JSONObject jSONObject) {
        Iterator<ISessionObserver> it = this.f1014a.iterator();
        while (it.hasNext()) {
            it.next().onSessionTerminate(j, str, jSONObject);
        }
    }
}
