package com.bytedance.android.anniex.base.data;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICopyData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0004J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anniex/base/data/ICopyData;", "", "getText", "", "CopyDataBuilder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface ICopyData {
    String getText();

    /* compiled from: ICopyData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/anniex/base/data/ICopyData$CopyDataBuilder;", "", "()V", "copyData", "Lcom/bytedance/android/anniex/base/data/ICopyData$CopyDataBuilder$CopyData;", "build", "Lcom/bytedance/android/anniex/base/data/ICopyData;", "setText", "text", "", "CopyData", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class CopyDataBuilder {
        private final CopyData copyData = new CopyData(null, 1, 0 == true ? 1 : 0);

        /* compiled from: ICopyData.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/anniex/base/data/ICopyData$CopyDataBuilder$CopyData;", "Lcom/bytedance/android/anniex/base/data/ICopyData;", "copyText", "", "(Ljava/lang/String;)V", "getCopyText", "()Ljava/lang/String;", "setCopyText", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "getText", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: classes2.dex */
        private static final /* data */ class CopyData implements ICopyData {
            private String copyText;

            /* JADX WARN: Multi-variable type inference failed */
            public CopyData() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ CopyData copy$default(CopyData copyData, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = copyData.copyText;
                }
                return copyData.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getCopyText() {
                return this.copyText;
            }

            public final CopyData copy(String copyText) {
                return new CopyData(copyText);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CopyData) && Intrinsics.areEqual(this.copyText, ((CopyData) other).copyText);
            }

            public int hashCode() {
                String str = this.copyText;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "CopyData(copyText=" + this.copyText + ')';
            }

            public CopyData(String str) {
                this.copyText = str;
            }

            public /* synthetic */ CopyData(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getCopyText() {
                return this.copyText;
            }

            public final void setCopyText(String str) {
                this.copyText = str;
            }

            @Override // com.bytedance.android.anniex.base.data.ICopyData
            public String getText() {
                return this.copyText;
            }
        }

        public final CopyDataBuilder setText(String text) {
            this.copyData.setCopyText(text);
            return this;
        }

        public final ICopyData build() {
            return this.copyData;
        }
    }
}
