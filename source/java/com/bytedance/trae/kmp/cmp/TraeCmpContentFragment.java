package com.bytedance.trae.kmp.cmp;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.fragment.app.Fragment;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.design.compose.TraeComposeTokensKt;
import com.bytedance.trae.kmp.base.C0811R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeCmpContentFragment.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001f\u001a\u00020\u001dH\u0014J\b\u0010 \u001a\u00020\u001dH\u0014J\u001a\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\r\u0010\"\u001a\u00020\u001dH%¢\u0006\u0002\u0010#R\u0014\u0010\u0004\u001a\u00020\u00058eX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¤\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007¨\u0006$"}, d2 = {"Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "titleResId", "", "getTitleResId", "()I", "titleBarMode", "Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;", "getTitleBarMode", "()Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;", "leftAction", "Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;", "getLeftAction", "()Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;", "rightAction", "getRightAction", "composeViewId", "getComposeViewId", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onBackAction", "onCloseAction", "onCmpViewCreated", "RenderCmpContent", "(Landroidx/compose/runtime/Composer;I)V", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class TraeCmpContentFragment extends Fragment {
    public static final int $stable = 0;
    private final TraeTitleBar.Action leftAction = TraeTitleBar.Action.BACK;
    private final TraeTitleBar.Action rightAction = TraeTitleBar.Action.NONE;
    private final int composeViewId = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void RenderCmpContent(Composer composer, int i);

    protected abstract TraeTitleBar.Mode getTitleBarMode();

    protected abstract int getTitleResId();

    protected void onCloseAction() {
    }

    protected void onCmpViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    protected TraeTitleBar.Action getLeftAction() {
        return this.leftAction;
    }

    protected TraeTitleBar.Action getRightAction() {
        return this.rightAction;
    }

    protected int getComposeViewId() {
        return this.composeViewId;
    }

    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(C0811R.layout.trae_fragment_cmp_content, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public final void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TraeTitleBar findViewById = view.findViewById(C0811R.id.trae_cmp_title_bar);
        TraeTitleBar.setMode$default(findViewById, getTitleBarMode(), false, 2, (Object) null);
        findViewById.setTitle(getTitleResId());
        findViewById.setLeftAction(getLeftAction());
        findViewById.setRightAction(getRightAction());
        findViewById.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.kmp.cmp.TraeCmpContentFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TraeCmpContentFragment.onViewCreated$lambda$2$lambda$0(TraeCmpContentFragment.this, view2);
            }
        });
        findViewById.setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.kmp.cmp.TraeCmpContentFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TraeCmpContentFragment.onViewCreated$lambda$2$lambda$1(TraeCmpContentFragment.this, view2);
            }
        });
        ComposeView findViewById2 = view.findViewById(C0811R.id.trae_cmp_content);
        if (getComposeViewId() != -1) {
            findViewById2.setId(getComposeViewId());
        }
        findViewById2.setSaveFromParentEnabled(false);
        findViewById2.setTag(R.id.compose_view_saveable_id_tag, getClass().getSimpleName() + '_' + SystemClock.elapsedRealtimeNanos());
        findViewById2.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        findViewById2.setContent(ComposableLambdaKt.composableLambdaInstance(-1909781802, true, new Function2<Composer, Integer, Unit>() { // from class: com.bytedance.trae.kmp.cmp.TraeCmpContentFragment$onViewCreated$2$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                if ((i & 3) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1909781802, i, -1, "com.bytedance.trae.kmp.cmp.TraeCmpContentFragment.onViewCreated.<anonymous>.<anonymous> (TraeCmpContentFragment.kt:70)");
                    }
                    final TraeCmpContentFragment traeCmpContentFragment = TraeCmpContentFragment.this;
                    TraeComposeTokensKt.TraeDesignTheme(false, ComposableLambdaKt.rememberComposableLambda(313320857, true, new Function2<Composer, Integer, Unit>() { // from class: com.bytedance.trae.kmp.cmp.TraeCmpContentFragment$onViewCreated$2$1.1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i2) {
                            if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(313320857, i2, -1, "com.bytedance.trae.kmp.cmp.TraeCmpContentFragment.onViewCreated.<anonymous>.<anonymous>.<anonymous> (TraeCmpContentFragment.kt:71)");
                                }
                                Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), NestedScrollInteropConnectionKt.rememberNestedScrollInteropConnection((View) null, composer2, 0, 1), (NestedScrollDispatcher) null, 2, (Object) null);
                                TraeCmpContentFragment traeCmpContentFragment2 = TraeCmpContentFragment.this;
                                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, nestedScroll$default);
                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer composer3 = Updater.constructor-impl(composer2);
                                Updater.set-impl(composer3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                traeCmpContentFragment2.RenderCmpContent(composer2, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composer, 54), composer, 48, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }));
        onCmpViewCreated(view, savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2$lambda$0(TraeCmpContentFragment traeCmpContentFragment, View view) {
        if (traeCmpContentFragment.getLeftAction() == TraeTitleBar.Action.BACK) {
            traeCmpContentFragment.onBackAction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2$lambda$1(TraeCmpContentFragment traeCmpContentFragment, View view) {
        if (traeCmpContentFragment.getRightAction() == TraeTitleBar.Action.CLOSE) {
            traeCmpContentFragment.onCloseAction();
        }
    }

    protected void onBackAction() {
        getParentFragmentManager().popBackStack();
    }
}
