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

public class circle_ilusion extends PApplet {

smallCircle c1 = new smallCircle(320,50,0,1,320,50);
smallCircle c2 = new smallCircle(180,240,1,0,120,240);
// smallCircle c3 = new smallCircle(0,0,0,0);
// smallCircle c4 = new smallCircle(0,0,0,0);
// smallCircle c5 = new smallCircle(0,0,0,0);
// smallCircle c6 = new smallCircle(0,0,0,0);
// smallCircle c7 = new smallCircle(0,0,0,0);
// smallCircle c8 = new smallCircle(0,0,0,0);

public void setup(){
    
}
boolean show_background=true;

public void draw(){
    background(51);
    fill(102);
    stroke(255);
    redCircle();
    c1.update();
    c2.update();
    println("c1.ypos: "+c1.ypos);
}

public void mousePressed(){
    if (show_background){
        show_background=false;
    }else{
        show_background=true;
    }
}

public void redCircle(){
    pushStyle();
    stroke(255,0,0);
    fill(255,0,0);
    circle(320,240,400);
    popStyle();
}

class smallCircle { 
  float ypos, xpos,ymax,ymin,xmax,xmin,speedx,speedy;
  boolean advance; 
  smallCircle (float x, float y,float spx,float spy,float xm,float ym) {  
    ypos = y; 
    speedx = spx;
    speedy= spy; 
    xpos = x;
    boolean advance=true;
    ymin=ym;
    ymax=ym+380;
    xmin=xm;
    xmax=xm+380;
  } 
  public void update() { 
    if (advance){
        ypos += speedy;
        xpos += speedx;
    }else{
        ypos -= speedy;
        xpos -= speedx;
    } 
    if (ypos >= ymax || xpos>=xmax) { 
      advance =false; 
    } 
    pushStyle();
    if (ypos<= ymin || xpos<=xmin){
        advance=true;
    }
    fill(0,255,0);
    circle(xpos, ypos, 20); 
    popStyle();
  } 
} 
  public void settings() {  size (640,480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "circle_ilusion" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
