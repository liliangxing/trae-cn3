package com.bytedance.trae.image;

import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.image.api.IImageInitiator;
import com.bytedance.trae.image.fresco.FrescoExt;
import kotlin.Metadata;

/* compiled from: ImageInitiator.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/image/ImageInitiator;", "Lcom/bytedance/trae/image/api/IImageInitiator;", "<init>", "()V", "initFresco", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ImageInitiator implements IImageInitiator {
    @Override // com.bytedance.trae.image.api.IImageInitiator
    public void initFresco() {
        FrescoExt.INSTANCE.init(AppHost.INSTANCE.getApplication());
    }
}
