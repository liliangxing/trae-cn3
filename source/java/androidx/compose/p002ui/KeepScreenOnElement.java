package androidx.compose.p002ui;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;

/* compiled from: KeepScreenOn.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÂ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\f\u0010\t\u001a\u00020\u0007*\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/KeepScreenOnElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/KeepScreenOnNode;", "<init>", "()V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final /* data */ class KeepScreenOnElement extends ModifierNodeElement<KeepScreenOnNode> {
    public static final KeepScreenOnElement INSTANCE = new KeepScreenOnElement();

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeepScreenOnElement)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return -84078893;
    }

    public String toString() {
        return "KeepScreenOnElement";
    }

    public void update(KeepScreenOnNode node) {
    }

    private KeepScreenOnElement() {
    }

    /* renamed from: create, reason: merged with bridge method [inline-methods] */
    public KeepScreenOnNode m4294create() {
        return new KeepScreenOnNode();
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("keepScreenOn");
    }
}
