package com.bytedance.trae.praise;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PraiseDialog.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/praise/PraiseDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "onRateClick", "Lkotlin/Function0;", "", "onLaterClick", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "dismissed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "handleLater", "Companion", "praise_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PraiseDialog extends Dialog {
    private static final String TAG = "Praise";
    private boolean dismissed;
    private final Function0<Unit> onLaterClick;
    private final Function0<Unit> onRateClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PraiseDialog(Context context, Function0<Unit> function0, Function0<Unit> function02) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "onRateClick");
        Intrinsics.checkNotNullParameter(function02, "onLaterClick");
        this.onRateClick = function0;
        this.onLaterClick = function02;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0899R.layout.trae_dialog_praise);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout((int) (window.getContext().getResources().getDisplayMetrics().widthPixels * 0.78d), -2);
            window.setGravity(17);
            window.setDimAmount(0.5f);
        }
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        ImageView imageView = (ImageView) findViewById(C0899R.id.iv_praise_icon);
        imageView.setPadding(0, 0, 0, 0);
        imageView.setCropToPadding(false);
        TextView textView = (TextView) findViewById(C0899R.id.btn_later);
        TextView textView2 = (TextView) findViewById(C0899R.id.btn_rate);
        findViewById(C0899R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.praise.PraiseDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PraiseDialog.onCreate$lambda$1(PraiseDialog.this, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.praise.PraiseDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PraiseDialog.onCreate$lambda$2(PraiseDialog.this, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.praise.PraiseDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PraiseDialog.onCreate$lambda$3(PraiseDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(PraiseDialog praiseDialog, View view) {
        praiseDialog.handleLater();
        praiseDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(PraiseDialog praiseDialog, View view) {
        praiseDialog.handleLater();
        praiseDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(PraiseDialog praiseDialog, View view) {
        FLogger.INSTANCE.mo428i(TAG, "PraiseDialog: Rate Now clicked");
        praiseDialog.dismissed = true;
        praiseDialog.onRateClick.invoke();
        praiseDialog.dismiss();
    }

    private final void handleLater() {
        if (this.dismissed) {
            return;
        }
        this.dismissed = true;
        FLogger.INSTANCE.mo428i(TAG, "PraiseDialog: Later/Cancel");
        this.onLaterClick.invoke();
    }
}
