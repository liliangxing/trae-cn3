# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/AgreementUrlOpener;
.super Ljava/lang/Object;
.source "AgreementUrlOpener.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/utils/AgreementUrlOpener;
.field private static final PRIVACY_AGREED_FLAG:Ljava/lang/String;
.field private static final SIMPLE_WEBVIEW_ACTIVITY:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/utils/AgreementUrlOpener;
    invoke-direct v0, Lcom/bytedance/trae/utils/AgreementUrlOpener;-><init>()V
    sput-object v0, Lcom/bytedance/trae/utils/AgreementUrlOpener;->INSTANCE Lcom/bytedance/trae/utils/AgreementUrlOpener;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final isPrivacyAgreed(android.content.Context)boolean
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/io/File;
    invoke-virtual v3, Landroid/content/Context;->getFilesDir()Ljava/io/File;
    move-result-object v3
    const-string/jumbo v1, privacy_agreed
    invoke-direct v0, v3, v1, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v0, Ljava/io/File;->exists()Z
    move-result v3
    return v3
.end method

.method public final open(android.content.Context  java.lang.String)void
    .registers 6
    # ins_size=3
    const-string v0, "context"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, url
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/utils/AgreementUrlOpener;->isPrivacyAgreed(Landroid/content/Context;)Z
    move-result v0
    if-eqz v0, +016h
    new-instance v0, Landroid/content/Intent;
    invoke-direct v0, Landroid/content/Intent;-><init>()V
    invoke-virtual v4, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v1
    const-string v2, "com.bytedance.trae.common.activity.SimpleWebViewActivity"
    invoke-virtual v0, v1, v2, Landroid/content/Intent;->setClassName(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v1, "extra_url"
    invoke-virtual v0, v1, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    goto +ch
    new-instance v0, Landroid/content/Intent;
    const-string v1, "android.intent.action.VIEW"
    invoke-static v5, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v5
    invoke-direct v0, v1, v5, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    instance-of v5, v4, Landroid/app/Activity;
    if-nez v5, +007h
    const/high16 v5, 268435456
    invoke-virtual v0, v5, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v4, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method
