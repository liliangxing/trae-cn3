package org.commonmark.parser.block;

/* loaded from: classes8.dex */
public interface ParserState {
    BlockParser getActiveBlockParser();

    int getColumn();

    int getIndent();

    int getIndex();

    CharSequence getLine();

    int getNextNonSpaceIndex();

    boolean isBlank();
}
