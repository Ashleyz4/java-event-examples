package com.github.Ashleyz4;

//EXAMPLE C
//          (( THIS ONE IS FAR MORE CONFUSING AND IS ONLY FOR ADVANCED USE ))
// In this method we're basically forcing the event down javas throat. The EventHandler is found by
// Reflections and is pushed to work. We're also checking to see if they extend EventExtender, so
// you can use abstract methods, although EventExtender isn't needed at all!

// All your events can go in com.github.Ashleyz4, as long as they look like the event that's already in there.
public @interface EventHandler {}
