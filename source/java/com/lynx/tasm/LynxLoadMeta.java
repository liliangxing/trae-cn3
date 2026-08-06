package com.lynx.tasm;

import java.nio.ByteBuffer;
import java.util.EnumSet;
import java.util.Map;

/* loaded from: classes6.dex */
public final class LynxLoadMeta {
    byte[] binaryData;
    TemplateBundle bundle;
    ByteBuffer byteBuffer;
    TemplateData globalProps;
    TemplateData initialData;
    LynxLoadMode loadMode;
    int loadOptions;
    Map<String, String> lynxViewConfig;
    String url;

    private LynxLoadMeta(String str, byte[] bArr, ByteBuffer byteBuffer, TemplateBundle templateBundle, TemplateData templateData, TemplateData templateData2, LynxLoadMode lynxLoadMode, int i, Map<String, String> map) {
        this.url = str;
        this.binaryData = bArr;
        this.byteBuffer = byteBuffer;
        this.bundle = templateBundle;
        this.initialData = templateData;
        this.globalProps = templateData2;
        this.loadMode = lynxLoadMode;
        this.loadOptions = i;
        this.lynxViewConfig = map;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isBundleValid() {
        TemplateBundle templateBundle = this.bundle;
        return templateBundle != null && templateBundle.isValid();
    }

    public boolean isBinaryValid() {
        byte[] bArr = this.binaryData;
        return bArr != null && bArr.length > 0;
    }

    public boolean isByteBufferValid() {
        return this.byteBuffer != null;
    }

    public byte[] getTemplateBinary() {
        return this.binaryData;
    }

    public TemplateBundle getTemplateBundle() {
        return this.bundle;
    }

    public TemplateData getInitialData() {
        return this.initialData;
    }

    public TemplateData getGlobalProps() {
        return this.globalProps;
    }

    public boolean isGlobalPropsValid() {
        return this.globalProps != null;
    }

    public Map<String, String> getLynxViewConfig() {
        return this.lynxViewConfig;
    }

    public LynxLoadMode getLoadMode() {
        return this.loadMode;
    }

    public EnumSet<LynxLoadOption> getLoadOption() {
        EnumSet<LynxLoadOption> noneOf = EnumSet.noneOf(LynxLoadOption.class);
        if (enableDumpElementTree()) {
            noneOf.add(LynxLoadOption.DUMP_ELEMENT);
        }
        if (enableRecycleTemplateBundle()) {
            noneOf.add(LynxLoadOption.RECYCLE_TEMPLATE_BUNDLE);
        }
        if (enableProcessLayout()) {
            noneOf.add(LynxLoadOption.PROCESS_LAYOUT_WITHOUT_UI_FLUSH);
        }
        if (renderForRecreateEngine()) {
            noneOf.add(LynxLoadOption.RENDER_FOR_RECREATE_ENGINE);
        }
        return noneOf;
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    public boolean enableDumpElementTree() {
        return (this.loadOptions & LynxLoadOption.DUMP_ELEMENT.id()) != 0;
    }

    public boolean enableRecycleTemplateBundle() {
        return (this.loadOptions & LynxLoadOption.RECYCLE_TEMPLATE_BUNDLE.id()) != 0;
    }

    public boolean enableProcessLayout() {
        return (this.loadOptions & LynxLoadOption.PROCESS_LAYOUT_WITHOUT_UI_FLUSH.id()) != 0;
    }

    private boolean renderForRecreateEngine() {
        return (this.loadOptions & LynxLoadOption.RENDER_FOR_RECREATE_ENGINE.id()) != 0;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private byte[] binaryData;
        private TemplateBundle bundle;
        private ByteBuffer byteBuffer;
        private TemplateData globalProps;
        private TemplateData initialData;
        private LynxLoadMode loadMode;
        private int loadOptions = 0;
        private Map<String, String> lynxViewConfig;
        private String url;

        public void setUrl(String str) {
            this.url = str;
        }

        public void setBinaryData(byte[] bArr) {
            this.binaryData = bArr;
        }

        public void setTemplateBundle(TemplateBundle templateBundle) {
            this.bundle = templateBundle;
        }

        public void setInitialData(TemplateData templateData) {
            this.initialData = templateData;
        }

        public void setGlobalProps(TemplateData templateData) {
            this.globalProps = templateData;
        }

        public void setLoadMode(LynxLoadMode lynxLoadMode) {
            this.loadMode = lynxLoadMode;
        }

        public void addLoadOption(LynxLoadOption lynxLoadOption) {
            this.loadOptions = lynxLoadOption.id() | this.loadOptions;
        }

        public void setLynxViewConfig(Map<String, String> map) {
            this.lynxViewConfig = map;
        }

        public void setByteBuffer(ByteBuffer byteBuffer) {
            this.byteBuffer = byteBuffer;
        }

        public LynxLoadMeta build() {
            return new LynxLoadMeta(this.url, this.binaryData, this.byteBuffer, this.bundle, this.initialData, this.globalProps, this.loadMode, this.loadOptions, this.lynxViewConfig);
        }
    }
}
