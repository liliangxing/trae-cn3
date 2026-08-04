# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
.super Ljava/lang/Object;
.source "PermissionRationaleDialog.kt"

.field private final allowText:Ljava/lang/String;
.field private final denyPermanentText:Ljava/lang/String;
.field private final denyText:Ljava/lang/String;
.field private final iconResId:I
.field private final message:Ljava/lang/String;
.field private final onAllow:Lkotlin/jvm/functions/Function0;
.field private final onDeny:Lkotlin/jvm/functions/Function0;
.field private final onDenyPermanent:Lkotlin/jvm/functions/Function0;
.field private final title:Ljava/lang/String;


.method public static synthetic $r8$lambda$C6VGWyN07Avmhu-Y0Xp4LplyDD0()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->_init_$lambda$1()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$gg0_d3CGyMVgy7ih2oqDHNjOg6w()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->_init_$lambda$0()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>(int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 11
    # ins_size=10
    const-string/jumbo v0, title
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "allowText"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "denyText"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onAllow"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onDeny"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->iconResId I
    iput-object v3, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->title Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->message Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->allowText Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyText Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyPermanentText Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onAllow Lkotlin/jvm/functions/Function0;
    iput-object v9, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDeny Lkotlin/jvm/functions/Function0;
    iput-object v10, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDenyPermanent Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 24
    # ins_size=12
    move/from16 v0, v22
    and-int/lit8 v1, v0, 1
    if-eqz v1, +005h
    const/4 v1, 0
    move v3, v1
    goto +2h
    move v3, v13
    and-int/lit8 v1, v0, 32
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v18
    and-int/lit8 v1, v0, 64
    if-eqz v1, +009h
    new-instance v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config$$ExternalSyntheticLambda0;-><init>()V
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v19
    and-int/lit16 v1, v0, 128
    if-eqz v1, +009h
    new-instance v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config$$ExternalSyntheticLambda1;
    invoke-direct v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config$$ExternalSyntheticLambda1;-><init>()V
    move-object v10, v1
    goto +3h
    move-object/from16 v10, v20
    and-int/lit16 v0, v0, 256
    if-eqz v0, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v21
    move-object v2, v12
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    invoke-direct/range v2 ... v11, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;-><init>(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final _init_$lambda$0()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final _init_$lambda$1()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.common.widget.PermissionRationaleDialog$Config  int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  int  java.lang.Object)com.bytedance.trae.common.widget.PermissionRationaleDialog$Config
    .registers 22
    # ins_size=12
    move-object v0, v10
    move/from16 v1, v20
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget v2, v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->iconResId I
    goto +2h
    move v2, v11
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->title Ljava/lang/String;
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->message Ljava/lang/String;
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->allowText Ljava/lang/String;
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyText Ljava/lang/String;
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyPermanentText Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onAllow Lkotlin/jvm/functions/Function0;
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDeny Lkotlin/jvm/functions/Function0;
    goto +3h
    move-object/from16 v9, v18
    and-int/lit16 v1, v1, 256
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDenyPermanent Lkotlin/jvm/functions/Function0;
    goto +3h
    move-object/from16 v1, v19
    move v11, v2
    move-object v12, v3
    move-object v13, v4
    move-object v14, v5
    move-object v15, v6
    move-object/from16 v16, v7
    move-object/from16 v17, v8
    move-object/from16 v18, v9
    move-object/from16 v19, v1
    invoke-virtual/range v10 ... v19, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->copy(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->iconResId I
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->allowText Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyText Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyPermanentText Ljava/lang/String;
    return-object v0
.end method

.method public final component7()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onAllow Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final component8()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDeny Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final component9()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDenyPermanent Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final copy(int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)com.bytedance.trae.common.widget.PermissionRationaleDialog$Config
    .registers 21
    # ins_size=10
    const-string/jumbo v0, title
    move-object v3, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    move-object v4, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "allowText"
    move-object v5, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "denyText"
    move-object/from16 v6, v16
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onAllow"
    move-object/from16 v8, v18
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onDeny"
    move-object/from16 v9, v19
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    move-object v1, v0
    move v2, v12
    move-object/from16 v7, v17
    move-object/from16 v10, v20
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;-><init>(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    iget v1, v4, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->iconResId I
    iget v3, v5, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->iconResId I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->title Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->message Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->allowText Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->allowText Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyText Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyText Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyPermanentText Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyPermanentText Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onAllow Lkotlin/jvm/functions/Function0;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onAllow Lkotlin/jvm/functions/Function0;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDeny Lkotlin/jvm/functions/Function0;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDeny Lkotlin/jvm/functions/Function0;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDenyPermanent Lkotlin/jvm/functions/Function0;
    iget-object v5, v5, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDenyPermanent Lkotlin/jvm/functions/Function0;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAllowText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->allowText Ljava/lang/String;
    return-object v0
.end method

.method public final getDenyPermanentText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyPermanentText Ljava/lang/String;
    return-object v0
.end method

.method public final getDenyText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyText Ljava/lang/String;
    return-object v0
.end method

.method public final getIconResId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->iconResId I
    return v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->message Ljava/lang/String;
    return-object v0
.end method

.method public final getOnAllow()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onAllow Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnDeny()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDeny Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnDenyPermanent()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDenyPermanent Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->title Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->iconResId I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->title Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->message Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->allowText Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyText Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyPermanentText Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onAllow Lkotlin/jvm/functions/Function0;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDeny Lkotlin/jvm/functions/Function0;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDenyPermanent Lkotlin/jvm/functions/Function0;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Config(iconResId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->iconResId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", title="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->title Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", message="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", allowText="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->allowText Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", denyText="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyText Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", denyPermanentText="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->denyPermanentText Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", onAllow="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onAllow Lkotlin/jvm/functions/Function0;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", onDeny="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDeny Lkotlin/jvm/functions/Function0;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", onDenyPermanent="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->onDenyPermanent Lkotlin/jvm/functions/Function0;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
