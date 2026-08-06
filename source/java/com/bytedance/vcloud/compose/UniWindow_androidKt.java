package com.bytedance.vcloud.compose;

import android.widget.LinearLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.bytedance.vcloud.uniplayer.UniScaleType;
import com.bytedance.vcloud.uniplayer.WindowClientNative;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.ss.ttm.player.TTAVPlayerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniWindow.android.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"PlayerView", "", "modifier", "Landroidx/compose/ui/Modifier;", "onWindowReady", "Lkotlin/Function1;", "Lcom/bytedance/vcloud/uniplayer/WindowClientNative;", "videoAspect", "", "scaleType", "Lcom/bytedance/vcloud/uniplayer/UniScaleType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;FLcom/bytedance/vcloud/uniplayer/UniScaleType;Landroidx/compose/runtime/Composer;II)V", "uniplayer-ui-trae_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UniWindow_androidKt {
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d4, code lost:
    
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ff, code lost:
    
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PlayerView(Modifier modifier, Function1<? super WindowClientNative, Unit> function1, final float f, final UniScaleType uniScaleType, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(uniScaleType, "scaleType");
        Composer startRestartGroup = composer.startRestartGroup(-1379076186);
        ComposerKt.sourceInformation(startRestartGroup, "C(PlayerView)P(!2,3)62@1720L419,75@2187L140,61@1689L644:UniWindow.android.kt#ei5rot");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        } else if ((i & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 0) {
            i3 |= startRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(uniScaleType.ordinal()) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (i5 != 0) {
                function1 = new Function1<WindowClientNative, Unit>() { // from class: com.bytedance.vcloud.compose.UniWindow_androidKt$PlayerView$1
                    public final void invoke(WindowClientNative windowClientNative) {
                        Intrinsics.checkNotNullParameter(windowClientNative, "it");
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                        invoke((WindowClientNative) obj3);
                        return Unit.INSTANCE;
                    }
                };
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1379076186, i3, -1, "com.bytedance.vcloud.compose.PlayerView (UniWindow.android.kt:60)");
            }
            startRestartGroup.startReplaceGroup(-1960975799);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):UniWindow.android.kt#9igjgp");
            int i6 = i3 & 7168;
            boolean z = ((i3 & 112) == 32) | ((i3 & 896) == 256) | (i6 == 2048);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
                obj = rememberedValue;
            }
            UniWindow_androidKt$PlayerView$2$1 uniWindow_androidKt$PlayerView$2$1 = new UniWindow_androidKt$PlayerView$2$1(f, uniScaleType, function1);
            startRestartGroup.updateRememberedValue(uniWindow_androidKt$PlayerView$2$1);
            obj = uniWindow_androidKt$PlayerView$2$1;
            Function1 function12 = (Function1) obj;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(655565057);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):UniWindow.android.kt#9igjgp");
            boolean z2 = i6 == 2048;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z2) {
                obj2 = rememberedValue2;
            }
            Function1<LinearLayout, Unit> function13 = new Function1<LinearLayout, Unit>() { // from class: com.bytedance.vcloud.compose.UniWindow_androidKt$PlayerView$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    invoke((LinearLayout) obj3);
                    return Unit.INSTANCE;
                }

                public final void invoke(LinearLayout linearLayout) {
                    Intrinsics.checkNotNullParameter(linearLayout, "view");
                    TTAVPlayerView childAt = linearLayout.getChildAt(0);
                    TTAVPlayerView tTAVPlayerView = childAt instanceof TTAVPlayerView ? childAt : null;
                    if (tTAVPlayerView != null) {
                        tTAVPlayerView.setScaleType(UniScaleType.this.getValue(), 0.0f, 0.0f);
                    }
                }
            };
            startRestartGroup.updateRememberedValue(function13);
            obj2 = function13;
            startRestartGroup.endReplaceGroup();
            AndroidView_androidKt.AndroidView(function12, modifier, (Function1) obj2, startRestartGroup, (i3 << 3) & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final Function1<? super WindowClientNative, Unit> function14 = function1;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.bytedance.vcloud.compose.UniWindow_androidKt$PlayerView$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                    invoke((Composer) obj3, ((Number) obj4).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    UniWindow_androidKt.PlayerView(modifier2, function14, f, uniScaleType, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
