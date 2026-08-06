package io.noties.markwon.ext.tasklist;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.commonmark.node.CustomBlock;

/* loaded from: classes7.dex */
public class TaskListItem extends CustomBlock {
    private final boolean isDone;

    public TaskListItem(boolean z) {
        this.isDone = z;
    }

    public boolean isDone() {
        return this.isDone;
    }

    @Override // org.commonmark.node.Node
    public String toString() {
        return "TaskListItem{isDone=" + this.isDone + AbstractJsonLexerKt.END_OBJ;
    }
}
