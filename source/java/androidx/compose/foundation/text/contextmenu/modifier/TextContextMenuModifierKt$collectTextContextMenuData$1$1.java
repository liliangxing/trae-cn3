package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextContextMenuModifier.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public /* synthetic */ class TextContextMenuModifierKt$collectTextContextMenuData$1$1 extends FunctionReferenceImpl implements Function1<Function1<? super TextContextMenuComponent, ? extends Boolean>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TextContextMenuModifierKt$collectTextContextMenuData$1$1(Object obj) {
        super(1, obj, TextContextMenuBuilderScope.class, "addFilter", "addFilter$foundation_release(Lkotlin/jvm/functions/Function1;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Function1<? super TextContextMenuComponent, Boolean>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Function1<? super TextContextMenuComponent, Boolean> function1) {
        ((TextContextMenuBuilderScope) this.receiver).addFilter$foundation_release(function1);
    }
}
