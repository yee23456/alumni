package com.BWtest.lab.BW.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.BWtest.lab.BW.entity.Booking;
import com.BWtest.lab.BW.service.BookingService;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

import lombok.extern.slf4j.Slf4j;

@LineMessageHandler
@Slf4j
public class Handler {
	@Autowired
	private BookingService service;
	/*
	 回復的訊息都在這裡寫 
	 */
	String specifiedString = "1";
	@EventMapping
	public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
//	    if (event.getMessage().getText().equals(specifiedString)) {
//	        List<Booking> bookings = service.GetTodayAllBooking();
//	        List<TextMessage> messages = new ArrayList<>();
//	        for (Booking booking : bookings) {
//	            String messageText = "Name: " + booking.getName() +", Phone: " + booking.getPhone()+ ", CheckIn: " + booking.getCheckIn();
//	            messages.add(new TextMessage(messageText));
//	        }
//	        return messages;
//	    } else {
//	    	return Collections.singletonList(new TextMessage("無法讀取"));
//	    }
	    return new TextMessage(event.getMessage().getText());
	}

	@EventMapping
	public void handleDefaultMessageEvent(Event event) {
		// 就是加入聊天室, 離開聊天室, 還有一些有的沒的事件
		log.info("event: " + event);
	}
}
