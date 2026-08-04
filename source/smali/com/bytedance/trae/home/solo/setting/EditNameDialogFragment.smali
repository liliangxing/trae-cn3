# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;
.super Landroidx/fragment/app/DialogFragment;
.source "EditNameDialogFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$Companion;
.field private static final MAX_NAME_LENGTH:I
.field private viewModel:Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;


.method public static synthetic $r8$lambda$6X6275C0rMSSf_yQC6JATveGdSU(android.view.View  com.bytedance.trae.home.solo.setting.EditNameDialogFragment  boolean)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->onViewCreated$lambda$2(Landroid/view/View; Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment; Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$cYSda93HmDWAl3x26jMkWiDtYjw(com.bytedance.trae.home.solo.setting.EditNameDialogFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->onViewCreated$lambda$0(Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$uLOesa3gVWvFj1Gy_Olunb_8WHY(android.widget.EditText  com.bytedance.trae.home.solo.setting.EditNameDialogFragment  java.lang.String  android.view.View  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->onViewCreated$lambda$1(Landroid/widget/EditText; Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment; Ljava/lang/String; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->Companion Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/fragment/app/DialogFragment;-><init>()V
    return-void 
.end method

.method public static final synthetic access$updateCharCount(com.bytedance.trae.home.solo.setting.EditNameDialogFragment  android.widget.TextView  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->updateCharCount(Landroid/widget/TextView; I)V
    return-void 
.end method

.method private static final onViewCreated$lambda$0(com.bytedance.trae.home.solo.setting.EditNameDialogFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->dismiss()V
    return-void 
.end method

.method private static final onViewCreated$lambda$1(android.widget.EditText  com.bytedance.trae.home.solo.setting.EditNameDialogFragment  java.lang.String  android.view.View  android.view.View)void
    .registers 9
    # ins_size=5
    invoke-virtual v4, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v4
    move-object v8, v4
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-nez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +010h
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->getContext()Landroid/content/Context;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/home/R$string;->trae_setting_name_empty_hint I
    invoke-static v4, v5, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v4
    invoke-virtual v4, Landroid/widget/Toast;->show()V
    return-void 
    new-instance v0, Lkotlin/text/Regex;
    const-string v3, "\s"
    invoke-direct v0, v3, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v8, Lkotlin/text/Regex;->containsMatchIn(Ljava/lang/CharSequence;)Z
    move-result v8
    if-eqz v8, +010h
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->getContext()Landroid/content/Context;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/home/R$string;->trae_setting_name_no_spaces I
    invoke-static v4, v5, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v4
    invoke-virtual v4, Landroid/widget/Toast;->show()V
    return-void 
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v8
    const/16 v0, 20
    if-le v8, v0, +01eh
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->getContext()Landroid/content/Context;
    move-result-object v4
    sget v6, Lcom/bytedance/trae/home/R$string;->trae_setting_name_too_long I
    new-array v7, v1, [Ljava/lang/Object;
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    aput-object v8, v7, v2
    invoke-virtual v5, v6, v7, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v4, v5, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v4
    invoke-virtual v4, Landroid/widget/Toast;->show()V
    return-void 
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +006h
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->dismiss()V
    return-void 
    invoke-virtual v7, v2, Landroid/view/View;->setEnabled(Z)V
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    if-nez v5, +009h
    const-string/jumbo v5, viewModel
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v5, 0
    invoke-virtual v5, v4, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->updateNickname(Ljava/lang/String;)V
    return-void 
.end method

.method private static final onViewCreated$lambda$2(android.view.View  com.bytedance.trae.home.solo.setting.EditNameDialogFragment  boolean)kotlin.Unit
    .registers 5
    # ins_size=3
    const/4 v0, 1
    invoke-virtual v2, v0, Landroid/view/View;->setEnabled(Z)V
    if-eqz v4, +005h
    sget v2, Lcom/bytedance/trae/home/R$string;->trae_setting_name_update_success I
    goto +3h
    sget v2, Lcom/bytedance/trae/home/R$string;->trae_setting_name_update_failed I
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    const/4 v1, 0
    invoke-static v0, v2, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    if-eqz v4, +005h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->dismiss()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private final updateCharCount(android.widget.TextView  int)void
    .registers 9
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_name_char_count I
    const/4 v1, 2
    new-array v1, v1, [Ljava/lang/Object;
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const/4 v3, 0
    aput-object v2, v1, v3
    const/16 v2, 20
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    invoke-virtual v6, v0, v1, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v7, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    if-lt v8, v2, +003h
    move v3, v5
    if-eqz v3, +009h
    const-string v8, "#FF4D4F"
    invoke-static v8, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v8
    goto +bh
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->requireContext()Landroid/content/Context;
    move-result-object v8
    sget v0, Lcom/bytedance/trae/home/R$color;->trae_setting_text_secondary I
    invoke-static v8, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v7, v8, Landroid/widget/TextView;->setTextColor(I)V
    return-void 
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 5
    # ins_size=2
    invoke-super v3, v4, Landroidx/fragment/app/DialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v4
    const-string v0, "onCreateDialog(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/app/Dialog;->getWindow()Landroid/view/Window;
    move-result-object v0
    if-eqz v0, +00dh
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;
    const/4 v2, 0
    invoke-direct v1, v2, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v1, Landroid/graphics/drawable/Drawable;
    invoke-virtual v0, v1, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v4, Landroid/app/Dialog;->getWindow()Landroid/view/Window;
    move-result-object v0
    if-eqz v0, +006h
    const/4 v1, 5
    invoke-virtual v0, v1, Landroid/view/Window;->setSoftInputMode(I)V
    return-object v4
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->dialog_edit_name I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onStart()void
    .registers 6
    # ins_size=1
    invoke-super v5, Landroidx/fragment/app/DialogFragment;->onStart()V
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->getDialog()Landroid/app/Dialog;
    move-result-object v0
    if-eqz v0, +020h
    invoke-virtual v0, Landroid/app/Dialog;->getWindow()Landroid/view/Window;
    move-result-object v0
    if-eqz v0, +01ah
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->widthPixels I
    int-to-double v1, v1
    const-wide/high16 v3, 4604930618986332160
    mul-double/2addr v1, v3
    double-to-int v1, v1
    const/4 v2, -2
    invoke-virtual v0, v1, v2, Landroid/view/Window;->setLayout(I I)V
    const/16 v1, 17
    invoke-virtual v0, v1, Landroid/view/Window;->setGravity(I)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v3, v4, v5, Landroidx/fragment/app/DialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    new-instance v5, Landroidx/lifecycle/ViewModelProvider;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const-string/jumbo v1, requireActivity(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v5, v0, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-virtual v5, v0, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    iput-object v5, v3, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v5
    if-eqz v5, +00ah
    const-string v0, "name"
    invoke-virtual v5, v0, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    const-string v5, ""
    sget v0, Lcom/bytedance/trae/home/R$id;->et_name I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/EditText;
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_char_count I
    invoke-virtual v4, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    move-object v2, v5
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v2
    invoke-virtual v0, v2, Landroid/widget/EditText;->setSelection(I)V
    invoke-virtual v0, Landroid/widget/EditText;->requestFocus()Z
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v2
    invoke-direct v3, v1, v2, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->updateCharCount(Landroid/widget/TextView; I)V
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$onViewCreated$1;
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$onViewCreated$1;-><init>(Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment; Landroid/widget/TextView;)V
    check-cast v2, Landroid/text/TextWatcher;
    invoke-virtual v0, v2, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_cancel I
    invoke-virtual v4, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$$ExternalSyntheticLambda0;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;)V
    invoke-virtual v1, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_save I
    invoke-virtual v4, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$$ExternalSyntheticLambda1;
    invoke-direct v1, v0, v3, v5, v4, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$$ExternalSyntheticLambda1;-><init>(Landroid/widget/EditText; Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment; Ljava/lang/String; Landroid/view/View;)V
    invoke-virtual v4, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    if-nez v5, +009h
    const-string/jumbo v5, viewModel
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v5, 0
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->getUpdateNameResult()Landroidx/lifecycle/LiveData;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/EventObserver;
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$$ExternalSyntheticLambda2;
    invoke-direct v2, v4, v3, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$$ExternalSyntheticLambda2;-><init>(Landroid/view/View; Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/EventObserver;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v1, Landroidx/lifecycle/Observer;
    invoke-virtual v5, v0, v1, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
.end method
