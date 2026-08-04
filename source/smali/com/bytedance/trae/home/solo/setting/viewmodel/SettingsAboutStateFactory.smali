# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;
.super Ljava/lang/Object;
.source "SettingsEntryViewModel.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final aboutWebItem(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItemKey  java.lang.String)com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination$WebUrl;
    invoke-direct v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination$WebUrl;-><init>(Ljava/lang/String;)V
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;
    invoke-direct v0, v3, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;)V
    return-object v0
.end method

.method public static synthetic build$default(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutStateFactory  com.bytedance.trae.kmp.host.KmpHostInfo  int  java.lang.Object)com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +006h
    sget-object v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;
    check-cast v1, Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->build(Lcom/bytedance/trae/kmp/host/KmpHostInfo;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    move-result-object v0
    return-object v0
.end method

.method private final buildAboutItems(com.bytedance.trae.kmp.host.KmpHostInfo)java.util.List
    .registers 12
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Website Lcom/bytedance/trae/kmp/network/KmpHostType;
    invoke-direct v10, v0, v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->webOrigin(Lcom/bytedance/trae/kmp/network/KmpHostType; Lcom/bytedance/trae/kmp/host/KmpHostInfo;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/kmp/network/KmpHostType;->Docs Lcom/bytedance/trae/kmp/network/KmpHostType;
    invoke-direct v10, v1, v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->webOrigin(Lcom/bytedance/trae/kmp/network/KmpHostType; Lcom/bytedance/trae/kmp/host/KmpHostInfo;)Ljava/lang/String;
    move-result-object v1
    invoke-direct v10, v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->webQuery(Lcom/bytedance/trae/kmp/host/KmpHostInfo;)Ljava/lang/String;
    move-result-object v2
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Terms Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, "/terms-of-service?"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->aboutWebItem(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    move-result-object v5
    invoke-interface v3, v5, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Privacy Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, "/privacy-policy?"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->aboutWebItem(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    move-result-object v5
    invoke-interface v3, v5, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->OpenSource Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, "/solo/open-source-software-notice-for-trae-solo-mobile-android?"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->aboutWebItem(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    move-result-object v5
    invoke-interface v3, v5, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Help Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, "/solo/what-is-trae-solo?"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->aboutWebItem(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    move-result-object v5
    invoke-interface v3, v5, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-interface v11, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isMainland()Z
    move-result v5
    if-eqz v5, +02ch
    new-instance v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Community Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination$ExternalBrowser;
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, Ljava/lang/StringBuilder;-><init>()V
    sget-object v9, Lcom/bytedance/trae/kmp/network/KmpHostType;->Community Lcom/bytedance/trae/kmp/network/KmpHostType;
    invoke-direct v4, v9, v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->webOrigin(Lcom/bytedance/trae/kmp/network/KmpHostType; Lcom/bytedance/trae/kmp/host/KmpHostInfo;)Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const/16 v9, 47
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-direct v7, v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination$ExternalBrowser;-><init>(Ljava/lang/String;)V
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;
    invoke-direct v5, v6, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;)V
    invoke-interface v3, v5, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Contact Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-interface v11, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isEnterprise()Z
    move-result v6
    if-eqz v6, +016h
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "/enterprise_contact-us"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    goto +18h
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v6, "/solo/support?"
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v4, v5, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->aboutWebItem(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    move-result-object v1
    invoke-interface v3, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-interface v11, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isMainland()Z
    move-result v11
    if-eqz v11, +08eh
    sget-object v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->PersonalInfoList Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "/h5/personal-collect"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v4, v11, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->aboutWebItem(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    move-result-object v11
    invoke-interface v3, v11, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ShareList Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "/h5/share-list"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v4, v11, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->aboutWebItem(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    move-result-object v11
    invoke-interface v3, v11, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->BusinessLicense Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "/h5/business-license"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v4, v11, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->aboutWebItem(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    move-result-object v11
    invoke-interface v3, v11, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->IcpFiling Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "/h5/icp-filing"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v4, v11, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->aboutWebItem(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    move-result-object v11
    invoke-interface v3, v11, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->PermissionUsage Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "/h5/permission-usage-policy"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v4, v11, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->aboutWebItem(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    move-result-object v11
    invoke-interface v3, v11, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-static v3, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v11
    return-object v11
.end method

.method private final webOrigin(com.bytedance.trae.kmp.network.KmpHostType  com.bytedance.trae.kmp.host.KmpHostInfo)java.lang.String
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->INSTANCE Lcom/bytedance/trae/kmp/network/KmpHostResolver;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->host(Lcom/bytedance/trae/kmp/network/KmpHostType; Lcom/bytedance/trae/kmp/host/KmpHostInfo;)Ljava/lang/String;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +005h
    const-string v2, ""
    goto +10h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v0, "https://"
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method private final webQuery(com.bytedance.trae.kmp.host.KmpHostInfo)java.lang.String
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "_lang="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v3, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getLanguageCode()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v0, "&platform=h5"
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public final build(com.bytedance.trae.kmp.host.KmpHostInfo)com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState
    .registers 5
    # ins_size=2
    const-string v0, "hostInfo"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v4, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getAppVersionName()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +004h
    const-string v0, "1.0.0"
    check-cast v0, Ljava/lang/String;
    invoke-direct v3, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->buildAboutItems(Lcom/bytedance/trae/kmp/host/KmpHostInfo;)Ljava/util/List;
    move-result-object v4
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    const-string v2, "TRAE"
    invoke-direct v1, v2, v0, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)V
    return-object v1
.end method
