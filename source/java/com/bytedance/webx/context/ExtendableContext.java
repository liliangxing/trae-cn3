package com.bytedance.webx.context;

import com.bytedance.webx.AbsExtension;
import com.bytedance.webx.WebXEnv;
import com.bytedance.webx.__PrivateMethod;
import com.bytedance.webx.base.logger.WLog;
import com.bytedance.webx.core.IExtendableControl;
import com.bytedance.webx.event.AbsListenerStub;
import com.bytedance.webx.impl.WebXImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ExtendableContext implements IContext {
    private static final WeakReference<Object> EMPTY_WEAK_REF_WOKEN = new WeakReference<>(null);
    private IExtendableControl mExtendable;
    private HashMap<Class<? extends AbsExtension>, WebXEnv.IExtensionCreateListener> mExtensionCreateListenerMap;
    private Set<WebXEnv.IExtensionCreateListener> mExtensionCreateListeners;
    private Map<String, TreeMap<Integer, AbsListenerStub>> mListenerMap;
    private WebXEnv mWebXEnv;
    private WeakReference<Object> mWeakRefToken = EMPTY_WEAK_REF_WOKEN;
    private boolean mIsBaseInited = false;
    private ArrayList<IContextItem> mContextItems = new ArrayList<>();
    private HashMap<Class, WeakReference<IContextItem>> mExtensionClassMap = new HashMap<>();

    public ExtendableContext(WebXEnv webXEnv, IExtendableControl iExtendableControl) {
        this.mWebXEnv = webXEnv;
        this.mExtendable = iExtendableControl;
        if (!(iExtendableControl instanceof IContextItem)) {
            throw new Error("! extendable instanceof IContextItem");
        }
        this.mContextItems.add((IContextItem) iExtendableControl);
    }

    private void add(Class<? extends AbsExtension> cls, IContextItem iContextItem) {
        this.mContextItems.add(iContextItem);
        this.mExtensionClassMap.put(cls, new WeakReference<>(iContextItem));
    }

    @Override // com.bytedance.webx.context.IContext
    public void setListenerMap(Map<String, TreeMap<Integer, AbsListenerStub>> map) {
        this.mListenerMap = map;
    }

    @Override // com.bytedance.webx.context.IContext
    public Map<String, TreeMap<Integer, AbsListenerStub>> getListenerMap() {
        return this.mListenerMap;
    }

    @Override // com.bytedance.webx.context.IContext
    public IContextItem getOrigin() {
        return (IContextItem) this.mExtendable;
    }

    @Override // com.bytedance.webx.context.IContext
    public IContextItem getExtension(Class cls) {
        WeakReference<IContextItem> weakReference = this.mExtensionClassMap.get(cls);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.bytedance.webx.context.IContext
    public Iterator<IContextItem> itContextItems() {
        return this.mContextItems.iterator();
    }

    @Override // com.bytedance.webx.context.IContext
    public WebXEnv getEnv() {
        return this.mWebXEnv;
    }

    public boolean isBaseInited() {
        return this.mIsBaseInited;
    }

    public void setBaseInited(boolean z) {
        this.mIsBaseInited = z;
    }

    public void firstAddExtension(LinkedHashSet<Class<? extends AbsExtension>> linkedHashSet) {
        if (linkedHashSet != null) {
            Iterator<Class<? extends AbsExtension>> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                Class<? extends AbsExtension> next = it.next();
                AbsExtension absExtension = (AbsExtension) WebXImpl.newInstance(next);
                if (absExtension == null) {
                    throw new Error("extension init fail: " + next);
                }
                initExtension(next, absExtension);
            }
        }
        Iterator it2 = new ArrayList(this.mContextItems).iterator();
        while (it2.hasNext()) {
            IContextItem iContextItem = (IContextItem) it2.next();
            if (iContextItem instanceof AbsExtension) {
                __PrivateMethod.onCreateExtendable((AbsExtension) iContextItem);
            }
        }
    }

    public void addExtensionCreateListener(Set<WebXEnv.IExtensionCreateListener> set, HashMap<Class<? extends AbsExtension>, WebXEnv.IExtensionCreateListener> hashMap) {
        if (set != null) {
            Set<WebXEnv.IExtensionCreateListener> set2 = this.mExtensionCreateListeners;
            if (set2 == null) {
                this.mExtensionCreateListeners = set;
            } else {
                set2.addAll(set);
            }
        }
        this.mExtensionCreateListenerMap = hashMap;
    }

    public void addExtension(Set<Class<? extends AbsExtension>> set) {
        if (set != null) {
            for (Class<? extends AbsExtension> cls : set) {
                if (!isDuplicated(cls)) {
                    AbsExtension absExtension = (AbsExtension) WebXImpl.newInstance(cls);
                    if (absExtension == null) {
                        String str = "extension init fail: " + cls;
                        Throwable th = new Throwable(str);
                        WLog.m44e("ExtendableContext", str, th);
                        WebXEnv.onError(str, th);
                    } else {
                        initExtension(cls, absExtension);
                        __PrivateMethod.onCreateExtendable(absExtension);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addExtensionInstance(AbsExtension... absExtensionArr) {
        if (absExtensionArr == null) {
            return;
        }
        for (AbsExtension absExtension : absExtensionArr) {
            Class<?> cls = absExtension.getClass();
            if (isDuplicated(cls)) {
                return;
            }
            initExtension(cls, absExtension);
            __PrivateMethod.onCreateExtendable(absExtension);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addExtensionInstanceNeverCast(AbsExtension... absExtensionArr) {
        if (absExtensionArr == null) {
            return;
        }
        for (AbsExtension absExtension : absExtensionArr) {
            initExtension(absExtension.getClass(), absExtension);
            __PrivateMethod.onCreateExtendable(absExtension);
        }
    }

    private void initExtension(Class<? extends AbsExtension> cls, AbsExtension absExtension) {
        WebXEnv.IExtensionCreateListener iExtensionCreateListener;
        LinkedHashSet<WebXEnv.IExtensionCreateListener> linkedHashSet;
        absExtension.init(this.mWebXEnv);
        if (this.mWebXEnv.mExtensionCreateListeners != null) {
            Iterator<WebXEnv.IExtensionCreateListener> it = this.mWebXEnv.mExtensionCreateListeners.iterator();
            while (it.hasNext()) {
                it.next().onExtensionCreate(absExtension);
            }
        }
        if (this.mWebXEnv.mExtensionCreateListenersMap != null && (linkedHashSet = this.mWebXEnv.mExtensionCreateListenersMap.get(cls)) != null) {
            Iterator<WebXEnv.IExtensionCreateListener> it2 = linkedHashSet.iterator();
            while (it2.hasNext()) {
                it2.next().onExtensionCreate(absExtension);
            }
        }
        Set<WebXEnv.IExtensionCreateListener> set = this.mExtensionCreateListeners;
        if (set != null) {
            Iterator<WebXEnv.IExtensionCreateListener> it3 = set.iterator();
            while (it3.hasNext()) {
                it3.next().onExtensionCreate(absExtension);
            }
        }
        HashMap<Class<? extends AbsExtension>, WebXEnv.IExtensionCreateListener> hashMap = this.mExtensionCreateListenerMap;
        if (hashMap != null && (iExtensionCreateListener = hashMap.get(cls)) != null) {
            iExtensionCreateListener.onExtensionCreate(absExtension);
        }
        add(cls, absExtension);
        absExtension.setContext(this);
    }

    private boolean isDuplicated(Class<? extends AbsExtension> cls) {
        return this.mExtensionClassMap.containsKey(cls);
    }
}
