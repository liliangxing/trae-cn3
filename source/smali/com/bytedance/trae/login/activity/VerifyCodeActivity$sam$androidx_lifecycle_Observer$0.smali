# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final synthetic Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;
.super Ljava/lang/Object;
.source "VerifyCodeActivity.kt"

.implements Landroidx/lifecycle/Observer;
.implements Lkotlin/jvm/internal/FunctionAdapter;

.field private final synthetic function:Lkotlin/jvm/functions/Function1;


.method constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "function"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;->function Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final equals(java.lang.Object)boolean
    .registers 4
    # ins_size=2
    instance-of v0, v3, Landroidx/lifecycle/Observer;
    const/4 v1, 0
    if-eqz v0, +017h
    instance-of v0, v3, Lkotlin/jvm/internal/FunctionAdapter;
    if-eqz v0, +013h
    move-object v0, v2
    check-cast v0, Lkotlin/jvm/internal/FunctionAdapter;
    invoke-interface v0, Lkotlin/jvm/internal/FunctionAdapter;->getFunctionDelegate()Lkotlin/Function;
    move-result-object v0
    check-cast v3, Lkotlin/jvm/internal/FunctionAdapter;
    invoke-interface v3, Lkotlin/jvm/internal/FunctionAdapter;->getFunctionDelegate()Lkotlin/Function;
    move-result-object v3
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    return v1
.end method

.method public final getFunctionDelegate()kotlin.Function
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;->function Lkotlin/jvm/functions/Function1;
    check-cast v0, Lkotlin/Function;
    return-object v0
.end method

.method public final hashCode()int
    .registers 2
    # ins_size=1
    move-object v0, v1
    check-cast v0, Lkotlin/jvm/internal/FunctionAdapter;
    invoke-interface v0, Lkotlin/jvm/internal/FunctionAdapter;->getFunctionDelegate()Lkotlin/Function;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    return v0
.end method

.method public final synthetic onChanged(java.lang.Object)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$sam$androidx_lifecycle_Observer$0;->function Lkotlin/jvm/functions/Function1;
    invoke-interface v0, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
