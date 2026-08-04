# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
.super Ljava/lang/Object;
.source "ContextMenuPopupWindow.kt"

.field private final destructive:Z
.field private final iconRes:I
.field private final iconTintRes:Ljava/lang/Integer;
.field private final onClick:Lkotlin/jvm/functions/Function0;
.field private final textColorRes:Ljava/lang/Integer;
.field private final title:Ljava/lang/CharSequence;
.field private final viewId:I


.method public constructor <init>(int  java.lang.CharSequence  boolean  java.lang.Integer  java.lang.Integer  int  kotlin.jvm.functions.Function0)void
    .registers 9
    # ins_size=8
    const-string/jumbo v0, title
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onClick"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconRes I
    iput-object v3, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->title Ljava/lang/CharSequence;
    iput-boolean v4, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->destructive Z
    iput-object v5, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconTintRes Ljava/lang/Integer;
    iput-object v6, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->textColorRes Ljava/lang/Integer;
    iput v7, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->viewId I
    iput-object v8, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->onClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.CharSequence  boolean  java.lang.Integer  java.lang.Integer  int  kotlin.jvm.functions.Function0  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 4
    if-eqz v0, +005h
    const/4 v0, 0
    move v4, v0
    goto +2h
    move v4, v12
    and-int/lit8 v0, v17, 8
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v13
    and-int/lit8 v0, v17, 16
    if-eqz v0, +004h
    move-object v6, v1
    goto +2h
    move-object v6, v14
    and-int/lit8 v0, v17, 32
    if-eqz v0, +005h
    const/4 v0, -1
    move v7, v0
    goto +2h
    move v7, v15
    move-object v1, v9
    move v2, v10
    move-object v3, v11
    move-object/from16 v8, v16
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(I Ljava/lang/CharSequence; Z Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.common.widget.ContextMenuPopupWindow$Item  int  java.lang.CharSequence  boolean  java.lang.Integer  java.lang.Integer  int  kotlin.jvm.functions.Function0  int  java.lang.Object)com.bytedance.trae.common.widget.ContextMenuPopupWindow$Item
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget v6, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconRes I
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-object v7, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->title Ljava/lang/CharSequence;
    move-object v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-boolean v8, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->destructive Z
    move v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v9, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconTintRes Ljava/lang/Integer;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-object v10, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->textColorRes Ljava/lang/Integer;
    move-object v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget v11, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->viewId I
    move v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->onClick Lkotlin/jvm/functions/Function0;
    move-object v4, v12
    move-object v7, v5
    move v8, v6
    move-object v9, v14
    move v10, v0
    move-object v11, v1
    move-object v12, v2
    move v13, v3
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->copy(I Ljava/lang/CharSequence; Z Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    move-result-object v5
    return-object v5
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconRes I
    return v0
.end method

.method public final component2()java.lang.CharSequence
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->title Ljava/lang/CharSequence;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->destructive Z
    return v0
.end method

.method public final component4()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconTintRes Ljava/lang/Integer;
    return-object v0
.end method

.method public final component5()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->textColorRes Ljava/lang/Integer;
    return-object v0
.end method

.method public final component6()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->viewId I
    return v0
.end method

.method public final component7()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->onClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final copy(int  java.lang.CharSequence  boolean  java.lang.Integer  java.lang.Integer  int  kotlin.jvm.functions.Function0)com.bytedance.trae.common.widget.ContextMenuPopupWindow$Item
    .registers 17
    # ins_size=8
    const-string/jumbo v0, title
    move-object v3, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onClick"
    move-object/from16 v8, v16
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    move-object v1, v0
    move v2, v10
    move v4, v12
    move-object v5, v13
    move-object v6, v14
    move v7, v15
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(I Ljava/lang/CharSequence; Z Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/functions/Function0;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    iget v1, v4, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconRes I
    iget v3, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconRes I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->title Ljava/lang/CharSequence;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->title Ljava/lang/CharSequence;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->destructive Z
    iget-boolean v3, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->destructive Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconTintRes Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconTintRes Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->textColorRes Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->textColorRes Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->viewId I
    iget v3, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->viewId I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->onClick Lkotlin/jvm/functions/Function0;
    iget-object v5, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->onClick Lkotlin/jvm/functions/Function0;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getDestructive()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->destructive Z
    return v0
.end method

.method public final getIconRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconRes I
    return v0
.end method

.method public final getIconTintRes()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconTintRes Ljava/lang/Integer;
    return-object v0
.end method

.method public final getOnClick()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->onClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getTextColorRes()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->textColorRes Ljava/lang/Integer;
    return-object v0
.end method

.method public final getTitle()java.lang.CharSequence
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->title Ljava/lang/CharSequence;
    return-object v0
.end method

.method public final getViewId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->viewId I
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconRes I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->title Ljava/lang/CharSequence;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->destructive Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconTintRes Ljava/lang/Integer;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->textColorRes Ljava/lang/Integer;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->viewId I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->onClick Lkotlin/jvm/functions/Function0;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Item(iconRes="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconRes I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", title="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->title Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", destructive="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->destructive Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", iconTintRes="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->iconTintRes Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", textColorRes="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->textColorRes Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", viewId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->viewId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", onClick="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->onClick Lkotlin/jvm/functions/Function0;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
