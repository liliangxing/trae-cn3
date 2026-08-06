package com.bytedance.common.component;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.push.instrumentation.InstrumentationListener;
import com.bytedance.push.instrumentation.PushInstrumentationManager;
import com.bytedance.push.utils.DoubleReflectUtils;
import com.bytedance.push.utils.Logger;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class CommonInstrumentation extends Instrumentation {
    public static final String KEY_INSTRUMENTATION_TYPE = "instrumentation_type";
    public static final String KEY_INSTRUMENTATION_TYPE_ALLIANCE = "instrumentation_type_alliance";
    public static final String KEY_INSTRUMENTATION_TYPE_KA = "instrumentation_type_ka";
    private final String TAG = "BaseInstrumentation";
    private Bundle mArguments;

    @Override // android.app.Instrumentation
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mArguments = bundle;
        Log.d("BaseInstrumentation", "CommonInstrumentation#onCreate,init mArguments:" + this.mArguments);
    }

    @Override // android.app.Instrumentation
    public Application newApplication(ClassLoader classLoader, String str, Context context) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Log.d("BaseInstrumentation", "CommonInstrumentation#newApplication");
        cleanInstrumentationForSafety(this);
        return super.newApplication(classLoader, str, context);
    }

    private void cleanInstrumentationForSafety(Instrumentation instrumentation) {
        cleanOneField("mWatcher", instrumentation);
        cleanOneField("mUiAutomationConnection", instrumentation);
    }

    private void cleanOneField(String str, Instrumentation instrumentation) {
        try {
            Field field = DoubleReflectUtils.getField(Instrumentation.class, str);
            field.setAccessible(true);
            if (field.get(instrumentation) != null) {
                Logger.e("BaseInstrumentation", "Field " + str + " was set, do clean!");
                field.set(this, null);
            }
            Logger.i("BaseInstrumentation", "Clean field=" + str);
        } catch (Throwable th) {
            Logger.e("BaseInstrumentation", "Failed to get object of " + str, th);
        }
    }

    @Override // android.app.Instrumentation
    public void callApplicationOnCreate(Application application) {
        super.callApplicationOnCreate(application);
        Bundle bundle = this.mArguments;
        if (bundle == null) {
            Logger.e("BaseInstrumentation", "arguments is null");
            return;
        }
        String string = bundle.getString(KEY_INSTRUMENTATION_TYPE);
        Log.d("BaseInstrumentation", "CommonInstrumentation#callApplicationOnCreate,instrumentationType is " + string);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        InstrumentationListener instrumentationListener = PushInstrumentationManager.getInstance().getInstrumentationListener(string);
        Log.d("BaseInstrumentation", "CommonInstrumentation#callApplicationOnCreate,instrumentationListener is " + instrumentationListener);
        if (instrumentationListener != null) {
            instrumentationListener.onInstrumentationCreate(getContext(), this.mArguments);
        }
    }
}
