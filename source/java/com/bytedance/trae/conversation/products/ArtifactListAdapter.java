package com.bytedance.trae.conversation.products;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactListAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\u0012\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;", "onItemClick", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/products/ArtifactItem;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "items", "", "submitList", "newItems", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "getItemCount", "ViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<ArtifactItem> items;
    private final Function1<ArtifactItem, Unit> onItemClick;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArtifactListAdapter() {
        this(r0, 1, r0);
        Function1 function1 = null;
    }

    public /* synthetic */ ArtifactListAdapter(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArtifactListAdapter(Function1<? super ArtifactItem, Unit> function1) {
        this.onItemClick = function1;
        this.items = new ArrayList();
    }

    public final void submitList(List<ArtifactItem> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.items.clear();
        this.items.addAll(newItems);
        notifyDataSetChanged();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_artifact, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(inflate);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final ArtifactItem artifactItem = this.items.get(position);
        holder.getTvName().setText(artifactItem.getName());
        holder.getIvIcon().setImageResource(artifactItem.getIconResId());
        boolean z = artifactItem.getIconResId() == C0637R.drawable.ic_folder;
        float f = holder.itemView.getContext().getResources().getDisplayMetrics().density;
        ViewGroup.LayoutParams layoutParams = holder.getIvIcon().getLayoutParams();
        if (z) {
            layoutParams.width = (int) (30 * f);
            layoutParams.height = (int) (23 * f);
        } else {
            int i = (int) (36 * f);
            layoutParams.width = i;
            layoutParams.height = i;
        }
        holder.getIvIcon().setLayoutParams(layoutParams);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.ArtifactListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactListAdapter.onBindViewHolder$lambda$0(ArtifactListAdapter.this, artifactItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(ArtifactListAdapter artifactListAdapter, ArtifactItem artifactItem, View view) {
        Function1<ArtifactItem, Unit> function1 = artifactListAdapter.onItemClick;
        if (function1 != null) {
            function1.invoke(artifactItem);
        }
    }

    public int getItemCount() {
        return this.items.size();
    }

    /* compiled from: ArtifactListAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ivIcon", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "tvName", "Landroid/widget/TextView;", "getTvName", "()Landroid/widget/TextView;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivIcon;
        private final TextView tvName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(C0637R.id.iv_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.ivIcon = (ImageView) findViewById;
            View findViewById2 = view.findViewById(C0637R.id.tv_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.tvName = (TextView) findViewById2;
        }

        public final ImageView getIvIcon() {
            return this.ivIcon;
        }

        public final TextView getTvName() {
            return this.tvName;
        }
    }
}
