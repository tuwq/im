package root.model;

import java.util.Date;

public class GroupChatMsg {
    private String id;

    private String sendUserId;

    private String acceptGroupId;

    private String msg;

    private Integer signFlag;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId == null ? null : sendUserId.trim();
    }

    public String getAcceptGroupId() {
        return acceptGroupId;
    }

    public void setAcceptGroupId(String acceptGroupId) {
        this.acceptGroupId = acceptGroupId == null ? null : acceptGroupId.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
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