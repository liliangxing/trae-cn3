# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/ApiHost;
.super Ljava/lang/Object;
.source "ApiHost.java"

.field private static final COMMUNITY_HOST:Ljava/lang/String;
.field private static final DOCS_HOST:Ljava/lang/String;
.field private static final ENTERPRISE_BOE_HOST:Ljava/lang/String;
.field private static final ENTERPRISE_HOST:Ljava/lang/String;
.field public static final FRONTIER_CONFIG:Lcom/bytedance/trae/network/FrontierConfig;
.field public static final FRONTIER_CONFIG_BYTECLOUD:Lcom/bytedance/trae/network/FrontierConfig;
.field private static final IMAGEX_HOST:Ljava/lang/String;
.field private static final LOGIN_HOST:Ljava/lang/String;
.field private static final MARKETPLACE_BYTECLOUD_HOST:Ljava/lang/String;
.field private static final MARKETPLACE_HOST:Ljava/lang/String;
.field private static final MSSDK_PASSPORT_TOKEN_Z:Ljava/lang/String;
.field private static final NOTIFICATION_HOST:Ljava/lang/String;
.field private static final ONLINE_HOST:Ljava/lang/String;
.field private static final PRAISE_HOST:Ljava/lang/String;
.field private static final SETTINGS_HOST:Ljava/lang/String;
.field private static final TRAE_MC_HOST:Ljava/lang/String;
.field private static final TRAE_REMOTE:Ljava/lang/String;
.field private static final WEBSITE_BYTECLOUD_HOST:Ljava/lang/String;
.field private static final WEBSITE_HOST:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 5
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/FrontierConfig;
    const/16 v1, 1924
    const v2, 943841
    const-string v3, "2eb730eefff567bc66454d914f83b9dc"
    const-string/jumbo v4, wss://frontier.zijieapi.com/ws/v2
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/network/FrontierConfig;-><init>(I I Ljava/lang/String; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/ApiHost;->FRONTIER_CONFIG Lcom/bytedance/trae/network/FrontierConfig;
    new-instance v0, Lcom/bytedance/trae/network/FrontierConfig;
    const v2, 1016841
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/network/FrontierConfig;-><init>(I I Ljava/lang/String; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/ApiHost;->FRONTIER_CONFIG_BYTECLOUD Lcom/bytedance/trae/network/FrontierConfig;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static initHostResolver()void
    .registers 11
    # ins_size=0
    new-instance v0, Ljava/util/HashMap;
    invoke-direct v0, Ljava/util/HashMap;-><init>()V
    sget-object v1, Lcom/bytedance/trae/network/AiRegion;->CN Lcom/bytedance/trae/network/AiRegion;
    const-string v2, "copilot-cn.bytedance.net"
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/network/AiRegion;->SG Lcom/bytedance/trae/network/AiRegion;
    const-string v3, "copilot-sg-og.byteintl.net"
    invoke-interface v0, v1, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/network/AiRegion;->US Lcom/bytedance/trae/network/AiRegion;
    const-string v3, "copilot-og.byteintl.net"
    invoke-interface v0, v1, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v1, Ljava/util/HashMap;
    invoke-direct v1, Ljava/util/HashMap;-><init>()V
    sget-object v3, Lcom/bytedance/trae/network/HostType;->ONLINE Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/DomainList;
    const-string/jumbo v6, www.trae.cn
    invoke-direct v5, v6, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/DomainList;
    const-string/jumbo v7, solo-web.bytedance.net
    invoke-direct v5, v7, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->bytecloudUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/DomainList;
    const-string v8, "console.enterprise.trae.cn"
    invoke-direct v5, v8, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->enterpriseUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/DomainList;
    const-string v9, "enterprise.mcdemo.show"
    invoke-direct v5, v9, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->enterpriseBoeUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v4
    invoke-interface v1, v3, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lcom/bytedance/trae/network/HostType;->LOGIN Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/DomainList;
    const-string v10, "api.trae.cn"
    invoke-direct v5, v10, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/DomainList;
    invoke-direct v5, v7, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->bytecloudUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/DomainList;
    invoke-direct v5, v8, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->enterpriseUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/DomainList;
    invoke-direct v5, v9, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->enterpriseBoeUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v4
    invoke-interface v1, v3, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/DomainList;
    const-string/jumbo v10, trae-api-cn.mchost.guru
    invoke-direct v5, v10, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/DomainList;
    invoke-direct v5, v2, v0, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->bytecloudUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/DomainList;
    invoke-direct v5, v8, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->enterpriseUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/DomainList;
    invoke-direct v5, v9, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->enterpriseBoeUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v4
    invoke-interface v1, v3, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lcom/bytedance/trae/network/HostType;->REMOTE Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/DomainList;
    const-string/jumbo v10, solo.trae.cn
    invoke-direct v5, v10, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/network/DomainList;
    invoke-direct v5, v2, v0, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->bytecloudUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/network/DomainList;
    invoke-direct v2, v8, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v2, Lcom/bytedance/trae/network/HostEntry$Builder;->enterpriseUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/network/DomainList;
    invoke-direct v2, v9, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v2, Lcom/bytedance/trae/network/HostEntry$Builder;->enterpriseBoeUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v0
    invoke-interface v1, v3, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/network/HostType;->IMAGEX Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/DomainList;
    const-string v4, "imagex.bytedanceapi.com"
    invoke-direct v3, v4, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v2
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/network/HostType;->MSSDK Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/DomainList;
    const-string v4, "mssdk.doubao.com"
    invoke-direct v3, v4, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v2
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/network/HostType;->PASSPORT Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/DomainList;
    invoke-direct v3, v6, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v2
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/network/HostType;->SETTINGS Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/DomainList;
    const-string v4, "is.snssdk.com"
    invoke-direct v3, v4, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v2
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/network/HostType;->PRAISE Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/DomainList;
    const-string v4, "praisewindow.ugsdk.cn"
    invoke-direct v3, v4, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v2
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/network/HostType;->NOTIFICATION Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/DomainList;
    const-string v4, "api.trae.com.cn"
    invoke-direct v3, v4, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v2
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/network/HostType;->MARKETPLACE Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/DomainList;
    invoke-direct v3, v4, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/DomainList;
    const-string v4, "ide.byted.org"
    invoke-direct v3, v4, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostEntry$Builder;->bytecloudUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v2
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/network/HostType;->WEBSITE Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/DomainList;
    invoke-direct v3, v6, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v2
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/network/HostType;->PLUGIN_WEB Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/DomainList;
    invoke-direct v3, v6, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/DomainList;
    invoke-direct v3, v7, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostEntry$Builder;->bytecloudUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v2
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/network/HostType;->DOCS Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/DomainList;
    const-string v4, "docs.trae.cn"
    invoke-direct v3, v4, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v2
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/network/HostType;->COMMUNITY Lcom/bytedance/trae/network/HostType;
    invoke-static Lcom/bytedance/trae/network/HostEntry;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/DomainList;
    const-string v4, "forum.trae.cn"
    invoke-direct v3, v4, Lcom/bytedance/trae/network/DomainList;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/HostEntry$Builder;->build()Lcom/bytedance/trae/network/HostEntry;
    move-result-object v2
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->init(Ljava/util/Map;)V
    return-void 
.end method
