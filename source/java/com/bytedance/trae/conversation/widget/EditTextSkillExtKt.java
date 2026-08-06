package com.bytedance.trae.conversation.widget;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: EditTextSkillExt.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0002\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u0004*\u00020\u0002¨\u0006\u000b"}, d2 = {"insertSkillTag", "", "Landroid/widget/EditText;", "skill", "Lcom/bytedance/trae/conversation/widget/SkillItem;", "removeSkillTag", "getUserInputText", "", "hasSkillTag", "", "getSelectedSkill", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class EditTextSkillExtKt {
    public static final void insertSkillTag(EditText editText, SkillItem skillItem) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(skillItem, "skill");
        removeSkillTag(editText);
        String str = " " + skillItem.getName() + (char) 160;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Context context = editText.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        spannableStringBuilder.setSpan(new SkillTagSpan(context, skillItem.getName(), skillItem.getIconRes(), null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 4088, null), 0, str.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append((CharSequence) spannableStringBuilder);
        spannableStringBuilder2.append((CharSequence) " ");
        spannableStringBuilder2.append((CharSequence) getUserInputText(editText));
        editText.setText(spannableStringBuilder2);
        editText.setSelection(str.length() + 1);
        editText.setTag(skillItem);
    }

    public static final void removeSkillTag(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Editable text = editText.getText();
        if (text == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator((SkillTagSpan[]) text.getSpans(0, text.length(), SkillTagSpan.class));
        while (it.hasNext()) {
            SkillTagSpan skillTagSpan = (SkillTagSpan) it.next();
            int spanStart = text.getSpanStart(skillTagSpan);
            int spanEnd = text.getSpanEnd(skillTagSpan);
            text.removeSpan(skillTagSpan);
            text.delete(spanStart, spanEnd);
        }
        editText.setTag(null);
    }

    public static final String getUserInputText(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Editable text = editText.getText();
        if (text == null) {
            return "";
        }
        SkillTagSpan[] skillTagSpanArr = (SkillTagSpan[]) text.getSpans(0, text.length(), SkillTagSpan.class);
        Intrinsics.checkNotNull(skillTagSpanArr);
        return skillTagSpanArr.length == 0 ? StringsKt.trim(text.toString()).toString() : StringsKt.trim(text.subSequence(text.getSpanEnd(skillTagSpanArr[0]), text.length()).toString()).toString();
    }

    public static final boolean hasSkillTag(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        Object[] spans = text.getSpans(0, text.length(), SkillTagSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        return !(spans.length == 0);
    }

    public static final SkillItem getSelectedSkill(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Object tag = editText.getTag();
        if (tag instanceof SkillItem) {
            return (SkillItem) tag;
        }
        return null;
    }
}
