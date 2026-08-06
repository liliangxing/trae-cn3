package com.lynx.tasm.navigator;

import android.content.Context;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NavigationModule extends LynxModule {
    public static String NAME = "NavigationModule";

    public NavigationModule(Context context) {
        super(context);
    }

    public NavigationModule(Context context, Object obj) {
        super(context, obj);
    }

    @LynxMethod
    public void registerRoute(final ReadableMap readableMap) {
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.navigator.NavigationModule.1
            @Override // java.lang.Runnable
            public void run() {
                LynxNavigator.inst().registerRoute(readableMap);
            }
        });
    }

    @LynxMethod
    public void navigateTo(final String str, final ReadableMap readableMap) {
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.navigator.NavigationModule.2
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                ReadableMap readableMap2 = readableMap;
                if (readableMap2 != null) {
                    hashMap = readableMap2.asHashMap();
                }
                LynxNavigator.inst().navigate(str, hashMap);
            }
        });
    }

    @LynxMethod
    public void replace(final String str, final ReadableMap readableMap) {
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.navigator.NavigationModule.3
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                ReadableMap readableMap2 = readableMap;
                if (readableMap2 != null) {
                    hashMap = readableMap2.asHashMap();
                }
                LynxNavigator.inst().replace(str, hashMap);
            }
        });
    }

    @LynxMethod
    public void goBack() {
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.navigator.NavigationModule.4
            @Override // java.lang.Runnable
            public void run() {
                LynxNavigator.inst().goBack();
            }
        });
    }

    @LynxMethod
    public String getString() {
        return NAME;
    }
}
