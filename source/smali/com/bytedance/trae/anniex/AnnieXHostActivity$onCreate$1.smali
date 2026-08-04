# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/AnnieXHostActivity$onCreate$1;
.super Landroidx/activity/OnBackPressedCallback;
.source "AnnieXHostActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/anniex/AnnieXHostActivity;


.method constructor <init>(com.bytedance.trae.anniex.AnnieXHostActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/anniex/AnnieXHostActivity$onCreate$1;->this$0 Lcom/bytedance/trae/anniex/AnnieXHostActivity;
    const/4 v1, 1
    invoke-direct v0, v1, Landroidx/activity/OnBackPressedCallback;-><init>(Z)V
    return-void 
.end method

.method public handleOnBackPressed()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/anniex/AnnieXHostActivity$onCreate$1;->this$0 Lcom/bytedance/trae/anniex/AnnieXHostActivity;
    invoke-static v0, Lcom/bytedance/trae/anniex/AnnieXHostActivity;->access$getAnnieXPageHelper(Lcom/bytedance/trae/anniex/AnnieXHostActivity;)Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;->onBackPressed()V
    return-void 
.end method
