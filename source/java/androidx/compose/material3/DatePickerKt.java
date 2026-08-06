package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.draw.ClipKt;
import androidx.compose.p002ui.draw.DrawModifierKt;
import androidx.compose.p002ui.draw.RotateKt;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p002ui.graphics.vector.ImageVector;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: DatePicker.kt */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0084\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001ak\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010'\u001a\u00020(2\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010+\u001a\u008d\u0001\u0010,\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020.2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010=\u001aZ\u0010>\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u00032\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001aT\u0010E\u001a\u00020&2\n\u0010F\u001a\u00060Gj\u0002`H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010.2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010;\u001a\u00020<H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001an\u0010O\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010P\u001a\u00020*2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020*2\u0006\u0010T\u001a\u00020*2\u0006\u0010U\u001a\u00020*2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u001c\u001a\u00020\u001d2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u0010X\u001a6\u0010Y\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020L2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001401H\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a\u008d\u0001\u0010^\u001a\u00020\u00142\u0006\u0010_\u001a\u00020`2\b\u0010-\u001a\u0004\u0018\u00010.2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010a\u001av\u0010b\u001a\u00020\u00142\u0006\u0010c\u001a\u00020d2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012\u0006\u0010e\u001a\u00020.2\b\u0010f\u001a\u0004\u0018\u00010.2\b\u0010g\u001a\u0004\u0018\u00010.2\b\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\u0010j\u001ag\u0010k\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010l\u001a\u00020*2\u0006\u0010m\u001a\u00020*2\u0006\u0010n\u001a\u00020*2\u0006\u0010o\u001a\u00020W2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010s\u001a\u009c\u0001\u0010t\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020.2\u0006\u0010Z\u001a\u00020L2#\u00100\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003ø\u0001\u0000¢\u0006\u0004\bu\u0010v\u001a\u001d\u0010w\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\u0010x\u001a^\u0010y\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010P\u001a\u00020*2\u0006\u0010z\u001a\u00020*2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010S\u001a\u00020*2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u001c\u001a\u00020\u001d2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u0010{\u001a`\u0010|\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010/\u001a\u00020.2!\u0010}\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(~\u0012\u0004\u0012\u00020\u0014012\u0006\u0010;\u001a\u00020<2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010\u007f\u001aC\u0010\u0080\u0001\u001a\u00020\u00142\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0007\u0010\u0081\u0001\u001a\u00020*2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0003\u0010\u0082\u0001\u001a6\u0010\u0083\u0001\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u0084\u00012\u0007\u0010%\u001a\u00030\u0086\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0089\u0001\u001a\u00020W2\u0007\u0010\u008a\u0001\u001a\u00020WH\u0002\u001a>\u0010\u008b\u0001\u001a\u0004\u0018\u00010W2\u0007\u0010\u008c\u0001\u001a\u00020*2\u0007\u0010\u008d\u0001\u001a\u00020*2\u0007\u0010\u008e\u0001\u001a\u00020*2\u0007\u0010\u008f\u0001\u001a\u00020*2\u0007\u0010\u0090\u0001\u001a\u00020*H\u0003¢\u0006\u0003\u0010\u0091\u0001\u001a\u0011\u0010\u0092\u0001\u001a\u00020\f2\u0006\u00109\u001a\u00020:H\u0000\u001aK\u0010\u0093\u0001\u001a\u00020&2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010.2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010;\u001a\u00020<H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001\u001aK\u0010\u0096\u0001\u001a\u00020\u00142\u0006\u0010_\u001a\u00020`2!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0080@¢\u0006\u0003\u0010\u0097\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\r\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u000e\u0010\u0005\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0010\u0010\u0005\"\u000e\u0010\u0011\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0012\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0098\u0001²\u0006\n\u0010n\u001a\u00020*X\u008a\u008e\u0002"}, d2 = {"DatePickerHeadlinePadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "getDatePickerHorizontalPadding", "()F", "F", "DatePickerModeTogglePadding", "getDatePickerModeTogglePadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerTitlePadding", "MaxCalendarRows", "", "MonthYearHeight", "getMonthYearHeight", "RecommendedSizeForAccessibility", "getRecommendedSizeForAccessibility", "YearsInRow", "YearsVerticalPadding", "DateEntryContainer", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "modeToggleButton", "colors", "Landroidx/compose/material3/DatePickerColors;", "headlineTextStyle", "Landroidx/compose/ui/text/TextStyle;", "headerMinHeight", "content", "DateEntryContainer-au3_HiA", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DatePicker", "state", "Landroidx/compose/material3/DatePickerState;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "showModeToggle", "", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DatePickerContent", "selectedDateMillis", "", "displayedMonthMillis", "onDateSelectionChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "dateInMillis", "onDisplayedMonthChange", "monthInMillis", "calendarModel", "Landroidx/compose/material3/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "(Ljava/lang/Long;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DatePickerHeader", "titleContentColor", "Landroidx/compose/ui/graphics/Color;", "headlineContentColor", "minHeight", "DatePickerHeader-pc5RIQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DatePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "initialSelectedDateMillis", "initialDisplayedMonthMillis", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "DatePickerState-sHin3Bw", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DatePickerState;", "Day", "selected", "onClick", "animateChecked", "enabled", "today", "inRange", "description", "", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;ZZZZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DisplayModeToggleButton", "displayMode", "onDisplayModeChange", "DisplayModeToggleButton-tER2X8s", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "HorizontalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "Month", "month", "Landroidx/compose/material3/CalendarMonth;", "todayMillis", "startDateMillis", "endDateMillis", "rangeSelectionInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "(Landroidx/compose/material3/CalendarMonth;Lkotlin/jvm/functions/Function1;JLjava/lang/Long;Ljava/lang/Long;Landroidx/compose/material3/SelectedRangeInfo;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "MonthsNavigation", "nextAvailable", "previousAvailable", "yearPickerVisible", "yearPickerText", "onNextClicked", "onPreviousClicked", "onYearPickerButtonClicked", "(Landroidx/compose/ui/Modifier;ZZZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "SwitchableDateEntryContent-d7iavvg", "(Ljava/lang/Long;JILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "WeekDays", "(Landroidx/compose/material3/DatePickerColors;Landroidx/compose/material3/CalendarModel;Landroidx/compose/runtime/Composer;I)V", "Year", "currentYear", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function0;ZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "YearPicker", "onYearSelected", "year", "(Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "YearPickerMenuButton", "expanded", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "scrollDownLabel", "dayContentDescription", "rangeSelectionEnabled", "isToday", "isStartDate", "isEndDate", "isInRange", "(ZZZZZLandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "numberOfMonthsInRange", "rememberDatePickerState", "rememberDatePickerState-EU0dCGE", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "updateDisplayedMonth", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class DatePickerKt {
    private static final PaddingValues DatePickerHeadlinePadding;
    private static final float DatePickerHorizontalPadding;
    private static final PaddingValues DatePickerModeTogglePadding;
    private static final PaddingValues DatePickerTitlePadding;
    private static final int MaxCalendarRows = 6;
    private static final int YearsInRow = 3;
    private static final float YearsVerticalPadding;
    private static final float RecommendedSizeForAccessibility = Dp.constructor-impl(48);
    private static final float MonthYearHeight = Dp.constructor-impl(56);

    /* JADX WARN: Removed duplicated region for block: B:100:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DatePicker(final DatePickerState datePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z, DatePickerColors datePickerColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i6;
        boolean z2;
        final DatePickerColors datePickerColors2;
        final DatePickerFormatter datePickerFormatter2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        boolean changed;
        Object rememberedValue;
        DatePickerFormatter datePickerFormatter3;
        final Modifier modifier3;
        final boolean z3;
        final DatePickerColors datePickerColors3;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(809701813);
        ComposerKt.sourceInformation(startRestartGroup, "C(DatePicker)P(5,3,1,6,2,4)154@7440L47,170@8108L8,172@8145L15,173@8185L62,189@8801L10,174@8252L1391:DatePicker.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(datePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    if ((i & Fields.RotationY) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter)) {
                        i8 = Fields.RotationX;
                        i3 |= i8;
                    }
                }
                i8 = Fields.SpotShadowColor;
                i3 |= i8;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                function23 = function2;
                i3 |= startRestartGroup.changedInstance(function23) ? Fields.CameraDistance : Fields.RotationZ;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    function24 = function22;
                    i3 |= startRestartGroup.changedInstance(function24) ? Fields.Clip : Fields.Shape;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= 196608;
                    } else if ((196608 & i) == 0) {
                        z2 = z;
                        i3 |= startRestartGroup.changed(z2) ? Fields.RenderEffect : 65536;
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                datePickerColors2 = datePickerColors;
                                if (startRestartGroup.changed(datePickerColors2)) {
                                    i7 = 1048576;
                                    i3 |= i7;
                                }
                            } else {
                                datePickerColors2 = datePickerColors;
                            }
                            i7 = Fields.BlendMode;
                            i3 |= i7;
                        } else {
                            datePickerColors2 = datePickerColors;
                        }
                        if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i9 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i2 & 4) != 0) {
                                    startRestartGroup.startReplaceableGroup(1809358065);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    datePickerFormatter2 = (DatePickerFormatter) rememberedValue2;
                                    startRestartGroup.endReplaceableGroup();
                                    i3 &= -897;
                                } else {
                                    datePickerFormatter2 = datePickerFormatter;
                                }
                                if (i4 != 0) {
                                    function23 = ComposableLambdaKt.composableLambda(startRestartGroup, -1504998463, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$2
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i10) {
                                            PaddingValues paddingValues;
                                            ComposerKt.sourceInformation(composer2, "C156@7557L135:DatePicker.kt#uh7d8r");
                                            if ((i10 & 3) != 2 || !composer2.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1504998463, i10, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:156)");
                                                }
                                                DatePickerDefaults datePickerDefaults = DatePickerDefaults.INSTANCE;
                                                int mo2499getDisplayModejFl4v0 = DatePickerState.this.mo2499getDisplayModejFl4v0();
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                paddingValues = DatePickerKt.DatePickerTitlePadding;
                                                datePickerDefaults.m2468DatePickerTitlehOD91z4(mo2499getDisplayModejFl4v0, PaddingKt.padding(companion, paddingValues), composer2, 432, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer2.skipToGroupEnd();
                                        }
                                    });
                                }
                                if (i5 != 0) {
                                    function24 = ComposableLambdaKt.composableLambda(startRestartGroup, -1780043561, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$3
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i10) {
                                            PaddingValues paddingValues;
                                            ComposerKt.sourceInformation(composer2, "C162@7771L243:DatePicker.kt#uh7d8r");
                                            if ((i10 & 3) != 2 || !composer2.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1780043561, i10, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:162)");
                                                }
                                                DatePickerDefaults datePickerDefaults = DatePickerDefaults.INSTANCE;
                                                Long selectedDateMillis = DatePickerState.this.getSelectedDateMillis();
                                                int mo2499getDisplayModejFl4v0 = DatePickerState.this.mo2499getDisplayModejFl4v0();
                                                DatePickerFormatter datePickerFormatter4 = datePickerFormatter2;
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                paddingValues = DatePickerKt.DatePickerHeadlinePadding;
                                                datePickerDefaults.m2467DatePickerHeadline3kbWawI(selectedDateMillis, mo2499getDisplayModejFl4v0, datePickerFormatter4, PaddingKt.padding(companion, paddingValues), composer2, 27648, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer2.skipToGroupEnd();
                                        }
                                    });
                                }
                                if (i6 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    datePickerColors2 = DatePickerDefaults.INSTANCE.colors(startRestartGroup, 6);
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                datePickerFormatter2 = datePickerFormatter;
                            }
                            function25 = function24;
                            boolean z4 = z2;
                            Function2<? super Composer, ? super Integer, Unit> function26 = function23;
                            int i10 = i3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(809701813, i10, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:171)");
                            }
                            Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(1809358810);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                            changed = startRestartGroup.changed(defaultLocale);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            final CalendarModel calendarModel = (CalendarModel) rememberedValue;
                            startRestartGroup.endReplaceableGroup();
                            int i11 = ((i10 >> 3) & 14) | 14155776;
                            int i12 = i10 >> 6;
                            DatePickerColors datePickerColors4 = datePickerColors2;
                            m2472DateEntryContainerau3_HiA(modifier2, function26, function25, z4 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1982226759, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    ComposerKt.sourceInformation(composer2, "C183@8630L50,180@8432L267:DatePicker.kt#uh7d8r");
                                    if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1982226759, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:180)");
                                        }
                                        Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                                        int mo2499getDisplayModejFl4v0 = DatePickerState.this.mo2499getDisplayModejFl4v0();
                                        composer2.startReplaceableGroup(-1036920264);
                                        ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                                        boolean changed2 = composer2.changed(DatePickerState.this);
                                        final DatePickerState datePickerState2 = DatePickerState.this;
                                        Object rememberedValue3 = composer2.rememberedValue();
                                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(1);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                    m2480invokevCnGnXg(((DisplayMode) obj).getValue());
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                                public final void m2480invokevCnGnXg(int i14) {
                                                    DatePickerState.this.mo2500setDisplayModevCnGnXg(i14);
                                                }
                                            };
                                            composer2.updateRememberedValue(rememberedValue3);
                                        }
                                        composer2.endReplaceableGroup();
                                        DatePickerKt.m2476DisplayModeToggleButtontER2X8s(padding, mo2499getDisplayModejFl4v0, (Function1) rememberedValue3, composer2, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }) : null, datePickerColors2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont()), DatePickerModalTokens.INSTANCE.m3547getHeaderContainerHeightD9Ej5fM(), ComposableLambdaKt.composableLambda(startRestartGroup, -1840727866, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    ComposerKt.sourceInformation(composer2, "C199@9229L59,200@9327L91,195@8998L639:DatePicker.kt#uh7d8r");
                                    if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1840727866, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:195)");
                                        }
                                        Long selectedDateMillis = DatePickerState.this.getSelectedDateMillis();
                                        long displayedMonthMillis = DatePickerState.this.getDisplayedMonthMillis();
                                        int mo2499getDisplayModejFl4v0 = DatePickerState.this.mo2499getDisplayModejFl4v0();
                                        composer2.startReplaceableGroup(-1036919665);
                                        ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                                        boolean changed2 = composer2.changed(DatePickerState.this);
                                        final DatePickerState datePickerState2 = DatePickerState.this;
                                        Object rememberedValue3 = composer2.rememberedValue();
                                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(1);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                    invoke((Long) obj);
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Long l) {
                                                    DatePickerState.this.setSelectedDateMillis(l);
                                                }
                                            };
                                            composer2.updateRememberedValue(rememberedValue3);
                                        }
                                        Function1 function1 = (Function1) rememberedValue3;
                                        composer2.endReplaceableGroup();
                                        composer2.startReplaceableGroup(-1036919567);
                                        ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                                        boolean changed3 = composer2.changed(DatePickerState.this);
                                        final DatePickerState datePickerState3 = DatePickerState.this;
                                        Object rememberedValue4 = composer2.rememberedValue();
                                        if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$2$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(1);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                    invoke(((Number) obj).longValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(long j) {
                                                    DatePickerState.this.setDisplayedMonthMillis(j);
                                                }
                                            };
                                            composer2.updateRememberedValue(rememberedValue4);
                                        }
                                        composer2.endReplaceableGroup();
                                        DatePickerKt.m2477SwitchableDateEntryContentd7iavvg(selectedDateMillis, displayedMonthMillis, mo2499getDisplayModejFl4v0, function1, (Function1) rememberedValue4, calendarModel, DatePickerState.this.getYearRange(), datePickerFormatter2, DatePickerState.this.getSelectableDates(), datePickerColors2, composer2, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), startRestartGroup, i11 | (i12 & 112) | (i12 & 896) | (i12 & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function23 = function26;
                            datePickerFormatter3 = datePickerFormatter2;
                            modifier3 = modifier2;
                            z3 = z4;
                            datePickerColors3 = datePickerColors4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            datePickerFormatter3 = datePickerFormatter;
                            modifier3 = modifier2;
                            function25 = function24;
                            z3 = z2;
                            datePickerColors3 = datePickerColors2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final DatePickerFormatter datePickerFormatter4 = datePickerFormatter3;
                            final Function2<? super Composer, ? super Integer, Unit> function27 = function23;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$6
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
                                    DatePickerKt.DatePicker(DatePickerState.this, modifier3, datePickerFormatter4, function27, function25, z3, datePickerColors3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    z2 = z;
                    if ((1572864 & i) == 0) {
                    }
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i2 & 4) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    function25 = function24;
                    boolean z42 = z2;
                    Function2<? super Composer, ? super Integer, Unit> function262 = function23;
                    int i102 = i3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Locale defaultLocale2 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(1809358810);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                    changed = startRestartGroup.changed(defaultLocale2);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale2);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    final CalendarModel calendarModel2 = (CalendarModel) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    int i112 = ((i102 >> 3) & 14) | 14155776;
                    int i122 = i102 >> 6;
                    DatePickerColors datePickerColors42 = datePickerColors2;
                    m2472DateEntryContainerau3_HiA(modifier2, function262, function25, z42 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1982226759, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            ComposerKt.sourceInformation(composer2, "C183@8630L50,180@8432L267:DatePicker.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1982226759, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:180)");
                                }
                                Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                                int mo2499getDisplayModejFl4v0 = DatePickerState.this.mo2499getDisplayModejFl4v0();
                                composer2.startReplaceableGroup(-1036920264);
                                ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                                boolean changed2 = composer2.changed(DatePickerState.this);
                                final DatePickerState datePickerState2 = DatePickerState.this;
                                Object rememberedValue3 = composer2.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            m2480invokevCnGnXg(((DisplayMode) obj).getValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                        public final void m2480invokevCnGnXg(int i14) {
                                            DatePickerState.this.mo2500setDisplayModevCnGnXg(i14);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue3);
                                }
                                composer2.endReplaceableGroup();
                                DatePickerKt.m2476DisplayModeToggleButtontER2X8s(padding, mo2499getDisplayModejFl4v0, (Function1) rememberedValue3, composer2, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }) : null, datePickerColors2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont()), DatePickerModalTokens.INSTANCE.m3547getHeaderContainerHeightD9Ej5fM(), ComposableLambdaKt.composableLambda(startRestartGroup, -1840727866, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            ComposerKt.sourceInformation(composer2, "C199@9229L59,200@9327L91,195@8998L639:DatePicker.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1840727866, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:195)");
                                }
                                Long selectedDateMillis = DatePickerState.this.getSelectedDateMillis();
                                long displayedMonthMillis = DatePickerState.this.getDisplayedMonthMillis();
                                int mo2499getDisplayModejFl4v0 = DatePickerState.this.mo2499getDisplayModejFl4v0();
                                composer2.startReplaceableGroup(-1036919665);
                                ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                                boolean changed2 = composer2.changed(DatePickerState.this);
                                final DatePickerState datePickerState2 = DatePickerState.this;
                                Object rememberedValue3 = composer2.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Long) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Long l) {
                                            DatePickerState.this.setSelectedDateMillis(l);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue3);
                                }
                                Function1 function1 = (Function1) rememberedValue3;
                                composer2.endReplaceableGroup();
                                composer2.startReplaceableGroup(-1036919567);
                                ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                                boolean changed3 = composer2.changed(DatePickerState.this);
                                final DatePickerState datePickerState3 = DatePickerState.this;
                                Object rememberedValue4 = composer2.rememberedValue();
                                if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$2$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke(((Number) obj).longValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(long j) {
                                            DatePickerState.this.setDisplayedMonthMillis(j);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue4);
                                }
                                composer2.endReplaceableGroup();
                                DatePickerKt.m2477SwitchableDateEntryContentd7iavvg(selectedDateMillis, displayedMonthMillis, mo2499getDisplayModejFl4v0, function1, (Function1) rememberedValue4, calendarModel2, DatePickerState.this.getYearRange(), datePickerFormatter2, DatePickerState.this.getSelectableDates(), datePickerColors2, composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, i112 | (i122 & 112) | (i122 & 896) | (i122 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function23 = function262;
                    datePickerFormatter3 = datePickerFormatter2;
                    modifier3 = modifier2;
                    z3 = z42;
                    datePickerColors3 = datePickerColors42;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function24 = function22;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                z2 = z;
                if ((1572864 & i) == 0) {
                }
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                function25 = function24;
                boolean z422 = z2;
                Function2<? super Composer, ? super Integer, Unit> function2622 = function23;
                int i1022 = i3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Locale defaultLocale22 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(1809358810);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                changed = startRestartGroup.changed(defaultLocale22);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale22);
                startRestartGroup.updateRememberedValue(rememberedValue);
                final CalendarModel calendarModel22 = (CalendarModel) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                int i1122 = ((i1022 >> 3) & 14) | 14155776;
                int i1222 = i1022 >> 6;
                DatePickerColors datePickerColors422 = datePickerColors2;
                m2472DateEntryContainerau3_HiA(modifier2, function2622, function25, z422 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1982226759, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        ComposerKt.sourceInformation(composer2, "C183@8630L50,180@8432L267:DatePicker.kt#uh7d8r");
                        if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1982226759, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:180)");
                            }
                            Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                            int mo2499getDisplayModejFl4v0 = DatePickerState.this.mo2499getDisplayModejFl4v0();
                            composer2.startReplaceableGroup(-1036920264);
                            ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                            boolean changed2 = composer2.changed(DatePickerState.this);
                            final DatePickerState datePickerState2 = DatePickerState.this;
                            Object rememberedValue3 = composer2.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        m2480invokevCnGnXg(((DisplayMode) obj).getValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                    public final void m2480invokevCnGnXg(int i14) {
                                        DatePickerState.this.mo2500setDisplayModevCnGnXg(i14);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue3);
                            }
                            composer2.endReplaceableGroup();
                            DatePickerKt.m2476DisplayModeToggleButtontER2X8s(padding, mo2499getDisplayModejFl4v0, (Function1) rememberedValue3, composer2, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }) : null, datePickerColors2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont()), DatePickerModalTokens.INSTANCE.m3547getHeaderContainerHeightD9Ej5fM(), ComposableLambdaKt.composableLambda(startRestartGroup, -1840727866, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        ComposerKt.sourceInformation(composer2, "C199@9229L59,200@9327L91,195@8998L639:DatePicker.kt#uh7d8r");
                        if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1840727866, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:195)");
                            }
                            Long selectedDateMillis = DatePickerState.this.getSelectedDateMillis();
                            long displayedMonthMillis = DatePickerState.this.getDisplayedMonthMillis();
                            int mo2499getDisplayModejFl4v0 = DatePickerState.this.mo2499getDisplayModejFl4v0();
                            composer2.startReplaceableGroup(-1036919665);
                            ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                            boolean changed2 = composer2.changed(DatePickerState.this);
                            final DatePickerState datePickerState2 = DatePickerState.this;
                            Object rememberedValue3 = composer2.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Long) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Long l) {
                                        DatePickerState.this.setSelectedDateMillis(l);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue3);
                            }
                            Function1 function1 = (Function1) rememberedValue3;
                            composer2.endReplaceableGroup();
                            composer2.startReplaceableGroup(-1036919567);
                            ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                            boolean changed3 = composer2.changed(DatePickerState.this);
                            final DatePickerState datePickerState3 = DatePickerState.this;
                            Object rememberedValue4 = composer2.rememberedValue();
                            if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).longValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(long j) {
                                        DatePickerState.this.setDisplayedMonthMillis(j);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue4);
                            }
                            composer2.endReplaceableGroup();
                            DatePickerKt.m2477SwitchableDateEntryContentd7iavvg(selectedDateMillis, displayedMonthMillis, mo2499getDisplayModejFl4v0, function1, (Function1) rememberedValue4, calendarModel22, DatePickerState.this.getYearRange(), datePickerFormatter2, DatePickerState.this.getSelectableDates(), datePickerColors2, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, i1122 | (i1222 & 112) | (i1222 & 896) | (i1222 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                function23 = function2622;
                datePickerFormatter3 = datePickerFormatter2;
                modifier3 = modifier2;
                z3 = z422;
                datePickerColors3 = datePickerColors422;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function23 = function2;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function24 = function22;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            z2 = z;
            if ((1572864 & i) == 0) {
            }
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            function25 = function24;
            boolean z4222 = z2;
            Function2<? super Composer, ? super Integer, Unit> function26222 = function23;
            int i10222 = i3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Locale defaultLocale222 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1809358810);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            changed = startRestartGroup.changed(defaultLocale222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale222);
            startRestartGroup.updateRememberedValue(rememberedValue);
            final CalendarModel calendarModel222 = (CalendarModel) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            int i11222 = ((i10222 >> 3) & 14) | 14155776;
            int i12222 = i10222 >> 6;
            DatePickerColors datePickerColors4222 = datePickerColors2;
            m2472DateEntryContainerau3_HiA(modifier2, function26222, function25, z4222 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1982226759, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    ComposerKt.sourceInformation(composer2, "C183@8630L50,180@8432L267:DatePicker.kt#uh7d8r");
                    if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1982226759, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:180)");
                        }
                        Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                        int mo2499getDisplayModejFl4v0 = DatePickerState.this.mo2499getDisplayModejFl4v0();
                        composer2.startReplaceableGroup(-1036920264);
                        ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                        boolean changed2 = composer2.changed(DatePickerState.this);
                        final DatePickerState datePickerState2 = DatePickerState.this;
                        Object rememberedValue3 = composer2.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    m2480invokevCnGnXg(((DisplayMode) obj).getValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                public final void m2480invokevCnGnXg(int i14) {
                                    DatePickerState.this.mo2500setDisplayModevCnGnXg(i14);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue3);
                        }
                        composer2.endReplaceableGroup();
                        DatePickerKt.m2476DisplayModeToggleButtontER2X8s(padding, mo2499getDisplayModejFl4v0, (Function1) rememberedValue3, composer2, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }) : null, datePickerColors2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont()), DatePickerModalTokens.INSTANCE.m3547getHeaderContainerHeightD9Ej5fM(), ComposableLambdaKt.composableLambda(startRestartGroup, -1840727866, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    ComposerKt.sourceInformation(composer2, "C199@9229L59,200@9327L91,195@8998L639:DatePicker.kt#uh7d8r");
                    if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1840727866, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:195)");
                        }
                        Long selectedDateMillis = DatePickerState.this.getSelectedDateMillis();
                        long displayedMonthMillis = DatePickerState.this.getDisplayedMonthMillis();
                        int mo2499getDisplayModejFl4v0 = DatePickerState.this.mo2499getDisplayModejFl4v0();
                        composer2.startReplaceableGroup(-1036919665);
                        ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                        boolean changed2 = composer2.changed(DatePickerState.this);
                        final DatePickerState datePickerState2 = DatePickerState.this;
                        Object rememberedValue3 = composer2.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Long) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Long l) {
                                    DatePickerState.this.setSelectedDateMillis(l);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue3);
                        }
                        Function1 function1 = (Function1) rememberedValue3;
                        composer2.endReplaceableGroup();
                        composer2.startReplaceableGroup(-1036919567);
                        ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                        boolean changed3 = composer2.changed(DatePickerState.this);
                        final DatePickerState datePickerState3 = DatePickerState.this;
                        Object rememberedValue4 = composer2.rememberedValue();
                        if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).longValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(long j) {
                                    DatePickerState.this.setDisplayedMonthMillis(j);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue4);
                        }
                        composer2.endReplaceableGroup();
                        DatePickerKt.m2477SwitchableDateEntryContentd7iavvg(selectedDateMillis, displayedMonthMillis, mo2499getDisplayModejFl4v0, function1, (Function1) rememberedValue4, calendarModel222, DatePickerState.this.getYearRange(), datePickerFormatter2, DatePickerState.this.getSelectableDates(), datePickerColors2, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, i11222 | (i12222 & 112) | (i12222 & 896) | (i12222 & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            function23 = function26222;
            datePickerFormatter3 = datePickerFormatter2;
            modifier3 = modifier2;
            z3 = z4222;
            datePickerColors3 = datePickerColors4222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) == 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function23 = function2;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function24 = function22;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        z2 = z;
        if ((1572864 & i) == 0) {
        }
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        function25 = function24;
        boolean z42222 = z2;
        Function2<? super Composer, ? super Integer, Unit> function262222 = function23;
        int i102222 = i3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Locale defaultLocale2222 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(1809358810);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
        changed = startRestartGroup.changed(defaultLocale2222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale2222);
        startRestartGroup.updateRememberedValue(rememberedValue);
        final CalendarModel calendarModel2222 = (CalendarModel) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        int i112222 = ((i102222 >> 3) & 14) | 14155776;
        int i122222 = i102222 >> 6;
        DatePickerColors datePickerColors42222 = datePickerColors2;
        m2472DateEntryContainerau3_HiA(modifier2, function262222, function25, z42222 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1982226759, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i13) {
                ComposerKt.sourceInformation(composer2, "C183@8630L50,180@8432L267:DatePicker.kt#uh7d8r");
                if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1982226759, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:180)");
                    }
                    Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                    int mo2499getDisplayModejFl4v0 = DatePickerState.this.mo2499getDisplayModejFl4v0();
                    composer2.startReplaceableGroup(-1036920264);
                    ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                    boolean changed2 = composer2.changed(DatePickerState.this);
                    final DatePickerState datePickerState2 = DatePickerState.this;
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                m2480invokevCnGnXg(((DisplayMode) obj).getValue());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                            public final void m2480invokevCnGnXg(int i14) {
                                DatePickerState.this.mo2500setDisplayModevCnGnXg(i14);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    DatePickerKt.m2476DisplayModeToggleButtontER2X8s(padding, mo2499getDisplayModejFl4v0, (Function1) rememberedValue3, composer2, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }) : null, datePickerColors2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont()), DatePickerModalTokens.INSTANCE.m3547getHeaderContainerHeightD9Ej5fM(), ComposableLambdaKt.composableLambda(startRestartGroup, -1840727866, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i13) {
                ComposerKt.sourceInformation(composer2, "C199@9229L59,200@9327L91,195@8998L639:DatePicker.kt#uh7d8r");
                if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1840727866, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:195)");
                    }
                    Long selectedDateMillis = DatePickerState.this.getSelectedDateMillis();
                    long displayedMonthMillis = DatePickerState.this.getDisplayedMonthMillis();
                    int mo2499getDisplayModejFl4v0 = DatePickerState.this.mo2499getDisplayModejFl4v0();
                    composer2.startReplaceableGroup(-1036919665);
                    ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                    boolean changed2 = composer2.changed(DatePickerState.this);
                    final DatePickerState datePickerState2 = DatePickerState.this;
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Long) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Long l) {
                                DatePickerState.this.setSelectedDateMillis(l);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    Function1 function1 = (Function1) rememberedValue3;
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(-1036919567);
                    ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                    boolean changed3 = composer2.changed(DatePickerState.this);
                    final DatePickerState datePickerState3 = DatePickerState.this;
                    Object rememberedValue4 = composer2.rememberedValue();
                    if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).longValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(long j) {
                                DatePickerState.this.setDisplayedMonthMillis(j);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue4);
                    }
                    composer2.endReplaceableGroup();
                    DatePickerKt.m2477SwitchableDateEntryContentd7iavvg(selectedDateMillis, displayedMonthMillis, mo2499getDisplayModejFl4v0, function1, (Function1) rememberedValue4, calendarModel2222, DatePickerState.this.getYearRange(), datePickerFormatter2, DatePickerState.this.getSelectableDates(), datePickerColors2, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, i112222 | (i122222 & 112) | (i122222 & 896) | (i122222 & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        function23 = function262222;
        datePickerFormatter3 = datePickerFormatter2;
        modifier3 = modifier2;
        z3 = z42222;
        datePickerColors3 = datePickerColors42222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00dd, code lost:
    
        if (r1 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L60;
     */
    /* renamed from: rememberDatePickerState-EU0dCGE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final DatePickerState m2479rememberDatePickerStateEU0dCGE(Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, Composer composer, int i2, int i3) {
        Object obj;
        composer.startReplaceableGroup(2065763010);
        ComposerKt.sourceInformation(composer, "C(rememberDatePickerState)P(2,1,4,0:c#material3.DisplayMode)364@14941L15,367@15059L347,365@14968L438:DatePicker.kt#uh7d8r");
        final Long l3 = (i3 & 1) != 0 ? null : l;
        final Long l4 = (i3 & 2) != 0 ? l3 : l2;
        final IntRange yearRange = (i3 & 4) != 0 ? DatePickerDefaults.INSTANCE.getYearRange() : intRange;
        final int m2537getPickerjFl4v0 = (i3 & 8) != 0 ? DisplayMode.INSTANCE.m2537getPickerjFl4v0() : i;
        final SelectableDates allDates = (i3 & 16) != 0 ? DatePickerDefaults.INSTANCE.getAllDates() : selectableDates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2065763010, i2, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.kt:363)");
        }
        final Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(composer, 0);
        Object[] objArr = new Object[0];
        Saver<DatePickerStateImpl, Object> Saver = DatePickerStateImpl.INSTANCE.Saver(allDates, defaultLocale);
        composer.startReplaceableGroup(-1398082866);
        ComposerKt.sourceInformation(composer, "CC(remember):DatePicker.kt#9igjgp");
        boolean changedInstance = ((((i2 & 14) ^ 6) > 4 && composer.changed(l3)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(l4)) || (i2 & 48) == 32) | composer.changedInstance(yearRange) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(m2537getPickerjFl4v0)) || (i2 & 3072) == 2048) | ((((57344 & i2) ^ 24576) > 16384 && composer.changed(allDates)) || (i2 & 24576) == 16384) | composer.changedInstance(defaultLocale);
        Object rememberedValue = composer.rememberedValue();
        if (!changedInstance) {
            obj = rememberedValue;
        }
        Object obj2 = (Function0) new Function0<DatePickerStateImpl>() { // from class: androidx.compose.material3.DatePickerKt$rememberDatePickerState$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final DatePickerStateImpl m2497invoke() {
                return new DatePickerStateImpl(l3, l4, yearRange, m2537getPickerjFl4v0, allDates, defaultLocale, null);
            }
        };
        composer.updateRememberedValue(obj2);
        obj = obj2;
        composer.endReplaceableGroup();
        DatePickerStateImpl datePickerStateImpl = (DatePickerStateImpl) RememberSaveableKt.m4241rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) obj, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return datePickerStateImpl;
    }

    /* renamed from: DatePickerState-sHin3Bw$default, reason: not valid java name */
    public static /* synthetic */ DatePickerState m2475DatePickerStatesHin3Bw$default(Locale locale, Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        Long l3 = (i2 & 4) != 0 ? l : l2;
        if ((i2 & 8) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        IntRange intRange2 = intRange;
        if ((i2 & 16) != 0) {
            i = DisplayMode.INSTANCE.m2537getPickerjFl4v0();
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        return m2474DatePickerStatesHin3Bw(locale, l, l3, intRange2, i3, selectableDates);
    }

    /* renamed from: DatePickerState-sHin3Bw, reason: not valid java name */
    public static final DatePickerState m2474DatePickerStatesHin3Bw(Locale locale, Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates) {
        return new DatePickerStateImpl(l, l2, intRange, i, selectableDates, locale, null);
    }

    /* renamed from: DateEntryContainer-au3_HiA, reason: not valid java name */
    public static final void m2472DateEntryContainerau3_HiA(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final DatePickerColors datePickerColors, final TextStyle textStyle, final float f, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1507356255);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateEntryContainer)P(6,7,3,5!1,4,2:c#ui.unit.Dp)1303@58682L1716:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(textStyle) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(f) ? 1048576 : Fields.BlendMode;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1507356255, i2, -1, "androidx.compose.material3.DateEntryContainer (DatePicker.kt:1302)");
            }
            Modifier semantics$default = SemanticsModifierKt.semantics$default(SizeKt.m1124sizeInqDBjuR0$default(modifier, DatePickerModalTokens.INSTANCE.m3541getContainerWidthD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                }
            }, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(semantics$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -916065881, "C1311@58918L1456,1344@60383L9:DatePicker.kt#uh7d8r");
            m2473DatePickerHeaderpc5RIQQ(Modifier.INSTANCE, function2, datePickerColors.getTitleContentColor(), datePickerColors.getHeadlineContentColor(), f, ComposableLambdaKt.composableLambda(startRestartGroup, -229007058, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$2$1
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

                public final void invoke(Composer composer2, int i3) {
                    Arrangement.HorizontalOrVertical end;
                    ComposerKt.sourceInformation(composer2, "C1318@59182L1182:DatePicker.kt#uh7d8r");
                    if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-229007058, i3, -1, "androidx.compose.material3.DateEntryContainer.<anonymous>.<anonymous> (DatePicker.kt:1318)");
                        }
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        final Function2<Composer, Integer, Unit> function25 = function22;
                        Function2<Composer, Integer, Unit> function26 = function23;
                        Function2<Composer, Integer, Unit> function27 = function2;
                        DatePickerColors datePickerColors2 = datePickerColors;
                        TextStyle textStyle2 = textStyle;
                        composer2.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer2);
                        Updater.m4116setimpl(m4109constructorimpl2, columnMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1449826990, "C1324@59507L580:DatePicker.kt#uh7d8r");
                        if (function25 != null && function26 != null) {
                            end = Arrangement.INSTANCE.getSpaceBetween();
                        } else if (function25 != null) {
                            end = Arrangement.INSTANCE.getStart();
                        } else {
                            end = Arrangement.INSTANCE.getEnd();
                        }
                        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer2, 48);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                        Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default2);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor3);
                        } else {
                            composer2.useNode();
                        }
                        Composer m4109constructorimpl3 = Updater.m4109constructorimpl(composer2);
                        Updater.m4116setimpl(m4109constructorimpl3, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl3, currentCompositionLocalMap3, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl3.getInserting() || !Intrinsics.areEqual(m4109constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m4109constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m4109constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        modifierMaterializerOf3.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1011363262, "C:DatePicker.kt#uh7d8r");
                        composer2.startReplaceableGroup(-1011363262);
                        ComposerKt.sourceInformation(composer2, "1330@59790L210");
                        if (function25 != null) {
                            TextKt.ProvideTextStyle(textStyle2, ComposableLambdaKt.composableLambda(composer2, -962031352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$2$1$1$1$1
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

                                public final void invoke(Composer composer3, int i4) {
                                    ComposerKt.sourceInformation(composer3, "C1331@59864L110:DatePicker.kt#uh7d8r");
                                    if ((i4 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-962031352, i4, -1, "androidx.compose.material3.DateEntryContainer.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1331)");
                                        }
                                        Modifier weight$default = RowScope.weight$default(RowScope.this, Modifier.INSTANCE, 1.0f, false, 2, null);
                                        Function2<Composer, Integer, Unit> function28 = function25;
                                        composer3.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                                        Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(weight$default);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor4);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m4109constructorimpl4 = Updater.m4109constructorimpl(composer3);
                                        Updater.m4116setimpl(m4109constructorimpl4, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m4116setimpl(m4109constructorimpl4, currentCompositionLocalMap4, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m4109constructorimpl4.getInserting() || !Intrinsics.areEqual(m4109constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                            m4109constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                            m4109constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                        }
                                        modifierMaterializerOf4.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2128822724, "C1332@59934L10:DatePicker.kt#uh7d8r");
                                        function28.invoke(composer3, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 48);
                        }
                        composer2.endReplaceableGroup();
                        composer2.startReplaceableGroup(1449827808);
                        ComposerKt.sourceInformation(composer2, "1336@60061L8");
                        if (function26 != null) {
                            function26.invoke(composer2, 0);
                        }
                        composer2.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.startReplaceableGroup(1680523079);
                        ComposerKt.sourceInformation(composer2, "1340@60286L46");
                        if (function27 != null || function25 != null || function26 != null) {
                            DividerKt.m2540HorizontalDivider9IZ8Weo(null, 0.0f, datePickerColors2.getDividerColor(), composer2, 0, 3);
                        }
                        composer2.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, (i2 & 112) | 196614 | (57344 & (i2 >> 6)));
            function24.invoke(startRestartGroup, Integer.valueOf((i2 >> 21) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$3
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

                public final void invoke(Composer composer2, int i3) {
                    DatePickerKt.m2472DateEntryContainerau3_HiA(Modifier.this, function2, function22, function23, datePickerColors, textStyle, f, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* renamed from: DisplayModeToggleButton-tER2X8s, reason: not valid java name */
    public static final void m2476DisplayModeToggleButtontER2X8s(final Modifier modifier, final int i, final Function1<? super DisplayMode, Unit> function1, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer startRestartGroup = composer.startRestartGroup(1393846115);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisplayModeToggleButton)P(1,0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 256 : Fields.SpotShadowColor;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1393846115, i3, -1, "androidx.compose.material3.DisplayModeToggleButton (DatePicker.kt:1354)");
            }
            if (!DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2537getPickerjFl4v0())) {
                startRestartGroup.startReplaceableGroup(-1814955404);
                ComposerKt.sourceInformation(startRestartGroup, "1363@60955L43,1363@60934L271");
                startRestartGroup.startReplaceableGroup(-1814955373);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                z = (i3 & 896) == 256;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2486invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m2486invoke() {
                            function1.invoke(DisplayMode.m2529boximpl(DisplayMode.INSTANCE.m2537getPickerjFl4v0()));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                IconButtonKt.IconButton((Function0) rememberedValue, modifier, false, null, null, ComposableSingletons$DatePickerKt.INSTANCE.m2408getLambda2$material3_release(), startRestartGroup, ((i3 << 3) & 112) | 196608, 28);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-1814955688);
                ComposerKt.sourceInformation(startRestartGroup, "1356@60671L42,1356@60650L262");
                startRestartGroup.startReplaceableGroup(-1814955657);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                z = (i3 & 896) == 256;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2485invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m2485invoke() {
                            function1.invoke(DisplayMode.m2529boximpl(DisplayMode.INSTANCE.m2536getInputjFl4v0()));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                IconButtonKt.IconButton((Function0) rememberedValue2, modifier, false, null, null, ComposableSingletons$DatePickerKt.INSTANCE.m2407getLambda1$material3_release(), startRestartGroup, ((i3 << 3) & 112) | 196608, 28);
                startRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$3
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

                public final void invoke(Composer composer2, int i4) {
                    DatePickerKt.m2476DisplayModeToggleButtontER2X8s(Modifier.this, i, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: SwitchableDateEntryContent-d7iavvg, reason: not valid java name */
    public static final void m2477SwitchableDateEntryContentd7iavvg(final Long l, final long j, final int i, final Function1<? super Long, Unit> function1, final Function1<? super Long, Unit> function12, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-895379221);
        ComposerKt.sourceInformation(startRestartGroup, "C(SwitchableDateEntryContent)P(8,4,3:c#material3.DisplayMode,5,6!1,9,2,7)*1392@62001L7,1399@62233L1975,1393@62037L3206:DatePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(l) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changed(i) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i2 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i2 & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function12) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(calendarModel) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(intRange) ? 1048576 : Fields.BlendMode;
        }
        if ((12582912 & i2) == 0) {
            i3 |= (16777216 & i2) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            i3 |= startRestartGroup.changed(selectableDates) ? 67108864 : 33554432;
        }
        if ((805306368 & i2) == 0) {
            i3 |= startRestartGroup.changed(datePickerColors) ? 536870912 : 268435456;
        }
        int i4 = i3;
        if ((306783379 & i4) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-895379221, i4, -1, "androidx.compose.material3.SwitchableDateEntryContent (DatePicker.kt:1389)");
            }
            ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final int i5 = -((Density) consume).roundToPx-0680j_4(Dp.constructor-impl(48));
            DisplayMode m2529boximpl = DisplayMode.m2529boximpl(i);
            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                }
            }, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(1777156755);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean changed = startRestartGroup.changed(i5);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function1) new Function1<AnimatedContentTransitionScope<DisplayMode>, ContentTransform>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final ContentTransform invoke(AnimatedContentTransitionScope<DisplayMode> animatedContentTransitionScope) {
                        ContentTransform contentTransform;
                        if (DisplayMode.m2532equalsimpl0(animatedContentTransitionScope.getTargetState().getValue(), DisplayMode.INSTANCE.m2536getInputjFl4v0())) {
                            EnterTransition plus = EnterExitTransitionKt.slideInVertically$default(null, new Function1<Integer, Integer>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.1
                                public final Integer invoke(int i6) {
                                    return Integer.valueOf(i6);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke(((Number) obj).intValue());
                                }
                            }, 1, null).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(100, 100, null, 4, null), 0.0f, 2, null));
                            ExitTransition fadeOut$default = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, 2, null);
                            final int i6 = i5;
                            contentTransform = AnimatedContentKt.togetherWith(plus, fadeOut$default.plus(EnterExitTransitionKt.slideOutVertically$default(null, new Function1<Integer, Integer>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public final Integer invoke(int i7) {
                                    return Integer.valueOf(i6);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke(((Number) obj).intValue());
                                }
                            }, 1, null)));
                        } else {
                            TweenSpec tween$default = AnimationSpecKt.tween$default(0, 50, null, 5, null);
                            final int i7 = i5;
                            contentTransform = AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(tween$default, new Function1<Integer, Integer>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke(((Number) obj).intValue());
                                }

                                public final Integer invoke(int i8) {
                                    return Integer.valueOf(i7);
                                }
                            }).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(100, 100, null, 4, null), 0.0f, 2, null)), EnterExitTransitionKt.slideOutVertically$default(null, new Function1<Integer, Integer>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.4
                                public final Integer invoke(int i8) {
                                    return Integer.valueOf(i8);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke(((Number) obj).intValue());
                                }
                            }, 1, null).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, 2, null)));
                        }
                        return animatedContentTransitionScope.using(contentTransform, AnimatedContentKt.SizeTransform(true, new Function2<IntSize, IntSize, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.5
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m2490invokeTemP2vQ(((IntSize) obj).unbox-impl(), ((IntSize) obj2).unbox-impl());
                            }

                            /* renamed from: invoke-TemP2vQ, reason: not valid java name */
                            public final FiniteAnimationSpec<IntSize> m2490invokeTemP2vQ(long j2, long j3) {
                                return AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier(), 2, null);
                            }
                        }));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            AnimatedContentKt.AnimatedContent(m2529boximpl, semantics$default, (Function1) rememberedValue, null, "DatePickerDisplayModeAnimation", null, ComposableLambdaKt.composableLambda(startRestartGroup, -459778869, true, new Function4<AnimatedContentScope, DisplayMode, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    m2491invokefYndouo((AnimatedContentScope) obj, ((DisplayMode) obj2).getValue(), (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-fYndouo, reason: not valid java name */
                public final void m2491invokefYndouo(AnimatedContentScope animatedContentScope, int i6, Composer composer2, int i7) {
                    ComposerKt.sourceInformation(composer2, "CP(0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-459778869, i7, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DatePicker.kt:1439)");
                    }
                    if (DisplayMode.m2532equalsimpl0(i6, DisplayMode.INSTANCE.m2537getPickerjFl4v0())) {
                        composer2.startReplaceableGroup(-1168710170);
                        ComposerKt.sourceInformation(composer2, "1440@64331L494");
                        DatePickerKt.DatePickerContent(l, j, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer2, 0);
                        composer2.endReplaceableGroup();
                    } else if (DisplayMode.m2532equalsimpl0(i6, DisplayMode.INSTANCE.m2536getInputjFl4v0())) {
                        composer2.startReplaceableGroup(-1168709641);
                        ComposerKt.sourceInformation(composer2, "1452@64860L367");
                        DateInputKt.DateInputContent(l, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer2, 0);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(-1168709264);
                        composer2.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, ((i4 >> 6) & 14) | 1597440, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$4
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

                public final void invoke(Composer composer2, int i6) {
                    DatePickerKt.m2477SwitchableDateEntryContentd7iavvg(l, j, i, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02a2, code lost:
    
        if (r4 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02cf, code lost:
    
        if (r3 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x026e, code lost:
    
        if (r3 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L102;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DatePickerContent(final Long l, final long j, final Function1<? super Long, Unit> function1, final Function1<? super Long, Unit> function12, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        String str;
        Object obj;
        Object obj2;
        Object obj3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-434467002);
        ComposerKt.sourceInformation(startRestartGroup, "C(DatePickerContent)P(7,3,4,5!1,8,2,6)1480@65783L87,1481@65896L24,1482@65950L42,1483@66017L15,1484@66037L4988:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(l) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function12) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= (2097152 & i) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 1048576 : Fields.BlendMode;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changed(selectableDates) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? 67108864 : 33554432;
        }
        int i3 = i2;
        if ((38347923 & i3) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-434467002, i3, -1, "androidx.compose.material3.DatePickerContent (DatePicker.kt:1477)");
            }
            final CalendarMonth month = calendarModel.getMonth(j);
            final LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(month.indexIn(intRange), 0, startRestartGroup, 0, 2);
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) RememberSaveableKt.m4241rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<Boolean>>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$yearPickerVisible$2
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final MutableState<Boolean> m2484invoke() {
                    MutableState<Boolean> mutableStateOf$default;
                    mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    return mutableStateOf$default;
                }
            }, startRestartGroup, 3072, 6);
            Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -269657363, "C1494@66536L511,1506@67081L520,1518@67643L42,1485@66054L1670,1522@67734L3285:DatePicker.kt#uh7d8r");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f = DatePickerHorizontalPadding;
            Modifier m1066paddingVpY3zN4$default = PaddingKt.m1066paddingVpY3zN4$default(companion2, f, 0.0f, 2, null);
            boolean canScrollForward = rememberLazyListState.getCanScrollForward();
            boolean canScrollBackward = rememberLazyListState.getCanScrollBackward();
            boolean DatePickerContent$lambda$8 = DatePickerContent$lambda$8(mutableState);
            String formatMonthYear = datePickerFormatter.formatMonthYear(Long.valueOf(j), defaultLocale);
            if (formatMonthYear == null) {
                formatMonthYear = "-";
            }
            String str2 = formatMonthYear;
            startRestartGroup.startReplaceableGroup(-269656881);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changed(rememberLazyListState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance) {
                str = "C79@3979L9:Column.kt#2w3rfo";
            } else {
                str = "C79@3979L9:Column.kt#2w3rfo";
                obj = rememberedValue2;
            }
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: DatePicker.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$1$1$1$1", f = "DatePicker.kt", i = {}, l = {1498}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$1$1$1$1 */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                public static final class C05961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ LazyListState $monthsListState;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C05961(LazyListState lazyListState, Continuation<? super C05961> continuation) {
                        super(2, continuation);
                        this.$monthsListState = lazyListState;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C05961(this.$monthsListState, continuation);
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        try {
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                LazyListState lazyListState = this.$monthsListState;
                                this.label = 1;
                                if (LazyListState.animateScrollToItem$default(lazyListState, lazyListState.getFirstVisibleItemIndex() + 1, 0, (Continuation) this, 2, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                        } catch (IllegalArgumentException unused) {
                        }
                        return Unit.INSTANCE;
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2481invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2481invoke() {
                    BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C05961(rememberLazyListState, null), 3, (Object) null);
                }
            };
            startRestartGroup.updateRememberedValue(function0);
            obj = function0;
            Function0 function02 = (Function0) obj;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-269656336);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changed(rememberLazyListState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changedInstance2) {
                obj2 = rememberedValue3;
            }
            Function0<Unit> function03 = new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$1$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: DatePicker.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$1$2$1$1", f = "DatePicker.kt", i = {}, l = {1510}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$1$2$1$1 */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                public static final class C05971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ LazyListState $monthsListState;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C05971(LazyListState lazyListState, Continuation<? super C05971> continuation) {
                        super(2, continuation);
                        this.$monthsListState = lazyListState;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C05971(this.$monthsListState, continuation);
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        try {
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                LazyListState lazyListState = this.$monthsListState;
                                this.label = 1;
                                if (LazyListState.animateScrollToItem$default(lazyListState, lazyListState.getFirstVisibleItemIndex() - 1, 0, (Continuation) this, 2, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                        } catch (IllegalArgumentException unused) {
                        }
                        return Unit.INSTANCE;
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2482invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2482invoke() {
                    BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C05971(rememberLazyListState, null), 3, (Object) null);
                }
            };
            startRestartGroup.updateRememberedValue(function03);
            obj2 = function03;
            Function0 function04 = (Function0) obj2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-269655774);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean changed = startRestartGroup.changed(mutableState);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed) {
                obj3 = rememberedValue4;
            }
            Function0<Unit> function05 = new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$1$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2483invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2483invoke() {
                    boolean DatePickerContent$lambda$82;
                    MutableState<Boolean> mutableState2 = mutableState;
                    DatePickerContent$lambda$82 = DatePickerKt.DatePickerContent$lambda$8(mutableState2);
                    DatePickerKt.DatePickerContent$lambda$9(mutableState2, !DatePickerContent$lambda$82);
                }
            };
            startRestartGroup.updateRememberedValue(function05);
            obj3 = function05;
            startRestartGroup.endReplaceableGroup();
            int i4 = i3 & 234881024;
            String str3 = str;
            MonthsNavigation(m1066paddingVpY3zN4$default, canScrollForward, canScrollBackward, DatePickerContent$lambda$8, str2, function02, function04, (Function0) obj3, datePickerColors, startRestartGroup, i4 | 6);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1767588144, "C1523@67752L683,1537@68475L2534:DatePicker.kt#uh7d8r");
            Modifier m1066paddingVpY3zN4$default2 = PaddingKt.m1066paddingVpY3zN4$default(Modifier.INSTANCE, f, 0.0f, 2, null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m1066paddingVpY3zN4$default2);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4109constructorimpl3 = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl3, columnMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl3, currentCompositionLocalMap3, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl3.getInserting() || !Intrinsics.areEqual(m4109constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m4109constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m4109constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            modifierMaterializerOf3.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, str3);
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1247393713, "C1524@67848L31,1525@67896L525:DatePicker.kt#uh7d8r");
            WeekDays(datePickerColors, calendarModel, startRestartGroup, ((i3 >> 24) & 14) | ((i3 >> 9) & 112));
            composer2 = startRestartGroup;
            HorizontalMonthsList(rememberLazyListState, l, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, startRestartGroup, ((i3 << 3) & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | i4);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            AnimatedVisibilityKt.AnimatedVisibility(DatePickerContent$lambda$8(mutableState), ClipKt.clipToBounds(Modifier.INSTANCE), EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.6f, 1, null)), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)), (String) null, ComposableLambdaKt.composableLambda(composer2, 1193716082, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5, Object obj6) {
                    invoke((AnimatedVisibilityScope) obj4, (Composer) obj5, ((Number) obj6).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i5) {
                    DatePickerColors datePickerColors2;
                    Object obj4;
                    ComposerKt.sourceInformation(composer3, "C1547@69058L48,1548@69160L30,1548@69123L1872:DatePicker.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1193716082, i5, -1, "androidx.compose.material3.DatePickerContent.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1547)");
                    }
                    Strings.Companion companion4 = Strings.INSTANCE;
                    final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_year_picker_pane_title), composer3, 0);
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    composer3.startReplaceableGroup(1247395025);
                    ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                    boolean changed2 = composer3.changed(m3033getStringNWtq28);
                    Object rememberedValue5 = composer3.rememberedValue();
                    if (changed2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj5) {
                                invoke((SemanticsPropertyReceiver) obj5);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq28);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue5);
                    }
                    composer3.endReplaceableGroup();
                    Modifier semantics$default = SemanticsModifierKt.semantics$default(companion5, false, (Function1) rememberedValue5, 1, (Object) null);
                    long j2 = j;
                    final MutableState<Boolean> mutableState2 = mutableState;
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    final LazyListState lazyListState = rememberLazyListState;
                    final IntRange intRange2 = intRange;
                    final CalendarMonth calendarMonth = month;
                    SelectableDates selectableDates2 = selectableDates;
                    CalendarModel calendarModel2 = calendarModel;
                    DatePickerColors datePickerColors3 = datePickerColors;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                    Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(semantics$default);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor4);
                    } else {
                        composer3.useNode();
                    }
                    Composer m4109constructorimpl4 = Updater.m4109constructorimpl(composer3);
                    Updater.m4116setimpl(m4109constructorimpl4, columnMeasurePolicy3, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4116setimpl(m4109constructorimpl4, currentCompositionLocalMap4, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4109constructorimpl4.getInserting() || !Intrinsics.areEqual(m4109constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m4109constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m4109constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    modifierMaterializerOf4.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1036318296, "C1560@69919L767,1549@69214L1696,1577@70931L46:DatePicker.kt#uh7d8r");
                    Modifier m1066paddingVpY3zN4$default3 = PaddingKt.m1066paddingVpY3zN4$default(SizeKt.m1109requiredHeight3ABfNKs(Modifier.INSTANCE, Dp.constructor-impl(Dp.constructor-impl(DatePickerKt.getRecommendedSizeForAccessibility() * 7) - DividerDefaults.INSTANCE.m2538getThicknessD9Ej5fM())), DatePickerKt.getDatePickerHorizontalPadding(), 0.0f, 2, null);
                    composer3.startReplaceableGroup(-1036317591);
                    ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                    boolean changed3 = composer3.changed(mutableState2) | composer3.changedInstance(coroutineScope2) | composer3.changed(lazyListState) | composer3.changedInstance(intRange2) | composer3.changed(calendarMonth);
                    Object rememberedValue6 = composer3.rememberedValue();
                    if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        datePickerColors2 = datePickerColors3;
                        Object obj5 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj6) {
                                invoke(((Number) obj6).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* compiled from: DatePicker.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1$1", f = "DatePicker.kt", i = {}, l = {1568}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1$1 */
                            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                            public static final class C05981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ CalendarMonth $displayedMonth;
                                final /* synthetic */ LazyListState $monthsListState;
                                final /* synthetic */ int $year;
                                final /* synthetic */ IntRange $yearRange;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C05981(LazyListState lazyListState, int i, IntRange intRange, CalendarMonth calendarMonth, Continuation<? super C05981> continuation) {
                                    super(2, continuation);
                                    this.$monthsListState = lazyListState;
                                    this.$year = i;
                                    this.$yearRange = intRange;
                                    this.$displayedMonth = calendarMonth;
                                }

                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C05981(this.$monthsListState, this.$year, this.$yearRange, this.$displayedMonth, continuation);
                                }

                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                }

                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (LazyListState.scrollToItem$default(this.$monthsListState, (((this.$year - this.$yearRange.getFirst()) * 12) + this.$displayedMonth.getMonth()) - 1, 0, (Continuation) this, 2, null) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            public final void invoke(int i6) {
                                boolean DatePickerContent$lambda$82;
                                MutableState<Boolean> mutableState3 = mutableState2;
                                DatePickerContent$lambda$82 = DatePickerKt.DatePickerContent$lambda$8(mutableState3);
                                DatePickerKt.DatePickerContent$lambda$9(mutableState3, !DatePickerContent$lambda$82);
                                BuildersKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new C05981(lazyListState, i6, intRange2, calendarMonth, null), 3, (Object) null);
                            }
                        };
                        composer3.updateRememberedValue(obj5);
                        obj4 = obj5;
                    } else {
                        datePickerColors2 = datePickerColors3;
                        obj4 = rememberedValue6;
                    }
                    composer3.endReplaceableGroup();
                    DatePickerKt.YearPicker(m1066paddingVpY3zN4$default3, j2, (Function1) obj4, selectableDates2, calendarModel2, intRange2, datePickerColors2, composer3, 6);
                    DividerKt.m2540HorizontalDivider9IZ8Weo(null, 0.0f, datePickerColors2.getDividerColor(), composer3, 0, 3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, 200112, 16);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                    invoke((Composer) obj4, ((Number) obj5).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i5) {
                    DatePickerKt.DatePickerContent(l, j, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DatePickerContent$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DatePickerContent$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* renamed from: DatePickerHeader-pc5RIQQ, reason: not valid java name */
    public static final void m2473DatePickerHeaderpc5RIQQ(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final long j, final long j2, final float f, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(-996037719);
        ComposerKt.sourceInformation(startRestartGroup, "C(DatePickerHeader)P(3,4,5:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.unit.Dp)1600@71484L740:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(j2) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(f) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? Fields.RenderEffect : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-996037719, i2, -1, "androidx.compose.material3.DatePickerHeader (DatePicker.kt:1592)");
            }
            if (function2 != null) {
                companion = SizeKt.m1105defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, f, 1, null);
            } else {
                companion = Modifier.INSTANCE;
            }
            Modifier then = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null).then(companion);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1127544336, "C1619@72104L114:DatePicker.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(1127544336);
            ComposerKt.sourceInformation(startRestartGroup, "1608@71722L10,1611@71841L244");
            if (function2 != null) {
                ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(j, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderSupportingTextFont()), ComposableLambdaKt.composableLambda(startRestartGroup, 1936268514, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerHeader$1$1
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

                    public final void invoke(Composer composer2, int i3) {
                        ComposerKt.sourceInformation(composer2, "C1614@71978L93:DatePicker.kt#uh7d8r");
                        if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1936268514, i3, -1, "androidx.compose.material3.DatePickerHeader.<anonymous>.<anonymous> (DatePicker.kt:1614)");
                            }
                            Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                            Function2<Composer, Integer, Unit> function23 = function2;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(bottomStart, false, composer2, 6);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer2);
                            Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1465500517, "C1615@72046L7:DatePicker.kt#uh7d8r");
                            function23.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, ((i2 >> 6) & 14) | 384);
            }
            startRestartGroup.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j2)), function22, startRestartGroup, ((i2 >> 12) & 112) | ProvidedValue.$stable | 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerHeader$2
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

                public final void invoke(Composer composer2, int i3) {
                    DatePickerKt.m2473DatePickerHeaderpc5RIQQ(Modifier.this, function2, j, j2, f, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HorizontalMonthsList(final LazyListState lazyListState, final Long l, final Function1<? super Long, Unit> function1, final Function1<? super Long, Unit> function12, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1994757941);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalMonthsList)P(3,7,4,5!1,8,2,6)1642@72780L138,1649@72963L10,1648@72923L1690,1687@74649L228,1687@74619L258:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(lazyListState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(l) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function12) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= (2097152 & i) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 1048576 : Fields.BlendMode;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changed(selectableDates) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? 67108864 : 33554432;
        }
        int i3 = i2;
        if ((38347923 & i3) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1994757941, i3, -1, "androidx.compose.material3.HorizontalMonthsList (DatePicker.kt:1640)");
            }
            final CalendarDate today = calendarModel.getToday();
            startRestartGroup.startReplaceableGroup(1346192500);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean changed = startRestartGroup.changed(intRange);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = calendarModel.getMonth(intRange.getFirst(), 1);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CalendarMonth calendarMonth = (CalendarMonth) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getDateLabelTextFont()), ComposableLambdaKt.composableLambda(composer2, 1504086906, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1
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

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C1661@73673L40,1662@73724L883,1651@73041L1566:DatePicker.kt#uh7d8r");
                    if ((i4 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1504086906, i4, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous> (DatePicker.kt:1651)");
                        }
                        Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1.1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt.HorizontalMonthsList.1.1.1
                                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Float m2487invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt.HorizontalMonthsList.1.1.2
                                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Float m2488invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, false, 4, (DefaultConstructorMarker) null));
                            }
                        }, 1, (Object) null);
                        LazyListState lazyListState2 = LazyListState.this;
                        FlingBehavior rememberSnapFlingBehavior$material3_release = DatePickerDefaults.INSTANCE.rememberSnapFlingBehavior$material3_release(LazyListState.this, null, composer3, 384, 2);
                        composer3.startReplaceableGroup(1286688325);
                        ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                        boolean changedInstance = composer3.changedInstance(intRange) | composer3.changedInstance(calendarModel) | composer3.changed(calendarMonth) | composer3.changed(function1) | composer3.changed(today) | composer3.changed(l) | composer3.changedInstance(datePickerFormatter) | composer3.changed(selectableDates) | composer3.changed(datePickerColors);
                        final IntRange intRange2 = intRange;
                        final CalendarModel calendarModel2 = calendarModel;
                        final CalendarMonth calendarMonth2 = calendarMonth;
                        final Function1<Long, Unit> function13 = function1;
                        final CalendarDate calendarDate = today;
                        final Long l2 = l;
                        final DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
                        final SelectableDates selectableDates2 = selectableDates;
                        final DatePickerColors datePickerColors2 = datePickerColors;
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((LazyListScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyListScope lazyListScope) {
                                    int numberOfMonthsInRange = DatePickerKt.numberOfMonthsInRange(intRange2);
                                    final CalendarModel calendarModel3 = calendarModel2;
                                    final CalendarMonth calendarMonth3 = calendarMonth2;
                                    final Function1<Long, Unit> function14 = function13;
                                    final CalendarDate calendarDate2 = calendarDate;
                                    final Long l3 = l2;
                                    final DatePickerFormatter datePickerFormatter3 = datePickerFormatter2;
                                    final SelectableDates selectableDates3 = selectableDates2;
                                    final DatePickerColors datePickerColors3 = datePickerColors2;
                                    LazyListScope.items$default(lazyListScope, numberOfMonthsInRange, null, null, ComposableLambdaKt.composableLambdaInstance(1137566309, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                            invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer4, int i6) {
                                            int i7;
                                            ComposerKt.sourceInformation(composer4, "C1668@73949L634:DatePicker.kt#uh7d8r");
                                            if ((i6 & 6) == 0) {
                                                i7 = i6 | (composer4.changed(lazyItemScope) ? 4 : 2);
                                            } else {
                                                i7 = i6;
                                            }
                                            if ((i6 & 48) == 0) {
                                                i7 |= composer4.changed(i5) ? 32 : 16;
                                            }
                                            if ((i7 & 147) != 146 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1137566309, i7, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1664)");
                                                }
                                                CalendarMonth plusMonths = CalendarModel.this.plusMonths(calendarMonth3, i5);
                                                Modifier fillParentMaxWidth$default = LazyItemScope.fillParentMaxWidth$default(lazyItemScope, Modifier.INSTANCE, 0.0f, 1, null);
                                                Function1<Long, Unit> function15 = function14;
                                                CalendarDate calendarDate3 = calendarDate2;
                                                Long l4 = l3;
                                                DatePickerFormatter datePickerFormatter4 = datePickerFormatter3;
                                                SelectableDates selectableDates4 = selectableDates3;
                                                DatePickerColors datePickerColors4 = datePickerColors3;
                                                composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillParentMaxWidth$default);
                                                if (!(composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer4.startReusableNode();
                                                if (composer4.getInserting()) {
                                                    composer4.createNode(constructor);
                                                } else {
                                                    composer4.useNode();
                                                }
                                                Composer m4109constructorimpl = Updater.m4109constructorimpl(composer4);
                                                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                composer4.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer4, 1367623956, "C1671@74055L510:DatePicker.kt#uh7d8r");
                                                DatePickerKt.Month(plusMonths, function15, calendarDate3.getUtcTimeMillis(), l4, null, null, datePickerFormatter4, selectableDates4, datePickerColors4, composer4, 221184);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                composer4.endReplaceableGroup();
                                                composer4.endNode();
                                                composer4.endReplaceableGroup();
                                                composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), 6, null);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        LazyDslKt.LazyRow(semantics$default, lazyListState2, null, false, null, null, rememberSnapFlingBehavior$material3_release, false, (Function1) rememberedValue2, composer3, 0, 188);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, 48);
            composer2.startReplaceableGroup(1346194369);
            ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
            int i4 = i3 & 14;
            boolean changedInstance = (i4 == 4) | ((i3 & 7168) == 2048) | composer2.changedInstance(calendarModel) | composer2.changedInstance(intRange);
            DatePickerKt$HorizontalMonthsList$2$1 rememberedValue2 = composer2.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new DatePickerKt$HorizontalMonthsList$2$1(lazyListState, function12, calendarModel, intRange, null);
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(lazyListState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer2, i4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$3
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

                public final void invoke(Composer composer3, int i5) {
                    DatePickerKt.HorizontalMonthsList(LazyListState.this, l, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final Object updateDisplayedMonth(final LazyListState lazyListState, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, Continuation<? super Unit> continuation) {
        Object collect = SnapshotStateKt.snapshotFlow(new Function0<Integer>() { // from class: androidx.compose.material3.DatePickerKt$updateDisplayedMonth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m2498invoke() {
                return Integer.valueOf(LazyListState.this.getFirstVisibleItemIndex());
            }
        }).collect(new FlowCollector() { // from class: androidx.compose.material3.DatePickerKt$updateDisplayedMonth$3
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit(((Number) obj).intValue(), (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(int i, Continuation<? super Unit> continuation2) {
                int firstVisibleItemIndex = LazyListState.this.getFirstVisibleItemIndex() / 12;
                function1.invoke(Boxing.boxLong(calendarModel.getMonth(intRange.getFirst() + firstVisibleItemIndex, (LazyListState.this.getFirstVisibleItemIndex() % 12) + 1).getStartUtcTimeMillis()));
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r13v8 */
    public static final void WeekDays(final DatePickerColors datePickerColors, final CalendarModel calendarModel, Composer composer, final int i) {
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1849465391);
        ComposerKt.sourceInformation(startRestartGroup, "C(WeekDays)P(1)1733@76133L10,1735@76204L990:DatePicker.kt#uh7d8r");
        int i2 = (i & 6) == 0 ? (startRestartGroup.changed(datePickerColors) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1849465391, i2, -1, "androidx.compose.material3.WeekDays (DatePicker.kt:1721)");
            }
            int firstDayOfWeek = calendarModel.getFirstDayOfWeek();
            List<Pair<String, String>> weekdayNames = calendarModel.getWeekdayNames();
            ArrayList arrayList = new ArrayList();
            int i3 = firstDayOfWeek - 1;
            int size = weekdayNames.size();
            for (int i4 = i3; i4 < size; i4++) {
                arrayList.add(weekdayNames.get(i4));
            }
            ?? r13 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                arrayList.add(weekdayNames.get(i5));
            }
            int i6 = 6;
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextFont());
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m1105defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, RecommendedSizeForAccessibility, 1, null), 0.0f, 1, null);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly, centerVertically, startRestartGroup, 54);
            int i7 = -1323940314;
            startRestartGroup.startReplaceableGroup(-1323940314);
            String str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 289869412, "C:DatePicker.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(-971954356);
            ComposerKt.sourceInformation(startRestartGroup, "*1747@76615L33,1745@76532L646");
            ArrayList arrayList2 = arrayList;
            int size2 = arrayList2.size();
            int i8 = 0;
            while (i8 < size2) {
                final Pair pair = (Pair) arrayList2.get(i8);
                Modifier.Companion companion = Modifier.INSTANCE;
                startRestartGroup.startReplaceableGroup(784223355);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                boolean changed = startRestartGroup.changed(pair);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$WeekDays$1$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, (String) pair.getFirst());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) rememberedValue);
                float f = RecommendedSizeForAccessibility;
                Modifier m1122sizeVpY3zN4 = SizeKt.m1122sizeVpY3zN4(clearAndSetSemantics, f, f);
                Alignment center = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, r13, startRestartGroup, i6);
                startRestartGroup.startReplaceableGroup(i7);
                ComposerKt.sourceInformation(startRestartGroup, str);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r13);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1122sizeVpY3zN4);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
                Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 178856377, "C1753@76900L264:DatePicker.kt#uh7d8r");
                Composer composer3 = startRestartGroup;
                TextKt.m3199Text4IGK_g((String) pair.getSecond(), SizeKt.wrapContentSize$default(Modifier.INSTANCE, null, false, 3, null), datePickerColors.getWeekdayContentColor(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, fromToken, composer3, 48, 0, 65016);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endReplaceableGroup();
                composer3.endNode();
                composer3.endReplaceableGroup();
                composer3.endReplaceableGroup();
                i8++;
                arrayList2 = arrayList2;
                size2 = size2;
                str = str;
                i7 = -1323940314;
                r13 = 0;
                i6 = 6;
                startRestartGroup = composer3;
            }
            composer2 = startRestartGroup;
            composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$WeekDays$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i9) {
                    DatePickerKt.WeekDays(DatePickerColors.this, calendarModel, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void Month(final CalendarMonth calendarMonth, final Function1<? super Long, Unit> function1, final long j, final Long l, final Long l2, final SelectedRangeInfo selectedRangeInfo, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Modifier.Companion companion;
        Composer composer2;
        String str;
        String str2;
        boolean z;
        int i3;
        String str3;
        int i4;
        Composer composer3;
        Locale locale;
        boolean z2;
        char c;
        boolean z3;
        boolean z4;
        final long j2;
        Object valueOf;
        boolean z5;
        Object mutableStateOf$default;
        long j3 = j;
        Object obj = l;
        Object obj2 = l2;
        final SelectedRangeInfo selectedRangeInfo2 = selectedRangeInfo;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        Composer startRestartGroup = composer.startRestartGroup(-1912870997);
        ComposerKt.sourceInformation(startRestartGroup, "C(Month)P(3,4,8,7,2,5,1,6)1790@77967L15,1792@78009L4836:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(calendarMonth) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j3) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(obj) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(obj2) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(selectedRangeInfo2) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= (2097152 & i) == 0 ? startRestartGroup.changed(datePickerFormatter2) : startRestartGroup.changedInstance(datePickerFormatter2) ? 1048576 : Fields.BlendMode;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changed(selectableDates) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? 67108864 : 33554432;
        }
        int i5 = i2;
        if ((38347923 & i5) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1912870997, i5, -1, "androidx.compose.material3.Month (DatePicker.kt:1780)");
            }
            startRestartGroup.startReplaceableGroup(-2019459922);
            ComposerKt.sourceInformation(startRestartGroup, "1782@77774L131");
            String str4 = "CC(remember):DatePicker.kt#9igjgp";
            if (selectedRangeInfo2 != null) {
                Modifier.Companion companion2 = Modifier.INSTANCE;
                startRestartGroup.startReplaceableGroup(-2019459855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                boolean z6 = ((i5 & 458752) == 131072) | ((i5 & 234881024) == 67108864);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Month$rangeSelectionDrawModifier$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                            invoke((ContentDrawScope) obj3);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            DateRangePickerKt.m2509drawRangeBackgroundmxwnekA(contentDrawScope, SelectedRangeInfo.this, datePickerColors.getDayInSelectionRangeContainerColor());
                            contentDrawScope.drawContent();
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                companion = DrawModifierKt.drawWithContent(companion2, (Function1) rememberedValue);
            } else {
                companion = Modifier.INSTANCE;
            }
            startRestartGroup.endReplaceableGroup();
            Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
            Modifier then = SizeKt.m1109requiredHeight3ABfNKs(Modifier.INSTANCE, Dp.constructor-impl(RecommendedSizeForAccessibility * 6)).then(companion);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceEvenly, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            String str5 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -713628571, "C:DatePicker.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(-2019459388);
            ComposerKt.sourceInformation(startRestartGroup, "*1799@78298L4531");
            int i6 = 0;
            int i7 = 0;
            int i8 = 6;
            while (i6 < i8) {
                int i9 = i6;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical spaceEvenly2 = Arrangement.INSTANCE.getSpaceEvenly();
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                startRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly2, centerVertically, startRestartGroup, 54);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, str5);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                int i10 = i7;
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
                Updater.m4116setimpl(m4109constructorimpl2, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                boolean z7 = false;
                modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1111236200, "C:DatePicker.kt#uh7d8r");
                startRestartGroup.startReplaceableGroup(-713628297);
                String str6 = "";
                ComposerKt.sourceInformation(startRestartGroup, "");
                int i11 = 0;
                int i12 = i10;
                while (i11 < 7) {
                    if (i12 < calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() || i12 >= calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() + calendarMonth.getNumberOfDays()) {
                        str = str6;
                        str2 = str4;
                        z = z7;
                        i3 = i5;
                        str3 = str5;
                        i4 = i12;
                        composer3 = startRestartGroup;
                        locale = defaultLocale;
                        composer3.startReplaceableGroup(-1111235936);
                        ComposerKt.sourceInformation(composer3, "1810@78843L271");
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        float f = RecommendedSizeForAccessibility;
                        SpacerKt.Spacer(SizeKt.m1114requiredSizeVpY3zN4(companion3, f, f), composer3, 6);
                        composer3.endReplaceableGroup();
                    } else {
                        startRestartGroup.startReplaceableGroup(-1111235573);
                        ComposerKt.sourceInformation(startRestartGroup, "1834@80231L341,1849@81021L39,1854@81396L518,1846@80852L1891");
                        final int daysFromStartOfWeekToFirstOfMonth = i12 - calendarMonth.getDaysFromStartOfWeekToFirstOfMonth();
                        int i13 = i5;
                        long startUtcTimeMillis = calendarMonth.getStartUtcTimeMillis() + (daysFromStartOfWeekToFirstOfMonth * CalendarModelKt.MillisecondsIn24Hours);
                        boolean z8 = startUtcTimeMillis == j3;
                        boolean z9 = obj != null && startUtcTimeMillis == l.longValue();
                        if (obj2 != null && startUtcTimeMillis == l2.longValue()) {
                            str = str6;
                            z2 = true;
                        } else {
                            str = str6;
                            z2 = false;
                        }
                        startRestartGroup.startReplaceableGroup(-1111235085);
                        ComposerKt.sourceInformation(startRestartGroup, "1824@79692L387");
                        if (selectedRangeInfo2 != null) {
                            startRestartGroup.startReplaceableGroup(-1111235023);
                            ComposerKt.sourceInformation(startRestartGroup, str4);
                            boolean changed = ((i13 & 458752) == 131072) | startRestartGroup.changed(startUtcTimeMillis);
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                if (startUtcTimeMillis >= (obj != null ? l.longValue() : SnapshotId_jvmKt.SnapshotIdMax)) {
                                    if (startUtcTimeMillis <= (obj2 != null ? l2.longValue() : Long.MIN_VALUE)) {
                                        z5 = true;
                                        c = 2;
                                        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z5), null, 2, null);
                                        startRestartGroup.updateRememberedValue(mutableStateOf$default);
                                    }
                                }
                                z5 = false;
                                c = 2;
                                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z5), null, 2, null);
                                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                            } else {
                                mutableStateOf$default = rememberedValue2;
                                c = 2;
                            }
                            startRestartGroup.endReplaceableGroup();
                            z3 = ((Boolean) ((MutableState) mutableStateOf$default).getValue()).booleanValue();
                        } else {
                            c = 2;
                            z3 = false;
                        }
                        startRestartGroup.endReplaceableGroup();
                        z = false;
                        i3 = i13;
                        str3 = str5;
                        i4 = i12;
                        Locale locale2 = defaultLocale;
                        Composer composer4 = startRestartGroup;
                        String dayContentDescription = dayContentDescription(selectedRangeInfo2 != null, z8, z9, z2, z3, composer4, 0);
                        String formatDate = datePickerFormatter2.formatDate(Long.valueOf(startUtcTimeMillis), locale2, true);
                        if (formatDate == null) {
                            formatDate = str;
                        }
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        boolean z10 = z9 || z2;
                        composer3 = composer4;
                        composer3.startReplaceableGroup(-1111233694);
                        ComposerKt.sourceInformation(composer3, str4);
                        locale = locale2;
                        if ((i3 & 112) == 32) {
                            j2 = startUtcTimeMillis;
                            z4 = true;
                        } else {
                            z4 = false;
                            j2 = startUtcTimeMillis;
                        }
                        boolean changed2 = z4 | composer3.changed(j2);
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$Month$1$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2489invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: collision with other method in class */
                                public final void m2489invoke() {
                                    function1.invoke(Long.valueOf(j2));
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        Function0 function0 = (Function0) rememberedValue3;
                        composer3.endReplaceableGroup();
                        composer3.startReplaceableGroup(-1111233319);
                        ComposerKt.sourceInformation(composer3, str4);
                        boolean changed3 = composer3.changed(j2);
                        Object rememberedValue4 = composer3.rememberedValue();
                        if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            valueOf = Boolean.valueOf(selectableDates.isSelectableYear(calendarMonth.getYear()) && selectableDates.isSelectableDate(j2));
                            composer3.updateRememberedValue(valueOf);
                        } else {
                            valueOf = rememberedValue4;
                        }
                        boolean booleanValue = ((Boolean) valueOf).booleanValue();
                        composer3.endReplaceableGroup();
                        str2 = str4;
                        Day(companion4, z10, function0, z9, booleanValue, z8, z3, dayContentDescription != null ? dayContentDescription + ", " + formatDate : formatDate, datePickerColors, ComposableLambdaKt.composableLambda(composer3, -2095706591, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Month$1$1$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                                invoke((Composer) obj3, ((Number) obj4).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer5, int i14) {
                                ComposerKt.sourceInformation(composer5, "C1872@82396L321:DatePicker.kt#uh7d8r");
                                if ((i14 & 3) != 2 || !composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2095706591, i14, -1, "androidx.compose.material3.Month.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1872)");
                                    }
                                    TextKt.m3199Text4IGK_g(ActualJvm_jvmKt.toLocalString$default(daysFromStartOfWeekToFirstOfMonth + 1, 0, 0, false, 7, null), SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Month$1$1$3.1
                                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                            invoke((SemanticsPropertyReceiver) obj3);
                                            return Unit.INSTANCE;
                                        }
                                    }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer5, 0, 0, 130556);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer5.skipToGroupEnd();
                            }
                        }), composer3, 805306374 | (i3 & 234881024));
                        composer3.endReplaceableGroup();
                    }
                    i12 = i4 + 1;
                    i11++;
                    obj = l;
                    obj2 = l2;
                    selectedRangeInfo2 = selectedRangeInfo;
                    datePickerFormatter2 = datePickerFormatter;
                    startRestartGroup = composer3;
                    i5 = i3;
                    z7 = z;
                    str6 = str;
                    defaultLocale = locale;
                    str4 = str2;
                    str5 = str3;
                    j3 = j;
                }
                int i14 = i12;
                Composer composer5 = startRestartGroup;
                composer5.endReplaceableGroup();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer5.endReplaceableGroup();
                composer5.endNode();
                composer5.endReplaceableGroup();
                composer5.endReplaceableGroup();
                obj = l;
                obj2 = l2;
                selectedRangeInfo2 = selectedRangeInfo;
                datePickerFormatter2 = datePickerFormatter;
                i8 = 6;
                i7 = i14;
                j3 = j;
                i6 = i9 + 1;
            }
            composer2 = startRestartGroup;
            composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Month$2
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

                public final void invoke(Composer composer6, int i15) {
                    DatePickerKt.Month(CalendarMonth.this, function1, j, l, l2, selectedRangeInfo, datePickerFormatter, selectableDates, datePickerColors, composer6, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final int numberOfMonthsInRange(IntRange intRange) {
        return ((intRange.getLast() - intRange.getFirst()) + 1) * 12;
    }

    private static final String dayContentDescription(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Composer composer, int i) {
        composer.startReplaceableGroup(502032503);
        ComposerKt.sourceInformation(composer, "C(dayContentDescription)P(4,3,2)1919@83871L54:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(502032503, i, -1, "androidx.compose.material3.dayContentDescription (DatePicker.kt:1900)");
        }
        StringBuilder sb = new StringBuilder();
        composer.startReplaceableGroup(-852185051);
        ComposerKt.sourceInformation(composer, "");
        if (z) {
            if (z3) {
                composer.startReplaceableGroup(-852184961);
                ComposerKt.sourceInformation(composer, "1905@83379L56");
                Strings.Companion companion = Strings.INSTANCE;
                sb.append(Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_range_picker_start_headline), composer, 0));
                composer.endReplaceableGroup();
            } else if (z4) {
                composer.startReplaceableGroup(-852184821);
                ComposerKt.sourceInformation(composer, "1909@83519L54");
                Strings.Companion companion2 = Strings.INSTANCE;
                sb.append(Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_range_picker_end_headline), composer, 0));
                composer.endReplaceableGroup();
            } else if (z5) {
                composer.startReplaceableGroup(-852184683);
                ComposerKt.sourceInformation(composer, "1913@83657L53");
                Strings.Companion companion3 = Strings.INSTANCE;
                sb.append(Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_range_picker_day_in_range), composer, 0));
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-852184582);
                composer.endReplaceableGroup();
            }
        }
        composer.endReplaceableGroup();
        if (z2) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            Strings.Companion companion4 = Strings.INSTANCE;
            sb.append(Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_today_description), composer, 0));
        }
        String sb2 = sb.length() == 0 ? null : sb.toString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Day(final Modifier modifier, final boolean z, final Function0<Unit> function0, final boolean z2, final boolean z3, final boolean z4, final boolean z5, final String str, final DatePickerColors datePickerColors, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1434777861);
        ComposerKt.sourceInformation(startRestartGroup, "C(Day)P(6,8,7!1,4,9,5,3)1945@84736L102,1950@84924L5,1951@84954L129,1956@85121L150,1938@84354L1463:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(z3) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(z4) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(z5) ? 1048576 : Fields.BlendMode;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changed(str) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
        }
        int i3 = i2;
        if ((306783379 & i3) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1434777861, i3, -1, "androidx.compose.material3.Day (DatePicker.kt:1937)");
            }
            startRestartGroup.startReplaceableGroup(1664739143);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean z6 = (29360128 & i3) == 8388608;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Day$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null));
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getButton-o7Vup1c());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier semantics = SemanticsModifierKt.semantics(modifier, true, (Function1) rememberedValue);
            int i4 = i3 >> 3;
            int i5 = i4 & 14;
            int i6 = i3 >> 15;
            int i7 = i3 >> 12;
            int i8 = i4 & 7168;
            composer2 = startRestartGroup;
            SurfaceKt.m3044Surfaced85dljk(z, function0, semantics, z3, ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getDateContainerShape(), startRestartGroup, 6), datePickerColors.dayContainerColor$material3_release(z, z3, z2, startRestartGroup, (i6 & 7168) | i5 | ((i3 >> 9) & 112) | (i4 & 896)).getValue().m4849unboximpl(), datePickerColors.dayContentColor$material3_release(z4, z, z5, z3, startRestartGroup, (i6 & 14) | (i3 & 112) | (i7 & 896) | i8 | (i7 & 57344)).getValue().m4849unboximpl(), 0.0f, 0.0f, (!z4 || z) ? null : BorderStrokeKt.m432BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.m3546getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.getTodayDateBorderColor()), (MutableInteractionSource) null, ComposableLambdaKt.composableLambda(startRestartGroup, -2031780827, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Day$2
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

                public final void invoke(Composer composer3, int i9) {
                    ComposerKt.sourceInformation(composer3, "C1971@85536L275:DatePicker.kt#uh7d8r");
                    if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2031780827, i9, -1, "androidx.compose.material3.Day.<anonymous> (DatePicker.kt:1971)");
                        }
                        Modifier m1114requiredSizeVpY3zN4 = SizeKt.m1114requiredSizeVpY3zN4(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m3545getDateStateLayerWidthD9Ej5fM(), DatePickerModalTokens.INSTANCE.m3544getDateStateLayerHeightD9Ej5fM());
                        Alignment center = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer3, 6);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1114requiredSizeVpY3zN4);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m4109constructorimpl = Updater.m4109constructorimpl(composer3);
                        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -806739671, "C1978@85792L9:DatePicker.kt#uh7d8r");
                        function22.invoke(composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, i5 | (i4 & 112) | i8, 48, 1408);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Day$3
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

                public final void invoke(Composer composer3, int i9) {
                    DatePickerKt.Day(Modifier.this, z, function0, z2, z3, z4, z5, str, datePickerColors, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void YearPicker(final Modifier modifier, final long j, final Function1<? super Integer, Unit> function1, final SelectableDates selectableDates, final CalendarModel calendarModel, final IntRange intRange, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1286899812);
        ComposerKt.sourceInformation(startRestartGroup, "C(YearPicker)P(3,2,4,5!1,6)1995@86176L10,1994@86128L4075:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(selectableDates) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? 1048576 : Fields.BlendMode;
        }
        if ((599187 & i2) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1286899812, i2, -1, "androidx.compose.material3.YearPicker (DatePicker.kt:1993)");
            }
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getSelectionYearLabelTextFont()), ComposableLambdaKt.composableLambda(startRestartGroup, 1301915789, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1
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

                public final void invoke(Composer composer2, int i3) {
                    float f;
                    LazyGridState lazyGridState;
                    Object obj;
                    ComposerKt.sourceInformation(composer2, "C2000@86448L319,2008@86911L11,2010@87049L7,2008@86923L143,2012@87096L24,2013@87161L53,2014@87253L51,2027@87936L2261,2015@87313L2884:DatePicker.kt#uh7d8r");
                    if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1301915789, i3, -1, "androidx.compose.material3.YearPicker.<anonymous> (DatePicker.kt:1997)");
                        }
                        CalendarModel calendarModel2 = CalendarModel.this;
                        final int year = calendarModel2.getMonth(calendarModel2.getToday()).getYear();
                        final int year2 = CalendarModel.this.getMonth(j).getYear();
                        final LazyGridState rememberLazyGridState = LazyGridStateKt.rememberLazyGridState(Math.max(0, (year2 - intRange.getFirst()) - 3), 0, composer2, 0, 2);
                        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer2, 6);
                        long containerColor = datePickerColors.getContainerColor();
                        ProvidableCompositionLocal<Dp> localAbsoluteTonalElevation = SurfaceKt.getLocalAbsoluteTonalElevation();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = composer2.consume(localAbsoluteTonalElevation);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        long m2379applyTonalElevationRFCenO8 = ColorSchemeKt.m2379applyTonalElevationRFCenO8(colorScheme, containerColor, ((Dp) consume).unbox-impl(), composer2, 0);
                        composer2.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composer2, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        composer2.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
                        Object rememberedValue = composer2.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                            composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            rememberedValue = compositionScopedCoroutineScopeCanceller;
                        }
                        composer2.endReplaceableGroup();
                        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                        composer2.endReplaceableGroup();
                        Strings.Companion companion = Strings.INSTANCE;
                        final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_scroll_to_earlier_years), composer2, 0);
                        Strings.Companion companion2 = Strings.INSTANCE;
                        final String m3033getStringNWtq282 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_scroll_to_later_years), composer2, 0);
                        GridCells.Fixed fixed = new GridCells.Fixed(3);
                        Modifier semantics$default = SemanticsModifierKt.semantics$default(BackgroundKt.m397backgroundbw27NRU$default(modifier, m2379applyTonalElevationRFCenO8, null, 2, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1.1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((SemanticsPropertyReceiver) obj2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.1.1
                                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Float m2492invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.1.2
                                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Float m2493invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, false, 4, (DefaultConstructorMarker) null));
                            }
                        }, 1, (Object) null);
                        Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
                        Arrangement arrangement = Arrangement.INSTANCE;
                        f = DatePickerKt.YearsVerticalPadding;
                        GridCells.Fixed fixed2 = fixed;
                        Arrangement.HorizontalOrVertical m909spacedBy0680j_4 = arrangement.m909spacedBy0680j_4(f);
                        Arrangement.HorizontalOrVertical horizontalOrVertical = spaceEvenly;
                        composer2.startReplaceableGroup(-969328877);
                        ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                        boolean changedInstance = composer2.changedInstance(intRange) | composer2.changed(rememberLazyGridState) | composer2.changedInstance(coroutineScope) | composer2.changed(m3033getStringNWtq28) | composer2.changed(m3033getStringNWtq282) | composer2.changed(year2) | composer2.changed(year) | composer2.changed(function1) | composer2.changed(selectableDates) | composer2.changed(datePickerColors);
                        final IntRange intRange2 = intRange;
                        final Function1<Integer, Unit> function12 = function1;
                        final SelectableDates selectableDates2 = selectableDates;
                        final DatePickerColors datePickerColors2 = datePickerColors;
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            lazyGridState = rememberLazyGridState;
                            Object obj2 = (Function1) new Function1<LazyGridScope, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                    invoke((LazyGridScope) obj3);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyGridScope lazyGridScope) {
                                    int count = CollectionsKt.count(intRange2);
                                    final IntRange intRange3 = intRange2;
                                    final LazyGridState lazyGridState2 = rememberLazyGridState;
                                    final CoroutineScope coroutineScope2 = coroutineScope;
                                    final String str = m3033getStringNWtq28;
                                    final String str2 = m3033getStringNWtq282;
                                    final int i4 = year2;
                                    final int i5 = year;
                                    final Function1<Integer, Unit> function13 = function12;
                                    final SelectableDates selectableDates3 = selectableDates2;
                                    final DatePickerColors datePickerColors3 = datePickerColors2;
                                    LazyGridScope.items$default(lazyGridScope, count, null, null, null, ComposableLambdaKt.composableLambdaInstance(1040623618, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4, Object obj5, Object obj6) {
                                            invoke((LazyGridItemScope) obj3, ((Number) obj4).intValue(), (Composer) obj5, ((Number) obj6).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyGridItemScope lazyGridItemScope, final int i6, Composer composer3, int i7) {
                                            int i8;
                                            ComposerKt.sourceInformation(composer3, "C2037@88435L975,2056@89567L32,*2058@89713L54,2031@88114L2059:DatePicker.kt#uh7d8r");
                                            if ((i7 & 48) == 0) {
                                                i8 = i7 | (composer3.changed(i6) ? 32 : 16);
                                            } else {
                                                i8 = i7;
                                            }
                                            if ((i8 & 145) != 144 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1040623618, i8, -1, "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2029)");
                                                }
                                                final int first = i6 + intRange3.getFirst();
                                                final String localString$default = ActualJvm_jvmKt.toLocalString$default(first, 0, 0, false, 7, null);
                                                Modifier m1114requiredSizeVpY3zN4 = SizeKt.m1114requiredSizeVpY3zN4(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m3553getSelectionYearContainerWidthD9Ej5fM(), DatePickerModalTokens.INSTANCE.m3552getSelectionYearContainerHeightD9Ej5fM());
                                                composer3.startReplaceableGroup(-1669466775);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                                boolean changed = ((i8 & 112) == 32) | composer3.changed(lazyGridState2) | composer3.changedInstance(coroutineScope2) | composer3.changed(str) | composer3.changed(str2);
                                                final LazyGridState lazyGridState3 = lazyGridState2;
                                                final CoroutineScope coroutineScope3 = coroutineScope2;
                                                final String str3 = str;
                                                final String str4 = str2;
                                                Object rememberedValue3 = composer3.rememberedValue();
                                                if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                                            invoke((SemanticsPropertyReceiver) obj3);
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                            List customScrollActions;
                                                            if (LazyGridState.this.getFirstVisibleItemIndex() != i6) {
                                                                LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.lastOrNull(LazyGridState.this.getLayoutInfo().getVisibleItemsInfo());
                                                                boolean z = false;
                                                                if (lazyGridItemInfo != null && lazyGridItemInfo.getIndex() == i6) {
                                                                    z = true;
                                                                }
                                                                if (!z) {
                                                                    customScrollActions = CollectionsKt.emptyList();
                                                                    SemanticsPropertiesKt.setCustomActions(semanticsPropertyReceiver, customScrollActions);
                                                                }
                                                            }
                                                            customScrollActions = DatePickerKt.customScrollActions(LazyGridState.this, coroutineScope3, str3, str4);
                                                            SemanticsPropertiesKt.setCustomActions(semanticsPropertyReceiver, customScrollActions);
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue3);
                                                }
                                                composer3.endReplaceableGroup();
                                                Modifier semantics$default2 = SemanticsModifierKt.semantics$default(m1114requiredSizeVpY3zN4, false, (Function1) rememberedValue3, 1, (Object) null);
                                                boolean z = first == i4;
                                                boolean z2 = first == i5;
                                                composer3.startReplaceableGroup(-1669465643);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                                boolean changed2 = composer3.changed(function13) | composer3.changed(first);
                                                final Function1<Integer, Unit> function14 = function13;
                                                Object rememberedValue4 = composer3.rememberedValue();
                                                if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1$2$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(0);
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke() {
                                                            m2494invoke();
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: collision with other method in class */
                                                        public final void m2494invoke() {
                                                            function14.invoke(Integer.valueOf(first));
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue4);
                                                }
                                                Function0 function0 = (Function0) rememberedValue4;
                                                composer3.endReplaceableGroup();
                                                boolean isSelectableYear = selectableDates3.isSelectableYear(first);
                                                Strings.Companion companion3 = Strings.INSTANCE;
                                                String format = String.format(Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_navigate_to_year_description), composer3, 0), Arrays.copyOf(new Object[]{localString$default}, 1));
                                                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                                                DatePickerKt.Year(semantics$default2, z, z2, function0, isSelectableYear, format, datePickerColors3, ComposableLambdaKt.composableLambda(composer3, 882189459, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.2.1.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                                                        invoke((Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer4, int i9) {
                                                        ComposerKt.sourceInformation(composer4, "C2062@89892L263:DatePicker.kt#uh7d8r");
                                                        if ((i9 & 3) != 2 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(882189459, i9, -1, "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2062)");
                                                            }
                                                            TextKt.m3199Text4IGK_g(localString$default, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.2.1.1.3.1
                                                                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                }

                                                                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                                                    invoke((SemanticsPropertyReceiver) obj3);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 130556);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), composer3, 12582912);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), 14, null);
                                }
                            };
                            composer2.updateRememberedValue(obj2);
                            obj = obj2;
                        } else {
                            lazyGridState = rememberLazyGridState;
                            obj = rememberedValue2;
                        }
                        composer2.endReplaceableGroup();
                        LazyGridDslKt.LazyVerticalGrid(fixed2, semantics$default, lazyGridState, null, false, m909spacedBy0680j_4, horizontalOrVertical, null, false, (Function1) obj, composer2, 1769472, 408);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$2
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

                public final void invoke(Composer composer2, int i3) {
                    DatePickerKt.YearPicker(Modifier.this, j, function1, selectableDates, calendarModel, intRange, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Year(final Modifier modifier, final boolean z, final boolean z2, final Function0<Unit> function0, final boolean z3, final String str, final DatePickerColors datePickerColors, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Object m432BorderStrokecXLIe8U;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(238547184);
        ComposerKt.sourceInformation(startRestartGroup, "C(Year)P(5,7,2,6,4,3)2086@90509L353,2103@91225L90,2108@91411L5,2109@91441L58,2110@91537L129,2097@90867L964:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(z3) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(str) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? 1048576 : Fields.BlendMode;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(238547184, i2, -1, "androidx.compose.material3.Year (DatePicker.kt:2085)");
            }
            startRestartGroup.startReplaceableGroup(84263149);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            int i3 = i2 & 112;
            boolean z4 = ((i2 & 896) == 256) | (i3 == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                m432BorderStrokecXLIe8U = (!z2 || z) ? null : BorderStrokeKt.m432BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.m3546getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.getTodayDateBorderColor());
                startRestartGroup.updateRememberedValue(m432BorderStrokecXLIe8U);
            } else {
                m432BorderStrokecXLIe8U = rememberedValue;
            }
            BorderStroke borderStroke = (BorderStroke) m432BorderStrokecXLIe8U;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(84263865);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean z5 = (458752 & i2) == 131072;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Year$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null));
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getButton-o7Vup1c());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier semantics = SemanticsModifierKt.semantics(modifier, true, (Function1) rememberedValue2);
            Shape value = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearStateLayerShape(), startRestartGroup, 6);
            int i4 = i2 >> 3;
            int i5 = i4 & 14;
            int i6 = i2 >> 9;
            long m4849unboximpl = datePickerColors.yearContainerColor$material3_release(z, z3, startRestartGroup, i5 | (i6 & 112) | ((i2 >> 12) & 896)).getValue().m4849unboximpl();
            int i7 = i2 >> 6;
            long m4849unboximpl2 = datePickerColors.yearContentColor$material3_release(z2, z, z3, startRestartGroup, (i7 & 14) | i3 | (i7 & 896) | (i6 & 7168)).getValue().m4849unboximpl();
            composer2 = startRestartGroup;
            SurfaceKt.m3044Surfaced85dljk(z, function0, semantics, z3, value, m4849unboximpl, m4849unboximpl2, 0.0f, 0.0f, borderStroke, (MutableInteractionSource) null, ComposableLambdaKt.composableLambda(composer2, -1573188346, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Year$2
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

                public final void invoke(Composer composer3, int i8) {
                    ComposerKt.sourceInformation(composer3, "C2117@91715L110:DatePicker.kt#uh7d8r");
                    if ((i8 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1573188346, i8, -1, "androidx.compose.material3.Year.<anonymous> (DatePicker.kt:2117)");
                        }
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer3, 6);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m4109constructorimpl = Updater.m4109constructorimpl(composer3);
                        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 873758912, "C2118@91806L9:DatePicker.kt#uh7d8r");
                        function22.invoke(composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, i5 | (i7 & 112) | (i4 & 7168), 48, 1408);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Year$3
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

                public final void invoke(Composer composer3, int i8) {
                    DatePickerKt.Year(Modifier.this, z, z2, function0, z3, str, datePickerColors, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MonthsNavigation(final Modifier modifier, final boolean z, final boolean z2, final boolean z3, final String str, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Arrangement.HorizontalOrVertical spaceBetween;
        Composer startRestartGroup = composer.startRestartGroup(-773929258);
        ComposerKt.sourceInformation(startRestartGroup, "C(MonthsNavigation)P(1,2,6,8,7,3,4,5)2140@92337L1934:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z2) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(z3) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(str) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 1048576 : Fields.BlendMode;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function03) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? 67108864 : 33554432;
        }
        if ((38347923 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-773929258, i2, -1, "androidx.compose.material3.MonthsNavigation (DatePicker.kt:2139)");
            }
            Modifier m1109requiredHeight3ABfNKs = SizeKt.m1109requiredHeight3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), MonthYearHeight);
            if (z3) {
                spaceBetween = Arrangement.INSTANCE.getStart();
            } else {
                spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1109requiredHeight3ABfNKs);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1911948306, "C2151@92667L1598:DatePicker.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(datePickerColors.getNavigationContentColor())), ComposableLambdaKt.composableLambda(startRestartGroup, -962805198, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C2153@92815L580,2167@93545L696:DatePicker.kt#uh7d8r");
                    if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-962805198, i3, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous> (DatePicker.kt:2153)");
                        }
                        Function0<Unit> function04 = function03;
                        boolean z4 = z3;
                        final String str2 = str;
                        DatePickerKt.YearPickerMenuButton(function04, z4, null, ComposableLambdaKt.composableLambda(composer2, 1377272806, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i4) {
                                ComposerKt.sourceInformation(composer3, "C2158@93045L335,2157@92967L414:DatePicker.kt#uh7d8r");
                                if ((i4 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1377272806, i4, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2157)");
                                    }
                                    String str3 = str2;
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    composer3.startReplaceableGroup(1090374478);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                    boolean changed = composer3.changed(str2);
                                    final String str4 = str2;
                                    Object rememberedValue = composer3.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((SemanticsPropertyReceiver) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                SemanticsPropertiesKt.setLiveRegion-hR3wRGc(semanticsPropertyReceiver, LiveRegionMode.Companion.getPolite-0phEisY());
                                                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str4);
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue);
                                    }
                                    composer3.endReplaceableGroup();
                                    TextKt.m3199Text4IGK_g(str3, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, (Object) null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131068);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, 3072, 4);
                        if (!z3) {
                            Function0<Unit> function05 = function02;
                            boolean z5 = z2;
                            Function0<Unit> function06 = function0;
                            boolean z6 = z;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer2);
                            Updater.m4116setimpl(m4109constructorimpl2, rowMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1090375004, "C2168@93571L321,2174@93913L310:DatePicker.kt#uh7d8r");
                            IconButtonKt.IconButton(function05, null, z5, null, null, ComposableSingletons$DatePickerKt.INSTANCE.m2409getLambda3$material3_release(), composer2, 196608, 26);
                            IconButtonKt.IconButton(function06, null, z6, null, null, ComposableSingletons$DatePickerKt.INSTANCE.m2410getLambda4$material3_release(), composer2, 196608, 26);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, ProvidedValue.$stable | 0 | 48);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    DatePickerKt.MonthsNavigation(Modifier.this, z, z2, z3, str, function0, function02, function03, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void YearPickerMenuButton(final Function0<Unit> function0, final boolean z, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(409654418);
        ComposerKt.sourceInformation(startRestartGroup, "C(YearPickerMenuButton)P(3,1,2)2198@94691L7,2198@94641L58,2194@94512L665:DatePicker.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changedInstance(function2) ? Fields.CameraDistance : Fields.RotationZ;
            }
            i4 = i3;
            if ((i4 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                modifier3 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(409654418, i4, -1, "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:2193)");
                }
                RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
                ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(localContentColor);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ButtonKt.TextButton(function0, modifier3, false, circleShape, buttonDefaults.m2261textButtonColorsro_MJ88(0L, ((Color) consume).m4849unboximpl(), 0L, 0L, startRestartGroup, 24576, 13), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1899012021, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPickerMenuButton$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope rowScope, Composer composer2, int i6) {
                        String m3033getStringNWtq28;
                        ComposerKt.sourceInformation(composer2, "C2202@94766L9,2203@94784L49,2204@94842L329:DatePicker.kt#uh7d8r");
                        if ((i6 & 17) != 16 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1899012021, i6, -1, "androidx.compose.material3.YearPickerMenuButton.<anonymous> (DatePicker.kt:2202)");
                            }
                            function2.invoke(composer2, 0);
                            SpacerKt.Spacer(SizeKt.m1120size3ABfNKs(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m2257getIconSpacingD9Ej5fM()), composer2, 6);
                            ImageVector arrowDropDown = ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE);
                            if (z) {
                                composer2.startReplaceableGroup(1071201785);
                                ComposerKt.sourceInformation(composer2, "2207@94953L49");
                                Strings.Companion companion = Strings.INSTANCE;
                                m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_switch_to_day_selection), composer2, 0);
                                composer2.endReplaceableGroup();
                            } else {
                                composer2.startReplaceableGroup(1071201872);
                                ComposerKt.sourceInformation(composer2, "2209@95040L50");
                                Strings.Companion companion2 = Strings.INSTANCE;
                                m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_switch_to_year_selection), composer2, 0);
                                composer2.endReplaceableGroup();
                            }
                            IconKt.m2622Iconww6aTOc(arrowDropDown, m3033getStringNWtq28, RotateKt.rotate(Modifier.INSTANCE, z ? 180.0f : 0.0f), 0L, composer2, 0, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, (i4 & 14) | 807075840 | ((i4 >> 3) & 112), 388);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier4 = modifier3;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPickerMenuButton$2
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

                    public final void invoke(Composer composer2, int i6) {
                        DatePickerKt.YearPickerMenuButton(function0, z, modifier4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        i4 = i3;
        if ((i4 & 1171) == 1170) {
        }
        if (i5 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        RoundedCornerShape circleShape2 = RoundedCornerShapeKt.getCircleShape();
        ButtonDefaults buttonDefaults2 = ButtonDefaults.INSTANCE;
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ButtonKt.TextButton(function0, modifier3, false, circleShape2, buttonDefaults2.m2261textButtonColorsro_MJ88(0L, ((Color) consume2).m4849unboximpl(), 0L, 0L, startRestartGroup, 24576, 13), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1899012021, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPickerMenuButton$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope rowScope, Composer composer2, int i6) {
                String m3033getStringNWtq28;
                ComposerKt.sourceInformation(composer2, "C2202@94766L9,2203@94784L49,2204@94842L329:DatePicker.kt#uh7d8r");
                if ((i6 & 17) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1899012021, i6, -1, "androidx.compose.material3.YearPickerMenuButton.<anonymous> (DatePicker.kt:2202)");
                    }
                    function2.invoke(composer2, 0);
                    SpacerKt.Spacer(SizeKt.m1120size3ABfNKs(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m2257getIconSpacingD9Ej5fM()), composer2, 6);
                    ImageVector arrowDropDown = ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE);
                    if (z) {
                        composer2.startReplaceableGroup(1071201785);
                        ComposerKt.sourceInformation(composer2, "2207@94953L49");
                        Strings.Companion companion = Strings.INSTANCE;
                        m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_switch_to_day_selection), composer2, 0);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(1071201872);
                        ComposerKt.sourceInformation(composer2, "2209@95040L50");
                        Strings.Companion companion2 = Strings.INSTANCE;
                        m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_switch_to_year_selection), composer2, 0);
                        composer2.endReplaceableGroup();
                    }
                    IconKt.m2622Iconww6aTOc(arrowDropDown, m3033getStringNWtq28, RotateKt.rotate(Modifier.INSTANCE, z ? 180.0f : 0.0f), 0L, composer2, 0, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, (i4 & 14) | 807075840 | ((i4 >> 3) & 112), 388);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(final LazyGridState lazyGridState, final CoroutineScope coroutineScope, String str, String str2) {
        return CollectionsKt.listOf(new CustomAccessibilityAction[]{new CustomAccessibilityAction(str, new Function0<Boolean>() { // from class: androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m2496invoke() {
                boolean z;
                if (LazyGridState.this.getCanScrollBackward()) {
                    BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C06111(LazyGridState.this, null), 3, (Object) null);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DatePicker.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1$1", f = "DatePicker.kt", i = {}, l = {2228}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1$1 */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            public static final class C06111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ LazyGridState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C06111(LazyGridState lazyGridState, Continuation<? super C06111> continuation) {
                    super(2, continuation);
                    this.$state = lazyGridState;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C06111(this.$state, continuation);
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        LazyGridState lazyGridState = this.$state;
                        this.label = 1;
                        if (LazyGridState.scrollToItem$default(lazyGridState, lazyGridState.getFirstVisibleItemIndex() - 3, 0, (Continuation) this, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        }), new CustomAccessibilityAction(str2, new Function0<Boolean>() { // from class: androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m2495invoke() {
                boolean z;
                if (LazyGridState.this.getCanScrollForward()) {
                    BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C06101(LazyGridState.this, null), 3, (Object) null);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DatePicker.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1$1", f = "DatePicker.kt", i = {}, l = {2238}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1$1 */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            public static final class C06101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ LazyGridState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C06101(LazyGridState lazyGridState, Continuation<? super C06101> continuation) {
                    super(2, continuation);
                    this.$state = lazyGridState;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C06101(this.$state, continuation);
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        LazyGridState lazyGridState = this.$state;
                        this.label = 1;
                        if (LazyGridState.scrollToItem$default(lazyGridState, lazyGridState.getFirstVisibleItemIndex() + 3, 0, (Continuation) this, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        })});
    }

    public static final float getRecommendedSizeForAccessibility() {
        return RecommendedSizeForAccessibility;
    }

    public static final float getMonthYearHeight() {
        return MonthYearHeight;
    }

    public static final float getDatePickerHorizontalPadding() {
        return DatePickerHorizontalPadding;
    }

    public static final PaddingValues getDatePickerModeTogglePadding() {
        return DatePickerModeTogglePadding;
    }

    static {
        float f = 12;
        DatePickerHorizontalPadding = Dp.constructor-impl(f);
        DatePickerModeTogglePadding = PaddingKt.m1061PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.constructor-impl(f), Dp.constructor-impl(f), 3, null);
        float f2 = 24;
        float f3 = 16;
        DatePickerTitlePadding = PaddingKt.m1061PaddingValuesa9UjIt4$default(Dp.constructor-impl(f2), Dp.constructor-impl(f3), Dp.constructor-impl(f), 0.0f, 8, null);
        DatePickerHeadlinePadding = PaddingKt.m1061PaddingValuesa9UjIt4$default(Dp.constructor-impl(f2), 0.0f, Dp.constructor-impl(f), Dp.constructor-impl(f), 2, null);
        YearsVerticalPadding = Dp.constructor-impl(f3);
    }
}
