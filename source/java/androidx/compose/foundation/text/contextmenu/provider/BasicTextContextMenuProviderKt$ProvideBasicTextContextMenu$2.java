package androidx.compose.foundation.text.contextmenu.provider;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BasicTextContextMenuProvider.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class BasicTextContextMenuProviderKt$ProvideBasicTextContextMenu$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ MutableState<LayoutCoordinates> $layoutCoordinates$delegate;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ BasicTextContextMenuProvider $provider;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public BasicTextContextMenuProviderKt$ProvideBasicTextContextMenu$2(Modifier modifier, MutableState<LayoutCoordinates> mutableState, Function2<? super Composer, ? super Integer, Unit> function2, BasicTextContextMenuProvider basicTextContextMenuProvider) {
        this.$modifier = modifier;
        this.$layoutCoordinates$delegate = mutableState;
        this.$content = function2;
        this.$provider = basicTextContextMenuProvider;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState, LayoutCoordinates layoutCoordinates) {
        mutableState.setValue(layoutCoordinates);
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C89@3863L26,87@3761L254:BasicTextContextMenuProvider.kt#qzx0zs");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(274270255, i, -1, "androidx.compose.foundation.text.contextmenu.provider.ProvideBasicTextContextMenu.<anonymous> (BasicTextContextMenuProvider.kt:87)");
        }
        Modifier modifier = this.$modifier;
        ComposerKt.sourceInformationMarkerStart(composer, 1580713609, "CC(remember):BasicTextContextMenuProvider.kt#9igjgp");
        final MutableState<LayoutCoordinates> mutableState = this.$layoutCoordinates$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProviderKt$ProvideBasicTextContextMenu$2$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = BasicTextContextMenuProviderKt$ProvideBasicTextContextMenu$2.invoke$lambda$1$lambda$0(MutableState.this, (LayoutCoordinates) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, (Function1) rememberedValue);
        Function2<Composer, Integer, Unit> function2 = this.$content;
        BasicTextContextMenuProvider basicTextContextMenuProvider = this.$provider;
        final MutableState<LayoutCoordinates> mutableState2 = this.$layoutCoordinates$delegate;
        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, onGloballyPositioned);
        Function0 constructor = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m4109constructorimpl = Updater.m4109constructorimpl(composer);
        Updater.m4116setimpl(m4109constructorimpl, maybeCachedBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
            m4109constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
            m4109constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
        }
        Updater.m4116setimpl(m4109constructorimpl, materializeModifier, (Function2<? super T, ? super Modifier, Unit>) ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -733481004, "C91@3915L9,92@3958L47,92@3946L59:BasicTextContextMenuProvider.kt#qzx0zs");
        function2.invoke(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 669077316, "CC(remember):BasicTextContextMenuProvider.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProviderKt$ProvideBasicTextContextMenu$2$$ExternalSyntheticLambda1
                public final Object invoke() {
                    LayoutCoordinates invoke$lambda$4$lambda$3$lambda$2;
                    invoke$lambda$4$lambda$3$lambda$2 = BasicTextContextMenuProviderKt$ProvideBasicTextContextMenu$2.invoke$lambda$4$lambda$3$lambda$2(MutableState.this);
                    return invoke$lambda$4$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        basicTextContextMenuProvider.ContextMenu((Function0) rememberedValue2, composer, 6);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates invoke$lambda$4$lambda$3$lambda$2(MutableState mutableState) {
        LayoutCoordinates ProvideBasicTextContextMenu$lambda$2;
        ProvideBasicTextContextMenu$lambda$2 = BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu$lambda$2(mutableState);
        if (ProvideBasicTextContextMenu$lambda$2 != null) {
            return ProvideBasicTextContextMenu$lambda$2;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }
}
