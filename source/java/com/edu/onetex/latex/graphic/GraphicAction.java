package com.edu.onetex.latex.graphic;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GraphicAction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/edu/onetex/latex/graphic/GraphicAction;", "", StrategyConstants.ACTION, "", "arg", "args", "", "intArgs", "", "(BLjava/lang/Object;[F[I)V", "getAction", "()B", "setAction", "(B)V", "getArg", "()Ljava/lang/Object;", "setArg", "(Ljava/lang/Object;)V", "getArgs", "()[F", "setArgs", "([F)V", "getIntArgs", "()[I", "setIntArgs", "([I)V", "toString", "", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class GraphicAction {
    private byte action;
    private Object arg;
    private float[] args;
    private int[] intArgs;

    public GraphicAction(byte b, Object obj, float[] fArr, int[] iArr) {
        this.action = b;
        this.arg = obj;
        this.args = fArr;
        this.intArgs = iArr;
    }

    public final byte getAction() {
        return this.action;
    }

    public final Object getArg() {
        return this.arg;
    }

    public final float[] getArgs() {
        return this.args;
    }

    public final int[] getIntArgs() {
        return this.intArgs;
    }

    public final void setAction(byte b) {
        this.action = b;
    }

    public final void setArg(Object obj) {
        this.arg = obj;
    }

    public final void setArgs(float[] fArr) {
        this.args = fArr;
    }

    public final void setIntArgs(int[] iArr) {
        this.intArgs = iArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ action: ").append((int) this.action).append(", arg: ").append(this.arg).append(", args: [");
        float[] fArr = this.args;
        if (fArr == null) {
            Intrinsics.checkNotNullExpressionValue(sb.append("null"), "builder.append(\"null\")");
        } else {
            Intrinsics.checkNotNull(fArr);
            for (float f : fArr) {
                sb.append(f).append(", ");
            }
        }
        sb.append("] }");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }
}
