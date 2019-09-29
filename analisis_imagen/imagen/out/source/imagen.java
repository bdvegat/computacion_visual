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

public class imagen extends PApplet {

PGraphics pgGray;
PGraphics pgHistogram;
PImage photo;
int co=0;
int dimension;
int brigth;

float[][] identity = { { 0, 0, 0 },{ 0,  1, 0 },{ 0, 0, 0} }; 
float[][] sharpen = { { 0, -1, 0 },{ -1,  5, -1 },{ 0, -1, 0 } }; 
float[][] edge = { { -1, -1, -1 },{ -1, 8, -1 },{ -1, -1, -1 } }; 
float[][] horizontalEdges = {{-1,-1,-1},{2,2,2},{-1,-1,-1}};
float[][] north={{-1,-2,-1},{0,0,0},{1,2,1}};

public void setup() {
  
  //load image
  photo = loadImage("red-fox-4502730_640.jpg");
  //create pGraphics
  pgGray = createGraphics(photo.width,photo.height);
  pgHistogram = createGraphics(photo.width,photo.height);
  dimension=photo.width*photo.height;
  image(photo, 4, 4);
  buttons();
}

public void draw() {
/*     if (co==0){
        rgb();
        histogram(pgGray);
        println("rgb");
        co=1;
    }else{  
        luma();
        histogram(pgGray);
        println("luma");
        co=0;
    } */
    //filter(edge);
    //rgb();
    //histogram(pgGray);
} 

public void mousePressed() {
  if(mouseX>rgbX && mouseX <rgbX+150 && mouseY>rgbY && mouseY <rgbY+60){
   rgb();
  }
  if(mouseX>lumaX && mouseX <lumaX+150 && mouseY>lumaY && mouseY <lumaY+60){
   luma();
  }
  if(mouseX>histogramaX && mouseX <histogramaX+180 && mouseY>histogramaY && mouseY <histogramaY+60){
    try {
      histogram(pgGray);
    } catch (Exception e) {
      rgb();
      histogram(pgGray);
    } 
  }
  if(mouseX>identityX && mouseX <identityX+180 && mouseY>identityY && mouseY <identityY+60){
   filter(identity);
  }
  if(mouseX>sharpenX && mouseX <sharpenX+180 && mouseY>sharpenY && mouseY <sharpenY+60){
   filter(sharpen);
  }
  if(mouseX>edgeX && mouseX <edgeX+180 && mouseY>edgeY && mouseY <edgeY+60){
   filter(edge);
  }
  if(mouseX>northX && mouseX <northX+180 && mouseY>northY && mouseY <northY+60){
   filter(north);
  }
}
int rgbX=25;
int rgbY=480;
int lumaX=200;
int lumaY=480;
int histogramaX=375;
int histogramaY=480;
int identityX=580;
int identityY=480;
int sharpenX=760;
int sharpenY=480;
int edgeX=940;
int edgeY=480;
int northX=1120;
int northY=480;


public void buttons(){
  pushStyle();

  rect(rgbX,rgbY,150,60);
  textSize(26);
  fill(0, 102, 153);
  text("rbg", rgbX+10,rgbY+32);

  fill(255);

  rect(lumaX,lumaY,150,60);
  textSize(26);
  fill(0, 102, 153);
  text("luma", lumaX+10,lumaY+32);

  fill(255);
  rect(histogramaX,histogramaY,180,60);
  textSize(26);
  fill(0, 102, 153);
  text("histograma", histogramaX+8,histogramaY+32);

  fill(0, 102, 153);   
  rect(identityX,identityY,150,60);
  textSize(26);
  fill(255); 
  text("identity", identityX+8,identityY+32);

  fill(0, 102, 153);   
  rect(sharpenX,sharpenY,150,60);
  textSize(26);
  fill(255); 
  text("sharpen", sharpenX+8,sharpenY+32);

  fill(0, 102, 153);   
  rect(edgeX,edgeY,150,60);
  textSize(26);
  fill(255); 
  text("edge", edgeX+8,edgeY+32);

  fill(0, 102, 153);   
  rect(northX,northY,150,60);
  textSize(26);
  fill(255); 
  text("north", northX+8,northY+32);

  popStyle();
}
public int convolution (float[][]kernel,int x,int y){
  int kLength=kernel.length;
  float r=0;
  float g=0;
  float b=0;
  for(int i=0;i<kLength;i++){
    for (int j=0;j<kLength;j++){
      int row=x-PApplet.parseInt(kLength/2)+i;
      int column=y-PApplet.parseInt(kLength/2)+j;
      int pos=row*photo.width+column;
      if (row>=0 && column>=0 && row<photo.height && column<photo.width){
        r+=PApplet.parseInt(kernel[kLength-i-1][kLength-j-1])*red(photo.pixels[pos]);
        g+=PApplet.parseInt(kernel[kLength-i-1][kLength-j-1])*green(photo.pixels[pos]);
        b+=PApplet.parseInt(kernel[kLength-i-1][kLength-j-1])*blue(photo.pixels[pos]);
        }else{
        continue;
      }
    }
  }
  r=constrain(r,0,255);
  g=constrain(g,0,255);
  b=constrain(b,0,255);
  return color(r,g,b);
}
public void filter(float[][] filter){
  pgGray.beginDraw();
  pgGray.loadPixels();
  for (int i=0;i<photo.height;i++){
    for (int j=0;j<photo.width;j++){
      pgGray.pixels[i*photo.width+j]=convolution(filter,i,j);
    }
  }
  pgGray.updatePixels();
  pgGray.endDraw();
  image(pgGray, 648, 4);
}
public void histogram(PGraphics image){
  int [] histograma = new int[256];
  image.loadPixels();
  //construir array del histograma
  for (int i=0;i<dimension;i++){
    int c=color(image.pixels[i]);
    brigth=PApplet.parseInt(brightness(c));
    histograma[brigth]+=1;
  }
  int histMax = max(histograma);
  //graficar histograma
  pgHistogram.beginDraw();
  pgHistogram.clear();
  pgHistogram.stroke (255);
  for (int i=0;i<width;i+=2){
    int x=PApplet.parseInt(map(i,0,width,0,255));
    int y=PApplet.parseInt(map(histograma[x],0,histMax,0,height));
    pgHistogram.line(i,height,i,height-y);
  }
  pgHistogram.endDraw();
  image(pgHistogram, 648, 4);
}
public void luma(){
  pgGray.beginDraw();
  pgGray.clear();
  pgGray.loadPixels();
  dimension=photo.width*photo.height;
  for (int i=0;i<dimension;i++){
    float r=red(photo.pixels[i])*0.299f;
    float g=green(photo.pixels[i])*0.587f;
    float b=blue(photo.pixels[i])*0.114f;
    pgGray.pixels[i]=color(r+g+b);
  }
  pgGray.updatePixels();
  pgGray.endDraw();
  image(pgGray, 648, 4);
}
public void rgb(){  
  pgGray.beginDraw();
  pgGray.clear();
  pgGray.loadPixels();
  dimension=photo.width*photo.height;
  for (int i=0;i<dimension;i++){
    float r=red(photo.pixels[i])/3;
    float g=green(photo.pixels[i])/3;
    float b=blue(photo.pixels[i])/3;
    pgGray.pixels[i]=color(r+g+b);
  }                         
  pgGray.updatePixels();    
  pgGray.endDraw();                     
  image(pgGray, 648, 4);                    
}  
  public void settings() {  size(1292,630); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "imagen" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
