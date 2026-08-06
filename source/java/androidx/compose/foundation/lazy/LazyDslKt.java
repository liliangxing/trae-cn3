package androidx.compose.foundation.lazy;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

/* compiled from: LazyDsl.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a©\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042%\b\n\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062%\b\n\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000623\b\u0004\u0010\f\u001a-\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0086\b¢\u0006\u0002\u0010\u0011\u001a\u0082\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042%\b\n\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u000623\b\u0004\u0010\f\u001a-\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0002\u0010\u0012\u001aè\u0001\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042:\b\n\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\r2:\b\u0006\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\r2H\b\u0004\u0010\f\u001aB\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0086\b¢\u0006\u0002\u0010\u0017\u001a¬\u0001\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042:\b\n\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\r2H\b\u0004\u0010\f\u001aB\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0002\u0010\u0018\u001a©\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00192%\b\n\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062%\b\n\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000623\b\u0004\u0010\f\u001a-\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0086\b¢\u0006\u0002\u0010\u001a\u001a\u0082\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00192%\b\n\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u000623\b\u0004\u0010\f\u001a-\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0002\u0010\u001b\u001aè\u0001\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00192:\b\n\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\r2:\b\u0006\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\r2H\b\u0004\u0010\f\u001aB\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0086\b¢\u0006\u0002\u0010\u001c\u001a¬\u0001\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00192:\b\n\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\r2H\b\u0004\u0010\f\u001aB\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0002\u0010\u001d\u001a\u0082\u0001\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020&2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u00101\u001a\u0082\u0001\u00102\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020&2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u00107\u001av\u00102\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020&2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u00108\u001al\u00102\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u0010+\u001a\u00020,2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u00109\u001av\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020&2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010:\u001al\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010;¨\u0006<"}, d2 = {"items", "", "T", "Landroidx/compose/foundation/lazy/LazyListScope;", "", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "item", "", "contentType", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "LazyRow", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyColumn", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyDslKt {
    public static final Unit LazyColumn$lambda$1(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, Function1 function1, int i, int i2, Composer composer, int i3) {
        LazyColumn(modifier, lazyListState, paddingValues, z, vertical, horizontal, flingBehavior, z2, overscrollEffect, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit LazyColumn$lambda$2(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, Function1 function1, int i, int i2, Composer composer, int i3) {
        LazyColumn(modifier, lazyListState, paddingValues, z, vertical, horizontal, flingBehavior, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit LazyColumn$lambda$3(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, Function1 function1, int i, int i2, Composer composer, int i3) {
        LazyColumn(modifier, lazyListState, paddingValues, z, vertical, horizontal, flingBehavior, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit LazyRow$lambda$0(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, Function1 function1, int i, int i2, Composer composer, int i3) {
        LazyRow(modifier, lazyListState, paddingValues, z, horizontal, vertical, flingBehavior, z2, overscrollEffect, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit LazyRow$lambda$4(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, boolean z2, Function1 function1, int i, int i2, Composer composer, int i3) {
        LazyRow(modifier, lazyListState, paddingValues, z, horizontal, vertical, flingBehavior, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit LazyRow$lambda$5(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, Function1 function1, int i, int i2, Composer composer, int i3) {
        LazyRow(modifier, lazyListState, paddingValues, z, horizontal, vertical, flingBehavior, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List list, Function1 function1, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = LazyDslKt$items$1.INSTANCE;
        }
        lazyListScope.items(list.size(), function1 != null ? new LazyDslKt$items$2(function1, list) : null, new LazyDslKt$items$3(function12, list), ComposableLambdaKt.composableLambdaInstance(802480018, true, new LazyDslKt$items$4(function4, list)));
    }

    public static final <T> void items(LazyListScope lazyListScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyListScope.items(list.size(), function1 != null ? new LazyDslKt$items$2(function1, list) : null, new LazyDslKt$items$3(function12, list), ComposableLambdaKt.composableLambdaInstance(802480018, true, new LazyDslKt$items$4(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List list, Function2 function2, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$1
                public final Void invoke(int i2, T t) {
                    return null;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        lazyListScope.items(list.size(), function2 != null ? new LazyDslKt$itemsIndexed$2(function2, list) : null, new LazyDslKt$itemsIndexed$3(function22, list), ComposableLambdaKt.composableLambdaInstance(2039820996, true, new LazyDslKt$itemsIndexed$4(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyListScope lazyListScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyListScope.items(list.size(), function2 != null ? new LazyDslKt$itemsIndexed$2(function2, list) : null, new LazyDslKt$itemsIndexed$3(function22, list), ComposableLambdaKt.composableLambdaInstance(2039820996, true, new LazyDslKt$itemsIndexed$4(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] objArr, Function1 function1, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = LazyDslKt$items$5.INSTANCE;
        }
        lazyListScope.items(objArr.length, function1 != null ? new LazyDslKt$items$6(function1, objArr) : null, new LazyDslKt$items$7(function12, objArr), ComposableLambdaKt.composableLambdaInstance(-1781742563, true, new LazyDslKt$items$8(function4, objArr)));
    }

    public static final <T> void items(LazyListScope lazyListScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyListScope.items(tArr.length, function1 != null ? new LazyDslKt$items$6(function1, tArr) : null, new LazyDslKt$items$7(function12, tArr), ComposableLambdaKt.composableLambdaInstance(-1781742563, true, new LazyDslKt$items$8(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] objArr, Function2 function2, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$5
                public final Void invoke(int i2, T t) {
                    return null;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        lazyListScope.items(objArr.length, function2 != null ? new LazyDslKt$itemsIndexed$6(function2, objArr) : null, new LazyDslKt$itemsIndexed$7(function22, objArr), ComposableLambdaKt.composableLambdaInstance(1763000017, true, new LazyDslKt$itemsIndexed$8(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyListScope lazyListScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyListScope.items(tArr.length, function2 != null ? new LazyDslKt$itemsIndexed$6(function2, tArr) : null, new LazyDslKt$itemsIndexed$7(function22, tArr), ComposableLambdaKt.composableLambdaInstance(1763000017, true, new LazyDslKt$itemsIndexed$8(function5, tArr)));
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyRow(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, final Function1<? super LazyListScope, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z3;
        Arrangement.Horizontal horizontal2;
        int i5;
        Alignment.Vertical vertical2;
        FlingBehavior flingBehavior2;
        int i6;
        Modifier.Companion companion;
        LazyListState lazyListState2;
        PaddingValues paddingValues2;
        final boolean z4;
        final boolean z5;
        final Arrangement.Horizontal horizontal3;
        Alignment.Vertical vertical3;
        final FlingBehavior flingBehavior3;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope endRestartGroup;
        Arrangement.Horizontal horizontal4;
        FlingBehavior flingBehavior4;
        OverscrollEffect overscrollEffect3;
        int i7;
        FlingBehavior flingBehavior5;
        boolean z6;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-1884325601);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyRow)N(modifier,state,contentPadding,reverseLayout,horizontalArrangement,verticalAlignment,flingBehavior,userScrollEnabled,overscrollEffect,content)340@17489L435:LazyDsl.kt#428nma");
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0 && startRestartGroup.changed(lazyListState)) {
                i11 = 32;
                i3 |= i11;
            }
            i11 = 16;
            i3 |= i11;
        }
        int i13 = i2 & 4;
        if (i13 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(paddingValues) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z3 = z;
                i3 |= startRestartGroup.changed(z3) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        horizontal2 = horizontal;
                        if (startRestartGroup.changed(horizontal2)) {
                            i10 = Fields.Clip;
                            i3 |= i10;
                        }
                    } else {
                        horizontal2 = horizontal;
                    }
                    i10 = Fields.Shape;
                    i3 |= i10;
                } else {
                    horizontal2 = horizontal;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    vertical2 = vertical;
                    i3 |= startRestartGroup.changed(vertical2) ? Fields.RenderEffect : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            flingBehavior2 = flingBehavior;
                            if (startRestartGroup.changed(flingBehavior2)) {
                                i9 = 1048576;
                                i3 |= i9;
                            }
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        i9 = Fields.BlendMode;
                        i3 |= i9;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    i6 = i2 & Fields.SpotShadowColor;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i2 & Fields.RotationX) == 0 && startRestartGroup.changed(overscrollEffect)) {
                            i8 = 67108864;
                            i3 |= i8;
                        }
                        i8 = 33554432;
                        i3 |= i8;
                    }
                    if ((i2 & Fields.RotationY) == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i3 |= startRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "329@16965L23,335@17316L15,337@17414L26");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 2) != 0) {
                                    i3 &= -113;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                if ((i2 & Fields.RotationX) != 0) {
                                    i3 &= -234881025;
                                }
                                companion = modifier;
                                lazyListState2 = lazyListState;
                                paddingValues2 = paddingValues;
                                overscrollEffect3 = overscrollEffect;
                                i7 = i3;
                                horizontal4 = horizontal2;
                                vertical3 = vertical2;
                                flingBehavior5 = flingBehavior2;
                                z6 = z2;
                            } else {
                                companion = i12 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i2 & 2) != 0) {
                                    lazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                    i3 &= -113;
                                } else {
                                    lazyListState2 = lazyListState;
                                }
                                paddingValues2 = i13 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues;
                                if (i4 != 0) {
                                    z3 = false;
                                }
                                if ((i2 & 16) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    horizontal4 = !z3 ? arrangement.getStart() : arrangement.getEnd();
                                    i3 &= -57345;
                                } else {
                                    horizontal4 = horizontal2;
                                }
                                vertical3 = i5 != 0 ? Alignment.INSTANCE.getTop() : vertical2;
                                if ((i2 & 64) != 0) {
                                    flingBehavior4 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i3 &= -3670017;
                                } else {
                                    flingBehavior4 = flingBehavior2;
                                }
                                boolean z7 = i6 == 0 ? z2 : true;
                                if ((i2 & Fields.RotationX) != 0) {
                                    i3 &= -234881025;
                                    overscrollEffect3 = OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0);
                                } else {
                                    overscrollEffect3 = overscrollEffect;
                                }
                                i7 = i3;
                                flingBehavior5 = flingBehavior4;
                                z6 = z7;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1884325601, i7, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:339)");
                            }
                            int i14 = i7 >> 3;
                            LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z3, false, flingBehavior5, z6, overscrollEffect3, 0, null, null, vertical3, horizontal4, function1, startRestartGroup, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (458752 & i14) | (3670016 & i14) | (i14 & 29360128), ((i7 >> 12) & 112) | ((i7 >> 6) & 896) | ((i7 >> 18) & 7168), 1792);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            flingBehavior3 = flingBehavior5;
                            Arrangement.Horizontal horizontal5 = horizontal4;
                            z4 = z6;
                            z5 = z3;
                            overscrollEffect2 = overscrollEffect3;
                            horizontal3 = horizontal5;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            companion = modifier;
                            lazyListState2 = lazyListState;
                            paddingValues2 = paddingValues;
                            z4 = z2;
                            z5 = z3;
                            horizontal3 = horizontal2;
                            vertical3 = vertical2;
                            flingBehavior3 = flingBehavior2;
                            overscrollEffect2 = overscrollEffect;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier2 = companion;
                            final LazyListState lazyListState3 = lazyListState2;
                            final PaddingValues paddingValues3 = paddingValues2;
                            final Alignment.Vertical vertical4 = vertical3;
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit LazyRow$lambda$0;
                                    LazyRow$lambda$0 = LazyDslKt.LazyRow$lambda$0(Modifier.this, lazyListState3, paddingValues3, z5, horizontal3, vertical4, flingBehavior3, z4, overscrollEffect2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    return LazyRow$lambda$0;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                vertical2 = vertical;
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & Fields.SpotShadowColor;
                if (i6 == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i2 & Fields.RotationY) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z3 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            vertical2 = vertical;
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & Fields.SpotShadowColor;
            if (i6 == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i2 & Fields.RotationY) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        vertical2 = vertical;
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & Fields.SpotShadowColor;
        if (i6 == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i2 & Fields.RotationY) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyColumn(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, final Function1<? super LazyListScope, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z3;
        Arrangement.Vertical vertical2;
        int i5;
        Alignment.Horizontal horizontal2;
        FlingBehavior flingBehavior2;
        int i6;
        Modifier.Companion companion;
        LazyListState lazyListState2;
        PaddingValues paddingValues2;
        final boolean z4;
        final boolean z5;
        final Arrangement.Vertical vertical3;
        Alignment.Horizontal horizontal3;
        final FlingBehavior flingBehavior3;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope endRestartGroup;
        Arrangement.Vertical vertical4;
        FlingBehavior flingBehavior4;
        OverscrollEffect overscrollEffect3;
        int i7;
        FlingBehavior flingBehavior5;
        boolean z6;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(53695811);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyColumn)N(modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalAlignment,flingBehavior,userScrollEnabled,overscrollEffect,content)400@20806L434:LazyDsl.kt#428nma");
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0 && startRestartGroup.changed(lazyListState)) {
                i11 = 32;
                i3 |= i11;
            }
            i11 = 16;
            i3 |= i11;
        }
        int i13 = i2 & 4;
        if (i13 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(paddingValues) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z3 = z;
                i3 |= startRestartGroup.changed(z3) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        vertical2 = vertical;
                        if (startRestartGroup.changed(vertical2)) {
                            i10 = Fields.Clip;
                            i3 |= i10;
                        }
                    } else {
                        vertical2 = vertical;
                    }
                    i10 = Fields.Shape;
                    i3 |= i10;
                } else {
                    vertical2 = vertical;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    horizontal2 = horizontal;
                    i3 |= startRestartGroup.changed(horizontal2) ? Fields.RenderEffect : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            flingBehavior2 = flingBehavior;
                            if (startRestartGroup.changed(flingBehavior2)) {
                                i9 = 1048576;
                                i3 |= i9;
                            }
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        i9 = Fields.BlendMode;
                        i3 |= i9;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    i6 = i2 & Fields.SpotShadowColor;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i2 & Fields.RotationX) == 0 && startRestartGroup.changed(overscrollEffect)) {
                            i8 = 67108864;
                            i3 |= i8;
                        }
                        i8 = 33554432;
                        i3 |= i8;
                    }
                    if ((i2 & Fields.RotationY) == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i3 |= startRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "389@20279L23,395@20633L15,397@20731L26");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 2) != 0) {
                                    i3 &= -113;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                if ((i2 & Fields.RotationX) != 0) {
                                    i3 &= -234881025;
                                }
                                companion = modifier;
                                lazyListState2 = lazyListState;
                                paddingValues2 = paddingValues;
                                overscrollEffect3 = overscrollEffect;
                                i7 = i3;
                                vertical4 = vertical2;
                                horizontal3 = horizontal2;
                                flingBehavior5 = flingBehavior2;
                                z6 = z2;
                            } else {
                                companion = i12 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i2 & 2) != 0) {
                                    lazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                    i3 &= -113;
                                } else {
                                    lazyListState2 = lazyListState;
                                }
                                paddingValues2 = i13 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues;
                                if (i4 != 0) {
                                    z3 = false;
                                }
                                if ((i2 & 16) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    vertical4 = !z3 ? arrangement.getTop() : arrangement.getBottom();
                                    i3 &= -57345;
                                } else {
                                    vertical4 = vertical2;
                                }
                                horizontal3 = i5 != 0 ? Alignment.INSTANCE.getStart() : horizontal2;
                                if ((i2 & 64) != 0) {
                                    flingBehavior4 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i3 &= -3670017;
                                } else {
                                    flingBehavior4 = flingBehavior2;
                                }
                                boolean z7 = i6 == 0 ? z2 : true;
                                if ((i2 & Fields.RotationX) != 0) {
                                    i3 &= -234881025;
                                    overscrollEffect3 = OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0);
                                } else {
                                    overscrollEffect3 = overscrollEffect;
                                }
                                i7 = i3;
                                flingBehavior5 = flingBehavior4;
                                z6 = z7;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(53695811, i7, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:399)");
                            }
                            int i14 = i7 >> 3;
                            LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z3, true, flingBehavior5, z6, overscrollEffect3, 0, horizontal3, vertical4, null, null, function1, startRestartGroup, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (458752 & i14) | (3670016 & i14) | (i14 & 29360128) | ((i7 << 12) & 1879048192), ((i7 >> 12) & 14) | ((i7 >> 18) & 7168), 6400);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            flingBehavior3 = flingBehavior5;
                            Arrangement.Vertical vertical5 = vertical4;
                            z4 = z6;
                            z5 = z3;
                            overscrollEffect2 = overscrollEffect3;
                            vertical3 = vertical5;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            companion = modifier;
                            lazyListState2 = lazyListState;
                            paddingValues2 = paddingValues;
                            z4 = z2;
                            z5 = z3;
                            vertical3 = vertical2;
                            horizontal3 = horizontal2;
                            flingBehavior3 = flingBehavior2;
                            overscrollEffect2 = overscrollEffect;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier2 = companion;
                            final LazyListState lazyListState3 = lazyListState2;
                            final PaddingValues paddingValues3 = paddingValues2;
                            final Alignment.Horizontal horizontal4 = horizontal3;
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit LazyColumn$lambda$1;
                                    LazyColumn$lambda$1 = LazyDslKt.LazyColumn$lambda$1(Modifier.this, lazyListState3, paddingValues3, z5, vertical3, horizontal4, flingBehavior3, z4, overscrollEffect2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    return LazyColumn$lambda$1;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                horizontal2 = horizontal;
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & Fields.SpotShadowColor;
                if (i6 == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i2 & Fields.RotationY) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z3 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            horizontal2 = horizontal;
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & Fields.SpotShadowColor;
            if (i6 == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i2 & Fields.RotationY) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        horizontal2 = horizontal;
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & Fields.SpotShadowColor;
        if (i6 == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i2 & Fields.RotationY) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyColumn(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z3;
        Arrangement.Vertical vertical2;
        int i5;
        Alignment.Horizontal horizontal2;
        FlingBehavior flingBehavior2;
        int i6;
        Modifier.Companion companion;
        LazyListState lazyListState2;
        PaddingValues paddingValues2;
        final boolean z4;
        final Arrangement.Vertical vertical3;
        final Alignment.Horizontal horizontal3;
        final FlingBehavior flingBehavior3;
        ScopeUpdateScope endRestartGroup;
        int i7;
        LazyListState lazyListState3;
        PaddingValues m1057PaddingValues0680j_4;
        Arrangement.Vertical vertical4;
        Alignment.Horizontal start;
        FlingBehavior flingBehavior4;
        boolean z5;
        LazyListState lazyListState4;
        int i8;
        FlingBehavior flingBehavior5;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-740714857);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyColumn)N(modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalAlignment,flingBehavior,userScrollEnabled,content)438@22230L26,429@21871L419:LazyDsl.kt#428nma");
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0 && startRestartGroup.changed(lazyListState)) {
                i11 = 32;
                i3 |= i11;
            }
            i11 = 16;
            i3 |= i11;
        }
        int i13 = i2 & 4;
        if (i13 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(paddingValues) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z3 = z;
                i3 |= startRestartGroup.changed(z3) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        vertical2 = vertical;
                        if (startRestartGroup.changed(vertical2)) {
                            i10 = Fields.Clip;
                            i3 |= i10;
                        }
                    } else {
                        vertical2 = vertical;
                    }
                    i10 = Fields.Shape;
                    i3 |= i10;
                } else {
                    vertical2 = vertical;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    horizontal2 = horizontal;
                    i3 |= startRestartGroup.changed(horizontal2) ? Fields.RenderEffect : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            flingBehavior2 = flingBehavior;
                            if (startRestartGroup.changed(flingBehavior2)) {
                                i9 = 1048576;
                                i3 |= i9;
                            }
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        i9 = Fields.BlendMode;
                        i3 |= i9;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    i6 = i2 & Fields.SpotShadowColor;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
                    }
                    if ((i2 & Fields.RotationX) == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changedInstance(function1) ? 67108864 : 33554432;
                        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "419@21414L23,425@21768L15");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 2) != 0) {
                                    i3 &= -113;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                companion = modifier;
                                lazyListState4 = lazyListState;
                                m1057PaddingValues0680j_4 = paddingValues;
                                z5 = z2;
                                vertical4 = vertical2;
                                start = horizontal2;
                                i8 = i3;
                                flingBehavior5 = flingBehavior2;
                            } else {
                                companion = i12 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i2 & 2) != 0) {
                                    i7 = 0;
                                    lazyListState3 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                    i3 &= -113;
                                } else {
                                    i7 = 0;
                                    lazyListState3 = lazyListState;
                                }
                                m1057PaddingValues0680j_4 = i13 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(i7)) : paddingValues;
                                if (i4 != 0) {
                                    z3 = false;
                                }
                                if ((i2 & 16) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    vertical4 = !z3 ? arrangement.getTop() : arrangement.getBottom();
                                    i3 &= -57345;
                                } else {
                                    vertical4 = vertical2;
                                }
                                start = i5 != 0 ? Alignment.INSTANCE.getStart() : horizontal2;
                                if ((i2 & 64) != 0) {
                                    flingBehavior4 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i3 &= -3670017;
                                } else {
                                    flingBehavior4 = flingBehavior2;
                                }
                                z5 = i6 != 0 ? true : z2;
                                lazyListState4 = lazyListState3;
                                FlingBehavior flingBehavior6 = flingBehavior4;
                                i8 = i3;
                                flingBehavior5 = flingBehavior6;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-740714857, i8, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:428)");
                            }
                            LazyColumn(companion, lazyListState4, m1057PaddingValues0680j_4, z3, vertical4, start, flingBehavior5, z5, OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0), function1, startRestartGroup, (i8 & 14) | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | (3670016 & i8) | (29360128 & i8) | ((i8 << 3) & 1879048192), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            flingBehavior3 = flingBehavior5;
                            paddingValues2 = m1057PaddingValues0680j_4;
                            lazyListState2 = lazyListState4;
                            Alignment.Horizontal horizontal4 = start;
                            z4 = z5;
                            vertical3 = vertical4;
                            horizontal3 = horizontal4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            companion = modifier;
                            lazyListState2 = lazyListState;
                            paddingValues2 = paddingValues;
                            z4 = z2;
                            vertical3 = vertical2;
                            horizontal3 = horizontal2;
                            flingBehavior3 = flingBehavior2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier2 = companion;
                            final LazyListState lazyListState5 = lazyListState2;
                            final PaddingValues paddingValues3 = paddingValues2;
                            final boolean z6 = z3;
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit LazyColumn$lambda$2;
                                    LazyColumn$lambda$2 = LazyDslKt.LazyColumn$lambda$2(Modifier.this, lazyListState5, paddingValues3, z6, vertical3, horizontal3, flingBehavior3, z4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    return LazyColumn$lambda$2;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                horizontal2 = horizontal;
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & Fields.SpotShadowColor;
                if (i6 == 0) {
                }
                if ((i2 & Fields.RotationX) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z3 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            horizontal2 = horizontal;
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & Fields.SpotShadowColor;
            if (i6 == 0) {
            }
            if ((i2 & Fields.RotationX) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        horizontal2 = horizontal;
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & Fields.SpotShadowColor;
        if (i6 == 0) {
        }
        if ((i2 & Fields.RotationX) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyColumn(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        PaddingValues paddingValues2;
        int i4;
        boolean z2;
        Arrangement.Vertical vertical2;
        int i5;
        Alignment.Horizontal horizontal2;
        FlingBehavior flingBehavior2;
        Modifier modifier2;
        LazyListState lazyListState2;
        PaddingValues paddingValues3;
        final boolean z3;
        final Arrangement.Vertical vertical3;
        Alignment.Horizontal horizontal3;
        FlingBehavior flingBehavior3;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        ?? r3;
        LazyListState lazyListState3;
        boolean z4;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-563353797);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyColumn)N(modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalAlignment,flingBehavior,content)456@22882L351:LazyDsl.kt#428nma");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0 && startRestartGroup.changed(lazyListState)) {
                i8 = 32;
                i3 |= i8;
            }
            i8 = 16;
            i3 |= i8;
        }
        int i10 = i2 & 4;
        if (i10 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            paddingValues2 = paddingValues;
            i3 |= startRestartGroup.changed(paddingValues2) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        vertical2 = vertical;
                        if (startRestartGroup.changed(vertical2)) {
                            i7 = Fields.Clip;
                            i3 |= i7;
                        }
                    } else {
                        vertical2 = vertical;
                    }
                    i7 = Fields.Shape;
                    i3 |= i7;
                } else {
                    vertical2 = vertical;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    horizontal2 = horizontal;
                    i3 |= startRestartGroup.changed(horizontal2) ? Fields.RenderEffect : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            flingBehavior2 = flingBehavior;
                            if (startRestartGroup.changed(flingBehavior2)) {
                                i6 = 1048576;
                                i3 |= i6;
                            }
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        i6 = Fields.BlendMode;
                        i3 |= i6;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if ((i2 & Fields.SpotShadowColor) == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changedInstance(function1) ? 8388608 : 4194304;
                        if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "447@22464L23,453@22818L15");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 2) != 0) {
                                    i3 &= -113;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                companion = modifier;
                                lazyListState3 = lazyListState;
                                paddingValues3 = paddingValues2;
                            } else {
                                companion = i9 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i2 & 2) != 0) {
                                    r3 = 0;
                                    lazyListState3 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                    i3 &= -113;
                                } else {
                                    r3 = 0;
                                    lazyListState3 = lazyListState;
                                }
                                paddingValues3 = i10 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl((float) r3)) : paddingValues2;
                                if (i4 != 0) {
                                    z2 = r3;
                                }
                                if ((i2 & 16) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    i3 &= -57345;
                                    vertical2 = !z2 ? arrangement.getTop() : arrangement.getBottom();
                                }
                                if (i5 != 0) {
                                    horizontal2 = Alignment.INSTANCE.getStart();
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    z4 = z2;
                                    horizontal3 = horizontal2;
                                    int i11 = i3;
                                    Arrangement.Vertical vertical4 = vertical2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-563353797, i11, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:455)");
                                    }
                                    LazyColumn(companion, lazyListState3, paddingValues3, z4, vertical4, horizontal3, flingBehavior3, true, null, function1, startRestartGroup, (i11 & 14) | 12582912 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | ((i11 << 6) & 1879048192), Fields.RotationX);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    vertical3 = vertical4;
                                    z3 = z4;
                                    lazyListState2 = lazyListState3;
                                    modifier2 = companion;
                                }
                            }
                            z4 = z2;
                            horizontal3 = horizontal2;
                            flingBehavior3 = flingBehavior2;
                            int i112 = i3;
                            Arrangement.Vertical vertical42 = vertical2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            LazyColumn(companion, lazyListState3, paddingValues3, z4, vertical42, horizontal3, flingBehavior3, true, null, function1, startRestartGroup, (i112 & 14) | 12582912 | (i112 & 112) | (i112 & 896) | (i112 & 7168) | (57344 & i112) | (458752 & i112) | (3670016 & i112) | ((i112 << 6) & 1879048192), Fields.RotationX);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            vertical3 = vertical42;
                            z3 = z4;
                            lazyListState2 = lazyListState3;
                            modifier2 = companion;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            lazyListState2 = lazyListState;
                            paddingValues3 = paddingValues2;
                            z3 = z2;
                            vertical3 = vertical2;
                            horizontal3 = horizontal2;
                            flingBehavior3 = flingBehavior2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final LazyListState lazyListState4 = lazyListState2;
                            final PaddingValues paddingValues4 = paddingValues3;
                            final Alignment.Horizontal horizontal4 = horizontal3;
                            final FlingBehavior flingBehavior4 = flingBehavior3;
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit LazyColumn$lambda$3;
                                    LazyColumn$lambda$3 = LazyDslKt.LazyColumn$lambda$3(Modifier.this, lazyListState4, paddingValues4, z3, vertical3, horizontal4, flingBehavior4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    return LazyColumn$lambda$3;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                horizontal2 = horizontal;
                if ((1572864 & i) != 0) {
                }
                if ((i2 & Fields.SpotShadowColor) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            horizontal2 = horizontal;
            if ((1572864 & i) != 0) {
            }
            if ((i2 & Fields.SpotShadowColor) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        paddingValues2 = paddingValues;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        horizontal2 = horizontal;
        if ((1572864 & i) != 0) {
        }
        if ((i2 & Fields.SpotShadowColor) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyRow(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z3;
        Arrangement.Horizontal horizontal2;
        int i5;
        Alignment.Vertical vertical2;
        FlingBehavior flingBehavior2;
        int i6;
        Modifier.Companion companion;
        LazyListState lazyListState2;
        PaddingValues paddingValues2;
        final boolean z4;
        final Arrangement.Horizontal horizontal3;
        final Alignment.Vertical vertical3;
        final FlingBehavior flingBehavior3;
        ScopeUpdateScope endRestartGroup;
        int i7;
        LazyListState lazyListState3;
        PaddingValues m1057PaddingValues0680j_4;
        Arrangement.Horizontal horizontal4;
        Alignment.Vertical top;
        FlingBehavior flingBehavior4;
        boolean z5;
        LazyListState lazyListState4;
        int i8;
        FlingBehavior flingBehavior5;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-1724297413);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyRow)N(modifier,state,contentPadding,reverseLayout,horizontalArrangement,verticalAlignment,flingBehavior,userScrollEnabled,content)492@24214L26,483@23858L416:LazyDsl.kt#428nma");
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0 && startRestartGroup.changed(lazyListState)) {
                i11 = 32;
                i3 |= i11;
            }
            i11 = 16;
            i3 |= i11;
        }
        int i13 = i2 & 4;
        if (i13 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(paddingValues) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z3 = z;
                i3 |= startRestartGroup.changed(z3) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        horizontal2 = horizontal;
                        if (startRestartGroup.changed(horizontal2)) {
                            i10 = Fields.Clip;
                            i3 |= i10;
                        }
                    } else {
                        horizontal2 = horizontal;
                    }
                    i10 = Fields.Shape;
                    i3 |= i10;
                } else {
                    horizontal2 = horizontal;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    vertical2 = vertical;
                    i3 |= startRestartGroup.changed(vertical2) ? Fields.RenderEffect : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            flingBehavior2 = flingBehavior;
                            if (startRestartGroup.changed(flingBehavior2)) {
                                i9 = 1048576;
                                i3 |= i9;
                            }
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        i9 = Fields.BlendMode;
                        i3 |= i9;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    i6 = i2 & Fields.SpotShadowColor;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
                    }
                    if ((i2 & Fields.RotationX) == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changedInstance(function1) ? 67108864 : 33554432;
                        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "473@23404L23,479@23755L15");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 2) != 0) {
                                    i3 &= -113;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                companion = modifier;
                                lazyListState4 = lazyListState;
                                m1057PaddingValues0680j_4 = paddingValues;
                                z5 = z2;
                                horizontal4 = horizontal2;
                                top = vertical2;
                                i8 = i3;
                                flingBehavior5 = flingBehavior2;
                            } else {
                                companion = i12 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i2 & 2) != 0) {
                                    i7 = 0;
                                    lazyListState3 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                    i3 &= -113;
                                } else {
                                    i7 = 0;
                                    lazyListState3 = lazyListState;
                                }
                                m1057PaddingValues0680j_4 = i13 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(i7)) : paddingValues;
                                if (i4 != 0) {
                                    z3 = false;
                                }
                                if ((i2 & 16) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    horizontal4 = !z3 ? arrangement.getStart() : arrangement.getEnd();
                                    i3 &= -57345;
                                } else {
                                    horizontal4 = horizontal2;
                                }
                                top = i5 != 0 ? Alignment.INSTANCE.getTop() : vertical2;
                                if ((i2 & 64) != 0) {
                                    flingBehavior4 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i3 &= -3670017;
                                } else {
                                    flingBehavior4 = flingBehavior2;
                                }
                                z5 = i6 != 0 ? true : z2;
                                lazyListState4 = lazyListState3;
                                FlingBehavior flingBehavior6 = flingBehavior4;
                                i8 = i3;
                                flingBehavior5 = flingBehavior6;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1724297413, i8, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:482)");
                            }
                            LazyRow(companion, lazyListState4, m1057PaddingValues0680j_4, z3, horizontal4, top, flingBehavior5, z5, OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0), function1, startRestartGroup, (i8 & 14) | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | (3670016 & i8) | (29360128 & i8) | ((i8 << 3) & 1879048192), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            flingBehavior3 = flingBehavior5;
                            paddingValues2 = m1057PaddingValues0680j_4;
                            lazyListState2 = lazyListState4;
                            Alignment.Vertical vertical4 = top;
                            z4 = z5;
                            horizontal3 = horizontal4;
                            vertical3 = vertical4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            companion = modifier;
                            lazyListState2 = lazyListState;
                            paddingValues2 = paddingValues;
                            z4 = z2;
                            horizontal3 = horizontal2;
                            vertical3 = vertical2;
                            flingBehavior3 = flingBehavior2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier2 = companion;
                            final LazyListState lazyListState5 = lazyListState2;
                            final PaddingValues paddingValues3 = paddingValues2;
                            final boolean z6 = z3;
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit LazyRow$lambda$4;
                                    LazyRow$lambda$4 = LazyDslKt.LazyRow$lambda$4(Modifier.this, lazyListState5, paddingValues3, z6, horizontal3, vertical3, flingBehavior3, z4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    return LazyRow$lambda$4;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                vertical2 = vertical;
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & Fields.SpotShadowColor;
                if (i6 == 0) {
                }
                if ((i2 & Fields.RotationX) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z3 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            vertical2 = vertical;
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & Fields.SpotShadowColor;
            if (i6 == 0) {
            }
            if ((i2 & Fields.RotationX) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        vertical2 = vertical;
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & Fields.SpotShadowColor;
        if (i6 == 0) {
        }
        if ((i2 & Fields.RotationX) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyRow(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        PaddingValues paddingValues2;
        int i4;
        boolean z2;
        Arrangement.Horizontal horizontal2;
        int i5;
        Alignment.Vertical vertical2;
        FlingBehavior flingBehavior2;
        Modifier modifier2;
        LazyListState lazyListState2;
        PaddingValues paddingValues3;
        final boolean z3;
        final Arrangement.Horizontal horizontal3;
        Alignment.Vertical vertical3;
        FlingBehavior flingBehavior3;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        ?? r3;
        LazyListState lazyListState3;
        boolean z4;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(407929823);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyRow)N(modifier,state,contentPadding,reverseLayout,horizontalArrangement,verticalAlignment,flingBehavior,content)510@24860L348:LazyDsl.kt#428nma");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0 && startRestartGroup.changed(lazyListState)) {
                i8 = 32;
                i3 |= i8;
            }
            i8 = 16;
            i3 |= i8;
        }
        int i10 = i2 & 4;
        if (i10 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            paddingValues2 = paddingValues;
            i3 |= startRestartGroup.changed(paddingValues2) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        horizontal2 = horizontal;
                        if (startRestartGroup.changed(horizontal2)) {
                            i7 = Fields.Clip;
                            i3 |= i7;
                        }
                    } else {
                        horizontal2 = horizontal;
                    }
                    i7 = Fields.Shape;
                    i3 |= i7;
                } else {
                    horizontal2 = horizontal;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    vertical2 = vertical;
                    i3 |= startRestartGroup.changed(vertical2) ? Fields.RenderEffect : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            flingBehavior2 = flingBehavior;
                            if (startRestartGroup.changed(flingBehavior2)) {
                                i6 = 1048576;
                                i3 |= i6;
                            }
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        i6 = Fields.BlendMode;
                        i3 |= i6;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if ((i2 & Fields.SpotShadowColor) == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changedInstance(function1) ? 8388608 : 4194304;
                        if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "501@24445L23,507@24796L15");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 2) != 0) {
                                    i3 &= -113;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                companion = modifier;
                                lazyListState3 = lazyListState;
                                paddingValues3 = paddingValues2;
                            } else {
                                companion = i9 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i2 & 2) != 0) {
                                    r3 = 0;
                                    lazyListState3 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                    i3 &= -113;
                                } else {
                                    r3 = 0;
                                    lazyListState3 = lazyListState;
                                }
                                paddingValues3 = i10 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl((float) r3)) : paddingValues2;
                                if (i4 != 0) {
                                    z2 = r3;
                                }
                                if ((i2 & 16) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    i3 &= -57345;
                                    horizontal2 = !z2 ? arrangement.getStart() : arrangement.getEnd();
                                }
                                if (i5 != 0) {
                                    vertical2 = Alignment.INSTANCE.getTop();
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    z4 = z2;
                                    vertical3 = vertical2;
                                    int i11 = i3;
                                    Arrangement.Horizontal horizontal4 = horizontal2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(407929823, i11, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:509)");
                                    }
                                    LazyRow(companion, lazyListState3, paddingValues3, z4, horizontal4, vertical3, flingBehavior3, true, null, function1, startRestartGroup, (i11 & 14) | 12582912 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | ((i11 << 6) & 1879048192), Fields.RotationX);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    horizontal3 = horizontal4;
                                    z3 = z4;
                                    lazyListState2 = lazyListState3;
                                    modifier2 = companion;
                                }
                            }
                            z4 = z2;
                            vertical3 = vertical2;
                            flingBehavior3 = flingBehavior2;
                            int i112 = i3;
                            Arrangement.Horizontal horizontal42 = horizontal2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            LazyRow(companion, lazyListState3, paddingValues3, z4, horizontal42, vertical3, flingBehavior3, true, null, function1, startRestartGroup, (i112 & 14) | 12582912 | (i112 & 112) | (i112 & 896) | (i112 & 7168) | (57344 & i112) | (458752 & i112) | (3670016 & i112) | ((i112 << 6) & 1879048192), Fields.RotationX);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            horizontal3 = horizontal42;
                            z3 = z4;
                            lazyListState2 = lazyListState3;
                            modifier2 = companion;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            lazyListState2 = lazyListState;
                            paddingValues3 = paddingValues2;
                            z3 = z2;
                            horizontal3 = horizontal2;
                            vertical3 = vertical2;
                            flingBehavior3 = flingBehavior2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final LazyListState lazyListState4 = lazyListState2;
                            final PaddingValues paddingValues4 = paddingValues3;
                            final Alignment.Vertical vertical4 = vertical3;
                            final FlingBehavior flingBehavior4 = flingBehavior3;
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit LazyRow$lambda$5;
                                    LazyRow$lambda$5 = LazyDslKt.LazyRow$lambda$5(Modifier.this, lazyListState4, paddingValues4, z3, horizontal3, vertical4, flingBehavior4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    return LazyRow$lambda$5;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                vertical2 = vertical;
                if ((1572864 & i) != 0) {
                }
                if ((i2 & Fields.SpotShadowColor) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            vertical2 = vertical;
            if ((1572864 & i) != 0) {
            }
            if ((i2 & Fields.SpotShadowColor) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        paddingValues2 = paddingValues;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        vertical2 = vertical;
        if ((1572864 & i) != 0) {
        }
        if ((i2 & Fields.SpotShadowColor) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List list, Function1 function1, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        lazyListScope.items(list.size(), function1 != null ? new LazyDslKt$items$2(function1, list) : null, new LazyDslKt$items$3(LazyDslKt$items$1.INSTANCE, list), ComposableLambdaKt.composableLambdaInstance(802480018, true, new LazyDslKt$items$4(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List list, Function2 function2, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        lazyListScope.items(list.size(), function2 != null ? new LazyDslKt$itemsIndexed$2(function2, list) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(list), ComposableLambdaKt.composableLambdaInstance(2039820996, true, new LazyDslKt$itemsIndexed$4(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] objArr, Function1 function1, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        lazyListScope.items(objArr.length, function1 != null ? new LazyDslKt$items$6(function1, objArr) : null, new LazyDslKt$items$7(LazyDslKt$items$5.INSTANCE, objArr), ComposableLambdaKt.composableLambdaInstance(-1781742563, true, new LazyDslKt$items$8(function4, objArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] objArr, Function2 function2, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        lazyListScope.items(objArr.length, function2 != null ? new LazyDslKt$itemsIndexed$6(function2, objArr) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(objArr), ComposableLambdaKt.composableLambdaInstance(1763000017, true, new LazyDslKt$itemsIndexed$8(function5, objArr)));
    }
}
