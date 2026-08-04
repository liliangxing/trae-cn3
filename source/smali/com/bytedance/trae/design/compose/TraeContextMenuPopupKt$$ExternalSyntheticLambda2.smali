# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Ljava/util/List;
.field public final synthetic f$1:Lcom/bytedance/trae/design/compose/TraeContextMenuPosition;
.field public final synthetic f$10:Z
.field public final synthetic f$11:Z
.field public final synthetic f$12:F
.field public final synthetic f$13:F
.field public final synthetic f$14:F
.field public final synthetic f$15:F
.field public final synthetic f$16:F
.field public final synthetic f$17:F
.field public final synthetic f$18:Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;
.field public final synthetic f$19:J
.field public final synthetic f$2:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$20:J
.field public final synthetic f$21:J
.field public final synthetic f$22:Ljava/lang/String;
.field public final synthetic f$23:I
.field public final synthetic f$24:I
.field public final synthetic f$25:I
.field public final synthetic f$26:I
.field public final synthetic f$3:Landroidx/compose/ui/Modifier;
.field public final synthetic f$4:F
.field public final synthetic f$5:F
.field public final synthetic f$6:F
.field public final synthetic f$7:F
.field public final synthetic f$8:F
.field public final synthetic f$9:Z


.method public synthetic constructor <init>(java.util.List  com.bytedance.trae.design.compose.TraeContextMenuPosition  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  float  float  float  float  float  boolean  boolean  boolean  float  float  float  float  float  float  com.bytedance.trae.design.compose.TraeContextMenuShadowPadding  long  long  long  java.lang.String  int  int  int  int)void
    .registers 34
    # ins_size=31
    move-object v0, v3
    invoke-direct v3, Ljava/lang/Object;-><init>()V
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$0 Ljava/util/List;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/design/compose/TraeContextMenuPosition;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$2 Lkotlin/jvm/functions/Function0;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$3 Landroidx/compose/ui/Modifier;
    move v1, v8
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$4 F
    move v1, v9
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$5 F
    move v1, v10
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$6 F
    move v1, v11
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$7 F
    move v1, v12
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$8 F
    move v1, v13
    iput-boolean v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$9 Z
    move v1, v14
    iput-boolean v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$10 Z
    move v1, v15
    iput-boolean v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$11 Z
    move/from16 v1, v16
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$12 F
    move/from16 v1, v17
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$13 F
    move/from16 v1, v18
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$14 F
    move/from16 v1, v19
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$15 F
    move/from16 v1, v20
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$16 F
    move/from16 v1, v21
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$17 F
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$18 Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;
    move-wide/from16 v1, v23
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$19 J
    move-wide/from16 v1, v25
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$20 J
    move-wide/from16 v1, v27
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$21 J
    move-object/from16 v1, v29
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$22 Ljava/lang/String;
    move/from16 v1, v30
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$23 I
    move/from16 v1, v31
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$24 I
    move/from16 v1, v32
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$25 I
    move/from16 v1, v33
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$26 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 38
    # ins_size=3
    move-object/from16 v0, v35
    iget-object v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$0 Ljava/util/List;
    iget-object v2, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/design/compose/TraeContextMenuPosition;
    iget-object v3, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$2 Lkotlin/jvm/functions/Function0;
    iget-object v4, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$3 Landroidx/compose/ui/Modifier;
    iget v5, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$4 F
    iget v6, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$5 F
    iget v7, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$6 F
    iget v8, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$7 F
    iget v9, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$8 F
    iget-boolean v10, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$9 Z
    iget-boolean v11, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$10 Z
    iget-boolean v12, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$11 Z
    iget v13, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$12 F
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$13 F
    iget v15, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$14 F
    move-object/from16 v33, v1
    iget v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$15 F
    move/from16 v16, v1
    iget v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$16 F
    move/from16 v17, v1
    iget v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$17 F
    move/from16 v18, v1
    iget-object v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$18 Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;
    move-object/from16 v19, v1
    move-object/from16 v34, v2
    iget-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$19 J
    move-wide/from16 v20, v1
    iget-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$20 J
    move-wide/from16 v22, v1
    iget-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$21 J
    move-wide/from16 v24, v1
    iget-object v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$22 Ljava/lang/String;
    move-object/from16 v26, v1
    iget v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$23 I
    move/from16 v27, v1
    iget v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$24 I
    move/from16 v28, v1
    iget v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$25 I
    move/from16 v29, v1
    iget v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;->f$26 I
    move/from16 v30, v1
    move-object/from16 v31, v36
    check-cast v31, Landroidx/compose/runtime/Composer;
    move-object/from16 v1, v37
    check-cast v1, Ljava/lang/Integer;
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v32
    move-object/from16 v1, v33
    move-object/from16 v2, v34
    invoke-static/range v1 ... v32, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->$r8$lambda$F3k-IjNvYBBejmjYhfq3QSVtqOc(Ljava/util/List; Lcom/bytedance/trae/design/compose/TraeContextMenuPosition; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; F F F F F Z Z Z F F F F F F Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding; J J J Ljava/lang/String; I I I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v1
    return-object v1
.end method
