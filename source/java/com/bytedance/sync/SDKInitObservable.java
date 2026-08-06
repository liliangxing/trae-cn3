package com.bytedance.sync;

import java.util.Observable;

/* loaded from: classes5.dex */
public class SDKInitObservable extends Observable {
    public void notifyInit() {
        setChanged();
        notifyObservers(true);
    }
}
