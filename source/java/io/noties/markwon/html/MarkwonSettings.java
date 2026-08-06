package io.noties.markwon.html;

import kotlin.Metadata;

/* compiled from: MarkwonSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/noties/markwon/html/MarkwonSettings;", "", "()V", "enableHtmlNameEntityOptimize", "", "getEnableHtmlNameEntityOptimize", "()Z", "setEnableHtmlNameEntityOptimize", "(Z)V", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class MarkwonSettings {
    public static final MarkwonSettings INSTANCE = new MarkwonSettings();
    private static boolean enableHtmlNameEntityOptimize;

    private MarkwonSettings() {
    }

    public final boolean getEnableHtmlNameEntityOptimize() {
        return enableHtmlNameEntityOptimize;
    }

    public final void setEnableHtmlNameEntityOptimize(boolean z) {
        enableHtmlNameEntityOptimize = z;
    }
}
