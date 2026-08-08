package com.bytedance.trae.test;

import com.bytedance.trae.conversation.extract.ApiMessageFetcher;

public class ApiMessageFetcherTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) throws Exception {
        testMultiPageAllMessages();
        testExactFullPages();
        testFewerThanPageSize();
        testFirstPageFailure();
        System.out.println("==== RESULT: passed=" + passed + ", failed=" + failed + " ====");
        if (failed > 0) {
            System.exit(1);
        }
    }

    private static void testMultiPageAllMessages() throws Exception {
        System.out.println("---- testMultiPageAllMessages ----");
        MockApiServer server = new MockApiServer(8443, 23, false);
        try {
            String markdown = ApiMessageFetcher.fetch("conv-test", "title", "tok", server.getBaseUrl());
            int count = ApiMessageFetcher.getLastUserMessageCount();

            check("request count == 3", server.getAnchorRequests().size() == 3, server.getAnchorRequests().toString());
            check("anchors sequence", server.getAnchorRequests().equals(java.util.Arrays.asList("", "14000", "4000")), server.getAnchorRequests().toString());
            check("user count == 16", count == 16, "count=" + count);
            check("markdown not null", markdown != null, "");
            if (markdown != null) {
                check("has first msg", markdown.contains("user-message-1"), "");
                check("has last msg", markdown.contains("user-message-23"), "");
                check("assistant filtered", !markdown.contains("user-message-21") && !markdown.contains("user-message-3"), "");
                check("ordered asc", isAscending(markdown, "user-message-1", "user-message-2", "user-message-4",
                        "user-message-5", "user-message-7", "user-message-8", "user-message-10", "user-message-11",
                        "user-message-13", "user-message-14", "user-message-16", "user-message-17", "user-message-19",
                        "user-message-20", "user-message-22", "user-message-23"), "");
            }
        } finally {
            server.close();
        }
    }

    private static void testExactFullPages() throws Exception {
        System.out.println("---- testExactFullPages ----");
        MockApiServer server = new MockApiServer(8444, 20, false);
        try {
            String markdown = ApiMessageFetcher.fetch("conv-test", "title", "tok", server.getBaseUrl());
            int count = ApiMessageFetcher.getLastUserMessageCount();

            check("request count == 3 (last empty page)", server.getAnchorRequests().size() == 3, server.getAnchorRequests().toString());
            check("anchors sequence", server.getAnchorRequests().equals(java.util.Arrays.asList("", "11000", "1000")), server.getAnchorRequests().toString());
            check("user count == 14", count == 14, "count=" + count);
            if (markdown != null) {
                check("full content", markdown.contains("user-message-20") && markdown.contains("user-message-1"), "");
            }
        } finally {
            server.close();
        }
    }

    private static void testFewerThanPageSize() throws Exception {
        System.out.println("---- testFewerThanPageSize ----");
        MockApiServer server = new MockApiServer(8445, 5, false);
        try {
            String markdown = ApiMessageFetcher.fetch("conv-test", "title", "tok", server.getBaseUrl());
            int count = ApiMessageFetcher.getLastUserMessageCount();

            check("request count == 1", server.getAnchorRequests().size() == 1, server.getAnchorRequests().toString());
            check("user count == 4", count == 4, "count=" + count);
            if (markdown != null) {
                check("ordered", isAscending(markdown, "user-message-1", "user-message-2", "user-message-4", "user-message-5"), "");
            }
        } finally {
            server.close();
        }
    }

    private static void testFirstPageFailure() throws Exception {
        System.out.println("---- testFirstPageFailure ----");
        MockApiServer server = new MockApiServer(8446, 23, true);
        try {
            String markdown = ApiMessageFetcher.fetch("conv-test", "title", "tok", server.getBaseUrl());
            check("markdown is null on first page failure", markdown == null, "markdown=" + markdown);
        } finally {
            server.close();
        }
    }

    private static boolean isAscending(String haystack, String... needles) {
        int prev = -1;
        for (String n : needles) {
            int idx = haystack.indexOf(n);
            if (idx < 0 || idx < prev) {
                return false;
            }
            prev = idx;
        }
        return true;
    }

    private static void check(String name, boolean ok, String detail) {
        if (ok) {
            passed++;
            System.out.println("  PASS: " + name);
        } else {
            failed++;
            System.out.println("  FAIL: " + name + (detail.isEmpty() ? "" : "  detail=" + detail));
        }
    }
}
