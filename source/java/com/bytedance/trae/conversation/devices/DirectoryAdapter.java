package com.bytedance.trae.conversation.devices;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.devices.DirectoryAdapter;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DirectoryAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001a\u001b\u001cB\u008a\u0001\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00126\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\t\u0012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/trae/conversation/devices/DirectoryNode;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onNodeClick", "Lkotlin/Function1;", "", "onNodeSelect", "onFolderNameConfirmed", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "placeholderId", "onFolderNameCancelled", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "getItemViewType", "", NewTaskTracker.Param.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "Companion", "NormalViewHolder", "EditingViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DirectoryAdapter extends ListAdapter<DirectoryNode, RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_EDITING = 1;
    private static final int VIEW_TYPE_NORMAL = 0;
    private final Function1<String, Unit> onFolderNameCancelled;
    private final Function2<String, String, Unit> onFolderNameConfirmed;
    private final Function1<DirectoryNode, Unit> onNodeClick;
    private final Function1<DirectoryNode, Unit> onNodeSelect;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DirectoryAdapter(Function1<? super DirectoryNode, Unit> function1, Function1<? super DirectoryNode, Unit> function12, Function2<? super String, ? super String, Unit> function2, Function1<? super String, Unit> function13) {
        super(new DirectoryDiffCallback());
        Intrinsics.checkNotNullParameter(function1, "onNodeClick");
        Intrinsics.checkNotNullParameter(function12, "onNodeSelect");
        Intrinsics.checkNotNullParameter(function2, "onFolderNameConfirmed");
        Intrinsics.checkNotNullParameter(function13, "onFolderNameCancelled");
        this.onNodeClick = function1;
        this.onNodeSelect = function12;
        this.onFolderNameConfirmed = function2;
        this.onFolderNameCancelled = function13;
    }

    public int getItemViewType(int position) {
        return ((DirectoryNode) getItem(position)).isEditing() ? 1 : 0;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View inflate = from.inflate(C0637R.layout.item_directory_node_editing, parent, false);
            Intrinsics.checkNotNull(inflate);
            return new EditingViewHolder(this, inflate);
        }
        View inflate2 = from.inflate(C0637R.layout.item_directory_node, parent, false);
        Intrinsics.checkNotNull(inflate2);
        return new NormalViewHolder(this, inflate2);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        DirectoryNode directoryNode = (DirectoryNode) getItem(position);
        if (holder instanceof NormalViewHolder) {
            Intrinsics.checkNotNull(directoryNode);
            ((NormalViewHolder) holder).bind(directoryNode);
        } else if (holder instanceof EditingViewHolder) {
            Intrinsics.checkNotNull(directoryNode);
            ((EditingViewHolder) holder).bind(directoryNode);
        }
    }

    /* compiled from: DirectoryAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;Landroid/view/View;)V", "ivArrow", "Landroid/widget/ImageView;", "ivIcon", "tvName", "Landroid/widget/TextView;", "rbSelect", "Landroid/widget/RadioButton;", "progressBar", "Landroid/widget/ProgressBar;", "viewIndent", "bind", "", "node", "Lcom/bytedance/trae/conversation/devices/DirectoryNode;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class NormalViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivArrow;
        private final ImageView ivIcon;
        private final ProgressBar progressBar;
        private final RadioButton rbSelect;
        final /* synthetic */ DirectoryAdapter this$0;
        private final TextView tvName;
        private final View viewIndent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NormalViewHolder(DirectoryAdapter directoryAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = directoryAdapter;
            View findViewById = view.findViewById(C0637R.id.iv_arrow);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.ivArrow = (ImageView) findViewById;
            View findViewById2 = view.findViewById(C0637R.id.iv_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.ivIcon = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(C0637R.id.tv_name);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.tvName = (TextView) findViewById3;
            View findViewById4 = view.findViewById(C0637R.id.rb_select);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.rbSelect = (RadioButton) findViewById4;
            View findViewById5 = view.findViewById(C0637R.id.progress_loading);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.progressBar = (ProgressBar) findViewById5;
            View findViewById6 = view.findViewById(C0637R.id.view_indent);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.viewIndent = findViewById6;
        }

        public final void bind(final DirectoryNode node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.viewIndent.getLayoutParams().width = (int) (node.getDepth() * 16 * this.itemView.getContext().getResources().getDisplayMetrics().density);
            this.viewIndent.requestLayout();
            this.tvName.setText(node.getName());
            this.ivIcon.setImageResource(C0637R.drawable.ic_device_folder);
            if (node.isLoading()) {
                this.ivArrow.setVisibility(4);
                this.progressBar.setVisibility(0);
            } else if (node.getHasChildren()) {
                this.ivArrow.setVisibility(0);
                this.progressBar.setVisibility(8);
                this.ivArrow.setImageResource(node.isExpanded() ? C0637R.drawable.ic_chevron_down : C0637R.drawable.chevron_right_gray);
            } else {
                this.ivArrow.setVisibility(4);
                this.progressBar.setVisibility(8);
            }
            this.rbSelect.setChecked(node.isSelected());
            View view = this.itemView;
            final DirectoryAdapter directoryAdapter = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.DirectoryAdapter$NormalViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DirectoryAdapter.NormalViewHolder.bind$lambda$0(DirectoryAdapter.this, node, view2);
                }
            });
            RadioButton radioButton = this.rbSelect;
            final DirectoryAdapter directoryAdapter2 = this.this$0;
            radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.DirectoryAdapter$NormalViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DirectoryAdapter.NormalViewHolder.bind$lambda$1(DirectoryAdapter.this, node, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(DirectoryAdapter directoryAdapter, DirectoryNode directoryNode, View view) {
            directoryAdapter.onNodeClick.invoke(directoryNode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(DirectoryAdapter directoryAdapter, DirectoryNode directoryNode, View view) {
            directoryAdapter.onNodeSelect.invoke(directoryNode);
        }
    }

    /* compiled from: DirectoryAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;Landroid/view/View;)V", "ivIcon", "Landroid/widget/ImageView;", "etName", "Landroid/widget/EditText;", "progressBar", "Landroid/widget/ProgressBar;", "viewIndent", "hasConfirmed", "", "bind", "", "node", "Lcom/bytedance/trae/conversation/devices/DirectoryNode;", "hideKeyboard", "view", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class EditingViewHolder extends RecyclerView.ViewHolder {
        private final EditText etName;
        private boolean hasConfirmed;
        private final ImageView ivIcon;
        private final ProgressBar progressBar;
        final /* synthetic */ DirectoryAdapter this$0;
        private final View viewIndent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EditingViewHolder(DirectoryAdapter directoryAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = directoryAdapter;
            View findViewById = view.findViewById(C0637R.id.iv_icon_editing);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.ivIcon = (ImageView) findViewById;
            View findViewById2 = view.findViewById(C0637R.id.et_folder_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.etName = (EditText) findViewById2;
            View findViewById3 = view.findViewById(C0637R.id.progress_creating);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.progressBar = (ProgressBar) findViewById3;
            View findViewById4 = view.findViewById(C0637R.id.view_indent_editing);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.viewIndent = findViewById4;
        }

        public final void bind(final DirectoryNode node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.hasConfirmed = false;
            this.viewIndent.getLayoutParams().width = (int) (node.getDepth() * 16 * this.itemView.getContext().getResources().getDisplayMetrics().density);
            this.viewIndent.requestLayout();
            this.ivIcon.setImageResource(C0637R.drawable.ic_device_folder);
            if (node.isLoading()) {
                this.etName.setEnabled(false);
                this.etName.setText(node.getName());
                this.progressBar.setVisibility(0);
                return;
            }
            this.progressBar.setVisibility(8);
            this.etName.setEnabled(true);
            this.etName.setText(node.getName());
            this.etName.setSelectAllOnFocus(true);
            this.etName.requestFocus();
            this.etName.post(new Runnable() { // from class: com.bytedance.trae.conversation.devices.DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DirectoryAdapter.EditingViewHolder.bind$lambda$0(DirectoryAdapter.EditingViewHolder.this);
                }
            });
            EditText editText = this.etName;
            final DirectoryAdapter directoryAdapter = this.this$0;
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.bytedance.trae.conversation.devices.DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda1
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    boolean bind$lambda$1;
                    bind$lambda$1 = DirectoryAdapter.EditingViewHolder.bind$lambda$1(DirectoryAdapter.EditingViewHolder.this, directoryAdapter, node, textView, i, keyEvent);
                    return bind$lambda$1;
                }
            });
            EditText editText2 = this.etName;
            final DirectoryAdapter directoryAdapter2 = this.this$0;
            editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.bytedance.trae.conversation.devices.DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    DirectoryAdapter.EditingViewHolder.bind$lambda$2(DirectoryAdapter.EditingViewHolder.this, directoryAdapter2, node, view, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(EditingViewHolder editingViewHolder) {
            editingViewHolder.etName.selectAll();
            Object systemService = editingViewHolder.itemView.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).showSoftInput(editingViewHolder.etName, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean bind$lambda$1(EditingViewHolder editingViewHolder, DirectoryAdapter directoryAdapter, DirectoryNode directoryNode, TextView textView, int i, KeyEvent keyEvent) {
            if (i != 2 && i != 6) {
                return false;
            }
            if (!editingViewHolder.hasConfirmed) {
                editingViewHolder.hasConfirmed = true;
                directoryAdapter.onFolderNameConfirmed.invoke(directoryNode.getId(), editingViewHolder.etName.getText().toString());
            }
            editingViewHolder.hideKeyboard(editingViewHolder.etName);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(EditingViewHolder editingViewHolder, DirectoryAdapter directoryAdapter, DirectoryNode directoryNode, View view, boolean z) {
            if (z || editingViewHolder.hasConfirmed) {
                return;
            }
            editingViewHolder.hasConfirmed = true;
            String obj = StringsKt.trim(editingViewHolder.etName.getText().toString()).toString();
            if (obj.length() == 0) {
                directoryAdapter.onFolderNameCancelled.invoke(directoryNode.getId());
            } else {
                directoryAdapter.onFolderNameConfirmed.invoke(directoryNode.getId(), obj);
            }
        }

        private final void hideKeyboard(View view) {
            Object systemService = view.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
