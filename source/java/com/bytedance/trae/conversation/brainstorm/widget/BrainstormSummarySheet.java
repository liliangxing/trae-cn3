package com.bytedance.trae.conversation.brainstorm.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormSummary;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormSummarySheet.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\u001a\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "summary", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;", "onDismissCallback", "Lkotlin/Function0;", "", "getOnDismissCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDismissCallback", "(Lkotlin/jvm/functions/Function0;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormSummarySheet extends BottomSheetDialogFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float SHEET_HEIGHT_RATIO = 0.8f;
    private static final String TAG = "BrainstormSummarySheet";
    private Function0<Unit> onDismissCallback;
    private BrainstormSummary summary;

    /* compiled from: BrainstormSummarySheet.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$Companion;", "", "<init>", "()V", "TAG", "", "SHEET_HEIGHT_RATIO", "", "newInstance", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;", "summary", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BrainstormSummarySheet newInstance(BrainstormSummary summary) {
            Intrinsics.checkNotNullParameter(summary, "summary");
            BrainstormSummarySheet brainstormSummarySheet = new BrainstormSummarySheet();
            brainstormSummarySheet.summary = summary;
            return brainstormSummarySheet;
        }
    }

    public final Function0<Unit> getOnDismissCallback() {
        return this.onDismissCallback;
    }

    public final void setOnDismissCallback(Function0<Unit> function0) {
        this.onDismissCallback = function0;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.trae_layout_brainstorm_summary, container, false);
    }

    public void onStart() {
        View findViewById;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (findViewById = dialog.findViewById(R.id.design_bottom_sheet)) == null) {
            return;
        }
        int i = (int) (getResources().getDisplayMetrics().heightPixels * 0.8f);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = i;
        findViewById.setLayoutParams(layoutParams);
        BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
        from.setPeekHeight(i);
        from.setHideable(true);
        from.setState(3);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        BrainstormSummary brainstormSummary = this.summary;
        if (brainstormSummary == null) {
            return;
        }
        final Context context = view.getContext();
        ((TextView) view.findViewById(C0637R.id.tv_key_points)).setText(CollectionsKt.joinToString$default(brainstormSummary.getKeyPoints(), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormSummarySheet$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence onViewCreated$lambda$2;
                onViewCreated$lambda$2 = BrainstormSummarySheet.onViewCreated$lambda$2(context, (String) obj);
                return onViewCreated$lambda$2;
            }
        }, 30, (Object) null));
        ((TextView) view.findViewById(C0637R.id.tv_action_items)).setText(CollectionsKt.joinToString$default(brainstormSummary.getActionItems(), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormSummarySheet$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                CharSequence onViewCreated$lambda$3;
                onViewCreated$lambda$3 = BrainstormSummarySheet.onViewCreated$lambda$3(context, (String) obj);
                return onViewCreated$lambda$3;
            }
        }, 30, (Object) null));
        view.findViewById(C0637R.id.btn_close_summary).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormSummarySheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BrainstormSummarySheet.onViewCreated$lambda$4(BrainstormSummarySheet.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onViewCreated$lambda$2(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        String string = context.getString(C0637R.string.trae_brainstorm_summary_bullet_prefix, str);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onViewCreated$lambda$3(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        String string = context.getString(C0637R.string.trae_brainstorm_summary_action_prefix, str);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(BrainstormSummarySheet brainstormSummarySheet, View view) {
        brainstormSummarySheet.dismiss();
        Function0<Unit> function0 = brainstormSummarySheet.onDismissCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
