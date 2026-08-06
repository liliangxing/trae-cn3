package androidx.compose.p002ui.graphics.vector;

import androidx.autofill.HintConstants;
import androidx.compose.p002ui.graphics.Brush;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.PathFillType;
import androidx.compose.p002ui.graphics.StrokeCap;
import androidx.compose.p002ui.graphics.StrokeJoin;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: VectorCompose.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a£\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H\u0007¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"Group", "", HintConstants.AUTOFILL_HINT_NAME, "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class VectorComposeKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Group(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List<? extends PathNode> list, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        float f8;
        int i5;
        float f9;
        int i6;
        float f10;
        int i7;
        int i8;
        int i9;
        String str2;
        float f11;
        final float f12;
        final float f13;
        final List<? extends PathNode> list2;
        final float f14;
        final float f15;
        final float f16;
        ScopeUpdateScope endRestartGroup;
        float f17;
        float f18;
        float f19;
        List<? extends PathNode> emptyPath;
        VectorComposeKt$Group$1$1 rememberedValue;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-1851426205);
        ComposerKt.sourceInformation(startRestartGroup, "C(Group)P(2,5,3,4,6,7,8,9)59@2563L20,58@2501L586:VectorCompose.kt#huu6hf");
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                f8 = f2;
                i3 |= startRestartGroup.changed(f8) ? Fields.RotationX : Fields.SpotShadowColor;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    f9 = f3;
                    i3 |= startRestartGroup.changed(f9) ? Fields.CameraDistance : Fields.RotationZ;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        f10 = f4;
                        i3 |= startRestartGroup.changed(f10) ? Fields.Clip : Fields.Shape;
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= 196608;
                        } else if ((i & 196608) == 0) {
                            i3 |= startRestartGroup.changed(f5) ? Fields.RenderEffect : 65536;
                        }
                        i8 = i2 & 64;
                        if (i8 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= startRestartGroup.changed(f6) ? 1048576 : Fields.BlendMode;
                        }
                        i9 = i2 & Fields.SpotShadowColor;
                        if (i9 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changed(f7) ? 8388608 : 4194304;
                        }
                        if ((i & 100663296) == 0) {
                            if ((i2 & Fields.RotationX) == 0 && startRestartGroup.changedInstance(list)) {
                                i10 = 67108864;
                                i3 |= i10;
                            }
                            i10 = 33554432;
                            i3 |= i10;
                        }
                        if ((i2 & Fields.RotationY) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                        }
                        if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                str2 = i11 != 0 ? "" : str;
                                f11 = i12 != 0 ? 0.0f : f;
                                if (i4 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i5 != 0) {
                                    f9 = 0.0f;
                                }
                                if (i6 != 0) {
                                    f10 = 1.0f;
                                }
                                f17 = i7 == 0 ? f5 : 1.0f;
                                f18 = i8 != 0 ? 0.0f : f6;
                                f19 = i9 == 0 ? f7 : 0.0f;
                                if ((i2 & Fields.RotationX) != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1851426205, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                                    }
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1104105737, "CC(remember):VectorCompose.kt#9igjgp");
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1$1
                                            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                            public final GroupComponent m5590invoke() {
                                                return new GroupComponent();
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    Function0 function0 = (Function0) rememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1291542257, "CC(ComposeNode)N(factory,update,content)361@14118L9:Composables.kt#9igjgp");
                                    if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    startRestartGroup.startNode();
                                    if (!startRestartGroup.getInserting()) {
                                        startRestartGroup.createNode(function0);
                                    } else {
                                        startRestartGroup.useNode();
                                    }
                                    Composer m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                                    Updater.m4116setimpl(m4109constructorimpl, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((GroupComponent) obj, (String) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, String str3) {
                                            groupComponent.setName(str3);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((GroupComponent) obj, ((Number) obj2).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, float f20) {
                                            groupComponent.setRotation(f20);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((GroupComponent) obj, ((Number) obj2).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, float f20) {
                                            groupComponent.setPivotX(f20);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((GroupComponent) obj, ((Number) obj2).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, float f20) {
                                            groupComponent.setPivotY(f20);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((GroupComponent) obj, ((Number) obj2).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, float f20) {
                                            groupComponent.setScaleX(f20);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, Float.valueOf(f17), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((GroupComponent) obj, ((Number) obj2).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, float f20) {
                                            groupComponent.setScaleY(f20);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, Float.valueOf(f18), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((GroupComponent) obj, ((Number) obj2).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, float f20) {
                                            groupComponent.setTranslationX(f20);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, Float.valueOf(f19), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((GroupComponent) obj, ((Number) obj2).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, float f20) {
                                            groupComponent.setTranslationY(f20);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((GroupComponent) obj, (List<? extends PathNode>) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                            groupComponent.setClipPathData(list3);
                                        }
                                    });
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1167503970, "C72@3072L9:VectorCompose.kt#huu6hf");
                                    function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    startRestartGroup.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    f12 = f17;
                                    f13 = f18;
                                    f15 = f9;
                                    list2 = emptyPath;
                                    float f20 = f8;
                                    f16 = f19;
                                    f14 = f20;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & Fields.RotationX) != 0) {
                                    i3 &= -234881025;
                                }
                                str2 = str;
                                f11 = f;
                                f17 = f5;
                                f18 = f6;
                                f19 = f7;
                            }
                            emptyPath = list;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1104105737, "CC(remember):VectorCompose.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            }
                            Function0 function02 = (Function0) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1291542257, "CC(ComposeNode)N(factory,update,content)361@14118L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
                            }
                            startRestartGroup.startNode();
                            if (!startRestartGroup.getInserting()) {
                            }
                            Composer m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
                            Updater.m4116setimpl(m4109constructorimpl2, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((GroupComponent) obj, (String) obj2);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, String str3) {
                                    groupComponent.setName(str3);
                                }
                            });
                            Updater.m4116setimpl(m4109constructorimpl2, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((GroupComponent) obj, ((Number) obj2).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, float f202) {
                                    groupComponent.setRotation(f202);
                                }
                            });
                            Updater.m4116setimpl(m4109constructorimpl2, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((GroupComponent) obj, ((Number) obj2).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, float f202) {
                                    groupComponent.setPivotX(f202);
                                }
                            });
                            Updater.m4116setimpl(m4109constructorimpl2, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((GroupComponent) obj, ((Number) obj2).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, float f202) {
                                    groupComponent.setPivotY(f202);
                                }
                            });
                            Updater.m4116setimpl(m4109constructorimpl2, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((GroupComponent) obj, ((Number) obj2).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, float f202) {
                                    groupComponent.setScaleX(f202);
                                }
                            });
                            Updater.m4116setimpl(m4109constructorimpl2, Float.valueOf(f17), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((GroupComponent) obj, ((Number) obj2).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, float f202) {
                                    groupComponent.setScaleY(f202);
                                }
                            });
                            Updater.m4116setimpl(m4109constructorimpl2, Float.valueOf(f18), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((GroupComponent) obj, ((Number) obj2).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, float f202) {
                                    groupComponent.setTranslationX(f202);
                                }
                            });
                            Updater.m4116setimpl(m4109constructorimpl2, Float.valueOf(f19), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((GroupComponent) obj, ((Number) obj2).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, float f202) {
                                    groupComponent.setTranslationY(f202);
                                }
                            });
                            Updater.m4116setimpl(m4109constructorimpl2, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((GroupComponent) obj, (List<? extends PathNode>) obj2);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                                    groupComponent.setClipPathData(list3);
                                }
                            });
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1167503970, "C72@3072L9:VectorCompose.kt#huu6hf");
                            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            f12 = f17;
                            f13 = f18;
                            f15 = f9;
                            list2 = emptyPath;
                            float f202 = f8;
                            f16 = f19;
                            f14 = f202;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            str2 = str;
                            f11 = f;
                            f12 = f5;
                            f13 = f6;
                            list2 = list;
                            f14 = f8;
                            f15 = f9;
                            f16 = f7;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final String str3 = str2;
                            final float f21 = f11;
                            final float f22 = f10;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    VectorComposeKt.Group(str3, f21, f14, f15, f22, f12, f13, f16, list2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    f10 = f4;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                    }
                    i9 = i2 & Fields.SpotShadowColor;
                    if (i9 != 0) {
                    }
                    if ((i & 100663296) == 0) {
                    }
                    if ((i2 & Fields.RotationY) != 0) {
                    }
                    if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                f9 = f3;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                f10 = f4;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                }
                i9 = i2 & Fields.SpotShadowColor;
                if (i9 != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i2 & Fields.RotationY) != 0) {
                }
                if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f8 = f2;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            f9 = f3;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            f10 = f4;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            i8 = i2 & 64;
            if (i8 != 0) {
            }
            i9 = i2 & Fields.SpotShadowColor;
            if (i9 != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i2 & Fields.RotationY) != 0) {
            }
            if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        f8 = f2;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        f9 = f3;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        f10 = f4;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        i8 = i2 & 64;
        if (i8 != 0) {
        }
        i9 = i2 & Fields.SpotShadowColor;
        if (i9 != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i2 & Fields.RotationY) != 0) {
        }
        if (startRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c9  */
    /* renamed from: Path-9cdaXJ4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m5589Path9cdaXJ4(final List<? extends PathNode> list, int i, String str, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        final String str2;
        final Brush brush3;
        final float f8;
        Brush brush4;
        final float f9;
        final float f10;
        final int i23;
        final int i24;
        final float f11;
        final float f12;
        final float f13;
        float f14;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1478270750);
        ComposerKt.sourceInformation(startRestartGroup, "C(Path)P(3,4:c#ui.graphics.PathFillType,2!4,10,7:c#ui.graphics.StrokeCap,8:c#ui.graphics.StrokeJoin!1,13)116@5136L19,115@5075L877:VectorCompose.kt#huu6hf");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(list) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i25 = i6 & 2;
        if (i25 != 0) {
            i7 |= 48;
        } else if ((i4 & 48) == 0) {
            i7 |= startRestartGroup.changed(i) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i4 & 384) == 0) {
                i7 |= startRestartGroup.changed(str) ? Fields.RotationX : Fields.SpotShadowColor;
                i9 = i6 & 8;
                int i26 = Fields.CameraDistance;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    i7 |= startRestartGroup.changed(brush) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        i7 |= startRestartGroup.changed(f) ? Fields.Clip : Fields.Shape;
                        i11 = i6 & 32;
                        if (i11 != 0) {
                            i7 |= 196608;
                        } else if ((i4 & 196608) == 0) {
                            i7 |= startRestartGroup.changed(brush2) ? Fields.RenderEffect : 65536;
                        }
                        i12 = i6 & 64;
                        if (i12 != 0) {
                            i7 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            i7 |= startRestartGroup.changed(f2) ? 1048576 : Fields.BlendMode;
                        }
                        i13 = i6 & Fields.SpotShadowColor;
                        if (i13 != 0) {
                            i7 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            i7 |= startRestartGroup.changed(f3) ? 8388608 : 4194304;
                        }
                        i14 = i6 & Fields.RotationX;
                        if (i14 != 0) {
                            i7 |= 100663296;
                        } else if ((i4 & 100663296) == 0) {
                            i7 |= startRestartGroup.changed(i2) ? 67108864 : 33554432;
                        }
                        i15 = i6 & Fields.RotationY;
                        if (i15 != 0) {
                            i7 |= 805306368;
                        } else if ((i4 & 805306368) == 0) {
                            i7 |= startRestartGroup.changed(i3) ? 536870912 : 268435456;
                        }
                        i16 = i6 & Fields.RotationZ;
                        if (i16 != 0) {
                            i17 = i5 | 6;
                        } else if ((i5 & 6) == 0) {
                            i17 = i5 | (startRestartGroup.changed(f4) ? 4 : 2);
                        } else {
                            i17 = i5;
                        }
                        i18 = i6 & Fields.CameraDistance;
                        if (i18 != 0) {
                            i17 |= 48;
                        } else if ((i5 & 48) == 0) {
                            i17 |= startRestartGroup.changed(f5) ? 32 : 16;
                        }
                        i19 = i17;
                        i20 = i6 & Fields.TransformOrigin;
                        if (i20 != 0) {
                            i19 |= 384;
                        } else if ((i5 & 384) == 0) {
                            i19 |= startRestartGroup.changed(f6) ? Fields.RotationX : Fields.SpotShadowColor;
                            i21 = i6 & Fields.Shape;
                            if (i21 == 0) {
                                i19 |= 3072;
                            } else if ((i5 & 3072) == 0) {
                                if (!startRestartGroup.changed(f7)) {
                                    i26 = 1024;
                                }
                                i19 |= i26;
                                if (!startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i19 & 1171) != 1170, i7 & 1)) {
                                    startRestartGroup.skipToGroupEnd();
                                    i22 = i;
                                    str2 = str;
                                    brush3 = brush;
                                    f8 = f;
                                    brush4 = brush2;
                                    f9 = f2;
                                    f10 = f3;
                                    i23 = i2;
                                    i24 = i3;
                                    f11 = f4;
                                    f12 = f5;
                                    f13 = f6;
                                    f14 = f7;
                                } else {
                                    i22 = i25 != 0 ? VectorKt.getDefaultFillType() : i;
                                    String str3 = i8 != 0 ? "" : str;
                                    Brush brush5 = i9 != 0 ? null : brush;
                                    float f15 = i10 != 0 ? 1.0f : f;
                                    brush4 = i11 != 0 ? null : brush2;
                                    float f16 = i12 != 0 ? 1.0f : f2;
                                    float f17 = i13 != 0 ? 0.0f : f3;
                                    int defaultStrokeLineCap = i14 != 0 ? VectorKt.getDefaultStrokeLineCap() : i2;
                                    int defaultStrokeLineJoin = i15 != 0 ? VectorKt.getDefaultStrokeLineJoin() : i3;
                                    float f18 = i16 != 0 ? 4.0f : f4;
                                    float f19 = i18 != 0 ? 0.0f : f5;
                                    float f20 = i20 != 0 ? 1.0f : f6;
                                    f14 = i21 == 0 ? f7 : 0.0f;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1478270750, i7, i19, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:114)");
                                    }
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1016006549, "CC(remember):VectorCompose.kt#9igjgp");
                                    VectorComposeKt$Path$1$1 rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$1$1
                                            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                            public final PathComponent m5591invoke() {
                                                return new PathComponent();
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    Function0 function0 = (Function0) rememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1886828752, "CC(ComposeNode)N(factory,update):Composables.kt#9igjgp");
                                    if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    startRestartGroup.startNode();
                                    if (startRestartGroup.getInserting()) {
                                        startRestartGroup.createNode(function0);
                                    } else {
                                        startRestartGroup.useNode();
                                    }
                                    Composer m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                                    Updater.m4116setimpl(m4109constructorimpl, str3, new Function2<PathComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((PathComponent) obj, (String) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(PathComponent pathComponent, String str4) {
                                            pathComponent.setName(str4);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, list, new Function2<PathComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$2
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((PathComponent) obj, (List<? extends PathNode>) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(PathComponent pathComponent, List<? extends PathNode> list2) {
                                            pathComponent.setPathData(list2);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, PathFillType.m5127boximpl(i22), new Function2<PathComponent, PathFillType, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$3
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            m5593invokepweu1eQ((PathComponent) obj, ((PathFillType) obj2).getValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-pweu1eQ, reason: not valid java name */
                                        public final void m5593invokepweu1eQ(PathComponent pathComponent, int i27) {
                                            pathComponent.m5581setPathFillTypeoQ8Xj4U(i27);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, brush5, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$4
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((PathComponent) obj, (Brush) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(PathComponent pathComponent, Brush brush6) {
                                            pathComponent.setFill(brush6);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, Float.valueOf(f15), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$5
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((PathComponent) obj, ((Number) obj2).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(PathComponent pathComponent, float f21) {
                                            pathComponent.setFillAlpha(f21);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, brush4, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$6
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((PathComponent) obj, (Brush) obj2);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(PathComponent pathComponent, Brush brush6) {
                                            pathComponent.setStroke(brush6);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, Float.valueOf(f16), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$7
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((PathComponent) obj, ((Number) obj2).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(PathComponent pathComponent, float f21) {
                                            pathComponent.setStrokeAlpha(f21);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, Float.valueOf(f17), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$8
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((PathComponent) obj, ((Number) obj2).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(PathComponent pathComponent, float f21) {
                                            pathComponent.setStrokeLineWidth(f21);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, StrokeJoin.m5214boximpl(defaultStrokeLineJoin), new Function2<PathComponent, StrokeJoin, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$9
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            m5594invokekLtJ_vA((PathComponent) obj, ((StrokeJoin) obj2).getValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-kLtJ_vA, reason: not valid java name */
                                        public final void m5594invokekLtJ_vA(PathComponent pathComponent, int i27) {
                                            pathComponent.m5583setStrokeLineJoinWw9F2mQ(i27);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, StrokeCap.m5204boximpl(defaultStrokeLineCap), new Function2<PathComponent, StrokeCap, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$10
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            m5592invokeCSYIeUk((PathComponent) obj, ((StrokeCap) obj2).getValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-CSYIeUk, reason: not valid java name */
                                        public final void m5592invokeCSYIeUk(PathComponent pathComponent, int i27) {
                                            pathComponent.m5582setStrokeLineCapBeK7IIE(i27);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, Float.valueOf(f18), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$11
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((PathComponent) obj, ((Number) obj2).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(PathComponent pathComponent, float f21) {
                                            pathComponent.setStrokeLineMiter(f21);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, Float.valueOf(f19), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$12
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((PathComponent) obj, ((Number) obj2).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(PathComponent pathComponent, float f21) {
                                            pathComponent.setTrimPathStart(f21);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, Float.valueOf(f20), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$13
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((PathComponent) obj, ((Number) obj2).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(PathComponent pathComponent, float f21) {
                                            pathComponent.setTrimPathEnd(f21);
                                        }
                                    });
                                    Updater.m4116setimpl(m4109constructorimpl, Float.valueOf(f14), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$14
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((PathComponent) obj, ((Number) obj2).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(PathComponent pathComponent, float f21) {
                                            pathComponent.setTrimPathOffset(f21);
                                        }
                                    });
                                    startRestartGroup.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    f11 = f18;
                                    str2 = str3;
                                    f10 = f17;
                                    f8 = f15;
                                    i24 = defaultStrokeLineJoin;
                                    f12 = f19;
                                    brush3 = brush5;
                                    f9 = f16;
                                    f13 = f20;
                                    i23 = defaultStrokeLineCap;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    final int i27 = i22;
                                    final Brush brush6 = brush4;
                                    final float f21 = f14;
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$3
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i28) {
                                            VectorComposeKt.m5589Path9cdaXJ4(list, i27, str2, brush3, f8, brush6, f9, f10, i23, i24, f11, f12, f13, f21, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if (!startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i19 & 1171) != 1170, i7 & 1)) {
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i21 = i6 & Fields.Shape;
                        if (i21 == 0) {
                        }
                        if (!startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i19 & 1171) != 1170, i7 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i11 = i6 & 32;
                    if (i11 != 0) {
                    }
                    i12 = i6 & 64;
                    if (i12 != 0) {
                    }
                    i13 = i6 & Fields.SpotShadowColor;
                    if (i13 != 0) {
                    }
                    i14 = i6 & Fields.RotationX;
                    if (i14 != 0) {
                    }
                    i15 = i6 & Fields.RotationY;
                    if (i15 != 0) {
                    }
                    i16 = i6 & Fields.RotationZ;
                    if (i16 != 0) {
                    }
                    i18 = i6 & Fields.CameraDistance;
                    if (i18 != 0) {
                    }
                    i19 = i17;
                    i20 = i6 & Fields.TransformOrigin;
                    if (i20 != 0) {
                    }
                    i21 = i6 & Fields.Shape;
                    if (i21 == 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i19 & 1171) != 1170, i7 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                i11 = i6 & 32;
                if (i11 != 0) {
                }
                i12 = i6 & 64;
                if (i12 != 0) {
                }
                i13 = i6 & Fields.SpotShadowColor;
                if (i13 != 0) {
                }
                i14 = i6 & Fields.RotationX;
                if (i14 != 0) {
                }
                i15 = i6 & Fields.RotationY;
                if (i15 != 0) {
                }
                i16 = i6 & Fields.RotationZ;
                if (i16 != 0) {
                }
                i18 = i6 & Fields.CameraDistance;
                if (i18 != 0) {
                }
                i19 = i17;
                i20 = i6 & Fields.TransformOrigin;
                if (i20 != 0) {
                }
                i21 = i6 & Fields.Shape;
                if (i21 == 0) {
                }
                if (!startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i19 & 1171) != 1170, i7 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i9 = i6 & 8;
            int i262 = Fields.CameraDistance;
            if (i9 != 0) {
            }
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            i12 = i6 & 64;
            if (i12 != 0) {
            }
            i13 = i6 & Fields.SpotShadowColor;
            if (i13 != 0) {
            }
            i14 = i6 & Fields.RotationX;
            if (i14 != 0) {
            }
            i15 = i6 & Fields.RotationY;
            if (i15 != 0) {
            }
            i16 = i6 & Fields.RotationZ;
            if (i16 != 0) {
            }
            i18 = i6 & Fields.CameraDistance;
            if (i18 != 0) {
            }
            i19 = i17;
            i20 = i6 & Fields.TransformOrigin;
            if (i20 != 0) {
            }
            i21 = i6 & Fields.Shape;
            if (i21 == 0) {
            }
            if (!startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i19 & 1171) != 1170, i7 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        i9 = i6 & 8;
        int i2622 = Fields.CameraDistance;
        if (i9 != 0) {
        }
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        i12 = i6 & 64;
        if (i12 != 0) {
        }
        i13 = i6 & Fields.SpotShadowColor;
        if (i13 != 0) {
        }
        i14 = i6 & Fields.RotationX;
        if (i14 != 0) {
        }
        i15 = i6 & Fields.RotationY;
        if (i15 != 0) {
        }
        i16 = i6 & Fields.RotationZ;
        if (i16 != 0) {
        }
        i18 = i6 & Fields.CameraDistance;
        if (i18 != 0) {
        }
        i19 = i17;
        i20 = i6 & Fields.TransformOrigin;
        if (i20 != 0) {
        }
        i21 = i6 & Fields.Shape;
        if (i21 == 0) {
        }
        if (!startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i19 & 1171) != 1170, i7 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
