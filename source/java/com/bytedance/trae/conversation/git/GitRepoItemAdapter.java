package com.bytedance.trae.conversation.git;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GitRepoItemAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/trae/conversation/git/GitRepoItem;", "Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$ViewHolder;", "onRepoClick", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "ViewHolder", "DiffCallback", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitRepoItemAdapter extends ListAdapter<GitRepoItem, ViewHolder> {

    /* renamed from: DiffCallback, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Function1<GitRepoItem, Unit> onRepoClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GitRepoItemAdapter(Function1<? super GitRepoItem, Unit> function1) {
        super(INSTANCE);
        Intrinsics.checkNotNullParameter(function1, "onRepoClick");
        this.onRepoClick = function1;
    }

    /* compiled from: GitRepoItemAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "ivRadio", "Landroid/widget/ImageView;", "getIvRadio", "()Landroid/widget/ImageView;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivRadio;
        private final TextView tvTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(C0637R.id.tv_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.tvTitle = (TextView) findViewById;
            View findViewById2 = view.findViewById(C0637R.id.iv_radio);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.ivRadio = (ImageView) findViewById2;
        }

        public final TextView getTvTitle() {
            return this.tvTitle;
        }

        public final ImageView getIvRadio() {
            return this.ivRadio;
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_git_repo, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(inflate);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final GitRepoItem gitRepoItem = (GitRepoItem) getItem(position);
        holder.getTvTitle().setText(gitRepoItem.getTitle());
        if (gitRepoItem.isSelected()) {
            holder.getIvRadio().setImageResource(C0637R.drawable.ic_radio_selected);
        } else {
            holder.getIvRadio().setImageResource(C0637R.drawable.ic_radio_unselected);
        }
        holder.itemView.setEnabled(gitRepoItem.isEnabled());
        holder.itemView.setAlpha(gitRepoItem.isEnabled() ? 1.0f : 0.2f);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.git.GitRepoItemAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GitRepoItemAdapter.onBindViewHolder$lambda$0(GitRepoItem.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(GitRepoItem gitRepoItem, GitRepoItemAdapter gitRepoItemAdapter, View view) {
        if (gitRepoItem.isEnabled()) {
            Function1<GitRepoItem, Unit> function1 = gitRepoItemAdapter.onRepoClick;
            Intrinsics.checkNotNull(gitRepoItem);
            function1.invoke(gitRepoItem);
        }
    }

    /* compiled from: GitRepoItemAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/bytedance/trae/conversation/git/GitRepoItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.bytedance.trae.conversation.git.GitRepoItemAdapter$DiffCallback, reason: from kotlin metadata */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion extends DiffUtil.ItemCallback<GitRepoItem> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public boolean areItemsTheSame(GitRepoItem oldItem, GitRepoItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getId(), newItem.getId());
        }

        public boolean areContentsTheSame(GitRepoItem oldItem, GitRepoItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }
}
