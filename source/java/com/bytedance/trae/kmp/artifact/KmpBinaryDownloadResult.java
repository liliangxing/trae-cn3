package com.bytedance.trae.kmp.artifact;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpArtifactIo.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÇ\u0001J\u0013\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001e\u001a\u00020\u0005H×\u0001J\t\u0010\u001f\u001a\u00020\bH×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;", "", "file", "Lcom/bytedance/trae/kmp/artifact/KmpFileReference;", "statusCode", "", "headers", "", "", "errorMessage", "<init>", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;ILjava/util/Map;Ljava/lang/String;)V", "getFile", "()Lcom/bytedance/trae/kmp/artifact/KmpFileReference;", "getStatusCode", "()I", "getHeaders", "()Ljava/util/Map;", "getErrorMessage", "()Ljava/lang/String;", "isSuccess", "", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class KmpBinaryDownloadResult {
    public static final int $stable = 8;
    private final String errorMessage;
    private final KmpFileReference file;
    private final Map<String, String> headers;
    private final int statusCode;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KmpBinaryDownloadResult copy$default(KmpBinaryDownloadResult kmpBinaryDownloadResult, KmpFileReference kmpFileReference, int i, Map map, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kmpFileReference = kmpBinaryDownloadResult.file;
        }
        if ((i2 & 2) != 0) {
            i = kmpBinaryDownloadResult.statusCode;
        }
        if ((i2 & 4) != 0) {
            map = kmpBinaryDownloadResult.headers;
        }
        if ((i2 & 8) != 0) {
            str = kmpBinaryDownloadResult.errorMessage;
        }
        return kmpBinaryDownloadResult.copy(kmpFileReference, i, map, str);
    }

    /* renamed from: component1, reason: from getter */
    public final KmpFileReference getFile() {
        return this.file;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    /* renamed from: component4, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final KmpBinaryDownloadResult copy(KmpFileReference file, int statusCode, Map<String, String> headers, String errorMessage) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new KmpBinaryDownloadResult(file, statusCode, headers, errorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmpBinaryDownloadResult)) {
            return false;
        }
        KmpBinaryDownloadResult kmpBinaryDownloadResult = (KmpBinaryDownloadResult) other;
        return Intrinsics.areEqual(this.file, kmpBinaryDownloadResult.file) && this.statusCode == kmpBinaryDownloadResult.statusCode && Intrinsics.areEqual(this.headers, kmpBinaryDownloadResult.headers) && Intrinsics.areEqual(this.errorMessage, kmpBinaryDownloadResult.errorMessage);
    }

    public int hashCode() {
        KmpFileReference kmpFileReference = this.file;
        int hashCode = (((((kmpFileReference == null ? 0 : kmpFileReference.hashCode()) * 31) + Integer.hashCode(this.statusCode)) * 31) + this.headers.hashCode()) * 31;
        String str = this.errorMessage;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "KmpBinaryDownloadResult(file=" + this.file + ", statusCode=" + this.statusCode + ", headers=" + this.headers + ", errorMessage=" + this.errorMessage + ')';
    }

    public KmpBinaryDownloadResult(KmpFileReference kmpFileReference, int i, Map<String, String> map, String str) {
        Intrinsics.checkNotNullParameter(map, "headers");
        this.file = kmpFileReference;
        this.statusCode = i;
        this.headers = map;
        this.errorMessage = str;
    }

    public final KmpFileReference getFile() {
        return this.file;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public /* synthetic */ KmpBinaryDownloadResult(KmpFileReference kmpFileReference, int i, Map map, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kmpFileReference, i, (i2 & 4) != 0 ? MapsKt.emptyMap() : map, (i2 & 8) != 0 ? null : str);
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean isSuccess() {
        if (this.file == null) {
            return false;
        }
        int i = this.statusCode;
        return (200 <= i && i < 300) && this.errorMessage == null;
    }
}
