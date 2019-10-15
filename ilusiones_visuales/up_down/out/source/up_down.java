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

public class up_down extends PApplet {

public void setup(){
    
    frameRate(6);

}
boolean show_circles=true;

int k=0;
int j=0;
public void draw(){
    background(255);
    squares(k,j);
    k++;
    
    if (j==6){
        j=0;
    }
    if (k==5){
        k=0;
        j++;
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
public void squares(int k,int j){
    pushStyle();
    pushMatrix();
    translate(0,j*80);
    int [] pos = {40,200,360};
    for (int i=0;i<3;i++){
        pushMatrix();
        translate(pos[i],100);
        if (k%2==0){
            stroke(0);
            fill(0);
            square(10, 10, 30);
            fill(255);
            square(40, 10, 30);
            fill(0);
            square(70, 10, 30);
            
            stroke(0);
            fill(255);
            square(10, 50, 30);
            fill(0);
            square(40, 50, 30);
            fill(255);
            square(70, 50, 30);
                
            fill(0);
            square(10, 90, 30);
            fill(255);
            square(40, 90, 30);
            fill(0);
            square(70, 90, 30);
        }else {
            stroke(0);
            fill(255);
            square(10, 10, 30);
            fill(0);
            square(40, 10, 30);
            fill(255);
            square(70, 10, 30);

            fill(0);
            square(10, 50, 30);
            fill(255);
            square(40, 50, 30);
            fill(0);
            square(70, 50, 30);
            
            stroke(0);
            fill(255);
            square(10, 90, 30);
            fill(0);
            square(40, 90, 30);
            fill(255);
            square(70, 90, 30);    
        }
        popMatrix();
    }
    popMatrix();
    popStyle();
}
  public void settings() {  size (640,640); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "up_down" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
