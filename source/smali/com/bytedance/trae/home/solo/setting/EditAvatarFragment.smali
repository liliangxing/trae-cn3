# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;
.super Landroidx/fragment/app/Fragment;
.source "EditAvatarFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$Companion;
.field private imageUri:Landroid/net/Uri;
.field private viewModel:Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;


.method public static synthetic $r8$lambda$CyfoRNOH-9amXcz95iRNbuBQuQo(android.widget.TextView  com.bytedance.trae.home.solo.setting.EditAvatarFragment  boolean)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->onViewCreated$lambda$3(Landroid/widget/TextView; Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment; Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$c8gerJfCAZ8CC54q6uCpXG-b1fs(com.bytedance.trae.home.solo.setting.EditAvatarFragment  android.widget.TextView  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->onViewCreated$lambda$1(Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment; Landroid/widget/TextView; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$m-gzj_B_zc_ZtkgJm65zs4z2qxg(com.bytedance.trae.home.solo.setting.EditAvatarFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->onViewCreated$lambda$0(Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->Companion Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/fragment/app/Fragment;-><init>()V
    return-void 
.end method

.method private static final onViewCreated$lambda$0(com.bytedance.trae.home.solo.setting.EditAvatarFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private static final onViewCreated$lambda$1(com.bytedance.trae.home.solo.setting.EditAvatarFragment  android.widget.TextView  android.view.View)void
    .registers 4
    # ins_size=3
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->imageUri Landroid/net/Uri;
    if-nez v3, +003h
    return-void 
    const/4 v0, 0
    invoke-virtual v2, v0, Landroid/widget/TextView;->setEnabled(Z)V
    iget-object v1, v1, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v1, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->uploadAvatar(Landroid/net/Uri;)V
    return-void 
.end method

.method private static final onViewCreated$lambda$3(android.widget.TextView  com.bytedance.trae.home.solo.setting.EditAvatarFragment  boolean)kotlin.Unit
    .registers 4
    # ins_size=3
    const/4 v0, 1
    invoke-virtual v1, v0, Landroid/widget/TextView;->setEnabled(Z)V
    const/4 v1, 0
    if-eqz v3, +017h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->getContext()Landroid/content/Context;
    move-result-object v3
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_avatar_update_success I
    invoke-static v3, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    goto +eh
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_avatar_update_failed I
    invoke-static v2, v3, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public onCreate(android.os.Bundle)void
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Landroidx/fragment/app/Fragment;->onCreate(Landroid/os/Bundle;)V
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v2
    if-eqz v2, +00ch
    const-string/jumbo v0, uri
    invoke-virtual v2, v0, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;
    move-result-object v2
    check-cast v2, Landroid/net/Uri;
    goto +2h
    const/4 v2, 0
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->imageUri Landroid/net/Uri;
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_edit_avatar I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v3, v4, v5, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    new-instance v5, Landroidx/lifecycle/ViewModelProvider;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const-string/jumbo v1, requireActivity(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v5, v0, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-virtual v5, v0, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    iput-object v5, v3, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    sget v5, Lcom/bytedance/trae/home/R$id;->btn_cancel I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/TextView;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;)V
    invoke-virtual v5, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v5, Lcom/bytedance/trae/home/R$id;->btn_ok I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/TextView;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$$ExternalSyntheticLambda1;
    invoke-direct v0, v3, v5, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment; Landroid/widget/TextView;)V
    invoke-virtual v5, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->iv_avatar_preview I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Lcom/facebook/drawee/view/SimpleDraweeView;
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->imageUri Landroid/net/Uri;
    if-eqz v0, +005h
    invoke-virtual v4, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    if-nez v4, +009h
    const-string/jumbo v4, viewModel
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->getUploadAvatarResult()Landroidx/lifecycle/LiveData;
    move-result-object v4
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/EventObserver;
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$$ExternalSyntheticLambda2;
    invoke-direct v2, v5, v3, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$$ExternalSyntheticLambda2;-><init>(Landroid/widget/TextView; Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/EventObserver;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v1, Landroidx/lifecycle/Observer;
    invoke-virtual v4, v0, v1, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
.end method
