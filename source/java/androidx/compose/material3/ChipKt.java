package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p002ui.graphics.GraphicsLayerScope;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.layout.LayoutIdKt;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a¦\u0001\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010%\u001a¦\u0001\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010'\u001a¹\u0001\u0010(\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0003ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a\u0094\u0001\u00101\u001a\u00020\u00112\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a¦\u0001\u00107\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010%\u001a¦\u0001\u00107\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010'\u001a®\u0001\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\u001a\u008f\u0001\u0010=\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010?\u001a\u008f\u0001\u0010=\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010@\u001a®\u0001\u0010A\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\u001aÅ\u0001\u0010B\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010C\u001aÎ\u0001\u0010D\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020:2\b\u0010\u001f\u001a\u0004\u0018\u00010;2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0003ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a\u008f\u0001\u0010G\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010?\u001a\u008f\u0001\u0010G\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010@\u001a&\u0010H\u001a\u00020\u00012\b\b\u0002\u0010I\u001a\u00020\u00192\b\b\u0002\u0010J\u001a\u00020\u00192\b\b\u0002\u0010K\u001a\u00020\u0019H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"AssistChipPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "FilterChipPadding", "HorizontalElementsPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LabelLayoutId", "", "LeadingIconLayoutId", "SuggestionChipPadding", "TrailingIconLayoutId", "defaultSuggestionChipColors", "Landroidx/compose/material3/ChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSuggestionChipColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "AssistChip", "", "onClick", "Lkotlin/Function0;", ChipKt.LabelLayoutId, "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", ChipKt.LeadingIconLayoutId, ChipKt.TrailingIconLayoutId, "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "elevation", "Landroidx/compose/material3/ChipElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/ChipBorder;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Chip", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "minHeight", "paddingValues", "Chip-nkUnTEs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ChipContent", "avatar", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "ElevatedAssistChip", "ElevatedFilterChip", "selected", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/SelectableChipElevation;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedSuggestionChip", "icon", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "InputChip", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SelectableChip", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SuggestionChip", "inputChipPadding", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ChipKt {
    private static final PaddingValues AssistChipPadding;
    private static final PaddingValues FilterChipPadding;
    private static final float HorizontalElementsPadding;
    private static final String LabelLayoutId = "label";
    private static final String LeadingIconLayoutId = "leadingIcon";
    private static final PaddingValues SuggestionChipPadding;
    private static final String TrailingIconLayoutId = "trailingIcon";

    /* JADX WARN: Removed duplicated region for block: B:101:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AssistChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        int i7;
        ChipColors chipColors2;
        int i8;
        int i9;
        int i10;
        Shape shape2;
        int i11;
        int i12;
        ChipElevation chipElevation2;
        BorderStroke borderStroke2;
        int i13;
        MutableInteractionSource mutableInteractionSource2;
        BorderStroke borderStroke3;
        int i14;
        Shape shape3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        ChipElevation chipElevation3;
        int i15;
        final ChipElevation chipElevation4;
        final BorderStroke borderStroke4;
        final boolean z3;
        MutableInteractionSource mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Shape shape4;
        final ChipColors chipColors3;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        ScopeUpdateScope endRestartGroup;
        int i16;
        int i17;
        int i18;
        Composer startRestartGroup = composer.startRestartGroup(313450168);
        ComposerKt.sourceInformation(startRestartGroup, "C(AssistChip)P(8,5,7,3,6,10,9,1,2)119@6048L5,120@6099L18,121@6170L21,122@6240L25,123@6317L39,129@6493L10,124@6362L507:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i19 = i3 & 4;
        if (i19 != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i4 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? Fields.Clip : Fields.Shape;
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= 196608;
                    } else if ((i & 196608) == 0) {
                        i4 |= startRestartGroup.changedInstance(function23) ? Fields.RenderEffect : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(shape)) ? 1048576 : Fields.BlendMode;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & Fields.SpotShadowColor) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i18 = 8388608;
                                i4 |= i18;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i18 = 4194304;
                        i4 |= i18;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i3 & Fields.RotationX) == 0 && startRestartGroup.changed(chipElevation)) {
                            i17 = 67108864;
                            i4 |= i17;
                        }
                        i17 = 33554432;
                        i4 |= i17;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & Fields.RotationY) == 0 && startRestartGroup.changed(borderStroke)) {
                            i16 = 536870912;
                            i4 |= i16;
                        }
                        i16 = 268435456;
                        i4 |= i16;
                    }
                    i8 = i3 & Fields.RotationZ;
                    if (i8 == 0) {
                        i9 = i8;
                        i10 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i9 = i8;
                        i10 = i2 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                    } else {
                        i9 = i8;
                        i10 = i2;
                    }
                    if ((i4 & 306783379) != 306783378 && (i10 & 3) == 2 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        function26 = function23;
                        chipElevation4 = chipElevation;
                        borderStroke4 = borderStroke;
                        mutableInteractionSource3 = mutableInteractionSource;
                        chipColors3 = chipColors2;
                        modifier3 = modifier2;
                        z3 = z2;
                        function27 = function22;
                        shape4 = shape;
                    } else {
                        startRestartGroup.startDefaults();
                        int i20 = i10;
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i19 == 0 ? Modifier.INSTANCE : modifier2;
                            boolean z4 = i5 == 0 ? true : z2;
                            Function2<? super Composer, ? super Integer, Unit> function28 = i6 == 0 ? null : function22;
                            Function2<? super Composer, ? super Integer, Unit> function29 = i7 == 0 ? null : function23;
                            if ((i3 & 64) == 0) {
                                i4 &= -3670017;
                                shape2 = AssistChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            } else {
                                shape2 = shape;
                            }
                            if ((i3 & Fields.SpotShadowColor) != 0) {
                                chipColors2 = AssistChipDefaults.INSTANCE.assistChipColors(startRestartGroup, 6);
                                i4 &= -29360129;
                            }
                            int i21 = i4;
                            ChipColors chipColors4 = chipColors2;
                            if ((i3 & Fields.RotationX) == 0) {
                                i11 = i20;
                                i12 = i21 & (-234881025);
                                chipElevation2 = AssistChipDefaults.INSTANCE.m2215assistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                            } else {
                                i11 = i20;
                                i12 = i21;
                                chipElevation2 = chipElevation;
                            }
                            if ((i3 & Fields.RotationY) == 0) {
                                borderStroke2 = AssistChipDefaults.INSTANCE.m2213assistChipBorderh1eTWw(z4, 0L, 0L, 0.0f, startRestartGroup, ((i12 >> 9) & 14) | 24576, 14);
                                i13 = i12 & (-1879048193);
                            } else {
                                borderStroke2 = borderStroke;
                                i13 = i12;
                            }
                            if (i9 == 0) {
                                startRestartGroup.startReplaceableGroup(839902005);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Chip.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                modifier2 = companion;
                                borderStroke3 = borderStroke2;
                                i14 = i13;
                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier2 = companion;
                                borderStroke3 = borderStroke2;
                                i14 = i13;
                            }
                            shape3 = shape2;
                            z2 = z4;
                            function24 = function28;
                            function25 = function29;
                            chipColors2 = chipColors4;
                            chipElevation3 = chipElevation2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                            }
                            if ((i3 & Fields.SpotShadowColor) != 0) {
                                i4 &= -29360129;
                            }
                            if ((i3 & Fields.RotationX) != 0) {
                                i4 &= -234881025;
                            }
                            if ((i3 & Fields.RotationY) != 0) {
                                i4 &= -1879048193;
                            }
                            function24 = function22;
                            shape3 = shape;
                            chipElevation3 = chipElevation;
                            borderStroke3 = borderStroke;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i11 = i20;
                            i14 = i4;
                            function25 = function23;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            i15 = i11;
                        } else {
                            i15 = i11;
                            ComposerKt.traceEventStart(313450168, i14, i15, "androidx.compose.material3.AssistChip (Chip.kt:124)");
                        }
                        int i22 = i14 << 6;
                        int i23 = ((i14 >> 6) & 14) | ((i14 << 3) & 112) | ((i14 >> 3) & 896) | (i22 & 7168) | (3670016 & i22) | (29360128 & i22) | (234881024 & i22) | (i22 & 1879048192);
                        int i24 = i14 >> 24;
                        m2325ChipnkUnTEs(modifier2, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function24, function25, shape3, chipColors2, chipElevation3, borderStroke3, AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, i23, (i24 & 112) | (i24 & 14) | 3456 | ((i15 << 12) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        chipElevation4 = chipElevation3;
                        borderStroke4 = borderStroke3;
                        z3 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function26 = function25;
                        shape4 = shape3;
                        chipColors3 = chipColors2;
                        modifier3 = modifier2;
                        function27 = function24;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$AssistChip$2
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

                            public final void invoke(Composer composer2, int i25) {
                                ChipKt.AssistChip(function0, function2, modifier3, z3, function27, function26, shape4, chipColors3, chipElevation4, borderStroke4, mutableInteractionSource4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i8 = i3 & Fields.RotationZ;
                if (i8 == 0) {
                }
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                int i202 = i10;
                if ((i & 1) != 0) {
                }
                if (i19 == 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if ((i3 & 64) == 0) {
                }
                if ((i3 & Fields.SpotShadowColor) != 0) {
                }
                int i212 = i4;
                ChipColors chipColors42 = chipColors2;
                if ((i3 & Fields.RotationX) == 0) {
                }
                if ((i3 & Fields.RotationY) == 0) {
                }
                if (i9 == 0) {
                }
                shape3 = shape2;
                z2 = z4;
                function24 = function28;
                function25 = function29;
                chipColors2 = chipColors42;
                chipElevation3 = chipElevation2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i222 = i14 << 6;
                int i232 = ((i14 >> 6) & 14) | ((i14 << 3) & 112) | ((i14 >> 3) & 896) | (i222 & 7168) | (3670016 & i222) | (29360128 & i222) | (234881024 & i222) | (i222 & 1879048192);
                int i242 = i14 >> 24;
                m2325ChipnkUnTEs(modifier2, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function24, function25, shape3, chipColors2, chipElevation3, borderStroke3, AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, i232, (i242 & 112) | (i242 & 14) | 3456 | ((i15 << 12) & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                chipElevation4 = chipElevation3;
                borderStroke4 = borderStroke3;
                z3 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                function26 = function25;
                shape4 = shape3;
                chipColors3 = chipColors2;
                modifier3 = modifier2;
                function27 = function24;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i8 = i3 & Fields.RotationZ;
            if (i8 == 0) {
            }
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            int i2022 = i10;
            if ((i & 1) != 0) {
            }
            if (i19 == 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if ((i3 & 64) == 0) {
            }
            if ((i3 & Fields.SpotShadowColor) != 0) {
            }
            int i2122 = i4;
            ChipColors chipColors422 = chipColors2;
            if ((i3 & Fields.RotationX) == 0) {
            }
            if ((i3 & Fields.RotationY) == 0) {
            }
            if (i9 == 0) {
            }
            shape3 = shape2;
            z2 = z4;
            function24 = function28;
            function25 = function29;
            chipColors2 = chipColors422;
            chipElevation3 = chipElevation2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i2222 = i14 << 6;
            int i2322 = ((i14 >> 6) & 14) | ((i14 << 3) & 112) | ((i14 >> 3) & 896) | (i2222 & 7168) | (3670016 & i2222) | (29360128 & i2222) | (234881024 & i2222) | (i2222 & 1879048192);
            int i2422 = i14 >> 24;
            m2325ChipnkUnTEs(modifier2, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function24, function25, shape3, chipColors2, chipElevation3, borderStroke3, AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, i2322, (i2422 & 112) | (i2422 & 14) | 3456 | ((i15 << 12) & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            chipElevation4 = chipElevation3;
            borderStroke4 = borderStroke3;
            z3 = z2;
            mutableInteractionSource3 = mutableInteractionSource2;
            function26 = function25;
            shape4 = shape3;
            chipColors3 = chipColors2;
            modifier3 = modifier2;
            function27 = function24;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i8 = i3 & Fields.RotationZ;
        if (i8 == 0) {
        }
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        int i20222 = i10;
        if ((i & 1) != 0) {
        }
        if (i19 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if ((i3 & 64) == 0) {
        }
        if ((i3 & Fields.SpotShadowColor) != 0) {
        }
        int i21222 = i4;
        ChipColors chipColors4222 = chipColors2;
        if ((i3 & Fields.RotationX) == 0) {
        }
        if ((i3 & Fields.RotationY) == 0) {
        }
        if (i9 == 0) {
        }
        shape3 = shape2;
        z2 = z4;
        function24 = function28;
        function25 = function29;
        chipColors2 = chipColors4222;
        chipElevation3 = chipElevation2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i22222 = i14 << 6;
        int i23222 = ((i14 >> 6) & 14) | ((i14 << 3) & 112) | ((i14 >> 3) & 896) | (i22222 & 7168) | (3670016 & i22222) | (29360128 & i22222) | (234881024 & i22222) | (i22222 & 1879048192);
        int i24222 = i14 >> 24;
        m2325ChipnkUnTEs(modifier2, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function24, function25, shape3, chipColors2, chipElevation3, borderStroke3, AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, i23222, (i24222 & 112) | (i24222 & 14) | 3456 | ((i15 << 12) & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        chipElevation4 = chipElevation3;
        borderStroke4 = borderStroke3;
        z3 = z2;
        mutableInteractionSource3 = mutableInteractionSource2;
        function26 = function25;
        shape4 = shape3;
        chipColors3 = chipColors2;
        modifier3 = modifier2;
        function27 = function24;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x033c  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with AssistChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "AssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void AssistChip(final Function0 function0, final Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        int i7;
        ChipColors chipColors2;
        int i8;
        int i9;
        int i10;
        Shape shape2;
        int i11;
        ChipElevation chipElevation2;
        ChipBorder chipBorder2;
        int i12;
        MutableInteractionSource mutableInteractionSource2;
        ChipBorder chipBorder3;
        int i13;
        Shape shape3;
        Function2 function24;
        Function2 function25;
        int i14;
        final ChipColors chipColors3;
        final Modifier modifier3;
        MutableInteractionSource mutableInteractionSource3;
        final boolean z3;
        final ChipElevation chipElevation3;
        final ChipBorder chipBorder4;
        final Function2 function26;
        final Function2 function27;
        final Shape shape4;
        ScopeUpdateScope endRestartGroup;
        int i15;
        int i16;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(-1932300596);
        ComposerKt.sourceInformation(startRestartGroup, "C(AssistChip)P(8,5,7,3,6,10,9,1,2)199@10095L5,200@10146L18,201@10217L21,202@10285L18,203@10355L39,209@10531L10,204@10400L537:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i18 = i3 & 4;
        if (i18 != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i4 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? Fields.Clip : Fields.Shape;
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= 196608;
                    } else if ((i & 196608) == 0) {
                        i4 |= startRestartGroup.changedInstance(function23) ? Fields.RenderEffect : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(shape)) ? 1048576 : Fields.BlendMode;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & Fields.SpotShadowColor) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i17 = 8388608;
                                i4 |= i17;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i17 = 4194304;
                        i4 |= i17;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i3 & Fields.RotationX) == 0 && startRestartGroup.changed(chipElevation)) {
                            i16 = 67108864;
                            i4 |= i16;
                        }
                        i16 = 33554432;
                        i4 |= i16;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & Fields.RotationY) == 0 && startRestartGroup.changed(chipBorder)) {
                            i15 = 536870912;
                            i4 |= i15;
                        }
                        i15 = 268435456;
                        i4 |= i15;
                    }
                    i8 = i3 & Fields.RotationZ;
                    if (i8 == 0) {
                        i9 = i8;
                        i10 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i9 = i8;
                        i10 = i2 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                    } else {
                        i9 = i8;
                        i10 = i2;
                    }
                    if ((i4 & 306783379) != 306783378 && (i10 & 3) == 2 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        function27 = function23;
                        chipElevation3 = chipElevation;
                        chipBorder4 = chipBorder;
                        mutableInteractionSource3 = mutableInteractionSource;
                        chipColors3 = chipColors2;
                        modifier3 = modifier2;
                        z3 = z2;
                        function26 = function22;
                        shape4 = shape;
                    } else {
                        startRestartGroup.startDefaults();
                        int i19 = i10;
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i18 == 0 ? Modifier.INSTANCE : modifier2;
                            boolean z4 = i5 == 0 ? true : z2;
                            Function2 function28 = i6 == 0 ? null : function22;
                            Function2 function29 = i7 == 0 ? null : function23;
                            if ((i3 & 64) == 0) {
                                i4 &= -3670017;
                                shape2 = AssistChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            } else {
                                shape2 = shape;
                            }
                            if ((i3 & Fields.SpotShadowColor) != 0) {
                                chipColors2 = AssistChipDefaults.INSTANCE.assistChipColors(startRestartGroup, 6);
                                i4 &= -29360129;
                            }
                            int i20 = i4;
                            ChipColors chipColors4 = chipColors2;
                            if ((i3 & Fields.RotationX) == 0) {
                                i11 = i19;
                                i20 &= -234881025;
                                chipElevation2 = AssistChipDefaults.INSTANCE.m2215assistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                            } else {
                                i11 = i19;
                                chipElevation2 = chipElevation;
                            }
                            if ((i3 & Fields.RotationY) == 0) {
                                chipBorder2 = AssistChipDefaults.INSTANCE.m2212assistChipBorderd_3_b6Q(0L, 0L, 0.0f, startRestartGroup, 3072, 7);
                                i12 = i20 & (-1879048193);
                            } else {
                                chipBorder2 = chipBorder;
                                i12 = i20;
                            }
                            if (i9 == 0) {
                                startRestartGroup.startReplaceableGroup(839906043);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Chip.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                modifier2 = companion;
                                chipBorder3 = chipBorder2;
                                i13 = i12;
                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier2 = companion;
                                chipBorder3 = chipBorder2;
                                i13 = i12;
                            }
                            shape3 = shape2;
                            z2 = z4;
                            function24 = function28;
                            function25 = function29;
                            chipColors2 = chipColors4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                            }
                            if ((i3 & Fields.SpotShadowColor) != 0) {
                                i4 &= -29360129;
                            }
                            if ((i3 & Fields.RotationX) != 0) {
                                i4 &= -234881025;
                            }
                            if ((i3 & Fields.RotationY) != 0) {
                                i4 &= -1879048193;
                            }
                            function24 = function22;
                            shape3 = shape;
                            chipElevation2 = chipElevation;
                            chipBorder3 = chipBorder;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i11 = i19;
                            i13 = i4;
                            function25 = function23;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            i14 = i11;
                        } else {
                            i14 = i11;
                            ComposerKt.traceEventStart(-1932300596, i13, i14, "androidx.compose.material3.AssistChip (Chip.kt:204)");
                        }
                        TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
                        long m2315labelColorvNxB06k$material3_release = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
                        startRestartGroup.startReplaceableGroup(839906470);
                        ComposerKt.sourceInformation(startRestartGroup, "216@10782L21");
                        State<BorderStroke> borderStroke$material3_release = chipBorder3 != null ? null : chipBorder3.borderStroke$material3_release(z2, startRestartGroup, ((i13 >> 9) & 14) | ((i13 >> 24) & 112));
                        startRestartGroup.endReplaceableGroup();
                        BorderStroke value = borderStroke$material3_release == null ? borderStroke$material3_release.getValue() : null;
                        ChipBorder chipBorder5 = chipBorder3;
                        int i21 = i13 << 6;
                        m2325ChipnkUnTEs(modifier2, function0, z2, function2, fromToken, m2315labelColorvNxB06k$material3_release, function24, function25, shape3, chipColors2, chipElevation2, value, AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, ((i13 >> 3) & 896) | ((i13 >> 6) & 14) | ((i13 << 3) & 112) | (i21 & 7168) | (3670016 & i21) | (29360128 & i21) | (234881024 & i21) | (i21 & 1879048192), ((i13 >> 24) & 14) | 3456 | ((i14 << 12) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        chipColors3 = chipColors2;
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z3 = z2;
                        chipElevation3 = chipElevation2;
                        chipBorder4 = chipBorder5;
                        function26 = function24;
                        function27 = function25;
                        shape4 = shape3;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$AssistChip$4
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

                            public final void invoke(Composer composer2, int i22) {
                                ChipKt.AssistChip(function0, function2, modifier3, z3, function26, function27, shape4, chipColors3, chipElevation3, chipBorder4, mutableInteractionSource4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i8 = i3 & Fields.RotationZ;
                if (i8 == 0) {
                }
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                int i192 = i10;
                if ((i & 1) != 0) {
                }
                if (i18 == 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if ((i3 & 64) == 0) {
                }
                if ((i3 & Fields.SpotShadowColor) != 0) {
                }
                int i202 = i4;
                ChipColors chipColors42 = chipColors2;
                if ((i3 & Fields.RotationX) == 0) {
                }
                if ((i3 & Fields.RotationY) == 0) {
                }
                if (i9 == 0) {
                }
                shape3 = shape2;
                z2 = z4;
                function24 = function28;
                function25 = function29;
                chipColors2 = chipColors42;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
                long m2315labelColorvNxB06k$material3_release2 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
                startRestartGroup.startReplaceableGroup(839906470);
                ComposerKt.sourceInformation(startRestartGroup, "216@10782L21");
                if (chipBorder3 != null) {
                }
                startRestartGroup.endReplaceableGroup();
                if (borderStroke$material3_release == null) {
                }
                ChipBorder chipBorder52 = chipBorder3;
                int i212 = i13 << 6;
                m2325ChipnkUnTEs(modifier2, function0, z2, function2, fromToken2, m2315labelColorvNxB06k$material3_release2, function24, function25, shape3, chipColors2, chipElevation2, value, AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, ((i13 >> 3) & 896) | ((i13 >> 6) & 14) | ((i13 << 3) & 112) | (i212 & 7168) | (3670016 & i212) | (29360128 & i212) | (234881024 & i212) | (i212 & 1879048192), ((i13 >> 24) & 14) | 3456 | ((i14 << 12) & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                chipColors3 = chipColors2;
                modifier3 = modifier2;
                mutableInteractionSource3 = mutableInteractionSource2;
                z3 = z2;
                chipElevation3 = chipElevation2;
                chipBorder4 = chipBorder52;
                function26 = function24;
                function27 = function25;
                shape4 = shape3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i8 = i3 & Fields.RotationZ;
            if (i8 == 0) {
            }
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            int i1922 = i10;
            if ((i & 1) != 0) {
            }
            if (i18 == 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if ((i3 & 64) == 0) {
            }
            if ((i3 & Fields.SpotShadowColor) != 0) {
            }
            int i2022 = i4;
            ChipColors chipColors422 = chipColors2;
            if ((i3 & Fields.RotationX) == 0) {
            }
            if ((i3 & Fields.RotationY) == 0) {
            }
            if (i9 == 0) {
            }
            shape3 = shape2;
            z2 = z4;
            function24 = function28;
            function25 = function29;
            chipColors2 = chipColors422;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            TextStyle fromToken22 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
            long m2315labelColorvNxB06k$material3_release22 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
            startRestartGroup.startReplaceableGroup(839906470);
            ComposerKt.sourceInformation(startRestartGroup, "216@10782L21");
            if (chipBorder3 != null) {
            }
            startRestartGroup.endReplaceableGroup();
            if (borderStroke$material3_release == null) {
            }
            ChipBorder chipBorder522 = chipBorder3;
            int i2122 = i13 << 6;
            m2325ChipnkUnTEs(modifier2, function0, z2, function2, fromToken22, m2315labelColorvNxB06k$material3_release22, function24, function25, shape3, chipColors2, chipElevation2, value, AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, ((i13 >> 3) & 896) | ((i13 >> 6) & 14) | ((i13 << 3) & 112) | (i2122 & 7168) | (3670016 & i2122) | (29360128 & i2122) | (234881024 & i2122) | (i2122 & 1879048192), ((i13 >> 24) & 14) | 3456 | ((i14 << 12) & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            chipColors3 = chipColors2;
            modifier3 = modifier2;
            mutableInteractionSource3 = mutableInteractionSource2;
            z3 = z2;
            chipElevation3 = chipElevation2;
            chipBorder4 = chipBorder522;
            function26 = function24;
            function27 = function25;
            shape4 = shape3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i8 = i3 & Fields.RotationZ;
        if (i8 == 0) {
        }
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        int i19222 = i10;
        if ((i & 1) != 0) {
        }
        if (i18 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if ((i3 & 64) == 0) {
        }
        if ((i3 & Fields.SpotShadowColor) != 0) {
        }
        int i20222 = i4;
        ChipColors chipColors4222 = chipColors2;
        if ((i3 & Fields.RotationX) == 0) {
        }
        if ((i3 & Fields.RotationY) == 0) {
        }
        if (i9 == 0) {
        }
        shape3 = shape2;
        z2 = z4;
        function24 = function28;
        function25 = function29;
        chipColors2 = chipColors4222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        TextStyle fromToken222 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
        long m2315labelColorvNxB06k$material3_release222 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
        startRestartGroup.startReplaceableGroup(839906470);
        ComposerKt.sourceInformation(startRestartGroup, "216@10782L21");
        if (chipBorder3 != null) {
        }
        startRestartGroup.endReplaceableGroup();
        if (borderStroke$material3_release == null) {
        }
        ChipBorder chipBorder5222 = chipBorder3;
        int i21222 = i13 << 6;
        m2325ChipnkUnTEs(modifier2, function0, z2, function2, fromToken222, m2315labelColorvNxB06k$material3_release222, function24, function25, shape3, chipColors2, chipElevation2, value, AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, ((i13 >> 3) & 896) | ((i13 >> 6) & 14) | ((i13 << 3) & 112) | (i21222 & 7168) | (3670016 & i21222) | (29360128 & i21222) | (234881024 & i21222) | (i21222 & 1879048192), ((i13 >> 24) & 14) | 3456 | ((i14 << 12) & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        chipColors3 = chipColors2;
        modifier3 = modifier2;
        mutableInteractionSource3 = mutableInteractionSource2;
        z3 = z2;
        chipElevation3 = chipElevation2;
        chipBorder4 = chipBorder5222;
        function26 = function24;
        function27 = function25;
        shape4 = shape3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedAssistChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        int i7;
        ChipColors chipColors2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Shape shape2;
        int i13;
        ChipElevation chipElevation2;
        int i14;
        MutableInteractionSource mutableInteractionSource2;
        ChipElevation chipElevation3;
        int i15;
        Shape shape3;
        BorderStroke borderStroke2;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i16;
        final ChipElevation chipElevation4;
        final BorderStroke borderStroke3;
        final boolean z3;
        MutableInteractionSource mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Shape shape4;
        final ChipColors chipColors3;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        ScopeUpdateScope endRestartGroup;
        int i17;
        int i18;
        Composer startRestartGroup = composer.startRestartGroup(1594789934);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)270@13792L5,271@13843L26,272@13922L29,274@14037L39,280@14212L10,275@14081L507:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i19 = i3 & 4;
        if (i19 != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i4 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? Fields.Clip : Fields.Shape;
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= 196608;
                    } else if ((i & 196608) == 0) {
                        i4 |= startRestartGroup.changedInstance(function23) ? Fields.RenderEffect : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(shape)) ? 1048576 : Fields.BlendMode;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & Fields.SpotShadowColor) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i18 = 8388608;
                                i4 |= i18;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i18 = 4194304;
                        i4 |= i18;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i3 & Fields.RotationX) == 0 && startRestartGroup.changed(chipElevation)) {
                            i17 = 67108864;
                            i4 |= i17;
                        }
                        i17 = 33554432;
                        i4 |= i17;
                    }
                    i8 = i3 & Fields.RotationY;
                    if (i8 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i9 = i8;
                        i4 |= startRestartGroup.changed(borderStroke) ? 536870912 : 268435456;
                        i10 = i3 & Fields.RotationZ;
                        if (i10 != 0) {
                            i11 = i10;
                            i12 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i11 = i10;
                            i12 = i2 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                        } else {
                            i11 = i10;
                            i12 = i2;
                        }
                        if ((i4 & 306783379) != 306783378 && (i12 & 3) == 2 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            function26 = function23;
                            chipElevation4 = chipElevation;
                            borderStroke3 = borderStroke;
                            mutableInteractionSource3 = mutableInteractionSource;
                            chipColors3 = chipColors2;
                            modifier3 = modifier2;
                            z3 = z2;
                            function27 = function22;
                            shape4 = shape;
                        } else {
                            startRestartGroup.startDefaults();
                            int i20 = i12;
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i19 != 0 ? Modifier.INSTANCE : modifier2;
                                boolean z4 = i5 != 0 ? true : z2;
                                Function2<? super Composer, ? super Integer, Unit> function28 = i6 != 0 ? null : function22;
                                Function2<? super Composer, ? super Integer, Unit> function29 = i7 != 0 ? null : function23;
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    shape2 = AssistChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    shape2 = shape;
                                }
                                if ((i3 & Fields.SpotShadowColor) != 0) {
                                    chipColors2 = AssistChipDefaults.INSTANCE.elevatedAssistChipColors(startRestartGroup, 6);
                                    i4 &= -29360129;
                                }
                                int i21 = i4;
                                ChipColors chipColors4 = chipColors2;
                                if ((i3 & Fields.RotationX) != 0) {
                                    i13 = i20;
                                    chipElevation2 = AssistChipDefaults.INSTANCE.m2217elevatedAssistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                    i14 = i21 & (-234881025);
                                } else {
                                    i13 = i20;
                                    chipElevation2 = chipElevation;
                                    i14 = i21;
                                }
                                BorderStroke borderStroke4 = i9 == 0 ? borderStroke : null;
                                if (i11 != 0) {
                                    startRestartGroup.startReplaceableGroup(-227035565);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Chip.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    modifier2 = companion;
                                    chipElevation3 = chipElevation2;
                                    i15 = i14;
                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    modifier2 = companion;
                                    chipElevation3 = chipElevation2;
                                    i15 = i14;
                                }
                                shape3 = shape2;
                                z2 = z4;
                                borderStroke2 = borderStroke4;
                                function24 = function28;
                                function25 = function29;
                                chipColors2 = chipColors4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i3 & Fields.SpotShadowColor) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & Fields.RotationX) != 0) {
                                    i4 &= -234881025;
                                }
                                function24 = function22;
                                shape3 = shape;
                                chipElevation3 = chipElevation;
                                borderStroke2 = borderStroke;
                                mutableInteractionSource2 = mutableInteractionSource;
                                i13 = i20;
                                i15 = i4;
                                function25 = function23;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                i16 = i13;
                                ComposerKt.traceEventStart(1594789934, i15, i16, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:275)");
                            } else {
                                i16 = i13;
                            }
                            int i22 = i15 << 6;
                            int i23 = ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896) | (i22 & 7168) | (3670016 & i22) | (29360128 & i22) | (234881024 & i22) | (i22 & 1879048192);
                            int i24 = i15 >> 24;
                            m2325ChipnkUnTEs(modifier2, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function24, function25, shape3, chipColors2, chipElevation3, borderStroke2, AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, i23, (i24 & 112) | (i24 & 14) | 3456 | ((i16 << 12) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            chipElevation4 = chipElevation3;
                            borderStroke3 = borderStroke2;
                            z3 = z2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            function26 = function25;
                            shape4 = shape3;
                            chipColors3 = chipColors2;
                            modifier3 = modifier2;
                            function27 = function24;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ElevatedAssistChip$2
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

                                public final void invoke(Composer composer2, int i25) {
                                    ChipKt.ElevatedAssistChip(function0, function2, modifier3, z3, function27, function26, shape4, chipColors3, chipElevation4, borderStroke3, mutableInteractionSource4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i8;
                    i10 = i3 & Fields.RotationZ;
                    if (i10 != 0) {
                    }
                    if ((i4 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    int i202 = i12;
                    if ((i & 1) != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if ((i3 & 64) != 0) {
                    }
                    if ((i3 & Fields.SpotShadowColor) != 0) {
                    }
                    int i212 = i4;
                    ChipColors chipColors42 = chipColors2;
                    if ((i3 & Fields.RotationX) != 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i11 != 0) {
                    }
                    shape3 = shape2;
                    z2 = z4;
                    borderStroke2 = borderStroke4;
                    function24 = function28;
                    function25 = function29;
                    chipColors2 = chipColors42;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i222 = i15 << 6;
                    int i232 = ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896) | (i222 & 7168) | (3670016 & i222) | (29360128 & i222) | (234881024 & i222) | (i222 & 1879048192);
                    int i242 = i15 >> 24;
                    m2325ChipnkUnTEs(modifier2, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function24, function25, shape3, chipColors2, chipElevation3, borderStroke2, AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, i232, (i242 & 112) | (i242 & 14) | 3456 | ((i16 << 12) & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    chipElevation4 = chipElevation3;
                    borderStroke3 = borderStroke2;
                    z3 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function26 = function25;
                    shape4 = shape3;
                    chipColors3 = chipColors2;
                    modifier3 = modifier2;
                    function27 = function24;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i8 = i3 & Fields.RotationY;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i3 & Fields.RotationZ;
                if (i10 != 0) {
                }
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                int i2022 = i12;
                if ((i & 1) != 0) {
                }
                if (i19 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if ((i3 & 64) != 0) {
                }
                if ((i3 & Fields.SpotShadowColor) != 0) {
                }
                int i2122 = i4;
                ChipColors chipColors422 = chipColors2;
                if ((i3 & Fields.RotationX) != 0) {
                }
                if (i9 == 0) {
                }
                if (i11 != 0) {
                }
                shape3 = shape2;
                z2 = z4;
                borderStroke2 = borderStroke4;
                function24 = function28;
                function25 = function29;
                chipColors2 = chipColors422;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i2222 = i15 << 6;
                int i2322 = ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896) | (i2222 & 7168) | (3670016 & i2222) | (29360128 & i2222) | (234881024 & i2222) | (i2222 & 1879048192);
                int i2422 = i15 >> 24;
                m2325ChipnkUnTEs(modifier2, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function24, function25, shape3, chipColors2, chipElevation3, borderStroke2, AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, i2322, (i2422 & 112) | (i2422 & 14) | 3456 | ((i16 << 12) & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                chipElevation4 = chipElevation3;
                borderStroke3 = borderStroke2;
                z3 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                function26 = function25;
                shape4 = shape3;
                chipColors3 = chipColors2;
                modifier3 = modifier2;
                function27 = function24;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i8 = i3 & Fields.RotationY;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i3 & Fields.RotationZ;
            if (i10 != 0) {
            }
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            int i20222 = i12;
            if ((i & 1) != 0) {
            }
            if (i19 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if ((i3 & Fields.SpotShadowColor) != 0) {
            }
            int i21222 = i4;
            ChipColors chipColors4222 = chipColors2;
            if ((i3 & Fields.RotationX) != 0) {
            }
            if (i9 == 0) {
            }
            if (i11 != 0) {
            }
            shape3 = shape2;
            z2 = z4;
            borderStroke2 = borderStroke4;
            function24 = function28;
            function25 = function29;
            chipColors2 = chipColors4222;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i22222 = i15 << 6;
            int i23222 = ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896) | (i22222 & 7168) | (3670016 & i22222) | (29360128 & i22222) | (234881024 & i22222) | (i22222 & 1879048192);
            int i24222 = i15 >> 24;
            m2325ChipnkUnTEs(modifier2, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function24, function25, shape3, chipColors2, chipElevation3, borderStroke2, AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, i23222, (i24222 & 112) | (i24222 & 14) | 3456 | ((i16 << 12) & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            chipElevation4 = chipElevation3;
            borderStroke3 = borderStroke2;
            z3 = z2;
            mutableInteractionSource3 = mutableInteractionSource2;
            function26 = function25;
            shape4 = shape3;
            chipColors3 = chipColors2;
            modifier3 = modifier2;
            function27 = function24;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i8 = i3 & Fields.RotationY;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3 & Fields.RotationZ;
        if (i10 != 0) {
        }
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        int i202222 = i12;
        if ((i & 1) != 0) {
        }
        if (i19 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if ((i3 & Fields.SpotShadowColor) != 0) {
        }
        int i212222 = i4;
        ChipColors chipColors42222 = chipColors2;
        if ((i3 & Fields.RotationX) != 0) {
        }
        if (i9 == 0) {
        }
        if (i11 != 0) {
        }
        shape3 = shape2;
        z2 = z4;
        borderStroke2 = borderStroke4;
        function24 = function28;
        function25 = function29;
        chipColors2 = chipColors42222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i222222 = i15 << 6;
        int i232222 = ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896) | (i222222 & 7168) | (3670016 & i222222) | (29360128 & i222222) | (234881024 & i222222) | (i222222 & 1879048192);
        int i242222 = i15 >> 24;
        m2325ChipnkUnTEs(modifier2, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function24, function25, shape3, chipColors2, chipElevation3, borderStroke2, AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, i232222, (i242222 & 112) | (i242222 & 14) | 3456 | ((i16 << 12) & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        chipElevation4 = chipElevation3;
        borderStroke3 = borderStroke2;
        z3 = z2;
        mutableInteractionSource3 = mutableInteractionSource2;
        function26 = function25;
        shape4 = shape3;
        chipColors3 = chipColors2;
        modifier3 = modifier2;
        function27 = function24;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d4  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedAssistChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "ElevatedAssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void ElevatedAssistChip(final Function0 function0, final Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        int i7;
        ChipColors chipColors2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Shape shape2;
        int i13;
        ChipElevation chipElevation2;
        int i14;
        MutableInteractionSource mutableInteractionSource2;
        ChipElevation chipElevation3;
        int i15;
        ChipBorder chipBorder2;
        Shape shape3;
        Function2 function24;
        Function2 function25;
        int i16;
        final ChipBorder chipBorder3;
        final Function2 function26;
        final ChipElevation chipElevation4;
        final boolean z3;
        MutableInteractionSource mutableInteractionSource3;
        final Shape shape4;
        final ChipColors chipColors3;
        final Modifier modifier3;
        final Function2 function27;
        ScopeUpdateScope endRestartGroup;
        int i17;
        int i18;
        Composer startRestartGroup = composer.startRestartGroup(1295844802);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)349@17824L5,350@17875L26,351@17954L29,353@18067L39,359@18242L10,354@18111L537:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i19 = i3 & 4;
        if (i19 != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i4 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? Fields.Clip : Fields.Shape;
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= 196608;
                    } else if ((i & 196608) == 0) {
                        i4 |= startRestartGroup.changedInstance(function23) ? Fields.RenderEffect : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(shape)) ? 1048576 : Fields.BlendMode;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & Fields.SpotShadowColor) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i18 = 8388608;
                                i4 |= i18;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i18 = 4194304;
                        i4 |= i18;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i3 & Fields.RotationX) == 0 && startRestartGroup.changed(chipElevation)) {
                            i17 = 67108864;
                            i4 |= i17;
                        }
                        i17 = 33554432;
                        i4 |= i17;
                    }
                    i8 = i3 & Fields.RotationY;
                    if (i8 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i9 = i8;
                        i4 |= startRestartGroup.changed(chipBorder) ? 536870912 : 268435456;
                        i10 = i3 & Fields.RotationZ;
                        if (i10 != 0) {
                            i11 = i10;
                            i12 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i11 = i10;
                            i12 = i2 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                        } else {
                            i11 = i10;
                            i12 = i2;
                        }
                        if ((i4 & 306783379) != 306783378 && (i12 & 3) == 2 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            function26 = function23;
                            chipElevation4 = chipElevation;
                            chipBorder3 = chipBorder;
                            mutableInteractionSource3 = mutableInteractionSource;
                            chipColors3 = chipColors2;
                            modifier3 = modifier2;
                            z3 = z2;
                            function27 = function22;
                            shape4 = shape;
                        } else {
                            startRestartGroup.startDefaults();
                            int i20 = i12;
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i19 != 0 ? Modifier.INSTANCE : modifier2;
                                boolean z4 = i5 != 0 ? true : z2;
                                Function2 function28 = i6 != 0 ? null : function22;
                                Function2 function29 = i7 != 0 ? null : function23;
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    shape2 = AssistChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    shape2 = shape;
                                }
                                if ((i3 & Fields.SpotShadowColor) != 0) {
                                    chipColors2 = AssistChipDefaults.INSTANCE.elevatedAssistChipColors(startRestartGroup, 6);
                                    i4 &= -29360129;
                                }
                                int i21 = i4;
                                ChipColors chipColors4 = chipColors2;
                                if ((i3 & Fields.RotationX) != 0) {
                                    i13 = i20;
                                    chipElevation2 = AssistChipDefaults.INSTANCE.m2217elevatedAssistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                    i14 = i21 & (-234881025);
                                } else {
                                    i13 = i20;
                                    chipElevation2 = chipElevation;
                                    i14 = i21;
                                }
                                ChipBorder chipBorder4 = i9 != 0 ? null : chipBorder;
                                if (i11 != 0) {
                                    startRestartGroup.startReplaceableGroup(-227031535);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Chip.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    modifier2 = companion;
                                    i15 = i14;
                                    chipBorder2 = chipBorder4;
                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    shape3 = shape2;
                                    z2 = z4;
                                    function24 = function28;
                                    chipColors2 = chipColors4;
                                    chipElevation3 = chipElevation2;
                                    function25 = function29;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    modifier2 = companion;
                                    chipElevation3 = chipElevation2;
                                    i15 = i14;
                                    chipBorder2 = chipBorder4;
                                    shape3 = shape2;
                                    z2 = z4;
                                    function24 = function28;
                                    function25 = function29;
                                    chipColors2 = chipColors4;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i3 & Fields.SpotShadowColor) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & Fields.RotationX) != 0) {
                                    i4 &= -234881025;
                                }
                                function24 = function22;
                                shape3 = shape;
                                chipElevation3 = chipElevation;
                                chipBorder2 = chipBorder;
                                mutableInteractionSource2 = mutableInteractionSource;
                                i13 = i20;
                                i15 = i4;
                                function25 = function23;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                i16 = i13;
                                ComposerKt.traceEventStart(1295844802, i15, i16, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:354)");
                            } else {
                                i16 = i13;
                            }
                            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
                            long m2315labelColorvNxB06k$material3_release = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
                            float m2218getHeightD9Ej5fM = AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM();
                            PaddingValues paddingValues = AssistChipPadding;
                            startRestartGroup.startReplaceableGroup(-227031027);
                            ComposerKt.sourceInformation(startRestartGroup, "368@18575L21");
                            State<BorderStroke> borderStroke$material3_release = chipBorder2 == null ? null : chipBorder2.borderStroke$material3_release(z2, startRestartGroup, ((i15 >> 9) & 14) | ((i15 >> 24) & 112));
                            startRestartGroup.endReplaceableGroup();
                            int i22 = i15 << 6;
                            ChipBorder chipBorder5 = chipBorder2;
                            m2325ChipnkUnTEs(modifier2, function0, z2, function2, fromToken, m2315labelColorvNxB06k$material3_release, function24, function25, shape3, chipColors2, chipElevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, m2218getHeightD9Ej5fM, paddingValues, mutableInteractionSource2, startRestartGroup, (i22 & 7168) | ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896) | (3670016 & i22) | (29360128 & i22) | (234881024 & i22) | (1879048192 & i22), ((i15 >> 24) & 14) | 3456 | ((i16 << 12) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            chipBorder3 = chipBorder5;
                            function26 = function25;
                            chipElevation4 = chipElevation3;
                            z3 = z2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape4 = shape3;
                            chipColors3 = chipColors2;
                            modifier3 = modifier2;
                            function27 = function24;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ElevatedAssistChip$4
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

                                public final void invoke(Composer composer2, int i23) {
                                    ChipKt.ElevatedAssistChip(function0, function2, modifier3, z3, function27, function26, shape4, chipColors3, chipElevation4, chipBorder3, mutableInteractionSource4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i8;
                    i10 = i3 & Fields.RotationZ;
                    if (i10 != 0) {
                    }
                    if ((i4 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    int i202 = i12;
                    if ((i & 1) != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if ((i3 & 64) != 0) {
                    }
                    if ((i3 & Fields.SpotShadowColor) != 0) {
                    }
                    int i212 = i4;
                    ChipColors chipColors42 = chipColors2;
                    if ((i3 & Fields.RotationX) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
                    long m2315labelColorvNxB06k$material3_release2 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
                    float m2218getHeightD9Ej5fM2 = AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM();
                    PaddingValues paddingValues2 = AssistChipPadding;
                    startRestartGroup.startReplaceableGroup(-227031027);
                    ComposerKt.sourceInformation(startRestartGroup, "368@18575L21");
                    if (chipBorder2 == null) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    if (borderStroke$material3_release != null) {
                    }
                    int i222 = i15 << 6;
                    ChipBorder chipBorder52 = chipBorder2;
                    m2325ChipnkUnTEs(modifier2, function0, z2, function2, fromToken2, m2315labelColorvNxB06k$material3_release2, function24, function25, shape3, chipColors2, chipElevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, m2218getHeightD9Ej5fM2, paddingValues2, mutableInteractionSource2, startRestartGroup, (i222 & 7168) | ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896) | (3670016 & i222) | (29360128 & i222) | (234881024 & i222) | (1879048192 & i222), ((i15 >> 24) & 14) | 3456 | ((i16 << 12) & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    chipBorder3 = chipBorder52;
                    function26 = function25;
                    chipElevation4 = chipElevation3;
                    z3 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape4 = shape3;
                    chipColors3 = chipColors2;
                    modifier3 = modifier2;
                    function27 = function24;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i8 = i3 & Fields.RotationY;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i3 & Fields.RotationZ;
                if (i10 != 0) {
                }
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                int i2022 = i12;
                if ((i & 1) != 0) {
                }
                if (i19 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if ((i3 & 64) != 0) {
                }
                if ((i3 & Fields.SpotShadowColor) != 0) {
                }
                int i2122 = i4;
                ChipColors chipColors422 = chipColors2;
                if ((i3 & Fields.RotationX) != 0) {
                }
                if (i9 != 0) {
                }
                if (i11 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                TextStyle fromToken22 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
                long m2315labelColorvNxB06k$material3_release22 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
                float m2218getHeightD9Ej5fM22 = AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM();
                PaddingValues paddingValues22 = AssistChipPadding;
                startRestartGroup.startReplaceableGroup(-227031027);
                ComposerKt.sourceInformation(startRestartGroup, "368@18575L21");
                if (chipBorder2 == null) {
                }
                startRestartGroup.endReplaceableGroup();
                if (borderStroke$material3_release != null) {
                }
                int i2222 = i15 << 6;
                ChipBorder chipBorder522 = chipBorder2;
                m2325ChipnkUnTEs(modifier2, function0, z2, function2, fromToken22, m2315labelColorvNxB06k$material3_release22, function24, function25, shape3, chipColors2, chipElevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, m2218getHeightD9Ej5fM22, paddingValues22, mutableInteractionSource2, startRestartGroup, (i2222 & 7168) | ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896) | (3670016 & i2222) | (29360128 & i2222) | (234881024 & i2222) | (1879048192 & i2222), ((i15 >> 24) & 14) | 3456 | ((i16 << 12) & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                chipBorder3 = chipBorder522;
                function26 = function25;
                chipElevation4 = chipElevation3;
                z3 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape4 = shape3;
                chipColors3 = chipColors2;
                modifier3 = modifier2;
                function27 = function24;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i8 = i3 & Fields.RotationY;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i3 & Fields.RotationZ;
            if (i10 != 0) {
            }
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            int i20222 = i12;
            if ((i & 1) != 0) {
            }
            if (i19 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if ((i3 & Fields.SpotShadowColor) != 0) {
            }
            int i21222 = i4;
            ChipColors chipColors4222 = chipColors2;
            if ((i3 & Fields.RotationX) != 0) {
            }
            if (i9 != 0) {
            }
            if (i11 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            TextStyle fromToken222 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
            long m2315labelColorvNxB06k$material3_release222 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
            float m2218getHeightD9Ej5fM222 = AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM();
            PaddingValues paddingValues222 = AssistChipPadding;
            startRestartGroup.startReplaceableGroup(-227031027);
            ComposerKt.sourceInformation(startRestartGroup, "368@18575L21");
            if (chipBorder2 == null) {
            }
            startRestartGroup.endReplaceableGroup();
            if (borderStroke$material3_release != null) {
            }
            int i22222 = i15 << 6;
            ChipBorder chipBorder5222 = chipBorder2;
            m2325ChipnkUnTEs(modifier2, function0, z2, function2, fromToken222, m2315labelColorvNxB06k$material3_release222, function24, function25, shape3, chipColors2, chipElevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, m2218getHeightD9Ej5fM222, paddingValues222, mutableInteractionSource2, startRestartGroup, (i22222 & 7168) | ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896) | (3670016 & i22222) | (29360128 & i22222) | (234881024 & i22222) | (1879048192 & i22222), ((i15 >> 24) & 14) | 3456 | ((i16 << 12) & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            chipBorder3 = chipBorder5222;
            function26 = function25;
            chipElevation4 = chipElevation3;
            z3 = z2;
            mutableInteractionSource3 = mutableInteractionSource2;
            shape4 = shape3;
            chipColors3 = chipColors2;
            modifier3 = modifier2;
            function27 = function24;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i8 = i3 & Fields.RotationY;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3 & Fields.RotationZ;
        if (i10 != 0) {
        }
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        int i202222 = i12;
        if ((i & 1) != 0) {
        }
        if (i19 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if ((i3 & Fields.SpotShadowColor) != 0) {
        }
        int i212222 = i4;
        ChipColors chipColors42222 = chipColors2;
        if ((i3 & Fields.RotationX) != 0) {
        }
        if (i9 != 0) {
        }
        if (i11 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        TextStyle fromToken2222 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), AssistChipTokens.INSTANCE.getLabelTextFont());
        long m2315labelColorvNxB06k$material3_release2222 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
        float m2218getHeightD9Ej5fM2222 = AssistChipDefaults.INSTANCE.m2218getHeightD9Ej5fM();
        PaddingValues paddingValues2222 = AssistChipPadding;
        startRestartGroup.startReplaceableGroup(-227031027);
        ComposerKt.sourceInformation(startRestartGroup, "368@18575L21");
        if (chipBorder2 == null) {
        }
        startRestartGroup.endReplaceableGroup();
        if (borderStroke$material3_release != null) {
        }
        int i222222 = i15 << 6;
        ChipBorder chipBorder52222 = chipBorder2;
        m2325ChipnkUnTEs(modifier2, function0, z2, function2, fromToken2222, m2315labelColorvNxB06k$material3_release2222, function24, function25, shape3, chipColors2, chipElevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, m2218getHeightD9Ej5fM2222, paddingValues2222, mutableInteractionSource2, startRestartGroup, (i222222 & 7168) | ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896) | (3670016 & i222222) | (29360128 & i222222) | (234881024 & i222222) | (1879048192 & i222222), ((i15 >> 24) & 14) | 3456 | ((i16 << 12) & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        chipBorder3 = chipBorder52222;
        function26 = function25;
        chipElevation4 = chipElevation3;
        z3 = z2;
        mutableInteractionSource3 = mutableInteractionSource2;
        shape4 = shape3;
        chipColors3 = chipColors2;
        modifier3 = modifier2;
        function27 = function24;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilterChip(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Shape shape2;
        SelectableChipColors selectableChipColors2;
        int i8;
        int i9;
        int i10;
        MutableInteractionSource mutableInteractionSource2;
        int i11;
        Modifier.Companion companion;
        boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Shape shape3;
        int i12;
        SelectableChipColors selectableChipColors3;
        int i13;
        SelectableChipElevation selectableChipElevation2;
        int i14;
        BorderStroke borderStroke2;
        int i15;
        BorderStroke borderStroke3;
        int i16;
        final Modifier modifier3;
        BorderStroke borderStroke4;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Shape shape4;
        final SelectableChipColors selectableChipColors4;
        MutableInteractionSource mutableInteractionSource3;
        final boolean z5;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final SelectableChipElevation selectableChipElevation3;
        ScopeUpdateScope endRestartGroup;
        int i17;
        int i18;
        int i19;
        int i20;
        Composer startRestartGroup = composer.startRestartGroup(-1711985619);
        ComposerKt.sourceInformation(startRestartGroup, "C(FilterChip)P(9,8,5,7,3,6,11,10,1,2)430@21945L5,431@22006L18,432@22087L21,433@22157L35,434@22244L39,441@22454L10,435@22288L516:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        int i21 = i3 & 8;
        if (i21 != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? Fields.CameraDistance : Fields.RotationZ;
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                z3 = z2;
                i4 |= startRestartGroup.changed(z3) ? Fields.Clip : Fields.Shape;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else if ((i & 196608) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? Fields.RenderEffect : 65536;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                    function24 = function23;
                } else {
                    function24 = function23;
                    if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function24) ? 1048576 : Fields.BlendMode;
                    }
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & Fields.SpotShadowColor) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i20 = 8388608;
                            i4 |= i20;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i20 = 4194304;
                    i4 |= i20;
                } else {
                    shape2 = shape;
                }
                if ((i & 100663296) == 0) {
                    if ((i3 & Fields.RotationX) == 0) {
                        selectableChipColors2 = selectableChipColors;
                        if (startRestartGroup.changed(selectableChipColors2)) {
                            i19 = 67108864;
                            i4 |= i19;
                        }
                    } else {
                        selectableChipColors2 = selectableChipColors;
                    }
                    i19 = 33554432;
                    i4 |= i19;
                } else {
                    selectableChipColors2 = selectableChipColors;
                }
                if ((i & 805306368) == 0) {
                    if ((i3 & Fields.RotationY) == 0 && startRestartGroup.changed(selectableChipElevation)) {
                        i18 = 536870912;
                        i4 |= i18;
                    }
                    i18 = 268435456;
                    i4 |= i18;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & Fields.RotationZ) == 0 && startRestartGroup.changed(borderStroke)) {
                        i17 = 4;
                        i8 = i2 | i17;
                    }
                    i17 = 2;
                    i8 = i2 | i17;
                } else {
                    i8 = i2;
                }
                i9 = i3 & Fields.CameraDistance;
                if (i9 != 0) {
                    i10 = i9;
                    i11 = i8 | 48;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    if ((i2 & 48) == 0) {
                        i10 = i9;
                        mutableInteractionSource2 = mutableInteractionSource;
                        i8 |= startRestartGroup.changed(mutableInteractionSource2) ? 32 : 16;
                    } else {
                        i10 = i9;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    i11 = i8;
                }
                if ((i4 & 306783379) != 306783378 && (i11 & 19) == 18 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    borderStroke4 = borderStroke;
                    shape4 = shape2;
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    selectableChipElevation3 = selectableChipElevation;
                    function26 = function24;
                    selectableChipColors4 = selectableChipColors2;
                    function27 = function22;
                } else {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i21 != 0 ? Modifier.INSTANCE : modifier2;
                        z4 = i5 != 0 ? true : z3;
                        function25 = i6 != 0 ? null : function22;
                        if (i7 != 0) {
                            function24 = null;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
                        if ((i3 & Fields.SpotShadowColor) != 0) {
                            i4 &= -29360129;
                            shape3 = FilterChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & Fields.RotationX) != 0) {
                            i12 = i4 & (-234881025);
                            selectableChipColors3 = FilterChipDefaults.INSTANCE.filterChipColors(startRestartGroup, 6);
                        } else {
                            i12 = i4;
                            selectableChipColors3 = selectableChipColors2;
                        }
                        if ((i3 & Fields.RotationY) != 0) {
                            i13 = i10;
                            selectableChipElevation2 = FilterChipDefaults.INSTANCE.m2588filterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                            i14 = i12 & (-1879048193);
                        } else {
                            i13 = i10;
                            selectableChipElevation2 = selectableChipElevation;
                            i14 = i12;
                        }
                        if ((i3 & Fields.RotationZ) != 0) {
                            borderStroke2 = FilterChipDefaults.INSTANCE.m2586filterChipBorder_7El2pE(z4, z, 0L, 0L, 0L, 0L, 0.0f, 0.0f, startRestartGroup, ((i14 >> 12) & 14) | 100663296 | ((i14 << 3) & 112), 252);
                            i11 &= -15;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if (i13 != 0) {
                            startRestartGroup.startReplaceableGroup(276179389);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Chip.kt#9igjgp");
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                            i16 = i11;
                            shape2 = shape3;
                            selectableChipColors2 = selectableChipColors3;
                            i15 = i14;
                            borderStroke3 = borderStroke2;
                            function24 = function28;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            i15 = i14;
                            borderStroke3 = borderStroke2;
                            i16 = i11;
                            function24 = function28;
                            shape2 = shape3;
                            selectableChipColors2 = selectableChipColors3;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i3 & Fields.SpotShadowColor) != 0) {
                            i4 &= -29360129;
                        }
                        if ((i3 & Fields.RotationX) != 0) {
                            i4 &= -234881025;
                        }
                        if ((i3 & Fields.RotationY) != 0) {
                            i4 &= -1879048193;
                        }
                        if ((i3 & Fields.RotationZ) != 0) {
                            i11 &= -15;
                        }
                        function25 = function22;
                        borderStroke3 = borderStroke;
                        i15 = i4;
                        companion = modifier2;
                        z4 = z3;
                        i16 = i11;
                        selectableChipElevation2 = selectableChipElevation;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1711985619, i15, i16, "androidx.compose.material3.FilterChip (Chip.kt:435)");
                    }
                    int i22 = i15 << 3;
                    int i23 = i15 << 6;
                    int i24 = (i15 & 14) | 12582912 | ((i15 >> 6) & 112) | (i22 & 896) | ((i15 >> 3) & 7168) | (i23 & 57344) | (i22 & 3670016) | (234881024 & i23) | (1879048192 & i23);
                    int i25 = i15 >> 24;
                    m2327SelectableChipu0RnIRE(z, companion, function0, z4, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), FilterChipTokens.INSTANCE.getLabelTextFont()), function25, null, function24, shape2, selectableChipColors2, selectableChipElevation2, borderStroke3, FilterChipDefaults.INSTANCE.m2589getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource2, startRestartGroup, i24, (i25 & 112) | (i25 & 14) | 27648 | ((i16 << 6) & 896) | ((i16 << 12) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    borderStroke4 = borderStroke3;
                    function26 = function24;
                    shape4 = shape2;
                    selectableChipColors4 = selectableChipColors2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z5 = z4;
                    function27 = function25;
                    selectableChipElevation3 = selectableChipElevation2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final BorderStroke borderStroke5 = borderStroke4;
                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$FilterChip$2
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

                        public final void invoke(Composer composer2, int i26) {
                            ChipKt.FilterChip(z, function0, function2, modifier3, z5, function27, function26, shape4, selectableChipColors4, selectableChipElevation3, borderStroke5, mutableInteractionSource4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                        }
                    });
                    return;
                }
                return;
            }
            z3 = z2;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i3 & 64;
            if (i7 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            i9 = i3 & Fields.CameraDistance;
            if (i9 != 0) {
            }
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i21 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            Function2<? super Composer, ? super Integer, Unit> function282 = function24;
            if ((i3 & Fields.SpotShadowColor) != 0) {
            }
            if ((i3 & Fields.RotationX) != 0) {
            }
            if ((i3 & Fields.RotationY) != 0) {
            }
            if ((i3 & Fields.RotationZ) != 0) {
            }
            if (i13 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i222 = i15 << 3;
            int i232 = i15 << 6;
            int i242 = (i15 & 14) | 12582912 | ((i15 >> 6) & 112) | (i222 & 896) | ((i15 >> 3) & 7168) | (i232 & 57344) | (i222 & 3670016) | (234881024 & i232) | (1879048192 & i232);
            int i252 = i15 >> 24;
            m2327SelectableChipu0RnIRE(z, companion, function0, z4, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), FilterChipTokens.INSTANCE.getLabelTextFont()), function25, null, function24, shape2, selectableChipColors2, selectableChipElevation2, borderStroke3, FilterChipDefaults.INSTANCE.m2589getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource2, startRestartGroup, i242, (i252 & 112) | (i252 & 14) | 27648 | ((i16 << 6) & 896) | ((i16 << 12) & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = companion;
            borderStroke4 = borderStroke3;
            function26 = function24;
            shape4 = shape2;
            selectableChipColors4 = selectableChipColors2;
            mutableInteractionSource3 = mutableInteractionSource2;
            z5 = z4;
            function27 = function25;
            selectableChipElevation3 = selectableChipElevation2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        z3 = z2;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i3 & 64;
        if (i7 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        i9 = i3 & Fields.CameraDistance;
        if (i9 != 0) {
        }
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i21 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        Function2<? super Composer, ? super Integer, Unit> function2822 = function24;
        if ((i3 & Fields.SpotShadowColor) != 0) {
        }
        if ((i3 & Fields.RotationX) != 0) {
        }
        if ((i3 & Fields.RotationY) != 0) {
        }
        if ((i3 & Fields.RotationZ) != 0) {
        }
        if (i13 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i2222 = i15 << 3;
        int i2322 = i15 << 6;
        int i2422 = (i15 & 14) | 12582912 | ((i15 >> 6) & 112) | (i2222 & 896) | ((i15 >> 3) & 7168) | (i2322 & 57344) | (i2222 & 3670016) | (234881024 & i2322) | (1879048192 & i2322);
        int i2522 = i15 >> 24;
        m2327SelectableChipu0RnIRE(z, companion, function0, z4, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), FilterChipTokens.INSTANCE.getLabelTextFont()), function25, null, function24, shape2, selectableChipColors2, selectableChipElevation2, borderStroke3, FilterChipDefaults.INSTANCE.m2589getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource2, startRestartGroup, i2422, (i2522 & 112) | (i2522 & 14) | 27648 | ((i16 << 6) & 896) | ((i16 << 12) & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = companion;
        borderStroke4 = borderStroke3;
        function26 = function24;
        shape4 = shape2;
        selectableChipColors4 = selectableChipColors2;
        mutableInteractionSource3 = mutableInteractionSource2;
        z5 = z4;
        function27 = function25;
        selectableChipElevation3 = selectableChipElevation2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0206  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedFilterChip(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Shape shape2;
        SelectableChipColors selectableChipColors2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Shape shape3;
        int i13;
        SelectableChipColors selectableChipColors3;
        Modifier modifier3;
        int i14;
        SelectableChipElevation selectableChipElevation2;
        int i15;
        MutableInteractionSource mutableInteractionSource2;
        int i16;
        BorderStroke borderStroke2;
        SelectableChipElevation selectableChipElevation3;
        Function2<? super Composer, ? super Integer, Unit> function25;
        final SelectableChipElevation selectableChipElevation4;
        BorderStroke borderStroke3;
        final Modifier modifier4;
        MutableInteractionSource mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Shape shape4;
        final boolean z4;
        final SelectableChipColors selectableChipColors4;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        ScopeUpdateScope endRestartGroup;
        int i17;
        int i18;
        int i19;
        Composer startRestartGroup = composer.startRestartGroup(-106647389);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedFilterChip)P(9,8,5,7,3,6,11,10,1,2)509@25986L5,510@26047L26,511@26136L29,513@26251L39,520@26461L10,514@26295L516:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        int i20 = i3 & 8;
        if (i20 != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? Fields.CameraDistance : Fields.RotationZ;
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                z3 = z2;
                i4 |= startRestartGroup.changed(z3) ? Fields.Clip : Fields.Shape;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else if ((i & 196608) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? Fields.RenderEffect : 65536;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                    function24 = function23;
                } else {
                    function24 = function23;
                    if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function24) ? 1048576 : Fields.BlendMode;
                    }
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & Fields.SpotShadowColor) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i19 = 8388608;
                            i4 |= i19;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i19 = 4194304;
                    i4 |= i19;
                } else {
                    shape2 = shape;
                }
                if ((i & 100663296) == 0) {
                    if ((i3 & Fields.RotationX) == 0) {
                        selectableChipColors2 = selectableChipColors;
                        if (startRestartGroup.changed(selectableChipColors2)) {
                            i18 = 67108864;
                            i4 |= i18;
                        }
                    } else {
                        selectableChipColors2 = selectableChipColors;
                    }
                    i18 = 33554432;
                    i4 |= i18;
                } else {
                    selectableChipColors2 = selectableChipColors;
                }
                if ((i & 805306368) == 0) {
                    if ((i3 & Fields.RotationY) == 0 && startRestartGroup.changed(selectableChipElevation)) {
                        i17 = 536870912;
                        i4 |= i17;
                    }
                    i17 = 268435456;
                    i4 |= i17;
                }
                i8 = i3 & Fields.RotationZ;
                if (i8 != 0) {
                    i10 = i2 | 6;
                    i9 = i8;
                } else if ((i2 & 6) == 0) {
                    i9 = i8;
                    i10 = i2 | (startRestartGroup.changed(borderStroke) ? 4 : 2);
                } else {
                    i9 = i8;
                    i10 = i2;
                }
                i11 = i3 & Fields.CameraDistance;
                if (i11 != 0) {
                    i10 |= 48;
                    i12 = i11;
                } else if ((i2 & 48) == 0) {
                    i12 = i11;
                    i10 |= startRestartGroup.changed(mutableInteractionSource) ? 32 : 16;
                } else {
                    i12 = i11;
                }
                int i21 = i10;
                if ((i4 & 306783379) != 306783378 && (i21 & 19) == 18 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    selectableChipElevation4 = selectableChipElevation;
                    borderStroke3 = borderStroke;
                    mutableInteractionSource3 = mutableInteractionSource;
                    shape4 = shape2;
                    modifier4 = modifier2;
                    z4 = z3;
                    function26 = function24;
                    selectableChipColors4 = selectableChipColors2;
                    function27 = function22;
                } else {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i20 != 0 ? Modifier.INSTANCE : modifier2;
                        boolean z5 = i5 != 0 ? true : z3;
                        Function2<? super Composer, ? super Integer, Unit> function28 = i6 != 0 ? null : function22;
                        Function2<? super Composer, ? super Integer, Unit> function29 = i7 != 0 ? null : function24;
                        if ((i3 & Fields.SpotShadowColor) != 0) {
                            i4 &= -29360129;
                            shape3 = FilterChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & Fields.RotationX) != 0) {
                            i13 = i4 & (-234881025);
                            selectableChipColors3 = FilterChipDefaults.INSTANCE.elevatedFilterChipColors(startRestartGroup, 6);
                        } else {
                            i13 = i4;
                            selectableChipColors3 = selectableChipColors2;
                        }
                        if ((i3 & Fields.RotationY) != 0) {
                            modifier3 = companion;
                            i14 = i21;
                            selectableChipElevation2 = FilterChipDefaults.INSTANCE.m2585elevatedFilterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                            i15 = i13 & (-1879048193);
                        } else {
                            modifier3 = companion;
                            i14 = i21;
                            selectableChipElevation2 = selectableChipElevation;
                            i15 = i13;
                        }
                        BorderStroke borderStroke4 = i9 == 0 ? borderStroke : null;
                        if (i12 != 0) {
                            startRestartGroup.startReplaceableGroup(-790761894);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Chip.kt#9igjgp");
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            modifier2 = modifier3;
                            i16 = i15;
                            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                        } else {
                            modifier2 = modifier3;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i16 = i15;
                        }
                        function24 = function29;
                        shape2 = shape3;
                        z3 = z5;
                        borderStroke2 = borderStroke4;
                        selectableChipColors2 = selectableChipColors3;
                        selectableChipElevation3 = selectableChipElevation2;
                        function25 = function28;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i3 & Fields.SpotShadowColor) != 0) {
                            i4 &= -29360129;
                        }
                        if ((i3 & Fields.RotationX) != 0) {
                            i4 &= -234881025;
                        }
                        if ((i3 & Fields.RotationY) != 0) {
                            i4 &= -1879048193;
                        }
                        selectableChipElevation3 = selectableChipElevation;
                        borderStroke2 = borderStroke;
                        mutableInteractionSource2 = mutableInteractionSource;
                        i14 = i21;
                        i16 = i4;
                        function25 = function22;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-106647389, i16, i14, "androidx.compose.material3.ElevatedFilterChip (Chip.kt:514)");
                    }
                    int i22 = i16 << 3;
                    int i23 = i16 << 6;
                    int i24 = (i16 & 14) | 12582912 | ((i16 >> 6) & 112) | (i22 & 896) | ((i16 >> 3) & 7168) | (i23 & 57344) | (i22 & 3670016) | (234881024 & i23) | (1879048192 & i23);
                    int i25 = i16 >> 24;
                    m2327SelectableChipu0RnIRE(z, modifier2, function0, z3, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), FilterChipTokens.INSTANCE.getLabelTextFont()), function25, null, function24, shape2, selectableChipColors2, selectableChipElevation3, borderStroke2, FilterChipDefaults.INSTANCE.m2589getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource2, startRestartGroup, i24, (i25 & 112) | (i25 & 14) | 27648 | ((i14 << 6) & 896) | ((i14 << 12) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    selectableChipElevation4 = selectableChipElevation3;
                    borderStroke3 = borderStroke2;
                    modifier4 = modifier2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function26 = function24;
                    shape4 = shape2;
                    z4 = z3;
                    selectableChipColors4 = selectableChipColors2;
                    function27 = function25;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final BorderStroke borderStroke5 = borderStroke3;
                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ElevatedFilterChip$2
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

                        public final void invoke(Composer composer2, int i26) {
                            ChipKt.ElevatedFilterChip(z, function0, function2, modifier4, z4, function27, function26, shape4, selectableChipColors4, selectableChipElevation4, borderStroke5, mutableInteractionSource4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                        }
                    });
                    return;
                }
                return;
            }
            z3 = z2;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i3 & 64;
            if (i7 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i8 = i3 & Fields.RotationZ;
            if (i8 != 0) {
            }
            i11 = i3 & Fields.CameraDistance;
            if (i11 != 0) {
            }
            int i212 = i10;
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i20 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if ((i3 & Fields.SpotShadowColor) != 0) {
            }
            if ((i3 & Fields.RotationX) != 0) {
            }
            if ((i3 & Fields.RotationY) != 0) {
            }
            if (i9 == 0) {
            }
            if (i12 != 0) {
            }
            function24 = function29;
            shape2 = shape3;
            z3 = z5;
            borderStroke2 = borderStroke4;
            selectableChipColors2 = selectableChipColors3;
            selectableChipElevation3 = selectableChipElevation2;
            function25 = function28;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i222 = i16 << 3;
            int i232 = i16 << 6;
            int i242 = (i16 & 14) | 12582912 | ((i16 >> 6) & 112) | (i222 & 896) | ((i16 >> 3) & 7168) | (i232 & 57344) | (i222 & 3670016) | (234881024 & i232) | (1879048192 & i232);
            int i252 = i16 >> 24;
            m2327SelectableChipu0RnIRE(z, modifier2, function0, z3, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), FilterChipTokens.INSTANCE.getLabelTextFont()), function25, null, function24, shape2, selectableChipColors2, selectableChipElevation3, borderStroke2, FilterChipDefaults.INSTANCE.m2589getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource2, startRestartGroup, i242, (i252 & 112) | (i252 & 14) | 27648 | ((i14 << 6) & 896) | ((i14 << 12) & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            selectableChipElevation4 = selectableChipElevation3;
            borderStroke3 = borderStroke2;
            modifier4 = modifier2;
            mutableInteractionSource3 = mutableInteractionSource2;
            function26 = function24;
            shape4 = shape2;
            z4 = z3;
            selectableChipColors4 = selectableChipColors2;
            function27 = function25;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        z3 = z2;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i3 & 64;
        if (i7 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i8 = i3 & Fields.RotationZ;
        if (i8 != 0) {
        }
        i11 = i3 & Fields.CameraDistance;
        if (i11 != 0) {
        }
        int i2122 = i10;
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i20 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if ((i3 & Fields.SpotShadowColor) != 0) {
        }
        if ((i3 & Fields.RotationX) != 0) {
        }
        if ((i3 & Fields.RotationY) != 0) {
        }
        if (i9 == 0) {
        }
        if (i12 != 0) {
        }
        function24 = function29;
        shape2 = shape3;
        z3 = z5;
        borderStroke2 = borderStroke4;
        selectableChipColors2 = selectableChipColors3;
        selectableChipElevation3 = selectableChipElevation2;
        function25 = function28;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i2222 = i16 << 3;
        int i2322 = i16 << 6;
        int i2422 = (i16 & 14) | 12582912 | ((i16 >> 6) & 112) | (i2222 & 896) | ((i16 >> 3) & 7168) | (i2322 & 57344) | (i2222 & 3670016) | (234881024 & i2322) | (1879048192 & i2322);
        int i2522 = i16 >> 24;
        m2327SelectableChipu0RnIRE(z, modifier2, function0, z3, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), FilterChipTokens.INSTANCE.getLabelTextFont()), function25, null, function24, shape2, selectableChipColors2, selectableChipElevation3, borderStroke2, FilterChipDefaults.INSTANCE.m2589getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource2, startRestartGroup, i2422, (i2522 & 112) | (i2522 & 14) | 27648 | ((i14 << 6) & 896) | ((i14 << 12) & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        selectableChipElevation4 = selectableChipElevation3;
        borderStroke3 = borderStroke2;
        modifier4 = modifier2;
        mutableInteractionSource3 = mutableInteractionSource2;
        function26 = function24;
        shape4 = shape2;
        z4 = z3;
        selectableChipColors4 = selectableChipColors2;
        function27 = function25;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InputChip(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i7;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        int i8;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        int i9;
        int i10;
        boolean z3;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Shape shape2;
        SelectableChipColors selectableChipColors2;
        int i11;
        boolean z4;
        int i12;
        SelectableChipElevation selectableChipElevation2;
        BorderStroke borderStroke2;
        MutableInteractionSource mutableInteractionSource2;
        int i13;
        Modifier modifier2;
        int i14;
        int i15;
        ComposableLambda composableLambda;
        final Modifier modifier3;
        SelectableChipElevation selectableChipElevation3;
        BorderStroke borderStroke3;
        MutableInteractionSource mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final boolean z5;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Shape shape3;
        final SelectableChipColors selectableChipColors3;
        ScopeUpdateScope endRestartGroup;
        int i16;
        int i17;
        int i18;
        int i19;
        Composer startRestartGroup = composer.startRestartGroup(1658928131);
        ComposerKt.sourceInformation(startRestartGroup, "C(InputChip)P(10,9,6,8,4,7!1,12,11,2,3)593@30171L5,594@30231L17,595@30310L20,596@30378L34,597@30464L39,624@31431L10,618@31241L747:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        int i20 = i3 & 8;
        if (i20 != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? Fields.CameraDistance : Fields.RotationZ;
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changed(z2) ? Fields.Clip : Fields.Shape;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                    function25 = function22;
                } else {
                    function25 = function22;
                    if ((i & 196608) == 0) {
                        i4 |= startRestartGroup.changedInstance(function25) ? Fields.RenderEffect : 65536;
                    }
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                    function26 = function23;
                } else {
                    function26 = function23;
                    if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function26) ? 1048576 : Fields.BlendMode;
                    }
                }
                i8 = i3 & Fields.SpotShadowColor;
                if (i8 != 0) {
                    i4 |= 12582912;
                    function27 = function24;
                } else {
                    function27 = function24;
                    if ((i & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(function27) ? 8388608 : 4194304;
                    }
                }
                if ((i & 100663296) == 0) {
                    if ((i3 & Fields.RotationX) == 0 && startRestartGroup.changed(shape)) {
                        i19 = 67108864;
                        i4 |= i19;
                    }
                    i19 = 33554432;
                    i4 |= i19;
                }
                if ((i & 805306368) == 0) {
                    if ((i3 & Fields.RotationY) == 0 && startRestartGroup.changed(selectableChipColors)) {
                        i18 = 536870912;
                        i4 |= i18;
                    }
                    i18 = 268435456;
                    i4 |= i18;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & Fields.RotationZ) == 0 && startRestartGroup.changed(selectableChipElevation)) {
                        i17 = 4;
                        i9 = i2 | i17;
                    }
                    i17 = 2;
                    i9 = i2 | i17;
                } else {
                    i9 = i2;
                }
                if ((i2 & 48) == 0) {
                    if ((i3 & Fields.CameraDistance) == 0 && startRestartGroup.changed(borderStroke)) {
                        i16 = 32;
                        i9 |= i16;
                    }
                    i16 = 16;
                    i9 |= i16;
                }
                int i21 = i9;
                i10 = i3 & Fields.TransformOrigin;
                if (i10 != 0) {
                    i21 |= 384;
                } else if ((i2 & 384) == 0) {
                    i21 |= startRestartGroup.changed(mutableInteractionSource) ? Fields.RotationX : Fields.SpotShadowColor;
                    if ((i4 & 306783379) != 306783378 && (i21 & 147) == 146 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        shape3 = shape;
                        selectableChipColors3 = selectableChipColors;
                        selectableChipElevation3 = selectableChipElevation;
                        borderStroke3 = borderStroke;
                        mutableInteractionSource3 = mutableInteractionSource;
                        function210 = function26;
                        function211 = function25;
                        z5 = z2;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier4 = i20 == 0 ? Modifier.INSTANCE : modifier;
                            z3 = i5 == 0 ? true : z2;
                            function28 = i6 == 0 ? null : function25;
                            Function2<? super Composer, ? super Integer, Unit> function212 = i7 == 0 ? null : function26;
                            function29 = i8 == 0 ? null : function27;
                            if ((i3 & Fields.RotationX) == 0) {
                                i4 &= -234881025;
                                shape2 = InputChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            } else {
                                shape2 = shape;
                            }
                            if ((i3 & Fields.RotationY) == 0) {
                                i11 = i4 & (-1879048193);
                                selectableChipColors2 = InputChipDefaults.INSTANCE.inputChipColors(startRestartGroup, 6);
                            } else {
                                selectableChipColors2 = selectableChipColors;
                                i11 = i4;
                            }
                            if ((i3 & Fields.RotationZ) == 0) {
                                z4 = true;
                                i12 = i10;
                                selectableChipElevation2 = InputChipDefaults.INSTANCE.m2635inputChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                i21 &= -15;
                            } else {
                                z4 = true;
                                i12 = i10;
                                selectableChipElevation2 = selectableChipElevation;
                            }
                            if ((i3 & Fields.CameraDistance) == 0) {
                                borderStroke2 = InputChipDefaults.INSTANCE.m2633inputChipBorder_7El2pE(z3, z, 0L, 0L, 0L, 0L, 0.0f, 0.0f, startRestartGroup, ((i11 >> 12) & 14) | 100663296 | ((i11 << 3) & 112), 252);
                                i21 &= -113;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if (i12 == 0) {
                                startRestartGroup.startReplaceableGroup(-1371993939);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Chip.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            i13 = i21;
                            modifier2 = modifier4;
                            function26 = function212;
                            i14 = i11;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & Fields.RotationX) != 0) {
                                i4 &= -234881025;
                            }
                            if ((i3 & Fields.RotationY) != 0) {
                                i4 &= -1879048193;
                            }
                            if ((i3 & Fields.RotationZ) != 0) {
                                i21 &= -15;
                            }
                            if ((i3 & Fields.CameraDistance) != 0) {
                                i21 &= -113;
                            }
                            z3 = z2;
                            shape2 = shape;
                            selectableChipColors2 = selectableChipColors;
                            borderStroke2 = borderStroke;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i13 = i21;
                            function28 = function25;
                            function29 = function27;
                            z4 = true;
                            modifier2 = modifier;
                            i14 = i4;
                            selectableChipElevation2 = selectableChipElevation;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1658928131, i14, i13, "androidx.compose.material3.InputChip (Chip.kt:598)");
                        }
                        startRestartGroup.startReplaceableGroup(-1371993712);
                        ComposerKt.sourceInformation(startRestartGroup, "604@30854L5");
                        if (function26 == null) {
                            final float f = z3 ? 1.0f : 0.38f;
                            i15 = 6;
                            final Shape value = ShapesKt.getValue(InputChipTokens.INSTANCE.getAvatarShape(), startRestartGroup, 6);
                            composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 1154227507, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$InputChip$2
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

                                public final void invoke(Composer composer2, int i22) {
                                    ComposerKt.sourceInformation(composer2, "C607@30964L148,606@30909L311:Chip.kt#uh7d8r");
                                    if ((i22 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1154227507, i22, -1, "androidx.compose.material3.InputChip.<anonymous> (Chip.kt:606)");
                                        }
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        composer2.startReplaceableGroup(946467138);
                                        ComposerKt.sourceInformation(composer2, "CC(remember):Chip.kt#9igjgp");
                                        boolean changed = composer2.changed(f) | composer2.changed(value);
                                        final float f2 = f;
                                        final Shape shape4 = value;
                                        Object rememberedValue2 = composer2.rememberedValue();
                                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.ChipKt$InputChip$2$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                    invoke((GraphicsLayerScope) obj);
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                                    graphicsLayerScope.setAlpha(f2);
                                                    graphicsLayerScope.setShape(shape4);
                                                    graphicsLayerScope.setClip(true);
                                                }
                                            };
                                            composer2.updateRememberedValue(rememberedValue2);
                                        }
                                        composer2.endReplaceableGroup();
                                        Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) rememberedValue2);
                                        Alignment center = Alignment.INSTANCE.getCenter();
                                        Function2<Composer, Integer, Unit> function213 = function26;
                                        composer2.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(graphicsLayer);
                                        if (!(composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer2.startReusableNode();
                                        if (composer2.getInserting()) {
                                            composer2.createNode(constructor);
                                        } else {
                                            composer2.useNode();
                                        }
                                        Composer m4109constructorimpl = Updater.m4109constructorimpl(composer2);
                                        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer2, -1294405811, "C614@31198L8:Chip.kt#uh7d8r");
                                        function213.invoke(composer2, 0);
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
                            });
                        } else {
                            i15 = 6;
                            composableLambda = null;
                        }
                        startRestartGroup.endReplaceableGroup();
                        int i22 = i14 << 3;
                        int i23 = i13 << 3;
                        m2327SelectableChipu0RnIRE(z, modifier2, function0, z3, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, i15), InputChipTokens.INSTANCE.getLabelTextFont()), function28, composableLambda, function29, shape2, selectableChipColors2, selectableChipElevation2, borderStroke2, InputChipDefaults.INSTANCE.m2631getHeightD9Ej5fM(), inputChipPadding(composableLambda == null ? z4 : false, function28 == null ? z4 : false, function29 != null ? z4 : false), mutableInteractionSource2, startRestartGroup, (i14 & 14) | ((i14 >> 6) & 112) | (i22 & 896) | ((i14 >> 3) & 7168) | ((i14 << 6) & 57344) | (3670016 & i22) | (234881024 & i22) | (i22 & 1879048192), ((i14 >> 27) & 14) | 3072 | (i23 & 112) | (i23 & 896) | ((i13 << 9) & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        selectableChipElevation3 = selectableChipElevation2;
                        borderStroke3 = borderStroke2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function210 = function26;
                        z5 = z3;
                        function211 = function28;
                        function27 = function29;
                        shape3 = shape2;
                        selectableChipColors3 = selectableChipColors2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final SelectableChipElevation selectableChipElevation4 = selectableChipElevation3;
                        final BorderStroke borderStroke4 = borderStroke3;
                        final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$InputChip$3
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

                            public final void invoke(Composer composer2, int i24) {
                                ChipKt.InputChip(z, function0, function2, modifier3, z5, function211, function210, function27, shape3, selectableChipColors3, selectableChipElevation4, borderStroke4, mutableInteractionSource4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i20 == 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if ((i3 & Fields.RotationX) == 0) {
                }
                if ((i3 & Fields.RotationY) == 0) {
                }
                if ((i3 & Fields.RotationZ) == 0) {
                }
                if ((i3 & Fields.CameraDistance) == 0) {
                }
                if (i12 == 0) {
                }
                i13 = i21;
                modifier2 = modifier4;
                function26 = function212;
                i14 = i11;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-1371993712);
                ComposerKt.sourceInformation(startRestartGroup, "604@30854L5");
                if (function26 == null) {
                }
                startRestartGroup.endReplaceableGroup();
                int i222 = i14 << 3;
                int i232 = i13 << 3;
                m2327SelectableChipu0RnIRE(z, modifier2, function0, z3, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, i15), InputChipTokens.INSTANCE.getLabelTextFont()), function28, composableLambda, function29, shape2, selectableChipColors2, selectableChipElevation2, borderStroke2, InputChipDefaults.INSTANCE.m2631getHeightD9Ej5fM(), inputChipPadding(composableLambda == null ? z4 : false, function28 == null ? z4 : false, function29 != null ? z4 : false), mutableInteractionSource2, startRestartGroup, (i14 & 14) | ((i14 >> 6) & 112) | (i222 & 896) | ((i14 >> 3) & 7168) | ((i14 << 6) & 57344) | (3670016 & i222) | (234881024 & i222) | (i222 & 1879048192), ((i14 >> 27) & 14) | 3072 | (i232 & 112) | (i232 & 896) | ((i13 << 9) & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                selectableChipElevation3 = selectableChipElevation2;
                borderStroke3 = borderStroke2;
                mutableInteractionSource3 = mutableInteractionSource2;
                function210 = function26;
                z5 = z3;
                function211 = function28;
                function27 = function29;
                shape3 = shape2;
                selectableChipColors3 = selectableChipColors2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i3 & 64;
            if (i7 != 0) {
            }
            i8 = i3 & Fields.SpotShadowColor;
            if (i8 != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i212 = i9;
            i10 = i3 & Fields.TransformOrigin;
            if (i10 != 0) {
            }
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i20 == 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
            }
            if ((i3 & Fields.RotationX) == 0) {
            }
            if ((i3 & Fields.RotationY) == 0) {
            }
            if ((i3 & Fields.RotationZ) == 0) {
            }
            if ((i3 & Fields.CameraDistance) == 0) {
            }
            if (i12 == 0) {
            }
            i13 = i212;
            modifier2 = modifier4;
            function26 = function212;
            i14 = i11;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-1371993712);
            ComposerKt.sourceInformation(startRestartGroup, "604@30854L5");
            if (function26 == null) {
            }
            startRestartGroup.endReplaceableGroup();
            int i2222 = i14 << 3;
            int i2322 = i13 << 3;
            m2327SelectableChipu0RnIRE(z, modifier2, function0, z3, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, i15), InputChipTokens.INSTANCE.getLabelTextFont()), function28, composableLambda, function29, shape2, selectableChipColors2, selectableChipElevation2, borderStroke2, InputChipDefaults.INSTANCE.m2631getHeightD9Ej5fM(), inputChipPadding(composableLambda == null ? z4 : false, function28 == null ? z4 : false, function29 != null ? z4 : false), mutableInteractionSource2, startRestartGroup, (i14 & 14) | ((i14 >> 6) & 112) | (i2222 & 896) | ((i14 >> 3) & 7168) | ((i14 << 6) & 57344) | (3670016 & i2222) | (234881024 & i2222) | (i2222 & 1879048192), ((i14 >> 27) & 14) | 3072 | (i2322 & 112) | (i2322 & 896) | ((i13 << 9) & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            selectableChipElevation3 = selectableChipElevation2;
            borderStroke3 = borderStroke2;
            mutableInteractionSource3 = mutableInteractionSource2;
            function210 = function26;
            z5 = z3;
            function211 = function28;
            function27 = function29;
            shape3 = shape2;
            selectableChipColors3 = selectableChipColors2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i3 & 64;
        if (i7 != 0) {
        }
        i8 = i3 & Fields.SpotShadowColor;
        if (i8 != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i2122 = i9;
        i10 = i3 & Fields.TransformOrigin;
        if (i10 != 0) {
        }
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i20 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if ((i3 & Fields.RotationX) == 0) {
        }
        if ((i3 & Fields.RotationY) == 0) {
        }
        if ((i3 & Fields.RotationZ) == 0) {
        }
        if ((i3 & Fields.CameraDistance) == 0) {
        }
        if (i12 == 0) {
        }
        i13 = i2122;
        modifier2 = modifier4;
        function26 = function212;
        i14 = i11;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-1371993712);
        ComposerKt.sourceInformation(startRestartGroup, "604@30854L5");
        if (function26 == null) {
        }
        startRestartGroup.endReplaceableGroup();
        int i22222 = i14 << 3;
        int i23222 = i13 << 3;
        m2327SelectableChipu0RnIRE(z, modifier2, function0, z3, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, i15), InputChipTokens.INSTANCE.getLabelTextFont()), function28, composableLambda, function29, shape2, selectableChipColors2, selectableChipElevation2, borderStroke2, InputChipDefaults.INSTANCE.m2631getHeightD9Ej5fM(), inputChipPadding(composableLambda == null ? z4 : false, function28 == null ? z4 : false, function29 != null ? z4 : false), mutableInteractionSource2, startRestartGroup, (i14 & 14) | ((i14 >> 6) & 112) | (i22222 & 896) | ((i14 >> 3) & 7168) | ((i14 << 6) & 57344) | (3670016 & i22222) | (234881024 & i22222) | (i22222 & 1879048192), ((i14 >> 27) & 14) | 3072 | (i23222 & 112) | (i23222 & 896) | ((i13 << 9) & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        selectableChipElevation3 = selectableChipElevation2;
        borderStroke3 = borderStroke2;
        mutableInteractionSource3 = mutableInteractionSource2;
        function210 = function26;
        z5 = z3;
        function211 = function28;
        function27 = function29;
        shape3 = shape2;
        selectableChipColors3 = selectableChipColors2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SuggestionChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Shape shape2;
        ChipColors chipColors2;
        int i6;
        int i7;
        final MutableInteractionSource mutableInteractionSource2;
        Shape shape3;
        int i8;
        ChipColors chipColors3;
        ChipElevation chipElevation2;
        BorderStroke borderStroke2;
        MutableInteractionSource mutableInteractionSource3;
        BorderStroke borderStroke3;
        ChipElevation chipElevation3;
        int i9;
        Composer composer2;
        final boolean z3;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Shape shape4;
        final ChipColors chipColors4;
        final ChipElevation chipElevation4;
        final BorderStroke borderStroke4;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-1700130831);
        ComposerKt.sourceInformation(startRestartGroup, "C(SuggestionChip)P(8,6,7,3,4,9,1,2)688@34668L5,689@34723L22,690@34802L25,691@34880L29,692@34961L39,698@35137L10,693@35006L504:Chip.kt#uh7d8r");
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
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i14 = i2 & 4;
        if (i14 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    function23 = function22;
                    i3 |= startRestartGroup.changedInstance(function23) ? Fields.Clip : Fields.Shape;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i13 = Fields.RenderEffect;
                                i3 |= i13;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i13 = 65536;
                        i3 |= i13;
                    } else {
                        shape2 = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i12 = 1048576;
                                i3 |= i12;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i12 = Fields.BlendMode;
                        i3 |= i12;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(chipElevation)) {
                            i11 = 8388608;
                            i3 |= i11;
                        }
                        i11 = 4194304;
                        i3 |= i11;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i2 & Fields.RotationX) == 0 && startRestartGroup.changed(borderStroke)) {
                            i10 = 67108864;
                            i3 |= i10;
                        }
                        i10 = 33554432;
                        i3 |= i10;
                    }
                    i6 = i2 & Fields.RotationY;
                    if (i6 == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i7 = i6;
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 536870912 : 268435456;
                        if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i14 != 0 ? Modifier.INSTANCE : modifier;
                                boolean z4 = i4 != 0 ? true : z2;
                                Function2<? super Composer, ? super Integer, Unit> function25 = i5 != 0 ? null : function23;
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    shape3 = SuggestionChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                if ((i2 & 64) != 0) {
                                    i8 = i3 & (-3670017);
                                    chipColors3 = SuggestionChipDefaults.INSTANCE.suggestionChipColors(startRestartGroup, 6);
                                } else {
                                    i8 = i3;
                                    chipColors3 = chipColors2;
                                }
                                if ((i2 & Fields.SpotShadowColor) != 0) {
                                    modifier = companion;
                                    i8 &= -29360129;
                                    chipElevation2 = SuggestionChipDefaults.INSTANCE.m3042suggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                } else {
                                    modifier = companion;
                                    chipElevation2 = chipElevation;
                                }
                                if ((i2 & Fields.RotationX) != 0) {
                                    borderStroke2 = SuggestionChipDefaults.INSTANCE.m3040suggestionChipBorderh1eTWw(z4, 0L, 0L, 0.0f, startRestartGroup, ((i8 >> 9) & 14) | 24576, 14);
                                    i8 &= -234881025;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if (i7 != 0) {
                                    startRestartGroup.startReplaceableGroup(2118462942);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Chip.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    borderStroke3 = borderStroke2;
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    borderStroke3 = borderStroke2;
                                }
                                chipElevation3 = chipElevation2;
                                shape2 = shape3;
                                z2 = z4;
                                function23 = function25;
                                chipColors2 = chipColors3;
                                i9 = i8;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                if ((i2 & Fields.SpotShadowColor) != 0) {
                                    i3 &= -29360129;
                                }
                                if ((i2 & Fields.RotationX) != 0) {
                                    i3 &= -234881025;
                                }
                                chipElevation3 = chipElevation;
                                borderStroke3 = borderStroke;
                                mutableInteractionSource3 = mutableInteractionSource;
                                i9 = i3;
                            }
                            Modifier modifier3 = modifier;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1700130831, i9, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:693)");
                            }
                            int i15 = i9 << 6;
                            int i16 = ((i9 >> 6) & 14) | 12582912 | ((i9 << 3) & 112) | ((i9 >> 3) & 896) | (i15 & 7168) | (i15 & 3670016);
                            int i17 = i9 << 9;
                            int i18 = i16 | (234881024 & i17) | (i17 & 1879048192);
                            int i19 = i9 >> 21;
                            int i20 = (i19 & 112) | (i19 & 14) | 3456 | ((i9 >> 15) & 57344);
                            composer2 = startRestartGroup;
                            m2325ChipnkUnTEs(modifier3, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function23, null, shape2, chipColors2, chipElevation3, borderStroke3, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i18, i20);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource2 = mutableInteractionSource3;
                            z3 = z2;
                            function24 = function23;
                            shape4 = shape2;
                            chipColors4 = chipColors2;
                            chipElevation4 = chipElevation3;
                            borderStroke4 = borderStroke3;
                            modifier2 = modifier3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            z3 = z2;
                            function24 = function23;
                            shape4 = shape2;
                            chipColors4 = chipColors2;
                            composer2 = startRestartGroup;
                            chipElevation4 = chipElevation;
                            borderStroke4 = borderStroke;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SuggestionChip$2
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

                                public final void invoke(Composer composer3, int i21) {
                                    ChipKt.SuggestionChip(function0, function2, modifier2, z3, function24, shape4, chipColors4, chipElevation4, borderStroke4, mutableInteractionSource2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i7 = i6;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & Fields.SpotShadowColor) != 0) {
                    }
                    if ((i2 & Fields.RotationX) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    chipElevation3 = chipElevation2;
                    shape2 = shape3;
                    z2 = z4;
                    function23 = function25;
                    chipColors2 = chipColors3;
                    i9 = i8;
                    Modifier modifier32 = modifier;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i152 = i9 << 6;
                    int i162 = ((i9 >> 6) & 14) | 12582912 | ((i9 << 3) & 112) | ((i9 >> 3) & 896) | (i152 & 7168) | (i152 & 3670016);
                    int i172 = i9 << 9;
                    int i182 = i162 | (234881024 & i172) | (i172 & 1879048192);
                    int i192 = i9 >> 21;
                    int i202 = (i192 & 112) | (i192 & 14) | 3456 | ((i9 >> 15) & 57344);
                    composer2 = startRestartGroup;
                    m2325ChipnkUnTEs(modifier32, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function23, null, shape2, chipColors2, chipElevation3, borderStroke3, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i182, i202);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z3 = z2;
                    function24 = function23;
                    shape4 = shape2;
                    chipColors4 = chipColors2;
                    chipElevation4 = chipElevation3;
                    borderStroke4 = borderStroke3;
                    modifier2 = modifier32;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function23 = function22;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i6 = i2 & Fields.RotationY;
                if (i6 == 0) {
                }
                i7 = i6;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i14 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & Fields.SpotShadowColor) != 0) {
                }
                if ((i2 & Fields.RotationX) != 0) {
                }
                if (i7 != 0) {
                }
                chipElevation3 = chipElevation2;
                shape2 = shape3;
                z2 = z4;
                function23 = function25;
                chipColors2 = chipColors3;
                i9 = i8;
                Modifier modifier322 = modifier;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1522 = i9 << 6;
                int i1622 = ((i9 >> 6) & 14) | 12582912 | ((i9 << 3) & 112) | ((i9 >> 3) & 896) | (i1522 & 7168) | (i1522 & 3670016);
                int i1722 = i9 << 9;
                int i1822 = i1622 | (234881024 & i1722) | (i1722 & 1879048192);
                int i1922 = i9 >> 21;
                int i2022 = (i1922 & 112) | (i1922 & 14) | 3456 | ((i9 >> 15) & 57344);
                composer2 = startRestartGroup;
                m2325ChipnkUnTEs(modifier322, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function23, null, shape2, chipColors2, chipElevation3, borderStroke3, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i1822, i2022);
                if (ComposerKt.isTraceInProgress()) {
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                z3 = z2;
                function24 = function23;
                shape4 = shape2;
                chipColors4 = chipColors2;
                chipElevation4 = chipElevation3;
                borderStroke4 = borderStroke3;
                modifier2 = modifier322;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function23 = function22;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i6 = i2 & Fields.RotationY;
            if (i6 == 0) {
            }
            i7 = i6;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i14 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & Fields.SpotShadowColor) != 0) {
            }
            if ((i2 & Fields.RotationX) != 0) {
            }
            if (i7 != 0) {
            }
            chipElevation3 = chipElevation2;
            shape2 = shape3;
            z2 = z4;
            function23 = function25;
            chipColors2 = chipColors3;
            i9 = i8;
            Modifier modifier3222 = modifier;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i15222 = i9 << 6;
            int i16222 = ((i9 >> 6) & 14) | 12582912 | ((i9 << 3) & 112) | ((i9 >> 3) & 896) | (i15222 & 7168) | (i15222 & 3670016);
            int i17222 = i9 << 9;
            int i18222 = i16222 | (234881024 & i17222) | (i17222 & 1879048192);
            int i19222 = i9 >> 21;
            int i20222 = (i19222 & 112) | (i19222 & 14) | 3456 | ((i9 >> 15) & 57344);
            composer2 = startRestartGroup;
            m2325ChipnkUnTEs(modifier3222, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function23, null, shape2, chipColors2, chipElevation3, borderStroke3, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i18222, i20222);
            if (ComposerKt.isTraceInProgress()) {
            }
            mutableInteractionSource2 = mutableInteractionSource3;
            z3 = z2;
            function24 = function23;
            shape4 = shape2;
            chipColors4 = chipColors2;
            chipElevation4 = chipElevation3;
            borderStroke4 = borderStroke3;
            modifier2 = modifier3222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function23 = function22;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i6 = i2 & Fields.RotationY;
        if (i6 == 0) {
        }
        i7 = i6;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i14 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & Fields.SpotShadowColor) != 0) {
        }
        if ((i2 & Fields.RotationX) != 0) {
        }
        if (i7 != 0) {
        }
        chipElevation3 = chipElevation2;
        shape2 = shape3;
        z2 = z4;
        function23 = function25;
        chipColors2 = chipColors3;
        i9 = i8;
        Modifier modifier32222 = modifier;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i152222 = i9 << 6;
        int i162222 = ((i9 >> 6) & 14) | 12582912 | ((i9 << 3) & 112) | ((i9 >> 3) & 896) | (i152222 & 7168) | (i152222 & 3670016);
        int i172222 = i9 << 9;
        int i182222 = i162222 | (234881024 & i172222) | (i172222 & 1879048192);
        int i192222 = i9 >> 21;
        int i202222 = (i192222 & 112) | (i192222 & 14) | 3456 | ((i9 >> 15) & 57344);
        composer2 = startRestartGroup;
        m2325ChipnkUnTEs(modifier32222, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function23, null, shape2, chipColors2, chipElevation3, borderStroke3, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i182222, i202222);
        if (ComposerKt.isTraceInProgress()) {
        }
        mutableInteractionSource2 = mutableInteractionSource3;
        z3 = z2;
        function24 = function23;
        shape4 = shape2;
        chipColors4 = chipColors2;
        chipElevation4 = chipElevation3;
        borderStroke4 = borderStroke3;
        modifier2 = modifier32222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0199  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with SuggestionChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "SuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void SuggestionChip(final Function0 function0, final Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z2;
        int i5;
        Function2 function23;
        Shape shape2;
        ChipColors chipColors2;
        int i6;
        int i7;
        final MutableInteractionSource mutableInteractionSource2;
        Shape shape3;
        int i8;
        ChipColors chipColors3;
        Modifier modifier2;
        ChipElevation chipElevation2;
        ChipBorder chipBorder2;
        MutableInteractionSource mutableInteractionSource3;
        ChipBorder chipBorder3;
        int i9;
        Modifier modifier3;
        Composer composer2;
        final boolean z3;
        final Function2 function24;
        final Shape shape4;
        final ChipColors chipColors4;
        final ChipElevation chipElevation3;
        final ChipBorder chipBorder4;
        final Modifier modifier4;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(170629701);
        ComposerKt.sourceInformation(startRestartGroup, "C(SuggestionChip)P(8,6,7,3,4,9,1,2)765@38541L5,766@38596L22,767@38675L25,768@38751L22,769@38825L39,775@39001L10,770@38870L534:Chip.kt#uh7d8r");
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
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i14 = i2 & 4;
        if (i14 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    function23 = function22;
                    i3 |= startRestartGroup.changedInstance(function23) ? Fields.Clip : Fields.Shape;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i13 = Fields.RenderEffect;
                                i3 |= i13;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i13 = 65536;
                        i3 |= i13;
                    } else {
                        shape2 = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i12 = 1048576;
                                i3 |= i12;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i12 = Fields.BlendMode;
                        i3 |= i12;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(chipElevation)) {
                            i11 = 8388608;
                            i3 |= i11;
                        }
                        i11 = 4194304;
                        i3 |= i11;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i2 & Fields.RotationX) == 0 && startRestartGroup.changed(chipBorder)) {
                            i10 = 67108864;
                            i3 |= i10;
                        }
                        i10 = 33554432;
                        i3 |= i10;
                    }
                    i6 = i2 & Fields.RotationY;
                    if (i6 == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i7 = i6;
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 536870912 : 268435456;
                        if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i14 != 0 ? Modifier.INSTANCE : modifier;
                                boolean z4 = i4 != 0 ? true : z2;
                                Function2 function25 = i5 != 0 ? null : function23;
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    shape3 = SuggestionChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                if ((i2 & 64) != 0) {
                                    i8 = i3 & (-3670017);
                                    chipColors3 = SuggestionChipDefaults.INSTANCE.suggestionChipColors(startRestartGroup, 6);
                                } else {
                                    i8 = i3;
                                    chipColors3 = chipColors2;
                                }
                                if ((i2 & Fields.SpotShadowColor) != 0) {
                                    modifier2 = companion;
                                    i8 &= -29360129;
                                    chipElevation2 = SuggestionChipDefaults.INSTANCE.m3042suggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                } else {
                                    modifier2 = companion;
                                    chipElevation2 = chipElevation;
                                }
                                if ((i2 & Fields.RotationX) != 0) {
                                    chipBorder2 = SuggestionChipDefaults.INSTANCE.m3039suggestionChipBorderd_3_b6Q(0L, 0L, 0.0f, startRestartGroup, 3072, 7);
                                    i8 &= -234881025;
                                } else {
                                    chipBorder2 = chipBorder;
                                }
                                if (i7 != 0) {
                                    startRestartGroup.startReplaceableGroup(2118466806);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Chip.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                    shape2 = shape3;
                                    z2 = z4;
                                    function23 = function25;
                                    chipColors2 = chipColors3;
                                    i9 = i8;
                                    chipBorder3 = chipBorder2;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    chipBorder3 = chipBorder2;
                                    shape2 = shape3;
                                    z2 = z4;
                                    function23 = function25;
                                    chipColors2 = chipColors3;
                                    i9 = i8;
                                }
                                modifier3 = modifier2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                if ((i2 & Fields.SpotShadowColor) != 0) {
                                    i3 &= -29360129;
                                }
                                if ((i2 & Fields.RotationX) != 0) {
                                    i3 &= -234881025;
                                }
                                chipBorder3 = chipBorder;
                                mutableInteractionSource3 = mutableInteractionSource;
                                i9 = i3;
                                modifier3 = modifier;
                                chipElevation2 = chipElevation;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(170629701, i9, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:770)");
                            }
                            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont());
                            long m2315labelColorvNxB06k$material3_release = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
                            startRestartGroup.startReplaceableGroup(2118467222);
                            ComposerKt.sourceInformation(startRestartGroup, "782@39241L21");
                            State<BorderStroke> borderStroke$material3_release = chipBorder3 == null ? null : chipBorder3.borderStroke$material3_release(z2, startRestartGroup, ((i9 >> 9) & 14) | ((i9 >> 21) & 112));
                            startRestartGroup.endReplaceableGroup();
                            BorderStroke value = borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null;
                            int i15 = i9 << 6;
                            int i16 = ((i9 >> 6) & 14) | 12582912 | ((i9 << 3) & 112) | ((i9 >> 3) & 896) | (i15 & 7168) | (i15 & 3670016);
                            int i17 = i9 << 9;
                            composer2 = startRestartGroup;
                            m2325ChipnkUnTEs(modifier3, function0, z2, function2, fromToken, m2315labelColorvNxB06k$material3_release, function23, null, shape2, chipColors2, chipElevation2, value, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i16 | (234881024 & i17) | (i17 & 1879048192), ((i9 >> 21) & 14) | 3456 | ((i9 >> 15) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z3 = z2;
                            function24 = function23;
                            shape4 = shape2;
                            chipColors4 = chipColors2;
                            chipElevation3 = chipElevation2;
                            chipBorder4 = chipBorder3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            modifier4 = modifier3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier4 = modifier;
                            z3 = z2;
                            function24 = function23;
                            shape4 = shape2;
                            chipColors4 = chipColors2;
                            composer2 = startRestartGroup;
                            chipElevation3 = chipElevation;
                            chipBorder4 = chipBorder;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SuggestionChip$4
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

                                public final void invoke(Composer composer3, int i18) {
                                    ChipKt.SuggestionChip(function0, function2, modifier4, z3, function24, shape4, chipColors4, chipElevation3, chipBorder4, mutableInteractionSource2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i7 = i6;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & Fields.SpotShadowColor) != 0) {
                    }
                    if ((i2 & Fields.RotationX) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    modifier3 = modifier2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont());
                    long m2315labelColorvNxB06k$material3_release2 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
                    startRestartGroup.startReplaceableGroup(2118467222);
                    ComposerKt.sourceInformation(startRestartGroup, "782@39241L21");
                    if (chipBorder3 == null) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    if (borderStroke$material3_release != null) {
                    }
                    int i152 = i9 << 6;
                    int i162 = ((i9 >> 6) & 14) | 12582912 | ((i9 << 3) & 112) | ((i9 >> 3) & 896) | (i152 & 7168) | (i152 & 3670016);
                    int i172 = i9 << 9;
                    composer2 = startRestartGroup;
                    m2325ChipnkUnTEs(modifier3, function0, z2, function2, fromToken2, m2315labelColorvNxB06k$material3_release2, function23, null, shape2, chipColors2, chipElevation2, value, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i162 | (234881024 & i172) | (i172 & 1879048192), ((i9 >> 21) & 14) | 3456 | ((i9 >> 15) & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z3 = z2;
                    function24 = function23;
                    shape4 = shape2;
                    chipColors4 = chipColors2;
                    chipElevation3 = chipElevation2;
                    chipBorder4 = chipBorder3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier4 = modifier3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function23 = function22;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i6 = i2 & Fields.RotationY;
                if (i6 == 0) {
                }
                i7 = i6;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i14 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & Fields.SpotShadowColor) != 0) {
                }
                if ((i2 & Fields.RotationX) != 0) {
                }
                if (i7 != 0) {
                }
                modifier3 = modifier2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                TextStyle fromToken22 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont());
                long m2315labelColorvNxB06k$material3_release22 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
                startRestartGroup.startReplaceableGroup(2118467222);
                ComposerKt.sourceInformation(startRestartGroup, "782@39241L21");
                if (chipBorder3 == null) {
                }
                startRestartGroup.endReplaceableGroup();
                if (borderStroke$material3_release != null) {
                }
                int i1522 = i9 << 6;
                int i1622 = ((i9 >> 6) & 14) | 12582912 | ((i9 << 3) & 112) | ((i9 >> 3) & 896) | (i1522 & 7168) | (i1522 & 3670016);
                int i1722 = i9 << 9;
                composer2 = startRestartGroup;
                m2325ChipnkUnTEs(modifier3, function0, z2, function2, fromToken22, m2315labelColorvNxB06k$material3_release22, function23, null, shape2, chipColors2, chipElevation2, value, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i1622 | (234881024 & i1722) | (i1722 & 1879048192), ((i9 >> 21) & 14) | 3456 | ((i9 >> 15) & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                z3 = z2;
                function24 = function23;
                shape4 = shape2;
                chipColors4 = chipColors2;
                chipElevation3 = chipElevation2;
                chipBorder4 = chipBorder3;
                mutableInteractionSource2 = mutableInteractionSource3;
                modifier4 = modifier3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function23 = function22;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i6 = i2 & Fields.RotationY;
            if (i6 == 0) {
            }
            i7 = i6;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i14 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & Fields.SpotShadowColor) != 0) {
            }
            if ((i2 & Fields.RotationX) != 0) {
            }
            if (i7 != 0) {
            }
            modifier3 = modifier2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            TextStyle fromToken222 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont());
            long m2315labelColorvNxB06k$material3_release222 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
            startRestartGroup.startReplaceableGroup(2118467222);
            ComposerKt.sourceInformation(startRestartGroup, "782@39241L21");
            if (chipBorder3 == null) {
            }
            startRestartGroup.endReplaceableGroup();
            if (borderStroke$material3_release != null) {
            }
            int i15222 = i9 << 6;
            int i16222 = ((i9 >> 6) & 14) | 12582912 | ((i9 << 3) & 112) | ((i9 >> 3) & 896) | (i15222 & 7168) | (i15222 & 3670016);
            int i17222 = i9 << 9;
            composer2 = startRestartGroup;
            m2325ChipnkUnTEs(modifier3, function0, z2, function2, fromToken222, m2315labelColorvNxB06k$material3_release222, function23, null, shape2, chipColors2, chipElevation2, value, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i16222 | (234881024 & i17222) | (i17222 & 1879048192), ((i9 >> 21) & 14) | 3456 | ((i9 >> 15) & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            z3 = z2;
            function24 = function23;
            shape4 = shape2;
            chipColors4 = chipColors2;
            chipElevation3 = chipElevation2;
            chipBorder4 = chipBorder3;
            mutableInteractionSource2 = mutableInteractionSource3;
            modifier4 = modifier3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function23 = function22;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i6 = i2 & Fields.RotationY;
        if (i6 == 0) {
        }
        i7 = i6;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i14 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & Fields.SpotShadowColor) != 0) {
        }
        if ((i2 & Fields.RotationX) != 0) {
        }
        if (i7 != 0) {
        }
        modifier3 = modifier2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        TextStyle fromToken2222 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont());
        long m2315labelColorvNxB06k$material3_release2222 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
        startRestartGroup.startReplaceableGroup(2118467222);
        ComposerKt.sourceInformation(startRestartGroup, "782@39241L21");
        if (chipBorder3 == null) {
        }
        startRestartGroup.endReplaceableGroup();
        if (borderStroke$material3_release != null) {
        }
        int i152222 = i9 << 6;
        int i162222 = ((i9 >> 6) & 14) | 12582912 | ((i9 << 3) & 112) | ((i9 >> 3) & 896) | (i152222 & 7168) | (i152222 & 3670016);
        int i172222 = i9 << 9;
        composer2 = startRestartGroup;
        m2325ChipnkUnTEs(modifier3, function0, z2, function2, fromToken2222, m2315labelColorvNxB06k$material3_release2222, function23, null, shape2, chipColors2, chipElevation2, value, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i162222 | (234881024 & i172222) | (i172222 & 1879048192), ((i9 >> 21) & 14) | 3456 | ((i9 >> 15) & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        z3 = z2;
        function24 = function23;
        shape4 = shape2;
        chipColors4 = chipColors2;
        chipElevation3 = chipElevation2;
        chipBorder4 = chipBorder3;
        mutableInteractionSource2 = mutableInteractionSource3;
        modifier4 = modifier3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedSuggestionChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Shape shape2;
        ChipColors chipColors2;
        int i6;
        int i7;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape3;
        int i9;
        ChipColors chipColors3;
        ChipElevation chipElevation2;
        MutableInteractionSource mutableInteractionSource3;
        ChipElevation chipElevation3;
        Modifier modifier2;
        boolean z2;
        BorderStroke borderStroke2;
        int i10;
        Composer composer2;
        BorderStroke borderStroke3;
        MutableInteractionSource mutableInteractionSource4;
        final Shape shape4;
        final Modifier modifier3;
        final boolean z3;
        final ChipElevation chipElevation4;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-818834969);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)833@42061L5,834@42116L30,835@42203L33,837@42322L39,843@42498L10,838@42367L504:Chip.kt#uh7d8r");
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
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i14 = i2 & 4;
        if (i14 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changed(z) ? Fields.CameraDistance : Fields.RotationZ;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    function23 = function22;
                    i3 |= startRestartGroup.changedInstance(function23) ? Fields.Clip : Fields.Shape;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i13 = Fields.RenderEffect;
                                i3 |= i13;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i13 = 65536;
                        i3 |= i13;
                    } else {
                        shape2 = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i12 = 1048576;
                                i3 |= i12;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i12 = Fields.BlendMode;
                        i3 |= i12;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(chipElevation)) {
                            i11 = 8388608;
                            i3 |= i11;
                        }
                        i11 = 4194304;
                        i3 |= i11;
                    }
                    i6 = i2 & Fields.RotationX;
                    if (i6 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changed(borderStroke) ? 67108864 : 33554432;
                    }
                    i7 = i2 & Fields.RotationY;
                    if (i7 == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i8 = i7;
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 536870912 : 268435456;
                        if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier4 = i14 != 0 ? Modifier.INSTANCE : modifier;
                                boolean z4 = i4 != 0 ? true : z;
                                Function2<? super Composer, ? super Integer, Unit> function24 = i5 != 0 ? null : function23;
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    shape3 = SuggestionChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                if ((i2 & 64) != 0) {
                                    i9 = i3 & (-3670017);
                                    chipColors3 = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipColors(startRestartGroup, 6);
                                } else {
                                    i9 = i3;
                                    chipColors3 = chipColors2;
                                }
                                if ((i2 & Fields.SpotShadowColor) != 0) {
                                    chipElevation2 = SuggestionChipDefaults.INSTANCE.m3036elevatedSuggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                    i9 &= -29360129;
                                } else {
                                    chipElevation2 = chipElevation;
                                }
                                BorderStroke borderStroke4 = i6 == 0 ? borderStroke : null;
                                if (i8 != 0) {
                                    startRestartGroup.startReplaceableGroup(-1455582059);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Chip.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                chipElevation3 = chipElevation2;
                                shape2 = shape3;
                                modifier2 = modifier4;
                                z2 = z4;
                                borderStroke2 = borderStroke4;
                                function23 = function24;
                                chipColors2 = chipColors3;
                                i10 = i9;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                if ((i2 & Fields.SpotShadowColor) != 0) {
                                    i3 &= -29360129;
                                }
                                modifier2 = modifier;
                                chipElevation3 = chipElevation;
                                borderStroke2 = borderStroke;
                                mutableInteractionSource3 = mutableInteractionSource;
                                i10 = i3;
                                z2 = z;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-818834969, i10, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:838)");
                            }
                            int i15 = i10 << 6;
                            int i16 = ((i10 >> 6) & 14) | 12582912 | ((i10 << 3) & 112) | ((i10 >> 3) & 896) | (i15 & 7168) | (i15 & 3670016);
                            int i17 = i10 << 9;
                            int i18 = i16 | (234881024 & i17) | (i17 & 1879048192);
                            int i19 = i10 >> 21;
                            int i20 = (i19 & 112) | (i19 & 14) | 3456 | ((i10 >> 15) & 57344);
                            composer2 = startRestartGroup;
                            m2325ChipnkUnTEs(modifier2, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function23, null, shape2, chipColors2, chipElevation3, borderStroke2, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i18, i20);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            borderStroke3 = borderStroke2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape2;
                            modifier3 = modifier2;
                            z3 = z2;
                            chipElevation4 = chipElevation3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            z3 = z;
                            shape4 = shape2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            composer2 = startRestartGroup;
                            chipElevation4 = chipElevation;
                            borderStroke3 = borderStroke;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                            final ChipColors chipColors4 = chipColors2;
                            final BorderStroke borderStroke5 = borderStroke3;
                            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ElevatedSuggestionChip$2
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

                                public final void invoke(Composer composer3, int i21) {
                                    ChipKt.ElevatedSuggestionChip(function0, function2, modifier3, z3, function25, shape4, chipColors4, chipElevation4, borderStroke5, mutableInteractionSource5, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = i7;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & Fields.SpotShadowColor) != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i8 != 0) {
                    }
                    chipElevation3 = chipElevation2;
                    shape2 = shape3;
                    modifier2 = modifier4;
                    z2 = z4;
                    borderStroke2 = borderStroke4;
                    function23 = function24;
                    chipColors2 = chipColors3;
                    i10 = i9;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i152 = i10 << 6;
                    int i162 = ((i10 >> 6) & 14) | 12582912 | ((i10 << 3) & 112) | ((i10 >> 3) & 896) | (i152 & 7168) | (i152 & 3670016);
                    int i172 = i10 << 9;
                    int i182 = i162 | (234881024 & i172) | (i172 & 1879048192);
                    int i192 = i10 >> 21;
                    int i202 = (i192 & 112) | (i192 & 14) | 3456 | ((i10 >> 15) & 57344);
                    composer2 = startRestartGroup;
                    m2325ChipnkUnTEs(modifier2, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function23, null, shape2, chipColors2, chipElevation3, borderStroke2, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i182, i202);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape2;
                    modifier3 = modifier2;
                    z3 = z2;
                    chipElevation4 = chipElevation3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function23 = function22;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i6 = i2 & Fields.RotationX;
                if (i6 == 0) {
                }
                i7 = i2 & Fields.RotationY;
                if (i7 == 0) {
                }
                i8 = i7;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i14 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & Fields.SpotShadowColor) != 0) {
                }
                if (i6 == 0) {
                }
                if (i8 != 0) {
                }
                chipElevation3 = chipElevation2;
                shape2 = shape3;
                modifier2 = modifier4;
                z2 = z4;
                borderStroke2 = borderStroke4;
                function23 = function24;
                chipColors2 = chipColors3;
                i10 = i9;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1522 = i10 << 6;
                int i1622 = ((i10 >> 6) & 14) | 12582912 | ((i10 << 3) & 112) | ((i10 >> 3) & 896) | (i1522 & 7168) | (i1522 & 3670016);
                int i1722 = i10 << 9;
                int i1822 = i1622 | (234881024 & i1722) | (i1722 & 1879048192);
                int i1922 = i10 >> 21;
                int i2022 = (i1922 & 112) | (i1922 & 14) | 3456 | ((i10 >> 15) & 57344);
                composer2 = startRestartGroup;
                m2325ChipnkUnTEs(modifier2, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function23, null, shape2, chipColors2, chipElevation3, borderStroke2, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i1822, i2022);
                if (ComposerKt.isTraceInProgress()) {
                }
                borderStroke3 = borderStroke2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape2;
                modifier3 = modifier2;
                z3 = z2;
                chipElevation4 = chipElevation3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function23 = function22;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i6 = i2 & Fields.RotationX;
            if (i6 == 0) {
            }
            i7 = i2 & Fields.RotationY;
            if (i7 == 0) {
            }
            i8 = i7;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i14 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & Fields.SpotShadowColor) != 0) {
            }
            if (i6 == 0) {
            }
            if (i8 != 0) {
            }
            chipElevation3 = chipElevation2;
            shape2 = shape3;
            modifier2 = modifier4;
            z2 = z4;
            borderStroke2 = borderStroke4;
            function23 = function24;
            chipColors2 = chipColors3;
            i10 = i9;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i15222 = i10 << 6;
            int i16222 = ((i10 >> 6) & 14) | 12582912 | ((i10 << 3) & 112) | ((i10 >> 3) & 896) | (i15222 & 7168) | (i15222 & 3670016);
            int i17222 = i10 << 9;
            int i18222 = i16222 | (234881024 & i17222) | (i17222 & 1879048192);
            int i19222 = i10 >> 21;
            int i20222 = (i19222 & 112) | (i19222 & 14) | 3456 | ((i10 >> 15) & 57344);
            composer2 = startRestartGroup;
            m2325ChipnkUnTEs(modifier2, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function23, null, shape2, chipColors2, chipElevation3, borderStroke2, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i18222, i20222);
            if (ComposerKt.isTraceInProgress()) {
            }
            borderStroke3 = borderStroke2;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape4 = shape2;
            modifier3 = modifier2;
            z3 = z2;
            chipElevation4 = chipElevation3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function23 = function22;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i6 = i2 & Fields.RotationX;
        if (i6 == 0) {
        }
        i7 = i2 & Fields.RotationY;
        if (i7 == 0) {
        }
        i8 = i7;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i14 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & Fields.SpotShadowColor) != 0) {
        }
        if (i6 == 0) {
        }
        if (i8 != 0) {
        }
        chipElevation3 = chipElevation2;
        shape2 = shape3;
        modifier2 = modifier4;
        z2 = z4;
        borderStroke2 = borderStroke4;
        function23 = function24;
        chipColors2 = chipColors3;
        i10 = i9;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i152222 = i10 << 6;
        int i162222 = ((i10 >> 6) & 14) | 12582912 | ((i10 << 3) & 112) | ((i10 >> 3) & 896) | (i152222 & 7168) | (i152222 & 3670016);
        int i172222 = i10 << 9;
        int i182222 = i162222 | (234881024 & i172222) | (i172222 & 1879048192);
        int i192222 = i10 >> 21;
        int i202222 = (i192222 & 112) | (i192222 & 14) | 3456 | ((i10 >> 15) & 57344);
        composer2 = startRestartGroup;
        m2325ChipnkUnTEs(modifier2, function0, z2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont()), chipColors2.m2315labelColorvNxB06k$material3_release(z2), function23, null, shape2, chipColors2, chipElevation3, borderStroke2, SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i182222, i202222);
        if (ComposerKt.isTraceInProgress()) {
        }
        borderStroke3 = borderStroke2;
        mutableInteractionSource4 = mutableInteractionSource3;
        shape4 = shape2;
        modifier3 = modifier2;
        z3 = z2;
        chipElevation4 = chipElevation3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ae  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedSuggestionChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "ElevatedSuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void ElevatedSuggestionChip(final Function0 function0, final Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        Function2 function23;
        Shape shape2;
        ChipColors chipColors2;
        int i6;
        int i7;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape3;
        int i9;
        ChipColors chipColors3;
        ChipElevation chipElevation2;
        MutableInteractionSource mutableInteractionSource3;
        ChipBorder chipBorder2;
        ChipElevation chipElevation3;
        Modifier modifier2;
        boolean z2;
        int i10;
        Composer composer2;
        ChipBorder chipBorder3;
        MutableInteractionSource mutableInteractionSource4;
        final Shape shape4;
        final Modifier modifier3;
        final boolean z3;
        final ChipElevation chipElevation4;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1668751803);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)909@45897L5,910@45952L30,911@46039L33,913@46156L39,919@46332L10,914@46201L534:Chip.kt#uh7d8r");
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
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i14 = i2 & 4;
        if (i14 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changed(z) ? Fields.CameraDistance : Fields.RotationZ;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    function23 = function22;
                    i3 |= startRestartGroup.changedInstance(function23) ? Fields.Clip : Fields.Shape;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i13 = Fields.RenderEffect;
                                i3 |= i13;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i13 = 65536;
                        i3 |= i13;
                    } else {
                        shape2 = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i12 = 1048576;
                                i3 |= i12;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i12 = Fields.BlendMode;
                        i3 |= i12;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(chipElevation)) {
                            i11 = 8388608;
                            i3 |= i11;
                        }
                        i11 = 4194304;
                        i3 |= i11;
                    }
                    i6 = i2 & Fields.RotationX;
                    if (i6 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changed(chipBorder) ? 67108864 : 33554432;
                    }
                    i7 = i2 & Fields.RotationY;
                    if (i7 == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i8 = i7;
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 536870912 : 268435456;
                        if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier4 = i14 != 0 ? Modifier.INSTANCE : modifier;
                                boolean z4 = i4 != 0 ? true : z;
                                Function2 function24 = i5 != 0 ? null : function23;
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    shape3 = SuggestionChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                if ((i2 & 64) != 0) {
                                    i9 = i3 & (-3670017);
                                    chipColors3 = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipColors(startRestartGroup, 6);
                                } else {
                                    i9 = i3;
                                    chipColors3 = chipColors2;
                                }
                                if ((i2 & Fields.SpotShadowColor) != 0) {
                                    chipElevation2 = SuggestionChipDefaults.INSTANCE.m3036elevatedSuggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                    i9 &= -29360129;
                                } else {
                                    chipElevation2 = chipElevation;
                                }
                                ChipBorder chipBorder4 = i6 != 0 ? null : chipBorder;
                                if (i8 != 0) {
                                    startRestartGroup.startReplaceableGroup(-1455578225);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Chip.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    chipBorder2 = chipBorder4;
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                    shape2 = shape3;
                                    modifier2 = modifier4;
                                    function23 = function24;
                                    chipColors2 = chipColors3;
                                    i10 = i9;
                                    chipElevation3 = chipElevation2;
                                    z2 = z4;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    chipBorder2 = chipBorder4;
                                    chipElevation3 = chipElevation2;
                                    shape2 = shape3;
                                    modifier2 = modifier4;
                                    z2 = z4;
                                    function23 = function24;
                                    chipColors2 = chipColors3;
                                    i10 = i9;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                if ((i2 & Fields.SpotShadowColor) != 0) {
                                    i3 &= -29360129;
                                }
                                modifier2 = modifier;
                                chipElevation3 = chipElevation;
                                chipBorder2 = chipBorder;
                                mutableInteractionSource3 = mutableInteractionSource;
                                i10 = i3;
                                z2 = z;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1668751803, i10, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:914)");
                            }
                            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont());
                            long m2315labelColorvNxB06k$material3_release = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
                            float m3037getHeightD9Ej5fM = SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM();
                            PaddingValues paddingValues = SuggestionChipPadding;
                            startRestartGroup.startReplaceableGroup(-1455577719);
                            ComposerKt.sourceInformation(startRestartGroup, "928@46662L21");
                            State<BorderStroke> borderStroke$material3_release = chipBorder2 == null ? null : chipBorder2.borderStroke$material3_release(z2, startRestartGroup, ((i10 >> 9) & 14) | ((i10 >> 21) & 112));
                            startRestartGroup.endReplaceableGroup();
                            BorderStroke value = borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null;
                            int i15 = i10 << 6;
                            int i16 = ((i10 >> 6) & 14) | 12582912 | ((i10 << 3) & 112) | ((i10 >> 3) & 896) | (i15 & 7168) | (i15 & 3670016);
                            int i17 = i10 << 9;
                            int i18 = ((i10 >> 21) & 14) | 3456 | ((i10 >> 15) & 57344);
                            composer2 = startRestartGroup;
                            m2325ChipnkUnTEs(modifier2, function0, z2, function2, fromToken, m2315labelColorvNxB06k$material3_release, function23, null, shape2, chipColors2, chipElevation3, value, m3037getHeightD9Ej5fM, paddingValues, mutableInteractionSource3, composer2, i16 | (234881024 & i17) | (i17 & 1879048192), i18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            chipBorder3 = chipBorder2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape2;
                            modifier3 = modifier2;
                            z3 = z2;
                            chipElevation4 = chipElevation3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            z3 = z;
                            shape4 = shape2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            composer2 = startRestartGroup;
                            chipElevation4 = chipElevation;
                            chipBorder3 = chipBorder;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Function2 function25 = function23;
                            final ChipColors chipColors4 = chipColors2;
                            final ChipBorder chipBorder5 = chipBorder3;
                            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ElevatedSuggestionChip$4
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

                                public final void invoke(Composer composer3, int i19) {
                                    ChipKt.ElevatedSuggestionChip(function0, function2, modifier3, z3, function25, shape4, chipColors4, chipElevation4, chipBorder5, mutableInteractionSource5, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = i7;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & Fields.SpotShadowColor) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont());
                    long m2315labelColorvNxB06k$material3_release2 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
                    float m3037getHeightD9Ej5fM2 = SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM();
                    PaddingValues paddingValues2 = SuggestionChipPadding;
                    startRestartGroup.startReplaceableGroup(-1455577719);
                    ComposerKt.sourceInformation(startRestartGroup, "928@46662L21");
                    if (chipBorder2 == null) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    if (borderStroke$material3_release != null) {
                    }
                    int i152 = i10 << 6;
                    int i162 = ((i10 >> 6) & 14) | 12582912 | ((i10 << 3) & 112) | ((i10 >> 3) & 896) | (i152 & 7168) | (i152 & 3670016);
                    int i172 = i10 << 9;
                    int i182 = ((i10 >> 21) & 14) | 3456 | ((i10 >> 15) & 57344);
                    composer2 = startRestartGroup;
                    m2325ChipnkUnTEs(modifier2, function0, z2, function2, fromToken2, m2315labelColorvNxB06k$material3_release2, function23, null, shape2, chipColors2, chipElevation3, value, m3037getHeightD9Ej5fM2, paddingValues2, mutableInteractionSource3, composer2, i162 | (234881024 & i172) | (i172 & 1879048192), i182);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    chipBorder3 = chipBorder2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape2;
                    modifier3 = modifier2;
                    z3 = z2;
                    chipElevation4 = chipElevation3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function23 = function22;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i6 = i2 & Fields.RotationX;
                if (i6 == 0) {
                }
                i7 = i2 & Fields.RotationY;
                if (i7 == 0) {
                }
                i8 = i7;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i14 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & Fields.SpotShadowColor) != 0) {
                }
                if (i6 != 0) {
                }
                if (i8 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                TextStyle fromToken22 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont());
                long m2315labelColorvNxB06k$material3_release22 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
                float m3037getHeightD9Ej5fM22 = SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM();
                PaddingValues paddingValues22 = SuggestionChipPadding;
                startRestartGroup.startReplaceableGroup(-1455577719);
                ComposerKt.sourceInformation(startRestartGroup, "928@46662L21");
                if (chipBorder2 == null) {
                }
                startRestartGroup.endReplaceableGroup();
                if (borderStroke$material3_release != null) {
                }
                int i1522 = i10 << 6;
                int i1622 = ((i10 >> 6) & 14) | 12582912 | ((i10 << 3) & 112) | ((i10 >> 3) & 896) | (i1522 & 7168) | (i1522 & 3670016);
                int i1722 = i10 << 9;
                int i1822 = ((i10 >> 21) & 14) | 3456 | ((i10 >> 15) & 57344);
                composer2 = startRestartGroup;
                m2325ChipnkUnTEs(modifier2, function0, z2, function2, fromToken22, m2315labelColorvNxB06k$material3_release22, function23, null, shape2, chipColors2, chipElevation3, value, m3037getHeightD9Ej5fM22, paddingValues22, mutableInteractionSource3, composer2, i1622 | (234881024 & i1722) | (i1722 & 1879048192), i1822);
                if (ComposerKt.isTraceInProgress()) {
                }
                chipBorder3 = chipBorder2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape2;
                modifier3 = modifier2;
                z3 = z2;
                chipElevation4 = chipElevation3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function23 = function22;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i6 = i2 & Fields.RotationX;
            if (i6 == 0) {
            }
            i7 = i2 & Fields.RotationY;
            if (i7 == 0) {
            }
            i8 = i7;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i14 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & Fields.SpotShadowColor) != 0) {
            }
            if (i6 != 0) {
            }
            if (i8 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            TextStyle fromToken222 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont());
            long m2315labelColorvNxB06k$material3_release222 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
            float m3037getHeightD9Ej5fM222 = SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM();
            PaddingValues paddingValues222 = SuggestionChipPadding;
            startRestartGroup.startReplaceableGroup(-1455577719);
            ComposerKt.sourceInformation(startRestartGroup, "928@46662L21");
            if (chipBorder2 == null) {
            }
            startRestartGroup.endReplaceableGroup();
            if (borderStroke$material3_release != null) {
            }
            int i15222 = i10 << 6;
            int i16222 = ((i10 >> 6) & 14) | 12582912 | ((i10 << 3) & 112) | ((i10 >> 3) & 896) | (i15222 & 7168) | (i15222 & 3670016);
            int i17222 = i10 << 9;
            int i18222 = ((i10 >> 21) & 14) | 3456 | ((i10 >> 15) & 57344);
            composer2 = startRestartGroup;
            m2325ChipnkUnTEs(modifier2, function0, z2, function2, fromToken222, m2315labelColorvNxB06k$material3_release222, function23, null, shape2, chipColors2, chipElevation3, value, m3037getHeightD9Ej5fM222, paddingValues222, mutableInteractionSource3, composer2, i16222 | (234881024 & i17222) | (i17222 & 1879048192), i18222);
            if (ComposerKt.isTraceInProgress()) {
            }
            chipBorder3 = chipBorder2;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape4 = shape2;
            modifier3 = modifier2;
            z3 = z2;
            chipElevation4 = chipElevation3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function23 = function22;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i6 = i2 & Fields.RotationX;
        if (i6 == 0) {
        }
        i7 = i2 & Fields.RotationY;
        if (i7 == 0) {
        }
        i8 = i7;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i14 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & Fields.SpotShadowColor) != 0) {
        }
        if (i6 != 0) {
        }
        if (i8 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        TextStyle fromToken2222 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), SuggestionChipTokens.INSTANCE.getLabelTextFont());
        long m2315labelColorvNxB06k$material3_release2222 = chipColors2.m2315labelColorvNxB06k$material3_release(z2);
        float m3037getHeightD9Ej5fM2222 = SuggestionChipDefaults.INSTANCE.m3037getHeightD9Ej5fM();
        PaddingValues paddingValues2222 = SuggestionChipPadding;
        startRestartGroup.startReplaceableGroup(-1455577719);
        ComposerKt.sourceInformation(startRestartGroup, "928@46662L21");
        if (chipBorder2 == null) {
        }
        startRestartGroup.endReplaceableGroup();
        if (borderStroke$material3_release != null) {
        }
        int i152222 = i10 << 6;
        int i162222 = ((i10 >> 6) & 14) | 12582912 | ((i10 << 3) & 112) | ((i10 >> 3) & 896) | (i152222 & 7168) | (i152222 & 3670016);
        int i172222 = i10 << 9;
        int i182222 = ((i10 >> 21) & 14) | 3456 | ((i10 >> 15) & 57344);
        composer2 = startRestartGroup;
        m2325ChipnkUnTEs(modifier2, function0, z2, function2, fromToken2222, m2315labelColorvNxB06k$material3_release2222, function23, null, shape2, chipColors2, chipElevation3, value, m3037getHeightD9Ej5fM2222, paddingValues2222, mutableInteractionSource3, composer2, i162222 | (234881024 & i172222) | (i172222 & 1879048192), i182222);
        if (ComposerKt.isTraceInProgress()) {
        }
        chipBorder3 = chipBorder2;
        mutableInteractionSource4 = mutableInteractionSource3;
        shape4 = shape2;
        modifier3 = modifier2;
        z3 = z2;
        chipElevation4 = chipElevation3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Chip-nkUnTEs, reason: not valid java name */
    public static final void m2325ChipnkUnTEs(final Modifier modifier, final Function0<Unit> function0, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Shape shape, final ChipColors chipColors, final ChipElevation chipElevation, final BorderStroke borderStroke, final float f, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        float f2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1400504719);
        ComposerKt.sourceInformation(startRestartGroup, "C(Chip)P(10,11,3,5,7,6:c#ui.graphics.Color,8,14,13,1,2!1,9:c#ui.unit.Dp,12)1862@93125L917:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i5 = i & 384;
        int i6 = Fields.RotationX;
        if (i5 == 0) {
            i3 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        int i7 = i & 3072;
        int i8 = Fields.CameraDistance;
        if (i7 == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        int i9 = i & 24576;
        int i10 = Fields.Clip;
        if (i9 == 0) {
            i3 |= startRestartGroup.changed(textStyle) ? 16384 : 8192;
        }
        int i11 = i3;
        if ((i & 196608) == 0) {
            i11 |= startRestartGroup.changed(j) ? Fields.RenderEffect : 65536;
        }
        if ((i & 1572864) == 0) {
            i11 |= startRestartGroup.changedInstance(function22) ? 1048576 : Fields.BlendMode;
        }
        if ((i & 12582912) == 0) {
            i11 |= startRestartGroup.changedInstance(function23) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i11 |= startRestartGroup.changed(shape) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i11 |= startRestartGroup.changed(chipColors) ? 536870912 : 268435456;
        }
        int i12 = i11;
        if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(chipElevation) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(borderStroke) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            if (!startRestartGroup.changed(f)) {
                i6 = 128;
            }
            i4 |= i6;
        }
        if ((i2 & 3072) == 0) {
            if (!startRestartGroup.changed(paddingValues)) {
                i8 = 1024;
            }
            i4 |= i8;
        }
        if ((i2 & 24576) == 0) {
            if (!startRestartGroup.changed(mutableInteractionSource)) {
                i10 = 8192;
            }
            i4 |= i10;
        }
        if ((306783379 & i12) != 306783378 || (i4 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1400504719, i12, i4, "androidx.compose.material3.Chip (Chip.kt:1861)");
            }
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getButton-o7Vup1c());
                }
            }, 1, (Object) null);
            long m2305containerColorvNxB06k$material3_release = chipColors.m2305containerColorvNxB06k$material3_release(z);
            if (chipElevation != null) {
                f2 = chipElevation.m2324tonalElevationu2uoSUM$material3_release(z);
            } else {
                f2 = Dp.constructor-impl(0);
            }
            float f3 = f2;
            startRestartGroup.startReplaceableGroup(64045604);
            ComposerKt.sourceInformation(startRestartGroup, "1869@93427L43");
            State<Dp> shadowElevation$material3_release = chipElevation != null ? chipElevation.shadowElevation$material3_release(z, mutableInteractionSource, startRestartGroup, ((i12 >> 6) & 14) | ((i4 >> 9) & 112) | ((i4 << 6) & 896)) : null;
            startRestartGroup.endReplaceableGroup();
            int i13 = i4;
            composer2 = startRestartGroup;
            SurfaceKt.m3046Surfaceo_FOJdg(function0, semantics$default, z, shape, m2305containerColorvNxB06k$material3_release, 0L, f3, shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().unbox-impl() : Dp.constructor-impl(0), borderStroke, mutableInteractionSource, ComposableLambdaKt.composableLambda(composer2, -1985962652, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$2
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

                public final void invoke(Composer composer3, int i14) {
                    ComposerKt.sourceInformation(composer3, "C1873@93575L461:Chip.kt#uh7d8r");
                    if ((i14 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1985962652, i14, -1, "androidx.compose.material3.Chip.<anonymous> (Chip.kt:1873)");
                        }
                        ChipKt.m2326ChipContentfe0OD_I(function2, textStyle, j, function22, null, function23, chipColors.m2316leadingIconContentColorvNxB06k$material3_release(z), chipColors.m2317trailingIconContentColorvNxB06k$material3_release(z), f, paddingValues, composer3, 24576);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, ((i12 >> 15) & 7168) | ((i12 >> 3) & 14) | (i12 & 896) | ((i13 << 21) & 234881024) | (1879048192 & (i13 << 15)), 6, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$3
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

                public final void invoke(Composer composer3, int i14) {
                    ChipKt.m2325ChipnkUnTEs(Modifier.this, function0, z, function2, textStyle, j, function22, function23, shape, chipColors, chipElevation, borderStroke, f, paddingValues, mutableInteractionSource, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: SelectableChip-u0RnIRE, reason: not valid java name */
    public static final void m2327SelectableChipu0RnIRE(final boolean z, final Modifier modifier, final Function0<Unit> function0, final boolean z2, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Shape shape, final SelectableChipColors selectableChipColors, final SelectableChipElevation selectableChipElevation, final BorderStroke borderStroke, final float f, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        float f2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(402951308);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectableChip)P(13,10,11,4,6,7,8!1,15,14,2,3!1,9:c#ui.unit.Dp,12)1914@94883L33,1908@94681L1012:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i & 384;
        int i6 = Fields.RotationX;
        if (i5 == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i7 = i & 3072;
        int i8 = Fields.CameraDistance;
        if (i7 == 0) {
            i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
        }
        int i9 = i & 24576;
        int i10 = Fields.Clip;
        if (i9 == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= startRestartGroup.changed(textStyle) ? Fields.RenderEffect : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 1048576 : Fields.BlendMode;
        }
        if ((i & 12582912) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= startRestartGroup.changed(shape) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(selectableChipColors) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(selectableChipElevation) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            if (!startRestartGroup.changed(borderStroke)) {
                i6 = 128;
            }
            i4 |= i6;
        }
        if ((i2 & 3072) == 0) {
            if (!startRestartGroup.changed(f)) {
                i8 = 1024;
            }
            i4 |= i8;
        }
        if ((i2 & 24576) == 0) {
            if (!startRestartGroup.changed(paddingValues)) {
                i10 = 8192;
            }
            i4 |= i10;
        }
        if ((i2 & 196608) == 0) {
            i4 |= startRestartGroup.changed(mutableInteractionSource) ? Fields.RenderEffect : 65536;
        }
        if ((i3 & 306783379) != 306783378 || (74899 & i4) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(402951308, i3, i4, "androidx.compose.material3.SelectableChip (Chip.kt:1906)");
            }
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                }
            }, 1, (Object) null);
            int i11 = (i3 >> 9) & 14;
            long m4849unboximpl = selectableChipColors.containerColor$material3_release(z2, z, startRestartGroup, ((i3 << 3) & 112) | i11 | ((i4 << 6) & 896)).getValue().m4849unboximpl();
            if (selectableChipElevation != null) {
                f2 = selectableChipElevation.m2894tonalElevationu2uoSUM$material3_release(z2);
            } else {
                f2 = Dp.constructor-impl(0);
            }
            float f3 = f2;
            startRestartGroup.startReplaceableGroup(1036687729);
            ComposerKt.sourceInformation(startRestartGroup, "1916@95030L43");
            State<Dp> shadowElevation$material3_release = selectableChipElevation == null ? null : selectableChipElevation.shadowElevation$material3_release(z2, mutableInteractionSource, startRestartGroup, i11 | ((i4 >> 12) & 112) | ((i4 << 3) & 896));
            startRestartGroup.endReplaceableGroup();
            int i12 = i3;
            int i13 = i4;
            composer2 = startRestartGroup;
            SurfaceKt.m3044Surfaced85dljk(z, function0, semantics$default, z2, shape, m4849unboximpl, 0L, f3, shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().unbox-impl() : Dp.constructor-impl(0), borderStroke, mutableInteractionSource, ComposableLambdaKt.composableLambda(startRestartGroup, -577614814, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$2
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

                public final void invoke(Composer composer3, int i14) {
                    ComposerKt.sourceInformation(composer3, "C1920@95178L509:Chip.kt#uh7d8r");
                    if ((i14 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-577614814, i14, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:1920)");
                        }
                        ChipKt.m2326ChipContentfe0OD_I(function2, textStyle, SelectableChipColors.this.m2885labelColorWaAFU9c$material3_release(z2, z), function22, function23, function24, SelectableChipColors.this.m2886leadingIconContentColorWaAFU9c$material3_release(z2, z), SelectableChipColors.this.m2887trailingIconContentColorWaAFU9c$material3_release(z2, z), f, paddingValues, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, (i12 & 14) | ((i12 >> 3) & 112) | (i12 & 7168) | ((i12 >> 15) & 57344) | ((i13 << 21) & 1879048192), ((i13 >> 15) & 14) | 48, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$3
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

                public final void invoke(Composer composer3, int i14) {
                    ChipKt.m2327SelectableChipu0RnIRE(z, modifier, function0, z2, function2, textStyle, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, f, paddingValues, mutableInteractionSource, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ChipContent-fe0OD_I, reason: not valid java name */
    public static final void m2326ChipContentfe0OD_I(final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final long j2, final long j3, final float f, final PaddingValues paddingValues, Composer composer, final int i) {
        int i2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-782878228);
        ComposerKt.sourceInformation(startRestartGroup, "C(ChipContent)P(1,3,2:c#ui.graphics.Color,4!1,8,5:c#ui.graphics.Color,9:c#ui.graphics.Color,6:c#ui.unit.Dp)1948@96070L3672:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 1048576 : Fields.BlendMode;
        }
        if ((12582912 & i) == 0) {
            i3 = i2 | (startRestartGroup.changed(j3) ? 8388608 : 4194304);
        } else {
            i3 = i2;
        }
        if ((100663296 & i) == 0) {
            i3 |= startRestartGroup.changed(f) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= startRestartGroup.changed(paddingValues) ? 536870912 : 268435456;
        }
        if ((i3 & 306783379) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-782878228, i3, -1, "androidx.compose.material3.ChipContent (Chip.kt:1947)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, ComposableLambdaKt.composableLambda(startRestartGroup, 1748799148, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$1
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
                    long j4;
                    float f2;
                    ComposerKt.sourceInformation(composer2, "C1952@96206L3530:Chip.kt#uh7d8r");
                    if ((i4 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1748799148, i4, -1, "androidx.compose.material3.ChipContent.<anonymous> (Chip.kt:1952)");
                        }
                        Modifier padding = PaddingKt.padding(SizeKt.m1105defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, f, 1, null), paddingValues);
                        C05881 c05881 = new MeasurePolicy() { // from class: androidx.compose.material3.ChipKt$ChipContent$1.1
                            @Override // androidx.compose.p002ui.layout.MeasurePolicy
                            /* renamed from: measure-3p2s80s */
                            public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                                Measurable measurable;
                                Measurable measurable2;
                                int size = list.size();
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= size) {
                                        measurable = null;
                                        break;
                                    }
                                    measurable = list.get(i5);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "leadingIcon")) {
                                        break;
                                    }
                                    i5++;
                                }
                                Measurable measurable3 = measurable;
                                final Placeable mo6318measureBRTryo0 = measurable3 != null ? measurable3.mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j5, 0, 0, 0, 0, 10, (Object) null)) : null;
                                final int widthOrZero = TextFieldImplKt.widthOrZero(mo6318measureBRTryo0);
                                final int heightOrZero = TextFieldImplKt.heightOrZero(mo6318measureBRTryo0);
                                int size2 = list.size();
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= size2) {
                                        measurable2 = null;
                                        break;
                                    }
                                    measurable2 = list.get(i6);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "trailingIcon")) {
                                        break;
                                    }
                                    i6++;
                                }
                                Measurable measurable4 = measurable2;
                                final Placeable mo6318measureBRTryo02 = measurable4 != null ? measurable4.mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j5, 0, 0, 0, 0, 10, (Object) null)) : null;
                                int widthOrZero2 = TextFieldImplKt.widthOrZero(mo6318measureBRTryo02);
                                final int heightOrZero2 = TextFieldImplKt.heightOrZero(mo6318measureBRTryo02);
                                int size3 = list.size();
                                for (int i7 = 0; i7 < size3; i7++) {
                                    Measurable measurable5 = list.get(i7);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), "label")) {
                                        final Placeable mo6318measureBRTryo03 = measurable5.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U$default(j5, -(widthOrZero + widthOrZero2), 0, 2, (Object) null));
                                        int width = mo6318measureBRTryo03.getWidth() + widthOrZero + widthOrZero2;
                                        final int max = Math.max(heightOrZero, Math.max(mo6318measureBRTryo03.getHeight(), heightOrZero2));
                                        return MeasureScope.layout$default(measureScope, width, max, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ChipKt.ChipContent.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Placeable.PlacementScope) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Placeable.PlacementScope placementScope) {
                                                Placeable placeable = Placeable.this;
                                                if (placeable != null) {
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.INSTANCE.getCenterVertically().align(heightOrZero, max), 0.0f, 4, null);
                                                }
                                                Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo03, widthOrZero, 0, 0.0f, 4, null);
                                                Placeable placeable2 = mo6318measureBRTryo02;
                                                if (placeable2 != null) {
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, mo6318measureBRTryo03.getWidth() + widthOrZero, Alignment.INSTANCE.getCenterVertically().align(heightOrZero2, max), 0.0f, 4, null);
                                                }
                                            }
                                        }, 4, null);
                                    }
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        };
                        Function2<Composer, Integer, Unit> function25 = function23;
                        Function2<Composer, Integer, Unit> function26 = function22;
                        Function2<Composer, Integer, Unit> function27 = function24;
                        long j5 = j2;
                        Function2<Composer, Integer, Unit> function28 = function2;
                        long j6 = j3;
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m4109constructorimpl = Updater.m4109constructorimpl(composer2);
                        Updater.m4116setimpl(m4109constructorimpl, c05881, (Function2<? super T, ? super C05881, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, 651014582, "C1974@97149L351:Chip.kt#uh7d8r");
                        composer2.startReplaceableGroup(651014582);
                        ComposerKt.sourceInformation(composer2, "1958@96447L667");
                        if (function25 == null && function26 == null) {
                            j4 = j6;
                        } else {
                            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "leadingIcon");
                            Alignment center = Alignment.INSTANCE.getCenter();
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            j4 = j6;
                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(layoutId);
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
                            ComposerKt.sourceInformationMarkerStart(composer2, 1725997314, "C:Chip.kt#uh7d8r");
                            if (function25 != null) {
                                composer2.startReplaceableGroup(1725997334);
                                ComposerKt.sourceInformation(composer2, "1964@96735L8");
                                function25.invoke(composer2, 0);
                                composer2.endReplaceableGroup();
                            } else if (function26 != null) {
                                composer2.startReplaceableGroup(1725997437);
                                ComposerKt.sourceInformation(composer2, "1966@96838L198");
                                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j5)), function26, composer2, ProvidedValue.$stable | 0);
                                composer2.endReplaceableGroup();
                            } else {
                                composer2.startReplaceableGroup(1725997699);
                                composer2.endReplaceableGroup();
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                        }
                        composer2.endReplaceableGroup();
                        Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "label");
                        f2 = ChipKt.HorizontalElementsPadding;
                        Modifier m1065paddingVpY3zN4 = PaddingKt.m1065paddingVpY3zN4(layoutId2, f2, Dp.constructor-impl(0));
                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                        Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m1065paddingVpY3zN4);
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
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1725998106, "C1980@97473L7:Chip.kt#uh7d8r");
                        function28.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.startReplaceableGroup(-313041276);
                        ComposerKt.sourceInformation(composer2, "1983@97565L471");
                        if (function27 != null) {
                            Modifier layoutId3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "trailingIcon");
                            Alignment center2 = Alignment.INSTANCE.getCenter();
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composer2, 6);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(layoutId3);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor4);
                            } else {
                                composer2.useNode();
                            }
                            Composer m4109constructorimpl4 = Updater.m4109constructorimpl(composer2);
                            Updater.m4116setimpl(m4109constructorimpl4, rememberBoxMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl4, currentCompositionLocalMap4, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl4.getInserting() || !Intrinsics.areEqual(m4109constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                m4109constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                m4109constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                            }
                            modifierMaterializerOf4.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1725998433, "C1988@97800L188:Chip.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j4)), function27, composer2, ProvidedValue.$stable | 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                        }
                        composer2.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$2
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
                    ChipKt.m2326ChipContentfe0OD_I(function2, textStyle, j, function22, function23, function24, j2, j3, f, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final ChipColors getDefaultSuggestionChipColors(ColorScheme colorScheme) {
        ChipColors defaultSuggestionChipColorsCached = colorScheme.getDefaultSuggestionChipColorsCached();
        if (defaultSuggestionChipColorsCached != null) {
            return defaultSuggestionChipColorsCached;
        }
        ChipColors chipColors = new ChipColors(Color.INSTANCE.m4874getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLeadingIconColor()), Color.INSTANCE.m4875getUnspecified0d7_KjU(), Color.INSTANCE.m4874getTransparent0d7_KjU(), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m4875getUnspecified0d7_KjU(), null);
        colorScheme.setDefaultSuggestionChipColorsCached$material3_release(chipColors);
        return chipColors;
    }

    static /* synthetic */ PaddingValues inputChipPadding$default(boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return inputChipPadding(z, z2, z3);
    }

    private static final PaddingValues inputChipPadding(boolean z, boolean z2, boolean z3) {
        return PaddingKt.m1061PaddingValuesa9UjIt4$default(Dp.constructor-impl((z || !z2) ? 4 : 8), 0.0f, Dp.constructor-impl(z3 ? 8 : 4), 0.0f, 10, null);
    }

    static {
        float f = Dp.constructor-impl(8);
        HorizontalElementsPadding = f;
        AssistChipPadding = PaddingKt.m1059PaddingValuesYgX7TsA$default(f, 0.0f, 2, null);
        FilterChipPadding = PaddingKt.m1059PaddingValuesYgX7TsA$default(f, 0.0f, 2, null);
        SuggestionChipPadding = PaddingKt.m1059PaddingValuesYgX7TsA$default(f, 0.0f, 2, null);
    }
}
