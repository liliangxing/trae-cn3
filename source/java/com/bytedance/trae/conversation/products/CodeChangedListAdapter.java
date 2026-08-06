package com.bytedance.trae.conversation.products;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.im.model.FileDiffInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CodeChangedListAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u001f\u0012\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u001b\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter$ViewHolder;", "onItemClick", "Lkotlin/Function1;", "Lcom/bytedance/trae/im/model/FileDiffInfo;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "items", "", "submitList", "newItems", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "getItemCount", "extractFileName", "", "filePath", "extractFileExtension", "getCodeFileIcon", "ViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CodeChangedListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<FileDiffInfo> items;
    private final Function1<FileDiffInfo, Unit> onItemClick;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CodeChangedListAdapter() {
        this(r0, 1, r0);
        Function1 function1 = null;
    }

    public /* synthetic */ CodeChangedListAdapter(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CodeChangedListAdapter(Function1<? super FileDiffInfo, Unit> function1) {
        this.onItemClick = function1;
        this.items = new ArrayList();
    }

    public final void submitList(List<FileDiffInfo> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.items.clear();
        this.items.addAll(newItems);
        notifyDataSetChanged();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_code_changed, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(inflate);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final FileDiffInfo fileDiffInfo = this.items.get(position);
        holder.getTvFileName().setText(extractFileName(fileDiffInfo.getFilePath()));
        holder.getIvFileIcon().setImageResource(getCodeFileIcon(fileDiffInfo.getFilePath()));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.CodeChangedListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CodeChangedListAdapter.onBindViewHolder$lambda$0(CodeChangedListAdapter.this, fileDiffInfo, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(CodeChangedListAdapter codeChangedListAdapter, FileDiffInfo fileDiffInfo, View view) {
        Function1<FileDiffInfo, Unit> function1 = codeChangedListAdapter.onItemClick;
        if (function1 != null) {
            function1.invoke(fileDiffInfo);
        }
    }

    public int getItemCount() {
        return this.items.size();
    }

    private final String extractFileName(String filePath) {
        String str = filePath;
        if (str == null || str.length() == 0) {
            return "";
        }
        return StringsKt.substringAfterLast$default(filePath, StringsKt.contains$default(str, '\\', false, 2, (Object) null) ? '\\' : '/', (String) null, 2, (Object) null);
    }

    private final String extractFileExtension(String filePath) {
        String str = filePath;
        if (str == null || str.length() == 0) {
            return "";
        }
        String extractFileName = extractFileName(filePath);
        int lastIndexOf$default = StringsKt.lastIndexOf$default(extractFileName, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default <= 0) {
            return "";
        }
        String substring = extractFileName.substring(lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0169, code lost:
    
        if (r2.equals("cpp") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0183, code lost:
    
        if (r2.equals("sh") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01ac, code lost:
    
        if (r2.equals("md") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01b8, code lost:
    
        if (r2.equals("kt") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x01dc, code lost:
    
        if (r2.equals("cc") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01e8, code lost:
    
        if (r2.equals("h") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (r2.equals("markdown") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_type_markdown;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
    
        if (r2.equals("yaml") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_lang_yaml;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        if (r2.equals("xlsx") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_type_xlsx;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        if (r2.equals("scss") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_lang_css;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        if (r2.equals("sass") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
    
        if (r2.equals("bash") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_type_bash;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b0, code lost:
    
        if (r2.equals("yml") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ce, code lost:
    
        if (r2.equals("xls") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0113, code lost:
    
        if (r2.equals("kts") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_lang_java;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x012b, code lost:
    
        if (r2.equals("hpp") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_type_header;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0135, code lost:
    
        if (r2.equals("elx") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0151, code lost:
    
        if (r2.equals("cxx") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_lang_cpp;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0028. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int getCodeFileIcon(String filePath) {
        String str = filePath;
        if (str == null || str.length() == 0) {
            return C0637R.drawable.ic_artifact_code;
        }
        String lowerCase = extractFileExtension(filePath).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case 99:
                if (lowerCase.equals("c")) {
                    return C0637R.drawable.explorer_lang_c;
                }
                return C0637R.drawable.ic_artifact_code;
            case 104:
                break;
            case 3168:
                break;
            case 3304:
                if (lowerCase.equals("go")) {
                    return C0637R.drawable.explorer_lang_go;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3401:
                if (lowerCase.equals("js")) {
                    return C0637R.drawable.explorer_lang_js;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3433:
                break;
            case 3479:
                break;
            case 3593:
                if (lowerCase.equals("py")) {
                    return C0637R.drawable.explorer_lang_python;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3649:
                if (lowerCase.equals("rs")) {
                    return C0637R.drawable.explorer_lang_rs;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3669:
                break;
            case 3711:
                if (lowerCase.equals("ts")) {
                    return C0637R.drawable.explorer_lang_ts;
                }
                return C0637R.drawable.ic_artifact_code;
            case 98723:
                break;
            case 98819:
                if (lowerCase.equals("css")) {
                    return C0637R.drawable.explorer_lang_css;
                }
                return C0637R.drawable.ic_artifact_code;
            case 98979:
                break;
            case 99811:
                if (lowerCase.equals("dts")) {
                    return C0637R.drawable.explorer_lang_dts;
                }
                return C0637R.drawable.ic_artifact_code;
            case 100529:
                break;
            case 103528:
                break;
            case 105551:
                if (lowerCase.equals("jsx")) {
                    return C0637R.drawable.explorer_lang_react;
                }
                return C0637R.drawable.ic_artifact_code;
            case 106538:
                break;
            case 110834:
                if (lowerCase.equals("pdf")) {
                    return C0637R.drawable.explorer_type_pdf;
                }
                return C0637R.drawable.ic_artifact_code;
            case 115161:
                if (lowerCase.equals("tsx")) {
                    return C0637R.drawable.explorer_lang_react;
                }
                return C0637R.drawable.ic_artifact_code;
            case 115312:
                if (lowerCase.equals("txt")) {
                    return C0637R.drawable.explorer_type_txt;
                }
                return C0637R.drawable.ic_artifact_code;
            case 117126:
                if (lowerCase.equals("vue")) {
                    return C0637R.drawable.explorer_lang_vue;
                }
                return C0637R.drawable.ic_artifact_code;
            case 118783:
                break;
            case 118807:
                if (lowerCase.equals("xml")) {
                    return C0637R.drawable.explorer_lang_xml;
                }
                return C0637R.drawable.ic_artifact_code;
            case 119768:
                break;
            case 3016404:
                break;
            case 3213227:
                if (lowerCase.equals("html")) {
                    return C0637R.drawable.explorer_lang_html;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3254818:
                if (lowerCase.equals("java")) {
                    return C0637R.drawable.explorer_lang_java;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3271912:
                if (lowerCase.equals("json")) {
                    return C0637R.drawable.explorer_lang_json;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3318169:
                if (lowerCase.equals("less")) {
                    return C0637R.drawable.explorer_lang_css;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3522862:
                break;
            case 3524784:
                break;
            case 3682393:
                break;
            case 3701415:
                break;
            case 246938863:
                break;
            default:
                return C0637R.drawable.ic_artifact_code;
        }
    }

    /* compiled from: CodeChangedListAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ivFileIcon", "Landroid/widget/ImageView;", "getIvFileIcon", "()Landroid/widget/ImageView;", "tvFileName", "Landroid/widget/TextView;", "getTvFileName", "()Landroid/widget/TextView;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivFileIcon;
        private final TextView tvFileName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(C0637R.id.iv_file_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.ivFileIcon = (ImageView) findViewById;
            View findViewById2 = view.findViewById(C0637R.id.tv_file_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.tvFileName = (TextView) findViewById2;
        }

        public final ImageView getIvFileIcon() {
            return this.ivFileIcon;
        }

        public final TextView getTvFileName() {
            return this.tvFileName;
        }
    }
}
