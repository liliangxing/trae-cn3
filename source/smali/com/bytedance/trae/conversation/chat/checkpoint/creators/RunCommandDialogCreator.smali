# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator;
.super Ljava/lang/Object;
.source "RunCommandDialogCreator.kt"

.implements Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;

.field public static final BLOCK_LEVEL_BLACKLIST:Ljava/lang/String;
.field public static final BLOCK_LEVEL_MANUAL:Ljava/lang/String;
.field public static final BLOCK_LEVEL_REDLIST:Ljava/lang/String;
.field public static final BLOCK_LEVEL_SANDBOX_EXECUTE_FAILURE:Ljava/lang/String;
.field public static final BLOCK_LEVEL_SANDBOX_NOT_BLOCK_COMMAND:Ljava/lang/String;
.field public static final BLOCK_LEVEL_SANDBOX_TO_RECOVERY:Ljava/lang/String;
.field public static final BLOCK_LEVEL_SANDBOX_UNAVAILABLE:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$Companion;


.method public static synthetic $r8$lambda$F6zI-aRegRK7buzNL2sJgc46jBc(androidx.core.widget.NestedScrollView  int)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator;->createContentView$lambda$15(Landroidx/core/widget/NestedScrollView; I)V
    return-void 
.end method

.method public static synthetic $r8$lambda$YOmj0AWUZmVyq3S-MVrK6ArsDQc(android.view.View  android.view.MotionEvent)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator;->createContentView$lambda$11$lambda$10(Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator;->Companion Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final buildCommandListText(android.content.Context  com.bytedance.trae.im.model.ConfirmInfo)java.lang.String
    .registers 15
    # ins_size=3
    const/4 v0, 0
    if-nez v14, +003h
    return-object v0
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ConfirmInfo;->getHitBlackList()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-nez v1, +007h
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ConfirmInfo;->getHitBlackList()Ljava/util/List;
    move-result-object v14
    goto +34h
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ConfirmInfo;->getHitRedList()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-nez v1, +007h
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ConfirmInfo;->getHitRedList()Ljava/util/List;
    move-result-object v14
    goto +1bh
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ConfirmInfo;->getRunningCommandList()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-nez v1, +007h
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ConfirmInfo;->getRunningCommandList()Ljava/util/List;
    move-result-object v14
    goto +2h
    move-object v14, v0
    move-object v1, v14
    check-cast v1, Ljava/util/Collection;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +003h
    return-object v0
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_warning_command_label I
    new-array v1, v3, [Ljava/lang/Object;
    move-object v3, v14
    check-cast v3, Ljava/lang/Iterable;
    const-string v14, ", "
    move-object v4, v14
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 62
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v14
    aput-object v14, v1, v2
    invoke-virtual v13, v0, v1, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    return-object v13
.end method

.method private final buildWarningView(android.content.Context  com.bytedance.trae.im.model.ConfirmInfo  float)android.view.View
    .registers 9
    # ins_size=4
    invoke-direct v5, v6, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator;->buildCommandListText(Landroid/content/Context; Lcom/bytedance/trae/im/model/ConfirmInfo;)Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    invoke-direct v5, v6, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator;->getWarningConfig(Landroid/content/Context; Lcom/bytedance/trae/im/model/ConfirmInfo;)Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
    move-result-object v7
    if-nez v7, +003h
    return-object v1
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v6, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 1
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v3, 12
    int-to-float v3, v3
    mul-float/2addr v3, v8
    float-to-int v3, v3
    const/16 v4, 10
    int-to-float v4, v4
    mul-float/2addr v4, v8
    float-to-int v4, v4
    invoke-virtual v1, v3, v4, v3, v4, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v3, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v3, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->getBgColor()I
    move-result v4
    invoke-virtual v3, v4, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v4, 8
    int-to-float v4, v4
    mul-float/2addr v4, v8
    invoke-virtual v3, v4, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v8, Landroid/widget/TextView;
    invoke-direct v8, v6, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v8, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;->getTextColor()I
    move-result v6
    invoke-virtual v8, v6, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v6, 2
    const/high16 v7, 1093664768
    invoke-virtual v8, v6, v7, Landroid/widget/TextView;->setTextSize(I F)V
    sget-object v6, Landroid/graphics/Typeface;->MONOSPACE Landroid/graphics/Typeface;
    invoke-virtual v8, v6, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v8, v2, Landroid/widget/TextView;->setMaxLines(I)V
    check-cast v8, Landroid/view/View;
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v7, -1
    const/4 v0, -2
    invoke-direct v6, v7, v0, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v8, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private static final createContentView$lambda$11$lambda$10(android.view.View  android.view.MotionEvent)boolean
    .registers 2
    # ins_size=2
    invoke-virtual v0, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    if-eqz v0, +006h
    const/4 v1, 1
    invoke-interface v0, v1, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    const/4 v0, 0
    return v0
.end method

.method private static final createContentView$lambda$15(androidx.core.widget.NestedScrollView  int)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, Landroidx/core/widget/NestedScrollView;->getHeight()I
    move-result v0
    if-le v0, v2, +00bh
    invoke-virtual v1, Landroidx/core/widget/NestedScrollView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    iput v2, v0, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v1, v0, Landroidx/core/widget/NestedScrollView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private final getDescriptionText(android.content.Context  com.bytedance.trae.im.model.ConfirmInfo)java.lang.String
    .registers 8
    # ins_size=3
    const/4 v0, 0
    if-nez v7, +003h
    return-object v0
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ConfirmInfo;->getBlockLevel()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    return-object v0
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    const/4 v3, 0
    const/4 v4, 1
    sparse-switch v2, +00000afh
    goto/16 +093h
    const-string/jumbo v2, sandbox_unavailable
    invoke-virtual v1, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +004h
    goto/16 +088h
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_warning_sandbox_unavailable I
    invoke-virtual v6, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    goto/16 +097h
    const-string v2, "blacklist"
    invoke-virtual v1, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +004h
    goto/16 +076h
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_warning_blacklist I
    invoke-virtual v6, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    goto/16 +085h
    const-string v2, "redlist"
    invoke-virtual v1, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    goto +64h
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_warning_redlist I
    invoke-virtual v6, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    goto/16 +074h
    const-string/jumbo v2, sandbox_not_block_command
    invoke-virtual v1, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    goto +52h
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_warning_sandbox_not_block I
    invoke-virtual v6, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    goto +62h
    const-string/jumbo v2, sandbox_to_recovery
    invoke-virtual v1, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    goto +41h
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_warning_sandbox_recovery I
    invoke-virtual v6, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    goto +51h
    const-string v2, "manual"
    invoke-virtual v1, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    goto +31h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ConfirmInfo;->getHitRedList()Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/util/Collection;
    if-eqz v7, +008h
    invoke-interface v7, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    if-eqz v7, +003h
    move v3, v4
    if-nez v3, +009h
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_warning_redlist I
    invoke-virtual v6, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    goto +30h
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_warning_manual I
    invoke-virtual v6, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    goto +29h
    const-string/jumbo v2, sandbox_execute_failure
    invoke-virtual v1, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    goto +8h
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_warning_sandbox_failure I
    invoke-virtual v6, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    goto +18h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ConfirmInfo;->getHitRedList()Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/util/Collection;
    if-eqz v7, +008h
    invoke-interface v7, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    if-eqz v7, +003h
    move v3, v4
    if-nez v3, +008h
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_warning_redlist I
    invoke-virtual v6, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    return-object v0
    nop 
    sparse-switch-payload -635aceb8 -4075183a -247a189f 3a0221b5 4093b8af 4f74291d 7a9f02d8
.end method

.method private final getWarningConfig(android.content.Context  com.bytedance.trae.im.model.ConfirmInfo)com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator$WarningConfig
    .registers 9
    # ins_size=3
    const/4 v7, 0
    if-nez v8, +003h
    return-object v7
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ConfirmInfo;->getBlockLevel()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ConfirmInfo;->getHitRedList()Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/util/Collection;
    const/4 v1, 1
    if-eqz v8, +00bh
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v8
    if-eqz v8, +003h
    goto +3h
    const/4 v8, 0
    goto +2h
    move v8, v1
    xor-int/2addr v8, v1
    const v1, 872369487
    const v2, -45745
    if-eqz v0, +0adh
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v3
    const v4, 872066324
    const v5, -2848762
    sparse-switch v3, +00000aah
    goto/16 +09eh
    const-string/jumbo v3, sandbox_unavailable
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +093h
    new-instance v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
    if-eqz v8, +003h
    goto +2h
    move v1, v4
    if-eqz v8, +003h
    goto +2h
    move v2, v5
    invoke-direct v7, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;-><init>(I I)V
    goto/16 +08bh
    const-string v3, "blacklist"
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +07ah
    new-instance v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
    invoke-direct v7, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;-><init>(I I)V
    goto/16 +07ah
    const-string v3, "redlist"
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +069h
    new-instance v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
    invoke-direct v7, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;-><init>(I I)V
    goto/16 +069h
    const-string/jumbo v3, sandbox_not_block_command
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +057h
    new-instance v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
    if-eqz v8, +003h
    goto +2h
    move v1, v4
    if-eqz v8, +003h
    goto +2h
    move v2, v5
    invoke-direct v7, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;-><init>(I I)V
    goto +4fh
    const-string/jumbo v3, sandbox_to_recovery
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +3eh
    new-instance v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
    if-eqz v8, +003h
    goto +2h
    move v1, v4
    if-eqz v8, +003h
    goto +2h
    move v2, v5
    invoke-direct v7, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;-><init>(I I)V
    goto +37h
    const-string v3, "manual"
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +27h
    if-eqz v8, +008h
    new-instance v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
    invoke-direct v7, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;-><init>(I I)V
    goto +26h
    new-instance v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
    invoke-direct v7, v4, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;-><init>(I I)V
    goto +20h
    const-string/jumbo v3, sandbox_execute_failure
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +fh
    new-instance v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
    if-eqz v8, +003h
    goto +2h
    move v1, v4
    if-eqz v8, +003h
    goto +2h
    move v2, v5
    invoke-direct v7, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;-><init>(I I)V
    goto +8h
    if-eqz v8, +007h
    new-instance v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;
    invoke-direct v7, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;-><init>(I I)V
    return-object v7
    nop 
    sparse-switch-payload -635aceb8 -4075183a -247a189f 3a0221b5 4093b8af 4f74291d 7a9f02d8
.end method

.method private final resolveWarningLevel(com.bytedance.trae.im.model.ConfirmInfo)com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator$WarningLevel
    .registers 6
    # ins_size=2
    if-nez v5, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;->NONE Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    return-object v5
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ConfirmInfo;->getBlockLevel()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +0bbh
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v3
    sparse-switch v3, +00000e3h
    goto/16 +0b2h
    const-string/jumbo v3, sandbox_unavailable
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +07bh
    goto/16 +0a7h
    const-string v3, "blacklist"
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +09dh
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;->HIGH Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    goto/16 +0c6h
    const-string v3, "redlist"
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +08fh
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;->NORMAL Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    goto/16 +0b8h
    const-string/jumbo v3, sandbox_not_block_command
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +054h
    goto/16 +080h
    const-string/jumbo v3, sandbox_to_recovery
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +049h
    goto/16 +075h
    const-string v3, "manual"
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +06bh
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ConfirmInfo;->getHitBlackList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;->HIGH Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    goto/16 +080h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ConfirmInfo;->getHitRedList()Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/util/Collection;
    if-eqz v5, +008h
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +003h
    move v1, v2
    if-nez v1, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;->NORMAL Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    goto/16 +06bh
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;->NONE Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    goto/16 +067h
    const-string/jumbo v3, sandbox_execute_failure
    invoke-virtual v0, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +2fh
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ConfirmInfo;->getHitBlackList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;->HIGH Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    goto +45h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ConfirmInfo;->getHitRedList()Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/util/Collection;
    if-eqz v5, +008h
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +003h
    move v1, v2
    if-nez v1, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;->NORMAL Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    goto +31h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;->NORMAL Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    goto +2eh
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ConfirmInfo;->getHitBlackList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;->HIGH Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    goto +17h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ConfirmInfo;->getHitRedList()Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/util/Collection;
    if-eqz v5, +008h
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +003h
    move v1, v2
    if-nez v1, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;->NORMAL Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    goto +3h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;->NONE Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    return-object v5
    sparse-switch-payload -635aceb8 -4075183a -247a189f 3a0221b5 4093b8af 4f74291d 7a9f02d8
.end method

.method public bindActions(android.view.View  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->bindActions(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Landroid/view/View; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public bindActions(android.view.View  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->bindActions(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Landroid/view/View; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public createContentView(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.im.model.ConfirmInfo)android.view.View
    .registers 16
    # ins_size=4
    const-string v0, "context"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator;->getCHECK_POINT_TAG()Ljava/lang/String;
    move-result-object v1
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[RunCommandDialogCreator] createContentView: toolCallInfo="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v13, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +00ah
    const-string v3, "command"
    invoke-virtual v1, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-nez v1, +010h
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v14
    if-eqz v14, +009h
    const-string v1, "cmd"
    invoke-virtual v14, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    goto +2h
    move-object v1, v2
    if-eqz v1, +012h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v14
    if-eqz v14, +003h
    move-object v2, v1
    if-eqz v2, +009h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v14
    if-eqz v14, +003h
    goto +3h
    const-string v14, ""
    invoke-direct v12, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator;->resolveWarningLevel(Lcom/bytedance/trae/im/model/ConfirmInfo;)Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    move-result-object v1
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v13, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v3, 1
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -1
    const/4 v5, -2
    invoke-direct v3, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;->NONE Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    const/16 v6, 12
    const/high16 v7, 1099431936
    const/16 v8, 16
    const/4 v9, 2
    if-ne v1, v3, +035h
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v13, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_run_command_title I
    invoke-virtual v13, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v1, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v13, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v1, v3, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v1, v9, v7, Landroid/widget/TextView;->setTextSize(I F)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->defaultMedium()Landroid/graphics/Typeface;
    move-result-object v3
    invoke-virtual v1, v3, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    check-cast v1, Landroid/view/View;
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v3, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v1, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    goto/16 +0a8h
    new-instance v3, Landroid/widget/LinearLayout;
    invoke-direct v3, v13, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v10, 0
    invoke-virtual v3, v10, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v3, v8, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v10, 20
    int-to-float v10, v10
    mul-float/2addr v10, v0
    float-to-int v10, v10
    sget-object v11, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;->HIGH Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;
    if-ne v1, v11, +005h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->warning_filled_red I
    goto +3h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->warning_filled_yellow I
    new-instance v11, Landroid/widget/ImageView;
    invoke-direct v11, v13, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    invoke-virtual v11, v1, Landroid/widget/ImageView;->setImageResource(I)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v1, v10, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v10, 4
    int-to-float v10, v10
    mul-float/2addr v10, v0
    float-to-int v10, v10
    invoke-virtual v1, v10, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v11, v1, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v11, Landroid/view/View;
    invoke-virtual v3, v11, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v13, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v10, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_run_command_title I
    invoke-virtual v13, v10, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    invoke-virtual v1, v10, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v10, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v13, v10, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v10
    invoke-virtual v1, v10, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v1, v9, v7, Landroid/widget/TextView;->setTextSize(I F)V
    sget-object v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->defaultMedium()Landroid/graphics/Typeface;
    move-result-object v7
    invoke-virtual v1, v7, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    check-cast v1, Landroid/view/View;
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v1, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v3, Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v1, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v3, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-direct v12, v13, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator;->getDescriptionText(Landroid/content/Context; Lcom/bytedance/trae/im/model/ConfirmInfo;)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +02dh
    new-instance v3, Landroid/widget/TextView;
    invoke-direct v3, v13, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v3, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v13, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v3, v1, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v1, 1097859072
    invoke-virtual v3, v9, v1, Landroid/widget/TextView;->setTextSize(I F)V
    check-cast v3, Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v1, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    int-to-float v7, v6
    mul-float/2addr v7, v0
    float-to-int v7, v7
    iput v7, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v3, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroidx/core/widget/NestedScrollView;
    invoke-direct v1, v13, Landroidx/core/widget/NestedScrollView;-><init>(Landroid/content/Context;)V
    int-to-float v3, v6
    mul-float/2addr v3, v0
    float-to-int v3, v3
    invoke-virtual v1, v3, v3, v3, v3, Landroidx/core/widget/NestedScrollView;->setPadding(I I I I)V
    new-instance v3, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v3, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v13, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v3, v6, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v6, 10
    int-to-float v6, v6
    mul-float/2addr v6, v0
    invoke-virtual v3, v6, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v3, Landroidx/core/widget/NestedScrollView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$$ExternalSyntheticLambda0;
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v1, v3, Landroidx/core/widget/NestedScrollView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    new-instance v3, Landroid/widget/TextView;
    invoke-direct v3, v13, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v14, Ljava/lang/CharSequence;
    invoke-virtual v3, v14, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget-object v14, Landroid/graphics/Typeface;->MONOSPACE Landroid/graphics/Typeface;
    invoke-virtual v3, v14, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    sget v14, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v13, v14, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v14
    invoke-virtual v3, v14, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v14, 1098907648
    invoke-virtual v3, v9, v14, Landroid/widget/TextView;->setTextSize(I F)V
    check-cast v3, Landroid/view/View;
    new-instance v14, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v14, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v14, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, v14, Landroidx/core/widget/NestedScrollView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    const/16 v14, 300
    int-to-float v14, v14
    mul-float/2addr v14, v0
    float-to-int v14, v14
    move-object v3, v1
    check-cast v3, Landroid/view/View;
    new-instance v6, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v6, v4, v5, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    int-to-float v7, v8
    mul-float/2addr v7, v0
    float-to-int v7, v7
    iput v7, v6, Landroid/widget/FrameLayout$LayoutParams;->topMargin I
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v3, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$$ExternalSyntheticLambda1;
    invoke-direct v3, v1, v14, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$$ExternalSyntheticLambda1;-><init>(Landroidx/core/widget/NestedScrollView; I)V
    invoke-virtual v1, v3, Landroidx/core/widget/NestedScrollView;->post(Ljava/lang/Runnable;)Z
    invoke-direct v12, v13, v15, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator;->buildWarningView(Landroid/content/Context; Lcom/bytedance/trae/im/model/ConfirmInfo; F)Landroid/view/View;
    move-result-object v13
    if-eqz v13, +015h
    new-instance v14, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v14, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v15, 8
    int-to-float v15, v15
    mul-float/2addr v15, v0
    float-to-int v15, v15
    iput v15, v14, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v14, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v13, v14, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v2, Landroid/view/View;
    return-object v2
.end method

.method public getCHECK_POINT_TAG()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getCHECK_POINT_TAG(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getContentTopMarginDp()int
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getContentTopMarginDp(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)I
    move-result v0
    return v0
.end method

.method public getContentTopMarginRes()int
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getContentTopMarginRes(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)I
    move-result v0
    return v0
.end method

.method public getHeaderLabel(android.content.Context)java.lang.String
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getHeaderLabel(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Landroid/content/Context;)Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method public getPrimaryButtonBackgroundRes()int
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getPrimaryButtonBackgroundRes(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)I
    move-result v0
    return v0
.end method

.method public getPrimaryButtonText(android.content.Context)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_run I
    invoke-virtual v2, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v0, "getString(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public getSecondaryButtonText(android.content.Context)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_deny I
    invoke-virtual v2, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v0, "getString(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public getTitle(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo)java.lang.String
    .registers 4
    # ins_size=3
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, toolCallInfo
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, ""
    return-object v2
.end method

.method public getTitleLetterSpacing()float
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getTitleLetterSpacing(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)F
    move-result v0
    return v0
.end method

.method public getTitleTextColorRes()int
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->getTitleTextColorRes(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)I
    move-result v0
    return v0
.end method

.method public hideDefaultButtons()boolean
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->hideDefaultButtons(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)Z
    move-result v0
    return v0
.end method

.method public setFileClickListener(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->setFileClickListener(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public setResolvedDisplayName(java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->setResolvedDisplayName(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Ljava/lang/String;)V
    return-void 
.end method

.method public showCloseButton()boolean
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator$DefaultImpls;->showCloseButton(Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)Z
    move-result v0
    return v0
.end method
