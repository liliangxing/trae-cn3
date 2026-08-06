package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactRepository.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult;", "", "Ready", "Failed", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Failed;", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ArtifactResourceResult {

    /* compiled from: ArtifactRepository.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult;", "localUri", "", "lease", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;)V", "getLocalUri", "()Ljava/lang/String;", "getLease", "()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Ready implements ArtifactResourceResult {
        public static final int $stable = 8;
        private final ArtifactResourceLease lease;
        private final String localUri;

        public static /* synthetic */ Ready copy$default(Ready ready, String str, ArtifactResourceLease artifactResourceLease, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ready.localUri;
            }
            if ((i & 2) != 0) {
                artifactResourceLease = ready.lease;
            }
            return ready.copy(str, artifactResourceLease);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLocalUri() {
            return this.localUri;
        }

        /* renamed from: component2, reason: from getter */
        public final ArtifactResourceLease getLease() {
            return this.lease;
        }

        public final Ready copy(String localUri, ArtifactResourceLease lease) {
            Intrinsics.checkNotNullParameter(localUri, "localUri");
            Intrinsics.checkNotNullParameter(lease, "lease");
            return new Ready(localUri, lease);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ready)) {
                return false;
            }
            Ready ready = (Ready) other;
            return Intrinsics.areEqual(this.localUri, ready.localUri) && Intrinsics.areEqual(this.lease, ready.lease);
        }

        public int hashCode() {
            return (this.localUri.hashCode() * 31) + this.lease.hashCode();
        }

        public String toString() {
            return "Ready(localUri=" + this.localUri + ", lease=" + this.lease + ')';
        }

        public Ready(String localUri, ArtifactResourceLease lease) {
            Intrinsics.checkNotNullParameter(localUri, "localUri");
            Intrinsics.checkNotNullParameter(lease, "lease");
            this.localUri = localUri;
            this.lease = lease;
        }

        public final String getLocalUri() {
            return this.localUri;
        }

        public final ArtifactResourceLease getLease() {
            return this.lease;
        }
    }

    /* compiled from: ArtifactRepository.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Failed;", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Failed implements ArtifactResourceResult {
        public static final int $stable = 0;
        private final String message;

        public static /* synthetic */ Failed copy$default(Failed failed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failed.message;
            }
            return failed.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Failed copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Failed(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failed) && Intrinsics.areEqual(this.message, ((Failed) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Failed(message=" + this.message + ')';
        }

        public Failed(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }
}
