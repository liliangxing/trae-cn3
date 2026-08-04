# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/PhoneBindActivity$Companion;
.super Ljava/lang/Object;
.source "PhoneBindActivity.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic start$default(com.bytedance.trae.login.activity.PhoneBindActivity$Companion  android.app.Activity  java.lang.String  java.lang.String  int  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$Companion;->start(Landroid/app/Activity; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public final start(android.app.Activity  java.lang.String  java.lang.String  int)void
    .registers 8
    # ins_size=5
    const-string v0, "context"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    move-object v1, v4
    check-cast v1, Landroid/content/Context;
    const-class v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-direct v0, v1, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v1, "extra_mode"
    invoke-virtual v0, v1, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    if-eqz v6, +007h
    const-string v5, "extra_phone_masked"
    invoke-virtual v0, v5, v6, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v4, v0, v7, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent; I)V
    return-void 
.end method
