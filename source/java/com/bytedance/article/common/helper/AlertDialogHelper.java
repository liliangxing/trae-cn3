package com.bytedance.article.common.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.common.dialog.AlertDialog;

/* loaded from: classes3.dex */
public final class AlertDialogHelper {

    /* loaded from: classes3.dex */
    public interface CallBackListener {
        void cancel();

        void confirm();

        void mobEvent();
    }

    /* loaded from: classes3.dex */
    public interface CallBackListenerWithBackCancel extends CallBackListener {
        void onBackCancel();
    }

    private AlertDialogHelper() {
    }

    public static void showAttentionDialog(Context context, CallBackListener callBackListener, int i, int i2, int i3) {
        showAttentionDialog(context, callBackListener, -1, i, i2, i3);
    }

    public static void showAttentionDialog(Context context, CallBackListener callBackListener, int i, int i2, int i3, int i4) {
        showAttentionDialog(context, callBackListener, i, context.getString(i2), i3, i4, true);
    }

    public static void showAttentionDialog(Context context, final CallBackListener callBackListener, int i, String str, int i2, int i3, boolean z) {
        if (callBackListener != null) {
            callBackListener.mobEvent();
        }
        AlertDialog.Builder themedAlertDlgBuilder = getThemedAlertDlgBuilder(context);
        if (i != -1) {
            themedAlertDlgBuilder.setTitle(context.getString(i));
        }
        themedAlertDlgBuilder.setMessage(str);
        themedAlertDlgBuilder.setPositiveButton(context.getString(i2), new DialogInterface.OnClickListener() { // from class: com.bytedance.article.common.helper.AlertDialogHelper.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                CallBackListener callBackListener2 = CallBackListener.this;
                if (callBackListener2 != null) {
                    callBackListener2.confirm();
                }
            }
        });
        themedAlertDlgBuilder.setNegativeButton(context.getString(i3), new DialogInterface.OnClickListener() { // from class: com.bytedance.article.common.helper.AlertDialogHelper.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                CallBackListener callBackListener2 = CallBackListener.this;
                if (callBackListener2 != null) {
                    callBackListener2.cancel();
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog create = themedAlertDlgBuilder.create();
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(z);
        create.show();
    }

    public static void showAttentionDialog(Context context, CallBackListener callBackListener, String str, String str2, String str3) {
        showAttentionDialog(context, callBackListener, "", str, str2, str3);
    }

    public static void showAttentionDialog(Context context, final CallBackListener callBackListener, String str, String str2, String str3, String str4) {
        callBackListener.mobEvent();
        AlertDialog.Builder themedAlertDlgBuilder = getThemedAlertDlgBuilder(context);
        if (!StringUtils.isEmpty(str)) {
            themedAlertDlgBuilder.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            themedAlertDlgBuilder.setMessage(str2);
        }
        themedAlertDlgBuilder.setPositiveButton(str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.article.common.helper.AlertDialogHelper.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                CallBackListener callBackListener2 = CallBackListener.this;
                if (callBackListener2 != null) {
                    callBackListener2.confirm();
                }
            }
        });
        themedAlertDlgBuilder.setNegativeButton(str4, new DialogInterface.OnClickListener() { // from class: com.bytedance.article.common.helper.AlertDialogHelper.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                CallBackListener callBackListener2 = CallBackListener.this;
                if (callBackListener2 != null) {
                    callBackListener2.cancel();
                }
                dialogInterface.dismiss();
            }
        });
        themedAlertDlgBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.article.common.helper.AlertDialogHelper.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                CallBackListener callBackListener2 = CallBackListener.this;
                if (callBackListener2 instanceof CallBackListenerWithBackCancel) {
                    ((CallBackListenerWithBackCancel) callBackListener2).onBackCancel();
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog create = themedAlertDlgBuilder.create();
        create.setCanceledOnTouchOutside(false);
        create.show();
    }

    public static void showOKAttentionDialog(Context context, final CallBackListener callBackListener, String str, String str2, String str3) {
        AlertDialog.Builder themedAlertDlgBuilder = getThemedAlertDlgBuilder(context);
        if (!StringUtils.isEmpty(str)) {
            themedAlertDlgBuilder.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            themedAlertDlgBuilder.setMessage(str2);
        }
        themedAlertDlgBuilder.setPositiveButton(str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.article.common.helper.AlertDialogHelper.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                CallBackListener callBackListener2 = CallBackListener.this;
                if (callBackListener2 != null) {
                    callBackListener2.confirm();
                }
            }
        });
        AlertDialog create = themedAlertDlgBuilder.create();
        create.setCanceledOnTouchOutside(false);
        create.show();
    }

    public static AlertDialog.Builder getThemedAlertDlgBuilder(Context context) {
        return new AlertDialog.Builder(context);
    }
}
