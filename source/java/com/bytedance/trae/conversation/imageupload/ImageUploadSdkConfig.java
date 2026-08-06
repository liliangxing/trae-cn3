package com.bytedance.trae.conversation.imageupload;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B³\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012:\b\u0002\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J$\u0010*\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bHÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bHÆ\u0003J\u0013\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000bHÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J;\u0010/\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011HÆ\u0003JÀ\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001e\b\u0002\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\r2:\b\u0002\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR)\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\"R\u001b\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%RC\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00067"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;", "", "uploaderConfig", "Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;", "api", "Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;", "getUserId", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "getImagexPrefix", "Lkotlin/Function0;", "isCnRegion", "", "getRegion", "enableContentCheck", "onImageCached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "tosUri", "Lcom/bytedance/trae/conversation/imageupload/ImageCacheData;", "data", "", "<init>", "(Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;)V", "getUploaderConfig", "()Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;", "getApi", "()Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;", "getGetUserId", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "getGetImagexPrefix", "()Lkotlin/jvm/functions/Function0;", "getGetRegion", "getEnableContentCheck", "()Z", "getOnImageCached", "()Lkotlin/jvm/functions/Function2;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;)Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ImageUploadSdkConfig {
    private final ImageUploadApi api;
    private final boolean enableContentCheck;
    private final Function0<String> getImagexPrefix;
    private final Function0<String> getRegion;
    private final Function1<Continuation<? super String>, Object> getUserId;
    private final Function0<Boolean> isCnRegion;
    private final Function2<String, ImageCacheData, Unit> onImageCached;
    private final UploaderConfig uploaderConfig;

    /* renamed from: component1, reason: from getter */
    public final UploaderConfig getUploaderConfig() {
        return this.uploaderConfig;
    }

    /* renamed from: component2, reason: from getter */
    public final ImageUploadApi getApi() {
        return this.api;
    }

    public final Function1<Continuation<? super String>, Object> component3() {
        return this.getUserId;
    }

    public final Function0<String> component4() {
        return this.getImagexPrefix;
    }

    public final Function0<Boolean> component5() {
        return this.isCnRegion;
    }

    public final Function0<String> component6() {
        return this.getRegion;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getEnableContentCheck() {
        return this.enableContentCheck;
    }

    public final Function2<String, ImageCacheData, Unit> component8() {
        return this.onImageCached;
    }

    public final ImageUploadSdkConfig copy(UploaderConfig uploaderConfig, ImageUploadApi api, Function1<? super Continuation<? super String>, ? extends Object> getUserId, Function0<String> getImagexPrefix, Function0<Boolean> isCnRegion, Function0<String> getRegion, boolean enableContentCheck, Function2<? super String, ? super ImageCacheData, Unit> onImageCached) {
        Intrinsics.checkNotNullParameter(uploaderConfig, "uploaderConfig");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(getUserId, "getUserId");
        return new ImageUploadSdkConfig(uploaderConfig, api, getUserId, getImagexPrefix, isCnRegion, getRegion, enableContentCheck, onImageCached);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageUploadSdkConfig)) {
            return false;
        }
        ImageUploadSdkConfig imageUploadSdkConfig = (ImageUploadSdkConfig) other;
        return Intrinsics.areEqual(this.uploaderConfig, imageUploadSdkConfig.uploaderConfig) && Intrinsics.areEqual(this.api, imageUploadSdkConfig.api) && Intrinsics.areEqual(this.getUserId, imageUploadSdkConfig.getUserId) && Intrinsics.areEqual(this.getImagexPrefix, imageUploadSdkConfig.getImagexPrefix) && Intrinsics.areEqual(this.isCnRegion, imageUploadSdkConfig.isCnRegion) && Intrinsics.areEqual(this.getRegion, imageUploadSdkConfig.getRegion) && this.enableContentCheck == imageUploadSdkConfig.enableContentCheck && Intrinsics.areEqual(this.onImageCached, imageUploadSdkConfig.onImageCached);
    }

    public int hashCode() {
        int hashCode = ((((this.uploaderConfig.hashCode() * 31) + this.api.hashCode()) * 31) + this.getUserId.hashCode()) * 31;
        Function0<String> function0 = this.getImagexPrefix;
        int hashCode2 = (hashCode + (function0 == null ? 0 : function0.hashCode())) * 31;
        Function0<Boolean> function02 = this.isCnRegion;
        int hashCode3 = (hashCode2 + (function02 == null ? 0 : function02.hashCode())) * 31;
        Function0<String> function03 = this.getRegion;
        int hashCode4 = (((hashCode3 + (function03 == null ? 0 : function03.hashCode())) * 31) + Boolean.hashCode(this.enableContentCheck)) * 31;
        Function2<String, ImageCacheData, Unit> function2 = this.onImageCached;
        return hashCode4 + (function2 != null ? function2.hashCode() : 0);
    }

    public String toString() {
        return "ImageUploadSdkConfig(uploaderConfig=" + this.uploaderConfig + ", api=" + this.api + ", getUserId=" + this.getUserId + ", getImagexPrefix=" + this.getImagexPrefix + ", isCnRegion=" + this.isCnRegion + ", getRegion=" + this.getRegion + ", enableContentCheck=" + this.enableContentCheck + ", onImageCached=" + this.onImageCached + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageUploadSdkConfig(UploaderConfig uploaderConfig, ImageUploadApi imageUploadApi, Function1<? super Continuation<? super String>, ? extends Object> function1, Function0<String> function0, Function0<Boolean> function02, Function0<String> function03, boolean z, Function2<? super String, ? super ImageCacheData, Unit> function2) {
        Intrinsics.checkNotNullParameter(uploaderConfig, "uploaderConfig");
        Intrinsics.checkNotNullParameter(imageUploadApi, "api");
        Intrinsics.checkNotNullParameter(function1, "getUserId");
        this.uploaderConfig = uploaderConfig;
        this.api = imageUploadApi;
        this.getUserId = function1;
        this.getImagexPrefix = function0;
        this.isCnRegion = function02;
        this.getRegion = function03;
        this.enableContentCheck = z;
        this.onImageCached = function2;
    }

    public /* synthetic */ ImageUploadSdkConfig(UploaderConfig uploaderConfig, ImageUploadApi imageUploadApi, Function1 function1, Function0 function0, Function0 function02, Function0 function03, boolean z, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uploaderConfig, imageUploadApi, function1, (i & 8) != 0 ? null : function0, (i & 16) != 0 ? null : function02, (i & 32) != 0 ? null : function03, (i & 64) != 0 ? false : z, (i & 128) != 0 ? null : function2);
    }

    public final UploaderConfig getUploaderConfig() {
        return this.uploaderConfig;
    }

    public final ImageUploadApi getApi() {
        return this.api;
    }

    public final Function1<Continuation<? super String>, Object> getGetUserId() {
        return this.getUserId;
    }

    public final Function0<String> getGetImagexPrefix() {
        return this.getImagexPrefix;
    }

    public final Function0<Boolean> isCnRegion() {
        return this.isCnRegion;
    }

    public final Function0<String> getGetRegion() {
        return this.getRegion;
    }

    public final boolean getEnableContentCheck() {
        return this.enableContentCheck;
    }

    public final Function2<String, ImageCacheData, Unit> getOnImageCached() {
        return this.onImageCached;
    }
}
