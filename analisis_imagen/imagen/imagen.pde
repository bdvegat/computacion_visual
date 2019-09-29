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

void setup() {
  size(1292,630);
  //load image
  photo = loadImage("red-fox-4502730_640.jpg");
  //create pGraphics
  pgGray = createGraphics(photo.width,photo.height);
  pgHistogram = createGraphics(photo.width,photo.height);
  dimension=photo.width*photo.height;
  image(photo, 4, 4);
  buttons();
}

void draw() {
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

void mousePressed() {
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