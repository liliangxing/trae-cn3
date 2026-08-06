package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyLayoutItemContentFactory.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class C0347xbaaa624f implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ LazyLayoutItemContentFactory this$0;
    final /* synthetic */ LazyLayoutItemContentFactory.CachedItemContent this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0347xbaaa624f(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, LazyLayoutItemContentFactory.CachedItemContent cachedItemContent) {
        this.this$0 = lazyLayoutItemContentFactory;
        this.this$1 = cachedItemContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SaveableStateHolder saveableStateHolder;
        ComposerKt.sourceInformation(composer, "C101@3940L244,101@3918L266:LazyLayoutItemContentFactory.kt#wow0x6");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(818252804, i, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:85)");
        }
        LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) this.this$0.getItemProvider().invoke();
        int index = this.this$1.getIndex();
        if ((index >= lazyLayoutItemProvider.getItemCount() || !Intrinsics.areEqual(lazyLayoutItemProvider.getKey(index), this.this$1.getKey())) && (index = lazyLayoutItemProvider.getIndex(this.this$1.getKey())) != -1) {
            this.this$1.index = index;
        }
        int i2 = index;
        if (i2 != -1) {
            composer.startReplaceGroup(-1664741271);
            ComposerKt.sourceInformation(composer, "94@3678L205");
            saveableStateHolder = this.this$0.saveableStateHolder;
            LazyLayoutItemContentFactoryKt.m1293SkippableItemJVlU9Rs(lazyLayoutItemProvider, StableValue.m1339constructorimpl(saveableStateHolder), i2, StableValue.m1339constructorimpl(this.this$1.getKey()), composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1664505826);
            composer.endReplaceGroup();
        }
        Object key = this.this$1.getKey();
        ComposerKt.sourceInformationMarkerStart(composer, 361949752, "CC(remember):LazyLayoutItemContentFactory.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(this.this$1);
        final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = this.this$1;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    DisposableEffectResult invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = C0347xbaaa624f.invoke$lambda$2$lambda$1(LazyLayoutItemContentFactory.CachedItemContent.this, (DisposableEffectScope) obj);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(key, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult invoke$lambda$2$lambda$1(final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$invoke$lambda$2$lambda$1$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                LazyLayoutItemContentFactory.CachedItemContent.this._content = null;
            }
        };
    }
}
