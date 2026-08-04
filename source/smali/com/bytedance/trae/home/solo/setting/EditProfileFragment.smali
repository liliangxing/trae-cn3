# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;
.super Landroidx/fragment/app/Fragment;
.source "EditProfileFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$Companion;
.field private final allowedMimeTypes:Ljava/util/Set;
.field private final pickImage:Landroidx/activity/result/ActivityResultLauncher;
.field private viewModel:Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;


.method public static synthetic $r8$lambda$BzWsWCqu2bU8jUP2sul1DvRpG3Q(android.widget.TextView  com.facebook.drawee.view.SimpleDraweeView  com.bytedance.trae.home.solo.setting.EditProfileFragment  android.widget.TextView  android.view.View  android.view.View  com.bytedance.trae.home.solo.setting.UserProfileState)kotlin.Unit
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->onViewCreated$lambda$2(Landroid/widget/TextView; Lcom/facebook/drawee/view/SimpleDraweeView; Lcom/bytedance/trae/home/solo/setting/EditProfileFragment; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lcom/bytedance/trae/home/solo/setting/UserProfileState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$FIqMJslYg8hqDKwzSTQuOY20quQ(com.bytedance.trae.home.solo.setting.EditProfileFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->onViewCreated$lambda$5(Lcom/bytedance/trae/home/solo/setting/EditProfileFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Ir_DX3ZaW2YsPATZiL73mkRXd7A(com.bytedance.trae.home.solo.setting.EditProfileFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->onViewCreated$lambda$4(Lcom/bytedance/trae/home/solo/setting/EditProfileFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$OyqKjKoj7yrOq0R5Q-boK5sNcXg(com.bytedance.trae.home.solo.setting.EditProfileFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->onViewCreated$lambda$3(Lcom/bytedance/trae/home/solo/setting/EditProfileFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ntERqgkTXLTtKQLBFyvE8f8x334(com.bytedance.trae.home.solo.setting.EditProfileFragment  androidx.activity.result.ActivityResult)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->pickImage$lambda$1(Lcom/bytedance/trae/home/solo/setting/EditProfileFragment; Landroidx/activity/result/ActivityResult;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->Companion Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Landroidx/fragment/app/Fragment;-><init>()V
    const-string v0, "image/png"
    const-string v1, "image/webp"
    const-string v2, "image/jpeg"
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->allowedMimeTypes Ljava/util/Set;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;)V
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    const-string v1, "registerForActivityResult(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->pickImage Landroidx/activity/result/ActivityResultLauncher;
    return-void 
.end method

.method private final isAllowedMimeType(android.net.Uri)boolean
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v0
    invoke-virtual v0, v2, Landroid/content/ContentResolver;->getType(Landroid/net/Uri;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const/4 v2, 0
    return v2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->allowedMimeTypes Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method private final isEnterpriseLogin()boolean
    .registers 3
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00dh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getAccountType()Lcom/bytedance/trae/login/api/AccountType;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/login/api/AccountType;->TOB Lcom/bytedance/trae/login/api/AccountType;
    if-ne v0, v1, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private static final onViewCreated$lambda$2(android.widget.TextView  com.facebook.drawee.view.SimpleDraweeView  com.bytedance.trae.home.solo.setting.EditProfileFragment  android.widget.TextView  android.view.View  android.view.View  com.bytedance.trae.home.solo.setting.UserProfileState)kotlin.Unit
    .registers 10
    # ins_size=7
    if-eqz v9, +076h
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getScreenName()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-lez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +00bh
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getScreenName()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v3, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getAvatarUrl()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +004h
    move v3, v1
    goto +2h
    move v3, v2
    if-eqz v3, +00eh
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getAvatarUrl()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v3
    invoke-virtual v4, v3, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    goto +6h
    sget v3, Lcom/bytedance/trae/home/R$drawable;->trae_default_avatar I
    invoke-virtual v4, v3, Lcom/facebook/drawee/view/SimpleDraweeView;->setActualImageResource(I)V
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v3
    if-nez v3, +00eh
    invoke-direct v5, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->isEnterpriseLogin()Z
    move-result v3
    if-eqz v3, +003h
    goto +6h
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getPhoneNumber()Ljava/lang/String;
    move-result-object v3
    goto +5h
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getEmail()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +00ch
    invoke-virtual v6, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v7, v2, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v8, v2, Landroid/view/View;->setVisibility(I)V
    goto +9h
    const/16 v3, 8
    invoke-virtual v7, v3, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v8, v3, Landroid/view/View;->setVisibility(I)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final onViewCreated$lambda$3(com.bytedance.trae.home.solo.setting.EditProfileFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private static final onViewCreated$lambda$4(com.bytedance.trae.home.solo.setting.EditProfileFragment  android.view.View)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    if-nez v2, +009h
    const-string/jumbo v2, viewModel
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->getUserProfile()Landroidx/lifecycle/LiveData;
    move-result-object v2
    invoke-virtual v2, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    if-eqz v2, +008h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getScreenName()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->Companion Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$Companion;->newInstance(Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    const-string v0, "EditNameDialog"
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method private static final onViewCreated$lambda$5(com.bytedance.trae.home.solo.setting.EditProfileFragment  android.view.View)void
    .registers 4
    # ins_size=2
    new-instance v3, Landroid/content/Intent;
    const-string v0, "android.intent.action.PICK"
    sget-object v1, Landroid/provider/MediaStore$Images$Media;->EXTERNAL_CONTENT_URI Landroid/net/Uri;
    invoke-direct v3, v0, v1, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    const-string v0, "image/*"
    invoke-virtual v3, v0, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;
    iget-object v2, v2, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->pickImage Landroidx/activity/result/ActivityResultLauncher;
    invoke-virtual v2, v3, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final pickImage$lambda$1(com.bytedance.trae.home.solo.setting.EditProfileFragment  androidx.activity.result.ActivityResult)void
    .registers 6
    # ins_size=2
    invoke-virtual v5, Landroidx/activity/result/ActivityResult;->getResultCode()I
    move-result v0
    const/4 v1, -1
    if-ne v0, v1, +04dh
    invoke-virtual v5, Landroidx/activity/result/ActivityResult;->getData()Landroid/content/Intent;
    move-result-object v5
    if-eqz v5, +047h
    invoke-virtual v5, Landroid/content/Intent;->getData()Landroid/net/Uri;
    move-result-object v5
    if-eqz v5, +041h
    invoke-direct v4, v5, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->isAllowedMimeType(Landroid/net/Uri;)Z
    move-result v0
    if-nez v0, +011h
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/home/R$string;->trae_setting_avatar_unsupported_format I
    const/4 v0, 0
    invoke-static v4, v5, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v4
    invoke-virtual v4, Landroid/widget/Toast;->show()V
    return-void 
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v4
    invoke-virtual v4, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/home/R$anim;->trae_slide_in_right I
    sget v1, Lcom/bytedance/trae/home/R$anim;->trae_slide_out_left I
    sget v2, Lcom/bytedance/trae/home/R$anim;->trae_slide_in_left I
    sget v3, Lcom/bytedance/trae/home/R$anim;->trae_slide_out_right I
    invoke-virtual v4, v0, v1, v2, v3, Landroidx/fragment/app/FragmentTransaction;->setCustomAnimations(I I I I)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/home/R$id;->settings_fragment_container I
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->Companion Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$Companion;
    invoke-virtual v1, v5, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$Companion;->newInstance(Landroid/net/Uri;)Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;
    move-result-object v5
    check-cast v5, Landroidx/fragment/app/Fragment;
    invoke-virtual v4, v0, v5, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v4
    const/4 v5, 0
    invoke-virtual v4, v5, Landroidx/fragment/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v4
    invoke-virtual v4, Landroidx/fragment/app/FragmentTransaction;->commit()I
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_edit_profile I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 14
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v11, v12, v13, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    new-instance v13, Landroidx/lifecycle/ViewModelProvider;
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const-string/jumbo v1, requireActivity(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v13, v0, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-virtual v13, v0, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    iput-object v13, v11, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    sget v13, Lcom/bytedance/trae/home/R$id;->iv_avatar I
    invoke-virtual v12, v13, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v13
    move-object v2, v13
    check-cast v2, Lcom/facebook/drawee/view/SimpleDraweeView;
    sget v13, Lcom/bytedance/trae/home/R$id;->tv_name_value I
    invoke-virtual v12, v13, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v13
    move-object v1, v13
    check-cast v1, Landroid/widget/TextView;
    sget v13, Lcom/bytedance/trae/home/R$id;->tv_email_value I
    invoke-virtual v12, v13, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v13
    move-object v4, v13
    check-cast v4, Landroid/widget/TextView;
    sget v13, Lcom/bytedance/trae/home/R$id;->tv_account_label I
    invoke-virtual v12, v13, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v13
    check-cast v13, Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->row_email I
    invoke-virtual v12, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    sget v0, Lcom/bytedance/trae/home/R$id;->divider_email I
    invoke-virtual v12, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_edit_avatar I
    invoke-virtual v12, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v7
    sget v0, Lcom/bytedance/trae/home/R$id;->img_avatar_edit_indicator I
    invoke-virtual v12, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    move-object v8, v0
    check-cast v8, Landroid/widget/ImageView;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-nez v0, +00ch
    invoke-direct v11, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->isEnterpriseLogin()Z
    move-result v0
    if-eqz v0, +003h
    goto +4h
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_phone I
    goto +3h
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_email I
    invoke-virtual v13, v0, Landroid/widget/TextView;->setText(I)V
    iget-object v13, v11, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    if-nez v13, +009h
    const-string/jumbo v13, viewModel
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v13, 0
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->getUserProfile()Landroidx/lifecycle/LiveData;
    move-result-object v13
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v9
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;
    move-object v0, v10
    move-object v3, v11
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;-><init>(Landroid/widget/TextView; Lcom/facebook/drawee/view/SimpleDraweeView; Lcom/bytedance/trae/home/solo/setting/EditProfileFragment; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v0, v10, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v0, Landroidx/lifecycle/Observer;
    invoke-virtual v13, v9, v0, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    sget v13, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v12, v13, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda2;
    invoke-direct v0, v11, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;)V
    invoke-virtual v13, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    sget v13, Lcom/bytedance/trae/home/R$id;->btn_edit_name I
    invoke-virtual v12, v13, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    new-instance v13, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda3;
    invoke-direct v13, v11, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;)V
    invoke-virtual v12, v13, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v11, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->isEnterpriseLogin()Z
    move-result v12
    if-eqz v12, +00fh
    const/4 v12, 0
    invoke-virtual v7, v12, Landroid/view/View;->setClickable(Z)V
    invoke-virtual v7, v12, Landroid/view/View;->setFocusable(Z)V
    const/16 v12, 8
    invoke-virtual v8, v12, Landroid/widget/ImageView;->setVisibility(I)V
    goto +9h
    new-instance v12, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda4;
    invoke-direct v12, v11, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;)V
    invoke-virtual v7, v12, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
