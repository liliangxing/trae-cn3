package com.bytedance.bdturing.twiceverify;

/* loaded from: classes3.dex */
public class TwiceVerifyConfig {
    private int backgroundColor;
    private String dlgCancelText;
    private String dlgConfirmText;
    private String dlgContent;
    private String dlgTitle;
    private int windowHeight;

    private TwiceVerifyConfig(Builder builder) {
        this.windowHeight = 0;
        this.backgroundColor = -1;
        this.windowHeight = builder.windowHeight;
        this.backgroundColor = builder.backgroundColor;
        this.dlgTitle = builder.dlgTitle;
        this.dlgContent = builder.dlgContent;
        this.dlgCancelText = builder.dlgCancelText;
        this.dlgConfirmText = builder.dlgConfirmText;
    }

    public int getWindowHeight() {
        return this.windowHeight;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public String getDlgTitle() {
        return this.dlgTitle;
    }

    public String getDlgContent() {
        return this.dlgContent;
    }

    public String getDlgCancelText() {
        return this.dlgCancelText;
    }

    public String getDlgConfirmText() {
        return this.dlgConfirmText;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private String dlgCancelText;
        private String dlgConfirmText;
        private String dlgContent;
        private String dlgTitle;
        private int windowHeight = 0;
        private int backgroundColor = -1;

        public Builder windowHeight(int i) {
            this.windowHeight = i;
            return this;
        }

        public Builder backgroundColor(int i) {
            this.backgroundColor = i;
            return this;
        }

        public Builder dlgTitle(String str) {
            this.dlgTitle = str;
            return this;
        }

        public Builder dlgContent(String str) {
            this.dlgContent = str;
            return this;
        }

        public Builder dlgCancelText(String str) {
            this.dlgCancelText = str;
            return this;
        }

        public Builder dlgConfirmText(String str) {
            this.dlgConfirmText = str;
            return this;
        }

        public TwiceVerifyConfig build() {
            return new TwiceVerifyConfig(this);
        }
    }
}
