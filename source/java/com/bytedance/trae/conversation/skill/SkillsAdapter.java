package com.bytedance.trae.conversation.skill;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.network.SkillItem;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SkillsAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B/\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001a\u0010\r\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/skill/SkillsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/conversation/skill/SkillsAdapter$SkillViewHolder;", "items", "", "Lcom/bytedance/trae/conversation/network/SkillItem;", "onItemClick", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "updateData", "newItems", "setOnItemClickListener", "listener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "getItemCount", "SkillViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SkillsAdapter extends RecyclerView.Adapter<SkillViewHolder> {
    private List<SkillItem> items;
    private Function1<? super SkillItem, Unit> onItemClick;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SkillsAdapter() {
        this(r0, r0, 3, r0);
        List list = null;
    }

    public /* synthetic */ SkillsAdapter(List list, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : function1);
    }

    public SkillsAdapter(List<SkillItem> list, Function1<? super SkillItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.items = list;
        this.onItemClick = function1;
    }

    public final void updateData(List<SkillItem> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        Log.d("SkillsAdapter", "updateData: size=" + newItems.size());
        ArrayList arrayList = new ArrayList();
        for (Object obj : newItems) {
            if (((SkillItem) obj).getEnabled()) {
                arrayList.add(obj);
            }
        }
        this.items = arrayList;
        notifyDataSetChanged();
    }

    public final void setOnItemClickListener(Function1<? super SkillItem, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onItemClick = listener;
    }

    public SkillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Log.d("SkillsAdapter", "onCreateViewHolder");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.item_conversation_skill, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new SkillViewHolder(inflate);
    }

    public void onBindViewHolder(SkillViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Log.d("SkillsAdapter", "onBindViewHolder: position=" + position + ", name=" + this.items.get(position).getName());
        final SkillItem skillItem = this.items.get(position);
        holder.bind(skillItem);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.skill.SkillsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SkillsAdapter.onBindViewHolder$lambda$1(SkillsAdapter.this, skillItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(SkillsAdapter skillsAdapter, SkillItem skillItem, View view) {
        Function1<? super SkillItem, Unit> function1 = skillsAdapter.onItemClick;
        if (function1 != null) {
            function1.invoke(skillItem);
        }
    }

    public int getItemCount() {
        return this.items.size();
    }

    /* compiled from: SkillsAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/skill/SkillsAdapter$SkillViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvName", "Landroid/widget/TextView;", "bind", "", "item", "Lcom/bytedance/trae/conversation/network/SkillItem;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class SkillViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SkillViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(C0637R.id.tv_skill_name);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.tvName = (TextView) findViewById;
        }

        public final void bind(SkillItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.tvName.setText(item.getName());
        }
    }
}
