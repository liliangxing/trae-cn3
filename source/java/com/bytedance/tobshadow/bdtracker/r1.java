package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.IEventJsonObserver;
import com.bytedance.tobshadow.applog.IEventObserver;
import com.bytedance.tobshadow.applog.IPresetEventObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class r1 implements IEventObserver, IEventJsonObserver, IPresetEventObserver {
    public final CopyOnWriteArraySet<IEventObserver> a = new CopyOnWriteArraySet<>();
    public final CopyOnWriteArraySet<IEventJsonObserver> b = new CopyOnWriteArraySet<>();
    public final CopyOnWriteArraySet<IPresetEventObserver> c = new CopyOnWriteArraySet<>();

    public void a(IEventJsonObserver iEventJsonObserver) {
        if (iEventJsonObserver != null) {
            this.b.add(iEventJsonObserver);
        }
    }

    public void a(IEventObserver iEventObserver) {
        if (iEventObserver != null) {
            this.a.add(iEventObserver);
        }
    }

    public void a(IPresetEventObserver iPresetEventObserver) {
        if (iPresetEventObserver != null) {
            this.c.add(iPresetEventObserver);
        }
    }

    public boolean a() {
        return !this.b.isEmpty();
    }

    public void b(IEventJsonObserver iEventJsonObserver) {
        if (iEventJsonObserver != null) {
            this.b.remove(iEventJsonObserver);
        }
    }

    public void b(IEventObserver iEventObserver) {
        if (iEventObserver != null) {
            this.a.remove(iEventObserver);
        }
    }

    public void b(IPresetEventObserver iPresetEventObserver) {
        if (iPresetEventObserver != null) {
            this.c.remove(iPresetEventObserver);
        }
    }

    public boolean b() {
        return !this.c.isEmpty();
    }

    @Override // com.bytedance.tobshadow.applog.IEventJsonObserver
    public void eventJson(String str, JSONObject jSONObject) {
        Iterator<IEventJsonObserver> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().eventJson(str, jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IEventJsonObserver
    public void launchJson(JSONObject jSONObject) {
        Iterator<IEventJsonObserver> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().launchJson(jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IEventObserver
    public void onEvent(String str, String str2, String str3, long j, long j2, String str4) {
        Iterator<IEventObserver> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onEvent(str, str2, str3, j, j2, str4);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IEventObserver
    public void onEventV3(String str, JSONObject jSONObject) {
        Iterator<IEventObserver> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onEventV3(str, jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IPresetEventObserver
    public void onLaunch(JSONObject jSONObject) {
        Iterator<IPresetEventObserver> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().onLaunch(jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IPresetEventObserver
    public void onPageEnter(JSONObject jSONObject) {
        Iterator<IPresetEventObserver> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().onPageEnter(jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IPresetEventObserver
    public void onPageLeave(JSONObject jSONObject) {
        Iterator<IPresetEventObserver> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().onPageLeave(jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IEventJsonObserver
    public void pageJson(JSONObject jSONObject, boolean z) {
        Iterator<IEventJsonObserver> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().pageJson(jSONObject, z);
        }
    }
}
