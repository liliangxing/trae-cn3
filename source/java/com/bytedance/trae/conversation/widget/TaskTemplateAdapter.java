package com.bytedance.trae.conversation.widget;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.databinding.TraeItemTaskTemplateBinding;
import com.bytedance.trae.conversation.network.TaskTemplateRepository;
import com.bytedance.trae.conversation.tracker.InputTracker;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.conversation.widget.TaskTemplateAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskTemplateAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;", "Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;", "onItemClick", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "ViewHolder", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskTemplateAdapter extends ListAdapter<TaskTemplateRepository.TaskTemplateModel, ViewHolder> {
    private static final TaskTemplateAdapter$Companion$DIFF_CALLBACK$1 DIFF_CALLBACK = new DiffUtil.ItemCallback<TaskTemplateRepository.TaskTemplateModel>() { // from class: com.bytedance.trae.conversation.widget.TaskTemplateAdapter$Companion$DIFF_CALLBACK$1
        public boolean areItemsTheSame(TaskTemplateRepository.TaskTemplateModel oldItem, TaskTemplateRepository.TaskTemplateModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }

        public boolean areContentsTheSame(TaskTemplateRepository.TaskTemplateModel oldItem, TaskTemplateRepository.TaskTemplateModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };
    private final Function1<TaskTemplateRepository.TaskTemplateModel, Unit> onItemClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TaskTemplateAdapter(Function1<? super TaskTemplateRepository.TaskTemplateModel, Unit> function1) {
        super(DIFF_CALLBACK);
        Intrinsics.checkNotNullParameter(function1, "onItemClick");
        this.onItemClick = function1;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        TraeItemTaskTemplateBinding inflate = TraeItemTaskTemplateBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate, this.onItemClick);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind((TaskTemplateRepository.TaskTemplateModel) item, position);
    }

    /* compiled from: TaskTemplateAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;", "onItemClick", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;", "", "<init>", "(Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;Lkotlin/jvm/functions/Function1;)V", "bind", "item", NewTaskTracker.Param.POSITION, "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final TraeItemTaskTemplateBinding binding;
        private final Function1<TaskTemplateRepository.TaskTemplateModel, Unit> onItemClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ViewHolder(TraeItemTaskTemplateBinding traeItemTaskTemplateBinding, Function1<? super TaskTemplateRepository.TaskTemplateModel, Unit> function1) {
            super(traeItemTaskTemplateBinding.getRoot());
            Intrinsics.checkNotNullParameter(traeItemTaskTemplateBinding, "binding");
            Intrinsics.checkNotNullParameter(function1, "onItemClick");
            this.binding = traeItemTaskTemplateBinding;
            this.onItemClick = function1;
        }

        public final void bind(final TaskTemplateRepository.TaskTemplateModel item, final int position) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.binding.tvTitle.setText(item.getTitle());
            if (item.getIcon().length() > 0) {
                this.binding.ivIcon.setVisibility(0);
                this.binding.ivIcon.setImageURI(Uri.parse(item.getIcon()));
            } else {
                this.binding.ivIcon.setVisibility(8);
            }
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.TaskTemplateAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskTemplateAdapter.ViewHolder.bind$lambda$0(position, item, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(int i, TaskTemplateRepository.TaskTemplateModel taskTemplateModel, ViewHolder viewHolder, View view) {
            try {
                InputTracker.INSTANCE.trackShowcaseClick(i, String.valueOf(taskTemplateModel.getId()));
            } catch (Throwable unused) {
            }
            viewHolder.onItemClick.invoke(taskTemplateModel);
        }
    }
}
