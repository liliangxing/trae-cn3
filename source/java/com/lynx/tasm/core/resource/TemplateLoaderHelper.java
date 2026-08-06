package com.lynx.tasm.core.resource;

import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.template.LynxTemplateResourceFetcher;
import com.lynx.tasm.resourceprovider.template.TemplateProviderResult;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TemplateLoaderHelper {
    private final LynxTemplateResourceFetcher mTemplateFetcher;

    public TemplateLoaderHelper(LynxTemplateResourceFetcher lynxTemplateResourceFetcher) {
        this.mTemplateFetcher = lynxTemplateResourceFetcher;
    }

    public boolean hasTemplateFetcher() {
        return this.mTemplateFetcher != null;
    }

    public void fetchTemplateByGenericTemplateFetcher(String str, final TemplateResourceCallback templateResourceCallback) {
        this.mTemplateFetcher.fetchTemplate(new LynxResourceRequest(str, templateResourceCallback.getResourceType()), new LynxResourceCallback<TemplateProviderResult>() { // from class: com.lynx.tasm.core.resource.TemplateLoaderHelper.1
            @Override // com.lynx.tasm.resourceprovider.LynxResourceCallback
            public void onResponse(LynxResourceResponse<TemplateProviderResult> lynxResourceResponse) {
                byte[] bArr;
                TemplateBundle templateBundle;
                ByteBuffer byteBuffer;
                TemplateProviderResult data = lynxResourceResponse.getData();
                if (data != null) {
                    byte[] templateBinary = data.getTemplateBinary();
                    ByteBuffer templateBuffer = data.getTemplateBuffer();
                    templateBundle = data.getTemplateBundle();
                    bArr = templateBinary;
                    byteBuffer = templateBuffer;
                } else {
                    bArr = null;
                    templateBundle = null;
                    byteBuffer = null;
                }
                templateResourceCallback.onTemplateLoaded(lynxResourceResponse.getState() == LynxResourceResponse.ResponseState.SUCCESS, bArr, templateBundle, byteBuffer, lynxResourceResponse.getError() != null ? lynxResourceResponse.getError().getMessage() : null);
            }
        });
    }
}
