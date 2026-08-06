package com.bytedance.android.anniex.container.p025ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.IPopupContainer;
import com.bytedance.android.anniex.base.container.listener.AnnieXDialogListener;
import com.bytedance.android.anniex.container.util.CustomViewUtil;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0007\b\u0000\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0010H\u0016J\u0012\u0010'\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020\u0010H\u0016J\u0012\u0010)\u001a\u00020\u001c2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u001a\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0015\u0010,\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\b-J\u0015\u0010.\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b/J\u0010\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u000eH\u0016J\u001a\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/DialogInterface$OnShowListener;", "()V", "listener", "Lcom/bytedance/android/anniex/base/container/listener/AnnieXDialogListener;", "popupComponent", "com/bytedance/android/anniex/container/ui/AnnieXDialog$popupComponent$1", "Lcom/bytedance/android/anniex/container/ui/AnnieXDialog$popupComponent$1;", "popupContainer", "Lcom/bytedance/android/anniex/base/container/IPopupContainer;", "rootView", "Landroid/view/View;", "useFlow", "", "bindOnBackPressedCallback", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onResume", "onShow", "onStop", "onSuperCreateDialog", "onViewCreated", "view", "setListener", "setListener$anniex_release", "setPopupContainer", "setPopupContainer$anniex_release", "setUserVisibleHint", "isVisibleToUser", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXDialog extends DialogFragment implements DialogInterface.OnShowListener {
    public static final String TAG = "AnnieXDialog";
    private AnnieXDialogListener listener;
    private final AnnieXDialog$popupComponent$1 popupComponent = new IPopupContainer.PopupComponent() { // from class: com.bytedance.android.anniex.container.ui.AnnieXDialog$popupComponent$1
        @Override // com.bytedance.android.anniex.base.container.UIComponent
        public View createErrorView() {
            IPopupContainer iPopupContainer;
            iPopupContainer = AnnieXDialog.this.popupContainer;
            if (iPopupContainer != null) {
                return CustomViewUtil.INSTANCE.createErrorView(iPopupContainer);
            }
            return null;
        }

        @Override // com.bytedance.android.anniex.base.container.UIComponent
        public View createLoadingView() {
            IPopupContainer iPopupContainer;
            iPopupContainer = AnnieXDialog.this.popupContainer;
            if (iPopupContainer != null) {
                return CustomViewUtil.INSTANCE.createLoadingView(iPopupContainer);
            }
            return null;
        }

        @Override // com.bytedance.android.anniex.base.container.UIComponent
        public void close() {
            AnnieXDialog.this.dismiss();
        }

        @Override // com.bytedance.android.anniex.base.container.IPopupContainer.PopupComponent
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Dialog onSuperCreateDialog;
            onSuperCreateDialog = AnnieXDialog.this.onSuperCreateDialog(savedInstanceState);
            return onSuperCreateDialog;
        }
    };
    private IPopupContainer popupContainer;
    private View rootView;
    private boolean useFlow;

    /* JADX INFO: Access modifiers changed from: private */
    public final Dialog onSuperCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        IPopupContainer iPopupContainer = this.popupContainer;
        if (iPopupContainer != null) {
            iPopupContainer.setPopupComponent(this.popupComponent);
            iPopupContainer.onAttach(this);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IPopupContainer iPopupContainer = this.popupContainer;
        if (iPopupContainer != null) {
            iPopupContainer.onCreate(savedInstanceState);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog;
        IPopupContainer iPopupContainer = this.popupContainer;
        if (iPopupContainer != null && (onCreateDialog = iPopupContainer.onCreateDialog(savedInstanceState)) != null) {
            return onCreateDialog;
        }
        Dialog onCreateDialog2 = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog2, "super.onCreateDialog(\n  …edInstanceState\n        )");
        return onCreateDialog2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate(C0840R.layout.annie_x_dialog, container, false);
        this.rootView = inflate;
        IPopupContainer iPopupContainer = this.popupContainer;
        if (iPopupContainer != null) {
            iPopupContainer.onCreateView(inflate);
        }
        bindOnBackPressedCallback();
        return this.rootView;
    }

    private final void bindOnBackPressedCallback() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bytedance.android.anniex.container.ui.AnnieXDialog$bindOnBackPressedCallback$1
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    IPopupContainer iPopupContainer;
                    Intrinsics.checkNotNullParameter(dialogInterface, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
                    if (i == 4 && keyEvent.getAction() == 1) {
                        iPopupContainer = AnnieXDialog.this.popupContainer;
                        if ((iPopupContainer == null || iPopupContainer.canBackPress()) ? false : true) {
                            HybridLogger.i$default(HybridLogger.INSTANCE, AnnieXDialog.TAG, "====intercept backPress=====", (Map) null, (LoggerContext) null, 12, (Object) null);
                            return true;
                        }
                    }
                    return false;
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        IPopupContainer iPopupContainer;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        IPopupContainer iPopupContainer2 = this.popupContainer;
        if (iPopupContainer2 != null) {
            iPopupContainer2.onViewCreated(view, savedInstanceState);
        }
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.getBoolean(AnnieXPageService.BUNDLE_ANNIE_X_FLOW, false) || (string = arguments.getString("__x_inner_schema")) == null || (iPopupContainer = this.popupContainer) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(string, "it");
        IContainer.DefaultImpls.loadSchema$default(iPopupContainer, string, null, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IPopupContainer iPopupContainer = this.popupContainer;
        if (iPopupContainer != null) {
            iPopupContainer.onResume();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        IPopupContainer iPopupContainer = this.popupContainer;
        if (iPopupContainer != null) {
            iPopupContainer.onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        IPopupContainer iPopupContainer = this.popupContainer;
        if (iPopupContainer != null) {
            iPopupContainer.setUserVisibleHint(isVisibleToUser);
        }
    }

    public final void setPopupContainer$anniex_release(IPopupContainer popupContainer) {
        Intrinsics.checkNotNullParameter(popupContainer, "popupContainer");
        this.popupContainer = popupContainer;
    }

    public final void setListener$anniex_release(AnnieXDialogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        IPopupContainer iPopupContainer = this.popupContainer;
        if (iPopupContainer != null) {
            iPopupContainer.onConfigurationChanged(newConfig);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        Dialog dialog;
        super.onActivityCreated(savedInstanceState);
        IPopupContainer iPopupContainer = this.popupContainer;
        if (iPopupContainer != null) {
            iPopupContainer.onActivityCreated(savedInstanceState);
        }
        if (!getShowsDialog() || (dialog = getDialog()) == null) {
            return;
        }
        dialog.setOnShowListener(this);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialog) {
        IPopupContainer iPopupContainer = this.popupContainer;
        if (iPopupContainer != null) {
            iPopupContainer.onShow(dialog);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        View view;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        IPopupContainer iPopupContainer = this.popupContainer;
        if (iPopupContainer != null) {
            iPopupContainer.onDismiss(dialog);
        }
        AnnieXDialogListener annieXDialogListener = this.listener;
        if (annieXDialogListener != null) {
            annieXDialogListener.onDismiss();
        }
        if (!IConditionCallKt.enableFixDialogDestroy() || (view = getView()) == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.bytedance.android.anniex.container.ui.AnnieXDialog$onDismiss$1
            @Override // java.lang.Runnable
            public final void run() {
                if (!AnnieXDialog.this.isAdded() || AnnieXDialog.this.getLifecycle().getState() == Lifecycle.State.DESTROYED) {
                    return;
                }
                AnnieXDialog.this.getParentFragmentManager().beginTransaction().remove(AnnieXDialog.this).commitNowAllowingStateLoss();
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String tag) {
        Object obj;
        Intrinsics.checkNotNullParameter(manager, "manager");
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===show()===", (Map) null, (LoggerContext) null, 12, (Object) null);
        try {
            Result.Companion companion = Result.Companion;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (manager.isDestroyed()) {
            return;
        }
        manager.beginTransaction().remove(this).commit();
        super.show(manager, tag);
        obj = Result.constructor-impl(Unit.INSTANCE);
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "===show error:" + th2.getMessage() + "===", (Map) null, (LoggerContext) null, 12, (Object) null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        IPopupContainer iPopupContainer = this.popupContainer;
        if (iPopupContainer != null) {
            iPopupContainer.release();
        }
    }
}
