package com.lynx.tasm.p001ui.image;

import com.facebook.drawee.components.DeferredReleaser;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class AsyncDeferredReleaser {
    private static AsyncDeferredReleaser sInstance;
    private final Runnable releaseRunnable = new Runnable() { // from class: com.lynx.tasm.ui.image.AsyncDeferredReleaser.1
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = AsyncDeferredReleaser.this.mPendingReleasable.iterator();
            while (it.hasNext()) {
                ((DeferredReleaser.Releasable) it.next()).release();
            }
            AsyncDeferredReleaser.this.mPendingReleasable.clear();
        }
    };
    private final Set<DeferredReleaser.Releasable> mPendingReleasable = Collections.newSetFromMap(new ConcurrentHashMap());

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized AsyncDeferredReleaser getInstance() {
        AsyncDeferredReleaser asyncDeferredReleaser;
        synchronized (AsyncDeferredReleaser.class) {
            if (sInstance == null) {
                sInstance = new AsyncDeferredReleaser();
            }
            asyncDeferredReleaser = sInstance;
        }
        return asyncDeferredReleaser;
    }

    AsyncDeferredReleaser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scheduleDeferredRelease(DeferredReleaser.Releasable releasable) {
        if (this.mPendingReleasable.add(releasable) && this.mPendingReleasable.size() == 1) {
            UIThreadUtils.runOnUiThread(this.releaseRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancelDeferredRelease(DeferredReleaser.Releasable releasable) {
        this.mPendingReleasable.remove(releasable);
    }
}
