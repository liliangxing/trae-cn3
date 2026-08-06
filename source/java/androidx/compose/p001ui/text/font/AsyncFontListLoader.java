package androidx.compose.p001ui.text.font;

import androidx.compose.p001ui.text.font.TypefaceResult;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.YieldKt;

/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010!\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u0004\u0018\u00010\u0002*\u00020\u0005H\u0080@¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00028V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Landroidx/compose/ui/text/font/AsyncFontListLoader;", "Landroidx/compose/runtime/State;", "", "fontList", "", "Landroidx/compose/ui/text/font/Font;", "initialType", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "onCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "<init>", "(Ljava/util/List;Ljava/lang/Object;Landroidx/compose/ui/text/font/TypefaceRequest;Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/font/PlatformFontLoader;)V", "<set-?>", StrategyConstants.VALUE, "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "cacheable", "", "getCacheable$ui_text", "()Z", "setCacheable$ui_text", "(Z)V", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWithTimeoutOrNull", "loadWithTimeoutOrNull$ui_text", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AsyncFontListLoader implements State<Object> {
    public static final int $stable = 0;
    private final AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable = true;
    private final List<Font> fontList;
    private final Function1<TypefaceResult.Immutable, Unit> onCompletion;
    private final PlatformFontLoader platformFontLoader;
    private final TypefaceRequest typefaceRequest;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncFontListLoader(List<? extends Font> list, Object obj, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, Function1<? super TypefaceResult.Immutable, Unit> function1, PlatformFontLoader platformFontLoader) {
        this.fontList = list;
        this.typefaceRequest = typefaceRequest;
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.onCompletion = function1;
        this.platformFontLoader = platformFontLoader;
        this.value = SnapshotStateKt.mutableStateOf$default(obj, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private void setValue(Object obj) {
        this.value.setValue(obj);
    }

    public Object getValue() {
        return this.value.getValue();
    }

    /* renamed from: getCacheable$ui_text, reason: from getter */
    public final boolean getCacheable() {
        return this.cacheable;
    }

    public final void setCacheable$ui_text(boolean z) {
        this.cacheable = z;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|(1:(1:(6:11|12|13|14|15|(3:20|21|(5:23|24|25|26|(1:28)(5:29|(3:31|32|33)(6:38|39|(1:41)|14|15|(2:17|18)(0))|35|36|37))(3:45|15|(0)(0)))(0))(2:49|50))(7:51|52|53|(0)(0)|35|36|37))(4:54|55|56|(0)(0))))|59|6|7|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0126, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0127, code lost:
    
        r14 = r20;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b2 A[Catch: all -> 0x00fa, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00fa, blocks: (B:31:0x00b2, B:39:0x00e6), top: B:38:0x00e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00f4 -> B:14:0x00f7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0100 -> B:15:0x0102). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object load(Continuation<? super Unit> continuation) {
        AsyncFontListLoader$load$1 asyncFontListLoader$load$1;
        int i;
        AsyncFontListLoader asyncFontListLoader;
        List<Font> list;
        int size;
        int i2;
        Font font;
        List<Font> list2;
        int i3;
        Font font2;
        AsyncFontListLoader asyncFontListLoader2;
        Object runCached;
        if (continuation instanceof AsyncFontListLoader$load$1) {
            asyncFontListLoader$load$1 = (AsyncFontListLoader$load$1) continuation;
            if ((asyncFontListLoader$load$1.label & Integer.MIN_VALUE) != 0) {
                asyncFontListLoader$load$1.label -= Integer.MIN_VALUE;
                Object obj = asyncFontListLoader$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = asyncFontListLoader$load$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    list = this.fontList;
                    size = list.size();
                    asyncFontListLoader = this;
                    i2 = 0;
                    if (i2 >= size) {
                    }
                } else {
                    if (i == 1) {
                        size = asyncFontListLoader$load$1.I$1;
                        i3 = asyncFontListLoader$load$1.I$0;
                        Font font3 = (Font) asyncFontListLoader$load$1.L$1;
                        List<Font> list3 = (List) asyncFontListLoader$load$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        asyncFontListLoader = this;
                        font = font3;
                        list2 = list3;
                        if (obj == null) {
                        }
                        th = th;
                        boolean isActive = JobKt.isActive(asyncFontListLoader$load$1.getContext());
                        asyncFontListLoader.cacheable = false;
                        asyncFontListLoader.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader.getValue(), isActive));
                        throw th;
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    size = asyncFontListLoader$load$1.I$1;
                    i3 = asyncFontListLoader$load$1.I$0;
                    list2 = (List) asyncFontListLoader$load$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    asyncFontListLoader = this;
                    i2 = i3;
                    list = list2;
                    i2++;
                    if (i2 >= size) {
                        try {
                            font2 = list.get(i2);
                        } catch (Throwable th) {
                            th = th;
                        }
                        if (FontLoadingStrategy.m2224equalsimpl0(font2.getLoadingStrategy(), FontLoadingStrategy.INSTANCE.m2228getAsyncPKNRLFQ())) {
                            try {
                                AsyncTypefaceCache asyncTypefaceCache = asyncFontListLoader.asyncTypefaceCache;
                                PlatformFontLoader platformFontLoader = asyncFontListLoader.platformFontLoader;
                                AsyncFontListLoader$load$2$typeface$1 asyncFontListLoader$load$2$typeface$1 = new AsyncFontListLoader$load$2$typeface$1(asyncFontListLoader, font2, null);
                                asyncFontListLoader$load$1.L$0 = list;
                                asyncFontListLoader$load$1.L$1 = font2;
                                asyncFontListLoader$load$1.I$0 = i2;
                                asyncFontListLoader$load$1.I$1 = size;
                                asyncFontListLoader$load$1.label = 1;
                                runCached = asyncTypefaceCache.runCached(font2, platformFontLoader, false, asyncFontListLoader$load$2$typeface$1, asyncFontListLoader$load$1);
                            } catch (Throwable th2) {
                                th = th2;
                                asyncFontListLoader = asyncFontListLoader2;
                            }
                            asyncFontListLoader2 = asyncFontListLoader;
                            if (runCached == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            list2 = list;
                            obj = runCached;
                            i3 = i2;
                            font = font2;
                            asyncFontListLoader = asyncFontListLoader2;
                            if (obj == null) {
                                asyncFontListLoader.setValue(FontSynthesis_androidKt.m2258synthesizeTypefaceFxwP2eA(asyncFontListLoader.typefaceRequest.m2283getFontSynthesisGVVA2EU(), obj, font, asyncFontListLoader.typefaceRequest.getFontWeight(), asyncFontListLoader.typefaceRequest.m2282getFontStyle_LCdwA()));
                                Unit unit = Unit.INSTANCE;
                                boolean isActive2 = JobKt.isActive(asyncFontListLoader$load$1.getContext());
                                asyncFontListLoader.cacheable = false;
                                asyncFontListLoader.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader.getValue(), isActive2));
                                return unit;
                            }
                            try {
                                asyncFontListLoader$load$1.L$0 = list2;
                                asyncFontListLoader$load$1.L$1 = null;
                                asyncFontListLoader$load$1.I$0 = i3;
                                asyncFontListLoader$load$1.I$1 = size;
                                asyncFontListLoader$load$1.label = 2;
                                if (YieldKt.yield(asyncFontListLoader$load$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                i2 = i3;
                                list = list2;
                                i2++;
                                if (i2 >= size) {
                                    boolean isActive3 = JobKt.isActive(asyncFontListLoader$load$1.getContext());
                                    asyncFontListLoader.cacheable = false;
                                    asyncFontListLoader.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader.getValue(), isActive3));
                                    return Unit.INSTANCE;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            th = th3;
                            boolean isActive4 = JobKt.isActive(asyncFontListLoader$load$1.getContext());
                            asyncFontListLoader.cacheable = false;
                            asyncFontListLoader.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader.getValue(), isActive4));
                            throw th;
                        }
                        i2++;
                        if (i2 >= size) {
                        }
                    }
                }
            }
        }
        asyncFontListLoader$load$1 = new AsyncFontListLoader$load$1(this, continuation);
        Object obj2 = asyncFontListLoader$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = asyncFontListLoader$load$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadWithTimeoutOrNull$ui_text(Font font, Continuation<Object> continuation) {
        AsyncFontListLoader$loadWithTimeoutOrNull$1 asyncFontListLoader$loadWithTimeoutOrNull$1;
        int i;
        Object obj;
        try {
            if (continuation instanceof AsyncFontListLoader$loadWithTimeoutOrNull$1) {
                asyncFontListLoader$loadWithTimeoutOrNull$1 = (AsyncFontListLoader$loadWithTimeoutOrNull$1) continuation;
                if ((asyncFontListLoader$loadWithTimeoutOrNull$1.label & Integer.MIN_VALUE) != 0) {
                    asyncFontListLoader$loadWithTimeoutOrNull$1.label -= Integer.MIN_VALUE;
                    Object obj2 = asyncFontListLoader$loadWithTimeoutOrNull$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = asyncFontListLoader$loadWithTimeoutOrNull$1.label;
                    obj = null;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        AsyncFontListLoader$loadWithTimeoutOrNull$2 asyncFontListLoader$loadWithTimeoutOrNull$2 = new AsyncFontListLoader$loadWithTimeoutOrNull$2(this, font, null);
                        asyncFontListLoader$loadWithTimeoutOrNull$1.L$0 = font;
                        asyncFontListLoader$loadWithTimeoutOrNull$1.label = 1;
                        obj2 = TimeoutKt.withTimeoutOrNull(15000L, asyncFontListLoader$loadWithTimeoutOrNull$2, asyncFontListLoader$loadWithTimeoutOrNull$1);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        font = (Font) asyncFontListLoader$loadWithTimeoutOrNull$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    obj = obj2;
                    return obj;
                }
            }
            if (i != 0) {
            }
            obj = obj2;
            return obj;
        } catch (CancellationException e) {
            if (JobKt.isActive(asyncFontListLoader$loadWithTimeoutOrNull$1.getContext())) {
                return obj;
            }
            throw e;
        } catch (Exception e2) {
            CoroutineExceptionHandler coroutineExceptionHandler = asyncFontListLoader$loadWithTimeoutOrNull$1.getContext().get(CoroutineExceptionHandler.Key);
            if (coroutineExceptionHandler == null) {
                return obj;
            }
            coroutineExceptionHandler.handleException(asyncFontListLoader$loadWithTimeoutOrNull$1.getContext(), new IllegalStateException("Unable to load font " + font, e2));
            return obj;
        }
        asyncFontListLoader$loadWithTimeoutOrNull$1 = new AsyncFontListLoader$loadWithTimeoutOrNull$1(this, continuation);
        Object obj22 = asyncFontListLoader$loadWithTimeoutOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = asyncFontListLoader$loadWithTimeoutOrNull$1.label;
        obj = null;
    }
}
