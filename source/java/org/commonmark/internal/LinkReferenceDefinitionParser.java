package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.parser.Parser;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class LinkReferenceDefinitionParser {
    private final List<LinkReferenceDefinition> definitions;
    private String destination;
    private StringBuilder label;
    private final Parser.LinkReferenceChecker linkReferenceChecker;
    private String normalizedLabel;
    private final StringBuilder paragraph;
    private boolean referenceValid;
    private State state;
    private StringBuilder title;
    private char titleDelimiter;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public enum State {
        START_DEFINITION,
        LABEL,
        DESTINATION,
        START_TITLE,
        TITLE,
        PARAGRAPH
    }

    public LinkReferenceDefinitionParser() {
        this(null);
    }

    public LinkReferenceDefinitionParser(Parser.LinkReferenceChecker linkReferenceChecker) {
        this.state = State.START_DEFINITION;
        this.paragraph = new StringBuilder();
        this.definitions = new ArrayList();
        this.referenceValid = false;
        this.linkReferenceChecker = linkReferenceChecker;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[LOOP:0: B:5:0x0015->B:20:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parse(CharSequence charSequence) {
        if (this.paragraph.length() != 0) {
            this.paragraph.append('\n');
        }
        this.paragraph.append(charSequence);
        int i = 0;
        while (i < charSequence.length()) {
            switch (C06861.f1467x496a1d35[this.state.ordinal()]) {
                case 1:
                    return;
                case 2:
                    i = startDefinition(charSequence, i);
                    if (i != -1) {
                        this.state = State.PARAGRAPH;
                        return;
                    }
                case 3:
                    i = label(charSequence, i);
                    if (i != -1) {
                    }
                    break;
                case 4:
                    i = destination(charSequence, i);
                    if (i != -1) {
                    }
                    break;
                case 5:
                    i = startTitle(charSequence, i);
                    if (i != -1) {
                    }
                    break;
                case 6:
                    i = title(charSequence, i);
                    if (i != -1) {
                    }
                    break;
                default:
                    if (i != -1) {
                    }
                    break;
            }
        }
    }

    /* renamed from: org.commonmark.internal.LinkReferenceDefinitionParser$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static /* synthetic */ class C06861 {

        /* renamed from: $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State */
        static final /* synthetic */ int[] f1467x496a1d35;

        static {
            int[] iArr = new int[State.values().length];
            f1467x496a1d35 = iArr;
            try {
                iArr[State.PARAGRAPH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1467x496a1d35[State.START_DEFINITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1467x496a1d35[State.LABEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1467x496a1d35[State.DESTINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1467x496a1d35[State.START_TITLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1467x496a1d35[State.TITLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence getParagraphContent() {
        return this.paragraph;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<LinkReferenceDefinition> getDefinitions() {
        finishReference();
        return this.definitions;
    }

    State getState() {
        return this.state;
    }

    private int startDefinition(CharSequence charSequence, int i) {
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, i, charSequence.length());
        if (skipSpaceTab >= charSequence.length() || charSequence.charAt(skipSpaceTab) != '[') {
            return -1;
        }
        this.state = State.LABEL;
        this.label = new StringBuilder();
        int i2 = skipSpaceTab + 1;
        if (i2 >= charSequence.length()) {
            this.label.append('\n');
        }
        return i2;
    }

    private int label(CharSequence charSequence, int i) {
        int i2;
        int scanLinkLabelContent = LinkScanner.scanLinkLabelContent(charSequence, i);
        if (scanLinkLabelContent == -1) {
            return -1;
        }
        this.label.append(charSequence, i, scanLinkLabelContent);
        Parser.LinkReferenceChecker linkReferenceChecker = this.linkReferenceChecker;
        if (linkReferenceChecker != null && !linkReferenceChecker.enable(this.label)) {
            return -1;
        }
        if (scanLinkLabelContent >= charSequence.length()) {
            this.label.append('\n');
            return scanLinkLabelContent;
        }
        if (charSequence.charAt(scanLinkLabelContent) != ']' || (i2 = scanLinkLabelContent + 1) >= charSequence.length() || charSequence.charAt(i2) != ':' || this.label.length() > 999) {
            return -1;
        }
        String normalizeLabelContent = Escaping.normalizeLabelContent(this.label.toString());
        if (normalizeLabelContent.isEmpty()) {
            return -1;
        }
        this.normalizedLabel = normalizeLabelContent;
        this.state = State.DESTINATION;
        return Parsing.skipSpaceTab(charSequence, i2 + 1, charSequence.length());
    }

    private int destination(CharSequence charSequence, int i) {
        String obj;
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, i, charSequence.length());
        int scanLinkDestination = LinkScanner.scanLinkDestination(charSequence, skipSpaceTab);
        if (scanLinkDestination == -1) {
            return -1;
        }
        if (charSequence.charAt(skipSpaceTab) == '<') {
            obj = charSequence.subSequence(skipSpaceTab + 1, scanLinkDestination - 1).toString();
        } else {
            obj = charSequence.subSequence(skipSpaceTab, scanLinkDestination).toString();
        }
        this.destination = obj;
        int skipSpaceTab2 = Parsing.skipSpaceTab(charSequence, scanLinkDestination, charSequence.length());
        if (skipSpaceTab2 >= charSequence.length()) {
            this.referenceValid = true;
            this.paragraph.setLength(0);
        } else if (skipSpaceTab2 == scanLinkDestination) {
            return -1;
        }
        this.state = State.START_TITLE;
        return skipSpaceTab2;
    }

    private int startTitle(CharSequence charSequence, int i) {
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, i, charSequence.length());
        if (skipSpaceTab >= charSequence.length()) {
            this.state = State.START_DEFINITION;
            return skipSpaceTab;
        }
        this.titleDelimiter = (char) 0;
        char charAt = charSequence.charAt(skipSpaceTab);
        if (charAt == '\"' || charAt == '\'') {
            this.titleDelimiter = charAt;
        } else if (charAt == '(') {
            this.titleDelimiter = ')';
        }
        if (this.titleDelimiter != 0) {
            this.state = State.TITLE;
            this.title = new StringBuilder();
            skipSpaceTab++;
            if (skipSpaceTab == charSequence.length()) {
                this.title.append('\n');
            }
        } else {
            finishReference();
            this.state = State.START_DEFINITION;
        }
        return skipSpaceTab;
    }

    private int title(CharSequence charSequence, int i) {
        int scanLinkTitleContent = LinkScanner.scanLinkTitleContent(charSequence, i, this.titleDelimiter);
        if (scanLinkTitleContent == -1) {
            return -1;
        }
        this.title.append(charSequence.subSequence(i, scanLinkTitleContent));
        if (scanLinkTitleContent >= charSequence.length()) {
            this.title.append('\n');
            return scanLinkTitleContent;
        }
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, scanLinkTitleContent + 1, charSequence.length());
        if (skipSpaceTab != charSequence.length()) {
            return -1;
        }
        this.referenceValid = true;
        finishReference();
        this.paragraph.setLength(0);
        this.state = State.START_DEFINITION;
        return skipSpaceTab;
    }

    private void finishReference() {
        if (this.referenceValid) {
            String unescapeString = Escaping.unescapeString(this.destination);
            StringBuilder sb = this.title;
            this.definitions.add(new LinkReferenceDefinition(this.normalizedLabel, unescapeString, sb != null ? Escaping.unescapeString(sb.toString()) : null));
            this.label = null;
            this.referenceValid = false;
            this.normalizedLabel = null;
            this.destination = null;
            this.title = null;
        }
    }
}
