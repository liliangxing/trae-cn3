package com.lynx.tasm;

/* loaded from: classes6.dex */
public final class LynxUpdateMeta {
    private TemplateData updatedData;
    private TemplateData updatedGlobalProps;

    private LynxUpdateMeta(TemplateData templateData, TemplateData templateData2) {
        this.updatedData = templateData;
        this.updatedGlobalProps = templateData2;
    }

    public TemplateData getUpdatedData() {
        return this.updatedData;
    }

    public TemplateData getUpdatedGlobalProps() {
        return this.updatedGlobalProps;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private TemplateData updatedData;
        private TemplateData updatedGlobalProps;

        public Builder setUpdatedData(TemplateData templateData) {
            this.updatedData = templateData;
            return this;
        }

        public Builder setUpdatedGlobalProps(TemplateData templateData) {
            this.updatedGlobalProps = templateData;
            return this;
        }

        public LynxUpdateMeta build() {
            return new LynxUpdateMeta(this.updatedData, this.updatedGlobalProps);
        }
    }
}
