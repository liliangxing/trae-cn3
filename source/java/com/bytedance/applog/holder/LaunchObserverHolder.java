package com.bytedance.applog.holder;

import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.ILaunchObserver;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LaunchObserverHolder implements ILaunchObserver {
    private final AppLogInstance appLogInstance;
    private final CopyOnWriteArraySet<ILaunchObserver> observers = new CopyOnWriteArraySet<>();

    public LaunchObserverHolder(AppLogInstance appLogInstance) {
        this.appLogInstance = appLogInstance;
    }

    @Override // com.bytedance.applog.ILaunchObserver
    public void onLaunch(String str, long j, boolean z) {
        Iterator<ILaunchObserver> it = this.observers.iterator();
        while (it.hasNext()) {
            try {
                it.next().onLaunch(str, j, z);
            } catch (Throwable th) {
                this.appLogInstance.getLogger().error(Collections.singletonList("LaunchObserverHolder"), "invoke onLaunch callback failed", th, new Object[0]);
            }
        }
    }

    public void addObserver(ILaunchObserver iLaunchObserver) {
        if (iLaunchObserver != null) {
            this.observers.add(iLaunchObserver);
        }
    }

    public void removeObserver(ILaunchObserver iLaunchObserver) {
        if (iLaunchObserver != null) {
            this.observers.remove(iLaunchObserver);
        }
    }

    public int getObserverSize() {
        return this.observers.size();
    }
}
