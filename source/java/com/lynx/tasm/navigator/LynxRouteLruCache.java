package com.lynx.tasm.navigator;

import android.util.LruCache;
import com.lynx.tasm.LynxView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxRouteLruCache extends LruCache<LynxRoute, LynxView> {
    private LynxRouteCacheListener listener;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface LynxRouteCacheListener {
        void onLynxViewEvicted(LynxView lynxView);

        void onLynxViewRecreated(LynxRoute lynxRoute, LynxViewCreationListener lynxViewCreationListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.util.LruCache
    public LynxView create(LynxRoute lynxRoute) {
        return null;
    }

    public LynxRouteLruCache(int i, LynxRouteCacheListener lynxRouteCacheListener) {
        super(i);
        this.listener = lynxRouteCacheListener;
    }

    protected final void get(LynxRoute lynxRoute, LynxViewCreationListener lynxViewCreationListener) {
        LynxView lynxView = get(lynxRoute);
        if (lynxView != null) {
            lynxViewCreationListener.onReady(lynxView);
        } else {
            this.listener.onLynxViewRecreated(lynxRoute, lynxViewCreationListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.util.LruCache
    public void entryRemoved(boolean z, LynxRoute lynxRoute, LynxView lynxView, LynxView lynxView2) {
        LynxRouteCacheListener lynxRouteCacheListener;
        if (!z || (lynxRouteCacheListener = this.listener) == null) {
            return;
        }
        lynxRouteCacheListener.onLynxViewEvicted(lynxView);
    }
}
