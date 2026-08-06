package com.flow.cmark.adapter;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: CMarkParserNativeLib.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0086 J\t\u0010\u0005\u001a\u00020\u0004H\u0086 J3\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\rH\u0086 J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0086 J\u0011\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0086 J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\bH\u0086 J\t\u0010\u0016\u001a\u00020\u000bH\u0086 ¨\u0006\u0018"}, d2 = {"Lcom/flow/cmark/adapter/CMarkParserNativeLib;", "", "()V", "cmarkGfmCoreExtensionsEnsureRegistered", "", "freeCMarkParser", "initCMarkParser", "parserOptions", "", "extensionList", "", "", "config", "", "isBlockNodeType", "", "nodeType", "isInlineNodeType", "parseMarkdown", "Lcom/flow/cmark/adapter/CMarkNodeJava;", "content", "featureOptions", "stringFromJNI", "Companion", "cmarkparser_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class CMarkParserNativeLib {
    public final native void cmarkGfmCoreExtensionsEnsureRegistered();

    public final native void freeCMarkParser();

    public final native void initCMarkParser(int parserOptions, List<String> extensionList, Map<String, ? extends Object> config);

    public final native boolean isBlockNodeType(int nodeType);

    public final native boolean isInlineNodeType(int nodeType);

    public final native CMarkNodeJava parseMarkdown(String content, int featureOptions);

    public final native String stringFromJNI();

    static {
        System.loadLibrary("jfmnativelib");
    }
}
