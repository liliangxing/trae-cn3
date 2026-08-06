package com.lynx.tasm.navigator;

import android.text.TextUtils;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxNavigator {
    private static LynxNavigator lynxNavigator = new LynxNavigator();
    private LynxSchemaInterceptor interceptor;
    private Stack<LynxCardManager> cardManagerStack = new Stack<>();
    private Map<LynxHolder, LynxCardManager> pageMap = new WeakHashMap();
    private int capacity = Integer.MAX_VALUE;

    private LynxNavigator() {
    }

    public static LynxNavigator inst() {
        return lynxNavigator;
    }

    public LynxNavigator setSchemaInterceptor(LynxSchemaInterceptor lynxSchemaInterceptor) {
        this.interceptor = lynxSchemaInterceptor;
        return this;
    }

    public LynxNavigator setMaxCapacity(int i) {
        this.capacity = i;
        return this;
    }

    public void registerLynxHolder(LynxHolder lynxHolder) {
        registerLynxHolder(lynxHolder, null);
    }

    public void registerLynxHolder(LynxHolder lynxHolder, LynxView lynxView) {
        LynxCardManager lynxCardManager = new LynxCardManager(lynxHolder, this.capacity);
        if (lynxView != null) {
            lynxCardManager.registerInitLynxView(lynxView);
        }
        this.cardManagerStack.push(lynxCardManager);
        this.pageMap.put(lynxHolder, lynxCardManager);
    }

    public void unRegisterLynxHolder(LynxHolder lynxHolder) {
        LynxCardManager remove = this.pageMap.remove(lynxHolder);
        if (remove != null) {
            remove.onDestroy();
            Iterator<LynxCardManager> it = this.cardManagerStack.iterator();
            while (it.hasNext()) {
                if (it.next() == remove) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void navigate(String str, Map<String, Object> map) {
        LynxCardManager currentCardManager;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LynxSchemaInterceptor lynxSchemaInterceptor = this.interceptor;
        if ((lynxSchemaInterceptor == null || !lynxSchemaInterceptor.intercept(str, map)) && (currentCardManager = getCurrentCardManager()) != null) {
            currentCardManager.push(str, map);
        }
    }

    public void replace(String str, Map<String, Object> map) {
        LynxCardManager currentCardManager;
        if (TextUtils.isEmpty(str) || (currentCardManager = getCurrentCardManager()) == null) {
            return;
        }
        currentCardManager.replace(str, map);
    }

    public void goBack() {
        LynxCardManager currentCardManager = getCurrentCardManager();
        if (currentCardManager != null) {
            currentCardManager.pop();
        }
    }

    public void registerRoute(ReadableMap readableMap) {
        LynxCardManager currentCardManager = getCurrentCardManager();
        if (currentCardManager != null) {
            currentCardManager.registerRoute(readableMap);
        }
    }

    public boolean onBackPressed(LynxHolder lynxHolder) {
        LynxCardManager currentCardManager = getCurrentCardManager();
        if (currentCardManager != null) {
            return currentCardManager.onBackPressed();
        }
        return false;
    }

    public LynxCardManager getCurrentCardManager() {
        Stack<LynxCardManager> stack = this.cardManagerStack;
        if (stack == null || stack.isEmpty()) {
            return null;
        }
        return this.cardManagerStack.peek();
    }

    public void onEnterForeground(LynxHolder lynxHolder) {
        LynxCardManager currentCardManager = getCurrentCardManager();
        if (currentCardManager != null) {
            currentCardManager.onEnterForeground();
        }
    }

    public void onEnterBackground(LynxHolder lynxHolder) {
        LynxCardManager currentCardManager = getCurrentCardManager();
        if (currentCardManager != null) {
            currentCardManager.onEnterBackground();
        }
    }
}
