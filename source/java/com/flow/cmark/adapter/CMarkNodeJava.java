package com.flow.cmark.adapter;

/* loaded from: classes6.dex */
public class CMarkNodeJava {
    public String codeLanguage;
    public String codeLiteral;
    public String content;
    public CMarkNodeJava firstChild;
    public String formulaLiteral;
    public int headingLevel;
    public boolean isDone;
    public boolean isFormulaByRedundantSlash;
    public CMarkNodeJava lastChild;
    public int listItemIndex;
    public int listStartIndex;
    public int listType;
    public String literal;
    public CMarkNodeJava next;
    public CMarkNodeJava parent;
    public CMarkNodeJava prev;
    public char tableAlignment;
    public String title;
    public int type;
    public String typeString;
    public String url;

    public CMarkNodeJava(String str, String str2, int i, String str3) {
        this.content = str;
        this.literal = str2;
        this.type = i;
        this.typeString = str3;
    }

    public void setParent(CMarkNodeJava cMarkNodeJava) {
        this.parent = cMarkNodeJava;
    }

    public void setFirstChild(CMarkNodeJava cMarkNodeJava) {
        this.firstChild = cMarkNodeJava;
    }

    public void setLastChild(CMarkNodeJava cMarkNodeJava) {
        this.lastChild = cMarkNodeJava;
    }

    public void setNext(CMarkNodeJava cMarkNodeJava) {
        this.next = cMarkNodeJava;
    }

    public void setPrev(CMarkNodeJava cMarkNodeJava) {
        this.prev = cMarkNodeJava;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setListType(int i) {
        this.listType = i;
    }

    public void setListItemIndex(int i) {
        this.listItemIndex = i;
    }

    public void setListStartIndex(int i) {
        this.listStartIndex = i;
    }

    public void setHeadingLevel(int i) {
        this.headingLevel = i;
    }

    public void setCodeLiteral(String str) {
        this.codeLiteral = str;
    }

    public void setCodeLanguage(String str) {
        this.codeLanguage = str;
    }

    public void setFormulaLiteral(String str) {
        this.formulaLiteral = str;
    }

    public void setIsFormulaByRedundantSlash(boolean z) {
        this.isFormulaByRedundantSlash = z;
    }

    public void setTableAlignment(char c) {
        this.tableAlignment = c;
    }

    public void setTaskListIsDone(boolean z) {
        this.isDone = z;
    }
}
