package com.lynx.tasm.resourceprovider.template;

import com.lynx.tasm.TemplateBundle;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TemplateProviderResult {
    private byte[] templateBinary = null;
    private ByteBuffer templateBuffer = null;
    private TemplateBundle templateBundle = null;

    public byte[] getTemplateBinary() {
        return this.templateBinary;
    }

    public TemplateBundle getTemplateBundle() {
        return this.templateBundle;
    }

    public ByteBuffer getTemplateBuffer() {
        return this.templateBuffer;
    }

    private TemplateProviderResult() {
    }

    public static TemplateProviderResult fromBinary(byte[] bArr) {
        TemplateProviderResult templateProviderResult = new TemplateProviderResult();
        templateProviderResult.templateBinary = bArr;
        return templateProviderResult;
    }

    public static TemplateProviderResult fromTemplateBundle(TemplateBundle templateBundle) {
        TemplateProviderResult templateProviderResult = new TemplateProviderResult();
        templateProviderResult.templateBundle = templateBundle;
        return templateProviderResult;
    }

    public static TemplateProviderResult fromBuffer(ByteBuffer byteBuffer) {
        TemplateProviderResult templateProviderResult = new TemplateProviderResult();
        templateProviderResult.templateBuffer = byteBuffer;
        return templateProviderResult;
    }
}
