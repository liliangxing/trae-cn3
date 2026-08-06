package com.bytedance.trae.conversation.chat.menu;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.im.service.DiffFileInfo;
import com.bytedance.trae.multilanguage.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RevertConfirmDialog.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "title", "", "diffFileInfos", "", "Lcom/bytedance/trae/im/service/DiffFileInfo;", "cancelText", "confirmText", "customMessage", "onConfirm", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "DiffFileAdapter", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RevertConfirmDialog extends Dialog {
    private final String cancelText;
    private final String confirmText;
    private final String customMessage;
    private final List<DiffFileInfo> diffFileInfos;
    private final Function0<Unit> onConfirm;
    private final String title;

    public /* synthetic */ RevertConfirmDialog(Context context, String str, List list, String str2, String str3, String str4, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, list, str2, str3, (i & 32) != 0 ? null : str4, function0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RevertConfirmDialog(Context context, String str, List<DiffFileInfo> list, String str2, String str3, String str4, Function0<Unit> function0) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "cancelText");
        Intrinsics.checkNotNullParameter(str3, "confirmText");
        Intrinsics.checkNotNullParameter(function0, "onConfirm");
        this.title = str;
        this.diffFileInfos = list;
        this.cancelText = str2;
        this.confirmText = str3;
        this.customMessage = str4;
        this.onConfirm = function0;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0637R.layout.trae_revert_dialog);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-2, -2);
            window.setGravity(17);
            window.setDimAmount(0.5f);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        TextView textView = (TextView) findViewById(C0637R.id.tv_dialog_title);
        TextView textView2 = (TextView) findViewById(C0637R.id.tv_message);
        RecyclerView findViewById = findViewById(C0637R.id.rv_file_list);
        TextView textView3 = (TextView) findViewById(C0637R.id.btn_cancel);
        TextView textView4 = (TextView) findViewById(C0637R.id.btn_confirm);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F5F5F5"));
        gradientDrawable.setCornerRadius(getContext().getResources().getDisplayMetrics().density * 34.0f);
        Object parent = findViewById(C0637R.id.tv_dialog_title).getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setBackground(gradientDrawable);
        textView.setText(this.title);
        List<DiffFileInfo> list = this.diffFileInfos;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        String str = this.customMessage;
        if (str != null) {
            textView2.setText(str);
        } else if (list.isEmpty()) {
            textView2.setText(getContext().getString(R.string.trae_conversation_revert_dialog_message_empty));
        } else {
            textView2.setText(getContext().getString(R.string.trae_conversation_revert_dialog_message, String.valueOf(list.size())));
        }
        if (true ^ list.isEmpty()) {
            findViewById.setLayoutManager(new LinearLayoutManager(getContext()));
            findViewById.setAdapter(new DiffFileAdapter(list));
        } else {
            findViewById.setVisibility(8);
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#29787880"));
        gradientDrawable2.setCornerRadius(getContext().getResources().getDisplayMetrics().density * 100.0f);
        textView3.setText(this.cancelText);
        GradientDrawable gradientDrawable3 = gradientDrawable2;
        textView3.setBackground(gradientDrawable3);
        textView4.setText(this.confirmText);
        textView4.setBackground(gradientDrawable3);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.menu.RevertConfirmDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RevertConfirmDialog.this.dismiss();
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.menu.RevertConfirmDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RevertConfirmDialog.onCreate$lambda$5(RevertConfirmDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5(RevertConfirmDialog revertConfirmDialog, View view) {
        revertConfirmDialog.onConfirm.invoke();
        revertConfirmDialog.dismiss();
    }

    /* compiled from: RevertConfirmDialog.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter$ViewHolder;", "items", "", "Lcom/bytedance/trae/im/service/DiffFileInfo;", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", NewTaskTracker.Param.POSITION, "getItemCount", "ViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class DiffFileAdapter extends RecyclerView.Adapter<ViewHolder> {
        private final List<DiffFileInfo> items;

        public DiffFileAdapter(List<DiffFileInfo> list) {
            Intrinsics.checkNotNullParameter(list, "items");
            this.items = list;
        }

        /* compiled from: RevertConfirmDialog.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvFilePath", "Landroid/widget/TextView;", "getTvFilePath", "()Landroid/widget/TextView;", "tvFileAction", "getTvFileAction", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView tvFileAction;
            private final TextView tvFilePath;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "itemView");
                View findViewById = view.findViewById(C0637R.id.tv_file_path);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                this.tvFilePath = (TextView) findViewById;
                View findViewById2 = view.findViewById(C0637R.id.tv_file_action);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                this.tvFileAction = (TextView) findViewById2;
            }

            public final TextView getTvFilePath() {
                return this.tvFilePath;
            }

            public final TextView getTvFileAction() {
                return this.tvFileAction;
            }
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_revert_file, parent, false);
            Intrinsics.checkNotNull(inflate);
            return new ViewHolder(inflate);
        }

        public void onBindViewHolder(ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            DiffFileInfo diffFileInfo = this.items.get(position);
            TextView tvFilePath = holder.getTvFilePath();
            String filePath = diffFileInfo.getFilePath();
            if (filePath == null) {
                filePath = "";
            }
            tvFilePath.setText(filePath);
        }

        public int getItemCount() {
            return this.items.size();
        }
    }
}
