# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$Companion;
.super Ljava/lang/Object;
.source "OneClickLoginFragment.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$Companion;-><init>()V
    return-void 
.end method

.method public final newInstance(java.lang.String  com.bytedance.trae.login.PhoneOneKeyPlatform)com.bytedance.trae.login.fragment.OneClickLoginFragment
    .registers 6
    # ins_size=3
    const-string v0, "maskedPhone"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "arg_masked_phone"
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/login/PhoneOneKeyPlatform;->name()Ljava/lang/String;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    const-string v5, "arg_carrier"
    invoke-virtual v1, v5, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
