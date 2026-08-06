package com.bytedance.trae.conversation.brainstorm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage;
import com.bytedance.trae.conversation.brainstorm.model.MessageRole;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormMessageAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;", "Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$MessageViewHolder;", "<init>", "()V", "getItemViewType", "", NewTaskTracker.Param.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "Companion", "MessageViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormMessageAdapter extends ListAdapter<BrainstormMessage, MessageViewHolder> {
    private static final BrainstormMessageAdapter$Companion$DIFF_CALLBACK$1 DIFF_CALLBACK = new DiffUtil.ItemCallback<BrainstormMessage>() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.BrainstormMessageAdapter$Companion$DIFF_CALLBACK$1
        public boolean areItemsTheSame(BrainstormMessage oldItem, BrainstormMessage newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getId(), newItem.getId());
        }

        public boolean areContentsTheSame(BrainstormMessage oldItem, BrainstormMessage newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };
    private static final int TYPE_ASSISTANT = 1;
    private static final int TYPE_USER = 0;

    /* compiled from: BrainstormMessageAdapter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageRole.values().length];
            try {
                iArr[MessageRole.User.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageRole.Assistant.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BrainstormMessageAdapter() {
        super(DIFF_CALLBACK);
    }

    public int getItemViewType(int position) {
        int i = WhenMappings.$EnumSwitchMapping$0[((BrainstormMessage) getItem(position)).getRole().ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int i;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            i = C0637R.layout.trae_item_brainstorm_message_user;
        } else {
            i = C0637R.layout.trae_item_brainstorm_message_ai;
        }
        View inflate = LayoutInflater.from(parent.getContext()).inflate(i, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new MessageViewHolder(inflate);
    }

    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind((BrainstormMessage) item);
    }

    /* compiled from: BrainstormMessageAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$MessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvContent", "Landroid/widget/TextView;", "bind", "", "message", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class MessageViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(C0637R.id.tv_message_content);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.tvContent = (TextView) findViewById;
        }

        public final void bind(BrainstormMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.tvContent.setText(message.getContent());
        }
    }
}
