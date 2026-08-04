# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$2:Landroidx/compose/ui/Modifier;
.field public final synthetic f$3:I
.field public final synthetic f$4:I


.method public synthetic constructor <init>(java.lang.String  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  int  int)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda1;->f$1 Lkotlin/jvm/functions/Function0;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda1;->f$2 Landroidx/compose/ui/Modifier;
    iput v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda1;->f$3 I
    iput v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda1;->f$4 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=3
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda1;->f$1 Lkotlin/jvm/functions/Function0;
    iget-object v2, v7, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda1;->f$2 Landroidx/compose/ui/Modifier;
    iget v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda1;->f$3 I
    iget v4, v7, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda1;->f$4 I
    move-object v5, v8
    check-cast v5, Landroidx/compose/runtime/Composer;
    check-cast v9, Ljava/lang/Integer;
    invoke-virtual v9, Ljava/lang/Integer;->intValue()I
    move-result v6
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt;->$r8$lambda$leDoweE2aL-DdsIH1FZjfd5PnhA(Ljava/lang/String; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v8
    return-object v8
.end method
