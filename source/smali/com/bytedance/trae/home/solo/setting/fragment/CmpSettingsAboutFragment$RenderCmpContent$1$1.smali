# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final synthetic Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment$RenderCmpContent$1$1;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "CmpSettingsAboutFragment.kt"

.implements Lkotlin/jvm/functions/Function2;


.method constructor <init>(java.lang.Object)void
    .registers 9
    # ins_size=2
    const/4 v1, 2
    const-class v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;
    const-string v4, "handleItemClick"
    const-string v5, "handleItemClick(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;Ljava/lang/String;)V"
    const/4 v6, 0
    move-object v0, v7
    move-object v2, v8
    invoke-direct/range v0 ... v6, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Object; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    check-cast v2, Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment$RenderCmpContent$1$1;->invoke(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final invoke(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "p0"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "p1"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment$RenderCmpContent$1$1;->receiver Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;->access$handleItemClick(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem; Ljava/lang/String;)V
    return-void 
.end method
