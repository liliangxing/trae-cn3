# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/ExtraParamsImpl;
.super Ljava/lang/Object;
.source "ExtraParamsImpl.kt"

.implements Lcom/bytedance/trae/apm/api/IExtraParams;

.field private final _staticParams:Ljava/util/Map;


.method public constructor <init>()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Ljava/lang/Object;-><init>()V
    const/4 v0, 3
    new-array v0, v0, [Lkotlin/Pair;
    invoke-static Lcom/bytedance/apm/ApmContext;->getCurrentProcessName()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lcom/bytedance/trae/utils/StringKt;->analysis(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "flow_process_name"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    invoke-static Landroid/os/Process;->myPid()I
    move-result v1
    invoke-static v1, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lcom/bytedance/trae/utils/StringKt;->analysis(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "flow_process_id"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 1
    aput-object v1, v0, v2
    const-string v1, "flow_app_variant"
    invoke-virtual v3, Lcom/bytedance/trae/apm/impl/ExtraParamsImpl;->getAppVariant()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 2
    aput-object v1, v0, v2
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/apm/impl/ExtraParamsImpl;->_staticParams Ljava/util/Map;
    return-void 
.end method

.method public getAppVariant()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, ""
    return-object v0
.end method

.method public getStaticParams()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/apm/impl/ExtraParamsImpl;->_staticParams Ljava/util/Map;
    return-object v0
.end method
