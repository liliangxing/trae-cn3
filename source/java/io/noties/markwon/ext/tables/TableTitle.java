package io.noties.markwon.ext.tables;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.CustomNode;

/* compiled from: TableTitle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lio/noties/markwon/ext/tables/TableTitle;", "Lorg/commonmark/node/CustomNode;", "()V", "excelLiteral", "", "getExcelLiteral", "()Ljava/lang/String;", "setExcelLiteral", "(Ljava/lang/String;)V", "info", "getInfo", "setInfo", "literal", "getLiteral", "setLiteral", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class TableTitle extends CustomNode {
    private String info = "";
    private String literal = "";
    private String excelLiteral = "";

    public final String getInfo() {
        return this.info;
    }

    public final void setInfo(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.info = str;
    }

    public final String getLiteral() {
        return this.literal;
    }

    public final void setLiteral(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.literal = str;
    }

    public final String getExcelLiteral() {
        return this.excelLiteral;
    }

    public final void setExcelLiteral(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.excelLiteral = str;
    }
}
