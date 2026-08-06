package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.ISingScoringEventHandler;
import com.ss.bytertc.engine.SingScoringManager;
import com.ss.bytertc.engine.data.SingScoringRealtimeInfo;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class NativeSingScoringEventHandler {
    private static final String TAG = "NativeSingScoringEventHandler";
    private WeakReference<SingScoringManager> mSingScoringManager;

    public NativeSingScoringEventHandler(SingScoringManager singScoringManager) {
        this.mSingScoringManager = new WeakReference<>(singScoringManager);
    }

    void onCurrentScoringInfo(SingScoringRealtimeInfo info) {
        SingScoringManager singScoringManager;
        ISingScoringEventHandler singScoringEventHandler;
        WeakReference<SingScoringManager> weakReference = this.mSingScoringManager;
        if (weakReference == null || (singScoringManager = weakReference.get()) == null || (singScoringEventHandler = singScoringManager.getSingScoringEventHandler()) == null) {
            return;
        }
        singScoringEventHandler.onCurrentScoringInfo(info);
    }
}
