package com.bytedance.push.proxy;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import com.bytedance.push.utils.DoubleReflectUtils;
import com.bytedance.push.utils.Logger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class InstrumentationProxy extends Instrumentation {
    public static final String METHOD_CALL_ACTIVITY_ON_PAUSE = "callActivityOnPause";
    public static final String METHOD_CALL_ACTIVITY_ON_RESUME = "callActivityOnResume";
    public static final String METHOD_CALL_ACTIVITY_ON_STOP = "callActivityOnStop";
    private final String TAG = "InstrumentationProxy";
    private Method mCallActivityOnPause;
    private Method mCallActivityOnResume;
    private Method mCallActivityOnStop;
    private final InvocationHandler mInvocationHandler;
    private Instrumentation mOriginInstrumentation;

    public Method getCallActivityOnPause() {
        return this.mCallActivityOnPause;
    }

    public InstrumentationProxy(InvocationHandler invocationHandler) {
        this.mInvocationHandler = invocationHandler;
        try {
            this.mCallActivityOnPause = DoubleReflectUtils.getMethod(Instrumentation.class, METHOD_CALL_ACTIVITY_ON_PAUSE, Activity.class);
            this.mCallActivityOnResume = DoubleReflectUtils.getMethod(Instrumentation.class, METHOD_CALL_ACTIVITY_ON_RESUME, Activity.class);
            this.mCallActivityOnStop = DoubleReflectUtils.getMethod(Instrumentation.class, METHOD_CALL_ACTIVITY_ON_STOP, Activity.class);
        } catch (Throwable th) {
            Logger.e("InstrumentationProxy", "error when init method ", th);
        }
    }

    public InstrumentationProxy setOriginInstrumentation(Instrumentation instrumentation) {
        this.mOriginInstrumentation = instrumentation;
        return this;
    }

    @Override // android.app.Instrumentation
    public void callActivityOnPause(Activity activity) {
        try {
            this.mInvocationHandler.invoke(this, this.mCallActivityOnPause, new Object[]{activity});
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.e("InstrumentationProxy", "[callActivityOnPause]exception", th);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnResume(Activity activity) {
        try {
            this.mInvocationHandler.invoke(this, this.mCallActivityOnResume, new Object[]{activity});
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.e("InstrumentationProxy", "[callActivityOnResume]exception", th);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnStop(Activity activity) {
        try {
            this.mInvocationHandler.invoke(this, this.mCallActivityOnStop, new Object[]{activity});
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.e("InstrumentationProxy", "[callActivityOnStop]exception", th);
        }
    }

    @Override // android.app.Instrumentation
    public boolean onException(Object obj, Throwable th) {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            return instrumentation.onException(obj, th);
        }
        return super.onException(obj, th);
    }

    @Override // android.app.Instrumentation
    public void callApplicationOnCreate(Application application) {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            instrumentation.callApplicationOnCreate(application);
        } else {
            super.callApplicationOnCreate(application);
        }
    }

    @Override // android.app.Instrumentation
    public Application newApplication(ClassLoader classLoader, String str, Context context) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            return instrumentation.newApplication(classLoader, str, context);
        }
        return super.newApplication(classLoader, str, context);
    }

    @Override // android.app.Instrumentation
    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            return instrumentation.newActivity(classLoader, str, intent);
        }
        return super.newActivity(classLoader, str, intent);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnNewIntent(Activity activity, Intent intent) {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            instrumentation.callActivityOnNewIntent(activity, intent);
        } else {
            super.callActivityOnNewIntent(activity, intent);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            instrumentation.callActivityOnCreate(activity, bundle);
        } else {
            super.callActivityOnCreate(activity, bundle);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnCreate(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            instrumentation.callActivityOnCreate(activity, bundle, persistableBundle);
        } else {
            super.callActivityOnCreate(activity, bundle, persistableBundle);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnPostCreate(Activity activity, Bundle bundle) {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            instrumentation.callActivityOnPostCreate(activity, bundle);
        } else {
            super.callActivityOnPostCreate(activity, bundle);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnStart(Activity activity) {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            instrumentation.callActivityOnStart(activity);
        } else {
            super.callActivityOnStart(activity);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnRestart(Activity activity) {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            instrumentation.callActivityOnRestart(activity);
        } else {
            super.callActivityOnRestart(activity);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnSaveInstanceState(Activity activity, Bundle bundle) {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            instrumentation.callActivityOnSaveInstanceState(activity, bundle);
        } else {
            super.callActivityOnSaveInstanceState(activity, bundle);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnSaveInstanceState(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            instrumentation.callActivityOnSaveInstanceState(activity, bundle, persistableBundle);
        } else {
            super.callActivityOnSaveInstanceState(activity, bundle, persistableBundle);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnRestoreInstanceState(Activity activity, Bundle bundle) {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            instrumentation.callActivityOnRestoreInstanceState(activity, bundle);
        } else {
            super.callActivityOnRestoreInstanceState(activity, bundle);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnRestoreInstanceState(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            instrumentation.callActivityOnRestoreInstanceState(activity, bundle, persistableBundle);
        } else {
            super.callActivityOnRestoreInstanceState(activity, bundle, persistableBundle);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnDestroy(Activity activity) {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            instrumentation.callActivityOnDestroy(activity);
        } else {
            super.callActivityOnDestroy(activity);
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnUserLeaving(Activity activity) {
        Instrumentation instrumentation = this.mOriginInstrumentation;
        if (instrumentation != null) {
            instrumentation.callActivityOnUserLeaving(activity);
        } else {
            super.callActivityOnUserLeaving(activity);
        }
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i) {
        if (this.mOriginInstrumentation == null) {
            return null;
        }
        try {
            DoubleReflectUtils.getAccessibleMethod(Instrumentation.class, "execStartActivity", Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE).invoke(this.mOriginInstrumentation, context, iBinder, iBinder2, activity, intent, Integer.valueOf(i));
            return null;
        } catch (Exception e) {
            Logger.e("InstrumentationProxy", "[execStartActivity1]exception:" + e.getLocalizedMessage());
            return null;
        }
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Fragment fragment, Intent intent, int i) {
        if (this.mOriginInstrumentation == null) {
            return null;
        }
        try {
            DoubleReflectUtils.getAccessibleMethod(Instrumentation.class, "execStartActivity", Context.class, IBinder.class, IBinder.class, Fragment.class, Intent.class, Integer.TYPE).invoke(this.mOriginInstrumentation, context, iBinder, iBinder2, fragment, intent, Integer.valueOf(i));
            return null;
        } catch (Exception e) {
            Logger.e("InstrumentationProxy", "[execStartActivity2]exception:" + e.getLocalizedMessage());
            return null;
        }
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i, Bundle bundle) {
        if (this.mOriginInstrumentation == null) {
            return null;
        }
        try {
            DoubleReflectUtils.getAccessibleMethod(Instrumentation.class, "execStartActivity", Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE, Bundle.class).invoke(this.mOriginInstrumentation, context, iBinder, iBinder2, activity, intent, Integer.valueOf(i), bundle);
            return null;
        } catch (Exception e) {
            Logger.e("InstrumentationProxy", "[execStartActivity3]exception:" + e.getLocalizedMessage());
            return null;
        }
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (this.mOriginInstrumentation == null) {
            return null;
        }
        try {
            DoubleReflectUtils.getAccessibleMethod(Instrumentation.class, "execStartActivity", Context.class, IBinder.class, IBinder.class, Fragment.class, Intent.class, Integer.TYPE, Bundle.class).invoke(this.mOriginInstrumentation, context, iBinder, iBinder2, fragment, intent, Integer.valueOf(i), bundle);
            return null;
        } catch (Exception e) {
            Logger.e("InstrumentationProxy", "[execStartActivity4]exception:" + e.getLocalizedMessage());
            return null;
        }
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, String str, Intent intent, int i, Bundle bundle) {
        if (this.mOriginInstrumentation == null) {
            return null;
        }
        try {
            DoubleReflectUtils.getAccessibleMethod(Instrumentation.class, "execStartActivity", Context.class, IBinder.class, IBinder.class, String.class, Intent.class, Integer.TYPE, Bundle.class).invoke(this.mOriginInstrumentation, context, iBinder, iBinder2, str, intent, Integer.valueOf(i), bundle);
            return null;
        } catch (Exception e) {
            Logger.e("InstrumentationProxy", "[execStartActivity5]exception:" + e.getLocalizedMessage());
            return null;
        }
    }

    public void execStartActivities(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent[] intentArr, Bundle bundle) {
        if (this.mOriginInstrumentation != null) {
            try {
                DoubleReflectUtils.getAccessibleMethod(Instrumentation.class, "execStartActivities", Context.class, IBinder.class, IBinder.class, Activity.class, Intent[].class, Bundle.class).invoke(this.mOriginInstrumentation, context, iBinder, iBinder2, activity, intentArr, bundle);
            } catch (Exception e) {
                Logger.e("InstrumentationProxy", "[execStartActivities]exception:" + e.getLocalizedMessage());
            }
        }
    }
}
