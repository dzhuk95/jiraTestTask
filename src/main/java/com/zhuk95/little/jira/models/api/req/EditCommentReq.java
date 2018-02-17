package com.zhuk95.little.jira.models.api.req;

public class EditCommentReq extends CreateCommentReq {
    private int commentId;

    public EditCommentReq() {
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
}
