# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "SkillsBottomSheet.kt"

.field private static final ARG_AGENT_TYPE:Ljava/lang/String;
.field private static final ARG_CLI_ID:Ljava/lang/String;
.field private static final ARG_CONFIG_NAME:Ljava/lang/String;
.field private static final ARG_CONVERSATION_ID:Ljava/lang/String;
.field private static final ARG_IS_IDE_SKILLS:Ljava/lang/String;
.field private static final ARG_PROJECT_ID:Ljava/lang/String;
.field private static final ARG_WORKSPACE_FOLDER:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$Companion;
.field private adapter:Lcom/bytedance/trae/conversation/skill/SkillsAdapter;
.field private fullSkillsList:Ljava/util/List;
.field private onSkillSelected:Lkotlin/jvm/functions/Function1;
.field private final viewModel$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$-ofbrLMFBq2DuK1e_ulCTEdGEUE(com.bytedance.trae.conversation.skill.SkillsBottomSheet  android.widget.LinearLayout  androidx.recyclerview.widget.RecyclerView  android.widget.TextView  android.widget.FrameLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView  android.widget.LinearLayout  java.lang.Boolean)kotlin.Unit
    .registers 9
    # ins_size=9
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->onViewCreated$lambda$5(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet; Landroid/widget/LinearLayout; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/TextView; Landroid/widget/FrameLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView; Landroid/widget/LinearLayout; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$3Lay0syy_ONevPTnzHYEAz35ysI(com.bytedance.trae.conversation.skill.SkillsBottomSheet  android.widget.LinearLayout  androidx.recyclerview.widget.RecyclerView  android.widget.TextView  android.widget.FrameLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView  android.widget.LinearLayout  java.lang.String)kotlin.Unit
    .registers 9
    # ins_size=9
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->onViewCreated$lambda$7(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet; Landroid/widget/LinearLayout; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/TextView; Landroid/widget/FrameLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView; Landroid/widget/LinearLayout; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$7vzfte56tCAXmr5GEAR5r9O-MGw(com.bytedance.trae.conversation.skill.SkillsBottomSheet  android.widget.LinearLayout  androidx.recyclerview.widget.RecyclerView  android.widget.TextView  android.widget.FrameLayout  com.bytedance.trae.common.widget.TraeTitleBar  boolean  android.widget.TextView  android.widget.LinearLayout  java.lang.Boolean)kotlin.Unit
    .registers 10
    # ins_size=10
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->onViewCreated$lambda$6(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet; Landroid/widget/LinearLayout; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/TextView; Landroid/widget/FrameLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Z Landroid/widget/TextView; Landroid/widget/LinearLayout; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$KbGfV2D2Llm3EXD6gt9oZtW8n3U(com.bytedance.trae.conversation.skill.SkillsBottomSheet  com.bytedance.trae.conversation.network.SkillItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->onViewCreated$lambda$3(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet; Lcom/bytedance/trae/conversation/network/SkillItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Ni4eUMurg_Nk5zarVRX50ABGKf0(com.bytedance.trae.conversation.skill.SkillsBottomSheet  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.TextView  androidx.recyclerview.widget.RecyclerView  android.widget.FrameLayout  java.util.List)kotlin.Unit
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->onViewCreated$lambda$10(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/FrameLayout; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$c0OF5TQnXT6dk5uA529aes8czfs(android.widget.EditText  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->onViewCreated$lambda$4(Landroid/widget/EditText; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$qq9axvF5n_H-aic3819JYLvt-Do(com.bytedance.trae.conversation.skill.SkillsBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->onViewCreated$lambda$2(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$uU4rQPLzbdFevINRxaURjv1mPr4(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.skill.SkillsBottomSheet  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->onCreateDialog$lambda$1(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->Companion Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 6
    # ins_size=1
    invoke-direct v5, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    move-object v0, v5
    check-cast v0, Landroidx/fragment/app/Fragment;
    new-instance v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$special$$inlined$viewModels$default$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$special$$inlined$viewModels$default$1;-><init>(Landroidx/fragment/app/Fragment;)V
    check-cast v1, Lkotlin/jvm/functions/Function0;
    const-class v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-static v2, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$special$$inlined$viewModels$default$2;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$special$$inlined$viewModels$default$2;-><init>(Lkotlin/jvm/functions/Function0;)V
    check-cast v3, Lkotlin/jvm/functions/Function0;
    new-instance v4, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$special$$inlined$viewModels$default$3;
    invoke-direct v4, v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$special$$inlined$viewModels$default$3;-><init>(Lkotlin/jvm/functions/Function0; Landroidx/fragment/app/Fragment;)V
    check-cast v4, Lkotlin/jvm/functions/Function0;
    invoke-static v0, v2, v3, v4, Landroidx/fragment/app/FragmentViewModelLazyKt;->createViewModelLazy(Landroidx/fragment/app/Fragment; Lkotlin/reflect/KClass; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v5, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->viewModel$delegate Lkotlin/Lazy;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v5, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->fullSkillsList Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$getAdapter$p(com.bytedance.trae.conversation.skill.SkillsBottomSheet)com.bytedance.trae.conversation.skill.SkillsAdapter
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->adapter Lcom/bytedance/trae/conversation/skill/SkillsAdapter;
    return-object v0
.end method

.method public static final synthetic access$getFullSkillsList$p(com.bytedance.trae.conversation.skill.SkillsBottomSheet)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->fullSkillsList Ljava/util/List;
    return-object v0
.end method

.method private final getViewModel()com.bytedance.trae.conversation.skill.SkillsViewModel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->viewModel$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    return-object v0
.end method

.method private static final onCreateDialog$lambda$1(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.skill.SkillsBottomSheet  android.content.DialogInterface)void
    .registers 4
    # ins_size=3
    sget v3, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v1, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/FrameLayout;
    if-eqz v1, +035h
    new-instance v3, Landroid/graphics/drawable/ColorDrawable;
    const/4 v0, 0
    invoke-direct v3, v0, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v3, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->heightPixels I
    mul-int/lit8 v2, v2, 9
    div-int/lit8 v2, v2, 10
    invoke-virtual v1, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v3
    iput v2, v3, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v1, Landroid/widget/FrameLayout;->requestLayout()V
    check-cast v1, Landroid/view/View;
    invoke-static v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v1
    invoke-virtual v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v2, 3
    invoke-virtual v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v2, 1
    invoke-virtual v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    return-void 
.end method

.method private static final onViewCreated$lambda$10(com.bytedance.trae.conversation.skill.SkillsBottomSheet  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.TextView  androidx.recyclerview.widget.RecyclerView  android.widget.FrameLayout  java.util.List)kotlin.Unit
    .registers 10
    # ins_size=7
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->stopLoadingAnimation(Landroid/widget/LinearLayout;)V
    const/16 v0, 8
    invoke-virtual v4, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-virtual v5, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    iput-object v9, v3, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->fullSkillsList Ljava/util/List;
    iget-object v3, v3, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->adapter Lcom/bytedance/trae/conversation/skill/SkillsAdapter;
    if-nez v3, +008h
    const-string v3, "adapter"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v3, 0
    invoke-virtual v3, v9, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->updateData(Ljava/util/List;)V
    const/4 v3, 0
    move-object v4, v9
    check-cast v4, Ljava/lang/Iterable;
    instance-of v1, v4, Ljava/util/Collection;
    if-eqz v1, +00dh
    move-object v1, v4
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +004h
    move v1, v3
    goto +20h
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    move v1, v3
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +016h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/network/SkillItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/SkillItem;->getEnabled()Z
    move-result v2
    if-eqz v2, -010h
    add-int/lit8 v1, v1, 1
    if-gez v1, -014h
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -19h
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/InputTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/InputTracker;
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/tracker/InputTracker;->trackSkillsPanelShow(I)V
    check-cast v9, Ljava/lang/Iterable;
    instance-of v4, v9, Ljava/util/Collection;
    const/4 v1, 1
    if-eqz v4, +00ch
    move-object v4, v9
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +003h
    goto +18h
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +00fh
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/network/SkillItem;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/network/SkillItem;->getEnabled()Z
    move-result v9
    if-eqz v9, -010h
    move v1, v3
    if-eqz v1, +004h
    move v4, v3
    goto +2h
    move v4, v0
    invoke-virtual v5, v4, Landroid/widget/LinearLayout;->setVisibility(I)V
    if-eqz v1, +004h
    move v4, v3
    goto +2h
    move v4, v0
    invoke-virtual v6, v4, Landroid/widget/TextView;->setVisibility(I)V
    if-eqz v1, +004h
    move v4, v0
    goto +2h
    move v4, v3
    invoke-virtual v7, v4, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    if-eqz v1, +003h
    goto +2h
    move v0, v3
    invoke-virtual v8, v0, Landroid/widget/FrameLayout;->setVisibility(I)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    :try_start_0x21
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.conversation.skill.SkillsBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->dismiss()V
    return-void 
.end method

.method private static final onViewCreated$lambda$3(com.bytedance.trae.conversation.skill.SkillsBottomSheet  com.bytedance.trae.conversation.network.SkillItem)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string/jumbo v0, skill
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/InputTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/InputTracker;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/SkillItem;->getName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/tracker/InputTracker;->trackSkillSelectClick(Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->onSkillSelected Lkotlin/jvm/functions/Function1;
    if-eqz v0, +005h
    invoke-interface v0, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->dismiss()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onViewCreated$lambda$4(android.widget.EditText  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-interface v0, Landroid/text/Editable;->clear()V
    return-void 
.end method

.method private static final onViewCreated$lambda$5(com.bytedance.trae.conversation.skill.SkillsBottomSheet  android.widget.LinearLayout  androidx.recyclerview.widget.RecyclerView  android.widget.TextView  android.widget.FrameLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView  android.widget.LinearLayout  java.lang.Boolean)kotlin.Unit
    .registers 9
    # ins_size=9
    invoke-virtual v8, Ljava/lang/Boolean;->booleanValue()Z
    move-result v8
    if-eqz v8, +024h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->stopLoadingAnimation(Landroid/widget/LinearLayout;)V
    const/16 v0, 8
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-virtual v2, v0, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    invoke-virtual v3, v0, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v4, v0, Landroid/widget/FrameLayout;->setVisibility(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_skills_error_offline_title I
    invoke-virtual v5, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_skills_error_project_offline_content I
    invoke-virtual v6, v0, Landroid/widget/TextView;->setText(I)V
    const/4 v0, 0
    invoke-virtual v7, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onViewCreated$lambda$6(com.bytedance.trae.conversation.skill.SkillsBottomSheet  android.widget.LinearLayout  androidx.recyclerview.widget.RecyclerView  android.widget.TextView  android.widget.FrameLayout  com.bytedance.trae.common.widget.TraeTitleBar  boolean  android.widget.TextView  android.widget.LinearLayout  java.lang.Boolean)kotlin.Unit
    .registers 10
    # ins_size=10
    invoke-virtual v9, Ljava/lang/Boolean;->booleanValue()Z
    move-result v9
    if-eqz v9, +029h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->stopLoadingAnimation(Landroid/widget/LinearLayout;)V
    const/16 v0, 8
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-virtual v2, v0, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    invoke-virtual v3, v0, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v4, v0, Landroid/widget/FrameLayout;->setVisibility(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_skills_error_offline_title I
    invoke-virtual v5, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(I)V
    if-eqz v6, +005h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_skills_error_offline_content I
    goto +3h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_skills_error_lite_offline_content I
    invoke-virtual v7, v0, Landroid/widget/TextView;->setText(I)V
    const/4 v0, 0
    invoke-virtual v8, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onViewCreated$lambda$7(com.bytedance.trae.conversation.skill.SkillsBottomSheet  android.widget.LinearLayout  androidx.recyclerview.widget.RecyclerView  android.widget.TextView  android.widget.FrameLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView  android.widget.LinearLayout  java.lang.String)kotlin.Unit
    .registers 9
    # ins_size=9
    if-eqz v8, +024h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->stopLoadingAnimation(Landroid/widget/LinearLayout;)V
    const/16 v0, 8
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-virtual v2, v0, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    invoke-virtual v3, v0, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v4, v0, Landroid/widget/FrameLayout;->setVisibility(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_skills_error_offline_title I
    invoke-virtual v5, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(I)V
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_disconnected I
    invoke-virtual v6, v0, Landroid/widget/TextView;->setText(I)V
    const/4 v0, 0
    invoke-virtual v7, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final setupLoadingViews(android.widget.LinearLayout)void
    .registers 7
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, requireContext(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    const/16 v2, 20
    int-to-float v2, v2
    mul-float/2addr v2, v1
    float-to-int v2, v2
    new-instance v3, Landroid/widget/ImageView;
    invoke-direct v3, v0, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_artifact_loading_spinner I
    invoke-virtual v3, v4, Landroid/widget/ImageView;->setImageResource(I)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v4, v2, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v2, 1
    iput v2, v4, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v4, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v3, Landroid/view/View;
    invoke-virtual v6, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v3, Landroid/widget/TextView;
    invoke-direct v3, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_artifact_loading I
    invoke-virtual v0, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v3, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_disabled I
    invoke-virtual v0, v4, Landroid/content/Context;->getColor(I)I
    move-result v0
    invoke-virtual v3, v0, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v0, 2
    const/high16 v4, 1097859072
    invoke-virtual v3, v0, v4, Landroid/widget/TextView;->setTextSize(I F)V
    const/16 v0, 17
    invoke-virtual v3, v0, Landroid/widget/TextView;->setGravity(I)V
    const/4 v0, 0
    invoke-virtual v3, v0, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -2
    invoke-direct v0, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v2, v0, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    const/16 v2, 8
    int-to-float v2, v2
    mul-float/2addr v2, v1
    float-to-int v1, v2
    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v0, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v3, Landroid/view/View;
    invoke-virtual v6, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    return-void 
.end method

.method private final startLoadingAnimation(android.widget.LinearLayout)void
    .registers 10
    # ins_size=2
    const/4 v0, 0
    invoke-virtual v9, v0, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v9
    if-nez v9, +003h
    return-void 
    new-instance v7, Landroid/view/animation/RotateAnimation;
    const/4 v1, 0
    const/high16 v2, 1135869952
    const/4 v3, 1
    const/high16 v4, 1056964608
    const/4 v5, 1
    const/high16 v6, 1056964608
    move-object v0, v7
    invoke-direct/range v0 ... v6, Landroid/view/animation/RotateAnimation;-><init>(F F I F I F)V
    const-wide/16 v0, 1000
    invoke-virtual v7, v0, v1, Landroid/view/animation/RotateAnimation;->setDuration(J)V
    const/4 v0, -1
    invoke-virtual v7, v0, Landroid/view/animation/RotateAnimation;->setRepeatCount(I)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/StepInterpolator;
    const/16 v1, 8
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/StepInterpolator;-><init>(I)V
    check-cast v0, Landroid/view/animation/Interpolator;
    invoke-virtual v7, v0, Landroid/view/animation/RotateAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V
    check-cast v7, Landroid/view/animation/Animation;
    invoke-virtual v9, v7, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V
    return-void 
.end method

.method private final stopLoadingAnimation(android.widget.LinearLayout)void
    .registers 3
    # ins_size=2
    const/4 v0, 0
    invoke-virtual v2, v0, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    invoke-virtual v2, Landroid/view/View;->clearAnimation()V
    return-void 
.end method

.method public final getOnSkillSelected()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->onSkillSelected Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v2
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    new-instance v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda7;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda7;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v2, Landroid/app/Dialog;
    return-object v2
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->bottom_sheet_skills I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 22
    # ins_size=3
    move-object/from16 v10, v19
    move-object/from16 v0, v20
    const-string/jumbo v1, view
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super/range v19 ... v21, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    move-result-object v1
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +009h
    const-string v4, "arg_cli_id"
    invoke-virtual v2, v4, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v3
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->setCliId(Ljava/lang/String;)V
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +00ah
    const-string v4, "arg_is_ide_skills"
    invoke-virtual v1, v4, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v1
    move v9, v1
    goto +2h
    move v9, v2
    if-nez v9, +02ch
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    move-result-object v1
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v4
    if-eqz v4, +009h
    const-string v5, "arg_config_name"
    invoke-virtual v4, v5, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v3
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->setConfigName(Ljava/lang/String;)V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    move-result-object v1
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v4
    if-eqz v4, +009h
    const-string v5, "arg_agent_type"
    invoke-virtual v4, v5, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v3
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->setAgentType(Ljava/lang/String;)V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    move-result-object v1
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v4
    if-eqz v4, +009h
    const-string v5, "arg_workspace_folder"
    invoke-virtual v4, v5, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v3
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->setWorkspaceFolder(Ljava/lang/String;)V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    move-result-object v1
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v4
    if-eqz v4, +009h
    const-string v5, "arg_project_id"
    invoke-virtual v4, v5, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v3
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->setProjectId(Ljava/lang/String;)V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    move-result-object v1
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v4
    if-eqz v4, +009h
    const-string v5, "arg_conversation_id"
    invoke-virtual v4, v5, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v3
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->setConversationId(Ljava/lang/String;)V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->loadSkills()V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->recycler_view I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    move-object v12, v1
    check-cast v12, Landroidx/recyclerview/widget/RecyclerView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_empty_state I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    move-object v13, v1
    check-cast v13, Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->loading_container I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    move-object v14, v1
    check-cast v14, Landroid/widget/LinearLayout;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->error_container I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    move-object v15, v1
    check-cast v15, Landroid/widget/LinearLayout;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_error_content I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    move-object/from16 v16, v1
    check-cast v16, Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->search_container I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/FrameLayout;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->et_search I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/EditText;
    sget v4, Lcom/bytedance/trae/conversation/R$id;->iv_search_clear I
    invoke-virtual v0, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/ImageView;
    sget-object v4, Lcom/bytedance/trae/conversation/skill/SkillsEmptyStateTextPolicy;->INSTANCE Lcom/bytedance/trae/conversation/skill/SkillsEmptyStateTextPolicy;
    invoke-virtual v4, v9, Lcom/bytedance/trae/conversation/skill/SkillsEmptyStateTextPolicy;->emptyStateTextRes(Z)I
    move-result v4
    invoke-virtual v13, v4, Landroid/widget/TextView;->setText(I)V
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v10, v14, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->setupLoadingViews(Landroid/widget/LinearLayout;)V
    invoke-virtual v14, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v10, v14, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->startLoadingAnimation(Landroid/widget/LinearLayout;)V
    const/16 v2, 8
    invoke-virtual v12, v2, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    invoke-virtual v13, v2, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v8, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    new-instance v2, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v2, v10, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;)V
    invoke-virtual v11, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v2, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;
    const/4 v4, 3
    invoke-direct v2, v3, v3, v4, v3, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;-><init>(Ljava/util/List; Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v10, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->adapter Lcom/bytedance/trae/conversation/skill/SkillsAdapter;
    new-instance v4, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v4, v10, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;)V
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->setOnItemClickListener(Lkotlin/jvm/functions/Function1;)V
    new-instance v2, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->requireContext()Landroid/content/Context;
    move-result-object v4
    invoke-direct v2, v4, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v12, v2, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    iget-object v2, v10, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->adapter Lcom/bytedance/trae/conversation/skill/SkillsAdapter;
    if-nez v2, +008h
    const-string v2, "adapter"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v2
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v12, v3, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    new-instance v2, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda2;
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda2;-><init>(Landroid/widget/EditText;)V
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v2, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$onViewCreated$4;
    invoke-direct v2, v0, v10, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$onViewCreated$4;-><init>(Landroid/widget/ImageView; Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;)V
    check-cast v2, Landroid/text/TextWatcher;
    invoke-virtual v1, v2, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->isDeviceProjectOffline()Landroidx/lifecycle/LiveData;
    move-result-object v7
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v6
    new-instance v5, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda3;
    move-object v0, v5
    move-object/from16 v1, v19
    move-object v2, v14
    move-object v3, v12
    move-object v4, v13
    move-object v10, v5
    move-object v5, v8
    move/from16 v21, v9
    move-object v9, v6
    move-object v6, v11
    move-object/from16 v17, v11
    move-object v11, v7
    move-object/from16 v7, v16
    move-object/from16 v18, v8
    move-object v8, v15
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet; Landroid/widget/LinearLayout; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/TextView; Landroid/widget/FrameLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView; Landroid/widget/LinearLayout;)V
    new-instance v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v0, Landroidx/lifecycle/Observer;
    invoke-virtual v11, v9, v0, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->isDeviceOffline()Landroidx/lifecycle/LiveData;
    move-result-object v10
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v11
    new-instance v9, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda4;
    move-object v0, v9
    move-object/from16 v5, v18
    move-object/from16 v6, v17
    move/from16 v7, v21
    move-object/from16 v8, v16
    move-object/from16 v21, v13
    move-object v13, v9
    move-object v9, v15
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet; Landroid/widget/LinearLayout; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/TextView; Landroid/widget/FrameLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Z Landroid/widget/TextView; Landroid/widget/LinearLayout;)V
    new-instance v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v0, v13, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v0, Landroidx/lifecycle/Observer;
    invoke-virtual v10, v11, v0, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->getError()Landroidx/lifecycle/LiveData;
    move-result-object v9
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v10
    new-instance v11, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda5;
    move-object v0, v11
    move-object/from16 v4, v21
    move-object/from16 v7, v16
    move-object v8, v15
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet; Landroid/widget/LinearLayout; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/TextView; Landroid/widget/FrameLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView; Landroid/widget/LinearLayout;)V
    new-instance v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v0, v11, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v0, Landroidx/lifecycle/Observer;
    invoke-virtual v9, v10, v0, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewModel()Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->getSkills()Landroidx/lifecycle/LiveData;
    move-result-object v7
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v8
    new-instance v9, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;
    move-object v0, v9
    move-object v3, v15
    move-object v5, v12
    move-object/from16 v6, v18
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/FrameLayout;)V
    new-instance v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v0, v9, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v0, Landroidx/lifecycle/Observer;
    invoke-virtual v7, v8, v0, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
.end method

.method public final setOnSkillSelected(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->onSkillSelected Lkotlin/jvm/functions/Function1;
    return-void 
.end method
