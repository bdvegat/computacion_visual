void rgb(){  
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