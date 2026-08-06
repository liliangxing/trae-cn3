package com.bytedance.android.anniex.base.data;

import com.bytedance.forest.model.PreloadConfig;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lynx.tasm.LynxError;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ISaveImageData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\n\u000bR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/anniex/base/data/ISaveImageData;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/android/anniex/base/data/ISaveImageData$SaveImageListener;", "getListener", "()Lcom/bytedance/android/anniex/base/data/ISaveImageData$SaveImageListener;", "url", "", "getUrl", "()Ljava/lang/String;", "SaveImageDataBuilder", "SaveImageListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface ISaveImageData {

    /* compiled from: ISaveImageData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/base/data/ISaveImageData$SaveImageListener;", "", "()V", "onFailure", "", LynxError.LYNX_THROWABLE, "", "onSuccess", "data", "Ljava/io/File;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static class SaveImageListener {
        public void onFailure(Throwable throwable) {
        }

        public void onSuccess(File data) {
        }
    }

    SaveImageListener getListener();

    String getUrl();

    /* compiled from: ISaveImageData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/anniex/base/data/ISaveImageData$SaveImageDataBuilder;", "", "url", "", "(Ljava/lang/String;)V", "saveImageData", "Lcom/bytedance/android/anniex/base/data/ISaveImageData$SaveImageDataBuilder$SaveImageData;", "build", "Lcom/bytedance/android/anniex/base/data/ISaveImageData;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/android/anniex/base/data/ISaveImageData$SaveImageListener;", "SaveImageData", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class SaveImageDataBuilder {
        private final SaveImageData saveImageData;

        /* compiled from: ISaveImageData.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/anniex/base/data/ISaveImageData$SaveImageDataBuilder$SaveImageData;", "Lcom/bytedance/android/anniex/base/data/ISaveImageData;", "url", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/android/anniex/base/data/ISaveImageData$SaveImageListener;", "(Ljava/lang/String;Lcom/bytedance/android/anniex/base/data/ISaveImageData$SaveImageListener;)V", "getListener", "()Lcom/bytedance/android/anniex/base/data/ISaveImageData$SaveImageListener;", "setListener", "(Lcom/bytedance/android/anniex/base/data/ISaveImageData$SaveImageListener;)V", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: classes2.dex */
        private static final /* data */ class SaveImageData implements ISaveImageData {
            private SaveImageListener listener;
            private final String url;

            public static /* synthetic */ SaveImageData copy$default(SaveImageData saveImageData, String str, SaveImageListener saveImageListener, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = saveImageData.url;
                }
                if ((i & 2) != 0) {
                    saveImageListener = saveImageData.listener;
                }
                return saveImageData.copy(str, saveImageListener);
            }

            /* renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            /* renamed from: component2, reason: from getter */
            public final SaveImageListener getListener() {
                return this.listener;
            }

            public final SaveImageData copy(String url, SaveImageListener listener) {
                Intrinsics.checkNotNullParameter(url, "url");
                return new SaveImageData(url, listener);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SaveImageData)) {
                    return false;
                }
                SaveImageData saveImageData = (SaveImageData) other;
                return Intrinsics.areEqual(this.url, saveImageData.url) && Intrinsics.areEqual(this.listener, saveImageData.listener);
            }

            public int hashCode() {
                int hashCode = this.url.hashCode() * 31;
                SaveImageListener saveImageListener = this.listener;
                return hashCode + (saveImageListener == null ? 0 : saveImageListener.hashCode());
            }

            public String toString() {
                return "SaveImageData(url=" + this.url + ", listener=" + this.listener + ')';
            }

            public SaveImageData(String url, SaveImageListener saveImageListener) {
                Intrinsics.checkNotNullParameter(url, "url");
                this.url = url;
                this.listener = saveImageListener;
            }

            public /* synthetic */ SaveImageData(String str, SaveImageListener saveImageListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : saveImageListener);
            }

            @Override // com.bytedance.android.anniex.base.data.ISaveImageData
            public String getUrl() {
                return this.url;
            }

            @Override // com.bytedance.android.anniex.base.data.ISaveImageData
            public SaveImageListener getListener() {
                return this.listener;
            }

            public void setListener(SaveImageListener saveImageListener) {
                this.listener = saveImageListener;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SaveImageDataBuilder(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.saveImageData = new SaveImageData(url, null, 2, 0 == true ? 1 : 0);
        }

        public final SaveImageDataBuilder listener(SaveImageListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.saveImageData.setListener(listener);
            return this;
        }

        public final ISaveImageData build() {
            return this.saveImageData;
        }
    }
}
