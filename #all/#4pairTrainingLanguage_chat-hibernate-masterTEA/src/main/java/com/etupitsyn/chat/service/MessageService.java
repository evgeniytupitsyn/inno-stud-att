package com.etupitsyn.chat.service;

import com.etupitsyn.chat.domain.ChatMessage;

import java.util.List;

public interface MessageService {
    public ChatMessage getMessage(Long messageId);
    public List<ChatMessage> getRecentMessages(int limit);
    public void addMessage(ChatMessage message);
    public StringBuilder fetchChatHistory(int limit);
}
