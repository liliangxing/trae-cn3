package com.bytedance.trae.conversation.ideproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.ideproject.IDEProjectAdapter;
import com.bytedance.trae.conversation.network.ProjectItem;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDEProjectAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00152\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0015\u0016B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\nJ\u001c\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00062\n\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0011H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/trae/conversation/network/ProjectItem;", "Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;", "onItemClick", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "selectedProjectId", "", "setSelectedProjectId", "projectId", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "Companion", "ProjectViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IDEProjectAdapter extends ListAdapter<ProjectItem, ProjectViewHolder> {
    private static final IDEProjectAdapter$Companion$DiffCallback$1 DiffCallback = new DiffUtil.ItemCallback<ProjectItem>() { // from class: com.bytedance.trae.conversation.ideproject.IDEProjectAdapter$Companion$DiffCallback$1
        public boolean areItemsTheSame(ProjectItem oldItem, ProjectItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getProjectId(), newItem.getProjectId());
        }

        public boolean areContentsTheSame(ProjectItem oldItem, ProjectItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };
    private final Function1<ProjectItem, Unit> onItemClick;
    private String selectedProjectId;

    public static final /* synthetic */ ProjectItem access$getItem(IDEProjectAdapter iDEProjectAdapter, int i) {
        return (ProjectItem) iDEProjectAdapter.getItem(i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public IDEProjectAdapter(Function1<? super ProjectItem, Unit> function1) {
        super(DiffCallback);
        Intrinsics.checkNotNullParameter(function1, "onItemClick");
        this.onItemClick = function1;
    }

    public final void setSelectedProjectId(String projectId) {
        String str = this.selectedProjectId;
        this.selectedProjectId = projectId;
        List currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        int i = 0;
        for (Object obj : currentList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ProjectItem projectItem = (ProjectItem) obj;
            if (Intrinsics.areEqual(projectItem.getProjectId(), str) || Intrinsics.areEqual(projectItem.getProjectId(), projectId)) {
                notifyItemChanged(i);
            }
            i = i2;
        }
    }

    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_ide_project, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new ProjectViewHolder(this, inflate);
    }

    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind((ProjectItem) item);
    }

    /* compiled from: IDEProjectAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;Landroid/view/View;)V", "radioButton", "Landroid/widget/RadioButton;", "tvName", "Landroid/widget/TextView;", "tvPath", "bind", "", "item", "Lcom/bytedance/trae/conversation/network/ProjectItem;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class ProjectViewHolder extends RecyclerView.ViewHolder {
        private final RadioButton radioButton;
        final /* synthetic */ IDEProjectAdapter this$0;
        private final TextView tvName;
        private final TextView tvPath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProjectViewHolder(final IDEProjectAdapter iDEProjectAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = iDEProjectAdapter;
            View findViewById = view.findViewById(C0637R.id.radio_project);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.radioButton = (RadioButton) findViewById;
            View findViewById2 = view.findViewById(C0637R.id.tv_project_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.tvName = (TextView) findViewById2;
            View findViewById3 = view.findViewById(C0637R.id.tv_project_path);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.tvPath = (TextView) findViewById3;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.ideproject.IDEProjectAdapter$ProjectViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    IDEProjectAdapter.ProjectViewHolder._init_$lambda$0(IDEProjectAdapter.ProjectViewHolder.this, iDEProjectAdapter, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(ProjectViewHolder projectViewHolder, IDEProjectAdapter iDEProjectAdapter, View view) {
            int adapterPosition = projectViewHolder.getAdapterPosition();
            if (adapterPosition != -1) {
                ProjectItem access$getItem = IDEProjectAdapter.access$getItem(iDEProjectAdapter, adapterPosition);
                iDEProjectAdapter.setSelectedProjectId(access$getItem.getProjectId());
                Function1 function1 = iDEProjectAdapter.onItemClick;
                Intrinsics.checkNotNull(access$getItem);
                function1.invoke(access$getItem);
            }
        }

        public final void bind(ProjectItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            TextView textView = this.tvName;
            IDEProjectNameUtil iDEProjectNameUtil = IDEProjectNameUtil.INSTANCE;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setText(iDEProjectNameUtil.getProjectName(context, item.getFolderPath(), item.getWorkspaceType()));
            this.tvPath.setText(item.getFolderPath());
            this.radioButton.setChecked(Intrinsics.areEqual(item.getProjectId(), this.this$0.selectedProjectId));
        }
    }
}
