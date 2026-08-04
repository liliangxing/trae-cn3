# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Z
.field public final synthetic f$2:Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
.field public final synthetic f$3:Landroidx/compose/ui/Modifier;
.field public final synthetic f$4:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$5:I
.field public final synthetic f$6:I


.method public synthetic constructor <init>(java.lang.String  boolean  com.bytedance.trae.home.solo.setting.ui.DeviceManagementPalette  androidx.compose.ui.Modifier  kotlin.jvm.functions.Function0  int  int)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;->f$0 Ljava/lang/String;
    iput-boolean v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;->f$1 Z
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;->f$2 Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;->f$3 Landroidx/compose/ui/Modifier;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;->f$4 Lkotlin/jvm/functions/Function0;
    iput v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;->f$5 I
    iput v7, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;->f$6 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=3
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;->f$0 Ljava/lang/String;
    iget-boolean v1, v9, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;->f$1 Z
    iget-object v2, v9, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;->f$2 Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    iget-object v3, v9, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;->f$3 Landroidx/compose/ui/Modifier;
    iget-object v4, v9, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;->f$4 Lkotlin/jvm/functions/Function0;
    iget v5, v9, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;->f$5 I
    iget v6, v9, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda16;->f$6 I
    move-object v7, v10
    check-cast v7, Landroidx/compose/runtime/Composer;
    check-cast v11, Ljava/lang/Integer;
    invoke-virtual v11, Ljava/lang/Integer;->intValue()I
    move-result v8
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->$r8$lambda$HHmBvXL9fwOojb7ag8cJp285IJU(Ljava/lang/String; Z Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette; Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function0; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v10
    return-object v10
.end method
