package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes7.dex */
public class DownloadAlertDialogInfo {
    public boolean mCancelableOnTouchOutside;
    public Context mContext;
    public OnDialogStatusChangedListener mDialogStatusChangedListener;
    public Drawable mIcon;
    public String mMessage;
    public String mNegativeBtnText;
    public int mNegativeTextColor;
    public String mPositiveBtnText;
    public int mPositiveTextColor;
    public String mTitle;
    public View mView;

    /* loaded from: classes7.dex */
    public interface OnDialogStatusChangedListener {
        void onCancel(DialogInterface dialogInterface);

        void onNegativeBtnClick(DialogInterface dialogInterface);

        void onPositiveBtnClick(DialogInterface dialogInterface);
    }

    private DownloadAlertDialogInfo(Builder builder) {
        this.mCancelableOnTouchOutside = true;
        this.mPositiveTextColor = 0;
        this.mNegativeTextColor = 0;
        this.mContext = builder.mContext;
        this.mTitle = builder.mTitle;
        this.mMessage = builder.mMessage;
        this.mPositiveBtnText = builder.mPositiveBtnText;
        this.mNegativeBtnText = builder.mNegativeBtnText;
        this.mCancelableOnTouchOutside = builder.mCancelableOnTouchOutside;
        this.mIcon = builder.mIcon;
        this.mPositiveTextColor = builder.mPositiveTextColor;
        this.mNegativeTextColor = builder.mNegativeTextColor;
        this.mDialogStatusChangedListener = builder.mDialogStatusChangedListener;
        this.mView = builder.mView;
    }

    /* loaded from: classes7.dex */
    public static final class Builder {
        private boolean mCancelableOnTouchOutside;
        private Context mContext;
        private OnDialogStatusChangedListener mDialogStatusChangedListener;
        private Drawable mIcon;
        private String mMessage;
        private String mNegativeBtnText;
        private int mNegativeTextColor;
        private String mPositiveBtnText;
        private int mPositiveTextColor;
        private String mTitle;
        public View mView;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setTitle(String str) {
            this.mTitle = str;
            return this;
        }

        public Builder setMessage(String str) {
            this.mMessage = str;
            return this;
        }

        public Builder setPositiveBtnText(String str) {
            this.mPositiveBtnText = str;
            return this;
        }

        public Builder setNegativeBtnText(String str) {
            this.mNegativeBtnText = str;
            return this;
        }

        public Builder setCancelableOnTouchOutside(boolean z) {
            this.mCancelableOnTouchOutside = z;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.mIcon = drawable;
            return this;
        }

        public Builder setPositiveTextColor(int i) {
            this.mPositiveTextColor = i;
            return this;
        }

        public Builder setNegativeTextColor(int i) {
            this.mNegativeTextColor = i;
            return this;
        }

        public Builder setDialogStatusChangedListener(OnDialogStatusChangedListener onDialogStatusChangedListener) {
            this.mDialogStatusChangedListener = onDialogStatusChangedListener;
            return this;
        }

        public Builder setView(View view) {
            this.mView = view;
            return this;
        }

        public DownloadAlertDialogInfo build() {
            return new DownloadAlertDialogInfo(this);
        }
    }
}
