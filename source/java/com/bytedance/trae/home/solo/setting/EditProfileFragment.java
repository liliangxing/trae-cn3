package com.bytedance.trae.home.solo.setting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.ILoginService;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EditProfileFragment.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;", "isEnterpriseLogin", "", "()Z", "allowedMimeTypes", "", "", "isAllowedMimeType", "uri", "Landroid/net/Uri;", "pickImage", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class EditProfileFragment extends Fragment {
    private final Set<String> allowedMimeTypes = SetsKt.setOf(new String[]{"image/jpeg", "image/png", "image/webp"});
    private final ActivityResultLauncher<Intent> pickImage;
    private SettingsViewModel viewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public EditProfileFragment() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.bytedance.trae.home.solo.setting.EditProfileFragment$$ExternalSyntheticLambda0
            public final void onActivityResult(Object obj) {
                EditProfileFragment.pickImage$lambda$1(EditProfileFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.pickImage = registerForActivityResult;
    }

    /* compiled from: EditProfileFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EditProfileFragment newInstance() {
            return new EditProfileFragment();
        }
    }

    private final boolean isEnterpriseLogin() {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        return ((iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getAccountType()) == AccountType.TOB;
    }

    private final boolean isAllowedMimeType(Uri uri) {
        String type = requireContext().getContentResolver().getType(uri);
        if (type == null) {
            return false;
        }
        return this.allowedMimeTypes.contains(type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pickImage$lambda$1(EditProfileFragment editProfileFragment, ActivityResult activityResult) {
        Intent data;
        Uri data2;
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null || (data2 = data.getData()) == null) {
            return;
        }
        if (!editProfileFragment.isAllowedMimeType(data2)) {
            Toast.makeText(editProfileFragment.requireContext(), C0820R.string.trae_setting_avatar_unsupported_format, 0).show();
        } else {
            editProfileFragment.getParentFragmentManager().beginTransaction().setCustomAnimations(C0820R.anim.trae_slide_in_right, C0820R.anim.trae_slide_out_left, C0820R.anim.trae_slide_in_left, C0820R.anim.trae_slide_out_right).replace(C0820R.id.settings_fragment_container, EditAvatarFragment.INSTANCE.newInstance(data2)).addToBackStack((String) null).commit();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_edit_profile, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModelStoreOwner requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.viewModel = new ViewModelProvider(requireActivity).get(SettingsViewModel.class);
        final SimpleDraweeView findViewById = view.findViewById(C0820R.id.iv_avatar);
        final TextView textView = (TextView) view.findViewById(C0820R.id.tv_name_value);
        final TextView textView2 = (TextView) view.findViewById(C0820R.id.tv_email_value);
        TextView textView3 = (TextView) view.findViewById(C0820R.id.tv_account_label);
        final View findViewById2 = view.findViewById(C0820R.id.row_email);
        final View findViewById3 = view.findViewById(C0820R.id.divider_email);
        View findViewById4 = view.findViewById(C0820R.id.btn_edit_avatar);
        ImageView imageView = (ImageView) view.findViewById(C0820R.id.img_avatar_edit_indicator);
        textView3.setText((AppHost.INSTANCE.isOversea() || isEnterpriseLogin()) ? C0820R.string.trae_setting_email : C0820R.string.trae_setting_phone);
        SettingsViewModel settingsViewModel = this.viewModel;
        if (settingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsViewModel = null;
        }
        settingsViewModel.getUserProfile().observe(getViewLifecycleOwner(), new EditProfileFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.home.solo.setting.EditProfileFragment$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$2;
                onViewCreated$lambda$2 = EditProfileFragment.onViewCreated$lambda$2(textView, findViewById, this, textView2, findViewById2, findViewById3, (UserProfileState) obj);
                return onViewCreated$lambda$2;
            }
        }));
        ((TraeTitleBar) view.findViewById(C0820R.id.title_bar)).setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.EditProfileFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditProfileFragment.onViewCreated$lambda$3(EditProfileFragment.this, view2);
            }
        });
        view.findViewById(C0820R.id.btn_edit_name).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.EditProfileFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditProfileFragment.onViewCreated$lambda$4(EditProfileFragment.this, view2);
            }
        });
        if (isEnterpriseLogin()) {
            findViewById4.setClickable(false);
            findViewById4.setFocusable(false);
            imageView.setVisibility(8);
            return;
        }
        findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.EditProfileFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditProfileFragment.onViewCreated$lambda$5(EditProfileFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(TextView textView, SimpleDraweeView simpleDraweeView, EditProfileFragment editProfileFragment, TextView textView2, View view, View view2, UserProfileState userProfileState) {
        if (userProfileState != null) {
            if (userProfileState.getScreenName().length() > 0) {
                textView.setText(userProfileState.getScreenName());
            }
            if (userProfileState.getAvatarUrl().length() > 0) {
                simpleDraweeView.setImageURI(Uri.parse(userProfileState.getAvatarUrl()));
            } else {
                simpleDraweeView.setActualImageResource(C0820R.drawable.trae_default_avatar);
            }
            String email = (AppHost.INSTANCE.isOversea() || editProfileFragment.isEnterpriseLogin()) ? userProfileState.getEmail() : userProfileState.getPhoneNumber();
            if (email.length() > 0) {
                textView2.setText(email);
                view.setVisibility(0);
                view2.setVisibility(0);
            } else {
                view.setVisibility(8);
                view2.setVisibility(8);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(EditProfileFragment editProfileFragment, View view) {
        editProfileFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(EditProfileFragment editProfileFragment, View view) {
        String str;
        SettingsViewModel settingsViewModel = editProfileFragment.viewModel;
        if (settingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsViewModel = null;
        }
        UserProfileState userProfileState = (UserProfileState) settingsViewModel.getUserProfile().getValue();
        if (userProfileState == null || (str = userProfileState.getScreenName()) == null) {
            str = "";
        }
        EditNameDialogFragment.INSTANCE.newInstance(str).show(editProfileFragment.getChildFragmentManager(), "EditNameDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(EditProfileFragment editProfileFragment, View view) {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        editProfileFragment.pickImage.launch(intent);
    }
}
