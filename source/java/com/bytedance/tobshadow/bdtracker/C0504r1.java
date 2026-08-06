package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.IEventJsonObserver;
import com.bytedance.tobshadow.applog.IEventObserver;
import com.bytedance.tobshadow.applog.IPresetEventObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.r1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0504r1 implements IEventObserver, IEventJsonObserver, IPresetEventObserver {

    /* renamed from: a */
    public final CopyOnWriteArraySet<IEventObserver> f973a = new CopyOnWriteArraySet<>();

    /* renamed from: b */
    public final CopyOnWriteArraySet<IEventJsonObserver> f974b = new CopyOnWriteArraySet<>();

    /* renamed from: c */
    public final CopyOnWriteArraySet<IPresetEventObserver> f975c = new CopyOnWriteArraySet<>();

    /* renamed from: a */
    public void m629a(IEventJsonObserver iEventJsonObserver) {
        if (iEventJsonObserver != null) {
            this.f974b.add(iEventJsonObserver);
        }
    }

    /* renamed from: a */
    public void m630a(IEventObserver iEventObserver) {
        if (iEventObserver != null) {
            this.f973a.add(iEventObserver);
        }
    }

    /* renamed from: a */
    public void m631a(IPresetEventObserver iPresetEventObserver) {
        if (iPresetEventObserver != null) {
            this.f975c.add(iPresetEventObserver);
        }
    }

    /* renamed from: a */
    public boolean m632a() {
        return !this.f974b.isEmpty();
    }

    /* renamed from: b */
    public void m633b(IEventJsonObserver iEventJsonObserver) {
        if (iEventJsonObserver != null) {
            this.f974b.remove(iEventJsonObserver);
        }
    }

    /* renamed from: b */
    public void m634b(IEventObserver iEventObserver) {
        if (iEventObserver != null) {
            this.f973a.remove(iEventObserver);
        }
    }

    /* renamed from: b */
    public void m635b(IPresetEventObserver iPresetEventObserver) {
        if (iPresetEventObserver != null) {
            this.f975c.remove(iPresetEventObserver);
        }
    }

    /* renamed from: b */
    public boolean m636b() {
        return !this.f975c.isEmpty();
    }

    @Override // com.bytedance.tobshadow.applog.IEventJsonObserver
    public void eventJson(String str, JSONObject jSONObject) {
        Iterator<IEventJsonObserver> it = this.f974b.iterator();
        while (it.hasNext()) {
            it.next().eventJson(str, jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IEventJsonObserver
    public void launchJson(JSONObject jSONObject) {
        Iterator<IEventJsonObserver> it = this.f974b.iterator();
        while (it.hasNext()) {
            it.next().launchJson(jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IEventObserver
    public void onEvent(String str, String str2, String str3, long j, long j2, String str4) {
        Iterator<IEventObserver> it = this.f973a.iterator();
        while (it.hasNext()) {
            it.next().onEvent(str, str2, str3, j, j2, str4);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IEventObserver
    public void onEventV3(String str, JSONObject jSONObject) {
        Iterator<IEventObserver> it = this.f973a.iterator();
        while (it.hasNext()) {
            it.next().onEventV3(str, jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IPresetEventObserver
    public void onLaunch(JSONObject jSONObject) {
        Iterator<IPresetEventObserver> it = this.f975c.iterator();
        while (it.hasNext()) {
            it.next().onLaunch(jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IPresetEventObserver
    public void onPageEnter(JSONObject jSONObject) {
        Iterator<IPresetEventObserver> it = this.f975c.iterator();
        while (it.hasNext()) {
            it.next().onPageEnter(jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IPresetEventObserver
    public void onPageLeave(JSONObject jSONObject) {
        Iterator<IPresetEventObserver> it = this.f975c.iterator();
        while (it.hasNext()) {
            it.next().onPageLeave(jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IEventJsonObserver
    public void pageJson(JSONObject jSONObject, boolean z) {
        Iterator<IEventJsonObserver> it = this.f974b.iterator();
        while (it.hasNext()) {
            it.next().pageJson(jSONObject, z);
        }
    }
}
