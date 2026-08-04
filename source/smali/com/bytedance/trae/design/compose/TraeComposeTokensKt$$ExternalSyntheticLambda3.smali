# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Z
.field public final synthetic f$1:Lkotlin/jvm/functions/Function2;
.field public final synthetic f$2:I
.field public final synthetic f$3:I


.method public synthetic constructor <init>(boolean  kotlin.jvm.functions.Function2  int  int)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda3;->f$0 Z
    iput-object v2, v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda3;->f$1 Lkotlin/jvm/functions/Function2;
    iput v3, v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda3;->f$2 I
    iput v4, v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda3;->f$3 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=3
    iget-boolean v0, v6, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda3;->f$0 Z
    iget-object v1, v6, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda3;->f$1 Lkotlin/jvm/functions/Function2;
    iget v2, v6, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda3;->f$2 I
    iget v3, v6, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda3;->f$3 I
    move-object v4, v7
    check-cast v4, Landroidx/compose/runtime/Composer;
    check-cast v8, Ljava/lang/Integer;
    invoke-virtual v8, Ljava/lang/Integer;->intValue()I
    move-result v5
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->$r8$lambda$Om_GvhWllxtMLxfTQB3_xl5TNj8(Z Lkotlin/jvm/functions/Function2; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v7
    return-object v7
.end method
