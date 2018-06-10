package com.seclass.ccc.models;

import java.util.Date;

import lombok.Data;

/**
 */
@Data
public class Chat {

    private String chatId;
    private String title;
    private Date createDate;
    private TextMessage lastMessage;
    private boolean disabled;
    private int totalUnreadCount;
}
