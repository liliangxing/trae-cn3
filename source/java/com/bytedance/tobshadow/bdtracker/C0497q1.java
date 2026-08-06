package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.IDataObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.q1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0497q1 implements IDataObserver {

    /* renamed from: a */
    public final CopyOnWriteArraySet<IDataObserver> f944a = new CopyOnWriteArraySet<>();

    /* renamed from: a */
    public void m616a(IDataObserver iDataObserver) {
        if (iDataObserver != null) {
            this.f944a.add(iDataObserver);
        }
    }

    /* renamed from: b */
    public void m617b(IDataObserver iDataObserver) {
        if (iDataObserver != null) {
            this.f944a.remove(iDataObserver);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IDataObserver
    public void onAbVidsChange(String str, String str2) {
        Iterator<IDataObserver> it = this.f944a.iterator();
        while (it.hasNext()) {
            it.next().onAbVidsChange(str, str2);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IDataObserver
    public void onIdLoaded(String str, String str2, String str3) {
        Iterator<IDataObserver> it = this.f944a.iterator();
        while (it.hasNext()) {
            it.next().onIdLoaded(str, str2, str3);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IDataObserver
    public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
        Iterator<IDataObserver> it = this.f944a.iterator();
        while (it.hasNext()) {
            it.next().onRemoteAbConfigGet(z, jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IDataObserver
    public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
        Iterator<IDataObserver> it = this.f944a.iterator();
        while (it.hasNext()) {
            it.next().onRemoteConfigGet(z, jSONObject);
        }
    }

    @Override // com.bytedance.tobshadow.applog.IDataObserver
    public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<IDataObserver> it = this.f944a.iterator();
        while (it.hasNext()) {
            it.next().onRemoteIdGet(z, str, str2, str3, str4, str5, str6);
        }
    }
}
