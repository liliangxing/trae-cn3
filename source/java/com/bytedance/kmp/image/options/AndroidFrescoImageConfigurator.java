package com.bytedance.kmp.image.options;

import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformImage.android.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0013\u001a\u00020\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u001a\u0010\u0015\u001a\u00020\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0004J\u001a\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u0004R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/kmp/image/options/AndroidFrescoImageConfigurator;", "", "()V", "onControllerBuild", "Lkotlin/Function1;", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "", "getOnControllerBuild$kmpimage_release", "()Lkotlin/jvm/functions/Function1;", "setOnControllerBuild$kmpimage_release", "(Lkotlin/jvm/functions/Function1;)V", "onHierarchyBuild", "Lcom/facebook/drawee/generic/GenericDraweeHierarchy;", "getOnHierarchyBuild$kmpimage_release", "setOnHierarchyBuild$kmpimage_release", "onRequestBuild", "Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "getOnRequestBuild$kmpimage_release", "setOnRequestBuild$kmpimage_release", "buildController", "block", "buildHierarchy", "buildRequest", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidFrescoImageConfigurator {
    public static final int $stable = 8;
    private Function1<? super GenericDraweeHierarchy, Unit> onHierarchyBuild = new Function1<GenericDraweeHierarchy, Unit>() { // from class: com.bytedance.kmp.image.options.AndroidFrescoImageConfigurator$onHierarchyBuild$1
        public final void invoke(GenericDraweeHierarchy genericDraweeHierarchy) {
            Intrinsics.checkNotNullParameter(genericDraweeHierarchy, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((GenericDraweeHierarchy) obj);
            return Unit.INSTANCE;
        }
    };
    private Function1<? super PipelineDraweeControllerBuilder, Unit> onControllerBuild = new Function1<PipelineDraweeControllerBuilder, Unit>() { // from class: com.bytedance.kmp.image.options.AndroidFrescoImageConfigurator$onControllerBuild$1
        public final void invoke(PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder) {
            Intrinsics.checkNotNullParameter(pipelineDraweeControllerBuilder, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PipelineDraweeControllerBuilder) obj);
            return Unit.INSTANCE;
        }
    };
    private Function1<? super ImageRequestBuilder, Unit> onRequestBuild = new Function1<ImageRequestBuilder, Unit>() { // from class: com.bytedance.kmp.image.options.AndroidFrescoImageConfigurator$onRequestBuild$1
        public final void invoke(ImageRequestBuilder imageRequestBuilder) {
            Intrinsics.checkNotNullParameter(imageRequestBuilder, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ImageRequestBuilder) obj);
            return Unit.INSTANCE;
        }
    };

    public final Function1<GenericDraweeHierarchy, Unit> getOnHierarchyBuild$kmpimage_release() {
        return this.onHierarchyBuild;
    }

    public final void setOnHierarchyBuild$kmpimage_release(Function1<? super GenericDraweeHierarchy, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onHierarchyBuild = function1;
    }

    public final Function1<PipelineDraweeControllerBuilder, Unit> getOnControllerBuild$kmpimage_release() {
        return this.onControllerBuild;
    }

    public final void setOnControllerBuild$kmpimage_release(Function1<? super PipelineDraweeControllerBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onControllerBuild = function1;
    }

    public final Function1<ImageRequestBuilder, Unit> getOnRequestBuild$kmpimage_release() {
        return this.onRequestBuild;
    }

    public final void setOnRequestBuild$kmpimage_release(Function1<? super ImageRequestBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onRequestBuild = function1;
    }

    public final AndroidFrescoImageConfigurator buildHierarchy(Function1<? super GenericDraweeHierarchy, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onHierarchyBuild = block;
        return this;
    }

    public final AndroidFrescoImageConfigurator buildController(Function1<? super PipelineDraweeControllerBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onControllerBuild = block;
        return this;
    }

    public final AndroidFrescoImageConfigurator buildRequest(Function1<? super ImageRequestBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onRequestBuild = block;
        return this;
    }
}
