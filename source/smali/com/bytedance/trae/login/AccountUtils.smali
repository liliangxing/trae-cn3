# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/AccountUtils;
.super Ljava/lang/Object;
.source "AccountUtils.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/AccountUtils;
.field private static accountPhoneOneKeyInfo:Lcom/bytedance/trae/login/PhoneOneKeyInfo;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/AccountUtils;
    invoke-direct v0, Lcom/bytedance/trae/login/AccountUtils;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/AccountUtils;->INSTANCE Lcom/bytedance/trae/login/AccountUtils;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$setAccountPhoneOneKeyInfo$p(com.bytedance.trae.login.PhoneOneKeyInfo)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/login/AccountUtils;->accountPhoneOneKeyInfo Lcom/bytedance/trae/login/PhoneOneKeyInfo;
    return-void 
.end method

.method public final formatPhoneNumber(java.lang.String  com.bytedance.trae.login.AccountUtils$MobileTotalLength)java.lang.String
    .registers 7
    # ins_size=3
    const-string v0, "input"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, totalLength
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/login/AccountUtils;->purePhoneNumber(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    sget-object v0, Lcom/bytedance/trae/login/AccountUtils$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v6, Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;->ordinal()I
    move-result v6
    aget v6, v0, v6
    const/4 v0, 1
    if-eq v6, v0, +00dh
    const/4 v0, 2
    if-ne v6, v0, +004h
    const/4 v6, 7
    goto +8h
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
    const/4 v6, 6
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v0
    const/4 v1, 3
    if-gt v0, v1, +003h
    goto +56h
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v0
    const/16 v2, 32
    if-gt v0, v6, +020h
    invoke-static v5, v1, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v6
    invoke-static v5, v1, Lkotlin/text/StringsKt;->drop(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v5
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    goto +30h
    invoke-static v5, v1, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, v1, v6, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v3, substring(...)
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v5, v6, Lkotlin/text/StringsKt;->drop(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v5
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    return-object v5
.end method

.method public final getPreLoadOneKeyInfo()com.bytedance.trae.login.PhoneOneKeyInfo
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/AccountUtils;->accountPhoneOneKeyInfo Lcom/bytedance/trae/login/PhoneOneKeyInfo;
    return-object v0
.end method

.method public final preLoadAccountPhoneOneKeyInfo()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/PhoneOneKeyInit;->INSTANCE Lcom/bytedance/trae/login/PhoneOneKeyInit;
    invoke-virtual v0, Lcom/bytedance/trae/login/PhoneOneKeyInit;->init()V
    new-instance v0, Lcom/bytedance/trae/login/PhoneLogin;
    invoke-direct v0, Lcom/bytedance/trae/login/PhoneLogin;-><init>()V
    sget-object v1, Lcom/bytedance/trae/login/api/LoginPlatform;->PHONE Lcom/bytedance/trae/login/api/LoginPlatform;
    new-instance v2, Lcom/bytedance/trae/login/AccountUtils$preLoadAccountPhoneOneKeyInfo$1;
    invoke-direct v2, Lcom/bytedance/trae/login/AccountUtils$preLoadAccountPhoneOneKeyInfo$1;-><init>()V
    check-cast v2, Lcom/bytedance/trae/login/IPhoneOneKeyCallback;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/PhoneLogin;->getPhoneInfo(Lcom/bytedance/trae/login/api/LoginPlatform; Lcom/bytedance/trae/login/IPhoneOneKeyCallback;)V
    return-void 
.end method

.method public final purePhoneNumber(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    const-string v0, "input"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    new-instance v0, Lkotlin/text/Regex;
    const-string v1, "[^0-9]"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    const-string v1, ""
    invoke-virtual v0, v3, v1, Lkotlin/text/Regex;->replace(Ljava/lang/CharSequence; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method
