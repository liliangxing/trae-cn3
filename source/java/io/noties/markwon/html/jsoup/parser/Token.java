package io.noties.markwon.html.jsoup.parser;

import io.noties.markwon.html.jsoup.helper.Normalizer;
import io.noties.markwon.html.jsoup.helper.Validate;
import io.noties.markwon.html.jsoup.nodes.Attributes;

/* loaded from: classes6.dex */
public abstract class Token {
    public final TokenType type;

    /* loaded from: classes6.dex */
    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    public abstract Token reset();

    protected Token(TokenType tokenType) {
        this.type = tokenType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reset(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    /* loaded from: classes6.dex */
    public static final class Doctype extends Token {
        boolean forceQuirks;
        final StringBuilder name;
        String pubSysKey;
        final StringBuilder publicIdentifier;
        final StringBuilder systemIdentifier;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Doctype() {
            super(TokenType.Doctype);
            this.name = new StringBuilder();
            this.pubSysKey = null;
            this.publicIdentifier = new StringBuilder();
            this.systemIdentifier = new StringBuilder();
            this.forceQuirks = false;
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token reset() {
            reset(this.name);
            this.pubSysKey = null;
            reset(this.publicIdentifier);
            reset(this.systemIdentifier);
            this.forceQuirks = false;
            return this;
        }

        String getName() {
            return this.name.toString();
        }

        String getPubSysKey() {
            return this.pubSysKey;
        }

        String getPublicIdentifier() {
            return this.publicIdentifier.toString();
        }

        public String getSystemIdentifier() {
            return this.systemIdentifier.toString();
        }

        public boolean isForceQuirks() {
            return this.forceQuirks;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class Tag extends Token {
        public Attributes attributes;
        private boolean hasEmptyAttributeValue;
        private boolean hasPendingAttributeValue;
        public String normalName;
        private String pendingAttributeName;
        private StringBuilder pendingAttributeValue;
        private String pendingAttributeValueS;
        public boolean selfClosing;
        public String tagName;

        protected Tag(TokenType tokenType) {
            super(tokenType);
            this.pendingAttributeValue = new StringBuilder();
            this.hasEmptyAttributeValue = false;
            this.hasPendingAttributeValue = false;
            this.selfClosing = false;
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Tag reset() {
            this.tagName = null;
            this.normalName = null;
            this.pendingAttributeName = null;
            reset(this.pendingAttributeValue);
            this.pendingAttributeValueS = null;
            this.hasEmptyAttributeValue = false;
            this.hasPendingAttributeValue = false;
            this.selfClosing = false;
            this.attributes = null;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void newAttribute() {
            String str;
            if (this.attributes == null) {
                this.attributes = new Attributes();
            }
            String str2 = this.pendingAttributeName;
            if (str2 != null) {
                String trim = str2.trim();
                this.pendingAttributeName = trim;
                if (trim.length() > 0) {
                    if (this.hasPendingAttributeValue) {
                        str = this.pendingAttributeValue.length() > 0 ? this.pendingAttributeValue.toString() : this.pendingAttributeValueS;
                    } else {
                        str = this.hasEmptyAttributeValue ? "" : null;
                    }
                    this.attributes.put(this.pendingAttributeName, str);
                }
            }
            this.pendingAttributeName = null;
            this.hasEmptyAttributeValue = false;
            this.hasPendingAttributeValue = false;
            reset(this.pendingAttributeValue);
            this.pendingAttributeValueS = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void finaliseTag() {
            if (this.pendingAttributeName != null) {
                newAttribute();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final String name() {
            String str = this.tagName;
            Validate.isFalse(str == null || str.length() == 0);
            return this.tagName;
        }

        final String normalName() {
            return this.normalName;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final Tag name(String str) {
            this.tagName = str;
            this.normalName = Normalizer.lowerCase(str);
            return this;
        }

        final boolean isSelfClosing() {
            return this.selfClosing;
        }

        final Attributes getAttributes() {
            return this.attributes;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendTagName(String str) {
            String str2 = this.tagName;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.tagName = str;
            this.normalName = Normalizer.lowerCase(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendTagName(char c) {
            appendTagName(String.valueOf(c));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeName(String str) {
            String str2 = this.pendingAttributeName;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.pendingAttributeName = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeName(char c) {
            appendAttributeName(String.valueOf(c));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeValue(String str) {
            ensureAttributeValue();
            if (this.pendingAttributeValue.length() == 0) {
                this.pendingAttributeValueS = str;
            } else {
                this.pendingAttributeValue.append(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeValue(char c) {
            ensureAttributeValue();
            this.pendingAttributeValue.append(c);
        }

        final void appendAttributeValue(char[] cArr) {
            ensureAttributeValue();
            this.pendingAttributeValue.append(cArr);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeValue(int[] iArr) {
            ensureAttributeValue();
            for (int i : iArr) {
                this.pendingAttributeValue.appendCodePoint(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void setEmptyAttributeValue() {
            this.hasEmptyAttributeValue = true;
        }

        private void ensureAttributeValue() {
            this.hasPendingAttributeValue = true;
            String str = this.pendingAttributeValueS;
            if (str != null) {
                this.pendingAttributeValue.append(str);
                this.pendingAttributeValueS = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class StartTag extends Tag {
        public StartTag() {
            super(TokenType.StartTag);
            this.attributes = new Attributes();
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token.Tag, io.noties.markwon.html.jsoup.parser.Token
        public Tag reset() {
            super.reset();
            this.attributes = new Attributes();
            return this;
        }

        StartTag nameAttr(String str, Attributes attributes) {
            this.tagName = str;
            this.attributes = attributes;
            this.normalName = Normalizer.lowerCase(this.tagName);
            return this;
        }

        public String toString() {
            if (this.attributes != null && this.attributes.size() > 0) {
                return "<" + name() + " " + this.attributes.toString() + ">";
            }
            return "<" + name() + ">";
        }
    }

    /* loaded from: classes6.dex */
    public static final class EndTag extends Tag {
        /* JADX INFO: Access modifiers changed from: package-private */
        public EndTag() {
            super(TokenType.EndTag);
        }

        public String toString() {
            return "</" + name() + ">";
        }
    }

    /* loaded from: classes6.dex */
    public static final class Comment extends Token {
        boolean bogus;
        final StringBuilder data;

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token reset() {
            reset(this.data);
            this.bogus = false;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Comment() {
            super(TokenType.Comment);
            this.data = new StringBuilder();
            this.bogus = false;
        }

        String getData() {
            return this.data.toString();
        }

        public String toString() {
            return "<!--" + getData() + "-->";
        }
    }

    /* loaded from: classes6.dex */
    public static class Character extends Token {
        private String data;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Character() {
            super(TokenType.Character);
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token reset() {
            this.data = null;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Character data(String str) {
            this.data = str;
            return this;
        }

        public String getData() {
            return this.data;
        }

        public String toString() {
            return getData();
        }
    }

    /* loaded from: classes6.dex */
    public static final class CData extends Character {
        /* JADX INFO: Access modifiers changed from: package-private */
        public CData(String str) {
            data(str);
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token.Character
        public String toString() {
            return "<![CDATA[" + getData() + "]]>";
        }
    }

    /* loaded from: classes6.dex */
    public static final class EOF extends Token {
        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token reset() {
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public EOF() {
            super(TokenType.EOF);
        }
    }
}
