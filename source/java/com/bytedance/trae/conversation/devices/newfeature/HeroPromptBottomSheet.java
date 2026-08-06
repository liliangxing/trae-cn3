package com.bytedance.trae.conversation.devices.newfeature;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeroPromptBottomSheet.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016JN\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\b\b\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018H\u0004¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "bindHeroPrompt", "", "view", "imageRes", "", "title", "", "message", "actionText", "onClose", "Lkotlin/Function0;", "onAction", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class HeroPromptBottomSheet extends BottomSheetDialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        Dialog dialog = (BottomSheetDialog) onCreateDialog;
        final int dimensionPixelSize = getResources().getDimensionPixelSize(C0637R.dimen.trae_new_feature_prompt_sheet_height);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.devices.newfeature.HeroPromptBottomSheet$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                HeroPromptBottomSheet.onCreateDialog$lambda$2(dimensionPixelSize, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$2(int i, DialogInterface dialogInterface) {
        View findViewById;
        BottomSheetDialog bottomSheetDialog = dialogInterface instanceof BottomSheetDialog ? (BottomSheetDialog) dialogInterface : null;
        if (bottomSheetDialog == null || (findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet)) == null) {
            return;
        }
        findViewById.setBackgroundResource(android.R.color.transparent);
        BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
        from.setPeekHeight(i);
        from.setState(3);
        from.setSkipCollapsed(true);
        from.setHideable(true);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = i;
        findViewById.setLayoutParams(layoutParams);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(C0637R.layout.bottom_sheet_new_feature_prompt, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindHeroPrompt(View view, int imageRes, CharSequence title, CharSequence message, CharSequence actionText, final Function0<Unit> onClose, final Function0<Unit> onAction) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        ((TraeTitleBar) view.findViewById(C0637R.id.title_bar)).setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.newfeature.HeroPromptBottomSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                onClose.invoke();
            }
        });
        ((ImageView) view.findViewById(C0637R.id.iv_prompt_image)).setImageResource(imageRes);
        ((TextView) view.findViewById(C0637R.id.tv_prompt_title)).setText(title);
        ((TextView) view.findViewById(C0637R.id.tv_prompt_message)).setText(message);
        TextView textView = (TextView) view.findViewById(C0637R.id.btn_connect);
        textView.setText(actionText);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.newfeature.HeroPromptBottomSheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                onAction.invoke();
            }
        });
    }
}
