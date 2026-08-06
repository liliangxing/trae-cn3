package com.bytedance.trae.conversation.plugin;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.network.PluginItem;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PluginsAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\u0014\u0010\u000e\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\u001a\u0010\u000f\u001a\u00020\n2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder;", "<init>", "()V", "items", "", "Lcom/bytedance/trae/conversation/network/PluginItem;", "onItemClickListener", "Lkotlin/Function1;", "", "updateData", "newItems", "", "appendData", "setOnItemClickListener", "listener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "getItemCount", "PluginViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginsAdapter extends RecyclerView.Adapter<PluginViewHolder> {
    private final List<PluginItem> items = new ArrayList();
    private Function1<? super PluginItem, Unit> onItemClickListener;

    public final void updateData(List<PluginItem> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.items.clear();
        this.items.addAll(newItems);
        notifyDataSetChanged();
    }

    public final void appendData(List<PluginItem> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        int size = this.items.size();
        this.items.addAll(newItems);
        notifyItemRangeInserted(size, newItems.size());
    }

    public final void setOnItemClickListener(Function1<? super PluginItem, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onItemClickListener = listener;
    }

    public PluginViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.item_conversation_plugin, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new PluginViewHolder(inflate);
    }

    public void onBindViewHolder(PluginViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final PluginItem pluginItem = this.items.get(position);
        holder.bind(pluginItem);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.plugin.PluginsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PluginsAdapter.onBindViewHolder$lambda$0(PluginsAdapter.this, pluginItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(PluginsAdapter pluginsAdapter, PluginItem pluginItem, View view) {
        Function1<? super PluginItem, Unit> function1 = pluginsAdapter.onItemClickListener;
        if (function1 != null) {
            function1.invoke(pluginItem);
        }
    }

    public int getItemCount() {
        return this.items.size();
    }

    /* compiled from: PluginsAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ivIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "tvName", "Landroid/widget/TextView;", "bind", "", "item", "Lcom/bytedance/trae/conversation/network/PluginItem;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class PluginViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView ivIcon;
        private final TextView tvName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PluginViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            SimpleDraweeView findViewById = view.findViewById(C0637R.id.iv_plugin_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.ivIcon = findViewById;
            View findViewById2 = view.findViewById(C0637R.id.tv_plugin_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.tvName = (TextView) findViewById2;
        }

        public final void bind(PluginItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            TextView textView = this.tvName;
            String displayName = item.getDisplayName();
            if (displayName == null && (displayName = item.getOriginPluginName()) == null) {
                displayName = item.getName();
            }
            textView.setText(displayName);
            String iconUrl = item.getIconUrl();
            String str = iconUrl;
            if (!(str == null || StringsKt.isBlank(str))) {
                this.ivIcon.setImageURI(Uri.parse(iconUrl));
            } else {
                this.ivIcon.setActualImageResource(C0637R.drawable.ic_plugin_default);
            }
        }
    }
}
