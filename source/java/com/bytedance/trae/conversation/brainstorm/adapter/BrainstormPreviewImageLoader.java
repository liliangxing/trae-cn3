package com.bytedance.trae.conversation.brainstorm.adapter;

import android.net.Uri;
import com.bytedance.trae.common_ui.C0591R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormAttachmentImageLoader.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;", "", "view", "Lcom/facebook/drawee/view/SimpleDraweeView;", "<init>", "(Lcom/facebook/drawee/view/SimpleDraweeView;)V", "loadedUri", "", "load", "", "uri", "clear", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormPreviewImageLoader {
    private String loadedUri;
    private final SimpleDraweeView view;

    public BrainstormPreviewImageLoader(SimpleDraweeView simpleDraweeView) {
        Intrinsics.checkNotNullParameter(simpleDraweeView, "view");
        this.view = simpleDraweeView;
    }

    public final void load(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (!Intrinsics.areEqual(this.loadedUri, uri) || this.view.getController() == null) {
            this.loadedUri = uri;
            this.view.getHierarchy().setPlaceholderImage(C0591R.drawable.trae_bg_image_loading, ScalingUtils.ScaleType.CENTER_CROP);
            this.view.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.parse(uri)).setAutoPlayAnimations(true).setOldController(this.view.getController()).build());
        }
    }

    public final void clear() {
        this.loadedUri = null;
        this.view.setController((DraweeController) null);
    }
}
