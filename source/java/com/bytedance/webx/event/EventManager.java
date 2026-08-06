package com.bytedance.webx.event;

import com.bytedance.webx.AbsExtension;
import com.bytedance.webx.WebXEnv;
import com.bytedance.webx.base.logger.WLog;
import com.bytedance.webx.context.IContext;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class EventManager {
    public static final int REGION_ENTRY_REDIRECT = 4000;
    public static final int REGION_ENTRY_STAT = 2000;
    public static final int REGION_IN_OUT_ADJUST = 5000;
    public static final int REGION_LOGIC_HIGH_BREAK = 7000;
    public static final int REGION_LOGIC_LOW_BREAK = 9000;
    public static final int REGION_LOGIC_NORMAL = 8000;
    public static final int REGION_LOGIC_STAT = 6000;
    public static final int REGION_PARAMS_ADDITION = 3000;
    public static final int REGION_SYSTEM = 500;
    private static Set<IContext> sContextWeakSet = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public @interface PriorityRegion {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class MyTreeMap<K, V> extends TreeMap<K, V> {
        public static final int MAX_ID = 10000;
        private int mId;

        private MyTreeMap() {
            this.mId = -1;
        }

        public void addId() {
            int i = this.mId + 1;
            this.mId = i;
            if (i == 10000) {
                throw new Error("listener id > 999");
            }
        }

        public int getId() {
            return this.mId;
        }
    }

    public static Set<IContext> getContexts() {
        return sContextWeakSet;
    }

    public static void register(IContext iContext, String str, AbsListenerStub absListenerStub) {
        register(iContext, str, absListenerStub, 8000);
    }

    public static void register(IContext iContext, String str, AbsListenerStub absListenerStub, int i) {
        if (iContext == null) {
            return;
        }
        Map<String, TreeMap<Integer, AbsListenerStub>> listenerMap = iContext.getListenerMap();
        if (listenerMap == null) {
            listenerMap = Collections.synchronizedMap(new HashMap());
            iContext.setListenerMap(listenerMap);
            sContextWeakSet.add(iContext);
        }
        MyTreeMap myTreeMap = (MyTreeMap) listenerMap.get(str);
        if (myTreeMap == null) {
            myTreeMap = new MyTreeMap();
            listenerMap.put(str, myTreeMap);
        }
        if (myTreeMap.containsValue(absListenerStub)) {
            return;
        }
        synchronized (EventManager.class) {
            myTreeMap.addId();
            myTreeMap.put(Integer.valueOf((i * 10000) + myTreeMap.getId()), absListenerStub);
        }
    }

    public static AbsListenerStub getTopListener(IContext iContext, String str) {
        TreeMap<Integer, AbsListenerStub> treeMap;
        if (iContext == null) {
            WLog.m47w("EventManager", "context is null");
            return null;
        }
        Map<String, TreeMap<Integer, AbsListenerStub>> listenerMap = iContext.getListenerMap();
        if (listenerMap == null || (treeMap = listenerMap.get(str)) == null || treeMap.size() <= 0) {
            return null;
        }
        AbsListenerStub value = treeMap.firstEntry().getValue();
        AbsExtension extension = value.getExtension();
        if (!extension.isEnable() || !extension.isApprove()) {
            if (WebXEnv.isEnableTrace()) {
                WLog.m45i("WebX", value.getExtendable().hashCode() + " " + str + "() {");
                WLog.m45i("WebX", value.getExtendable().hashCode() + "   " + extension.getClass().getCanonicalName() + " (disable)");
            }
            return findNextListener(iContext, value, str);
        }
        if (!WebXEnv.isEnableTrace()) {
            return value;
        }
        WLog.m45i("WebX", value.getExtendable().hashCode() + " " + str + "() {");
        WLog.m45i("WebX", value.getExtendable().hashCode() + "   " + extension.getClass().getCanonicalName());
        return value;
    }

    public static AbsListenerStub findNextListener(IContext iContext, AbsListenerStub absListenerStub, String str) {
        TreeMap<Integer, AbsListenerStub> treeMap;
        Map<String, TreeMap<Integer, AbsListenerStub>> listenerMap = iContext.getListenerMap();
        if (listenerMap == null || (treeMap = listenerMap.get(str)) == null || treeMap.size() <= 0) {
            return null;
        }
        Iterator<AbsListenerStub> it = treeMap.values().iterator();
        while (it.hasNext()) {
            if (absListenerStub == it.next()) {
                while (it.hasNext()) {
                    AbsListenerStub next = it.next();
                    AbsExtension extension = next.getExtension();
                    if (!extension.isEnable() || !extension.isApprove()) {
                        if (WebXEnv.isEnableTrace()) {
                            WLog.m45i("WebX", absListenerStub.getExtendable().hashCode() + "   " + extension.getClass().getCanonicalName() + " (disable)");
                        }
                    } else {
                        if (WebXEnv.isEnableTrace()) {
                            WLog.m45i("WebX", absListenerStub.getExtendable().hashCode() + "   " + extension.getClass().getCanonicalName());
                        }
                        return next;
                    }
                }
                if (WebXEnv.isEnableTrace()) {
                    WLog.m45i("WebX", absListenerStub.getExtendable().hashCode() + "   " + absListenerStub.getExtendable().getClass().getCanonicalName() + " //super()->real");
                    WLog.m45i("WebX", absListenerStub.getExtendable().hashCode() + " } //" + str);
                }
                return null;
            }
        }
        if (WebXEnv.isEnableTrace()) {
            WLog.m45i("WebX", "  " + absListenerStub.getExtendable().getClass().getCanonicalName() + " //super()->real");
            WLog.m45i("WebX", "} //" + str);
        }
        return null;
    }
}
