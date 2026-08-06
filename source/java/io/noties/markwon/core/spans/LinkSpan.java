package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import io.noties.markwon.LinkResolver;
import io.noties.markwon.core.MarkwonTheme;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes6.dex */
public class LinkSpan extends URLSpan {
    private final Map<String, String> extra;
    private final String link;
    protected final LinkResolver resolver;
    private final MarkwonTheme theme;

    public LinkSpan(MarkwonTheme markwonTheme, String str, LinkResolver linkResolver) {
        this(markwonTheme, str, null, linkResolver);
    }

    public LinkSpan(MarkwonTheme markwonTheme, String str, Map<String, String> map, LinkResolver linkResolver) {
        super(str);
        this.theme = markwonTheme;
        this.link = str;
        this.extra = map == null ? Collections.emptyMap() : map;
        this.resolver = linkResolver;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        this.resolver.resolve(view, this.link);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        this.theme.applyLinkStyle(textPaint);
    }

    public String getLink() {
        return this.link;
    }
}
