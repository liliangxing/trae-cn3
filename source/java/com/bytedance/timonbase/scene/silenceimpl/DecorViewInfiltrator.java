package com.bytedance.timonbase.scene.silenceimpl;

import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.scene.ScenesDetector;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DecorViewInfiltrator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/timonbase/scene/silenceimpl/DecorViewInfiltrator;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "classDecorView", "Ljava/lang/Class;", "classDecorViewAndroid6", "classPopupDecorView", "infiltrateFor", "", "objectDecorView", "useTouchListenerWrapper", "decorViewObject", "useWindowCallbackWrapper", "useWindowCallbackWrapperAndroid6", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class DecorViewInfiltrator {
    public static final DecorViewInfiltrator INSTANCE = new DecorViewInfiltrator();
    private static final String TAG = "DecorViewInfiltrator";
    private static Class<?> classDecorView;
    private static Class<?> classDecorViewAndroid6;
    private static Class<?> classPopupDecorView;

    static {
        try {
            classDecorView = Class.forName("com.android.internal.policy.DecorView");
            classPopupDecorView = Class.forName("android.widget.PopupWindow$PopupDecorView");
        } catch (ClassNotFoundException e) {
            TMLogger tMLogger = TMLogger.INSTANCE;
            String TAG2 = TAG;
            Intrinsics.checkExpressionValueIsNotNull(TAG2, "TAG");
            tMLogger.e(TAG2, e.getMessage(), e.getCause());
            ScenesDetector.INSTANCE.infiltratorErrorHappen("DecorViewInfiltrator", -5);
        }
    }

    private DecorViewInfiltrator() {
    }

    private final void useWindowCallbackWrapper(Object decorViewObject) {
        Class<?> cls = classDecorView;
        if (cls == null) {
            Intrinsics.throwNpe();
        }
        Field mWindowField = cls.getDeclaredField("mWindow");
        Intrinsics.checkExpressionValueIsNotNull(mWindowField, "mWindowField");
        mWindowField.setAccessible(true);
        Object obj = mWindowField.get(decorViewObject);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.Window");
        }
        Window window = (Window) obj;
        Window.Callback callback = window.getCallback();
        if (window.getCallback() == null) {
            ScenesDetector.INSTANCE.infiltratorErrorHappen("Window.Callback is null, forbidSilence invoke", -6);
        } else {
            Intrinsics.checkExpressionValueIsNotNull(callback, "callback");
            window.setCallback(new WindowCallbackWrapper(callback));
        }
    }

    private final void useWindowCallbackWrapperAndroid6(Object decorViewObject) {
        Field declaredField;
        Class<?> cls = classDecorViewAndroid6;
        if (cls == null || (declaredField = cls.getDeclaredField("this$0")) == null) {
            throw new NoSuchFieldException("can't find PhoneWindow");
        }
        declaredField.setAccessible(true);
        Object obj = declaredField.get(decorViewObject);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.Window");
        }
        Window window = (Window) obj;
        Window.Callback callback = window.getCallback();
        if (window.getCallback() == null) {
            ScenesDetector.INSTANCE.infiltratorErrorHappen("Window.Callback is null, forbidSilence invoke", -6);
        } else {
            Intrinsics.checkExpressionValueIsNotNull(callback, "callback");
            window.setCallback(new WindowCallbackWrapper(callback));
        }
    }

    private final void useTouchListenerWrapper(Object decorViewObject) {
        Class<?> cls = classPopupDecorView;
        if (cls == null) {
            Intrinsics.throwNpe();
        }
        Field declaredField = cls.getDeclaredField("this$0");
        Intrinsics.checkExpressionValueIsNotNull(declaredField, "`this$0Field`");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(decorViewObject);
        Field mTouchInterceptorField = PopupWindow.class.getDeclaredField("mTouchInterceptor");
        Intrinsics.checkExpressionValueIsNotNull(mTouchInterceptorField, "mTouchInterceptorField");
        mTouchInterceptorField.setAccessible(true);
        mTouchInterceptorField.set(obj, new OnTouchListenerWrapper((View.OnTouchListener) mTouchInterceptorField.get(obj)));
    }

    public final void infiltrateFor(Object objectDecorView) {
        Intrinsics.checkParameterIsNotNull(objectDecorView, "objectDecorView");
        try {
            Class<?> cls = classDecorView;
            if (cls != null && cls.isInstance(objectDecorView)) {
                useWindowCallbackWrapper(objectDecorView);
            } else {
                Class<?> cls2 = classDecorViewAndroid6;
                if (cls2 != null && cls2.isInstance(objectDecorView)) {
                    useWindowCallbackWrapperAndroid6(objectDecorView);
                } else {
                    Class<?> cls3 = classPopupDecorView;
                    if (cls3 != null && cls3.isInstance(objectDecorView)) {
                        useTouchListenerWrapper(objectDecorView);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            TMLogger tMLogger = TMLogger.INSTANCE;
            String TAG2 = TAG;
            Intrinsics.checkExpressionValueIsNotNull(TAG2, "TAG");
            tMLogger.e(TAG2, e.getMessage(), e.getCause());
            ScenesDetector.INSTANCE.infiltratorErrorHappen("infiltrateFor: illegalAccess", -3);
        } catch (NoSuchFieldException e2) {
            TMLogger tMLogger2 = TMLogger.INSTANCE;
            String TAG3 = TAG;
            Intrinsics.checkExpressionValueIsNotNull(TAG3, "TAG");
            tMLogger2.e(TAG3, e2.getMessage(), e2.getCause());
            ScenesDetector.INSTANCE.infiltratorErrorHappen("infiltrateFor: noSuchField", -4);
        }
    }
}
