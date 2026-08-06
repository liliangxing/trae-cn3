package com.bytedance.trae.conversation.products;

import com.bytedance.forest.model.PreloadConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileDownloadHelper.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/products/DownloadCacheResult;", "", "<init>", "()V", "Success", "Failure", "Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;", "Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Success;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class DownloadCacheResult {
    public /* synthetic */ DownloadCacheResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: FileDownloadHelper.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Success;", "Lcom/bytedance/trae/conversation/products/DownloadCacheResult;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Success extends DownloadCacheResult {
        private final File file;

        public static /* synthetic */ Success copy$default(Success success, File file, int i, Object obj) {
            if ((i & 1) != 0) {
                file = success.file;
            }
            return success.copy(file);
        }

        /* renamed from: component1, reason: from getter */
        public final File getFile() {
            return this.file;
        }

        public final Success copy(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new Success(file);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.file, ((Success) other).file);
        }

        public int hashCode() {
            return this.file.hashCode();
        }

        public String toString() {
            return "Success(file=" + this.file + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(File file) {
            super(null);
            Intrinsics.checkNotNullParameter(file, "file");
            this.file = file;
        }

        public final File getFile() {
            return this.file;
        }
    }

    private DownloadCacheResult() {
    }

    /* compiled from: FileDownloadHelper.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;", "Lcom/bytedance/trae/conversation/products/DownloadCacheResult;", "message", "", "httpStatusCode", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getMessage", "()Ljava/lang/String;", "getHttpStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Failure extends DownloadCacheResult {
        private final Integer httpStatusCode;
        private final String message;

        public static /* synthetic */ Failure copy$default(Failure failure, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failure.message;
            }
            if ((i & 2) != 0) {
                num = failure.httpStatusCode;
            }
            return failure.copy(str, num);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getHttpStatusCode() {
            return this.httpStatusCode;
        }

        public final Failure copy(String message, Integer httpStatusCode) {
            return new Failure(message, httpStatusCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) other;
            return Intrinsics.areEqual(this.message, failure.message) && Intrinsics.areEqual(this.httpStatusCode, failure.httpStatusCode);
        }

        public int hashCode() {
            String str = this.message;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.httpStatusCode;
            return hashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "Failure(message=" + this.message + ", httpStatusCode=" + this.httpStatusCode + ')';
        }

        public /* synthetic */ Failure(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : num);
        }

        public final String getMessage() {
            return this.message;
        }

        public final Integer getHttpStatusCode() {
            return this.httpStatusCode;
        }

        public Failure(String str, Integer num) {
            super(null);
            this.message = str;
            this.httpStatusCode = num;
        }
    }
}
