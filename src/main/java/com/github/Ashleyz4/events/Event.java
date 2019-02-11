package com.github.Ashleyz4.events;

import com.github.Ashleyz4.EventExtender;
import com.github.Ashleyz4.EventHandler;

@EventHandler
public class Event extends EventExtender {
    public Event() { }
    @Override
    public void push() {
        System.out.println("Hello!");
    }
}
