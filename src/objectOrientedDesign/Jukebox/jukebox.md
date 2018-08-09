# Design a Jukebox using object oriented principles

## What is a Jukebox? 
A Jukebox is a device, when you give it a coin, you can select a song from a music library. 

## How do you select a song?
Usually it's a combination - every song in the jukebox corresponds to a letter plus a number combination.
How many songs would that allow you to store in a JukeBox? 10 numbers for each letter, and you have 26 letters.
26 * 10 = 260 songs in a jukebox. Assuming these parameters we can design a Jukebox using a map.
String combination being the key and the song track being the value. 


```java 
public class JukeBox {
  public HashMap<String, SongTrack> jukebox;

  public JukeBox() {
    this.jukebox = new JukeBox();
    initJukeBox();
  }

  private void initJukebox() {
    // ... initializes the jukebox with song data
  }

  public void Play(String input) {
    SongTrack track = jukebox.get(input);
    if (track != null) {
      track.playTrack();
    }
  }
}

public class SongTrack {
  public TrackData audioStream; 

  public void playTrack() {
    // ... play the track
  }
}
```