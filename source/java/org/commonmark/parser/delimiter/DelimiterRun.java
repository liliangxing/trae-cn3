package org.commonmark.parser.delimiter;

/* loaded from: classes8.dex */
public interface DelimiterRun {
    boolean canClose();

    boolean canOpen();

    int length();

    int originalLength();
}
