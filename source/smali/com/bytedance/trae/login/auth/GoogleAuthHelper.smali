# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/auth/GoogleAuthHelper;
.super Ljava/lang/Object;
.source "GoogleAuthHelper.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/auth/GoogleAuthHelper;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/auth/GoogleAuthHelper;
    invoke-direct v0, Lcom/bytedance/trae/login/auth/GoogleAuthHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/auth/GoogleAuthHelper;->INSTANCE Lcom/bytedance/trae/login/auth/GoogleAuthHelper;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getSignInIntent(android.app.Activity)android.content.Intent
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    return-object v2
.end method

.method public final initIfNeeded(android.app.Activity)void
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public final onActivityResult(int  int  android.content.Intent)void
    .registers 4
    # ins_size=4
    return-void 
.end method

.method public final onDestroy()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public final parseSignInResult(android.content.Intent)com.bytedance.trae.login.auth.GoogleAuthInfo
    .registers 2
    # ins_size=2
    const/4 v1, 0
    return-object v1
.end method
