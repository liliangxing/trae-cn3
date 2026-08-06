package com.bytedance.trae.conversation.products;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DiffFile.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0019\u001a\u00020\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J[\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0017R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017¨\u0006'"}, d2 = {"Lcom/bytedance/trae/conversation/products/DiffFile;", "", "oldPath", "", "newPath", "insertLineCount", "", "deleteLineCount", "oldContent", "newContent", "isBinary", "", "isConflict", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ZZ)V", "getOldPath", "()Ljava/lang/String;", "getNewPath", "getInsertLineCount", "()I", "getDeleteLineCount", "getOldContent", "getNewContent", "()Z", "isNewFile", "toUnifiedDiff", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class DiffFile {
    private final int deleteLineCount;
    private final int insertLineCount;
    private final boolean isBinary;
    private final boolean isConflict;
    private final String newContent;
    private final String newPath;
    private final String oldContent;
    private final String oldPath;

    /* renamed from: component1, reason: from getter */
    public final String getOldPath() {
        return this.oldPath;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNewPath() {
        return this.newPath;
    }

    /* renamed from: component3, reason: from getter */
    public final int getInsertLineCount() {
        return this.insertLineCount;
    }

    /* renamed from: component4, reason: from getter */
    public final int getDeleteLineCount() {
        return this.deleteLineCount;
    }

    /* renamed from: component5, reason: from getter */
    public final String getOldContent() {
        return this.oldContent;
    }

    /* renamed from: component6, reason: from getter */
    public final String getNewContent() {
        return this.newContent;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsBinary() {
        return this.isBinary;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsConflict() {
        return this.isConflict;
    }

    public final DiffFile copy(String oldPath, String newPath, int insertLineCount, int deleteLineCount, String oldContent, String newContent, boolean isBinary, boolean isConflict) {
        Intrinsics.checkNotNullParameter(newPath, "newPath");
        Intrinsics.checkNotNullParameter(oldContent, "oldContent");
        Intrinsics.checkNotNullParameter(newContent, "newContent");
        return new DiffFile(oldPath, newPath, insertLineCount, deleteLineCount, oldContent, newContent, isBinary, isConflict);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiffFile)) {
            return false;
        }
        DiffFile diffFile = (DiffFile) other;
        return Intrinsics.areEqual(this.oldPath, diffFile.oldPath) && Intrinsics.areEqual(this.newPath, diffFile.newPath) && this.insertLineCount == diffFile.insertLineCount && this.deleteLineCount == diffFile.deleteLineCount && Intrinsics.areEqual(this.oldContent, diffFile.oldContent) && Intrinsics.areEqual(this.newContent, diffFile.newContent) && this.isBinary == diffFile.isBinary && this.isConflict == diffFile.isConflict;
    }

    public int hashCode() {
        String str = this.oldPath;
        return ((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.newPath.hashCode()) * 31) + Integer.hashCode(this.insertLineCount)) * 31) + Integer.hashCode(this.deleteLineCount)) * 31) + this.oldContent.hashCode()) * 31) + this.newContent.hashCode()) * 31) + Boolean.hashCode(this.isBinary)) * 31) + Boolean.hashCode(this.isConflict);
    }

    public String toString() {
        return "DiffFile(oldPath=" + this.oldPath + ", newPath=" + this.newPath + ", insertLineCount=" + this.insertLineCount + ", deleteLineCount=" + this.deleteLineCount + ", oldContent=" + this.oldContent + ", newContent=" + this.newContent + ", isBinary=" + this.isBinary + ", isConflict=" + this.isConflict + ')';
    }

    public DiffFile(String str, String str2, int i, int i2, String str3, String str4, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str2, "newPath");
        Intrinsics.checkNotNullParameter(str3, "oldContent");
        Intrinsics.checkNotNullParameter(str4, "newContent");
        this.oldPath = str;
        this.newPath = str2;
        this.insertLineCount = i;
        this.deleteLineCount = i2;
        this.oldContent = str3;
        this.newContent = str4;
        this.isBinary = z;
        this.isConflict = z2;
    }

    public /* synthetic */ DiffFile(String str, String str2, int i, int i2, String str3, String str4, boolean z, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, i2, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? "" : str4, (i3 & 64) != 0 ? false : z, (i3 & 128) != 0 ? false : z2);
    }

    public final String getOldPath() {
        return this.oldPath;
    }

    public final String getNewPath() {
        return this.newPath;
    }

    public final int getInsertLineCount() {
        return this.insertLineCount;
    }

    public final int getDeleteLineCount() {
        return this.deleteLineCount;
    }

    public final String getOldContent() {
        return this.oldContent;
    }

    public final String getNewContent() {
        return this.newContent;
    }

    public final boolean isBinary() {
        return this.isBinary;
    }

    public final boolean isConflict() {
        return this.isConflict;
    }

    public final boolean isNewFile() {
        return this.oldPath == null;
    }

    public final String toUnifiedDiff() {
        String str = this.oldPath;
        if (str == null) {
            str = "/dev/null";
        }
        String str2 = isNewFile() ? "" : "a/";
        if (this.isBinary) {
            return StringsKt.trimMargin$default("\n                |diff --git " + str2 + str + " b/" + this.newPath + "\n                |Binary files " + str2 + str + " and b/" + this.newPath + " differ\n            ", (String) null, 1, (Object) null);
        }
        List emptyList = isNewFile() ? CollectionsKt.emptyList() : StringsKt.lines(this.oldContent);
        List lines = StringsKt.lines(this.newContent);
        StringBuilder sb = new StringBuilder();
        sb.append("diff --git " + str2 + str + " b/" + this.newPath).append('\n');
        if (isNewFile()) {
            sb.append("new file mode 100644\n");
        }
        sb.append("--- " + (isNewFile() ? "/dev/null" : str2 + str)).append('\n');
        sb.append("+++ b/" + this.newPath).append('\n');
        sb.append("@@ -" + (isNewFile() ? "0,0" : "1," + emptyList.size()) + " +1," + lines.size() + " @@").append('\n');
        Iterator it = emptyList.iterator();
        while (it.hasNext()) {
            sb.append("-" + ((String) it.next())).append('\n');
        }
        Iterator it2 = lines.iterator();
        while (it2.hasNext()) {
            sb.append("+" + ((String) it2.next())).append('\n');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
