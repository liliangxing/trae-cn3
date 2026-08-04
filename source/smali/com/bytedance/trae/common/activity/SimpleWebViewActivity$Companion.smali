# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;
.super Ljava/lang/Object;
.source "SimpleWebViewActivity.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic start$default(com.bytedance.trae.common.activity.SimpleWebViewActivity$Companion  android.content.Context  java.lang.String  boolean  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Z)V
    return-void 
.end method

.method public final start(android.content.Context  java.lang.String  boolean)void
    .registers 6
    # ins_size=4
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, url
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;
    invoke-direct v0, v3, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v1, "extra_url"
    invoke-virtual v0, v1, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_show_more_menu"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    invoke-virtual v3, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method
