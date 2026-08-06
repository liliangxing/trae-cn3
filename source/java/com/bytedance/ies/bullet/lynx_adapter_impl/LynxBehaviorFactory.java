package com.bytedance.ies.bullet.lynx_adapter_impl;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.bytedance.ies.lynx.lynx_adapter.annotation.LynxPropWrapper;
import com.bytedance.ies.lynx.lynx_adapter.annotation.LynxUIMethodWrapper;
import com.bytedance.ies.lynx.lynx_adapter.inter.LynxUISetterProxy;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxBehaviorWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxCallbackWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxContextWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.BehaviorClassWarmer;
import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.utils.LynxUIMethodsExecutor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxBehaviorFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/lynx_adapter_impl/LynxBehaviorFactory;", "", "()V", "createLynxBehavior", "Lcom/lynx/tasm/behavior/Behavior;", "wrapper", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxBehaviorWrapper;", "lynx-adapter-impl_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxBehaviorFactory {
    public static final LynxBehaviorFactory INSTANCE = new LynxBehaviorFactory();

    private LynxBehaviorFactory() {
    }

    public final Behavior createLynxBehavior(final LynxBehaviorWrapper wrapper) {
        Intrinsics.checkParameterIsNotNull(wrapper, "wrapper");
        final String name = wrapper.getName();
        final boolean flatten = wrapper.getFlatten();
        return new Behavior(name, flatten) { // from class: com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactory$createLynxBehavior$1
            public ShadowNode createShadowNode() {
                return LynxBehaviorFactoryKt.transform(LynxBehaviorWrapper.this.createShadowNode());
            }

            public LynxUI<?> createUI(LynxContext context) {
                Annotation annotation;
                Intrinsics.checkParameterIsNotNull(context, "context");
                final LynxUIWrapper<? extends View> createUI = LynxBehaviorWrapper.this.createUI(new LynxContextWrapper(context.getBaseContext()));
                final LinkedHashMap linkedHashMap = new LinkedHashMap();
                Method[] declaredMethods = createUI.getClass().getDeclaredMethods();
                Intrinsics.checkExpressionValueIsNotNull(declaredMethods, "this.javaClass.declaredMethods");
                ArrayList arrayList = new ArrayList();
                int length = declaredMethods.length;
                int i = 0;
                while (true) {
                    boolean z = true;
                    if (i >= length) {
                        break;
                    }
                    Method method = declaredMethods[i];
                    Intrinsics.checkExpressionValueIsNotNull(method, "it");
                    Annotation[] annotations = method.getAnnotations();
                    Intrinsics.checkExpressionValueIsNotNull(annotations, "it.annotations");
                    int length2 = annotations.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            z = false;
                            break;
                        }
                        Annotation annotation2 = annotations[i2];
                        if ((annotation2 instanceof LynxPropWrapper) || (annotation2 instanceof LynxUIMethodWrapper)) {
                            break;
                        }
                        i2++;
                    }
                    if (z) {
                        arrayList.add(method);
                    }
                    i++;
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    Annotation annotation3 = null;
                    if (it.hasNext()) {
                        Method method2 = (Method) it.next();
                        Intrinsics.checkExpressionValueIsNotNull(method2, "method");
                        Annotation[] annotations2 = method2.getAnnotations();
                        Intrinsics.checkExpressionValueIsNotNull(annotations2, "method.annotations");
                        int length3 = annotations2.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length3) {
                                annotation = null;
                                break;
                            }
                            annotation = annotations2[i3];
                            if (annotation instanceof LynxPropWrapper) {
                                break;
                            }
                            i3++;
                        }
                        if (annotation != null) {
                            if (annotation != null) {
                                LynxPropWrapper lynxPropWrapper = (LynxPropWrapper) annotation;
                                if (lynxPropWrapper != null) {
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type com.bytedance.ies.lynx.lynx_adapter.annotation.LynxPropWrapper");
                            }
                        }
                        Annotation[] annotations3 = method2.getAnnotations();
                        Intrinsics.checkExpressionValueIsNotNull(annotations3, "method.annotations");
                        int length4 = annotations3.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length4) {
                                break;
                            }
                            Annotation annotation4 = annotations3[i4];
                            if (annotation4 instanceof LynxUIMethodWrapper) {
                                annotation3 = annotation4;
                                break;
                            }
                            i4++;
                        }
                        if (annotation3 != null) {
                            createUI.getMUIMethods().put(method2.getName(), method2);
                        }
                    } else {
                        createUI.setMPropSetter(new LynxUISetterProxy.Base() { // from class: com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactory$createLynxBehavior$1$createUI$1$3
                            @Override // com.bytedance.ies.lynx.lynx_adapter.inter.LynxUISetterProxy.Base, com.bytedance.ies.lynx.lynx_adapter.inter.LynxUISetterProxy
                            public void setProperty(String name2, Object prop) {
                                Intrinsics.checkParameterIsNotNull(name2, "name");
                                if (linkedHashMap.get(name2) != null) {
                                    Object obj = linkedHashMap.get(name2);
                                    if (obj == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    Method method3 = (Method) obj;
                                    Class<?>[] parameterTypes = method3.getParameterTypes();
                                    if (parameterTypes.length == 1) {
                                        try {
                                            if (Intrinsics.areEqual(parameterTypes[0], ReadableMapWrapper.class) && (prop instanceof ReadableMap)) {
                                                method3.invoke(createUI, LynxBehaviorFactoryKt.toReadableMapWrapper((ReadableMap) prop));
                                                return;
                                            }
                                            if (Intrinsics.areEqual(parameterTypes[0], ReadableArrayWrapper.class) && (prop instanceof ReadableArray)) {
                                                method3.invoke(createUI, LynxBehaviorFactoryKt.toReadableArrayWrapper((ReadableArray) prop));
                                                return;
                                            }
                                            Class<?> cls = parameterTypes[0];
                                            if (Intrinsics.areEqual(cls, String.class)) {
                                                if (!(prop instanceof String)) {
                                                    prop = null;
                                                }
                                                prop = (String) prop;
                                            } else if (Intrinsics.areEqual(cls, Integer.class)) {
                                                if (!(prop instanceof Number)) {
                                                    prop = null;
                                                }
                                                Number number = (Number) prop;
                                                if (number != null) {
                                                    prop = Integer.valueOf(number.intValue());
                                                }
                                                prop = null;
                                            } else if (Intrinsics.areEqual(cls, Boolean.TYPE)) {
                                                if (!(prop instanceof Boolean)) {
                                                    prop = null;
                                                }
                                                prop = (Boolean) prop;
                                            } else if (Intrinsics.areEqual(cls, Double.TYPE)) {
                                                if (!(prop instanceof Number)) {
                                                    prop = null;
                                                }
                                                Number number2 = (Number) prop;
                                                if (number2 != null) {
                                                    prop = Double.valueOf(number2.doubleValue());
                                                }
                                                prop = null;
                                            } else if (Intrinsics.areEqual(cls, Long.TYPE)) {
                                                if (!(prop instanceof Number)) {
                                                    prop = null;
                                                }
                                                Number number3 = (Number) prop;
                                                if (number3 != null) {
                                                    prop = Long.valueOf(number3.longValue());
                                                }
                                                prop = null;
                                            } else if (Intrinsics.areEqual(cls, Float.TYPE)) {
                                                if (!(prop instanceof Number)) {
                                                    prop = null;
                                                }
                                                Number number4 = (Number) prop;
                                                if (number4 != null) {
                                                    prop = Float.valueOf(number4.floatValue());
                                                }
                                                prop = null;
                                            } else if (Intrinsics.areEqual(cls, Integer.TYPE)) {
                                                if (!(prop instanceof Number)) {
                                                    prop = null;
                                                }
                                                Number number5 = (Number) prop;
                                                if (number5 != null) {
                                                    prop = Integer.valueOf(number5.intValue());
                                                }
                                                prop = null;
                                            } else {
                                                Log.d("bullet", "oops! invoke method got unsupported type: " + parameterTypes[0]);
                                            }
                                            method3.invoke(createUI, prop);
                                            return;
                                        } catch (Exception e) {
                                            Log.d("bullet", "oops! invoke method got wrong msg: " + Log.getStackTraceString(e));
                                            return;
                                        }
                                    }
                                    Log.d("bullet", "no way! setProperty passed wrong params");
                                }
                            }
                        });
                        final LynxUI<?> transform = LynxBehaviorFactoryKt.transform(createUI, context);
                        try {
                            if (!createUI.getMUIMethods().isEmpty()) {
                                Field declaredField = LynxUIMethodsExecutor.class.getDeclaredField("LYNX_UI_METHOD_INVOKER_MAP");
                                Log.d("bullet", "got LynxUIMethodInvokerMap field " + declaredField);
                                Intrinsics.checkExpressionValueIsNotNull(declaredField, "field");
                                declaredField.setAccessible(true);
                                Object obj = declaredField.get(null);
                                if (obj == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.HashMap<java.lang.Class<*>, com.lynx.tasm.behavior.utils.LynxUIMethodInvoker<*>> /* = java.util.HashMap<java.lang.Class<*>, com.lynx.tasm.behavior.utils.LynxUIMethodInvoker<*>> */");
                                }
                                ((HashMap) obj).put(transform.getClass(), new LynxUIMethodInvokerProxy() { // from class: com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactory$createLynxBehavior$1$createUI$2$1
                                    @Override // com.bytedance.ies.bullet.lynx_adapter_impl.LynxUIMethodInvokerProxy
                                    public void invoke(LynxUI<? extends View> ui, String methodName, ReadableMap params, Callback callback) {
                                        Intrinsics.checkParameterIsNotNull(methodName, "methodName");
                                        handleUIMethod(methodName, params, callback);
                                    }

                                    public final void handleUIMethod(String methodName, ReadableMap params, Callback callback) {
                                        Intrinsics.checkParameterIsNotNull(methodName, "methodName");
                                        Method method3 = LynxUIWrapper.this.getMUIMethods().get(methodName);
                                        if (method3 != null) {
                                            try {
                                                Class<?>[] parameterTypes = method3.getParameterTypes();
                                                Intrinsics.checkExpressionValueIsNotNull(parameterTypes, "paramTypes");
                                                if (parameterTypes.length == 0) {
                                                    method3.invoke(LynxUIWrapper.this, new Object[0]);
                                                } else if (parameterTypes.length == 1) {
                                                    Class<?> cls = parameterTypes[0];
                                                    if (Intrinsics.areEqual(cls, ReadableMap.class)) {
                                                        method3.invoke(LynxUIWrapper.this, params);
                                                    } else if (Intrinsics.areEqual(cls, Callback.class)) {
                                                        method3.invoke(LynxUIWrapper.this, callback);
                                                    } else if (Intrinsics.areEqual(cls, ReadableMapWrapper.class)) {
                                                        method3.invoke(LynxUIWrapper.this, LynxBehaviorFactoryKt.toReadableMapWrapper(params));
                                                    } else if (Intrinsics.areEqual(cls, LynxCallbackWrapper.class)) {
                                                        method3.invoke(LynxUIWrapper.this, LynxBehaviorFactoryKt.toLynxCallbackWrapper(callback));
                                                    } else {
                                                        Log.d("bullet", "unsupported param type: " + parameterTypes[0]);
                                                    }
                                                } else if (parameterTypes.length == 2) {
                                                    if (Intrinsics.areEqual(parameterTypes[0], ReadableMap.class) && Intrinsics.areEqual(parameterTypes[1], Callback.class)) {
                                                        method3.invoke(transform, params, callback);
                                                    } else if (Intrinsics.areEqual(parameterTypes[0], ReadableMapWrapper.class) && Intrinsics.areEqual(parameterTypes[1], LynxCallbackWrapper.class)) {
                                                        method3.invoke(transform, LynxBehaviorFactoryKt.toReadableMapWrapper(params), LynxBehaviorFactoryKt.toLynxCallbackWrapper(callback));
                                                    } else {
                                                        Log.d("bullet", "unsupported param type: " + parameterTypes[0]);
                                                    }
                                                } else {
                                                    LynxCallbackWrapper lynxCallbackWrapper = LynxBehaviorFactoryKt.toLynxCallbackWrapper(callback);
                                                    if (lynxCallbackWrapper != null) {
                                                        lynxCallbackWrapper.invoke(4);
                                                    }
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                });
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return transform;
                    }
                }
            }

            public LynxFlattenUI createFlattenUI(LynxContext context) {
                return LynxBehaviorFactoryKt.transform(LynxBehaviorWrapper.this.createFlattenUI((Context) context));
            }

            public BehaviorClassWarmer createClassWarmer() {
                return LynxBehaviorFactoryKt.transform(LynxBehaviorWrapper.this.createClassWarmer());
            }
        };
    }
}
