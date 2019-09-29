void luma(){
  pgGray.beginDraw();
  pgGray.clear();
  pgGray.loadPixels();
  dimension=photo.width*photo.height;
  for (int i=0;i<dimension;i++){
    float r=red(photo.pixels[i])*0.299;
    float g=green(photo.pixels[i])*0.587;
    float b=blue(photo.pixels[i])*0.114;
    pgGray.pixels[i]=color(r+g+b);
  }
  pgGray.updatePixels();
  pgGray.endDraw();
  image(pgGray, 648, 4);
}