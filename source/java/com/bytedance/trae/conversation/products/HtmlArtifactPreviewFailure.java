package com.bytedance.trae.conversation.products;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HtmlArtifactPreviewRetryPolicy.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;", "", "<init>", "()V", "UrlUnavailable", "ArchiveDownload", "InvalidArchive", "EntryUnavailable", "Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;", "Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$EntryUnavailable;", "Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$InvalidArchive;", "Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$UrlUnavailable;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class HtmlArtifactPreviewFailure {
    public /* synthetic */ HtmlArtifactPreviewFailure(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: HtmlArtifactPreviewRetryPolicy.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$UrlUnavailable;", "Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class UrlUnavailable extends HtmlArtifactPreviewFailure {
        public static final UrlUnavailable INSTANCE = new UrlUnavailable();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UrlUnavailable)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1409224053;
        }

        public String toString() {
            return "UrlUnavailable";
        }

        private UrlUnavailable() {
            super(null);
        }
    }

    private HtmlArtifactPreviewFailure() {
    }

    /* compiled from: HtmlArtifactPreviewRetryPolicy.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;", "Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;", "message", "", "httpStatusCode", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getMessage", "()Ljava/lang/String;", "getHttpStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class ArchiveDownload extends HtmlArtifactPreviewFailure {
        private final Integer httpStatusCode;
        private final String message;

        public static /* synthetic */ ArchiveDownload copy$default(ArchiveDownload archiveDownload, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = archiveDownload.message;
            }
            if ((i & 2) != 0) {
                num = archiveDownload.httpStatusCode;
            }
            return archiveDownload.copy(str, num);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getHttpStatusCode() {
            return this.httpStatusCode;
        }

        public final ArchiveDownload copy(String message, Integer httpStatusCode) {
            return new ArchiveDownload(message, httpStatusCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ArchiveDownload)) {
                return false;
            }
            ArchiveDownload archiveDownload = (ArchiveDownload) other;
            return Intrinsics.areEqual(this.message, archiveDownload.message) && Intrinsics.areEqual(this.httpStatusCode, archiveDownload.httpStatusCode);
        }

        public int hashCode() {
            String str = this.message;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.httpStatusCode;
            return hashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "ArchiveDownload(message=" + this.message + ", httpStatusCode=" + this.httpStatusCode + ')';
        }

        public /* synthetic */ ArchiveDownload(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : num);
        }

        public final String getMessage() {
            return this.message;
        }

        public final Integer getHttpStatusCode() {
            return this.httpStatusCode;
        }

        public ArchiveDownload(String str, Integer num) {
            super(null);
            this.message = str;
            this.httpStatusCode = num;
        }
    }

    /* compiled from: HtmlArtifactPreviewRetryPolicy.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$InvalidArchive;", "Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class InvalidArchive extends HtmlArtifactPreviewFailure {
        public static final InvalidArchive INSTANCE = new InvalidArchive();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidArchive)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 688550111;
        }

        public String toString() {
            return "InvalidArchive";
        }

        private InvalidArchive() {
            super(null);
        }
    }

    /* compiled from: HtmlArtifactPreviewRetryPolicy.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$EntryUnavailable;", "Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class EntryUnavailable extends HtmlArtifactPreviewFailure {
        public static final EntryUnavailable INSTANCE = new EntryUnavailable();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EntryUnavailable)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1442601582;
        }

        public String toString() {
            return "EntryUnavailable";
        }

        private EntryUnavailable() {
            super(null);
        }
    }
}
