package androidx.compose.p001ui.node;

import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DpRect;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutNodeDrawScope.kt */
@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J4\u0010\r\u001a\u00020\f*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\u0002\b\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0016\u001a\u00020\f*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eJ9\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0004\b\u001f\u0010 J9\u0010!\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0004\b\"\u0010#Jd\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u001b2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\b5\u00106Jd\u0010$\u001a\u00020\f2\u0006\u00107\u001a\u0002082\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u001b2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\b9\u0010:JL\u0010;\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\u0006\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020-2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\b>\u0010?JL\u0010;\u001a\u00020\f2\u0006\u00107\u001a\u0002082\u0006\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020-2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\b@\u0010AJD\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020D2\u0006\u0010,\u001a\u00020-2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\bE\u0010FJ\\\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00102\u0006\u0010J\u001a\u00020H2\u0006\u0010K\u001a\u00020\u00102\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0097\u0001¢\u0006\u0004\bL\u0010MJd\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00102\u0006\u0010J\u001a\u00020H2\u0006\u0010K\u001a\u00020\u00102\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\u0006\u0010N\u001a\u00020OH\u0096\u0001¢\u0006\u0004\bP\u0010QJ^\u0010R\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\u0006\u0010S\u001a\u00020-2\u0006\u0010T\u001a\u00020-2\u0006\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\b\u0001\u0010.\u001a\u00020(2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\bZ\u0010[J^\u0010R\u001a\u00020\f2\u0006\u00107\u001a\u0002082\u0006\u0010S\u001a\u00020-2\u0006\u0010T\u001a\u00020-2\u0006\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\b\u0001\u0010.\u001a\u00020(2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\b\\\u0010]JL\u0010^\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u001b2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\b_\u0010`JL\u0010^\u001a\u00020\f2\u0006\u00107\u001a\u0002082\u0006\u0010,\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u001b2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\ba\u0010bJD\u0010c\u001a\u00020\f2\u0006\u0010d\u001a\u00020e2\u0006\u0010%\u001a\u00020&2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\bf\u0010gJD\u0010c\u001a\u00020\f2\u0006\u0010d\u001a\u00020e2\u0006\u00107\u001a\u0002082\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\bh\u0010iJd\u0010j\u001a\u00020\f2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020-0l2\u0006\u0010m\u001a\u00020n2\u0006\u0010%\u001a\u00020&2\u0006\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\b\u0001\u0010.\u001a\u00020(2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\bo\u0010pJd\u0010j\u001a\u00020\f2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020-0l2\u0006\u0010m\u001a\u00020n2\u0006\u00107\u001a\u0002082\u0006\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\b\u0001\u0010.\u001a\u00020(2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\bq\u0010rJL\u0010s\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u001b2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\bt\u0010`JL\u0010s\u001a\u00020\f2\u0006\u00107\u001a\u0002082\u0006\u0010,\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u001b2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\bu\u0010bJT\u0010v\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u001b2\u0006\u0010w\u001a\u00020x2\b\b\u0001\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\by\u0010zJT\u0010v\u001a\u00020\f2\u0006\u00107\u001a\u0002082\u0006\u0010,\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u001b2\u0006\u0010w\u001a\u00020x2\u0006\u0010/\u001a\u0002002\b\b\u0001\u0010.\u001a\u00020(2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0096\u0001¢\u0006\u0004\b{\u0010|J\u0016\u0010}\u001a\u00020~*\u00020\u007fH\u0097\u0001¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0017\u0010}\u001a\u00020~*\u00030\u0082\u0001H\u0097\u0001¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0017\u0010\u0085\u0001\u001a\u00020\u007f*\u00020~H\u0097\u0001¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0017\u0010\u0085\u0001\u001a\u00020\u007f*\u00020(H\u0097\u0001¢\u0006\u0006\b\u0086\u0001\u0010\u0088\u0001J\u0018\u0010\u0085\u0001\u001a\u00020\u007f*\u00030\u0082\u0001H\u0097\u0001¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u0018\u0010\u008b\u0001\u001a\u00030\u008c\u0001*\u00020\u001bH\u0097\u0001¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u0017\u0010\u008f\u0001\u001a\u00020(*\u00020\u007fH\u0097\u0001¢\u0006\u0006\b\u0090\u0001\u0010\u0088\u0001J\u0018\u0010\u008f\u0001\u001a\u00020(*\u00030\u0082\u0001H\u0097\u0001¢\u0006\u0006\b\u0091\u0001\u0010\u008a\u0001J\u0010\u0010\u0092\u0001\u001a\u00030\u0093\u0001*\u00030\u0094\u0001H\u0097\u0001J\u0018\u0010\u0095\u0001\u001a\u00020\u001b*\u00030\u008c\u0001H\u0097\u0001¢\u0006\u0006\b\u0096\u0001\u0010\u008e\u0001J\u0018\u0010\u0097\u0001\u001a\u00030\u0082\u0001*\u00020~H\u0097\u0001¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u0018\u0010\u0097\u0001\u001a\u00030\u0082\u0001*\u00020(H\u0097\u0001¢\u0006\u0006\b\u0098\u0001\u0010\u009a\u0001J\u0018\u0010\u0097\u0001\u001a\u00030\u0082\u0001*\u00020\u007fH\u0097\u0001¢\u0006\u0006\b\u009b\u0001\u0010\u009a\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010=\u001a\u00020-8VX\u0096\u0005¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0017\u0010\u009e\u0001\u001a\u00020(8\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0016\u0010¡\u0001\u001a\u00030¢\u0001X\u0096\u0005¢\u0006\b\u001a\u0006\b£\u0001\u0010¤\u0001R\u0017\u0010¥\u0001\u001a\u00020(8\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b¦\u0001\u0010 \u0001R\u0016\u0010§\u0001\u001a\u00030¨\u0001X\u0096\u0005¢\u0006\b\u001a\u0006\b©\u0001\u0010ª\u0001R\u0016\u0010\u000f\u001a\u00020\u001b8VX\u0096\u0005¢\u0006\b\u001a\u0006\b«\u0001\u0010\u009d\u0001¨\u0006¬\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "<init>", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "getCanvasDrawScope", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "drawNode", "Landroidx/compose/ui/node/DrawModifierNode;", "drawContent", "", "record", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "size", "Landroidx/compose/ui/unit/IntSize;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "record-JVtK1S4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;JLkotlin/jvm/functions/Function1;)V", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "layer", "draw", "Landroidx/compose/ui/geometry/Size;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/Modifier$Node;", "draw-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "drawDirect", "drawDirect-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/node/DrawModifierNode;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "drawArc", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "", "sweepAngle", "useCenter", "", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "center", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", StrategyConstants.PATH, "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "getCenter-F1C5BW0", "()J", "density", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getSize-NH-jbRc", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {
    public static final int $stable = 0;
    private final CanvasDrawScope canvasDrawScope;
    private DrawModifierNode drawNode;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LayoutNodeDrawScope() {
        this(r0, 1, r0);
        CanvasDrawScope canvasDrawScope = null;
    }

    /* renamed from: drawArc-illE91I, reason: not valid java name */
    public void m1422drawArcillE91I(Brush brush, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawArc-illE91I(brush, startAngle, sweepAngle, useCenter, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    /* renamed from: drawArc-yD3GUKo, reason: not valid java name */
    public void m1423drawArcyD3GUKo(long color, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawArc-yD3GUKo(color, startAngle, sweepAngle, useCenter, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    /* renamed from: drawCircle-V9BoPsw, reason: not valid java name */
    public void m1424drawCircleV9BoPsw(Brush brush, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawCircle-V9BoPsw(brush, radius, center, alpha, style, colorFilter, blendMode);
    }

    /* renamed from: drawCircle-VaOC9Bg, reason: not valid java name */
    public void m1425drawCircleVaOC9Bg(long color, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawCircle-VaOC9Bg(color, radius, center, alpha, style, colorFilter, blendMode);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE, reason: not valid java name */
    public /* synthetic */ void m1427drawImage9jGpkUE(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawImage-9jGpkUE(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode);
    }

    /* renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public void m1428drawImageAZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        this.canvasDrawScope.drawImage-AZ2fEMs(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, filterQuality);
    }

    /* renamed from: drawImage-gbVJVH8, reason: not valid java name */
    public void m1429drawImagegbVJVH8(ImageBitmap image, long topLeft, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawImage-gbVJVH8(image, topLeft, alpha, style, colorFilter, blendMode);
    }

    /* renamed from: drawLine-1RTmtNc, reason: not valid java name */
    public void m1430drawLine1RTmtNc(Brush brush, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawLine-1RTmtNc(brush, start, end, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    /* renamed from: drawLine-NGM6Ib0, reason: not valid java name */
    public void m1431drawLineNGM6Ib0(long color, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawLine-NGM6Ib0(color, start, end, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    /* renamed from: drawOval-AsUm42w, reason: not valid java name */
    public void m1432drawOvalAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawOval-AsUm42w(brush, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    /* renamed from: drawOval-n-J9OG0, reason: not valid java name */
    public void m1433drawOvalnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawOval-n-J9OG0(color, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    /* renamed from: drawPath-GBMwjPU, reason: not valid java name */
    public void m1434drawPathGBMwjPU(Path path, Brush brush, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawPath-GBMwjPU(path, brush, alpha, style, colorFilter, blendMode);
    }

    /* renamed from: drawPath-LG529CI, reason: not valid java name */
    public void m1435drawPathLG529CI(Path path, long color, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawPath-LG529CI(path, color, alpha, style, colorFilter, blendMode);
    }

    /* renamed from: drawPoints-F8ZwMP8, reason: not valid java name */
    public void m1436drawPointsF8ZwMP8(List<Offset> points, int pointMode, long color, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawPoints-F8ZwMP8(points, pointMode, color, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    /* renamed from: drawPoints-Gsft0Ws, reason: not valid java name */
    public void m1437drawPointsGsft0Ws(List<Offset> points, int pointMode, Brush brush, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawPoints-Gsft0Ws(points, pointMode, brush, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    /* renamed from: drawRect-AsUm42w, reason: not valid java name */
    public void m1438drawRectAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawRect-AsUm42w(brush, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    /* renamed from: drawRect-n-J9OG0, reason: not valid java name */
    public void m1439drawRectnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawRect-n-J9OG0(color, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    /* renamed from: drawRoundRect-ZuiqVtQ, reason: not valid java name */
    public void m1440drawRoundRectZuiqVtQ(Brush brush, long topLeft, long size, long cornerRadius, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawRoundRect-ZuiqVtQ(brush, topLeft, size, cornerRadius, alpha, style, colorFilter, blendMode);
    }

    /* renamed from: drawRoundRect-u-Aw5IA, reason: not valid java name */
    public void m1441drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.drawRoundRect-u-Aw5IA(color, topLeft, size, cornerRadius, style, alpha, colorFilter, blendMode);
    }

    /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public long m1442getCenterF1C5BW0() {
        return this.canvasDrawScope.getCenter-F1C5BW0();
    }

    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public long m1443getSizeNHjbRc() {
        return this.canvasDrawScope.getSize-NH-jbRc();
    }

    /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public int m1445roundToPxR2X_6o(long j) {
        return this.canvasDrawScope.roundToPx--R2X_6o(j);
    }

    /* renamed from: roundToPx-0680j_4, reason: not valid java name */
    public int m1446roundToPx0680j_4(float f) {
        return this.canvasDrawScope.roundToPx-0680j_4(f);
    }

    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    public float m1447toDpGaN1DYA(long j) {
        return this.canvasDrawScope.toDp-GaN1DYA(j);
    }

    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float m1448toDpu2uoSUM(float f) {
        return this.canvasDrawScope.toDp-u2uoSUM(f);
    }

    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float m1449toDpu2uoSUM(int i) {
        return this.canvasDrawScope.toDp-u2uoSUM(i);
    }

    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public long m1450toDpSizekrfVVM(long j) {
        return this.canvasDrawScope.toDpSize-k-rfVVM(j);
    }

    /* renamed from: toPx--R2X_6o, reason: not valid java name */
    public float m1451toPxR2X_6o(long j) {
        return this.canvasDrawScope.toPx--R2X_6o(j);
    }

    /* renamed from: toPx-0680j_4, reason: not valid java name */
    public float m1452toPx0680j_4(float f) {
        return this.canvasDrawScope.toPx-0680j_4(f);
    }

    public Rect toRect(DpRect dpRect) {
        return this.canvasDrawScope.toRect(dpRect);
    }

    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public long m1453toSizeXkaWNTQ(long j) {
        return this.canvasDrawScope.toSize-XkaWNTQ(j);
    }

    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    public long m1454toSp0xMU5do(float f) {
        return this.canvasDrawScope.toSp-0xMU5do(f);
    }

    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long m1455toSpkPz2Gy4(float f) {
        return this.canvasDrawScope.toSp-kPz2Gy4(f);
    }

    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long m1456toSpkPz2Gy4(int i) {
        return this.canvasDrawScope.toSp-kPz2Gy4(i);
    }

    public LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope) {
        this.canvasDrawScope = canvasDrawScope;
    }

    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }

    public final CanvasDrawScope getCanvasDrawScope() {
        return this.canvasDrawScope;
    }

    public void drawContent() {
        Modifier.Node nextDrawNode;
        Canvas canvas = getDrawContext().getCanvas();
        DrawModifierNode drawModifierNode = this.drawNode;
        if (drawModifierNode != null) {
            DrawModifierNode drawModifierNode2 = drawModifierNode;
            nextDrawNode = LayoutNodeDrawScopeKt.nextDrawNode(drawModifierNode2);
            if (nextDrawNode == null) {
                NodeCoordinator m1341requireCoordinator64DMado = DelegatableNodeKt.m1341requireCoordinator64DMado(drawModifierNode2, NodeKind.m1562constructorimpl(4));
                if (m1341requireCoordinator64DMado.getTail() == drawModifierNode.getNode()) {
                    m1341requireCoordinator64DMado = m1341requireCoordinator64DMado.getWrapped();
                    Intrinsics.checkNotNull(m1341requireCoordinator64DMado);
                }
                m1341requireCoordinator64DMado.performDraw(canvas, getDrawContext().getGraphicsLayer());
                return;
            }
            int m1562constructorimpl = NodeKind.m1562constructorimpl(4);
            MutableVector mutableVector = null;
            while (nextDrawNode != null) {
                if (nextDrawNode instanceof DrawModifierNode) {
                    performDraw((DrawModifierNode) nextDrawNode, canvas, getDrawContext().getGraphicsLayer());
                } else if (((nextDrawNode.getKindSet$ui_release() & m1562constructorimpl) != 0) && (nextDrawNode instanceof DelegatingNode)) {
                    int i = 0;
                    for (Modifier.Node delegate = ((DelegatingNode) nextDrawNode).getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                        if ((delegate.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                            i++;
                            if (i == 1) {
                                nextDrawNode = delegate;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (nextDrawNode != null) {
                                    if (mutableVector != null) {
                                        mutableVector.add(nextDrawNode);
                                    }
                                    nextDrawNode = null;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate);
                                }
                            }
                        }
                    }
                    if (i == 1) {
                    }
                }
                nextDrawNode = DelegatableNodeKt.pop(mutableVector);
            }
            return;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Attempting to drawContent for a `null` node. This usually means that a call to ContentDrawScope#drawContent() has been captured inside a lambda, and is being invoked outside of the draw pass. Capturing the scope this way is unsupported - if you are trying to record drawContent with graphicsLayer.record(), make sure you are using the GraphicsLayer#record function within DrawScope, instead of the member function on GraphicsLayer.");
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: record-JVtK1S4, reason: not valid java name */
    public void m1444recordJVtK1S4(GraphicsLayer graphicsLayer, long j, final Function1<? super DrawScope, Unit> function1) {
        final DrawModifierNode drawModifierNode = this.drawNode;
        graphicsLayer.record-mL-hObY((Density) this, getLayoutDirection(), j, new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeDrawScope$record$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DrawScope drawScope) {
                DrawContext drawContext;
                drawContext = LayoutNodeDrawScope.this.drawNode;
                LayoutNodeDrawScope.this.drawNode = drawModifierNode;
                try {
                    LayoutNodeDrawScope layoutNodeDrawScope = LayoutNodeDrawScope.this;
                    Density density = drawScope.getDrawContext().getDensity();
                    LayoutDirection layoutDirection = drawScope.getDrawContext().getLayoutDirection();
                    Canvas canvas = drawScope.getDrawContext().getCanvas();
                    long j2 = drawScope.getDrawContext().getSize-NH-jbRc();
                    GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
                    Function1<DrawScope, Unit> function12 = function1;
                    Density density2 = layoutNodeDrawScope.getDrawContext().getDensity();
                    LayoutDirection layoutDirection2 = layoutNodeDrawScope.getDrawContext().getLayoutDirection();
                    Canvas canvas2 = layoutNodeDrawScope.getDrawContext().getCanvas();
                    long j3 = layoutNodeDrawScope.getDrawContext().getSize-NH-jbRc();
                    GraphicsLayer graphicsLayer3 = layoutNodeDrawScope.getDrawContext().getGraphicsLayer();
                    try {
                        drawContext = layoutNodeDrawScope.getDrawContext();
                        drawContext.setDensity(density);
                        drawContext.setLayoutDirection(layoutDirection);
                        drawContext.setCanvas(canvas);
                        drawContext.setSize-uvyYCjk(j2);
                        drawContext.setGraphicsLayer(graphicsLayer2);
                        canvas.save();
                        try {
                            function12.invoke(layoutNodeDrawScope);
                            canvas.restore();
                            DrawContext drawContext2 = layoutNodeDrawScope.getDrawContext();
                            drawContext2.setDensity(density2);
                            drawContext2.setLayoutDirection(layoutDirection2);
                            drawContext2.setCanvas(canvas2);
                            drawContext2.setSize-uvyYCjk(j3);
                            drawContext2.setGraphicsLayer(graphicsLayer3);
                            LayoutNodeDrawScope.this.drawNode = drawContext;
                        } catch (Throwable th) {
                            canvas.restore();
                            DrawContext drawContext3 = layoutNodeDrawScope.getDrawContext();
                            drawContext3.setDensity(density2);
                            drawContext3.setLayoutDirection(layoutDirection2);
                            drawContext3.setCanvas(canvas2);
                            drawContext3.setSize-uvyYCjk(j3);
                            drawContext3.setGraphicsLayer(graphicsLayer3);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        drawContext = drawContext;
                        LayoutNodeDrawScope.this.drawNode = drawContext;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        });
    }

    public final void performDraw(DrawModifierNode drawModifierNode, Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator m1341requireCoordinator64DMado = DelegatableNodeKt.m1341requireCoordinator64DMado(drawModifierNode, NodeKind.m1562constructorimpl(4));
        m1341requireCoordinator64DMado.getLayoutNode().getMDrawScope$ui_release().m1426drawDirecteZhPAX0$ui_release(canvas, IntSizeKt.m2863toSizeozmzZPI(m1341requireCoordinator64DMado.m1533getSizeYbymL2g()), m1341requireCoordinator64DMado, drawModifierNode, graphicsLayer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: drawDirect-eZhPAX0$ui_release, reason: not valid java name */
    public final void m1426drawDirecteZhPAX0$ui_release(Canvas canvas, long size, NodeCoordinator coordinator, DrawModifierNode drawNode, GraphicsLayer layer) {
        DrawModifierNode drawModifierNode = this.drawNode;
        this.drawNode = drawNode;
        DrawScope drawScope = this.canvasDrawScope;
        LayoutDirection layoutDirection = coordinator.getLayoutDirection();
        Density density = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long j = drawScope.getDrawContext().getSize-NH-jbRc();
        GraphicsLayer graphicsLayer = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity((Density) coordinator);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.setSize-uvyYCjk(size);
        drawContext.setGraphicsLayer(layer);
        canvas.save();
        try {
            drawNode.draw(this);
            canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.setSize-uvyYCjk(j);
            drawContext2.setGraphicsLayer(graphicsLayer);
            this.drawNode = drawModifierNode;
        } catch (Throwable th) {
            canvas.restore();
            DrawContext drawContext3 = drawScope.getDrawContext();
            drawContext3.setDensity(density);
            drawContext3.setLayoutDirection(layoutDirection2);
            drawContext3.setCanvas(canvas2);
            drawContext3.setSize-uvyYCjk(j);
            drawContext3.setGraphicsLayer(graphicsLayer);
            throw th;
        }
    }

    /* renamed from: draw-eZhPAX0$ui_release, reason: not valid java name */
    public final void m1421draweZhPAX0$ui_release(Canvas canvas, long size, NodeCoordinator coordinator, Modifier.Node drawNode, GraphicsLayer layer) {
        int m1562constructorimpl = NodeKind.m1562constructorimpl(4);
        Modifier.Node node = drawNode;
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof DrawModifierNode) {
                m1426drawDirecteZhPAX0$ui_release(canvas, size, coordinator, (DrawModifierNode) node, layer);
            } else if (((node.getKindSet$ui_release() & m1562constructorimpl) != 0) && (node instanceof DelegatingNode)) {
                int i = 0;
                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                    if ((delegate.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            node = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                }
                if (i == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector);
        }
    }
}
