package com.bytedance.trae.conversation.devices;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.trae.conversation.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectProjectPermissionDialog.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "folderName", "", "onAllow", "Lkotlin/Function0;", "", "onCancel", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectProjectPermissionDialog extends Dialog {
    private final String folderName;
    private final Function0<Unit> onAllow;
    private final Function0<Unit> onCancel;

    public /* synthetic */ SelectProjectPermissionDialog(Context context, String str, Function0 function0, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, function0, (i & 8) != 0 ? new Function0() { // from class: com.bytedance.trae.conversation.devices.SelectProjectPermissionDialog$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function02);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectProjectPermissionDialog(Context context, String folderName, Function0<Unit> onAllow, Function0<Unit> onCancel) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(onAllow, "onAllow");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        this.folderName = folderName;
        this.onAllow = onAllow;
        this.onCancel = onCancel;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trae_select_project_permission);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout((int) (300 * window.getContext().getResources().getDisplayMetrics().density), -2);
            window.setGravity(17);
            window.setDimAmount(0.5f);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        TextView textView2 = (TextView) findViewById(R.id.tv_subtitle);
        TextView textView3 = (TextView) findViewById(R.id.btn_allow);
        TextView textView4 = (TextView) findViewById(R.id.btn_cancel);
        textView.setText(getContext().getString(R.string.trae_select_project_permission_title, this.folderName));
        textView2.setText(getContext().getString(R.string.trae_select_project_permission_subtitle));
        textView3.setText(getContext().getString(R.string.trae_select_project_permission_allow));
        textView4.setText(getContext().getString(R.string.trae_select_project_permission_cancel));
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.SelectProjectPermissionDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectProjectPermissionDialog.onCreate$lambda$2(SelectProjectPermissionDialog.this, view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.SelectProjectPermissionDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectProjectPermissionDialog.onCreate$lambda$3(SelectProjectPermissionDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(SelectProjectPermissionDialog selectProjectPermissionDialog, View view) {
        selectProjectPermissionDialog.onAllow.invoke();
        selectProjectPermissionDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(SelectProjectPermissionDialog selectProjectPermissionDialog, View view) {
        selectProjectPermissionDialog.onCancel.invoke();
        selectProjectPermissionDialog.dismiss();
    }
}
