package com.bytedance.bdinstall.util;

import com.bytedance.bdinstall.IDataObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public class DataObserverHolder implements IDataObserver {
    private static volatile DataObserverHolder sInstance;
    private final CopyOnWriteArraySet<IDataObserver> mDataObserver = new CopyOnWriteArraySet<>();

    public static DataObserverHolder getInstance() {
        if (sInstance == null) {
            synchronized (DataObserverHolder.class) {
                if (sInstance == null) {
                    sInstance = new DataObserverHolder();
                }
            }
        }
        return sInstance;
    }

    private DataObserverHolder() {
    }

    @Override // com.bytedance.bdinstall.IDataObserver
    public void onIdLoaded(String str, String str2, String str3) {
        Iterator<IDataObserver> it = this.mDataObserver.iterator();
        while (it.hasNext()) {
            it.next().onIdLoaded(str, str2, str3);
        }
    }

    @Override // com.bytedance.bdinstall.IDataObserver
    public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<IDataObserver> it = this.mDataObserver.iterator();
        while (it.hasNext()) {
            it.next().onRemoteIdGet(z, str, str2, str3, str4, str5, str6);
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
