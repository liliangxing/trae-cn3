# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
.super Ljava/lang/Object;
.source "ToolDetailCard.kt"

.field private badgeText:Ljava/lang/String;
.field private contentView:Lkotlin/jvm/functions/Function1;
.field private contentViewInstance:Landroid/view/View;
.field private iconEmoji:Ljava/lang/String;
.field private iconResId:I
.field private iconTintColorRes:I
.field private onDetailClick:Lkotlin/jvm/functions/Function1;
.field private shimmerTitle:Z
.field private status:Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
.field private subtitle:Ljava/lang/String;
.field private title:Ljava/lang/String;


.method public constructor <init>(java.lang.String  int  int  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus  boolean  kotlin.jvm.functions.Function1)void
    .registers 12
    # ins_size=11
    const-string v0, "iconEmoji"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, title
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, status
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconEmoji Ljava/lang/String;
    iput v3, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconResId I
    iput v4, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconTintColorRes I
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->title Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->subtitle Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->badgeText Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->contentView Lkotlin/jvm/functions/Function1;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->status Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    iput-boolean v10, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->shimmerTitle Z
    iput-object v11, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->onDetailClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  int  int  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus  boolean  kotlin.jvm.functions.Function1  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 27
    # ins_size=13
    move/from16 v0, v25
    and-int/lit8 v1, v0, 2
    const/4 v2, 0
    if-eqz v1, +004h
    move v5, v2
    goto +3h
    move/from16 v5, v16
    and-int/lit8 v1, v0, 4
    if-eqz v1, +004h
    move v6, v2
    goto +3h
    move/from16 v6, v17
    and-int/lit8 v1, v0, 16
    const/4 v3, 0
    if-eqz v1, +004h
    move-object v8, v3
    goto +3h
    move-object/from16 v8, v19
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move-object v9, v3
    goto +3h
    move-object/from16 v9, v20
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v10, v3
    goto +3h
    move-object/from16 v10, v21
    and-int/lit16 v1, v0, 128
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-object v11, v1
    goto +3h
    move-object/from16 v11, v22
    and-int/lit16 v1, v0, 256
    if-eqz v1, +004h
    move v12, v2
    goto +3h
    move/from16 v12, v23
    and-int/lit16 v0, v0, 512
    if-eqz v0, +004h
    move-object v13, v3
    goto +3h
    move-object/from16 v13, v24
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v7, v18
    invoke-direct/range v3 ... v13, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard  java.lang.String  int  int  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus  boolean  kotlin.jvm.functions.Function1  int  java.lang.Object)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 24
    # ins_size=13
    move-object v0, v11
    move/from16 v1, v22
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconEmoji Ljava/lang/String;
    goto +2h
    move-object v2, v12
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget v3, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconResId I
    goto +2h
    move v3, v13
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconTintColorRes I
    goto +2h
    move v4, v14
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->title Ljava/lang/String;
    goto +2h
    move-object v5, v15
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->subtitle Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v16
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->badgeText Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v17
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->contentView Lkotlin/jvm/functions/Function1;
    goto +3h
    move-object/from16 v8, v18
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->status Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    goto +3h
    move-object/from16 v9, v19
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-boolean v10, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->shimmerTitle Z
    goto +3h
    move/from16 v10, v20
    and-int/lit16 v1, v1, 512
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->onDetailClick Lkotlin/jvm/functions/Function1;
    goto +3h
    move-object/from16 v1, v21
    move-object v12, v2
    move v13, v3
    move v14, v4
    move-object v15, v5
    move-object/from16 v16, v6
    move-object/from16 v17, v7
    move-object/from16 v18, v8
    move-object/from16 v19, v9
    move/from16 v20, v10
    move-object/from16 v21, v1
    invoke-virtual/range v11 ... v21, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->copy(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconEmoji Ljava/lang/String;
    return-object v0
.end method

.method public final component10()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->onDetailClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconResId I
    return v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconTintColorRes I
    return v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->subtitle Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->badgeText Ljava/lang/String;
    return-object v0
.end method

.method public final component7()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->contentView Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final component8()com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->status Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    return-object v0
.end method

.method public final component9()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->shimmerTitle Z
    return v0
.end method

.method public final copy(java.lang.String  int  int  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus  boolean  kotlin.jvm.functions.Function1)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 23
    # ins_size=11
    const-string v0, "iconEmoji"
    move-object v2, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, title
    move-object/from16 v5, v16
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, status
    move-object/from16 v9, v20
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-object v1, v0
    move v3, v14
    move v4, v15
    move-object/from16 v6, v17
    move-object/from16 v7, v18
    move-object/from16 v8, v19
    move/from16 v10, v21
    move-object/from16 v11, v22
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;-><init>(Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus; Z Lkotlin/jvm/functions/Function1;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconEmoji Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconEmoji Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconResId I
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconResId I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconTintColorRes I
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconTintColorRes I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->title Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->subtitle Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->subtitle Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->badgeText Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->badgeText Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->contentView Lkotlin/jvm/functions/Function1;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->contentView Lkotlin/jvm/functions/Function1;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->status Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->status Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->shimmerTitle Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->shimmerTitle Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->onDetailClick Lkotlin/jvm/functions/Function1;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->onDetailClick Lkotlin/jvm/functions/Function1;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getBadgeText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->badgeText Ljava/lang/String;
    return-object v0
.end method

.method public final getContentView()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->contentView Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getContentViewInstance()android.view.View
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->contentViewInstance Landroid/view/View;
    return-object v0
.end method

.method public final getIconEmoji()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconEmoji Ljava/lang/String;
    return-object v0
.end method

.method public final getIconResId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconResId I
    return v0
.end method

.method public final getIconTintColorRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconTintColorRes I
    return v0
.end method

.method public final getOnDetailClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->onDetailClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOrCreateContentView(android.content.Context)android.view.View
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->contentViewInstance Landroid/view/View;
    if-eqz v0, +003h
    return-object v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->contentView Lkotlin/jvm/functions/Function1;
    if-eqz v0, +009h
    invoke-interface v0, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Landroid/view/View;
    goto +2h
    const/4 v2, 0
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->contentViewInstance Landroid/view/View;
    return-object v2
.end method

.method public final getShimmerTitle()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->shimmerTitle Z
    return v0
.end method

.method public final getStatus()com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->status Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    return-object v0
.end method

.method public final getSubtitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->subtitle Ljava/lang/String;
    return-object v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->title Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconEmoji Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconResId I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconTintColorRes I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->title Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->subtitle Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->badgeText Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->contentView Lkotlin/jvm/functions/Function1;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->status Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->shimmerTitle Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->onDetailClick Lkotlin/jvm/functions/Function1;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final setBadgeText(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->badgeText Ljava/lang/String;
    return-void 
.end method

.method public final setContentView(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->contentView Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setContentViewInstance(android.view.View)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->contentViewInstance Landroid/view/View;
    return-void 
.end method

.method public final setIconEmoji(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconEmoji Ljava/lang/String;
    return-void 
.end method

.method public final setIconResId(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconResId I
    return-void 
.end method

.method public final setIconTintColorRes(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconTintColorRes I
    return-void 
.end method

.method public final setOnDetailClick(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->onDetailClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setShimmerTitle(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->shimmerTitle Z
    return-void 
.end method

.method public final setStatus(com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->status Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    return-void 
.end method

.method public final setSubtitle(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->subtitle Ljava/lang/String;
    return-void 
.end method

.method public final setTitle(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->title Ljava/lang/String;
    return-void 
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ToolDetailCard(iconEmoji="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconEmoji Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", iconResId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconResId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", iconTintColorRes="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->iconTintColorRes I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", title="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->title Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", subtitle="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->subtitle Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", badgeText="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->badgeText Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", contentView="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->contentView Lkotlin/jvm/functions/Function1;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", status="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->status Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", shimmerTitle="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->shimmerTitle Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", onDetailClick="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->onDetailClick Lkotlin/jvm/functions/Function1;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
