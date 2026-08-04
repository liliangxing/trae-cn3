# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda26;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Ljava/util/List;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
.field public final synthetic f$2:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$3:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$4:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$5:I


.method public synthetic constructor <init>(java.util.List  com.bytedance.trae.home.solo.setting.ui.DeviceManagementPalette  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  int)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda26;->f$0 Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda26;->f$1 Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda26;->f$2 Lkotlin/jvm/functions/Function0;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda26;->f$3 Lkotlin/jvm/functions/Function1;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda26;->f$4 Lkotlin/jvm/functions/Function1;
    iput v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda26;->f$5 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=3
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda26;->f$0 Ljava/util/List;
    iget-object v1, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda26;->f$1 Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    iget-object v2, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda26;->f$2 Lkotlin/jvm/functions/Function0;
    iget-object v3, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda26;->f$3 Lkotlin/jvm/functions/Function1;
    iget-object v4, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda26;->f$4 Lkotlin/jvm/functions/Function1;
    iget v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda26;->f$5 I
    move-object v6, v9
    check-cast v6, Landroidx/compose/runtime/Composer;
    check-cast v10, Ljava/lang/Integer;
    invoke-virtual v10, Ljava/lang/Integer;->intValue()I
    move-result v7
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->$r8$lambda$1cwI0ggUH5dYRVtLWGYcVNGHla4(Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v9
    return-object v9
.end method
