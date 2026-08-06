package com.huawei.hms.p030ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.UIUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractDialog {

    /* renamed from: a */
    private Activity f1841a;

    /* renamed from: b */
    private AlertDialog f1842b;

    /* renamed from: c */
    private Callback f1843c;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface Callback {
        void onCancel(AbstractDialog abstractDialog);

        void onDoWork(AbstractDialog abstractDialog);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.ui.AbstractDialog$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class DialogInterfaceOnClickListenerC1263a implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC1263a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AbstractDialog.this.fireDoWork();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.ui.AbstractDialog$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class DialogInterfaceOnClickListenerC1264b implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC1264b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AbstractDialog.this.cancel();
        }
    }

    /* renamed from: com.huawei.hms.ui.AbstractDialog$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    class DialogInterfaceOnCancelListenerC1265c implements DialogInterface.OnCancelListener {
        DialogInterfaceOnCancelListenerC1265c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            AbstractDialog.this.fireCancel();
        }
    }

    /* renamed from: com.huawei.hms.ui.AbstractDialog$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    class DialogInterfaceOnKeyListenerC1266d implements DialogInterface.OnKeyListener {
        DialogInterfaceOnKeyListenerC1266d() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (4 != i || keyEvent.getAction() != 1) {
                return false;
            }
            AbstractDialog.this.cancel();
            return true;
        }
    }

    public void cancel() {
        AlertDialog alertDialog = this.f1842b;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    public void dismiss() {
        AlertDialog alertDialog = this.f1842b;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.f1842b.dismiss();
    }

    protected void fireCancel() {
        Callback callback = this.f1843c;
        if (callback != null) {
            callback.onCancel(this);
        }
    }

    protected void fireDoWork() {
        Callback callback = this.f1843c;
        if (callback != null) {
            callback.onDoWork(this);
        }
    }

    protected Activity getActivity() {
        return this.f1841a;
    }

    protected int getDialogThemeId() {
        return UIUtil.getDialogThemeId(getActivity());
    }

    protected AlertDialog onCreateDialog(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), getDialogThemeId());
        String onGetTitleString = onGetTitleString(activity);
        if (onGetTitleString != null) {
            builder.setTitle(onGetTitleString);
        }
        String onGetMessageString = onGetMessageString(activity);
        if (onGetMessageString != null) {
            builder.setMessage(onGetMessageString);
        }
        String onGetPositiveButtonString = onGetPositiveButtonString(activity);
        if (onGetPositiveButtonString != null) {
            builder.setPositiveButton(onGetPositiveButtonString, new DialogInterfaceOnClickListenerC1263a());
        }
        String onGetNegativeButtonString = onGetNegativeButtonString(activity);
        if (onGetNegativeButtonString != null) {
            builder.setNegativeButton(onGetNegativeButtonString, new DialogInterfaceOnClickListenerC1264b());
        }
        return builder.create();
    }

    protected abstract String onGetMessageString(Context context);

    protected abstract String onGetNegativeButtonString(Context context);

    protected abstract String onGetPositiveButtonString(Context context);

    protected abstract String onGetTitleString(Context context);

    public void setMessage(CharSequence charSequence) {
        AlertDialog alertDialog = this.f1842b;
        if (alertDialog != null) {
            alertDialog.setMessage(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        AlertDialog alertDialog = this.f1842b;
        if (alertDialog != null) {
            alertDialog.setTitle(charSequence);
        }
    }

    public void show(Activity activity, Callback callback) {
        this.f1841a = activity;
        this.f1843c = callback;
        if (activity != null && !activity.isFinishing()) {
            AlertDialog onCreateDialog = onCreateDialog(this.f1841a);
            this.f1842b = onCreateDialog;
            onCreateDialog.setCanceledOnTouchOutside(false);
            this.f1842b.setOnCancelListener(new DialogInterfaceOnCancelListenerC1265c());
            this.f1842b.setOnKeyListener(new DialogInterfaceOnKeyListenerC1266d());
            UIUtil.enableFocusedForButtonsInTV(this.f1842b);
            this.f1842b.show();
            return;
        }
        HMSLog.m2118e("AbstractDialog", "In show, The activity is null or finishing.");
    }
}
