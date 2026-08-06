package io.noties.markwon.ext.tables;

import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import io.noties.markwon.ext.tables.AbsTableRowSpan;

/* loaded from: classes7.dex */
abstract class TableRowsScheduler {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void schedule(final TextView textView) {
        AbsTableRowSpan[] extract = extract(textView);
        if (extract == null || extract.length <= 0) {
            return;
        }
        if (textView.getTag(R.id.markwon_tables_scheduler) == null) {
            View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: io.noties.markwon.ext.tables.TableRowsScheduler.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    TableRowsScheduler.unschedule(textView);
                    textView.removeOnAttachStateChangeListener(this);
                    textView.setTag(R.id.markwon_tables_scheduler, null);
                }
            };
            textView.addOnAttachStateChangeListener(onAttachStateChangeListener);
            textView.setTag(R.id.markwon_tables_scheduler, onAttachStateChangeListener);
        }
        AbsTableRowSpan.Invalidator invalidator = new AbsTableRowSpan.Invalidator() { // from class: io.noties.markwon.ext.tables.TableRowsScheduler.2
            final Runnable runnable = new Runnable() { // from class: io.noties.markwon.ext.tables.TableRowsScheduler.2.1
                @Override // java.lang.Runnable
                public void run() {
                    textView.setText(textView.getText());
                }
            };

            @Override // io.noties.markwon.ext.tables.AbsTableRowSpan.Invalidator
            public void invalidate() {
                textView.removeCallbacks(this.runnable);
                textView.post(this.runnable);
            }
        };
        for (AbsTableRowSpan absTableRowSpan : extract) {
            absTableRowSpan.invalidator(invalidator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unschedule(TextView textView) {
        AbsTableRowSpan[] extract = extract(textView);
        if (extract == null || extract.length <= 0) {
            return;
        }
        for (AbsTableRowSpan absTableRowSpan : extract) {
            absTableRowSpan.invalidator(null);
        }
    }

    public static AbsTableRowSpan[] extract(TextView textView) {
        CharSequence text = textView.getText();
        if (TextUtils.isEmpty(text) || !(text instanceof Spanned)) {
            return null;
        }
        return (AbsTableRowSpan[]) ((Spanned) text).getSpans(0, text.length(), AbsTableRowSpan.class);
    }

    private TableRowsScheduler() {
    }
}
