package com.bytedance.iesgurd;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.forest.model.PreloadConfig;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IESGurdResData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JA\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\tHÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/bytedance/iesgurd/IESGurdResData;", "", "error", "Lcom/bytedance/iesgurd/IESGurdResError;", "resFrom", "Lcom/bytedance/iesgurd/IESGurdResFrom;", "id", "", "path", "", "data", "Ljava/io/InputStream;", "(Lcom/bytedance/iesgurd/IESGurdResError;Lcom/bytedance/iesgurd/IESGurdResFrom;JLjava/lang/String;Ljava/io/InputStream;)V", "getData", "()Ljava/io/InputStream;", AirActionConstant.ActionId.ACTION_ID_NAME_SET_DATA, "(Ljava/io/InputStream;)V", "getError", "()Lcom/bytedance/iesgurd/IESGurdResError;", "getId", "()J", "getPath", "()Ljava/lang/String;", "getResFrom", "()Lcom/bytedance/iesgurd/IESGurdResFrom;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final /* data */ class IESGurdResData {
    private InputStream data;
    private final IESGurdResError error;
    private final long id;
    private final String path;
    private final IESGurdResFrom resFrom;

    public IESGurdResData() {
        this(null, null, 0L, null, null, 31, null);
    }

    public static /* synthetic */ IESGurdResData copy$default(IESGurdResData iESGurdResData, IESGurdResError iESGurdResError, IESGurdResFrom iESGurdResFrom, long j, String str, InputStream inputStream, int i, Object obj) {
        if ((i & 1) != 0) {
            iESGurdResError = iESGurdResData.error;
        }
        if ((i & 2) != 0) {
            iESGurdResFrom = iESGurdResData.resFrom;
        }
        IESGurdResFrom iESGurdResFrom2 = iESGurdResFrom;
        if ((i & 4) != 0) {
            j = iESGurdResData.id;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str = iESGurdResData.path;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            inputStream = iESGurdResData.data;
        }
        return iESGurdResData.copy(iESGurdResError, iESGurdResFrom2, j2, str2, inputStream);
    }

    /* renamed from: component1, reason: from getter */
    public final IESGurdResError getError() {
        return this.error;
    }

    /* renamed from: component2, reason: from getter */
    public final IESGurdResFrom getResFrom() {
        return this.resFrom;
    }

    /* renamed from: component3, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component5, reason: from getter */
    public final InputStream getData() {
        return this.data;
    }

    public final IESGurdResData copy(IESGurdResError error, IESGurdResFrom resFrom, long id, String path, InputStream data) {
        Intrinsics.checkParameterIsNotNull(resFrom, "resFrom");
        return new IESGurdResData(error, resFrom, id, path, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IESGurdResData)) {
            return false;
        }
        IESGurdResData iESGurdResData = (IESGurdResData) other;
        return Intrinsics.areEqual(this.error, iESGurdResData.error) && Intrinsics.areEqual(this.resFrom, iESGurdResData.resFrom) && this.id == iESGurdResData.id && Intrinsics.areEqual(this.path, iESGurdResData.path) && Intrinsics.areEqual(this.data, iESGurdResData.data);
    }

    public int hashCode() {
        IESGurdResError iESGurdResError = this.error;
        int hashCode = (iESGurdResError != null ? iESGurdResError.hashCode() : 0) * 31;
        IESGurdResFrom iESGurdResFrom = this.resFrom;
        int hashCode2 = (hashCode + (iESGurdResFrom != null ? iESGurdResFrom.hashCode() : 0)) * 31;
        long j = this.id;
        int i = (hashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.path;
        int hashCode3 = (i + (str != null ? str.hashCode() : 0)) * 31;
        InputStream inputStream = this.data;
        return hashCode3 + (inputStream != null ? inputStream.hashCode() : 0);
    }

    public String toString() {
        return "IESGurdResData(error=" + this.error + ", resFrom=" + this.resFrom + ", id=" + this.id + ", path=" + this.path + ", data=" + this.data + ")";
    }

    public IESGurdResData(IESGurdResError iESGurdResError, IESGurdResFrom resFrom, long j, String str, InputStream inputStream) {
        Intrinsics.checkParameterIsNotNull(resFrom, "resFrom");
        this.error = iESGurdResError;
        this.resFrom = resFrom;
        this.id = j;
        this.path = str;
        this.data = inputStream;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ IESGurdResData(IESGurdResError iESGurdResError, IESGurdResFrom iESGurdResFrom, long j, String str, InputStream inputStream, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iESGurdResError, r12, r1, r3, r0);
        String str2;
        InputStream inputStream2 = null;
        if ((i & 1) != 0) {
            iESGurdResError = null;
        }
        IESGurdResFrom iESGurdResFrom2 = (i & 2) != 0 ? IESGurdResFrom.NONE : iESGurdResFrom;
        long j2 = (i & 4) != 0 ? 0L : j;
        if ((i & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i & 16) != 0) {
        } else {
            inputStream2 = inputStream;
        }
    }

    public final IESGurdResError getError() {
        return this.error;
    }

    public final IESGurdResFrom getResFrom() {
        return this.resFrom;
    }

    public final long getId() {
        return this.id;
    }

    public final String getPath() {
        return this.path;
    }

    public final InputStream getData() {
        return this.data;
    }

    public final void setData(InputStream inputStream) {
        this.data = inputStream;
    }
}
