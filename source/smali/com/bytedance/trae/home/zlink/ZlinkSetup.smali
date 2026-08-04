# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/zlink/ZlinkSetup;
.super Ljava/lang/Object;
.source "ZlinkSetup.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/zlink/ZlinkSetup;
.field private static final TAG:Ljava/lang/String;
.field private static final fetchExecutor:Ljava/util/concurrent/ExecutorService;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup;
    invoke-direct v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkSetup;
    invoke-static Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->fetchExecutor Ljava/util/concurrent/ExecutorService;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getFetchExecutor$p()java.util.concurrent.ExecutorService
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->fetchExecutor Ljava/util/concurrent/ExecutorService;
    return-object v0
.end method

.method public static final synthetic access$parseUrl(com.bytedance.trae.home.zlink.ZlinkSetup  java.lang.String)kotlin.Pair
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->parseUrl(Ljava/lang/String;)Lkotlin/Pair;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$toHeaderList(com.bytedance.trae.home.zlink.ZlinkSetup  java.util.Map)java.util.List
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/zlink/ZlinkSetup;->toHeaderList(Ljava/util/Map;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method private final parseUrl(java.lang.String)kotlin.Pair
    .registers 8
    # ins_size=2
    invoke-static v7, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v0
    invoke-virtual v0, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, "https"
    invoke-virtual v0, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v2
    const-string v3, "/"
    if-nez v2, +007h
    invoke-static v7, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    return-object v7
    invoke-virtual v0, Landroid/net/Uri;->getPort()I
    move-result v7
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v5, "://"
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    if-lez v7, +00bh
    const/16 v1, 58
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    const/16 v7, 47
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, Landroid/net/Uri;->getEncodedPath()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v3, v2
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v0, Landroid/net/Uri;->getEncodedQuery()Ljava/lang/String;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    if-nez v2, +00bh
    const/16 v2, 63
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v7, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    return-object v7
.end method

.method private final toHeaderList(java.util.Map)java.util.List
    .registers 6
    # ins_size=2
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/util/Map;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +004h
    const/4 v5, 0
    return-object v5
    new-instance v0, Ljava/util/ArrayList;
    invoke-interface v5, Ljava/util/Map;->size()I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v5
    invoke-interface v5, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01dh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    new-instance v3, Lcom/bytedance/retrofit2/client/Header;
    invoke-direct v3, v2, v1, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v0, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -20h
    check-cast v0, Ljava/util/List;
    return-object v0
.end method

.method public final buildDependAbility(android.app.Application)com.bytedance.ug.sdk.deeplink.ZlinkDependAbility
    .registers 6
    # ins_size=2
    const-string v0, "application"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkDependImpl;
    invoke-direct v0, v5, Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkDependImpl;-><init>(Landroid/app/Application;)V
    new-instance v1, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$network$1;
    invoke-direct v1, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$network$1;-><init>()V
    new-instance v2, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$appLinkCallback$1;
    invoke-direct v2, v5, Lcom/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$appLinkCallback$1;-><init>(Landroid/app/Application;)V
    new-instance v3, Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;
    invoke-direct v3, Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;-><init>()V
    invoke-virtual v3, v5, Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;->withApplication(Landroid/app/Application;)Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;
    move-result-object v5
    check-cast v0, Lcom/bytedance/ug/sdk/deeplink/IZlinkDepend;
    invoke-virtual v5, v0, Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;->withZlinkDepend(Lcom/bytedance/ug/sdk/deeplink/IZlinkDepend;)Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;
    move-result-object v5
    const-class v0, Lcom/bytedance/ug/sdk/deeplink/interfaces/INetwork;
    invoke-virtual v5, v0, v1, Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;->withService(Ljava/lang/Class; Ljava/lang/Object;)Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;
    move-result-object v5
    const-class v0, Lcom/bytedance/ug/sdk/deeplink/interfaces/IClipboard;
    new-instance v1, Lcom/bytedance/trae/home/zlink/TimonClipboardImpl;
    invoke-direct v1, Lcom/bytedance/trae/home/zlink/TimonClipboardImpl;-><init>()V
    invoke-virtual v5, v0, v1, Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;->withService(Ljava/lang/Class; Ljava/lang/Object;)Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;
    move-result-object v5
    check-cast v2, Lcom/bytedance/ug/sdk/deeplink/CallBackForAppLink;
    invoke-virtual v5, v2, Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;->withCallBackForAppLink(Lcom/bytedance/ug/sdk/deeplink/CallBackForAppLink;)Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;
    move-result-object v5
    const/4 v0, 0
    invoke-virtual v5, v0, Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;->withEnableClipboardOutside(Z)Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility$Builder;->build()Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility;
    move-result-object v5
    const-string v0, "build(...)"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v5
.end method
