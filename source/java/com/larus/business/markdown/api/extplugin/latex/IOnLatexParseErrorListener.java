package com.larus.business.markdown.api.extplugin.latex;

import kotlin.Metadata;

/* compiled from: ILatexPlugin.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/api/extplugin/latex/IOnLatexParseErrorListener;", "", "onParseError", "", "parseContent", "", "errorMsg", "errorCode", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface IOnLatexParseErrorListener {
    void onParseError(String parseContent, String errorMsg, int errorCode);
}
