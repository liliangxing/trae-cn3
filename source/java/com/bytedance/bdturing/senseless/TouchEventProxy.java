package com.bytedance.bdturing.senseless;

import android.view.MotionEvent;
import android.view.Window;
import com.bytedance.webx.core.webview.WebViewContainer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class TouchEventProxy implements InvocationHandler {
    private Window.Callback mOriginalCallback;

    public TouchEventProxy(Window.Callback callback) {
        this.mOriginalCallback = callback;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            if (WebViewContainer.EVENT_dispatchTouchEvent.equals(method.getName()) && objArr != null && objArr.length > 0) {
                Object obj2 = objArr[0];
                if (obj2 instanceof MotionEvent) {
                    PageTracer.getInstance().onDispatchTouchEvent((MotionEvent) obj2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return method.invoke(this.mOriginalCallback, objArr);
    }
}
