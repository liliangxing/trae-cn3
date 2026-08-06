package androidx.compose.p001ui.platform;

import android.content.res.Resources;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntIntMap;
import androidx.compose.p001ui.node.LayoutNode;
import androidx.compose.p001ui.semantics.AccessibilityAction;
import androidx.compose.p001ui.semantics.ProgressBarRangeInfo;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.semantics.SemanticsConfiguration;
import androidx.compose.p001ui.semantics.SemanticsConfigurationKt;
import androidx.compose.p001ui.semantics.SemanticsNode;
import androidx.compose.p001ui.semantics.SemanticsNodeWithAdjustedBounds;
import androidx.compose.p001ui.semantics.SemanticsOwnerKt;
import androidx.compose.p001ui.semantics.SemanticsProperties;
import androidx.compose.p001ui.semantics.SemanticsPropertyKey;
import androidx.compose.p001ui.semantics.SemanticsSortKt;
import androidx.compose.p001ui.state.ToggleableState;
import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.ui.R;
import androidx.compose.ui.contentcapture.ContentCaptureManager;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u001a.\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\f\u0010\u0018\u001a\u00020\u0004*\u00020\u0011H\u0002\u001a\u0014\u0010\u0019\u001a\u00020\u0004*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0002\u001a\f\u0010\u001e\u001a\u00020\u0004*\u00020\u0011H\u0002\u001a\u001a\u0010\u001f\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002\"\u0018\u0010\u001c\u001a\u00020\u0004*\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\"*\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00048F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006+"}, d2 = {"findClosestParentNode", "Landroidx/compose/ui/node/LayoutNode;", "selector", "Lkotlin/Function1;", "", "setTraversalValues", "", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/semantics/SemanticsNodeWithAdjustedBounds;", "outputBeforeMap", "Landroidx/collection/MutableIntIntMap;", "outputAfterMap", "resources", "Landroid/content/res/Resources;", "isScreenReaderFocusable", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "getInfoText", "Landroidx/compose/ui/text/AnnotatedString;", "getInfoStateDescriptionOrNull", "", "createStateDescriptionForTextField", "getInfoIsCheckable", "enabled", "propertiesDeleted", "oldConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "isRtl", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "excludeLineAndPageGranularities", "accessibilityEquals", "Landroidx/compose/ui/semantics/AccessibilityAction;", "other", "", StrategyConstants.VALUE, "DisableContentCapture", "getDisableContentCapture$annotations", "()V", "getDisableContentCapture", "()Z", "setDisableContentCapture", "(Z)V", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat_androidKt {

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.f5On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use ContentCapture.isEnabled instead", replaceWith = @ReplaceWith(expression = "!ContentCaptureManager.isEnabled", imports = {"androidx.compose.ui.contentcapture.ContentCaptureManager.Companion.isEnabled"}))
    public static /* synthetic */ void getDisableContentCapture$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutNode findClosestParentNode(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> function1) {
        for (LayoutNode parent$ui_release = layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (((Boolean) function1.invoke(parent$ui_release)).booleanValue()) {
                return parent$ui_release;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTraversalValues(final IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap, MutableIntIntMap mutableIntIntMap, MutableIntIntMap mutableIntIntMap2, final Resources resources) {
        mutableIntIntMap.clear();
        mutableIntIntMap2.clear();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) intObjectMap.get(-1);
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
        Intrinsics.checkNotNull(semanticsNode);
        List<SemanticsNode> subtreeSortedByGeometryGrouping = SemanticsSortKt.subtreeSortedByGeometryGrouping(semanticsNode, new Function1<SemanticsNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$setTraversalValues$semanticsOrderList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Boolean invoke(SemanticsNode semanticsNode2) {
                return Boolean.valueOf(intObjectMap.containsKey(semanticsNode2.getId()));
            }
        }, new Function1<SemanticsNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$setTraversalValues$semanticsOrderList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Boolean invoke(SemanticsNode semanticsNode2) {
                boolean isScreenReaderFocusable;
                isScreenReaderFocusable = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isScreenReaderFocusable(semanticsNode2, resources);
                return Boolean.valueOf(isScreenReaderFocusable);
            }
        }, CollectionsKt.listOf(semanticsNode));
        int lastIndex = CollectionsKt.getLastIndex(subtreeSortedByGeometryGrouping);
        int i = 1;
        if (1 > lastIndex) {
            return;
        }
        while (true) {
            int id = subtreeSortedByGeometryGrouping.get(i - 1).getId();
            int id2 = subtreeSortedByGeometryGrouping.get(i).getId();
            mutableIntIntMap.set(id, id2);
            mutableIntIntMap2.set(id2, id);
            if (i == lastIndex) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isScreenReaderFocusable(SemanticsNode semanticsNode, Resources resources) {
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getContentDescription());
        boolean z = ((list != null ? (String) CollectionsKt.firstOrNull(list) : null) == null && getInfoText(semanticsNode) == null && getInfoStateDescriptionOrNull(semanticsNode, resources) == null && !getInfoIsCheckable(semanticsNode)) ? false : true;
        if (SemanticsOwnerKt.isHidden(semanticsNode)) {
            return false;
        }
        return semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || (semanticsNode.isUnmergedLeafNode$ui_release() && z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString getInfoText(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString = (AnnotatedString) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getEditableText());
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
        return annotatedString == null ? list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null : annotatedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getInfoStateDescriptionOrNull(SemanticsNode semanticsNode, Resources resources) {
        int i;
        Object orNull = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getStateDescription());
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
        if (toggleableState != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i2 == 1) {
                if ((role == null ? false : Role.m1855equalsimpl0(role.getValue(), Role.INSTANCE.m1865getSwitcho7Vup1c())) && orNull == null) {
                    orNull = resources.getString(R.string.state_on);
                }
            } else if (i2 == 2) {
                if ((role == null ? false : Role.m1855equalsimpl0(role.getValue(), Role.INSTANCE.m1865getSwitcho7Vup1c())) && orNull == null) {
                    orNull = resources.getString(R.string.state_off);
                }
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (orNull == null) {
                    orNull = resources.getString(R.string.indeterminate);
                }
            }
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (!(role == null ? false : Role.m1855equalsimpl0(role.getValue(), Role.INSTANCE.m1866getTabo7Vup1c())) && orNull == null) {
                if (booleanValue) {
                    orNull = resources.getString(R.string.selected);
                } else {
                    orNull = resources.getString(R.string.not_selected);
                }
            }
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (progressBarRangeInfo != null) {
            if (progressBarRangeInfo != ProgressBarRangeInfo.INSTANCE.getIndeterminate()) {
                if (orNull == null) {
                    ClosedFloatingPointRange<Float> range = progressBarRangeInfo.getRange();
                    float current = ((((Number) range.getEndInclusive()).floatValue() - ((Number) range.getStart()).floatValue()) > 0.0f ? 1 : ((((Number) range.getEndInclusive()).floatValue() - ((Number) range.getStart()).floatValue()) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (progressBarRangeInfo.getCurrent() - ((Number) range.getStart()).floatValue()) / (((Number) range.getEndInclusive()).floatValue() - ((Number) range.getStart()).floatValue());
                    if (current < 0.0f) {
                        current = 0.0f;
                    }
                    if (current > 1.0f) {
                        current = 1.0f;
                    }
                    if (current == 0.0f) {
                        i = 0;
                    } else {
                        i = 100;
                        if (!(current == 1.0f)) {
                            i = RangesKt.coerceIn(Math.round(current * 100), 1, 99);
                        }
                    }
                    orNull = resources.getString(R.string.template_percent, Integer.valueOf(i));
                }
            } else if (orNull == null) {
                orNull = resources.getString(R.string.in_progress);
            }
        }
        if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            orNull = createStateDescriptionForTextField(semanticsNode, resources);
        }
        return (String) orNull;
    }

    private static final String createStateDescriptionForTextField(SemanticsNode semanticsNode, Resources resources) {
        SemanticsConfiguration config = semanticsNode.copyWithMergingEnabled$ui_release().getConfig();
        Collection collection = (Collection) SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getContentDescription());
        boolean z = false;
        if (collection == null || collection.isEmpty()) {
            Collection collection2 = (Collection) SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getText());
            if (collection2 == null || collection2.isEmpty()) {
                CharSequence charSequence = (CharSequence) SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getEditableText());
                if (charSequence == null || charSequence.length() == 0) {
                    z = true;
                }
            }
        }
        if (z) {
            return resources.getString(R.string.state_empty);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getInfoIsCheckable(SemanticsNode semanticsNode) {
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
        boolean z = toggleableState != null;
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
        if (bool == null) {
            return z;
        }
        bool.booleanValue();
        return role != null ? Role.m1855equalsimpl0(role.getValue(), Role.INSTANCE.m1866getTabo7Vup1c()) : false ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enabled(SemanticsNode semanticsNode) {
        return !semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getDisabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean propertiesDeleted(SemanticsNode semanticsNode, SemanticsConfiguration semanticsConfiguration) {
        Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it = semanticsConfiguration.iterator();
        while (it.hasNext()) {
            if (!semanticsNode.getConfig().contains(it.next().getKey())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRtl(SemanticsNode semanticsNode) {
        return semanticsNode.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean excludeLineAndPageGranularities(SemanticsNode semanticsNode) {
        if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText()) && !Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getFocused()), true)) {
            return true;
        }
        LayoutNode findClosestParentNode = findClosestParentNode(semanticsNode.getLayoutNode(), new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1
            public final Boolean invoke(LayoutNode layoutNode) {
                SemanticsConfiguration semanticsConfiguration = layoutNode.getSemanticsConfiguration();
                return Boolean.valueOf((semanticsConfiguration != null && semanticsConfiguration.getIsMergingSemanticsOfDescendants()) && semanticsConfiguration.contains(SemanticsProperties.INSTANCE.getEditableText()));
            }
        });
        if (findClosestParentNode != null) {
            SemanticsConfiguration semanticsConfiguration = findClosestParentNode.getSemanticsConfiguration();
            if (!(semanticsConfiguration != null ? Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.INSTANCE.getFocused()), true) : false)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean accessibilityEquals(AccessibilityAction<?> accessibilityAction, Object obj) {
        if (accessibilityAction == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityAction)) {
            return false;
        }
        AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj;
        if (!Intrinsics.areEqual(accessibilityAction.getLabel(), accessibilityAction2.getLabel())) {
            return false;
        }
        if (accessibilityAction.getAction() != null || accessibilityAction2.getAction() == null) {
            return accessibilityAction.getAction() == null || accessibilityAction2.getAction() != null;
        }
        return false;
    }

    public static final boolean getDisableContentCapture() {
        return ContentCaptureManager.Companion.isEnabled();
    }

    public static final void setDisableContentCapture(boolean z) {
        ContentCaptureManager.Companion.setEnabled(z);
    }
}
