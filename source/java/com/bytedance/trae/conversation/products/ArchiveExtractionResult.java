package com.bytedance.trae.conversation.products;

import com.bytedance.forest.model.PreloadConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HtmlArtifactPreviewActivity.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult;", "", "<init>", "()V", "Success", "Failure", "Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Failure;", "Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
abstract class ArchiveExtractionResult {
    public /* synthetic */ ArchiveExtractionResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: HtmlArtifactPreviewActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;", "Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult;", "extractDir", "Ljava/io/File;", "archiveFile", "<init>", "(Ljava/io/File;Ljava/io/File;)V", "getExtractDir", "()Ljava/io/File;", "getArchiveFile", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Success extends ArchiveExtractionResult {
        private final File archiveFile;
        private final File extractDir;

        public static /* synthetic */ Success copy$default(Success success, File file, File file2, int i, Object obj) {
            if ((i & 1) != 0) {
                file = success.extractDir;
            }
            if ((i & 2) != 0) {
                file2 = success.archiveFile;
            }
            return success.copy(file, file2);
        }

        /* renamed from: component1, reason: from getter */
        public final File getExtractDir() {
            return this.extractDir;
        }

        /* renamed from: component2, reason: from getter */
        public final File getArchiveFile() {
            return this.archiveFile;
        }

        public final Success copy(File extractDir, File archiveFile) {
            Intrinsics.checkNotNullParameter(extractDir, "extractDir");
            Intrinsics.checkNotNullParameter(archiveFile, "archiveFile");
            return new Success(extractDir, archiveFile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.extractDir, success.extractDir) && Intrinsics.areEqual(this.archiveFile, success.archiveFile);
        }

        public int hashCode() {
            return (this.extractDir.hashCode() * 31) + this.archiveFile.hashCode();
        }

        public String toString() {
            return "Success(extractDir=" + this.extractDir + ", archiveFile=" + this.archiveFile + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(File extractDir, File archiveFile) {
            super(null);
            Intrinsics.checkNotNullParameter(extractDir, "extractDir");
            Intrinsics.checkNotNullParameter(archiveFile, "archiveFile");
            this.extractDir = extractDir;
            this.archiveFile = archiveFile;
        }

        public final File getArchiveFile() {
            return this.archiveFile;
        }

        public final File getExtractDir() {
            return this.extractDir;
        }
    }

    private ArchiveExtractionResult() {
    }

    /* compiled from: HtmlArtifactPreviewActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Failure;", "Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult;", "failure", "Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;", "<init>", "(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;)V", "getFailure", "()Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Failure extends ArchiveExtractionResult {
        private final HtmlArtifactPreviewFailure failure;

        public static /* synthetic */ Failure copy$default(Failure failure, HtmlArtifactPreviewFailure htmlArtifactPreviewFailure, int i, Object obj) {
            if ((i & 1) != 0) {
                htmlArtifactPreviewFailure = failure.failure;
            }
            return failure.copy(htmlArtifactPreviewFailure);
        }

        /* renamed from: component1, reason: from getter */
        public final HtmlArtifactPreviewFailure getFailure() {
            return this.failure;
        }

        public final Failure copy(HtmlArtifactPreviewFailure failure) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            return new Failure(failure);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failure) && Intrinsics.areEqual(this.failure, ((Failure) other).failure);
        }

        public int hashCode() {
            return this.failure.hashCode();
        }

        public String toString() {
            return "Failure(failure=" + this.failure + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(HtmlArtifactPreviewFailure failure) {
            super(null);
            Intrinsics.checkNotNullParameter(failure, "failure");
            this.failure = failure;
        }

        public final HtmlArtifactPreviewFailure getFailure() {
            return this.failure;
        }
    }
}
