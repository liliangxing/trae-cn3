# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/AboutWebUrlOpener;
.super Ljava/lang/Object;
.source "AboutWebUrlOpener.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/AboutWebUrlOpener;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AboutWebUrlOpener;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AboutWebUrlOpener;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/AboutWebUrlOpener;->INSTANCE Lcom/bytedance/trae/home/solo/setting/AboutWebUrlOpener;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final buildAnnieXWebUri(java.lang.String)android.net.Uri
    .registers 5
    # ins_size=2
    new-instance v0, Landroid/net/Uri$Builder;
    invoke-direct v0, Landroid/net/Uri$Builder;-><init>()V
    const-string/jumbo v1, sslocal
    invoke-virtual v0, v1, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v0
    const-string/jumbo v1, webview
    invoke-virtual v0, v1, Landroid/net/Uri$Builder;->authority(Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v0
    const-string v1, "hide_nav_bar"
    const-string v2, "1"
    invoke-virtual v0, v1, v2, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v0
    const-string/jumbo v1, url
    invoke-virtual v0, v1, v4, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v4
    invoke-virtual v4, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;
    move-result-object v4
    const-string v0, "build(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
.end method

.method public final open(android.content.Context  java.lang.String)void
    .registers 16
    # ins_size=3
    const-string v0, "context"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, url
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +00dh
    sget-object v1, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->Companion Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v2, v14
    move-object v3, v15
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;->start$default(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion; Landroid/content/Context; Ljava/lang/String; Z I Ljava/lang/Object;)V
    goto +eh
    sget-object v7, Lcom/bytedance/android/anniex/assemble/AnnieX;->INSTANCE Lcom/bytedance/android/anniex/assemble/AnnieX;
    invoke-direct v13, v15, Lcom/bytedance/trae/home/solo/setting/AboutWebUrlOpener;->buildAnnieXWebUri(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v9
    const/4 v10, 0
    const/4 v11, 4
    const/4 v12, 0
    move-object v8, v14
    invoke-static/range v7 ... v12, Lcom/bytedance/android/anniex/assemble/AnnieX;->open$default(Lcom/bytedance/android/anniex/assemble/AnnieX; Landroid/content/Context; Landroid/net/Uri; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Z
    return-void 
.end method
