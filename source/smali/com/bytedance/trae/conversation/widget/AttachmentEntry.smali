# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/AttachmentEntry;
.super Ljava/lang/Object;
.source "ChatAttachmentConfig.kt"

.field private final iconRes:I
.field private final isVisible:Lkotlin/jvm/functions/Function4;
.field private final labelRes:I
.field private final type:Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
.field private final viewIdRes:I


.method public constructor <init>(com.bytedance.trae.conversation.widget.ChatAttachmentDialog$AttachmentType  int  int  int  kotlin.jvm.functions.Function4)void
    .registers 7
    # ins_size=6
    const-string/jumbo v0, type
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "isVisible"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->type Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    iput v3, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->viewIdRes I
    iput v4, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->iconRes I
    iput v5, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->labelRes I
    iput-object v6, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->isVisible Lkotlin/jvm/functions/Function4;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.widget.AttachmentEntry  com.bytedance.trae.conversation.widget.ChatAttachmentDialog$AttachmentType  int  int  int  kotlin.jvm.functions.Function4  int  java.lang.Object)com.bytedance.trae.conversation.widget.AttachmentEntry
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->type Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget v5, v3, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->viewIdRes I
    move v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget v6, v3, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->iconRes I
    move v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget v7, v3, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->labelRes I
    move v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->isVisible Lkotlin/jvm/functions/Function4;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move v7, v10
    move v8, v0
    move v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->copy(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType; I I I Lkotlin/jvm/functions/Function4;)Lcom/bytedance/trae/conversation/widget/AttachmentEntry;
    move-result-object v3
    return-object v3
.end method

.method public final component1()com.bytedance.trae.conversation.widget.ChatAttachmentDialog$AttachmentType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->type Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    return-object v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->viewIdRes I
    return v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->iconRes I
    return v0
.end method

.method public final component4()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->labelRes I
    return v0
.end method

.method public final component5()kotlin.jvm.functions.Function4
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->isVisible Lkotlin/jvm/functions/Function4;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.widget.ChatAttachmentDialog$AttachmentType  int  int  int  kotlin.jvm.functions.Function4)com.bytedance.trae.conversation.widget.AttachmentEntry
    .registers 13
    # ins_size=6
    const-string/jumbo v0, type
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "isVisible"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;
    move-object v1, v0
    move-object v2, v8
    move v3, v9
    move v4, v10
    move v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;-><init>(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType; I I I Lkotlin/jvm/functions/Function4;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->type Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->type Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->viewIdRes I
    iget v3, v5, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->viewIdRes I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->iconRes I
    iget v3, v5, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->iconRes I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->labelRes I
    iget v3, v5, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->labelRes I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->isVisible Lkotlin/jvm/functions/Function4;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->isVisible Lkotlin/jvm/functions/Function4;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getIconRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->iconRes I
    return v0
.end method

.method public final getLabelRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->labelRes I
    return v0
.end method

.method public final getType()com.bytedance.trae.conversation.widget.ChatAttachmentDialog$AttachmentType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->type Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    return-object v0
.end method

.method public final getViewIdRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->viewIdRes I
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->type Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->viewIdRes I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->iconRes I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->labelRes I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->isVisible Lkotlin/jvm/functions/Function4;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isVisible()kotlin.jvm.functions.Function4
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->isVisible Lkotlin/jvm/functions/Function4;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "AttachmentEntry(type="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->type Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", viewIdRes="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->viewIdRes I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", iconRes="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->iconRes I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", labelRes="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->labelRes I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isVisible="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;->isVisible Lkotlin/jvm/functions/Function4;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
