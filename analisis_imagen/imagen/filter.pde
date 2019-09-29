void filter(float[][] filter){
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