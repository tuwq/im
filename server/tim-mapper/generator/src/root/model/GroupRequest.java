package root.model;

import java.util.Date;

public class GroupRequest {
    private Integer id;

    private Integer sendGroupId;

    private Integer acceptUserId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSendGroupId() {
        return sendGroupId;
    }

    public void setSendGroupId(Integer sendGroupId) {
        this.sendGroupId = sendGroupId;
    }

    public Integer getAcceptUserId() {
        return acceptUserId;
    }

    public void setAcceptUserId(Integer acceptUserId) {
        this.acceptUserId = acceptUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}