# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$Companion;
.super Ljava/lang/Object;
.source "EditNameDialogFragment.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$Companion;-><init>()V
    return-void 
.end method

.method public final newInstance(java.lang.String)com.bytedance.trae.home.solo.setting.EditNameDialogFragment
    .registers 5
    # ins_size=2
    const-string v0, "currentName"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "name"
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
