package root.model;

import java.util.Date;

public class MyFriends {
    private Integer id;

    private Integer myId;

    private Integer myFriendId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMyId() {
        return myId;
    }

    public void setMyId(Integer myId) {
        this.myId = myId;
    }

    public Integer getMyFriendId() {
        return myFriendId;
    }

    public void setMyFriendId(Integer myFriendId) {
        this.myFriendId = myFriendId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}