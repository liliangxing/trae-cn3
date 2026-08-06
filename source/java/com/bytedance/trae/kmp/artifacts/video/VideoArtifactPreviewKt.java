package com.bytedance.trae.kmp.artifacts.video;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.Velocity;
import com.bytedance.ies.bullet.preloadv2.PreloadV2Kt;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.trae.design.compose.TraeActivityIndicatorKt;
import com.bytedance.trae.design.compose.TraeColorTokens;
import com.bytedance.trae.design.compose.TraeContextMenuItem;
import com.bytedance.trae.design.compose.TraeContextMenuPopupKt;
import com.bytedance.trae.design.compose.TraeContextMenuPosition;
import com.bytedance.trae.design.compose.TraeContextMenuShadowPadding;
import com.bytedance.trae.design.compose.TraeDimens;
import com.bytedance.trae.design.compose.TraeTheme;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository;
import com.bytedance.trae.kmp.artifacts.generated.resources.Drawable0_commonMainKt;
import com.bytedance.trae.kmp.artifacts.generated.resources.Res;
import com.bytedance.trae.kmp.artifacts.generated.resources.String0_commonMainKt;
import com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewAction;
import com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState;
import com.bytedance.trae.kmp.p007ui.KmpClickHandler;
import com.bytedance.trae.kmp.p007ui.KmpStringResource_androidKt;
import com.bytedance.vcloud.uniplayer.InstIntKey;
import com.bytedance.vcloud.uniplayer.UniAVEngine;
import com.bytedance.vcloud.uniplayer.UniAbConfig;
import com.bytedance.vcloud.uniplayer.UniAbKey;
import com.bytedance.vcloud.uniplayer.UniInstConfig;
import com.bytedance.vcloud.uniplayer.UniScaleType;
import com.bytedance.vcloud.uniplayer.UniVideoViewKt;
import com.bytedance.vcloud.uniplayer.UniWindowClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResources_androidKt;

