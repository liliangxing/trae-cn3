package com.lynx.tasm.navigator;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.behavior.herotransition.HeroTransitionManager;
import com.lynx.tasm.navigator.LynxRouteLruCache;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxCardManager implements LynxRouteLruCache.LynxRouteCacheListener {
    private WeakReference<LynxHolder> holderRef;
    private WeakReference<LynxView> initLynxViewRef;
    private LynxRouteLruCache lruCache;
    private Stack<LynxRoute> routeStack = new Stack<>();
    private HashMap<String, Object> routeTable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LynxCardManager(LynxHolder lynxHolder, int i) {
        this.holderRef = new WeakReference<>(lynxHolder);
        this.lruCache = new LynxRouteLruCache(i, this);
    }

    public void registerRoute(ReadableMap readableMap) {
        this.routeTable = readableMap.asHashMap();
    }

    public void registerInitLynxView(LynxView lynxView) {
        this.initLynxViewRef = new WeakReference<>(lynxView);
    }

    public void push(final String str, Map<String, Object> map) {
        final LynxRoute lynxRoute = new LynxRoute(getTemplateUrl(str), map);
        buildLynxView(lynxRoute, new LynxViewCreationListener() { // from class: com.lynx.tasm.navigator.LynxCardManager.1
            @Override // com.lynx.tasm.navigator.LynxViewCreationListener
            public void onFailed() {
            }

            @Override // com.lynx.tasm.navigator.LynxViewCreationListener
            public void onReady(LynxView lynxView) {
                if (lynxView != null) {
                    if (!LynxCardManager.this.routeStack.isEmpty()) {
                        LynxCardManager.this.invokeOnHide(LynxCardManager.this.lruCache.get((LynxRoute) LynxCardManager.this.routeStack.peek()));
                    } else {
                        LynxCardManager lynxCardManager = LynxCardManager.this;
                        lynxCardManager.invokeOnHide(lynxCardManager.getInitLynxView());
                    }
                    LynxCardManager.this.routeStack.push(lynxRoute);
                    LynxHolder currentHolder = LynxCardManager.this.getCurrentHolder();
                    if (currentHolder != null) {
                        currentHolder.showLynxView(lynxView, str);
                    }
                }
            }
        });
    }

    public void replace(final String str, Map<String, Object> map) {
        final LynxRoute lynxRoute = new LynxRoute(getTemplateUrl(str), map);
        buildLynxView(lynxRoute, new LynxViewCreationListener() { // from class: com.lynx.tasm.navigator.LynxCardManager.2
            @Override // com.lynx.tasm.navigator.LynxViewCreationListener
            public void onFailed() {
            }

            @Override // com.lynx.tasm.navigator.LynxViewCreationListener
            public void onReady(LynxView lynxView) {
                if (lynxView != null) {
                    if (!LynxCardManager.this.routeStack.isEmpty()) {
                        LynxCardManager.this.hideLynxView(LynxCardManager.this.lruCache.remove((LynxRoute) LynxCardManager.this.routeStack.pop()));
                    } else {
                        LynxCardManager lynxCardManager = LynxCardManager.this;
                        lynxCardManager.hideLynxView(lynxCardManager.getInitLynxView());
                    }
                    LynxCardManager.this.routeStack.push(lynxRoute);
                    LynxHolder currentHolder = LynxCardManager.this.getCurrentHolder();
                    if (currentHolder != null) {
                        currentHolder.showLynxView(lynxView, str);
                    }
                }
            }
        });
    }

    private String getTemplateUrl(String str) {
        HashMap<String, Object> hashMap = this.routeTable;
        if (hashMap != null) {
            Object obj = hashMap.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return str;
    }

    public void pop() {
        if (!this.routeStack.isEmpty()) {
            hideLynxView(this.lruCache.remove(this.routeStack.pop()));
        } else {
            LynxHolder currentHolder = getCurrentHolder();
            if (currentHolder != null) {
                currentHolder.quit();
            }
        }
    }

    public boolean onBackPressed() {
        if (this.routeStack.isEmpty()) {
            return false;
        }
        hideLynxView(this.lruCache.remove(this.routeStack.pop()));
        return true;
    }

    private void buildLynxView(final LynxRoute lynxRoute, final LynxViewCreationListener lynxViewCreationListener) {
        LynxHolder currentHolder = getCurrentHolder();
        if (currentHolder != null) {
            currentHolder.createLynxView(lynxRoute, new LynxViewCreationListener() { // from class: com.lynx.tasm.navigator.LynxCardManager.3
                @Override // com.lynx.tasm.navigator.LynxViewCreationListener
                public void onReady(LynxView lynxView) {
                    if (lynxView != null) {
                        LynxCardManager.this.lruCache.put(lynxRoute, lynxView);
                        lynxViewCreationListener.onReady(lynxView);
                    }
                }

                @Override // com.lynx.tasm.navigator.LynxViewCreationListener
                public void onFailed() {
                    lynxViewCreationListener.onFailed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLynxView(final LynxView lynxView) {
        if (lynxView == null) {
            return;
        }
        HeroTransitionManager.inst().executeExitAnim(lynxView, new HeroTransitionManager.LynxViewExitFinishListener() { // from class: com.lynx.tasm.navigator.LynxCardManager.4
            @Override // com.lynx.tasm.behavior.herotransition.HeroTransitionManager.LynxViewExitFinishListener
            public void onLynxViewExited() {
                LynxHolder currentHolder = LynxCardManager.this.getCurrentHolder();
                if (currentHolder != null) {
                    currentHolder.dismissLynxView(lynxView);
                }
                lynxView.destroy();
            }
        });
        invokeOnShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeOnHide(LynxView lynxView) {
        if (lynxView == null) {
            return;
        }
        HeroTransitionManager.inst().executePauseAnim(lynxView);
        lynxView.onEnterBackground();
    }

    private void invokeOnShow() {
        if (!this.routeStack.isEmpty()) {
            LynxRoute peek = this.routeStack.peek();
            final LynxView lynxView = this.lruCache.get(peek);
            if (lynxView != null) {
                if (lynxView.getParent() == null) {
                    LynxHolder currentHolder = getCurrentHolder();
                    if (currentHolder != null) {
                        currentHolder.showLynxView(lynxView, peek.getRouteName());
                        lynxView.addLynxViewClient(new LynxViewClient() { // from class: com.lynx.tasm.navigator.LynxCardManager.5
                            public void onLoadSuccess() {
                                HeroTransitionManager.inst().executeResumeAnim(lynxView);
                                lynxView.onEnterForeground();
                            }
                        });
                        return;
                    }
                    return;
                }
                HeroTransitionManager.inst().executeResumeAnim(lynxView);
                lynxView.onEnterForeground();
                return;
            }
            return;
        }
        LynxView initLynxView = getInitLynxView();
        if (initLynxView != null) {
            HeroTransitionManager.inst().executeResumeAnim(initLynxView);
            initLynxView.onEnterForeground();
        }
    }

    public void onEnterForeground() {
        if (!this.routeStack.isEmpty()) {
            LynxView lynxView = this.lruCache.get(this.routeStack.peek());
            if (lynxView != null) {
                lynxView.onEnterForeground();
                return;
            }
            return;
        }
        LynxView initLynxView = getInitLynxView();
        if (initLynxView != null) {
            initLynxView.onEnterForeground();
        }
    }

    public void onEnterBackground() {
        if (!this.routeStack.isEmpty()) {
            LynxView lynxView = this.lruCache.get(this.routeStack.peek());
            if (lynxView != null) {
                lynxView.onEnterBackground();
                return;
            }
            return;
        }
        LynxView initLynxView = getInitLynxView();
        if (initLynxView != null) {
            initLynxView.onEnterBackground();
        }
    }

    @Override // com.lynx.tasm.navigator.LynxRouteLruCache.LynxRouteCacheListener
    public void onLynxViewEvicted(LynxView lynxView) {
        LynxHolder currentHolder = getCurrentHolder();
        if (currentHolder != null) {
            currentHolder.dismissLynxView(lynxView);
        }
        lynxView.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LynxHolder getCurrentHolder() {
        WeakReference<LynxHolder> weakReference = this.holderRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LynxView getInitLynxView() {
        WeakReference<LynxView> weakReference = this.initLynxViewRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.lynx.tasm.navigator.LynxRouteLruCache.LynxRouteCacheListener
    public void onLynxViewRecreated(LynxRoute lynxRoute, LynxViewCreationListener lynxViewCreationListener) {
        buildLynxView(lynxRoute, lynxViewCreationListener);
    }

    public void onDestroy() {
        Iterator<LynxRoute> it = this.routeStack.iterator();
        while (it.hasNext()) {
            this.lruCache.remove(it.next());
        }
        this.routeStack.clear();
        HashMap<String, Object> hashMap = this.routeTable;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
