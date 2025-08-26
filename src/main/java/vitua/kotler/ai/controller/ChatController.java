package vitua.kotler.ai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vitua.kotler.ai.dto.ChatDto;
import vitua.kotler.ai.dto.MessageDto;
import vitua.kotler.ai.service.ChatService;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ChatDto createChat(@RequestBody ChatDto chat) {
        return chatService.createChat(chat);
    }

    @GetMapping("/user/{userId}")
    public List<ChatDto> getUserChats(@PathVariable Long userId) {
        return chatService.getAllChatsByUser(userId);
    }

    @PostMapping("/{chatId}/messages")
    public MessageDto sendMessage(@PathVariable Long chatId, @RequestBody MessageDto messageDto) {
        messageDto.setChatId(chatId);
        return chatService.sendMessage(messageDto);
    }

    @GetMapping("/{chatId}/messages")
    public List<MessageDto> getChatMessages(@PathVariable Long chatId) {
        return chatService.getMessagesByChat(chatId);
    }
}