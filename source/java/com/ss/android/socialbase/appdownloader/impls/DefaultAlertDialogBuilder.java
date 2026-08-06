package com.ss.android.socialbase.appdownloader.impls;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Button;
import com.ss.android.socialbase.appdownloader.depend.AbsDownloadAlertDialogBuilder;
import com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog;
import com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder;

/* loaded from: classes7.dex */
public class DefaultAlertDialogBuilder extends AbsDownloadAlertDialogBuilder {
    private AlertDialog.Builder builder;

    public DefaultAlertDialogBuilder(Context context) {
        this.builder = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialogBuilder setTitle(int i) {
        AlertDialog.Builder builder = this.builder;
        if (builder != null) {
            builder.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialogBuilder setMessage(String str) {
        AlertDialog.Builder builder = this.builder;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialogBuilder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.builder;
        if (builder != null) {
            builder.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialogBuilder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.builder;
        if (builder != null) {
            builder.setPositiveButton(charSequence, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialogBuilder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.builder;
        if (builder != null) {
            builder.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialogBuilder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.builder;
        if (builder != null) {
            builder.setNegativeButton(charSequence, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialogBuilder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.builder;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder
    public IDownloadAlertDialog show() {
        return new DownloadAlertDialog(this.builder);
    }

    /* loaded from: classes7.dex */
    private static class DownloadAlertDialog implements IDownloadAlertDialog {
        private AlertDialog alertDialog;

        public DownloadAlertDialog(AlertDialog.Builder builder) {
            if (builder != null) {
                this.alertDialog = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog
        public void show() {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog
        public void dismiss() {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog
        public boolean isShowing() {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog
        public Button getButton(int i) {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                return alertDialog.getButton(i);
            }
            return null;
        }
    }
}
