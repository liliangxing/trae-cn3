# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/home/MainActivity;


.method public synthetic constructor <init>(com.bytedance.trae.home.MainActivity)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/home/MainActivity;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/home/MainActivity;
    check-cast v2, Landroidx/activity/OnBackPressedCallback;
    invoke-static v0, v2, Lcom/bytedance/trae/home/MainActivity;->$r8$lambda$T97Gmrx5XFEvKrOpSRruFR73Ybw(Lcom/bytedance/trae/home/MainActivity; Landroidx/activity/OnBackPressedCallback;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
