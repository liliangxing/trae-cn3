package io.noties.markwon.ext.tasklist;

import android.text.TextUtils;
import io.noties.markwon.utils.ParserUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.commonmark.node.Text;
import org.commonmark.parser.PostProcessor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class TaskListPostProcessor implements PostProcessor {
    public Node process(Node node) {
        node.accept(new TaskListVisitor());
        return node;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class TaskListVisitor extends AbstractVisitor {
        private static final Pattern REGEX_TASK_LIST_ITEM = Pattern.compile("^\\[([xX\\s])]\\s+(.*)");

        private TaskListVisitor() {
        }

        public void visit(ListItem listItem) {
            Node firstChild = listItem.getFirstChild();
            if (firstChild instanceof Paragraph) {
                Text firstChild2 = firstChild.getFirstChild();
                if (firstChild2 instanceof Text) {
                    Matcher matcher = REGEX_TASK_LIST_ITEM.matcher(firstChild2.getLiteral());
                    if (matcher.matches()) {
                        boolean z = true;
                        String group = matcher.group(1);
                        if (!"x".equals(group) && !"X".equals(group)) {
                            z = false;
                        }
                        TaskListItem taskListItem = new TaskListItem(z);
                        Paragraph paragraph = new Paragraph();
                        listItem.insertBefore(taskListItem);
                        String group2 = matcher.group(2);
                        if (!TextUtils.isEmpty(group2)) {
                            paragraph.appendChild(new Text(group2));
                        }
                        ParserUtils.moveChildren(paragraph, firstChild2);
                        taskListItem.appendChild(paragraph);
                        ParserUtils.moveChildren(taskListItem, firstChild);
                        listItem.unlink();
                        visitChildren(taskListItem);
                        return;
                    }
                }
            }
            visitChildren(listItem);
        }
    }
}
