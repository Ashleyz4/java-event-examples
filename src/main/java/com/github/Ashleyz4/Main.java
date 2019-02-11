package com.github.Ashleyz4;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//EXAMPLE A
// Does not detect second class, as I think it should honestly.
// Test.test() is invoked, but it does not continue into it's overridden methods
// I actually can't remember what lang does this, but I thought it was java when I tried this
class Test {
    public void test() {
        System.out.println("Hello World");
    }
}
class TestExtends extends Test {
    @Override
    public void test() {
        System.out.println("Hello World!");
    }
}



//EXAMPLE B
// com.github.Ashleyz4.Listener is given a voice to make the responder work, but in this example
// the responder has to be manually added.
interface HelloListener {
    void someoneSaidHello();
}
class Listener {
    private List<HelloListener> listeners = new ArrayList<HelloListener>();
    public void AddListener(HelloListener listener) {
        this.listeners.add(listener); }
    public void PushListeners() {
        for(HelloListener listener : listeners)
            listener.someoneSaidHello();
    }
}
class Responder implements HelloListener {
    public void someoneSaidHello() {
        System.out.println("com.github.Ashleyz4.Responder says Hello!");
    }
}


// (( to see the explination for this one, check com.github.Ashleyz4.EventHandler ))
public class Main {
    private void main() {
        // get our current package name
        String p = this.getClass().getPackage().getName();

        // show us an example of what our package looks like
        System.out.println(" ");
        System.out.println("Current package: " + p);
        System.out.println(" ");

        // Create reflections in this package in specific
        Reflections reflections = new Reflections(p);
        // Get a list of all the classes in this package and up that use EventHandler
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(EventHandler.class);
        for(Class<?> cl : classes) {
            // Check if the class actually extends EventExtender
            if(cl.getSuperclass().equals(EventExtender.class)) {
                System.out.println("Found " + cl.getName() + " for an event");
                try {
                    // Call method .push(); pretty easily.
                    ((EventExtender) cl.getConstructor().newInstance()).push();
                } catch(Exception e) { e.printStackTrace(); }
            } else {
                System.out.println("nope");
            }
        }
    }








// Here's where we start everything, one at a time.
    public static void main(String[] args) {
        // just create test.
        new Test().test();


        // Create the listener
        Listener listener = new Listener();
        // add the class that listener will be calling
        listener.AddListener((HelloListener) new Responder());
        // in whatever method you want, call this method to push all the classes.
        listener.PushListeners();


        // Create main again cause we can't be static here.
        new Main().main();
    }
}
