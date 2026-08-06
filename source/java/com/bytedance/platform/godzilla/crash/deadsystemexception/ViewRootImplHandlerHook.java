package com.bytedance.platform.godzilla.crash.deadsystemexception;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.bytedance.platform.godzilla.common.DoubleReflectHelper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.utils.FieldUtils;
import java.lang.reflect.Field;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ViewRootImplHandlerHook implements Application.ActivityLifecycleCallbacks {
    private Field mAttachInfoField;
    private Field mHandlerField;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public void onHook(Application application) {
        try {
            Field field = DoubleReflectHelper.getField(View.class, "mAttachInfo");
            this.mAttachInfoField = field;
            if (field != null) {
                field.setAccessible(true);
                application.registerActivityLifecycleCallbacks(this);
                Logger.m197e("ViewRootImplHandlerHook", "Hook success ");
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Logger.m197e("ViewRootImplHandlerHook", "onActivityStarted！");
        if (this.mAttachInfoField == null) {
            return;
        }
        try {
            final View decorView = activity.getWindow().getDecorView();
            decorView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.platform.godzilla.crash.deadsystemexception.ViewRootImplHandlerHook.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    try {
                        Object obj = ViewRootImplHandlerHook.this.mAttachInfoField.get(decorView);
                        if (ViewRootImplHandlerHook.this.mHandlerField == null) {
                            ViewRootImplHandlerHook.this.mHandlerField = FieldUtils.getField(obj.getClass(), "mHandler");
                        }
                        Handler handler = (Handler) ViewRootImplHandlerHook.this.mHandlerField.get(obj);
                        Field field = FieldUtils.getField(Handler.class, "mCallback");
                        Handler.Callback callback = (Handler.Callback) field.get(handler);
                        if (callback != null && callback.getClass().getName().equals(PreventHandlerCallback.class.getName())) {
                            Logger.m197e("ViewRootImplHandlerHook", "Already replaced，not need to do it.");
                        } else {
                            field.set(handler, new PreventHandlerCallback(handler));
                            Logger.m197e("ViewRootImplHandlerHook", "Prevent handler in ViewRootImpl successful.");
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class PreventHandlerCallback implements Handler.Callback {
        private Handler mTargetHandler;

        PreventHandlerCallback(Handler handler) {
            this.mTargetHandler = handler;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                Logger.m197e("ViewRootImplHandlerHook", "Handle message " + message);
                this.mTargetHandler.handleMessage(message);
                return true;
            } catch (Throwable unused) {
                return true;
            }
        }
    }
}
