# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/onboarding/OnboardingPageData;
.super Ljava/lang/Object;
.source "OnboardingPageData.kt"

.field public static final $stable:I
.field private final buttonTextResId:I
.field private final imageResId:I
.field private final isLastPage:Z
.field private final titleItalicResId:I
.field private final titleNormalResId:I


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(int  int  int  int  boolean)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleNormalResId I
    iput v2, v0, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleItalicResId I
    iput v3, v0, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->imageResId I
    iput v4, v0, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->buttonTextResId I
    iput-boolean v5, v0, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->isLastPage Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.onboarding.OnboardingPageData  int  int  int  int  boolean  int  java.lang.Object)com.bytedance.trae.home.onboarding.OnboardingPageData
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget v4, v3, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleNormalResId I
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget v5, v3, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleItalicResId I
    move v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget v6, v3, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->imageResId I
    move v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget v7, v3, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->buttonTextResId I
    move v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-boolean v8, v3, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->isLastPage Z
    move v2, v8
    move-object v5, v3
    move v6, v4
    move v7, v10
    move v8, v0
    move v9, v1
    move v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->copy(I I I I Z)Lcom/bytedance/trae/home/onboarding/OnboardingPageData;
    move-result-object v3
    return-object v3
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleNormalResId I
    return v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleItalicResId I
    return v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->imageResId I
    return v0
.end method

.method public final component4()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->buttonTextResId I
    return v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->isLastPage Z
    return v0
.end method

.method public final copy(int  int  int  int  boolean)com.bytedance.trae.home.onboarding.OnboardingPageData
    .registers 13
    # ins_size=6
    new-instance v6, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;
    move-object v0, v6
    move v1, v8
    move v2, v9
    move v3, v10
    move v4, v11
    move v5, v12
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;-><init>(I I I I Z)V
    return-object v6
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;
    iget v1, v4, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleNormalResId I
    iget v3, v5, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleNormalResId I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleItalicResId I
    iget v3, v5, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleItalicResId I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->imageResId I
    iget v3, v5, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->imageResId I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->buttonTextResId I
    iget v3, v5, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->buttonTextResId I
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->isLastPage Z
    iget-boolean v5, v5, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->isLastPage Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getButtonTextResId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->buttonTextResId I
    return v0
.end method

.method public final getImageResId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->imageResId I
    return v0
.end method

.method public final getTitleItalicResId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleItalicResId I
    return v0
.end method

.method public final getTitleNormalResId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleNormalResId I
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleNormalResId I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleItalicResId I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->imageResId I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->buttonTextResId I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->isLastPage Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isLastPage()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->isLastPage Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "OnboardingPageData(titleNormalResId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleNormalResId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", titleItalicResId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->titleItalicResId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", imageResId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->imageResId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", buttonTextResId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->buttonTextResId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isLastPage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/home/onboarding/OnboardingPageData;->isLastPage Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