/* compiled from: VideoArtifactPreview.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0085\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00120\u00162\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\u0010!\u001a\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002\u001a\r\u0010&\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010'\u001a\u001b\u0010(\u001a\u00020\u00122\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120\u001aH\u0003¢\u0006\u0002\u0010*\u001aI\u0010+\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\u0010/\u001a\u008f\u0001\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u00022\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00120\u00162\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0002\u0010=\u001aO\u0010>\u001a\u00020\u00122\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0002\u0010?\u001a\u0010\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u000204H\u0002\u001a\u0010\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020\u0002H\u0002\u001a\u0010\u0010D\u001a\u00020%2\u0006\u0010C\u001a\u00020\u0002H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0010\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0010\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f\"\u0010\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f\"\u0010\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f\"\u000e\u0010\u000f\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006E²\u0006\n\u0010F\u001a\u00020\u0002X\u008a\u008e\u0002²\u0006\f\u0010G\u001a\u0004\u0018\u00010HX\u008a\u008e\u0002²\u0006\u0010\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00120\u001aX\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020<X\u008a\u008e\u0002²\u0006\n\u0010K\u001a\u000204X\u008a\u008e\u0002"}, d2 = {"PlaybackSpeeds", "", "", "PlaybackPositionUpdateIntervalMs", "", "PreviewBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "J", "PreviewStateTextColor", "PreviewReloadBackgroundColor", "PreviewDismissDistance", "Landroidx/compose/ui/unit/Dp;", "F", "PreviewDismissScaleDistance", "PreviewDismissVelocityThreshold", "PreviewDismissScaleReduction", "PreviewDismissResetDurationMs", "VideoArtifactPreviewScreen", "", "state", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState;", "onAttachPlayer", "Lkotlin/Function1;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;", "onDetachPlayer", "onPlayerWindowReady", "Lkotlin/Function0;", "onPlayerCreationFailed", "onAction", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction;", "onClose", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "createVideoArtifactEngine", "Lcom/bytedance/vcloud/uniplayer/UniAVEngine;", "localSource", "", "ArtifactPreviewLoadingState", "(Landroidx/compose/runtime/Composer;I)V", "ArtifactPreviewErrorState", "onReload", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "VideoArtifactPreviewContent", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;", "player", "Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;", "(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "VideoPlaybackControls", "isPlaying", "", "positionMs", "", "durationMs", "playbackSpeed", "onPlayPause", "onDragPosition", "onSeek", "onSpeedClick", "onSpeedAnchorChanged", "Landroidx/compose/ui/geometry/Offset;", "(ZJJFLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "VideoProgressBar", "(JJLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "formatTime", "timeMs", "formatSpeed", "speed", "formatMenuSpeed", "artifacts_mainlandRelease", "dragOffsetY", "resetAnimationJob", "Lkotlinx/coroutines/Job;", "currentOnClose", "speedAnchor", "pendingSeekMs"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class VideoArtifactPreviewKt {
    private static final int PlaybackPositionUpdateIntervalMs = 1000;
    private static final int PreviewDismissResetDurationMs = 250;
    private static final float PreviewDismissScaleReduction = 0.2f;
    private static final List<Float> PlaybackSpeeds = CollectionsKt.listOf(new Float[]{Float.valueOf(0.5f), Float.valueOf(1.0f), Float.valueOf(1.5f), Float.valueOf(2.0f)});
    private static final long PreviewBackgroundColor = ColorKt.Color(4278848010L);
    private static final long PreviewStateTextColor = ColorKt.Color(4285756275L);
    private static final long PreviewReloadBackgroundColor = ColorKt.Color(862546281);
    private static final float PreviewDismissDistance = Dp.constructor-impl(120);
    private static final float PreviewDismissScaleDistance = Dp.constructor-impl(PatchException.ERR_LOAD_SO_MD5_NOT_MATCH);
    private static final float PreviewDismissVelocityThreshold = Dp.constructor-impl(800);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ArtifactPreviewErrorState$lambda$39(Function0 function0, int i, Composer composer, int i2) {
        ArtifactPreviewErrorState(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ArtifactPreviewLoadingState$lambda$32(int i, Composer composer, int i2) {
        ArtifactPreviewLoadingState(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoArtifactPreviewContent$lambda$64(VideoArtifactPreviewState.Ready ready, UniVideoArtifactPlayer uniVideoArtifactPlayer, Function0 function0, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        VideoArtifactPreviewContent(ready, uniVideoArtifactPlayer, function0, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoArtifactPreviewScreen$lambda$27(VideoArtifactPreviewState videoArtifactPreviewState, Function1 function1, Function1 function12, Function0 function0, Function0 function02, Function1 function13, Function0 function03, Modifier modifier, int i, int i2, Composer composer, int i3) {
        VideoArtifactPreviewScreen(videoArtifactPreviewState, function1, function12, function0, function02, function13, function03, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoPlaybackControls$lambda$84(boolean z, long j, long j2, float f, Function0 function0, Function1 function1, Function1 function12, Function0 function02, Function1 function13, Modifier modifier, int i, int i2, Composer composer, int i3) {
        VideoPlaybackControls(z, j, j2, f, function0, function1, function12, function02, function13, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoProgressBar$lambda$92(long j, long j2, Function1 function1, Function1 function12, Modifier modifier, int i, int i2, Composer composer, int i3) {
        VideoProgressBar(j, j2, function1, function12, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void VideoArtifactPreviewScreen(final VideoArtifactPreviewState videoArtifactPreviewState, final Function1<? super VideoArtifactPlayer, Unit> function1, final Function1<? super VideoArtifactPlayer, Unit> function12, final Function0<Unit> function0, final Function0<Unit> function02, final Function1<? super VideoArtifactPreviewAction, Unit> function13, final Function0<Unit> function03, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        Composer composer2;
        Modifier modifier3;
        Object obj;
        VideoArtifactPreviewKt$VideoArtifactPreviewScreen$2$3$2$1 videoArtifactPreviewKt$VideoArtifactPreviewScreen$2$3$2$1;
        Intrinsics.checkNotNullParameter(videoArtifactPreviewState, "state");
        Intrinsics.checkNotNullParameter(function1, "onAttachPlayer");
        Intrinsics.checkNotNullParameter(function12, "onDetachPlayer");
        Intrinsics.checkNotNullParameter(function0, "onPlayerWindowReady");
        Intrinsics.checkNotNullParameter(function02, "onPlayerCreationFailed");
        Intrinsics.checkNotNullParameter(function13, "onAction");
        Intrinsics.checkNotNullParameter(function03, "onClose");
        Composer startRestartGroup = composer.startRestartGroup(-1210240656);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(videoArtifactPreviewState) : startRestartGroup.changedInstance(videoArtifactPreviewState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
        }
        if ((i2 & 32) != 0) {
            i3 |= 196608;
        } else if ((i & 196608) == 0) {
            i3 |= startRestartGroup.changedInstance(function13) ? 131072 : ArtifactRepository.IO_CHUNK_SIZE;
        }
        if ((i2 & 64) != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(function03) ? PreloadV2Kt.M_MEM_SIZE : 524288;
        }
        int i4 = i2 & 128;
        if (i4 != 0) {
            i3 |= 12582912;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i & 12582912) == 0) {
                i3 |= startRestartGroup.changed(modifier2) ? 8388608 : 4194304;
            }
        }
        if ((i3 & 4793491) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (i4 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1210240656, i3, -1, "com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewScreen (VideoArtifactPreview.kt:195)");
            }
            startRestartGroup.startReplaceGroup(1682469831);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1682471946);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function03, startRestartGroup, (i3 >> 18) & 14);
            CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            final float f = density.toPx-0680j_4(PreviewDismissDistance);
            float f2 = density.toPx-0680j_4(PreviewDismissScaleDistance);
            final float f3 = density.toPx-0680j_4(PreviewDismissVelocityThreshold);
            final float coerceIn = 1.0f - (RangesKt.coerceIn(VideoArtifactPreviewScreen$lambda$1(mutableFloatState) / f2, 0.0f, 1.0f) * PreviewDismissScaleReduction);
            Modifier modifier4 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, (Object) null), PreviewBackgroundColor, (Shape) null, 2, (Object) null);
            Float valueOf = Float.valueOf(f);
            Float valueOf2 = Float.valueOf(f3);
            Modifier modifier5 = modifier2;
            startRestartGroup.startReplaceGroup(1682502407);
            boolean changed = startRestartGroup.changed(f) | startRestartGroup.changed(f3) | startRestartGroup.changed(rememberUpdatedState) | startRestartGroup.changedInstance(coroutineScope);
            PointerInputEventHandler rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new PointerInputEventHandler() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1

                    /* compiled from: VideoArtifactPreview.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1", f = "VideoArtifactPreview.kt", i = {0, 1, 1, 1, 1, 1}, l = {219, 232}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "velocityTracker", "direction", "totalDrag", "dragStartOffsetY"}, s = {"L$0", "L$0", "L$1", "L$2", "J$0", "F$0"})
                    /* renamed from: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1 */
                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
                    static final class C08041 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ CoroutineScope $animationScope;
                        final /* synthetic */ State<Function0<Unit>> $currentOnClose$delegate;
                        final /* synthetic */ float $dismissDistancePx;
                        final /* synthetic */ float $dismissVelocityThresholdPx;
                        final /* synthetic */ MutableFloatState $dragOffsetY$delegate;
                        final /* synthetic */ MutableState<Job> $resetAnimationJob$delegate;
                        float F$0;
                        long J$0;
                        private /* synthetic */ Object L$0;
                        Object L$1;
                        Object L$2;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C08041(float f, float f2, CoroutineScope coroutineScope, MutableState<Job> mutableState, MutableFloatState mutableFloatState, State<? extends Function0<Unit>> state, Continuation<? super C08041> continuation) {
                            super(2, continuation);
                            this.$dismissDistancePx = f;
                            this.$dismissVelocityThresholdPx = f2;
                            this.$animationScope = coroutineScope;
                            this.$resetAnimationJob$delegate = mutableState;
                            this.$dragOffsetY$delegate = mutableFloatState;
                            this.$currentOnClose$delegate = state;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            Continuation<Unit> c08041 = new C08041(this.$dismissDistancePx, this.$dismissVelocityThresholdPx, this.$animationScope, this.$resetAnimationJob$delegate, this.$dragOffsetY$delegate, this.$currentOnClose$delegate, continuation);
                            c08041.L$0 = obj;
                            return c08041;
                        }

                        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                            return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:11:0x00ac  */
                        /* JADX WARN: Removed duplicated region for block: B:33:0x0078  */
                        /* JADX WARN: Removed duplicated region for block: B:41:0x015c  */
                        /* JADX WARN: Removed duplicated region for block: B:49:0x019b  */
                        /* JADX WARN: Removed duplicated region for block: B:8:0x009c  */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008d -> B:6:0x0090). Please report as a decompilation issue!!! */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object invokeSuspend(Object obj) {
                            AwaitPointerEventScope awaitPointerEventScope;
                            Object awaitFirstDown;
                            C08041 c08041;
                            AwaitPointerEventScope awaitPointerEventScope2;
                            float f;
                            int i;
                            PreviewDismissGestureDirection previewDismissGestureDirection;
                            VelocityTracker velocityTracker;
                            long j;
                            float VideoArtifactPreviewScreen$lambda$1;
                            Job VideoArtifactPreviewScreen$lambda$4;
                            float VideoArtifactPreviewScreen$lambda$12;
                            Function0 VideoArtifactPreviewScreen$lambda$6;
                            Object obj2;
                            PreviewDismissGestureDirection previewDismissGestureDirection2;
                            Job VideoArtifactPreviewScreen$lambda$42;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i2 = this.label;
                            int i3 = 2;
                            int i4 = 1;
                            if (i2 == 0) {
                                ResultKt.throwOnFailure(obj);
                                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                                this.L$0 = awaitPointerEventScope;
                                this.label = 1;
                                awaitFirstDown = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, PointerEventPass.Initial, (Continuation) this);
                                if (awaitFirstDown == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i2 != 1) {
                                    if (i2 != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    f = this.F$0;
                                    j = this.J$0;
                                    previewDismissGestureDirection = (PreviewDismissGestureDirection) this.L$2;
                                    velocityTracker = (VelocityTracker) this.L$1;
                                    awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    Object awaitPointerEvent = obj;
                                    c08041 = this;
                                    PointerEvent pointerEvent = (PointerEvent) awaitPointerEvent;
                                    if (pointerEvent.getChanges().size() != i4) {
                                        previewDismissGestureDirection = PreviewDismissGestureDirection.Rejected;
                                    }
                                    PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull(pointerEvent.getChanges());
                                    if (pointerInputChange != null) {
                                        int i5 = (pointerInputChange.getPressed() ? 1 : 0) ^ i4;
                                        velocityTracker.addPosition-Uv8p0NA(pointerInputChange.getUptimeMillis(), pointerInputChange.getPosition-F1C5BW0());
                                        if (i5 == 0) {
                                            j = Offset.plus-MK-Hz9U(j, PointerEventKt.positionChange(pointerInputChange));
                                            if (previewDismissGestureDirection == PreviewDismissGestureDirection.Undecided) {
                                                int i6 = (int) (j >> 32);
                                                obj2 = coroutine_suspended;
                                                int i7 = (int) (j & 4294967295L);
                                                if (Math.max(Math.abs(Float.intBitsToFloat(i6)), Math.abs(Float.intBitsToFloat(i7))) > awaitPointerEventScope2.getViewConfiguration().getTouchSlop()) {
                                                    if (Float.intBitsToFloat(i7) > 0.0f && Math.abs(Float.intBitsToFloat(i7)) > Math.abs(Float.intBitsToFloat(i6))) {
                                                        VideoArtifactPreviewScreen$lambda$42 = VideoArtifactPreviewKt.VideoArtifactPreviewScreen$lambda$4(c08041.$resetAnimationJob$delegate);
                                                        if (VideoArtifactPreviewScreen$lambda$42 != null) {
                                                            Job.DefaultImpls.cancel$default(VideoArtifactPreviewScreen$lambda$42, (CancellationException) null, 1, (Object) null);
                                                        }
                                                        f = VideoArtifactPreviewKt.VideoArtifactPreviewScreen$lambda$1(c08041.$dragOffsetY$delegate);
                                                        previewDismissGestureDirection2 = PreviewDismissGestureDirection.VerticalDown;
                                                    } else {
                                                        previewDismissGestureDirection2 = PreviewDismissGestureDirection.Rejected;
                                                    }
                                                    previewDismissGestureDirection = previewDismissGestureDirection2;
                                                }
                                            } else {
                                                obj2 = coroutine_suspended;
                                            }
                                            if (previewDismissGestureDirection == PreviewDismissGestureDirection.VerticalDown) {
                                                pointerInputChange.consume();
                                                c08041.$dragOffsetY$delegate.setFloatValue(RangesKt.coerceAtLeast(Float.intBitsToFloat((int) (j & 4294967295L)) + f, 0.0f));
                                            }
                                            coroutine_suspended = obj2;
                                        }
                                        i = i5;
                                        i3 = 2;
                                        i4 = 1;
                                        if (i == 0) {
                                            c08041.L$0 = awaitPointerEventScope2;
                                            c08041.L$1 = velocityTracker;
                                            c08041.L$2 = previewDismissGestureDirection;
                                            c08041.J$0 = j;
                                            c08041.F$0 = f;
                                            c08041.label = i3;
                                            awaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(PointerEventPass.Initial, (Continuation) c08041);
                                            if (awaitPointerEvent == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            PointerEvent pointerEvent2 = (PointerEvent) awaitPointerEvent;
                                            if (pointerEvent2.getChanges().size() != i4) {
                                            }
                                            PointerInputChange pointerInputChange2 = (PointerInputChange) CollectionsKt.firstOrNull(pointerEvent2.getChanges());
                                            if (pointerInputChange2 != null) {
                                            }
                                        }
                                    }
                                    if (previewDismissGestureDirection == PreviewDismissGestureDirection.VerticalDown) {
                                        VideoArtifactPreviewScreen$lambda$1 = VideoArtifactPreviewKt.VideoArtifactPreviewScreen$lambda$1(c08041.$dragOffsetY$delegate);
                                        if (!(VideoArtifactPreviewScreen$lambda$1 == 0.0f)) {
                                            VideoArtifactPreviewScreen$lambda$4 = VideoArtifactPreviewKt.VideoArtifactPreviewScreen$lambda$4(c08041.$resetAnimationJob$delegate);
                                            if (!(VideoArtifactPreviewScreen$lambda$4 != null && VideoArtifactPreviewScreen$lambda$4.isActive())) {
                                                c08041.$resetAnimationJob$delegate.setValue(BuildersKt.launch$default(c08041.$animationScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(c08041.$dragOffsetY$delegate, null), 3, (Object) null));
                                            }
                                        }
                                    } else {
                                        float f2 = Velocity.getY-impl(velocityTracker.calculateVelocity-9UxMQ8M());
                                        VideoArtifactPreviewScreen$lambda$12 = VideoArtifactPreviewKt.VideoArtifactPreviewScreen$lambda$1(c08041.$dragOffsetY$delegate);
                                        if (VideoArtifactPreviewScreen$lambda$12 > c08041.$dismissDistancePx || f2 > c08041.$dismissVelocityThresholdPx) {
                                            VideoArtifactPreviewScreen$lambda$6 = VideoArtifactPreviewKt.VideoArtifactPreviewScreen$lambda$6(c08041.$currentOnClose$delegate);
                                            VideoArtifactPreviewScreen$lambda$6.invoke();
                                        } else {
                                            c08041.$resetAnimationJob$delegate.setValue(BuildersKt.launch$default(c08041.$animationScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(c08041.$dragOffsetY$delegate, null), 3, (Object) null));
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                awaitFirstDown = obj;
                            }
                            PointerInputChange pointerInputChange3 = (PointerInputChange) awaitFirstDown;
                            VelocityTracker velocityTracker2 = new VelocityTracker();
                            velocityTracker2.addPosition-Uv8p0NA(pointerInputChange3.getUptimeMillis(), pointerInputChange3.getPosition-F1C5BW0());
                            c08041 = this;
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            f = 0.0f;
                            i = 0;
                            previewDismissGestureDirection = PreviewDismissGestureDirection.Undecided;
                            velocityTracker = velocityTracker2;
                            j = Offset.Companion.getZero-F1C5BW0();
                            if (i == 0) {
                            }
                            if (previewDismissGestureDirection == PreviewDismissGestureDirection.VerticalDown) {
                            }
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: VideoArtifactPreview.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$1", f = "VideoArtifactPreview.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$1, reason: invalid class name */
                        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ MutableFloatState $dragOffsetY$delegate;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(MutableFloatState mutableFloatState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$dragOffsetY$delegate = mutableFloatState;
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$dragOffsetY$delegate, continuation);
                            }

                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object obj) {
                                float VideoArtifactPreviewScreen$lambda$1;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    VideoArtifactPreviewScreen$lambda$1 = VideoArtifactPreviewKt.VideoArtifactPreviewScreen$lambda$1(this.$dragOffsetY$delegate);
                                    Animatable Animatable$default = AnimatableKt.Animatable$default(VideoArtifactPreviewScreen$lambda$1, 0.0f, 2, (Object) null);
                                    Float boxFloat = Boxing.boxFloat(0.0f);
                                    AnimationSpec tween$default = AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null);
                                    final MutableFloatState mutableFloatState = this.$dragOffsetY$delegate;
                                    this.label = 1;
                                    if (Animatable.animateTo$default(Animatable$default, boxFloat, tween$default, (Object) null, 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                        	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:129)
                                        	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
                                        	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:115)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        */
                                    /*
                                        this = this;
                                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                        int r1 = r13.label
                                        r2 = 1
                                        if (r1 == 0) goto L17
                                        if (r1 != r2) goto Lf
                                        kotlin.ResultKt.throwOnFailure(r14)
                                        goto L4c
                                    Lf:
                                        java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                        r14.<init>(r0)
                                        throw r14
                                    L17:
                                        kotlin.ResultKt.throwOnFailure(r14)
                                        androidx.compose.runtime.MutableFloatState r14 = r13.$dragOffsetY$delegate
                                        float r14 = com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt.access$VideoArtifactPreviewScreen$lambda$1(r14)
                                        r1 = 2
                                        r3 = 0
                                        r4 = 0
                                        androidx.compose.animation.core.Animatable r5 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r14, r3, r1, r4)
                                        java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
                                        r14 = 0
                                        r1 = 6
                                        r3 = 250(0xfa, float:3.5E-43)
                                        androidx.compose.animation.core.TweenSpec r14 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r3, r14, r4, r1, r4)
                                        r7 = r14
                                        androidx.compose.animation.core.AnimationSpec r7 = (androidx.compose.animation.core.AnimationSpec) r7
                                        r8 = 0
                                        androidx.compose.runtime.MutableFloatState r14 = r13.$dragOffsetY$delegate
                                        com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$1$$ExternalSyntheticLambda0 r9 = new com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$1$$ExternalSyntheticLambda0
                                        r9.<init>(r14)
                                        r10 = r13
                                        kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                                        r11 = 4
                                        r12 = 0
                                        r13.label = r2
                                        java.lang.Object r14 = androidx.compose.animation.core.Animatable.animateTo$default(r5, r6, r7, r8, r9, r10, r11, r12)
                                        if (r14 != r0) goto L4c
                                        return r0
                                    L4c:
                                        kotlin.Unit r14 = kotlin.Unit.INSTANCE
                                        return r14
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1.C08041.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final Unit invokeSuspend$lambda$0(MutableFloatState mutableFloatState, Animatable animatable) {
                                    mutableFloatState.setFloatValue(((Number) animatable.getValue()).floatValue());
                                    return Unit.INSTANCE;
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* compiled from: VideoArtifactPreview.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                            @DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2", f = "VideoArtifactPreview.kt", i = {}, l = {286}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2, reason: invalid class name */
                            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
                            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ MutableFloatState $dragOffsetY$delegate;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass2(MutableFloatState mutableFloatState, Continuation<? super AnonymousClass2> continuation) {
                                    super(2, continuation);
                                    this.$dragOffsetY$delegate = mutableFloatState;
                                }

                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass2(this.$dragOffsetY$delegate, continuation);
                                }

                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                }

                                public final Object invokeSuspend(Object obj) {
                                    float VideoArtifactPreviewScreen$lambda$1;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        VideoArtifactPreviewScreen$lambda$1 = VideoArtifactPreviewKt.VideoArtifactPreviewScreen$lambda$1(this.$dragOffsetY$delegate);
                                        Animatable Animatable$default = AnimatableKt.Animatable$default(VideoArtifactPreviewScreen$lambda$1, 0.0f, 2, (Object) null);
                                        Float boxFloat = Boxing.boxFloat(0.0f);
                                        AnimationSpec tween$default = AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null);
                                        final MutableFloatState mutableFloatState = this.$dragOffsetY$delegate;
                                        this.label = 1;
                                        if (Animatable.animateTo$default(Animatable$default, boxFloat, tween$default, (Object) null, 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2$$ExternalSyntheticLambda0, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:129)
                                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
                                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:115)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            */
                                        /*
                                            this = this;
                                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                            int r1 = r13.label
                                            r2 = 1
                                            if (r1 == 0) goto L17
                                            if (r1 != r2) goto Lf
                                            kotlin.ResultKt.throwOnFailure(r14)
                                            goto L4c
                                        Lf:
                                            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                            r14.<init>(r0)
                                            throw r14
                                        L17:
                                            kotlin.ResultKt.throwOnFailure(r14)
                                            androidx.compose.runtime.MutableFloatState r14 = r13.$dragOffsetY$delegate
                                            float r14 = com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt.access$VideoArtifactPreviewScreen$lambda$1(r14)
                                            r1 = 2
                                            r3 = 0
                                            r4 = 0
                                            androidx.compose.animation.core.Animatable r5 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r14, r3, r1, r4)
                                            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
                                            r14 = 0
                                            r1 = 6
                                            r3 = 250(0xfa, float:3.5E-43)
                                            androidx.compose.animation.core.TweenSpec r14 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r3, r14, r4, r1, r4)
                                            r7 = r14
                                            androidx.compose.animation.core.AnimationSpec r7 = (androidx.compose.animation.core.AnimationSpec) r7
                                            r8 = 0
                                            androidx.compose.runtime.MutableFloatState r14 = r13.$dragOffsetY$delegate
                                            com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2$$ExternalSyntheticLambda0 r9 = new com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2$$ExternalSyntheticLambda0
                                            r9.<init>(r14)
                                            r10 = r13
                                            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                                            r11 = 4
                                            r12 = 0
                                            r13.label = r2
                                            java.lang.Object r14 = androidx.compose.animation.core.Animatable.animateTo$default(r5, r6, r7, r8, r9, r10, r11, r12)
                                            if (r14 != r0) goto L4c
                                            return r0
                                        L4c:
                                            kotlin.Unit r14 = kotlin.Unit.INSTANCE
                                            return r14
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1.C08041.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                                    }

                                    /* JADX INFO: Access modifiers changed from: private */
                                    public static final Unit invokeSuspend$lambda$0(MutableFloatState mutableFloatState, Animatable animatable) {
                                        mutableFloatState.setFloatValue(((Number) animatable.getValue()).floatValue());
                                        return Unit.INSTANCE;
                                    }
                                }
                            }

                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C08041(f, f3, coroutineScope, mutableState, mutableFloatState, rememberUpdatedState, null), continuation);
                                return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, valueOf, valueOf2, (PointerInputEventHandler) rememberedValue4);
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, pointerInput);
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Composer composer3 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                        composer3.updateRememberedValue(Integer.valueOf(hashCode));
                        composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    startRestartGroup.startReplaceGroup(-1108579916);
                    Object rememberedValue5 = startRestartGroup.rememberedValue();
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        rememberedValue5 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj2) {
                                IntOffset VideoArtifactPreviewScreen$lambda$26$lambda$12$lambda$11;
                                VideoArtifactPreviewScreen$lambda$26$lambda$12$lambda$11 = VideoArtifactPreviewKt.VideoArtifactPreviewScreen$lambda$26$lambda$12$lambda$11(mutableFloatState, (Density) obj2);
                                return VideoArtifactPreviewScreen$lambda$26$lambda$12$lambda$11;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier offset = OffsetKt.offset(fillMaxSize$default, (Function1) rememberedValue5);
                    startRestartGroup.startReplaceGroup(-1108577245);
                    boolean changed2 = startRestartGroup.changed(coerceIn);
                    Object rememberedValue6 = startRestartGroup.rememberedValue();
                    if (changed2 || rememberedValue6 == Composer.Companion.getEmpty()) {
                        rememberedValue6 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj2) {
                                Unit VideoArtifactPreviewScreen$lambda$26$lambda$14$lambda$13;
                                VideoArtifactPreviewScreen$lambda$26$lambda$14$lambda$13 = VideoArtifactPreviewKt.VideoArtifactPreviewScreen$lambda$26$lambda$14$lambda$13(coerceIn, (GraphicsLayerScope) obj2);
                                return VideoArtifactPreviewScreen$lambda$26$lambda$14$lambda$13;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(offset, (Function1) rememberedValue6);
                    Alignment center2 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, graphicsLayer);
                    Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor2);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Composer composer4 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer4, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode2))) {
                        composer4.updateRememberedValue(Integer.valueOf(hashCode2));
                        composer4.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
                    }
                    Updater.set-impl(composer4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    if (Intrinsics.areEqual(videoArtifactPreviewState, VideoArtifactPreviewState.Preparing.INSTANCE)) {
                        startRestartGroup.startReplaceGroup(923111708);
                        ArtifactPreviewLoadingState(startRestartGroup, 0);
                        startRestartGroup.endReplaceGroup();
                        composer2 = startRestartGroup;
                        modifier3 = modifier5;
                    } else if (videoArtifactPreviewState instanceof VideoArtifactPreviewState.Ready) {
                        startRestartGroup.startReplaceGroup(923276814);
                        VideoArtifactPreviewState.Ready ready = (VideoArtifactPreviewState.Ready) videoArtifactPreviewState;
                        String localSource = ready.getLocalSource();
                        startRestartGroup.startReplaceGroup(1138161773);
                        boolean changed3 = startRestartGroup.changed(localSource);
                        Object rememberedValue7 = startRestartGroup.rememberedValue();
                        if (changed3 || rememberedValue7 == Composer.Companion.getEmpty()) {
                            try {
                                Result.Companion companion = Result.Companion;
                                obj = Result.constructor-impl(new UniVideoArtifactPlayer(createVideoArtifactEngine(((VideoArtifactPreviewState.Ready) videoArtifactPreviewState).getLocalSource())));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj = null;
                            }
                            rememberedValue7 = (UniVideoArtifactPlayer) obj;
                            startRestartGroup.updateRememberedValue(rememberedValue7);
                        }
                        final UniVideoArtifactPlayer uniVideoArtifactPlayer = (UniVideoArtifactPlayer) rememberedValue7;
                        startRestartGroup.endReplaceGroup();
                        if (uniVideoArtifactPlayer != null) {
                            startRestartGroup.startReplaceGroup(923625192);
                            startRestartGroup.startReplaceGroup(1138174220);
                            boolean changedInstance = startRestartGroup.changedInstance(uniVideoArtifactPlayer) | ((i3 & 112) == 32) | ((i3 & 896) == 256);
                            Object rememberedValue8 = startRestartGroup.rememberedValue();
                            if (changedInstance || rememberedValue8 == Composer.Companion.getEmpty()) {
                                rememberedValue8 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj2) {
                                        DisposableEffectResult m372x409ed741;
                                        m372x409ed741 = VideoArtifactPreviewKt.m372x409ed741(function1, uniVideoArtifactPlayer, function12, (DisposableEffectScope) obj2);
                                        return m372x409ed741;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue8);
                            }
                            startRestartGroup.endReplaceGroup();
                            EffectsKt.DisposableEffect(uniVideoArtifactPlayer, (Function1) rememberedValue8, startRestartGroup, 0);
                            modifier3 = modifier5;
                            composer2 = startRestartGroup;
                            VideoArtifactPreviewContent(ready, uniVideoArtifactPlayer, function0, function13, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), startRestartGroup, ((i3 >> 3) & 896) | 24576 | ((i3 >> 6) & 7168), 0);
                            composer2.endReplaceGroup();
                        } else {
                            composer2 = startRestartGroup;
                            modifier3 = modifier5;
                            composer2.startReplaceGroup(924251671);
                            String localSource2 = ready.getLocalSource();
                            composer2.startReplaceGroup(1138195057);
                            boolean z = (57344 & i3) == 16384;
                            Object rememberedValue9 = composer2.rememberedValue();
                            if (z || rememberedValue9 == Composer.Companion.getEmpty()) {
                                videoArtifactPreviewKt$VideoArtifactPreviewScreen$2$3$2$1 = new VideoArtifactPreviewKt$VideoArtifactPreviewScreen$2$3$2$1(function02, null);
                                composer2.updateRememberedValue(videoArtifactPreviewKt$VideoArtifactPreviewScreen$2$3$2$1);
                            } else {
                                videoArtifactPreviewKt$VideoArtifactPreviewScreen$2$3$2$1 = rememberedValue9;
                            }
                            composer2.endReplaceGroup();
                            EffectsKt.LaunchedEffect(localSource2, (Function2) videoArtifactPreviewKt$VideoArtifactPreviewScreen$2$3$2$1, composer2, 0);
                            composer2.startReplaceGroup(1138200556);
                            boolean z2 = (458752 & i3) == 131072;
                            Object rememberedValue10 = composer2.rememberedValue();
                            if (z2 || rememberedValue10 == Composer.Companion.getEmpty()) {
                                rememberedValue10 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda4
                                    public final Object invoke() {
                                        Unit m373x360f9971;
                                        m373x360f9971 = VideoArtifactPreviewKt.m373x360f9971(function13);
                                        return m373x360f9971;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue10);
                            }
                            composer2.endReplaceGroup();
                            ArtifactPreviewErrorState((Function0) rememberedValue10, composer2, 0);
                            composer2.endReplaceGroup();
                        }
                        composer2.endReplaceGroup();
                    } else {
                        composer2 = startRestartGroup;
                        modifier3 = modifier5;
                        if (!(videoArtifactPreviewState instanceof VideoArtifactPreviewState.Failed)) {
                            composer2.startReplaceGroup(1138155471);
                            composer2.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composer2.startReplaceGroup(924710657);
                        composer2.startReplaceGroup(1138210596);
                        boolean z3 = (458752 & i3) == 131072;
                        Object rememberedValue11 = composer2.rememberedValue();
                        if (z3 || rememberedValue11 == Composer.Companion.getEmpty()) {
                            rememberedValue11 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda5
                                public final Object invoke() {
                                    Unit m374x5fd8fef5;
                                    m374x5fd8fef5 = VideoArtifactPreviewKt.m374x5fd8fef5(function13);
                                    return m374x5fd8fef5;
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue11);
                        }
                        composer2.endReplaceGroup();
                        ArtifactPreviewErrorState((Function0) rememberedValue11, composer2, 0);
                        composer2.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                }
                ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit VideoArtifactPreviewScreen$lambda$27;
                            VideoArtifactPreviewScreen$lambda$27 = VideoArtifactPreviewKt.VideoArtifactPreviewScreen$lambda$27(VideoArtifactPreviewState.this, function1, function12, function0, function02, function13, function03, modifier2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            return VideoArtifactPreviewScreen$lambda$27;
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final float VideoArtifactPreviewScreen$lambda$1(MutableFloatState mutableFloatState) {
                return ((FloatState) mutableFloatState).getFloatValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Job VideoArtifactPreviewScreen$lambda$4(MutableState<Job> mutableState) {
                return (Job) ((State) mutableState).getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final IntOffset VideoArtifactPreviewScreen$lambda$26$lambda$12$lambda$11(MutableFloatState mutableFloatState, Density density) {
                Intrinsics.checkNotNullParameter(density, "$this$offset");
                return IntOffset.box-impl(IntOffset.constructor-impl((MathKt.roundToInt(VideoArtifactPreviewScreen$lambda$1(mutableFloatState)) & 4294967295L) | (0 << 32)));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit VideoArtifactPreviewScreen$lambda$26$lambda$14$lambda$13(float f, GraphicsLayerScope graphicsLayerScope) {
                Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
                graphicsLayerScope.setScaleX(f);
                graphicsLayerScope.setScaleY(f);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$19$lambda$18 */
            public static final DisposableEffectResult m372x409ed741(Function1 function1, final UniVideoArtifactPlayer uniVideoArtifactPlayer, final Function1 function12, DisposableEffectScope disposableEffectScope) {
                Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                function1.invoke(uniVideoArtifactPlayer);
                return new DisposableEffectResult() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$19$lambda$18$$inlined$onDispose$1
                    public void dispose() {
                        function12.invoke(uniVideoArtifactPlayer);
                    }
                };
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$22$lambda$21 */
            public static final Unit m373x360f9971(Function1 function1) {
                function1.invoke(VideoArtifactPreviewAction.Reload.INSTANCE);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$24$lambda$23 */
            public static final Unit m374x5fd8fef5(Function1 function1) {
                function1.invoke(VideoArtifactPreviewAction.Reload.INSTANCE);
                return Unit.INSTANCE;
            }

            private static final UniAVEngine createVideoArtifactEngine(String str) {
                UniAbConfig create = UniAbConfig.Companion.create();
                create.setUniAbKv(UniAbKey.USE_LOCK_TT_NOTIFIER, 1);
                UniInstConfig create2 = UniInstConfig.Companion.create();
                create2.setIntValue(InstIntKey.POSITION_UPDATE_INTERVAL, 1000);
                try {
                    return UniAVEngine.Companion.create(str, create, create2);
                } finally {
                    create.close();
                }
            }

            private static final void ArtifactPreviewLoadingState(Composer composer, final int i) {
                Composer composer2;
                Composer startRestartGroup = composer.startRestartGroup(-1200563270);
                if (i != 0 || !startRestartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1200563270, i, -1, "com.bytedance.trae.kmp.artifacts.video.ArtifactPreviewLoadingState (VideoArtifactPreview.kt:374)");
                    }
                    TraeDimens dimens = TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable);
                    Modifier modifier = PaddingKt.padding-VpY3zN4$default(OffsetKt.offset-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(-Dp.constructor-impl(Dp.constructor-impl(dimens.getVideoArtifactCardDurationHeight-D9Ej5fM() - dimens.getContextMenuDividerHeight-D9Ej5fM()) - dimens.getContextMenuDividerHeight-D9Ej5fM())), 1, (Object) null), dimens.getArtifactPreviewStateHorizontalPadding-D9Ej5fM(), 0.0f, 2, (Object) null);
                    Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Composer composer3 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                        composer3.updateRememberedValue(Integer.valueOf(hashCode));
                        composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    Modifier modifier2 = SizeKt.size-3ABfNKs(Modifier.Companion, dimens.getArtifactPreviewLoadingIndicatorSize-D9Ej5fM());
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
                    Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor2);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Composer composer4 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer4, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode2))) {
                        composer4.updateRememberedValue(Integer.valueOf(hashCode2));
                        composer4.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
                    }
                    Updater.set-impl(composer4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    TraeActivityIndicatorKt.TraeActivityIndicator-iJQMabo(SizeKt.size-3ABfNKs(Modifier.Companion, dimens.getTitleBarIconSize-D9Ej5fM()), TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getSpecialWhite-0d7_KjU(), startRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, dimens.getArtifactPreviewStateGap-D9Ej5fM()), startRestartGroup, 0);
                    String kmpStringResource = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_video_artifact_preview_loading(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
                    long j = PreviewStateTextColor;
                    TextStyle bodyBase = TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getBodyBase();
                    composer2 = startRestartGroup;
                    TextKt.Text--4IGK_g(kmpStringResource, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, bodyBase, composer2, 384, 0, 65018);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                }
                ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda16
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ArtifactPreviewLoadingState$lambda$32;
                            ArtifactPreviewLoadingState$lambda$32 = VideoArtifactPreviewKt.ArtifactPreviewLoadingState$lambda$32(i, (Composer) obj, ((Integer) obj2).intValue());
                            return ArtifactPreviewLoadingState$lambda$32;
                        }
                    });
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:43:0x023a, code lost:
            
                if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L45;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private static final void ArtifactPreviewErrorState(final Function0<Unit> function0, Composer composer, final int i) {
                int i2;
                Object obj;
                Composer composer2;
                Composer startRestartGroup = composer.startRestartGroup(-1864549436);
                if ((i & 6) == 0) {
                    i2 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
                } else {
                    i2 = i;
                }
                if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1864549436, i2, -1, "com.bytedance.trae.kmp.artifacts.video.ArtifactPreviewErrorState (VideoArtifactPreview.kt:408)");
                    }
                    TraeDimens dimens = TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable);
                    startRestartGroup.startReplaceGroup(-15563135);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new KmpClickHandler(null, 1, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    final KmpClickHandler kmpClickHandler = (KmpClickHandler) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    Modifier modifier = PaddingKt.padding-VpY3zN4$default(OffsetKt.offset-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(-dimens.getContextMenuShadowPaddingTop-D9Ej5fM()), 1, (Object) null), dimens.getArtifactPreviewStateHorizontalPadding-D9Ej5fM(), 0.0f, 2, (Object) null);
                    Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    int i3 = i2;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Composer composer3 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                        composer3.updateRememberedValue(Integer.valueOf(hashCode));
                        composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    ImageKt.Image(ImageResources_androidKt.painterResource(Drawable0_commonMainKt.getTrae_video_preview_error(Res.drawable.INSTANCE), startRestartGroup, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, dimens.getArtifactPreviewErrorIconSize-D9Ej5fM()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 48, 120);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, dimens.getArtifactPreviewStateGap-D9Ej5fM()), startRestartGroup, 0);
                    TextKt.Text--4IGK_g(KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_video_artifact_preview_error(Res.string.INSTANCE), new Object[0], startRestartGroup, 0), (Modifier) null, PreviewStateTextColor, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getBodyBase(), startRestartGroup, 384, 0, 65018);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, dimens.getArtifactPreviewStateGap-D9Ej5fM()), startRestartGroup, 0);
                    Modifier modifier2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(dimens.getArtifactPreviewReloadButtonRadius-D9Ej5fM())), PreviewReloadBackgroundColor, (Shape) null, 2, (Object) null);
                    startRestartGroup.startReplaceGroup(1553033385);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue2;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1553036560);
                    boolean changedInstance = startRestartGroup.changedInstance(kmpClickHandler) | ((i3 & 14) == 4);
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                        obj = rememberedValue3;
                    }
                    Function0 function02 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda14
                        public final Object invoke() {
                            Unit ArtifactPreviewErrorState$lambda$38$lambda$36$lambda$35;
                            ArtifactPreviewErrorState$lambda$38$lambda$36$lambda$35 = VideoArtifactPreviewKt.ArtifactPreviewErrorState$lambda$38$lambda$36$lambda$35(KmpClickHandler.this, function0);
                            return ArtifactPreviewErrorState$lambda$38$lambda$36$lambda$35;
                        }
                    };
                    startRestartGroup.updateRememberedValue(function02);
                    obj = function02;
                    startRestartGroup.endReplaceGroup();
                    Modifier modifier3 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-O2vRcR0$default(modifier2, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) obj, 28, (Object) null), dimens.getArtifactPreviewReloadButtonPaddingHorizontal-D9Ej5fM(), dimens.getArtifactPreviewReloadButtonPaddingVertical-D9Ej5fM());
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier3);
                    Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor2);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Composer composer4 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer4, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode2))) {
                        composer4.updateRememberedValue(Integer.valueOf(hashCode2));
                        composer4.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
                    }
                    Updater.set-impl(composer4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    composer2 = startRestartGroup;
                    TextKt.Text--4IGK_g(KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_video_artifact_preview_reload(Res.string.INSTANCE), new Object[0], startRestartGroup, 0), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getBodyBaseMd(), startRestartGroup, 384, 0, 65530);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                }
                ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda15
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit ArtifactPreviewErrorState$lambda$39;
                            ArtifactPreviewErrorState$lambda$39 = VideoArtifactPreviewKt.ArtifactPreviewErrorState$lambda$39(function0, i, (Composer) obj2, ((Integer) obj3).intValue());
                            return ArtifactPreviewErrorState$lambda$39;
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit ArtifactPreviewErrorState$lambda$38$lambda$36$lambda$35(KmpClickHandler kmpClickHandler, Function0 function0) {
                kmpClickHandler.tryHandle(function0);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:126:0x0486, code lost:
            
                if (r1 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L171;
             */
            /* JADX WARN: Code restructure failed: missing block: B:52:0x01e8, code lost:
            
                if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L89;
             */
            /* JADX WARN: Code restructure failed: missing block: B:62:0x0243, code lost:
            
                if (r1 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L102;
             */
            /* JADX WARN: Code restructure failed: missing block: B:69:0x026c, code lost:
            
                if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L111;
             */
            /* JADX WARN: Code restructure failed: missing block: B:76:0x0295, code lost:
            
                if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L120;
             */
            /* JADX WARN: Code restructure failed: missing block: B:83:0x02c0, code lost:
            
                if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L129;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:133:0x0551  */
            /* JADX WARN: Removed duplicated region for block: B:135:0x02b2  */
            /* JADX WARN: Removed duplicated region for block: B:137:0x0288  */
            /* JADX WARN: Removed duplicated region for block: B:139:0x025f  */
            /* JADX WARN: Removed duplicated region for block: B:141:0x0236  */
            /* JADX WARN: Removed duplicated region for block: B:142:0x021c  */
            /* JADX WARN: Removed duplicated region for block: B:144:0x01da  */
            /* JADX WARN: Removed duplicated region for block: B:146:0x0166  */
            /* JADX WARN: Removed duplicated region for block: B:147:0x00c3  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x055a  */
            /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00ca  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00e3  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0156  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x0162  */
            /* JADX WARN: Removed duplicated region for block: B:48:0x01d8  */
            /* JADX WARN: Removed duplicated region for block: B:51:0x01e2  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0217  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x0234  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x023d  */
            /* JADX WARN: Removed duplicated region for block: B:65:0x025d  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x0266  */
            /* JADX WARN: Removed duplicated region for block: B:72:0x0286  */
            /* JADX WARN: Removed duplicated region for block: B:75:0x028f  */
            /* JADX WARN: Removed duplicated region for block: B:79:0x02af  */
            /* JADX WARN: Removed duplicated region for block: B:82:0x02ba  */
            /* JADX WARN: Removed duplicated region for block: B:86:0x02e3  */
            /* JADX WARN: Removed duplicated region for block: B:89:0x0357  */
            /* JADX WARN: Type inference failed for: r11v18, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r11v19, types: [java.lang.Object, com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda22] */
            /* JADX WARN: Type inference failed for: r11v20 */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public static final void VideoArtifactPreviewContent(final VideoArtifactPreviewState.Ready ready, final UniVideoArtifactPlayer uniVideoArtifactPlayer, final Function0<Unit> function0, final Function1<? super VideoArtifactPreviewAction, Unit> function1, Modifier modifier, Composer composer, final int i, final int i2) {
                int i3;
                Modifier modifier2;
                int i4;
                Object rememberedValue;
                int hashCode;
                Composer composer2;
                boolean changedInstance;
                Object obj;
                Modifier modifier3;
                boolean z;
                Object obj2;
                boolean z2;
                Object obj3;
                boolean z3;
                Object obj4;
                boolean z4;
                Object obj5;
                Object rememberedValue2;
                DrawableResource drawableResource;
                boolean z5;
                Object obj6;
                ScopeUpdateScope endRestartGroup;
                Intrinsics.checkNotNullParameter(ready, "state");
                Intrinsics.checkNotNullParameter(uniVideoArtifactPlayer, "player");
                Intrinsics.checkNotNullParameter(function0, "onPlayerWindowReady");
                Intrinsics.checkNotNullParameter(function1, "onAction");
                Composer startRestartGroup = composer.startRestartGroup(-638522054);
                if ((i2 & 1) != 0) {
                    i3 = i | 6;
                } else if ((i & 6) == 0) {
                    i3 = (startRestartGroup.changed(ready) ? 4 : 2) | i;
                } else {
                    i3 = i;
                }
                if ((i2 & 2) != 0) {
                    i3 |= 48;
                } else if ((i & 48) == 0) {
                    i3 |= startRestartGroup.changedInstance(uniVideoArtifactPlayer) ? 32 : 16;
                }
                if ((i2 & 4) != 0) {
                    i3 |= 384;
                } else if ((i & 384) == 0) {
                    i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
                }
                int i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    modifier2 = modifier;
                    i3 |= startRestartGroup.changed(modifier2) ? 16384 : 8192;
                    i4 = i3;
                    if ((i4 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                        Modifier modifier4 = i5 == 0 ? (Modifier) Modifier.Companion : modifier2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-638522054, i4, -1, "com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewContent (VideoArtifactPreview.kt:462)");
                        }
                        startRestartGroup.startReplaceGroup(77860170);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        final MutableState mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        Modifier modifier5 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getSpecialBlack-0d7_KjU(), (Shape) null, 2, (Object) null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier5);
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (!startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(constructor);
                        } else {
                            startRestartGroup.useNode();
                        }
                        composer2 = Updater.constructor-impl(startRestartGroup);
                        Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                            composer2.updateRememberedValue(Integer.valueOf(hashCode));
                            composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        startRestartGroup.startReplaceGroup(619478513);
                        changedInstance = ((i4 & 896) != 256) | startRestartGroup.changedInstance(uniVideoArtifactPlayer);
                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changedInstance) {
                            obj = rememberedValue3;
                        }
                        Function1 function12 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda11
                            public final Object invoke(Object obj7) {
                                Unit VideoArtifactPreviewContent$lambda$63$lambda$44$lambda$43;
                                VideoArtifactPreviewContent$lambda$63$lambda$44$lambda$43 = VideoArtifactPreviewKt.VideoArtifactPreviewContent$lambda$63$lambda$44$lambda$43(UniVideoArtifactPlayer.this, function0, (UniWindowClient) obj7);
                                return VideoArtifactPreviewContent$lambda$63$lambda$44$lambda$43;
                            }
                        };
                        startRestartGroup.updateRememberedValue(function12);
                        obj = function12;
                        startRestartGroup.endReplaceGroup();
                        modifier3 = modifier4;
                        UniVideoViewKt.UniVideoView(fillMaxSize$default, (Function1) obj, 0.0f, UniScaleType.ASPECT_FIT, startRestartGroup, 3078, 4);
                        boolean isPlaying = ready.isPlaying();
                        long dragPositionMs = !ready.isDragging() ? ready.getDragPositionMs() : ready.getPositionMs();
                        long durationMs = ready.getDurationMs();
                        float playbackSpeed = ready.getPlaybackSpeed();
                        startRestartGroup.startReplaceGroup(619493012);
                        int i6 = i4 & 7168;
                        z = i6 != 2048;
                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!z) {
                            obj2 = rememberedValue4;
                        }
                        Function0 function02 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda17
                            public final Object invoke() {
                                Unit VideoArtifactPreviewContent$lambda$63$lambda$46$lambda$45;
                                VideoArtifactPreviewContent$lambda$63$lambda$46$lambda$45 = VideoArtifactPreviewKt.VideoArtifactPreviewContent$lambda$63$lambda$46$lambda$45(function1);
                                return VideoArtifactPreviewContent$lambda$63$lambda$46$lambda$45;
                            }
                        };
                        startRestartGroup.updateRememberedValue(function02);
                        obj2 = function02;
                        Function0 function03 = (Function0) obj2;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(619496674);
                        z2 = i6 != 2048;
                        Object rememberedValue5 = startRestartGroup.rememberedValue();
                        if (!z2) {
                            obj3 = rememberedValue5;
                        }
                        Function1 function13 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda18
                            public final Object invoke(Object obj7) {
                                Unit VideoArtifactPreviewContent$lambda$63$lambda$48$lambda$47;
                                VideoArtifactPreviewContent$lambda$63$lambda$48$lambda$47 = VideoArtifactPreviewKt.VideoArtifactPreviewContent$lambda$63$lambda$48$lambda$47(function1, ((Long) obj7).longValue());
                                return VideoArtifactPreviewContent$lambda$63$lambda$48$lambda$47;
                            }
                        };
                        startRestartGroup.updateRememberedValue(function13);
                        obj3 = function13;
                        Function1 function14 = (Function1) obj3;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(619500514);
                        z3 = i6 != 2048;
                        Object rememberedValue6 = startRestartGroup.rememberedValue();
                        if (!z3) {
                            obj4 = rememberedValue6;
                        }
                        Function1 function15 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda19
                            public final Object invoke(Object obj7) {
                                Unit VideoArtifactPreviewContent$lambda$63$lambda$50$lambda$49;
                                VideoArtifactPreviewContent$lambda$63$lambda$50$lambda$49 = VideoArtifactPreviewKt.VideoArtifactPreviewContent$lambda$63$lambda$50$lambda$49(function1, ((Long) obj7).longValue());
                                return VideoArtifactPreviewContent$lambda$63$lambda$50$lambda$49;
                            }
                        };
                        startRestartGroup.updateRememberedValue(function15);
                        obj4 = function15;
                        Function1 function16 = (Function1) obj4;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(619504531);
                        z4 = i6 != 2048;
                        Object rememberedValue7 = startRestartGroup.rememberedValue();
                        if (!z4) {
                            obj5 = rememberedValue7;
                        }
                        Function0 function04 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda20
                            public final Object invoke() {
                                Unit VideoArtifactPreviewContent$lambda$63$lambda$52$lambda$51;
                                VideoArtifactPreviewContent$lambda$63$lambda$52$lambda$51 = VideoArtifactPreviewKt.VideoArtifactPreviewContent$lambda$63$lambda$52$lambda$51(function1);
                                return VideoArtifactPreviewContent$lambda$63$lambda$52$lambda$51;
                            }
                        };
                        startRestartGroup.updateRememberedValue(function04);
                        obj5 = function04;
                        Function0 function05 = (Function0) obj5;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(619508277);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda21
                                public final Object invoke(Object obj7) {
                                    Unit VideoArtifactPreviewContent$lambda$63$lambda$54$lambda$53;
                                    VideoArtifactPreviewContent$lambda$63$lambda$54$lambda$53 = VideoArtifactPreviewKt.VideoArtifactPreviewContent$lambda$63$lambda$54$lambda$53(mutableState, (Offset) obj7);
                                    return VideoArtifactPreviewContent$lambda$63$lambda$54$lambda$53;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceGroup();
                        VideoPlaybackControls(isPlaying, dragPositionMs, durationMs, playbackSpeed, function03, function14, function16, function05, (Function1) rememberedValue2, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(boxScope.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 1, (Object) null), TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable).getVideoPreviewControlHorizontalMargin-D9Ej5fM(), 0.0f, TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable).getVideoPreviewControlHorizontalMargin-D9Ej5fM(), TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable).getVideoPreviewControlBottomMargin-D9Ej5fM(), 2, (Object) null), startRestartGroup, 100663296, 0);
                        startRestartGroup.startReplaceGroup(619524375);
                        if (ready.getShowSpeedMenu()) {
                            startRestartGroup.startReplaceGroup(619524220);
                            LinkedHashMap rememberedValue8 = startRestartGroup.rememberedValue();
                            if (rememberedValue8 == Composer.Companion.getEmpty()) {
                                List<Float> list = PlaybackSpeeds;
                                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
                                for (Object obj7 : list) {
                                    ((Number) obj7).floatValue();
                                    linkedHashMap.put(obj7, new KmpClickHandler(null, 1, null));
                                }
                                drawableResource = null;
                                z5 = true;
                                rememberedValue8 = linkedHashMap;
                                startRestartGroup.updateRememberedValue(rememberedValue8);
                            } else {
                                drawableResource = null;
                                z5 = true;
                            }
                            final Map map = (Map) rememberedValue8;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(619530040);
                            List<Float> list2 = PlaybackSpeeds;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                            Iterator it = list2.iterator();
                            while (it.hasNext()) {
                                final float floatValue = ((Number) it.next()).floatValue();
                                String valueOf = String.valueOf(floatValue);
                                String formatMenuSpeed = formatMenuSpeed(floatValue);
                                DrawableResource trae_video_preview_checkmark = (floatValue > ready.getPlaybackSpeed() ? 1 : (floatValue == ready.getPlaybackSpeed() ? 0 : -1)) == 0 ? z5 : false ? Drawable0_commonMainKt.getTrae_video_preview_checkmark(Res.drawable.INSTANCE) : drawableResource;
                                startRestartGroup.startReplaceGroup(-1716241161);
                                boolean changedInstance2 = startRestartGroup.changedInstance(map) | startRestartGroup.changed(floatValue) | (i6 == 2048 ? z5 : false);
                                Function0 rememberedValue9 = startRestartGroup.rememberedValue();
                                if (changedInstance2 || rememberedValue9 == Composer.Companion.getEmpty()) {
                                    rememberedValue9 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda22
                                        public final Object invoke() {
                                            Unit m370x3e254020;
                                            m370x3e254020 = VideoArtifactPreviewKt.m370x3e254020(map, floatValue, function1);
                                            return m370x3e254020;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue((Object) rememberedValue9);
                                }
                                startRestartGroup.endReplaceGroup();
                                arrayList.add(new TraeContextMenuItem(valueOf, formatMenuSpeed, rememberedValue9, (DrawableResource) null, (Color) null, (Color) null, trae_video_preview_checkmark, (Color) null, 184, (DefaultConstructorMarker) null));
                            }
                            ArrayList arrayList2 = arrayList;
                            startRestartGroup.endReplaceGroup();
                            TraeContextMenuPosition anchored = new TraeContextMenuPosition.Anchored(Float.intBitsToFloat((int) (VideoArtifactPreviewContent$lambda$41(mutableState) >> 32)), Float.intBitsToFloat((int) (VideoArtifactPreviewContent$lambda$41(mutableState) & 4294967295L)));
                            startRestartGroup.startReplaceGroup(619556318);
                            boolean z6 = i6 == 2048 ? z5 : false;
                            Object rememberedValue10 = startRestartGroup.rememberedValue();
                            if (!z6) {
                                obj6 = rememberedValue10;
                            }
                            Function0 function06 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda23
                                public final Object invoke() {
                                    Unit VideoArtifactPreviewContent$lambda$63$lambda$62$lambda$61;
                                    VideoArtifactPreviewContent$lambda$63$lambda$62$lambda$61 = VideoArtifactPreviewKt.VideoArtifactPreviewContent$lambda$63$lambda$62$lambda$61(function1);
                                    return VideoArtifactPreviewContent$lambda$63$lambda$62$lambda$61;
                                }
                            };
                            startRestartGroup.updateRememberedValue(function06);
                            obj6 = function06;
                            startRestartGroup.endReplaceGroup();
                            TraeContextMenuPopupKt.TraeContextMenuPopup-_G194Zc(arrayList2, anchored, (Function0) obj6, (Modifier) null, TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable).getVideoPreviewSpeedMenuWidth-D9Ej5fM(), TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable).getVideoPreviewSpeedMenuItemHeight-D9Ej5fM(), TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable).getVideoPreviewSpeedMenuRadius-D9Ej5fM(), 0.0f, 0.0f, true, true, true, TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable).getContextMenuItemHorizontalPadding-D9Ej5fM(), 0.0f, 0.0f, TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable).getBodySmLineHeightDp-D9Ej5fM(), TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable).getContextMenuDetailIconTextGap-D9Ej5fM(), TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable).getContextMenuAnchorGap-D9Ej5fM(), (TraeContextMenuShadowPadding) null, TraeColorTokens.INSTANCE.getLight().getBorderBorderNeutralL1-0d7_KjU(), TraeColorTokens.INSTANCE.getLight().getTextTextDefault-0d7_KjU(), Color.copy-wmQWz5c$default(TraeColorTokens.INSTANCE.getLight().getBgBgBaseDefault-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (String) null, startRestartGroup, 805306368, 54, 0, 4481416);
                        }
                        startRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier6 = modifier3;
                        endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda24
                            public final Object invoke(Object obj8, Object obj9) {
                                Unit VideoArtifactPreviewContent$lambda$64;
                                VideoArtifactPreviewContent$lambda$64 = VideoArtifactPreviewKt.VideoArtifactPreviewContent$lambda$64(VideoArtifactPreviewState.Ready.this, uniVideoArtifactPlayer, function0, function1, modifier6, i, i2, (Composer) obj8, ((Integer) obj9).intValue());
                                return VideoArtifactPreviewContent$lambda$64;
                            }
                        });
                        return;
                    }
                    return;
                }
                modifier2 = modifier;
                i4 = i3;
                if ((i4 & 9363) == 9362) {
                }
                if (i5 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(77860170);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                }
                final MutableState mutableState2 = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                Modifier modifier52 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getSpecialBlack-0d7_KjU(), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier52);
                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                }
                composer2 = Updater.constructor-impl(startRestartGroup);
                Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                }
                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash2);
                Updater.set-impl(composer2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                startRestartGroup.startReplaceGroup(619478513);
                changedInstance = ((i4 & 896) != 256) | startRestartGroup.changedInstance(uniVideoArtifactPlayer);
                Object rememberedValue32 = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                Function1 function122 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj72) {
                        Unit VideoArtifactPreviewContent$lambda$63$lambda$44$lambda$43;
                        VideoArtifactPreviewContent$lambda$63$lambda$44$lambda$43 = VideoArtifactPreviewKt.VideoArtifactPreviewContent$lambda$63$lambda$44$lambda$43(UniVideoArtifactPlayer.this, function0, (UniWindowClient) obj72);
                        return VideoArtifactPreviewContent$lambda$63$lambda$44$lambda$43;
                    }
                };
                startRestartGroup.updateRememberedValue(function122);
                obj = function122;
                startRestartGroup.endReplaceGroup();
                modifier3 = modifier4;
                UniVideoViewKt.UniVideoView(fillMaxSize$default2, (Function1) obj, 0.0f, UniScaleType.ASPECT_FIT, startRestartGroup, 3078, 4);
                boolean isPlaying2 = ready.isPlaying();
                if (!ready.isDragging()) {
                }
                long durationMs2 = ready.getDurationMs();
                float playbackSpeed2 = ready.getPlaybackSpeed();
                startRestartGroup.startReplaceGroup(619493012);
                int i62 = i4 & 7168;
                if (i62 != 2048) {
                }
                Object rememberedValue42 = startRestartGroup.rememberedValue();
                if (!z) {
                }
                Function0 function022 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda17
                    public final Object invoke() {
                        Unit VideoArtifactPreviewContent$lambda$63$lambda$46$lambda$45;
                        VideoArtifactPreviewContent$lambda$63$lambda$46$lambda$45 = VideoArtifactPreviewKt.VideoArtifactPreviewContent$lambda$63$lambda$46$lambda$45(function1);
                        return VideoArtifactPreviewContent$lambda$63$lambda$46$lambda$45;
                    }
                };
                startRestartGroup.updateRememberedValue(function022);
                obj2 = function022;
                Function0 function032 = (Function0) obj2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(619496674);
                if (i62 != 2048) {
                }
                Object rememberedValue52 = startRestartGroup.rememberedValue();
                if (!z2) {
                }
                Function1 function132 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda18
                    public final Object invoke(Object obj72) {
                        Unit VideoArtifactPreviewContent$lambda$63$lambda$48$lambda$47;
                        VideoArtifactPreviewContent$lambda$63$lambda$48$lambda$47 = VideoArtifactPreviewKt.VideoArtifactPreviewContent$lambda$63$lambda$48$lambda$47(function1, ((Long) obj72).longValue());
                        return VideoArtifactPreviewContent$lambda$63$lambda$48$lambda$47;
                    }
                };
                startRestartGroup.updateRememberedValue(function132);
                obj3 = function132;
                Function1 function142 = (Function1) obj3;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(619500514);
                if (i62 != 2048) {
                }
                Object rememberedValue62 = startRestartGroup.rememberedValue();
                if (!z3) {
                }
                Function1 function152 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda19
                    public final Object invoke(Object obj72) {
                        Unit VideoArtifactPreviewContent$lambda$63$lambda$50$lambda$49;
                        VideoArtifactPreviewContent$lambda$63$lambda$50$lambda$49 = VideoArtifactPreviewKt.VideoArtifactPreviewContent$lambda$63$lambda$50$lambda$49(function1, ((Long) obj72).longValue());
                        return VideoArtifactPreviewContent$lambda$63$lambda$50$lambda$49;
                    }
                };
                startRestartGroup.updateRememberedValue(function152);
                obj4 = function152;
                Function1 function162 = (Function1) obj4;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(619504531);
                if (i62 != 2048) {
                }
                Object rememberedValue72 = startRestartGroup.rememberedValue();
                if (!z4) {
                }
                Function0 function042 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda20
                    public final Object invoke() {
                        Unit VideoArtifactPreviewContent$lambda$63$lambda$52$lambda$51;
                        VideoArtifactPreviewContent$lambda$63$lambda$52$lambda$51 = VideoArtifactPreviewKt.VideoArtifactPreviewContent$lambda$63$lambda$52$lambda$51(function1);
                        return VideoArtifactPreviewContent$lambda$63$lambda$52$lambda$51;
                    }
                };
                startRestartGroup.updateRememberedValue(function042);
                obj5 = function042;
                Function0 function052 = (Function0) obj5;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(619508277);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                }
                startRestartGroup.endReplaceGroup();
                VideoPlaybackControls(isPlaying2, dragPositionMs, durationMs2, playbackSpeed2, function032, function142, function162, function052, (Function1) rememberedValue2, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(boxScope2.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 1, (Object) null), TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable).getVideoPreviewControlHorizontalMargin-D9Ej5fM(), 0.0f, TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable).getVideoPreviewControlHorizontalMargin-D9Ej5fM(), TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable).getVideoPreviewControlBottomMargin-D9Ej5fM(), 2, (Object) null), startRestartGroup, 100663296, 0);
                startRestartGroup.startReplaceGroup(619524375);
                if (ready.getShowSpeedMenu()) {
                }
                startRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }

            private static final long VideoArtifactPreviewContent$lambda$41(MutableState<Offset> mutableState) {
                return ((Offset) ((State) mutableState).getValue()).unbox-impl();
            }

            private static final void VideoArtifactPreviewContent$lambda$42(MutableState<Offset> mutableState, long j) {
                mutableState.setValue(Offset.box-impl(j));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit VideoArtifactPreviewContent$lambda$63$lambda$44$lambda$43(UniVideoArtifactPlayer uniVideoArtifactPlayer, Function0 function0, UniWindowClient uniWindowClient) {
                Intrinsics.checkNotNullParameter(uniWindowClient, "window");
                uniWindowClient.bindEngine(uniVideoArtifactPlayer.getEngine());
                function0.invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit VideoArtifactPreviewContent$lambda$63$lambda$46$lambda$45(Function1 function1) {
                function1.invoke(VideoArtifactPreviewAction.TogglePlayback.INSTANCE);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit VideoArtifactPreviewContent$lambda$63$lambda$48$lambda$47(Function1 function1, long j) {
                function1.invoke(new VideoArtifactPreviewAction.DragTo(j));
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit VideoArtifactPreviewContent$lambda$63$lambda$50$lambda$49(Function1 function1, long j) {
                function1.invoke(new VideoArtifactPreviewAction.SeekTo(j));
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit VideoArtifactPreviewContent$lambda$63$lambda$52$lambda$51(Function1 function1) {
                function1.invoke(VideoArtifactPreviewAction.OpenSpeedMenu.INSTANCE);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit VideoArtifactPreviewContent$lambda$63$lambda$54$lambda$53(MutableState mutableState, Offset offset) {
                VideoArtifactPreviewContent$lambda$42(mutableState, offset.unbox-impl());
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: VideoArtifactPreviewContent$lambda$63$lambda$60$lambda$59$lambda$58 */
            public static final Unit m370x3e254020(Map map, final float f, final Function1 function1) {
                ((KmpClickHandler) MapsKt.getValue(map, Float.valueOf(f))).tryHandle(new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit m371xd3a0511b;
                        m371xd3a0511b = VideoArtifactPreviewKt.m371xd3a0511b(function1, f);
                        return m371xd3a0511b;
                    }
                });
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: VideoArtifactPreviewContent$lambda$63$lambda$60$lambda$59$lambda$58$lambda$57 */
            public static final Unit m371xd3a0511b(Function1 function1, float f) {
                function1.invoke(new VideoArtifactPreviewAction.SelectSpeed(f));
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit VideoArtifactPreviewContent$lambda$63$lambda$62$lambda$61(Function1 function1) {
                function1.invoke(VideoArtifactPreviewAction.DismissSpeedMenu.INSTANCE);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:93:0x03f6, code lost:
            
                if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L167;
             */
            /* JADX WARN: Removed duplicated region for block: B:102:0x047f  */
            /* JADX WARN: Removed duplicated region for block: B:106:0x04b0  */
            /* JADX WARN: Removed duplicated region for block: B:109:0x0562  */
            /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
            /* JADX WARN: Removed duplicated region for block: B:112:0x056e  */
            /* JADX WARN: Removed duplicated region for block: B:115:0x0597  */
            /* JADX WARN: Removed duplicated region for block: B:119:0x061e  */
            /* JADX WARN: Removed duplicated region for block: B:122:0x062a  */
            /* JADX WARN: Removed duplicated region for block: B:125:0x0653  */
            /* JADX WARN: Removed duplicated region for block: B:129:0x071b  */
            /* JADX WARN: Removed duplicated region for block: B:132:0x0725  */
            /* JADX WARN: Removed duplicated region for block: B:137:0x0758  */
            /* JADX WARN: Removed duplicated region for block: B:140:0x0780  */
            /* JADX WARN: Removed duplicated region for block: B:143:0x078a  */
            /* JADX WARN: Removed duplicated region for block: B:148:0x07ea  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
            /* JADX WARN: Removed duplicated region for block: B:151:0x07f6  */
            /* JADX WARN: Removed duplicated region for block: B:154:0x081f  */
            /* JADX WARN: Removed duplicated region for block: B:158:0x0913  */
            /* JADX WARN: Removed duplicated region for block: B:161:0x07fa  */
            /* JADX WARN: Removed duplicated region for block: B:163:0x0782  */
            /* JADX WARN: Removed duplicated region for block: B:165:0x071d  */
            /* JADX WARN: Removed duplicated region for block: B:167:0x062e  */
            /* JADX WARN: Removed duplicated region for block: B:169:0x0572  */
            /* JADX WARN: Removed duplicated region for block: B:170:0x04b7  */
            /* JADX WARN: Removed duplicated region for block: B:172:0x045a  */
            /* JADX WARN: Removed duplicated region for block: B:174:0x03e8  */
            /* JADX WARN: Removed duplicated region for block: B:176:0x034a  */
            /* JADX WARN: Removed duplicated region for block: B:178:0x0292  */
            /* JADX WARN: Removed duplicated region for block: B:179:0x01d7  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
            /* JADX WARN: Removed duplicated region for block: B:180:0x01c7  */
            /* JADX WARN: Removed duplicated region for block: B:181:0x013e  */
            /* JADX WARN: Removed duplicated region for block: B:182:0x010e  */
            /* JADX WARN: Removed duplicated region for block: B:189:0x00f2  */
            /* JADX WARN: Removed duplicated region for block: B:195:0x00d9  */
            /* JADX WARN: Removed duplicated region for block: B:201:0x00ba  */
            /* JADX WARN: Removed duplicated region for block: B:208:0x009c  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
            /* JADX WARN: Removed duplicated region for block: B:215:0x0084  */
            /* JADX WARN: Removed duplicated region for block: B:222:0x006d  */
            /* JADX WARN: Removed duplicated region for block: B:229:0x0051  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x00b6  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00ee  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x0109  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0129  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x091e  */
            /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:49:0x0139  */
            /* JADX WARN: Removed duplicated region for block: B:52:0x0146  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0181  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x01a1  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x01c5  */
            /* JADX WARN: Removed duplicated region for block: B:63:0x01ca  */
            /* JADX WARN: Removed duplicated region for block: B:66:0x0282  */
            /* JADX WARN: Removed duplicated region for block: B:69:0x028e  */
            /* JADX WARN: Removed duplicated region for block: B:72:0x02b7  */
            /* JADX WARN: Removed duplicated region for block: B:76:0x033a  */
            /* JADX WARN: Removed duplicated region for block: B:79:0x0346  */
            /* JADX WARN: Removed duplicated region for block: B:82:0x036f  */
            /* JADX WARN: Removed duplicated region for block: B:86:0x03be  */
            /* JADX WARN: Removed duplicated region for block: B:89:0x03e6  */
            /* JADX WARN: Removed duplicated region for block: B:92:0x03f0  */
            /* JADX WARN: Removed duplicated region for block: B:96:0x044a  */
            /* JADX WARN: Removed duplicated region for block: B:99:0x0456  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private static final void VideoPlaybackControls(final boolean z, final long j, final long j2, final float f, final Function0<Unit> function0, final Function1<? super Long, Unit> function1, final Function1<? super Long, Unit> function12, final Function0<Unit> function02, final Function1<? super Offset, Unit> function13, Modifier modifier, Composer composer, final int i, final int i2) {
                int i3;
                int i4;
                Object rememberedValue;
                Object rememberedValue2;
                String formatSpeed;
                int hashCode;
                Composer composer2;
                int hashCode2;
                Composer composer3;
                Object rememberedValue3;
                boolean changedInstance;
                Object obj;
                int hashCode3;
                Composer composer4;
                DrawableResource trae_video_preview_play;
                int hashCode4;
                Composer composer5;
                int hashCode5;
                Composer composer6;
                boolean changed;
                Object rememberedValue4;
                String str;
                Object rememberedValue5;
                boolean changedInstance2;
                Object obj2;
                int hashCode6;
                Composer composer7;
                final Modifier modifier2;
                ScopeUpdateScope endRestartGroup;
                int i5;
                int i6;
                Composer startRestartGroup = composer.startRestartGroup(-295831889);
                if ((i2 & 1) != 0) {
                    i3 = i | 6;
                } else if ((i & 6) == 0) {
                    i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
                } else {
                    i3 = i;
                }
                if ((i2 & 2) != 0) {
                    i3 |= 48;
                } else if ((i & 48) == 0) {
                    i3 |= startRestartGroup.changed(j) ? 32 : 16;
                    if ((i2 & 4) == 0) {
                        i3 |= 384;
                    } else if ((i & 384) == 0) {
                        i3 |= startRestartGroup.changed(j2) ? 256 : 128;
                        if ((i2 & 8) != 0) {
                            i3 |= 3072;
                        } else if ((i & 3072) == 0) {
                            i3 |= startRestartGroup.changed(f) ? 2048 : 1024;
                        }
                        if ((i2 & 16) != 0) {
                            i3 |= 24576;
                        } else if ((i & 24576) == 0) {
                            i3 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
                        }
                        if ((i2 & 32) != 0) {
                            i3 |= 196608;
                        } else if ((196608 & i) == 0) {
                            i3 |= startRestartGroup.changedInstance(function1) ? 131072 : ArtifactRepository.IO_CHUNK_SIZE;
                            if ((i2 & 64) == 0) {
                                i3 |= 1572864;
                            } else if ((1572864 & i) == 0) {
                                i3 |= startRestartGroup.changedInstance(function12) ? PreloadV2Kt.M_MEM_SIZE : 524288;
                                if ((i2 & 128) == 0) {
                                    i6 = (12582912 & i) == 0 ? startRestartGroup.changedInstance(function02) ? 8388608 : 4194304 : 12582912;
                                    if ((i2 & 256) != 0) {
                                        i5 = (100663296 & i) == 0 ? startRestartGroup.changedInstance(function13) ? 67108864 : 33554432 : 100663296;
                                        i4 = i2 & 512;
                                        if (i4 != 0) {
                                            i3 |= 805306368;
                                        } else if ((i & 805306368) == 0) {
                                            i3 |= startRestartGroup.changed(modifier) ? 536870912 : 268435456;
                                        }
                                        if ((306783379 & i3) == 306783378 || !startRestartGroup.getSkipping()) {
                                            Modifier modifier3 = i4 != 0 ? (Modifier) Modifier.Companion : modifier;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-295831889, i3, -1, "com.bytedance.trae.kmp.artifacts.video.VideoPlaybackControls (VideoArtifactPreview.kt:563)");
                                            }
                                            final TraeDimens dimens = TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable);
                                            CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume = startRestartGroup.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            final Density density = (Density) consume;
                                            startRestartGroup.startReplaceGroup(1449294190);
                                            rememberedValue = startRestartGroup.rememberedValue();
                                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                                rememberedValue = new KmpClickHandler(null, 1, null);
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            final KmpClickHandler kmpClickHandler = (KmpClickHandler) rememberedValue;
                                            startRestartGroup.endReplaceGroup();
                                            startRestartGroup.startReplaceGroup(1449296078);
                                            rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                                rememberedValue2 = new KmpClickHandler(null, 1, null);
                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                            }
                                            final KmpClickHandler kmpClickHandler2 = (KmpClickHandler) rememberedValue2;
                                            startRestartGroup.endReplaceGroup();
                                            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(dimens.getVideoPreviewControlRadius-D9Ej5fM());
                                            startRestartGroup.startReplaceGroup(1449300264);
                                            if (f == 1.0f) {
                                                formatSpeed = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_video_artifact_preview_speed(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
                                            } else {
                                                formatSpeed = formatSpeed(f);
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            Shape shape2 = shape;
                                            Modifier modifier4 = modifier3;
                                            Modifier modifier5 = PaddingKt.padding-qDBjuR0(BackgroundKt.background-bw27NRU$default(ClipKt.clip(ShadowKt.shadow-s4CzXII$default(SizeKt.height-3ABfNKs(modifier3, dimens.getVideoPreviewControlHeight-D9Ej5fM()), dimens.getTitleBarElevation-D9Ej5fM(), shape2, false, 0L, 0L, 24, (Object) null), shape2), Color.copy-wmQWz5c$default(TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getSpecialWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), dimens.getVideoPreviewControlPaddingStart-D9Ej5fM(), dimens.getVideoPreviewControlPaddingVertical-D9Ej5fM(), dimens.getVideoPreviewControlPaddingEnd-D9Ej5fM(), dimens.getVideoPreviewControlPaddingVertical-D9Ej5fM());
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                            String str2 = formatSpeed;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                            hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier5);
                                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            startRestartGroup.startReusableNode();
                                            if (startRestartGroup.getInserting()) {
                                                startRestartGroup.createNode(constructor);
                                            } else {
                                                startRestartGroup.useNode();
                                            }
                                            composer2 = Updater.constructor-impl(startRestartGroup);
                                            Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (!composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                                                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                                                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                                            }
                                            Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                                            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                            hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
                                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            startRestartGroup.startReusableNode();
                                            if (startRestartGroup.getInserting()) {
                                                startRestartGroup.createNode(constructor2);
                                            } else {
                                                startRestartGroup.useNode();
                                            }
                                            composer3 = Updater.constructor-impl(startRestartGroup);
                                            Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (!composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode2))) {
                                                composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                                                composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
                                            }
                                            Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                            RowScope rowScope = RowScopeInstance.INSTANCE;
                                            Modifier modifier6 = SizeKt.size-3ABfNKs(Modifier.Companion, dimens.getVideoPreviewPlayTouchSize-D9Ej5fM());
                                            startRestartGroup.startReplaceGroup(2074446709);
                                            rememberedValue3 = startRestartGroup.rememberedValue();
                                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                                rememberedValue3 = InteractionSourceKt.MutableInteractionSource();
                                                startRestartGroup.updateRememberedValue(rememberedValue3);
                                            }
                                            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue3;
                                            startRestartGroup.endReplaceGroup();
                                            startRestartGroup.startReplaceGroup(2074450149);
                                            changedInstance = startRestartGroup.changedInstance(kmpClickHandler) | ((57344 & i3) == 16384);
                                            Object rememberedValue6 = startRestartGroup.rememberedValue();
                                            if (!changedInstance) {
                                                obj = rememberedValue6;
                                            }
                                            Function0 function03 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda7
                                                public final Object invoke() {
                                                    Unit VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68;
                                                    VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68 = VideoArtifactPreviewKt.VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68(KmpClickHandler.this, function0);
                                                    return VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(function03);
                                            obj = function03;
                                            startRestartGroup.endReplaceGroup();
                                            Modifier modifier7 = ClickableKt.clickable-O2vRcR0$default(modifier6, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) obj, 28, (Object) null);
                                            Alignment center = Alignment.Companion.getCenter();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                            hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier7);
                                            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            startRestartGroup.startReusableNode();
                                            if (startRestartGroup.getInserting()) {
                                                startRestartGroup.createNode(constructor3);
                                            } else {
                                                startRestartGroup.useNode();
                                            }
                                            composer4 = Updater.constructor-impl(startRestartGroup);
                                            Updater.set-impl(composer4, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (!composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode3))) {
                                                composer4.updateRememberedValue(Integer.valueOf(hashCode3));
                                                composer4.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
                                            }
                                            Updater.set-impl(composer4, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                                            if (z) {
                                                trae_video_preview_play = Drawable0_commonMainKt.getTrae_video_preview_pause(Res.drawable.INSTANCE);
                                            } else {
                                                trae_video_preview_play = Drawable0_commonMainKt.getTrae_video_preview_play(Res.drawable.INSTANCE);
                                            }
                                            ImageKt.Image(ImageResources_androidKt.painterResource(trae_video_preview_play, startRestartGroup, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, dimens.getVideoPreviewPlayIconSize-D9Ej5fM()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 48, 120);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            startRestartGroup.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, dimens.getVideoPreviewControlGap-D9Ej5fM()), startRestartGroup, 0);
                                            Modifier modifier8 = SizeKt.height-3ABfNKs(RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null), dimens.getVideoPreviewControlContentHeight-D9Ej5fM());
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                            hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier8);
                                            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            startRestartGroup.startReusableNode();
                                            if (startRestartGroup.getInserting()) {
                                                startRestartGroup.createNode(constructor4);
                                            } else {
                                                startRestartGroup.useNode();
                                            }
                                            composer5 = Updater.constructor-impl(startRestartGroup);
                                            Updater.set-impl(composer5, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.set-impl(composer5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (!composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(hashCode4))) {
                                                composer5.updateRememberedValue(Integer.valueOf(hashCode4));
                                                composer5.apply(Integer.valueOf(hashCode4), setCompositeKeyHash4);
                                            }
                                            Updater.set-impl(composer5, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                                            Modifier modifier9 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), dimens.getVideoPreviewControlTextRowHeight-D9Ej5fM());
                                            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, startRestartGroup, 48);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                            hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                            CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier9);
                                            Function0 constructor5 = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            startRestartGroup.startReusableNode();
                                            if (startRestartGroup.getInserting()) {
                                                startRestartGroup.createNode(constructor5);
                                            } else {
                                                startRestartGroup.useNode();
                                            }
                                            composer6 = Updater.constructor-impl(startRestartGroup);
                                            Updater.set-impl(composer6, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.set-impl(composer6, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (!composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(hashCode5))) {
                                                composer6.updateRememberedValue(Integer.valueOf(hashCode5));
                                                composer6.apply(Integer.valueOf(hashCode5), setCompositeKeyHash5);
                                            }
                                            Updater.set-impl(composer6, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                            RowScope rowScope2 = RowScopeInstance.INSTANCE;
                                            TextKt.Text--4IGK_g(formatTime(j) + " / " + formatTime(j2), (Modifier) null, TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getTextTextWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXs(), startRestartGroup, 0, 0, 65530);
                                            SpacerKt.Spacer(RowScope.weight$default(rowScope2, Modifier.Companion, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
                                            Modifier wrapContentWidth$default = SizeKt.wrapContentWidth$default(Modifier.Companion, (Alignment.Horizontal) null, false, 3, (Object) null);
                                            startRestartGroup.startReplaceGroup(460831822);
                                            changed = startRestartGroup.changed(density) | startRestartGroup.changed(dimens) | ((234881024 & i3) == 67108864);
                                            rememberedValue4 = startRestartGroup.rememberedValue();
                                            if (!changed || rememberedValue4 == Composer.Companion.getEmpty()) {
                                                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                                                rememberedValue4 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda8
                                                    public final Object invoke(Object obj3) {
                                                        Unit m375xb89c363;
                                                        m375xb89c363 = VideoArtifactPreviewKt.m375xb89c363(density, function13, dimens, (LayoutCoordinates) obj3);
                                                        return m375xb89c363;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue4);
                                            } else {
                                                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(wrapContentWidth$default, (Function1) rememberedValue4);
                                            startRestartGroup.startReplaceGroup(460877555);
                                            rememberedValue5 = startRestartGroup.rememberedValue();
                                            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                                                rememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                                                startRestartGroup.updateRememberedValue(rememberedValue5);
                                            }
                                            MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) rememberedValue5;
                                            startRestartGroup.endReplaceGroup();
                                            startRestartGroup.startReplaceGroup(460881525);
                                            changedInstance2 = startRestartGroup.changedInstance(kmpClickHandler2) | ((29360128 & i3) == 8388608);
                                            Object rememberedValue7 = startRestartGroup.rememberedValue();
                                            if (!changedInstance2 || rememberedValue7 == Composer.Companion.getEmpty()) {
                                                Function0 function04 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda9
                                                    public final Object invoke() {
                                                        Unit m376xca37dba9;
                                                        m376xca37dba9 = VideoArtifactPreviewKt.m376xca37dba9(KmpClickHandler.this, function02);
                                                        return m376xca37dba9;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(function04);
                                                obj2 = function04;
                                            } else {
                                                obj2 = rememberedValue7;
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            Modifier modifier10 = ClickableKt.clickable-O2vRcR0$default(onGloballyPositioned, mutableInteractionSource2, (Indication) null, false, (String) null, (Role) null, (Function0) obj2, 28, (Object) null);
                                            Alignment center2 = Alignment.Companion.getCenter();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                            hashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                            CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier10);
                                            Function0 constructor6 = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, str);
                                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            startRestartGroup.startReusableNode();
                                            if (startRestartGroup.getInserting()) {
                                                startRestartGroup.createNode(constructor6);
                                            } else {
                                                startRestartGroup.useNode();
                                            }
                                            composer7 = Updater.constructor-impl(startRestartGroup);
                                            Updater.set-impl(composer7, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.set-impl(composer7, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (!composer7.getInserting() || !Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(hashCode6))) {
                                                composer7.updateRememberedValue(Integer.valueOf(hashCode6));
                                                composer7.apply(Integer.valueOf(hashCode6), setCompositeKeyHash6);
                                            }
                                            Updater.set-impl(composer7, materializeModifier6, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                                            TextKt.Text--4IGK_g(str2, (Modifier) null, TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getTextTextWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXsStrong(), startRestartGroup, 0, 0, 65530);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            startRestartGroup.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            startRestartGroup.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            int i7 = i3 >> 3;
                                            int i8 = i3 >> 9;
                                            VideoProgressBar(j, j2, function1, function12, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), dimens.getVideoPreviewProgressHeight-D9Ej5fM()), startRestartGroup, (i7 & 112) | (i7 & 14) | (i8 & 896) | (i8 & 7168), 0);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            startRestartGroup.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            startRestartGroup.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            startRestartGroup.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            modifier2 = modifier4;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            modifier2 = modifier;
                                        }
                                        endRestartGroup = startRestartGroup.endRestartGroup();
                                        if (endRestartGroup != null) {
                                            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda10
                                                public final Object invoke(Object obj3, Object obj4) {
                                                    Unit VideoPlaybackControls$lambda$84;
                                                    VideoPlaybackControls$lambda$84 = VideoArtifactPreviewKt.VideoPlaybackControls$lambda$84(z, j, j2, f, function0, function1, function12, function02, function13, modifier2, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                                                    return VideoPlaybackControls$lambda$84;
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    i3 |= i5;
                                    i4 = i2 & 512;
                                    if (i4 != 0) {
                                    }
                                    if ((306783379 & i3) == 306783378) {
                                    }
                                    if (i4 != 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    final TraeDimens dimens2 = TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable);
                                    CompositionLocal localDensity2 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume2 = startRestartGroup.consume(localDensity2);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    final Density density2 = (Density) consume2;
                                    startRestartGroup.startReplaceGroup(1449294190);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                    }
                                    final KmpClickHandler kmpClickHandler3 = (KmpClickHandler) rememberedValue;
                                    startRestartGroup.endReplaceGroup();
                                    startRestartGroup.startReplaceGroup(1449296078);
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    }
                                    final KmpClickHandler kmpClickHandler22 = (KmpClickHandler) rememberedValue2;
                                    startRestartGroup.endReplaceGroup();
                                    Shape shape3 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(dimens2.getVideoPreviewControlRadius-D9Ej5fM());
                                    startRestartGroup.startReplaceGroup(1449300264);
                                    if (f == 1.0f) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    Shape shape22 = shape3;
                                    Modifier modifier42 = modifier3;
                                    Modifier modifier52 = PaddingKt.padding-qDBjuR0(BackgroundKt.background-bw27NRU$default(ClipKt.clip(ShadowKt.shadow-s4CzXII$default(SizeKt.height-3ABfNKs(modifier3, dimens2.getVideoPreviewControlHeight-D9Ej5fM()), dimens2.getTitleBarElevation-D9Ej5fM(), shape22, false, 0L, 0L, 24, (Object) null), shape22), Color.copy-wmQWz5c$default(TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getSpecialWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), dimens2.getVideoPreviewControlPaddingStart-D9Ej5fM(), dimens2.getVideoPreviewControlPaddingVertical-D9Ej5fM(), dimens2.getVideoPreviewControlPaddingEnd-D9Ej5fM(), dimens2.getVideoPreviewControlPaddingVertical-D9Ej5fM());
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                    MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                    String str22 = formatSpeed;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                    hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                    CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier52);
                                    Function0 constructor7 = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    }
                                    startRestartGroup.startReusableNode();
                                    if (startRestartGroup.getInserting()) {
                                    }
                                    composer2 = Updater.constructor-impl(startRestartGroup);
                                    Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.set-impl(composer2, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash7 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (!composer2.getInserting()) {
                                    }
                                    composer2.updateRememberedValue(Integer.valueOf(hashCode));
                                    composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash7);
                                    Updater.set-impl(composer2, materializeModifier7, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                    BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                                    Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                                    Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, startRestartGroup, 48);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                    hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                    CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default2);
                                    Function0 constructor22 = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    }
                                    startRestartGroup.startReusableNode();
                                    if (startRestartGroup.getInserting()) {
                                    }
                                    composer3 = Updater.constructor-impl(startRestartGroup);
                                    Updater.set-impl(composer3, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.set-impl(composer3, currentCompositionLocalMap22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (!composer3.getInserting()) {
                                    }
                                    composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                                    composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash22);
                                    Updater.set-impl(composer3, materializeModifier22, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                    RowScope rowScope3 = RowScopeInstance.INSTANCE;
                                    Modifier modifier62 = SizeKt.size-3ABfNKs(Modifier.Companion, dimens2.getVideoPreviewPlayTouchSize-D9Ej5fM());
                                    startRestartGroup.startReplaceGroup(2074446709);
                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                    }
                                    MutableInteractionSource mutableInteractionSource3 = (MutableInteractionSource) rememberedValue3;
                                    startRestartGroup.endReplaceGroup();
                                    startRestartGroup.startReplaceGroup(2074450149);
                                    changedInstance = startRestartGroup.changedInstance(kmpClickHandler3) | ((57344 & i3) == 16384);
                                    Object rememberedValue62 = startRestartGroup.rememberedValue();
                                    if (!changedInstance) {
                                    }
                                    Function0 function032 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda7
                                        public final Object invoke() {
                                            Unit VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68;
                                            VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68 = VideoArtifactPreviewKt.VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68(KmpClickHandler.this, function0);
                                            return VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(function032);
                                    obj = function032;
                                    startRestartGroup.endReplaceGroup();
                                    Modifier modifier72 = ClickableKt.clickable-O2vRcR0$default(modifier62, mutableInteractionSource3, (Indication) null, false, (String) null, (Role) null, (Function0) obj, 28, (Object) null);
                                    Alignment center3 = Alignment.Companion.getCenter();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                    MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                    hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                    CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier72);
                                    Function0 constructor32 = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    }
                                    startRestartGroup.startReusableNode();
                                    if (startRestartGroup.getInserting()) {
                                    }
                                    composer4 = Updater.constructor-impl(startRestartGroup);
                                    Updater.set-impl(composer4, maybeCachedBoxMeasurePolicy22, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.set-impl(composer4, currentCompositionLocalMap32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash32 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (!composer4.getInserting()) {
                                    }
                                    composer4.updateRememberedValue(Integer.valueOf(hashCode3));
                                    composer4.apply(Integer.valueOf(hashCode3), setCompositeKeyHash32);
                                    Updater.set-impl(composer4, materializeModifier32, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                    BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
                                    if (z) {
                                    }
                                    ImageKt.Image(ImageResources_androidKt.painterResource(trae_video_preview_play, startRestartGroup, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, dimens2.getVideoPreviewPlayIconSize-D9Ej5fM()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 48, 120);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    startRestartGroup.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, dimens2.getVideoPreviewControlGap-D9Ej5fM()), startRestartGroup, 0);
                                    Modifier modifier82 = SizeKt.height-3ABfNKs(RowScope.weight$default(rowScope3, Modifier.Companion, 1.0f, false, 2, (Object) null), dimens2.getVideoPreviewControlContentHeight-D9Ej5fM());
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                    hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                    CompositionLocalMap currentCompositionLocalMap42 = startRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier42 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier82);
                                    Function0 constructor42 = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    }
                                    startRestartGroup.startReusableNode();
                                    if (startRestartGroup.getInserting()) {
                                    }
                                    composer5 = Updater.constructor-impl(startRestartGroup);
                                    Updater.set-impl(composer5, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.set-impl(composer5, currentCompositionLocalMap42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash42 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (!composer5.getInserting()) {
                                    }
                                    composer5.updateRememberedValue(Integer.valueOf(hashCode4));
                                    composer5.apply(Integer.valueOf(hashCode4), setCompositeKeyHash42);
                                    Updater.set-impl(composer5, materializeModifier42, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                    ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                                    Modifier modifier92 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), dimens2.getVideoPreviewControlTextRowHeight-D9Ej5fM());
                                    Alignment.Vertical centerVertically22 = Alignment.Companion.getCenterVertically();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically22, startRestartGroup, 48);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                    hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                    CompositionLocalMap currentCompositionLocalMap52 = startRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier52 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier92);
                                    Function0 constructor52 = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    }
                                    startRestartGroup.startReusableNode();
                                    if (startRestartGroup.getInserting()) {
                                    }
                                    composer6 = Updater.constructor-impl(startRestartGroup);
                                    Updater.set-impl(composer6, rowMeasurePolicy22, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.set-impl(composer6, currentCompositionLocalMap52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash52 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (!composer6.getInserting()) {
                                    }
                                    composer6.updateRememberedValue(Integer.valueOf(hashCode5));
                                    composer6.apply(Integer.valueOf(hashCode5), setCompositeKeyHash52);
                                    Updater.set-impl(composer6, materializeModifier52, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                    RowScope rowScope22 = RowScopeInstance.INSTANCE;
                                    TextKt.Text--4IGK_g(formatTime(j) + " / " + formatTime(j2), (Modifier) null, TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getTextTextWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXs(), startRestartGroup, 0, 0, 65530);
                                    SpacerKt.Spacer(RowScope.weight$default(rowScope22, Modifier.Companion, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
                                    Modifier wrapContentWidth$default2 = SizeKt.wrapContentWidth$default(Modifier.Companion, (Alignment.Horizontal) null, false, 3, (Object) null);
                                    startRestartGroup.startReplaceGroup(460831822);
                                    changed = startRestartGroup.changed(density2) | startRestartGroup.changed(dimens2) | ((234881024 & i3) == 67108864);
                                    rememberedValue4 = startRestartGroup.rememberedValue();
                                    if (changed) {
                                    }
                                    str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                                    rememberedValue4 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda8
                                        public final Object invoke(Object obj3) {
                                            Unit m375xb89c363;
                                            m375xb89c363 = VideoArtifactPreviewKt.m375xb89c363(density2, function13, dimens2, (LayoutCoordinates) obj3);
                                            return m375xb89c363;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                    startRestartGroup.endReplaceGroup();
                                    Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(wrapContentWidth$default2, (Function1) rememberedValue4);
                                    startRestartGroup.startReplaceGroup(460877555);
                                    rememberedValue5 = startRestartGroup.rememberedValue();
                                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                                    }
                                    MutableInteractionSource mutableInteractionSource22 = (MutableInteractionSource) rememberedValue5;
                                    startRestartGroup.endReplaceGroup();
                                    startRestartGroup.startReplaceGroup(460881525);
                                    changedInstance2 = startRestartGroup.changedInstance(kmpClickHandler22) | ((29360128 & i3) == 8388608);
                                    Object rememberedValue72 = startRestartGroup.rememberedValue();
                                    if (changedInstance2) {
                                    }
                                    Function0 function042 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda9
                                        public final Object invoke() {
                                            Unit m376xca37dba9;
                                            m376xca37dba9 = VideoArtifactPreviewKt.m376xca37dba9(KmpClickHandler.this, function02);
                                            return m376xca37dba9;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(function042);
                                    obj2 = function042;
                                    startRestartGroup.endReplaceGroup();
                                    Modifier modifier102 = ClickableKt.clickable-O2vRcR0$default(onGloballyPositioned2, mutableInteractionSource22, (Indication) null, false, (String) null, (Role) null, (Function0) obj2, 28, (Object) null);
                                    Alignment center22 = Alignment.Companion.getCenter();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                    MeasurePolicy maybeCachedBoxMeasurePolicy32 = BoxKt.maybeCachedBoxMeasurePolicy(center22, false);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                    hashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                    CompositionLocalMap currentCompositionLocalMap62 = startRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier62 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier102);
                                    Function0 constructor62 = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, str);
                                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    }
                                    startRestartGroup.startReusableNode();
                                    if (startRestartGroup.getInserting()) {
                                    }
                                    composer7 = Updater.constructor-impl(startRestartGroup);
                                    Updater.set-impl(composer7, maybeCachedBoxMeasurePolicy32, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.set-impl(composer7, currentCompositionLocalMap62, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash62 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (!composer7.getInserting()) {
                                    }
                                    composer7.updateRememberedValue(Integer.valueOf(hashCode6));
                                    composer7.apply(Integer.valueOf(hashCode6), setCompositeKeyHash62);
                                    Updater.set-impl(composer7, materializeModifier62, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                    BoxScope boxScope32 = BoxScopeInstance.INSTANCE;
                                    TextKt.Text--4IGK_g(str22, (Modifier) null, TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getTextTextWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXsStrong(), startRestartGroup, 0, 0, 65530);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    startRestartGroup.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    startRestartGroup.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    int i72 = i3 >> 3;
                                    int i82 = i3 >> 9;
                                    VideoProgressBar(j, j2, function1, function12, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), dimens2.getVideoPreviewProgressHeight-D9Ej5fM()), startRestartGroup, (i72 & 112) | (i72 & 14) | (i82 & 896) | (i82 & 7168), 0);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    startRestartGroup.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    startRestartGroup.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    startRestartGroup.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    modifier2 = modifier42;
                                    endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup != null) {
                                    }
                                }
                                i3 |= i6;
                                if ((i2 & 256) != 0) {
                                }
                                i3 |= i5;
                                i4 = i2 & 512;
                                if (i4 != 0) {
                                }
                                if ((306783379 & i3) == 306783378) {
                                }
                                if (i4 != 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                final TraeDimens dimens22 = TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable);
                                CompositionLocal localDensity22 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object consume22 = startRestartGroup.consume(localDensity22);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final Density density22 = (Density) consume22;
                                startRestartGroup.startReplaceGroup(1449294190);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                }
                                final KmpClickHandler kmpClickHandler32 = (KmpClickHandler) rememberedValue;
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.startReplaceGroup(1449296078);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                }
                                final KmpClickHandler kmpClickHandler222 = (KmpClickHandler) rememberedValue2;
                                startRestartGroup.endReplaceGroup();
                                Shape shape32 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(dimens22.getVideoPreviewControlRadius-D9Ej5fM());
                                startRestartGroup.startReplaceGroup(1449300264);
                                if (f == 1.0f) {
                                }
                                startRestartGroup.endReplaceGroup();
                                Shape shape222 = shape32;
                                Modifier modifier422 = modifier3;
                                Modifier modifier522 = PaddingKt.padding-qDBjuR0(BackgroundKt.background-bw27NRU$default(ClipKt.clip(ShadowKt.shadow-s4CzXII$default(SizeKt.height-3ABfNKs(modifier3, dimens22.getVideoPreviewControlHeight-D9Ej5fM()), dimens22.getTitleBarElevation-D9Ej5fM(), shape222, false, 0L, 0L, 24, (Object) null), shape222), Color.copy-wmQWz5c$default(TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getSpecialWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), dimens22.getVideoPreviewControlPaddingStart-D9Ej5fM(), dimens22.getVideoPreviewControlPaddingVertical-D9Ej5fM(), dimens22.getVideoPreviewControlPaddingEnd-D9Ej5fM(), dimens22.getVideoPreviewControlPaddingVertical-D9Ej5fM());
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy42 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                String str222 = formatSpeed;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                CompositionLocalMap currentCompositionLocalMap72 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier72 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier522);
                                Function0 constructor72 = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                }
                                composer2 = Updater.constructor-impl(startRestartGroup);
                                Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy42, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl(composer2, currentCompositionLocalMap72, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash72 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (!composer2.getInserting()) {
                                }
                                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash72);
                                Updater.set-impl(composer2, materializeModifier72, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                BoxScope boxScope42 = BoxScopeInstance.INSTANCE;
                                Modifier fillMaxSize$default22 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                                Alignment.Vertical centerVertically32 = Alignment.Companion.getCenterVertically();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy32 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically32, startRestartGroup, 48);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default22);
                                Function0 constructor222 = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                }
                                composer3 = Updater.constructor-impl(startRestartGroup);
                                Updater.set-impl(composer3, rowMeasurePolicy32, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl(composer3, currentCompositionLocalMap222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (!composer3.getInserting()) {
                                }
                                composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                                composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash222);
                                Updater.set-impl(composer3, materializeModifier222, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                RowScope rowScope32 = RowScopeInstance.INSTANCE;
                                Modifier modifier622 = SizeKt.size-3ABfNKs(Modifier.Companion, dimens22.getVideoPreviewPlayTouchSize-D9Ej5fM());
                                startRestartGroup.startReplaceGroup(2074446709);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                }
                                MutableInteractionSource mutableInteractionSource32 = (MutableInteractionSource) rememberedValue3;
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.startReplaceGroup(2074450149);
                                changedInstance = startRestartGroup.changedInstance(kmpClickHandler32) | ((57344 & i3) == 16384);
                                Object rememberedValue622 = startRestartGroup.rememberedValue();
                                if (!changedInstance) {
                                }
                                Function0 function0322 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda7
                                    public final Object invoke() {
                                        Unit VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68;
                                        VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68 = VideoArtifactPreviewKt.VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68(KmpClickHandler.this, function0);
                                        return VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(function0322);
                                obj = function0322;
                                startRestartGroup.endReplaceGroup();
                                Modifier modifier722 = ClickableKt.clickable-O2vRcR0$default(modifier622, mutableInteractionSource32, (Indication) null, false, (String) null, (Role) null, (Function0) obj, 28, (Object) null);
                                Alignment center32 = Alignment.Companion.getCenter();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(center32, false);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                CompositionLocalMap currentCompositionLocalMap322 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier322 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier722);
                                Function0 constructor322 = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                }
                                composer4 = Updater.constructor-impl(startRestartGroup);
                                Updater.set-impl(composer4, maybeCachedBoxMeasurePolicy222, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl(composer4, currentCompositionLocalMap322, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash322 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (!composer4.getInserting()) {
                                }
                                composer4.updateRememberedValue(Integer.valueOf(hashCode3));
                                composer4.apply(Integer.valueOf(hashCode3), setCompositeKeyHash322);
                                Updater.set-impl(composer4, materializeModifier322, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                BoxScope boxScope222 = BoxScopeInstance.INSTANCE;
                                if (z) {
                                }
                                ImageKt.Image(ImageResources_androidKt.painterResource(trae_video_preview_play, startRestartGroup, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, dimens22.getVideoPreviewPlayIconSize-D9Ej5fM()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 48, 120);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, dimens22.getVideoPreviewControlGap-D9Ej5fM()), startRestartGroup, 0);
                                Modifier modifier822 = SizeKt.height-3ABfNKs(RowScope.weight$default(rowScope32, Modifier.Companion, 1.0f, false, 2, (Object) null), dimens22.getVideoPreviewControlContentHeight-D9Ej5fM());
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                CompositionLocalMap currentCompositionLocalMap422 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier422 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier822);
                                Function0 constructor422 = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                }
                                composer5 = Updater.constructor-impl(startRestartGroup);
                                Updater.set-impl(composer5, columnMeasurePolicy22, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl(composer5, currentCompositionLocalMap422, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash422 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (!composer5.getInserting()) {
                                }
                                composer5.updateRememberedValue(Integer.valueOf(hashCode4));
                                composer5.apply(Integer.valueOf(hashCode4), setCompositeKeyHash422);
                                Updater.set-impl(composer5, materializeModifier422, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                ColumnScope columnScope22 = ColumnScopeInstance.INSTANCE;
                                Modifier modifier922 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), dimens22.getVideoPreviewControlTextRowHeight-D9Ej5fM());
                                Alignment.Vertical centerVertically222 = Alignment.Companion.getCenterVertically();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy222 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically222, startRestartGroup, 48);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                CompositionLocalMap currentCompositionLocalMap522 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier522 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier922);
                                Function0 constructor522 = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                }
                                composer6 = Updater.constructor-impl(startRestartGroup);
                                Updater.set-impl(composer6, rowMeasurePolicy222, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl(composer6, currentCompositionLocalMap522, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash522 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (!composer6.getInserting()) {
                                }
                                composer6.updateRememberedValue(Integer.valueOf(hashCode5));
                                composer6.apply(Integer.valueOf(hashCode5), setCompositeKeyHash522);
                                Updater.set-impl(composer6, materializeModifier522, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                RowScope rowScope222 = RowScopeInstance.INSTANCE;
                                TextKt.Text--4IGK_g(formatTime(j) + " / " + formatTime(j2), (Modifier) null, TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getTextTextWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXs(), startRestartGroup, 0, 0, 65530);
                                SpacerKt.Spacer(RowScope.weight$default(rowScope222, Modifier.Companion, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
                                Modifier wrapContentWidth$default22 = SizeKt.wrapContentWidth$default(Modifier.Companion, (Alignment.Horizontal) null, false, 3, (Object) null);
                                startRestartGroup.startReplaceGroup(460831822);
                                changed = startRestartGroup.changed(density22) | startRestartGroup.changed(dimens22) | ((234881024 & i3) == 67108864);
                                rememberedValue4 = startRestartGroup.rememberedValue();
                                if (changed) {
                                }
                                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                                rememberedValue4 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda8
                                    public final Object invoke(Object obj3) {
                                        Unit m375xb89c363;
                                        m375xb89c363 = VideoArtifactPreviewKt.m375xb89c363(density22, function13, dimens22, (LayoutCoordinates) obj3);
                                        return m375xb89c363;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                                startRestartGroup.endReplaceGroup();
                                Modifier onGloballyPositioned22 = OnGloballyPositionedModifierKt.onGloballyPositioned(wrapContentWidth$default22, (Function1) rememberedValue4);
                                startRestartGroup.startReplaceGroup(460877555);
                                rememberedValue5 = startRestartGroup.rememberedValue();
                                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                                }
                                MutableInteractionSource mutableInteractionSource222 = (MutableInteractionSource) rememberedValue5;
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.startReplaceGroup(460881525);
                                changedInstance2 = startRestartGroup.changedInstance(kmpClickHandler222) | ((29360128 & i3) == 8388608);
                                Object rememberedValue722 = startRestartGroup.rememberedValue();
                                if (changedInstance2) {
                                }
                                Function0 function0422 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda9
                                    public final Object invoke() {
                                        Unit m376xca37dba9;
                                        m376xca37dba9 = VideoArtifactPreviewKt.m376xca37dba9(KmpClickHandler.this, function02);
                                        return m376xca37dba9;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(function0422);
                                obj2 = function0422;
                                startRestartGroup.endReplaceGroup();
                                Modifier modifier1022 = ClickableKt.clickable-O2vRcR0$default(onGloballyPositioned22, mutableInteractionSource222, (Indication) null, false, (String) null, (Role) null, (Function0) obj2, 28, (Object) null);
                                Alignment center222 = Alignment.Companion.getCenter();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy322 = BoxKt.maybeCachedBoxMeasurePolicy(center222, false);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                hashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                CompositionLocalMap currentCompositionLocalMap622 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier622 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier1022);
                                Function0 constructor622 = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, str);
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                }
                                composer7 = Updater.constructor-impl(startRestartGroup);
                                Updater.set-impl(composer7, maybeCachedBoxMeasurePolicy322, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl(composer7, currentCompositionLocalMap622, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash622 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (!composer7.getInserting()) {
                                }
                                composer7.updateRememberedValue(Integer.valueOf(hashCode6));
                                composer7.apply(Integer.valueOf(hashCode6), setCompositeKeyHash622);
                                Updater.set-impl(composer7, materializeModifier622, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                BoxScope boxScope322 = BoxScopeInstance.INSTANCE;
                                TextKt.Text--4IGK_g(str222, (Modifier) null, TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getTextTextWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXsStrong(), startRestartGroup, 0, 0, 65530);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                int i722 = i3 >> 3;
                                int i822 = i3 >> 9;
                                VideoProgressBar(j, j2, function1, function12, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), dimens22.getVideoPreviewProgressHeight-D9Ej5fM()), startRestartGroup, (i722 & 112) | (i722 & 14) | (i822 & 896) | (i822 & 7168), 0);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier2 = modifier422;
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                            if ((i2 & 128) == 0) {
                            }
                            i3 |= i6;
                            if ((i2 & 256) != 0) {
                            }
                            i3 |= i5;
                            i4 = i2 & 512;
                            if (i4 != 0) {
                            }
                            if ((306783379 & i3) == 306783378) {
                            }
                            if (i4 != 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final TraeDimens dimens222 = TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable);
                            CompositionLocal localDensity222 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume222 = startRestartGroup.consume(localDensity222);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final Density density222 = (Density) consume222;
                            startRestartGroup.startReplaceGroup(1449294190);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                            }
                            final KmpClickHandler kmpClickHandler322 = (KmpClickHandler) rememberedValue;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(1449296078);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            }
                            final KmpClickHandler kmpClickHandler2222 = (KmpClickHandler) rememberedValue2;
                            startRestartGroup.endReplaceGroup();
                            Shape shape322 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(dimens222.getVideoPreviewControlRadius-D9Ej5fM());
                            startRestartGroup.startReplaceGroup(1449300264);
                            if (f == 1.0f) {
                            }
                            startRestartGroup.endReplaceGroup();
                            Shape shape2222 = shape322;
                            Modifier modifier4222 = modifier3;
                            Modifier modifier5222 = PaddingKt.padding-qDBjuR0(BackgroundKt.background-bw27NRU$default(ClipKt.clip(ShadowKt.shadow-s4CzXII$default(SizeKt.height-3ABfNKs(modifier3, dimens222.getVideoPreviewControlHeight-D9Ej5fM()), dimens222.getTitleBarElevation-D9Ej5fM(), shape2222, false, 0L, 0L, 24, (Object) null), shape2222), Color.copy-wmQWz5c$default(TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getSpecialWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), dimens222.getVideoPreviewControlPaddingStart-D9Ej5fM(), dimens222.getVideoPreviewControlPaddingVertical-D9Ej5fM(), dimens222.getVideoPreviewControlPaddingEnd-D9Ej5fM(), dimens222.getVideoPreviewControlPaddingVertical-D9Ej5fM());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy422 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            String str2222 = formatSpeed;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                            hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap722 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier722 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier5222);
                            Function0 constructor722 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                            }
                            composer2 = Updater.constructor-impl(startRestartGroup);
                            Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy422, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer2, currentCompositionLocalMap722, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash722 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!composer2.getInserting()) {
                            }
                            composer2.updateRememberedValue(Integer.valueOf(hashCode));
                            composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash722);
                            Updater.set-impl(composer2, materializeModifier722, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope422 = BoxScopeInstance.INSTANCE;
                            Modifier fillMaxSize$default222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            Alignment.Vertical centerVertically322 = Alignment.Companion.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy322 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically322, startRestartGroup, 48);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                            hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default222);
                            Function0 constructor2222 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                            }
                            composer3 = Updater.constructor-impl(startRestartGroup);
                            Updater.set-impl(composer3, rowMeasurePolicy322, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer3, currentCompositionLocalMap2222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash2222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!composer3.getInserting()) {
                            }
                            composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                            composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2222);
                            Updater.set-impl(composer3, materializeModifier2222, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScope rowScope322 = RowScopeInstance.INSTANCE;
                            Modifier modifier6222 = SizeKt.size-3ABfNKs(Modifier.Companion, dimens222.getVideoPreviewPlayTouchSize-D9Ej5fM());
                            startRestartGroup.startReplaceGroup(2074446709);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            }
                            MutableInteractionSource mutableInteractionSource322 = (MutableInteractionSource) rememberedValue3;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(2074450149);
                            changedInstance = startRestartGroup.changedInstance(kmpClickHandler322) | ((57344 & i3) == 16384);
                            Object rememberedValue6222 = startRestartGroup.rememberedValue();
                            if (!changedInstance) {
                            }
                            Function0 function03222 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda7
                                public final Object invoke() {
                                    Unit VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68;
                                    VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68 = VideoArtifactPreviewKt.VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68(KmpClickHandler.this, function0);
                                    return VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68;
                                }
                            };
                            startRestartGroup.updateRememberedValue(function03222);
                            obj = function03222;
                            startRestartGroup.endReplaceGroup();
                            Modifier modifier7222 = ClickableKt.clickable-O2vRcR0$default(modifier6222, mutableInteractionSource322, (Indication) null, false, (String) null, (Role) null, (Function0) obj, 28, (Object) null);
                            Alignment center322 = Alignment.Companion.getCenter();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy2222 = BoxKt.maybeCachedBoxMeasurePolicy(center322, false);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                            hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap3222 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier3222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier7222);
                            Function0 constructor3222 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                            }
                            composer4 = Updater.constructor-impl(startRestartGroup);
                            Updater.set-impl(composer4, maybeCachedBoxMeasurePolicy2222, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer4, currentCompositionLocalMap3222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash3222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!composer4.getInserting()) {
                            }
                            composer4.updateRememberedValue(Integer.valueOf(hashCode3));
                            composer4.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3222);
                            Updater.set-impl(composer4, materializeModifier3222, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope2222 = BoxScopeInstance.INSTANCE;
                            if (z) {
                            }
                            ImageKt.Image(ImageResources_androidKt.painterResource(trae_video_preview_play, startRestartGroup, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, dimens222.getVideoPreviewPlayIconSize-D9Ej5fM()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 48, 120);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, dimens222.getVideoPreviewControlGap-D9Ej5fM()), startRestartGroup, 0);
                            Modifier modifier8222 = SizeKt.height-3ABfNKs(RowScope.weight$default(rowScope322, Modifier.Companion, 1.0f, false, 2, (Object) null), dimens222.getVideoPreviewControlContentHeight-D9Ej5fM());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                            hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap4222 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier4222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier8222);
                            Function0 constructor4222 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                            }
                            composer5 = Updater.constructor-impl(startRestartGroup);
                            Updater.set-impl(composer5, columnMeasurePolicy222, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer5, currentCompositionLocalMap4222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash4222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!composer5.getInserting()) {
                            }
                            composer5.updateRememberedValue(Integer.valueOf(hashCode4));
                            composer5.apply(Integer.valueOf(hashCode4), setCompositeKeyHash4222);
                            Updater.set-impl(composer5, materializeModifier4222, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScope columnScope222 = ColumnScopeInstance.INSTANCE;
                            Modifier modifier9222 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), dimens222.getVideoPreviewControlTextRowHeight-D9Ej5fM());
                            Alignment.Vertical centerVertically2222 = Alignment.Companion.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy2222 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2222, startRestartGroup, 48);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                            hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap5222 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier5222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier9222);
                            Function0 constructor5222 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                            }
                            composer6 = Updater.constructor-impl(startRestartGroup);
                            Updater.set-impl(composer6, rowMeasurePolicy2222, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer6, currentCompositionLocalMap5222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash5222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!composer6.getInserting()) {
                            }
                            composer6.updateRememberedValue(Integer.valueOf(hashCode5));
                            composer6.apply(Integer.valueOf(hashCode5), setCompositeKeyHash5222);
                            Updater.set-impl(composer6, materializeModifier5222, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScope rowScope2222 = RowScopeInstance.INSTANCE;
                            TextKt.Text--4IGK_g(formatTime(j) + " / " + formatTime(j2), (Modifier) null, TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getTextTextWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXs(), startRestartGroup, 0, 0, 65530);
                            SpacerKt.Spacer(RowScope.weight$default(rowScope2222, Modifier.Companion, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
                            Modifier wrapContentWidth$default222 = SizeKt.wrapContentWidth$default(Modifier.Companion, (Alignment.Horizontal) null, false, 3, (Object) null);
                            startRestartGroup.startReplaceGroup(460831822);
                            changed = startRestartGroup.changed(density222) | startRestartGroup.changed(dimens222) | ((234881024 & i3) == 67108864);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (changed) {
                            }
                            str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                            rememberedValue4 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda8
                                public final Object invoke(Object obj3) {
                                    Unit m375xb89c363;
                                    m375xb89c363 = VideoArtifactPreviewKt.m375xb89c363(density222, function13, dimens222, (LayoutCoordinates) obj3);
                                    return m375xb89c363;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                            startRestartGroup.endReplaceGroup();
                            Modifier onGloballyPositioned222 = OnGloballyPositionedModifierKt.onGloballyPositioned(wrapContentWidth$default222, (Function1) rememberedValue4);
                            startRestartGroup.startReplaceGroup(460877555);
                            rememberedValue5 = startRestartGroup.rememberedValue();
                            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                            }
                            MutableInteractionSource mutableInteractionSource2222 = (MutableInteractionSource) rememberedValue5;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(460881525);
                            changedInstance2 = startRestartGroup.changedInstance(kmpClickHandler2222) | ((29360128 & i3) == 8388608);
                            Object rememberedValue7222 = startRestartGroup.rememberedValue();
                            if (changedInstance2) {
                            }
                            Function0 function04222 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda9
                                public final Object invoke() {
                                    Unit m376xca37dba9;
                                    m376xca37dba9 = VideoArtifactPreviewKt.m376xca37dba9(KmpClickHandler.this, function02);
                                    return m376xca37dba9;
                                }
                            };
                            startRestartGroup.updateRememberedValue(function04222);
                            obj2 = function04222;
                            startRestartGroup.endReplaceGroup();
                            Modifier modifier10222 = ClickableKt.clickable-O2vRcR0$default(onGloballyPositioned222, mutableInteractionSource2222, (Indication) null, false, (String) null, (Role) null, (Function0) obj2, 28, (Object) null);
                            Alignment center2222 = Alignment.Companion.getCenter();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy3222 = BoxKt.maybeCachedBoxMeasurePolicy(center2222, false);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                            hashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap6222 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier6222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier10222);
                            Function0 constructor6222 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, str);
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                            }
                            composer7 = Updater.constructor-impl(startRestartGroup);
                            Updater.set-impl(composer7, maybeCachedBoxMeasurePolicy3222, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer7, currentCompositionLocalMap6222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash6222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!composer7.getInserting()) {
                            }
                            composer7.updateRememberedValue(Integer.valueOf(hashCode6));
                            composer7.apply(Integer.valueOf(hashCode6), setCompositeKeyHash6222);
                            Updater.set-impl(composer7, materializeModifier6222, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope3222 = BoxScopeInstance.INSTANCE;
                            TextKt.Text--4IGK_g(str2222, (Modifier) null, TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getTextTextWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXsStrong(), startRestartGroup, 0, 0, 65530);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i7222 = i3 >> 3;
                            int i8222 = i3 >> 9;
                            VideoProgressBar(j, j2, function1, function12, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), dimens222.getVideoPreviewProgressHeight-D9Ej5fM()), startRestartGroup, (i7222 & 112) | (i7222 & 14) | (i8222 & 896) | (i8222 & 7168), 0);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier2 = modifier4222;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        if ((i2 & 64) == 0) {
                        }
                        if ((i2 & 128) == 0) {
                        }
                        i3 |= i6;
                        if ((i2 & 256) != 0) {
                        }
                        i3 |= i5;
                        i4 = i2 & 512;
                        if (i4 != 0) {
                        }
                        if ((306783379 & i3) == 306783378) {
                        }
                        if (i4 != 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final TraeDimens dimens2222 = TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable);
                        CompositionLocal localDensity2222 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object consume2222 = startRestartGroup.consume(localDensity2222);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final Density density2222 = (Density) consume2222;
                        startRestartGroup.startReplaceGroup(1449294190);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                        }
                        final KmpClickHandler kmpClickHandler3222 = (KmpClickHandler) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(1449296078);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        final KmpClickHandler kmpClickHandler22222 = (KmpClickHandler) rememberedValue2;
                        startRestartGroup.endReplaceGroup();
                        Shape shape3222 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(dimens2222.getVideoPreviewControlRadius-D9Ej5fM());
                        startRestartGroup.startReplaceGroup(1449300264);
                        if (f == 1.0f) {
                        }
                        startRestartGroup.endReplaceGroup();
                        Shape shape22222 = shape3222;
                        Modifier modifier42222 = modifier3;
                        Modifier modifier52222 = PaddingKt.padding-qDBjuR0(BackgroundKt.background-bw27NRU$default(ClipKt.clip(ShadowKt.shadow-s4CzXII$default(SizeKt.height-3ABfNKs(modifier3, dimens2222.getVideoPreviewControlHeight-D9Ej5fM()), dimens2222.getTitleBarElevation-D9Ej5fM(), shape22222, false, 0L, 0L, 24, (Object) null), shape22222), Color.copy-wmQWz5c$default(TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getSpecialWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), dimens2222.getVideoPreviewControlPaddingStart-D9Ej5fM(), dimens2222.getVideoPreviewControlPaddingVertical-D9Ej5fM(), dimens2222.getVideoPreviewControlPaddingEnd-D9Ej5fM(), dimens2222.getVideoPreviewControlPaddingVertical-D9Ej5fM());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy4222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        String str22222 = formatSpeed;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap7222 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier7222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier52222);
                        Function0 constructor7222 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        composer2 = Updater.constructor-impl(startRestartGroup);
                        Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy4222, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap7222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash7222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer2.getInserting()) {
                        }
                        composer2.updateRememberedValue(Integer.valueOf(hashCode));
                        composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash7222);
                        Updater.set-impl(composer2, materializeModifier7222, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope4222 = BoxScopeInstance.INSTANCE;
                        Modifier fillMaxSize$default2222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        Alignment.Vertical centerVertically3222 = Alignment.Companion.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy3222 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3222, startRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier22222 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default2222);
                        Function0 constructor22222 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        composer3 = Updater.constructor-impl(startRestartGroup);
                        Updater.set-impl(composer3, rowMeasurePolicy3222, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer3, currentCompositionLocalMap22222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash22222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer3.getInserting()) {
                        }
                        composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                        composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash22222);
                        Updater.set-impl(composer3, materializeModifier22222, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope3222 = RowScopeInstance.INSTANCE;
                        Modifier modifier62222 = SizeKt.size-3ABfNKs(Modifier.Companion, dimens2222.getVideoPreviewPlayTouchSize-D9Ej5fM());
                        startRestartGroup.startReplaceGroup(2074446709);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        }
                        MutableInteractionSource mutableInteractionSource3222 = (MutableInteractionSource) rememberedValue3;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(2074450149);
                        changedInstance = startRestartGroup.changedInstance(kmpClickHandler3222) | ((57344 & i3) == 16384);
                        Object rememberedValue62222 = startRestartGroup.rememberedValue();
                        if (!changedInstance) {
                        }
                        Function0 function032222 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda7
                            public final Object invoke() {
                                Unit VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68;
                                VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68 = VideoArtifactPreviewKt.VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68(KmpClickHandler.this, function0);
                                return VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68;
                            }
                        };
                        startRestartGroup.updateRememberedValue(function032222);
                        obj = function032222;
                        startRestartGroup.endReplaceGroup();
                        Modifier modifier72222 = ClickableKt.clickable-O2vRcR0$default(modifier62222, mutableInteractionSource3222, (Indication) null, false, (String) null, (Role) null, (Function0) obj, 28, (Object) null);
                        Alignment center3222 = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy22222 = BoxKt.maybeCachedBoxMeasurePolicy(center3222, false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap32222 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier32222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier72222);
                        Function0 constructor32222 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        composer4 = Updater.constructor-impl(startRestartGroup);
                        Updater.set-impl(composer4, maybeCachedBoxMeasurePolicy22222, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer4, currentCompositionLocalMap32222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash32222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer4.getInserting()) {
                        }
                        composer4.updateRememberedValue(Integer.valueOf(hashCode3));
                        composer4.apply(Integer.valueOf(hashCode3), setCompositeKeyHash32222);
                        Updater.set-impl(composer4, materializeModifier32222, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope22222 = BoxScopeInstance.INSTANCE;
                        if (z) {
                        }
                        ImageKt.Image(ImageResources_androidKt.painterResource(trae_video_preview_play, startRestartGroup, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, dimens2222.getVideoPreviewPlayIconSize-D9Ej5fM()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 48, 120);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, dimens2222.getVideoPreviewControlGap-D9Ej5fM()), startRestartGroup, 0);
                        Modifier modifier82222 = SizeKt.height-3ABfNKs(RowScope.weight$default(rowScope3222, Modifier.Companion, 1.0f, false, 2, (Object) null), dimens2222.getVideoPreviewControlContentHeight-D9Ej5fM());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy2222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap42222 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier42222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier82222);
                        Function0 constructor42222 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        composer5 = Updater.constructor-impl(startRestartGroup);
                        Updater.set-impl(composer5, columnMeasurePolicy2222, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer5, currentCompositionLocalMap42222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash42222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer5.getInserting()) {
                        }
                        composer5.updateRememberedValue(Integer.valueOf(hashCode4));
                        composer5.apply(Integer.valueOf(hashCode4), setCompositeKeyHash42222);
                        Updater.set-impl(composer5, materializeModifier42222, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope2222 = ColumnScopeInstance.INSTANCE;
                        Modifier modifier92222 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), dimens2222.getVideoPreviewControlTextRowHeight-D9Ej5fM());
                        Alignment.Vertical centerVertically22222 = Alignment.Companion.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy22222 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically22222, startRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap52222 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier52222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier92222);
                        Function0 constructor52222 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        composer6 = Updater.constructor-impl(startRestartGroup);
                        Updater.set-impl(composer6, rowMeasurePolicy22222, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer6, currentCompositionLocalMap52222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash52222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer6.getInserting()) {
                        }
                        composer6.updateRememberedValue(Integer.valueOf(hashCode5));
                        composer6.apply(Integer.valueOf(hashCode5), setCompositeKeyHash52222);
                        Updater.set-impl(composer6, materializeModifier52222, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope22222 = RowScopeInstance.INSTANCE;
                        TextKt.Text--4IGK_g(formatTime(j) + " / " + formatTime(j2), (Modifier) null, TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getTextTextWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXs(), startRestartGroup, 0, 0, 65530);
                        SpacerKt.Spacer(RowScope.weight$default(rowScope22222, Modifier.Companion, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
                        Modifier wrapContentWidth$default2222 = SizeKt.wrapContentWidth$default(Modifier.Companion, (Alignment.Horizontal) null, false, 3, (Object) null);
                        startRestartGroup.startReplaceGroup(460831822);
                        changed = startRestartGroup.changed(density2222) | startRestartGroup.changed(dimens2222) | ((234881024 & i3) == 67108864);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (changed) {
                        }
                        str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                        rememberedValue4 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda8
                            public final Object invoke(Object obj3) {
                                Unit m375xb89c363;
                                m375xb89c363 = VideoArtifactPreviewKt.m375xb89c363(density2222, function13, dimens2222, (LayoutCoordinates) obj3);
                                return m375xb89c363;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                        startRestartGroup.endReplaceGroup();
                        Modifier onGloballyPositioned2222 = OnGloballyPositionedModifierKt.onGloballyPositioned(wrapContentWidth$default2222, (Function1) rememberedValue4);
                        startRestartGroup.startReplaceGroup(460877555);
                        rememberedValue5 = startRestartGroup.rememberedValue();
                        if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        }
                        MutableInteractionSource mutableInteractionSource22222 = (MutableInteractionSource) rememberedValue5;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(460881525);
                        changedInstance2 = startRestartGroup.changedInstance(kmpClickHandler22222) | ((29360128 & i3) == 8388608);
                        Object rememberedValue72222 = startRestartGroup.rememberedValue();
                        if (changedInstance2) {
                        }
                        Function0 function042222 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda9
                            public final Object invoke() {
                                Unit m376xca37dba9;
                                m376xca37dba9 = VideoArtifactPreviewKt.m376xca37dba9(KmpClickHandler.this, function02);
                                return m376xca37dba9;
                            }
                        };
                        startRestartGroup.updateRememberedValue(function042222);
                        obj2 = function042222;
                        startRestartGroup.endReplaceGroup();
                        Modifier modifier102222 = ClickableKt.clickable-O2vRcR0$default(onGloballyPositioned2222, mutableInteractionSource22222, (Indication) null, false, (String) null, (Role) null, (Function0) obj2, 28, (Object) null);
                        Alignment center22222 = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy32222 = BoxKt.maybeCachedBoxMeasurePolicy(center22222, false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        hashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap62222 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier62222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier102222);
                        Function0 constructor62222 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, str);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        composer7 = Updater.constructor-impl(startRestartGroup);
                        Updater.set-impl(composer7, maybeCachedBoxMeasurePolicy32222, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer7, currentCompositionLocalMap62222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash62222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer7.getInserting()) {
                        }
                        composer7.updateRememberedValue(Integer.valueOf(hashCode6));
                        composer7.apply(Integer.valueOf(hashCode6), setCompositeKeyHash62222);
                        Updater.set-impl(composer7, materializeModifier62222, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope32222 = BoxScopeInstance.INSTANCE;
                        TextKt.Text--4IGK_g(str22222, (Modifier) null, TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getTextTextWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXsStrong(), startRestartGroup, 0, 0, 65530);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        int i72222 = i3 >> 3;
                        int i82222 = i3 >> 9;
                        VideoProgressBar(j, j2, function1, function12, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), dimens2222.getVideoPreviewProgressHeight-D9Ej5fM()), startRestartGroup, (i72222 & 112) | (i72222 & 14) | (i82222 & 896) | (i82222 & 7168), 0);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = modifier42222;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) == 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    i3 |= i6;
                    if ((i2 & 256) != 0) {
                    }
                    i3 |= i5;
                    i4 = i2 & 512;
                    if (i4 != 0) {
                    }
                    if ((306783379 & i3) == 306783378) {
                    }
                    if (i4 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final TraeDimens dimens22222 = TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable);
                    CompositionLocal localDensity22222 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume22222 = startRestartGroup.consume(localDensity22222);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Density density22222 = (Density) consume22222;
                    startRestartGroup.startReplaceGroup(1449294190);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                    }
                    final KmpClickHandler kmpClickHandler32222 = (KmpClickHandler) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1449296078);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    final KmpClickHandler kmpClickHandler222222 = (KmpClickHandler) rememberedValue2;
                    startRestartGroup.endReplaceGroup();
                    Shape shape32222 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(dimens22222.getVideoPreviewControlRadius-D9Ej5fM());
                    startRestartGroup.startReplaceGroup(1449300264);
                    if (f == 1.0f) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Shape shape222222 = shape32222;
                    Modifier modifier422222 = modifier3;
                    Modifier modifier522222 = PaddingKt.padding-qDBjuR0(BackgroundKt.background-bw27NRU$default(ClipKt.clip(ShadowKt.shadow-s4CzXII$default(SizeKt.height-3ABfNKs(modifier3, dimens22222.getVideoPreviewControlHeight-D9Ej5fM()), dimens22222.getTitleBarElevation-D9Ej5fM(), shape222222, false, 0L, 0L, 24, (Object) null), shape222222), Color.copy-wmQWz5c$default(TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getSpecialWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), dimens22222.getVideoPreviewControlPaddingStart-D9Ej5fM(), dimens22222.getVideoPreviewControlPaddingVertical-D9Ej5fM(), dimens22222.getVideoPreviewControlPaddingEnd-D9Ej5fM(), dimens22222.getVideoPreviewControlPaddingVertical-D9Ej5fM());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy42222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    String str222222 = formatSpeed;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap72222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier72222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier522222);
                    Function0 constructor72222 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    composer2 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy42222, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap72222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash72222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                    }
                    composer2.updateRememberedValue(Integer.valueOf(hashCode));
                    composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash72222);
                    Updater.set-impl(composer2, materializeModifier72222, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope42222 = BoxScopeInstance.INSTANCE;
                    Modifier fillMaxSize$default22222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    Alignment.Vertical centerVertically32222 = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy32222 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically32222, startRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap222222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier222222 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default22222);
                    Function0 constructor222222 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    composer3 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer3, rowMeasurePolicy32222, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer3, currentCompositionLocalMap222222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash222222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer3.getInserting()) {
                    }
                    composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                    composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash222222);
                    Updater.set-impl(composer3, materializeModifier222222, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope32222 = RowScopeInstance.INSTANCE;
                    Modifier modifier622222 = SizeKt.size-3ABfNKs(Modifier.Companion, dimens22222.getVideoPreviewPlayTouchSize-D9Ej5fM());
                    startRestartGroup.startReplaceGroup(2074446709);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    }
                    MutableInteractionSource mutableInteractionSource32222 = (MutableInteractionSource) rememberedValue3;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(2074450149);
                    changedInstance = startRestartGroup.changedInstance(kmpClickHandler32222) | ((57344 & i3) == 16384);
                    Object rememberedValue622222 = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                    }
                    Function0 function0322222 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68;
                            VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68 = VideoArtifactPreviewKt.VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68(KmpClickHandler.this, function0);
                            return VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68;
                        }
                    };
                    startRestartGroup.updateRememberedValue(function0322222);
                    obj = function0322222;
                    startRestartGroup.endReplaceGroup();
                    Modifier modifier722222 = ClickableKt.clickable-O2vRcR0$default(modifier622222, mutableInteractionSource32222, (Indication) null, false, (String) null, (Role) null, (Function0) obj, 28, (Object) null);
                    Alignment center32222 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy222222 = BoxKt.maybeCachedBoxMeasurePolicy(center32222, false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap322222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier322222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier722222);
                    Function0 constructor322222 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    composer4 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer4, maybeCachedBoxMeasurePolicy222222, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer4, currentCompositionLocalMap322222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash322222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer4.getInserting()) {
                    }
                    composer4.updateRememberedValue(Integer.valueOf(hashCode3));
                    composer4.apply(Integer.valueOf(hashCode3), setCompositeKeyHash322222);
                    Updater.set-impl(composer4, materializeModifier322222, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope222222 = BoxScopeInstance.INSTANCE;
                    if (z) {
                    }
                    ImageKt.Image(ImageResources_androidKt.painterResource(trae_video_preview_play, startRestartGroup, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, dimens22222.getVideoPreviewPlayIconSize-D9Ej5fM()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 48, 120);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, dimens22222.getVideoPreviewControlGap-D9Ej5fM()), startRestartGroup, 0);
                    Modifier modifier822222 = SizeKt.height-3ABfNKs(RowScope.weight$default(rowScope32222, Modifier.Companion, 1.0f, false, 2, (Object) null), dimens22222.getVideoPreviewControlContentHeight-D9Ej5fM());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy22222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap422222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier422222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier822222);
                    Function0 constructor422222 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    composer5 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer5, columnMeasurePolicy22222, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer5, currentCompositionLocalMap422222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash422222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer5.getInserting()) {
                    }
                    composer5.updateRememberedValue(Integer.valueOf(hashCode4));
                    composer5.apply(Integer.valueOf(hashCode4), setCompositeKeyHash422222);
                    Updater.set-impl(composer5, materializeModifier422222, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope22222 = ColumnScopeInstance.INSTANCE;
                    Modifier modifier922222 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), dimens22222.getVideoPreviewControlTextRowHeight-D9Ej5fM());
                    Alignment.Vertical centerVertically222222 = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy222222 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically222222, startRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap522222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier522222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier922222);
                    Function0 constructor522222 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    composer6 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer6, rowMeasurePolicy222222, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer6, currentCompositionLocalMap522222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash522222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer6.getInserting()) {
                    }
                    composer6.updateRememberedValue(Integer.valueOf(hashCode5));
                    composer6.apply(Integer.valueOf(hashCode5), setCompositeKeyHash522222);
                    Updater.set-impl(composer6, materializeModifier522222, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope222222 = RowScopeInstance.INSTANCE;
                    TextKt.Text--4IGK_g(formatTime(j) + " / " + formatTime(j2), (Modifier) null, TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getTextTextWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXs(), startRestartGroup, 0, 0, 65530);
                    SpacerKt.Spacer(RowScope.weight$default(rowScope222222, Modifier.Companion, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
                    Modifier wrapContentWidth$default22222 = SizeKt.wrapContentWidth$default(Modifier.Companion, (Alignment.Horizontal) null, false, 3, (Object) null);
                    startRestartGroup.startReplaceGroup(460831822);
                    changed = startRestartGroup.changed(density22222) | startRestartGroup.changed(dimens22222) | ((234881024 & i3) == 67108864);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (changed) {
                    }
                    str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    rememberedValue4 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj3) {
                            Unit m375xb89c363;
                            m375xb89c363 = VideoArtifactPreviewKt.m375xb89c363(density22222, function13, dimens22222, (LayoutCoordinates) obj3);
                            return m375xb89c363;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    startRestartGroup.endReplaceGroup();
                    Modifier onGloballyPositioned22222 = OnGloballyPositionedModifierKt.onGloballyPositioned(wrapContentWidth$default22222, (Function1) rememberedValue4);
                    startRestartGroup.startReplaceGroup(460877555);
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    }
                    MutableInteractionSource mutableInteractionSource222222 = (MutableInteractionSource) rememberedValue5;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(460881525);
                    changedInstance2 = startRestartGroup.changedInstance(kmpClickHandler222222) | ((29360128 & i3) == 8388608);
                    Object rememberedValue722222 = startRestartGroup.rememberedValue();
                    if (changedInstance2) {
                    }
                    Function0 function0422222 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit m376xca37dba9;
                            m376xca37dba9 = VideoArtifactPreviewKt.m376xca37dba9(KmpClickHandler.this, function02);
                            return m376xca37dba9;
                        }
                    };
                    startRestartGroup.updateRememberedValue(function0422222);
                    obj2 = function0422222;
                    startRestartGroup.endReplaceGroup();
                    Modifier modifier1022222 = ClickableKt.clickable-O2vRcR0$default(onGloballyPositioned22222, mutableInteractionSource222222, (Indication) null, false, (String) null, (Role) null, (Function0) obj2, 28, (Object) null);
                    Alignment center222222 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy322222 = BoxKt.maybeCachedBoxMeasurePolicy(center222222, false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    hashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap622222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier622222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier1022222);
                    Function0 constructor622222 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, str);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    composer7 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer7, maybeCachedBoxMeasurePolicy322222, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer7, currentCompositionLocalMap622222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash622222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer7.getInserting()) {
                    }
                    composer7.updateRememberedValue(Integer.valueOf(hashCode6));
                    composer7.apply(Integer.valueOf(hashCode6), setCompositeKeyHash622222);
                    Updater.set-impl(composer7, materializeModifier622222, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope322222 = BoxScopeInstance.INSTANCE;
                    TextKt.Text--4IGK_g(str222222, (Modifier) null, TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getTextTextWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXsStrong(), startRestartGroup, 0, 0, 65530);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    int i722222 = i3 >> 3;
                    int i822222 = i3 >> 9;
                    VideoProgressBar(j, j2, function1, function12, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), dimens22222.getVideoPreviewProgressHeight-D9Ej5fM()), startRestartGroup, (i722222 & 112) | (i722222 & 14) | (i822222 & 896) | (i822222 & 7168), 0);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier422222;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i2 & 4) == 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) == 0) {
                }
                if ((i2 & 128) == 0) {
                }
                i3 |= i6;
                if ((i2 & 256) != 0) {
                }
                i3 |= i5;
                i4 = i2 & 512;
                if (i4 != 0) {
                }
                if ((306783379 & i3) == 306783378) {
                }
                if (i4 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                final TraeDimens dimens222222 = TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable);
                CompositionLocal localDensity222222 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume222222 = startRestartGroup.consume(localDensity222222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final Density density222222 = (Density) consume222222;
                startRestartGroup.startReplaceGroup(1449294190);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                }
                final KmpClickHandler kmpClickHandler322222 = (KmpClickHandler) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1449296078);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                }
                final KmpClickHandler kmpClickHandler2222222 = (KmpClickHandler) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                Shape shape322222 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(dimens222222.getVideoPreviewControlRadius-D9Ej5fM());
                startRestartGroup.startReplaceGroup(1449300264);
                if (f == 1.0f) {
                }
                startRestartGroup.endReplaceGroup();
                Shape shape2222222 = shape322222;
                Modifier modifier4222222 = modifier3;
                Modifier modifier5222222 = PaddingKt.padding-qDBjuR0(BackgroundKt.background-bw27NRU$default(ClipKt.clip(ShadowKt.shadow-s4CzXII$default(SizeKt.height-3ABfNKs(modifier3, dimens222222.getVideoPreviewControlHeight-D9Ej5fM()), dimens222222.getTitleBarElevation-D9Ej5fM(), shape2222222, false, 0L, 0L, 24, (Object) null), shape2222222), Color.copy-wmQWz5c$default(TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getSpecialWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), dimens222222.getVideoPreviewControlPaddingStart-D9Ej5fM(), dimens222222.getVideoPreviewControlPaddingVertical-D9Ej5fM(), dimens222222.getVideoPreviewControlPaddingEnd-D9Ej5fM(), dimens222222.getVideoPreviewControlPaddingVertical-D9Ej5fM());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy422222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                String str2222222 = formatSpeed;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap722222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier722222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier5222222);
                Function0 constructor722222 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                composer2 = Updater.constructor-impl(startRestartGroup);
                Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy422222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap722222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash722222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                }
                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash722222);
                Updater.set-impl(composer2, materializeModifier722222, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope422222 = BoxScopeInstance.INSTANCE;
                Modifier fillMaxSize$default222222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment.Vertical centerVertically322222 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy322222 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically322222, startRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2222222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2222222 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default222222);
                Function0 constructor2222222 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                composer3 = Updater.constructor-impl(startRestartGroup);
                Updater.set-impl(composer3, rowMeasurePolicy322222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap2222222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2222222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer3.getInserting()) {
                }
                composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2222222);
                Updater.set-impl(composer3, materializeModifier2222222, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope322222 = RowScopeInstance.INSTANCE;
                Modifier modifier6222222 = SizeKt.size-3ABfNKs(Modifier.Companion, dimens222222.getVideoPreviewPlayTouchSize-D9Ej5fM());
                startRestartGroup.startReplaceGroup(2074446709);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                }
                MutableInteractionSource mutableInteractionSource322222 = (MutableInteractionSource) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(2074450149);
                changedInstance = startRestartGroup.changedInstance(kmpClickHandler322222) | ((57344 & i3) == 16384);
                Object rememberedValue6222222 = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                Function0 function03222222 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68;
                        VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68 = VideoArtifactPreviewKt.VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68(KmpClickHandler.this, function0);
                        return VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68;
                    }
                };
                startRestartGroup.updateRememberedValue(function03222222);
                obj = function03222222;
                startRestartGroup.endReplaceGroup();
                Modifier modifier7222222 = ClickableKt.clickable-O2vRcR0$default(modifier6222222, mutableInteractionSource322222, (Indication) null, false, (String) null, (Role) null, (Function0) obj, 28, (Object) null);
                Alignment center322222 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2222222 = BoxKt.maybeCachedBoxMeasurePolicy(center322222, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3222222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3222222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier7222222);
                Function0 constructor3222222 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                composer4 = Updater.constructor-impl(startRestartGroup);
                Updater.set-impl(composer4, maybeCachedBoxMeasurePolicy2222222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap3222222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash3222222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer4.getInserting()) {
                }
                composer4.updateRememberedValue(Integer.valueOf(hashCode3));
                composer4.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3222222);
                Updater.set-impl(composer4, materializeModifier3222222, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2222222 = BoxScopeInstance.INSTANCE;
                if (z) {
                }
                ImageKt.Image(ImageResources_androidKt.painterResource(trae_video_preview_play, startRestartGroup, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, dimens222222.getVideoPreviewPlayIconSize-D9Ej5fM()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 48, 120);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, dimens222222.getVideoPreviewControlGap-D9Ej5fM()), startRestartGroup, 0);
                Modifier modifier8222222 = SizeKt.height-3ABfNKs(RowScope.weight$default(rowScope322222, Modifier.Companion, 1.0f, false, 2, (Object) null), dimens222222.getVideoPreviewControlContentHeight-D9Ej5fM());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy222222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4222222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4222222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier8222222);
                Function0 constructor4222222 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                composer5 = Updater.constructor-impl(startRestartGroup);
                Updater.set-impl(composer5, columnMeasurePolicy222222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer5, currentCompositionLocalMap4222222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash4222222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer5.getInserting()) {
                }
                composer5.updateRememberedValue(Integer.valueOf(hashCode4));
                composer5.apply(Integer.valueOf(hashCode4), setCompositeKeyHash4222222);
                Updater.set-impl(composer5, materializeModifier4222222, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope222222 = ColumnScopeInstance.INSTANCE;
                Modifier modifier9222222 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), dimens222222.getVideoPreviewControlTextRowHeight-D9Ej5fM());
                Alignment.Vertical centerVertically2222222 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy2222222 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2222222, startRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                hashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap5222222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier5222222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier9222222);
                Function0 constructor5222222 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                composer6 = Updater.constructor-impl(startRestartGroup);
                Updater.set-impl(composer6, rowMeasurePolicy2222222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer6, currentCompositionLocalMap5222222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash5222222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer6.getInserting()) {
                }
                composer6.updateRememberedValue(Integer.valueOf(hashCode5));
                composer6.apply(Integer.valueOf(hashCode5), setCompositeKeyHash5222222);
                Updater.set-impl(composer6, materializeModifier5222222, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2222222 = RowScopeInstance.INSTANCE;
                TextKt.Text--4IGK_g(formatTime(j) + " / " + formatTime(j2), (Modifier) null, TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getTextTextWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXs(), startRestartGroup, 0, 0, 65530);
                SpacerKt.Spacer(RowScope.weight$default(rowScope2222222, Modifier.Companion, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
                Modifier wrapContentWidth$default222222 = SizeKt.wrapContentWidth$default(Modifier.Companion, (Alignment.Horizontal) null, false, 3, (Object) null);
                startRestartGroup.startReplaceGroup(460831822);
                changed = startRestartGroup.changed(density222222) | startRestartGroup.changed(dimens222222) | ((234881024 & i3) == 67108864);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (changed) {
                }
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                rememberedValue4 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj3) {
                        Unit m375xb89c363;
                        m375xb89c363 = VideoArtifactPreviewKt.m375xb89c363(density222222, function13, dimens222222, (LayoutCoordinates) obj3);
                        return m375xb89c363;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                startRestartGroup.endReplaceGroup();
                Modifier onGloballyPositioned222222 = OnGloballyPositionedModifierKt.onGloballyPositioned(wrapContentWidth$default222222, (Function1) rememberedValue4);
                startRestartGroup.startReplaceGroup(460877555);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                }
                MutableInteractionSource mutableInteractionSource2222222 = (MutableInteractionSource) rememberedValue5;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(460881525);
                changedInstance2 = startRestartGroup.changedInstance(kmpClickHandler2222222) | ((29360128 & i3) == 8388608);
                Object rememberedValue7222222 = startRestartGroup.rememberedValue();
                if (changedInstance2) {
                }
                Function0 function04222222 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        Unit m376xca37dba9;
                        m376xca37dba9 = VideoArtifactPreviewKt.m376xca37dba9(KmpClickHandler.this, function02);
                        return m376xca37dba9;
                    }
                };
                startRestartGroup.updateRememberedValue(function04222222);
                obj2 = function04222222;
                startRestartGroup.endReplaceGroup();
                Modifier modifier10222222 = ClickableKt.clickable-O2vRcR0$default(onGloballyPositioned222222, mutableInteractionSource2222222, (Indication) null, false, (String) null, (Role) null, (Function0) obj2, 28, (Object) null);
                Alignment center2222222 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy3222222 = BoxKt.maybeCachedBoxMeasurePolicy(center2222222, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                hashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap6222222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier6222222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier10222222);
                Function0 constructor6222222 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, str);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                composer7 = Updater.constructor-impl(startRestartGroup);
                Updater.set-impl(composer7, maybeCachedBoxMeasurePolicy3222222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer7, currentCompositionLocalMap6222222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash6222222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer7.getInserting()) {
                }
                composer7.updateRememberedValue(Integer.valueOf(hashCode6));
                composer7.apply(Integer.valueOf(hashCode6), setCompositeKeyHash6222222);
                Updater.set-impl(composer7, materializeModifier6222222, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope3222222 = BoxScopeInstance.INSTANCE;
                TextKt.Text--4IGK_g(str2222222, (Modifier) null, TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getTextTextWhite-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXsStrong(), startRestartGroup, 0, 0, 65530);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                int i7222222 = i3 >> 3;
                int i8222222 = i3 >> 9;
                VideoProgressBar(j, j2, function1, function12, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), dimens222222.getVideoPreviewProgressHeight-D9Ej5fM()), startRestartGroup, (i7222222 & 112) | (i7222222 & 14) | (i8222222 & 896) | (i8222222 & 7168), 0);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier4222222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68(KmpClickHandler kmpClickHandler, Function0 function0) {
                kmpClickHandler.tryHandle(function0);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: VideoPlaybackControls$lambda$83$lambda$82$lambda$81$lambda$80$lambda$75$lambda$74 */
            public static final Unit m375xb89c363(Density density, Function1 function1, TraeDimens traeDimens, LayoutCoordinates layoutCoordinates) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
                long positionInRoot = LayoutCoordinatesKt.positionInRoot(layoutCoordinates);
                float f = density.toPx-0680j_4(traeDimens.getVideoPreviewSpeedMenuWidth-D9Ej5fM());
                float f2 = (density.toPx-0680j_4(traeDimens.getVideoPreviewSpeedMenuItemHeight-D9Ej5fM()) * PlaybackSpeeds.size()) / 2.0f;
                float f3 = density.toPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(traeDimens.getContextMenuVerticalPadding-D9Ej5fM() - traeDimens.getContextMenuDividerHeight-D9Ej5fM()) - traeDimens.getContextMenuDividerHeight-D9Ej5fM()));
                float intBitsToFloat = (Float.intBitsToFloat((int) (positionInRoot >> 32)) + ((int) (layoutCoordinates.getSize-YbymL2g() >> 32))) - (f / 2.0f);
                float intBitsToFloat2 = (Float.intBitsToFloat((int) (positionInRoot & 4294967295L)) - f3) - f2;
                function1.invoke(Offset.box-impl(Offset.constructor-impl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L))));
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: VideoPlaybackControls$lambda$83$lambda$82$lambda$81$lambda$80$lambda$78$lambda$77 */
            public static final Unit m376xca37dba9(KmpClickHandler kmpClickHandler, Function0 function0) {
                kmpClickHandler.tryHandle(function0);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:25:0x0214  */
            /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x00af  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00c4  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x00e2  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0130  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x013c  */
            /* JADX WARN: Removed duplicated region for block: B:52:0x0171  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x017b  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x0185  */
            /* JADX WARN: Removed duplicated region for block: B:70:0x0209  */
            /* JADX WARN: Removed duplicated region for block: B:73:0x017e  */
            /* JADX WARN: Removed duplicated region for block: B:74:0x0174  */
            /* JADX WARN: Removed duplicated region for block: B:76:0x013f  */
            /* JADX WARN: Removed duplicated region for block: B:77:0x0133  */
            /* JADX WARN: Removed duplicated region for block: B:78:0x00cf  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private static final void VideoProgressBar(final long j, final long j2, final Function1<? super Long, Unit> function1, final Function1<? super Long, Unit> function12, Modifier modifier, Composer composer, final int i, final int i2) {
                int i3;
                Modifier modifier2;
                float coerceIn;
                Object rememberedValue;
                long j3;
                boolean z;
                VideoArtifactPreviewKt$VideoProgressBar$1$1 rememberedValue2;
                Long valueOf;
                boolean z2;
                VideoArtifactPreviewKt$VideoProgressBar$2$1 rememberedValue3;
                long j4;
                float f;
                Long l;
                boolean changed;
                Object rememberedValue4;
                ScopeUpdateScope endRestartGroup;
                Composer startRestartGroup = composer.startRestartGroup(-1419374183);
                if ((i2 & 1) != 0) {
                    i3 = i | 6;
                } else if ((i & 6) == 0) {
                    i3 = (startRestartGroup.changed(j) ? 4 : 2) | i;
                } else {
                    i3 = i;
                }
                if ((i2 & 2) != 0) {
                    i3 |= 48;
                } else if ((i & 48) == 0) {
                    i3 |= startRestartGroup.changed(j2) ? 32 : 16;
                }
                if ((i2 & 4) != 0) {
                    i3 |= 384;
                } else if ((i & 384) == 0) {
                    i3 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
                }
                int i4 = i2 & 16;
                if (i4 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    modifier2 = modifier;
                    i3 |= startRestartGroup.changed(modifier2) ? 16384 : 8192;
                    if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                        if (i4 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1419374183, i3, -1, "com.bytedance.trae.kmp.artifacts.video.VideoProgressBar (VideoArtifactPreview.kt:699)");
                        }
                        final TraeDimens dimens = TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable);
                        coerceIn = j2 <= 0 ? RangesKt.coerceIn(((float) j) / ((float) j2), 0.0f, 1.0f) : 0.0f;
                        startRestartGroup.startReplaceGroup(-512929458);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt.mutableStateOf$default(Long.valueOf(j), (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        MutableState mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        j3 = Color.copy-wmQWz5c$default(TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getSpecialWhite-0d7_KjU(), PreviewDismissScaleReduction, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        final long j5 = TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getBgBgWhite-0d7_KjU();
                        Long valueOf2 = Long.valueOf(j2);
                        startRestartGroup.startReplaceGroup(-512915342);
                        int i5 = i3 & 7168;
                        int i6 = i3 & 112;
                        z = (i6 != 32) | (i5 != 2048);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!z || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new VideoArtifactPreviewKt$VideoProgressBar$1$1(function12, j2);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceGroup();
                        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier2, valueOf2, (PointerInputEventHandler) rememberedValue2);
                        valueOf = Long.valueOf(j2);
                        startRestartGroup.startReplaceGroup(-512909199);
                        z2 = ((i3 & 896) != 256) | (i6 != 32) | (i5 == 2048);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!z2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                            j4 = j3;
                            f = coerceIn;
                            l = valueOf;
                            rememberedValue3 = new VideoArtifactPreviewKt$VideoProgressBar$2$1(function1, j2, mutableState, function12);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        } else {
                            l = valueOf;
                            f = coerceIn;
                            j4 = j3;
                        }
                        startRestartGroup.endReplaceGroup();
                        Modifier pointerInput2 = SuspendingPointerInputFilterKt.pointerInput(pointerInput, l, (PointerInputEventHandler) rememberedValue3);
                        startRestartGroup.startReplaceGroup(-512889411);
                        changed = startRestartGroup.changed(dimens) | startRestartGroup.changed(f) | startRestartGroup.changed(j4) | startRestartGroup.changed(j5);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue4 == Composer.Companion.getEmpty()) {
                            final float f2 = f;
                            final long j6 = j4;
                            rememberedValue4 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda12
                                public final Object invoke(Object obj) {
                                    Unit VideoProgressBar$lambda$91$lambda$90;
                                    VideoProgressBar$lambda$91$lambda$90 = VideoArtifactPreviewKt.VideoProgressBar$lambda$91$lambda$90(dimens, f2, j6, j5, (DrawScope) obj);
                                    return VideoProgressBar$lambda$91$lambda$90;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                        }
                        startRestartGroup.endReplaceGroup();
                        CanvasKt.Canvas(pointerInput2, (Function1) rememberedValue4, startRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                    }
                    final Modifier modifier3 = modifier2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda13
                            public final Object invoke(Object obj, Object obj2) {
                                Unit VideoProgressBar$lambda$92;
                                VideoProgressBar$lambda$92 = VideoArtifactPreviewKt.VideoProgressBar$lambda$92(j, j2, function1, function12, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                return VideoProgressBar$lambda$92;
                            }
                        });
                        return;
                    }
                    return;
                }
                modifier2 = modifier;
                if ((i3 & 9363) == 9362) {
                }
                if (i4 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                final TraeDimens dimens2 = TraeTheme.INSTANCE.getDimens(startRestartGroup, TraeTheme.$stable);
                if (j2 <= 0) {
                }
                startRestartGroup.startReplaceGroup(-512929458);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                }
                MutableState mutableState2 = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                j3 = Color.copy-wmQWz5c$default(TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getSpecialWhite-0d7_KjU(), PreviewDismissScaleReduction, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                final long j52 = TraeTheme.INSTANCE.getColors(startRestartGroup, TraeTheme.$stable).getBgBgWhite-0d7_KjU();
                Long valueOf22 = Long.valueOf(j2);
                startRestartGroup.startReplaceGroup(-512915342);
                int i52 = i3 & 7168;
                if (i52 != 2048) {
                }
                int i62 = i3 & 112;
                z = (i62 != 32) | (i52 != 2048);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z) {
                }
                rememberedValue2 = new VideoArtifactPreviewKt$VideoProgressBar$1$1(function12, j2);
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceGroup();
                Modifier pointerInput3 = SuspendingPointerInputFilterKt.pointerInput(modifier2, valueOf22, (PointerInputEventHandler) rememberedValue2);
                valueOf = Long.valueOf(j2);
                startRestartGroup.startReplaceGroup(-512909199);
                if (i62 != 32) {
                }
                z2 = ((i3 & 896) != 256) | (i62 != 32) | (i52 == 2048);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (z2) {
                }
                j4 = j3;
                f = coerceIn;
                l = valueOf;
                rememberedValue3 = new VideoArtifactPreviewKt$VideoProgressBar$2$1(function1, j2, mutableState2, function12);
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceGroup();
                Modifier pointerInput22 = SuspendingPointerInputFilterKt.pointerInput(pointerInput3, l, (PointerInputEventHandler) rememberedValue3);
                startRestartGroup.startReplaceGroup(-512889411);
                changed = startRestartGroup.changed(dimens2) | startRestartGroup.changed(f) | startRestartGroup.changed(j4) | startRestartGroup.changed(j52);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                final float f22 = f;
                final long j62 = j4;
                rememberedValue4 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj) {
                        Unit VideoProgressBar$lambda$91$lambda$90;
                        VideoProgressBar$lambda$91$lambda$90 = VideoArtifactPreviewKt.VideoProgressBar$lambda$91$lambda$90(dimens2, f22, j62, j52, (DrawScope) obj);
                        return VideoProgressBar$lambda$91$lambda$90;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                startRestartGroup.endReplaceGroup();
                CanvasKt.Canvas(pointerInput22, (Function1) rememberedValue4, startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                final Modifier modifier32 = modifier2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final long VideoProgressBar$lambda$86(MutableState<Long> mutableState) {
                return ((Number) ((State) mutableState).getValue()).longValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void VideoProgressBar$lambda$87(MutableState<Long> mutableState, long j) {
                mutableState.setValue(Long.valueOf(j));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final long VideoProgressBar$targetFor(long j, float f, int i) {
                if (j <= 0 || i <= 0) {
                    return 0L;
                }
                return ((float) j) * RangesKt.coerceIn(f / i, 0.0f, 1.0f);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit VideoProgressBar$lambda$91$lambda$90(TraeDimens traeDimens, float f, long j, long j2, DrawScope drawScope) {
                Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
                float f2 = drawScope.toPx-0680j_4(traeDimens.getVideoPreviewProgressHorizontalInset-D9Ej5fM());
                float f3 = drawScope.toPx-0680j_4(traeDimens.getVideoPreviewProgressTrackHeight-D9Ej5fM());
                float f4 = drawScope.toPx-0680j_4(traeDimens.getVideoPreviewProgressThumbSize-D9Ej5fM()) / 2.0f;
                float coerceAtLeast = f2 + ((RangesKt.coerceAtLeast(Float.intBitsToFloat((int) (drawScope.getSize-NH-jbRc() >> 32)) - f2, f2) - f2) * f);
                float intBitsToFloat = (Float.intBitsToFloat((int) (drawScope.getSize-NH-jbRc() & 4294967295L)) / 2.0f) - (f3 / 2.0f);
                DrawScope.drawRoundRect-u-Aw5IA$default(drawScope, j, Offset.constructor-impl((Float.floatToRawIntBits(f2) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L)), Size.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (Float.floatToRawIntBits(f3) & 4294967295L)), CornerRadius.constructor-impl((Float.floatToRawIntBits(r23) << 32) | (Float.floatToRawIntBits(r23) & 4294967295L)), (DrawStyle) null, 0.0f, (ColorFilter) null, 0, 240, (Object) null);
                DrawScope.drawRoundRect-u-Aw5IA$default(drawScope, j2, Offset.constructor-impl((Float.floatToRawIntBits(f2) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L)), Size.constructor-impl((Float.floatToRawIntBits(RangesKt.coerceAtLeast(coerceAtLeast - f2, 0.0f)) << 32) | (Float.floatToRawIntBits(f3) & 4294967295L)), CornerRadius.constructor-impl((Float.floatToRawIntBits(r23) << 32) | (Float.floatToRawIntBits(r23) & 4294967295L)), (DrawStyle) null, 0.0f, (ColorFilter) null, 0, 240, (Object) null);
                DrawScope.drawCircle-VaOC9Bg$default(drawScope, j2, f4, Offset.constructor-impl((Float.floatToRawIntBits(coerceAtLeast) << 32) | (Float.floatToRawIntBits(r22) & 4294967295L)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
                return Unit.INSTANCE;
            }

            private static final String formatTime(long j) {
                long coerceAtLeast = RangesKt.coerceAtLeast(j, 0L) / 1000;
                return StringsKt.padStart(String.valueOf(coerceAtLeast / 60), 2, '0') + ':' + StringsKt.padStart(String.valueOf(coerceAtLeast % 60), 2, '0');
            }

            private static final String formatSpeed(float f) {
                String valueOf;
                if (f % 1.0f == 0.0f) {
                    valueOf = String.valueOf((int) f);
                } else {
                    valueOf = String.valueOf(f);
                }
                return valueOf + 'x';
            }

            private static final String formatMenuSpeed(float f) {
                if (f % 1.0f == 0.0f) {
                    return ((int) f) + ".0";
                }
                return String.valueOf(f);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Function0<Unit> VideoArtifactPreviewScreen$lambda$6(State<? extends Function0<Unit>> state) {
                return (Function0) state.getValue();
            }
        }
