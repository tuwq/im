package root.model;

import java.util.Date;

public class GroupAcceptChatContent {
    private String id;

    private String groupSendContentId;

    private String acceptUserId;

    private String acceptGroupId;

    private String content;

    private Integer signFlag;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGroupSendContentId() {
        return groupSendContentId;
    }

    public void setGroupSendContentId(String groupSendContentId) {
        this.groupSendContentId = groupSendContentId == null ? null : groupSendContentId.trim();
    }

    public String getAcceptUserId() {
        return acceptUserId;
    }

    public void setAcceptUserId(String acceptUserId) {
        this.acceptUserId = acceptUserId == null ? null : acceptUserId.trim();
    }

    public String getAcceptGroupId() {
        return acceptGroupId;
    }

    public void setAcceptGroupId(String acceptGroupId) {
        this.acceptGroupId = acceptGroupId == null ? null : acceptGroupId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getSignFlag() {
        return signFlag;
    }

    public void setSignFlag(Integer signFlag) {
        this.signFlag = signFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}