# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;
.super Ljava/lang/Object;
.source "EnterpriseLoginConfig.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;
.field public static final LOGIN_PLATFORM:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getBaseUrl()java.lang.String
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->INSTANCE Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-virtual v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overrideBaseUrlOrNull()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +003h
    return-object v0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->LOGIN Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getEntry(Lcom/bytedance/trae/network/HostType;)Lcom/bytedance/trae/network/HostEntry;
    move-result-object v0
    if-nez v0, +005h
    const-string v0, ""
    return-object v0
    sget-object v1, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v1, Lcom/bytedance/trae/network/DebugSettings;->isEnterpriseTestEnv()Z
    move-result v1
    const/4 v2, 0
    if-eqz v1, +01ch
    invoke-virtual v0, Lcom/bytedance/trae/network/HostEntry;->getEnterpriseBoeUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    if-eqz v1, +00bh
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->getNormal()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +3h
    move-object v2, v1
    goto +16h
    invoke-virtual v0, Lcom/bytedance/trae/network/HostEntry;->getEnterpriseUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    if-eqz v1, +011h
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->getNormal()Ljava/lang/String;
    move-result-object v2
    goto +bh
    invoke-virtual v0, Lcom/bytedance/trae/network/HostEntry;->getEnterpriseUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->getNormal()Ljava/lang/String;
    move-result-object v2
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "https://"
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-nez v2, +00ah
    invoke-virtual v0, Lcom/bytedance/trae/network/HostEntry;->getPublicUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/DomainList;->getNormal()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
