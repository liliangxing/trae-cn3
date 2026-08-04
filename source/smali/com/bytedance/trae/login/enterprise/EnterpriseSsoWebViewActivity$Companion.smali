# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$Companion;
.super Ljava/lang/Object;
.source "EnterpriseSsoWebViewActivity.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$Companion;-><init>()V
    return-void 
.end method

.method public final start(android.content.Context  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=4
    const-string v0, "context"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, ssoUrl
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "email"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Landroid/content/Intent;
    const-class v2, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
    invoke-direct v1, v4, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string/jumbo v2, sso_url
    invoke-virtual v1, v2, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v1, v0, v6, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v4, v1, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method
