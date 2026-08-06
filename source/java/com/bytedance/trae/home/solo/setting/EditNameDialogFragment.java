package com.bytedance.trae.home.solo.setting;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.trae.home.C0820R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: EditNameDialogFragment.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updateCharCount", "tvCharCount", "Landroid/widget/TextView;", "length", "", "onCreateDialog", "Landroid/app/Dialog;", "onStart", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class EditNameDialogFragment extends DialogFragment {
    private static final int MAX_NAME_LENGTH = 20;
    private SettingsViewModel viewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: EditNameDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$Companion;", "", "<init>", "()V", "MAX_NAME_LENGTH", "", "newInstance", "Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;", "currentName", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EditNameDialogFragment newInstance(String currentName) {
            Intrinsics.checkNotNullParameter(currentName, "currentName");
            EditNameDialogFragment editNameDialogFragment = new EditNameDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", currentName);
            editNameDialogFragment.setArguments(bundle);
            return editNameDialogFragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.dialog_edit_name, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        final String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModelStoreOwner requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.viewModel = new ViewModelProvider(requireActivity).get(SettingsViewModel.class);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("name")) == null) {
            str = "";
        }
        final EditText editText = (EditText) view.findViewById(C0820R.id.et_name);
        final TextView textView = (TextView) view.findViewById(C0820R.id.tv_char_count);
        editText.setText(str);
        editText.setSelection(str.length());
        editText.requestFocus();
        Intrinsics.checkNotNull(textView);
        updateCharCount(textView, str.length());
        editText.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.home.solo.setting.EditNameDialogFragment$onViewCreated$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                EditNameDialogFragment editNameDialogFragment = EditNameDialogFragment.this;
                TextView textView2 = textView;
                Intrinsics.checkNotNull(textView2);
                editNameDialogFragment.updateCharCount(textView2, s != null ? s.length() : 0);
            }
        });
        view.findViewById(C0820R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.EditNameDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditNameDialogFragment.this.dismiss();
            }
        });
        final View findViewById = view.findViewById(C0820R.id.btn_save);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.EditNameDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditNameDialogFragment.onViewCreated$lambda$1(editText, this, str, findViewById, view2);
            }
        });
        SettingsViewModel settingsViewModel = this.viewModel;
        if (settingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsViewModel = null;
        }
        settingsViewModel.getUpdateNameResult().observe(getViewLifecycleOwner(), new EventObserver(new Function1() { // from class: com.bytedance.trae.home.solo.setting.EditNameDialogFragment$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$2;
                onViewCreated$lambda$2 = EditNameDialogFragment.onViewCreated$lambda$2(findViewById, this, ((Boolean) obj).booleanValue());
                return onViewCreated$lambda$2;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(EditText editText, EditNameDialogFragment editNameDialogFragment, String str, View view, View view2) {
        String obj = StringsKt.trim(editText.getText().toString()).toString();
        String str2 = obj;
        if (str2.length() == 0) {
            Toast.makeText(editNameDialogFragment.getContext(), C0820R.string.trae_setting_name_empty_hint, 0).show();
            return;
        }
        if (new Regex("\\s").containsMatchIn(str2)) {
            Toast.makeText(editNameDialogFragment.getContext(), C0820R.string.trae_setting_name_no_spaces, 0).show();
            return;
        }
        if (obj.length() > 20) {
            Toast.makeText(editNameDialogFragment.getContext(), editNameDialogFragment.getString(C0820R.string.trae_setting_name_too_long, new Object[]{20}), 0).show();
            return;
        }
        if (Intrinsics.areEqual(obj, str)) {
            editNameDialogFragment.dismiss();
            return;
        }
        view.setEnabled(false);
        SettingsViewModel settingsViewModel = editNameDialogFragment.viewModel;
        if (settingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsViewModel = null;
        }
        settingsViewModel.updateNickname(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(View view, EditNameDialogFragment editNameDialogFragment, boolean z) {
        view.setEnabled(true);
        Toast.makeText(editNameDialogFragment.getContext(), z ? C0820R.string.trae_setting_name_update_success : C0820R.string.trae_setting_name_update_failed, 0).show();
        if (z) {
            editNameDialogFragment.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCharCount(TextView tvCharCount, int length) {
        tvCharCount.setText(getString(C0820R.string.trae_setting_name_char_count, new Object[]{Integer.valueOf(length), 20}));
        tvCharCount.setTextColor(length >= 20 ? Color.parseColor("#FF4D4F") : ContextCompat.getColor(requireContext(), C0820R.color.trae_setting_text_secondary));
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "onCreateDialog(...)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window2 = onCreateDialog.getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(5);
        }
        return onCreateDialog;
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (getResources().getDisplayMetrics().widthPixels * 0.75d), -2);
        window.setGravity(17);
    }
}
