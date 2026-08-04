# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final synthetic Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$4$1;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "CmpSettingsEntryFragment.kt"

.implements Lkotlin/jvm/functions/Function0;


.method constructor <init>(java.lang.Object)void
    .registers 9
    # ins_size=2
    const/4 v1, 0
    const-class v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;
    const-string v4, "performLogout"
    const-string v5, "performLogout()V"
    const/4 v6, 0
    move-object v0, v7
    move-object v2, v8
    invoke-direct/range v0 ... v6, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Object; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public bridge synthetic invoke()java.lang.Object
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$4$1;->invoke()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final invoke()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$4$1;->receiver Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->access$performLogout(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)V
    return-void 
.end method
