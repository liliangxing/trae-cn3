package com.bytedance.apm.perf.memory.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.EventData;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.samplers.SamplerHelper;
import java.lang.reflect.Field;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ActivityLeakFixer {
    public static final String ACTIVITY_LEAK_EVENT = "activity_leak_event";
    private static final String TAG = "ActivityLeakFixer";

    public static void fixInputMethodManagerLeak(Context context) {
        InputMethodManager inputMethodManager;
        long currentTimeMillis = System.currentTimeMillis();
        if (context != null && (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) != null) {
            String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
            for (int i = 0; i < 3; i++) {
                try {
                    Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(inputMethodManager);
                    if (obj instanceof View) {
                        View view = (View) obj;
                        if (view.getContext() == context) {
                            declaredField.set(inputMethodManager, null);
                        } else {
                            if (!ApmContext.isDebugMode()) {
                                break;
                            }
                            Logger.m88i(TAG, "fixInputMethodManagerLeak break, context is not suitable, get_context=" + view.getContext() + " dest_context=" + context);
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (Throwable th) {
                    if (ApmContext.isDebugMode()) {
                        Logger.m87e(TAG, "failed to fix InputMethodManagerLeak, " + th.toString());
                    }
                }
            }
        }
        if (ApmContext.isDebugMode()) {
            Logger.m88i(TAG, "fixInputMethodManagerLeak done, cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
        }
    }

    public static void uploadLeakEvent(String str) {
        boolean serviceSwitch = SamplerHelper.getServiceSwitch(ACTIVITY_LEAK_EVENT);
        if (ApmContext.isDebugMode()) {
            Logger.m88i(TAG, "activity_leak_event : " + serviceSwitch);
        }
        if (!serviceSwitch || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, 1);
            CommonDataPipeline.getInstance().handle(new EventData(ACTIVITY_LEAK_EVENT, 0, null, jSONObject, null, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unbindDrawables(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        if (activity != null && activity.getWindow() != null && activity.getWindow().peekDecorView() != null) {
            try {
                if (!activity.isDestroyed()) {
                    return;
                }
                if (activity.getWindow().getContext() == activity) {
                    View rootView = activity.getWindow().peekDecorView().getRootView();
                    ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
                    if (viewGroup.getChildCount() > 0 && viewGroup.getChildAt(0).getContext() == activity) {
                        unbindDrawablesAndRecycleInView(rootView, activity);
                    }
                }
            } catch (Throwable th) {
                if (ApmContext.isDebugMode()) {
                    Logger.m90w(TAG, "caught unexpected exception when unbind drawables.", th.getMessage());
                }
            }
        } else if (ApmContext.isDebugMode()) {
            Logger.m88i(TAG, "unbindDrawables, ui or ui's window is null, skip rest works.");
        }
        if (ApmContext.isDebugMode()) {
            Logger.m88i(TAG, "unbindDrawables done, cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
        }
    }

    private static void unbindDrawablesAndRecycleInView(View view, Activity activity) {
        if (view == null || view.getContext() == null) {
            return;
        }
        if (view.getContext() == activity) {
            recycleBackground(view);
            if (view instanceof ImageView) {
                recycleImageView((ImageView) view);
            }
            if (view instanceof TextView) {
                recycleTextViewCompound((TextView) view);
            }
        }
        if (view instanceof ViewGroup) {
            recycleViewGroupByView((ViewGroup) view, activity);
        }
    }

    private static void recycleBackground(View view) {
        if (view.getBackground() != null) {
            try {
                view.getBackground().setCallback(null);
                view.setBackgroundDrawable(null);
            } catch (Throwable unused) {
            }
        }
    }

    private static void recycleImageView(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setCallback(null);
        }
        imageView.setImageDrawable(null);
    }

    private static void recycleTextViewCompound(TextView textView) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setCallback(null);
            }
        }
        textView.setCompoundDrawables(null, null, null, null);
    }

    private static void recycleViewGroupByView(ViewGroup viewGroup, Activity activity) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            unbindDrawablesAndRecycleInView(viewGroup.getChildAt(i), activity);
        }
    }
}
