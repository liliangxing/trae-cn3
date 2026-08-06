package androidx.compose.foundation.text.input.internal;

import android.content.ClipDescription;
import android.view.DragEvent;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.content.MediaType;
import androidx.compose.p002ui.draganddrop.DragAndDropEvent;
import androidx.compose.p002ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.p002ui.draganddrop.DragAndDropTarget;
import androidx.compose.p002ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.p002ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldDragAndDropNode.android.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÒ\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010H\u0000¨\u0006\u001c"}, d2 = {"textFieldDragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "hintMediaTypes", "Lkotlin/Function0;", "", "Landroidx/compose/foundation/content/MediaType;", "onDrop", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/ClipEntry;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "clipEntry", "Landroidx/compose/ui/platform/ClipMetadata;", "clipMetadata", "", "dragAndDropRequestPermission", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "onStarted", "event", "onEntered", "onMoved", "Landroidx/compose/ui/geometry/Offset;", "position", "onChanged", "onExited", "onEnded", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldDragAndDropNode_androidKt {
    public static final DragAndDropTargetModifierNode textFieldDragAndDropNode(final Function0<? extends Set<MediaType>> function0, final Function2<? super ClipEntry, ? super ClipMetadata, Boolean> function2, final Function1<? super DragAndDropEvent, Unit> function1, final Function1<? super DragAndDropEvent, Unit> function12, final Function1<? super DragAndDropEvent, Unit> function13, final Function1<? super Offset, Unit> function14, final Function1<? super DragAndDropEvent, Unit> function15, final Function1<? super DragAndDropEvent, Unit> function16, final Function1<? super DragAndDropEvent, Unit> function17) {
        return DragAndDropNodeKt.DragAndDropTargetModifierNode(new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDragAndDropNode_androidKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean textFieldDragAndDropNode$lambda$1;
                textFieldDragAndDropNode$lambda$1 = TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode$lambda$1(function0, (DragAndDropEvent) obj);
                return Boolean.valueOf(textFieldDragAndDropNode$lambda$1);
            }
        }, new DragAndDropTarget() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDragAndDropNode_androidKt$textFieldDragAndDropNode$2
            @Override // androidx.compose.p002ui.draganddrop.DragAndDropTarget
            public boolean onDrop(DragAndDropEvent event) {
                function1.invoke(event);
                return ((Boolean) function2.invoke(AndroidClipboardManager_androidKt.toClipEntry(DragAndDrop_androidKt.toAndroidDragEvent(event).getClipData()), AndroidClipboardManager_androidKt.toClipMetadata(DragAndDrop_androidKt.toAndroidDragEvent(event).getClipDescription()))).booleanValue();
            }

            @Override // androidx.compose.p002ui.draganddrop.DragAndDropTarget
            public void onStarted(DragAndDropEvent event) {
                Function1<DragAndDropEvent, Unit> function18 = function12;
                if (function18 != null) {
                    function18.invoke(event);
                }
            }

            @Override // androidx.compose.p002ui.draganddrop.DragAndDropTarget
            public void onEntered(DragAndDropEvent event) {
                Function1<DragAndDropEvent, Unit> function18 = function13;
                if (function18 != null) {
                    function18.invoke(event);
                }
            }

            @Override // androidx.compose.p002ui.draganddrop.DragAndDropTarget
            public void onMoved(DragAndDropEvent event) {
                DragEvent androidDragEvent = DragAndDrop_androidKt.toAndroidDragEvent(event);
                Function1<Offset, Unit> function18 = function14;
                if (function18 != null) {
                    float x = androidDragEvent.getX();
                    float y = androidDragEvent.getY();
                    function18.invoke(Offset.m4582boximpl(Offset.m4585constructorimpl((Float.floatToRawIntBits(x) << 32) | (Float.floatToRawIntBits(y) & 4294967295L))));
                }
            }

            @Override // androidx.compose.p002ui.draganddrop.DragAndDropTarget
            public void onExited(DragAndDropEvent event) {
                Function1<DragAndDropEvent, Unit> function18 = function16;
                if (function18 != null) {
                    function18.invoke(event);
                }
            }

            @Override // androidx.compose.p002ui.draganddrop.DragAndDropTarget
            public void onChanged(DragAndDropEvent event) {
                Function1<DragAndDropEvent, Unit> function18 = function15;
                if (function18 != null) {
                    function18.invoke(event);
                }
            }

            @Override // androidx.compose.p002ui.draganddrop.DragAndDropTarget
            public void onEnded(DragAndDropEvent event) {
                Function1<DragAndDropEvent, Unit> function18 = function17;
                if (function18 != null) {
                    function18.invoke(event);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean textFieldDragAndDropNode$lambda$1(Function0 function0, DragAndDropEvent dragAndDropEvent) {
        ClipDescription clipDescription = DragAndDrop_androidKt.toAndroidDragEvent(dragAndDropEvent).getClipDescription();
        Iterable<MediaType> iterable = (Iterable) function0.invoke();
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (MediaType mediaType : iterable) {
            if (Intrinsics.areEqual(mediaType, MediaType.INSTANCE.getAll()) || clipDescription.hasMimeType(mediaType.getRepresentation())) {
                return true;
            }
        }
        return false;
    }
}
