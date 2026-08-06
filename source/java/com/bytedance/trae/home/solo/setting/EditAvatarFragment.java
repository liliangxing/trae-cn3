package com.bytedance.trae.home.solo.setting;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.trae.home.C0820R;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EditAvatarFragment.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;", "imageUri", "Landroid/net/Uri;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class EditAvatarFragment extends Fragment {
    private Uri imageUri;
    private SettingsViewModel viewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.imageUri = arguments != null ? (Uri) arguments.getParcelable("uri") : null;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_edit_avatar, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModelStoreOwner requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.viewModel = new ViewModelProvider(requireActivity).get(SettingsViewModel.class);
        ((TextView) view.findViewById(C0820R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.EditAvatarFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditAvatarFragment.onViewCreated$lambda$0(EditAvatarFragment.this, view2);
            }
        });
        final TextView textView = (TextView) view.findViewById(C0820R.id.btn_ok);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.EditAvatarFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditAvatarFragment.onViewCreated$lambda$1(EditAvatarFragment.this, textView, view2);
            }
        });
        SimpleDraweeView findViewById = view.findViewById(C0820R.id.iv_avatar_preview);
        Uri uri = this.imageUri;
        if (uri != null) {
            findViewById.setImageURI(uri);
        }
        SettingsViewModel settingsViewModel = this.viewModel;
        if (settingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsViewModel = null;
        }
        settingsViewModel.getUploadAvatarResult().observe(getViewLifecycleOwner(), new EventObserver(new Function1() { // from class: com.bytedance.trae.home.solo.setting.EditAvatarFragment$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$3;
                onViewCreated$lambda$3 = EditAvatarFragment.onViewCreated$lambda$3(textView, this, ((Boolean) obj).booleanValue());
                return onViewCreated$lambda$3;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(EditAvatarFragment editAvatarFragment, View view) {
        editAvatarFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(EditAvatarFragment editAvatarFragment, TextView textView, View view) {
        Uri uri = editAvatarFragment.imageUri;
        if (uri == null) {
            return;
        }
        textView.setEnabled(false);
        SettingsViewModel settingsViewModel = editAvatarFragment.viewModel;
        if (settingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsViewModel = null;
        }
        settingsViewModel.uploadAvatar(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(TextView textView, EditAvatarFragment editAvatarFragment, boolean z) {
        textView.setEnabled(true);
        if (z) {
            Toast.makeText(editAvatarFragment.getContext(), C0820R.string.trae_setting_avatar_update_success, 0).show();
            editAvatarFragment.getParentFragmentManager().popBackStack();
        } else {
            Toast.makeText(editAvatarFragment.getContext(), C0820R.string.trae_setting_avatar_update_failed, 0).show();
        }
        return Unit.INSTANCE;
    }

    /* compiled from: EditAvatarFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;", "uri", "Landroid/net/Uri;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EditAvatarFragment newInstance(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            EditAvatarFragment editAvatarFragment = new EditAvatarFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("uri", uri);
            editAvatarFragment.setArguments(bundle);
            return editAvatarFragment;
        }
    }
}
