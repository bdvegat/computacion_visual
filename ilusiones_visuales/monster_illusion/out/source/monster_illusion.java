import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class monster_illusion extends PApplet {

PImage background;
PImage monster;
public void setup(){
    
}
boolean show_background=true;

public void draw(){
    background = loadImage("arizona-asphalt-beautiful-490466.jpg");
    monster = loadImage("werewolf-1566753_640.png");
    monster.resize(0,200);
    if (show_background){
        image(background, 0, 0);
    }else{
        background(255);
    }
    image(monster,250,50);
    image(monster,250,280);
}


public void mousePressed(){
    if (show_background){
        show_background=false;
    }else{
        show_background=true;
    }
}
  public void settings() {  size (640,480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "monster_illusion" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
