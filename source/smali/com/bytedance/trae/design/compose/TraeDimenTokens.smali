# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/design/compose/TraeDimenTokens;
.super Ljava/lang/Object;
.source "TraeComposeTokens.kt"

.field public static final $stable:I
.field private static final Default:Lcom/bytedance/trae/design/compose/TraeDimens;
.field public static final INSTANCE:Lcom/bytedance/trae/design/compose/TraeDimenTokens;


.method static constructor <clinit>()void
    .registers 259
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/design/compose/TraeDimenTokens;
    invoke-direct v0, Lcom/bytedance/trae/design/compose/TraeDimenTokens;-><init>()V
    sput-object v0, Lcom/bytedance/trae/design/compose/TraeDimenTokens;->INSTANCE Lcom/bytedance/trae/design/compose/TraeDimenTokens;
    new-instance v0, Lcom/bytedance/trae/design/compose/TraeDimens;
    move-object v1, v0
    const/16 v2, 48
    int-to-float v15, v2
    invoke-static v15, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v2
    invoke-static v15, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v3
    const/16 v14, 20
    int-to-float v12, v14
    invoke-static v12, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v4
    const/16 v13, 12
    int-to-float v11, v13
    invoke-static v11, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v5
    const/16 v9, 16
    int-to-float v10, v9
    invoke-static v10, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v6
    invoke-static v10, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v7
    const/16 v8, 38
    int-to-float v8, v8
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v8
    move-object/from16 v247, v0
    const/16 v0, 17
    invoke-static v0, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v16
    move/from16 v69, v9
    move/from16 v229, v10
    move-wide/from16 v9, v16
    const/16 v13, 25
    int-to-float v13, v13
    invoke-static v13, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v17
    move/from16 v236, v11
    move/from16 v11, v17
    invoke-static v0, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v17
    move/from16 v241, v12
    move/from16 v191, v13
    const/16 v113, 12
    move-wide/from16 v12, v17
    invoke-static/range v191, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v16
    move/from16 v161, v14
    move/from16 v14, v16
    invoke-static v0, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v16
    move/from16 v227, v15
    move-wide/from16 v15, v16
    const/16 v0, 24
    int-to-float v0, v0
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v17
    const/16 v21, 17
    invoke-static/range v21, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v18
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v20
    invoke-static/range v21, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v22
    move-wide/from16 v21, v22
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v23
    invoke-static/range v69, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v24
    move-object/from16 v248, v1
    const/16 v1, 22
    move/from16 v249, v2
    int-to-float v2, v1
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v26
    invoke-static/range v69, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v27
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v29
    invoke-static/range v69, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v30
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v32
    const/16 v1, 15
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v33
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v35
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v36
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v38
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v39
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v41
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v42
    const/16 v1, 21
    int-to-float v1, v1
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v44
    const/16 v45, 15
    invoke-static/range v45, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v46
    move-wide/from16 v45, v46
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v47
    move/from16 v250, v3
    const/16 v3, 13
    invoke-static v3, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v48
    const/16 v3, 18
    move/from16 v251, v4
    int-to-float v4, v3
    invoke-static v4, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v50
    const/16 v51, 13
    invoke-static/range v51, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v52
    move-wide/from16 v51, v52
    invoke-static v4, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v53
    invoke-static/range v113, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v54
    const/16 v3, 14
    move/from16 v252, v5
    int-to-float v5, v3
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v56
    invoke-static/range v113, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v57
    move/from16 v253, v6
    const/16 v3, 15
    int-to-float v6, v3
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v59
    invoke-static/range v113, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v60
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v62
    const/16 v3, 11
    invoke-static v3, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v63
    const/16 v6, 13
    int-to-float v3, v6
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v65
    const/16 v6, 11
    invoke-static v6, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v66
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v68
    invoke-static/range v69, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v69
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v71
    const/16 v6, 14
    invoke-static v6, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v72
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v74
    const/16 v6, 13
    invoke-static v6, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v75
    move/from16 v254, v7
    const/16 v6, 17
    int-to-float v7, v6
    invoke-static v7, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v77
    const/16 v6, 13
    invoke-static v6, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v78
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v80
    invoke-static/range v113, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v81
    invoke-static v4, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v83
    const/4 v6, 4
    int-to-float v6, v6
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v84
    move/from16 v255, v8
    const/16 v8, 8
    int-to-float v8, v8
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v85
    move-wide/16 v256, v9
    const/4 v9, 0
    int-to-float v9, v9
    invoke-static v9, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v86
    const/16 v9, 240
    int-to-float v9, v9
    invoke-static v9, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v87
    const/high16 v9, 1056964608
    invoke-static v9, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v88
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v89
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v90
    const/16 v9, 44
    int-to-float v9, v9
    invoke-static v9, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v91
    invoke-static/range v229, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v92
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v93
    invoke-static/range v229, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v94
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v95
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v96
    invoke-static/range v229, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v97
    invoke-static/range v236, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v98
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v99
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v100
    const/16 v3, 200
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v101
    const/16 v3, 10
    invoke-static v3, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v102
    const/16 v3, 13
    invoke-static v3, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v104
    invoke-static v7, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v106
    invoke-static v3, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v107
    invoke-static v7, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v109
    const/16 v3, 28
    invoke-static v3, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v110
    const/16 v10, 36
    int-to-float v10, v10
    invoke-static v10, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v112
    invoke-static/range v113, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v113
    invoke-static v4, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v115
    const/16 v4, 32
    invoke-static v4, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v116
    invoke-static v9, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v118
    const/16 v119, 11
    invoke-static/range v119, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v119
    invoke-static/range v229, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v121
    const/16 v3, 26
    invoke-static v3, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v122
    int-to-float v3, v4
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v124
    const/16 v125, 26
    invoke-static/range v125, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v126
    move-wide/from16 v125, v126
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v127
    invoke-static v4, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v128
    const/16 v3, 40
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v130
    invoke-static v4, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v131
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v133
    invoke-static/range v161, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v134
    const/16 v4, 26
    int-to-float v4, v4
    invoke-static v4, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v136
    invoke-static/range v161, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v137
    invoke-static v4, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v139
    const/16 v143, 18
    invoke-static/range v143, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v140
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v142
    invoke-static/range v143, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v144
    move-wide/from16 v143, v144
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v145
    const/16 v149, 22
    invoke-static/range v149, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v146
    move/16 v258, v11
    const/16 v11, 28
    int-to-float v11, v11
    invoke-static v11, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v148
    invoke-static/range v149, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v149
    invoke-static v11, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v151
    const/16 v152, 18
    invoke-static/range v152, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v152
    invoke-static v4, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v154
    const/16 v4, 15
    invoke-static v4, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v155
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v157
    const/16 v1, 14
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v158
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v160
    invoke-static/range v161, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v161
    invoke-static v11, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v163
    const/16 v1, 13
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v164
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v166
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v167
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v168
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v169
    invoke-static v9, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v170
    invoke-static/range v236, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v171
    const/4 v1, 3
    int-to-float v1, v1
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v172
    invoke-static/range v236, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v173
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v174
    const/4 v1, 6
    int-to-float v1, v1
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v175
    invoke-static/range v229, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v176
    const/4 v4, 5
    int-to-float v4, v4
    invoke-static v4, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v177
    invoke-static v10, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v178
    invoke-static/range v229, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v179
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v180
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v181
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v182
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v183
    const/16 v3, 80
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v184
    invoke-static v9, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v185
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v186
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v187
    const/high16 v3, 1095237632
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v188
    const/16 v3, 88
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v189
    const/16 v3, 176
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v190
    invoke-static/range v191, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v191
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v192
    const/16 v3, 54
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v193
    const/16 v3, 70
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v194
    const/4 v3, 2
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v195
    const/16 v3, 92
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v196
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v197
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v198
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v199
    invoke-static v11, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v200
    invoke-static/range v227, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v201
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v202
    invoke-static/range v236, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v203
    invoke-static/range v229, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v204
    const/4 v3, 1
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v205
    invoke-static/range v236, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v206
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v207
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v208
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v209
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v210
    invoke-static v4, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v211
    invoke-static v10, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v212
    invoke-static v11, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v213
    const/16 v3, 37
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v214
    const/16 v3, 52
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v215
    invoke-static/range v236, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v216
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v217
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v218
    invoke-static v10, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v219
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v220
    const/16 v3, 151
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v221
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v222
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v223
    const/16 v3, 86
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v224
    const/16 v3, 29
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v225
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v226
    invoke-static/range v227, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v227
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v228
    invoke-static/range v229, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v229
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v230
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v231
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v232
    invoke-static v7, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v233
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v234
    invoke-static v10, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v235
    invoke-static/range v236, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v236
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v237
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v238
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v239
    invoke-static v9, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v240
    invoke-static/range v241, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v241
    const/16 v0, 120
    int-to-float v0, v0
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v242
    const/16 v0, 17
    invoke-static v0, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v243
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v245
    const/16 v246, 0
    move-object/from16 v1, v248
    move/from16 v2, v249
    move/from16 v3, v250
    move/from16 v4, v251
    move/from16 v5, v252
    move/from16 v6, v253
    move/from16 v7, v254
    move/from16 v8, v255
    move-wide/from16 v9, v256
    move/from16 v11, v258
    invoke-direct/range v1 ... v246, Lcom/bytedance/trae/design/compose/TraeDimens;-><init>(F F F F F F F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F F F F F F F F F F F F F F F F F F F J J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F J F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F F J F Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v247, Lcom/bytedance/trae/design/compose/TraeDimenTokens;->Default Lcom/bytedance/trae/design/compose/TraeDimens;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getDefault()com.bytedance.trae.design.compose.TraeDimens
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeDimenTokens;->Default Lcom/bytedance/trae/design/compose/TraeDimens;
    return-object v0
.end method
