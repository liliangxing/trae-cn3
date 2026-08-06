package com.bytedance.apm.agent.wrapper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class TTToastWrapper {

    /* loaded from: classes3.dex */
    public @interface Duration {
    }

    public static Toast makeText(Context context, CharSequence charSequence, int i) {
        Toast makeText = Toast.makeText(context, ((Object) charSequence) + "__wrapper", i);
        initToastHook(makeText);
        return makeText;
    }

    public static Toast makeText(Context context, int i, int i2) throws Resources.NotFoundException {
        return makeText(context, ((Object) context.getResources().getText(i)) + "__wrapper", i2);
    }

    public static boolean initToastHook(Toast toast) {
        if (Build.VERSION.SDK_INT != 24 && Build.VERSION.SDK_INT != 25) {
            return true;
        }
        reflectAndoridNTNHandler(toast);
        return true;
    }

    private static boolean reflectAndoridNTNHandler(Toast toast) {
        Field declaredField;
        Field declaredField2;
        try {
            if (toast.getClass().getSuperclass() != null && Toast.class.getName().equals(toast.getClass().getSuperclass().getName())) {
                declaredField = toast.getClass().getSuperclass().getDeclaredField("mTN");
            } else {
                declaredField = toast.getClass().getDeclaredField("mTN");
            }
            if (declaredField == null) {
                return false;
            }
            declaredField.setAccessible(true);
            Object obj = declaredField.get(toast);
            if (obj == null || (declaredField2 = obj.getClass().getDeclaredField("mHandler")) == null) {
                return false;
            }
            declaredField2.setAccessible(true);
            declaredField2.set(obj, new ProxyTNHandler(obj));
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class ProxyTNHandler extends Handler {
        private Method handleHideMethod;
        private Method handleShowMethod;
        private Object tnObject;

        ProxyTNHandler(Object obj) {
            this.tnObject = obj;
            try {
                Method declaredMethod = obj.getClass().getDeclaredMethod("handleShow", IBinder.class);
                this.handleShowMethod = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = obj.getClass().getDeclaredMethod("handleHide", new Class[0]);
                this.handleHideMethod = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Method method;
            int i = message.what;
            if (i == 0) {
                IBinder iBinder = (IBinder) message.obj;
                Method method2 = this.handleShowMethod;
                if (method2 != null) {
                    try {
                        method2.invoke(this.tnObject, iBinder);
                    } catch (WindowManager.BadTokenException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    } catch (InvocationTargetException e3) {
                        e3.printStackTrace();
                    }
                }
            } else if (i == 1) {
                Method method3 = this.handleHideMethod;
                if (method3 != null) {
                    try {
                        method3.invoke(this.tnObject, new Object[0]);
                    } catch (IllegalAccessException e4) {
                        e4.printStackTrace();
                    } catch (InvocationTargetException e5) {
                        e5.printStackTrace();
                    }
                }
            } else if (i == 2 && (method = this.handleHideMethod) != null) {
                try {
                    method.invoke(this.tnObject, new Object[0]);
                } catch (IllegalAccessException e6) {
                    e6.printStackTrace();
                } catch (InvocationTargetException e7) {
                    e7.printStackTrace();
                }
            }
            super.handleMessage(message);
        }
    }
}
