package com.bytedance.bdturing.theme;

import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public class IdentityVerifyTheme {
    private int beautyIntensity;
    private Drawable faceLiveBackImage;
    private int faceLiveNavBarColor;
    private int faceLiveProgressBgColor;
    private int faceLiveProgressColor;
    private float faceLiveProgressGap;
    private float faceLiveProgressWidth;
    private int faceLiveScreenBgColor;
    private Drawable faceLiveScreenBgImage;
    private int faceLiveTextColor;
    private float faceLiveTextSize;
    private boolean isFaceLiveBack;
    private boolean isInitNeedLoading;
    private boolean isWebDarkMode;

    public IdentityVerifyTheme(Builder builder) {
        this.faceLiveProgressColor = builder.faceLiveProgressColor;
        this.faceLiveProgressBgColor = builder.faceLiveProgressBgColor;
        this.faceLiveScreenBgColor = builder.faceLiveScreenBgColor;
        this.faceLiveScreenBgImage = builder.faceLiveScreenBgImage;
        this.faceLiveTextColor = builder.faceLiveTextColor;
        this.isFaceLiveBack = builder.isFaceLiveBack;
        this.faceLiveBackImage = builder.faceLiveBackImage;
        this.isInitNeedLoading = builder.isInitNeedLoading;
        this.isWebDarkMode = builder.isWebDarkMode;
        this.beautyIntensity = builder.beautyIntensity;
        this.faceLiveNavBarColor = builder.faceLiveNavBarColor;
        this.faceLiveTextSize = builder.faceLiveTextSize;
        this.faceLiveProgressWidth = builder.faceLiveProgressWidth;
        this.faceLiveProgressGap = builder.faceLiveProgressGap;
    }

    public int getFaceLiveProgressColor() {
        return this.faceLiveProgressColor;
    }

    public void setFaceLiveProgressColor(int i) {
        this.faceLiveProgressColor = i;
    }

    public int getFaceLiveProgressBgColor() {
        return this.faceLiveProgressBgColor;
    }

    public void setFaceLiveProgressBgColor(int i) {
        this.faceLiveProgressBgColor = i;
    }

    public int getFaceLiveScreenBgColor() {
        return this.faceLiveScreenBgColor;
    }

    public void setFaceLiveScreenBgColor(int i) {
        this.faceLiveScreenBgColor = i;
    }

    public Drawable getFaceLiveScreenBgImage() {
        return this.faceLiveScreenBgImage;
    }

    public void setFaceLiveScreenBgImage(Drawable drawable) {
        this.faceLiveScreenBgImage = drawable;
    }

    public int getFaceLiveTextColor() {
        return this.faceLiveTextColor;
    }

    public void setFaceLiveTextColor(int i) {
        this.faceLiveTextColor = i;
    }

    public boolean isFaceLiveBack() {
        return this.isFaceLiveBack;
    }

    public void setFaceLiveBack(boolean z) {
        this.isFaceLiveBack = z;
    }

    public Drawable getFaceLiveBackImage() {
        return this.faceLiveBackImage;
    }

    public void setFaceLiveBackImage(Drawable drawable) {
        this.faceLiveBackImage = drawable;
    }

    public boolean isInitNeedLoading() {
        return this.isInitNeedLoading;
    }

    public void setInitNeedLoading(boolean z) {
        this.isInitNeedLoading = z;
    }

    public boolean isWebDarkMode() {
        return this.isWebDarkMode;
    }

    public void setWebDarkMode(boolean z) {
        this.isWebDarkMode = z;
    }

    public int getBeautyIntensity() {
        return this.beautyIntensity;
    }

    public void setBeautyIntensity(int i) {
        this.beautyIntensity = i;
    }

    public int getFaceLiveNavBarColor() {
        return this.faceLiveNavBarColor;
    }

    public void setFaceLiveNavBarColor(int i) {
        this.faceLiveNavBarColor = i;
    }

    public float getFaceLiveTextSize() {
        return this.faceLiveTextSize;
    }

    public void setFaceLiveTextSize(float f) {
        this.faceLiveTextSize = f;
    }

    public float getFaceLiveProgressWidth() {
        return this.faceLiveProgressWidth;
    }

    public void setFaceLiveProgressWidth(float f) {
        this.faceLiveProgressWidth = f;
    }

    public float getFaceLiveProgressGap() {
        return this.faceLiveProgressGap;
    }

    public void setFaceLiveProgressGap(float f) {
        this.faceLiveProgressGap = f;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private Drawable faceLiveBackImage;
        private int faceLiveNavBarColor;
        private int faceLiveProgressBgColor;
        private int faceLiveProgressColor;
        private int faceLiveScreenBgColor;
        private Drawable faceLiveScreenBgImage;
        private int faceLiveTextColor;
        private boolean isWebDarkMode;
        private boolean isFaceLiveBack = true;
        private boolean isInitNeedLoading = true;
        private int beautyIntensity = -1;
        private float faceLiveTextSize = -1.0f;
        private float faceLiveProgressWidth = -1.0f;
        private float faceLiveProgressGap = -1.0f;

        public Builder faceLiveProgressColor(int i) {
            this.faceLiveProgressColor = i;
            return this;
        }

        public Builder faceLiveProgressBgColor(int i) {
            this.faceLiveProgressBgColor = i;
            return this;
        }

        public Builder faceLiveScreenBgColor(int i) {
            this.faceLiveScreenBgColor = i;
            return this;
        }

        public Builder faceLiveScreenBgImage(Drawable drawable) {
            this.faceLiveScreenBgImage = drawable;
            return this;
        }

        public Builder faceLiveTextColor(int i) {
            this.faceLiveTextColor = i;
            return this;
        }

        public Builder faceLiveBack(boolean z) {
            this.isFaceLiveBack = z;
            return this;
        }

        public Builder faceLiveBackImage(Drawable drawable) {
            this.faceLiveBackImage = drawable;
            return this;
        }

        public Builder isInitNeedLoading(boolean z) {
            this.isInitNeedLoading = z;
            return this;
        }

        public Builder isWebDarkMode(boolean z) {
            this.isWebDarkMode = z;
            return this;
        }

        public Builder beautyIntensity(int i) {
            this.beautyIntensity = i;
            return this;
        }

        public Builder faceLiveNavBarColor(int i) {
            this.faceLiveNavBarColor = i;
            return this;
        }

        public Builder faceLiveTextSize(float f) {
            this.faceLiveTextSize = f;
            return this;
        }

        public Builder faceLiveProgressWidth(float f) {
            this.faceLiveProgressWidth = f;
            return this;
        }

        public Builder faceLiveProgressGap(float f) {
            this.faceLiveProgressGap = f;
            return this;
        }

        public IdentityVerifyTheme build() {
            return new IdentityVerifyTheme(this);
        }
    }
}
