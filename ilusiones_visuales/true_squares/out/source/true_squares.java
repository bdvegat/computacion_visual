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

public class true_squares extends PApplet {

public void setup(){
    
}
boolean show_circles=true;

public void draw(){
    background(255);
    if (show_circles){
        circles();
    }

    squares();
}

public void circles(){
    pushStyle();
    noFill();
    float rad=27.5f;
    int [] x = {115,335,555};
    int [] y = {115,335};
        for (int i=0;i<6;i++){
            for (int j=0;j<8;j++){
                circle(x[i%3],y[i%2],rad*(j+1));
            }
        }
    popStyle();
}

public void squares(){
    pushStyle();
    noFill();
    rectMode(CENTER);
    float extent=155.56f;
    int [] x = {115,335,555};
    int [] y = {115,335};
    for (int i=0;i<6;i++){
        pushMatrix();
        translate(x[i%3], y[i%2]);
        rotate(PI/4.0f);
        square(0,0,extent);
        popMatrix();
    }        
    popStyle();
}

public void mousePressed(){
    if (show_circles){
        show_circles=false;
    }else{
        show_circles=true;
    }
}
  public void settings() {  size (670,450); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "true_squares" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
