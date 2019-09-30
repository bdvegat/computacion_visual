import processing.video.*;
Movie video;
PGraphics pgGray;

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
  int dimension=640*360;
  for (int i=0;i<dimension;i++){
    float r=red(video.pixels[i])*0.299;
    float g=green(video.pixels[i])*0.587;
    float b=blue(video.pixels[i])*0.114;
    pgGray.pixels[i]=color(r+g+b);
  }
  pgGray.updatePixels();
  pgGray.endDraw();
}
