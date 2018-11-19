package root.model;

import java.util.Date;

public class SingleUsers {
    private String id;

    private String myId;

    private String myFriendId;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMyId() {
        return myId;
    }

    public void setMyId(String myId) {
        this.myId = myId == null ? null : myId.trim();
    }

    public String getMyFriendId() {
        return myFriendId;
    }

    public void setMyFriendId(String myFriendId) {
        this.myFriendId = myFriendId == null ? null : myFriendId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}