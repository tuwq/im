package root.model;

import java.util.Date;

public class GroupRequest {
    private String id;

    private String sendGroupId;

    private String acceptUserId;

    private Integer acceptStatus;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSendGroupId() {
        return sendGroupId;
    }

    public void setSendGroupId(String sendGroupId) {
        this.sendGroupId = sendGroupId == null ? null : sendGroupId.trim();
    }

    public String getAcceptUserId() {
        return acceptUserId;
    }

    public void setAcceptUserId(String acceptUserId) {
        this.acceptUserId = acceptUserId == null ? null : acceptUserId.trim();
    }

    public Integer getAcceptStatus() {
        return acceptStatus;
    }

    public void setAcceptStatus(Integer acceptStatus) {
        this.acceptStatus = acceptStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}