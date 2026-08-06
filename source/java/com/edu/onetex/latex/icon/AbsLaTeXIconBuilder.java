package com.edu.onetex.latex.icon;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsLaTeXIconBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b'\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H&J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/edu/onetex/latex/icon/AbsLaTeXIconBuilder;", "", "nativePtr", "", "paramPtr", "(JJ)V", "build", "Lcom/edu/onetex/latex/icon/LaTeXIcon;", "finalize", "", "setSize", "size", "", "setStyle", "style", "setType", "type", "Companion", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public abstract class AbsLaTeXIconBuilder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private long nativePtr;
    private long paramPtr;

    public abstract LaTeXIcon build();

    public AbsLaTeXIconBuilder(long j, long j2) {
        this.nativePtr = j;
        this.paramPtr = j2;
    }

    public final void setSize(int size) {
        INSTANCE.nSetSize(this.nativePtr, size);
    }

    public final void setStyle(int style) {
        INSTANCE.nSetStyle(this.nativePtr, style);
    }

    public final void setType(int type) {
        INSTANCE.nSetType(this.nativePtr, type);
    }

    public final void finalize() {
        long j = this.nativePtr;
        if (j != 0) {
            INSTANCE.nFinalize(j, this.paramPtr);
            this.nativePtr = 0L;
        }
    }

    /* compiled from: AbsLaTeXIconBuilder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0082 J\u0019\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0082 J\u0019\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nH\u0082 J\u0019\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nH\u0082 ¨\u0006\u000f"}, d2 = {"Lcom/edu/onetex/latex/icon/AbsLaTeXIconBuilder$Companion;", "", "()V", "nFinalize", "", "ptr", "", "paramPtr", "nSetSize", "size", "", "nSetStyle", "style", "nSetType", "type", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class Companion {
        /* JADX INFO: Access modifiers changed from: private */
        public final native void nFinalize(long ptr, long paramPtr);

        /* JADX INFO: Access modifiers changed from: private */
        public final native void nSetSize(long ptr, int size);

        /* JADX INFO: Access modifiers changed from: private */
        public final native void nSetStyle(long ptr, int style);

        /* JADX INFO: Access modifiers changed from: private */
        public final native void nSetType(long ptr, int type);

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
