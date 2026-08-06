package androidx.compose.foundation.text.selection;

import android.os.Build;
import android.os.LocaleList;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: PlatformSelectionBehaviors.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/TextRange;", "Landroid/view/textclassifier/TextClassifier;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2", f = "PlatformSelectionBehaviors.android.kt", i = {0, 0, 0, 1}, l = {351, 158}, m = "invokeSuspend", n = {"suggestedSelection", "$this$withLock_u24default$iv", "newSelection", "newSelection"}, s = {"L$0", "L$1", "J$0", "J$0"})
/* renamed from: androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class C0513xcb45b7e0 extends SuspendLambda implements Function2<TextClassifier, Continuation<? super TextRange>, Object> {
    final /* synthetic */ long $selection;
    final /* synthetic */ CharSequence $text;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0513xcb45b7e0(CharSequence charSequence, long j, PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, Continuation<? super C0513xcb45b7e0> continuation) {
        super(2, continuation);
        this.$text = charSequence;
        this.$selection = j;
        this.this$0 = platformSelectionBehaviorsImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0513xcb45b7e0 = new C0513xcb45b7e0(this.$text, this.$selection, this.this$0, continuation);
        c0513xcb45b7e0.L$0 = obj;
        return c0513xcb45b7e0;
    }

    public final Object invoke(TextClassifier textClassifier, Continuation<? super TextRange> continuation) {
        return create(textClassifier, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LocaleList androidLocalList;
        Object m2063classifyTextM8tDOmk;
        long j;
        Mutex mutex;
        CharSequence charSequence;
        TextSelection textSelection;
        PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl;
        long j2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TextClassifier textClassifier = (TextClassifier) this.L$0;
            TextSelection.Request.Builder builder = new TextSelection.Request.Builder(this.$text, TextRange.getMin-impl(this.$selection), TextRange.getMax-impl(this.$selection));
            androidLocalList = this.this$0.getAndroidLocalList();
            TextSelection.Request.Builder defaultLocales = builder.setDefaultLocales(androidLocalList);
            if (Build.VERSION.SDK_INT >= 31) {
                defaultLocales.setIncludeTextClassification(true);
            }
            TextSelection suggestSelection = textClassifier.suggestSelection(defaultLocales.build());
            long TextRange = TextRangeKt.TextRange(suggestSelection.getSelectionStartIndex(), suggestSelection.getSelectionEndIndex());
            if (Build.VERSION.SDK_INT < 31 || suggestSelection.getTextClassification() == null) {
                this.J$0 = TextRange;
                this.label = 2;
                m2063classifyTextM8tDOmk = this.this$0.m2063classifyTextM8tDOmk(this.$text, TextRange, textClassifier, (Continuation) this);
                if (m2063classifyTextM8tDOmk == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j = TextRange;
                j2 = j;
            } else {
                mutex = this.this$0.mutex;
                PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl2 = this.this$0;
                CharSequence charSequence2 = this.$text;
                this.L$0 = suggestSelection;
                this.L$1 = mutex;
                this.L$2 = platformSelectionBehaviorsImpl2;
                this.L$3 = charSequence2;
                this.J$0 = TextRange;
                this.label = 1;
                if (mutex.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                charSequence = charSequence2;
                textSelection = suggestSelection;
                platformSelectionBehaviorsImpl = platformSelectionBehaviorsImpl2;
                j2 = TextRange;
                TextClassification textClassification = textSelection.getTextClassification();
                Intrinsics.checkNotNull(textClassification);
                platformSelectionBehaviorsImpl.setTextClassificationResult(new TextClassificationResult(charSequence, j2, textClassification, null));
                Unit unit = Unit.INSTANCE;
            }
        } else if (i == 1) {
            j2 = this.J$0;
            CharSequence charSequence3 = (CharSequence) this.L$3;
            platformSelectionBehaviorsImpl = (PlatformSelectionBehaviorsImpl) this.L$2;
            mutex = (Mutex) this.L$1;
            textSelection = (TextSelection) this.L$0;
            ResultKt.throwOnFailure(obj);
            charSequence = charSequence3;
            try {
                TextClassification textClassification2 = textSelection.getTextClassification();
                Intrinsics.checkNotNull(textClassification2);
                platformSelectionBehaviorsImpl.setTextClassificationResult(new TextClassificationResult(charSequence, j2, textClassification2, null));
                Unit unit2 = Unit.INSTANCE;
            } finally {
                mutex.unlock((Object) null);
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
            j2 = j;
        }
        return TextRange.box-impl(j2);
    }
}
