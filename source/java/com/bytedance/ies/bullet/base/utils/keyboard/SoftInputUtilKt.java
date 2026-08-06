package com.bytedance.ies.bullet.base.utils.keyboard;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SoftInputUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0003\u001a\n\u0010\t\u001a\u00020\u0007*\u00020\b¨\u0006\n"}, d2 = {"getSoftInputHeight", "", "Landroid/app/Activity;", "Landroidx/fragment/app/Fragment;", "hasSoftInput", "", "hideSoftInput", "", "Landroid/widget/EditText;", "showSoftInput", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SoftInputUtilKt {
    public static final void showSoftInput(final EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        EditText editText2 = editText;
        if (SoftInputKt.isSystemInsetsAnimationSupport(editText2)) {
            WindowInsetsControllerCompat windowInsetsController = ViewCompat.getWindowInsetsController(editText2);
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsetsCompat.Type.ime());
                return;
            }
            return;
        }
        editText.postDelayed(new Runnable() { // from class: com.bytedance.ies.bullet.base.utils.keyboard.SoftInputUtilKt$showSoftInput$1
            @Override // java.lang.Runnable
            public final void run() {
                Object systemService = editText.getContext().getSystemService("input_method");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService).showSoftInput(editText, 0);
            }
        }, 300L);
    }

    public static final void hideSoftInput(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            Object systemService = activity.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        } else {
            WindowInsetsControllerCompat windowInsetsController = ViewCompat.getWindowInsetsController(activity.getWindow().getDecorView());
            if (windowInsetsController != null) {
                windowInsetsController.hide(WindowInsetsCompat.Type.ime());
            }
        }
    }

    public static final void hideSoftInput(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Activity requireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        hideSoftInput(requireActivity);
    }

    public static final void hideSoftInput(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        WindowInsetsControllerCompat windowInsetsController = ViewCompat.getWindowInsetsController(editText);
        if (windowInsetsController != null) {
            windowInsetsController.hide(WindowInsetsCompat.Type.ime());
        }
    }

    public static final boolean hasSoftInput(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(activity.getWindow().getDecorView());
        if (rootWindowInsets != null) {
            return rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime());
        }
        return false;
    }

    public static final boolean hasSoftInput(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Activity requireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return hasSoftInput(requireActivity);
    }

    public static final int getSoftInputHeight(Activity activity) {
        Insets insets;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(activity.getWindow().getDecorView());
        Integer valueOf = (rootWindowInsets == null || (insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.ime())) == null) ? null : Integer.valueOf(insets.bottom);
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }

    public static final int getSoftInputHeight(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Activity requireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return getSoftInputHeight(requireActivity);
    }
}
