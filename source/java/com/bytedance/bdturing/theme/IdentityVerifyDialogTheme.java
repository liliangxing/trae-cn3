package com.bytedance.bdturing.theme;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public class IdentityVerifyDialogTheme {
    private Drawable cancelBtnBg;
    private String cancelText;
    private int cancelTextColor;
    private float cancelTextSize;
    private Drawable confirmBtnBg;
    private String confirmText;
    private int confirmTextColor;
    private float confirmTextSize;
    private String content;
    private int contentTextColor;
    private float contentTextSize;
    private float contentTopMargin;
    private Drawable dialogBg;
    private int divideLineColor;
    private float divideLineHeight;
    private String title;
    private int titleTextColor;
    private float titleTextSize;
    private float titleTopMargin;

    public IdentityVerifyDialogTheme() {
        this.cancelBtnBg = null;
        this.confirmBtnBg = null;
    }

    public IdentityVerifyDialogTheme(Builder builder) {
        this.cancelBtnBg = null;
        this.confirmBtnBg = null;
        this.title = builder.title;
        this.content = builder.content;
        this.cancelText = builder.cancelText;
        this.confirmText = builder.confirmText;
        this.titleTextSize = builder.titleTextSize;
        this.confirmTextSize = builder.confirmTextSize;
        this.contentTextSize = builder.contentTextSize;
        this.cancelTextSize = builder.cancelTextSize;
        this.titleTextColor = builder.titleTextColor;
        this.contentTextColor = builder.contentTextColor;
        this.cancelTextColor = builder.cancelTextColor;
        this.confirmTextColor = builder.confirmTextColor;
        this.divideLineColor = builder.divideLineColor;
        this.divideLineHeight = builder.divideLineSize;
        this.dialogBg = builder.dialogBg;
        this.titleTopMargin = builder.titleTopMargin;
        this.contentTopMargin = builder.contentTopMargin;
        this.cancelBtnBg = builder.cancelBtnBg;
        this.confirmBtnBg = builder.confirmBtnBg;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getCancelText() {
        return this.cancelText;
    }

    public void setCancelText(String str) {
        this.cancelText = str;
    }

    public String getConfirmText() {
        return this.confirmText;
    }

    public void setConfirmText(String str) {
        this.confirmText = str;
    }

    public float getTitleTextSize() {
        return this.titleTextSize;
    }

    public void setTitleTextSize(float f) {
        this.titleTextSize = f;
    }

    public float getContentTextSize() {
        return this.contentTextSize;
    }

    public void setContentTextSize(float f) {
        this.contentTextSize = f;
    }

    public float getCancelTextSize() {
        return this.cancelTextSize;
    }

    public void setCancelTextSize(float f) {
        this.cancelTextSize = f;
    }

    public float getConfirmTextSize() {
        return this.confirmTextSize;
    }

    public void setConfirmTextSize(float f) {
        this.confirmTextSize = f;
    }

    public int getTitleTextColor() {
        return this.titleTextColor;
    }

    public void setTitleTextColor(int i) {
        this.titleTextColor = i;
    }

    public int getContentTextColor() {
        return this.contentTextColor;
    }

    public void setContentTextColor(int i) {
        this.contentTextColor = i;
    }

    public int getCancelTextColor() {
        return this.cancelTextColor;
    }

    public void setCancelTextColor(int i) {
        this.cancelTextColor = i;
    }

    public int getConfirmTextColor() {
        return this.confirmTextColor;
    }

    public void setConfirmTextColor(int i) {
        this.confirmTextColor = i;
    }

    public int getDivideLineColor() {
        return this.divideLineColor;
    }

    public void setDivideLineColor(int i) {
        this.divideLineColor = i;
    }

    public float getDivideLineHeight() {
        return this.divideLineHeight;
    }

    public void setDivideLineHeight(float f) {
        this.divideLineHeight = f;
    }

    public Drawable getDialogBg() {
        return this.dialogBg;
    }

    public void setDialogBg(Drawable drawable) {
        this.dialogBg = drawable;
    }

    public float getTitleTopMargin() {
        return this.titleTopMargin;
    }

    public void setTitleTopMargin(float f) {
        this.titleTopMargin = f;
    }

    public float getContentTopMargin() {
        return this.contentTopMargin;
    }

    public void setContentTopMargin(float f) {
        this.contentTopMargin = f;
    }

    public Drawable getCancelBtnBg() {
        return this.cancelBtnBg;
    }

    public void setCancelBtnBg(Drawable drawable) {
        this.cancelBtnBg = drawable;
    }

    public Drawable getConfirmBtnBg() {
        return this.confirmBtnBg;
    }

    public void setConfirmBtnBg(Drawable drawable) {
        this.confirmBtnBg = drawable;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private String cancelText;
        private String confirmText;
        private String content;
        private Drawable dialogBg;
        private String title;
        private float titleTextSize = 17.0f;
        private float contentTextSize = 14.0f;
        private float cancelTextSize = 15.0f;
        private float confirmTextSize = 15.0f;
        private int titleTextColor = -15329245;
        private int contentTextColor = -1089071069;
        private int cancelTextColor = -2146035677;
        private int confirmTextColor = -15329245;
        private int divideLineColor = 521541667;
        private float divideLineSize = 0.5f;
        private float titleTopMargin = 32.0f;
        private float contentTopMargin = 8.0f;
        private Drawable cancelBtnBg = null;
        private Drawable confirmBtnBg = null;

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder content(String str) {
            this.content = str;
            return this;
        }

        public Builder cancelText(String str) {
            this.cancelText = this.content;
            return this;
        }

        public Builder confirmText(String str) {
            this.confirmText = str;
            return this;
        }

        public Builder titleTextSize(int i) {
            this.titleTextSize = i;
            return this;
        }

        public Builder contentTextSize(int i) {
            this.contentTextSize = i;
            return this;
        }

        public Builder cancelTextSize(int i) {
            this.cancelTextSize = i;
            return this;
        }

        public Builder confirmTextSize(int i) {
            this.confirmTextSize = i;
            return this;
        }

        public Builder titleTextColor(int i) {
            this.titleTextColor = i;
            return this;
        }

        public Builder contentTextColor(int i) {
            this.contentTextColor = i;
            return this;
        }

        public Builder cancelTextColor(int i) {
            this.cancelTextColor = i;
            return this;
        }

        public Builder confirmTextColor(int i) {
            this.confirmTextColor = i;
            return this;
        }

        public Builder divideLineColor(int i) {
            this.divideLineColor = i;
            return this;
        }

        public Builder divideLineSize(float f) {
            this.divideLineSize = f;
            return this;
        }

        public Builder dialogBg(Drawable drawable) {
            this.dialogBg = drawable;
            return this;
        }

        public Builder titleTopMargin(float f) {
            this.titleTopMargin = f;
            return this;
        }

        public Builder contentTopMargin(float f) {
            this.contentTopMargin = f;
            return this;
        }

        public Builder cancelBtnBg(Drawable drawable) {
            this.cancelBtnBg = drawable;
            return this;
        }

        public Builder confirmBtnBg(Drawable drawable) {
            this.confirmBtnBg = drawable;
            return this;
        }

        public IdentityVerifyDialogTheme build(Context context) {
            return new IdentityVerifyDialogTheme(this);
        }
    }
}
