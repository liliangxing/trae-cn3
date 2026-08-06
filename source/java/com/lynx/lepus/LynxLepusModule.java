package com.lynx.lepus;

import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.jsbridge.LynxModuleWrapper;
import com.lynx.jsbridge.MethodDescriptor;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.common.LepusBuffer;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.core.LynxThreadPool;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxLepusModule {
    private static final String METHOD_CALL = "call";
    private static final String METHOD_CALL_SYNC = "callSync";
    private static final String PARAM_CALLBACKID = "callbackId";
    private static final String PARAM_DATA = "param";
    private static final String PARAM_ENTRY = "tasmEntryName";
    private static final String PARAM_FROM_PIPER = "fromPiper";
    private static final String PARAM_METHOD = "method";
    private static final String PARAM_METHOD_DETAIL = "methodDetail";
    private static final String PARAM_MODULE = "module";
    private static final String TAG = "LynxLepusModule";

    public static void triggerLepusBridgeAsync(final String str, Object obj, LynxEngineProxy lynxEngineProxy, LynxModuleFactory lynxModuleFactory) {
        if (obj instanceof ReadableMap) {
            if (lynxModuleFactory == null) {
                LLog.m2577e(TAG, "mModuleFactory does not exist!");
                return;
            }
            final ReadableMap readableMap = (ReadableMap) obj;
            ReadableMap map = readableMap.getMap(PARAM_METHOD_DETAIL, new JavaOnlyMap());
            String string = map.getString(PARAM_MODULE, null);
            map.getString("method", null);
            if (string == null) {
                return;
            }
            LynxModuleWrapper module = lynxModuleFactory.getModule(string);
            if (module == null) {
                module = LynxEnv.inst().getModuleFactory().getModule(string);
            }
            if (module == null) {
                return;
            }
            boolean z = false;
            if (!readableMap.getBoolean("lepusUseUIThread", false) && readableMap.getBoolean("useAirThread", false)) {
                z = true;
            }
            if (z) {
                final WeakReference weakReference = new WeakReference(module);
                final WeakReference weakReference2 = new WeakReference(lynxEngineProxy);
                LynxThreadPool.getAsyncLepusBridgeExecutor().execute(new Runnable() { // from class: com.lynx.lepus.LynxLepusModule.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LynxModuleWrapper lynxModuleWrapper = (LynxModuleWrapper) weakReference.get();
                        LynxEngineProxy lynxEngineProxy2 = (LynxEngineProxy) weakReference2.get();
                        if (lynxModuleWrapper != null && lynxEngineProxy2 != null) {
                            LynxLepusModule.invokeLepusModuleInternal(lynxModuleWrapper, lynxEngineProxy2, readableMap, str);
                        } else {
                            LLog.m2578i(LynxLepusModule.TAG, "triggerLepusBridgeAsync failed, LynxModule or LynxEngine has been released.");
                        }
                    }
                });
                return;
            }
            invokeLepusModuleInternal(module, lynxEngineProxy, readableMap, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void invokeLepusModuleInternal(LynxModuleWrapper lynxModuleWrapper, LynxEngineProxy lynxEngineProxy, ReadableMap readableMap, String str) {
        char c;
        ReadableMap map = readableMap.getMap(PARAM_METHOD_DETAIL, new JavaOnlyMap());
        map.getString(PARAM_MODULE, null);
        String string = map.getString("method", null);
        final boolean z = readableMap.getBoolean(PARAM_FROM_PIPER, false);
        final String string2 = readableMap.getString(PARAM_ENTRY, null);
        final int i = readableMap.getInt(PARAM_CALLBACKID, -1);
        char c2 = 1;
        boolean z2 = str.equals(METHOD_CALL) || !(string == null || string.length() == 0);
        try {
            for (MethodDescriptor methodDescriptor : lynxModuleWrapper.getMethodDescriptors()) {
                String name = methodDescriptor.getName();
                if (name != null && !name.isEmpty()) {
                    if (name.equals(str)) {
                        final WeakReference weakReference = new WeakReference(lynxEngineProxy);
                        if (z2) {
                            Method method = methodDescriptor.getMethod();
                            LynxModule module = lynxModuleWrapper.getModule();
                            Object[] objArr = new Object[3];
                            objArr[0] = string;
                            objArr[c2] = map;
                            objArr[2] = new Callback() { // from class: com.lynx.lepus.LynxLepusModule.2
                                @Override // com.lynx.react.bridge.Callback
                                public void invoke(Object... objArr2) {
                                    LynxEngineProxy lynxEngineProxy2 = (LynxEngineProxy) weakReference.get();
                                    if (lynxEngineProxy2 == null) {
                                        LLog.m2578i(LynxLepusModule.TAG, "triggerLepusBridgeAsync failed, LynxEngine has been released.");
                                    } else {
                                        if (objArr2.length <= 0 || z) {
                                            return;
                                        }
                                        lynxEngineProxy2.invokeLepusApiCallback(i, string2, LepusBuffer.INSTANCE.encodeMessage(objArr2[0]));
                                    }
                                }
                            };
                            method.invoke(module, objArr);
                        } else if (z) {
                            methodDescriptor.getMethod().invoke(lynxModuleWrapper.getModule(), map.getArray("param", new JavaOnlyArray()).asArrayList().toArray());
                        } else {
                            Method method2 = methodDescriptor.getMethod();
                            LynxModule module2 = lynxModuleWrapper.getModule();
                            Callback callback = new Callback() { // from class: com.lynx.lepus.LynxLepusModule.3
                                @Override // com.lynx.react.bridge.Callback
                                public void invoke(Object... objArr2) {
                                    LynxEngineProxy lynxEngineProxy2 = (LynxEngineProxy) weakReference.get();
                                    if (lynxEngineProxy2 == null) {
                                        LLog.m2578i(LynxLepusModule.TAG, "triggerLepusBridgeAsync failed, LynxEngine has been released.");
                                    } else if (objArr2.length > 0) {
                                        lynxEngineProxy2.invokeLepusApiCallback(i, string2, LepusBuffer.INSTANCE.encodeMessage(objArr2[0]));
                                    }
                                }
                            };
                            c = 1;
                            method2.invoke(module2, map, callback);
                            c2 = c;
                        }
                        c = 1;
                        c2 = c;
                    }
                }
            }
        } catch (Exception e) {
            LLog.m2577e(TAG, "Lepus Module invokeAsync: " + e.toString());
        }
    }

    public static Object triggerLepusBridge(String str, Object obj, LynxModuleFactory lynxModuleFactory) {
        if (!(obj instanceof ReadableMap)) {
            return null;
        }
        if (lynxModuleFactory == null) {
            LLog.m2577e(TAG, "mModuleFactory does not exist!");
            return null;
        }
        ReadableMap map = ((ReadableMap) obj).getMap(PARAM_METHOD_DETAIL, new JavaOnlyMap());
        String string = map.getString(PARAM_MODULE, null);
        String string2 = map.getString("method", null);
        if (string == null) {
            return null;
        }
        LynxModuleWrapper module = lynxModuleFactory.getModule(string);
        if (module == null) {
            module = LynxEnv.inst().getModuleFactory().getModule(string);
        }
        if (module == null) {
            return null;
        }
        boolean z = str.equals(METHOD_CALL) || str.equals(METHOD_CALL_SYNC) || !(string2 == null || string2.length() == 0);
        for (MethodDescriptor methodDescriptor : module.getMethodDescriptors()) {
            String name = methodDescriptor.getName();
            if (name != null && !name.isEmpty() && name.equals(str)) {
                try {
                    return z ? methodDescriptor.getMethod().invoke(module.getModule(), string2, map) : methodDescriptor.getMethod().invoke(module.getModule(), map);
                } catch (Exception e) {
                    LLog.m2577e(TAG, "Lepus Module invokeSync: " + e.toString());
                }
            }
        }
        return null;
    }
}
