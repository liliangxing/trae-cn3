package androidx.compose.foundation.text.selection;

import android.app.RemoteAction;
import android.content.Context;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope_androidKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: PlatformSelectionBehaviors.android.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0096@¢\u0006\u0004\b\"\u0010#J \u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0096@¢\u0006\u0004\b&\u0010#J(\u0010'\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b)\u0010*J<\u0010-\u001a\u00020%*\u00020.2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020%00¢\u0006\u0002\b1H\u0000¢\u0006\u0004\b2\u00103J\u001f\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b6\u00107J?\u00108\u001a\u0004\u0018\u0001H9\"\u0004\b\u0000\u001092'\u0010:\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H90<\u0012\u0006\u0012\u0004\u0018\u00010,0;¢\u0006\u0002\b1H\u0082@¢\u0006\u0002\u0010=R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviorsImpl;", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "context", "Landroid/content/Context;", "selectedTextType", "Landroidx/compose/foundation/text/selection/SelectedTextType;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Landroid/content/Context;Landroidx/compose/foundation/text/selection/SelectedTextType;Landroidx/compose/ui/text/intl/LocaleList;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "textClassificationSession", "Landroid/view/textclassifier/TextClassifier;", "<set-?>", "Landroidx/compose/foundation/text/selection/TextClassificationResult;", "textClassificationResult", "getTextClassificationResult", "()Landroidx/compose/foundation/text/selection/TextClassificationResult;", "setTextClassificationResult", "(Landroidx/compose/foundation/text/selection/TextClassificationResult;)V", "textClassificationResult$delegate", "Landroidx/compose/runtime/MutableState;", "androidLocalList", "Landroid/os/LocaleList;", "getAndroidLocalList", "()Landroid/os/LocaleList;", "suggestSelectionForLongPressOrDoubleClick", "Landroidx/compose/ui/text/TextRange;", "text", "", "selection", "suggestSelectionForLongPressOrDoubleClick-pYaCw-w", "(Ljava/lang/CharSequence;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onShowContextMenu", "", "onShowContextMenu-Sb-Bc2M", "classifyText", "textClassifier", "classifyText-M8tDOmk", "(Ljava/lang/CharSequence;JLandroid/view/textclassifier/TextClassifier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AssistantItemKey", "", "addSmartSelectionTextContextMenuItems", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "child", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "addSmartSelectionTextContextMenuItems-YmzfRxQ$foundation_release", "(Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;Ljava/lang/CharSequence;JLkotlin/jvm/functions/Function1;)V", "tryGetTextClassification", "Landroid/view/textclassifier/TextClassification;", "tryGetTextClassification-FDrldGo", "(Ljava/lang/CharSequence;J)Landroid/view/textclassifier/TextClassification;", "requireTextClassificationSession", "T", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PlatformSelectionBehaviorsImpl implements PlatformSelectionBehaviors {
    public static final int $stable = 8;
    private final Object AssistantItemKey;
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final LocaleList localeList;
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);
    private final SelectedTextType selectedTextType;

    /* renamed from: textClassificationResult$delegate, reason: from kotlin metadata */
    private final MutableState textClassificationResult;
    private TextClassifier textClassificationSession;

    public PlatformSelectionBehaviorsImpl(CoroutineContext coroutineContext, Context context, SelectedTextType selectedTextType, LocaleList localeList) {
        MutableState mutableStateOf$default;
        this.coroutineContext = coroutineContext;
        this.context = context;
        this.selectedTextType = selectedTextType;
        this.localeList = localeList;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.textClassificationResult = mutableStateOf$default;
        this.AssistantItemKey = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TextClassificationResult getTextClassificationResult() {
        return (TextClassificationResult) this.textClassificationResult.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextClassificationResult(TextClassificationResult textClassificationResult) {
        this.textClassificationResult.setValue(textClassificationResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final android.os.LocaleList getAndroidLocalList() {
        android.os.LocaleList androidLocaleList;
        LocaleList localeList = this.localeList;
        return (localeList == null || (androidLocaleList = TextClassifierHelperMethods.INSTANCE.toAndroidLocaleList(localeList)) == null) ? new android.os.LocaleList(Locale.Companion.getCurrent().getPlatformLocale()) : androidLocaleList;
    }

    @Override // androidx.compose.foundation.text.selection.PlatformSelectionBehaviors
    /* renamed from: suggestSelectionForLongPressOrDoubleClick-pYaCw-w */
    public Object mo2061suggestSelectionForLongPressOrDoubleClickpYaCww(CharSequence charSequence, long j, Continuation<? super TextRange> continuation) {
        if ((charSequence.length() == 0) || TextRange.getCollapsed-impl(j)) {
            return null;
        }
        return requireTextClassificationSession(new C0513xcb45b7e0(charSequence, j, this, null), continuation);
    }

    @Override // androidx.compose.foundation.text.selection.PlatformSelectionBehaviors
    /* renamed from: onShowContextMenu-Sb-Bc2M */
    public Object mo2060onShowContextMenuSbBc2M(CharSequence charSequence, long j, Continuation<? super Unit> continuation) {
        if ((charSequence.length() == 0) || TextRange.getCollapsed-impl(j)) {
            return Unit.INSTANCE;
        }
        return requireTextClassificationSession(new PlatformSelectionBehaviorsImpl$onShowContextMenu$2(this, charSequence, j, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088 A[Catch: all -> 0x00ea, TryCatch #1 {all -> 0x00ea, blocks: (B:24:0x0081, B:26:0x0088, B:30:0x0092, B:33:0x0098), top: B:23:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092 A[Catch: all -> 0x00ea, TRY_LEAVE, TryCatch #1 {all -> 0x00ea, blocks: (B:24:0x0081, B:26:0x0088, B:30:0x0092, B:33:0x0098), top: B:23:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0098 A[Catch: all -> 0x00ea, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00ea, blocks: (B:24:0x0081, B:26:0x0088, B:30:0x0092, B:33:0x0098), top: B:23:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: classifyText-M8tDOmk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m2063classifyTextM8tDOmk(CharSequence charSequence, long j, TextClassifier textClassifier, Continuation<? super Unit> continuation) {
        PlatformSelectionBehaviorsImpl$classifyText$1 platformSelectionBehaviorsImpl$classifyText$1;
        int i;
        boolean z;
        Mutex mutex;
        CharSequence charSequence2;
        TextClassifier textClassifier2;
        long j2;
        Mutex mutex2;
        TextClassificationResult textClassificationResult;
        TextClassification textClassification;
        long j3;
        CharSequence charSequence3;
        boolean m2069canReuseh5sm0ck;
        try {
            if (continuation instanceof PlatformSelectionBehaviorsImpl$classifyText$1) {
                platformSelectionBehaviorsImpl$classifyText$1 = (PlatformSelectionBehaviorsImpl$classifyText$1) continuation;
                if ((platformSelectionBehaviorsImpl$classifyText$1.label & Integer.MIN_VALUE) != 0) {
                    platformSelectionBehaviorsImpl$classifyText$1.label -= Integer.MIN_VALUE;
                    Object obj = platformSelectionBehaviorsImpl$classifyText$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = platformSelectionBehaviorsImpl$classifyText$1.label;
                    z = true;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        platformSelectionBehaviorsImpl$classifyText$1.L$0 = charSequence;
                        platformSelectionBehaviorsImpl$classifyText$1.L$1 = textClassifier;
                        platformSelectionBehaviorsImpl$classifyText$1.L$2 = mutex;
                        platformSelectionBehaviorsImpl$classifyText$1.J$0 = j;
                        platformSelectionBehaviorsImpl$classifyText$1.label = 1;
                        if (mutex.lock((Object) null, platformSelectionBehaviorsImpl$classifyText$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        charSequence2 = charSequence;
                        textClassifier2 = textClassifier;
                        j2 = j;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            long j4 = platformSelectionBehaviorsImpl$classifyText$1.J$0;
                            mutex2 = (Mutex) platformSelectionBehaviorsImpl$classifyText$1.L$2;
                            TextClassification textClassification2 = (TextClassification) platformSelectionBehaviorsImpl$classifyText$1.L$1;
                            CharSequence charSequence4 = (CharSequence) platformSelectionBehaviorsImpl$classifyText$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            charSequence3 = charSequence4;
                            j3 = j4;
                            textClassification = textClassification2;
                            try {
                                setTextClassificationResult(new TextClassificationResult(charSequence3, j3, textClassification, null));
                                Unit unit = Unit.INSTANCE;
                                mutex2.unlock((Object) null);
                                return Unit.INSTANCE;
                            } finally {
                            }
                        }
                        j2 = platformSelectionBehaviorsImpl$classifyText$1.J$0;
                        mutex = (Mutex) platformSelectionBehaviorsImpl$classifyText$1.L$2;
                        textClassifier2 = (TextClassifier) platformSelectionBehaviorsImpl$classifyText$1.L$1;
                        charSequence2 = (CharSequence) platformSelectionBehaviorsImpl$classifyText$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    textClassificationResult = getTextClassificationResult();
                    if (textClassificationResult != null) {
                        m2069canReuseh5sm0ck = PlatformSelectionBehaviors_androidKt.m2069canReuseh5sm0ck(textClassificationResult, charSequence2, j2);
                        if (m2069canReuseh5sm0ck) {
                            if (z) {
                                return Unit.INSTANCE;
                            }
                            Unit unit2 = Unit.INSTANCE;
                            mutex2.unlock((Object) null);
                            TextClassification classifyText = textClassifier2.classifyText(new TextClassification.Request.Builder(charSequence2, TextRange.getMin-impl(j2), TextRange.getMax-impl(j2)).setDefaultLocales(getAndroidLocalList()).build());
                            Mutex mutex3 = this.mutex;
                            platformSelectionBehaviorsImpl$classifyText$1.L$0 = charSequence2;
                            platformSelectionBehaviorsImpl$classifyText$1.L$1 = classifyText;
                            platformSelectionBehaviorsImpl$classifyText$1.L$2 = mutex3;
                            platformSelectionBehaviorsImpl$classifyText$1.J$0 = j2;
                            platformSelectionBehaviorsImpl$classifyText$1.label = 2;
                            if (mutex3.lock((Object) null, platformSelectionBehaviorsImpl$classifyText$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            mutex2 = mutex3;
                            textClassification = classifyText;
                            j3 = j2;
                            charSequence3 = charSequence2;
                            setTextClassificationResult(new TextClassificationResult(charSequence3, j3, textClassification, null));
                            Unit unit3 = Unit.INSTANCE;
                            mutex2.unlock((Object) null);
                            return Unit.INSTANCE;
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
            }
            textClassificationResult = getTextClassificationResult();
            if (textClassificationResult != null) {
            }
            z = false;
            if (z) {
            }
        } finally {
        }
        platformSelectionBehaviorsImpl$classifyText$1 = new PlatformSelectionBehaviorsImpl$classifyText$1(this, continuation);
        Object obj2 = platformSelectionBehaviorsImpl$classifyText$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = platformSelectionBehaviorsImpl$classifyText$1.label;
        z = true;
        if (i != 0) {
        }
    }

    /* renamed from: addSmartSelectionTextContextMenuItems-YmzfRxQ$foundation_release, reason: not valid java name */
    public final void m2064addSmartSelectionTextContextMenuItemsYmzfRxQ$foundation_release(TextContextMenuBuilderScope textContextMenuBuilderScope, CharSequence charSequence, long j, Function1<? super TextContextMenuBuilderScope, Unit> function1) {
        TextClassification m2065tryGetTextClassificationFDrldGo = m2065tryGetTextClassificationFDrldGo(charSequence, j);
        if (m2065tryGetTextClassificationFDrldGo == null) {
            function1.invoke(textContextMenuBuilderScope);
            return;
        }
        if (!m2065tryGetTextClassificationFDrldGo.getActions().isEmpty()) {
            TextContextMenuBuilderScope_androidKt.textClassificationItem(textContextMenuBuilderScope, this.AssistantItemKey, m2065tryGetTextClassificationFDrldGo, 0);
        } else if (TextClassifierHelperMethods.INSTANCE.hasLegacyAssistItem$foundation_release(m2065tryGetTextClassificationFDrldGo)) {
            TextContextMenuBuilderScope_androidKt.textClassificationItem(textContextMenuBuilderScope, this.AssistantItemKey, m2065tryGetTextClassificationFDrldGo, -1);
        }
        function1.invoke(textContextMenuBuilderScope);
        List<RemoteAction> actions = m2065tryGetTextClassificationFDrldGo.getActions();
        int size = actions.size();
        for (int i = 0; i < size; i++) {
            actions.get(i);
            if (i > 0) {
                TextContextMenuBuilderScope_androidKt.textClassificationItem(textContextMenuBuilderScope, this.AssistantItemKey, m2065tryGetTextClassificationFDrldGo, i);
            }
        }
    }

    /* renamed from: tryGetTextClassification-FDrldGo, reason: not valid java name */
    public final TextClassification m2065tryGetTextClassificationFDrldGo(CharSequence text, long selection) {
        boolean m2069canReuseh5sm0ck;
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, (Object) null, 1, (Object) null)) {
            return null;
        }
        TextClassificationResult textClassificationResult = getTextClassificationResult();
        boolean z = false;
        if (textClassificationResult != null) {
            m2069canReuseh5sm0ck = PlatformSelectionBehaviors_androidKt.m2069canReuseh5sm0ck(textClassificationResult, text, selection);
            if (m2069canReuseh5sm0ck) {
                z = true;
            }
        }
        TextClassification textClassification = z ? textClassificationResult.getTextClassification() : null;
        Mutex.DefaultImpls.unlock$default(this.mutex, (Object) null, 1, (Object) null);
        return textClassification;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object requireTextClassificationSession(Function2<? super TextClassifier, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return BuildersKt.withContext(this.coroutineContext, new C0511xa7a7d588(this, function2, null), continuation);
    }
}
