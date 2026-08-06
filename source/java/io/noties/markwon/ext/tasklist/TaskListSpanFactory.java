package io.noties.markwon.ext.tasklist;

import android.graphics.drawable.Drawable;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TaskListSpanFactory implements SpanFactory {
    private final Drawable drawable;

    public TaskListSpanFactory(Drawable drawable) {
        this.drawable = drawable;
    }

    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new TaskListSpan(markwonConfiguration.theme(), this.drawable, ((Boolean) TaskListProps.DONE.get(renderProps, false)).booleanValue());
    }
}
