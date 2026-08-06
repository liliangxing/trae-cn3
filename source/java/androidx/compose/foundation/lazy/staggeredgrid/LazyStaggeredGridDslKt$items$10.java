package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* compiled from: LazyStaggeredGridDsl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyStaggeredGridDslKt$items$10 implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ Function4<LazyStaggeredGridItemScope, T, Composer, Integer, Unit> $itemContent;
    final /* synthetic */ T[] $items;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridDslKt$items$10(Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, T[] tArr) {
        this.$itemContent = function4;
        this.$items = tArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyStaggeredGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, int i, Composer composer, int i2) {
        int i3;
        ComposerKt.sourceInformation(composer, "CN(index)472@22306L25:LazyStaggeredGridDsl.kt#fzvcnm");
        if ((i2 & 6) == 0) {
            i3 = (composer.changed(lazyStaggeredGridItemScope) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composer.changed(i) ? 32 : 16;
        }
        if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1775984467, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.items.<anonymous> (LazyStaggeredGridDsl.kt:472)");
        }
        this.$itemContent.invoke(lazyStaggeredGridItemScope, this.$items[i], composer, Integer.valueOf(i3 & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
