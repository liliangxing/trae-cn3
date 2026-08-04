# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "ChatAttachmentDialog.kt"

.field private static final ARG_CHAT_MODE:Ljava/lang/String;
.field private static final ARG_IDE_VERSION:Ljava/lang/String;
.field private static final ARG_IS_IDE:Ljava/lang/String;
.field private static final ARG_IS_LOCAL:Ljava/lang/String;
.field private static final ARG_SHOW_SKILLS:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$Companion;
.field public static final TAG:Ljava/lang/String;
.field private onAttachmentSelected:Lkotlin/jvm/functions/Function1;


.method public static synthetic $r8$lambda$2kyLxrmHKvk4g4SfsEQhJgS_Do0(com.bytedance.trae.conversation.widget.ChatAttachmentDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->setupVoiceLayout$lambda$12(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$JieQxDXK6Xgz7-prVrpug4Zbutg(android.content.DialogInterface)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->onViewCreated$lambda$4(Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$OiZ_jqK9P5KgezjLropNDmDObkk(com.bytedance.trae.conversation.widget.ChatAttachmentDialog  com.bytedance.trae.conversation.widget.AttachmentEntry  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->setupDynamicLayout$lambda$10$lambda$9(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog; Lcom/bytedance/trae/conversation/widget/AttachmentEntry; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$RwQpAoliI7cwep2VjLB_OHYvmlw(com.bytedance.trae.conversation.widget.ChatAttachmentDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->setupVoiceLayout$lambda$14(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Yh6eHnK6A43M9ktD0lRc91bz9Ss(com.google.android.material.bottomsheet.BottomSheetBehavior  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->onViewCreated$lambda$4$lambda$3$lambda$2(Lcom/google/android/material/bottomsheet/BottomSheetBehavior; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$iE5lG-Fqq800FzGlhGtoFS2FrqQ(com.bytedance.trae.conversation.widget.ChatAttachmentDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->setupVoiceLayout$lambda$13(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$t1KrO4RljbEKgdQp7Sl1PjvUdv0(com.bytedance.trae.conversation.widget.ChatAttachmentDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->setupVoiceLayout$lambda$11(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->Companion Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    return-void 
.end method

.method private final getChatMode()com.bytedance.trae.conversation.widget.ChatMode
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +02fh
    const-string v1, "chat_mode"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +027h
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    const/4 v0, 0
    check-cast v0, Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-eqz v0, +003h
    goto +3h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-object v0
    :try_start_0xe
.end method

.method private final getIdeVersion()java.lang.String
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +009h
    const-string v1, "ide_version"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method private final getShowSkills()boolean
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 1
    if-eqz v0, +009h
    const-string/jumbo v2, show_skills
    invoke-virtual v0, v2, v1, Landroid/os/Bundle;->getBoolean(Ljava/lang/String; Z)Z
    move-result v1
    return v1
.end method

.method private final getUseVoiceCompactLayout()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getShowSkills()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    return v0
.end method

.method private final isIde()boolean
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +008h
    const-string v2, "is_ide"
    invoke-virtual v0, v2, v1, Landroid/os/Bundle;->getBoolean(Ljava/lang/String; Z)Z
    move-result v1
    return v1
.end method

.method private final isLocal()boolean
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +008h
    const-string v2, "is_local"
    invoke-virtual v0, v2, v1, Landroid/os/Bundle;->getBoolean(Ljava/lang/String; Z)Z
    move-result v1
    return v1
.end method

.method private static final onViewCreated$lambda$4(android.content.DialogInterface)void
    .registers 3
    # ins_size=1
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    sget v0, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v2
    if-eqz v2, +018h
    const v0, 17170445
    invoke-virtual v2, v0, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v0
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    new-instance v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda5;
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda5;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetBehavior; Landroid/view/View;)V
    invoke-virtual v2, v1, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final onViewCreated$lambda$4$lambda$3$lambda$2(com.google.android.material.bottomsheet.BottomSheetBehavior  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v1, Landroid/view/View;->getMeasuredHeight()I
    move-result v1
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v1, 3
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    return-void 
.end method

.method private final setupDynamicLayout(android.view.View)void
    .registers 18
    # ins_size=2
    sget v0, Lcom/bytedance/trae/conversation/R$id;->container I
    move-object/from16 v1, v17
    invoke-virtual v1, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/LinearLayout;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->requireContext()Landroid/content/Context;
    move-result-object v1
    invoke-static v1, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;->INSTANCE Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;->getEntries()Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +035h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->isVisible()Lkotlin/jvm/functions/Function4;
    move-result-object v5
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getChatMode()Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v6
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->isLocal()Z
    move-result v7
    invoke-static v7, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v7
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->isIde()Z
    move-result v8
    invoke-static v8, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v8
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getIdeVersion()Ljava/lang/String;
    move-result-object v9
    invoke-interface v5, v6, v7, v8, v9, Lkotlin/jvm/functions/Function4;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Boolean;
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    if-eqz v5, -033h
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -38h
    check-cast v3, Ljava/util/List;
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;->INSTANCE Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;->rowLayout(I)Ljava/util/List;
    move-result-object v2
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_12 I
    invoke-virtual v4, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    const/4 v5, 0
    move v6, v5
    move v7, v6
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +0afh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    add-int/lit8 v9, v6, 1
    if-gez v6, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v8, Ljava/lang/Number;
    invoke-virtual v8, Ljava/lang/Number;->intValue()I
    move-result v8
    const/4 v10, -1
    if-lez v6, +018h
    new-instance v6, Landroid/view/View;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->requireContext()Landroid/content/Context;
    move-result-object v11
    invoke-direct v6, v11, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v11, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v11, v10, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v11, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v0, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v6, Landroid/widget/LinearLayout;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->requireContext()Landroid/content/Context;
    move-result-object v11
    invoke-direct v6, v11, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v6, v5, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v11, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v12, -2
    invoke-direct v11, v10, v12, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v11, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    move v11, v5
    if-ge v11, v8, +061h
    if-lez v11, +018h
    new-instance v12, Landroid/view/View;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->requireContext()Landroid/content/Context;
    move-result-object v13
    invoke-direct v12, v13, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v13, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v13, v4, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v13, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v13, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v6, v12, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    add-int/lit8 v12, v7, 1
    invoke-interface v3, v7, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;
    sget v13, Lcom/bytedance/trae/conversation/R$layout;->item_chat_attachment_entry I
    move-object v14, v6
    check-cast v14, Landroid/view/ViewGroup;
    invoke-virtual v1, v13, v14, v5, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v13
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->getViewIdRes()I
    move-result v14
    invoke-virtual v13, v14, Landroid/view/View;->setId(I)V
    sget v14, Lcom/bytedance/trae/conversation/R$id;->iv_icon I
    invoke-virtual v13, v14, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v14
    check-cast v14, Landroid/widget/ImageView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->getIconRes()I
    move-result v15
    invoke-virtual v14, v15, Landroid/widget/ImageView;->setImageResource(I)V
    sget v14, Lcom/bytedance/trae/conversation/R$id;->tv_label I
    invoke-virtual v13, v14, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v14
    check-cast v14, Landroid/widget/TextView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->getLabelRes()I
    move-result v15
    invoke-virtual v14, v15, Landroid/widget/TextView;->setText(I)V
    new-instance v14, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda6;
    move-object/from16 v15, v16
    invoke-direct v14, v15, v7, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog; Lcom/bytedance/trae/conversation/widget/AttachmentEntry;)V
    invoke-virtual v13, v14, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v6, v13, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    add-int/lit8 v11, v11, 1
    move v7, v12
    goto -60h
    move-object/from16 v15, v16
    check-cast v6, Landroid/view/View;
    invoke-virtual v0, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move v6, v9
    goto/16 -0b1h
    move-object/from16 v15, v16
    return-void 
.end method

.method private static final setupDynamicLayout$lambda$10$lambda$9(com.bytedance.trae.conversation.widget.ChatAttachmentDialog  com.bytedance.trae.conversation.widget.AttachmentEntry  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->getType()Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    move-result-object v2
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->trackAttachment(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->onAttachmentSelected Lkotlin/jvm/functions/Function1;
    if-eqz v2, +009h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->getType()Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    move-result-object v1
    invoke-interface v2, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->dismiss()V
    return-void 
.end method

.method private final setupVoiceLayout(android.view.View)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getChatMode()Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v1, +01ah
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_files I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const/16 v1, 8
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->spacer_photo_files I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_close I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda1;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_camera I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda2;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_photo I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda3;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_files I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    if-eqz v3, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda4;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;)V
    invoke-virtual v3, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupVoiceLayout$lambda$11(com.bytedance.trae.conversation.widget.ChatAttachmentDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->dismiss()V
    return-void 
.end method

.method private static final setupVoiceLayout$lambda$12(com.bytedance.trae.conversation.widget.ChatAttachmentDialog  android.view.View)void
    .registers 3
    # ins_size=2
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->CAMERA Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->trackAttachment(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->onAttachmentSelected Lkotlin/jvm/functions/Function1;
    if-eqz v2, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->CAMERA Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-interface v2, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->dismiss()V
    return-void 
.end method

.method private static final setupVoiceLayout$lambda$13(com.bytedance.trae.conversation.widget.ChatAttachmentDialog  android.view.View)void
    .registers 3
    # ins_size=2
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->PHOTO Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->trackAttachment(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->onAttachmentSelected Lkotlin/jvm/functions/Function1;
    if-eqz v2, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->PHOTO Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-interface v2, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->dismiss()V
    return-void 
.end method

.method private static final setupVoiceLayout$lambda$14(com.bytedance.trae.conversation.widget.ChatAttachmentDialog  android.view.View)void
    .registers 3
    # ins_size=2
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->FILES Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->trackAttachment(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->onAttachmentSelected Lkotlin/jvm/functions/Function1;
    if-eqz v2, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->FILES Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-interface v2, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->dismiss()V
    return-void 
.end method

.method private final trackAttachment(com.bytedance.trae.conversation.widget.ChatAttachmentDialog$AttachmentType)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +021h
    const/4 v0, 2
    if-eq v2, v0, +01bh
    const/4 v0, 3
    if-eq v2, v0, +015h
    const/4 v0, 4
    if-eq v2, v0, +00fh
    const/4 v0, 5
    if-ne v2, v0, +006h
    const-string/jumbo v2, skill
    goto +12h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    const-string v2, "plugin"
    goto +9h
    const-string v2, "file"
    goto +6h
    const-string v2, "image"
    goto +3h
    const-string v2, "camera"
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/InputTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/InputTracker;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/tracker/InputTracker;->trackAttachmentClick(Ljava/lang/String;)V
    return-void 
.end method

.method public final getOnAttachmentSelected()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->onAttachmentSelected Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getUseVoiceCompactLayout()Z
    move-result v4
    if-eqz v4, +005h
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->dialog_chat_attachment_voice I
    goto +3h
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->dialog_chat_attachment I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getUseVoiceCompactLayout()Z
    move-result v3
    if-eqz v3, +006h
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->setupVoiceLayout(Landroid/view/View;)V
    goto +4h
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->setupDynamicLayout(Landroid/view/View;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getDialog()Landroid/app/Dialog;
    move-result-object v2
    if-eqz v2, +00ah
    new-instance v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda0;
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v2, v3, Landroid/app/Dialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    return-void 
.end method

.method public final setOnAttachmentSelected(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->onAttachmentSelected Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final showOnce(androidx.fragment.app.FragmentManager)boolean
    .registers 5
    # ins_size=2
    const-string v0, "fragmentManager"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return v1
    const-string v0, "ChatAttachmentDialog"
    invoke-virtual v4, v0, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v2
    if-eqz v2, +003h
    return v1
    invoke-virtual v3, v4, v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->showNow(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    const/4 v4, 1
    return v4
.end method
