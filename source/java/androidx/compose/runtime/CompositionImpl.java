package androidx.compose.runtime;

import androidx.autofill.HintConstants;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.GlobalCompositionObserver;
import androidx.compose.runtime.tooling.GlobalCompositionObserverKt;
import androidx.compose.runtime.tooling.ObservableComposition;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte$;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composition.kt */
@Metadata(d1 = {"\u0000®\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B'\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ \u0010g\u001a\u00020\\2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0016¢\u0006\u0002\u0010aJ \u0010i\u001a\u00020\\2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0016¢\u0006\u0002\u0010aJ \u0010j\u001a\u00020k2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0016¢\u0006\u0002\u0010lJ \u0010m\u001a\u00020k2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0016¢\u0006\u0002\u0010lJ\u001d\u0010n\u001a\u00020\\2\u000e\u0010o\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010pH\u0000¢\u0006\u0002\brJ \u0010s\u001a\u00020\\2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0002¢\u0006\u0002\u0010aJ(\u0010t\u001a\u00020k2\u0006\u0010u\u001a\u00020<2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0002¢\u0006\u0002\u0010vJ \u0010w\u001a\u00020\\2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0002¢\u0006\u0002\u0010aJ\b\u0010x\u001a\u00020\\H\u0002J\b\u0010y\u001a\u00020<H\u0002J\u0010\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020}H\u0016J\u000e\u0010~\u001a\u00020\\2\u0006\u0010\u007f\u001a\u00020HJ\t\u0010\u0080\u0001\u001a\u00020\\H\u0002J\t\u0010\u0081\u0001\u001a\u00020\\H\u0002J\t\u0010\u0082\u0001\u001a\u00020\\H\u0002J!\u0010\u0083\u0001\u001a\u00020\\2\u0011\u0010h\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]H\u0016¢\u0006\u0002\u0010aJ\u000f\u0010\u0084\u0001\u001a\u00020\\H\u0000¢\u0006\u0003\b\u0085\u0001J\t\u0010\u0086\u0001\u001a\u00020\\H\u0016J\u0018\u0010\u0089\u0001\u001a\u00020\\2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130(H\u0016J\u0018\u0010\u008b\u0001\u001a\u00020<2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130(H\u0016J\u0018\u0010\u008c\u0001\u001a\u00020\\2\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\\0[H\u0016J:\u0010\u008e\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00130\u008f\u0001032\u0015\u0010\u0090\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0092\u0001\u0012\u0004\u0012\u00020<0\u0091\u0001H\u0080\b¢\u0006\u0003\b\u0093\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\\2\u0007\u0010\u0095\u0001\u001a\u00020\u00132\u0007\u0010\u0096\u0001\u001a\u00020<H\u0002J!\u0010\u0094\u0001\u001a\u00020\\2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130(2\u0007\u0010\u0096\u0001\u001a\u00020<H\u0002J\t\u0010\u0097\u0001\u001a\u00020\\H\u0002J\u0012\u0010\u0098\u0001\u001a\u00020\\2\u0007\u0010\u0095\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010\u0099\u0001\u001a\u00020\\2\u0007\u0010\u0095\u0001\u001a\u00020\u0013H\u0002J\u0012\u0010\u009a\u0001\u001a\u00020\\2\u0007\u0010\u0095\u0001\u001a\u00020\u0013H\u0016J\t\u0010\u009b\u0001\u001a\u00020<H\u0016J)\u0010\u009c\u0001\u001a\u00020\\2\u001e\u0010\u009d\u0001\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030\u009e\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009e\u00010\u008f\u000103H\u0016J\u0012\u0010\u009f\u0001\u001a\u00020\\2\u0007\u0010W\u001a\u00030 \u0001H\u0016J\u0011\u0010¡\u0001\u001a\u00020\\2\u0006\u00106\u001a\u000207H\u0002J\t\u0010¢\u0001\u001a\u00020\\H\u0016J\t\u0010£\u0001\u001a\u00020\\H\u0016J\t\u0010¤\u0001\u001a\u00020\\H\u0016JL\u0010¥\u0001\u001a\u0003H¦\u0001\"\u0005\b\u0000\u0010¦\u000122\u0010\u008d\u0001\u001a-\u0012!\u0012\u001f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00130$¢\u0006\u000e\b§\u0001\u0012\t\b¨\u0001\u0012\u0004\b\b(6\u0012\u0005\u0012\u0003H¦\u00010\u0091\u0001H\u0082\b¢\u0006\u0003\u0010©\u0001J(\u0010ª\u0001\u001a\u0003H¦\u0001\"\u0005\b\u0000\u0010¦\u00012\u000e\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u0003H¦\u00010[H\u0082\b¢\u0006\u0003\u0010«\u0001J\t\u0010¬\u0001\u001a\u00020\\H\u0016J\t\u0010\u00ad\u0001\u001a\u00020\\H\u0016J\t\u0010®\u0001\u001a\u00020\\H\u0016J;\u0010¯\u0001\u001a\u0003H°\u0001\"\u0005\b\u0000\u0010°\u00012\t\u0010±\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010²\u0001\u001a\u00020H2\u000e\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u0003H°\u00010[H\u0016¢\u0006\u0003\u0010³\u0001J\u0015\u0010´\u0001\u001a\u0004\u0018\u00010C2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u001e\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010·\u0001\u001a\u00020%2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010¹\u0001\u001a\u00020\\2\u0007\u0010·\u0001\u001a\u00020%H\u0016J)\u0010º\u0001\u001a\u0005\u0018\u0001H¦\u0001\"\u0005\b\u0000\u0010¦\u00012\u000e\u0010\u007f\u001a\n\u0012\u0005\u0012\u0003H¦\u00010»\u0001H\u0016¢\u0006\u0003\u0010¼\u0001J\u001d\u0010½\u0001\u001a\u00020<2\u0007\u0010·\u0001\u001a\u00020%2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0013H\u0002J(\u0010¾\u0001\u001a\u00030¶\u00012\u0007\u0010·\u0001\u001a\u00020%2\b\u0010¿\u0001\u001a\u00030\u0092\u00012\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0013H\u0002J!\u0010À\u0001\u001a\u00020\\2\u0007\u0010¸\u0001\u001a\u00020\u00132\u0007\u0010·\u0001\u001a\u00020%H\u0000¢\u0006\u0003\bÁ\u0001J\u001b\u0010Â\u0001\u001a\u00020\\2\n\u0010W\u001a\u0006\u0012\u0002\b\u00030/H\u0000¢\u0006\u0003\bÃ\u0001J\u001e\u0010Ä\u0001\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00130$H\u0002¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u0011\u0010Ç\u0001\u001a\u00020\\2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J(\u0010È\u0001\u001a\u0003H¦\u0001\"\u0005\b\u0000\u0010¦\u00012\u000e\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u0003H¦\u00010[H\u0082\b¢\u0006\u0003\u0010«\u0001J\n\u0010|\u001a\u0004\u0018\u00010}H\u0002J\t\u0010É\u0001\u001a\u00020\\H\u0016J\u000f\u0010Ê\u0001\u001a\u00020HH\u0000¢\u0006\u0003\bË\u0001R\u0013\u0010\u0007\u001a\u00020\b8G¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0013`\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u0016\u001a\u00060\u0013j\u0002`\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130(8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020%0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020%0,X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030/0$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130(8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b1\u0010*R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020%038AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u001c\u0010:\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00130$X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R \u0010;\u001a\u00020<X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b=\u0010\u001d\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\u00020JX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\u00020PX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0010\u0010S\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0011\u0010V\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\bV\u0010?R\u000e\u0010W\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\u00020<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u0010?R'\u0010Z\u001a\r\u0012\u0004\u0012\u00020\\0[¢\u0006\u0002\b]X\u0086\u000e¢\u0006\u0010\n\u0002\u0010b\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010?R\u0014\u0010d\u001a\u00020<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010?R\u0014\u0010e\u001a\u00020<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bf\u0010?R\u0016\u0010\u0087\u0001\u001a\u00020<8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010?¨\u0006Ì\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/CompositionServices;", "Landroidx/compose/runtime/PausableComposition;", "Landroidx/compose/runtime/tooling/ObservableComposition;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "getParent", "()Landroidx/compose/runtime/CompositionContext;", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "getAbandonSet$annotations", "()V", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime$annotations", "getSlotTable$runtime", "()Landroidx/compose/runtime/SlotTable;", "observations", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/collection/MutableScatterMap;", "observedObjects", "", "getObservedObjects$runtime", "()Ljava/util/Set;", "invalidatedScopes", "Landroidx/collection/MutableScatterSet;", "conditionallyInvalidatedScopes", "derivedStates", "Landroidx/compose/runtime/DerivedState;", "derivedStateDependencies", "getDerivedStateDependencies$runtime", "conditionalScopes", "", "getConditionalScopes$runtime", "()Ljava/util/List;", "changes", "Landroidx/compose/runtime/changelist/ChangeList;", "lateChanges", "observationsProcessed", "invalidations", "pendingInvalidScopes", "", "getPendingInvalidScopes$runtime$annotations", "getPendingInvalidScopes$runtime", "()Z", "setPendingInvalidScopes$runtime", "(Z)V", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "pendingPausedComposition", "Landroidx/compose/runtime/PausedCompositionImpl;", "invalidationDelegate", "invalidationDelegateGroup", "", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "rememberManager", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "getComposer$runtime", "()Landroidx/compose/runtime/ComposerImpl;", "_recomposeContext", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "isRoot", "state", "areChildrenComposing", "getAreChildrenComposing", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "isComposing", "isDisposed", "hasPendingChanges", "getHasPendingChanges", "setContent", "content", "setContentWithReuse", "setPausableContent", "Landroidx/compose/runtime/PausedComposition;", "(Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/PausedComposition;", "setPausableContentWithReuse", "pausedCompositionFinished", "ignoreSet", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/RememberObserverHolder;", "pausedCompositionFinished$runtime", "composeInitial", "composeInitialPaused", "reusable", "(ZLkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/PausedComposition;", "composeInitialWithReuse", "ensureRunning", "clearDeactivated", "setObserver", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", "invalidateGroupsWithKey", "key", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "drainPendingModificationsOutOfBandLocked", "composeContent", "updateMovingInvalidations", "updateMovingInvalidations$runtime", "dispose", "hasInvalidations", "getHasInvalidations", "recordModificationsOf", "values", "observesAnyOf", "prepareCompose", "block", "extractInvalidationsOfGroup", "Lkotlin/Pair;", "inGroup", "Lkotlin/Function1;", "Landroidx/compose/runtime/Anchor;", "extractInvalidationsOfGroup$runtime", "addPendingInvalidationsLocked", "value", "forgetConditionalScopes", "cleanUpDerivedStateObservations", "recordReadOf", "invalidateScopeOfLocked", "recordWriteOf", "recompose", "insertMovableContent", "references", "Landroidx/compose/runtime/MovableContentStateReference;", "disposeUnusedMovableContent", "Landroidx/compose/runtime/MovableContentState;", "applyChangesInLocked", "applyChanges", "applyLateChanges", "changesApplied", "guardInvalidationsLocked", "T", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "guardChanges", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "abandonChanges", "invalidateAll", "verifyConsistent", "delegateInvalidations", "R", "to", "groupIndex", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAndSetShouldPauseCallback", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "recomposeScopeReleased", "getCompositionService", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "tryImminentInvalidation", "invalidateChecked", "anchor", "removeObservation", "removeObservation$runtime", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime", "takeInvalidations", "takeInvalidations-afanTW4", "()Landroidx/collection/MutableScatterMap;", "validateRecomposeScopeAnchors", "trackAbandonedValues", "deactivate", "composerStacksSizes", "composerStacksSizes$runtime", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner, CompositionServices, PausableComposition, ObservableComposition {
    public static final int $stable = 8;
    private final CoroutineContext _recomposeContext;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final ChangeList changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final MutableScatterSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final MutableScatterMap<Object, Object> derivedStates;
    private final MutableScatterSet<RecomposeScopeImpl> invalidatedScopes;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private MutableScatterMap<Object, Object> invalidations;
    private final boolean isRoot;
    private final ChangeList lateChanges;
    private final Object lock;
    private final MutableScatterMap<Object, Object> observations;
    private final MutableScatterMap<Object, Object> observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private PausedCompositionImpl pendingPausedComposition;
    private final RememberEventDispatcher rememberManager;
    private ShouldPauseCallback shouldPause;
    private final SlotTable slotTable;
    private int state;

    private static /* synthetic */ void getAbandonSet$annotations() {
    }

    public static /* synthetic */ void getPendingInvalidScopes$runtime$annotations() {
    }

    public static /* synthetic */ void getSlotTable$runtime$annotations() {
    }

    public CompositionImpl(CompositionContext compositionContext, Applier<?> applier, CoroutineContext coroutineContext) {
        this.parent = compositionContext;
        this.applier = applier;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        Set<RememberObserver> asMutableSet = new MutableScatterSet(0, 1, null).asMutableSet();
        this.abandonSet = asMutableSet;
        SlotTable slotTable = new SlotTable();
        if (compositionContext.getCollectingCallByInformation$runtime()) {
            slotTable.collectCalledByInformation();
        }
        if (compositionContext.getCollectingSourceInformation()) {
            slotTable.collectSourceInformation();
        }
        this.slotTable = slotTable;
        this.observations = ScopeMap.m4211constructorimpl$default(null, 1, null);
        this.invalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.conditionallyInvalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.derivedStates = ScopeMap.m4211constructorimpl$default(null, 1, null);
        ChangeList changeList = new ChangeList();
        this.changes = changeList;
        ChangeList changeList2 = new ChangeList();
        this.lateChanges = changeList2;
        this.observationsProcessed = ScopeMap.m4211constructorimpl$default(null, 1, null);
        this.invalidations = ScopeMap.m4211constructorimpl$default(null, 1, null);
        CompositionObserverHolder compositionObserverHolder = new CompositionObserverHolder(null, false, compositionContext, 3, null);
        this.observerHolder = compositionObserverHolder;
        this.rememberManager = new RememberEventDispatcher();
        ComposerImpl composerImpl = new ComposerImpl(applier, compositionContext, slotTable, asMutableSet, changeList, changeList2, compositionObserverHolder, this);
        compositionContext.registerComposer$runtime(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.getLambda$954879418$runtime();
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier, (i & 4) != 0 ? null : coroutineContext);
    }

    public final CompositionContext getParent() {
        return this.parent;
    }

    /* renamed from: getSlotTable$runtime, reason: from getter */
    public final SlotTable getSlotTable() {
        return this.slotTable;
    }

    public final Set<Object> getObservedObjects$runtime() {
        return this.observations.asMap().keySet();
    }

    public final Set<Object> getDerivedStateDependencies$runtime() {
        return this.derivedStates.asMap().keySet();
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes.asSet());
    }

    /* renamed from: getPendingInvalidScopes$runtime, reason: from getter */
    public final boolean getPendingInvalidScopes() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime(boolean z) {
        this.pendingInvalidScopes = z;
    }

    /* renamed from: getObserverHolder$runtime, reason: from getter */
    public final CompositionObserverHolder getObserverHolder() {
        return this.observerHolder;
    }

    /* renamed from: getComposer$runtime, reason: from getter */
    public final ComposerImpl getComposer() {
        return this.composer;
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime() : coroutineContext;
    }

    /* renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composable = function2;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.getIsComposing();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.state == 3;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime;
        synchronized (this.lock) {
            hasPendingChanges$runtime = this.composer.getHasPendingChanges$runtime();
        }
        return hasPendingChanges$runtime;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        boolean clearDeactivated = clearDeactivated();
        ensureRunning();
        if (clearDeactivated) {
            composeInitialWithReuse(content);
        } else {
            composeInitial(content);
        }
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void setContentWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        clearDeactivated();
        ensureRunning();
        composeInitialWithReuse(content);
    }

    @Override // androidx.compose.runtime.PausableComposition
    public PausedComposition setPausableContent(Function2<? super Composer, ? super Integer, Unit> content) {
        return composeInitialPaused(clearDeactivated(), content);
    }

    @Override // androidx.compose.runtime.PausableComposition
    public PausedComposition setPausableContentWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        clearDeactivated();
        ensureRunning();
        return composeInitialPaused(true, content);
    }

    public final void pausedCompositionFinished$runtime(ScatterSet<RememberObserverHolder> ignoreSet) {
        this.pendingPausedComposition = null;
        if (ignoreSet != null) {
            this.rememberManager.ignoreForgotten(ignoreSet);
            this.state = 2;
        }
    }

    private final void composeInitial(Function2<? super Composer, ? super Integer, Unit> content) {
        this.composable = content;
        this.parent.composeInitial$runtime(this, content);
    }

    private final PausedComposition composeInitialPaused(boolean reusable, Function2<? super Composer, ? super Integer, Unit> content) {
        if (!(this.pendingPausedComposition == null)) {
            PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
        }
        PausedCompositionImpl pausedCompositionImpl = new PausedCompositionImpl(this, this.parent, this.composer, this.abandonSet, content, reusable, this.applier, this.lock);
        this.pendingPausedComposition = pausedCompositionImpl;
        return pausedCompositionImpl;
    }

    private final void composeInitialWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        this.composer.startReuseFromRoot();
        composeInitial(content);
        this.composer.endReuseFromRoot();
    }

    private final void ensureRunning() {
        int i = this.state;
        if (!(i == 0)) {
            PreconditionsKt.throwIllegalStateException(i != 1 ? i != 2 ? i != 3 ? "" : "The composition is disposed" : "A previous pausable composition for this composition was cancelled. This composition must be disposed." : "The composition should be activated before setting content.");
        }
        if (this.pendingPausedComposition == null) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
    }

    private final boolean clearDeactivated() {
        boolean z;
        synchronized (this.lock) {
            z = true;
            if (this.state != 1) {
                z = false;
            }
            if (z) {
                this.state = 0;
            }
        }
        return z;
    }

    @Override // androidx.compose.runtime.tooling.ObservableComposition
    public CompositionObserverHandle setObserver(final CompositionObserver observer) {
        synchronized (this.lock) {
            this.observerHolder.setObserver(observer);
            this.observerHolder.setRoot(true);
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.CompositionImpl$setObserver$2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                Object obj;
                obj = CompositionImpl.this.lock;
                CompositionImpl compositionImpl = CompositionImpl.this;
                CompositionObserver compositionObserver = observer;
                synchronized (obj) {
                    if (Intrinsics.areEqual(compositionImpl.getObserverHolder().getObserver(), compositionObserver)) {
                        compositionImpl.getObserverHolder().setObserver(null);
                        compositionImpl.getObserverHolder().setRoot(false);
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        };
    }

    public final void invalidateGroupsWithKey(int key) {
        List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime;
        boolean z;
        synchronized (this.lock) {
            invalidateGroupsWithKey$runtime = this.slotTable.invalidateGroupsWithKey$runtime(key);
        }
        boolean z2 = true;
        if (invalidateGroupsWithKey$runtime != null) {
            int size = invalidateGroupsWithKey$runtime.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                }
                if (invalidateGroupsWithKey$runtime.get(i).invalidateForResult(null) == InvalidationResult.IGNORED) {
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                z2 = false;
            }
        }
        if (z2 && this.composer.forceRecomposeScopes$runtime()) {
            this.parent.invalidate$runtime(this);
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object obj;
        Object obj2;
        AtomicReference<Object> atomicReference = this.pendingModifications;
        obj = CompositionKt.PendingApplyNoModifications;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != null) {
            obj2 = CompositionKt.PendingApplyNoModifications;
            if (Intrinsics.areEqual(andSet, obj2)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set<? extends Object>) andSet, true);
                return;
            }
            if (andSet instanceof Object[]) {
                for (Set<? extends Object> set : (Set[]) andSet) {
                    addPendingInvalidationsLocked(set, true);
                }
                return;
            }
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    private final void drainPendingModificationsLocked() {
        Object obj;
        Object andSet = this.pendingModifications.getAndSet(null);
        obj = CompositionKt.PendingApplyNoModifications;
        if (Intrinsics.areEqual(andSet, obj)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (!(andSet instanceof Object[])) {
            if (andSet == null) {
                ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
                throw new KotlinNothingValueException();
            }
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
        for (Set<? extends Object> set : (Set[]) andSet) {
            addPendingInvalidationsLocked(set, false);
        }
    }

    private final void drainPendingModificationsOutOfBandLocked() {
        Object obj;
        Object andSet = this.pendingModifications.getAndSet(SetsKt.emptySet());
        obj = CompositionKt.PendingApplyNoModifications;
        if (Intrinsics.areEqual(andSet, obj) || andSet == null) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2<? super Composer, ? super Integer, Unit> content) {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                MutableScatterMap<Object, Object> m4041takeInvalidationsafanTW4 = m4041takeInvalidationsafanTW4();
                try {
                    this.composer.m4038composeContentZbOJvo$runtime(m4041takeInvalidationsafanTW4, content, this.shouldPause);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th) {
                    this.invalidations = m4041takeInvalidationsafanTW4;
                    throw th;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        } catch (Throwable th2) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } catch (Throwable th3) {
                        rememberEventDispatcher.clear();
                        throw th3;
                    }
                }
                throw th2;
            } catch (Throwable th4) {
                abandonChanges();
                throw th4;
            }
        }
    }

    public final void updateMovingInvalidations$runtime() {
        synchronized (this.lock) {
            drainPendingModificationsOutOfBandLocked();
            MutableScatterMap<Object, Object> m4041takeInvalidationsafanTW4 = m4041takeInvalidationsafanTW4();
            try {
                this.composer.m4040updateComposerInvalidationsRY85e9Y(m4041takeInvalidationsafanTW4);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                this.invalidations = m4041takeInvalidationsafanTW4;
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            if (!(!this.composer.getIsComposing())) {
                PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
            }
            if (this.state != 3) {
                this.state = 3;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.getLambda$1918065384$runtime();
                ChangeList deferredChanges = this.composer.getDeferredChanges();
                if (deferredChanges != null) {
                    applyChangesInLocked(deferredChanges);
                }
                boolean z = this.slotTable.getGroupsSize() > 0;
                if (z || (!this.abandonSet.isEmpty())) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        if (z) {
                            this.applier.onBeginChanges();
                            SlotWriter openWriter = this.slotTable.openWriter();
                            try {
                                ComposerKt.removeCurrentGroup(openWriter, this.rememberManager);
                                Unit unit = Unit.INSTANCE;
                                openWriter.close(true);
                                this.applier.clear();
                                this.applier.onEndChanges();
                                rememberEventDispatcher.dispatchRememberObservers();
                            } catch (Throwable th) {
                                openWriter.close(false);
                                throw th;
                            }
                        }
                        rememberEventDispatcher.dispatchAbandons();
                    } finally {
                        rememberEventDispatcher.clear();
                    }
                }
                this.composer.dispose$runtime();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime(this);
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = ScopeMap.m4216getSizeimpl(this.invalidations) > 0;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.Set[]] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> values) {
        Object obj;
        Set<? extends Object> set;
        Object obj2;
        do {
            obj = this.pendingModifications.get();
            if (obj != null) {
                obj2 = CompositionKt.PendingApplyNoModifications;
                if (!Intrinsics.areEqual(obj, obj2)) {
                    if (obj instanceof Set) {
                        set = new Set[]{obj, values};
                    } else {
                        if (!(obj instanceof Object[])) {
                            throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                        set = ArraysKt.plus((Set[]) obj, values);
                    }
                }
            }
            set = values;
        } while (!UByte$.ExternalSyntheticBackport0.m(this.pendingModifications, obj, set));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0<Unit> block) {
        this.composer.prepareCompose$runtime(block);
    }

    public final List<Pair<RecomposeScopeImpl, Object>> extractInvalidationsOfGroup$runtime(Function1<? super Anchor, Boolean> inGroup) {
        long[] jArr;
        int i;
        long[] jArr2;
        int i2;
        int i3;
        long j;
        int i4;
        char c;
        long j2;
        int i5;
        int i6;
        boolean z;
        Object[] objArr;
        long[] jArr3;
        int i7;
        Object[] objArr2;
        long[] jArr4;
        int i8;
        boolean z2;
        if (ScopeMap.m4216getSizeimpl(this.invalidations) > 0) {
            ArrayList arrayList = new ArrayList();
            MutableScatterMap mutableScatterMap = this.invalidations;
            long[] jArr5 = mutableScatterMap.metadata;
            int length = jArr5.length - 2;
            if (length < 0) {
                return arrayList;
            }
            int i9 = 0;
            while (true) {
                long j3 = jArr5[i9];
                char c2 = 7;
                long j4 = -9187201950435737472L;
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i10 = 8;
                    int i11 = 8 - ((~(i9 - length)) >>> 31);
                    int i12 = 0;
                    while (i12 < i11) {
                        boolean z3 = true;
                        if ((j3 & 255) < 128) {
                            int i13 = (i9 << 3) + i12;
                            Object obj = mutableScatterMap.keys[i13];
                            Object obj2 = mutableScatterMap.values[i13];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr3 = mutableScatterSet.elements;
                                long[] jArr6 = mutableScatterSet.metadata;
                                int length2 = jArr6.length - 2;
                                jArr2 = jArr5;
                                if (length2 >= 0) {
                                    i3 = i9;
                                    j = j3;
                                    int i14 = 0;
                                    while (true) {
                                        long j5 = jArr6[i14];
                                        i4 = i11;
                                        c = 7;
                                        j2 = -9187201950435737472L;
                                        if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i15 = 8 - ((~(i14 - length2)) >>> 31);
                                            int i16 = 0;
                                            while (i16 < i15) {
                                                if ((j5 & 255) < 128) {
                                                    jArr4 = jArr6;
                                                    int i17 = (i14 << 3) + i16;
                                                    i7 = length;
                                                    Object obj3 = objArr3[i17];
                                                    objArr2 = objArr3;
                                                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                                                    i8 = i12;
                                                    Anchor anchor = recomposeScopeImpl.getAnchor();
                                                    if (anchor == null || !((Boolean) inGroup.invoke(anchor)).booleanValue()) {
                                                        z2 = false;
                                                    } else {
                                                        arrayList.add(TuplesKt.to(recomposeScopeImpl, obj3));
                                                        z2 = true;
                                                    }
                                                    if (z2) {
                                                        mutableScatterSet.removeElementAt(i17);
                                                    }
                                                } else {
                                                    i7 = length;
                                                    objArr2 = objArr3;
                                                    jArr4 = jArr6;
                                                    i8 = i12;
                                                }
                                                j5 >>= 8;
                                                i16++;
                                                length = i7;
                                                jArr6 = jArr4;
                                                objArr3 = objArr2;
                                                i12 = i8;
                                            }
                                            i2 = length;
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                            i5 = i12;
                                            if (i15 != 8) {
                                                break;
                                            }
                                        } else {
                                            i2 = length;
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                            i5 = i12;
                                        }
                                        if (i14 == length2) {
                                            break;
                                        }
                                        i14++;
                                        i11 = i4;
                                        length = i2;
                                        jArr6 = jArr3;
                                        objArr3 = objArr;
                                        i12 = i5;
                                    }
                                } else {
                                    i2 = length;
                                    i3 = i9;
                                    j = j3;
                                    i4 = i11;
                                    i5 = i12;
                                    c = 7;
                                    j2 = -9187201950435737472L;
                                }
                                z = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr5;
                                i2 = length;
                                i3 = i9;
                                j = j3;
                                i4 = i11;
                                c = c2;
                                i5 = i12;
                                j2 = -9187201950435737472L;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
                                Anchor anchor2 = recomposeScopeImpl2.getAnchor();
                                if (anchor2 == null || !((Boolean) inGroup.invoke(anchor2)).booleanValue()) {
                                    z3 = false;
                                } else {
                                    arrayList.add(TuplesKt.to(recomposeScopeImpl2, obj2));
                                }
                                z = z3;
                            }
                            if (z) {
                                mutableScatterMap.removeValueAt(i13);
                            }
                            i6 = 8;
                        } else {
                            jArr2 = jArr5;
                            i2 = length;
                            i3 = i9;
                            j = j3;
                            i4 = i11;
                            c = c2;
                            j2 = j4;
                            i5 = i12;
                            i6 = i10;
                        }
                        j3 = j >> i6;
                        i12 = i5 + 1;
                        i10 = i6;
                        c2 = c;
                        j4 = j2;
                        jArr5 = jArr2;
                        i9 = i3;
                        i11 = i4;
                        length = i2;
                    }
                    jArr = jArr5;
                    int i18 = length;
                    int i19 = i9;
                    if (i11 != i10) {
                        return arrayList;
                    }
                    i = i19;
                    length = i18;
                } else {
                    jArr = jArr5;
                    i = i9;
                }
                if (i == length) {
                    return arrayList;
                }
                i9 = i + 1;
                jArr5 = jArr;
            }
        } else {
            return CollectionsKt.emptyList();
        }
    }

    private final void addPendingInvalidationsLocked(Object value, boolean forgetConditionalScopes) {
        Object obj = this.observations.get(value);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (!ScopeMap.m4218removeimpl(this.observationsProcessed, value, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(value) != InvalidationResult.IGNORED) {
                                if (recomposeScopeImpl.isConditional() && !forgetConditionalScopes) {
                                    this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                                } else {
                                    this.invalidatedScopes.add(recomposeScopeImpl);
                                }
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
            if (ScopeMap.m4218removeimpl(this.observationsProcessed, value, recomposeScopeImpl2) || recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IGNORED) {
                return;
            }
            if (recomposeScopeImpl2.isConditional() && !forgetConditionalScopes) {
                this.conditionallyInvalidatedScopes.add(recomposeScopeImpl2);
            } else {
                this.invalidatedScopes.add(recomposeScopeImpl2);
            }
        }
    }

    private final void cleanUpDerivedStateObservations() {
        long[] jArr;
        long[] jArr2;
        int i;
        int i2;
        int i3;
        boolean z;
        Object[] objArr;
        long[] jArr3;
        Object[] objArr2;
        long[] jArr4;
        MutableScatterMap<Object, Object> mutableScatterMap = this.derivedStates;
        long[] jArr5 = mutableScatterMap.metadata;
        int length = jArr5.length - 2;
        long j = 255;
        char c = 7;
        long j2 = -9187201950435737472L;
        int i4 = 8;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j3 = jArr5[i5];
                if ((((~j3) << c) & j3 & j2) != j2) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j3 & j) < 128) {
                            int i8 = (i5 << 3) + i7;
                            Object obj = mutableScatterMap.keys[i8];
                            Object obj2 = mutableScatterMap.values[i8];
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr3 = mutableScatterSet.elements;
                                long[] jArr6 = mutableScatterSet.metadata;
                                int length2 = jArr6.length - 2;
                                jArr2 = jArr5;
                                i = length;
                                if (length2 >= 0) {
                                    int i9 = 0;
                                    while (true) {
                                        long j4 = jArr6[i9];
                                        i2 = i6;
                                        i3 = i7;
                                        if ((((~j4) << c) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                            int i11 = 0;
                                            while (i11 < i10) {
                                                if ((j4 & 255) < 128) {
                                                    int i12 = (i9 << 3) + i11;
                                                    objArr2 = objArr3;
                                                    jArr4 = jArr6;
                                                    if (!ScopeMap.m4212containsimpl(this.observations, (DerivedState) objArr3[i12])) {
                                                        mutableScatterSet.removeElementAt(i12);
                                                    }
                                                } else {
                                                    objArr2 = objArr3;
                                                    jArr4 = jArr6;
                                                }
                                                j4 >>= 8;
                                                i11++;
                                                jArr6 = jArr4;
                                                objArr3 = objArr2;
                                            }
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                            if (i10 != 8) {
                                                break;
                                            }
                                        } else {
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                        }
                                        if (i9 == length2) {
                                            break;
                                        }
                                        i9++;
                                        i6 = i2;
                                        i7 = i3;
                                        jArr6 = jArr3;
                                        objArr3 = objArr;
                                        c = 7;
                                    }
                                } else {
                                    i2 = i6;
                                    i3 = i7;
                                }
                                z = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr5;
                                i = length;
                                i2 = i6;
                                i3 = i7;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                z = !ScopeMap.m4212containsimpl(this.observations, (DerivedState) obj2);
                            }
                            if (z) {
                                mutableScatterMap.removeValueAt(i8);
                            }
                        } else {
                            jArr2 = jArr5;
                            i = length;
                            i2 = i6;
                            i3 = i7;
                        }
                        j3 >>= 8;
                        i7 = i3 + 1;
                        i4 = 8;
                        jArr5 = jArr2;
                        length = i;
                        i6 = i2;
                        j = 255;
                        c = 7;
                    }
                    jArr = jArr5;
                    int i13 = length;
                    if (i6 != i4) {
                        break;
                    } else {
                        length = i13;
                    }
                } else {
                    jArr = jArr5;
                }
                if (i5 == length) {
                    break;
                }
                i5++;
                jArr5 = jArr;
                j = 255;
                c = 7;
                j2 = -9187201950435737472L;
                i4 = 8;
            }
        }
        if (!this.conditionallyInvalidatedScopes.isNotEmpty()) {
            return;
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        Object[] objArr4 = mutableScatterSet2.elements;
        long[] jArr7 = mutableScatterSet2.metadata;
        int length3 = jArr7.length - 2;
        if (length3 < 0) {
            return;
        }
        int i14 = 0;
        while (true) {
            long j5 = jArr7[i14];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i15 = 8 - ((~(i14 - length3)) >>> 31);
                for (int i16 = 0; i16 < i15; i16++) {
                    if ((j5 & 255) < 128) {
                        int i17 = (i14 << 3) + i16;
                        if (!((RecomposeScopeImpl) objArr4[i17]).isConditional()) {
                            mutableScatterSet2.removeElementAt(i17);
                        }
                    }
                    j5 >>= 8;
                }
                if (i15 != 8) {
                    return;
                }
            }
            if (i14 == length3) {
                return;
            } else {
                i14++;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object value) {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        long[] jArr;
        long[] jArr2;
        int i;
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime = this.composer.getCurrentRecomposeScope$runtime()) == null) {
            return;
        }
        currentRecomposeScope$runtime.setUsed(true);
        boolean recordRead = currentRecomposeScope$runtime.recordRead(value);
        CompositionObserver observer = observer();
        if (observer != null) {
            observer.onReadInScope(currentRecomposeScope$runtime, value);
        }
        GlobalCompositionObserver globalCompositionObserver = GlobalCompositionObserverKt.get_globalCompositionObserver();
        if (globalCompositionObserver != null) {
            globalCompositionObserver.onReadInScope(currentRecomposeScope$runtime, value);
        }
        if (recordRead) {
            return;
        }
        if (value instanceof StateObjectImpl) {
            ReaderKind.Companion companion = ReaderKind.INSTANCE;
            ((StateObjectImpl) value).m4276recordReadInh_f27i8$runtime(ReaderKind.m4253constructorimpl(1));
        }
        ScopeMap.m4205addimpl(this.observations, value, currentRecomposeScope$runtime);
        if (value instanceof DerivedState) {
            DerivedState<?> derivedState = (DerivedState) value;
            DerivedState.Record<?> currentRecord = derivedState.getCurrentRecord();
            ScopeMap.m4220removeScopeimpl(this.derivedStates, value);
            ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
            Object[] objArr = dependencies.keys;
            long[] jArr3 = dependencies.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    long j = jArr3[i2];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i3 = 8;
                        int i4 = 8 - ((~(i2 - length)) >>> 31);
                        int i5 = 0;
                        while (i5 < i4) {
                            if ((j & 255) < 128) {
                                StateObject stateObject = (StateObject) objArr[(i2 << 3) + i5];
                                if (stateObject instanceof StateObjectImpl) {
                                    ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                                    jArr2 = jArr3;
                                    ((StateObjectImpl) stateObject).m4276recordReadInh_f27i8$runtime(ReaderKind.m4253constructorimpl(1));
                                } else {
                                    jArr2 = jArr3;
                                }
                                ScopeMap.m4205addimpl(this.derivedStates, stateObject, value);
                                i = 8;
                            } else {
                                jArr2 = jArr3;
                                i = i3;
                            }
                            j >>= i;
                            i5++;
                            i3 = i;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i4 != i3) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                    jArr3 = jArr;
                }
            }
            currentRecomposeScope$runtime.recordDerivedStateValue(derivedState, currentRecord.getCurrentValue());
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        Object obj = this.observations.get(value);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (recomposeScopeImpl.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                                ScopeMap.m4205addimpl(this.observationsProcessed, value, recomposeScopeImpl);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
            if (recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                ScopeMap.m4205addimpl(this.observationsProcessed, value, recomposeScopeImpl2);
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(Object value) {
        synchronized (this.lock) {
            invalidateScopeOfLocked(value);
            Object obj = this.derivedStates.get(value);
            if (obj != null) {
                if (!(obj instanceof MutableScatterSet)) {
                    invalidateScopeOfLocked((DerivedState) obj);
                } else {
                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                    Object[] objArr = mutableScatterSet.elements;
                    long[] jArr = mutableScatterSet.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i = 0;
                        while (true) {
                            long j = jArr[i];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i2 = 8 - ((~(i - length)) >>> 31);
                                for (int i3 = 0; i3 < i2; i3++) {
                                    if ((255 & j) < 128) {
                                        invalidateScopeOfLocked((DerivedState) objArr[(i << 3) + i3]);
                                    }
                                    j >>= 8;
                                }
                                if (i2 != 8) {
                                    break;
                                }
                            }
                            if (i == length) {
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        synchronized (this.lock) {
            PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
            if (pausedCompositionImpl != null && !pausedCompositionImpl.isRecomposing$runtime()) {
                pausedCompositionImpl.markIncomplete$runtime();
                return false;
            }
            drainPendingModificationsForCompositionLocked();
            try {
                try {
                    boolean m4039recomposeaFTiNEg$runtime = this.composer.m4039recomposeaFTiNEg$runtime(m4041takeInvalidationsafanTW4(), this.shouldPause);
                    if (!m4039recomposeaFTiNEg$runtime) {
                        drainPendingModificationsLocked();
                    }
                    return m4039recomposeaFTiNEg$runtime;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    }
                    throw th;
                } catch (Throwable th3) {
                    abandonChanges();
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState state) {
        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
        try {
            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
            SlotWriter openWriter = state.getSlotTable().openWriter();
            try {
                ComposerKt.removeCurrentGroup(openWriter, this.rememberManager);
                Unit unit = Unit.INSTANCE;
                openWriter.close(true);
                rememberEventDispatcher.dispatchRememberObservers();
            } catch (Throwable th) {
                openWriter.close(false);
                throw th;
            }
        } finally {
            rememberEventDispatcher.clear();
        }
    }

    /* JADX WARN: Finally extract failed */
    private final void applyChangesInLocked(ChangeList changes) {
        RememberEventDispatcher rememberEventDispatcher;
        Object obj;
        Object obj2;
        int i;
        long[] jArr;
        int i2;
        int i3;
        long[] jArr2;
        int i4;
        int i5;
        char c;
        long j;
        int i6;
        boolean z;
        long[] jArr3;
        RecordingApplier<Object> pausableApplier$runtime;
        CompositionImpl compositionImpl = this;
        compositionImpl.rememberManager.prepare(compositionImpl.abandonSet, compositionImpl.composer.getErrorContext$runtime());
        try {
            if (changes.isEmpty()) {
                try {
                    if (compositionImpl.lateChanges.isEmpty() && compositionImpl.pendingPausedComposition == null) {
                        compositionImpl.rememberManager.dispatchAbandons();
                    }
                    return;
                } finally {
                }
            }
            Object beginSection = Trace.INSTANCE.beginSection("Compose:applyChanges");
            try {
                PausedCompositionImpl pausedCompositionImpl = compositionImpl.pendingPausedComposition;
                RecordingApplier<Object> recordingApplier = (pausedCompositionImpl == null || (pausableApplier$runtime = pausedCompositionImpl.getPausableApplier$runtime()) == null) ? compositionImpl.applier : pausableApplier$runtime;
                PausedCompositionImpl pausedCompositionImpl2 = compositionImpl.pendingPausedComposition;
                if (pausedCompositionImpl2 == null || (rememberEventDispatcher = pausedCompositionImpl2.getRememberManager()) == null) {
                    rememberEventDispatcher = compositionImpl.rememberManager;
                }
                recordingApplier.onBeginChanges();
                SlotWriter openWriter = compositionImpl.slotTable.openWriter();
                int i7 = 0;
                try {
                    changes.executeAndFlushAllPendingChanges(recordingApplier, openWriter, rememberEventDispatcher, compositionImpl.composer.getErrorContext$runtime());
                    Unit unit = Unit.INSTANCE;
                    int i8 = 1;
                    openWriter.close(true);
                    recordingApplier.onEndChanges();
                    Unit unit2 = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(beginSection);
                    compositionImpl.rememberManager.dispatchRememberObservers();
                    compositionImpl.rememberManager.dispatchSideEffects();
                    if (compositionImpl.pendingInvalidScopes) {
                        try {
                            Object beginSection2 = Trace.INSTANCE.beginSection("Compose:unobserve");
                            try {
                                compositionImpl.pendingInvalidScopes = false;
                                MutableScatterMap<Object, Object> mutableScatterMap = compositionImpl.observations;
                                long[] jArr4 = mutableScatterMap.metadata;
                                int length = jArr4.length - 2;
                                if (length >= 0) {
                                    int i9 = 0;
                                    while (true) {
                                        long j2 = jArr4[i9];
                                        char c2 = 7;
                                        long j3 = -9187201950435737472L;
                                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i10 = 8;
                                            int i11 = 8 - ((~(i9 - length)) >>> 31);
                                            int i12 = i7;
                                            while (i12 < i11) {
                                                if (((j2 & 255) < 128 ? i8 : i7) != 0) {
                                                    int i13 = (i9 << 3) + i12;
                                                    Object obj3 = mutableScatterMap.keys[i13];
                                                    Object obj4 = mutableScatterMap.values[i13];
                                                    if (obj4 instanceof MutableScatterSet) {
                                                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                                        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj4;
                                                        Object[] objArr = mutableScatterSet.elements;
                                                        long[] jArr5 = mutableScatterSet.metadata;
                                                        int length2 = jArr5.length - 2;
                                                        obj2 = beginSection2;
                                                        if (length2 >= 0) {
                                                            int i14 = 0;
                                                            while (true) {
                                                                try {
                                                                    long j4 = jArr5[i14];
                                                                    i4 = length;
                                                                    i5 = i9;
                                                                    c = 7;
                                                                    j = -9187201950435737472L;
                                                                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                        int i15 = 8 - ((~(i14 - length2)) >>> 31);
                                                                        int i16 = 0;
                                                                        while (i16 < i15) {
                                                                            if ((j4 & 255) < 128) {
                                                                                jArr3 = jArr4;
                                                                                int i17 = (i14 << 3) + i16;
                                                                                if (!((RecomposeScopeImpl) objArr[i17]).getValid()) {
                                                                                    mutableScatterSet.removeElementAt(i17);
                                                                                }
                                                                            } else {
                                                                                jArr3 = jArr4;
                                                                            }
                                                                            j4 >>= 8;
                                                                            i16++;
                                                                            jArr4 = jArr3;
                                                                        }
                                                                        jArr2 = jArr4;
                                                                        i3 = 1;
                                                                        if (i15 != 8) {
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        jArr2 = jArr4;
                                                                        i3 = 1;
                                                                    }
                                                                    if (i14 == length2) {
                                                                        break;
                                                                    }
                                                                    i14++;
                                                                    length = i4;
                                                                    i9 = i5;
                                                                    jArr4 = jArr2;
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    obj = obj2;
                                                                    Trace.INSTANCE.endSection(obj);
                                                                    throw th;
                                                                }
                                                            }
                                                        } else {
                                                            jArr2 = jArr4;
                                                            i4 = length;
                                                            i5 = i9;
                                                            c = c2;
                                                            j = -9187201950435737472L;
                                                            i3 = 1;
                                                        }
                                                        z = mutableScatterSet.isEmpty();
                                                    } else {
                                                        obj2 = beginSection2;
                                                        jArr2 = jArr4;
                                                        i4 = length;
                                                        i5 = i9;
                                                        c = c2;
                                                        j = j3;
                                                        i3 = 1;
                                                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                                        z = !((RecomposeScopeImpl) obj4).getValid();
                                                    }
                                                    if (z) {
                                                        mutableScatterMap.removeValueAt(i13);
                                                    }
                                                    i6 = 8;
                                                } else {
                                                    obj2 = beginSection2;
                                                    i3 = i8;
                                                    jArr2 = jArr4;
                                                    i4 = length;
                                                    i5 = i9;
                                                    c = c2;
                                                    j = j3;
                                                    i6 = i10;
                                                }
                                                j2 >>= i6;
                                                i12++;
                                                i10 = i6;
                                                j3 = j;
                                                c2 = c;
                                                beginSection2 = obj2;
                                                length = i4;
                                                i9 = i5;
                                                jArr4 = jArr2;
                                                i8 = i3;
                                                i7 = 0;
                                            }
                                            obj2 = beginSection2;
                                            i = i8;
                                            jArr = jArr4;
                                            int i18 = length;
                                            int i19 = i9;
                                            if (i11 != i10) {
                                                break;
                                            }
                                            length = i18;
                                            i2 = i19;
                                        } else {
                                            obj2 = beginSection2;
                                            i = i8;
                                            jArr = jArr4;
                                            i2 = i9;
                                        }
                                        if (i2 == length) {
                                            break;
                                        }
                                        i9 = i2 + 1;
                                        i7 = 0;
                                        beginSection2 = obj2;
                                        jArr4 = jArr;
                                        i8 = i;
                                    }
                                } else {
                                    obj2 = beginSection2;
                                }
                                cleanUpDerivedStateObservations();
                                Unit unit3 = Unit.INSTANCE;
                                Trace.INSTANCE.endSection(obj2);
                            } catch (Throwable th2) {
                                th = th2;
                                obj = beginSection2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            compositionImpl = this;
                            try {
                                if (compositionImpl.lateChanges.isEmpty() && compositionImpl.pendingPausedComposition == null) {
                                    compositionImpl.rememberManager.dispatchAbandons();
                                }
                                throw th;
                            } finally {
                            }
                        }
                    }
                    try {
                        if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                            this.rememberManager.dispatchAbandons();
                        }
                    } finally {
                        this.rememberManager.clear();
                    }
                } catch (Throwable th4) {
                    openWriter.close(false);
                    throw th4;
                }
            } catch (Throwable th5) {
                Trace.INSTANCE.endSection(beginSection);
                throw th5;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    }
                    throw th;
                } catch (Throwable th3) {
                    abandonChanges();
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (this.lateChanges.isNotEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    }
                    throw th;
                } catch (Throwable th3) {
                    abandonChanges();
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        RememberEventDispatcher rememberEventDispatcher;
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime();
                if (!this.abandonSet.isEmpty()) {
                    rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } finally {
                    }
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } finally {
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    abandonChanges();
                    throw th2;
                }
            }
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super ScopeMap<RecomposeScopeImpl, Object>, ? extends T> block) {
        MutableScatterMap<Object, Object> m4041takeInvalidationsafanTW4 = m4041takeInvalidationsafanTW4();
        try {
            return (T) block.invoke(ScopeMap.m4208boximpl(m4041takeInvalidationsafanTW4));
        } catch (Throwable th) {
            this.invalidations = m4041takeInvalidationsafanTW4;
            throw th;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        if (!this.abandonSet.isEmpty()) {
            RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
            try {
                rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                rememberEventDispatcher.dispatchAbandons();
            } finally {
                rememberEventDispatcher.clear();
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        synchronized (this.lock) {
            for (Object obj : this.slotTable.getSlots()) {
                RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime();
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition to, int groupIndex, Function0<? extends R> block) {
        if (to != null && !Intrinsics.areEqual(to, this) && groupIndex >= 0) {
            this.invalidationDelegate = (CompositionImpl) to;
            this.invalidationDelegateGroup = groupIndex;
            try {
                return (R) block.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return (R) block.invoke();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public ShouldPauseCallback getAndSetShouldPauseCallback(ShouldPauseCallback shouldPause) {
        ShouldPauseCallback shouldPauseCallback = this.shouldPause;
        this.shouldPause = shouldPause;
        return shouldPauseCallback;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        CompositionImpl compositionImpl;
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (this.slotTable.ownsAnchor(anchor)) {
            if (!scope.getCanRecompose()) {
                return InvalidationResult.IGNORED;
            }
            InvalidationResult invalidateChecked = invalidateChecked(scope, anchor, instance);
            if (invalidateChecked != InvalidationResult.IGNORED) {
                CompositionObserver observer = observer();
                if (observer != null) {
                    observer.onScopeInvalidated(scope, instance);
                }
                GlobalCompositionObserver globalCompositionObserver = GlobalCompositionObserverKt.get_globalCompositionObserver();
                if (globalCompositionObserver != null) {
                    globalCompositionObserver.onScopeInvalidated(scope, instance);
                }
            }
            return invalidateChecked;
        }
        synchronized (this.lock) {
            compositionImpl = this.invalidationDelegate;
        }
        if (compositionImpl != null && compositionImpl.tryImminentInvalidation(scope, instance)) {
            return InvalidationResult.IMMINENT;
        }
        return InvalidationResult.IGNORED;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
        this.pendingInvalidScopes = true;
        CompositionObserver observer = observer();
        if (observer != null) {
            observer.onScopeDisposed(scope);
        }
        GlobalCompositionObserver globalCompositionObserver = GlobalCompositionObserverKt.get_globalCompositionObserver();
        if (globalCompositionObserver != null) {
            globalCompositionObserver.onScopeDisposed(scope);
        }
    }

    @Override // androidx.compose.runtime.CompositionServices
    public <T> T getCompositionService(CompositionServiceKey<T> key) {
        if (Intrinsics.areEqual(key, CompositionKt.getObservableCompositionServiceKey())) {
            return (T) this;
        }
        return null;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl scope, Object instance) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime(scope, instance);
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b3, code lost:
    
        if ((r5 == androidx.compose.runtime.ScopeInvalidated.INSTANCE) != false) goto L136;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba A[Catch: all -> 0x00db, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x0010, B:12:0x001f, B:14:0x0025, B:19:0x002b, B:20:0x0034, B:22:0x0038, B:23:0x0041, B:25:0x0049, B:27:0x004d, B:30:0x005b, B:32:0x006e, B:34:0x007a, B:38:0x008b, B:49:0x00ba, B:44:0x009f, B:59:0x00a9, B:61:0x00ac), top: B:3:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final InvalidationResult invalidateChecked(RecomposeScopeImpl scope, Anchor anchor, Object instance) {
        boolean z;
        int i;
        synchronized (this.lock) {
            CompositionImpl compositionImpl = this.invalidationDelegate;
            CompositionImpl compositionImpl2 = null;
            if (compositionImpl != null) {
                if (!this.slotTable.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                    compositionImpl = null;
                }
                compositionImpl2 = compositionImpl;
            }
            if (compositionImpl2 == null) {
                if (tryImminentInvalidation(scope, instance)) {
                    return InvalidationResult.IMMINENT;
                }
                if (instance == null) {
                    ScopeMap.m4222setimpl(this.invalidations, scope, ScopeInvalidated.INSTANCE);
                } else if (!(instance instanceof DerivedState)) {
                    ScopeMap.m4222setimpl(this.invalidations, scope, ScopeInvalidated.INSTANCE);
                } else {
                    Object obj = this.invalidations.get(scope);
                    if (obj != null) {
                        if (obj instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                            Object[] objArr = mutableScatterSet.elements;
                            long[] jArr = mutableScatterSet.metadata;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i2 = 0;
                                loop0: while (true) {
                                    long j = jArr[i2];
                                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i3 = 8;
                                        int i4 = 8 - ((~(i2 - length)) >>> 31);
                                        int i5 = 0;
                                        while (i5 < i4) {
                                            if ((j & 255) < 128) {
                                                if (objArr[(i2 << 3) + i5] == ScopeInvalidated.INSTANCE) {
                                                    break loop0;
                                                }
                                                i = 8;
                                            } else {
                                                i = i3;
                                            }
                                            j >>= i;
                                            i5++;
                                            i3 = i;
                                        }
                                        if (i4 != i3) {
                                            break;
                                        }
                                    }
                                    if (i2 == length) {
                                        break;
                                    }
                                    i2++;
                                }
                                z = true;
                            }
                        }
                        if (!z) {
                            ScopeMap.m4205addimpl(this.invalidations, scope, instance);
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
            if (compositionImpl2 != null) {
                return compositionImpl2.invalidateChecked(scope, anchor, instance);
            }
            this.parent.invalidate$runtime(this);
            return isComposing() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
        }
    }

    public final void removeObservation$runtime(Object instance, RecomposeScopeImpl scope) {
        ScopeMap.m4218removeimpl(this.observations, instance, scope);
    }

    public final void removeDerivedStateObservation$runtime(DerivedState<?> state) {
        if (ScopeMap.m4212containsimpl(this.observations, state)) {
            return;
        }
        ScopeMap.m4220removeScopeimpl(this.derivedStates, state);
    }

    /* renamed from: takeInvalidations-afanTW4 */
    private final MutableScatterMap<Object, Object> m4041takeInvalidationsafanTW4() {
        MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
        this.invalidations = ScopeMap.m4211constructorimpl$default(null, 1, null);
        return mutableScatterMap;
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable) {
        Object[] slots = slotTable.getSlots();
        ArrayList arrayList = new ArrayList();
        for (Object obj : slots) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList2.get(i);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && !slotTable.slotsOf$runtime(anchor.toIndexFor(slotTable)).contains(recomposeScopeImpl2)) {
                PreconditionsKt.throwIllegalStateException("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + ArraysKt.indexOf(slotTable.getSlots(), recomposeScopeImpl2));
            }
        }
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> block) {
        try {
            T t = (T) block.invoke();
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return t;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (!this.abandonSet.isEmpty()) {
                RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                try {
                    rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                    rememberEventDispatcher.dispatchAbandons();
                } finally {
                    InlineMarker.finallyStart(1);
                    rememberEventDispatcher.clear();
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    private final CompositionObserver observer() {
        return this.observerHolder.current();
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void deactivate() {
        synchronized (this.lock) {
            if (!(this.pendingPausedComposition == null)) {
                PreconditionsKt.throwIllegalStateException("Deactivate is not supported while pausable composition is in progress");
            }
            boolean z = this.slotTable.getGroupsSize() > 0;
            if (z || (!this.abandonSet.isEmpty())) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:deactivate");
                try {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        if (z) {
                            this.applier.onBeginChanges();
                            SlotWriter openWriter = this.slotTable.openWriter();
                            try {
                                ComposerKt.deactivateCurrentGroup(openWriter, this.rememberManager);
                                Unit unit = Unit.INSTANCE;
                                openWriter.close(true);
                                this.applier.onEndChanges();
                                rememberEventDispatcher.dispatchRememberObservers();
                            } catch (Throwable th) {
                                openWriter.close(false);
                                throw th;
                            }
                        }
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                        Unit unit2 = Unit.INSTANCE;
                    } catch (Throwable th2) {
                        rememberEventDispatcher.clear();
                        throw th2;
                    }
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
            ScopeMap.m4209clearimpl(this.observations);
            ScopeMap.m4209clearimpl(this.derivedStates);
            ScopeMap.m4209clearimpl(this.invalidations);
            this.changes.clear();
            this.lateChanges.clear();
            this.composer.deactivate$runtime();
            this.state = 1;
            Unit unit3 = Unit.INSTANCE;
        }
    }

    public final int composerStacksSizes$runtime() {
        return this.composer.stacksSize$runtime();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        return true;
     */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean observesAnyOf(Set<? extends Object> values) {
        if (values instanceof ScatterSetWrapper) {
            ScatterSet set$runtime = ((ScatterSetWrapper) values).getSet$runtime();
            Object[] objArr = set$runtime.elements;
            long[] jArr = set$runtime.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                loop0: while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                Object obj = objArr[(i << 3) + i3];
                                if (ScopeMap.m4212containsimpl(this.observations, obj) || ScopeMap.m4212containsimpl(this.derivedStates, obj)) {
                                    break loop0;
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        } else {
            for (Object obj2 : values) {
                if (ScopeMap.m4212containsimpl(this.observations, obj2) || ScopeMap.m4212containsimpl(this.derivedStates, obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void addPendingInvalidationsLocked(Set<? extends Object> values, boolean forgetConditionalScopes) {
        String str;
        long[] jArr;
        int i;
        String str2;
        long[] jArr2;
        int i2;
        long j;
        int i3;
        boolean contains;
        Object[] objArr;
        Object[] objArr2;
        String str3;
        long[] jArr3;
        int i4;
        String str4;
        long[] jArr4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        long[] jArr5;
        Object[] objArr3;
        long[] jArr6;
        Object[] objArr4;
        Object[] objArr5;
        Object[] objArr6;
        long j2;
        int i9;
        int i10;
        int i11;
        char c = 7;
        long j3 = -9187201950435737472L;
        int i12 = 8;
        if (values instanceof ScatterSetWrapper) {
            ScatterSet set$runtime = ((ScatterSetWrapper) values).getSet$runtime();
            Object[] objArr7 = set$runtime.elements;
            long[] jArr7 = set$runtime.metadata;
            int length = jArr7.length - 2;
            if (length >= 0) {
                int i13 = 0;
                while (true) {
                    long j4 = jArr7[i13];
                    if ((((~j4) << 7) & j4 & j3) != j3) {
                        int i14 = 8 - ((~(i13 - length)) >>> 31);
                        int i15 = 0;
                        while (i15 < i14) {
                            if ((j4 & 255) < 128) {
                                Object obj = objArr7[(i13 << 3) + i15];
                                if (obj instanceof RecomposeScopeImpl) {
                                    ((RecomposeScopeImpl) obj).invalidateForResult(null);
                                    objArr6 = objArr7;
                                    j2 = j4;
                                    i9 = i14;
                                    i10 = i15;
                                } else {
                                    addPendingInvalidationsLocked(obj, forgetConditionalScopes);
                                    Object obj2 = this.derivedStates.get(obj);
                                    if (obj2 != null) {
                                        if (obj2 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                            Object[] objArr8 = mutableScatterSet.elements;
                                            long[] jArr8 = mutableScatterSet.metadata;
                                            int length2 = jArr8.length - 2;
                                            if (length2 >= 0) {
                                                i9 = i14;
                                                i10 = i15;
                                                int i16 = 0;
                                                while (true) {
                                                    long j5 = jArr8[i16];
                                                    objArr6 = objArr7;
                                                    j2 = j4;
                                                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i17 = 8 - ((~(i16 - length2)) >>> 31);
                                                        for (int i18 = 0; i18 < i17; i18++) {
                                                            if ((j5 & 255) < 128) {
                                                                addPendingInvalidationsLocked((DerivedState) objArr8[(i16 << 3) + i18], forgetConditionalScopes);
                                                            }
                                                            j5 >>= 8;
                                                        }
                                                        if (i17 != 8) {
                                                            break;
                                                        }
                                                    }
                                                    if (i16 == length2) {
                                                        break;
                                                    }
                                                    i16++;
                                                    objArr7 = objArr6;
                                                    j4 = j2;
                                                }
                                            }
                                        } else {
                                            objArr6 = objArr7;
                                            j2 = j4;
                                            i9 = i14;
                                            i10 = i15;
                                            addPendingInvalidationsLocked((DerivedState) obj2, forgetConditionalScopes);
                                        }
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    objArr6 = objArr7;
                                    j2 = j4;
                                    i9 = i14;
                                    i10 = i15;
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                i11 = 8;
                            } else {
                                objArr6 = objArr7;
                                j2 = j4;
                                i9 = i14;
                                i10 = i15;
                                i11 = i12;
                            }
                            j4 = j2 >> i11;
                            i15 = i10 + 1;
                            i14 = i9;
                            i12 = i11;
                            objArr7 = objArr6;
                        }
                        objArr5 = objArr7;
                        if (i14 != i12) {
                            break;
                        }
                    } else {
                        objArr5 = objArr7;
                    }
                    if (i13 == length) {
                        break;
                    }
                    i13++;
                    objArr7 = objArr5;
                    j3 = -9187201950435737472L;
                    i12 = 8;
                }
            }
        } else {
            for (Object obj3 : values) {
                if (obj3 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj3).invalidateForResult(null);
                } else {
                    addPendingInvalidationsLocked(obj3, forgetConditionalScopes);
                    Object obj4 = this.derivedStates.get(obj3);
                    if (obj4 != null) {
                        if (obj4 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj4;
                            Object[] objArr9 = mutableScatterSet2.elements;
                            long[] jArr9 = mutableScatterSet2.metadata;
                            int length3 = jArr9.length - 2;
                            if (length3 >= 0) {
                                int i19 = 0;
                                while (true) {
                                    long j6 = jArr9[i19];
                                    if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i20 = 8 - ((~(i19 - length3)) >>> 31);
                                        for (int i21 = 0; i21 < i20; i21++) {
                                            if ((j6 & 255) < 128) {
                                                addPendingInvalidationsLocked((DerivedState) objArr9[(i19 << 3) + i21], forgetConditionalScopes);
                                            }
                                            j6 >>= 8;
                                        }
                                        if (i20 != 8) {
                                            break;
                                        }
                                    }
                                    if (i19 == length3) {
                                        break;
                                    } else {
                                        i19++;
                                    }
                                }
                            }
                        } else {
                            addPendingInvalidationsLocked((DerivedState) obj4, forgetConditionalScopes);
                        }
                    }
                    Unit unit3 = Unit.INSTANCE;
                }
            }
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet3 = this.conditionallyInvalidatedScopes;
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet4 = this.invalidatedScopes;
        String str5 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>";
        if (!forgetConditionalScopes || !mutableScatterSet3.isNotEmpty()) {
            String str6 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>";
            if (mutableScatterSet4.isNotEmpty()) {
                MutableScatterMap<Object, Object> mutableScatterMap = this.observations;
                long[] jArr10 = mutableScatterMap.metadata;
                int length4 = jArr10.length - 2;
                if (length4 >= 0) {
                    int i22 = 0;
                    while (true) {
                        long j7 = jArr10[i22];
                        if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i23 = 8 - ((~(i22 - length4)) >>> 31);
                            int i24 = 0;
                            while (i24 < i23) {
                                if ((j7 & 255) < 128) {
                                    int i25 = (i22 << 3) + i24;
                                    Object obj5 = mutableScatterMap.keys[i25];
                                    Object obj6 = mutableScatterMap.values[i25];
                                    if (obj6 instanceof MutableScatterSet) {
                                        String str7 = str6;
                                        Intrinsics.checkNotNull(obj6, str7);
                                        MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj6;
                                        Object[] objArr10 = mutableScatterSet5.elements;
                                        long[] jArr11 = mutableScatterSet5.metadata;
                                        int length5 = jArr11.length - 2;
                                        jArr2 = jArr10;
                                        if (length5 >= 0) {
                                            i3 = i23;
                                            str2 = str7;
                                            int i26 = 0;
                                            while (true) {
                                                long j8 = jArr11[i26];
                                                i2 = i22;
                                                j = j7;
                                                if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i27 = 8 - ((~(i26 - length5)) >>> 31);
                                                    int i28 = 0;
                                                    while (i28 < i27) {
                                                        if ((j8 & 255) < 128) {
                                                            int i29 = (i26 << 3) + i28;
                                                            objArr2 = objArr10;
                                                            if (mutableScatterSet4.contains((RecomposeScopeImpl) objArr10[i29])) {
                                                                mutableScatterSet5.removeElementAt(i29);
                                                            }
                                                        } else {
                                                            objArr2 = objArr10;
                                                        }
                                                        j8 >>= 8;
                                                        i28++;
                                                        objArr10 = objArr2;
                                                    }
                                                    objArr = objArr10;
                                                    if (i27 != 8) {
                                                        break;
                                                    }
                                                } else {
                                                    objArr = objArr10;
                                                }
                                                if (i26 == length5) {
                                                    break;
                                                }
                                                i26++;
                                                i22 = i2;
                                                j7 = j;
                                                objArr10 = objArr;
                                            }
                                        } else {
                                            i2 = i22;
                                            j = j7;
                                            i3 = i23;
                                            str2 = str7;
                                        }
                                        contains = mutableScatterSet5.isEmpty();
                                    } else {
                                        str2 = str6;
                                        jArr2 = jArr10;
                                        i2 = i22;
                                        j = j7;
                                        i3 = i23;
                                        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                        contains = mutableScatterSet4.contains((RecomposeScopeImpl) obj6);
                                    }
                                    if (contains) {
                                        mutableScatterMap.removeValueAt(i25);
                                    }
                                } else {
                                    str2 = str6;
                                    jArr2 = jArr10;
                                    i2 = i22;
                                    j = j7;
                                    i3 = i23;
                                }
                                j7 = j >> 8;
                                i24++;
                                i23 = i3;
                                i22 = i2;
                                jArr10 = jArr2;
                                str6 = str2;
                            }
                            str = str6;
                            jArr = jArr10;
                            int i30 = i22;
                            if (i23 != 8) {
                                break;
                            } else {
                                i = i30;
                            }
                        } else {
                            str = str6;
                            jArr = jArr10;
                            i = i22;
                        }
                        if (i == length4) {
                            break;
                        }
                        i22 = i + 1;
                        jArr10 = jArr;
                        str6 = str;
                    }
                }
                cleanUpDerivedStateObservations();
                mutableScatterSet4.clear();
                return;
            }
            return;
        }
        MutableScatterMap<Object, Object> mutableScatterMap2 = this.observations;
        long[] jArr12 = mutableScatterMap2.metadata;
        int length6 = jArr12.length - 2;
        if (length6 >= 0) {
            int i31 = 0;
            while (true) {
                long j9 = jArr12[i31];
                if ((((~j9) << c) & j9 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i32 = 8 - ((~(i31 - length6)) >>> 31);
                    int i33 = 0;
                    while (i33 < i32) {
                        if ((j9 & 255) < 128) {
                            int i34 = (i31 << 3) + i33;
                            Object obj7 = mutableScatterMap2.keys[i34];
                            Object obj8 = mutableScatterMap2.values[i34];
                            if (obj8 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj8, str5);
                                MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj8;
                                Object[] objArr11 = mutableScatterSet6.elements;
                                jArr4 = jArr12;
                                long[] jArr13 = mutableScatterSet6.metadata;
                                str4 = str5;
                                int length7 = jArr13.length - 2;
                                i5 = length6;
                                i6 = i31;
                                if (length7 >= 0) {
                                    int i35 = 0;
                                    while (true) {
                                        long j10 = jArr13[i35];
                                        i7 = i32;
                                        i8 = i33;
                                        if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i36 = 8 - ((~(i35 - length7)) >>> 31);
                                            int i37 = 0;
                                            while (i37 < i36) {
                                                if ((j10 & 255) < 128) {
                                                    jArr6 = jArr13;
                                                    int i38 = (i35 << 3) + i37;
                                                    objArr4 = objArr11;
                                                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr11[i38];
                                                    if (mutableScatterSet3.contains(recomposeScopeImpl) || mutableScatterSet4.contains(recomposeScopeImpl)) {
                                                        mutableScatterSet6.removeElementAt(i38);
                                                    }
                                                } else {
                                                    jArr6 = jArr13;
                                                    objArr4 = objArr11;
                                                }
                                                j10 >>= 8;
                                                i37++;
                                                jArr13 = jArr6;
                                                objArr11 = objArr4;
                                            }
                                            jArr5 = jArr13;
                                            objArr3 = objArr11;
                                            if (i36 != 8) {
                                                break;
                                            }
                                        } else {
                                            jArr5 = jArr13;
                                            objArr3 = objArr11;
                                        }
                                        if (i35 == length7) {
                                            break;
                                        }
                                        i35++;
                                        i32 = i7;
                                        i33 = i8;
                                        jArr13 = jArr5;
                                        objArr11 = objArr3;
                                    }
                                } else {
                                    i7 = i32;
                                    i8 = i33;
                                }
                                z = mutableScatterSet6.isEmpty();
                            } else {
                                str4 = str5;
                                jArr4 = jArr12;
                                i5 = length6;
                                i6 = i31;
                                i7 = i32;
                                i8 = i33;
                                Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj8;
                                z = mutableScatterSet3.contains(recomposeScopeImpl2) || mutableScatterSet4.contains(recomposeScopeImpl2);
                            }
                            if (z) {
                                mutableScatterMap2.removeValueAt(i34);
                            }
                        } else {
                            str4 = str5;
                            jArr4 = jArr12;
                            i5 = length6;
                            i6 = i31;
                            i7 = i32;
                            i8 = i33;
                        }
                        j9 >>= 8;
                        i33 = i8 + 1;
                        str5 = str4;
                        length6 = i5;
                        jArr12 = jArr4;
                        i31 = i6;
                        i32 = i7;
                    }
                    str3 = str5;
                    jArr3 = jArr12;
                    int i39 = length6;
                    int i40 = i31;
                    if (i32 != 8) {
                        break;
                    }
                    length6 = i39;
                    i4 = i40;
                } else {
                    str3 = str5;
                    jArr3 = jArr12;
                    i4 = i31;
                }
                if (i4 == length6) {
                    break;
                }
                i31 = i4 + 1;
                c = 7;
                str5 = str3;
                jArr12 = jArr3;
            }
        }
        mutableScatterSet3.clear();
        cleanUpDerivedStateObservations();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        int size = references.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual(((MovableContentStateReference) references.get(i).getFirst()).getComposition(), this)) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } catch (Throwable th2) {
                        rememberEventDispatcher.clear();
                        throw th2;
                    }
                }
                throw th;
            } catch (Throwable th3) {
                abandonChanges();
                throw th3;
            }
        }
    }

    private final <T> T guardChanges(Function0<? extends T> block) {
        try {
            try {
                T t = (T) block.invoke();
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                return t;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        InlineMarker.finallyStart(1);
                        rememberEventDispatcher.clear();
                        InlineMarker.finallyEnd(1);
                    } catch (Throwable th2) {
                        InlineMarker.finallyStart(1);
                        rememberEventDispatcher.clear();
                        InlineMarker.finallyEnd(1);
                        throw th2;
                    }
                }
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } catch (Throwable th3) {
            abandonChanges();
            throw th3;
        }
    }
}
