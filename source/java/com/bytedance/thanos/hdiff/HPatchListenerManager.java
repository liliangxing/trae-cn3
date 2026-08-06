package com.bytedance.thanos.hdiff;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class HPatchListenerManager {
    private static volatile HPatchListenerManager sInstance;
    private List<PatchProgressListener> mPatchProgressListenerList = Collections.emptyList();

    /* loaded from: classes5.dex */
    public interface PatchProgressListener {
        void onProgress(float f);
    }

    private HPatchListenerManager() {
    }

    public static HPatchListenerManager getsInstance() {
        if (sInstance == null) {
            synchronized (HPatchListenerManager.class) {
                if (sInstance == null) {
                    sInstance = new HPatchListenerManager();
                }
            }
        }
        return sInstance;
    }

    public void addPatchProgressListener(PatchProgressListener patchProgressListener) {
        if (this.mPatchProgressListenerList.isEmpty()) {
            this.mPatchProgressListenerList = new CopyOnWriteArrayList();
        }
        this.mPatchProgressListenerList.add(patchProgressListener);
    }

    public void removePatchProgressListener(PatchProgressListener patchProgressListener) {
        if (this.mPatchProgressListenerList.isEmpty()) {
            this.mPatchProgressListenerList = new CopyOnWriteArrayList();
        }
        this.mPatchProgressListenerList.remove(patchProgressListener);
    }

    List<PatchProgressListener> getPatchProgressListener() {
        return this.mPatchProgressListenerList;
    }
}
