 
import processing.video.*;
Movie video;
PGraphics pgGray;
float[][] filter = {{-1,-1,-1},{2,2,2},{-1,-1,-1}}; 

void setup() {
  size(1292, 370);
  video = new Movie(this, "test.mp4");
  pgGray = createGraphics(640,360);
  video.loop();
}
void draw() {
  image(video,4,4);
  image(pgGray,646,4);
  println("frameRate: "+frameRate);
}
void movieEvent(Movie m) {
  m.read();
  pgGray.beginDraw();
  video.loadPixels();
  pgGray.loadPixels();
  for (int i=0;i<360;i++){
    for (int j=0;j<640;j++){
      pgGray.pixels[i*640+j]=convolution(filter,i,j);
    }
  }
  pgGray.updatePixels();
  pgGray.endDraw();
}
