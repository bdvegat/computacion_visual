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

public class MunkerWhite extends PApplet {

PGraphics left;
PGraphics rigth;

public void setup(){
    
    left=createGraphics(320,480);
    rigth=createGraphics(320,480);
}
boolean show_background=true;

public void draw(){
    left();
    rigth();
    image(left,0,0);
    image(rigth,320,0);
}

public void left(){
    if (show_background){
        blueLines(left);
        redCircle(left);
        yellowLines(left);
    }else{
        left.beginDraw();
        left.background(255);
        left.endDraw();
        redCircle(left);
    }
}

public void rigth(){
    if (show_background){
        yellowLines(rigth);
        redCircle(rigth);
        blueLines(rigth);
    }else{
        rigth.beginDraw();
        rigth.background(255);
        rigth.endDraw();
        redCircle(rigth);
    }
}

public void blueLines(PGraphics pg){
    pushStyle();
    pg.beginDraw();
    int wide = 320;
    pg.stroke(0,0,204);
    int j=0;
    for (int i=0;i<wide;i+=1){
        j+=1;
        if(j>9){
            pg.line(i,0,i,480);
        }
        if (j==19) {
            j=0;
        }
    }
    pg.endDraw();
    popStyle();
}

public void yellowLines(PGraphics pg){
    pushStyle();
    pg.beginDraw();
    int wide = 320;
    pg.stroke(255,255,51);
    int j=0;
    for (int i=0;i<wide;i+=1){
        j+=1;
        if(j<10){
            pg.line(i,0,i,480);
        }else if (j==19) {
            j=0;
        }
    }
    pg.endDraw();
    popStyle();
}

public void mousePressed(){
    if (show_background){
        show_background=false;
    }else{
        show_background=true;
    }
}

public void redCircle(PGraphics pg){
    pushStyle();
    pg.beginDraw();
    pg.stroke(255,0,0);
    pg.fill(255,0,0);
    pg.circle(160,240,200);
    pg.endDraw();
    popStyle();
}
  public void settings() {  size (640,480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "MunkerWhite" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
