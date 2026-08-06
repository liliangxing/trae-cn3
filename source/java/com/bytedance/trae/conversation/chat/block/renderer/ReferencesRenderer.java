package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer;
import com.bytedance.trae.im.model.DocReference;
import com.bytedance.trae.im.model.DocReferencesData;
import com.bytedance.trae.im.model.Reference;
import com.bytedance.trae.im.model.SearchReference;
import com.bytedance.trae.im.model.SearchReferenceData;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ReferencesRenderer.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "createRefItem", "icon", "", "text", "density", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ReferencesRenderer implements IBlockRenderer<AgentContentBlock.References> {

    @Deprecated
    public static final String BLOCK_TAG = "AgentBlock";
    private static final Companion Companion = new Companion(null);

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.References references) {
        IBlockRenderer.DefaultImpls.update(this, view, references);
    }

    /* compiled from: ReferencesRenderer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer$Companion;", "", "<init>", "()V", "BLOCK_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.References block) {
        List<DocReference> documents;
        List<SearchReference> references;
        List<DocReference> documents2;
        List<SearchReference> references2;
        List<DocReference> documents3;
        List<SearchReference> references3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        int size = block.getCodeReferences().size();
        SearchReferenceData searchReferences = block.getSearchReferences();
        int size2 = size + ((searchReferences == null || (references3 = searchReferences.getReferences()) == null) ? 0 : references3.size());
        DocReferencesData docReferences = block.getDocReferences();
        FLogger.INSTANCE.i("AgentBlock", "[ReferencesRenderer] render: references=" + (size2 + ((docReferences == null || (documents3 = docReferences.getDocuments()) == null) ? 0 : documents3.size())));
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i = (int) (4 * f);
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i;
        linearLayout.setLayoutParams(layoutParams);
        int size3 = block.getCodeReferences().size();
        SearchReferenceData searchReferences2 = block.getSearchReferences();
        int size4 = (searchReferences2 == null || (references2 = searchReferences2.getReferences()) == null) ? 0 : references2.size();
        DocReferencesData docReferences2 = block.getDocReferences();
        int size5 = (docReferences2 == null || (documents2 = docReferences2.getDocuments()) == null) ? 0 : documents2.size();
        int i2 = size3 + size4 + size5;
        ArrayList arrayList = new ArrayList();
        if (size4 > 0) {
            String string = context.getString(C0637R.string.trae_chat_ref_searched_web);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            arrayList.add(string);
        }
        if (size3 > 0) {
            String string2 = context.getString(C0637R.string.trae_chat_ref_read_files, Integer.valueOf(size3));
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            arrayList.add(string2);
        }
        if (size5 > 0) {
            String string3 = context.getString(C0637R.string.trae_chat_ref_docs, Integer.valueOf(size5));
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            arrayList.add(string3);
        }
        String string4 = arrayList.isEmpty() ? context.getString(C0637R.string.trae_chat_ref_count, Integer.valueOf(i2)) : CollectionsKt.joinToString$default(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        Intrinsics.checkNotNull(string4);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        int i3 = (int) (8 * f);
        float f2 = 6 * f;
        int i4 = (int) f2;
        linearLayout2.setPadding(i3, i4, i3, i4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l1));
        gradientDrawable.setCornerRadius(f2);
        linearLayout2.setBackground(gradientDrawable);
        linearLayout.addView(linearLayout2);
        final TextView textView = new TextView(context);
        textView.setText(string4);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        textView.setTextSize(2, 13.0f);
        textView.setCompoundDrawablePadding(i);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, C0637R.drawable.chevron_unfold, 0);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        final LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(1);
        linearLayout3.setVisibility(8);
        linearLayout3.setPadding(i3, i, i3, 0);
        linearLayout.addView(linearLayout3);
        for (Reference reference : block.getCodeReferences()) {
            String fileName = reference.getFileName();
            if (fileName == null) {
                String uri = reference.getUri();
                fileName = null;
                if (uri != null) {
                    fileName = StringsKt.substringAfterLast$default(uri, '/', (String) null, 2, (Object) null);
                }
                if (fileName == null) {
                    fileName = context.getString(C0637R.string.trae_chat_ref_file);
                    Intrinsics.checkNotNullExpressionValue(fileName, "getString(...)");
                }
            }
            linearLayout3.addView(createRefItem(context, "📄", fileName, f));
        }
        SearchReferenceData searchReferences3 = block.getSearchReferences();
        if (searchReferences3 != null && (references = searchReferences3.getReferences()) != null) {
            for (SearchReference searchReference : references) {
                String title = searchReference.getTitle();
                if (title == null && (title = searchReference.getLink()) == null) {
                    title = context.getString(C0637R.string.trae_chat_ref_web_result);
                    Intrinsics.checkNotNullExpressionValue(title, "getString(...)");
                }
                linearLayout3.addView(createRefItem(context, "🌐", title, f));
            }
        }
        DocReferencesData docReferences3 = block.getDocReferences();
        if (docReferences3 != null && (documents = docReferences3.getDocuments()) != null) {
            for (DocReference docReference : documents) {
                String title2 = docReference.getTitle();
                if (title2 == null && (title2 = docReference.getLink()) == null) {
                    title2 = context.getString(C0637R.string.trae_chat_ref_document);
                    Intrinsics.checkNotNullExpressionValue(title2, "getString(...)");
                }
                linearLayout3.addView(createRefItem(context, "📑", title2, f));
            }
        }
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ReferencesRenderer$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReferencesRenderer.render$lambda$9(linearLayout3, textView, view);
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void render$lambda$9(LinearLayout linearLayout, TextView textView, View view) {
        if (linearLayout.getVisibility() == 8) {
            linearLayout.setVisibility(0);
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, C0637R.drawable.chevron_fold, 0);
        } else {
            linearLayout.setVisibility(8);
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, C0637R.drawable.chevron_unfold, 0);
        }
    }

    private final View createRefItem(Context context, String icon, String text, float density) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int i = (int) (2 * density);
        linearLayout.setPadding(0, i, 0, i);
        TextView textView = new TextView(context);
        textView.setText(icon);
        textView.setTextSize(2, 12.0f);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setText(text);
        textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
        textView2.setTextSize(2, 12.0f);
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart((int) (4 * density));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView2, layoutParams);
        return linearLayout;
    }
}
