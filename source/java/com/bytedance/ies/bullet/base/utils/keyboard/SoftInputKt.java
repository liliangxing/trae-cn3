package com.bytedance.ies.bullet.base.utils.keyboard;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.arch.core.util.Function;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: SoftInput.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\\\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0007\u001ac\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u000e2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u000f\u001a\\\u0010\u0003\u001a\u00020\u0004*\u00020\u00102\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0007\u001a\\\u0010\u0003\u001a\u00020\u0004*\u00020\u00112\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0007\u001a\\\u0010\u0003\u001a\u00020\u0004*\u00020\u00122\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0007\u001a\\\u0010\u0003\u001a\u00020\u0004*\u00020\u00132\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0007\u001aR\u0010\u0014\u001a\u00020\u0004*\u00020\u00102\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0002¨\u0006\u0015"}, d2 = {"isSystemInsetsAnimationSupport", "", "Landroid/view/View;", "setWindowSoftInput", "", "Landroid/app/Activity;", "float", "transition", "editText", "margin", "", "setPadding", "onChanged", "Lkotlin/Function1;", "Landroid/app/Dialog;", "(Landroid/app/Dialog;Landroid/view/View;Landroid/view/View;Landroid/view/View;IZLkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "Landroid/view/Window;", "Landroidx/fragment/app/DialogFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "setWindowSoftInputCompatible", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SoftInputKt {
    public static final Unit setWindowSoftInput(Dialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "<this>");
        return setWindowSoftInput$default(dialog, (View) null, (View) null, (View) null, 0, false, (Function1) null, 63, (Object) null);
    }

    public static final Unit setWindowSoftInput(Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "<this>");
        return setWindowSoftInput$default(dialog, view, (View) null, (View) null, 0, false, (Function1) null, 62, (Object) null);
    }

    public static final Unit setWindowSoftInput(Dialog dialog, View view, View view2) {
        Intrinsics.checkNotNullParameter(dialog, "<this>");
        return setWindowSoftInput$default(dialog, view, view2, (View) null, 0, false, (Function1) null, 60, (Object) null);
    }

    public static final Unit setWindowSoftInput(Dialog dialog, View view, View view2, View view3) {
        Intrinsics.checkNotNullParameter(dialog, "<this>");
        return setWindowSoftInput$default(dialog, view, view2, view3, 0, false, (Function1) null, 56, (Object) null);
    }

    public static final Unit setWindowSoftInput(Dialog dialog, View view, View view2, View view3, int i) {
        Intrinsics.checkNotNullParameter(dialog, "<this>");
        return setWindowSoftInput$default(dialog, view, view2, view3, i, false, (Function1) null, 48, (Object) null);
    }

    public static final Unit setWindowSoftInput(Dialog dialog, View view, View view2, View view3, int i, boolean z) {
        Intrinsics.checkNotNullParameter(dialog, "<this>");
        return setWindowSoftInput$default(dialog, view, view2, view3, i, z, (Function1) null, 32, (Object) null);
    }

    public static final void setWindowSoftInput(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        setWindowSoftInput$default(activity, (View) null, (View) null, (View) null, 0, false, (Function1) null, 63, (Object) null);
    }

    public static final void setWindowSoftInput(Activity activity, View view) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        setWindowSoftInput$default(activity, view, (View) null, (View) null, 0, false, (Function1) null, 62, (Object) null);
    }

    public static final void setWindowSoftInput(Activity activity, View view, View view2) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        setWindowSoftInput$default(activity, view, view2, (View) null, 0, false, (Function1) null, 60, (Object) null);
    }

    public static final void setWindowSoftInput(Activity activity, View view, View view2, View view3) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        setWindowSoftInput$default(activity, view, view2, view3, 0, false, (Function1) null, 56, (Object) null);
    }

    public static final void setWindowSoftInput(Activity activity, View view, View view2, View view3, int i) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        setWindowSoftInput$default(activity, view, view2, view3, i, false, (Function1) null, 48, (Object) null);
    }

    public static final void setWindowSoftInput(Activity activity, View view, View view2, View view3, int i, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        setWindowSoftInput$default(activity, view, view2, view3, i, z, (Function1) null, 32, (Object) null);
    }

    public static final void setWindowSoftInput(Window window) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        setWindowSoftInput$default(window, (View) null, (View) null, (View) null, 0, false, (Function1) null, 63, (Object) null);
    }

    public static final void setWindowSoftInput(Window window, View view) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        setWindowSoftInput$default(window, view, (View) null, (View) null, 0, false, (Function1) null, 62, (Object) null);
    }

    public static final void setWindowSoftInput(Window window, View view, View view2) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        setWindowSoftInput$default(window, view, view2, (View) null, 0, false, (Function1) null, 60, (Object) null);
    }

    public static final void setWindowSoftInput(Window window, View view, View view2, View view3) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        setWindowSoftInput$default(window, view, view2, view3, 0, false, (Function1) null, 56, (Object) null);
    }

    public static final void setWindowSoftInput(Window window, View view, View view2, View view3, int i) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        setWindowSoftInput$default(window, view, view2, view3, i, false, (Function1) null, 48, (Object) null);
    }

    public static final void setWindowSoftInput(Window window, View view, View view2, View view3, int i, boolean z) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        setWindowSoftInput$default(window, view, view2, view3, i, z, (Function1) null, 32, (Object) null);
    }

    public static final void setWindowSoftInput(DialogFragment dialogFragment) {
        Intrinsics.checkNotNullParameter(dialogFragment, "<this>");
        setWindowSoftInput$default(dialogFragment, (View) null, (View) null, (View) null, 0, false, (Function1) null, 63, (Object) null);
    }

    public static final void setWindowSoftInput(DialogFragment dialogFragment, View view) {
        Intrinsics.checkNotNullParameter(dialogFragment, "<this>");
        setWindowSoftInput$default(dialogFragment, view, (View) null, (View) null, 0, false, (Function1) null, 62, (Object) null);
    }

    public static final void setWindowSoftInput(DialogFragment dialogFragment, View view, View view2) {
        Intrinsics.checkNotNullParameter(dialogFragment, "<this>");
        setWindowSoftInput$default(dialogFragment, view, view2, (View) null, 0, false, (Function1) null, 60, (Object) null);
    }

    public static final void setWindowSoftInput(DialogFragment dialogFragment, View view, View view2, View view3) {
        Intrinsics.checkNotNullParameter(dialogFragment, "<this>");
        setWindowSoftInput$default(dialogFragment, view, view2, view3, 0, false, (Function1) null, 56, (Object) null);
    }

    public static final void setWindowSoftInput(DialogFragment dialogFragment, View view, View view2, View view3, int i) {
        Intrinsics.checkNotNullParameter(dialogFragment, "<this>");
        setWindowSoftInput$default(dialogFragment, view, view2, view3, i, false, (Function1) null, 48, (Object) null);
    }

    public static final void setWindowSoftInput(DialogFragment dialogFragment, View view, View view2, View view3, int i, boolean z) {
        Intrinsics.checkNotNullParameter(dialogFragment, "<this>");
        setWindowSoftInput$default(dialogFragment, view, view2, view3, i, z, (Function1) null, 32, (Object) null);
    }

    public static final void setWindowSoftInput(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        setWindowSoftInput$default(fragment, (View) null, (View) null, (View) null, 0, false, (Function1) null, 63, (Object) null);
    }

    public static final void setWindowSoftInput(Fragment fragment, View view) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        setWindowSoftInput$default(fragment, view, (View) null, (View) null, 0, false, (Function1) null, 62, (Object) null);
    }

    public static final void setWindowSoftInput(Fragment fragment, View view, View view2) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        setWindowSoftInput$default(fragment, view, view2, (View) null, 0, false, (Function1) null, 60, (Object) null);
    }

    public static final void setWindowSoftInput(Fragment fragment, View view, View view2, View view3) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        setWindowSoftInput$default(fragment, view, view2, view3, 0, false, (Function1) null, 56, (Object) null);
    }

    public static final void setWindowSoftInput(Fragment fragment, View view, View view2, View view3, int i) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        setWindowSoftInput$default(fragment, view, view2, view3, i, false, (Function1) null, 48, (Object) null);
    }

    public static final void setWindowSoftInput(Fragment fragment, View view, View view2, View view3, int i, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        setWindowSoftInput$default(fragment, view, view2, view3, i, z, (Function1) null, 32, (Object) null);
    }

    public static final void setWindowSoftInput(BottomSheetDialogFragment bottomSheetDialogFragment) {
        Intrinsics.checkNotNullParameter(bottomSheetDialogFragment, "<this>");
        setWindowSoftInput$default(bottomSheetDialogFragment, (View) null, (View) null, (View) null, 0, false, (Function1) null, 63, (Object) null);
    }

    public static final void setWindowSoftInput(BottomSheetDialogFragment bottomSheetDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(bottomSheetDialogFragment, "<this>");
        setWindowSoftInput$default(bottomSheetDialogFragment, view, (View) null, (View) null, 0, false, (Function1) null, 62, (Object) null);
    }

    public static final void setWindowSoftInput(BottomSheetDialogFragment bottomSheetDialogFragment, View view, View view2) {
        Intrinsics.checkNotNullParameter(bottomSheetDialogFragment, "<this>");
        setWindowSoftInput$default(bottomSheetDialogFragment, view, view2, (View) null, 0, false, (Function1) null, 60, (Object) null);
    }

    public static final void setWindowSoftInput(BottomSheetDialogFragment bottomSheetDialogFragment, View view, View view2, View view3) {
        Intrinsics.checkNotNullParameter(bottomSheetDialogFragment, "<this>");
        setWindowSoftInput$default(bottomSheetDialogFragment, view, view2, view3, 0, false, (Function1) null, 56, (Object) null);
    }

    public static final void setWindowSoftInput(BottomSheetDialogFragment bottomSheetDialogFragment, View view, View view2, View view3, int i) {
        Intrinsics.checkNotNullParameter(bottomSheetDialogFragment, "<this>");
        setWindowSoftInput$default(bottomSheetDialogFragment, view, view2, view3, i, false, (Function1) null, 48, (Object) null);
    }

    public static final void setWindowSoftInput(BottomSheetDialogFragment bottomSheetDialogFragment, View view, View view2, View view3, int i, boolean z) {
        Intrinsics.checkNotNullParameter(bottomSheetDialogFragment, "<this>");
        setWindowSoftInput$default(bottomSheetDialogFragment, view, view2, view3, i, z, (Function1) null, 32, (Object) null);
    }

    public static /* synthetic */ void setWindowSoftInput$default(Activity activity, View view, View view2, View view3, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            view = null;
        }
        if ((i2 & 2) != 0) {
            Object parent = view != null ? view.getParent() : null;
            view2 = parent instanceof View ? (View) parent : null;
        }
        if ((i2 & 4) != 0) {
            view3 = null;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        if ((i2 & 16) != 0) {
            z = false;
        }
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        setWindowSoftInput(activity, view, view2, view3, i, z, (Function1<? super Boolean, Unit>) function1);
    }

    public static final void setWindowSoftInput(Activity activity, View view, View view2, View view3, int i, boolean z, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        if (activity instanceof ComponentActivity) {
            ((ComponentActivity) activity).getLifecycle().addObserver(SoftInput.INSTANCE.getHideSoftInputObserver$anniex_release());
        }
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        setWindowSoftInput(window, view, view2, view3, i, z, function1);
    }

    public static /* synthetic */ void setWindowSoftInput$default(Fragment fragment, View view, View view2, View view3, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            view = null;
        }
        if ((i2 & 2) != 0) {
            view2 = fragment.getView();
        }
        if ((i2 & 4) != 0) {
            view3 = null;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        if ((i2 & 16) != 0) {
            z = false;
        }
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        setWindowSoftInput(fragment, view, view2, view3, i, z, (Function1<? super Boolean, Unit>) function1);
    }

    public static final void setWindowSoftInput(Fragment fragment, View view, View view2, View view3, int i, boolean z, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        fragment.getLifecycle().addObserver(SoftInput.INSTANCE.getHideSoftInputObserver$anniex_release());
        Window window = fragment.requireActivity().getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "requireActivity().window");
        setWindowSoftInput(window, view, view2, view3, i, z, function1);
    }

    public static /* synthetic */ void setWindowSoftInput$default(DialogFragment dialogFragment, View view, View view2, View view3, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            view = null;
        }
        if ((i2 & 2) != 0) {
            view2 = dialogFragment.getView();
        }
        if ((i2 & 4) != 0) {
            view3 = null;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        if ((i2 & 16) != 0) {
            z = false;
        }
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        setWindowSoftInput(dialogFragment, view, view2, view3, i, z, (Function1<? super Boolean, Unit>) function1);
    }

    public static final void setWindowSoftInput(DialogFragment dialogFragment, View view, View view2, View view3, int i, boolean z, Function1<? super Boolean, Unit> function1) {
        Window window;
        Intrinsics.checkNotNullParameter(dialogFragment, "<this>");
        dialogFragment.getLifecycle().addObserver(SoftInput.INSTANCE.getHideSoftInputObserver$anniex_release());
        Dialog dialog = dialogFragment.getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        setWindowSoftInput(window, view, view2, view3, i, z, function1);
    }

    public static /* synthetic */ void setWindowSoftInput$default(BottomSheetDialogFragment bottomSheetDialogFragment, View view, View view2, View view3, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            view = null;
        }
        if ((i2 & 2) != 0) {
            Dialog dialog = bottomSheetDialogFragment.getDialog();
            view2 = dialog != null ? dialog.findViewById(R.id.design_bottom_sheet) : null;
        }
        if ((i2 & 4) != 0) {
            view3 = null;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        if ((i2 & 16) != 0) {
            z = false;
        }
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        setWindowSoftInput(bottomSheetDialogFragment, view, view2, view3, i, z, (Function1<? super Boolean, Unit>) function1);
    }

    public static final void setWindowSoftInput(BottomSheetDialogFragment bottomSheetDialogFragment, View view, View view2, View view3, int i, boolean z, Function1<? super Boolean, Unit> function1) {
        Window window;
        Intrinsics.checkNotNullParameter(bottomSheetDialogFragment, "<this>");
        bottomSheetDialogFragment.getLifecycle().addObserver(SoftInput.INSTANCE.getHideSoftInputObserver$anniex_release());
        Dialog dialog = bottomSheetDialogFragment.getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        setWindowSoftInput(window, view, view2, view3, i, z, function1);
    }

    public static /* synthetic */ Unit setWindowSoftInput$default(Dialog dialog, View view, View view2, View view3, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            view = null;
        }
        if ((i2 & 2) != 0) {
            Window window = dialog.getWindow();
            view2 = window != null ? window.getDecorView() : null;
        }
        if ((i2 & 4) != 0) {
            view3 = null;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        if ((i2 & 16) != 0) {
            z = false;
        }
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return setWindowSoftInput(dialog, view, view2, view3, i, z, (Function1<? super Boolean, Unit>) function1);
    }

    public static final Unit setWindowSoftInput(Dialog dialog, View view, View view2, View view3, int i, boolean z, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(dialog, "<this>");
        Window window = dialog.getWindow();
        if (window == null) {
            return null;
        }
        setWindowSoftInput(window, view, view2, view3, i, z, function1);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void setWindowSoftInput$default(Window window, View view, View view2, View view3, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            view = null;
        }
        if ((i2 & 2) != 0) {
            view2 = null;
        }
        if ((i2 & 4) != 0) {
            view3 = null;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        if ((i2 & 16) != 0) {
            z = false;
        }
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        setWindowSoftInput(window, view, view2, view3, i, z, (Function1<? super Boolean, Unit>) function1);
    }

    public static final void setWindowSoftInput(final Window window, final View view, final View view2, final View view3, final int i, final boolean z, final Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "decorView");
        if (!isSystemInsetsAnimationSupport(decorView) || SoftInput.INSTANCE.isSoftInputCompatMode()) {
            setWindowSoftInputCompatible(window, view, view2, view3, i, function1);
            return;
        }
        window.setSoftInputMode(48);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        ViewCompat.setWindowInsetsAnimationCallback(window.getDecorView(), new WindowInsetsAnimationCompat.Callback() { // from class: com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt$setWindowSoftInput$callback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat animation, WindowInsetsAnimationCompat.BoundsCompat bounds) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Intrinsics.checkNotNullParameter(bounds, "bounds");
                Ref.BooleanRef booleanRef3 = booleanRef2;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(window.getDecorView());
                booleanRef3.element = rootWindowInsets != null ? rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime()) : false;
                if (view != null && view2 != null) {
                    objectRef.element = animation;
                    if (booleanRef2.element) {
                        Ref.BooleanRef booleanRef4 = booleanRef;
                        View view4 = view3;
                        booleanRef4.element = view4 == null || view4.hasFocus();
                    }
                    if (booleanRef2.element) {
                        Ref.IntRef intRef2 = intRef;
                        View view5 = view;
                        int[] iArr = new int[2];
                        view5.getLocationInWindow(iArr);
                        intRef2.element = iArr[1] + view5.getHeight();
                    }
                }
                return bounds;
            }

            public void onEnd(WindowInsetsAnimationCompat animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onEnd(animation);
                Function1<Boolean, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(Boolean.valueOf(booleanRef2.element));
                }
            }

            public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
                Intrinsics.checkNotNullParameter(insets, "insets");
                Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) objectRef.element;
                Float valueOf = windowInsetsAnimationCompat != null ? Float.valueOf(windowInsetsAnimationCompat.getFraction()) : null;
                if (valueOf != null && view != null && view2 != null && booleanRef.element) {
                    int bottom = window.getDecorView().getBottom() - insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
                    if (booleanRef2.element && bottom < intRef.element) {
                        float f = (bottom - intRef.element) - i;
                        if (z) {
                            view2.setPadding(0, 0, 0, -((int) f));
                            floatRef.element = -f;
                        } else {
                            view2.setTranslationY(f);
                            floatRef.element = f;
                        }
                    } else if (!booleanRef2.element) {
                        if (z) {
                            view2.setPadding(0, 0, 0, (int) Math.max(floatRef.element - (floatRef.element * (valueOf.floatValue() + 0.5f)), 0.0f));
                        } else {
                            view2.setTranslationY(Math.min(floatRef.element - (floatRef.element * (valueOf.floatValue() + 0.5f)), 0.0f));
                        }
                    }
                }
                return insets;
            }
        });
    }

    static /* synthetic */ void setWindowSoftInputCompatible$default(Window window, View view, View view2, View view3, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            view = null;
        }
        if ((i2 & 2) != 0) {
            Object parent = view != null ? view.getParent() : null;
            view2 = parent instanceof View ? (View) parent : null;
        }
        if ((i2 & 4) != 0) {
            view3 = null;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        if ((i2 & 16) != 0) {
            function1 = null;
        }
        setWindowSoftInputCompatible(window, view, view2, view3, i, function1);
    }

    private static final void setWindowSoftInputCompatible(final Window window, View view, View view2, final View view3, int i, final Function1<? super Boolean, Unit> function1) {
        window.setSoftInputMode(16);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        int bridgeContainerLeakValue = IConditionCallKt.getBridgeContainerLeakValue();
        if (bridgeContainerLeakValue == 2) {
            Object tag = window.getDecorView().getTag(com.bytedance.android.anniex.R.id.bullet_container);
            WeakWindowLayoutRERef weakWindowLayoutRERef = tag instanceof WeakWindowLayoutRERef ? (WeakWindowLayoutRERef) tag : null;
            if (weakWindowLayoutRERef == null) {
                weakWindowLayoutRERef = new WeakWindowLayoutRERef(null, 1, null);
                window.getDecorView().setTag(com.bytedance.android.anniex.R.id.bullet_container, weakWindowLayoutRERef);
            }
            weakWindowLayoutRERef.setFunctionRef(new WeakReference<>(new Function<Unit, Unit>() { // from class: com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt$setWindowSoftInputCompatible$1
                public /* bridge */ /* synthetic */ Object apply(Object obj) {
                    apply((Unit) obj);
                    return Unit.INSTANCE;
                }

                public void apply(Unit input) {
                    Function1<Boolean, Unit> function12;
                    Function1<Boolean, Unit> function13;
                    WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(window.getDecorView());
                    if (rootWindowInsets == null) {
                        return;
                    }
                    if (rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime())) {
                        Ref.BooleanRef booleanRef3 = booleanRef2;
                        View view4 = view3;
                        booleanRef3.element = view4 == null || view4.hasFocus();
                        if (!booleanRef.element && booleanRef2.element && (function13 = function1) != null) {
                            function13.invoke(true);
                        }
                        booleanRef.element = true;
                        return;
                    }
                    if (booleanRef.element && booleanRef2.element && (function12 = function1) != null) {
                        function12.invoke(false);
                    }
                    booleanRef.element = false;
                }
            }));
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(weakWindowLayoutRERef);
            return;
        }
        ViewTreeObserver viewTreeObserver = window.getDecorView().getViewTreeObserver();
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt$setWindowSoftInputCompatible$2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Function1<Boolean, Unit> function12;
                Function1<Boolean, Unit> function13;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(window.getDecorView());
                if (rootWindowInsets == null) {
                    return;
                }
                if (rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime())) {
                    Ref.BooleanRef booleanRef3 = booleanRef2;
                    View view4 = view3;
                    booleanRef3.element = view4 == null || view4.hasFocus();
                    if (!booleanRef.element && booleanRef2.element && (function13 = function1) != null) {
                        function13.invoke(true);
                    }
                    booleanRef.element = true;
                    return;
                }
                if (booleanRef.element && booleanRef2.element && (function12 = function1) != null) {
                    function12.invoke(false);
                }
                booleanRef.element = false;
            }
        };
        if (bridgeContainerLeakValue == 1) {
            Object tag2 = window.getDecorView().getTag(com.bytedance.android.anniex.R.id.bullet_container);
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener2 = tag2 instanceof ViewTreeObserver.OnGlobalLayoutListener ? (ViewTreeObserver.OnGlobalLayoutListener) tag2 : null;
            if (onGlobalLayoutListener2 != null) {
                window.getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener2);
            }
            window.getDecorView().setTag(com.bytedance.android.anniex.R.id.bullet_container, onGlobalLayoutListener);
        }
        viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static final boolean isSystemInsetsAnimationSupport(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        WindowInsetsControllerCompat windowInsetsController = ViewCompat.getWindowInsetsController(view);
        return (windowInsetsController == null || windowInsetsController.getSystemBarsBehavior() == 0) ? false : true;
    }
}
