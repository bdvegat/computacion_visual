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

public class lilac_chaser extends PApplet {

public void setup(){
    
    frameRate(10);

}
boolean show_circles=true;

int k=0;
public void draw(){
    background(255);
    circles(k);
    k++;
    if (k==12){
        k=0;
    }
}

public void circles(int k){
    pushStyle();
    line(310,320,330,320);
    line(320,310,320,330);
    fill(255,102,178);
    float rad=60;
    float [] deg ={0,30,60,90,120,150,180,210,240,270,300,330};
    float current;
    translate(320, 320);
        for (int i=0;i<12;i++){
            pushMatrix();
            current=deg[i];
            rotate(radians(current));
            println("current: "+current);
            if (i!=k){
                circle(0,150,rad);
            }
            popMatrix();
        }
    popStyle();
}

  public void settings() {  size (640,640); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "lilac_chaser" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
