package com.bytedance.vcloud.uniplayer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import com.bytedance.vcloud.compose.UniWindow_androidKt;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.lynx.tasm.animation.AnimationConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: UniVideoView.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"UniVideoView", "", "modifier", "Landroidx/compose/ui/Modifier;", "onWindowReady", "Lkotlin/Function1;", "Lcom/bytedance/vcloud/uniplayer/UniWindowClient;", "videoAspect", "", "scaleType", "Lcom/bytedance/vcloud/uniplayer/UniScaleType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;FLcom/bytedance/vcloud/uniplayer/UniScaleType;Landroidx/compose/runtime/Composer;II)V", "uniplayer-ui-trae_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UniVideoViewKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void UniVideoView(Modifier modifier, Function1<? super UniWindowClient, Unit> function1, float f, UniScaleType uniScaleType, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Function1<? super UniWindowClient, Unit> function12;
        int i4;
        float f2;
        int i5;
        Modifier modifier3;
        final UniVideoViewKt$UniVideoView$1 uniVideoViewKt$UniVideoView$1;
        Object rememberedValue;
        final Object rememberedValue2;
        boolean changedInstance;
        Object rememberedValue3;
        boolean changedInstance2;
        Object rememberedValue4;
        final float f3;
        final UniScaleType uniScaleType2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-743949682);
        ComposerKt.sourceInformation(startRestartGroup, "C(UniVideoView)P(!2,3)53@1350L54,54@1426L18,57@1474L336,57@1451L359,67@1838L163,67@1816L210:UniVideoView.kt#333alq");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            function12 = function1;
            i3 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
            } else if ((i & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 0) {
                f2 = f;
                i3 |= startRestartGroup.changed(f2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changed(uniScaleType == null ? -1 : uniScaleType.ordinal()) ? AnimationConstant.PROP_BOTTOM : 1024;
                }
                if ((i3 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                    modifier3 = i6 != 0 ? (Modifier) Modifier.Companion : modifier2;
                    uniVideoViewKt$UniVideoView$1 = i7 != 0 ? new Function1<UniWindowClient, Unit>() { // from class: com.bytedance.vcloud.uniplayer.UniVideoViewKt$UniVideoView$1
                        public final void invoke(UniWindowClient uniWindowClient) {
                            Intrinsics.checkNotNullParameter(uniWindowClient, "it");
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((UniWindowClient) obj);
                            return Unit.INSTANCE;
                        }
                    } : function12;
                    float f4 = i4 != 0 ? 1.7777778f : f2;
                    UniScaleType uniScaleType3 = i5 != 0 ? UniScaleType.ASPECT_FIT : uniScaleType;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-743949682, i3, -1, "com.bytedance.vcloud.uniplayer.UniVideoView (UniVideoView.kt:52)");
                    }
                    startRestartGroup.startReplaceGroup(-662257955);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):UniVideoView.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    final MutableState mutableState = (MutableState) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(-662257955);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):UniVideoView.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Object();
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                    startRestartGroup.startReplaceGroup(-1878998491);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):UniVideoView.kt#9igjgp");
                    changedInstance = startRestartGroup.changedInstance(rememberedValue2);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.bytedance.vcloud.uniplayer.UniVideoViewKt$UniVideoView$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                objectRef.element = mutableState.getValue();
                                System.out.println((Object) ("unip: UniVideoView Disposable start owner=" + rememberedValue2 + " current=" + objectRef.element));
                                final MutableState<WindowClientNative> mutableState2 = mutableState;
                                final Object obj = rememberedValue2;
                                return new DisposableEffectResult() { // from class: com.bytedance.vcloud.uniplayer.UniVideoViewKt$UniVideoView$2$1$invoke$$inlined$onDispose$1
                                    public void dispose() {
                                        objectRef.element = mutableState2.getValue();
                                        System.out.println((Object) ("unip: UniVideoView Disposable dispose owner=" + obj + " current=" + objectRef.element));
                                        WindowClientNative windowClientNative = (WindowClientNative) objectRef.element;
                                        if (windowClientNative != null) {
                                            windowClientNative.release();
                                        }
                                    }
                                };
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    startRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(unit, (Function1) rememberedValue3, startRestartGroup, 6);
                    startRestartGroup.startReplaceGroup(-1960975799);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):UniVideoView.kt#9igjgp");
                    changedInstance2 = startRestartGroup.changedInstance(rememberedValue2) | ((i3 & 112) == 32);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changedInstance2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                        rememberedValue4 = (Function1) new Function1<WindowClientNative, Unit>() { // from class: com.bytedance.vcloud.uniplayer.UniVideoViewKt$UniVideoView$3$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((WindowClientNative) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(WindowClientNative windowClientNative) {
                                Intrinsics.checkNotNullParameter(windowClientNative, "w");
                                System.out.println((Object) ("unip: UniVideoView onWindowReady owner=" + rememberedValue2 + " w=" + windowClientNative));
                                mutableState.setValue(windowClientNative);
                                uniVideoViewKt$UniVideoView$1.invoke(windowClientNative);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    startRestartGroup.endReplaceGroup();
                    UniWindow_androidKt.PlayerView(modifier3, (Function1) rememberedValue4, f4, uniScaleType3, startRestartGroup, (i3 & 14) | (i3 & 896) | (i3 & 7168), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function12 = uniVideoViewKt$UniVideoView$1;
                    f3 = f4;
                    uniScaleType2 = uniScaleType3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    f3 = f2;
                    uniScaleType2 = uniScaleType;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final Function1<? super UniWindowClient, Unit> function13 = function12;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.bytedance.vcloud.uniplayer.UniVideoViewKt$UniVideoView$4
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

                        public final void invoke(Composer composer2, int i8) {
                            UniVideoViewKt.UniVideoView(modifier4, function13, f3, uniScaleType2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            f2 = f;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            if ((i3 & 1171) == 1170) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-662257955);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):UniVideoView.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
            }
            final MutableState<WindowClientNative> mutableState2 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-662257955);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):UniVideoView.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            Unit unit2 = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1878998491);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):UniVideoView.kt#9igjgp");
            changedInstance = startRestartGroup.changedInstance(rememberedValue2);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.bytedance.vcloud.uniplayer.UniVideoViewKt$UniVideoView$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = mutableState2.getValue();
                    System.out.println((Object) ("unip: UniVideoView Disposable start owner=" + rememberedValue2 + " current=" + objectRef.element));
                    final MutableState mutableState22 = mutableState2;
                    final Object obj = rememberedValue2;
                    return new DisposableEffectResult() { // from class: com.bytedance.vcloud.uniplayer.UniVideoViewKt$UniVideoView$2$1$invoke$$inlined$onDispose$1
                        public void dispose() {
                            objectRef.element = mutableState22.getValue();
                            System.out.println((Object) ("unip: UniVideoView Disposable dispose owner=" + obj + " current=" + objectRef.element));
                            WindowClientNative windowClientNative = (WindowClientNative) objectRef.element;
                            if (windowClientNative != null) {
                                windowClientNative.release();
                            }
                        }
                    };
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(unit2, (Function1) rememberedValue3, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1960975799);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):UniVideoView.kt#9igjgp");
            changedInstance2 = startRestartGroup.changedInstance(rememberedValue2) | ((i3 & 112) == 32);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changedInstance2) {
            }
            rememberedValue4 = (Function1) new Function1<WindowClientNative, Unit>() { // from class: com.bytedance.vcloud.uniplayer.UniVideoViewKt$UniVideoView$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((WindowClientNative) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(WindowClientNative windowClientNative) {
                    Intrinsics.checkNotNullParameter(windowClientNative, "w");
                    System.out.println((Object) ("unip: UniVideoView onWindowReady owner=" + rememberedValue2 + " w=" + windowClientNative));
                    mutableState2.setValue(windowClientNative);
                    uniVideoViewKt$UniVideoView$1.invoke(windowClientNative);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            startRestartGroup.endReplaceGroup();
            UniWindow_androidKt.PlayerView(modifier3, (Function1) rememberedValue4, f4, uniScaleType3, startRestartGroup, (i3 & 14) | (i3 & 896) | (i3 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function12 = uniVideoViewKt$UniVideoView$1;
            f3 = f4;
            uniScaleType2 = uniScaleType3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function12 = function1;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        f2 = f;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        if ((i3 & 1171) == 1170) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-662257955);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):UniVideoView.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        final MutableState<WindowClientNative> mutableState22 = (MutableState) rememberedValue;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(-662257955);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):UniVideoView.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Unit unit22 = Unit.INSTANCE;
        startRestartGroup.startReplaceGroup(-1878998491);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):UniVideoView.kt#9igjgp");
        changedInstance = startRestartGroup.changedInstance(rememberedValue2);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.bytedance.vcloud.uniplayer.UniVideoViewKt$UniVideoView$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = mutableState22.getValue();
                System.out.println((Object) ("unip: UniVideoView Disposable start owner=" + rememberedValue2 + " current=" + objectRef.element));
                final MutableState mutableState222 = mutableState22;
                final Object obj = rememberedValue2;
                return new DisposableEffectResult() { // from class: com.bytedance.vcloud.uniplayer.UniVideoViewKt$UniVideoView$2$1$invoke$$inlined$onDispose$1
                    public void dispose() {
                        objectRef.element = mutableState222.getValue();
                        System.out.println((Object) ("unip: UniVideoView Disposable dispose owner=" + obj + " current=" + objectRef.element));
                        WindowClientNative windowClientNative = (WindowClientNative) objectRef.element;
                        if (windowClientNative != null) {
                            windowClientNative.release();
                        }
                    }
                };
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceGroup();
        EffectsKt.DisposableEffect(unit22, (Function1) rememberedValue3, startRestartGroup, 6);
        startRestartGroup.startReplaceGroup(-1960975799);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):UniVideoView.kt#9igjgp");
        changedInstance2 = startRestartGroup.changedInstance(rememberedValue2) | ((i3 & 112) == 32);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue4 = (Function1) new Function1<WindowClientNative, Unit>() { // from class: com.bytedance.vcloud.uniplayer.UniVideoViewKt$UniVideoView$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((WindowClientNative) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(WindowClientNative windowClientNative) {
                Intrinsics.checkNotNullParameter(windowClientNative, "w");
                System.out.println((Object) ("unip: UniVideoView onWindowReady owner=" + rememberedValue2 + " w=" + windowClientNative));
                mutableState22.setValue(windowClientNative);
                uniVideoViewKt$UniVideoView$1.invoke(windowClientNative);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceGroup();
        UniWindow_androidKt.PlayerView(modifier3, (Function1) rememberedValue4, f4, uniScaleType3, startRestartGroup, (i3 & 14) | (i3 & 896) | (i3 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function12 = uniVideoViewKt$UniVideoView$1;
        f3 = f4;
        uniScaleType2 = uniScaleType3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
