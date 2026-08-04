# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:I
.field public final synthetic f$1:I


.method public synthetic constructor <init>(int  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter$$ExternalSyntheticLambda0;->f$0 I
    iput v2, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter$$ExternalSyntheticLambda0;->f$1 I
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget v0, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter$$ExternalSyntheticLambda0;->f$0 I
    iget v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter$$ExternalSyntheticLambda0;->f$1 I
    check-cast v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->$r8$lambda$Eruaq0Sg9ck9wncQup4Hj9BJsDI(I I Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;)Z
    move-result v3
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    return-object v3
.end method
