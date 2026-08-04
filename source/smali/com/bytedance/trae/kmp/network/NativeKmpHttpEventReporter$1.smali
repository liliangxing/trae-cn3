# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final synthetic Lcom/bytedance/trae/kmp/network/NativeKmpHttpEventReporter$1;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "AndroidKmpHttpClientFactory.kt"

.implements Lkotlin/jvm/functions/Function5;


.method constructor <init>(java.lang.Object)void
    .registers 9
    # ins_size=2
    const/4 v1, 5
    const-class v3, Lcom/bytedance/trae/network/TraeRequestEventReporter;
    const-string/jumbo v4, report
    const-string/jumbo v5, report(Ljava/lang/String;JJLjava/lang/String;Ljava/util/Map;)V
    const/4 v6, 0
    move-object v0, v7
    move-object v2, v8
    invoke-direct/range v0 ... v6, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Object; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=6
    move-object v1, v9
    check-cast v1, Ljava/lang/String;
    check-cast v10, Ljava/lang/Number;
    invoke-virtual v10, Ljava/lang/Number;->longValue()J
    move-result-wide v2
    check-cast v11, Ljava/lang/Number;
    invoke-virtual v11, Ljava/lang/Number;->longValue()J
    move-result-wide v4
    move-object v6, v12
    check-cast v6, Ljava/lang/String;
    move-object v7, v13
    check-cast v7, Ljava/util/Map;
    move-object v0, v8
    invoke-virtual/range v0 ... v7, Lcom/bytedance/trae/kmp/network/NativeKmpHttpEventReporter$1;->invoke(Ljava/lang/String; J J Ljava/lang/String; Ljava/util/Map;)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method

.method public final invoke(java.lang.String  long  long  java.lang.String  java.util.Map)void
    .registers 17
    # ins_size=8
    const-string/jumbo v0, p3
    move-object v7, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, p4
    move-object/from16 v8, v16
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v9
    iget-object v1, v0, Lcom/bytedance/trae/kmp/network/NativeKmpHttpEventReporter$1;->receiver Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/network/TraeRequestEventReporter;
    move-object v2, v10
    move-wide v3, v11
    move-wide v5, v13
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/network/TraeRequestEventReporter;->report(Ljava/lang/String; J J Ljava/lang/String; Ljava/util/Map;)V
    return-void 
.end method
