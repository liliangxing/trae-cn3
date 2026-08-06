package com.bytedance.ug.sdk.share.api.callback;

import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import java.util.UUID;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IShareTokenGenerator {
    String generateShareToken(ShareContent shareContent);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class DefaultShareTokenGenerator implements IShareTokenGenerator {
        @Override // com.bytedance.ug.sdk.share.api.callback.IShareTokenGenerator
        public String generateShareToken(ShareContent shareContent) {
            return UUID.randomUUID().toString();
        }
    }
}
