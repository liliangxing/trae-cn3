package com.bytedance.trae.conversation.chat.block.renderer;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.im.model.FileDiffInfo;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileTreeBottomSheetFragment.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "diffFiles", "", "Lcom/bytedance/trae/im/model/FileDiffInfo;", "onFileClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "filePath", "", "getOnFileClick", "()Lkotlin/jvm/functions/Function1;", "setOnFileClick", "(Lkotlin/jvm/functions/Function1;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FileTreeBottomSheetFragment extends BottomSheetDialogFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static List<FileDiffInfo> pendingDiffFiles;
    private List<FileDiffInfo> diffFiles = CollectionsKt.emptyList();
    private Function1<? super String, Unit> onFileClick;

    /* compiled from: FileTreeBottomSheetFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$Companion;", "", "<init>", "()V", "pendingDiffFiles", "", "Lcom/bytedance/trae/im/model/FileDiffInfo;", "newInstance", "Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;", "diffFiles", "onFileClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "filePath", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FileTreeBottomSheetFragment newInstance$default(Companion companion, List list, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = null;
            }
            return companion.newInstance(list, function1);
        }

        public final FileTreeBottomSheetFragment newInstance(List<FileDiffInfo> diffFiles, Function1<? super String, Unit> onFileClick) {
            Intrinsics.checkNotNullParameter(diffFiles, "diffFiles");
            FileTreeBottomSheetFragment.pendingDiffFiles = diffFiles;
            FileTreeBottomSheetFragment fileTreeBottomSheetFragment = new FileTreeBottomSheetFragment();
            fileTreeBottomSheetFragment.setOnFileClick(onFileClick);
            return fileTreeBottomSheetFragment;
        }
    }

    public final Function1<String, Unit> getOnFileClick() {
        return this.onFileClick;
    }

    public final void setOnFileClick(Function1<? super String, Unit> function1) {
        this.onFileClick = function1;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<FileDiffInfo> list = pendingDiffFiles;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        this.diffFiles = list;
        pendingDiffFiles = null;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final Dialog dialog = (BottomSheetDialog) onCreateDialog;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.FileTreeBottomSheetFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                FileTreeBottomSheetFragment.onCreateDialog$lambda$0(dialog, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(BottomSheetDialog bottomSheetDialog, DialogInterface dialogInterface) {
        View findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        if (findViewById != null) {
            findViewById.setBackgroundResource(android.R.color.transparent);
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            from.setState(3);
            from.setSkipCollapsed(true);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.trae_fragment_file_tree_bottom_sheet, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((TraeTitleBar) view.findViewById(C0637R.id.title_bar)).setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.FileTreeBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FileTreeBottomSheetFragment.this.dismiss();
            }
        });
        RecyclerView findViewById = view.findViewById(C0637R.id.rv_files);
        findViewById.setLayoutManager(new LinearLayoutManager(getContext()));
        FileTreeAdapter fileTreeAdapter = new FileTreeAdapter(new Function1() { // from class: com.bytedance.trae.conversation.chat.block.renderer.FileTreeBottomSheetFragment$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$2;
                onViewCreated$lambda$2 = FileTreeBottomSheetFragment.onViewCreated$lambda$2(FileTreeBottomSheetFragment.this, (String) obj);
                return onViewCreated$lambda$2;
            }
        });
        findViewById.setAdapter(fileTreeAdapter);
        fileTreeAdapter.setDiffFiles(this.diffFiles);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(FileTreeBottomSheetFragment fileTreeBottomSheetFragment, String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Function1<? super String, Unit> function1 = fileTreeBottomSheetFragment.onFileClick;
        if (function1 != null) {
            function1.invoke(str);
        }
        fileTreeBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }
}
