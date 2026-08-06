package com.bytedance.android.anniex.base.data;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.xbridge.XBridge;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lynx.tasm.provider.LynxProviderRegistry;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDownloadData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0002\u0018\u0019R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/anniex/base/data/IDownloadData;", "", "callbackOnMainThread", "", "getCallbackOnMainThread", "()Z", "fileName", "", "getFileName", "()Ljava/lang/String;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/ss/android/socialbase/downloader/depend/IDownloadListener;", "getListener", "()Lcom/ss/android/socialbase/downloader/depend/IDownloadListener;", "saveDir", "getSaveDir", "scene", "", "getScene$annotations", "()V", "getScene", "()I", "url", "getUrl", "DownloadDataBuilder", "DownloadScene", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IDownloadData {

    /* compiled from: IDownloadData.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @DownloadScene
        public static /* synthetic */ void getScene$annotations() {
        }
    }

    boolean getCallbackOnMainThread();

    String getFileName();

    IDownloadListener getListener();

    String getSaveDir();

    int getScene();

    String getUrl();

    /* compiled from: IDownloadData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/anniex/base/data/IDownloadData$DownloadDataBuilder;", "", "url", "", "(Ljava/lang/String;)V", "downloadData", "Lcom/bytedance/android/anniex/base/data/IDownloadData$DownloadDataBuilder$DownloadData;", "build", "Lcom/bytedance/android/anniex/base/data/IDownloadData;", "callbackOnMainThread", "", "fileName", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/ss/android/socialbase/downloader/depend/IDownloadListener;", "saveDir", "scene", "", "DownloadData", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DownloadDataBuilder {
        private final DownloadData downloadData;

        /* compiled from: IDownloadData.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003JK\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012¨\u0006,"}, d2 = {"Lcom/bytedance/android/anniex/base/data/IDownloadData$DownloadDataBuilder$DownloadData;", "Lcom/bytedance/android/anniex/base/data/IDownloadData;", "url", "", "scene", "", "saveDir", "fileName", "callbackOnMainThread", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/ss/android/socialbase/downloader/depend/IDownloadListener;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLcom/ss/android/socialbase/downloader/depend/IDownloadListener;)V", "getCallbackOnMainThread", "()Z", "setCallbackOnMainThread", "(Z)V", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "getListener", "()Lcom/ss/android/socialbase/downloader/depend/IDownloadListener;", "setListener", "(Lcom/ss/android/socialbase/downloader/depend/IDownloadListener;)V", "getSaveDir", "setSaveDir", "getScene", "()I", "setScene", "(I)V", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: classes2.dex */
        private static final /* data */ class DownloadData implements IDownloadData {
            private boolean callbackOnMainThread;
            private String fileName;
            private IDownloadListener listener;
            private String saveDir;
            private int scene;
            private final String url;

            public static /* synthetic */ DownloadData copy$default(DownloadData downloadData, String str, int i, String str2, String str3, boolean z, IDownloadListener iDownloadListener, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = downloadData.url;
                }
                if ((i2 & 2) != 0) {
                    i = downloadData.scene;
                }
                int i3 = i;
                if ((i2 & 4) != 0) {
                    str2 = downloadData.saveDir;
                }
                String str4 = str2;
                if ((i2 & 8) != 0) {
                    str3 = downloadData.fileName;
                }
                String str5 = str3;
                if ((i2 & 16) != 0) {
                    z = downloadData.callbackOnMainThread;
                }
                boolean z2 = z;
                if ((i2 & 32) != 0) {
                    iDownloadListener = downloadData.listener;
                }
                return downloadData.copy(str, i3, str4, str5, z2, iDownloadListener);
            }

            /* renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            /* renamed from: component2, reason: from getter */
            public final int getScene() {
                return this.scene;
            }

            /* renamed from: component3, reason: from getter */
            public final String getSaveDir() {
                return this.saveDir;
            }

            /* renamed from: component4, reason: from getter */
            public final String getFileName() {
                return this.fileName;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getCallbackOnMainThread() {
                return this.callbackOnMainThread;
            }

            /* renamed from: component6, reason: from getter */
            public final IDownloadListener getListener() {
                return this.listener;
            }

            public final DownloadData copy(String url, @DownloadScene int scene, String saveDir, String fileName, boolean callbackOnMainThread, IDownloadListener listener) {
                Intrinsics.checkNotNullParameter(url, "url");
                return new DownloadData(url, scene, saveDir, fileName, callbackOnMainThread, listener);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DownloadData)) {
                    return false;
                }
                DownloadData downloadData = (DownloadData) other;
                return Intrinsics.areEqual(this.url, downloadData.url) && this.scene == downloadData.scene && Intrinsics.areEqual(this.saveDir, downloadData.saveDir) && Intrinsics.areEqual(this.fileName, downloadData.fileName) && this.callbackOnMainThread == downloadData.callbackOnMainThread && Intrinsics.areEqual(this.listener, downloadData.listener);
            }

            public int hashCode() {
                int hashCode = ((this.url.hashCode() * 31) + Integer.hashCode(this.scene)) * 31;
                String str = this.saveDir;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.fileName;
                int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.callbackOnMainThread)) * 31;
                IDownloadListener iDownloadListener = this.listener;
                return hashCode3 + (iDownloadListener != null ? iDownloadListener.hashCode() : 0);
            }

            public String toString() {
                return "DownloadData(url=" + this.url + ", scene=" + this.scene + ", saveDir=" + this.saveDir + ", fileName=" + this.fileName + ", callbackOnMainThread=" + this.callbackOnMainThread + ", listener=" + this.listener + ')';
            }

            public DownloadData(String url, @DownloadScene int i, String str, String str2, boolean z, IDownloadListener iDownloadListener) {
                Intrinsics.checkNotNullParameter(url, "url");
                this.url = url;
                this.scene = i;
                this.saveDir = str;
                this.fileName = str2;
                this.callbackOnMainThread = z;
                this.listener = iDownloadListener;
            }

            public /* synthetic */ DownloadData(String str, int i, String str2, String str3, boolean z, IDownloadListener iDownloadListener, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) == 0 ? z : false, (i2 & 32) == 0 ? iDownloadListener : null);
            }

            @Override // com.bytedance.android.anniex.base.data.IDownloadData
            public String getUrl() {
                return this.url;
            }

            @Override // com.bytedance.android.anniex.base.data.IDownloadData
            public int getScene() {
                return this.scene;
            }

            public void setScene(int i) {
                this.scene = i;
            }

            @Override // com.bytedance.android.anniex.base.data.IDownloadData
            public String getSaveDir() {
                return this.saveDir;
            }

            public void setSaveDir(String str) {
                this.saveDir = str;
            }

            @Override // com.bytedance.android.anniex.base.data.IDownloadData
            public String getFileName() {
                return this.fileName;
            }

            public void setFileName(String str) {
                this.fileName = str;
            }

            @Override // com.bytedance.android.anniex.base.data.IDownloadData
            public boolean getCallbackOnMainThread() {
                return this.callbackOnMainThread;
            }

            public void setCallbackOnMainThread(boolean z) {
                this.callbackOnMainThread = z;
            }

            @Override // com.bytedance.android.anniex.base.data.IDownloadData
            public IDownloadListener getListener() {
                return this.listener;
            }

            public void setListener(IDownloadListener iDownloadListener) {
                this.listener = iDownloadListener;
            }
        }

        public DownloadDataBuilder(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.downloadData = new DownloadData(url, 0, null, null, false, null, 62, null);
        }

        public final DownloadDataBuilder scene(@DownloadScene int scene) {
            this.downloadData.setScene(scene);
            return this;
        }

        public final DownloadDataBuilder saveDir(String saveDir) {
            this.downloadData.setSaveDir(saveDir);
            return this;
        }

        public final DownloadDataBuilder fileName(String fileName) {
            this.downloadData.setFileName(fileName);
            return this;
        }

        public final DownloadDataBuilder callbackOnMainThread(boolean callbackOnMainThread) {
            this.downloadData.setCallbackOnMainThread(callbackOnMainThread);
            return this;
        }

        public final DownloadDataBuilder listener(IDownloadListener listener) {
            this.downloadData.setListener(listener);
            return this;
        }

        public final IDownloadData build() {
            return this.downloadData;
        }
    }

    /* compiled from: IDownloadData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/anniex/base/data/IDownloadData$DownloadScene;", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes2.dex */
    public @interface DownloadScene {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int DEFAULT = 0;
        public static final int IMAGE = 1;

        /* compiled from: IDownloadData.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/anniex/base/data/IDownloadData$DownloadScene$Companion;", "", "()V", XBridge.DEFAULT_NAMESPACE, "", LynxProviderRegistry.LYNX_PROVIDER_TYPE_IMAGE, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int DEFAULT = 0;
            public static final int IMAGE = 1;

            private Companion() {
            }
        }
    }
}
