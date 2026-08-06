package com.ss.android.common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.ss.android.common.dialog.AlertController;
import com.ss.android.dialog.R;

/* loaded from: classes7.dex */
public class AlertDialog extends Dialog implements DialogInterface {
    public static final int LAYOUT_HINT_NONE = 0;
    public static final int LAYOUT_HINT_SIDE = 1;
    public static final int THEME_LIGHT = 1;
    public static final int THEME_NIGHT = 2;
    public static final int THEME_OTHER = 16777216;
    private static NightMode sNightMode;
    private AlertController mAlert;

    /* loaded from: classes7.dex */
    public interface NightMode {
        boolean isToggled();
    }

    public static void setNightMode(NightMode nightMode) {
        sNightMode = nightMode;
    }

    protected AlertDialog(Context context) {
        this(context, 0);
    }

    protected AlertDialog(Context context, int i) {
        super(context, resolveDialogTheme(context, i));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    static int resolveDialogTheme(Context context, int i) {
        if (i == 1) {
            return R.style.SSTheme_Dialog_Alert;
        }
        if (i == 2) {
            return R.style.SSTheme_Dialog_Alert_Night;
        }
        if (i >= 16777216) {
            return i;
        }
        NightMode nightMode = sNightMode;
        if (nightMode == null) {
            return R.style.SSTheme_Dialog_Alert;
        }
        return nightMode.isToggled() ? R.style.SSTheme_Dialog_Alert_Night : R.style.SSTheme_Dialog_Alert;
    }

    public Button getButton(int i) {
        return this.mAlert.getButton(i);
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.setTitle(charSequence);
    }

    public void setCustomTitle(View view) {
        this.mAlert.setCustomTitle(view);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.setMessage(charSequence);
    }

    public void setView(View view) {
        this.mAlert.setView(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mAlert.setView(view, i, i2, i3, i4);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.mAlert.setButton(i, charSequence, null, message);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.setButton(i, charSequence, onClickListener, null);
    }

    @Deprecated
    public void setButton(CharSequence charSequence, Message message) {
        setButton(-1, charSequence, message);
    }

    @Deprecated
    public void setButton2(CharSequence charSequence, Message message) {
        setButton(-2, charSequence, message);
    }

    @Deprecated
    public void setButton3(CharSequence charSequence, Message message) {
        setButton(-3, charSequence, message);
    }

    @Deprecated
    public void setButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        setButton(-1, charSequence, onClickListener);
    }

    @Deprecated
    public void setButton2(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        setButton(-2, charSequence, onClickListener);
    }

    @Deprecated
    public void setButton3(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        setButton(-3, charSequence, onClickListener);
    }

    public void setIcon(int i) {
        this.mAlert.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.setIcon(drawable);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.mAlert.setIcon(typedValue.resourceId);
    }

    public void setInverseBackgroundForced(boolean z) {
        this.mAlert.setInverseBackgroundForced(z);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.installContent();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mAlert.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.mAlert.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        private final AlertController.AlertParams mParams;
        private int mTheme;

        public Builder(Context context) {
            this(context, 0);
        }

        public Builder(Context context, int i) {
            this.mParams = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, i)));
            this.mTheme = i;
        }

        public Context getContext() {
            return this.mParams.mContext;
        }

        public Builder setTitle(int i) {
            AlertController.AlertParams alertParams = this.mParams;
            alertParams.mTitle = alertParams.mContext.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.mParams.mTitle = charSequence;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.mParams.mCustomTitleView = view;
            return this;
        }

        public Builder setMessage(int i) {
            AlertController.AlertParams alertParams = this.mParams;
            alertParams.mMessage = alertParams.mContext.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.mParams.mMessage = charSequence;
            return this;
        }

        public Builder setIcon(int i) {
            this.mParams.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.mParams.mIcon = drawable;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.mParams.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.mParams.mIconId = typedValue.resourceId;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.mParams;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.mParams.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.mParams.mPositiveButtonText = charSequence;
            this.mParams.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.mParams;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.mParams.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.mParams.mNegativeButtonText = charSequence;
            this.mParams.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.mParams;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
            this.mParams.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.mParams.mNeutralButtonText = charSequence;
            this.mParams.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.mParams.mCancelable = z;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.mParams.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.mParams.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.mParams.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.mParams;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            this.mParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.mParams.mItems = charSequenceArr;
            this.mParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.mParams.mAdapter = listAdapter;
            this.mParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            this.mParams.mCursor = cursor;
            this.mParams.mLabelColumn = str;
            this.mParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.mParams;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            this.mParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.mParams.mCheckedItems = zArr;
            this.mParams.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.mParams.mItems = charSequenceArr;
            this.mParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.mParams.mCheckedItems = zArr;
            this.mParams.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.mParams.mCursor = cursor;
            this.mParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.mParams.mIsCheckedColumn = str;
            this.mParams.mLabelColumn = str2;
            this.mParams.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.mParams;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            this.mParams.mOnClickListener = onClickListener;
            this.mParams.mCheckedItem = i2;
            this.mParams.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            this.mParams.mCursor = cursor;
            this.mParams.mOnClickListener = onClickListener;
            this.mParams.mCheckedItem = i;
            this.mParams.mLabelColumn = str;
            this.mParams.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            this.mParams.mItems = charSequenceArr;
            this.mParams.mOnClickListener = onClickListener;
            this.mParams.mCheckedItem = i;
            this.mParams.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            this.mParams.mAdapter = listAdapter;
            this.mParams.mOnClickListener = onClickListener;
            this.mParams.mCheckedItem = i;
            this.mParams.mIsSingleChoice = true;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.mParams.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setView(int i) {
            this.mParams.mView = null;
            this.mParams.mViewLayoutResId = i;
            this.mParams.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view) {
            this.mParams.mView = view;
            this.mParams.mViewLayoutResId = 0;
            this.mParams.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.mParams.mView = view;
            this.mParams.mViewLayoutResId = 0;
            this.mParams.mViewSpacingSpecified = true;
            this.mParams.mViewSpacingLeft = i;
            this.mParams.mViewSpacingTop = i2;
            this.mParams.mViewSpacingRight = i3;
            this.mParams.mViewSpacingBottom = i4;
            return this;
        }

        public Builder setInverseBackgroundForced(boolean z) {
            this.mParams.mForceInverseBackground = z;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.mParams.mRecycleOnMeasure = z;
            return this;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.mParams.mContext, this.mTheme);
            this.mParams.apply(alertDialog.mAlert);
            alertDialog.setCancelable(this.mParams.mCancelable);
            if (this.mParams.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.mParams.mOnCancelListener);
            alertDialog.setOnDismissListener(this.mParams.mOnDismissListener);
            if (this.mParams.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.mParams.mOnKeyListener);
            }
            return alertDialog;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            try {
                create.show();
            } catch (Exception unused) {
            }
            return create;
        }
    }
}
