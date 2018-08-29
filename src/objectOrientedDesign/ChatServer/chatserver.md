# The problem:
Explain how you would design a chat server. In particular, provide details about the various backend components, classes and methods. What would be the hardest problems to solve? 

## Object Oriented Design Questions:
1. Handle Ambiguity.
I'm going to go under the assumption that users just set their usernames - or they have the option to. That Authentication is not a part of this solution. If that is the case, then a user simply has display name. 

So the idea is that you have a centralized chathub. All users that connect to the chat server register a connection to the chathub. The front-end interface sends messages to the chat hub, in the form of a username and message. 

The chathub will then send / notify all clients registered to the chathub that there is a new message. 

You can use a technology like SignalR to implement this in C# or Sockets in Java. 

2. Define core objects.
```ChatHub``` 

## Pseudocode implementation

```java
// this particular example would use something like SignalR (in C#). 
public class ChatHub extends Hub {
  public void send(String name, String message) {
    Clients.All.broadcastMessage(name, message);
  }
}
```

The front end would then take this message and render it in a UI.



