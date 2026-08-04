# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;
.super Ljava/lang/Object;
.source "TraeAuthDeviceManager.kt"

.field private static final DEVICE_TYPE:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;
.field private static final KEYSTORE_PROVIDER:Ljava/lang/String;
.field private static final KEY_ALIAS:Ljava/lang/String;
.field private static final PLATFORM_CODE:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static final keyStore$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$nmexYN_Umm2PBswaRVgu_9JPDPs()java.security.KeyStore
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->keyStore_delegate$lambda$1()Ljava/security/KeyStore;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;
    invoke-direct v0, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;
    new-instance v1, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v1, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->keyStore$delegate Lkotlin/Lazy;
    invoke-direct v0, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->ensureKeyPairExists()V
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final buildDeviceName()java.lang.String
    .registers 13
    # ins_size=1
    sget-object v0, Landroid/os/Build;->MANUFACTURER Ljava/lang/String;
    const-string v1, ""
    if-nez v0, +003h
    move-object v0, v1
    sget-object v2, Landroid/os/Build;->MODEL Ljava/lang/String;
    if-nez v2, +003h
    goto +2h
    move-object v1, v2
    const/4 v2, 2
    new-array v2, v2, [Ljava/lang/String;
    const/4 v3, 0
    aput-object v0, v2, v3
    const/4 v0, 1
    aput-object v1, v2, v0
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +016h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Ljava/lang/String;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v0
    if-eqz v4, -014h
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    check-cast v2, Ljava/util/List;
    move-object v3, v2
    check-cast v3, Ljava/lang/Iterable;
    const-string v0, " "
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 62
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final ensureKeyPairExists()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->getKeyStore()Ljava/security/KeyStore;
    move-result-object v0
    const-string v1, "com.trae.device.ec256"
    invoke-virtual v0, v1, Ljava/security/KeyStore;->containsAlias(Ljava/lang/String;)Z
    move-result v0
    if-nez v0, +005h
    invoke-direct v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->generateKeyPair()V
    return-void 
.end method

.method private final exportPublicKeyPEM()java.lang.String
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->getPublicKey()Ljava/security/PublicKey;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    invoke-interface v0, Ljava/security/PublicKey;->getEncoded()[B
    move-result-object v0
    if-nez v0, +003h
    return-object v1
    const/4 v1, 2
    invoke-static v0, v1, Landroid/util/Base64;->encodeToString([B I)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "-----BEGIN PUBLIC KEY-----
"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "
-----END PUBLIC KEY-----"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final generateKeyPair()void
    .registers 6
    # ins_size=1
    const-string v0, "TraeAuthDeviceManager"
    new-instance v1, Landroid/security/keystore/KeyGenParameterSpec$Builder;
    const-string v2, "com.trae.device.ec256"
    const/16 v3, 12
    invoke-direct v1, v2, v3, Landroid/security/keystore/KeyGenParameterSpec$Builder;-><init>(Ljava/lang/String; I)V
    new-instance v2, Ljava/security/spec/ECGenParameterSpec;
    const-string/jumbo v3, secp256r1
    invoke-direct v2, v3, Ljava/security/spec/ECGenParameterSpec;-><init>(Ljava/lang/String;)V
    check-cast v2, Ljava/security/spec/AlgorithmParameterSpec;
    invoke-virtual v1, v2, Landroid/security/keystore/KeyGenParameterSpec$Builder;->setAlgorithmParameterSpec(Ljava/security/spec/AlgorithmParameterSpec;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    move-result-object v1
    const-string v2, "SHA-256"
    filled-new-array v2, [Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Landroid/security/keystore/KeyGenParameterSpec$Builder;->setDigests([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    move-result-object v1
    invoke-virtual v1, Landroid/security/keystore/KeyGenParameterSpec$Builder;->build()Landroid/security/keystore/KeyGenParameterSpec;
    move-result-object v1
    const-string v2, "build(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "EC"
    const-string v3, "AndroidKeyStore"
    invoke-static v2, v3, Ljava/security/KeyPairGenerator;->getInstance(Ljava/lang/String; Ljava/lang/String;)Ljava/security/KeyPairGenerator;
    move-result-object v2
    check-cast v1, Ljava/security/spec/AlgorithmParameterSpec;
    invoke-virtual v2, v1, Ljava/security/KeyPairGenerator;->initialize(Ljava/security/spec/AlgorithmParameterSpec;)V
    invoke-virtual v2, Ljava/security/KeyPairGenerator;->generateKeyPair()Ljava/security/KeyPair;
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "generateKeyPair: new EC P-256 key pair generated"
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +1ah
    move-exception v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "generateKeyPair: failed - "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0x2
.end method

.method public static synthetic getDeviceProof$default(com.bytedance.trae.login.traeauth.TraeAuthDeviceManager  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.login.traeauth.DeviceProof
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    const-string v1, "POST"
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    const-string v2, "/cloudide/api/v3/trae/oauth/BindDevice"
    and-int/lit8 v4, v4, 4
    if-eqz v4, +008h
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getRefreshToken()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->getDeviceProof(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/login/traeauth/DeviceProof;
    move-result-object v0
    return-object v0
.end method

.method private final getKeyStore()java.security.KeyStore
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->keyStore$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getValue(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/security/KeyStore;
    return-object v0
.end method

.method private final getPrivateKey()java.security.PrivateKey
    .registers 6
    # ins_size=1
    const/4 v0, 0
    invoke-direct v5, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->getKeyStore()Ljava/security/KeyStore;
    move-result-object v1
    const-string v2, "com.trae.device.ec256"
    invoke-virtual v1, v2, v0, Ljava/security/KeyStore;->getKey(Ljava/lang/String; [C)Ljava/security/Key;
    move-result-object v1
    instance-of v2, v1, Ljava/security/PrivateKey;
    if-eqz v2, +021h
    check-cast v1, Ljava/security/PrivateKey;
    move-object v0, v1
    goto +1ch
    move-exception v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "getPrivateKey: failed - "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v3, "TraeAuthDeviceManager"
    invoke-virtual v2, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    :try_start_0x1
.end method

.method private final getPublicKey()java.security.PublicKey
    .registers 6
    # ins_size=1
    const/4 v0, 0
    invoke-direct v5, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->getKeyStore()Ljava/security/KeyStore;
    move-result-object v1
    const-string v2, "com.trae.device.ec256"
    invoke-virtual v1, v2, Ljava/security/KeyStore;->getCertificate(Ljava/lang/String;)Ljava/security/cert/Certificate;
    move-result-object v1
    if-eqz v1, +022h
    invoke-virtual v1, Ljava/security/cert/Certificate;->getPublicKey()Ljava/security/PublicKey;
    move-result-object v0
    goto +1ch
    move-exception v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "getPublicKey: failed - "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v3, "TraeAuthDeviceManager"
    invoke-virtual v2, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    :try_start_0x1
.end method

.method private static final keyStore_delegate$lambda$1()java.security.KeyStore
    .registers 2
    # ins_size=0
    const-string v0, "AndroidKeyStore"
    invoke-static v0, Ljava/security/KeyStore;->getInstance(Ljava/lang/String;)Ljava/security/KeyStore;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Ljava/security/KeyStore;->load(Ljava/security/KeyStore$LoadStoreParameter;)V
    return-object v0
.end method

.method public final getDeviceInfo()com.bytedance.trae.login.traeauth.DeviceInfo
    .registers 16
    # ins_size=1
    new-instance v13, Lcom/bytedance/trae/login/traeauth/DeviceInfo;
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v1
    invoke-direct v15, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->buildDeviceName()Ljava/lang/String;
    move-result-object v2
    const-string v3, "mobile"
    const-string/jumbo v4, solo_mobile
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v5
    sget-object v0, Landroid/os/Build;->MODEL Ljava/lang/String;
    const-string v6, ""
    if-nez v0, +004h
    move-object v7, v6
    goto +2h
    move-object v7, v0
    sget-object v0, Landroid/os/Build$VERSION;->RELEASE Ljava/lang/String;
    if-nez v0, +004h
    move-object v8, v6
    goto +2h
    move-object v8, v0
    const/4 v9, 0
    invoke-direct v15, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->exportPublicKeyPEM()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    move-object v10, v6
    goto +2h
    move-object v10, v0
    sget-object v0, Landroid/os/Build;->BRAND Ljava/lang/String;
    if-nez v0, +004h
    move-object v11, v6
    goto +2h
    move-object v11, v0
    const/16 v12, 128
    const/4 v14, 0
    move-object v0, v13
    move-object v6, v7
    move-object v7, v8
    move-object v8, v9
    move-object v9, v10
    move-object v10, v11
    move v11, v12
    move-object v12, v14
    invoke-direct/range v0 ... v12, Lcom/bytedance/trae/login/traeauth/DeviceInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v13
.end method

.method public final getDeviceProof(java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.login.traeauth.DeviceProof
    .registers 23
    # ins_size=4
    move-object/from16 v0, v20
    move-object/from16 v1, v21
    move-object/from16 v2, v22
    const-string v3, "httpMethod"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, path
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, refreshToken
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v19, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->getPrivateKey()Ljava/security/PrivateKey;
    move-result-object v3
    const/4 v4, 0
    const-string v5, "TraeAuthDeviceManager"
    if-nez v3, +00ah
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "getDeviceProof: privateKey unavailable"
    invoke-virtual v0, v5, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-object v4
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getClientId()Ljava/lang/String;
    move-result-object v6
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v7
    const/16 v9, 1000
    int-to-long v9, v9
    div-long/2addr v7, v9
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v9
    invoke-virtual v9, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v10
    const-string/jumbo v9, toString(...)
    invoke-static v10, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v11, "-"
    const-string v12, ""
    const/4 v13, 0
    const/4 v14, 4
    const/4 v15, 0
    invoke-static/range v10 ... v15, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v9
    sget-object v10, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v9, v10, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v9
    const-string/jumbo v10, toLowerCase(...)
    invoke-static v9, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v10, 6
    new-array v10, v10, [Ljava/lang/String;
    const/4 v11, 0
    aput-object v0, v10, v11
    const/4 v0, 1
    aput-object v1, v10, v0
    const/4 v0, 2
    aput-object v6, v10, v0
    const/4 v1, 3
    aput-object v2, v10, v1
    const/4 v1, 4
    invoke-static v7, v8, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v2
    aput-object v2, v10, v1
    const/4 v1, 5
    aput-object v9, v10, v1
    invoke-static v10, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Ljava/lang/Iterable;
    const-string v1, "
"
    move-object v11, v1
    check-cast v11, Ljava/lang/CharSequence;
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    const/16 v17, 62
    const/16 v18, 0
    invoke-static/range v10 ... v18, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "SHA256withECDSA"
    invoke-static v2, Ljava/security/Signature;->getInstance(Ljava/lang/String;)Ljava/security/Signature;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/security/Signature;->initSign(Ljava/security/PrivateKey;)V
    sget-object v3, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-virtual v1, v3, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B
    move-result-object v1
    const-string v3, "getBytes(...)"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v1, Ljava/security/Signature;->update([B)V
    invoke-virtual v2, Ljava/security/Signature;->sign()[B
    move-result-object v1
    invoke-static v1, v0, Landroid/util/Base64;->encodeToString([B I)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/login/traeauth/DeviceProof;
    invoke-static v7, v8, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    invoke-direct v1, v0, v2, v9, Lcom/bytedance/trae/login/traeauth/DeviceProof;-><init>(Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String;)V
    move-object v4, v1
    goto +1ah
    move-exception v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "getDeviceProof: signing failed - "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-object v4
    :try_start_0x8d
.end method

.method public final regenerateKeyPair()void
    .registers 6
    # ins_size=1
    const-string v0, "TraeAuthDeviceManager"
    invoke-direct v5, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->getKeyStore()Ljava/security/KeyStore;
    move-result-object v1
    const-string v2, "com.trae.device.ec256"
    invoke-virtual v1, v2, Ljava/security/KeyStore;->deleteEntry(Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v2, regenerateKeyPair: old key deleted
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +1bh
    move-exception v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, regenerateKeyPair: delete failed - 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v5, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;->generateKeyPair()V
    return-void 
    :try_start_0x2
.end method

.method public final showLimitDeviceDialog(com.bytedance.trae.login.traeauth.TraeAuthDeviceManager$TraeAuthDeviceCallback)void
    .registers 9
    # ins_size=2
    const-string v0, "callback"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;
    const/4 v4, 0
    invoke-direct v0, v8, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
