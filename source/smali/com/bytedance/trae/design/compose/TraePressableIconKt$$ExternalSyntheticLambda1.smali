# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lorg/jetbrains/compose/resources/DrawableResource;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$10:I
.field public final synthetic f$2:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$3:Landroidx/compose/ui/Modifier;
.field public final synthetic f$4:Z
.field public final synthetic f$5:J
.field public final synthetic f$6:J
.field public final synthetic f$7:J
.field public final synthetic f$8:J
.field public final synthetic f$9:I


.method public synthetic constructor <init>(org.jetbrains.compose.resources.DrawableResource  java.lang.String  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  boolean  long  long  long  long  int  int)void
    .registers 16
    # ins_size=16
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$0 Lorg/jetbrains/compose/resources/DrawableResource;
    iput-object v2, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$2 Lkotlin/jvm/functions/Function0;
    iput-object v4, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$3 Landroidx/compose/ui/Modifier;
    iput-boolean v5, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$4 Z
    iput-wide v6, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$5 J
    iput-wide v8, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$6 J
    iput-wide v10, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$7 J
    iput-wide v12, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$8 J
    iput v14, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$9 I
    iput v15, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$10 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 21
    # ins_size=3
    move-object/from16 v0, v18
    iget-object v1, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$0 Lorg/jetbrains/compose/resources/DrawableResource;
    iget-object v2, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iget-object v3, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$2 Lkotlin/jvm/functions/Function0;
    iget-object v4, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$3 Landroidx/compose/ui/Modifier;
    iget-boolean v5, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$4 Z
    iget-wide v6, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$5 J
    iget-wide v8, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$6 J
    iget-wide v10, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$7 J
    iget-wide v12, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$8 J
    iget v14, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$9 I
    iget v15, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;->f$10 I
    move-object/from16 v16, v19
    check-cast v16, Landroidx/compose/runtime/Composer;
    move-object/from16 v17, v20
    check-cast v17, Ljava/lang/Integer;
    invoke-virtual/range v17, Ljava/lang/Integer;->intValue()I
    move-result v17
    invoke-static/range v1 ... v17, Lcom/bytedance/trae/design/compose/TraePressableIconKt;->$r8$lambda$IWDv9Ci1z7CHRz_jJDJIX-FF_8o(Lorg/jetbrains/compose/resources/DrawableResource; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; Z J J J J I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v1
    return-object v1
.end method
