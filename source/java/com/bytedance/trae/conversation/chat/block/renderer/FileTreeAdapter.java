package com.bytedance.trae.conversation.chat.block.renderer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.im.model.FileDiffInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FileTreeAdapter.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003&'(B.\u0012%\b\u0002\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0011\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0016\u0010\u0015\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0018\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u001bH\u0016J\u0012\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u0005H\u0002R+\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;", "onFileClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "filePath", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "flatItems", "", "Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;", "rootNode", "Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;", "setDiffFiles", "diffFiles", "", "Lcom/bytedance/trae/im/model/FileDiffInfo;", "buildTree", "hoistSingleChildFolders", "node", "rebuildFlatList", "flattenNode", "indentLevel", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "getItemCount", "getFileActionIcon", "fileAction", "ViewHolder", "TreeNode", "FlatTreeItem", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FileTreeAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<FlatTreeItem> flatItems;
    private final Function1<String, Unit> onFileClick;
    private TreeNode rootNode;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FileTreeAdapter() {
        this(r0, 1, r0);
        Function1 function1 = null;
    }

    public /* synthetic */ FileTreeAdapter(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileTreeAdapter(Function1<? super String, Unit> function1) {
        this.onFileClick = function1;
        this.flatItems = new ArrayList();
    }

    public final void setDiffFiles(List<FileDiffInfo> diffFiles) {
        Intrinsics.checkNotNullParameter(diffFiles, "diffFiles");
        this.rootNode = buildTree(diffFiles);
        rebuildFlatList();
    }

    private final TreeNode buildTree(List<FileDiffInfo> diffFiles) {
        Object obj;
        TreeNode treeNode = new TreeNode("", true, null, -1, false, null, null, 116, null);
        for (FileDiffInfo fileDiffInfo : diffFiles) {
            String filePath = fileDiffInfo.getFilePath();
            if (filePath != null) {
                List<String> split$default = StringsKt.split$default(filePath, new String[]{"/"}, false, 0, 6, (Object) null);
                int i = 0;
                TreeNode treeNode2 = treeNode;
                for (String str : split$default) {
                    int i2 = i + 1;
                    if (i == CollectionsKt.getLastIndex(split$default)) {
                        treeNode2.getChildren().add(new TreeNode(str, false, fileDiffInfo.getFileAction(), i, false, filePath, null, 80, null));
                        i = i2;
                    } else {
                        Iterator<T> it = treeNode2.getChildren().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            TreeNode treeNode3 = (TreeNode) obj;
                            if (Intrinsics.areEqual(treeNode3.getName(), str) && treeNode3.isFolder()) {
                                break;
                            }
                        }
                        TreeNode treeNode4 = (TreeNode) obj;
                        if (treeNode4 != null) {
                            i = i2;
                            treeNode2 = treeNode4;
                        } else {
                            TreeNode treeNode5 = new TreeNode(str, true, null, i, true, null, null, 100, null);
                            treeNode2.getChildren().add(treeNode5);
                            i = i2;
                            treeNode2 = treeNode5;
                        }
                    }
                }
            }
        }
        return hoistSingleChildFolders(treeNode);
    }

    private final TreeNode hoistSingleChildFolders(TreeNode node) {
        TreeNode treeNode = new TreeNode(node.getName(), node.isFolder(), node.getFileAction(), node.getIndentLevel(), node.getExpanded(), node.getFilePath(), null, 64, null);
        Iterator<TreeNode> it = node.getChildren().iterator();
        while (it.hasNext()) {
            treeNode.getChildren().add(hoistSingleChildFolders(it.next()));
        }
        return treeNode;
    }

    private final void rebuildFlatList() {
        this.flatItems.clear();
        TreeNode treeNode = this.rootNode;
        if (treeNode == null) {
            return;
        }
        Iterator<TreeNode> it = treeNode.getChildren().iterator();
        while (it.hasNext()) {
            flattenNode(it.next(), 0);
        }
        notifyDataSetChanged();
    }

    private final void flattenNode(TreeNode node, int indentLevel) {
        this.flatItems.add(new FlatTreeItem(node, indentLevel));
        if (node.isFolder() && node.getExpanded()) {
            Iterator<TreeNode> it = node.getChildren().iterator();
            while (it.hasNext()) {
                flattenNode(it.next(), indentLevel + 1);
            }
        }
    }

    /* compiled from: FileTreeAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvFilename", "Landroid/widget/TextView;", "getTvFilename", "()Landroid/widget/TextView;", "ivIcon", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "ivIndicator", "getIvIndicator", "llIndent", "Landroid/widget/LinearLayout;", "getLlIndent", "()Landroid/widget/LinearLayout;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivIcon;
        private final ImageView ivIndicator;
        private final LinearLayout llIndent;
        private final TextView tvFilename;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(C0637R.id.tv_filename);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.tvFilename = (TextView) findViewById;
            View findViewById2 = view.findViewById(C0637R.id.iv_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.ivIcon = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(C0637R.id.iv_indicator);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.ivIndicator = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(C0637R.id.ll_indent);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.llIndent = (LinearLayout) findViewById4;
        }

        public final TextView getTvFilename() {
            return this.tvFilename;
        }

        public final ImageView getIvIcon() {
            return this.ivIcon;
        }

        public final ImageView getIvIndicator() {
            return this.ivIndicator;
        }

        public final LinearLayout getLlIndent() {
            return this.llIndent;
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_file_tree, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(inflate);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        FlatTreeItem flatTreeItem = this.flatItems.get(position);
        final TreeNode node = flatTreeItem.getNode();
        holder.getTvFilename().setText(node.getName());
        if (node.isFolder()) {
            holder.getIvIcon().setImageResource(C0637R.drawable.ic_explorer_folder);
            holder.getIvIndicator().setImageResource(C0637R.drawable.ic_explorer_down);
            holder.getTvFilename().setTextSize(13.0f);
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FileTreeAdapter.onBindViewHolder$lambda$1(FileTreeAdapter.TreeNode.this, this, view);
                }
            });
        } else {
            holder.getIvIcon().setImageResource(getFileActionIcon(node.getFileAction()));
            holder.getIvIndicator().setImageResource(C0637R.drawable.ic_explorer_dot);
            holder.getTvFilename().setTextSize(15.0f);
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FileTreeAdapter.onBindViewHolder$lambda$2(FileTreeAdapter.TreeNode.this, this, view);
                }
            });
        }
        if (flatTreeItem.getIndentLevel() > 0) {
            holder.getLlIndent().setVisibility(0);
            ViewGroup.LayoutParams layoutParams = holder.getLlIndent().getLayoutParams();
            layoutParams.width = (int) (flatTreeItem.getIndentLevel() * 14 * holder.itemView.getResources().getDisplayMetrics().density);
            holder.getLlIndent().setLayoutParams(layoutParams);
            return;
        }
        holder.getLlIndent().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(TreeNode treeNode, FileTreeAdapter fileTreeAdapter, View view) {
        treeNode.setExpanded(!treeNode.getExpanded());
        fileTreeAdapter.rebuildFlatList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(TreeNode treeNode, FileTreeAdapter fileTreeAdapter, View view) {
        Function1<String, Unit> function1;
        String filePath = treeNode.getFilePath();
        if (filePath == null || (function1 = fileTreeAdapter.onFileClick) == null) {
            return;
        }
        function1.invoke(filePath);
    }

    public int getItemCount() {
        return this.flatItems.size();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        if (r2.equals("new") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_diff_add;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r2.equals("add") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
    
        if (r2.equals("update") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
    
        if (r2.equals("remove") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_diff_delete;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
    
        if (r2.equals("modify") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        if (r2.equals("delete") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
    
        if (r2.equals("create") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
    
        if (r2.equals("edit") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_diff_edit;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0016. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int getFileActionIcon(String fileAction) {
        String str;
        if (fileAction != null) {
            str = fileAction.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        } else {
            str = null;
        }
        if (str != null) {
            switch (str.hashCode()) {
                case -1352294148:
                    break;
                case -1335458389:
                    break;
                case -1068795718:
                    break;
                case -934610812:
                    break;
                case -838846263:
                    break;
                case 96417:
                    break;
                case 108960:
                    break;
                case 3108362:
                    break;
            }
        }
        return C0637R.drawable.ic_diff_add;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileTreeAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u001b\b\u0082\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00000\fHÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\fHÆ\u0001J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;", "", "name", "", "isFolder", "", "fileAction", "indentLevel", "", "expanded", "filePath", "children", "", "<init>", "(Ljava/lang/String;ZLjava/lang/String;IZLjava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "()Z", "getFileAction", "getIndentLevel", "()I", "getExpanded", "setExpanded", "(Z)V", "getFilePath", "getChildren", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class TreeNode {
        private final List<TreeNode> children;
        private boolean expanded;
        private final String fileAction;
        private final String filePath;
        private final int indentLevel;
        private final boolean isFolder;
        private final String name;

        public static /* synthetic */ TreeNode copy$default(TreeNode treeNode, String str, boolean z, String str2, int i, boolean z2, String str3, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = treeNode.name;
            }
            if ((i2 & 2) != 0) {
                z = treeNode.isFolder;
            }
            boolean z3 = z;
            if ((i2 & 4) != 0) {
                str2 = treeNode.fileAction;
            }
            String str4 = str2;
            if ((i2 & 8) != 0) {
                i = treeNode.indentLevel;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                z2 = treeNode.expanded;
            }
            boolean z4 = z2;
            if ((i2 & 32) != 0) {
                str3 = treeNode.filePath;
            }
            String str5 = str3;
            if ((i2 & 64) != 0) {
                list = treeNode.children;
            }
            return treeNode.copy(str, z3, str4, i3, z4, str5, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsFolder() {
            return this.isFolder;
        }

        /* renamed from: component3, reason: from getter */
        public final String getFileAction() {
            return this.fileAction;
        }

        /* renamed from: component4, reason: from getter */
        public final int getIndentLevel() {
            return this.indentLevel;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getExpanded() {
            return this.expanded;
        }

        /* renamed from: component6, reason: from getter */
        public final String getFilePath() {
            return this.filePath;
        }

        public final List<TreeNode> component7() {
            return this.children;
        }

        public final TreeNode copy(String name, boolean isFolder, String fileAction, int indentLevel, boolean expanded, String filePath, List<TreeNode> children) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(children, "children");
            return new TreeNode(name, isFolder, fileAction, indentLevel, expanded, filePath, children);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TreeNode)) {
                return false;
            }
            TreeNode treeNode = (TreeNode) other;
            return Intrinsics.areEqual(this.name, treeNode.name) && this.isFolder == treeNode.isFolder && Intrinsics.areEqual(this.fileAction, treeNode.fileAction) && this.indentLevel == treeNode.indentLevel && this.expanded == treeNode.expanded && Intrinsics.areEqual(this.filePath, treeNode.filePath) && Intrinsics.areEqual(this.children, treeNode.children);
        }

        public int hashCode() {
            int hashCode = ((this.name.hashCode() * 31) + Boolean.hashCode(this.isFolder)) * 31;
            String str = this.fileAction;
            int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.indentLevel)) * 31) + Boolean.hashCode(this.expanded)) * 31;
            String str2 = this.filePath;
            return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.children.hashCode();
        }

        public String toString() {
            return "TreeNode(name=" + this.name + ", isFolder=" + this.isFolder + ", fileAction=" + this.fileAction + ", indentLevel=" + this.indentLevel + ", expanded=" + this.expanded + ", filePath=" + this.filePath + ", children=" + this.children + ')';
        }

        public TreeNode(String str, boolean z, String str2, int i, boolean z2, String str3, List<TreeNode> list) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(list, "children");
            this.name = str;
            this.isFolder = z;
            this.fileAction = str2;
            this.indentLevel = i;
            this.expanded = z2;
            this.filePath = str3;
            this.children = list;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean isFolder() {
            return this.isFolder;
        }

        public final String getFileAction() {
            return this.fileAction;
        }

        public final int getIndentLevel() {
            return this.indentLevel;
        }

        public final boolean getExpanded() {
            return this.expanded;
        }

        public final void setExpanded(boolean z) {
            this.expanded = z;
        }

        public final String getFilePath() {
            return this.filePath;
        }

        public /* synthetic */ TreeNode(String str, boolean z, String str2, int i, boolean z2, String str3, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, z, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? true : z2, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? new ArrayList() : list);
        }

        public final List<TreeNode> getChildren() {
            return this.children;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileTreeAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;", "", "node", "Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;", "indentLevel", "", "<init>", "(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;I)V", "getNode", "()Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;", "getIndentLevel", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class FlatTreeItem {
        private final int indentLevel;
        private final TreeNode node;

        public static /* synthetic */ FlatTreeItem copy$default(FlatTreeItem flatTreeItem, TreeNode treeNode, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                treeNode = flatTreeItem.node;
            }
            if ((i2 & 2) != 0) {
                i = flatTreeItem.indentLevel;
            }
            return flatTreeItem.copy(treeNode, i);
        }

        /* renamed from: component1, reason: from getter */
        public final TreeNode getNode() {
            return this.node;
        }

        /* renamed from: component2, reason: from getter */
        public final int getIndentLevel() {
            return this.indentLevel;
        }

        public final FlatTreeItem copy(TreeNode node, int indentLevel) {
            Intrinsics.checkNotNullParameter(node, "node");
            return new FlatTreeItem(node, indentLevel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FlatTreeItem)) {
                return false;
            }
            FlatTreeItem flatTreeItem = (FlatTreeItem) other;
            return Intrinsics.areEqual(this.node, flatTreeItem.node) && this.indentLevel == flatTreeItem.indentLevel;
        }

        public int hashCode() {
            return (this.node.hashCode() * 31) + Integer.hashCode(this.indentLevel);
        }

        public String toString() {
            return "FlatTreeItem(node=" + this.node + ", indentLevel=" + this.indentLevel + ')';
        }

        public FlatTreeItem(TreeNode treeNode, int i) {
            Intrinsics.checkNotNullParameter(treeNode, "node");
            this.node = treeNode;
            this.indentLevel = i;
        }

        public final TreeNode getNode() {
            return this.node;
        }

        public final int getIndentLevel() {
            return this.indentLevel;
        }
    }
}
