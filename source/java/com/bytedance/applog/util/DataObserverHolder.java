package com.bytedance.applog.util;

import com.bytedance.applog.IDataObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DataObserverHolder implements IDataObserver {
    private final CopyOnWriteArraySet<IDataObserver> mDataObserver = new CopyOnWriteArraySet<>();

    @Override // com.bytedance.applog.IDataObserver
    public void onIdLoaded(String str, String str2, String str3) {
        Iterator<IDataObserver> it = this.mDataObserver.iterator();
        while (it.hasNext()) {
            it.next().onIdLoaded(str, str2, str3);
        }
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<IDataObserver> it = this.mDataObserver.iterator();
        while (it.hasNext()) {
            it.next().onRemoteIdGet(z, str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
        Iterator<IDataObserver> it = this.mDataObserver.iterator();
        while (it.hasNext()) {
            it.next().onRemoteConfigGet(z, jSONObject);
        }
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
        Iterator<IDataObserver> it = this.mDataObserver.iterator();
        while (it.hasNext()) {
            it.next().onRemoteAbConfigGet(z, jSONObject);
        }
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onAbVidsChange(String str, String str2) {
        Iterator<IDataObserver> it = this.mDataObserver.iterator();
        while (it.hasNext()) {
            it.next().onAbVidsChange(str, str2);
        }
    }

    public void addDataObserver(IDataObserver iDataObserver) {
        if (iDataObserver != null) {
            this.mDataObserver.add(iDataObserver);
        }
    }

    public void removeDataObserver(IDataObserver iDataObserver) {
        if (iDataObserver != null) {
            this.mDataObserver.remove(iDataObserver);
        }
    }

    public void removeAllDataObserver() {
        this.mDataObserver.clear();
    }
}
