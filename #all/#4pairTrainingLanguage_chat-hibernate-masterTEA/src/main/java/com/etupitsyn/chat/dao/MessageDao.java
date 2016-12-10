package com.etupitsyn.chat.dao;

import com.etupitsyn.chat.domain.ChatMessage;

import java.util.List;

public interface MessageDao {
    public ChatMessage getMessage(Long messageId);
    public void addMessage(ChatMessage message);
    public List<ChatMessage> getRecentMessages(int limit);
}
