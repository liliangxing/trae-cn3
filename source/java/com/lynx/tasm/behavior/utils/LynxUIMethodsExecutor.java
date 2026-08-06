package com.lynx.tasm.behavior.utils;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.UIShadowProxy;
import com.lynx.tasm.utils.CallStackUtil;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxUIMethodsExecutor {
    private static final Map<Class<?>, LynxUIMethodInvoker<?>> LYNX_UI_METHOD_INVOKER_MAP = new HashMap();

    public static void invokeMethod(LynxBaseUI lynxBaseUI, String str, ReadableMap readableMap, Callback callback) {
        if (lynxBaseUI instanceof UIShadowProxy) {
            lynxBaseUI = ((UIShadowProxy) lynxBaseUI).getChild();
        }
        if (lynxBaseUI == null) {
            callback.invoke(new Object[]{2, "node does not have a LynxUI"});
            return;
        }
        try {
            findLynxUIMethodInvoker(lynxBaseUI.getClass()).invoke(lynxBaseUI, str, readableMap, callback);
        } catch (Exception e) {
            LynxError lynxError = new LynxError(990100, "Invoke method '" + str + "' error: " + e.getMessage(), "", "error");
            lynxError.setCallStack(CallStackUtil.getStackTraceStringWithLineTrimmed(e));
            lynxError.setUserDefineInfo(lynxBaseUI.getPlatformCustomInfo());
            lynxBaseUI.getLynxContext().handleLynxError(lynxError);
        }
    }

    public static void registerMethodInvoker(LynxUIMethodInvoker lynxUIMethodInvoker) {
        LYNX_UI_METHOD_INVOKER_MAP.put(lynxUIMethodInvoker.getClass(), lynxUIMethodInvoker);
    }

    static <T extends LynxBaseUI> LynxUIMethodInvoker<T> findLynxUIMethodInvoker(Class<? extends LynxBaseUI> cls) {
        Map<Class<?>, LynxUIMethodInvoker<?>> map = LYNX_UI_METHOD_INVOKER_MAP;
        LynxUIMethodInvoker<T> lynxUIMethodInvoker = (LynxUIMethodInvoker) map.get(cls);
        if (lynxUIMethodInvoker == null) {
            lynxUIMethodInvoker = (LynxUIMethodInvoker) findGeneratedMethodInvoker(cls);
            if (lynxUIMethodInvoker == null) {
                String str = "MethodInvoker not generated for class: " + cls.getName() + ". You should add module lynxProcessor";
                LLog.e("MethodsExecutor", str);
                if (LynxEnv.inst().isCheckPropsSetter() && LynxEnv.inst().isLynxDebugEnabled()) {
                    throw new IllegalStateException(str);
                }
                lynxUIMethodInvoker = new FallbackLynxUIMethodInvoker<>(cls);
            }
            map.put(cls, lynxUIMethodInvoker);
        }
        return lynxUIMethodInvoker;
    }

    private static <T> T findGeneratedMethodInvoker(Class<?> cls) {
        String str = cls.getName() + "$$MethodInvoker";
        try {
            return (T) Class.forName(str).newInstance();
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (IllegalAccessException e) {
            e = e;
            throw new RuntimeException("Unable to instantiate methods invoker for " + str, e);
        } catch (InstantiationException e2) {
            e = e2;
            throw new RuntimeException("Unable to instantiate methods invoker for " + str, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class FallbackLynxUIMethodInvoker<T extends LynxBaseUI> implements LynxUIMethodInvoker<T> {
        private Map<String, Method> mMethods;

        public FallbackLynxUIMethodInvoker(Class<? extends LynxBaseUI> cls) {
            this.mMethods = LynxUIMethodsCache.getNativeMethodsForLynxUIClass(cls);
        }

        @Override // com.lynx.tasm.behavior.utils.LynxUIMethodInvoker
        public void invoke(T t, String str, ReadableMap readableMap, Callback callback) {
            Method method = this.mMethods.get(str);
            if (method == null) {
                callback.invoke(new Object[]{3});
                return;
            }
            try {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 0) {
                    method.invoke(t, new Object[0]);
                } else if (parameterTypes.length == 1) {
                    Class<?> cls = parameterTypes[0];
                    if (cls == ReadableMap.class) {
                        method.invoke(t, readableMap);
                    } else if (cls == Callback.class) {
                        method.invoke(t, callback);
                    }
                } else if (parameterTypes[0] == ReadableMap.class && parameterTypes[1] == Callback.class) {
                    method.invoke(t, readableMap, callback);
                } else {
                    callback.invoke(new Object[]{4});
                    LLog.d("FallbackMethodInvoker", "invoke target method: params invalid");
                }
            } catch (Exception e) {
                callback.invoke(new Object[]{1});
                LLog.d("FallbackMethodInvoker", "invoke target method exception," + e.getMessage());
            }
        }
    }
}
