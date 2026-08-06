package io.noties.markwon.ext.tasklist;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.MarkwonVisitor;
import org.commonmark.parser.Parser;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TaskListPlugin extends AbstractMarkwonPlugin {
    private final Drawable drawable;

    public static TaskListPlugin create(Drawable drawable) {
        return new TaskListPlugin(drawable);
    }

    public static TaskListPlugin create(Context context) {
        int resolve = resolve(context, android.R.attr.textColorLink);
        return new TaskListPlugin(new TaskListDrawable(resolve, resolve, resolve(context, android.R.attr.colorBackground)));
    }

    public static TaskListPlugin create(int i, int i2, int i3) {
        return new TaskListPlugin(new TaskListDrawable(i, i2, i3));
    }

    private TaskListPlugin(Drawable drawable) {
        this.drawable = drawable;
    }

    public void configureParser(Parser.Builder builder) {
        builder.postProcessor(new TaskListPostProcessor());
    }

    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
        builder.setFactory(TaskListItem.class, new TaskListSpanFactory(this.drawable));
    }

    public void configureVisitor(MarkwonVisitor.Builder builder) {
        builder.on(TaskListItem.class, new MarkwonVisitor.NodeVisitor<TaskListItem>() { // from class: io.noties.markwon.ext.tasklist.TaskListPlugin.1
            public void visit(MarkwonVisitor markwonVisitor, TaskListItem taskListItem) {
                int length = markwonVisitor.length();
                markwonVisitor.visitChildren(taskListItem);
                TaskListProps.DONE.set(markwonVisitor.renderProps(), Boolean.valueOf(taskListItem.isDone()));
                markwonVisitor.setSpansForNode(taskListItem, length);
                if (markwonVisitor.hasNext(taskListItem)) {
                    markwonVisitor.ensureNewLine();
                }
            }
        });
    }

    private static int resolve(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{i});
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
