void histogram(PGraphics image){
  int [] histograma = new int[256];
  image.loadPixels();
  //construir array del histograma
  for (int i=0;i<dimension;i++){
    color c=color(image.pixels[i]);
    brigth=int(brightness(c));
    histograma[brigth]+=1;
  }
  int histMax = max(histograma);
  //graficar histograma
  pgHistogram.beginDraw();
  pgHistogram.clear();
  pgHistogram.stroke (255);
  for (int i=0;i<width;i+=2){
    int x=int(map(i,0,width,0,255));
    int y=int(map(histograma[x],0,histMax,0,height));
    pgHistogram.line(i,height,i,height-y);
  }
  pgHistogram.endDraw();
  image(pgHistogram, 648, 4);
}